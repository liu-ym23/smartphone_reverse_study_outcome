package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class SingleDelayWithSingle$OtherObserver<T, U> extends AtomicReference<b> implements r<U>, b {
    private static final long serialVersionUID = -8565274649390031272L;
    final r<? super T> downstream;
    final s<T> source;

    SingleDelayWithSingle$OtherObserver(r<? super T> r10, s<T> r11) {
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

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(U r10) {
        this.source.a(new io.reactivex.internal.observers.b(this, this.downstream));
    }
}
