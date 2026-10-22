package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = -2945777694260521066L;
    final tc.c<? super R> downstream;
    final boolean veryEnd;

    FlowableConcatMap$ConcatMapDelayed(tc.c<? super R> r10, zb.h<? super T, ? extends tc.b<? extends R>> r11, int r12, boolean r13) {
        super(r11, r12);
        this.downstream = r10;
        this.veryEnd = r13;
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
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L6;
        if (this.active == true) goto L51;
        boolean r10 = this.done;
        if (r10 == true) goto L12;
    L53:
        T r11 = this.queue.poll();     // Catch: Throwable -> L47
        if (r11 != null) goto L21;
        boolean r12 = true;
    L22:
        if (r10 == false) goto L29;
        if (r12 == false) goto L29;
        Throwable r13 = this.errors.terminate();
        tc.c<? super R> r14 = this.downstream;
        if (r13 == null) goto L27;
        r14.onError(r13);
        return;
    L27:
        r14.onComplete();
        return;
    L29:
        if (r12 == true) goto L51;
        tc.b r15 = (tc.b) io.reactivex.internal.functions.a.d(this.mapper.apply(r11), "The mapper returned a null Publisher");     // Catch: Throwable -> L47
        if (this.sourceMode == 1) goto L38;
        int r16 = this.consumed + 1;
        if (r16 != this.limit) goto L36;
        this.consumed = 0;
        this.upstream.request(r16);
        goto L38
    L36:
        this.consumed = r16;
    L38:
        if ((r15 instanceof Callable) == false) goto L49;
        Object r17 = ((Callable) r15).call();     // Catch: Throwable -> L47
        if (r17 == null) goto L5;
        if (this.inner.isUnbounded() == true) goto L45;
        this.active = true;
        FlowableConcatMap$ConcatMapInner<R> r18 = this.inner;
        r18.setSubscription(new d(r17, r18));
        goto L51
    L45:
        this.downstream.onNext(r17);
        goto L5
    L49:
        this.active = true;
        r15.subscribe(this.inner);
        goto L51
    L21:
        r12 = false;
    L47:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
    L15:
        this.downstream.onError(this.errors.terminate());
        return;
    L12:
        if (this.veryEnd == true) goto L53;
        if (this.errors.get() == null) goto L53;
    L51:
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.c
    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.veryEnd == true) goto L7;
        this.upstream.cancel();
        this.done = true;
    L7:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.c
    public void innerNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
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
