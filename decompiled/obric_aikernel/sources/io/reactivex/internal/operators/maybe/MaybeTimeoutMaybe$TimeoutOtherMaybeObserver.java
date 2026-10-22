package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements j<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> parent;

    MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> r10) {
        this.parent = r10;
    }

    @Override // xb.j
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.parent.otherError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(Object r10) {
        this.parent.otherComplete();
    }
}
