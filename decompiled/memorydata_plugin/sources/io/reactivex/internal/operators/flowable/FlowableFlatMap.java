package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.e;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFlatMap<T, U> extends a<T, U> {
    final h<? super T, ? extends org.a.b<? extends U>> c;
    final boolean d;
    final int e;
    final int f;

    static final class InnerSubscriber<T, U> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile f<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> r1, long r2) {
            this.id = r2;
            this.parent = r1;
            int r3 = r1.bufferSize;
            this.bufferSize = r3;
            this.limit = r3 >> 2;
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
            this.done = true;
            this.parent.drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, r2);
        }

        @Override // org.a.c
        public void onNext(U r3) {
            if (this.fusionMode == 2) goto L5;
            this.parent.tryEmit(r3, this);
            return;
        L5:
            this.parent.drain();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L13;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L13;
            this.fusionMode = r1;
            this.queue = r0;
        L13:
            r5.request(this.bufferSize);
        }

        void requestMore(long r3) {
            if (this.fusionMode == 1) goto L9;
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements j<T>, org.a.d {
        static final InnerSubscriber<?, ?>[] CANCELLED = null;
        static final InnerSubscriber<?, ?>[] EMPTY = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final org.a.c<? super U> downstream;
        final AtomicThrowable errs;
        long lastId;
        int lastIndex;
        final h<? super T, ? extends org.a.b<? extends U>> mapper;
        final int maxConcurrency;
        volatile e<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        org.a.d upstream;

        static {
            EMPTY = new InnerSubscriber[0];
            CANCELLED = new InnerSubscriber[0];
        }

        MergeSubscriber(org.a.c<? super U> r3, h<? super T, ? extends org.a.b<? extends U>> r4, boolean r5, int r6, int r7) {
            org.a.c<? super U> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<? extends U>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.errs = new AtomicThrowable();
            AtomicReference<InnerSubscriber<?, ?>[]> r0 = new AtomicReference();
            this.subscribers = r0;
            this.requested = new AtomicLong();
            this.downstream = r8;
            this.mapper = r9;
            this.delayErrors = r5;
            this.maxConcurrency = r6;
            this.bufferSize = r7;
            this.scalarLimit = Math.max(1, r6 >> 1);
            r0.lazySet(EMPTY);
        }

        boolean addInner(InnerSubscriber<T, U> r5) {
        L2:
            InnerSubscriber<?, ?>[] r0 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            if (r0 == CANCELLED) goto L4;
            int r1 = r0.length;
            InnerSubscriber[] r3 = new InnerSubscriber[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.subscribers.compareAndSet(r0, (InnerSubscriber<?, ?>[]) r3) == false) goto L2;
            return true;
        L4:
            r5.dispose();
            return false;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L10;
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0) goto L11;
            e<U> r1 = this.queue;
            if (r1 == null) goto L12;
            r1.clear();
            return;
        L12:
            return;
        L11:
            return;
        }

        boolean checkTerminate() {
            if (this.cancelled == false) goto L7;
            clearScalarQueue();
            return true;
        L7:
            if (this.delayErrors == false) goto L9;
            return false;
        L9:
            if (this.errs.get() == null) goto L16;
            clearScalarQueue();
            Throwable r0 = this.errs.terminate();
            if (r0 == ExceptionHelper.f17150a) goto L13;
            this.downstream.onError(r0);
        L13:
            return true;
        L16:
            return false;
        }

        void clearScalarQueue() {
            e<U> r0 = this.queue;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] r0 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            InnerSubscriber<?, ?>[] r1 = CANCELLED;
            if (r0 == r1) goto L16;
            InnerSubscriber<?, ?>[] r2 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(r1), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            if (r2 == r1) goto L17;
            int r3 = r2.length;
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            r2[r4].dispose();
            r4 = r4 + 1;
            goto L7
        L9:
            Throwable r5 = this.errs.terminate();
            if (r5 != null) goto L12;
            return;
        L12:
            if (r5 == ExceptionHelper.f17150a) goto L19;
            io.reactivex.d.a.a(r5);
            return;
        L19:
            return;
        L17:
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            org.a.c<? super U> r2 = this.downstream;
            int r4 = 1;
        L4:
            if (checkTerminate() == true) goto L5;
            e<U> r0 = this.queue;
            long r5 = this.requested.get();
            if (r5 != Long.MAX_VALUE) goto L9;
            boolean r9 = true;
        L10:
            long r14 = 0;
            long r16 = 0;
            if (r0 == null) goto L31;
        L12:
            long r7 = 0;
            Object r18 = null;
        L14:
            if (r5 == 0) goto L22;
            U r10 = r0.poll();
            if (checkTerminate() == true) goto L17;
            if (r10 == null) goto L19;
            r2.onNext(r10);
            r16 = r16 + 1;
            r7 = r7 + 1;
            r5 = r5 - 1;
            r18 = r10;
            goto L14
        L19:
            r18 = r10;
            goto L22
        L17:
            return;
        L22:
            if (r7 == 0) goto L27;
            if (r9 == false) goto L25;
            r5 = Long.MAX_VALUE;
            goto L27
        L25:
            r5 = this.requested.addAndGet(-r7);
        L27:
            if (r5 == 0) goto L31;
            if (r18 != null) goto L12;
        L31:
            boolean r1 = this.done;
            e<U> r8 = this.queue;
            InnerSubscriber<T, U>[] r11 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r12 = r11.length;
            if (r1 == false) goto L43;
            if (r8 != null) goto L35;
        L36:
            if (r12 != 0) goto L43;
            Throwable r3 = this.errs.terminate();
            if (r3 == ExceptionHelper.f17150a) goto L167;
            if (r3 != null) goto L41;
            r2.onComplete();
            return;
        L41:
            r2.onError(r3);
            return;
        L167:
            return;
        L35:
            if (r8.isEmpty() == true) goto L36;
        L43:
            if (r12 == 0) goto L123;
            int r13 = r4;
            long r6 = this.lastId;
            int r15 = this.lastIndex;
            if (r12 > r15) goto L47;
        L48:
            if (r12 > r15) goto L50;
            r15 = 0;
        L50:
            int r17 = 0;
        L51:
            if (r17 >= r12) goto L59;
            if (r11[r15].id == r6) goto L59;
            r15 = r15 + 1;
            if (r15 != r12) goto L58;
            r15 = 0;
        L58:
            r17 = r17 + 1;
        L59:
            this.lastIndex = r15;
            this.lastId = r11[r15].id;
        L60:
            int r19 = r15;
            boolean r20 = false;
            int r21 = 0;
        L61:
            if (r21 >= r12) goto L121;
            if (checkTerminate() == true) goto L64;
            InnerSubscriber<T, U> r22 = r11[r19];
            Object r110 = null;
        L67:
            if (checkTerminate() == true) goto L68;
            f<U> r111 = r22.queue;
            int r23 = r13;
            if (r111 == null) goto L103;
            Object r24 = r110;
            long r112 = r14;
        L74:
            if (r5 == r14) goto L90;
            U r113 = r111.poll();     // Catch: Throwable -> L82
            if (r113 == null) goto L77;
            r2.onNext(r113);
            if (checkTerminate() == true) goto L80;
            r5 = r5 - 1;
            r112 = r112 + 1;
            r24 = r113;
            r14 = 0;
            goto L74
        L80:
            return;
        L77:
            r24 = r113;
            long r114 = 0;
        L92:
            if (r112 == r114) goto L97;
            if (r9 == true) goto L95;
            r5 = this.requested.addAndGet(-r112);
        L96:
            r22.requestMore(r112);
            long r115 = 0;
        L99:
            if (r5 == r115) goto L103;
            if (r24 == null) goto L103;
            r13 = r23;
            r110 = r24;
            r14 = 0;
            goto L67
        L95:
            r5 = Long.MAX_VALUE;
            goto L96
        L97:
            r115 = r114;
        L82:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r22.dispose();
            this.errs.addThrowable(th);
            if (this.delayErrors == true) goto L87;
            this.upstream.cancel();
        L87:
            if (checkTerminate() == true) goto L88;
            removeInner(r22);
            r21 = r21 + 1;
            r20 = true;
            int r25 = 1;
        L120:
            r21 = r21 + r25;
            r13 = r23;
            r14 = 0;
            goto L61
        L88:
            return;
        L90:
            r114 = r14;
        L103:
            boolean r116 = r22.done;
            f<U> r117 = r22.queue;
            if (r116 == false) goto L114;
            if (r117 != null) goto L107;
        L108:
            removeInner(r22);
            if (checkTerminate() == true) goto L110;
            r16 = r16 + 1;
            r20 = true;
            goto L114
        L110:
            return;
        L107:
            if (r117.isEmpty() == true) goto L108;
        L114:
            if (r5 == 0) goto L115;
            r19 = r19 + 1;
            if (r19 != r12) goto L119;
            r19 = 0;
        L119:
            r25 = 1;
            goto L120
        L115:
            boolean r118 = r20;
        L122:
            this.lastIndex = r19;
            this.lastId = r11[r19].id;
            long r26 = r16;
            long r27 = 0;
        L125:
            if (r26 != r27) goto L127;
        L129:
            if (r118 == true) goto L130;
            r4 = addAndGet(-r23);
            if (r4 != 0) goto L4;
            return;
        L130:
            r4 = r23;
            goto L4
        L127:
            if (this.cancelled == true) goto L129;
            this.upstream.request(r26);
            goto L129
        L68:
            return;
        L64:
            return;
        L121:
            r23 = r13;
            r118 = r20;
            goto L122
        L47:
            if (r11[r15].id == r6) goto L60;
        L123:
            r23 = r4;
            r27 = 0;
            r26 = r16;
            r118 = false;
            goto L125
        L9:
            r9 = false;
            goto L10
        }

        f<U> getInnerQueue(InnerSubscriber<T, U> r2) {
            f<U> r0 = r2.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(this.bufferSize);
            r2.queue = r1;
            return r1;
        L6:
            return r0;
        }

        f<U> getMainQueue() {
            e<U> r0 = this.queue;
            if (r0 == null) goto L5;
        L9:
            return r0;
        L5:
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L7;
            r0 = new io.reactivex.internal.queue.a(this.bufferSize);
        L8:
            this.queue = r0;
            goto L9
        L7:
            r0 = new SpscArrayQueue(this.maxConcurrency);
            goto L8
        }

        void innerError(InnerSubscriber<T, U> r3, Throwable r4) {
            if (this.errs.addThrowable(r4) == false) goto L10;
            r3.done = true;
            if (this.delayErrors == true) goto L9;
            this.upstream.cancel();
            InnerSubscriber[] r5 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(CANCELLED), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r6 = r5.length;
            int r0 = 0;
        L7:
            if (r0 >= r6) goto L9;
            r5[r0].dispose();
            r0 = r0 + 1;
        L9:
            drain();
            return;
        L10:
            io.reactivex.d.a.a(r4);
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
        public void onError(Throwable r4) {
            if (this.done == false) goto L7;
            io.reactivex.d.a.a(r4);
            return;
        L7:
            if (this.errs.addThrowable(r4) == false) goto L14;
            this.done = true;
            if (this.delayErrors == true) goto L13;
            InnerSubscriber[] r5 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(CANCELLED), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r0 = r5.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L13;
            r5[r1].dispose();
            r1 = r1 + 1;
        L13:
            drain();
            return;
        L14:
            io.reactivex.d.a.a(r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T r6) {
            if (this.done == false) goto L30;
            return;
        L30:
            org.a.b r7 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r6), "The mapper returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            if (ZeusTransformUtils.instanceOf(r7, Callable.class) == true) goto L28;
            long r1 = this.uniqueId;
            this.uniqueId = 1 + r1;
            InnerSubscriber r0 = new InnerSubscriber(this, r1);
            if (addInner(r0) == false) goto L37;
            r7.subscribe(r0);
            return;
        L37:
            return;
        L28:
            Object r8 = ((Callable) ZeusTransformUtils.preCheckCast(r7, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L18
            if (r8 == null) goto L12;
            tryEmitScalar(r8);
            return;
        L12:
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L14;
            return;
        L14:
            if (this.cancelled == true) goto L34;
            int r9 = this.scalarEmitted + 1;
            this.scalarEmitted = r9;
            int r2 = this.scalarLimit;
            if (r9 != r2) goto L35;
            this.scalarEmitted = 0;
            this.upstream.request(r2);
            return;
        L35:
            return;
        L34:
            return;
        L18:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errs.addThrowable(th);
            drain();
            return;
        L25:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L12;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L13;
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L9;
            long r0 = Long.MAX_VALUE;
        L10:
            r4.request(r0);
            return;
        L9:
            r0 = r2;
            goto L10
        L13:
            return;
        }

        void removeInner(InnerSubscriber<T, U> r7) {
        L2:
            InnerSubscriber<T, U>[] r0 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r2 = -1;
            int r4 = 0;
        L6:
            if (r4 >= r1) goto L11;
            if (r0[r4] == r7) goto L9;
            r4 = r4 + 1;
            goto L6
        L9:
            r2 = r4;
        L11:
            if (r2 < 0) goto L12;
            if (r1 != 1) goto L16;
            InnerSubscriber<?, ?>[] r3 = EMPTY;
        L18:
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerSubscriber<?, ?>[] r5 = new InnerSubscriber[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        void tryEmit(U r7, InnerSubscriber<T, U> r8) {
            if (get() == 0) goto L5;
        L25:
            f r0 = r8.queue;
            if (r0 != null) goto L29;
            r0 = new SpscArrayQueue(this.bufferSize);
            r8.queue = r0;
        L29:
            if (r0.offer(r7) == true) goto L32;
            MissingBackpressureException r9 = new MissingBackpressureException("Inner queue full?!");
        L20:
            onError(r9);
            return;
        L32:
            if (getAndIncrement() == 0) goto L34;
            return;
        L34:
            drainLoop();
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L25;
            long r2 = this.requested.get();
            f<U> r1 = r8.queue;
            if (r2 == 0) goto L15;
            if (r1 != null) goto L10;
        L11:
            this.downstream.onNext(r7);
            if (r2 == Long.MAX_VALUE) goto L14;
            this.requested.decrementAndGet();
        L14:
            r8.requestMore(1);
        L23:
            if (decrementAndGet() != 0) goto L34;
            return;
        L10:
            if (r1.isEmpty() == true) goto L11;
        L15:
            if (r1 != null) goto L18;
            r1 = getInnerQueue(r8);
        L18:
            if (r1.offer(r7) == true) goto L23;
            r9 = new MissingBackpressureException("Inner queue full?!");
            goto L20
        }

        void tryEmitScalar(U r9) {
            if (get() != 0) goto L32;
            if (compareAndSet(0, 1) == false) goto L32;
            long r3 = this.requested.get();
            f<U> r5 = this.queue;
            if (r3 == 0) goto L21;
            if (r5 != null) goto L10;
        L11:
            this.downstream.onNext(r9);
            if (r3 == Long.MAX_VALUE) goto L15;
            this.requested.decrementAndGet();
        L15:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
            if (this.cancelled == true) goto L29;
            int r10 = this.scalarEmitted + 1;
            this.scalarEmitted = r10;
            int r1 = this.scalarLimit;
            if (r10 != r1) goto L29;
            this.scalarEmitted = 0;
            this.upstream.request(r1);
        L29:
            if (decrementAndGet() != 0) goto L37;
            return;
        L37:
            drainLoop();
            return;
        L10:
            if (r5.isEmpty() == true) goto L11;
        L21:
            if (r5 != null) goto L24;
            r5 = getMainQueue();
        L24:
            if (r5.offer(r9) == true) goto L29;
            IllegalStateException r11 = new IllegalStateException("Scalar queue full?!");
        L26:
            onError(r11);
            return;
        L32:
            if (getMainQueue().offer(r9) == true) goto L35;
            r11 = new IllegalStateException("Scalar queue full?!");
            goto L26
        L35:
            if (getAndIncrement() == 0) goto L37;
        }
    }

    public static <T, U> j<T> a(org.a.c<? super U> r8, h<? super T, ? extends org.a.b<? extends U>> r9, boolean r10, int r11, int r12) {
        return new MergeSubscriber((org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin"), (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin"), r10, r11, r12);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super U> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        if (d.a(this.f16812b, r6, this.c) == false) goto L5;
        return;
    L5:
        this.f16812b.a(a(r6, this.c, this.d, this.e, this.f));
    }
}
