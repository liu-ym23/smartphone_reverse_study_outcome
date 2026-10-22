package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowablePublishAlt$InnerSubscription<T> extends AtomicLong implements zu.d {
    private static final long serialVersionUID = 2845000326761540265L;
    final zu.c downstream;
    long emitted;
    final FlowablePublishAlt$PublishConnection<T> parent;

    public FlowablePublishAlt$InnerSubscription(zu.c r5, FlowablePublishAlt$PublishConnection<T> r10) {
        this.downstream = r5;
        this.parent = r10;
    }

    @Override // zu.d
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
        this.parent.remove(this);
        this.parent.drain();
        return;
    }

    public boolean isCancelled() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.d
    public void request(long r5) {
        v0.s(this, r5);
        this.parent.drain();
    }
}
