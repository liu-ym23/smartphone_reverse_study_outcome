package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class l<T> implements xb.o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final xb.o<? super T> f9576c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9577g;

    l(xb.o<? super T> r10, AtomicReference<io.reactivex.disposables.b> r11) {
        this.f9576c = r10;
        this.f9577g = r11;
    }

    @Override // xb.o
    public void onComplete() {
        this.f9576c.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9576c.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.f9576c.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this.f9577g, r10);
    }
}
