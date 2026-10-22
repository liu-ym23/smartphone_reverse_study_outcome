package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSampleTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16984b;
    final TimeUnit c;
    final u d;
    final boolean e;

    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(t<? super T> r7, long r8, TimeUnit r10, u r11) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin"), r8, r10, r11);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            emit();
            if (this.wip.decrementAndGet() != 0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() != 2) goto L8;
            emit();
            if (this.wip.decrementAndGet() != 0) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            return;
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(t<? super T> r7, long r8, TimeUnit r10, u r11) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin"), r8, r10, r11);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements io.reactivex.disposables.b, t<T>, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final t<? super T> downstream;
        final long period;
        final u scheduler;
        final AtomicReference<io.reactivex.disposables.b> timer;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        SampleTimedObserver(t<? super T> r3, long r4, TimeUnit r6, u r7) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.timer = new AtomicReference();
            this.downstream = r5;
            this.period = r4;
            this.unit = r6;
            this.scheduler = r7;
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        abstract void complete();

        @Override // io.reactivex.disposables.b
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        void emit() {
            T r0 = getAndSet(null);
            if (r0 == null) goto L6;
            this.downstream.onNext(r0);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            cancelTimer();
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r8) {
            io.reactivex.disposables.b r9 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r8, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r9) == false) goto L6;
            this.upstream = r9;
            this.downstream.onSubscribe(this);
            u r0 = this.scheduler;
            long r4 = this.period;
            io.reactivex.disposables.b r10 = r0.a(this, r4, r4, this.unit);
            DisposableHelper.replace(this.timer, r10);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r8) {
        io.reactivex.observers.b r1 = new io.reactivex.observers.b((t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin"));
        if (this.e == false) goto L5;
        s<T> r9 = this.f17034a;
        t<? super T> r6 = new SampleTimedEmitLast(r1, this.f16984b, this.c, this.d);
    L6:
        r9.subscribe(r6);
        return;
    L5:
        r9 = this.f17034a;
        r6 = new SampleTimedNoLast(r1, this.f16984b, this.c, this.d);
        goto L6
    }
}
