package com.bytedance.awemeopen.servicesapi.ui;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d {
    void a(AoAnimConfig.b r1);

    void b();

    void c(String r1);

    void cancelAnimation();

    void d(Drawable.Callback r1);

    void e();

    void f(int r1, int r2);

    void g(int r1);

    LottieDrawable getDrawable();

    float getScale();

    void h(a r1);

    boolean isRunning();

    void setFrame(int r1);

    void setRepeatCount(int r1);

    void setScale(float r1);

    void start();

    void stop();
}
