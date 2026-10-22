package com.bytedance.bdinstall;

import android.accounts.Account;
import com.larus.apm.impl.protector.RunnableProtector;
import g84.a;
import g84.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class p0$h implements Runnable {
    public final /* synthetic */ Account a;
    public final /* synthetic */ p0 b;

    public final void a() {
        if (this.b.a == null) goto L5;
        o0 r0 = this.b.a;
        r0.y = this.a;
    L5:
        a r1 = (a) e.a(a.class, String.valueOf(this.b.a.a));
        if (r1 == null) goto L9;
        r1.b(this.a);
        return;
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

    public p0$h(p0 r1, Account r2) {
        this.b = r1;
        this.a = r2;
    }
}
