package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final tc.c<? super R> downstream;
    final AtomicThrowable errors;
    final zb.h<? super T, ? extends xb.k<? extends R>> mapper;
    final int maxConcurrency;
    final AtomicReference<io.reactivex.internal.queue.a<R>> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    tc.d upstream;

    final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.j<R>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ FlowableFlatMapMaybe$FlatMapMaybeSubscriber this$0;

        InnerObserver(FlowableFlatMapMaybe$FlatMapMaybeSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xb.j
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.j
        public void onSuccess(R r10) {
            this.this$0.innerSuccess(this, r10);
        }
    }

    FlowableFlatMapMaybe$FlatMapMaybeSubscriber(tc.c<? super R> r10, zb.h<? super T, ? extends xb.k<? extends R>> r11, boolean r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.maxConcurrency = r13;
        this.requested = new AtomicLong();
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    void clear() {
        io.reactivex.internal.queue.a<R> r10 = this.queue.get();
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    void drainLoop() {
        tc.c<? super R> r10 = this.downstream;
        AtomicInteger r11 = this.active;
        AtomicReference<io.reactivex.internal.queue.a<R>> r12 = this.queue;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
        long r15 = 0;
    L4:
        boolean r16 = false;
        if (r15 == r14) goto L37;
        if (this.cancelled == true) goto L8;
        if (this.delayErrors == true) goto L17;
        if (this.errors.get() == null) goto L17;
    L14:
        Throwable r17 = this.errors.terminate();
        clear();
        r10.onError(r17);
        return;
    L17:
        if (r11.get() != 0) goto L19;
        boolean r18 = true;
    L20:
        io.reactivex.internal.queue.a<R> r19 = r12.get();
        if (r19 == null) goto L23;
        a1.c r110 = r19.poll();
    L24:
        if (r110 != null) goto L26;
        boolean r111 = true;
    L27:
        if (r18 == false) goto L34;
        if (r111 == false) goto L34;
        Throwable r20 = this.errors.terminate();
        if (r20 == null) goto L32;
        r10.onError(r20);
        return;
    L32:
        r10.onComplete();
        return;
    L34:
        if (r111 == true) goto L37;
        r10.onNext(r110);
        r15 = r15 + 1;
        goto L4
    L26:
        r111 = false;
        goto L27
    L23:
        r110 = null;
        goto L24
    L19:
        r18 = false;
        goto L20
    L8:
        clear();
        return;
    L37:
        if (r15 != r14) goto L64;
        if (this.cancelled == true) goto L40;
        if (this.delayErrors == true) goto L48;
        if (this.errors.get() != null) goto L14;
    L48:
        if (r11.get() != 0) goto L50;
        boolean r21 = true;
    L51:
        io.reactivex.internal.queue.a<R> r22 = r12.get();
        if (r22 != null) goto L54;
    L55:
        r16 = true;
    L56:
        if (r21 == false) goto L64;
        if (r16 == false) goto L64;
        Throwable r23 = this.errors.terminate();
        if (r23 == null) goto L61;
        r10.onError(r23);
        return;
    L61:
        r10.onComplete();
        return;
    L54:
        if (r22.isEmpty() == false) goto L56;
    L50:
        r21 = false;
        goto L51
    L40:
        clear();
        return;
    L64:
        if (r15 == 0) goto L68;
        io.reactivex.internal.util.b.e(this.requested, r15);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L68;
        this.upstream.request(r15);
    L68:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
    }

    io.reactivex.internal.queue.a<R> getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.a<R> r10 = this.queue.get();
        if (r10 != null) goto L4;
        io.reactivex.internal.queue.a<R> r11 = new io.reactivex.internal.queue.a(xb.e.a());
        if (this.queue.compareAndSet(null, r11) == false) goto L2;
        return r11;
    L4:
        return r10;
    }

    void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver r10) {
        this.set.c(r10);
        if (get() != 0) goto L26;
        boolean r11 = false;
        if (compareAndSet(0, 1) == false) goto L26;
        if (this.active.decrementAndGet() != 0) goto L9;
        r11 = true;
    L9:
        io.reactivex.internal.queue.a<R> r12 = this.queue.get();
        if (r11 == false) goto L20;
        if (r12 != null) goto L13;
    L14:
        Throwable r13 = this.errors.terminate();
        tc.c<? super R> r14 = this.downstream;
        if (r13 == null) goto L17;
        r14.onError(r13);
        return;
    L17:
        r14.onComplete();
        return;
    L13:
        if (r12.isEmpty() == true) goto L14;
    L20:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L23;
        this.upstream.request(1);
    L23:
        if (decrementAndGet() != 0) goto L25;
        return;
    L25:
        drainLoop();
        return;
    L26:
        this.active.decrementAndGet();
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
        this.upstream.request(1);
    L29:
        drain();
    }

    void innerError(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver r10, Throwable r11) {
        this.set.c(r10);
        if (this.errors.addThrowable(r11) == true) goto L5;
        dc.a.n(r11);
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

    void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver r10, R r11) {
        this.set.c(r10);
        if (get() != 0) goto L34;
        boolean r12 = false;
        if (compareAndSet(0, 1) == false) goto L34;
        if (this.active.decrementAndGet() != 0) goto L10;
        r12 = true;
    L10:
        if (this.requested.get() == 0) goto L24;
        this.downstream.onNext(r11);
        io.reactivex.internal.queue.a<R> r13 = this.queue.get();
        if (r12 == false) goto L21;
        if (r13 != null) goto L15;
    L16:
        Throwable r14 = this.errors.terminate();
        tc.c<? super R> r15 = this.downstream;
        if (r14 == null) goto L19;
        r15.onError(r14);
        return;
    L19:
        r15.onComplete();
        return;
    L15:
        if (r13.isEmpty() == true) goto L16;
    L21:
        io.reactivex.internal.util.b.e(this.requested, 1);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
        this.upstream.request(1);
    L29:
        if (decrementAndGet() != 0) goto L41;
        return;
    L41:
        drainLoop();
        return;
    L24:
        io.reactivex.internal.queue.a<R> r16 = getOrCreateQueue();
        monitor-enter(r16);
        r16.offer(r11);     // Catch: Throwable -> L31
        monitor-exit(r16);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L34:
        io.reactivex.internal.queue.a<R> r17 = getOrCreateQueue();
        monitor-enter(r17);
        r17.offer(r11);     // Catch: Throwable -> L43
        monitor-exit(r17);     // Catch: Throwable -> L43
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L41;
        return;
    L43:
        th = move-exception;
        throw th;
    }

    @Override // tc.c
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.set.dispose();
    L7:
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        xb.k r11 = (xb.k) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L9
        this.active.getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        r11.a(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L10;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        long r12 = Long.MAX_VALUE;
    L8:
        r10.request(r12);
        return;
    L7:
        r12 = r11;
        goto L8
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }
}
