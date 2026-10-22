package com.bytedance.map.api.animation;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class EaseCubicInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f6875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f6876c;
    public final boolean d;

    public EaseCubicInterpolator(float r5, float r10, float r11, float r12, boolean r13) {
        this.f6874a = 0;
        PointF r14 = new PointF();
        this.f6875b = r14;
        PointF r15 = new PointF();
        this.f6876c = r15;
        r14.x = r5;
        r14.y = r10;
        r15.x = r11;
        r15.y = r12;
        this.d = r13;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r27) {
        int r5 = this.f6874a;
        float r10 = r27;
    L3:
        double r11 = 1.0d;
        if (r5 >= 4096) goto L9;
        r10 = (r5 * 1.0f) / 4096.0f;
        double r12 = r10;
        double r13 = this.f6875b.x;
        double r16 = 1.0d - r12;
        double r18 = r12 * r12;
        double r20 = r16 * r16;
        double r22 = (r20 * r16) * 0.0d;
        if ((((r18 * r12) * 1.0d) + ((((r16 * 3.0d) * r18) * ((double) this.f6876c.x)) + ((((r20 * 3.0d) * r12) * r13) + r22))) >= r27) goto L7;
        r5 = r5 + 1;
        goto L3
    L7:
        this.f6874a = r5;
    L9:
        double r14 = r10;
        double r15 = this.f6875b.y;
        double r17 = 1.0d - r14;
        double r19 = r14 * r14;
        double r110 = r17 * r17;
        double r21 = (r110 * r17) * 0.0d;
        double r23 = (r19 * r14) * 1.0d;
        double r24 = r23 + ((((r17 * 3.0d) * r19) * ((double) this.f6876c.y)) + ((((r110 * 3.0d) * r14) * r15) + r21));
        if (this.d == false) goto L12;
    L14:
        r11 = r24;
    L16:
        return (float) r11;
    L12:
        if (r24 <= 0.999d) goto L14;
        this.f6874a = 0;
        goto L16
    }
}
