package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<Disposable> implements j {
    private static final long serialVersionUID = -3031974433025990931L;
    final MaybeEqualSingle$EqualCoordinator<T> parent;
    Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> r5) {
        this.parent = r5;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.j
    public void onComplete() {
        this.parent.done();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.parent.error(this, r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.value = r5;
        this.parent.done();
    }
}
