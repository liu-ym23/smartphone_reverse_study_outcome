package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowablePublish$InnerSubscriber<T> extends AtomicLong implements zu.d {
    private static final long serialVersionUID = -4453897557930727610L;
    final zu.c child;
    long emitted;
    volatile FlowablePublish$PublishSubscriber<T> parent;

    public FlowablePublish$InnerSubscriber(zu.c r5) {
        this.child = r5;
    }

    @Override // zu.d
    public void cancel() {
        if (get() != Long.MIN_VALUE) goto L5;
        return;
    L5:
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L11;
        FlowablePublish$PublishSubscriber<T> r5 = this.parent;
        if (r5 == null) goto L12;
        r5.remove(this);
        r5.dispatch();
        return;
    L12:
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L8;
        v0.s(this, r5);
        FlowablePublish$PublishSubscriber<T> r10 = this.parent;
        if (r10 == null) goto L9;
        r10.dispatch();
        return;
    L9:
        return;
    }
}
