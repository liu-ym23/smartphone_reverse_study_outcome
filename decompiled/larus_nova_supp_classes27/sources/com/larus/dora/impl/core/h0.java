package com.larus.dora.impl.core;

import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h0 implements Runnable {
    public final /* synthetic */ i0 a;

    public /* synthetic */ h0(i0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 r0 = this.a;
        r0.getClass();
        int r3 = kj4.a.g().isReady();     // Catch: Throwable -> L16
        if (r3 == 0) goto L10;
        if (r3 == 3) goto L10;
        g49.d.d("DoraLinkManager", "tryLinkOnAppForeground: ready: " + r3);     // Catch: Throwable -> L16
    L19:
        return;
    L10:
        if (kj4.a.g().hasDoraDevice() == true) goto L12;
        g49.d.d("DoraLinkManager", "tryLinkOnAppForeground: no dora device");     // Catch: Throwable -> L16
        goto L19
    L12:
        if (AccountService.a.isLogin().booleanValue() == false) goto L19;
        r0.i(5, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        g49.d.c("DoraLinkManager", "tryLinkOnAppForeground exception", th);
    }
}
