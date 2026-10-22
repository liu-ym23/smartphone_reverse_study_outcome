package com.bytedance.crash.upload;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f4104b;

    public /* synthetic */ d(g r5, int r10) {
        this.f4103a = r10;
        this.f4104b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f4103a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f4104b.t();
        return;
    L6:
        g r5 = this.f4104b;
        if (r5.f == false) goto L10;
        return;
    L10:
        if (com.bytedance.crash.p.f4084h == false) goto L13;
        return;
    L13:
        if (com.bytedance.ies.bullet.base.utils.b.n(r5.f4124a) == false) goto L15;
        r5.t();
        return;
    L15:
        l9.o.e().c(r5.f4127h, 5000);
    }
}
