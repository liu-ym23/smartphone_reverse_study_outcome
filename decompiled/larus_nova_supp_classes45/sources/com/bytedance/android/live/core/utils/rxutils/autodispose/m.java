package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> extends Flowable<T> {
    public final Publisher<T> a;
    public final CompletableSource b;

    public final void subscribeActual(wwc.b<? super T> r4) {
        this.a.subscribe(new AutoDisposingSubscriberImpl(this.b, r4));
    }

    public m(Flowable r1, CompletableSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
