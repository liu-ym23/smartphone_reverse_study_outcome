package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.model.DisplayRatio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {
    void a(int r1);

    void b(int r1);

    void c(int r1);

    int d();

    boolean e();

    void f(int r1);

    int getBottom();

    DisplayRatio getDisplayRatio();

    int getHeight();

    int getLeft();

    int getRight();

    int getScaleType();

    float getScaleX();

    float getScaleY();

    int getTop();

    float getTranslationX();

    float getTranslationY();

    int getWidth();

    void requestLayout(String r1);

    void setDisplayRatio(DisplayRatio r1);

    void setGravity(int r1);

    void setHeight(int r1);

    void setScaleType(int r1);

    void setScaleX(float r1);

    void setScaleY(float r1);

    void setTranslationX(float r1);

    void setTranslationY(float r1);

    void setWidth(int r1);
}
