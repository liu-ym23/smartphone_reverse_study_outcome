package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableRange$BaseRangeSubscription extends BasicQueueSubscription<Integer> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    final int end;
    int index;

    public FlowableRange$BaseRangeSubscription(int r5, int r10) {
        this.index = r5;
        this.end = r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, zu.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final void clear() {
        this.index = this.end;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final boolean isEmpty() {
        if (this.index != this.end) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public /* bridge */ /* synthetic */ Object poll() throws Exception {
        return poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, zu.d
    public final void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L5;
        return;
    L5:
        if (v0.r(this, r5) == 0) goto L7;
        return;
    L7:
        if (r5 != Long.MAX_VALUE) goto L9;
        fastPath();
        return;
    L9:
        slowPath(r5);
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.d
    public final int requestFusion(int r5) {
        return r5 & 1;
    }

    public abstract void slowPath(long r5);

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final Integer poll() {
        int r5 = this.index;
        if (r5 != this.end) goto L6;
        return null;
    L6:
        this.index = r5 + 1;
        return Integer.valueOf(r5);
    }
}
