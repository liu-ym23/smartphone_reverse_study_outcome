package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final MaybeZipArray$ZipCoordinator<T, ?> parent;

    MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.j
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.parent.innerError(r10, this.index);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.parent.innerSuccess(r10, this.index);
    }
}
