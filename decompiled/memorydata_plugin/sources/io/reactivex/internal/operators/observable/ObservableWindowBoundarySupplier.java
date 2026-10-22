package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.s;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.observable.a<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends s<B>> f17022b;
    final int c;

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.disposables.b, t<T>, Runnable {
        static final a<Object, Object> BOUNDARY_DISPOSED = null;
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<a<T, B>> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final t<? super Observable<T>> downstream;
        final AtomicThrowable errors;
        final Callable<? extends s<B>> other;
        final MpscLinkedQueue<Object> queue;
        final AtomicBoolean stopWindows;
        io.reactivex.disposables.b upstream;
        UnicastSubject<T> window;
        final AtomicInteger windows;

        static {
            BOUNDARY_DISPOSED = new a(null);
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainObserver(t<? super Observable<T>> r3, int r4, Callable<? extends s<B>> r5) {
            t<? super Observable<T>> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            Callable<? extends s<B>> r7 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.capacityHint = r4;
            this.boundaryObserver = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = r7;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            disposeBoundary();
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        L9:
            return;
        }

        void disposeBoundary() {
            AtomicReference<a<T, B>> r3 = this.boundaryObserver;
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
            t<? super Observable<T>> r0 = this.downstream;
            MpscLinkedQueue<Object> r1 = this.queue;
            AtomicThrowable r2 = this.errors;
            int r4 = 1;
        L7:
            if (this.windows.get() == 0) goto L8;
            UnicastSubject<T> r5 = this.window;
            boolean r7 = this.done;
            if (r7 == true) goto L13;
        L19:
            Object r8 = r1.poll();
            if (r8 != null) goto L22;
            boolean r9 = true;
        L23:
            if (r7 == false) goto L34;
            if (r9 == false) goto L34;
            Throwable r3 = r2.terminate();
            if (r3 != null) goto L30;
            if (r5 == null) goto L29;
            this.window = null;
            r5.onComplete();
        L29:
            r0.onComplete();
            return;
        L30:
            if (r5 == null) goto L32;
            this.window = null;
            r5.onError(r3);
        L32:
            r0.onError(r3);
            return;
        L34:
            if (r9 == true) goto L35;
            if (r8 != NEXT_WINDOW) goto L40;
            if (r5 == null) goto L44;
            this.window = null;
            r5.onComplete();
        L44:
            if (this.stopWindows.get() == true) goto L7;
            UnicastSubject<T> r6 = UnicastSubject.a(this.capacityHint, this);
            this.window = r6;
            this.windows.getAndIncrement();
            s r10 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.other.call(), "The other Callable returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
            a<T, B> r11 = new a(this);
            if (this.boundaryObserver.compareAndSet(null, r11) == false) goto L7;
            r10.subscribe(r11);
            r0.onNext(r6);
        L50:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r2.addThrowable(th);
            this.done = true;
            goto L7
        L40:
            r5.onNext((T) r8);
            goto L7
        L35:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L22:
            r9 = false;
            goto L23
        L13:
            if (r2.get() == null) goto L19;
            r1.clear();
            Throwable r12 = r2.terminate();
            if (r5 == null) goto L17;
            this.window = null;
            r5.onError(r12);
        L17:
            r0.onError(r12);
            return;
        L8:
            r1.clear();
            this.window = null;
        }

        void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        void innerError(Throwable r2) {
            this.upstream.dispose();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void innerNext(a<T, B> r3) {
            this.boundaryObserver.compareAndSet(r3, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            disposeBoundary();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            this.queue.offer(NEXT_WINDOW);
            drain();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            this.upstream.dispose();
            return;
        }
    }

    static final class a<T, B> extends io.reactivex.observers.a<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f17023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f17024b;

        a(WindowBoundaryMainObserver<T, B> r1) {
            this.f17023a = r1;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.f17024b == false) goto L5;
            return;
        L5:
            this.f17024b = true;
            this.f17023a.innerComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.f17024b == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.f17024b = true;
            this.f17023a.innerError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(B r1) {
            if (this.f17024b == false) goto L5;
            return;
        L5:
            this.f17024b = true;
            dispose();
            this.f17023a.innerNext(this);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super Observable<T>> r4) {
        WindowBoundaryMainObserver r0 = new WindowBoundaryMainObserver((t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin"), this.c, this.f17022b);
        this.f17034a.subscribe(r0);
    }
}
