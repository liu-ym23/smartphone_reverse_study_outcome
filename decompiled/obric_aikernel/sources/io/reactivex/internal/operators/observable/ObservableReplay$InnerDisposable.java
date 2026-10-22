package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableReplay$InnerDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final xb.o<? super T> child;
    Object index;
    final ObservableReplay$ReplayObserver<T> parent;

    ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver<T> r10, xb.o<? super T> r11) {
        this.parent = r10;
        this.child = r11;
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
