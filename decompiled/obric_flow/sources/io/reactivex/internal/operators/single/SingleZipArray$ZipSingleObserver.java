package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<Disposable> implements b0 {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final SingleZipArray$ZipCoordinator<T, ?> parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.parent.innerError(r5, this.index);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.parent.innerSuccess(r5, this.index);
    }
}
