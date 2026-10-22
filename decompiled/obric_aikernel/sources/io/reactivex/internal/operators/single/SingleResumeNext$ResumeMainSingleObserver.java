package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -5314538511045349925L;
    final r<? super T> downstream;
    final h<? super Throwable, ? extends s<? extends T>> nextFunction;

    SingleResumeNext$ResumeMainSingleObserver(r<? super T> r10, h<? super Throwable, ? extends s<? extends T>> r11) {
        this.downstream = r10;
        this.nextFunction = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        ((s) io.reactivex.internal.functions.a.d(this.nextFunction.apply(r10), "The nextFunction returned a null SingleSource.")).a(new io.reactivex.internal.observers.b(this, this.downstream));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
