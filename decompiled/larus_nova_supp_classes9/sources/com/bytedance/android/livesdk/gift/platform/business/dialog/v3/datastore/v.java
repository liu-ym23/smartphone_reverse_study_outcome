package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v {
    public static final oc6.e a(ExchangeInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toRpc");
        oc6.e r0 = new oc6.e();
        r0.b(r2.getHideCashExchange());
        r0.c(r2.getHideCombineExchange());
        int r3 = com.bytedance.android.live.recharge.util.d.a;
        r0.a(com.bytedance.android.live.recharge.util.d.b(s1.getContext()));
        return r0;
    }
}
