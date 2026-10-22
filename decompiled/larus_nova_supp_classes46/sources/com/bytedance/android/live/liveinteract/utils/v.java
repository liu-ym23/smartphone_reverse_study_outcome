package com.bytedance.android.live.liveinteract.utils;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public static final boolean a(EPointF r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isZeroPoint");
        if (((PointF) r2).x == 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (((PointF) r2).y != 0.0f) goto L7;
        return true;
    }

    public static final EPointF b(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toEPoint");
        return new EPointF(r2.x, r2.y);
    }
}
