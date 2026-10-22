package com.bytedance.android.live.recharge.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r3) {
        jy0.b.b("RechargeEventHandlerService", "on subscribe error", (Throwable) r3);
    }
}
