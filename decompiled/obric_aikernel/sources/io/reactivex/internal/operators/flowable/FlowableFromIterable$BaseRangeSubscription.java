package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    Iterator<? extends T> it;
    boolean once;

    FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> r10) {
        this.it = r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, tc.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final void clear() {
        this.it = null;
    }

    abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final boolean isEmpty() {
        Iterator<? extends T> r10 = this.it;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.hasNext() == false) goto L8;
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final T poll() {
        Iterator<? extends T> r10 = this.it;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.once == true) goto L9;
        this.once = true;
    L12:
        return (T) io.reactivex.internal.functions.a.d(this.it.next(), "Iterator.next() returned a null value");
    L9:
        if (r10.hasNext() == true) goto L12;
        return null;
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
