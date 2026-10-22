package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver extends AtomicReference<Disposable> implements mt.b {
    private static final long serialVersionUID = -8003404460084760287L;
    final d parent;

    public ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(d r5) {
        this.parent = r5;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.b
    public void onComplete() {
        d r5 = this.parent;
        AtomicReference r10 = r5.e;
    L4:
        if (r10.compareAndSet(this, null) == true) goto L6;
        if (r10.get() == this) goto L4;
        return;
    L6:
        if (r5.f == false) goto L13;
        Throwable r11 = r5.d.terminate();
        if (r11 != null) goto L10;
        r5.f17688a.onComplete();
        return;
    L10:
        r5.f17688a.onError(r11);
        return;
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        d r10 = this.parent;
        AtomicReference r11 = r10.e;
    L4:
        if (r11.compareAndSet(this, null) == true) goto L6;
        if (r11.get() == this) goto L4;
    L17:
        wn.f.k(r5);
        return;
    L6:
        if (r10.d.addThrowable(r5) == false) goto L17;
        if (r10.f17690c == true) goto L10;
        r10.dispose();
        Throwable r12 = r10.d.terminate();
        if (r12 == io.reactivex.internal.util.d.f18173a) goto L24;
        r10.f17688a.onError(r12);
        return;
    L24:
        return;
    L10:
        if (r10.f == false) goto L22;
        Throwable r13 = r10.d.terminate();
        r10.f17688a.onError(r13);
        return;
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
