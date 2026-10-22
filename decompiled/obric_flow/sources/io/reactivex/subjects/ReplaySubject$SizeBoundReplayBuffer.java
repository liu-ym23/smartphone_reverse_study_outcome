package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class ReplaySubject$SizeBoundReplayBuffer<T> extends AtomicReference<Object> {
    private static final long serialVersionUID = 1107649250281456395L;
    volatile boolean done;
    volatile ReplaySubject$Node<Object> head;
    final int maxSize;
    int size;
    ReplaySubject$Node<Object> tail;

    public ReplaySubject$SizeBoundReplayBuffer(int r5) {
        io.reactivex.internal.functions.e.e(r5, "maxSize");
        this.maxSize = r5;
        ReplaySubject$Node<Object> r10 = new ReplaySubject$Node(null);
        this.tail = r10;
        this.head = r10;
    }

    public void add(T r5) {
        ReplaySubject$Node<Object> r10 = new ReplaySubject$Node(r5);
        ReplaySubject$Node<Object> r11 = this.tail;
        this.tail = r10;
        this.size++;
        r11.set(r10);
        trim();
    }

    public void addFinal(Object r5) {
        ReplaySubject$Node<Object> r10 = new ReplaySubject$Node(r5);
        ReplaySubject$Node<Object> r11 = this.tail;
        this.tail = r10;
        this.size++;
        r11.lazySet(r10);
        trimHead();
        this.done = true;
    }

    public T getValue() {
        ReplaySubject$Node<Object> r5 = this.head;
        ReplaySubject$Node<Object> r10 = null;
    L3:
        ReplaySubject$Node<T> r11 = r5.get();
        if (r11 == null) goto L5;
        r10 = r5;
        r5 = r11;
        goto L3
    L5:
        T r12 = (T) r5.value;
        if (r12 != null) goto L9;
        return null;
    L9:
        if (NotificationLite.isComplete(r12) == true) goto L15;
        if (NotificationLite.isError(r12) == true) goto L15;
        return r12;
    L15:
        return (T) r10.value;
    }

    public T[] getValues(T[] r5) {
        ReplaySubject$Node<T> r10 = this.head;
        int r11 = size();
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
        ReplaySubject$Node<Object> r11 = (ReplaySubject$Node) r10.index;
        if (r11 != null) goto L8;
        r11 = this.head;
    L8:
        int r12 = 1;
    L10:
        if (r10.cancelled == true) goto L11;
        ReplaySubject$Node<T> r13 = r11.get();
        if (r13 == null) goto L16;
        T r14 = r13.value;
        if (this.done == true) goto L24;
    L31:
        r5.onNext(r14);
        r11 = r13;
        goto L10
    L24:
        if (r13.get() != null) goto L31;
        if (NotificationLite.isComplete(r14) == false) goto L28;
        r5.onComplete();
    L29:
        r10.index = null;
        r10.cancelled = true;
        return;
    L28:
        r5.onError(NotificationLite.getError(r14));
        goto L29
    L16:
        if (r11.get() != null) goto L10;
        r10.index = r11;
        r12 = r10.addAndGet(-r12);
        if (r12 != 0) goto L10;
        return;
    L11:
        r10.index = null;
    }

    public int size() {
        ReplaySubject$Node<Object> r5 = this.head;
        int r10 = 0;
    L4:
        if (r10 == Integer.MAX_VALUE) goto L17;
        ReplaySubject$Node<T> r11 = r5.get();
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

    public void trim() {
        int r5 = this.size;
        if (r5 <= this.maxSize) goto L6;
        this.size = r5 - 1;
        this.head = this.head.get();
        return;
    }

    public void trimHead() {
        ReplaySubject$Node<Object> r5 = this.head;
        if (r5.value == null) goto L6;
        ReplaySubject$Node<Object> r10 = new ReplaySubject$Node(null);
        r10.lazySet(r5.get());
        this.head = r10;
        return;
    }
}
