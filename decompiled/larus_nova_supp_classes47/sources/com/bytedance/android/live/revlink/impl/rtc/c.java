package com.bytedance.android.live.revlink.impl.rtc;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final RectF a(RectF r4, RectF r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$transformByCropFromCanvasGrid");
        RectF r0 = new RectF(r4);
        if (r5 != null) goto L5;
        return r0;
    L5:
        float r6 = r5.left;
        float r1 = r5.top;
        float r2 = r5.width();
        float r7 = r5.height();
        Matrix r3 = new Matrix();
        r3.postScale(r2, r7);
        r3.postTranslate(r6, r1);
        Intrinsics.checkNotNullParameter(r3, "matrix");
        Matrix r8 = new Matrix();
        r3.invert(r8);
        r8.mapRect(r0);
        return r0;
    }
}
