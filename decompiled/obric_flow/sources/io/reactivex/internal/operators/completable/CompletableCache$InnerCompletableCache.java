package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import mt.b;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableCache$InnerCompletableCache extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 8943152917179642732L;
    final b downstream;
    final /* synthetic */ a this$0;

    public CompletableCache$InnerCompletableCache(a r5, b r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }
}
