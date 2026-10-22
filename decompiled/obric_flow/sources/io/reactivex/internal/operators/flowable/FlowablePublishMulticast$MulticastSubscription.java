package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements zu.d {
    private static final long serialVersionUID = 8664815189257569791L;
    final zu.c downstream;
    long emitted;
    final p parent;

    public FlowablePublishMulticast$MulticastSubscription(zu.c r5, p r10) {
        this.downstream = r5;
    }

    @Override // zu.d
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

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L5;
        return;
    L5:
        v0.s(this, r5);
        throw null;
    }
}
