package com.obric.matrix.platform.sdk.ones.account;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ c(d.a r1, Intent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a r0 = this.a;
        Intent r1 = this.b;
        r0.getClass();
        if (r1.getAction().equals("obric.intent.action.account.LOGIN") == false) goto L6;
        r0.a.a();
        return;
    L6:
        if (r1.getAction().equals("obric.intent.action.account.LOGOUT") == false) goto L9;
        int r2 = r1.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
        r0.a.c(r2);
        return;
    L9:
        if (r1.getAction().equals("obric.intent.action.account.ACCOUNT_INFO_UPDATE") == false) goto L14;
        r0.a.b();
        return;
    }
}
