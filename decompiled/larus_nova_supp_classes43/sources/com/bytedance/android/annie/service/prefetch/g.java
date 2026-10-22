package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        this.a.k();
        d r0 = this.a;
        r0.finishWithFailure((Throwable) r10);
    }
}
