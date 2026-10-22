package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ tlc.d a;
    public final /* synthetic */ h b;
    public final /* synthetic */ String c;
    public final /* synthetic */ IBDXBridgeContext d;

    public e(tlc.d r1, h r2, String r3, IBDXBridgeContext r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.a(this.b, this.a, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
