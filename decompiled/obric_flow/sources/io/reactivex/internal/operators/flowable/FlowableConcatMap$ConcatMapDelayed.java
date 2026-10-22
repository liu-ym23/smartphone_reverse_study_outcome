package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = -2945777694260521066L;
    final zu.c downstream;
    final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(zu.c r5, pt.o r10, int r11, boolean r12) {
        super(r10, r11);
        this.downstream = r5;
        this.veryEnd = r12;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, zu.d
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.inner.cancel();
        this.upstream.cancel();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L6;
        if (this.active == true) goto L62;
        boolean r5 = this.done;
        if (r5 == true) goto L12;
    L66:
        Object r10 = this.queue.poll();     // Catch: Throwable -> L58
        if (r10 != null) goto L21;
        boolean r11 = true;
    L22:
        if (r5 == false) goto L29;
        if (r11 == false) goto L29;
        Throwable r12 = this.errors.terminate();
        if (r12 == null) goto L27;
        this.downstream.onError(r12);
        return;
    L27:
        this.downstream.onComplete();
        return;
    L29:
        if (r11 == true) goto L62;
        Object r13 = this.mapper.apply(r10);     // Catch: Throwable -> L55
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null Publisher");     // Catch: Throwable -> L55
        zu.b r14 = (zu.b) r13;     // Catch: Throwable -> L55
        if (this.sourceMode == 1) goto L38;
        int r15 = this.consumed + 1;
        if (r15 != this.limit) goto L36;
        this.consumed = 0;
        this.upstream.request(r15);
        goto L38
    L36:
        this.consumed = r15;
    L38:
        if ((r14 instanceof Callable) == false) goto L54;
        Object r16 = ((Callable) r14).call();     // Catch: Throwable -> L42
    L48:
        if (r16 == null) goto L5;
        if (this.inner.isUnbounded() == true) goto L52;
        this.active = true;
        FlowableConcatMap$ConcatMapInner<R> r17 = this.inner;
        r17.setSubscription(new f(r16, r17));
        goto L62
    L52:
        this.downstream.onNext(r16);
    L42:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
        if (this.veryEnd == false) goto L45;
        r16 = null;
        goto L48
    L45:
        this.upstream.cancel();
        this.downstream.onError(this.errors.terminate());
        return;
    L54:
        this.active = true;
        r14.subscribe(this.inner);
    L55:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L21:
        r11 = false;
    L58:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L12:
        if (this.veryEnd == true) goto L66;
        if (this.errors.get() == null) goto L66;
        this.downstream.onError(this.errors.terminate());
        return;
    L62:
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.e
    public void innerError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.veryEnd == true) goto L7;
        this.upstream.cancel();
        this.done = true;
    L7:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, io.reactivex.internal.operators.flowable.e
    public void innerNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, zu.d
    public void request(long r5) {
        this.inner.request(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}
