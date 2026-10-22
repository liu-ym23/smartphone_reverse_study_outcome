package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    Iterator<? extends T> it;
    boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> r5) {
        this.it = r5;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, zu.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final void clear() {
        this.it = null;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final boolean isEmpty() {
        Iterator<? extends T> r5 = this.it;
        if (r5 != null) goto L5;
    L8:
        return true;
    L5:
        if (r5.hasNext() == false) goto L8;
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, rt.h
    public final T poll() {
        Iterator<? extends T> r5 = this.it;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (this.once == true) goto L9;
        this.once = true;
    L11:
        T r10 = this.it.next();
        io.reactivex.internal.functions.e.d(r10, "Iterator.next() returned a null value");
        return r10;
    L9:
        if (r5.hasNext() == true) goto L11;
        return null;
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
