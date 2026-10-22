package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ LRUCleanStrategy a;

    public q(LRUCleanStrategy r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        t r3 = this.a.k;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }
}
