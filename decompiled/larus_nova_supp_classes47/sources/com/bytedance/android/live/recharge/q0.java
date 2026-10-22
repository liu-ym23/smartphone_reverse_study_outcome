package com.bytedance.android.live.recharge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 {
    public final String a;

    public q0(String r3, int r4) {
        String r1 = "";
        if ((r4 & 4) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r4 & 16) != 0) goto L10;
        r1 = null;
    L10:
        Intrinsics.checkNotNullParameter(r3, "chargeReason");
        Intrinsics.checkNotNullParameter(r0, "chargeScene");
        Intrinsics.checkNotNullParameter(r1, "showType");
        this.a = r3;
        return;
    L5:
        r0 = "gift_recharge";
        goto L7
    }
}
