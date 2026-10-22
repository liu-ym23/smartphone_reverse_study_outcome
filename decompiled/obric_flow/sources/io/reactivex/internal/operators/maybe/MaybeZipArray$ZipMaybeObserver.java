package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<Disposable> implements j {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final MaybeZipArray$ZipCoordinator<T, ?> parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.j
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.parent.innerError(r5, this.index);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.parent.innerSuccess(r5, this.index);
    }
}
