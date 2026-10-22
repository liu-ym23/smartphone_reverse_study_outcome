package com.ss.android.lark.monitor.traffic;

import android.net.TrafficStats;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ i a;

    public final void a() {
        i r0 = this.a;
        r0.getClass();
        Log.i("TrafficMonitorVerify", "getUidTxBytes = " + TrafficStats.getUidTxBytes(r0.a) + ", getUidRxBytes = " + TrafficStats.getUidRxBytes(r0.a));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("Verify", "getCurrentAppTrafficStats have exceptoin " + e.getMessage());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(i r1) {
        this.a = r1;
    }
}
