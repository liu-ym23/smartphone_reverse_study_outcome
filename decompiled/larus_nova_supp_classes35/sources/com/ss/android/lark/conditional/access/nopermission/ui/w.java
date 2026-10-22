package com.ss.android.lark.conditional.access.nopermission.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment b;

    public w(long r1, OfficeSDKOAuthReauthorizationFragment r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = this.a;     // Catch: Throwable -> L9
        OfficeSDKOAuthReauthorizationFragment r2 = this.b;     // Catch: Throwable -> L9
        if (r0 == r2.k) goto L5;
    L7:
        this.b.l = null;     // Catch: Throwable -> L9
        return;
    L5:
        if (r2.getView() == null) goto L7;
        this.b.aa0(false);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
