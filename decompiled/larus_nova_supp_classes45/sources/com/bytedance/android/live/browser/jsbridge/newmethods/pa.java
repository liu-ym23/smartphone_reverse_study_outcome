package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class pa implements Runnable {
    public final /* synthetic */ com.ss.ugc.live.sdk.message.wrsc.data.a a;
    public final /* synthetic */ wa b;
    public final /* synthetic */ CallContext c;

    public pa(com.ss.ugc.live.sdk.message.wrsc.data.a r1, wa r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wa.j(this.b, this.a, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
