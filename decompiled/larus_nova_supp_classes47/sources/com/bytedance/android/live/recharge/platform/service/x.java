package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements DealSetApiDataSource.b {
    public static final x a = null;

    public x() {
    }

    static {
        a = new x();
    }

    @Override // com.bytedance.android.live.recharge.deal.DealSetApiDataSource.b
    public final void a(com.bytedance.android.live.recharge.deal.m r3) {
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == false) goto L5;
        int r0 = 212;
    L6:
        Map<String, String> r4 = r3.a;
        HashMap r5 = (HashMap) r4;
        r5.put("type", String.valueOf(r0));
        return;
    L5:
        r0 = 1;
        goto L6
    }
}
