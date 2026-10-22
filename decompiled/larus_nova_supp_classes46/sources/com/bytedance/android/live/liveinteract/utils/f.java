package com.bytedance.android.live.liveinteract.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements TypeEvaluator<PointF> {
    public final PointF a;

    public f(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "controlPoint");
        this.a = r2;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r7, PointF r8, PointF r9) {
        PointF r10 = r8;
        PointF r11 = r9;
        Intrinsics.checkNotNullParameter(r10, "startValue");
        Intrinsics.checkNotNullParameter(r11, "endValue");
        PointF r0 = this.a;
        PointF r1 = new PointF();
        float r2 = 1 - r7;
        float r3 = r2 * r2;
        float r5 = (2 * r7) * r2;
        float r12 = r7 * r7;
        r1.x = ((r10.x * r3) + (r0.x * r5)) + (r11.x * r12);
        r1.y = ((r3 * r10.y) + (r5 * r0.y)) + (r12 * r11.y);
        return r1;
    }
}
