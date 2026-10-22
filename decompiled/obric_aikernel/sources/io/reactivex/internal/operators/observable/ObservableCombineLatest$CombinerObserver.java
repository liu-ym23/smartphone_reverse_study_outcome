package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T> {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.o
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.parent.innerNext(this.index, r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
