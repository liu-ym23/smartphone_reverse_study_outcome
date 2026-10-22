package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0;
import io.reactivex.b.h;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableConcatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends s<? extends U>> f16933b;
    final int c;
    final ErrorMode d;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable error;
        final h<? super T, ? extends s<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        f<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        io.reactivex.disposables.b upstream;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final t<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(t<? super R> r3, ConcatMapDelayErrorObserver<?, R> r4) {
                this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
                this.parent = r4;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.t
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> r1 = this.parent;
                r1.active = false;
                r1.drain();
            }

            @Override // io.reactivex.t
            public void onError(Throwable r2) {
                ConcatMapDelayErrorObserver<?, R> r1 = this.parent;
                if (r1.error.addThrowable(r2) == true) goto L5;
                io.reactivex.d.a.a(r2);
                return;
            L5:
                if (r1.tillTheEnd == true) goto L7;
                r1.upstream.dispose();
            L7:
                r1.active = false;
                r1.drain();
            }

            @Override // io.reactivex.t
            public void onNext(R r1) {
                this.downstream.onNext(r1);
            }

            @Override // io.reactivex.t
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        ConcatMapDelayErrorObserver(t<? super R> r3, h<? super T, ? extends s<? extends R>> r4, int r5, boolean r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.bufferSize = r5;
            this.tillTheEnd = r6;
            this.error = new AtomicThrowable();
            this.observer = new DelayErrorInnerObserver(r7, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super R> r0 = this.downstream;
            f<T> r1 = this.queue;
            AtomicThrowable r2 = this.error;
        L7:
            if (this.active == true) goto L48;
            if (this.cancelled == true) goto L10;
            if (this.tillTheEnd == false) goto L15;
        L19:
            boolean r3 = this.done;
            T r6 = r1.poll();     // Catch: Throwable -> L45
            if (r6 != null) goto L23;
            boolean r7 = true;
        L24:
            if (r3 == false) goto L31;
            if (r7 == false) goto L31;
            this.cancelled = true;
            Throwable r8 = r2.terminate();
            if (r8 == null) goto L29;
            r0.onError(r8);
            return;
        L29:
            r0.onComplete();
            return;
        L31:
            if (r7 == true) goto L48;
            s r4 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r6), "The mapper returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
            if (ZeusTransformUtils.instanceOf(r4, Callable.class) == false) goto L42;
            $$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0 r5 = (Object) ((Callable) ZeusTransformUtils.preCheckCast(r4, Callable.class, "com.obric.memorydata.plugin")).call();
            if (r5 == null) goto L7;
            if (this.cancelled == true) goto L7;
            r0.onNext(r5);
        L40:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r2.addThrowable(th);
            goto L7
        L42:
            this.active = true;
            r4.subscribe(this.observer);
        L43:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.dispose();
            r1.clear();
            r2.addThrowable(th);
        L17:
            r0.onError(r2.terminate());
            return;
        L23:
            r7 = false;
        L45:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.dispose();
            r2.addThrowable(th);
            goto L17
        L15:
            if (((Throwable) ZeusTransformUtils.preCheckCast(r2.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L19;
            r1.clear();
            this.cancelled = true;
            goto L17
        L10:
            r1.clear();
            return;
        L48:
            if (decrementAndGet() != 0) goto L7;
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
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (this.sourceMode != 0) goto L5;
            this.queue.offer(r2);
        L5:
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(3);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r5;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
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
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final t<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final h<? super T, ? extends s<? extends U>> mapper;
        f<T> queue;
        io.reactivex.disposables.b upstream;

        static final class InnerObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements t<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final t<? super U> downstream;
            final SourceObserver<?, ?> parent;

            InnerObserver(t<? super U> r3, SourceObserver<?, ?> r4) {
                this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
                this.parent = r4;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.t
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.t
            public void onError(Throwable r2) {
                this.parent.dispose();
                this.downstream.onError(r2);
            }

            @Override // io.reactivex.t
            public void onNext(U r1) {
                this.downstream.onNext(r1);
            }

            @Override // io.reactivex.t
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        SourceObserver(t<? super U> r3, h<? super T, ? extends s<? extends U>> r4, int r5) {
            t<? super U> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends U>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.bufferSize = r5;
            this.inner = new InnerObserver(r6, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.disposed == true) goto L7;
            if (this.active == true) goto L31;
            boolean r0 = this.done;
            T r1 = this.queue.poll();     // Catch: Throwable -> L27
            if (r1 != null) goto L16;
            boolean r3 = true;
        L17:
            if (r0 == false) goto L21;
            if (r3 == false) goto L21;
            this.disposed = true;
            this.downstream.onComplete();
            return;
        L21:
            if (r3 == true) goto L31;
            s r2 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r1), "The mapper returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            this.active = true;
            r2.subscribe(this.inner);
        L24:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L16:
            r3 = false;
        L27:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L31:
            if (decrementAndGet() != 0) goto L6;
            return;
        L7:
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.fusionMode != 0) goto L8;
            this.queue.offer(r2);
        L8:
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(3);
            if (r0 != 1) goto L11;
            this.fusionMode = r0;
            this.queue = r5;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.fusionMode = r0;
            this.queue = r5;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super U> r6) {
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
        if (ObservableScalarXMap.a(this.f17034a, r7, this.f16933b) == false) goto L6;
        return;
    L6:
        if (this.d != ErrorMode.IMMEDIATE) goto L8;
        io.reactivex.observers.b r0 = new io.reactivex.observers.b(r7);
        this.f17034a.subscribe(new SourceObserver(r0, this.f16933b, this.c));
        return;
    L8:
        s<T> r1 = this.f17034a;
        h<? super T, ? extends s<? extends U>> r2 = this.f16933b;
        int r3 = this.c;
        if (this.d != ErrorMode.END) goto L11;
        boolean r5 = true;
    L12:
        r1.subscribe(new ConcatMapDelayErrorObserver(r7, r2, r3, r5));
        return;
    L11:
        r5 = false;
        goto L12
    }
}
