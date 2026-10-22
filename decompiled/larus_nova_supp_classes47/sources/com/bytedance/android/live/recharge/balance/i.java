package com.bytedance.android.live.recharge.balance;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T, R> implements Function {
    public i() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.data;
        if (r4 == null) goto L7;
        return (com.bytedance.android.live.recharge.l) r4;
    L7:
        throw new IllegalStateException("/webcast/wallet/info/ returned null data".toString());
    }
}
