package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<Disposable> implements j {
    private static final long serialVersionUID = -2897979525538174559L;
    final j downstream;
    final pt.c resultSelector;
    T value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(j r5, pt.c r10) {
        this.downstream = r5;
        this.resultSelector = r10;
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
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(U r5) {
        T r10 = this.value;
        this.value = null;
        Object r11 = this.resultSelector.apply(r10, r5);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The resultSelector returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r11);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }
}
