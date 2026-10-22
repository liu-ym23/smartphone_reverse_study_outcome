package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableGroupJoin$LeftRightEndObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.o<Object>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final e parent;

    ObservableGroupJoin$LeftRightEndObserver(e r10, boolean r11, int r12) {
        this.parent = r10;
        this.isLeft = r11;
        this.index = r12;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.parent.innerCloseError(r10);
    }

    @Override // xb.o
    public void onNext(Object r10) {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.parent.innerClose(this.isLeft, this);
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
