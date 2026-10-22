package io.reactivex.internal.subscribers;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;
import zb.i;

/* JADX INFO: loaded from: classes2.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<d> implements g<T>, b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final zb.a onComplete;
    final zb.g<? super Throwable> onError;
    final i<? super T> onNext;

    public ForEachWhileSubscriber(i<? super T> r10, zb.g<? super Throwable> r11, zb.a r12) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.onError.accept(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r10) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
