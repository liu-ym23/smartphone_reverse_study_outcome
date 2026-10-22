package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0<T> implements Consumer {
    public static final o0 a = null;

    static {
        a = new o0();
    }

    public o0() {
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "preload pre pay cashier info error", (Throwable) r3);
    }
}
