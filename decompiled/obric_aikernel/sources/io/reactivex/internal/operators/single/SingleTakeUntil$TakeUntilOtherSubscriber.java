package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class SingleTakeUntil$TakeUntilOtherSubscriber extends AtomicReference<d> implements g<Object> {
    private static final long serialVersionUID = 5170026210238877381L;
    final SingleTakeUntil$TakeUntilMainObserver<?> parent;

    SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver<?> r10) {
        this.parent = r10;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.otherError(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
