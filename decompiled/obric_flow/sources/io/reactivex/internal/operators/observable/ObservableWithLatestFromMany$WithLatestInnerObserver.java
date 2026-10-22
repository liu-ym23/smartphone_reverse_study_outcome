package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWithLatestFromMany$WithLatestInnerObserver extends AtomicReference<Disposable> implements mt.u {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> parent;

    public ObservableWithLatestFromMany$WithLatestInnerObserver(ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.u
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.parent.innerError(this.index, r5);
    }

    @Override // mt.u
    public void onNext(Object r5) {
        if (this.hasValue == true) goto L5;
        this.hasValue = true;
    L5:
        this.parent.innerNext(this.index, r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
