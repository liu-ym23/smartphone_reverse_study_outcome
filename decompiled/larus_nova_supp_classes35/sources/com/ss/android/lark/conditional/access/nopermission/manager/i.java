package com.ss.android.lark.conditional.access.nopermission.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Runnable {
    public final /* synthetic */ NoPermissionModuleManager a;
    public final /* synthetic */ qnc.e b;
    public final /* synthetic */ qnc.b c;
    public final /* synthetic */ qnc.c.a d;

    public i(NoPermissionModuleManager r1, qnc.e r2, qnc.b r3, qnc.c.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NoPermissionModuleManager.d(this.a, false, this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
