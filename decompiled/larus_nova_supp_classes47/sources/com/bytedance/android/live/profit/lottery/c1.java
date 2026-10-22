package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c1 {
    public static final boolean a(t r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isLifeLottery");
        c r2 = r1.k;
        if (r2 == null) goto L7;
        b r3 = r2.a();
        if (r3 == null) goto L7;
        Boolean r4 = r3.a();
    L9:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L7:
        r4 = null;
        goto L9
    }
}
