package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T> {
    private static final long serialVersionUID = -1185974347409665484L;
    final xb.o<? super T> downstream;
    final int index;
    final b<T> parent;
    boolean won;

    ObservableAmb$AmbInnerObserver(b<T> r10, int r11, xb.o<? super T> r12) {
        this.index = r11;
        this.downstream = r12;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.o
    public void onComplete() {
        if (this.won == false) goto L7;
        this.downstream.onComplete();
        return;
    L7:
        throw null;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.won == false) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        throw null;
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.won == false) goto L7;
        this.downstream.onNext(r10);
        return;
    L7:
        throw null;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
