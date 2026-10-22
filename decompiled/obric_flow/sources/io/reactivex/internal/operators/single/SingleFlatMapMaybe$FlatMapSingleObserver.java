package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import mt.h;
import mt.j;
import mt.k;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = -5843758257109742742L;
    final j downstream;
    final o mapper;

    public SingleFlatMapMaybe$FlatMapSingleObserver(j r5, o r10) {
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

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L7
        e.d(r10, "The mapper returned a null MaybeSource");     // Catch: Throwable -> L7
        k r11 = (k) r10;     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        h r12 = (h) r11;
        r12.b(new s6.c(11, this, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(th);
    }
}
