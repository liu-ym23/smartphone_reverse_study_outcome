package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class ReplaySubject$UnboundedReplayBuffer<T> extends AtomicReference<Object> {
    private static final long serialVersionUID = -733876083048047795L;
    final List<Object> buffer;
    volatile boolean done;
    volatile int size;

    public ReplaySubject$UnboundedReplayBuffer(int r5) {
        io.reactivex.internal.functions.e.e(r5, "capacityHint");
        this.buffer = new ArrayList(r5);
    }

    public void add(T r5) {
        this.buffer.add(r5);
        this.size++;
    }

    public void addFinal(Object r5) {
        this.buffer.add(r5);
        trimHead();
        this.size++;
        this.done = true;
    }

    public T getValue() {
        int r5 = this.size;
        if (r5 == 0) goto L15;
        List<Object> r10 = this.buffer;
        T r11 = (T) r10.get(r5 - 1);
        if (NotificationLite.isComplete(r11) == true) goto L11;
        if (NotificationLite.isError(r11) == true) goto L11;
        return r11;
    L11:
        if (r5 != 1) goto L14;
        return null;
    L14:
        return (T) r10.get(r5 - 2);
    L15:
        return null;
    }

    public T[] getValues(T[] r10) {
        int r5 = this.size;
        int r11 = 0;
        if (r5 == 0) goto L5;
        List<Object> r12 = this.buffer;
        Object r13 = r12.get(r5 - 1);
        if (NotificationLite.isComplete(r13) == false) goto L11;
    L12:
        r5 = r5 - 1;
        if (r5 == 0) goto L15;
    L19:
        if (r10.length >= r5) goto L21;
        r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r5));
    L21:
        if (r11 >= r5) goto L24;
        r10[r11] = r12.get(r11);
        r11 = r11 + 1;
        goto L21
    L24:
        if (r10.length <= r5) goto L26;
        r10[r5] = null;
    L26:
        return r10;
    L15:
        if (r10.length == 0) goto L17;
        r10[0] = null;
    L17:
        return r10;
    L11:
        if (NotificationLite.isError(r13) == false) goto L19;
    L5:
        if (r10.length == 0) goto L7;
        r10[0] = null;
    L7:
        return r10;
    }

    public void replay(ReplaySubject$ReplayDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        List<Object> r5 = this.buffer;
        u r11 = r10.downstream;
        Integer r12 = (Integer) r10.index;
        if (r12 == null) goto L9;
        int r13 = r12.intValue();
    L8:
        int r14 = 1;
    L11:
        if (r10.cancelled == true) goto L12;
        int r15 = this.size;
    L15:
        if (r15 == r13) goto L34;
        if (r10.cancelled == true) goto L18;
        Object r16 = r5.get(r13);
        if (this.done == false) goto L32;
        int r17 = r13 + 1;
        if (r17 != r15) goto L32;
        r15 = this.size;
        if (r17 != r15) goto L32;
        if (NotificationLite.isComplete(r16) == false) goto L29;
        r11.onComplete();
    L30:
        r10.index = null;
        r10.cancelled = true;
        return;
    L29:
        r11.onError(NotificationLite.getError(r16));
    L32:
        r11.onNext(r16);
        r13 = r13 + 1;
        goto L15
    L18:
        r10.index = null;
        return;
    L34:
        if (r13 != this.size) goto L11;
        r10.index = Integer.valueOf(r13);
        r14 = r10.addAndGet(-r14);
        if (r14 != 0) goto L11;
        return;
    L12:
        r10.index = null;
        return;
    L9:
        r13 = 0;
        r10.index = 0;
        goto L8
    }

    public int size() {
        int r5 = this.size;
        if (r5 == 0) goto L11;
        int r10 = r5 - 1;
        Object r11 = this.buffer.get(r10);
        if (NotificationLite.isComplete(r11) == false) goto L7;
    L10:
        return r10;
    L7:
        if (NotificationLite.isError(r11) == true) goto L10;
        return r5;
    L11:
        return 0;
    }

    public void trimHead() {
    }
}
