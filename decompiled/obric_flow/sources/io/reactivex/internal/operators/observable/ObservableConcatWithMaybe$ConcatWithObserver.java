package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatWithMaybe$ConcatWithObserver<T> extends AtomicReference<Disposable> implements mt.u, mt.j, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final mt.u downstream;
    boolean inMaybe;
    mt.k other;

    public ObservableConcatWithMaybe$ConcatWithObserver(mt.u r5, mt.k r10) {
        this.downstream = r5;
        this.other = r10;
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
        if (this.inMaybe == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inMaybe = true;
        DisposableHelper.replace(this, null);
        mt.k r5 = this.other;
        this.other = null;
        ((mt.h) r5).b(this);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if (this.inMaybe == true) goto L9;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onNext(r5);
        this.downstream.onComplete();
    }
}
