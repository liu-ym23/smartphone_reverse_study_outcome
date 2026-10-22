package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.c;
import xb.r;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<b> implements r<T>, xb.b, b {
    private static final long serialVersionUID = -2177128922851101253L;
    final xb.b downstream;
    final h<? super T, ? extends c> mapper;

    SingleFlatMapCompletable$FlatMapCompletableObserver(xb.b r10, h<? super T, ? extends c> r11) {
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

    @Override // xb.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        DisposableHelper.replace(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        c r11 = (c) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
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
