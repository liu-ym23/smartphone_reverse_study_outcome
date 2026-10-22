package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.schedulers.k;
import io.reactivex.t;
import io.reactivex.u;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16960b;
    final boolean c;
    final int d;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements t<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final t<? super T> downstream;
        Throwable error;
        boolean outputFused;
        f<T> queue;
        int sourceMode;
        io.reactivex.disposables.b upstream;
        final u.c worker;

        ObserveOnObserver(t<? super T> r3, u.c r4, boolean r5, int r6) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.worker = r4;
            this.delayError = r5;
            this.bufferSize = r6;
        }

        boolean checkTerminated(boolean r3, boolean r4, t<? super T> r5) {
            t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
            if (this.disposed == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == false) goto L22;
            Throwable r7 = this.error;
            if (this.delayError == false) goto L16;
            if (r4 == false) goto L24;
            this.disposed = true;
            if (r7 == null) goto L13;
            r6.onError(r7);
        L14:
            this.worker.dispose();
            return true;
        L13:
            r6.onComplete();
            goto L14
        L24:
            return false;
        L16:
            if (r7 == null) goto L19;
            this.disposed = true;
            this.queue.clear();
            r6.onError(r7);
            this.worker.dispose();
            return true;
        L19:
            if (r4 == false) goto L25;
            this.disposed = true;
            r6.onComplete();
            this.worker.dispose();
            return true;
        L25:
            return false;
        L22:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed == true) goto L10;
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused == false) goto L7;
            return;
        L7:
            if (getAndIncrement() != 0) goto L12;
            this.queue.clear();
            return;
        L12:
            return;
        }

        void drainFused() {
            int r1 = 1;
        L4:
            if (this.disposed == true) goto L5;
            boolean r2 = this.done;
            Throwable r3 = this.error;
            if (this.delayError == true) goto L13;
            if (r2 == false) goto L13;
            if (r3 == null) goto L13;
            this.disposed = true;
            this.downstream.onError(this.error);
        L11:
            this.worker.dispose();
            return;
        L13:
            this.downstream.onNext(null);
            if (r2 == true) goto L15;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L15:
            this.disposed = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L18;
            this.downstream.onError(r0);
            goto L11
        L18:
            this.downstream.onComplete();
            goto L11
        }

        void drainNormal() {
            f<T> r0 = this.queue;
            t<? super T> r1 = this.downstream;
            int r3 = 1;
        L4:
            if (checkTerminated(this.done, r0.isEmpty(), r1) == true) goto L5;
        L6:
            boolean r4 = this.done;
            T r5 = r0.poll();     // Catch: Throwable -> L19
            if (r5 != null) goto L10;
            boolean r6 = true;
        L12:
            if (checkTerminated(r4, r6, r1) == true) goto L13;
            if (r6 == true) goto L15;
            r1.onNext(r5);
            goto L6
        L15:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L4;
            return;
        L13:
            return;
        L10:
            r6 = false;
        L19:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.disposed = true;
            this.upstream.dispose();
            r0.clear();
            r1.onError(th);
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 2) goto L8;
            this.queue.offer(r3);
        L8:
            schedule();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(7);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r5;
            this.done = true;
            this.downstream.onSubscribe(this);
            schedule();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.sourceMode = r0;
            this.queue = r5;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused == false) goto L5;
            drainFused();
            return;
        L5:
            drainNormal();
        }

        void schedule() {
            if (getAndIncrement() != 0) goto L6;
            this.worker.a(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r5) {
        t<? super T> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.f16960b, k.class) == false) goto L5;
        this.f17034a.subscribe(r6);
        return;
    L5:
        u.c r0 = this.f16960b.a();
        this.f17034a.subscribe(new ObserveOnObserver(r6, r0, this.c, this.d));
    }
}
