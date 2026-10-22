package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements r {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    int size;
    FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node r5 = new FlowableReplay$Node(null, 0);
        this.tail = r5;
        set(r5);
    }

    public final void addLast(FlowableReplay$Node r5) {
        this.tail.set(r5);
        this.tail = r5;
        this.size++;
    }

    public final void collect(Collection<? super T> r5) {
        FlowableReplay$Node r10 = getHead();
    L3:
        r10 = r10.get();
        if (r10 == null) goto L11;
        Object r11 = leaveTransform(r10.value);
        if (NotificationLite.isComplete(r11) == true) goto L15;
        if (NotificationLite.isError(r11) == true) goto L16;
        r5.add((Object) NotificationLite.getValue(r11));
        goto L3
    L16:
        return;
    L15:
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public final void complete() {
        Object r5 = enterTransform(NotificationLite.complete());
        long r10 = this.index + 1;
        this.index = r10;
        addLast(new FlowableReplay$Node(r5, r10));
        truncateFinal();
    }

    public Object enterTransform(Object r5) {
        return r5;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public final void error(Throwable r10) {
        Object r11 = enterTransform(NotificationLite.error(r10));
        long r5 = this.index + 1;
        this.index = r5;
        addLast(new FlowableReplay$Node(r11, r5));
        truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return get();
    }

    public boolean hasCompleted() {
        Object r5 = this.tail.value;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isComplete(leaveTransform(r5)) == false) goto L7;
        return true;
    }

    public boolean hasError() {
        Object r5 = this.tail.value;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(leaveTransform(r5)) == false) goto L7;
        return true;
    }

    public Object leaveTransform(Object r5) {
        return r5;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public final void next(T r10) {
        Object r11 = enterTransform(NotificationLite.next(r10));
        long r5 = this.index + 1;
        this.index = r5;
        addLast(new FlowableReplay$Node(r11, r5));
        truncate();
    }

    public final void removeFirst() {
        FlowableReplay$Node r5 = get().get();
        if (r5 == null) goto L7;
        this.size--;
        setFirst(r5);
        return;
    L7:
        throw new IllegalStateException("Empty list!");
    }

    public final void removeSome(int r5) {
        FlowableReplay$Node r10 = get();
    L3:
        if (r5 <= 0) goto L5;
        r10 = r10.get();
        r5 = r5 - 1;
        this.size--;
        goto L3
    L5:
        setFirst(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public final void replay(FlowableReplay$InnerSubscription<T> r15) {
        monitor-enter(r15);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r15.emitting == false) goto L10;
        r15.missed = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
        return;
    L10:
        r15.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
    L13:
        if (r15.isDisposed() == true) goto L14;
        long r5 = r15.get();
        if (r5 != Long.MAX_VALUE) goto L19;
        boolean r10 = true;
    L20:
        FlowableReplay$Node r11 = (FlowableReplay$Node) r15.index();
        if (r11 != null) goto L23;
        r11 = getHead();
        r15.index = r11;
        v0.r(r15.totalRequested, r11.index);
    L23:
        long r12 = 0;
    L25:
        if (r5 == 0) goto L47;
        FlowableReplay$Node r13 = r11.get();
        if (r13 == null) goto L47;
        Object r14 = leaveTransform(r13.value);
    L33:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r15.index = null;
        r15.dispose();
        if (NotificationLite.isError(r14) == false) goto L43;
        return;
    L43:
        if (NotificationLite.isComplete(r14) == true) goto L78;
        r15.child.onError(th);
        return;
    L78:
        return;
    L30:
        if (NotificationLite.accept(r14, r15.child) == true) goto L31;
        r12 = r12 + 1;
        r5 = r5 - 1;
        if (r15.isDisposed() == true) goto L37;
        r11 = r13;
        goto L25
    L37:
        r15.index = null;
        return;
    L31:
        r15.index = null;     // Catch: Throwable -> L33
        return;
    L47:
        if (r12 == 0) goto L51;
        r15.index = r11;
        if (r10 == true) goto L51;
        r15.produced(r12);
    L51:
        monitor-enter(r15);
    L57:
        th = move-exception;
        throw th;
    L53:
        if (r15.missed == false) goto L54;
        r15.missed = false;     // Catch: Throwable -> L57
        monitor-exit(r15);     // Catch: Throwable -> L57
        goto L13
    L54:
        r15.emitting = false;     // Catch: Throwable -> L57
        monitor-exit(r15);     // Catch: Throwable -> L57
        return;
    L19:
        r10 = false;
        goto L20
    L14:
        r15.index = null;
    }

    public final void setFirst(FlowableReplay$Node r5) {
        set(r5);
    }

    public final void trimHead() {
        FlowableReplay$Node r5 = get();
        if (r5.value == null) goto L6;
        FlowableReplay$Node r10 = new FlowableReplay$Node(null, 0);
        r10.lazySet(r5.get());
        set(r10);
        return;
    }

    public void truncate() {
    }

    public void truncateFinal() {
        trimHead();
    }
}
