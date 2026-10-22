package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> extends Maybe<T> {
    public final MaybeSource<T> a;
    public final CompletableSource b;

    public final void subscribeActual(io.reactivex.k<? super T> r4) {
        this.a.subscribe(new s(this.b, r4));
    }

    public n(Maybe r1, CompletableSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
