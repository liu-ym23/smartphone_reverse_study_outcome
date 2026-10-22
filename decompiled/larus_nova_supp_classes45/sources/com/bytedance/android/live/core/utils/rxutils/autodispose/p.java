package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p<T> extends Single<T> {
    public final SingleSource<T> a;
    public final CompletableSource b;

    public final void subscribeActual(SingleObserver<? super T> r4) {
        this.a.subscribe(new t(this.b, r4));
    }

    public p(Single r1, CompletableSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
