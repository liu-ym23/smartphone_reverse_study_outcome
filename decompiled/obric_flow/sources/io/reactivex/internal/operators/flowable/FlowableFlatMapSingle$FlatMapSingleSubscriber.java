package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final zu.c downstream;
    final AtomicThrowable errors;
    final pt.o mapper;
    final int maxConcurrency;
    final AtomicReference<io.reactivex.internal.queue.b> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    zu.d upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements b0, Disposable {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ FlowableFlatMapSingle$FlatMapSingleSubscriber this$0;

        public InnerObserver(FlowableFlatMapSingle$FlatMapSingleSubscriber r5) {
            this.this$0 = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.this$0.innerError(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(R r5) {
            this.this$0.innerSuccess(this, r5);
        }
    }

    public FlowableFlatMapSingle$FlatMapSingleSubscriber(zu.c r5, pt.o r10, boolean r11, int r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.maxConcurrency = r12;
        this.requested = new AtomicLong();
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
        io.reactivex.internal.queue.b r5 = this.queue.get();
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        zu.c r5 = this.downstream;
        AtomicInteger r10 = this.active;
        AtomicReference<io.reactivex.internal.queue.b> r11 = this.queue;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
        long r14 = 0;
    L4:
        boolean r15 = false;
        if (r14 == r13) goto L37;
        if (this.cancelled == true) goto L8;
        if (this.delayErrors == true) goto L17;
        if (this.errors.get() == null) goto L17;
        Throwable r16 = this.errors.terminate();
        clear();
        r5.onError(r16);
        return;
    L17:
        if (r10.get() != 0) goto L19;
        boolean r17 = true;
    L20:
        io.reactivex.internal.queue.b r18 = r11.get();
        if (r18 == null) goto L23;
        Object r19 = r18.poll();
    L24:
        if (r19 != null) goto L26;
        boolean r110 = true;
    L27:
        if (r17 == false) goto L34;
        if (r110 == false) goto L34;
        Throwable r20 = this.errors.terminate();
        if (r20 == null) goto L32;
        r5.onError(r20);
        return;
    L32:
        r5.onComplete();
        return;
    L34:
        if (r110 == true) goto L37;
        r5.onNext(r19);
        r14 = r14 + 1;
        goto L4
    L26:
        r110 = false;
        goto L27
    L23:
        r19 = null;
        goto L24
    L19:
        r17 = false;
        goto L20
    L8:
        clear();
        return;
    L37:
        if (r14 != r13) goto L65;
        if (this.cancelled == true) goto L40;
        if (this.delayErrors == true) goto L49;
        if (this.errors.get() == null) goto L49;
        Throwable r21 = this.errors.terminate();
        clear();
        r5.onError(r21);
        return;
    L49:
        if (r10.get() != 0) goto L51;
        boolean r22 = true;
    L52:
        io.reactivex.internal.queue.b r23 = r11.get();
        if (r23 != null) goto L55;
    L56:
        r15 = true;
    L57:
        if (r22 == false) goto L65;
        if (r15 == false) goto L65;
        Throwable r24 = this.errors.terminate();
        if (r24 == null) goto L62;
        r5.onError(r24);
        return;
    L62:
        r5.onComplete();
        return;
    L55:
        if (r23.isEmpty() == false) goto L57;
    L51:
        r22 = false;
        goto L52
    L40:
        clear();
        return;
    L65:
        if (r14 == 0) goto L69;
        v0.y(this.requested, r14);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L69;
        this.upstream.request(r14);
    L69:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
    }

    public io.reactivex.internal.queue.b getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.b r5 = this.queue.get();
        if (r5 != null) goto L4;
        io.reactivex.internal.queue.b r10 = new io.reactivex.internal.queue.b(mt.e.f20168a);
        AtomicReference<io.reactivex.internal.queue.b> r11 = this.queue;
    L7:
        if (r11.compareAndSet(null, r10) == true) goto L8;
        if (r11.get() == null) goto L7;
    L8:
        return r10;
    L4:
        return r5;
    }

    public void innerError(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver r5, Throwable r10) {
        this.set.c(r5);
        if (this.errors.addThrowable(r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L8;
        this.upstream.cancel();
        this.set.dispose();
    L10:
        this.active.decrementAndGet();
        drain();
        return;
    L8:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L10;
        this.upstream.request(1);
        goto L10
    }

    public void innerSuccess(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver r5, R r10) {
        this.set.c(r5);
        if (get() != 0) goto L34;
        boolean r11 = false;
        if (compareAndSet(0, 1) == false) goto L34;
        if (this.active.decrementAndGet() != 0) goto L10;
        r11 = true;
    L10:
        if (this.requested.get() == 0) goto L24;
        this.downstream.onNext(r10);
        io.reactivex.internal.queue.b r12 = this.queue.get();
        if (r11 == false) goto L21;
        if (r12 != null) goto L15;
    L16:
        Throwable r13 = this.errors.terminate();
        if (r13 == null) goto L19;
        this.downstream.onError(r13);
        return;
    L19:
        this.downstream.onComplete();
        return;
    L15:
        if (r12.isEmpty() == true) goto L16;
    L21:
        v0.y(this.requested, 1);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
        this.upstream.request(1);
    L29:
        if (decrementAndGet() != 0) goto L41;
        return;
    L41:
        drainLoop();
        return;
    L24:
        io.reactivex.internal.queue.b r14 = getOrCreateQueue();
        monitor-enter(r14);
        r14.offer(r10);     // Catch: Throwable -> L31
        monitor-exit(r14);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L34:
        io.reactivex.internal.queue.b r15 = getOrCreateQueue();
        monitor-enter(r15);
        r15.offer(r10);     // Catch: Throwable -> L43
        monitor-exit(r15);     // Catch: Throwable -> L43
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L41;
        return;
    L43:
        th = move-exception;
        throw th;
    }

    @Override // zu.c
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.set.dispose();
    L7:
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
        c0 r11 = (c0) r10;     // Catch: Throwable -> L9
        this.active.getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        ((a0) r11).b(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L9;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        int r10 = this.maxConcurrency;
        if (r10 != Integer.MAX_VALUE) goto L7;
        r5.request(Long.MAX_VALUE);
        return;
    L7:
        r5.request(r10);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
