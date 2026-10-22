package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5853b;

    public /* synthetic */ b(Object r8, int r10) {
        this.f5852a = r10;
        this.f5853b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5852a;
        Object r10 = this.f5853b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        UserAwareManager.g((UserAwareManager) r10);
        return;
    L7:
        QshHalInterface.a((QshHalInterface) r10);
        return;
    L9:
        CoalescedWifiScanExecutor.b((CoalescedWifiScanExecutor) r10);
        return;
    L11:
        WifiAwareInfoManager.e((WifiAwareInfoManager) r10);
    }
}
