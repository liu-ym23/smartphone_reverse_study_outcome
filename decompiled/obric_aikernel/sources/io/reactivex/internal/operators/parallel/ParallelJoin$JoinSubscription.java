package io.reactivex.internal.operators.parallel;

import bc.e;
import dc.a;
import io.reactivex.exceptions.MissingBackpressureException;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelJoin$JoinSubscription<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = 6312374661811000451L;

    ParallelJoin$JoinSubscription(c<? super T> r10, int r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    void drainLoop() {
        ParallelJoin$JoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        c<? super T> r12 = this.downstream;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
        long r15 = 0;
    L5:
        if (r15 == r14) goto L36;
        if (this.cancelled == true) goto L8;
        Throwable r16 = this.errors.get();
        if (r16 != null) goto L12;
        if (this.done.get() != 0) goto L17;
        boolean r17 = true;
    L18:
        int r18 = 0;
        boolean r19 = true;
    L20:
        if (r18 >= r10.length) goto L30;
        ParallelJoin$JoinInnerSubscriber<T> r20 = r10[r18];
        e<T> r110 = r20.queue;
        if (r110 == null) goto L29;
        T r111 = r110.poll();
        if (r111 == null) goto L29;
        r12.onNext(r111);
        r20.requestOne();
        r15 = r15 + 1;
        if (r15 == r14) goto L36;
        r19 = false;
    L29:
        r18 = r18 + 1;
        goto L20
    L30:
        if (r17 == false) goto L34;
        if (r19 == false) goto L34;
        r12.onComplete();
        return;
    L34:
        if (r19 == false) goto L5;
    L17:
        r17 = false;
        goto L18
    L12:
        cleanup();
        r12.onError(r16);
        return;
    L8:
        cleanup();
        return;
    L36:
        if (r15 != r14) goto L63;
        if (this.cancelled == true) goto L39;
        Throwable r21 = this.errors.get();
        if (r21 != null) goto L43;
        if (this.done.get() != 0) goto L48;
        boolean r22 = true;
    L49:
        int r112 = 0;
    L50:
        if (r112 >= r11) goto L57;
        e<T> r113 = r10[r112].queue;
        if (r113 == null) goto L56;
        if (r113.isEmpty() == true) goto L56;
        boolean r114 = false;
    L58:
        if (r22 == false) goto L63;
        if (r114 == false) goto L63;
        r12.onComplete();
        return;
    L56:
        r112 = r112 + 1;
        goto L50
    L57:
        r114 = true;
        goto L58
    L48:
        r22 = false;
        goto L49
    L43:
        cleanup();
        r12.onError(r21);
        return;
    L39:
        cleanup();
        return;
    L63:
        if (r15 != 0) goto L65;
    L67:
        int r23 = get();
        if (r23 != r13) goto L72;
        r23 = addAndGet(-r13);
        if (r23 != 0) goto L72;
        return;
    L72:
        r13 = r23;
        goto L3
    L65:
        if (r14 == Long.MAX_VALUE) goto L67;
        this.requested.addAndGet(-r15);
        goto L67
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable r10) {
        if (this.errors.compareAndSet(null, r10) == false) goto L6;
        cancelAll();
        drain();
        return;
    L6:
        if (r10 == this.errors.get()) goto L10;
        a.n(r10);
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
        a.n(r12);
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
