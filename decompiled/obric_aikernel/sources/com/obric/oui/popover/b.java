package com.obric.oui.popover;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7145a;

    public b(float r10) {
        this.f7145a = 0.5f;
        this.f7145a = r10;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 != 0.0f) goto L5;
        return r10;
    L5:
        if (r10 == 1.0f) goto L10;
        double r11 = Math.pow(2.0d, (-10) * r10);
        float r12 = this.f7145a;
        return (float) ((r11 * Math.sin(((((double) r10) - (((double) r12) / 4.0d)) * 6.283185307179586d) / ((double) r12))) + ((double) 1));
    L10:
        return r10;
    }
}
