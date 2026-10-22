package com.obric.cae.smartBluetooth;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder.DeathRecipient f5728b;

    public /* synthetic */ a(IBinder.DeathRecipient r8, int r10) {
        this.f5727a = r10;
        this.f5728b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5727a;
        IBinder.DeathRecipient r10 = this.f5728b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CloudBinderClient.ServiceDeathRecipient.a((CloudBinderClient.ServiceDeathRecipient) r10);
        return;
    L7:
        SmartBleAlwaysOnBinderClient.ServiceDeathRecipient.c((SmartBleAlwaysOnBinderClient.ServiceDeathRecipient) r10);
    }
}
