package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, xb.b, io.reactivex.disposables.b {
    private static final long serialVersionUID = -2177128922851101253L;
    final xb.b downstream;
    final h<? super T, ? extends xb.c> mapper;

    MaybeFlatMapCompletable$FlatMapCompletableObserver(xb.b r10, h<? super T, ? extends xb.c> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        xb.c r11 = (xb.c) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        r11.a(this);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        onError(th);
    }
}
