package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import rt.g;
import wn.f;
import zu.c;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelJoin$JoinSubscription<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = 6312374661811000451L;

    public ParallelJoin$JoinSubscription(c r5, int r10, int r11) {
        super(r5, r10, r11);
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    public void drainLoop() {
        ParallelJoin$JoinInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        c r11 = this.downstream;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
        long r14 = 0;
    L5:
        if (r14 == r13) goto L36;
        if (this.cancelled == true) goto L8;
        Throwable r15 = this.errors.get();
        if (r15 != null) goto L12;
        if (this.done.get() != 0) goto L17;
        boolean r16 = true;
    L18:
        int r17 = 0;
        boolean r18 = true;
    L20:
        if (r17 >= r5.length) goto L30;
        ParallelJoin$JoinInnerSubscriber<T> r19 = r5[r17];
        g r110 = r19.queue;
        if (r110 == null) goto L29;
        Object r111 = r110.poll();
        if (r111 == null) goto L29;
        r11.onNext(r111);
        r19.requestOne();
        r14 = r14 + 1;
        if (r14 == r13) goto L36;
        r18 = false;
    L29:
        r17 = r17 + 1;
        goto L20
    L30:
        if (r16 == false) goto L34;
        if (r18 == false) goto L34;
        r11.onComplete();
        return;
    L34:
        if (r18 == false) goto L5;
    L17:
        r16 = false;
        goto L18
    L12:
        cleanup();
        r11.onError(r15);
        return;
    L8:
        cleanup();
        return;
    L36:
        if (r14 != r13) goto L63;
        if (this.cancelled == true) goto L39;
        Throwable r20 = this.errors.get();
        if (r20 != null) goto L43;
        if (this.done.get() != 0) goto L48;
        boolean r21 = true;
    L49:
        int r112 = 0;
    L50:
        if (r112 >= r10) goto L57;
        g r113 = r5[r112].queue;
        if (r113 == null) goto L56;
        if (r113.isEmpty() == true) goto L56;
        boolean r114 = false;
    L58:
        if (r21 == false) goto L63;
        if (r114 == false) goto L63;
        r11.onComplete();
        return;
    L56:
        r112 = r112 + 1;
        goto L50
    L57:
        r114 = true;
        goto L58
    L48:
        r21 = false;
        goto L49
    L43:
        cleanup();
        r11.onError(r20);
        return;
    L39:
        cleanup();
        return;
    L63:
        if (r14 != 0) goto L65;
    L67:
        int r22 = get();
        if (r22 != r12) goto L72;
        r22 = addAndGet(-r12);
        if (r22 != 0) goto L72;
        return;
    L72:
        r12 = r22;
        goto L3
    L65:
        if (r13 == Long.MAX_VALUE) goto L67;
        this.requested.addAndGet(-r14);
        goto L67
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable r5) {
        if (this.errors.compareAndSet(null, r5) == false) goto L6;
        cancelAll();
        drain();
        return;
    L6:
        if (r5 == this.errors.get()) goto L10;
        f.k(r5);
        return;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> r10, T r11) {
        if (get() != 0) goto L23;
        if (compareAndSet(0, 1) == false) goto L23;
        if (this.requested.get() == 0) goto L13;
        this.downstream.onNext(r11);
        if (this.requested.get() == Long.MAX_VALUE) goto L11;
        this.requested.decrementAndGet();
    L11:
        r10.request(1);
    L20:
        if (decrementAndGet() != 0) goto L29;
        return;
    L29:
        drainLoop();
        return;
    L13:
        if (r10.getQueue().offer(r11) == true) goto L20;
        cancelAll();
        MissingBackpressureException r12 = new MissingBackpressureException("Queue full?!");
        if (this.errors.compareAndSet(null, r12) == false) goto L17;
        this.downstream.onError(r12);
        return;
    L17:
        f.k(r12);
        return;
    L23:
        if (r10.getQueue().offer(r11) == true) goto L27;
        cancelAll();
        onError(new MissingBackpressureException("Queue full?!"));
        return;
    L27:
        if (getAndIncrement() == 0) goto L29;
    }
}
