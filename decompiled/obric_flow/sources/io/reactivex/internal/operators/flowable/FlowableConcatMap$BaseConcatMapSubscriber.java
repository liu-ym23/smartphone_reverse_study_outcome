package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements mt.g, e, zu.d {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final AtomicThrowable errors;
    final FlowableConcatMap$ConcatMapInner<R> inner;
    final int limit;
    final pt.o mapper;
    final int prefetch;
    rt.h queue;
    int sourceMode;
    zu.d upstream;

    public FlowableConcatMap$BaseConcatMapSubscriber(pt.o r5, int r10) {
        this.mapper = r5;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
        this.inner = new FlowableConcatMap$ConcatMapInner(this);
        this.errors = new AtomicThrowable();
    }

    @Override // zu.d
    public abstract /* synthetic */ void cancel();

    public abstract void drain();

    @Override // io.reactivex.internal.operators.flowable.e
    public final void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.e
    public abstract /* synthetic */ void innerError(Throwable r5);

    @Override // io.reactivex.internal.operators.flowable.e
    public abstract /* synthetic */ void innerNext(Object r5);

    @Override // zu.c
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public abstract /* synthetic */ void onError(Throwable r5);

    @Override // zu.c
    public final void onNext(T r5) {
        if (this.sourceMode != 2) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        this.upstream.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        subscribeActual();
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        subscribeActual();
        r5.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        subscribeActual();
        r5.request(this.prefetch);
        return;
    }

    @Override // zu.d
    public abstract /* synthetic */ void request(long r5);

    public abstract void subscribeActual();
}
