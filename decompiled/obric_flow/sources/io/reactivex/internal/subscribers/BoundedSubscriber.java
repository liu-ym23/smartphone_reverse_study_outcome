package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class BoundedSubscriber<T> extends AtomicReference<d> implements g, d, Disposable {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final pt.a onComplete;
    final pt.g onError;
    final pt.g onNext;
    final pt.g onSubscribe;

    public BoundedSubscriber(pt.g r5, pt.g r10, pt.a r11, pt.g r12, int r13) {
        this.onNext = r5;
        this.onError = r10;
        this.onComplete = r11;
        this.onSubscribe = r12;
        this.bufferSize = r13;
        this.limit = r13 - (r13 >> 2);
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        if (this.onError == e.e) goto L5;
        return true;
    L5:
        return false;
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
        d r5 = get();
        SubscriptionHelper r10 = SubscriptionHelper.CANCELLED;
        if (r5 == r10) goto L12;
        lazySet(r10);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L9;
        lazySet(r11);
        this.onError.accept(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r5, th}));
        return;
    L9:
        f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (isDisposed() == true) goto L17;
        this.onNext.accept(r5);     // Catch: Throwable -> L7
        int r10 = this.consumed + 1;     // Catch: Throwable -> L7
        if (r10 != this.limit) goto L9;
        this.consumed = 0;     // Catch: Throwable -> L7
        get().request(this.limit);     // Catch: Throwable -> L7
    L13:
        return;
    L9:
        this.consumed = r10;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.cancel();
        onError(th);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        get().request(r5);
    }
}
