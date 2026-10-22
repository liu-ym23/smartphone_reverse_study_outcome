package com.obric.cae.userAware;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WifiAwareInfoManager f5905b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ List f5906m;

    public /* synthetic */ u(WifiAwareInfoManager r8, List r10, int r11) {
        this.f5904a = r11;
        this.f5905b = r8;
        this.f5906m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5904a;
        List r10 = this.f5906m;
        WifiAwareInfoManager r11 = this.f5905b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        WifiAwareInfoManager.j(r11, r10);
        return;
    L7:
        WifiAwareInfoManager.h(r11, r10);
    }
}
