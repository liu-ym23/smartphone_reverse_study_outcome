package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRefCount$RefConnection extends AtomicReference<Disposable> implements Runnable, pt.g {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final q parent;
    long subscriberCount;
    Disposable timer;

    public FlowableRefCount$RefConnection(q r5) {
    }

    @Override // pt.g
    public /* bridge */ /* synthetic */ void accept(Object r5) throws Exception {
        accept((Disposable) r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        throw null;
    }

    public void accept(Disposable r5) throws Exception {
        DisposableHelper.replace(this, r5);
        throw null;
    }
}
