package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableThrottleLatest<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17005b;
    final TimeUnit c;
    final u d;
    final boolean e;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T>, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final t<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest;
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;
        final u.c worker;

        ThrottleLatestObserver(t<? super T> r3, long r4, TimeUnit r6, u.c r7, boolean r8) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.emitLast = r8;
            this.latest = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.latest.lazySet(null);
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<T> r0 = this.latest;
            t<? super T> r1 = this.downstream;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r4 = this.done;
            if (r4 == false) goto L18;
            if (this.error == null) goto L18;
            r0.lazySet(null);
            r1.onError(this.error);
        L15:
            this.worker.dispose();
            return;
        L18:
            if (r0.get() != null) goto L20;
            boolean r6 = true;
        L21:
            if (r4 == true) goto L22;
            if (r6 == true) goto L30;
            if (this.timerRunning == false) goto L40;
            if (this.timerFired == true) goto L40;
        L37:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L40:
            r1.onNext(r0.getAndSet(null));
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.a(this, this.timeout, this.unit);
            goto L7
        L30:
            if (this.timerFired == false) goto L37;
            this.timerRunning = false;
            this.timerFired = false;
            goto L37
        L22:
            T r2 = r0.getAndSet(null);
            if (r6 == false) goto L25;
        L27:
            r1.onComplete();
            goto L15
        L25:
            if (this.emitLast == false) goto L27;
            r1.onNext(r2);
            goto L27
        L20:
            r6 = false;
            goto L21
        L8:
            r0.lazySet(null);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.latest.set(r2);
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r9) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new ThrottleLatestObserver(r1, this.f17005b, this.c, this.d.a(), this.e));
    }
}
