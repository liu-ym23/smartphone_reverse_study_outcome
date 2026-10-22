package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = -5314538511045349925L;
    final b0 downstream;
    final o nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(b0 r5, o r10) {
        this.downstream = r5;
        this.nextFunction = r10;
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
        Object r10 = this.nextFunction.apply(r5);     // Catch: Throwable -> L5
        e.d(r10, "The nextFunction returned a null SingleSource.");     // Catch: Throwable -> L5
        c0 r11 = (c0) r10;     // Catch: Throwable -> L5
        a0 r12 = (a0) r11;
        r12.b(new com.lynx.animax.player.b(9, this, this.downstream));
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }
}
