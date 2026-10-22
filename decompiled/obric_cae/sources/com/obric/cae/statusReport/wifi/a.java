package com.obric.cae.statusReport.wifi;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattPeripheral;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5838b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f5841o;

    public /* synthetic */ a(Object r8, Object r10, Object r11, Object r12, int r13) {
        this.f5837a = r13;
        this.f5838b = r8;
        this.f5839m = r10;
        this.f5840n = r11;
        this.f5841o = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5837a;
        Object r10 = this.f5841o;
        Object r11 = this.f5840n;
        Object r12 = this.f5839m;
        Object r13 = this.f5838b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeWifiStatusCollect.a((CaeWifiStatusCollect) r13, (String) r12, (String) r11, (CaeWifiInfo) r10);
        return;
    L7:
        BluetoothGattPeripheral.b((BluetoothGattPeripheral) r13, (AdvertiseSettings) r12, (AdvertiseData) r11, (AdvertiseData) r10);
    }
}
