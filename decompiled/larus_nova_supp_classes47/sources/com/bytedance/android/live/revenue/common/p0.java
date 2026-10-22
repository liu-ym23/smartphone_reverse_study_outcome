package com.bytedance.android.live.revenue.common;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 {
    public static void a(long r2, boolean r4, boolean r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r5 = false;
    L11:
        Intrinsics.checkNotNullParameter(r6, "action");
        com.bytedance.live.kmp.util.d.a(r2, r4, r5, r6);
    }
}
