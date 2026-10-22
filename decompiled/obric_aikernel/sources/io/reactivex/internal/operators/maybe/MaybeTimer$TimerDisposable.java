package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeTimer$TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    final j<? super Long> downstream;

    MaybeTimer$TimerDisposable(j<? super Long> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.downstream.onSuccess(0L);
    }

    void setFuture(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this, r10);
    }
}
