package com.obric.memorydata.sdk.service;

import android.os.IBinder;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import pka.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MemoryDataServiceProxy$c implements IBinder.DeathRecipient {
    public MemoryDataServiceProxy$c() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IMemoryDataService r0 = MemoryDataServiceProxy.b;     // Catch: Exception -> L13
        if (r0 == null) goto L7;
        IBinder r1 = r0.asBinder();     // Catch: Exception -> L13
        if (r1 == null) goto L7;
        r1.unlinkToDeath(this, 0);     // Catch: Exception -> L13
    L7:
        b.a(new e());     // Catch: Exception -> L13
        MemoryDataServiceProxy r2 = MemoryDataServiceProxy.a;     // Catch: Exception -> L13
        MemoryDataServiceProxy.b = null;     // Catch: Exception -> L13
        MemoryDataServiceProxy.d.removeCallbacks(MemoryDataServiceProxy.g);     // Catch: Exception -> L13
        MemoryDataServiceProxy.e = false;     // Catch: Exception -> L13
        Iterator r3 = CollectionsKt.toList(MemoryDataServiceProxy.h.values()).iterator();     // Catch: Exception -> L13
    L9:
        if (r3.hasNext() == false) goto L11;
        ((MemoryDataServiceProxy.a) r3.next()).binderDied();     // Catch: Exception -> L13
        goto L9
    L11:
        MemoryDataServiceProxy.d.postDelayed(new f(), 5000);     // Catch: Exception -> L13
        return;
    }
}
