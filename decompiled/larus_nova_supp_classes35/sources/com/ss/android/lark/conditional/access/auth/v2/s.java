package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements Runnable {
    public final /* synthetic */ String a;

    public s(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.b;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        String r1 = this.a;     // Catch: Throwable -> L10
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == false) goto L17;
        d r2 = (d) r0.getJSONObject(r1, d.class);     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r2.h(Long.valueOf(System.currentTimeMillis() - 1));     // Catch: Throwable -> L10
        r0.putJSONObject(r1, r2);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
