package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements Runnable {
    public final /* synthetic */ Map<String, d> a;
    public final /* synthetic */ String b;

    public u(Map<String, d> r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = com.ss.android.lark.security.compliance.infra.util.f.c(this.a);     // Catch: Exception -> L4
    L6:
        com.ss.android.lark.storage.kv.repo.a r1 = y.c;
        if (r1 == null) goto L12;
        r1.putString("object_" + this.b, r0);
        return;
    L12:
        return;
    L4:
        e = move-exception;
        int r2 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_PolicyStorage", "saveDynamicObjectResult(), trans data to dataStr error, e:" + e.getMessage());
        r0 = BuildConfig.FLAVOR;
        goto L6
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
