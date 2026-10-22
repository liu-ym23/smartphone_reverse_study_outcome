package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final Pair<Integer, Integer> a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getPositionOnScreen");
        int[] r0 = new int[2];
        r2.getLocationOnScreen(r0);
        return TuplesKt.to(Integer.valueOf(r0[0]), Integer.valueOf(r0[1]));
    }
}
