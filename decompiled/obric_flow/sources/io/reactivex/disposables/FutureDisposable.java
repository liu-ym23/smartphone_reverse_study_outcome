package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    public FutureDisposable(Future<?> r5, boolean r10) {
        super(r5);
        this.allowInterrupt = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> r5 = getAndSet(null);
        if (r5 == null) goto L6;
        r5.cancel(this.allowInterrupt);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Future<?> r5 = get();
        if (r5 != null) goto L5;
    L8:
        return true;
    L5:
        if (r5.isDone() == true) goto L8;
        return false;
    }
}
