package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;

/* JADX INFO: loaded from: classes3.dex */
final class SingleDelayWithCompletable$OtherObserver<T> extends AtomicReference<Disposable> implements mt.b, Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    final b0 downstream;
    final c0 source;

    public SingleDelayWithCompletable$OtherObserver(b0 r5, c0 r10) {
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
        c0 r5 = this.source;
        a0 r10 = (a0) r5;
        r10.b(new com.lynx.animax.player.b(9, this, this.downstream));
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
