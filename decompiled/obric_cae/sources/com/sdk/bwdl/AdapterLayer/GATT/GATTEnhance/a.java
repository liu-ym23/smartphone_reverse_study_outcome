package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6711b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f6710a = r10;
        this.f6711b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6710a;
        Object r10 = this.f6711b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        BluetoothGattCentral.AnonymousClass1.a((BluetoothGattCentral.AnonymousClass1) r10);
        return;
    L7:
        BluetoothGattPeripheral.AnonymousClass1.a((BluetoothGattPeripheral.AnonymousClass1) r10);
    }
}
