package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ko.r;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 4603919676453758899L;
    final b0 downstream;
    final c0 other;

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(b0 r5, c0 r10) {
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
        c0 r10 = this.other;
        a0 r11 = (a0) r10;
        r11.b(new r(11, this.downstream, this));
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
