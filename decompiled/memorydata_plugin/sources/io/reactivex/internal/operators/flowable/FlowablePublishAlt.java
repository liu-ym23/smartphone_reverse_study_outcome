package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowablePublishAlt<T> extends io.reactivex.a.a<T> implements io.reactivex.internal.disposables.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<T> f16782b;
    final int c;
    final AtomicReference<PublishConnection<T>> d;

    static final class InnerSubscription<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = 2845000326761540265L;
        final org.a.c<? super T> downstream;
        long emitted;
        final PublishConnection<T> parent;

        InnerSubscription(org.a.c<? super T> r3, PublishConnection<T> r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.parent = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            this.parent.drain();
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.d
        public void request(long r1) {
            io.reactivex.internal.util.b.b(this, r1);
            this.parent.drain();
        }
    }

    static final class PublishConnection<T> extends AtomicInteger implements io.reactivex.disposables.b, j<T> {
        static final InnerSubscription[] EMPTY = null;
        static final InnerSubscription[] TERMINATED = null;
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        final AtomicBoolean connect;
        int consumed;
        final AtomicReference<PublishConnection<T>> current;
        volatile boolean done;
        Throwable error;
        volatile f<T> queue;
        int sourceMode;
        final AtomicReference<InnerSubscription<T>[]> subscribers;
        final AtomicReference<org.a.d> upstream;

        static {
            EMPTY = new InnerSubscription[0];
            TERMINATED = new InnerSubscription[0];
        }

        PublishConnection(AtomicReference<PublishConnection<T>> r1, int r2) {
            this.current = r1;
            this.upstream = new AtomicReference();
            this.connect = new AtomicBoolean();
            this.bufferSize = r2;
            this.subscribers = new AtomicReference(EMPTY);
        }

        boolean add(InnerSubscription<T> r5) {
        L2:
            InnerSubscription<T>[] r0 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerSubscription<T>[] r3 = new InnerSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        boolean checkTerminated(boolean r3, boolean r4) {
            int r0 = 0;
            if (r3 == false) goto L16;
            if (r4 == false) goto L16;
            Throwable r5 = this.error;
            if (r5 == null) goto L8;
            signalError(r5);
            return true;
        L8:
            InnerSubscription[] r2 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r6 = r2.length;
        L9:
            if (r0 >= r6) goto L20;
            InnerSubscription r7 = r2[r0];
            if (r7.isCancelled() == true) goto L13;
            r7.downstream.onComplete();
        L13:
            r0 = r0 + 1;
            goto L9
        L20:
            return true;
        L16:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            f<T> r0 = this.queue;
            int r2 = this.consumed;
            int r3 = this.bufferSize;
            int r4 = r3 - (r3 >> 2);
            boolean r6 = true;
            if (this.sourceMode == 1) goto L8;
            boolean r5 = true;
        L9:
            int r7 = 1;
            f<T> r8 = r0;
            int r1 = r2;
        L10:
            if (r8 == null) goto L55;
            long r9 = Long.MAX_VALUE;
            InnerSubscription<T>[] r10 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r11 = r10.length;
            int r13 = 0;
            boolean r14 = false;
        L12:
            if (r13 >= r11) goto L17;
            InnerSubscription<T> r15 = r10[r13];
            long r16 = r15.get();
            if (r16 == Long.MIN_VALUE) goto L16;
            r9 = Math.min(r16 - r15.emitted, r9);
            r14 = r6;
        L16:
            r13 = r13 + 1;
            goto L12
        L17:
            long r17 = 0;
            if (r14 == true) goto L21;
            r9 = 0;
        L21:
            if (r9 == r17) goto L52;
            boolean r12 = this.done;
            T r18 = r8.poll();     // Catch: Throwable -> L49
            if (r18 != null) goto L26;
            boolean r19 = r6;
        L28:
            if (checkTerminated(r12, r19) == true) goto L29;
            if (r19 == true) goto L52;
            int r110 = r10.length;
            int r111 = 0;
        L34:
            if (r111 >= r110) goto L40;
            InnerSubscription<T> r20 = r10[r111];
            if (r20.isCancelled() == true) goto L39;
            r20.downstream.onNext(r18);
            r20.emitted++;
        L39:
            r111 = r111 + 1;
            r7 = r7;
            goto L34
        L40:
            int r112 = r7;
            if (r5 == false) goto L45;
            r1 = r1 + 1;
            if (r1 != r4) goto L45;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r4);
            r1 = 0;
        L45:
            r9 = r9 - 1;
            r7 = r112;
            r6 = true;
            if (r10 != this.subscribers.get()) goto L10;
            r17 = 0;
            goto L21
        L29:
            return;
        L26:
            r19 = false;
        L49:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            r8.clear();
            this.done = true;
            signalError(th);
            return;
        L52:
            boolean r21 = r6;
            int r113 = r7;
            if (checkTerminated(this.done, r8.isEmpty()) == true) goto L54;
        L56:
            this.consumed = r1;
            r7 = addAndGet(-r113);
            if (r7 == 0) goto L58;
            if (r8 != null) goto L61;
            r8 = this.queue;
        L61:
            r6 = r21;
            goto L10
        L58:
            return;
        L54:
            return;
        L55:
            r21 = r6;
            r113 = r7;
            goto L56
        L8:
            r5 = false;
            goto L9
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
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            this.error = r2;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            drain();
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
            this.done = true;
            drain();
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

        void remove(InnerSubscription<T> r7) {
        L2:
            InnerSubscription<T>[] r0 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L19;
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
            InnerSubscription<T>[] r3 = EMPTY;
        L18:
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerSubscription<T>[] r5 = new InnerSubscription[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        void signalError(Throwable r5) {
            InnerSubscription[] r4 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            InnerSubscription r2 = r4[r1];
            if (r2.isCancelled() == true) goto L7;
            r2.downstream.onError(r5);
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    @Override // io.reactivex.a.a
    public void a(g<? super io.reactivex.disposables.b> r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
    L3:
        PublishConnection<T> r0 = (PublishConnection) ZeusTransformUtils.preCheckCast(this.d.get(), PublishConnection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L7:
        PublishConnection<T> r2 = new PublishConnection(this.d, this.c);
        if (this.d.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L11:
        boolean r3 = true;
        if (r0.connect.get() == false) goto L14;
    L16:
        r3 = false;
    L24:
        r7.accept(r0);     // Catch: Throwable -> L21
        if (r3 == false) goto L29;
        this.f16782b.subscribe(r0);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L14:
        if (r0.connect.compareAndSet(false, true) == false) goto L16;
    L6:
        if (r0.isDisposed() == false) goto L11;
        goto L7
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        this.d.compareAndSet((PublishConnection) ZeusTransformUtils.preCheckCast(r4, PublishConnection.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r6) {
        org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
    L3:
        PublishConnection<T> r0 = (PublishConnection) ZeusTransformUtils.preCheckCast(this.d.get(), PublishConnection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        PublishConnection<T> r2 = new PublishConnection(this.d, this.c);
        if (this.d.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L9:
        InnerSubscription<T> r5 = new InnerSubscription(r7, r0);
        r7.onSubscribe(r5);
        if (r0.add(r5) == true) goto L12;
        Throwable r8 = r0.error;
        if (r8 == null) goto L19;
        r7.onError(r8);
        return;
    L19:
        r7.onComplete();
        return;
    L12:
        if (r5.isCancelled() == false) goto L14;
        r0.remove(r5);
        return;
    L14:
        r0.drain();
    }
}
