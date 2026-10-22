package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements b {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    FutureDisposable(Future<?> r10, boolean r11) {
        super(r10);
        this.allowInterrupt = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> r10 = getAndSet(null);
        if (r10 == null) goto L6;
        r10.cancel(this.allowInterrupt);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Future<?> r10 = get();
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isDone() == true) goto L8;
        return false;
    }
}
