package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j5<T> implements Consumer {
    public final /* synthetic */ h5 a;

    public j5(h5 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        this.a.finishWithFailure();
    }
}
