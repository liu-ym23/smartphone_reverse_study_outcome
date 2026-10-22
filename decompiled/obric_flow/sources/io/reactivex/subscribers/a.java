package io.reactivex.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements g, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18207a;

    public a() {
        this.f18207a = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.f18207a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f18207a.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public final void onSubscribe(d r5) {
        AtomicReference r10 = this.f18207a;
        Class<?> r11 = getClass();
        e.d(r5, "next is null");
    L4:
        if (r10.compareAndSet(null, r5) == true) goto L5;
        if (r10.get() == null) goto L4;
        r5.cancel();
        if (r10.get() == SubscriptionHelper.CANCELLED) goto L16;
        com.lynx.tasm.behavior.ui.utils.e.p(r11);
        return;
    L16:
        return;
    L5:
        ((d) r10.get()).request(Long.MAX_VALUE);
    }
}
