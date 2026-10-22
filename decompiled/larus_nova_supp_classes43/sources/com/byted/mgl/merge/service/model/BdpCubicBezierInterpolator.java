package com.byted.mgl.merge.service.model;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpCubicBezierInterpolator implements Interpolator {
    private final float mX1;
    private final float mX2;
    private final float mY1;
    private final float mY2;

    private float linearInterpolate(float r1, float r10, float r11) {
        return r1 + ((r10 - r1) * r11);
    }

    private float getTForXValue(float r19) {
        float r1 = 0.0f;
        if (r19 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r19 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r10 = 0;
        float r11 = r19;
        float r12 = 0.0f;
        float r13 = 1.0f;
        int r14 = 0;
    L10:
        if (r14 >= 8) goto L23;
        r12 = getX(r11);
        double r15 = (getX(r11 + 1.0E-4f) - r12) / 1.0E-4f;
        float r16 = r12 - r19;
        if (Math.abs(r16) < 1.0E-4f) goto L13;
        if (Math.abs(r15) < 9.999999747378752E-5d) goto L23;
        if (r12 >= r19) goto L20;
        r1 = r11;
    L21:
        r11 = (float) (((double) r11) - (((double) r16) / r15));
        r14 = r14 + 1;
        goto L10
    L20:
        r13 = r11;
        goto L21
    L13:
        return r11;
    L23:
        if (Math.abs(r12 - r19) <= 1.0E-4f) goto L30;
        if (r10 >= 8) goto L30;
        if (r12 >= r19) goto L28;
        float r17 = r11;
        r11 = (r11 + r13) / 2.0f;
        r1 = r17;
    L29:
        r12 = getX(r11);
        r10 = r10 + 1;
        goto L23
    L28:
        r13 = r11;
        r11 = (r11 + r1) / 2.0f;
    L30:
        return r11;
    }

    private float getX(float r10) {
        return getCoordinate(r10, this.mX1, this.mX2);
    }

    private float getY(float r10) {
        return getCoordinate(r10, this.mY1, this.mY2);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return getY(getTForXValue(r1));
    }

    private float getCoordinate(float r10, float r11, float r12) {
        if (r10 != 0.0f) goto L5;
        return r10;
    L5:
        if (r10 == 1.0f) goto L10;
        float r0 = linearInterpolate(0.0f, r11, r10);
        float r13 = linearInterpolate(r11, r12, r10);
        float r14 = linearInterpolate(r12, 1.0f, r10);
        return linearInterpolate(linearInterpolate(r0, r13, r10), linearInterpolate(r13, r14, r10), r10);
    L10:
        return r10;
    }

    public BdpCubicBezierInterpolator(float r1, float r10, float r11, float r12) {
        this.mX1 = r1;
        this.mY1 = r10;
        this.mX2 = r11;
        this.mY2 = r12;
    }

    public BdpCubicBezierInterpolator(double r1, double r10, double r11, double r12) {
        this((float) r1, (float) r10, (float) r11, (float) r12);
    }
}
