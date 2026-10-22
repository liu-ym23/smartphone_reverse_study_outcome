package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends io.reactivex.subscribers.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableDebounce$DebounceSubscriber f17658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17659c;
    public final Object d;
    public boolean e;
    public final AtomicBoolean f;

    public g(FlowableDebounce$DebounceSubscriber r5, long r10, Object r11) {
        this.f = new AtomicBoolean();
        this.f17658b = r5;
        this.f17659c = r10;
        this.d = r11;
    }

    public final void a() {
        if (this.f.compareAndSet(false, true) == false) goto L6;
        long r5 = this.f17659c;
        Object r10 = this.d;
        this.f17658b.emit(r5, r10);
        return;
    }

    @Override // zu.c
    public final void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        a();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        if (this.e == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.e = true;
        this.f17658b.onError(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        dispose();
        a();
    }
}
