package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> extends AtomicReference<tc.d> implements xb.g<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long index;
    final FlowableSwitchMap$SwitchMapSubscriber<T, R> parent;
    volatile bc.f<R> queue;

    FlowableSwitchMap$SwitchMapInnerSubscriber(FlowableSwitchMap$SwitchMapSubscriber<T, R> r10, long r11, int r12) {
        this.parent = r10;
        this.index = r11;
        this.bufferSize = r12;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r10 = this.parent;
        if (this.index != r10.unique) goto L6;
        this.done = true;
        r10.drain();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r11 = this.parent;
        if (this.index == r11.unique) goto L5;
    L10:
        dc.a.n(r10);
        return;
    L5:
        if (r11.error.addThrowable(r10) == false) goto L10;
        if (r11.delayErrors == true) goto L9;
        r11.upstream.cancel();
    L9:
        this.done = true;
        r11.drain();
    }

    @Override // tc.c
    public void onNext(R r10) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> r11 = this.parent;
        if (this.index == r11.unique) goto L5;
        return;
    L5:
        if (this.fusionMode == 0) goto L7;
    L10:
        r11.drain();
        return;
    L7:
        if (this.queue.offer(r10) == true) goto L10;
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        r10.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r10.request(this.bufferSize);
    }
}
