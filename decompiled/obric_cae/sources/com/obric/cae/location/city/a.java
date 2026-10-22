package com.obric.cae.location.city;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5627b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f5626a = r10;
        this.f5627b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5626a;
        Object r10 = this.f5627b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CityAoiSyncRunner.a((CityAoiSyncRunner) r10);
        return;
    L7:
        TrafficGeoManager.g((TrafficGeoManager) r10);
    }
}
