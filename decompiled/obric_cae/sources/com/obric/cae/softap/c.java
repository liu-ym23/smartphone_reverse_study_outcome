package com.obric.cae.softap;

import com.obric.cae.smartNfc.SmartNfcService;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5827b;

    public /* synthetic */ c(Object r8, int r10) {
        this.f5826a = r10;
        this.f5827b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5826a;
        Object r10 = this.f5827b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApService.I2((CaeSoftApService) r10);
        return;
    L7:
        SmartNfcService.a((SmartNfcService) r10);
    }
}
