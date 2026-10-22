package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTimeout<T, U, V> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<U> f17006b;
    final h<? super T, ? extends s<V>> c;
    final s<? extends T> d;

    static final class TimeoutConsumer extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<Object> {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final a parent;

        TimeoutConsumer(long r3, a r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
            this.idx = r3;
            this.parent = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (get() == DisposableHelper.DISPOSED) goto L6;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r4) {
            if (get() == DisposableHelper.DISPOSED) goto L5;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.onTimeoutError(this.idx, r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.t
        public void onNext(Object r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r4 == DisposableHelper.DISPOSED) goto L6;
            r4.dispose();
            lazySet(DisposableHelper.DISPOSED);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, a, t<T> {
        private static final long serialVersionUID = -7508389464265974549L;
        final t<? super T> downstream;
        s<? extends T> fallback;
        final AtomicLong index;
        final h<? super T, ? extends s<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        TimeoutFallbackObserver(t<? super T> r3, h<? super T, ? extends s<?>> r4, s<? extends T> r5) {
            t<? super T> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<?>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            s<? extends T> r8 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.itemTimeoutIndicator = r7;
            this.task = new SequentialDisposable();
            this.fallback = r8;
            this.index = new AtomicLong();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
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
            this.task.dispose();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.task.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        @Override // io.reactivex.t
        public void onNext(T r8) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r5 = 1 + r0;
            if (this.index.compareAndSet(r0, r5) == false) goto L23;
            io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.downstream.onNext(r8);
            s r9 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.itemTimeoutIndicator.apply(r8), "The itemTimeoutIndicator returned a null ObservableSource."), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r5, this);
            if (this.task.replace(r2) == false) goto L21;
            r9.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            this.index.getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
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
            r5.subscribe(new ObservableTimeoutTimed.a(this.downstream, this));
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long r4, Throwable r6) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L5;
            DisposableHelper.dispose(this);
            this.downstream.onError(r6);
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        void startFirstTimeout(s<?> r4) {
            s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L9;
            r5.subscribe(r0);
            return;
        L9:
            return;
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.disposables.b, a, t<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final t<? super T> downstream;
        final h<? super T, ? extends s<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        TimeoutObserver(t<? super T> r3, h<? super T, ? extends s<?>> r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<?>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.itemTimeoutIndicator = r6;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
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
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // io.reactivex.t
        public void onNext(T r8) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r4 = 1 + r0;
            if (compareAndSet(r0, r4) == false) goto L23;
            io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.downstream.onNext(r8);
            s r9 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.itemTimeoutIndicator.apply(r8), "The itemTimeoutIndicator returned a null ObservableSource."), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r4, this);
            if (this.task.replace(r2) == false) goto L21;
            r9.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
            getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long r3) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException());
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long r3, Throwable r5) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L5;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        void startFirstTimeout(s<?> r4) {
            s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L9;
            r5.subscribe(r0);
            return;
        L9:
            return;
        }
    }

    interface a extends ObservableTimeoutTimed.b {
        void onTimeoutError(long r1, Throwable r3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        if (this.d != null) goto L5;
        TimeoutObserver r0 = new TimeoutObserver(r5, this.c);
        r5.onSubscribe(r0);
        r0.startFirstTimeout(this.f17006b);
        t<? super T> r1 = r0;
    L6:
        this.f17034a.subscribe(r1);
        return;
    L5:
        TimeoutFallbackObserver r2 = new TimeoutFallbackObserver(r5, this.c, this.d);
        r5.onSubscribe(r2);
        r2.startFirstTimeout(this.f17006b);
        r1 = r2;
        goto L6
    }
}
