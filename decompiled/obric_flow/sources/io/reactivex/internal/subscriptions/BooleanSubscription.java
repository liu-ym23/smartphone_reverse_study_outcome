package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class BooleanSubscription extends AtomicBoolean implements d {
    private static final long serialVersionUID = -8127758972444290902L;

    public BooleanSubscription() {
    }

    @Override // zu.d
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.validate(r5);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
