package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import pt.p;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<d> implements g, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final pt.a onComplete;
    final pt.g onError;
    final p onNext;

    public ForEachWhileSubscriber(p r5, pt.g r10, pt.a r11) {
        this.onNext = r5;
        this.onError = r10;
        this.onComplete = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.done = true;
        this.onError.accept(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r5) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
