package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import io.reactivex.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableReplay<T> extends io.reactivex.a.a<T> implements io.reactivex.internal.disposables.c {
    static final Callable f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g<T> f16789b;
    final AtomicReference<ReplaySubscriber<T>> c;
    final Callable<? extends b<T>> d;
    final org.a.b<T> e;

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements b<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node r0 = new Node(null, 0);
            this.tail = r0;
            set(r0);
        }

        final void addLast(Node r2) {
            this.tail.set(r2);
            this.tail = r2;
            this.size++;
        }

        final void collect(Collection<? super T> r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            Node r0 = getHead();
        L3:
            r0 = (Node) ZeusTransformUtils.preCheckCast(r0.get(), Node.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L11;
            Object r2 = leaveTransform(r0.value);
            if (NotificationLite.isComplete(r2) == true) goto L15;
            if (NotificationLite.isError(r2) == true) goto L16;
            r6.add(NotificationLite.getValue(r2));
            goto L3
        L16:
            return;
        L15:
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void complete() {
            Object r0 = enterTransform(NotificationLite.complete());
            long r2 = this.index + 1;
            this.index = r2;
            addLast(new Node(r0, r2));
            truncateFinal();
        }

        Object enterTransform(Object r1) {
            return r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void error(Throwable r6) {
            Object r7 = enterTransform(NotificationLite.error(r6));
            long r1 = this.index + 1;
            this.index = r1;
            addLast(new Node(r7, r1));
            truncateFinal();
        }

        Node getHead() {
            return (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
        }

        boolean hasCompleted() {
            if (this.tail.value != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isComplete(leaveTransform(this.tail.value)) == false) goto L7;
            return true;
        }

        boolean hasError() {
            if (this.tail.value != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isError(leaveTransform(this.tail.value)) == false) goto L7;
            return true;
        }

        Object leaveTransform(Object r1) {
            return r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void next(T r6) {
            Object r7 = enterTransform(NotificationLite.next(r6));
            long r1 = this.index + 1;
            this.index = r1;
            addLast(new Node(r7, r1));
            truncate();
        }

        final void removeFirst() {
            Node r0 = (Node) ZeusTransformUtils.preCheckCast(((Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin")).get(), Node.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            this.size--;
            setFirst(r0);
            return;
        L7:
            throw new IllegalStateException("Empty list!");
        }

        final void removeSome(int r4) {
            Node r0 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
        L3:
            if (r4 <= 0) goto L5;
            r0 = (Node) ZeusTransformUtils.preCheckCast(r0.get(), Node.class, "com.obric.memorydata.plugin");
            r4 = r4 - 1;
            this.size--;
            goto L3
        L5:
            setFirst(r0);
            Node r5 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
            if (r5.get() != null) goto L10;
            this.tail = r5;
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void replay(InnerSubscription<T> r15) {
            monitor-enter(r15);
        L60:
            th = move-exception;
            throw th;
        L4:
            if (r15.emitting == false) goto L8;
            r15.missed = true;     // Catch: Throwable -> L60
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L8:
            r15.emitting = true;     // Catch: Throwable -> L60
            monitor-exit(r15);     // Catch: Throwable -> L60
        L11:
            if (r15.isDisposed() == true) goto L12;
            long r3 = r15.get();
            if (r3 != Long.MAX_VALUE) goto L17;
            boolean r0 = true;
        L18:
            Node r6 = (Node) ZeusTransformUtils.preCheckCast(r15.index(), Node.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L21;
            r6 = getHead();
            r15.index = r6;
            io.reactivex.internal.util.b.a(r15.totalRequested, r6.index);
        L21:
            long r9 = 0;
        L23:
            if (r3 == 0) goto L44;
            Node r11 = (Node) ZeusTransformUtils.preCheckCast(r6.get(), Node.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L44;
            Object r7 = leaveTransform(r11.value);
        L36:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r15.index = null;
            r15.dispose();
            if (NotificationLite.isError(r7) == false) goto L40;
            return;
        L40:
            if (NotificationLite.isComplete(r7) == true) goto L75;
            r15.child.onError(th);
            return;
        L75:
            return;
        L28:
            if (NotificationLite.accept(r7, r15.child) == true) goto L29;
            r9 = r9 + 1;
            r3 = r3 - 1;
            if (r15.isDisposed() == true) goto L33;
            r6 = r11;
            goto L23
        L33:
            r15.index = null;
            return;
        L29:
            r15.index = null;     // Catch: Throwable -> L36
            return;
        L44:
            if (r9 == 0) goto L48;
            r15.index = r6;
            if (r0 == true) goto L48;
            r15.produced(r9);
        L48:
            monitor-enter(r15);
        L57:
            th = move-exception;
            throw th;
        L50:
            if (r15.missed == false) goto L51;
            r15.missed = false;     // Catch: Throwable -> L57
            monitor-exit(r15);     // Catch: Throwable -> L57
            goto L11
        L51:
            r15.emitting = false;     // Catch: Throwable -> L57
            monitor-exit(r15);     // Catch: Throwable -> L57
            return;
        L17:
            r0 = false;
            goto L18
        L12:
            r15.index = null;
        }

        final void setFirst(Node r1) {
            set(r1);
        }

        final void trimHead() {
            Node r0 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
            if (r0.value == null) goto L6;
            Node r1 = new Node(null, 0);
            r1.lazySet(r0.get());
            set(r1);
            return;
        }

        void truncate() {
        }

        void truncateFinal() {
            trimHead();
        }
    }

    static final class InnerSubscription<T> extends AtomicLong implements io.reactivex.disposables.b, org.a.d {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final org.a.c<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested;

        InnerSubscription(ReplaySubscriber<T> r3, org.a.c<? super T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
            this.parent = r3;
            this.child = r5;
            this.totalRequested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            this.parent.manageRequests();
            this.index = null;
            return;
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public long produced(long r1) {
            return io.reactivex.internal.util.b.d(this, r1);
        }

        @Override // org.a.d
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (io.reactivex.internal.util.b.b(this, r5) == Long.MIN_VALUE) goto L9;
            io.reactivex.internal.util.b.a(this.totalRequested, r5);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
            return;
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object r1, long r2) {
            this.value = r1;
            this.index = r2;
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<T> {
        static final InnerSubscription[] EMPTY = null;
        static final InnerSubscription[] TERMINATED = null;
        private static final long serialVersionUID = 7224554242710036740L;
        final b<T> buffer;
        boolean done;
        final AtomicInteger management;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicBoolean shouldConnect;
        final AtomicReference<InnerSubscription<T>[]> subscribers;

        static {
            EMPTY = new InnerSubscription[0];
            TERMINATED = new InnerSubscription[0];
        }

        ReplaySubscriber(b<T> r3) {
            this.buffer = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.management = new AtomicInteger();
            this.subscribers = new AtomicReference(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        boolean add(InnerSubscription<T> r5) {
            Objects.requireNonNull(r5);
        L3:
            InnerSubscription<T>[] r0 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            if (r0 == TERMINATED) goto L5;
            int r1 = r0.length;
            InnerSubscription<T>[] r3 = new InnerSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L3;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.subscribers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        void manageRequests() {
            if (this.management.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r0 = 1;
        L7:
            if (isDisposed() == true) goto L8;
            InnerSubscription[] r1 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            long r4 = this.maxChildRequested;
            int r2 = r1.length;
            int r6 = 0;
            long r7 = r4;
        L10:
            if (r6 >= r2) goto L12;
            r7 = Math.max(r7, r1[r6].totalRequested.get());
            r6 = r6 + 1;
            goto L10
        L12:
            long r3 = this.maxUpstreamRequested;
            org.a.d r5 = (org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin");
            long r8 = r7 - r4;
            if (r8 == 0) goto L25;
            this.maxChildRequested = r7;
            if (r5 != null) goto L17;
            long r9 = r3 + r8;
            if (r9 >= 0) goto L23;
            r9 = Long.MAX_VALUE;
        L23:
            this.maxUpstreamRequested = r9;
        L29:
            r0 = this.management.addAndGet(-r0);
            if (r0 != 0) goto L7;
            return;
        L17:
            if (r3 == 0) goto L19;
            this.maxUpstreamRequested = 0;
            r3 = r3 + r8;
        L28:
            r5.request(r3);
            goto L29
        L19:
            r5.request(r8);
            goto L29
        L25:
            if (r3 == 0) goto L29;
            if (r5 == null) goto L29;
            this.maxUpstreamRequested = 0;
            goto L28
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L7;
            this.done = true;
            this.buffer.complete();
            InnerSubscription<T>[] r0 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L9;
            InnerSubscription<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L5
        L9:
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            if (this.done == true) goto L7;
            this.done = true;
            this.buffer.error(r5);
            InnerSubscription<T>[] r6 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.getAndSet(TERMINATED), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L10;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L10:
            return;
        L7:
            io.reactivex.d.a.a(r5);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == true) goto L7;
            this.buffer.next(r5);
            InnerSubscription<T>[] r6 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r5) {
            if (SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin")) == false) goto L7;
            manageRequests();
            InnerSubscription<T>[] r6 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        void remove(InnerSubscription<T> r7) {
        L2:
            InnerSubscription<T>[] r0 = (InnerSubscription[]) ZeusTransformUtils.preCheckCast(this.subscribers.get(), InnerSubscription[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L4;
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
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final u scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r1, long r2, TimeUnit r4, u r5) {
            this.scheduler = r5;
            this.limit = r1;
            this.maxAge = r2;
            this.unit = r4;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object r4) {
            return new io.reactivex.e.b(r4, this.scheduler.b(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            long r0 = this.scheduler.b(this.unit) - this.maxAge;
            Node r7 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
        L3:
            Node r2 = (Node) ZeusTransformUtils.preCheckCast(r7.get(), Node.class, "com.obric.memorydata.plugin");
            Node r3 = r7;
            r7 = r2;
            if (r7 == null) goto L14;
            io.reactivex.e.b r4 = (io.reactivex.e.b) ZeusTransformUtils.preCheckCast(r7.value, io.reactivex.e.b.class, "com.obric.memorydata.plugin");
            if (NotificationLite.isComplete(r4.a()) == true) goto L14;
            if (NotificationLite.isError(r4.a()) == true) goto L14;
            if (r4.b() <= r0) goto L3;
        L14:
            return r3;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object r2) {
            return ((io.reactivex.e.b) ZeusTransformUtils.preCheckCast(r2, io.reactivex.e.b.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            long r0 = this.scheduler.b(this.unit) - this.maxAge;
            Node r2 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
            Node r3 = (Node) ZeusTransformUtils.preCheckCast(r2.get(), Node.class, "com.obric.memorydata.plugin");
            int r5 = 0;
        L3:
            Node r9 = r3;
            Node r4 = r2;
            r2 = r9;
            if (r2 == null) goto L13;
            if (this.size <= this.limit) goto L11;
            if (this.size <= 1) goto L11;
        L12:
            r5 = r5 + 1;
            this.size--;
            r3 = (Node) ZeusTransformUtils.preCheckCast(r2.get(), Node.class, "com.obric.memorydata.plugin");
        L11:
            if (((io.reactivex.e.b) ZeusTransformUtils.preCheckCast(r2.value, io.reactivex.e.b.class, "com.obric.memorydata.plugin")).b() <= r0) goto L12;
        L13:
            if (r5 == 0) goto L20;
            setFirst(r4);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncateFinal() {
            long r0 = this.scheduler.b(this.unit) - this.maxAge;
            Node r2 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
            Node r3 = (Node) ZeusTransformUtils.preCheckCast(r2.get(), Node.class, "com.obric.memorydata.plugin");
            int r5 = 0;
        L3:
            Node r10 = r3;
            Node r4 = r2;
            r2 = r10;
            if (r2 == null) goto L10;
            if (this.size <= 1) goto L10;
            if (((io.reactivex.e.b) ZeusTransformUtils.preCheckCast(r2.value, io.reactivex.e.b.class, "com.obric.memorydata.plugin")).b() > r0) goto L10;
            r5 = r5 + 1;
            this.size--;
            r3 = (Node) ZeusTransformUtils.preCheckCast(r2.get(), Node.class, "com.obric.memorydata.plugin");
        L10:
            if (r5 == 0) goto L16;
            setFirst(r4);
            return;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int r1) {
            this.limit = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size <= this.limit) goto L6;
            removeFirst();
            return;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements b<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int r1) {
            super(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void error(Throwable r1) {
            add(NotificationLite.error(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void next(T r1) {
            add(NotificationLite.next(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void replay(InnerSubscription<T> r15) {
            monitor-enter(r15);
        L54:
            th = move-exception;
            throw th;
        L4:
            if (r15.emitting == false) goto L8;
            r15.missed = true;     // Catch: Throwable -> L54
            monitor-exit(r15);     // Catch: Throwable -> L54
            return;
        L8:
            r15.emitting = true;     // Catch: Throwable -> L54
            monitor-exit(r15);     // Catch: Throwable -> L54
            org.a.c<? super T> r0 = r15.child;
        L12:
            if (r15.isDisposed() == true) goto L13;
            int r1 = this.size;
            Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r15.index(), Integer.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L17;
            int r3 = r2.intValue();
        L18:
            long r4 = r15.get();
            long r8 = r4;
            long r10 = 0;
        L20:
            if (r8 == 0) goto L38;
            if (r3 >= r1) goto L38;
            Object r12 = get(r3);
            if (NotificationLite.accept(r12, r0) == true) goto L25;
            if (r15.isDisposed() == true) goto L28;
            r3 = r3 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
            goto L20
        L28:
            return;
        L25:
            return;
        L30:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r15.dispose();
            if (NotificationLite.isError(r12) == false) goto L34;
            return;
        L34:
            if (NotificationLite.isComplete(r12) == true) goto L69;
            r0.onError(th);
            return;
        L69:
            return;
        L38:
            if (r10 == 0) goto L42;
            r15.index = Integer.valueOf(r3);
            if (r4 == Long.MAX_VALUE) goto L42;
            r15.produced(r10);
        L42:
            monitor-enter(r15);
        L51:
            th = move-exception;
            throw th;
        L44:
            if (r15.missed == false) goto L45;
            r15.missed = false;     // Catch: Throwable -> L51
            monitor-exit(r15);     // Catch: Throwable -> L51
            goto L12
        L45:
            r15.emitting = false;     // Catch: Throwable -> L51
            monitor-exit(r15);     // Catch: Throwable -> L51
            return;
        L17:
            r3 = 0;
            goto L18
        }
    }

    static final class a implements Callable<Object> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    interface b<T> {
        void complete();

        void error(Throwable r1);

        void next(T r1);

        void replay(InnerSubscription<T> r1);
    }

    static {
        f = new a();
    }

    @Override // io.reactivex.a.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> r5) {
        io.reactivex.b.g r6 = (io.reactivex.b.g) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.g.class, "com.obric.memorydata.plugin");
    L3:
        ReplaySubscriber<T> r0 = (ReplaySubscriber) ZeusTransformUtils.preCheckCast(this.c.get(), ReplaySubscriber.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L30:
        ReplaySubscriber<T> r3 = new ReplaySubscriber((b) ZeusTransformUtils.preCheckCast(this.d.call(), b.class, "com.obric.memorydata.plugin"));
        if (this.c.compareAndSet(r0, r3) == false) goto L3;
        r0 = r3;
    L13:
        if (r0.shouldConnect.get() == false) goto L15;
    L17:
        boolean r1 = false;
    L32:
        r6.accept(r0);     // Catch: Throwable -> L22
        if (r1 == false) goto L37;
        this.f16789b.a(r0);
        return;
    L37:
        return;
    L22:
        th = move-exception;
        if (r1 == false) goto L25;
        r0.shouldConnect.compareAndSet(true, false);
    L25:
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L15:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L17;
        r1 = true;
    L27:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L6:
        if (r0.isDisposed() == false) goto L13;
        goto L30
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        this.c.compareAndSet((ReplaySubscriber) ZeusTransformUtils.preCheckCast(r4, ReplaySubscriber.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.e.subscribe(r4);
    }
}
