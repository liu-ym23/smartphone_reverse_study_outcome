package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCache$CacheSubscription<T> extends AtomicInteger implements zu.d {
    private static final long serialVersionUID = 6770240836423125754L;
    final zu.c downstream;
    long index;
    c node;
    int offset;
    final d parent;
    final AtomicLong requested;

    public FlowableCache$CacheSubscription(zu.c r5, d r10) {
        this.downstream = r5;
        throw null;
    }

    @Override // zu.d
    public void cancel() {
        if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L5;
        return;
    L5:
        v0.s(this.requested, r5);
        throw null;
    }
}
