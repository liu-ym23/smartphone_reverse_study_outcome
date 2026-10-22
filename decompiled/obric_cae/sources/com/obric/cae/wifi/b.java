package com.obric.cae.wifi;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaeWifiDatabaseService f6073b;

    public /* synthetic */ b(CaeWifiDatabaseService r8, int r10) {
        this.f6072a = r10;
        this.f6073b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6072a;
        CaeWifiDatabaseService r10 = this.f6073b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeWifiDatabaseService.d(r10);
        return;
    L7:
        CaeWifiDatabaseService.c(r10);
    }
}
