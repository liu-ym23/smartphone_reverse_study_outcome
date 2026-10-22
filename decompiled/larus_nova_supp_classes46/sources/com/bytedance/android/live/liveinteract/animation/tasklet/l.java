package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements TypeEvaluator<PointF> {
    public l() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r4, PointF r5, PointF r6) {
        PointF r7 = r5;
        PointF r8 = r6;
        Intrinsics.checkNotNullParameter(r7, "startValue");
        Intrinsics.checkNotNullParameter(r8, "endValue");
        PointF r0 = new PointF();
        float r1 = r7.x;
        r0.x = r1 + ((r8.x - r1) * r4);
        float r9 = r7.y;
        r0.y = r9 + ((r8.y - r9) * r4);
        return r0;
    }
}
