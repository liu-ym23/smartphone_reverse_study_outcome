package com.bytedance.android.live.ktv.common.midi;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements TypeEvaluator<PointF> {
    public final PointF a;

    public a(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "controlPoint");
        this.a = r2;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r7, PointF r8, PointF r9) {
        PointF r11 = r8;
        PointF r12 = r9;
        Intrinsics.checkNotNullParameter(r11, "startValue");
        Intrinsics.checkNotNullParameter(r12, "endValue");
        PointF r0 = this.a;
        PointF r1 = new PointF();
        float r2 = 1 - r7;
        float r3 = r2 * r2;
        float r5 = (2 * r7) * r2;
        float r13 = r7 * r7;
        r1.x = ((r11.x * r3) + (r0.x * r5)) + (r12.x * r13);
        r1.y = ((r3 * r11.y) + (r5 * r0.y)) + (r13 * r12.y);
        return r1;
    }
}
