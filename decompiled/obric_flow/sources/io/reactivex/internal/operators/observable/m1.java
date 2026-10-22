package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements mt.g, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zu.d f17865b;

    public m1(mt.u r5) {
        this.f17864a = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17865b.cancel();
        this.f17865b = SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f17865b != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public final void onComplete() {
        this.f17864a.onComplete();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        this.f17864a.onError(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        this.f17864a.onNext(r5);
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.f17865b, r5) == false) goto L6;
        this.f17865b = r5;
        this.f17864a.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
