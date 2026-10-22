package com.bytedance.android.live.profit.scoreboard;

import android.graphics.Rect;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o1 {
    public static final String a(Pair<? extends RegionId, j80.d> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$formatEventTrackerParam");
        return ((RegionId) r4.getFirst()).getId() + '-' + j80.a.a(((j80.d) r4.getSecond()).a().floatValue(), 3) + '-' + j80.a.a(((j80.d) r4.getSecond()).b().floatValue(), 3);
    }

    public static final void b(View r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r6, "rect");
        int r0 = MathKt.roundToInt(r5.getTranslationX());
        int r1 = MathKt.roundToInt(r5.getTranslationY());
        r6.set(r5.getLeft() + r0, r5.getTop() + r1, r5.getRight() + r0, r5.getBottom() + r1);
    }
}
