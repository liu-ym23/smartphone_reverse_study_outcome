package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTimeout<T, U, V> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final org.a.b<U> c;
    final h<? super T, ? extends org.a.b<V>> d;
    final org.a.b<? extends T> e;

    static final class TimeoutConsumer extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
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
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.c
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r4) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeoutError(this.idx, r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // org.a.c
        public void onNext(Object r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin");
            if (r4 == SubscriptionHelper.CANCELLED) goto L6;
            r4.cancel();
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeout(this.idx);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements a, j<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final org.a.c<? super T> downstream;
        org.a.b<? extends T> fallback;
        final AtomicLong index;
        final h<? super T, ? extends org.a.b<?>> itemTimeoutIndicator;
        final SequentialDisposable task;
        final AtomicReference<org.a.d> upstream;

        TimeoutFallbackSubscriber(org.a.c<? super T> r3, h<? super T, ? extends org.a.b<?>> r4, org.a.b<? extends T> r5) {
            org.a.c<? super T> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<?>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r8 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r5, org.a.b.class, "com.obric.memorydata.plugin");
            super(true);
            this.downstream = r6;
            this.itemTimeoutIndicator = r7;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.fallback = r8;
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.task.dispose();
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        @Override // org.a.c
        public void onNext(T r10) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L22;
            long r7 = r0 + 1;
            if (this.index.compareAndSet(r0, r7) == false) goto L23;
            io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.task.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L10;
            r1.dispose();
        L10:
            this.consumed++;
            this.downstream.onNext(r10);
            org.a.b r11 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.itemTimeoutIndicator.apply(r10), "The itemTimeoutIndicator returned a null Publisher."), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r7, this);
            if (this.task.replace(r2) == false) goto L21;
            r11.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            this.index.getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.upstream, r4) == false) goto L6;
            setSubscription(r4);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long r5) {
            if (this.index.compareAndSet(r5, Long.MAX_VALUE) == false) goto L9;
            SubscriptionHelper.cancel(this.upstream);
            org.a.b<? extends T> r6 = this.fallback;
            this.fallback = null;
            long r0 = this.consumed;
            if (r0 == 0) goto L7;
            produced(r0);
        L7:
            r6.subscribe(new FlowableTimeoutTimed.a(this.downstream, this));
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void onTimeoutError(long r4, Throwable r6) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r6);
            return;
        L5:
            io.reactivex.d.a.a(r6);
        }

        void startFirstTimeout(org.a.b<?> r4) {
            org.a.b r5 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L9;
            r5.subscribe(r0);
            return;
        L9:
            return;
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements a, j<T>, org.a.d {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> downstream;
        final h<? super T, ? extends org.a.b<?>> itemTimeoutIndicator;
        final AtomicLong requested;
        final SequentialDisposable task;
        final AtomicReference<org.a.d> upstream;

        TimeoutSubscriber(org.a.c<? super T> r3, h<? super T, ? extends org.a.b<?>> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<?>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.itemTimeoutIndicator = r6;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // org.a.c
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
            org.a.b r9 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.itemTimeoutIndicator.apply(r8), "The itemTimeoutIndicator returned a null Publisher."), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            TimeoutConsumer r2 = new TimeoutConsumer(r4, this);
            if (this.task.replace(r2) == false) goto L21;
            r9.subscribe(r2);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            getAndSet(Long.MAX_VALUE);
            this.downstream.onError(th);
            return;
        L23:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long r3) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException());
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void onTimeoutError(long r3, Throwable r5) {
            if (compareAndSet(r3, Long.MAX_VALUE) == false) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        void startFirstTimeout(org.a.b<?> r4) {
            org.a.b r5 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            TimeoutConsumer r0 = new TimeoutConsumer(0, this);
            if (this.task.replace(r0) == false) goto L9;
            r5.subscribe(r0);
            return;
        L9:
            return;
        }
    }

    interface a extends FlowableTimeoutTimed.b {
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
    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (this.e != null) goto L5;
        TimeoutSubscriber r0 = new TimeoutSubscriber(r5, this.d);
        r5.onSubscribe(r0);
        r0.startFirstTimeout(this.c);
        j<? super T> r1 = r0;
    L6:
        this.f16812b.a(r1);
        return;
    L5:
        TimeoutFallbackSubscriber r2 = new TimeoutFallbackSubscriber(r5, this.d, this.e);
        r5.onSubscribe(r2);
        r2.startFirstTimeout(this.c);
        r1 = r2;
        goto L6
    }
}
