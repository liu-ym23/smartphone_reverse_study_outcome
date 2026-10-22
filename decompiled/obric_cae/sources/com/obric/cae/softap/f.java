package com.obric.cae.softap;

import android.net.wifi.SoftApConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5834b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5835m;

    public /* synthetic */ f(int r8, Object r10, Object r11) {
        this.f5833a = r8;
        this.f5834b = r10;
        this.f5835m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5833a;
        Object r10 = this.f5835m;
        Object r11 = this.f5834b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HostapdCtrlMonitor.b((HostapdCtrlMonitor.Listener) r11, (String) r10);
        return;
    L7:
        CaeSoftApService.H2((CaeSoftApService) r11, (SoftApConfiguration) r10);
    }
}
