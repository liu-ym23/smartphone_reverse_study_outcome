package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatMap<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final h<? super T, ? extends org.a.b<? extends R>> c;
    final int d;
    final ErrorMode e;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16766a = null;

        static {
            int[] r0 = new int[ErrorMode.values().length];
            f16766a = r0;
            r0[ErrorMode.BOUNDARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f16766a[ErrorMode.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements a<R>, j<T>, org.a.d {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final AtomicThrowable errors;
        final ConcatMapInner<R> inner;
        final int limit;
        final h<? super T, ? extends org.a.b<? extends R>> mapper;
        final int prefetch;
        f<T> queue;
        int sourceMode;
        org.a.d upstream;

        BaseConcatMapSubscriber(h<? super T, ? extends org.a.b<? extends R>> r3, int r4) {
            this.mapper = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            this.prefetch = r4;
            this.limit = r4 - (r4 >> 2);
            this.inner = new ConcatMapInner(this);
            this.errors = new AtomicThrowable();
        }

        abstract void drain();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // org.a.c
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public final void onNext(T r3) {
            if (this.sourceMode != 2) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r3) == true) goto L8;
            this.upstream.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        @Override // io.reactivex.j, org.a.c
        public final void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
            this.upstream = r5;
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            subscribeActual();
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            subscribeActual();
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            r5.request(this.prefetch);
            return;
        }

        abstract void subscribeActual();
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final org.a.c<? super R> downstream;
        final boolean veryEnd;

        ConcatMapDelayed(org.a.c<? super R> r3, h<? super T, ? extends org.a.b<? extends R>> r4, int r5, boolean r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super((h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin"), r5);
            this.downstream = r7;
            this.veryEnd = r6;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == true) goto L6;
            if (this.active == true) goto L57;
            boolean r0 = this.done;
            if (r0 == true) goto L12;
        L59:
            T r2 = this.queue.poll();     // Catch: Throwable -> L54
            if (r2 != null) goto L21;
            boolean r5 = true;
        L22:
            if (r0 == false) goto L29;
            if (r5 == false) goto L29;
            Throwable r1 = this.errors.terminate();
            org.a.c<? super R> r7 = this.downstream;
            if (r1 == null) goto L27;
            r7.onError(r1);
            return;
        L27:
            r7.onComplete();
            return;
        L29:
            if (r5 == true) goto L57;
            org.a.b r3 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r2), "The mapper returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            if (this.sourceMode == 1) goto L38;
            int r4 = this.consumed + 1;
            if (r4 != this.limit) goto L36;
            this.consumed = 0;
            this.upstream.request(r4);
            goto L38
        L36:
            this.consumed = r4;
        L38:
            if (ZeusTransformUtils.instanceOf(r3, Callable.class) == false) goto L53;
            Object r6 = ((Callable) ZeusTransformUtils.preCheckCast(r3, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L42
        L47:
            if (r6 == null) goto L5;
            if (this.inner.isUnbounded() == true) goto L51;
            this.active = true;
            this.inner.setSubscription(new SimpleScalarSubscription(r6, this.inner));
            goto L57
        L51:
            this.downstream.onNext(r6);
        L42:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
            if (this.veryEnd == false) goto L45;
            r6 = null;
            goto L47
        L45:
            this.upstream.cancel();
        L15:
            this.downstream.onError(this.errors.terminate());
            return;
        L53:
            this.active = true;
            r3.subscribe(this.inner);
            goto L57
        L21:
            r5 = false;
        L54:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            goto L15
        L12:
            if (this.veryEnd == true) goto L59;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L59;
        L57:
            if (decrementAndGet() != 0) goto L5;
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.veryEnd == true) goto L7;
            this.upstream.cancel();
            this.done = true;
        L7:
            this.active = false;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.d
        public void request(long r1) {
            this.inner.request(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final org.a.c<? super R> downstream;
        final AtomicInteger wip;

        ConcatMapImmediate(org.a.c<? super R> r3, h<? super T, ? extends org.a.b<? extends R>> r4, int r5) {
            org.a.c<? super R> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super((h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin"), r5);
            this.downstream = r6;
            this.wip = new AtomicInteger();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == true) goto L6;
            if (this.active == true) goto L55;
            boolean r1 = this.done;
            T r2 = this.queue.poll();     // Catch: Throwable -> L51
            if (r2 != null) goto L14;
            boolean r5 = true;
        L15:
            if (r1 == false) goto L19;
            if (r5 == false) goto L19;
            this.downstream.onComplete();
            return;
        L19:
            if (r5 == true) goto L55;
            org.a.b r3 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r2), "The mapper returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
            if (this.sourceMode == 1) goto L28;
            int r4 = this.consumed + 1;
            if (r4 != this.limit) goto L26;
            this.consumed = 0;
            this.upstream.request(r4);
            goto L28
        L26:
            this.consumed = r4;
        L28:
            if (ZeusTransformUtils.instanceOf(r3, Callable.class) == false) goto L47;
            Object r6 = ((Callable) ZeusTransformUtils.preCheckCast(r3, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L44
            if (r6 == null) goto L5;
            if (this.inner.isUnbounded() == true) goto L36;
            this.active = true;
            this.inner.setSubscription(new SimpleScalarSubscription(r6, this.inner));
            goto L55
        L36:
            if (get() != 0) goto L5;
            if (compareAndSet(0, 1) == false) goto L5;
            this.downstream.onNext(r6);
            if (compareAndSet(1, 0) == true) goto L5;
            this.downstream.onError(this.errors.terminate());
            return;
        L44:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L47:
            this.active = true;
            r3.subscribe(this.inner);
        L48:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L14:
            r5 = false;
        L51:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L55:
            if (this.wip.decrementAndGet() != 0) goto L5;
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L7;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.downstream.onError(this.errors.terminate());
            return;
        L9:
            return;
        L7:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r4) {
            if (get() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L12;
            this.downstream.onNext(r4);
            if (compareAndSet(1, 0) == false) goto L9;
            return;
        L9:
            this.downstream.onError(this.errors.terminate());
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L7;
            this.inner.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.downstream.onError(this.errors.terminate());
            return;
        L9:
            return;
        L7:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.d
        public void request(long r1) {
            this.inner.request(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    static final class ConcatMapInner<R> extends SubscriptionArbiter implements j<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final a<R> parent;
        long produced;

        ConcatMapInner(a<R> r3) {
            a<R> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            super(false);
            this.parent = r4;
        }

        @Override // org.a.c
        public void onComplete() {
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.parent.innerComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.parent.innerError(r6);
        }

        @Override // org.a.c
        public void onNext(R r5) {
            this.produced++;
            this.parent.innerNext(r5);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            setSubscription((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class SimpleScalarSubscription<T> extends AtomicBoolean implements org.a.d {
        final org.a.c<? super T> downstream;
        final T value;

        SimpleScalarSubscription(T r3, org.a.c<? super T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
            this.value = r3;
            this.downstream = r5;
        }

        @Override // org.a.d
        public void cancel() {
        }

        @Override // org.a.d
        public void request(long r3) {
            if (r3 > 0) goto L5;
            return;
        L5:
            if (compareAndSet(false, true) == false) goto L9;
            org.a.c<? super T> r4 = this.downstream;
            r4.onNext(this.value);
            r4.onComplete();
            return;
        }
    }

    interface a<T> {
        void innerComplete();

        void innerError(Throwable r1);

        void innerNext(T r1);
    }

    public static <T, R> org.a.c<T> a(org.a.c<? super R> r2, h<? super T, ? extends org.a.b<? extends R>> r3, int r4, ErrorMode r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.a.c.class, "com.obric.memorydata.plugin");
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        int r8 = AnonymousClass1.f16766a[r5.ordinal()];
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L9;
        return new ConcatMapImmediate(r6, r7, r4);
    L9:
        return new ConcatMapDelayed(r6, r7, r4, true);
    L11:
        return new ConcatMapDelayed(r6, r7, r4, false);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (d.a(this.f16812b, r5, this.c) == false) goto L5;
        return;
    L5:
        this.f16812b.subscribe(a(r5, this.c, this.d, this.e));
    }
}
