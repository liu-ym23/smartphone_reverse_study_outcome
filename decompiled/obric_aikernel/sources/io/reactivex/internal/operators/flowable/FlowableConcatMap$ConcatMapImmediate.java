package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMap$ConcatMapImmediate<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = 7898995095634264146L;
    final tc.c<? super R> downstream;
    final AtomicInteger wip;

    FlowableConcatMap$ConcatMapImmediate(tc.c<? super R> r10, zb.h<? super T, ? extends tc.b<? extends R>> r11, int r12) {
        super(r11, r12);
        this.downstream = r10;
        this.wip = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, tc.d
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.inner.cancel();
        this.upstream.cancel();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L6;
        if (this.active == true) goto L55;
        boolean r10 = this.done;
        T r11 = this.queue.poll();     // Catch: Throwable -> L51
        if (r11 != null) goto L14;
        boolean r12 = true;
    L15:
        if (r10 == false) goto L19;
        if (r12 == false) goto L19;
        this.downstream.onComplete();
        return;
    L19:
        if (r12 == true) goto L55;
        tc.b r13 = (tc.b) io.reactivex.internal.functions.a.d(this.mapper.apply(r11), "The mapper returned a null Publisher");     // Catch: Throwable -> L48
        if (this.sourceMode == 1) goto L28;
        int r14 = this.consumed + 1;
        if (r14 != this.limit) goto L26;
        this.consumed = 0;
        this.upstream.request(r14);
        goto L28
    L26:
        this.consumed = r14;
    L28:
        if ((r13 instanceof Callable) == false) goto L47;
        Object r15 = ((Callable) r13).call();     // Catch: Throwable -> L44
        if (r15 == null) goto L5;
        if (this.inner.isUnbounded() == true) goto L36;
        this.active = true;
        FlowableConcatMap$ConcatMapInner<R> r16 = this.inner;
        r16.setSubscription(new d(r15, r16));
        goto L55
    L36:
        if (get() != 0) goto L5;
        if (compareAndSet(0, 1) == false) goto L5;
        this.downstream.onNext(r15);
        if (compareAndSet(1, 0) == true) goto L5;
        this.downstream.onError(this.errors.terminate());
        return;
    L44:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L47:
        this.active = true;
        r13.subscribe(this.inner);
    L48:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L14:
        r12 = false;
    L51:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L55:
        if (this.wip.decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.c
    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L7;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.downstream.onError(this.errors.terminate());
        return;
    L9:
        return;
    L7:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.c
    public void innerNext(R r10) {
        if (get() == 0) goto L5;
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L12;
        this.downstream.onNext(r10);
        if (compareAndSet(1, 0) == false) goto L9;
        return;
    L9:
        this.downstream.onError(this.errors.terminate());
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L7;
        this.inner.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.downstream.onError(this.errors.terminate());
        return;
    L9:
        return;
    L7:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, tc.d
    public void request(long r10) {
        this.inner.request(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}
