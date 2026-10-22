package com.bytedance.bdlocation.scan.bluetooth;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothInfoManager f3808b;

    public /* synthetic */ a(BluetoothInfoManager r8, int r10) {
        this.f3807a = r10;
        this.f3808b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f3807a;
        BluetoothInfoManager r10 = this.f3808b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        BluetoothInfoManager.b(r10);
        return;
    L7:
        BluetoothInfoManager.a(r10);
    }
}
