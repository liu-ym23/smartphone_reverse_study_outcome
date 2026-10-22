package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConcurrentWifiScanner.ScanRequest f5857b;

    public /* synthetic */ d(ConcurrentWifiScanner.ScanRequest r8, int r10) {
        this.f5856a = r10;
        this.f5857b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5856a;
        ConcurrentWifiScanner.ScanRequest r10 = this.f5857b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        ConcurrentWifiScanner.ScanRequest.f(r10);
        return;
    L7:
        ConcurrentWifiScanner.ScanRequest.b(r10);
    }
}
