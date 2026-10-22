package io.reactivex.subjects;

import ai.j0;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableSubject$CompletableDisposable extends AtomicReference<b> implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;
    final mt.b downstream;

    public CompletableSubject$CompletableDisposable(mt.b r5, b r10) {
        this.downstream = r5;
        lazySet(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        j0.A(getAndSet(null));
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
