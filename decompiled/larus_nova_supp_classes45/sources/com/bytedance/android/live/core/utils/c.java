package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ String b;

    public c(Runnable r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        this.a.run();
        ALogger.i("AnchorMainPostOptUtils", "run " + this.b + " = " + (System.currentTimeMillis() - r0));
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
}
