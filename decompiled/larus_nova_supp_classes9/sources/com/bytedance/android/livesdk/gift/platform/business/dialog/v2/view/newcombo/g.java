package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements TypeEvaluator<PointF> {
    public final PointF a;
    public final PointF b;

    public g(PointF r2, PointF r3) {
        Intrinsics.checkNotNullParameter(r2, "controlPoint1");
        Intrinsics.checkNotNullParameter(r3, "controlPoint2");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r9, PointF r10, PointF r11) {
        PointF r13 = r10;
        PointF r14 = r11;
        Intrinsics.checkNotNullParameter(r13, "startValue");
        Intrinsics.checkNotNullParameter(r14, "endValue");
        PointF r0 = new PointF();
        float r1 = 1 - r9;
        float r2 = (r1 * r1) * r1;
        float r3 = r13.x * r2;
        float r4 = 3 * r9;
        float r5 = (r4 * r1) * r1;
        PointF r6 = this.a;
        float r7 = r3 + (r6.x * r5);
        float r8 = (r4 * r9) * r1;
        PointF r15 = this.b;
        float r16 = (r9 * r9) * r9;
        r0.x = (r7 + (r15.x * r8)) + (r14.x * r16);
        r0.y = (((r2 * r13.y) + (r5 * r6.y)) + (r8 * r15.y)) + (r16 * r14.y);
        return r0;
    }
}
