package com.ss.android.lark.conditional.access.nopermission.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ DeviceAuthenticationNoPermissionFragment a;

    public a(DeviceAuthenticationNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceAuthenticationNoPermissionFragment r0 = this.a;     // Catch: Throwable -> L8
        if (r0.m == false) goto L5;
        String r1 = "cert_auto";
    L6:
        r0.W90(r1);     // Catch: Throwable -> L8
        return;
    L5:
        r1 = "cert_button";
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
