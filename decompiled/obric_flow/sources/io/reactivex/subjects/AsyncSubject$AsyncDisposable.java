package io.reactivex.subjects;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class AsyncSubject$AsyncDisposable<T> extends DeferredScalarDisposable<T> {
    private static final long serialVersionUID = 5629876084736248016L;
    final a parent;

    public AsyncSubject$AsyncDisposable(u r5, a r10) {
        super(r5);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        if (tryDispose() == true) goto L6;
        return;
    L6:
        throw null;
    }

    public void onComplete() {
        if (isDisposed() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void onError(Throwable r5) {
        if (isDisposed() == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.downstream.onError(r5);
    }
}
