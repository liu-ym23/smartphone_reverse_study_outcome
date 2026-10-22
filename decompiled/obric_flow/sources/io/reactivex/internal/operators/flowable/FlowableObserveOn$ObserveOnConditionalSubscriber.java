package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = 644624475404284533L;
    long consumed;
    final rt.a downstream;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(rt.a r5, mt.y r10, boolean r11, int r12) {
        super(r10, r11, r12);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = 1;
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = 2;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() throws Exception {
        T r5 = (T) this.queue.poll();
        if (r5 != null) goto L5;
    L10:
        return r5;
    L5:
        if (this.sourceMode == 1) goto L10;
        long r10 = this.consumed + 1;
        if (r10 != this.limit) goto L9;
        this.consumed = 0;
        this.upstream.request(r10);
        goto L10
    L9:
        this.consumed = r10;
        goto L10
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        rt.a r5 = this.downstream;
        rt.h r10 = this.queue;
        long r11 = this.produced;
        long r12 = this.consumed;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r11 == r14) goto L25;
        boolean r15 = this.done;
        Object r16 = r10.poll();     // Catch: Throwable -> L22
        if (r16 != null) goto L10;
        boolean r17 = true;
    L12:
        if (checkTerminated(r15, r17, r5) == true) goto L13;
        if (r17 == true) goto L25;
        if (r5.tryOnNext(r16) == false) goto L19;
        r11 = r11 + 1;
    L19:
        r12 = r12 + 1;
        if (r12 != this.limit) goto L5;
        this.upstream.request(r12);
        r12 = 0;
        goto L5
    L13:
        return;
    L10:
        r17 = false;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.cancelled = true;
        this.upstream.cancel();
        r10.clear();
        r5.onError(th);
        this.worker.dispose();
        return;
    L25:
        if (r11 == r14) goto L27;
    L29:
        int r18 = get();
        if (r13 == r18) goto L31;
        r13 = r18;
        goto L3
    L31:
        this.produced = r11;
        this.consumed = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L27:
        if (checkTerminated(this.done, r10.isEmpty(), r5) == false) goto L29;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        int r5 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        boolean r10 = this.done;
        this.downstream.onNext(null);
        if (r10 == true) goto L8;
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L4;
        return;
    L8:
        this.cancelled = true;
        Throwable r11 = this.error;
        if (r11 == null) goto L11;
        this.downstream.onError(r11);
    L12:
        this.worker.dispose();
        return;
    L11:
        this.downstream.onComplete();
        goto L12
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runSync() {
        rt.a r5 = this.downstream;
        rt.h r10 = this.queue;
        long r11 = this.produced;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
    L5:
        if (r11 == r13) goto L20;
        Object r14 = r10.poll();     // Catch: Throwable -> L16
        if (this.cancelled == true) goto L9;
        if (r14 == null) goto L11;
        if (r5.tryOnNext(r14) == false) goto L5;
        r11 = r11 + 1;
        goto L5
    L11:
        this.cancelled = true;
        r5.onComplete();
        this.worker.dispose();
        return;
    L9:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.cancelled = true;
        this.upstream.cancel();
        r5.onError(th);
        this.worker.dispose();
        return;
    L20:
        if (this.cancelled == true) goto L21;
        if (r10.isEmpty() == true) goto L24;
        int r15 = get();
        if (r12 == r15) goto L28;
        r12 = r15;
        goto L3
    L28:
        this.produced = r11;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L24:
        this.cancelled = true;
        r5.onComplete();
        this.worker.dispose();
        return;
    }
}
