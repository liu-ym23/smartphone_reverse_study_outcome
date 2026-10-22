package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.n;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableAndThenObservable$AndThenObservableObserver<R> extends AtomicReference<b> implements o<R>, xb.b, b {
    private static final long serialVersionUID = -8948264376121066672L;
    final o<? super R> downstream;
    n<? extends R> other;

    CompletableAndThenObservable$AndThenObservableObserver(o<? super R> r10, n<? extends R> r11) {
        this.other = r11;
        this.downstream = r10;
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
        n<? extends R> r10 = this.other;
        if (r10 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r10.subscribe(this);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        DisposableHelper.replace(this, r10);
    }
}
