package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableReplay<T> extends io.reactivex.c.a<T> implements io.reactivex.internal.disposables.c {
    static final a e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<T> f16979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<ReplayObserver<T>> f16980b;
    final a<T> c;
    final s<T> d;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements b<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node r0 = new Node(null);
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        Object enterTransform(Object r1) {
            return r1;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void error(Throwable r2) {
            addLast(new Node(enterTransform(NotificationLite.error(r2))));
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void next(T r2) {
            addLast(new Node(enterTransform(NotificationLite.next(r2))));
            truncate();
        }

        final void removeFirst() {
            Node r0 = (Node) ZeusTransformUtils.preCheckCast(((Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin")).get(), Node.class, "com.obric.memorydata.plugin");
            this.size--;
            setFirst(r0);
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void replay(InnerDisposable<T> r7) {
            if (r7.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r0 = 1;
        L6:
            Node r1 = (Node) ZeusTransformUtils.preCheckCast(r7.index(), Node.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L10;
            r1 = getHead();
            r7.index = r1;
        L10:
            if (r7.isDisposed() == true) goto L11;
            Node r2 = (Node) ZeusTransformUtils.preCheckCast(r1.get(), Node.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L20;
            if (NotificationLite.accept(leaveTransform(r2.value), r7.child) == true) goto L17;
            r1 = r2;
            goto L10
        L17:
            r7.index = null;
            return;
        L20:
            r7.index = r1;
            r0 = r7.addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L11:
            r7.index = null;
        }

        final void setFirst(Node r1) {
            set(r1);
        }

        final void trimHead() {
            Node r0 = (Node) ZeusTransformUtils.preCheckCast(get(), Node.class, "com.obric.memorydata.plugin");
            if (r0.value == null) goto L6;
            Node r1 = new Node(null);
            r1.lazySet(r0.get());
            set(r1);
            return;
        }

        abstract void truncate();

        void truncateFinal() {
            trimHead();
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final t<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> r3, t<? super T> r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
            this.parent = r3;
            this.child = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
            return;
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object r1) {
            this.value = r1;
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
        static final InnerDisposable[] EMPTY = null;
        static final InnerDisposable[] TERMINATED = null;
        private static final long serialVersionUID = -533785617179540163L;
        final b<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers;
        final AtomicBoolean shouldConnect;

        static {
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        ReplayObserver(b<T> r3) {
            this.buffer = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.observers = new AtomicReference(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        boolean add(InnerDisposable<T> r5) {
        L2:
            InnerDisposable[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerDisposable[] r3 = new InnerDisposable[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.observers.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.observers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.buffer.complete();
            replayFinal();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == true) goto L5;
            this.done = true;
            this.buffer.error(r2);
            replayFinal();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (this.done == true) goto L6;
            this.buffer.next(r2);
            replay();
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            replay();
            return;
        }

        void remove(InnerDisposable<T> r7) {
        L2:
            InnerDisposable[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
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
            InnerDisposable[] r3 = EMPTY;
        L18:
            if (this.observers.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            InnerDisposable[] r5 = new InnerDisposable[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        void replay() {
            InnerDisposable<T>[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.observers.get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            InnerDisposable<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L3
        }

        void replayFinal() {
            InnerDisposable<T>[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(this.observers.getAndSet(TERMINATED), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            InnerDisposable<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L3
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object enterTransform(Object r4) {
            return new io.reactivex.e.b(r4, this.scheduler.b(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object leaveTransform(Object r2) {
            return ((io.reactivex.e.b) ZeusTransformUtils.preCheckCast(r2, io.reactivex.e.b.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void error(Throwable r1) {
            add(NotificationLite.error(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void next(T r1) {
            add(NotificationLite.next(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void replay(InnerDisposable<T> r7) {
            if (r7.getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super T> r0 = r7.child;
            int r1 = 1;
        L7:
            if (r7.isDisposed() == true) goto L8;
            int r2 = this.size;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r7.index(), Integer.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L12;
            int r4 = r3.intValue();
        L13:
            if (r4 >= r2) goto L21;
            if (NotificationLite.accept(get(r4), r0) == true) goto L16;
            if (r7.isDisposed() == true) goto L19;
            r4 = r4 + 1;
            goto L13
        L19:
            return;
        L16:
            return;
        L21:
            r7.index = Integer.valueOf(r4);
            r1 = r7.addAndGet(-r1);
            if (r1 != 0) goto L7;
            return;
        L12:
            r4 = 0;
            goto L13
        }
    }

    interface a<T> {
        b<T> call();
    }

    interface b<T> {
        void complete();

        void error(Throwable r1);

        void next(T r1);

        void replay(InnerDisposable<T> r1);
    }

    static final class c implements a<Object> {
        c() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public b<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static {
        e = new c();
    }

    @Override // io.reactivex.c.a
    public void a(g<? super io.reactivex.disposables.b> r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
    L3:
        ReplayObserver<T> r0 = (ReplayObserver) ZeusTransformUtils.preCheckCast(this.f16980b.get(), ReplayObserver.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L7:
        ReplayObserver<T> r3 = new ReplayObserver(this.c.call());
        if (this.f16980b.compareAndSet(r0, r3) == false) goto L3;
        r0 = r3;
    L12:
        if (r0.shouldConnect.get() == false) goto L14;
    L16:
        boolean r1 = false;
    L26:
        r6.accept(r0);     // Catch: Throwable -> L21
        if (r1 == false) goto L31;
        this.f16979a.subscribe(r0);
        return;
    L31:
        return;
    L21:
        th = move-exception;
        if (r1 == false) goto L24;
        r0.shouldConnect.compareAndSet(true, false);
    L24:
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L14:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L16;
        r1 = true;
        goto L26
    L6:
        if (r0.isDisposed() == false) goto L12;
        goto L7
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        this.f16980b.compareAndSet((ReplayObserver) ZeusTransformUtils.preCheckCast(r4, ReplayObserver.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.d.subscribe(r4);
    }
}
