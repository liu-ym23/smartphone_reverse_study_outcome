package io.reactivex.subjects;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class PublishSubject$PublishDisposable<T> extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 3562861878281475070L;
    final u downstream;
    final d parent;

    public PublishSubject$PublishDisposable(u r5, d r10) {
        this.downstream = r5;
        this.parent = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (compareAndSet(false, true) == false) goto L6;
        this.parent.d(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }

    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void onError(Throwable r5) {
        if (get() == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.downstream.onError(r5);
    }

    public void onNext(T r5) {
        if (get() == true) goto L6;
        this.downstream.onNext(r5);
        return;
    }
}
