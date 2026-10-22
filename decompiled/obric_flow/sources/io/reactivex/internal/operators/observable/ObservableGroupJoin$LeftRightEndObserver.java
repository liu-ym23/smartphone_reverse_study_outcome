package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableGroupJoin$LeftRightEndObserver extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final r1 parent;

    public ObservableGroupJoin$LeftRightEndObserver(r1 r5, boolean r10, int r11) {
        this.parent = r5;
        this.isLeft = r10;
        this.index = r11;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.parent.innerCloseError(r5);
    }

    @Override // mt.u
    public void onNext(Object r5) {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.parent.innerClose(this.isLeft, this);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
