package io.reactivex.processors;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class ReplayProcessor$ReplaySubscription<T> extends AtomicInteger implements zu.d {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final zu.c downstream;
    long emitted;
    Object index;
    final AtomicLong requested;
    final f state;

    public ReplayProcessor$ReplaySubscription(zu.c r5, f r10) {
        this.downstream = r5;
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        throw null;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L5;
        return;
    L5:
        v0.r(this.requested, r5);
        throw null;
    }
}
