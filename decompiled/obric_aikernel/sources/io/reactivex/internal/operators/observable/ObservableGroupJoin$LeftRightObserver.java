package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableGroupJoin$LeftRightObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.o<Object>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final e parent;

    ObservableGroupJoin$LeftRightObserver(e r10, boolean r11) {
        this.parent = r10;
        this.isLeft = r11;
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
        this.parent.innerComplete(this);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // xb.o
    public void onNext(Object r10) {
        this.parent.innerValue(this.isLeft, r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
