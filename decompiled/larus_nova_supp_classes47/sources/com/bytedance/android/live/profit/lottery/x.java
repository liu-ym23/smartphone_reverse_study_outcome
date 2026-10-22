package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends com.bytedance.android.live.core.utils.rxutils.l.a {
    public x() {
    }

    public final boolean a(Throwable r4, int r5) {
        v.c r0 = v.a;
        if (r4 != null) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        return true;
    L15:
        return super.a(r4, r5);
    L5:
        if (com.bytedance.android.live.revenue.common.r0.a(r4) != 10001) goto L7;
    L10:
        r1 = true;
        goto L12
    L7:
        if (com.bytedance.android.live.revenue.common.r0.a(r4) == 10002) goto L10;
        if (Intrinsics.areEqual(com.bytedance.android.live.revenue.common.q0.a(r4), "unknown") == false) goto L11;
        goto L10
    }
}
