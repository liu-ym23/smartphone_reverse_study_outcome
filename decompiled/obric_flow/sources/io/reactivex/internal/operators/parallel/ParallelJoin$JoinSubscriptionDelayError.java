package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import rt.g;
import zu.c;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(c r5, int r10, int r11) {
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
        if (r14 == r13) goto L34;
        if (this.cancelled == true) goto L8;
        if (this.done.get() != 0) goto L13;
        boolean r15 = true;
    L14:
        int r16 = 0;
        boolean r17 = true;
    L15:
        if (r16 >= r10) goto L25;
        ParallelJoin$JoinInnerSubscriber<T> r18 = r5[r16];
        g r19 = r18.queue;
        if (r19 == null) goto L24;
        Object r110 = r19.poll();
        if (r110 == null) goto L24;
        r11.onNext(r110);
        r18.requestOne();
        r14 = r14 + 1;
        if (r14 == r13) goto L34;
        r17 = false;
    L24:
        r16 = r16 + 1;
        goto L15
    L25:
        if (r15 == false) goto L32;
        if (r17 == false) goto L32;
        if (this.errors.get() == null) goto L30;
        r11.onError(this.errors.terminate());
        return;
    L30:
        r11.onComplete();
        return;
    L32:
        if (r17 == false) goto L5;
    L13:
        r15 = false;
        goto L14
    L8:
        cleanup();
        return;
    L34:
        if (r14 != r13) goto L60;
        if (this.cancelled == true) goto L37;
        if (this.done.get() != 0) goto L42;
        boolean r20 = true;
    L43:
        int r111 = 0;
    L44:
        if (r111 >= r10) goto L51;
        g r112 = r5[r111].queue;
        if (r112 == null) goto L50;
        if (r112.isEmpty() == true) goto L50;
        boolean r113 = false;
    L52:
        if (r20 == false) goto L60;
        if (r113 == false) goto L60;
        if (this.errors.get() == null) goto L57;
        r11.onError(this.errors.terminate());
        return;
    L57:
        r11.onComplete();
        return;
    L50:
        r111 = r111 + 1;
        goto L44
    L51:
        r113 = true;
        goto L52
    L42:
        r20 = false;
        goto L43
    L37:
        cleanup();
        return;
    L60:
        if (r14 != 0) goto L62;
    L64:
        int r21 = get();
        if (r21 != r12) goto L69;
        r21 = addAndGet(-r12);
        if (r21 != 0) goto L69;
        return;
    L69:
        r12 = r21;
        goto L3
    L62:
        if (r13 == Long.MAX_VALUE) goto L64;
        this.requested.addAndGet(-r14);
        goto L64
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable r5) {
        this.errors.addThrowable(r5);
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> r10, T r11) {
        if (get() != 0) goto L20;
        if (compareAndSet(0, 1) == false) goto L20;
        if (this.requested.get() == 0) goto L13;
        this.downstream.onNext(r11);
        if (this.requested.get() == Long.MAX_VALUE) goto L11;
        this.requested.decrementAndGet();
    L11:
        r10.request(1);
    L17:
        if (decrementAndGet() != 0) goto L27;
        return;
    L27:
        drainLoop();
        return;
    L13:
        if (r10.getQueue().offer(r11) == true) goto L17;
        r10.cancel();
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
        drainLoop();
        return;
    L20:
        if (r10.getQueue().offer(r11) == true) goto L25;
        if (r10.cancel() == false) goto L25;
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
    L25:
        if (getAndIncrement() == 0) goto L27;
    }
}
