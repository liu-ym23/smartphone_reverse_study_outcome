package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    final T[] array;
    volatile boolean cancelled;
    int index;

    public FlowableFromArray$BaseArraySubscription(T[] r5) {
        this.array = r5;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, zu.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final void clear() {
        this.index = this.array.length;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final boolean isEmpty() {
        if (this.index != this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final T poll() {
        int r5 = this.index;
        T[] r10 = this.array;
        if (r5 != r10.length) goto L6;
        return null;
    L6:
        this.index = r5 + 1;
        T r11 = r10[r5];
        io.reactivex.internal.functions.e.d(r11, "array element is null");
        return r11;
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
}
