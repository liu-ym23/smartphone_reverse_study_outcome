package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.t;
import io.reactivex.u;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplaySubject<T> extends b<T> {
    static final ReplayDisposable[] c = null;
    static final ReplayDisposable[] d = null;
    private static final Object[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a<T> f17176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<ReplayDisposable<T>[]> f17177b;
    boolean e;

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r1) {
            this.value = r1;
        }
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final t<? super T> downstream;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(t<? super T> r3, ReplaySubject<T> r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.state = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.b(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final u scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r2, long r3, TimeUnit r5, u r6) {
            this.maxSize = io.reactivex.internal.functions.a.a(r2, "maxSize");
            this.maxAge = io.reactivex.internal.functions.a.a(r3, "maxAge");
            this.unit = (TimeUnit) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r5, "unit is null"), TimeUnit.class, "com.obric.memorydata.plugin");
            this.scheduler = (u) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r6, "scheduler is null"), u.class, "com.obric.memorydata.plugin");
            TimedNode<Object> r4 = new TimedNode(null, 0);
            this.tail = r4;
            this.head = r4;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r4) {
            TimedNode<Object> r0 = new TimedNode(r4, this.scheduler.b(this.unit));
            TimedNode<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.set(r0);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r4) {
            TimedNode<Object> r0 = new TimedNode(r4, Long.MAX_VALUE);
            TimedNode<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.lazySet(r0);
            trimFinal();
            this.done = true;
        }

        TimedNode<Object> getHead() {
            TimedNode<Object> r0 = this.head;
            long r1 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<T> r8 = r0.get();
            Class<TimedNode> r3 = TimedNode.class;
        L3:
            TimedNode<Object> r7 = r0;
            r0 = (TimedNode) ZeusTransformUtils.preCheckCast(r8, r3, "com.obric.memorydata.plugin");
            if (r0 == null) goto L9;
            if (r0.time > r1) goto L9;
            r8 = r0.get();
            r3 = TimedNode.class;
        L9:
            return r7;
        }

        public T getValue() {
            TimedNode<Object> r0 = this.head;
            TimedNode<Object> r2 = null;
        L3:
            TimedNode<Object> r3 = (TimedNode) ZeusTransformUtils.preCheckCast(r0.get(), TimedNode.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L6;
            r2 = r0;
            r0 = r3;
            goto L3
        L6:
            if (r0.time >= (this.scheduler.b(this.unit) - this.maxAge)) goto L8;
            return null;
        L8:
            T r7 = (T) r0.value;
            if (r7 != null) goto L12;
            return null;
        L12:
            if (NotificationLite.isComplete(r7) == true) goto L18;
            if (NotificationLite.isError(r7) == true) goto L18;
            return r7;
        L18:
            return (T) r2.value;
        }

        public T[] getValues(T[] r6) {
            TimedNode<Object> r0 = getHead();
            int r5 = size(r0);
            int r2 = 0;
            if (r5 != 0) goto L8;
            if (r6.length == 0) goto L15;
            r6[0] = null;
        L15:
            return r6;
        L8:
            if (r6.length >= r5) goto L10;
            r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6.getClass().getComponentType(), r5), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        L10:
            if (r2 == r5) goto L13;
            r0 = (TimedNode) ZeusTransformUtils.preCheckCast(r0.get(), TimedNode.class, "com.obric.memorydata.plugin");
            T[] r7 = r6;
            r7[r2] = r0.value;
            r2 = r2 + 1;
            goto L10
        L13:
            if (r6.length <= r5) goto L15;
            r6[r5] = null;
            goto L15
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r9) {
            if (r9.getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super T> r0 = r9.downstream;
            TimedNode<Object> r1 = (TimedNode) ZeusTransformUtils.preCheckCast(r9.index, TimedNode.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L8;
            r1 = getHead();
        L8:
            int r4 = 1;
        L10:
            if (r9.cancelled == true) goto L11;
        L14:
            if (r9.cancelled == true) goto L15;
            TimedNode<Object> r5 = (TimedNode) ZeusTransformUtils.preCheckCast(r1.get(), TimedNode.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L20;
            $$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0 r2 = (Object) r5.value;
            if (this.done == false) goto L35;
            if (r5.get() != null) goto L35;
            if (NotificationLite.isComplete(r2) == false) goto L32;
            r0.onComplete();
        L33:
            r9.index = null;
            r9.cancelled = true;
            return;
        L32:
            r0.onError(NotificationLite.getError(r2));
        L35:
            r0.onNext(r2);
            r1 = r5;
            goto L14
        L20:
            if (r1.get() != null) goto L10;
            r9.index = r1;
            r4 = r9.addAndGet(-r4);
            if (r4 != 0) goto L10;
            return;
        L15:
            r9.index = null;
            return;
        L11:
            r9.index = null;
        }

        public int size() {
            return size(getHead());
        }

        int size(TimedNode<Object> r4) {
            int r3 = 0;
        L4:
            if (r3 == Integer.MAX_VALUE) goto L17;
            TimedNode<Object> r0 = (TimedNode) ZeusTransformUtils.preCheckCast(r4.get(), TimedNode.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            r3 = r3 + 1;
            r4 = r0;
            goto L4
        L7:
            Object r5 = r4.value;
            if (NotificationLite.isComplete(r5) == true) goto L16;
            if (NotificationLite.isError(r5) == true) goto L16;
            return r3;
        L16:
            return r3 - 1;
        L17:
            return r3;
        }

        void trim() {
            int r0 = this.size;
            if (r0 <= this.maxSize) goto L5;
            this.size = r0 - 1;
            this.head = (TimedNode) ZeusTransformUtils.preCheckCast(this.head.get(), TimedNode.class, "com.obric.memorydata.plugin");
        L5:
            long r1 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> r4 = this.head;
        L7:
            if (this.size <= 1) goto L8;
            TimedNode<Object> r5 = (TimedNode) ZeusTransformUtils.preCheckCast(r4.get(), TimedNode.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            if (r5.time > r1) goto L8;
            this.size--;
            r4 = r5;
        L8:
            this.head = r4;
        }

        void trimFinal() {
            long r0 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> r2 = this.head;
        L3:
            TimedNode<Object> r3 = (TimedNode) ZeusTransformUtils.preCheckCast(r2.get(), TimedNode.class, "com.obric.memorydata.plugin");
            if (r3.get() == null) goto L6;
            if (r3.time > r0) goto L13;
            r2 = r3;
            goto L3
        L13:
            if (r2.value != null) goto L14;
        L9:
            this.head = r2;
            return;
        L14:
            TimedNode<Object> r1 = new TimedNode(null, 0);
        L8:
            r1.lazySet(r2.get());
            this.head = r1;
            return;
        L6:
            if (r2.value == null) goto L9;
            r1 = new TimedNode(null, 0);
            goto L8
        }

        public void trimHead() {
            TimedNode<Object> r0 = this.head;
            if (r0.value == null) goto L6;
            TimedNode<Object> r1 = new TimedNode(null, 0);
            r1.lazySet(r0.get());
            this.head = r1;
            return;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int r2) {
            this.maxSize = io.reactivex.internal.functions.a.a(r2, "maxSize");
            Node<Object> r3 = new Node(null);
            this.tail = r3;
            this.head = r3;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r3) {
            Node<Object> r0 = new Node(r3);
            Node<Object> r4 = this.tail;
            this.tail = r0;
            this.size++;
            r4.set(r0);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r4) {
            Node<Object> r0 = new Node(r4);
            Node<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.lazySet(r0);
            trimHead();
            this.done = true;
        }

        public T getValue() {
            Node<Object> r5 = this.head;
            Node<Object> r1 = null;
        L3:
            Node<Object> r2 = (Node) ZeusTransformUtils.preCheckCast(r5.get(), Node.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L5;
            r1 = r5;
            r5 = r2;
            goto L3
        L5:
            T r6 = (T) r5.value;
            if (r6 != null) goto L9;
            return null;
        L9:
            if (NotificationLite.isComplete(r6) == true) goto L15;
            if (NotificationLite.isError(r6) == true) goto L15;
            return r6;
        L15:
            return (T) r1.value;
        }

        public T[] getValues(T[] r6) {
            Node<Object> r0 = this.head;
            int r5 = size();
            int r2 = 0;
            if (r5 != 0) goto L8;
            if (r6.length == 0) goto L15;
            r6[0] = null;
        L15:
            return r6;
        L8:
            if (r6.length >= r5) goto L10;
            r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6.getClass().getComponentType(), r5), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        L10:
            if (r2 == r5) goto L13;
            r0 = (Node) ZeusTransformUtils.preCheckCast(r0.get(), Node.class, "com.obric.memorydata.plugin");
            T[] r7 = r6;
            r7[r2] = r0.value;
            r2 = r2 + 1;
            goto L10
        L13:
            if (r6.length <= r5) goto L15;
            r6[r5] = null;
            goto L15
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r9) {
            if (r9.getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super T> r0 = r9.downstream;
            Node<Object> r1 = (Node) ZeusTransformUtils.preCheckCast(r9.index, Node.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L8;
            r1 = this.head;
        L8:
            int r4 = 1;
        L10:
            if (r9.cancelled == true) goto L11;
            Node<Object> r5 = (Node) ZeusTransformUtils.preCheckCast(r1.get(), Node.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L16;
            $$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0 r2 = (Object) r5.value;
            if (this.done == true) goto L24;
        L31:
            r0.onNext(r2);
            r1 = r5;
            goto L10
        L24:
            if (r5.get() != null) goto L31;
            if (NotificationLite.isComplete(r2) == false) goto L28;
            r0.onComplete();
        L29:
            r9.index = null;
            r9.cancelled = true;
            return;
        L28:
            r0.onError(NotificationLite.getError(r2));
            goto L29
        L16:
            if (r1.get() != null) goto L10;
            r9.index = r1;
            r4 = r9.addAndGet(-r4);
            if (r4 != 0) goto L10;
            return;
        L11:
            r9.index = null;
        }

        public int size() {
            Node<Object> r4 = this.head;
            int r0 = 0;
        L4:
            if (r0 == Integer.MAX_VALUE) goto L17;
            Node<Object> r1 = (Node) ZeusTransformUtils.preCheckCast(r4.get(), Node.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            r0 = r0 + 1;
            r4 = r1;
            goto L4
        L7:
            Object r5 = r4.value;
            if (NotificationLite.isComplete(r5) == true) goto L16;
            if (NotificationLite.isError(r5) == true) goto L16;
            return r0;
        L16:
            return r0 - 1;
        L17:
            return r0;
        }

        void trim() {
            int r0 = this.size;
            if (r0 <= this.maxSize) goto L6;
            this.size = r0 - 1;
            this.head = (Node) ZeusTransformUtils.preCheckCast(this.head.get(), Node.class, "com.obric.memorydata.plugin");
            return;
        }

        public void trimHead() {
            Node<Object> r0 = this.head;
            if (r0.value == null) goto L6;
            Node<Object> r1 = new Node(null);
            r1.lazySet(r0.get());
            this.head = r1;
            return;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T r1, long r2) {
            this.value = r1;
            this.time = r2;
        }
    }

    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        UnboundedReplayBuffer(int r3) {
            this.buffer = new ArrayList(io.reactivex.internal.functions.a.a(r3, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r2) {
            this.buffer.add(r2);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r2) {
            this.buffer.add(r2);
            trimHead();
            this.size++;
            this.done = true;
        }

        public T getValue() {
            int r0 = this.size;
            if (r0 == 0) goto L15;
            List<Object> r4 = this.buffer;
            T r2 = (T) r4.get(r0 - 1);
            if (NotificationLite.isComplete(r2) == true) goto L11;
            if (NotificationLite.isError(r2) == true) goto L11;
            return r2;
        L11:
            if (r0 != 1) goto L14;
            return null;
        L14:
            return (T) r4.get(r0 - 2);
        L15:
            return null;
        }

        public T[] getValues(T[] r6) {
            int r0 = this.size;
            int r2 = 0;
            if (r0 == 0) goto L5;
            List<Object> r5 = this.buffer;
            Object r3 = r5.get(r0 - 1);
            if (NotificationLite.isComplete(r3) == false) goto L11;
        L12:
            r0 = r0 - 1;
            if (r0 == 0) goto L15;
        L19:
            if (r6.length >= r0) goto L21;
            r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        L21:
            if (r2 >= r0) goto L24;
            r6[r2] = r5.get(r2);
            r2 = r2 + 1;
            goto L21
        L24:
            if (r6.length <= r0) goto L26;
            r6[r0] = null;
        L26:
            return r6;
        L15:
            if (r6.length == 0) goto L17;
            r6[0] = null;
        L17:
            return r6;
        L11:
            if (NotificationLite.isError(r3) == false) goto L19;
        L5:
            if (r6.length == 0) goto L7;
            r6[0] = null;
        L7:
            return r6;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<Object> r0 = this.buffer;
            t<? super T> r1 = r10.downstream;
            Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r10.index, Integer.class, "com.obric.memorydata.plugin");
            int r3 = 0;
            if (r2 == null) goto L8;
            r3 = r2.intValue();
        L9:
            int r4 = 1;
        L11:
            if (r10.cancelled == true) goto L12;
            int r5 = this.size;
        L15:
            if (r5 == r3) goto L34;
            if (r10.cancelled == true) goto L18;
            Object r7 = r0.get(r3);
            if (this.done == false) goto L32;
            int r8 = r3 + 1;
            if (r8 != r5) goto L32;
            r5 = this.size;
            if (r8 != r5) goto L32;
            if (NotificationLite.isComplete(r7) == false) goto L29;
            r1.onComplete();
        L30:
            r10.index = null;
            r10.cancelled = true;
            return;
        L29:
            r1.onError(NotificationLite.getError(r7));
        L32:
            r1.onNext(r7);
            r3 = r3 + 1;
            goto L15
        L18:
            r10.index = null;
            return;
        L34:
            if (r3 != this.size) goto L11;
            r10.index = Integer.valueOf(r3);
            r4 = r10.addAndGet(-r4);
            if (r4 != 0) goto L11;
            return;
        L12:
            r10.index = null;
            return;
        L8:
            r10.index = 0;
            goto L9
        }

        public int size() {
            int r0 = this.size;
            if (r0 == 0) goto L11;
            int r1 = r0 - 1;
            Object r3 = this.buffer.get(r1);
            if (NotificationLite.isComplete(r3) == false) goto L7;
        L10:
            return r1;
        L7:
            if (NotificationLite.isError(r3) == true) goto L10;
            return r0;
        L11:
            return 0;
        }

        public void trimHead() {
        }
    }

    interface a<T> {
        void add(T r1);

        void addFinal(Object r1);

        boolean compareAndSet(Object r1, Object r2);

        void replay(ReplayDisposable<T> r1);
    }

    static {
        c = new ReplayDisposable[0];
        d = new ReplayDisposable[0];
        f = new Object[0];
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        ReplayDisposable<T> r0 = new ReplayDisposable(r4, this);
        r4.onSubscribe(r0);
        if (r0.cancelled == false) goto L5;
        return;
    L5:
        if (a(r0) == true) goto L7;
    L10:
        this.f17176a.replay(r0);
        return;
    L7:
        if (r0.cancelled == false) goto L10;
        b(r0);
    }

    boolean a(ReplayDisposable<T> r5) {
    L2:
        ReplayDisposable<T>[] r0 = (ReplayDisposable[]) ZeusTransformUtils.preCheckCast(this.f17177b.get(), ReplayDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == d) goto L4;
        int r1 = r0.length;
        ReplayDisposable<T>[] r3 = new ReplayDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.f17177b.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    ReplayDisposable<T>[] a(Object r3) {
        if (this.f17176a.compareAndSet(null, r3) == false) goto L7;
        return (ReplayDisposable[]) ZeusTransformUtils.preCheckCast(this.f17177b.getAndSet(d), ReplayDisposable[].class, "com.obric.memorydata.plugin");
    L7:
        return d;
    }

    void b(ReplayDisposable<T> r7) {
    L2:
        ReplayDisposable<T>[] r0 = (ReplayDisposable[]) ZeusTransformUtils.preCheckCast(this.f17177b.get(), ReplayDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == d) goto L21;
        if (r0 == c) goto L29;
        int r1 = r0.length;
        int r2 = -1;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L13;
        if (r0[r4] == r7) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r2 = r4;
    L13:
        if (r2 < 0) goto L14;
        if (r1 != 1) goto L18;
        ReplayDisposable<T>[] r3 = c;
    L20:
        if (this.f17177b.compareAndSet(r0, r3) == false) goto L2;
        return;
    L18:
        ReplayDisposable<T>[] r5 = new ReplayDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L20
    L14:
        return;
    L29:
        return;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        Object r0 = NotificationLite.complete();
        a<T> r1 = this.f17176a;
        r1.addFinal(r0);
        ReplayDisposable<T>[] r4 = a(r0);
        int r2 = r4.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.replay(r4[r3]);
        r3 = r3 + 1;
        goto L6
    }

    @Override // io.reactivex.t
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.e = true;
        Object r5 = NotificationLite.error(r4);
        a<T> r0 = this.f17176a;
        r0.addFinal(r5);
        ReplayDisposable<T>[] r3 = a(r5);
        int r6 = r3.length;
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L9;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // io.reactivex.t
    public void onNext(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L5;
        return;
    L5:
        a<T> r0 = this.f17176a;
        r0.add(r4);
        ReplayDisposable<T>[] r3 = (ReplayDisposable[]) ZeusTransformUtils.preCheckCast(this.f17177b.get(), ReplayDisposable[].class, "com.obric.memorydata.plugin");
        int r5 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L8;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L6
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.e == false) goto L6;
        r4.dispose();
        return;
    }
}
