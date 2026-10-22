package com.obric.cae.location.geosdk.poi;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StarAoiBoardManager f5685b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Location f5686m;

    public /* synthetic */ c(StarAoiBoardManager r8, Location r10, int r11) {
        this.f5684a = r11;
        this.f5685b = r8;
        this.f5686m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5684a;
        Location r10 = this.f5686m;
        StarAoiBoardManager r11 = this.f5685b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        StarAoiBoardManager.g(r11, r10);
        return;
    L7:
        StarAoiBoardManager.h(r11, r10);
    }
}
