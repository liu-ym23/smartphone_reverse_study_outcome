package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements xb.g<T>, c<R>, tc.d {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final AtomicThrowable errors;
    final FlowableConcatMap$ConcatMapInner<R> inner;
    final int limit;
    final zb.h<? super T, ? extends tc.b<? extends R>> mapper;
    final int prefetch;
    bc.f<T> queue;
    int sourceMode;
    tc.d upstream;

    FlowableConcatMap$BaseConcatMapSubscriber(zb.h<? super T, ? extends tc.b<? extends R>> r10, int r11) {
        this.mapper = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
        this.inner = new FlowableConcatMap$ConcatMapInner(this);
        this.errors = new AtomicThrowable();
    }

    @Override // tc.d
    public abstract /* synthetic */ void cancel();

    abstract void drain();

    @Override // io.reactivex.internal.operators.flowable.c
    public final void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.c
    public abstract /* synthetic */ void innerError(Throwable r10);

    @Override // io.reactivex.internal.operators.flowable.c
    public abstract /* synthetic */ void innerNext(T r10);

    @Override // tc.c
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public abstract /* synthetic */ void onError(Throwable r10);

    @Override // tc.c
    public final void onNext(T r10) {
        if (this.sourceMode != 2) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        this.upstream.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    @Override // xb.g, tc.c
    public final void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        subscribeActual();
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        subscribeActual();
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        subscribeActual();
        r10.request(this.prefetch);
        return;
    }

    @Override // tc.d
    public abstract /* synthetic */ void request(long r10);

    abstract void subscribeActual();
}
