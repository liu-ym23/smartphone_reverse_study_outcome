package io.reactivex.subjects;

import io.reactivex.disposables.b;
import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class ReplaySubject<T> extends a<T> {

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r10) {
            this.value = r10;
        }
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final o<? super T> downstream;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(o<? super T> r10, ReplaySubject<T> r11) {
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final p scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r10, long r11, TimeUnit r12, p r13) {
            this.maxSize = io.reactivex.internal.functions.a.e(r10, "maxSize");
            this.maxAge = io.reactivex.internal.functions.a.f(r11, "maxAge");
            this.unit = (TimeUnit) io.reactivex.internal.functions.a.d(r12, "unit is null");
            this.scheduler = (p) io.reactivex.internal.functions.a.d(r13, "scheduler is null");
            TimedNode<Object> r14 = new TimedNode(null, 0);
            this.tail = r14;
            this.head = r14;
        }

        public void add(T r10) {
            TimedNode<Object> r11 = new TimedNode(r10, this.scheduler.b(this.unit));
            TimedNode<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.set(r11);
            trim();
        }

        public void addFinal(Object r10) {
            TimedNode<Object> r11 = new TimedNode(r10, Long.MAX_VALUE);
            TimedNode<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.lazySet(r11);
            trimFinal();
            this.done = true;
        }

        TimedNode<Object> getHead() {
            TimedNode<Object> r10 = this.head;
            long r11 = this.scheduler.b(this.unit) - this.maxAge;
        L3:
            TimedNode<Object> r12 = r10;
            r10 = r10.get();
            if (r10 == null) goto L7;
            if (r10.time <= r11) goto L3;
        L7:
            return r12;
        }

        public T getValue() {
            TimedNode<Object> r10 = this.head;
            TimedNode<Object> r11 = null;
        L3:
            TimedNode<T> r12 = r10.get();
            if (r12 == null) goto L6;
            r11 = r10;
            r10 = r12;
            goto L3
        L6:
            if (r10.time >= (this.scheduler.b(this.unit) - this.maxAge)) goto L8;
            return null;
        L8:
            T r13 = (T) r10.value;
            if (r13 != null) goto L12;
            return null;
        L12:
            if (NotificationLite.isComplete(r13) == true) goto L18;
            if (NotificationLite.isError(r13) == true) goto L18;
            return r13;
        L18:
            return (T) r11.value;
        }

        public T[] getValues(T[] r10) {
            TimedNode<T> r11 = getHead();
            int r12 = size(r11);
            int r13 = 0;
            if (r12 != 0) goto L8;
            if (r10.length == 0) goto L15;
            r10[0] = null;
        L15:
            return r10;
        L8:
            if (r10.length >= r12) goto L10;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r12));
        L10:
            if (r13 == r12) goto L13;
            r11 = r11.get();
            T[] r14 = r10;
            r14[r13] = r11.value;
            r13 = r13 + 1;
            goto L10
        L13:
            if (r10.length <= r12) goto L15;
            r10[r12] = null;
            goto L15
        }

        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            o<? super T> r11 = r10.downstream;
            TimedNode<Object> r12 = (TimedNode) r10.index;
            if (r12 != null) goto L8;
            r12 = getHead();
        L8:
            int r13 = 1;
        L10:
            if (r10.cancelled == true) goto L11;
        L14:
            if (r10.cancelled == true) goto L15;
            TimedNode<T> r14 = r12.get();
            if (r14 == null) goto L20;
            T r15 = r14.value;
            if (this.done == false) goto L35;
            if (r14.get() != null) goto L35;
            if (NotificationLite.isComplete(r15) == false) goto L32;
            r11.onComplete();
        L33:
            r10.index = null;
            r10.cancelled = true;
            return;
        L32:
            r11.onError(NotificationLite.getError(r15));
        L35:
            r11.onNext(r15);
            r12 = r14;
            goto L14
        L20:
            if (r12.get() != null) goto L10;
            r10.index = r12;
            r13 = r10.addAndGet(-r13);
            if (r13 != 0) goto L10;
            return;
        L15:
            r10.index = null;
            return;
        L11:
            r10.index = null;
        }

        public int size() {
            return size(getHead());
        }

        int size(TimedNode<Object> r10) {
            int r11 = 0;
        L4:
            if (r11 == Integer.MAX_VALUE) goto L17;
            TimedNode<T> r12 = r10.get();
            if (r12 == null) goto L7;
            r11 = r11 + 1;
            r10 = r12;
            goto L4
        L7:
            Object r13 = r10.value;
            if (NotificationLite.isComplete(r13) == true) goto L16;
            if (NotificationLite.isError(r13) == true) goto L16;
            return r11;
        L16:
            return r11 - 1;
        L17:
            return r11;
        }

        void trim() {
            int r10 = this.size;
            if (r10 <= this.maxSize) goto L5;
            this.size = r10 - 1;
            this.head = this.head.get();
        L5:
            long r11 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> r12 = this.head;
        L6:
            TimedNode<T> r13 = r12.get();
            if (r13 == null) goto L8;
            if (r13.time > r11) goto L8;
            r12 = r13;
        L8:
            this.head = r12;
        }

        void trimFinal() {
            long r10 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> r11 = this.head;
        L3:
            TimedNode<T> r12 = r11.get();
            if (r12.get() == null) goto L6;
            if (r12.time > r10) goto L13;
            r11 = r12;
            goto L3
        L13:
            if (r11.value != null) goto L14;
        L9:
            this.head = r11;
            return;
        L14:
            TimedNode<Object> r13 = new TimedNode(null, 0);
        L8:
            r13.lazySet(r11.get());
            this.head = r13;
            return;
        L6:
            if (r11.value == null) goto L9;
            r13 = new TimedNode(null, 0);
            goto L8
        }

        public void trimHead() {
            TimedNode<Object> r10 = this.head;
            if (r10.value == null) goto L6;
            TimedNode<Object> r11 = new TimedNode(null, 0);
            r11.lazySet(r10.get());
            this.head = r11;
            return;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int r10) {
            this.maxSize = io.reactivex.internal.functions.a.e(r10, "maxSize");
            Node<Object> r11 = new Node(null);
            this.tail = r11;
            this.head = r11;
        }

        public void add(T r10) {
            Node<Object> r11 = new Node(r10);
            Node<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.set(r11);
            trim();
        }

        public void addFinal(Object r10) {
            Node<Object> r11 = new Node(r10);
            Node<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.lazySet(r11);
            trimHead();
            this.done = true;
        }

        public T getValue() {
            Node<Object> r10 = this.head;
            Node<Object> r11 = null;
        L3:
            Node<T> r12 = r10.get();
            if (r12 == null) goto L5;
            r11 = r10;
            r10 = r12;
            goto L3
        L5:
            T r13 = (T) r10.value;
            if (r13 != null) goto L9;
            return null;
        L9:
            if (NotificationLite.isComplete(r13) == true) goto L15;
            if (NotificationLite.isError(r13) == true) goto L15;
            return r13;
        L15:
            return (T) r11.value;
        }

        public T[] getValues(T[] r10) {
            Node<T> r11 = this.head;
            int r12 = size();
            int r13 = 0;
            if (r12 != 0) goto L8;
            if (r10.length == 0) goto L15;
            r10[0] = null;
        L15:
            return r10;
        L8:
            if (r10.length >= r12) goto L10;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r12));
        L10:
            if (r13 == r12) goto L13;
            r11 = r11.get();
            T[] r14 = r10;
            r14[r13] = r11.value;
            r13 = r13 + 1;
            goto L10
        L13:
            if (r10.length <= r12) goto L15;
            r10[r12] = null;
            goto L15
        }

        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            o<? super T> r11 = r10.downstream;
            Node<Object> r12 = (Node) r10.index;
            if (r12 != null) goto L8;
            r12 = this.head;
        L8:
            int r13 = 1;
        L10:
            if (r10.cancelled == true) goto L11;
            Node<T> r14 = r12.get();
            if (r14 == null) goto L16;
            T r15 = r14.value;
            if (this.done == true) goto L24;
        L31:
            r11.onNext(r15);
            r12 = r14;
            goto L10
        L24:
            if (r14.get() != null) goto L31;
            if (NotificationLite.isComplete(r15) == false) goto L28;
            r11.onComplete();
        L29:
            r10.index = null;
            r10.cancelled = true;
            return;
        L28:
            r11.onError(NotificationLite.getError(r15));
            goto L29
        L16:
            if (r12.get() != null) goto L10;
            r10.index = r12;
            r13 = r10.addAndGet(-r13);
            if (r13 != 0) goto L10;
            return;
        L11:
            r10.index = null;
        }

        public int size() {
            Node<Object> r10 = this.head;
            int r11 = 0;
        L4:
            if (r11 == Integer.MAX_VALUE) goto L17;
            Node<T> r12 = r10.get();
            if (r12 == null) goto L7;
            r11 = r11 + 1;
            r10 = r12;
            goto L4
        L7:
            Object r13 = r10.value;
            if (NotificationLite.isComplete(r13) == true) goto L16;
            if (NotificationLite.isError(r13) == true) goto L16;
            return r11;
        L16:
            return r11 - 1;
        L17:
            return r11;
        }

        void trim() {
            int r10 = this.size;
            if (r10 <= this.maxSize) goto L6;
            this.size = r10 - 1;
            this.head = this.head.get();
            return;
        }

        public void trimHead() {
            Node<Object> r10 = this.head;
            if (r10.value == null) goto L6;
            Node<Object> r11 = new Node(null);
            r11.lazySet(r10.get());
            this.head = r11;
            return;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T r10, long r11) {
            this.value = r10;
            this.time = r11;
        }
    }

    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        UnboundedReplayBuffer(int r10) {
            this.buffer = new ArrayList(io.reactivex.internal.functions.a.e(r10, "capacityHint"));
        }

        public void add(T r10) {
            this.buffer.add(r10);
            this.size++;
        }

        public void addFinal(Object r10) {
            this.buffer.add(r10);
            trimHead();
            this.size++;
            this.done = true;
        }

        public T getValue() {
            int r10 = this.size;
            if (r10 == 0) goto L15;
            List<Object> r11 = this.buffer;
            T r12 = (T) r11.get(r10 - 1);
            if (NotificationLite.isComplete(r12) == true) goto L11;
            if (NotificationLite.isError(r12) == true) goto L11;
            return r12;
        L11:
            if (r10 != 1) goto L14;
            return null;
        L14:
            return (T) r11.get(r10 - 2);
        L15:
            return null;
        }

        public T[] getValues(T[] r10) {
            int r11 = this.size;
            int r12 = 0;
            if (r11 == 0) goto L5;
            List<Object> r13 = this.buffer;
            Object r14 = r13.get(r11 - 1);
            if (NotificationLite.isComplete(r14) == false) goto L11;
        L12:
            r11 = r11 - 1;
            if (r11 == 0) goto L15;
        L19:
            if (r10.length >= r11) goto L21;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r11));
        L21:
            if (r12 >= r11) goto L24;
            r10[r12] = r13.get(r12);
            r12 = r12 + 1;
            goto L21
        L24:
            if (r10.length <= r11) goto L26;
            r10[r11] = null;
        L26:
            return r10;
        L15:
            if (r10.length == 0) goto L17;
            r10[0] = null;
        L17:
            return r10;
        L11:
            if (NotificationLite.isError(r14) == false) goto L19;
        L5:
            if (r10.length == 0) goto L7;
            r10[0] = null;
        L7:
            return r10;
        }

        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<Object> r11 = this.buffer;
            o<? super T> r12 = r10.downstream;
            Integer r13 = (Integer) r10.index;
            int r14 = 0;
            if (r13 == null) goto L8;
            r14 = r13.intValue();
        L9:
            int r15 = 1;
        L11:
            if (r10.cancelled == true) goto L12;
            int r16 = this.size;
        L15:
            if (r16 == r14) goto L34;
            if (r10.cancelled == true) goto L18;
            Object r17 = r11.get(r14);
            if (this.done == false) goto L32;
            int r18 = r14 + 1;
            if (r18 != r16) goto L32;
            r16 = this.size;
            if (r18 != r16) goto L32;
            if (NotificationLite.isComplete(r17) == false) goto L29;
            r12.onComplete();
        L30:
            r10.index = null;
            r10.cancelled = true;
            return;
        L29:
            r12.onError(NotificationLite.getError(r17));
        L32:
            r12.onNext(r17);
            r14 = r14 + 1;
            goto L15
        L18:
            r10.index = null;
            return;
        L34:
            if (r14 != this.size) goto L11;
            r10.index = Integer.valueOf(r14);
            r15 = r10.addAndGet(-r15);
            if (r15 != 0) goto L11;
            return;
        L12:
            r10.index = null;
            return;
        L8:
            r10.index = 0;
            goto L9
        }

        public int size() {
            int r10 = this.size;
            if (r10 == 0) goto L11;
            int r11 = r10 - 1;
            Object r12 = this.buffer.get(r11);
            if (NotificationLite.isComplete(r12) == false) goto L7;
        L10:
            return r11;
        L7:
            if (NotificationLite.isError(r12) == true) goto L10;
            return r10;
        L11:
            return 0;
        }

        public void trimHead() {
        }
    }
}
