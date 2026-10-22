package io.reactivex.internal.subscribers;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class LambdaSubscriber<T> extends AtomicReference<d> implements g<T>, d, b {
    private static final long serialVersionUID = -7251123623727029452L;
    final zb.a onComplete;
    final zb.g<? super Throwable> onError;
    final zb.g<? super T> onNext;
    final zb.g<? super d> onSubscribe;

    public LambdaSubscriber(zb.g<? super T> r10, zb.g<? super Throwable> r11, zb.a r12, zb.g<? super d> r13) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
        this.onSubscribe = r13;
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        if (this.onError == Functions.f9489d) goto L5;
        return true;
    L5:
        return false;
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
        d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L12;
        lazySet(r11);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        d r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L9;
        lazySet(r12);
        this.onError.accept(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
        return;
    L9:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.cancel();
        onError(th);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        get().request(r10);
    }
}
