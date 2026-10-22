package com.bytedance.android.livesdk.focus;

import android.animation.TimeInterpolator;
import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements TimeInterpolator {
    public int a;
    public final PointF b;
    public final PointF c;

    public static double a(double r12, double r14, double r16) {
        double r0 = ((double) 1) - r12;
        double r2 = r12 * r12;
        double r4 = r0 * r0;
        double r10 = 3;
        return ((((r4 * r0) * 0.0d) + (((r4 * r10) * r12) * r14)) + (((r10 * r0) * r2) * r16)) + ((r2 * r12) * 1.0d);
    }

    public a() {
        this.b = new PointF(0.75f, 0.0f);
        this.c = new PointF(0.65f, 1.0f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r10) {
        double r0 = r10;
        if (r0 <= 0.2d) goto L5;
        float r1 = 1.0f;
    L6:
        int r2 = this.a;
        float r3 = r1;
    L8:
        if (r2 >= 4096) goto L13;
        r3 = (r2 * 1.0f) / 4096;
        if (a(r3, this.b.x, this.c.x) >= r1) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        this.a = r2;
    L13:
        double r4 = a(r3, this.b.y, this.c.y);
        if (r4 <= 0.999d) goto L17;
        this.a = 0;
        r4 = 1.0d;
    L17:
        return (float) r4;
    L5:
        r1 = (float) (r0 / 0.2d);
        goto L6
    }
}
