package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservablePublish$InnerDisposable<T> extends AtomicReference<Object> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = -1100270633763673112L;
    final xb.o<? super T> child;

    ObservablePublish$InnerDisposable(xb.o<? super T> r10) {
        this.child = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Object r10 = getAndSet(this);
        if (r10 == null) goto L7;
        if (r10 == this) goto L8;
        ((f) r10).a(this);
        return;
    L8:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != this) goto L5;
        return true;
    L5:
        return false;
    }

    void setParent(f<T> r10) {
        if (compareAndSet(null, r10) == true) goto L6;
        r10.a(this);
        return;
    }
}
