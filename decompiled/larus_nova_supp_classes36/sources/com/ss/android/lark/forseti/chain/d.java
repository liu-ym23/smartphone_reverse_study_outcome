package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ ForsetiChainFragment a;
    public final /* synthetic */ com.ss.android.lark.api.ui.g b;
    public final /* synthetic */ boolean c;

    public d(ForsetiChainFragment r1, ForsetiPlugin.b r2) {
        this.a = r1;
        this.b = r2;
        this.c = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.ca0().m(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
