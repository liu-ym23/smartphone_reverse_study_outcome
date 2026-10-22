package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5867b;

    public /* synthetic */ g(Object r8, int r10) {
        this.f5866a = r10;
        this.f5867b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5866a;
        Object r10 = this.f5867b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        BtAwareInfoManager.a((BtAwareInfoManager) r10);
        return;
    L7:
        UserAwareCloudBinderClient.ServiceDeathRecipient.a((UserAwareCloudBinderClient) r10);
        return;
    L9:
        GeofenceEventDelaySorter.a((GeofenceEventDelaySorter) r10);
        return;
    L11:
        CoalescedWifiScanExecutor.b((CoalescedWifiScanExecutor) r10);
    }
}
