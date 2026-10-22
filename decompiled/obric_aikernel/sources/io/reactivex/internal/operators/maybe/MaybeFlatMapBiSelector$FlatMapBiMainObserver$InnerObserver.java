package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<io.reactivex.disposables.b> implements j<U> {
    private static final long serialVersionUID = -2897979525538174559L;
    final j<? super R> downstream;
    final zb.c<? super T, ? super U, ? extends R> resultSelector;
    T value;

    MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(j<? super R> r10, zb.c<? super T, ? super U, ? extends R> r11) {
        this.downstream = r10;
        this.resultSelector = r11;
    }

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(U r10) {
        T r11 = this.value;
        this.value = null;
        Object r12 = io.reactivex.internal.functions.a.d(this.resultSelector.apply(r11, r10), "The resultSelector returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r12);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
