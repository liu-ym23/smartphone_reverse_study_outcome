package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<tc.d> implements g<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> parent;

    MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> r10) {
        this.parent = r10;
    }

    @Override // tc.c
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.otherError(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        get().cancel();
        this.parent.otherComplete();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
