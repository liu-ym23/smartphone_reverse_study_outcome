package com.obric.memorydata.sdk.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MemoryDataServiceProxy$b implements ServiceConnection {
    public MemoryDataServiceProxy$b() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        MemoryDataServiceProxy.d.removeCallbacks(MemoryDataServiceProxy.g);
        MemoryDataServiceProxy.b = null;
        MemoryDataServiceProxy.e = false;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r3, IBinder r4) {
        if (r4 != null) goto L17;
    L5:
        MemoryDataServiceProxy r0 = MemoryDataServiceProxy.a;     // Catch: Throwable -> L11 Exception -> L16
        if (r4 == null) goto L8;
        MemoryDataServiceProxy.ServiceProxy r1 = new MemoryDataServiceProxy.ServiceProxy(IMemoryDataService.Stub.asInterface(r4));     // Catch: Throwable -> L11 Exception -> L16
    L9:
        MemoryDataServiceProxy.b = r1;     // Catch: Throwable -> L11 Exception -> L16
    L14:
        MemoryDataServiceProxy.d.removeCallbacks(MemoryDataServiceProxy.g);
        MemoryDataServiceProxy.e = false;
        return;
    L11:
        th = move-exception;
        MemoryDataServiceProxy.d.removeCallbacks(MemoryDataServiceProxy.g);
        MemoryDataServiceProxy.e = false;
        throw th;
    L8:
        r1 = null;
        goto L9
    L17:
        r4.linkToDeath(MemoryDataServiceProxy.i, 0);     // Catch: Throwable -> L11 Exception -> L16
        goto L5
    }
}
