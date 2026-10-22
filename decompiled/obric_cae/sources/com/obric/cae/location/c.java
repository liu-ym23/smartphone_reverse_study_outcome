package com.obric.cae.location;

import com.obric.cae.location.city.TrafficGeoManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5616b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5617m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5618n;

    public /* synthetic */ c(int r8, int r10, int r11, Object r12) {
        this.f5615a = r11;
        this.f5618n = r12;
        this.f5616b = r8;
        this.f5617m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5615a;
        int r10 = this.f5617m;
        int r11 = this.f5616b;
        Object r12 = this.f5618n;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        StarLocationManager.a((StarLocationManager) r12, r11, r10);
        return;
    L7:
        TrafficGeoManager.c((TrafficGeoManager) r12, r11, r10);
    }
}
