package com.obric.cae.smartBluetooth.scan;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmartBluetoothBleScanManager f5757b;

    public /* synthetic */ b(SmartBluetoothBleScanManager r8, int r10) {
        this.f5756a = r10;
        this.f5757b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5756a;
        SmartBluetoothBleScanManager r10 = this.f5757b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartBluetoothBleScanManager.d(r10);
        return;
    L7:
        SmartBluetoothBleScanManager.a(r10);
    }
}
