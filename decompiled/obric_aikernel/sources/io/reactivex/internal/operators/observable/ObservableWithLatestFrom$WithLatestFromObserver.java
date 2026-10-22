package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableWithLatestFrom$WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -312246233408980075L;
    final zb.c<? super T, ? super U, ? extends R> combiner;
    final xb.o<? super R> downstream;
    final AtomicReference<io.reactivex.disposables.b> other;
    final AtomicReference<io.reactivex.disposables.b> upstream;

    ObservableWithLatestFrom$WithLatestFromObserver(xb.o<? super R> r10, zb.c<? super T, ? super U, ? extends R> r11) {
        this.upstream = new AtomicReference();
        this.other = new AtomicReference();
        this.downstream = r10;
        this.combiner = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.other);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // xb.o
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        U r11 = get();
        if (r11 == null) goto L11;
        Object r12 = io.reactivex.internal.functions.a.d(this.combiner.apply(r10, r11), "The combiner returned a null value");     // Catch: Throwable -> L6
        this.downstream.onNext(r12);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        this.downstream.onError(th);
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    public void otherError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(r10);
    }

    public boolean setOther(io.reactivex.disposables.b r10) {
        return DisposableHelper.setOnce(this.other, r10);
    }
}
