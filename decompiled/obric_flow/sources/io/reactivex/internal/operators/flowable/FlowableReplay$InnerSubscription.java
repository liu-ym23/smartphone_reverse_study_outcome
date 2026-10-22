package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements zu.d, Disposable {
    static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final zu.c child;
    boolean emitting;
    Object index;
    boolean missed;
    final FlowableReplay$ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> r5, zu.c r10) {
        this.parent = r5;
        this.child = r10;
        this.totalRequested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
        this.parent.remove(this);
        this.parent.manageRequests();
        this.index = null;
        return;
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public long produced(long r5) {
        return v0.z(this, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L5;
        return;
    L5:
        if (v0.s(this, r5) == Long.MIN_VALUE) goto L9;
        v0.r(this.totalRequested, r5);
        this.parent.manageRequests();
        this.parent.buffer.replay(this);
        return;
    }
}
