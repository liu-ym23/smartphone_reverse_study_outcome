package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    volatile boolean done;
    Throwable error;
    final io.reactivex.internal.queue.a<T> queue;
    final AtomicInteger wip;

    FlowableCreate$BufferAsyncEmitter(tc.c<? super T> r10, int r11) {
        super(r10);
        this.queue = new io.reactivex.internal.queue.a(r11);
        this.wip = new AtomicInteger();
    }

    void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a<T> r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = get();
        long r14 = 0;
    L8:
        if (r14 == r13) goto L27;
        if (isCancelled() == true) goto L11;
        boolean r15 = this.done;
        T r16 = r11.poll();
        if (r16 != null) goto L16;
        boolean r17 = true;
    L17:
        if (r15 == false) goto L24;
        if (r17 == false) goto L24;
        Throwable r18 = this.error;
        if (r18 == null) goto L22;
        error(r18);
        return;
    L22:
        complete();
        return;
    L24:
        if (r17 == true) goto L27;
        r10.onNext(r16);
        r14 = r14 + 1;
        goto L8
    L16:
        r17 = false;
        goto L17
    L11:
        r11.clear();
        return;
    L27:
        if (r14 != r13) goto L41;
        if (isCancelled() == true) goto L30;
        boolean r19 = this.done;
        boolean r20 = r11.isEmpty();
        if (r19 == false) goto L41;
        if (r20 == false) goto L41;
        Throwable r21 = this.error;
        if (r21 == null) goto L38;
        error(r21);
        return;
    L38:
        complete();
        return;
    L30:
        r11.clear();
        return;
    L41:
        if (r14 == 0) goto L43;
        io.reactivex.internal.util.b.e(this, r14);
    L43:
        r12 = this.wip.addAndGet(-r12);
        if (r12 != 0) goto L6;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, xb.d
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, xb.d
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (isCancelled() == true) goto L13;
        if (r10 != null) goto L10;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L10:
        this.queue.offer(r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public boolean tryOnError(Throwable r10) {
        if (this.done == false) goto L5;
        return false;
    L5:
        if (isCancelled() == true) goto L13;
        if (r10 != null) goto L9;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L9:
        this.error = r10;
        this.done = true;
        drain();
        return true;
    L13:
        return false;
    }
}
