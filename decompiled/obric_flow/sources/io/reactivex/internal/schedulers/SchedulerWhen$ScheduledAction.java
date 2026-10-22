package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
abstract class SchedulerWhen$ScheduledAction extends AtomicReference<Disposable> implements Disposable {
    public SchedulerWhen$ScheduledAction() {
        super(n.f18147b);
    }

    public void call(y r5, mt.b r10) {
        Disposable r11 = get();
        if (r11 != n.f18148c) goto L5;
        return;
    L5:
        m r12 = n.f18147b;
        if (r11 == r12) goto L8;
        return;
    L8:
        Disposable r13 = callActual(r5, r10);
        if (compareAndSet(r12, r13) == true) goto L12;
        r13.dispose();
        return;
    }

    public abstract Disposable callActual(y r5, mt.b r10);

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        EmptyDisposable r5 = n.f18148c;
    L3:
        Disposable r10 = get();
        if (r10 == n.f18148c) goto L5;
        if (compareAndSet(r10, r5) == false) goto L3;
        if (r10 == n.f18147b) goto L15;
        r10.dispose();
        return;
    L15:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get().isDisposed();
    }
}
