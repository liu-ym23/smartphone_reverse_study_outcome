package com.ss.android.account.share.data.write;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public b(Context r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = "key_account_info";
        this.d = r3;
    }

    public final void a() {
        AccountManager r0 = AccountManager.get(this.a);     // Catch: Exception -> L15
        String r1 = this.b;     // Catch: Exception -> L15
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = this.a.getPackageName();     // Catch: Exception -> L15
    L9:
        Account[] r2 = r0.getAccountsByType(r1);     // Catch: Exception -> L15
        if (r2 == null) goto L21;
        int r3 = r2.length;     // Catch: Exception -> L15
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L22;
        Account r5 = r2[r4];     // Catch: Exception -> L15
        AccountManager.get(this.a).setUserData(r5, this.c, this.d);     // Catch: Exception -> L15
        r4 = r4 + 1;
        goto L12
    L22:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        dra.b r6 = new dra.b();
        r6.b("share_sdk_save_account_info_failed");
        r6.a("err_msg", e.getMessage());
        r6.a("err_msg_stack", Log.getStackTraceString(e));
        r6.c();
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
