package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    volatile boolean done;
    Throwable error;
    final AtomicReference<T> queue;
    final AtomicInteger wip;

    public FlowableCreate$LatestAsyncEmitter(zu.c r5) {
        super(r5);
        this.queue = new AtomicReference();
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        AtomicReference<T> r10 = this.queue;
        int r11 = 1;
    L6:
        long r12 = get();
        long r13 = 0;
    L7:
        boolean r14 = false;
        if (r13 == r12) goto L27;
        if (isCancelled() == true) goto L11;
        boolean r15 = this.done;
        T r16 = r10.getAndSet(null);
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
        r5.onNext(r16);
        r13 = r13 + 1;
        goto L7
    L16:
        r17 = false;
        goto L17
    L11:
        r10.lazySet(null);
        return;
    L27:
        if (r13 != r12) goto L43;
        if (isCancelled() == true) goto L30;
        boolean r19 = this.done;
        if (r10.get() != null) goto L35;
        r14 = true;
    L35:
        if (r19 == false) goto L43;
        if (r14 == false) goto L43;
        Throwable r20 = this.error;
        if (r20 == null) goto L40;
        error(r20);
        return;
    L40:
        complete();
        return;
    L30:
        r10.lazySet(null);
        return;
    L43:
        if (r13 == 0) goto L45;
        v0.y(this, r13);
    L45:
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
        this.queue.set(r5);
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
        this.queue.lazySet(null);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public boolean tryOnError(Throwable r5) {
        if (this.done == false) goto L5;
        return false;
    L5:
        if (isCancelled() == true) goto L13;
        if (r5 != null) goto L9;
        onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
    L9:
        this.error = r5;
        this.done = true;
        drain();
        return true;
    L13:
        return false;
    }
}
