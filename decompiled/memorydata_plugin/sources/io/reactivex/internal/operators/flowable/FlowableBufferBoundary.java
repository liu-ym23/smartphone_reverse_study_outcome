package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {
    final Callable<U> c;
    final org.a.b<? extends Open> d;
    final h<? super Open, ? extends org.a.b<? extends Close>> e;

    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -8466418554264089604L;
        final h<? super Open, ? extends org.a.b<? extends Close>> bufferClose;
        final org.a.b<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers;
        volatile boolean cancelled;
        volatile boolean done;
        final org.a.c<? super C> downstream;
        long emitted;
        final AtomicThrowable errors;
        long index;
        final io.reactivex.internal.queue.a<C> queue;
        final AtomicLong requested;
        final io.reactivex.disposables.a subscribers;
        final AtomicReference<org.a.d> upstream;

        static final class BufferOpenSubscriber<Open> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Open> {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> r1) {
                this.parent = r1;
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

            @Override // org.a.c
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // org.a.c
            public void onError(Throwable r2) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, r2);
            }

            @Override // org.a.c
            public void onNext(Open r1) {
                this.parent.open(r1);
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(org.a.d r3) {
                SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
            }
        }

        BufferBoundarySubscriber(org.a.c<? super C> r3, org.a.b<? extends Open> r4, h<? super Open, ? extends org.a.b<? extends Close>> r5, Callable<C> r6) {
            org.a.c<? super C> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<? extends Open> r8 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            h<? super Open, ? extends org.a.b<? extends Close>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Callable<C> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.bufferSupplier = r10;
            this.bufferOpen = r8;
            this.bufferClose = r9;
            this.queue = new io.reactivex.internal.queue.a(g.a());
            this.subscribers = new io.reactivex.disposables.a();
            this.requested = new AtomicLong();
            this.upstream = new AtomicReference();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        void boundaryError(io.reactivex.disposables.b r3, Throwable r4) {
            io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.delete(r5);
            onError(r4);
        }

        @Override // org.a.d
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

        void close(BufferCloseSubscriber<T, C> r4, long r5) {
            this.subscribers.delete(r4);
            if (this.subscribers.a() != 0) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            boolean r6 = true;
        L6:
            monitor-enter(this);
            Map<Long, C> r1 = this.buffers;     // Catch: Throwable -> L17
            if (r1 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L11:
            this.queue.offer(r1.remove(Long.valueOf(r5)));     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            if (r6 == false) goto L15;
            this.done = true;
        L15:
            drain();
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            r6 = false;
            goto L6
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            long r0 = this.emitted;
            org.a.c<? super C> r2 = this.downstream;
            io.reactivex.internal.queue.a<C> r3 = this.queue;
            int r5 = 1;
        L6:
            long r6 = this.requested.get();
        L8:
            if (r0 == r6) goto L30;
            if (this.cancelled == true) goto L11;
            boolean r9 = this.done;
            if (r9 == true) goto L16;
        L19:
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r3.poll(), Collection.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L22;
            boolean r11 = true;
        L23:
            if (r9 == false) goto L27;
            if (r11 == false) goto L27;
            r2.onComplete();
            return;
        L27:
            if (r11 == true) goto L30;
            r2.onNext(r10);
            r0 = r0 + 1;
            goto L8
        L22:
            r11 = false;
            goto L23
        L16:
            if (this.errors.get() == null) goto L19;
        L17:
            r3.clear();
            r2.onError(this.errors.terminate());
            return;
        L11:
            r3.clear();
            return;
        L30:
            if (r0 == r6) goto L32;
        L44:
            this.emitted = r0;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L6;
            return;
        L32:
            if (this.cancelled == true) goto L33;
            if (this.done == false) goto L44;
            if (this.errors.get() != null) goto L17;
            if (r3.isEmpty() == false) goto L44;
            r2.onComplete();
            return;
        L33:
            r3.clear();
        }

        @Override // org.a.c
        public void onComplete() {
            this.subscribers.dispose();
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L16
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L8:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L12;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1.next(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            this.queue.offer((C) r2);     // Catch: Throwable -> L16
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

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L13;
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
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L13
        L9:
            if (r1.hasNext() == false) goto L11;
            ((Collection) ZeusTransformUtils.preCheckCast(r1.next(), Collection.class, "com.obric.memorydata.plugin")).add(r5);     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.upstream, r4) == false) goto L6;
            BufferOpenSubscriber r0 = new BufferOpenSubscriber(this);
            this.subscribers.a(r0);
            this.bufferOpen.subscribe(r0);
            r4.request(Long.MAX_VALUE);
            return;
        }

        void open(Open r6) {
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            org.a.b r7 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferClose.apply(r6), "The bufferClose returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            long r1 = this.index;
            this.index = 1 + r1;
            monitor-enter(this);
            Map<Long, C> r3 = this.buffers;     // Catch: Throwable -> L13
            if (r3 != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L9:
            r3.put(Long.valueOf(r1), (C) r0);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            BufferCloseSubscriber r2 = new BufferCloseSubscriber(this, r1);
            this.subscribers.a(r2);
            r7.subscribe(r2);
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

        void openComplete(BufferOpenSubscriber<Open> r2) {
            this.subscribers.delete(r2);
            if (this.subscribers.a() != 0) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
        }
    }

    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundarySubscriber<T, C, ?, ?> parent;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> r1, long r2) {
            this.parent = r1;
            this.index = r2;
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

        @Override // org.a.c
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.close(this, this.index);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // org.a.c
        public void onNext(Object r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin");
            if (r4 == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            r4.cancel();
            this.parent.close(this, this.index);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super U> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        BufferBoundarySubscriber r0 = new BufferBoundarySubscriber(r6, this.d, this.e, this.c);
        r6.onSubscribe(r0);
        this.f16812b.a(r0);
    }
}
