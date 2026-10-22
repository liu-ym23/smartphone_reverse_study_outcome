package com.bytedance.bdlocation.scan.bluetooth;

import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3815b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f3817n;

    public /* synthetic */ c(Object r8, long r10, Object r11, int r12) {
        this.f3814a = r12;
        this.f3816m = r8;
        this.f3815b = r10;
        this.f3817n = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f3814a;
        Object r10 = this.f3817n;
        long r11 = this.f3815b;
        Object r12 = this.f3816m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        BluetoothInfoManager.c((BluetoothInfoManager) r12, r11, r10);
        return;
    L7:
        StarAoiBoardManager.d((StarAoiBoardManager) r12, r11, (AoiBoard) r10);
    }
}
