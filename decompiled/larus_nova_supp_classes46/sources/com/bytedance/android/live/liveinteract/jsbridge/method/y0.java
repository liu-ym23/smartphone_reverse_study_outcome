package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y0 implements Runnable {
    public final /* synthetic */ tlc.d a;
    public final /* synthetic */ b1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ CallContext d;

    public y0(tlc.d r1, b1 r2, String r3, CallContext r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b1.j(this.b, this.a, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
