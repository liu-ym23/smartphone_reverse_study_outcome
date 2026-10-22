package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowablePublish$InnerSubscriber<T> extends AtomicLong implements tc.d {
    private static final long serialVersionUID = -4453897557930727610L;
    final tc.c<? super T> child;
    long emitted;
    volatile FlowablePublish$PublishSubscriber<T> parent;

    FlowablePublish$InnerSubscriber(tc.c<? super T> r10) {
        this.child = r10;
    }

    @Override // tc.d
    public void cancel() {
        if (get() != Long.MIN_VALUE) goto L5;
        return;
    L5:
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L11;
        FlowablePublish$PublishSubscriber<T> r10 = this.parent;
        if (r10 == null) goto L12;
        r10.remove(this);
        r10.dispatch();
        return;
    L12:
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L8;
        io.reactivex.internal.util.b.b(this, r10);
        FlowablePublish$PublishSubscriber<T> r11 = this.parent;
        if (r11 == null) goto L9;
        r11.dispatch();
        return;
    L9:
        return;
    }
}
