package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class ObservableReplay$BoundedReplayBuffer<T> extends AtomicReference<ObservableReplay$Node> implements g<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    ObservableReplay$Node tail;

    ObservableReplay$BoundedReplayBuffer() {
        ObservableReplay$Node r10 = new ObservableReplay$Node(null);
        this.tail = r10;
        set(r10);
    }

    final void addLast(ObservableReplay$Node r10) {
        this.tail.set(r10);
        this.tail = r10;
        this.size++;
    }

    final void collect(Collection<? super T> r10) {
        ObservableReplay$Node r11 = getHead();
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

    @Override // io.reactivex.internal.operators.observable.g
    public final void complete() {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.complete())));
        truncateFinal();
    }

    Object enterTransform(Object r10) {
        return r10;
    }

    @Override // io.reactivex.internal.operators.observable.g
    public final void error(Throwable r10) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.error(r10))));
        truncateFinal();
    }

    ObservableReplay$Node getHead() {
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

    @Override // io.reactivex.internal.operators.observable.g
    public final void next(T r10) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.next(r10))));
        truncate();
    }

    final void removeFirst() {
        ObservableReplay$Node r10 = get().get();
        this.size--;
        setFirst(r10);
    }

    final void removeSome(int r10) {
        ObservableReplay$Node r11 = get();
    L3:
        if (r10 <= 0) goto L5;
        r11 = r11.get();
        r10 = r10 - 1;
        this.size--;
        goto L3
    L5:
        setFirst(r11);
    }

    @Override // io.reactivex.internal.operators.observable.g
    public final void replay(ObservableReplay$InnerDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r11 = 1;
    L6:
        ObservableReplay$Node r12 = (ObservableReplay$Node) r10.index();
        if (r12 != null) goto L10;
        r12 = getHead();
        r10.index = r12;
    L10:
        if (r10.isDisposed() == true) goto L11;
        ObservableReplay$Node r13 = r12.get();
        if (r13 == null) goto L20;
        if (NotificationLite.accept(leaveTransform(r13.value), r10.child) == true) goto L17;
        r12 = r13;
        goto L10
    L17:
        r10.index = null;
        return;
    L20:
        r10.index = r12;
        r11 = r10.addAndGet(-r11);
        if (r11 != 0) goto L6;
        return;
    L11:
        r10.index = null;
    }

    final void setFirst(ObservableReplay$Node r10) {
        set(r10);
    }

    final void trimHead() {
        ObservableReplay$Node r10 = get();
        if (r10.value == null) goto L6;
        ObservableReplay$Node r11 = new ObservableReplay$Node(null);
        r11.lazySet(r10.get());
        set(r11);
        return;
    }

    abstract void truncate();

    void truncateFinal() {
        trimHead();
    }
}
