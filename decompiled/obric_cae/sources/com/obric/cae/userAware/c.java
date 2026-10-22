package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConcurrentWifiScanner.ScanRequest f5855b;

    public /* synthetic */ c(ConcurrentWifiScanner.ScanRequest r8, int r10) {
        this.f5854a = r10;
        this.f5855b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5854a;
        ConcurrentWifiScanner.ScanRequest r10 = this.f5855b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        ConcurrentWifiScanner.ScanRequest.a(r10);
        return;
    L7:
        ConcurrentWifiScanner.ScanRequest.d(r10);
        return;
    L9:
        ConcurrentWifiScanner.ScanRequest.g(r10);
    }
}
