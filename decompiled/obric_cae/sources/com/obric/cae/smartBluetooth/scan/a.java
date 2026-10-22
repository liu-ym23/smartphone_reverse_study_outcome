package com.obric.cae.smartBluetooth.scan;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmartBluetoothBleScanManager f5755b;

    public /* synthetic */ a(SmartBluetoothBleScanManager r8, int r10) {
        this.f5754a = r10;
        this.f5755b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5754a;
        SmartBluetoothBleScanManager r10 = this.f5755b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartBluetoothBleScanManager.c(r10);
        return;
    L7:
        SmartBluetoothBleScanManager.f(r10);
    }
}
