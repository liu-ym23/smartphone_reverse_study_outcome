package com.obric.cae.libs.softap;

import com.obric.cae.userAware.WifiAwareInfoManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5483b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5484m;

    public /* synthetic */ d(int r8, int r10, Object r11) {
        this.f5482a = r10;
        this.f5484m = r11;
        this.f5483b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5482a;
        int r10 = this.f5483b;
        Object r11 = this.f5484m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.a((CaeSoftApManager.c) r11, r10);
        return;
    L7:
        WifiAwareInfoManager.d((WifiAwareInfoManager) r11, r10);
    }
}
