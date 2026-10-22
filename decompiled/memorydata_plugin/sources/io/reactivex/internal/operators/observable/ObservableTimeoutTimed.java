package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTimeoutTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17007b;
    final TimeUnit c;
    final u d;
    final s<? extends T> e;

    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, b, t<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final t<? super T> downstream;
        s<? extends T> fallback;
        final AtomicLong index;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        final u.c worker;

        TimeoutFallbackObserver(t<? super T> r3, long r4, TimeUnit r6, u.c r7, s<? extends T> r8) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            s<? extends T> r9 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.fallback = r9;
            this.task = new SequentialDisposable();
            this.index = new AtomicLong();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.worker.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        @Override // io.reactivex.t
        public void onNext(T r6) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r3 = 1 + r0;
            if (this.index.compareAndSet(r0, r3) == false) goto L10;
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            this.downstream.onNext(r6);
            startTimeout(r3);
            return;
        L10:
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long r4) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            s<? extends T> r5 = this.fallback;
            this.fallback = null;
            r5.subscribe(new a(this.downstream, this));
            this.worker.dispose();
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.a(new c(r4, this), this.timeout, this.unit));
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.disposables.b, b, t<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final t<? super T> downstream;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        final u.c worker;

        TimeoutObserver(t<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            this.worker.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // io.reactivex.t
        public void onNext(T r6) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r2 = 1 + r0;
            if (compareAndSet(r0, r2) == false) goto L10;
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            this.downstream.onNext(r6);
            startTimeout(r2);
            return;
        L10:
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long r4) {
            if (compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.a(this.timeout, this.unit)));
            this.worker.dispose();
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.a(new c(r4, this), this.timeout, this.unit));
        }
    }

    static final class a<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t<? super T> f17008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f17009b;

        a(t<? super T> r3, AtomicReference<io.reactivex.disposables.b> r4) {
            this.f17008a = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.f17009b = r4;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.f17008a.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.f17008a.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.f17008a.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.f17009b, r4);
        }
    }

    interface b {
        void onTimeout(long r1);
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f17010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f17011b;

        c(long r3, b r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
            this.f17011b = r3;
            this.f17010a = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17010a.onTimeout(this.f17011b);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r11) {
        t r12 = (t) ZeusTransformUtils.wrapperContextForParams(r11, t.class, "com.obric.memorydata.plugin");
        if (this.e != null) goto L5;
        TimeoutObserver r6 = new TimeoutObserver(r12, this.f17007b, this.c, this.d.a());
        r12.onSubscribe(r6);
        r6.startTimeout(0);
        this.f17034a.subscribe(r6);
        return;
    L5:
        TimeoutFallbackObserver r9 = new TimeoutFallbackObserver(r12, this.f17007b, this.c, this.d.a(), this.e);
        r12.onSubscribe(r9);
        r9.startTimeout(0);
        this.f17034a.subscribe(r9);
    }
}
