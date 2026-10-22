package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ko.r;
import mt.b;
import mt.c;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableAndThenCompletable$SourceObserver extends AtomicReference<Disposable> implements b, Disposable {
    private static final long serialVersionUID = -4101678820158072998L;
    final b actualObserver;
    final c next;

    public CompletableAndThenCompletable$SourceObserver(b r5, c r10) {
        this.actualObserver = r5;
        this.next = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b
    public void onComplete() {
        c r5 = this.next;
        mt.a r10 = (mt.a) r5;
        r10.b(new r(10, this, this.actualObserver));
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.actualObserver.onError(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.actualObserver.onSubscribe(this);
        return;
    }
}
