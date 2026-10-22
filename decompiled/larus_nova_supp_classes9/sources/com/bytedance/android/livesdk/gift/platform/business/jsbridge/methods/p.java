package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ q a;

    public p(q r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        q r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
