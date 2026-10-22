package com.lynx.canvas;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface KryptonSurfaceView {
    float getDensity();

    int getHeight();

    android.view.SurfaceHolder getHolder();

    int getWidth();

    void setOnTouchListener(View.OnTouchListener r1);
}
