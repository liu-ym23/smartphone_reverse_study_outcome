package com.bytedance.android.live.revenue.common.player.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdk.model.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final RectF a(RectF r4, n0 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$transformByCrop");
        RectF r0 = new RectF(r4);
        if (r5 != null) goto L5;
        return r0;
    L5:
        float r6 = r5.c() / r5.f();
        float r1 = r5.d() / r5.e();
        float r2 = r5.b() / r5.f();
        float r3 = r5.a() / r5.e();
        Matrix r7 = new Matrix();
        r7.postScale(r2, r3);
        r7.postTranslate(r6, r1);
        r7.mapRect(r0);
        return r0;
    }
}
