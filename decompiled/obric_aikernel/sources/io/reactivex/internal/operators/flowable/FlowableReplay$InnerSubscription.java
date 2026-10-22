package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements tc.d, io.reactivex.disposables.b {
    static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final tc.c<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final FlowableReplay$ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;

    FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> r10, tc.c<? super T> r11) {
        this.parent = r10;
        this.child = r11;
        this.totalRequested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
        this.parent.remove(this);
        this.parent.manageRequests();
        this.index = null;
        return;
    }

    <U> U index() {
        return (U) this.index;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public long produced(long r10) {
        return io.reactivex.internal.util.b.f(this, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (io.reactivex.internal.util.b.b(this, r10) == Long.MIN_VALUE) goto L9;
        io.reactivex.internal.util.b.a(this.totalRequested, r10);
        this.parent.manageRequests();
        this.parent.buffer.replay(this);
        return;
    }
}
