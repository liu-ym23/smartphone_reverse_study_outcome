package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableReplay$InnerDisposable<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final mt.u child;
    Object index;
    final ObservableReplay$ReplayObserver<T> parent;

    public ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver<T> r5, mt.u r10) {
        this.parent = r5;
        this.child = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.parent.remove(this);
        this.index = null;
        return;
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }
}
