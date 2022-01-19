package com.swu.zzm.java8;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;

/**
 * 属性动画 真正改变了属性的值
 * 1.系统属性：alpha scaleX scaleY translationX translationY rotationX rotationY
 * 2.自定义属性：这个属性必须实现set get方法
 * Administrator
 */

public class MainActivity extends AppCompatActivity {

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = findViewById(R.id.v);
    }

    // 透明度
    public void test1(){
        /**
         * 1.target 需要动画控件
         * 2.propertyName 控件的哪个属性
         * 3....values 变化的值 start..end
         */
        ObjectAnimator alphaAni = ObjectAnimator.ofFloat(v,"alpha",1,0,1);
        alphaAni.setDuration(1000);
        alphaAni.start();
    }

    /**
     *  旋转
     */
    public void test2(){
        ObjectAnimator rotationAni = ObjectAnimator.ofFloat(v,"rotation",0,360);
        rotationAni.setDuration(1000);
        rotationAni.start();
    }

    public void test3(){
        ObjectAnimator scaleAni = ObjectAnimator.ofFloat(v,"scaleX",1,3,1,3,1);
        scaleAni.setDuration(1000);
        scaleAni.setRepeatCount(-1);
        scaleAni.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator scaleAni2 = ObjectAnimator.ofFloat(v,"scaleY",
                1,1.1f,1,1.1f,1);
        scaleAni2.setDuration(1000);
        scaleAni2.setRepeatCount(-1);
        scaleAni2.setRepeatMode(ValueAnimator.REVERSE);

        // with 同时执行
        // after 后面执行
        // before 前面执行

        // playTogether
        // playSequentially 顺序执行
        AnimatorSet aSet = new AnimatorSet();
        aSet.play(scaleAni).with(scaleAni2);
        aSet.start();
    }

    /**
     * 移动
     *@return
     */
    public void test4(){
        ObjectAnimator transAni = ObjectAnimator.ofFloat(v,"translationX",
                v.getTranslationX()+100);
        transAni.setDuration(1000);
        transAni.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // test1();
            // test2();
            // test3();
            test4();
        }
        return true;
    }
}