package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements tc.d {
    private static final long serialVersionUID = 8664815189257569791L;
    final tc.c<? super T> downstream;
    long emitted;
    final h<T> parent;

    FlowablePublishMulticast$MulticastSubscription(tc.c<? super T> r10, h<T> r11) {
        this.downstream = r10;
    }

    @Override // tc.d
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
        return;
    L6:
        throw null;
    }

    public boolean isCancelled() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        io.reactivex.internal.util.b.b(this, r10);
        throw null;
    }
}
