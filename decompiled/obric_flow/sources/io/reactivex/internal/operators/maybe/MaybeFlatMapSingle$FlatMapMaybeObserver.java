package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.j;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapSingle$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 4827726964688405508L;
    final b0 downstream;
    final o mapper;

    public MaybeFlatMapSingle$FlatMapMaybeObserver(b0 r5, o r10) {
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
        this.downstream.onError(new NoSuchElementException());
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null SingleSource");     // Catch: Throwable -> L7
        c0 r11 = (c0) r10;     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        a0 r12 = (a0) r11;
        r12.b(new s6.c(10, this, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(th);
    }
}
