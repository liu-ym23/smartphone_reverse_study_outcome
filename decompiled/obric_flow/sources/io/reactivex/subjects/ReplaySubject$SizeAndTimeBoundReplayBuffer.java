package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class ReplaySubject$SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> {
    private static final long serialVersionUID = -8056260896137901749L;
    volatile boolean done;
    volatile ReplaySubject$TimedNode<Object> head;
    final long maxAge;
    final int maxSize;
    final z scheduler;
    int size;
    ReplaySubject$TimedNode<Object> tail;
    final TimeUnit unit;

    public ReplaySubject$SizeAndTimeBoundReplayBuffer(int r5, long r10, TimeUnit r11, z r12) {
        io.reactivex.internal.functions.e.e(r5, "maxSize");
        this.maxSize = r5;
        io.reactivex.internal.functions.e.f(r10, "maxAge");
        this.maxAge = r10;
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        this.unit = r11;
        io.reactivex.internal.functions.e.d(r12, "scheduler is null");
        this.scheduler = r12;
        ReplaySubject$TimedNode<Object> r13 = new ReplaySubject$TimedNode(null, 0);
        this.tail = r13;
        this.head = r13;
    }

    public void add(T r5) {
        ReplaySubject$TimedNode<Object> r10 = new ReplaySubject$TimedNode(r5, this.scheduler.b(this.unit));
        ReplaySubject$TimedNode<Object> r11 = this.tail;
        this.tail = r10;
        this.size++;
        r11.set(r10);
        trim();
    }

    public void addFinal(Object r5) {
        ReplaySubject$TimedNode<Object> r10 = new ReplaySubject$TimedNode(r5, Long.MAX_VALUE);
        ReplaySubject$TimedNode<Object> r11 = this.tail;
        this.tail = r10;
        this.size++;
        r11.lazySet(r10);
        trimFinal();
        this.done = true;
    }

    public ReplaySubject$TimedNode<Object> getHead() {
        ReplaySubject$TimedNode<Object> r5 = this.head;
        long r10 = this.scheduler.b(this.unit) - this.maxAge;
        ReplaySubject$TimedNode<T> r11 = r5.get();
    L3:
        ReplaySubject$TimedNode<Object> r12 = r5;
        r5 = r11;
        if (r5 == null) goto L9;
        if (r5.time > r10) goto L9;
        r11 = r5.get();
    L9:
        return r12;
    }

    public T getValue() {
        ReplaySubject$TimedNode<Object> r5 = this.head;
        ReplaySubject$TimedNode<Object> r10 = null;
    L3:
        ReplaySubject$TimedNode<T> r11 = r5.get();
        if (r11 == null) goto L6;
        r10 = r5;
        r5 = r11;
        goto L3
    L6:
        if (r5.time >= (this.scheduler.b(this.unit) - this.maxAge)) goto L8;
        return null;
    L8:
        T r12 = (T) r5.value;
        if (r12 != null) goto L12;
        return null;
    L12:
        if (NotificationLite.isComplete(r12) == true) goto L18;
        if (NotificationLite.isError(r12) == true) goto L18;
        return r12;
    L18:
        return (T) r10.value;
    }

    public T[] getValues(T[] r5) {
        ReplaySubject$TimedNode<T> r10 = getHead();
        int r11 = size(r10);
        int r12 = 0;
        if (r11 != 0) goto L8;
        if (r5.length == 0) goto L15;
        r5[0] = null;
    L15:
        return r5;
    L8:
        if (r5.length >= r11) goto L10;
        r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), r11));
    L10:
        if (r12 == r11) goto L13;
        r10 = r10.get();
        T[] r13 = r5;
        r13[r12] = r10.value;
        r12 = r12 + 1;
        goto L10
    L13:
        if (r5.length <= r11) goto L15;
        r5[r11] = null;
        goto L15
    }

    public void replay(ReplaySubject$ReplayDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        u r5 = r10.downstream;
        ReplaySubject$TimedNode<Object> r11 = (ReplaySubject$TimedNode) r10.index;
        if (r11 != null) goto L8;
        r11 = getHead();
    L8:
        int r12 = 1;
    L10:
        if (r10.cancelled == true) goto L11;
    L14:
        if (r10.cancelled == true) goto L15;
        ReplaySubject$TimedNode<T> r13 = r11.get();
        if (r13 == null) goto L20;
        T r14 = r13.value;
        if (this.done == false) goto L35;
        if (r13.get() != null) goto L35;
        if (NotificationLite.isComplete(r14) == false) goto L32;
        r5.onComplete();
    L33:
        r10.index = null;
        r10.cancelled = true;
        return;
    L32:
        r5.onError(NotificationLite.getError(r14));
    L35:
        r5.onNext(r14);
        r11 = r13;
        goto L14
    L20:
        if (r11.get() != null) goto L10;
        r10.index = r11;
        r12 = r10.addAndGet(-r12);
        if (r12 != 0) goto L10;
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

    public void trim() {
        int r5 = this.size;
        if (r5 <= this.maxSize) goto L5;
        this.size = r5 - 1;
        this.head = this.head.get();
    L5:
        long r10 = this.scheduler.b(this.unit) - this.maxAge;
        ReplaySubject$TimedNode<Object> r11 = this.head;
    L6:
        ReplaySubject$TimedNode<T> r12 = r11.get();
        if (r12 == null) goto L8;
        if (r12.time > r10) goto L11;
        r11 = r12;
        goto L6
    L11:
        this.head = r11;
        return;
    L8:
        this.head = r11;
    }

    public void trimFinal() {
        long r5 = this.scheduler.b(this.unit) - this.maxAge;
        ReplaySubject$TimedNode<Object> r10 = this.head;
    L3:
        ReplaySubject$TimedNode<T> r11 = r10.get();
        if (r11.get() == null) goto L6;
        if (r11.time > r5) goto L12;
        r10 = r11;
        goto L3
    L12:
        if (r10.value == null) goto L14;
        ReplaySubject$TimedNode<Object> r12 = new ReplaySubject$TimedNode(null, 0);
        r12.lazySet(r10.get());
        this.head = r12;
        return;
    L14:
        this.head = r10;
        return;
    L6:
        if (r10.value == null) goto L8;
        ReplaySubject$TimedNode<Object> r13 = new ReplaySubject$TimedNode(null, 0);
        r13.lazySet(r10.get());
        this.head = r13;
        return;
    L8:
        this.head = r10;
    }

    public void trimHead() {
        ReplaySubject$TimedNode<Object> r5 = this.head;
        if (r5.value == null) goto L6;
        ReplaySubject$TimedNode<Object> r10 = new ReplaySubject$TimedNode(null, 0);
        r10.lazySet(r5.get());
        this.head = r10;
        return;
    }

    public int size(ReplaySubject$TimedNode<Object> r5) {
        int r10 = 0;
    L4:
        if (r10 == Integer.MAX_VALUE) goto L17;
        ReplaySubject$TimedNode<T> r11 = r5.get();
        if (r11 == null) goto L7;
        r10 = r10 + 1;
        r5 = r11;
        goto L4
    L7:
        Object r12 = r5.value;
        if (NotificationLite.isComplete(r12) == true) goto L16;
        if (NotificationLite.isError(r12) == true) goto L16;
        return r10;
    L16:
        return r10 - 1;
    L17:
        return r10;
    }
}
