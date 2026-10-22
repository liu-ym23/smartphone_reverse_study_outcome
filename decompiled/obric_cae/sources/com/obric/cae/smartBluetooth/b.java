package com.obric.cae.smartBluetooth;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder.DeathRecipient f5735b;

    public /* synthetic */ b(IBinder.DeathRecipient r8, int r10) {
        this.f5734a = r10;
        this.f5735b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5734a;
        IBinder.DeathRecipient r10 = this.f5735b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SmartBleAlwaysOnBinderClient.ServiceDeathRecipient.a((SmartBleAlwaysOnBinderClient.ServiceDeathRecipient) r10);
        return;
    L7:
        SmartBluetoothBinderClient.ServiceDeathRecipient.a((SmartBluetoothBinderClient.ServiceDeathRecipient) r10);
    }
}
