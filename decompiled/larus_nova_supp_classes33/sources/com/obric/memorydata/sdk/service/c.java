package com.obric.memorydata.sdk.service;

import android.content.Context;
import android.util.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function0 {
    public /* synthetic */ c() {
    }

    public final Object invoke() {
        if (MemoryDataServiceProxy.b == null) goto L5;
    L8:
        MemoryDataServiceProxy r0 = MemoryDataServiceProxy.a;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L11:
        if (MemoryDataServiceProxy.b == null) goto L13;
    L14:
        Context r1 = MemoryDataServiceProxy.c;     // Catch: Throwable -> L21
        if (r1 == null) goto L17;
        r1.unbindService(MemoryDataServiceProxy.j);     // Catch: Throwable -> L21
    L17:
        MemoryDataServiceProxy.d.removeCallbacks(MemoryDataServiceProxy.g);     // Catch: Throwable -> L21
        MemoryDataServiceProxy.b = null;     // Catch: Throwable -> L21
        MemoryDataServiceProxy.e = false;     // Catch: Throwable -> L21
    L18:
        monitor-exit(r0);
        return Unit.INSTANCE;
    L13:
        if (MemoryDataServiceProxy.e == false) goto L18;
    L5:
        if (MemoryDataServiceProxy.e == true) goto L8;
        return Integer.valueOf(Log.w("MemoryDataServiceProxy", "service already unbound"));
    }
}
