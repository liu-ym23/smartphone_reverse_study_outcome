package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableDoFinally$DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements bc.a<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final bc.a<? super T> downstream;
    final zb.a onFinally;
    bc.d<T> qs;
    boolean syncFused;
    tc.d upstream;

    FlowableDoFinally$DoFinallyConditionalSubscriber(bc.a<? super T> r10, zb.a r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        this.upstream.cancel();
        runFinally();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        if ((r10 instanceof bc.d) == false) goto L7;
        this.qs = (bc.d) r10;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public T poll() {
        T r10 = this.qs.poll();
        if (r10 == null) goto L5;
    L7:
        return r10;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void request(long r10) {
        this.upstream.request(r10);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public int requestFusion(int r10) {
        bc.d<T> r11 = this.qs;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r10 & 4) != 0) goto L13;
        int r13 = r11.requestFusion(r10);
        if (r13 != 0) goto L9;
    L12:
        return r13;
    L9:
        if (r13 != 1) goto L11;
        r12 = true;
    L11:
        this.syncFused = r12;
        goto L12
    }

    void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // bc.a
    public boolean tryOnNext(T r10) {
        return this.downstream.tryOnNext(r10);
    }
}
