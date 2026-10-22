package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.s;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableAndThenObservable$AndThenObservableObserver<R> extends AtomicReference<Disposable> implements u, mt.b, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;
    final u downstream;
    s other;

    public CompletableAndThenObservable$AndThenObservableObserver(u r5, s r10) {
        this.other = r10;
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        s r5 = this.other;
        if (r5 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r5.subscribe(this);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }
}
