package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ e a;

    public h(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        e r0 = this.a;
        r0.finishWithFailure((Throwable) r2);
    }
}
