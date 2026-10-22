package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f17862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17863c;
    public final Object d;
    public boolean e;
    public final AtomicBoolean f;

    public m0(n0 r5, long r10, Object r11) {
        this.f = new AtomicBoolean();
        this.f17862b = r5;
        this.f17863c = r10;
        this.d = r11;
    }

    public final void a() {
        if (this.f.compareAndSet(false, true) == false) goto L8;
        n0 r5 = this.f17862b;
        long r10 = this.f17863c;
        Object r11 = this.d;
        if (r10 != r5.e) goto L9;
        r5.f17873a.onNext(r11);
        return;
    L9:
        return;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        a();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.e == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.e = true;
        this.f17862b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        dispose();
        a();
    }
}
