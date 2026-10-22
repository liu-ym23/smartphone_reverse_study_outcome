package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import mt.y;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final rt.a downstream;

    public ParallelRunOn$RunOnConditionalSubscriber(rt.a r5, int r10, SpscArrayQueue<T> r11, y r12) {
        super(r10, r11, r12);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        int r5 = this.consumed;
        SpscArrayQueue<T> r10 = this.queue;
        rt.a r11 = this.downstream;
        int r12 = this.limit;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
        long r15 = 0;
    L5:
        if (r15 == r14) goto L32;
        if (this.cancelled == true) goto L8;
        boolean r16 = this.done;
        if (r16 == false) goto L16;
        Throwable r17 = this.error;
        if (r17 == null) goto L16;
        r10.clear();
        r11.onError(r17);
        this.worker.dispose();
        return;
    L16:
        T r18 = r10.poll();
        if (r18 != null) goto L19;
        boolean r19 = true;
    L20:
        if (r16 == false) goto L24;
        if (r19 == false) goto L24;
        r11.onComplete();
        this.worker.dispose();
        return;
    L24:
        if (r19 == true) goto L32;
        if (r11.tryOnNext(r18) == false) goto L29;
        r15 = r15 + 1;
    L29:
        r5 = r5 + 1;
        if (r5 != r12) goto L5;
        this.upstream.request(r5);
        r5 = 0;
        goto L5
    L19:
        r19 = false;
        goto L20
    L8:
        r10.clear();
        return;
    L32:
        if (r15 != r14) goto L48;
        if (this.cancelled == true) goto L35;
        if (this.done == false) goto L48;
        Throwable r110 = this.error;
        if (r110 != null) goto L41;
        if (r10.isEmpty() == false) goto L48;
        r11.onComplete();
        this.worker.dispose();
        return;
    L41:
        r10.clear();
        r11.onError(r110);
        this.worker.dispose();
        return;
    L35:
        r10.clear();
        return;
    L48:
        if (r15 != 0) goto L50;
    L52:
        int r20 = get();
        if (r20 == r13) goto L54;
        r13 = r20;
        goto L3
    L54:
        this.consumed = r5;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L50:
        if (r14 == Long.MAX_VALUE) goto L52;
        this.requested.addAndGet(-r15);
        goto L52
    }
}
