package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.c;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableAndThenCompletable$SourceObserver extends AtomicReference<b> implements xb.b, b {
    private static final long serialVersionUID = -4101678820158072998L;
    final xb.b actualObserver;
    final c next;

    CompletableAndThenCompletable$SourceObserver(xb.b r10, c r11) {
        this.actualObserver = r10;
        this.next = r11;
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
        this.next.a(new a(this, this.actualObserver));
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.actualObserver.onError(r10);
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.actualObserver.onSubscribe(this);
        return;
    }
}
