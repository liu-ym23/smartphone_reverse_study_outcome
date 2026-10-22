package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    final T[] array;
    volatile boolean cancelled;
    int index;

    FlowableFromArray$BaseArraySubscription(T[] r10) {
        this.array = r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, tc.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final void clear() {
        this.index = this.array.length;
    }

    abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final boolean isEmpty() {
        if (this.index != this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, bc.f
    public final T poll() {
        int r10 = this.index;
        T[] r11 = this.array;
        if (r10 != r11.length) goto L6;
        return null;
    L6:
        this.index = r10 + 1;
        return (T) io.reactivex.internal.functions.a.d(r11[r10], "array element is null");
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
