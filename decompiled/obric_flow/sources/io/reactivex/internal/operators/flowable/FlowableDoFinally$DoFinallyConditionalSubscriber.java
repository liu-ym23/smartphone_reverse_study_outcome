package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableDoFinally$DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements rt.a {
    private static final long serialVersionUID = 4109457741734051389L;
    final rt.a downstream;
    final pt.a onFinally;

    /* JADX INFO: renamed from: qs, reason: collision with root package name */
    rt.e f17644qs;
    boolean syncFused;
    zu.d upstream;

    public FlowableDoFinally$DoFinallyConditionalSubscriber(rt.a r5, pt.a r10) {
        this.downstream = r5;
        this.onFinally = r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        this.upstream.cancel();
        runFinally();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.f17644qs.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.f17644qs.isEmpty();
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
        runFinally();
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L9;
        this.upstream = r5;
        if ((r5 instanceof rt.e) == false) goto L7;
        this.f17644qs = (rt.e) r5;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() throws Exception {
        T r5 = (T) this.f17644qs.poll();
        if (r5 == null) goto L5;
    L7:
        return r5;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public int requestFusion(int r5) {
        rt.e r10 = this.f17644qs;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r5 & 4) != 0) goto L13;
        int r12 = r10.requestFusion(r5);
        if (r12 != 0) goto L9;
    L12:
        return r12;
    L9:
        if (r12 != 1) goto L11;
        r11 = true;
    L11:
        this.syncFused = r11;
        goto L12
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    }

    @Override // rt.a
    public boolean tryOnNext(T r5) {
        return this.downstream.tryOnNext(r5);
    }
}
