package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements Runnable {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public o(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomNoPermissionFragment r0 = this.a;     // Catch: Throwable -> L8
        if (r0.j == false) goto L5;
        String r1 = "cert_button";
    L6:
        r0.aa0(r1);     // Catch: Throwable -> L8
        return;
    L5:
        r1 = "cert_auto";
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
