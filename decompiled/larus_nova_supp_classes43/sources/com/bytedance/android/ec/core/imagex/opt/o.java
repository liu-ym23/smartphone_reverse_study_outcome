package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public final /* synthetic */ DomainPreConnect.a a;
    public final /* synthetic */ long b;

    public o(DomainPreConnect.a r1, long r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        Logger.d("ImageDomainPreConnectConfig", "onPost");
        DomainPreConnect r0 = DomainPreConnect.c;
        DomainPreConnect.a r10 = this.a;
        long r11 = this.b;
        r0.getClass();
        if (r10.a == r11) goto L5;
        return;
    L5:
        if (r10.b == true) goto L8;
        return;
    L8:
        if ((System.nanoTime() - r10.c) > r10.e) goto L21;
        r10.b = false;
        return;
    L21:
        TTNetInit.preconnectUrl(r10.d);     // Catch: Throwable -> L12
        Logger.d("ImageDomainPreConnectConfig", "preConnectUrl " + r10.d);     // Catch: Throwable -> L12
    L14:
        r10.c = System.nanoTime();
        r10.b = false;
        return;
    L12:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "url " + r10.d);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r10.c = System.nanoTime();
        r10.b = false;
        throw th;
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
