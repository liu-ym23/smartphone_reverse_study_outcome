package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class SingleTakeUntil$TakeUntilOtherSubscriber extends AtomicReference<d> implements g {
    private static final long serialVersionUID = 5170026210238877381L;
    final SingleTakeUntil$TakeUntilMainObserver<?> parent;

    public SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver<?> r5) {
        this.parent = r5;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        d r5 = get();
        SubscriptionHelper r10 = SubscriptionHelper.CANCELLED;
        if (r5 == r10) goto L6;
        lazySet(r10);
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.otherError(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
