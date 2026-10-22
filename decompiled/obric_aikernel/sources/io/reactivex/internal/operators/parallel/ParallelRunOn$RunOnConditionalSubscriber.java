package io.reactivex.internal.operators.parallel;

import bc.a;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import tc.d;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final a<? super T> downstream;

    ParallelRunOn$RunOnConditionalSubscriber(a<? super T> r10, int r11, SpscArrayQueue<T> r12, p.c r13) {
        super(r11, r12, r13);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        int r10 = this.consumed;
        SpscArrayQueue<T> r11 = this.queue;
        a<? super T> r12 = this.downstream;
        int r13 = this.limit;
        int r14 = 1;
    L3:
        long r15 = this.requested.get();
        long r16 = 0;
    L5:
        if (r16 == r15) goto L32;
        if (this.cancelled == true) goto L8;
        boolean r17 = this.done;
        if (r17 == false) goto L17;
        Throwable r18 = this.error;
        if (r18 == null) goto L17;
        r11.clear();
        r12.onError(r18);
    L15:
        this.worker.dispose();
        return;
    L17:
        T r19 = r11.poll();
        if (r19 != null) goto L20;
        boolean r110 = true;
    L21:
        if (r17 == false) goto L24;
        if (r110 == false) goto L24;
    L23:
        r12.onComplete();
    L24:
        if (r110 == true) goto L32;
        if (r12.tryOnNext(r19) == false) goto L29;
        r16 = r16 + 1;
    L29:
        r10 = r10 + 1;
        if (r10 != r13) goto L5;
        this.upstream.request(r10);
        r10 = 0;
        goto L5
    L20:
        r110 = false;
        goto L21
    L8:
        r11.clear();
        return;
    L32:
        if (r16 != r15) goto L46;
        if (this.cancelled == true) goto L35;
        if (this.done == false) goto L46;
        Throwable r111 = this.error;
        if (r111 != null) goto L41;
        if (r11.isEmpty() == false) goto L46;
    L41:
        r11.clear();
        r12.onError(r111);
        goto L15
    L35:
        r11.clear();
        return;
    L46:
        if (r16 != 0) goto L48;
    L50:
        int r20 = get();
        if (r20 == r14) goto L52;
        r14 = r20;
        goto L3
    L52:
        this.consumed = r10;
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L3;
        return;
    L48:
        if (r15 == Long.MAX_VALUE) goto L50;
        this.requested.addAndGet(-r16);
        goto L50
    }
}
