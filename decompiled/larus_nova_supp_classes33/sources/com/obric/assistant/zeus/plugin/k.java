package com.obric.assistant.zeus.plugin;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ ZeusMainProcessUpdateProvider a;
    public final /* synthetic */ String b;

    public /* synthetic */ k(ZeusMainProcessUpdateProvider r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ZeusMainProcessUpdateProvider r0 = this.a;
        String r1 = this.b;
        r0.b = r1;
        if (r0.c == false) goto L5;
        FLogger.a.i("ZeusMainProcessUpdateProvider", "merge pending fetch plugin request, reason=" + r1);
        return;
    L5:
        r0.c = true;
        r0.a.postDelayed(r0.d, ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);
    }
}
