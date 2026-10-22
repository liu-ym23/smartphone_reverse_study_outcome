package com.obric.oui.popover;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14128a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r10) {
        if (r10 != 0.0f) goto L6;
        return r10;
    L6:
        if (r10 == 1.0f) goto L11;
        double r5 = Math.pow(2.0d, (-10) * r10);
        float r11 = this.f14128a;
        return (float) ((Math.sin(((((double) r10) - (((double) r11) / 4.0d)) * 6.283185307179586d) / ((double) r11)) * r5) + ((double) 1));
    L11:
        return r10;
    }
}
