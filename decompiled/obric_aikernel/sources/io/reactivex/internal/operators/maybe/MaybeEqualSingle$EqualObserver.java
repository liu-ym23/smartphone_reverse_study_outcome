package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T> {
    private static final long serialVersionUID = -3031974433025990931L;
    final MaybeEqualSingle$EqualCoordinator<T> parent;
    Object value;

    MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> r10) {
        this.parent = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.j
    public void onComplete() {
        this.parent.done();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.parent.error(this, r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.value = r10;
        this.parent.done();
    }
}
