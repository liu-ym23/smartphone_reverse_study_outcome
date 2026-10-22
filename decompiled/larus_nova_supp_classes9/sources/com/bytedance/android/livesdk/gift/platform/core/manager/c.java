package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r1) {
        kq2.a r2 = (kq2.a) r1;
        GiftEffectManager.e = true;
    }
}
