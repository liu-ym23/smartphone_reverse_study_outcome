package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWithLatestFrom$WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements mt.u, Disposable {
    private static final long serialVersionUID = -312246233408980075L;
    final pt.c combiner;
    final mt.u downstream;
    final AtomicReference<Disposable> other;
    final AtomicReference<Disposable> upstream;

    public ObservableWithLatestFrom$WithLatestFromObserver(mt.u r5, pt.c r10) {
        this.upstream = new AtomicReference();
        this.other = new AtomicReference();
        this.downstream = r5;
        this.combiner = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.other);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        U r10 = get();
        if (r10 == null) goto L11;
        Object r11 = this.combiner.apply(r5, r10);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The combiner returned a null value");     // Catch: Throwable -> L6
        this.downstream.onNext(r11);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.downstream.onError(th);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    public void otherError(Throwable r5) {
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(r5);
    }

    public boolean setOther(Disposable r5) {
        return DisposableHelper.setOnce(this.other, r5);
    }
}
