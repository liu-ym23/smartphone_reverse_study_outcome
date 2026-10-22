package com.obric.cae.smartNetwork;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5765b;

    public /* synthetic */ b(Object r8, int r10) {
        this.f5764a = r10;
        this.f5765b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5764a;
        Object r10 = this.f5765b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartNetworkBinder.ServiceDeathRecipient.a((SmartNetworkBinder.ServiceDeathRecipient) r10);
        return;
    L7:
        SmartNetworkService.b((SmartNetworkService) r10);
    }
}
