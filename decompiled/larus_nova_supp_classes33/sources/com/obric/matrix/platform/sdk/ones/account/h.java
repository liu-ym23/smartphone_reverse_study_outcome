package com.obric.matrix.platform.sdk.ones.account;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ i.a a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ h(i.a r1, Intent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a r0 = this.a;
        Intent r1 = this.b;
        r0.getClass();
        r1.getAction();
        if (r1.getAction() != null) goto L6;
        return;
    L6:
        if (r1.getAction().equals("obric.intent.action.account.SECURE_LOGIN") == false) goto L9;
        r0.a.a();
        return;
    L9:
        if (r1.getAction().equals("obric.intent.action.account.SECURE_LOGOUT") == false) goto L12;
        int r2 = r1.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
        r0.a.c(r2);
        return;
    L12:
        if (r1.getAction().equals("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE") == false) goto L17;
        r0.a.b();
        return;
    }
}
