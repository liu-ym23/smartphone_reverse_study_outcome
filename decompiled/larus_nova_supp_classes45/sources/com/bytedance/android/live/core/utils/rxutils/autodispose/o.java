package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o<T> extends Observable<T> {
    public final ObservableSource<T> a;
    public final CompletableSource b;

    public final void subscribeActual(Observer<? super T> r4) {
        this.a.subscribe(new AutoDisposingObserverImpl(this.b, r4));
    }

    public o(Observable r1, CompletableSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
