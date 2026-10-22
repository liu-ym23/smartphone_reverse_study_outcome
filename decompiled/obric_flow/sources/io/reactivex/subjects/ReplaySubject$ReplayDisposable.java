package io.reactivex.subjects;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class ReplaySubject$ReplayDisposable<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final u downstream;
    Object index;
    final e state;

    public ReplaySubject$ReplayDisposable(u r5, e r10) {
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }
}
