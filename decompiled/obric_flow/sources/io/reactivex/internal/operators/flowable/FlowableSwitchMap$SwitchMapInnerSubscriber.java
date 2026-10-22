package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> extends AtomicReference<zu.d> implements mt.g {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long index;
    final FlowableSwitchMap$SwitchMapSubscriber<T, R> parent;
    volatile rt.h queue;

    public FlowableSwitchMap$SwitchMapInnerSubscriber(FlowableSwitchMap$SwitchMapSubscriber<T, R> r5, long r10, int r11) {
        this.parent = r5;
        this.index = r10;
        this.bufferSize = r11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r5 = this.parent;
        if (this.index != r5.unique) goto L6;
        this.done = true;
        r5.drain();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r10) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r5 = this.parent;
        if (this.index == r5.unique) goto L5;
    L10:
        wn.f.k(r10);
        return;
    L5:
        if (r5.error.addThrowable(r10) == false) goto L10;
        if (r5.delayErrors == true) goto L9;
        r5.upstream.cancel();
    L9:
        this.done = true;
        r5.drain();
    }

    @Override // zu.c
    public void onNext(R r10) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r5 = this.parent;
        if (this.index == r5.unique) goto L5;
        return;
    L5:
        if (this.fusionMode == 0) goto L7;
    L10:
        r5.drain();
        return;
    L7:
        if (this.queue.offer(r10) == true) goto L10;
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.fusionMode = r11;
        this.queue = r10;
        r5.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r5.request(this.bufferSize);
    }
}
