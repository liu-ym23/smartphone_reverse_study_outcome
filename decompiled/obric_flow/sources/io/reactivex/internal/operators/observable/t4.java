package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class t4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4 f17979b;

    public t4(long r5, u4 r10) {
        this.f17978a = r5;
        this.f17979b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u4 r5 = this.f17979b;
        if (r5.d == true) goto L5;
        r5.f17640c.offer(this);
    L7:
        if (r5.i() == false) goto L10;
        r5.u();
        return;
    L10:
        return;
    L5:
        r5.s = true;
        r5.t();
        goto L7
    }
}
