package com.obric.cae.location.zpp;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StarZppManager f5716b;

    public /* synthetic */ b(StarZppManager r8, int r10) {
        this.f5715a = r10;
        this.f5716b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5715a;
        StarZppManager r10 = this.f5716b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        StarZppManager.f(r10);
        return;
    L7:
        StarZppManager.d(r10);
    }
}
