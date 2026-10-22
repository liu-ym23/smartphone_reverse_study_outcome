package io.reactivex.subscribers;

import io.reactivex.disposables.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements g<T>, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<d> f9733c;

    public a() {
        this.f9733c = new AtomicReference();
    }

    protected final void a() {
        dispose();
    }

    protected void b() {
        this.f9733c.get().request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f9733c);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (this.f9733c.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.g, tc.c
    public final void onSubscribe(d r10) {
        if (io.reactivex.internal.util.d.d(this.f9733c, r10, getClass()) == false) goto L6;
        b();
        return;
    }
}
