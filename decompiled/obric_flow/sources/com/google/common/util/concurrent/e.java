package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f9409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f9410b;

    public e(o r5, w0 r10) {
        this.f9409a = r5;
        this.f9410b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9409a.f9424a == this) goto L5;
        return;
    L5:
        Object r5 = o.g(this.f9410b);
        if (o.f.b(this.f9409a, this, r5) == false) goto L9;
        o.d(this.f9409a);
        return;
    }
}
