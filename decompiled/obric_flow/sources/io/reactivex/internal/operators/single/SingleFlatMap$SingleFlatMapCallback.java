package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = 3258103020495908596L;
    final b0 downstream;
    final o mapper;

    public SingleFlatMap$SingleFlatMapCallback(b0 r5, o r10) {
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
        e.d(r10, "The single returned by the mapper is null");     // Catch: Throwable -> L7
        c0 r11 = (c0) r10;     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        a0 r12 = (a0) r11;
        r12.b(new q7.a(10, this, false, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }
}
