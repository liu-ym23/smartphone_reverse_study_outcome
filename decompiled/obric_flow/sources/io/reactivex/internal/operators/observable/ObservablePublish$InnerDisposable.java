package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservablePublish$InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
    private static final long serialVersionUID = -1100270633763673112L;
    final mt.u child;

    public ObservablePublish$InnerDisposable(mt.u r5) {
        this.child = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object r5 = getAndSet(this);
        if (r5 == null) goto L7;
        if (r5 == this) goto L8;
        ((q2) r5).a(this);
        return;
    L8:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != this) goto L5;
        return true;
    L5:
        return false;
    }

    public void setParent(q2 r5) {
        if (compareAndSet(null, r5) == true) goto L6;
        r5.a(this);
        return;
    }
}
