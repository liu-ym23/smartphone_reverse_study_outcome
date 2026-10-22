package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.flowable.a<T, g<T>> {
    final Callable<? extends org.a.b<B>> c;
    final int d;

    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        static final a<Object, Object> BOUNDARY_DISPOSED = null;
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<a<T, B>> boundarySubscriber;
        final int capacityHint;
        volatile boolean done;
        final org.a.c<? super g<T>> downstream;
        long emitted;
        final AtomicThrowable errors;
        final Callable<? extends org.a.b<B>> other;
        final MpscLinkedQueue<Object> queue;
        final AtomicLong requested;
        final AtomicBoolean stopWindows;
        org.a.d upstream;
        UnicastProcessor<T> window;
        final AtomicInteger windows;

        static {
            BOUNDARY_DISPOSED = new a(null);
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainSubscriber(org.a.c<? super g<T>> r3, int r4, Callable<? extends org.a.b<B>> r5) {
            org.a.c<? super g<T>> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            Callable<? extends org.a.b<B>> r7 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.capacityHint = r4;
            this.boundarySubscriber = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = r7;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            disposeBoundary();
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.cancel();
            return;
        L9:
            return;
        }

        void disposeBoundary() {
            AtomicReference<a<T, B>> r3 = this.boundarySubscriber;
            a<Object, Object> r0 = BOUNDARY_DISPOSED;
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3.getAndSet((a<T, B>) r0), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            if (r4 == r0) goto L8;
            r4.dispose();
            return;
        L8:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super g<T>> r0 = this.downstream;
            MpscLinkedQueue<Object> r1 = this.queue;
            AtomicThrowable r2 = this.errors;
            long r3 = this.emitted;
            int r6 = 1;
        L7:
            if (this.windows.get() == 0) goto L8;
            UnicastProcessor<T> r7 = this.window;
            boolean r9 = this.done;
            if (r9 == true) goto L13;
        L19:
            Object r10 = r1.poll();
            if (r10 != null) goto L22;
            boolean r11 = true;
        L23:
            if (r9 == false) goto L34;
            if (r11 == false) goto L34;
            Throwable r4 = r2.terminate();
            if (r4 != null) goto L30;
            if (r7 == null) goto L29;
            this.window = null;
            r7.onComplete();
        L29:
            r0.onComplete();
            return;
        L30:
            if (r7 == null) goto L32;
            this.window = null;
            r7.onError(r4);
        L32:
            r0.onError(r4);
            return;
        L34:
            if (r11 == true) goto L35;
            if (r10 != NEXT_WINDOW) goto L40;
            if (r7 == null) goto L44;
            this.window = null;
            r7.onComplete();
        L44:
            if (this.stopWindows.get() == true) goto L7;
            if (r3 == this.requested.get()) goto L55;
            UnicastProcessor<T> r8 = UnicastProcessor.a(this.capacityHint, this);
            this.window = r8;
            this.windows.getAndIncrement();
            org.a.b r12 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.other.call(), "The other Callable returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
            a<T, B> r13 = new a(this);
            if (this.boundarySubscriber.compareAndSet(null, r13) == false) goto L7;
            r12.subscribe(r13);
            r3 = r3 + 1;
            r0.onNext(r8);
        L52:
            MissingBackpressureException th = th;
            io.reactivex.exceptions.a.a(th);
        L54:
            r2.addThrowable(th);
            this.done = true;
            goto L7
        L55:
            this.upstream.cancel();
            disposeBoundary();
            th = new MissingBackpressureException("Could not deliver a window due to lack of requests");
            goto L54
        L40:
            r7.onNext((T) r10);
            goto L7
        L35:
            this.emitted = r3;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L7;
            return;
        L22:
            r11 = false;
            goto L23
        L13:
            if (r2.get() == null) goto L19;
            r1.clear();
            Throwable r5 = r2.terminate();
            if (r7 == null) goto L17;
            this.window = null;
            r7.onError(r5);
        L17:
            r0.onError(r5);
            return;
        L8:
            r1.clear();
            this.window = null;
        }

        void innerComplete() {
            this.upstream.cancel();
            this.done = true;
            drain();
        }

        void innerError(Throwable r2) {
            this.upstream.cancel();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void innerNext(a<T, B> r3) {
            this.boundarySubscriber.compareAndSet(r3, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            disposeBoundary();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            this.queue.offer(NEXT_WINDOW);
            drain();
            r4.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.a.d
        public void request(long r1) {
            io.reactivex.internal.util.b.a(this.requested, r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    static final class a<T, B> extends io.reactivex.subscribers.a<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowBoundaryMainSubscriber<T, B> f16806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f16807b;

        a(WindowBoundaryMainSubscriber<T, B> r1) {
            this.f16806a = r1;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.f16807b == false) goto L5;
            return;
        L5:
            this.f16807b = true;
            this.f16806a.innerComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.f16807b == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.f16807b = true;
            this.f16806a.innerError(r2);
        }

        @Override // org.a.c
        public void onNext(B r1) {
            if (this.f16807b == false) goto L5;
            return;
        L5:
            this.f16807b = true;
            dispose();
            this.f16806a.innerNext(this);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super g<T>> r4) {
        WindowBoundaryMainSubscriber r0 = new WindowBoundaryMainSubscriber((org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin"), this.d, this.c);
        this.f16812b.a(r0);
    }
}
