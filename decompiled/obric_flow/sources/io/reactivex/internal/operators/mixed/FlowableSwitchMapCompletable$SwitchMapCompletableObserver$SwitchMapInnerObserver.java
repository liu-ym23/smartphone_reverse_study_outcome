package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver extends AtomicReference<Disposable> implements mt.b {
    private static final long serialVersionUID = -8003404460084760287L;
    final a parent;

    public FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(a r5) {
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.b
    public void onComplete() {
        throw null;
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        throw null;
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
