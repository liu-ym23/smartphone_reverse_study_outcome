package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
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

/* JADX INFO: loaded from: classes3.dex */
final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -8466418554264089604L;
    final pt.o bufferClose;
    final zu.b bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final zu.c downstream;
    long emitted;
    final AtomicThrowable errors;
    long index;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a subscribers;
    final AtomicReference<zu.d> upstream;

    public static final class BufferOpenSubscriber<Open> extends AtomicReference<zu.d> implements mt.g, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        public BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> r5) {
            this.parent = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // zu.c
        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        @Override // zu.c
        public void onError(Throwable r5) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, r5);
        }

        @Override // zu.c
        public void onNext(Open r5) {
            this.parent.open(r5);
        }

        @Override // zu.c
        public void onSubscribe(zu.d r5) {
            SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary$BufferBoundarySubscriber(zu.c r5, zu.b r10, pt.o r11, Callable<C> r12) {
        this.downstream = r5;
        this.bufferSupplier = r12;
        this.bufferOpen = r10;
        this.bufferClose = r11;
        this.queue = new io.reactivex.internal.queue.b(mt.e.f20168a);
        this.subscribers = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap();
        this.errors = new AtomicThrowable();
    }

    public void boundaryError(Disposable r5, Throwable r10) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.c(r5);
        onError(r10);
    }

    @Override // zu.d
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

    public void close(FlowableBufferBoundary$BufferCloseSubscriber<T, C> r5, long r10) {
        this.subscribers.c(r5);
        if (this.subscribers.d() != 0) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        boolean r11 = true;
    L6:
        monitor-enter(this);
        Map<Long, C> r12 = this.buffers;     // Catch: Throwable -> L11
        if (r12 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.queue.offer(r12.remove(Long.valueOf(r10)));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r11 == false) goto L17;
        this.done = true;
    L17:
        drain();
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r11 = false;
        goto L6
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r5 = this.emitted;
        zu.c r10 = this.downstream;
        io.reactivex.internal.queue.b r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = this.requested.get();
    L8:
        if (r5 == r13) goto L30;
        if (this.cancelled == true) goto L11;
        boolean r14 = this.done;
        if (r14 == true) goto L16;
    L19:
        Collection r15 = (Collection) r11.poll();
        if (r15 != null) goto L22;
        boolean r16 = true;
    L23:
        if (r14 == false) goto L27;
        if (r16 == false) goto L27;
        r10.onComplete();
        return;
    L27:
        if (r16 == true) goto L30;
        r10.onNext(r15);
        r5 = r5 + 1;
        goto L8
    L22:
        r16 = false;
        goto L23
    L16:
        if (this.errors.get() == null) goto L19;
        r11.clear();
        r10.onError(this.errors.terminate());
        return;
    L11:
        r11.clear();
        return;
    L30:
        if (r5 == r13) goto L32;
    L45:
        this.emitted = r5;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L6;
        return;
    L32:
        if (this.cancelled == true) goto L33;
        if (this.done == false) goto L45;
        if (this.errors.get() != null) goto L39;
        if (r11.isEmpty() == false) goto L45;
        r10.onComplete();
        return;
    L39:
        r11.clear();
        r10.onError(this.errors.terminate());
        return;
    L33:
        r11.clear();
    }

    @Override // zu.c
    public void onComplete() {
        this.subscribers.dispose();
        monitor-enter(this);
        Map<Long, C> r5 = this.buffers;     // Catch: Throwable -> L8
        if (r5 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<C> r10 = r5.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r10.hasNext() == false) goto L14;
        C r11 = r10.next();     // Catch: Throwable -> L8
        this.queue.offer(r11);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.buffers = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.done = true;
        drain();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == false) goto L13;
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
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        monitor-enter(this);
        Map<Long, C> r10 = this.buffers;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Iterator<C> r11 = r10.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (r11.hasNext() == false) goto L13;
        r11.next().add(r5);     // Catch: Throwable -> L7
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this.upstream, r5) == false) goto L6;
        BufferOpenSubscriber r10 = new BufferOpenSubscriber(this);
        this.subscribers.b(r10);
        this.bufferOpen.subscribe(r10);
        r5.request(Long.MAX_VALUE);
        return;
    }

    public void open(Open r10) {
        C r5 = this.bufferSupplier.call();     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r5, "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L17
        C r11 = r5;     // Catch: Throwable -> L17
        Object r12 = this.bufferClose.apply(r10);     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r12, "The bufferClose returned a null Publisher");     // Catch: Throwable -> L17
        zu.b r13 = (zu.b) r12;     // Catch: Throwable -> L17
        long r14 = this.index;
        this.index = 1 + r14;
        monitor-enter(this);
        Map<Long, C> r15 = this.buffers;     // Catch: Throwable -> L9
        if (r15 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        r15.put(Long.valueOf(r14), r11);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        FlowableBufferBoundary$BufferCloseSubscriber r16 = new FlowableBufferBoundary$BufferCloseSubscriber(this, r14);
        this.subscribers.b(r16);
        r13.subscribe(r16);
        return;
    L9:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        SubscriptionHelper.cancel(this.upstream);
        onError(th);
    }

    public void openComplete(BufferOpenSubscriber<Open> r5) {
        this.subscribers.c(r5);
        if (this.subscribers.d() != 0) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        v0.r(this.requested, r5);
        drain();
    }
}
