package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class ObservableReplay$BoundedReplayBuffer<T> extends AtomicReference<ObservableReplay$Node> implements f3 {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    ObservableReplay$Node tail;

    public ObservableReplay$BoundedReplayBuffer() {
        ObservableReplay$Node r5 = new ObservableReplay$Node(null);
        this.tail = r5;
        set(r5);
    }

    public final void addLast(ObservableReplay$Node r5) {
        this.tail.set(r5);
        this.tail = r5;
        this.size++;
    }

    public final void collect(Collection<? super T> r5) {
        ObservableReplay$Node r10 = getHead();
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

    @Override // io.reactivex.internal.operators.observable.f3
    public final void complete() {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.complete())));
        truncateFinal();
    }

    public Object enterTransform(Object r5) {
        return r5;
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public final void error(Throwable r5) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.error(r5))));
        truncateFinal();
    }

    public ObservableReplay$Node getHead() {
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

    @Override // io.reactivex.internal.operators.observable.f3
    public final void next(T r5) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.next(r5))));
        truncate();
    }

    public final void removeFirst() {
        ObservableReplay$Node r5 = get().get();
        this.size--;
        setFirst(r5);
    }

    public final void removeSome(int r5) {
        ObservableReplay$Node r10 = get();
    L3:
        if (r5 <= 0) goto L5;
        r10 = r10.get();
        r5 = r5 - 1;
        this.size--;
        goto L3
    L5:
        setFirst(r10);
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public final void replay(ObservableReplay$InnerDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r5 = 1;
    L6:
        ObservableReplay$Node r11 = (ObservableReplay$Node) r10.index();
        if (r11 != null) goto L10;
        r11 = getHead();
        r10.index = r11;
    L10:
        if (r10.isDisposed() == true) goto L11;
        ObservableReplay$Node r12 = r11.get();
        if (r12 == null) goto L20;
        if (NotificationLite.accept(leaveTransform(r12.value), r10.child) == true) goto L17;
        r11 = r12;
        goto L10
    L17:
        r10.index = null;
        return;
    L20:
        r10.index = r11;
        r5 = r10.addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L11:
        r10.index = null;
    }

    public final void setFirst(ObservableReplay$Node r5) {
        set(r5);
    }

    public final void trimHead() {
        ObservableReplay$Node r5 = get();
        if (r5.value == null) goto L6;
        ObservableReplay$Node r10 = new ObservableReplay$Node(null);
        r10.lazySet(r5.get());
        set(r10);
        return;
    }

    public abstract void truncate();

    public void truncateFinal() {
        trimHead();
    }
}
