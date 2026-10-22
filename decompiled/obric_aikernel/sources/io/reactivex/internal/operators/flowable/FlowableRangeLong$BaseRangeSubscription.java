package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableRangeLong$BaseRangeSubscription extends BasicQueueSubscription<Long> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    final long end;
    long index;

    FlowableRangeLong$BaseRangeSubscription(long r10, long r11) {
        this.index = r10;
        this.end = r11;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, tc.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final void clear() {
        this.index = this.end;
    }

    abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final boolean isEmpty() {
        if (this.index != this.end) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final Long poll() {
        long r10 = this.index;
        if (r10 != this.end) goto L6;
        return null;
    L6:
        this.index = 1 + r10;
        return Long.valueOf(r10);
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (io.reactivex.internal.util.b.a(this, r10) == 0) goto L7;
        return;
    L7:
        if (r10 != Long.MAX_VALUE) goto L9;
        fastPath();
        return;
    L9:
        slowPath(r10);
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.c
    public final int requestFusion(int r10) {
        return r10 & 1;
    }

    abstract void slowPath(long r10);
}
