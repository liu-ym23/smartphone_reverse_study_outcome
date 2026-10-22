package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableConcatWithMaybe$ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, xb.j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -1953724749712440952L;
    final xb.o<? super T> downstream;
    boolean inMaybe;
    xb.k<? extends T> other;

    ObservableConcatWithMaybe$ConcatWithObserver(xb.o<? super T> r10, xb.k<? extends T> r11) {
        this.downstream = r10;
        this.other = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        if (this.inMaybe == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inMaybe = true;
        DisposableHelper.replace(this, null);
        xb.k<? extends T> r10 = this.other;
        this.other = null;
        r10.a(this);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if (this.inMaybe == true) goto L9;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.downstream.onNext(r10);
        this.downstream.onComplete();
    }
}
