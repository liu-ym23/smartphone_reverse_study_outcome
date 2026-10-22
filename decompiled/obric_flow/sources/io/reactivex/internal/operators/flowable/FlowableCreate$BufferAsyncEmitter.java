package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    volatile boolean done;
    Throwable error;
    final io.reactivex.internal.queue.b queue;
    final AtomicInteger wip;

    public FlowableCreate$BufferAsyncEmitter(zu.c r5, int r10) {
        super(r5);
        this.queue = new io.reactivex.internal.queue.b(r10);
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        int r11 = 1;
    L6:
        long r12 = get();
        long r13 = 0;
    L8:
        if (r13 == r12) goto L27;
        if (isCancelled() == true) goto L11;
        boolean r14 = this.done;
        Object r15 = r10.poll();
        if (r15 != null) goto L16;
        boolean r16 = true;
    L17:
        if (r14 == false) goto L24;
        if (r16 == false) goto L24;
        Throwable r17 = this.error;
        if (r17 == null) goto L22;
        error(r17);
        return;
    L22:
        complete();
        return;
    L24:
        if (r16 == true) goto L27;
        r5.onNext(r15);
        r13 = r13 + 1;
        goto L8
    L16:
        r16 = false;
        goto L17
    L11:
        r10.clear();
        return;
    L27:
        if (r13 != r12) goto L41;
        if (isCancelled() == true) goto L30;
        boolean r18 = this.done;
        boolean r19 = r10.isEmpty();
        if (r18 == false) goto L41;
        if (r19 == false) goto L41;
        Throwable r20 = this.error;
        if (r20 == null) goto L38;
        error(r20);
        return;
    L38:
        complete();
        return;
    L30:
        r10.clear();
        return;
    L41:
        if (r13 == 0) goto L43;
        v0.y(this, r13);
    L43:
        r11 = this.wip.addAndGet(-r11);
        if (r11 != 0) goto L6;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, mt.d
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, mt.d
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (isCancelled() == true) goto L13;
        if (r5 != null) goto L10;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L10:
        this.queue.offer(r5);
        drain();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public boolean tryOnError(Throwable r5) {
        if (this.done == false) goto L5;
        return false;
    L5:
        if (isCancelled() == true) goto L13;
        if (r5 != null) goto L9;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L9:
        this.error = r5;
        this.done = true;
        drain();
        return true;
    L13:
        return false;
    }
}
