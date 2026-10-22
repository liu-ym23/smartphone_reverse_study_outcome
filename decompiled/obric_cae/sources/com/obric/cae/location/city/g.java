package com.obric.cae.location.city;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TrafficGeoManager f5635b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f5637n;

    public /* synthetic */ g(TrafficGeoManager r8, int r10, int r11, int r12) {
        this.f5634a = r12;
        this.f5635b = r8;
        this.f5636m = r10;
        this.f5637n = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5634a;
        TrafficGeoManager r10 = this.f5635b;
        int r11 = this.f5637n;
        int r12 = this.f5636m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        TrafficGeoManager.d(r10, r12, r11);
        return;
    L7:
        TrafficGeoManager.h(r10, r12, r11);
    }
}
