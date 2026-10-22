package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x implements Runnable {
    public final /* synthetic */ SenderTenantMap a;

    public x(SenderTenantMap r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.putJSONObject("SenderTenantIdMap", this.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
