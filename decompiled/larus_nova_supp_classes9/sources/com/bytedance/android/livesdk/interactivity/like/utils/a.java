package com.bytedance.android.livesdk.interactivity.like.utils;

import android.animation.TimeInterpolator;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final ClosedFloatingPointRange<Float> a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public final float a(float r3, TimeInterpolator r4) {
        float r0 = this.d;
        float r5 = (r3 - r0) / (this.e - r0);
        if (r4 == null) goto L5;
        r4.getInterpolation(r5);
    L5:
        float r6 = this.b;
        return r6 + ((this.c - r6) * r5);
    }

    public a(float r1, float r2, float r3, float r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = RangesKt.rangeTo(r3, r4);
    }
}
