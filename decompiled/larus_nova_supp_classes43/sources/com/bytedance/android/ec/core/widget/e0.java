package com.bytedance.android.ec.core.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 extends ViewOutlineProvider {
    public final float a;
    public final int b;
    public final int c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        r11.setRoundRect(new Rect(0, 0, this.b, this.c), this.a);
    }

    public e0(float r1, int r10, int r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
