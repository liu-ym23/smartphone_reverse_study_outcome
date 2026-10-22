package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 implements mt.d, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.g f17877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17878c;
    public volatile boolean d;
    public boolean e;

    public n1(mt.u r5, pt.c r10, pt.g r11, Object r12) {
        this.f17876a = r5;
        this.f17877b = r11;
        this.f17878c = r12;
    }

    public final void a(Object r5) {
        this.f17877b.accept(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.d
    public final void onError(Throwable r5) {
        if (this.e == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.e = true;
        this.f17876a.onError(r5);
    }
}
