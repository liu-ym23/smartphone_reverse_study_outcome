package com.obric.cae.location.city;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5644b;

    public /* synthetic */ k(Object r8, int r10) {
        this.f5643a = r10;
        this.f5644b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5643a;
        Object r10 = this.f5644b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        TrafficGeoManager.g((TrafficGeoManager) r10);
        return;
    L7:
        TrafficGeoManager.AnonymousClass2.b((TrafficGeoManager) r10);
        return;
    L9:
        CityAoiSyncRunner.a((CityAoiSyncRunner) r10);
    }
}
