package com.larus.dora.impl.network;

import com.larus.utils.logger.FLogger;
import hm9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements hm9.v {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final synchronized void X0(boolean r5) {
        monitor-enter(this);
        if (r5 == true) goto L15;
    L8:
        boolean r6 = false;
    L9:
        FLogger.a.i("DoraBackgroundConnectionStrict", "onNetworkBlockStateChanged: pool=" + r6);     // Catch: Throwable -> L12
        com.larus.network.ttnet.h.a.b(r6);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (j.h.z == false) goto L8;
        r6 = true;
        goto L9
    }
}
