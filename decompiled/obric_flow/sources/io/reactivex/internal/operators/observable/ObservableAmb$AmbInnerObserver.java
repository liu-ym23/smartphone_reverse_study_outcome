package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<Disposable> implements mt.u {
    private static final long serialVersionUID = -1185974347409665484L;
    final mt.u downstream;
    final int index;
    final n parent;
    boolean won;

    public ObservableAmb$AmbInnerObserver(n r5, int r10, mt.u r11) {
        this.parent = r5;
        this.index = r10;
        this.downstream = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.u
    public void onComplete() {
        if (this.won == false) goto L6;
        this.downstream.onComplete();
        return;
    L6:
        if (this.parent.a(this.index) == false) goto L10;
        this.won = true;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.won == false) goto L6;
        this.downstream.onError(r5);
        return;
    L6:
        if (this.parent.a(this.index) == false) goto L8;
        this.won = true;
        this.downstream.onError(r5);
        return;
    L8:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.won == false) goto L6;
        this.downstream.onNext(r5);
        return;
    L6:
        if (this.parent.a(this.index) == false) goto L8;
        this.won = true;
        this.downstream.onNext(r5);
        return;
    L8:
        get().dispose();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
