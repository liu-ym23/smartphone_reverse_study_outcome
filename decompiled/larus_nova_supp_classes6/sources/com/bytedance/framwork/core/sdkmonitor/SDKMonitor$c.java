package com.bytedance.framwork.core.sdkmonitor;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SDKMonitor$c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ long c;
    public final /* synthetic */ SDKMonitor d;

    @Override // java.lang.Runnable
    public final void run() {
        this.d.monitorCommonLogInternal(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public SDKMonitor$c(SDKMonitor r1, String r2, JSONObject r3, long r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
