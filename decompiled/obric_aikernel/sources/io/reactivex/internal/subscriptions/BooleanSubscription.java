package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class BooleanSubscription extends AtomicBoolean implements d {
    private static final long serialVersionUID = -8127758972444290902L;

    public BooleanSubscription() {
    }

    @Override // tc.d
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.validate(r10);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
