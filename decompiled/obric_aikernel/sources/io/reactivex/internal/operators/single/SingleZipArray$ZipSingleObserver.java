package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<b> implements r<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final SingleZipArray$ZipCoordinator<T, ?> parent;

    SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.parent.innerError(r10, this.index);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.parent.innerSuccess(r10, this.index);
    }
}
