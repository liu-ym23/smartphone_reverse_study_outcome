package com.obric.cae.smartBluetooth.scan;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmartBluetoothBleScanManager f5759b;

    public /* synthetic */ c(SmartBluetoothBleScanManager r8, int r10) {
        this.f5758a = r10;
        this.f5759b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5758a;
        SmartBluetoothBleScanManager r10 = this.f5759b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartBluetoothBleScanManager.e(r10);
        return;
    L7:
        SmartBluetoothBleScanManager.b(r10);
    }
}
