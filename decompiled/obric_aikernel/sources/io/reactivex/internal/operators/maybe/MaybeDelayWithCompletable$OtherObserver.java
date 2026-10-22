package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.b, io.reactivex.disposables.b {
    private static final long serialVersionUID = 703409937383992161L;
    final j<? super T> downstream;
    final k<T> source;

    MaybeDelayWithCompletable$OtherObserver(j<? super T> r10, k<T> r11) {
        this.downstream = r10;
        this.source = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.b
    public void onComplete() {
        this.source.a(new a(this, this.downstream));
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }
}
