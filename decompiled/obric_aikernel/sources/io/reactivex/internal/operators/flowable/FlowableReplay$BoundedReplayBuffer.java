package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements i<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    int size;
    FlowableReplay$Node tail;

    FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node r10 = new FlowableReplay$Node(null, 0);
        this.tail = r10;
        set(r10);
    }

    final void addLast(FlowableReplay$Node r10) {
        this.tail.set(r10);
        this.tail = r10;
        this.size++;
    }

    final void collect(Collection<? super T> r10) {
        FlowableReplay$Node r11 = getHead();
    L3:
        r11 = r11.get();
        if (r11 == null) goto L11;
        Object r12 = leaveTransform(r11.value);
        if (NotificationLite.isComplete(r12) == true) goto L15;
        if (NotificationLite.isError(r12) == true) goto L16;
        r10.add((Object) NotificationLite.getValue(r12));
        goto L3
    L16:
        return;
    L15:
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public final void complete() {
        Object r10 = enterTransform(NotificationLite.complete());
        long r11 = this.index + 1;
        this.index = r11;
        addLast(new FlowableReplay$Node(r10, r11));
        truncateFinal();
    }

    Object enterTransform(Object r10) {
        return r10;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public final void error(Throwable r10) {
        Object r11 = enterTransform(NotificationLite.error(r10));
        long r12 = this.index + 1;
        this.index = r12;
        addLast(new FlowableReplay$Node(r11, r12));
        truncateFinal();
    }

    FlowableReplay$Node getHead() {
        return get();
    }

    boolean hasCompleted() {
        Object r10 = this.tail.value;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isComplete(leaveTransform(r10)) == false) goto L7;
        return true;
    }

    boolean hasError() {
        Object r10 = this.tail.value;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(leaveTransform(r10)) == false) goto L7;
        return true;
    }

    Object leaveTransform(Object r10) {
        return r10;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public final void next(T r10) {
        Object r11 = enterTransform(NotificationLite.next(r10));
        long r12 = this.index + 1;
        this.index = r12;
        addLast(new FlowableReplay$Node(r11, r12));
        truncate();
    }

    final void removeFirst() {
        FlowableReplay$Node r10 = get().get();
        if (r10 == null) goto L7;
        this.size--;
        setFirst(r10);
        return;
    L7:
        throw new IllegalStateException("Empty list!");
    }

    final void removeSome(int r10) {
        FlowableReplay$Node r11 = get();
    L3:
        if (r10 <= 0) goto L5;
        r11 = r11.get();
        r10 = r10 - 1;
        this.size--;
        goto L3
    L5:
        setFirst(r11);
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public final void replay(FlowableReplay$InnerSubscription<T> r15) {
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
        long r10 = r15.get();
        if (r10 != Long.MAX_VALUE) goto L17;
        boolean r11 = true;
    L18:
        FlowableReplay$Node r12 = (FlowableReplay$Node) r15.index();
        if (r12 != null) goto L21;
        r12 = getHead();
        r15.index = r12;
        io.reactivex.internal.util.b.a(r15.totalRequested, r12.index);
    L21:
        long r13 = 0;
    L23:
        if (r10 == 0) goto L44;
        FlowableReplay$Node r14 = r12.get();
        if (r14 == null) goto L44;
        Object r16 = leaveTransform(r14.value);
    L36:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r15.index = null;
        r15.dispose();
        if (NotificationLite.isError(r16) == false) goto L40;
        return;
    L40:
        if (NotificationLite.isComplete(r16) == true) goto L75;
        r15.child.onError(th);
        return;
    L75:
        return;
    L28:
        if (NotificationLite.accept(r16, r15.child) == true) goto L29;
        r13 = r13 + 1;
        r10 = r10 - 1;
        if (r15.isDisposed() == true) goto L33;
        r12 = r14;
        goto L23
    L33:
        r15.index = null;
        return;
    L29:
        r15.index = null;     // Catch: Throwable -> L36
        return;
    L44:
        if (r13 == 0) goto L48;
        r15.index = r12;
        if (r11 == true) goto L48;
        r15.produced(r13);
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
        r11 = false;
        goto L18
    L12:
        r15.index = null;
    }

    final void setFirst(FlowableReplay$Node r10) {
        set(r10);
    }

    final void trimHead() {
        FlowableReplay$Node r10 = get();
        if (r10.value == null) goto L6;
        FlowableReplay$Node r11 = new FlowableReplay$Node(null, 0);
        r11.lazySet(r10.get());
        set(r11);
        return;
    }

    void truncate() {
    }

    void truncateFinal() {
        trimHead();
    }
}
