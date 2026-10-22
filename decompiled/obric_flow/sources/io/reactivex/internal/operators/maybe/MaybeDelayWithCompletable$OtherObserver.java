package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<Disposable> implements mt.b, Disposable {
    private static final long serialVersionUID = 703409937383992161L;
    final j downstream;
    final k source;

    public MaybeDelayWithCompletable$OtherObserver(j r5, k r10) {
        this.downstream = r5;
        this.source = r10;
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
        k r5 = this.source;
        h r10 = (h) r5;
        r10.b(new q7.a(9, this, false, this.downstream));
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }
}
