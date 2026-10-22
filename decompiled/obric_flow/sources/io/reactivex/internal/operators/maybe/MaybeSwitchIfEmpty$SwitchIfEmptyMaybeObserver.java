package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = -2223459372976438024L;
    final j downstream;
    final k other;

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(j r5, k r10) {
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

    @Override // mt.j
    public void onComplete() {
        Disposable r5 = get();
        if (r5 != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (compareAndSet(r5, null) == false) goto L9;
        k r10 = this.other;
        h r11 = (h) r10;
        r11.b(new com.lynx.animax.player.b(10, this.downstream, this));
        return;
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }
}
