package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5851b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f5850a = r10;
        this.f5851b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5850a;
        Object r10 = this.f5851b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        CoalescedWifiScanExecutor.a((CoalescedWifiScanExecutor) r10);
        return;
    L7:
        CoalescedWifiScanExecutor.a((CoalescedWifiScanExecutor) r10);
        return;
    L9:
        SplitWifiScanner.AnonymousClass3.a((SplitWifiScanner.AnonymousClass3) r10);
    }
}
