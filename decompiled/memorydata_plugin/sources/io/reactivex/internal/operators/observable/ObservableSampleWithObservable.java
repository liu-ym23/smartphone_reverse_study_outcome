package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSampleWithObservable<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<?> f16985b;
    final boolean c;

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(t<? super T> r3, s<?> r4) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin"));
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            if (this.wip.getAndIncrement() != 0) goto L10;
        L4:
            boolean r0 = this.done;
            emit();
            if (r0 == true) goto L6;
            if (this.wip.decrementAndGet() != 0) goto L4;
            return;
        L6:
            this.downstream.onComplete();
            return;
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(t<? super T> r3, s<?> r4) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            emit();
        }
    }

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -3517602651313910099L;
        final t<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> other;
        final s<?> sampler;
        io.reactivex.disposables.b upstream;

        SampleMainObserver(t<? super T> r3, s<?> r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            s<?> r6 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
            this.other = new AtomicReference();
            this.downstream = r5;
            this.sampler = r6;
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        abstract void completion();

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        void emit() {
            T r0 = getAndSet(null);
            if (r0 == null) goto L6;
            this.downstream.onNext(r0);
            return;
        }

        public void error(Throwable r2) {
            this.upstream.dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completion();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L8;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            if (this.other.get() != null) goto L9;
            this.sampler.subscribe(new a(this));
            return;
        L9:
            return;
        }

        abstract void run();

        boolean setOther(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            return DisposableHelper.setOnce(this.other, r4);
        }
    }

    static final class a<T> implements t<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SampleMainObserver<T> f16986a;

        a(SampleMainObserver<T> r1) {
            this.f16986a = r1;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.f16986a.complete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.f16986a.error(r1);
        }

        @Override // io.reactivex.t
        public void onNext(Object r1) {
            this.f16986a.run();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.f16986a.setOther(r4);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        io.reactivex.observers.b r0 = new io.reactivex.observers.b((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
        if (this.c == false) goto L5;
        s<T> r4 = this.f17034a;
        t<? super T> r1 = new SampleMainEmitLast(r0, this.f16985b);
    L6:
        r4.subscribe(r1);
        return;
    L5:
        r4 = this.f17034a;
        r1 = new SampleMainNoLast(r0, this.f16985b);
        goto L6
    }
}
