package com.obric.cae.smartBluetooth;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5738b;

    public /* synthetic */ c(Object r8, int r10) {
        this.f5737a = r10;
        this.f5738b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5737a;
        Object r10 = this.f5738b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartBleAlwaysOnBinderClient.ServiceDeathRecipient.b((SmartBleAlwaysOnBinderClient.ServiceDeathRecipient) r10);
        return;
    L7:
        SmartBleAlwaysOnBinderClient.a((SmartBleAlwaysOnBinderClient) r10);
    }
}
