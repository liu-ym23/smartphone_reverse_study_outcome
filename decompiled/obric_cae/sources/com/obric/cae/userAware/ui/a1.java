package com.obric.cae.userAware.ui;

import com.obric.cae.userAware.UserAwareManager;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5916b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5917m;

    public /* synthetic */ a1(int r8, int r10, Object r11) {
        this.f5915a = r10;
        this.f5916b = r11;
        this.f5917m = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5915a;
        int r10 = this.f5917m;
        Object r11 = this.f5916b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        SubwayStatusActivity.g((SubwayStatusActivity) r11, r10);
        return;
    L7:
        SubwayStatusActivity.r((SubwayStatusActivity) r11, r10);
        return;
    L9:
        UserAwareManager.c((UserAwareManager) r11, r10);
    }
}
