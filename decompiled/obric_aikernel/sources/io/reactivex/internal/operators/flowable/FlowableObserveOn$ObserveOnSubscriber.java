package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX WARN: Unexpected interfaces in signature: [xb.g<T>] */
/* JADX INFO: loaded from: classes2.dex */
final class FlowableObserveOn$ObserveOnSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = -4547113800637756442L;
    final tc.c<? super T> downstream;

    FlowableObserveOn$ObserveOnSubscriber(tc.c<? super T> r10, xb.p.c r11, boolean r12, int r13) {
        super(r11, r12, r13);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = 1;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = 2;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public T poll() {
        T r10 = this.queue.poll();
        if (r10 != null) goto L5;
    L10:
        return r10;
    L5:
        if (this.sourceMode == 1) goto L10;
        long r11 = this.produced + 1;
        if (r11 != this.limit) goto L9;
        this.produced = 0;
        this.upstream.request(r11);
        goto L10
    L9:
        this.produced = r11;
        goto L10
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    void runAsync() {
        tc.c<? super T> r10 = this.downstream;
        bc.f<T> r11 = this.queue;
        long r12 = this.produced;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r12 == r14) goto L25;
        boolean r15 = this.done;
        T r16 = r11.poll();     // Catch: Throwable -> L22
        if (r16 != null) goto L10;
        boolean r17 = true;
    L12:
        if (checkTerminated(r15, r17, r10) == true) goto L13;
        if (r17 == true) goto L25;
        r10.onNext(r16);
        r12 = r12 + 1;
        if (r12 != this.limit) goto L5;
        if (r14 == Long.MAX_VALUE) goto L21;
        r14 = this.requested.addAndGet(-r12);
    L21:
        this.upstream.request(r12);
        r12 = 0;
        goto L5
    L13:
        return;
    L10:
        r17 = false;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.cancel();
        r11.clear();
        r10.onError(th);
        this.worker.dispose();
        return;
    L25:
        if (r12 == r14) goto L27;
    L29:
        int r18 = get();
        if (r13 == r18) goto L31;
        r13 = r18;
        goto L3
    L31:
        this.produced = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L27:
        if (checkTerminated(this.done, r11.isEmpty(), r10) == false) goto L29;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    void runBackfused() {
        int r10 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        boolean r11 = this.done;
        this.downstream.onNext(null);
        if (r11 == true) goto L8;
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L4;
        return;
    L8:
        this.cancelled = true;
        Throwable r12 = this.error;
        if (r12 == null) goto L11;
        this.downstream.onError(r12);
    L12:
        this.worker.dispose();
        return;
    L11:
        this.downstream.onComplete();
        goto L12
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    void runSync() {
        tc.c<? super T> r10 = this.downstream;
        bc.f<T> r11 = this.queue;
        long r12 = this.produced;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r12 == r14) goto L18;
        T r15 = r11.poll();     // Catch: Throwable -> L15
        if (this.cancelled == true) goto L9;
        if (r15 == null) goto L11;
        r10.onNext(r15);
        r12 = r12 + 1;
    L11:
        this.cancelled = true;
        r10.onComplete();
    L12:
        this.worker.dispose();
        return;
    L9:
        return;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.cancel();
        r10.onError(th);
        goto L12
    L18:
        if (this.cancelled == true) goto L19;
        if (r11.isEmpty() == true) goto L11;
        int r16 = get();
        if (r13 == r16) goto L25;
        r13 = r16;
        goto L3
    L25:
        this.produced = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    }
}
