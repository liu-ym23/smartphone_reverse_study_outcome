package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.s;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableWindowBoundary<T, B> extends io.reactivex.internal.operators.observable.a<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<B> f17019b;
    final int c;

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.disposables.b, t<T>, Runnable {
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final a<T, B> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final t<? super Observable<T>> downstream;
        final AtomicThrowable errors;
        final MpscLinkedQueue<Object> queue;
        final AtomicBoolean stopWindows;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        UnicastSubject<T> window;
        final AtomicInteger windows;

        static {
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainObserver(t<? super Observable<T>> r3, int r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.capacityHint = r4;
            this.boundaryObserver = new a(this);
            this.upstream = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            this.boundaryObserver.dispose();
            if (this.windows.decrementAndGet() != 0) goto L9;
            DisposableHelper.dispose(this.upstream);
            return;
        L9:
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
            r0.onNext(r6);
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
            Throwable r10 = r2.terminate();
            if (r5 == null) goto L17;
            this.window = null;
            r5.onError(r10);
        L17:
            r0.onError(r10);
            return;
        L8:
            r1.clear();
            this.window = null;
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }

        void innerError(Throwable r2) {
            DisposableHelper.dispose(this.upstream);
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.boundaryObserver.dispose();
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
            if (DisposableHelper.setOnce(this.upstream, r4) == false) goto L6;
            innerNext();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            DisposableHelper.dispose(this.upstream);
            return;
        }
    }

    static final class a<T, B> extends io.reactivex.observers.a<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f17020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f17021b;

        a(WindowBoundaryMainObserver<T, B> r1) {
            this.f17020a = r1;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.f17021b == false) goto L5;
            return;
        L5:
            this.f17021b = true;
            this.f17020a.innerComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.f17021b == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.f17021b = true;
            this.f17020a.innerError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(B r1) {
            if (this.f17021b == false) goto L5;
            return;
        L5:
            this.f17020a.innerNext();
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super Observable<T>> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        WindowBoundaryMainObserver r0 = new WindowBoundaryMainObserver(r4, this.c);
        r4.onSubscribe(r0);
        this.f17019b.subscribe(r0.boundaryObserver);
        this.f17034a.subscribe(r0);
    }
}
