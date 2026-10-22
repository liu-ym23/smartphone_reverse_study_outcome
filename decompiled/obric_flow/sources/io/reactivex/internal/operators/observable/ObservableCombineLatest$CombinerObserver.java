package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<Disposable> implements mt.u {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.u
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.parent.innerError(this.index, r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.parent.innerNext(this.index, r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
