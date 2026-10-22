package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements mt.g, zu.d {
    static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED = null;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final zu.c downstream;
    final AtomicThrowable error;
    final pt.o mapper;
    final AtomicLong requested;
    volatile long unique;
    zu.d upstream;

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> r5 = new FlowableSwitchMap$SwitchMapInnerSubscriber(null, -1, 1);
        CANCELLED = r5;
        r5.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(zu.c r5, pt.o r10, int r11, boolean r12) {
        this.active = new AtomicReference();
        this.requested = new AtomicLong();
        this.downstream = r5;
        this.mapper = r10;
        this.bufferSize = r11;
        this.delayErrors = r12;
        this.error = new AtomicThrowable();
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
        return;
    }

    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r5 = this.active.get();
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> r10 = CANCELLED;
        if (r5 == r10) goto L9;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r11 = this.active.getAndSet((FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>) r10);
        if (r11 == r10) goto L10;
        if (r11 == null) goto L11;
        r11.cancel();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        int r10 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.done == true) goto L13;
    L29:
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r11 = this.active.get();
        if (r11 == null) goto L32;
        rt.h r12 = r11.queue;
    L33:
        if (r12 == null) goto L113;
        if (r11.done == false) goto L60;
        if (this.delayErrors == false) goto L39;
        if (r12.isEmpty() == false) goto L60;
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r13 = this.active;
    L55:
        if (r13.compareAndSet(r11, null) == true) goto L7;
        if (r13.get() == r11) goto L55;
    L39:
        if (this.error.get() != null) goto L40;
        if (r12.isEmpty() == false) goto L60;
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r14 = this.active;
    L46:
        if (r14.compareAndSet(r11, null) == true) goto L7;
        if (r14.get() == r11) goto L46;
    L40:
        disposeInner();
        r5.onError(this.error.terminate());
        return;
    L60:
        long r15 = this.requested.get();
        long r16 = 0;
    L61:
        boolean r17 = false;
        if (r16 == r15) goto L104;
        if (this.cancelled == true) goto L65;
        boolean r18 = r11.done;
        Object r19 = r12.poll();     // Catch: Throwable -> L69
    L71:
        if (r19 != null) goto L73;
        boolean r110 = true;
    L75:
        if (r11 != this.active.get()) goto L76;
        if (r18 == true) goto L79;
    L100:
        if (r110 == true) goto L104;
        r5.onNext(r19);
        r16 = r16 + 1;
        goto L61
    L79:
        if (this.delayErrors == false) goto L81;
        if (r110 == false) goto L100;
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r20 = this.active;
    L95:
        if (r20.compareAndSet(r11, null) == true) goto L76;
        if (r20.get() == r11) goto L95;
    L81:
        if (this.error.get() != null) goto L82;
        if (r110 == false) goto L100;
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r21 = this.active;
    L87:
        if (r21.compareAndSet(r11, null) == true) goto L76;
        if (r21.get() == r11) goto L87;
    L82:
        r5.onError(this.error.terminate());
        return;
    L76:
        r17 = true;
        goto L104
    L73:
        r110 = false;
    L69:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.cancel();
        this.error.addThrowable(th);
        r19 = null;
        r18 = true;
        goto L71
    L65:
        return;
    L104:
        if (r16 != 0) goto L106;
    L111:
        if (r17 == false) goto L113;
    L106:
        if (this.cancelled == true) goto L111;
        if (r15 == Long.MAX_VALUE) goto L110;
        this.requested.addAndGet(-r16);
    L110:
        r11.get().request(r16);
    L113:
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L7;
        return;
    L32:
        r12 = null;
        goto L33
    L13:
        if (this.delayErrors == false) goto L22;
        if (this.active.get() != null) goto L29;
        if (this.error.get() == null) goto L19;
        r5.onError(this.error.terminate());
        return;
    L19:
        r5.onComplete();
        return;
    L22:
        if (this.error.get() != null) goto L23;
        if (this.active.get() != null) goto L29;
        r5.onComplete();
        return;
    L23:
        disposeInner();
        r5.onError(this.error.terminate());
        return;
    L8:
        this.active.lazySet(null);
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L5;
    L10:
        wn.f.k(r5);
        return;
    L5:
        if (this.error.addThrowable(r5) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        disposeInner();
    L9:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r10 = this.unique + 1;
        this.unique = r10;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r11 = this.active.get();
        if (r11 == null) goto L24;
        r11.cancel();
    L24:
        Object r12 = this.mapper.apply(r5);     // Catch: Throwable -> L21
        io.reactivex.internal.functions.e.d(r12, "The publisher returned is null");     // Catch: Throwable -> L21
        zu.b r13 = (zu.b) r12;     // Catch: Throwable -> L21
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r14 = new FlowableSwitchMap$SwitchMapInnerSubscriber(this, r10, this.bufferSize);
    L10:
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r15 = this.active.get();
        if (r15 == CANCELLED) goto L30;
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r16 = this.active;
    L15:
        if (r16.compareAndSet(r15, r14) == true) goto L16;
        if (r16.get() == r15) goto L15;
    L16:
        r13.subscribe(r14);
        return;
    L30:
        return;
    L21:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L9;
        v0.r(this.requested, r5);
        if (this.unique != 0) goto L7;
        this.upstream.request(Long.MAX_VALUE);
        return;
    L7:
        drain();
        return;
    }
}
