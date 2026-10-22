package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Runnable {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public j(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.a.isAdded() == false) goto L10;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "ping after device token claims challenge authorization");     // Catch: Throwable -> L7
        this.a.aa0("device_token_claims_challenge");     // Catch: Throwable -> L7
        return;
    }
}
