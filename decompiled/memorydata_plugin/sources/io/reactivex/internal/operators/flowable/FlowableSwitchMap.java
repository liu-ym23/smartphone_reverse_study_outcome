package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSwitchMap<T, R> extends a<T, R> {
    final h<? super T, ? extends org.a.b<? extends R>> c;
    final int d;
    final boolean e;

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<org.a.d> implements j<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile f<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> r1, long r2, int r4) {
            this.parent = r1;
            this.index = r2;
            this.bufferSize = r4;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index != r0.unique) goto L6;
            this.done = true;
            r0.drain();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index == r0.unique) goto L5;
        L10:
            io.reactivex.d.a.a(r6);
            return;
        L5:
            if (r0.error.addThrowable(r6) == false) goto L10;
            if (r0.delayErrors == true) goto L9;
            r0.upstream.cancel();
            r0.done = true;
        L9:
            this.done = true;
            r0.drain();
        }

        @Override // org.a.c
        public void onNext(R r6) {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index == r0.unique) goto L5;
            return;
        L5:
            if (this.fusionMode == 0) goto L7;
        L10:
            r0.drain();
            return;
        L7:
            if (this.queue.offer(r6) == true) goto L10;
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.fusionMode = r1;
            this.queue = r0;
            r5.request(this.bufferSize);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.bufferSize);
            r5.request(this.bufferSize);
        }

        public void request(long r3) {
            if (this.fusionMode == 1) goto L6;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r3);
            return;
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements j<T>, org.a.d {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        final AtomicThrowable error;
        final h<? super T, ? extends org.a.b<? extends R>> mapper;
        final AtomicLong requested;
        volatile long unique;
        org.a.d upstream;

        static {
            SwitchMapInnerSubscriber<Object, Object> r0 = new SwitchMapInnerSubscriber(null, -1, 1);
            CANCELLED = r0;
            r0.cancel();
        }

        SwitchMapSubscriber(org.a.c<? super R> r3, h<? super T, ? extends org.a.b<? extends R>> r4, int r5, boolean r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.active = new AtomicReference();
            this.requested = new AtomicLong();
            this.downstream = r7;
            this.mapper = r8;
            this.bufferSize = r5;
            this.delayErrors = r6;
            this.error = new AtomicThrowable();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
            return;
        }

        void disposeInner() {
            SwitchMapInnerSubscriber<Object, Object> r0 = (SwitchMapInnerSubscriber) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerSubscriber.class, "com.obric.memorydata.plugin");
            SwitchMapInnerSubscriber<Object, Object> r1 = CANCELLED;
            if (r0 == r1) goto L9;
            SwitchMapInnerSubscriber<Object, Object> r3 = (SwitchMapInnerSubscriber) ZeusTransformUtils.preCheckCast(this.active.getAndSet((SwitchMapInnerSubscriber<T, R>) r1), SwitchMapInnerSubscriber.class, "com.obric.memorydata.plugin");
            if (r3 == r1) goto L10;
            if (r3 == null) goto L11;
            r3.cancel();
            return;
        L11:
            return;
        L10:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super R> r2 = this.downstream;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.done == true) goto L12;
        L29:
            SwitchMapInnerSubscriber<T, R> r6 = (SwitchMapInnerSubscriber) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerSubscriber.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L32;
            f<R> r8 = r6.queue;
        L33:
            if (r8 == null) goto L88;
            if (r6.done == false) goto L47;
            if (this.delayErrors == true) goto L45;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L22;
            if (r8.isEmpty() == false) goto L47;
        L46:
            this.active.compareAndSet(r6, null);
        L22:
            disposeInner();
        L23:
            r2.onError(this.error.terminate());
            return;
        L45:
            if (r8.isEmpty() == true) goto L46;
        L47:
            long r9 = this.requested.get();
            long r13 = 0;
        L49:
            if (r13 == r9) goto L77;
            if (this.cancelled == true) goto L52;
            boolean r0 = r6.done;
            Object r3 = r8.poll();     // Catch: Throwable -> L56
        L58:
            if (r3 != null) goto L60;
            boolean r16 = true;
        L62:
            if (r6 != this.active.get()) goto L63;
            if (r0 == true) goto L66;
        L74:
            if (r16 == true) goto L77;
            r2.onNext(r3);
            r13 = r13 + 1;
            goto L49
        L66:
            if (this.delayErrors == false) goto L68;
            if (r16 == false) goto L74;
        L73:
            this.active.compareAndSet(r6, null);
            goto L63
        L68:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L23;
            if (r16 == false) goto L74;
        L63:
            boolean r15 = true;
        L79:
            if (r13 != 0) goto L81;
        L86:
            if (r15 == false) goto L88;
        L81:
            if (this.cancelled == true) goto L86;
            if (r9 == Long.MAX_VALUE) goto L85;
            this.requested.addAndGet(-r13);
        L85:
            r6.request(r13);
            goto L86
        L60:
            r16 = false;
        L56:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r6.cancel();
            this.error.addThrowable(th);
            r3 = null;
            r0 = true;
            goto L58
        L52:
            return;
        L77:
            r15 = false;
        L88:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L32:
            r8 = null;
            goto L33
        L12:
            if (this.delayErrors == false) goto L21;
            if (this.active.get() != null) goto L29;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L18;
            r2.onError(this.error.terminate());
            return;
        L18:
            r2.onComplete();
            return;
        L21:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L22;
            if (this.active.get() != null) goto L29;
            r2.onComplete();
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
        L10:
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.error.addThrowable(r2) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            disposeInner();
        L9:
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r6) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.unique + 1;
            this.unique = r0;
            SwitchMapInnerSubscriber r2 = (SwitchMapInnerSubscriber) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerSubscriber.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L20;
            r2.cancel();
        L20:
            org.a.b r7 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r6), "The publisher returned is null"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            SwitchMapInnerSubscriber<T, R> r3 = new SwitchMapInnerSubscriber(this, r0, this.bufferSize);
        L10:
            SwitchMapInnerSubscriber<T, R> r1 = (SwitchMapInnerSubscriber) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerSubscriber.class, "com.obric.memorydata.plugin");
            if (r1 == CANCELLED) goto L25;
            if (this.active.compareAndSet(r1, r3) == false) goto L10;
            r7.subscribe(r3);
            return;
        L25:
            return;
        L17:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == false) goto L9;
            io.reactivex.internal.util.b.a(this.requested, r3);
            if (this.unique != 0) goto L7;
            this.upstream.request(Long.MAX_VALUE);
            return;
        L7:
            drain();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        if (d.a(this.f16812b, r6, this.c) == false) goto L5;
        return;
    L5:
        this.f16812b.a(new SwitchMapSubscriber(r6, this.c, this.d, this.e));
    }
}
