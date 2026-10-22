package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ k.b a;

    public n(k.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        k.b r0 = this.a;
        r0.onFailed((Throwable) r2);
    }
}
