package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowablePublish<T> extends io.reactivex.a.a<T> implements c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g<T> f16781b;
    final AtomicReference<PublishSubscriber<T>> c;
    final int d;
    final org.a.b<T> e;

    static final class InnerSubscriber<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = -4453897557930727610L;
        final org.a.c<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(org.a.c<? super T> r3) {
            this.child = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        }

        @Override // org.a.d
        public void cancel() {
            if (get() != Long.MIN_VALUE) goto L5;
            return;
        L5:
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L11;
            PublishSubscriber<T> r0 = this.parent;
            if (r0 == null) goto L12;
            r0.remove(this);
            r0.dispatch();
            return;
        L12:
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L8;
            io.reactivex.internal.util.b.b(this, r2);
            PublishSubscriber<T> r1 = this.parent;
            if (r1 == null) goto L9;
            r1.dispatch();
            return;
        L9:
            return;
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements io.reactivex.disposables.b, j<T> {
        static final InnerSubscriber[] EMPTY = null;
        static final InnerSubscriber[] TERMINATED = null;
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile f<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers;
        volatile Object terminalEvent;
        final AtomicReference<org.a.d> upstream;

        static {
            EMPTY = new InnerSubscriber[0];
            TERMINATED = new InnerSubscriber[0];
        }

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> r3, int r4) {
            this.upstream = new AtomicReference();
            this.subscribers = new AtomicReference(EMPTY);
            this.current = r3;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = r4;
        }

        boolean add(InnerSubscriber<T> r5) {
        L2:
            InnerSubscriber<T>[] r0 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerSubscriber<T>[] r3 = new InnerSubscriber[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        boolean checkTerminated(Object r6, boolean r7) {
            int r0 = 0;
            if (r6 != null) goto L5;
        L18:
            return false;
        L5:
            if (NotificationLite.isComplete(r6) == false) goto L11;
            if (r7 == false) goto L18;
            this.current.compareAndSet(this, null);
            InnerSubscriber[] r5 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r8 = r5.length;
        L8:
            if (r0 >= r8) goto L10;
            r5[r0].child.onComplete();
            r0 = r0 + 1;
            goto L8
        L10:
            return true;
        L11:
            Throwable r9 = NotificationLite.getError(r6);
            this.current.compareAndSet(this, null);
            InnerSubscriber[] r10 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            if (r10.length == 0) goto L16;
            int r11 = r10.length;
        L14:
            if (r0 >= r11) goto L17;
            r10[r0].child.onError(r9);
            r0 = r0 + 1;
        L17:
            return true;
        L16:
            io.reactivex.d.a.a(r9);
            goto L17
        }

        void dispatch() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<InnerSubscriber<T>[]> r2 = this.subscribers;
            boolean r3 = true;
            InnerSubscriber[] r5 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(r2.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r6 = 1;
        L6:
            Object r0 = this.terminalEvent;
            f<T> r7 = this.queue;
            if (r7 != null) goto L9;
        L12:
            boolean r9 = r3;
        L14:
            if (checkTerminated(r0, r9) == true) goto L15;
            if (r9 == true) goto L90;
            int r1 = r5.length;
            int r10 = r5.length;
            boolean r16 = r9;
            long r8 = Long.MAX_VALUE;
            int r13 = 0;
            int r14 = 0;
        L19:
            if (r13 >= r10) goto L26;
            InnerSubscriber r15 = r5[r13];
            long r19 = r15.get();
            if (r19 == Long.MIN_VALUE) goto L23;
            r8 = Math.min(r8, r19 - r15.emitted);
        L24:
            r13 = r13 + 1;
            goto L19
        L23:
            r14 = r14 + 1;
            goto L24
        L26:
            if (r1 == r14) goto L27;
            int r17 = 0;
        L43:
            long r18 = r17;
            if (r18 >= r8) goto L80;
            Object r4 = this.terminalEvent;
            T r110 = r7.poll();     // Catch: Throwable -> L48
        L50:
            if (r110 != null) goto L52;
            boolean r12 = r3;
        L54:
            if (checkTerminated(r4, r12) == true) goto L55;
            if (r12 == true) goto L57;
            Object r11 = NotificationLite.getValue(r110);
            int r111 = r5.length;
            int r112 = 0;
            boolean r113 = false;
        L59:
            if (r112 >= r111) goto L69;
            InnerSubscriber r20 = r5[r112];
            long r23 = r20.get();
            if (r23 != Long.MIN_VALUE) goto L63;
            r6 = r6;
            r7 = r7;
            r113 = true;
        L68:
            r112 = r112 + 1;
            r6 = r6;
            r7 = r7;
            goto L59
        L63:
            if (r23 == Long.MAX_VALUE) goto L66;
            r20.emitted++;
        L66:
            r20.child.onNext(r11);
            goto L68
        L69:
            int r24 = r6;
            f<T> r25 = r7;
            r17 = r17 + 1;
            InnerSubscriber[] r21 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(r2.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            if (r113 == true) goto L74;
            if (r21 != r5) goto L74;
            r16 = r12;
            r6 = r24;
            r7 = r25;
            r3 = true;
        L74:
            if (r17 != 0) goto L76;
        L78:
            r5 = r21;
            r6 = r24;
            r3 = true;
            goto L6
        L76:
            if (this.sourceMode == 1) goto L78;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r17);
            goto L78
        L57:
            r16 = r12;
            goto L80
        L55:
            return;
        L52:
            r12 = false;
        L48:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            r4 = NotificationLite.error(th);
            this.terminalEvent = r4;
            r110 = null;
        L80:
            if (r17 == 0) goto L84;
            r3 = true;
            if (this.sourceMode == 1) goto L86;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r18);
        L86:
            if (r8 == 0) goto L89;
            if (r16 == true) goto L89;
        L88:
            r6 = r6;
        L89:
            int r22 = r6;
        L91:
            r6 = addAndGet(-r22);
            if (r6 == 0) goto L93;
            r5 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(r2.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            goto L6
        L93:
            return;
        L84:
            r3 = true;
            goto L86
        L27:
            Object r26 = this.terminalEvent;
            T r114 = r7.poll();     // Catch: Throwable -> L30
        L32:
            if (r114 != null) goto L34;
            boolean r27 = r3;
        L36:
            if (checkTerminated(r26, r27) == true) goto L37;
            if (this.sourceMode == r3) goto L41;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(1);
        L41:
            r6 = r6;
            goto L88
        L37:
            return;
        L34:
            r27 = false;
        L30:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            r26 = NotificationLite.error(th);
            this.terminalEvent = r26;
            r114 = null;
            goto L32
        L90:
            r22 = r6;
            goto L91
        L15:
            return;
        L9:
            if (r7.isEmpty() == true) goto L12;
            r9 = false;
            goto L14
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            InnerSubscriber<T>[] r0 = this.subscribers.get();
            InnerSubscriber<T>[] r1 = TERMINATED;
            if (r0 != r1) goto L5;
            return;
        L5:
            if (((InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(r1), InnerSubscriber[].class, "com.obric.memorydata.plugin")) == r1) goto L9;
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.subscribers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.terminalEvent != null) goto L6;
            this.terminalEvent = NotificationLite.complete();
            dispatch();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.terminalEvent != null) goto L5;
            this.terminalEvent = NotificationLite.error(r2);
            dispatch();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            dispatch();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.upstream, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.terminalEvent = NotificationLite.complete();
            dispatch();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r5.request(this.bufferSize);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.bufferSize);
            r5.request(this.bufferSize);
        }

        void remove(InnerSubscriber<T> r7) {
        L2:
            InnerSubscriber<T>[] r0 = (InnerSubscriber[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscriber[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L19;
            int r2 = -1;
            int r4 = 0;
        L6:
            if (r4 >= r1) goto L11;
            if (r0[r4].equals(r7) == true) goto L9;
            r4 = r4 + 1;
            goto L6
        L9:
            r2 = r4;
        L11:
            if (r2 < 0) goto L12;
            if (r1 != 1) goto L16;
            InnerSubscriber<T>[] r3 = EMPTY;
        L18:
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerSubscriber<T>[] r5 = new InnerSubscriber[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }
    }

    @Override // io.reactivex.a.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> r6) {
        io.reactivex.b.g r7 = (io.reactivex.b.g) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.g.class, "com.obric.memorydata.plugin");
    L3:
        PublishSubscriber<T> r0 = (PublishSubscriber) ZeusTransformUtils.preCheckCast(this.c.get(), PublishSubscriber.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L7:
        PublishSubscriber<T> r2 = new PublishSubscriber(this.c, this.d);
        if (this.c.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L11:
        boolean r3 = true;
        if (r0.shouldConnect.get() == false) goto L14;
    L16:
        r3 = false;
    L24:
        r7.accept(r0);     // Catch: Throwable -> L21
        if (r3 == false) goto L29;
        this.f16781b.a(r0);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L14:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L16;
    L6:
        if (r0.isDisposed() == false) goto L11;
        goto L7
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.e.subscribe(r4);
    }
}
