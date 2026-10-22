package com.bytedance.android.live.incentive.balance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final UpdateReason a;

    public e(UpdateReason r3) {
        RequestFrom r0 = RequestFrom.ExchangePanel;
        Intrinsics.checkNotNullParameter(r3, "updateReason");
        Intrinsics.checkNotNullParameter(r0, "requestFrom");
        this.a = r3;
    }
}
