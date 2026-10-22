package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRefCount$RefCountSubscriber<T> extends AtomicBoolean implements mt.g, zu.d {
    private static final long serialVersionUID = -7419642935409022375L;
    final FlowableRefCount$RefConnection connection;
    final zu.c downstream;
    final q parent;
    zu.d upstream;

    public FlowableRefCount$RefCountSubscriber(zu.c r5, q r10, FlowableRefCount$RefConnection r11) {
        this.downstream = r5;
        this.connection = r11;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
        if (compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // zu.c
    public void onComplete() {
        if (compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (compareAndSet(false, true) == true) goto L7;
        wn.f.k(r5);
        return;
    L7:
        throw null;
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }
}
