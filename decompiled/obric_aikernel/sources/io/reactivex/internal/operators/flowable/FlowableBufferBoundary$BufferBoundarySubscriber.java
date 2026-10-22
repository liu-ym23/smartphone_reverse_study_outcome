package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -8466418554264089604L;
    final zb.h<? super Open, ? extends tc.b<? extends Close>> bufferClose;
    final tc.b<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final tc.c<? super C> downstream;
    long emitted;
    final AtomicThrowable errors;
    long index;
    final io.reactivex.internal.queue.a<C> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a subscribers;
    final AtomicReference<tc.d> upstream;

    static final class BufferOpenSubscriber<Open> extends AtomicReference<tc.d> implements xb.g<Open>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8498650778633225126L;
        final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> r10) {
            this.parent = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // tc.c
        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, r10);
        }

        @Override // tc.c
        public void onNext(Open r10) {
            this.parent.open(r10);
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    FlowableBufferBoundary$BufferBoundarySubscriber(tc.c<? super C> r10, tc.b<? extends Open> r11, zb.h<? super Open, ? extends tc.b<? extends Close>> r12, Callable<C> r13) {
        this.downstream = r10;
        this.bufferSupplier = r13;
        this.bufferOpen = r11;
        this.bufferClose = r12;
        this.queue = new io.reactivex.internal.queue.a(xb.e.a());
        this.subscribers = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap();
        this.errors = new AtomicThrowable();
    }

    void boundaryError(io.reactivex.disposables.b r10, Throwable r11) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.c(r10);
        onError(r11);
    }

    @Override // tc.d
    public void cancel() {
        if (SubscriptionHelper.cancel(this.upstream) == false) goto L15;
        this.cancelled = true;
        this.subscribers.dispose();
        monitor-enter(this);
        this.buffers = null;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (getAndIncrement() == 0) goto L18;
        this.queue.clear();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void close(FlowableBufferBoundary$BufferCloseSubscriber<T, C> r10, long r11) {
        this.subscribers.c(r10);
        if (this.subscribers.e() != 0) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        boolean r12 = true;
    L6:
        monitor-enter(this);
        Map<Long, C> r13 = this.buffers;     // Catch: Throwable -> L17
        if (r13 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L11:
        this.queue.offer(r13.remove(Long.valueOf(r11)));     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r12 == false) goto L15;
        this.done = true;
    L15:
        drain();
        return;
    L17:
        th = move-exception;
        throw th;
    L5:
        r12 = false;
        goto L6
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r10 = this.emitted;
        tc.c<? super C> r11 = this.downstream;
        io.reactivex.internal.queue.a<C> r12 = this.queue;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
    L8:
        if (r10 == r14) goto L30;
        if (this.cancelled == true) goto L11;
        boolean r15 = this.done;
        if (r15 == true) goto L16;
    L19:
        C r16 = r12.poll();
        if (r16 != null) goto L22;
        boolean r17 = true;
    L23:
        if (r15 == false) goto L27;
        if (r17 == false) goto L27;
        r11.onComplete();
        return;
    L27:
        if (r17 == true) goto L30;
        r11.onNext(r16);
        r10 = r10 + 1;
        goto L8
    L22:
        r17 = false;
        goto L23
    L16:
        if (this.errors.get() == null) goto L19;
    L17:
        r12.clear();
        r11.onError(this.errors.terminate());
        return;
    L11:
        r12.clear();
        return;
    L30:
        if (r10 == r14) goto L32;
    L44:
        this.emitted = r10;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
        return;
    L32:
        if (this.cancelled == true) goto L33;
        if (this.done == false) goto L44;
        if (this.errors.get() != null) goto L17;
        if (r12.isEmpty() == false) goto L44;
        r11.onComplete();
        return;
    L33:
        r12.clear();
    }

    @Override // tc.c
    public void onComplete() {
        this.subscribers.dispose();
        monitor-enter(this);
        Map<Long, C> r10 = this.buffers;     // Catch: Throwable -> L16
        if (r10 != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L8:
        Iterator<C> r11 = r10.values().iterator();     // Catch: Throwable -> L16
    L10:
        if (r11.hasNext() == false) goto L12;
        C r12 = r11.next();     // Catch: Throwable -> L16
        this.queue.offer(r12);     // Catch: Throwable -> L16
        goto L10
    L12:
        this.buffers = null;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.done = true;
        drain();
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L13;
        this.subscribers.dispose();
        monitor-enter(this);
        this.buffers = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.done = true;
        drain();
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        monitor-enter(this);
        Map<Long, C> r11 = this.buffers;     // Catch: Throwable -> L13
        if (r11 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L7:
        Iterator<C> r12 = r11.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r12.hasNext() == false) goto L11;
        r12.next().add(r10);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L6;
        BufferOpenSubscriber r11 = new BufferOpenSubscriber(this);
        this.subscribers.b(r11);
        this.bufferOpen.subscribe(r11);
        r10.request(Long.MAX_VALUE);
        return;
    }

    void open(Open r10) {
        Collection r11 = (Collection) io.reactivex.internal.functions.a.d(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L16
        tc.b r12 = (tc.b) io.reactivex.internal.functions.a.d(this.bufferClose.apply(r10), "The bufferClose returned a null Publisher");     // Catch: Throwable -> L16
        long r13 = this.index;
        this.index = 1 + r13;
        monitor-enter(this);
        Map<Long, C> r14 = this.buffers;     // Catch: Throwable -> L13
        if (r14 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        r14.put(Long.valueOf(r13), (C) r11);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        FlowableBufferBoundary$BufferCloseSubscriber r15 = new FlowableBufferBoundary$BufferCloseSubscriber(this, r13);
        this.subscribers.b(r15);
        r12.subscribe(r15);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        SubscriptionHelper.cancel(this.upstream);
        onError(th);
    }

    void openComplete(BufferOpenSubscriber<Open> r10) {
        this.subscribers.c(r10);
        if (this.subscribers.e() != 0) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
    }
}
