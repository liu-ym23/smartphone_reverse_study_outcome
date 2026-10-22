package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<zu.d> implements g {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> r5) {
        this.parent = r5;
    }

    @Override // zu.c
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.otherError(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        get().cancel();
        this.parent.otherComplete();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
