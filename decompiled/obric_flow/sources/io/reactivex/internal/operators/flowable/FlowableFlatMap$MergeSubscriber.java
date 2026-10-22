package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements mt.g, zu.d {
    static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = null;
    static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = null;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final zu.c downstream;
    final AtomicThrowable errs;
    long lastId;
    int lastIndex;
    final pt.o mapper;
    final int maxConcurrency;
    volatile rt.g queue;
    final AtomicLong requested;
    int scalarEmitted;
    final int scalarLimit;
    final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers;
    long uniqueId;
    zu.d upstream;

    static {
        EMPTY = new FlowableFlatMap$InnerSubscriber[0];
        CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    }

    public FlowableFlatMap$MergeSubscriber(zu.c r5, pt.o r10, boolean r11, int r12, int r13) {
        this.errs = new AtomicThrowable();
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> r14 = new AtomicReference();
        this.subscribers = r14;
        this.requested = new AtomicLong();
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.maxConcurrency = r12;
        this.bufferSize = r13;
        this.scalarLimit = Math.max(1, r12 >> 1);
        r14.lazySet(EMPTY);
    }

    public boolean addInner(FlowableFlatMap$InnerSubscriber<T, U> r5) {
    L2:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r10 = this.subscribers.get();
        if (r10 == CANCELLED) goto L4;
        int r11 = r10.length;
        FlowableFlatMap$InnerSubscriber[] r12 = new FlowableFlatMap$InnerSubscriber[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> r13 = this.subscribers;
    L8:
        if (r13.compareAndSet(r10, (FlowableFlatMap$InnerSubscriber<?, ?>[]) r12) == true) goto L9;
        if (r13.get() == r10) goto L8;
    L9:
        return true;
    L4:
        r5.dispose();
        return false;
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L10;
        this.cancelled = true;
        this.upstream.cancel();
        disposeAll();
        if (getAndIncrement() != 0) goto L11;
        rt.g r5 = this.queue;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L11:
        return;
    }

    public boolean checkTerminate() {
        if (this.cancelled == false) goto L7;
        clearScalarQueue();
        return true;
    L7:
        if (this.delayErrors == false) goto L9;
        return false;
    L9:
        if (this.errs.get() == null) goto L16;
        clearScalarQueue();
        Throwable r5 = this.errs.terminate();
        if (r5 == io.reactivex.internal.util.d.f18173a) goto L13;
        this.downstream.onError(r5);
    L13:
        return true;
    L16:
        return false;
    }

    public void clearScalarQueue() {
        rt.g r5 = this.queue;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber<?, ?>[] r5 = this.subscribers.get();
        FlowableFlatMap$InnerSubscriber<?, ?>[] r10 = CANCELLED;
        if (r5 == r10) goto L16;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r11 = this.subscribers.getAndSet(r10);
        if (r11 == r10) goto L17;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r11[r13].dispose();
        r13 = r13 + 1;
        goto L7
    L9:
        Throwable r14 = this.errs.terminate();
        if (r14 != null) goto L12;
        return;
    L12:
        if (r14 == io.reactivex.internal.util.d.f18173a) goto L19;
        wn.f.k(r14);
        return;
    L19:
        return;
    L17:
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainLoop() {
        zu.c r5 = this.downstream;
        int r10 = 1;
    L4:
        if (checkTerminate() == true) goto L5;
        rt.g r11 = this.queue;
        long r12 = this.requested.get();
        if (r12 != Long.MAX_VALUE) goto L9;
        boolean r13 = true;
    L10:
        long r14 = 0;
        long r16 = 0;
        if (r11 == null) goto L31;
    L12:
        long r15 = 0;
        Object r18 = null;
    L14:
        if (r12 == 0) goto L22;
        Object r17 = r11.poll();
        if (checkTerminate() == true) goto L17;
        if (r17 == null) goto L19;
        r5.onNext(r17);
        r16 = r16 + 1;
        r15 = r15 + 1;
        r12 = r12 - 1;
        r18 = r17;
        goto L14
    L19:
        r18 = r17;
        goto L22
    L17:
        return;
    L22:
        if (r15 == 0) goto L27;
        if (r13 == false) goto L25;
        r12 = Long.MAX_VALUE;
        goto L27
    L25:
        r12 = this.requested.addAndGet(-r15);
    L27:
        if (r12 == 0) goto L31;
        if (r18 != null) goto L12;
    L31:
        boolean r19 = this.done;
        rt.g r20 = this.queue;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r21 = this.subscribers.get();
        int r110 = r21.length;
        if (r19 == false) goto L43;
        if (r20 != null) goto L35;
    L36:
        if (r110 != 0) goto L43;
        Throwable r22 = this.errs.terminate();
        if (r22 == io.reactivex.internal.util.d.f18173a) goto L168;
        if (r22 != null) goto L41;
        r5.onComplete();
        return;
    L41:
        r5.onError(r22);
        return;
    L168:
        return;
    L35:
        if (r20.isEmpty() == true) goto L36;
    L43:
        int r111 = r10;
        if (r110 == 0) goto L124;
        long r23 = this.lastId;
        int r24 = this.lastIndex;
        if (r110 > r24) goto L48;
    L49:
        if (r110 > r24) goto L51;
        r24 = 0;
    L51:
        int r25 = 0;
    L52:
        if (r25 >= r110) goto L60;
        if (r21[r24].f17646id == r23) goto L60;
        r24 = r24 + 1;
        if (r24 != r110) goto L59;
        r24 = 0;
    L59:
        r25 = r25 + 1;
    L60:
        this.lastIndex = r24;
        this.lastId = r21[r24].f17646id;
    L61:
        int r26 = r24;
        boolean r27 = false;
        int r28 = 0;
    L62:
        if (r28 >= r110) goto L122;
        if (checkTerminate() == true) goto L65;
        FlowableFlatMap$InnerSubscriber<T, U> r29 = r21[r26];
        Object r112 = null;
    L68:
        if (checkTerminate() == true) goto L69;
        rt.h r113 = r29.queue;
        if (r113 == null) goto L72;
        int r114 = r110;
        Object r210 = r112;
        long r115 = r14;
    L75:
        if (r12 == r14) goto L92;
        Object r116 = r113.poll();     // Catch: Throwable -> L83
        if (r116 == null) goto L78;
        r5.onNext(r116);
        if (checkTerminate() == true) goto L81;
        r12 = r12 - 1;
        r115 = r115 + 1;
        r210 = r116;
        r14 = 0;
        goto L75
    L81:
        return;
    L78:
        r210 = r116;
        r14 = 0;
    L83:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r29.dispose();
        this.errs.addThrowable(th);
        if (this.delayErrors == true) goto L88;
        this.upstream.cancel();
    L88:
        if (checkTerminate() == true) goto L89;
        removeInner(r29);
        r28 = r28 + 1;
        r27 = true;
        int r30 = 1;
    L121:
        r28 = r28 + r30;
        r110 = r114;
        r14 = 0;
        goto L62
    L89:
        return;
    L92:
        if (r115 == r14) goto L97;
        if (r13 == true) goto L95;
        r12 = this.requested.addAndGet(-r115);
    L96:
        r29.requestMore(r115);
        long r117 = 0;
    L99:
        if (r12 == r117) goto L103;
        if (r210 == null) goto L103;
        r110 = r114;
        r112 = r210;
        r14 = 0;
    L103:
        boolean r118 = r29.done;
        rt.h r119 = r29.queue;
        if (r118 == false) goto L115;
        if (r119 != null) goto L107;
    L110:
        removeInner(r29);
        if (checkTerminate() == true) goto L112;
        r16 = r16 + 1;
        r27 = true;
        goto L115
    L112:
        return;
    L107:
        if (r119.isEmpty() == true) goto L110;
    L115:
        if (r12 == 0) goto L116;
        r26 = r26 + 1;
        if (r26 != r114) goto L120;
        r26 = 0;
    L120:
        r30 = 1;
        goto L121
    L116:
        boolean r120 = r27;
    L123:
        this.lastIndex = r26;
        this.lastId = r21[r26].f17646id;
        long r31 = r16;
        long r32 = 0;
    L126:
        if (r31 != r32) goto L128;
    L130:
        if (r120 == true) goto L131;
        r10 = addAndGet(-r111);
        if (r10 != 0) goto L4;
        return;
    L131:
        r10 = r111;
        goto L4
    L128:
        if (this.cancelled == true) goto L130;
        this.upstream.request(r31);
        goto L130
    L95:
        r12 = Long.MAX_VALUE;
        goto L96
    L97:
        r117 = r14;
        goto L99
    L72:
        r114 = r110;
        goto L103
    L69:
        return;
    L65:
        return;
    L122:
        r120 = r27;
        goto L123
    L48:
        if (r21[r24].f17646id == r23) goto L61;
    L124:
        r32 = 0;
        r31 = r16;
        r120 = false;
        goto L126
    L9:
        r13 = false;
        goto L10
    }

    public rt.h getInnerQueue(FlowableFlatMap$InnerSubscriber<T, U> r5) {
        rt.h r10 = r5.queue;
        if (r10 != null) goto L6;
        SpscArrayQueue r11 = new SpscArrayQueue(this.bufferSize);
        r5.queue = r11;
        return r11;
    L6:
        return r10;
    }

    public rt.h getMainQueue() {
        rt.g r5 = this.queue;
        if (r5 == null) goto L5;
    L9:
        return r5;
    L5:
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L7;
        r5 = new io.reactivex.internal.queue.b(this.bufferSize);
    L8:
        this.queue = r5;
        goto L9
    L7:
        r5 = new SpscArrayQueue(this.maxConcurrency);
        goto L8
    }

    public void innerError(FlowableFlatMap$InnerSubscriber<T, U> r5, Throwable r10) {
        if (this.errs.addThrowable(r10) == false) goto L10;
        r5.done = true;
        if (this.delayErrors == true) goto L9;
        this.upstream.cancel();
        FlowableFlatMap$InnerSubscriber<?, ?>[] r11 = this.subscribers.getAndSet(CANCELLED);
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r11[r13].dispose();
        r13 = r13 + 1;
    L9:
        drain();
        return;
    L10:
        wn.f.k(r10);
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
        if (this.done == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        if (this.errs.addThrowable(r5) == false) goto L9;
        this.done = true;
        drain();
        return;
    L9:
        wn.f.k(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L30;
        return;
    L30:
        Object r11 = this.mapper.apply(r10);     // Catch: Throwable -> L25
        io.reactivex.internal.functions.e.d(r11, "The mapper returned a null Publisher");     // Catch: Throwable -> L25
        zu.b r12 = (zu.b) r11;     // Catch: Throwable -> L25
        if ((r12 instanceof Callable) == true) goto L28;
        long r5 = this.uniqueId;
        this.uniqueId = 1 + r5;
        FlowableFlatMap$InnerSubscriber r13 = new FlowableFlatMap$InnerSubscriber(this, r5);
        if (addInner(r13) == false) goto L37;
        r12.subscribe(r13);
        return;
    L37:
        return;
    L28:
        Object r14 = ((Callable) r12).call();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        tryEmitScalar(r14);
        return;
    L12:
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L14;
        return;
    L14:
        if (this.cancelled == true) goto L34;
        int r15 = this.scalarEmitted + 1;
        this.scalarEmitted = r15;
        int r16 = this.scalarLimit;
        if (r15 != r16) goto L35;
        this.scalarEmitted = 0;
        this.upstream.request(r16);
        return;
    L35:
        return;
    L34:
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errs.addThrowable(th);
        drain();
        return;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L11;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        if (this.cancelled == true) goto L12;
        int r10 = this.maxConcurrency;
        if (r10 != Integer.MAX_VALUE) goto L9;
        r5.request(Long.MAX_VALUE);
        return;
    L9:
        r5.request(r10);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> r10) {
    L2:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r5 = this.subscribers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L4;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12] == r10) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r13 = EMPTY;
    L18:
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> r14 = this.subscribers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L21;
        if (r14.get() == r5) goto L20;
    L21:
        return;
    L17:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r15 = new FlowableFlatMap$InnerSubscriber[r11 - 1];
        System.arraycopy(r5, 0, r15, 0, r12);
        System.arraycopy(r5, r12 + 1, r15, r12, (r11 - r12) - 1);
        r13 = r15;
        goto L18
    L13:
        return;
    L11:
        r12 = -1;
        goto L12
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }

    public void tryEmit(U r10, FlowableFlatMap$InnerSubscriber<T, U> r11) {
        if (get() == 0) goto L5;
    L24:
        rt.h r5 = r11.queue;
        if (r5 != null) goto L28;
        r5 = new SpscArrayQueue(this.bufferSize);
        r11.queue = r5;
    L28:
        if (r5.offer(r10) == true) goto L32;
        onError(new MissingBackpressureException("Inner queue full?!"));
        return;
    L32:
        if (getAndIncrement() == 0) goto L34;
        return;
    L34:
        drainLoop();
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L24;
        long r12 = this.requested.get();
        rt.h r13 = r11.queue;
        if (r12 == 0) goto L15;
        if (r13 != null) goto L10;
    L11:
        this.downstream.onNext(r10);
        if (r12 == Long.MAX_VALUE) goto L14;
        this.requested.decrementAndGet();
    L14:
        r11.requestMore(1);
    L22:
        if (decrementAndGet() != 0) goto L34;
        return;
    L10:
        if (r13.isEmpty() == true) goto L11;
    L15:
        if (r13 != null) goto L18;
        r13 = getInnerQueue(r11);
    L18:
        if (r13.offer(r10) == true) goto L22;
        onError(new MissingBackpressureException("Inner queue full?!"));
    }

    public void tryEmitScalar(U r10) {
        if (get() != 0) goto L31;
        if (compareAndSet(0, 1) == false) goto L31;
        long r5 = this.requested.get();
        rt.h r11 = this.queue;
        if (r5 == 0) goto L21;
        if (r11 != null) goto L10;
    L11:
        this.downstream.onNext(r10);
        if (r5 == Long.MAX_VALUE) goto L15;
        this.requested.decrementAndGet();
    L15:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L28;
        if (this.cancelled == true) goto L28;
        int r12 = this.scalarEmitted + 1;
        this.scalarEmitted = r12;
        int r13 = this.scalarLimit;
        if (r12 != r13) goto L28;
        this.scalarEmitted = 0;
        this.upstream.request(r13);
    L28:
        if (decrementAndGet() != 0) goto L37;
        return;
    L37:
        drainLoop();
        return;
    L10:
        if (r11.isEmpty() == true) goto L11;
    L21:
        if (r11 != null) goto L24;
        r11 = getMainQueue();
    L24:
        if (r11.offer(r10) == true) goto L28;
        onError(new IllegalStateException("Scalar queue full?!"));
        return;
    L31:
        if (getMainQueue().offer(r10) == true) goto L35;
        onError(new IllegalStateException("Scalar queue full?!"));
        return;
    L35:
        if (getAndIncrement() == 0) goto L37;
    }
}
