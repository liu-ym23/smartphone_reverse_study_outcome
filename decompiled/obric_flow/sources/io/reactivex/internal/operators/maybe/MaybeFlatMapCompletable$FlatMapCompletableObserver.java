package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements j, mt.b, Disposable {
    private static final long serialVersionUID = -2177128922851101253L;
    final mt.b downstream;
    final o mapper;

    public MaybeFlatMapCompletable$FlatMapCompletableObserver(mt.b r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
        mt.c r11 = (mt.c) r10;     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        ((mt.a) r11).b(this);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(th);
    }
}
