package com.ss.android.badger;

import com.bytedance.badger.Badger;
import com.bytedance.sdk.account.impl.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements Runnable {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static void a() {
        j r2 = AccountBadger.b;     // Catch: Exception -> L14
        if (r2 != null) goto L6;
    L8:
        j r3 = AccountBadger.b;     // Catch: Exception -> L14
        if (r3 == null) goto L11;
        boolean r4 = r3.isLogin();     // Catch: Exception -> L14
    L12:
        tb7.a.a("AccountBadger", "doDelayInitTask, login is " + r4 + ", start periodic report");     // Catch: Exception -> L14
        Badger.INSTANCE.startBootReport();     // Catch: Exception -> L14
        return;
    L11:
        r4 = false;
        goto L12
    L6:
        if (r2.isLogin() != true) goto L8;
        tb7.a.a("AccountBadger", "doDelayInitTask, login is true, check unfinished tasks");     // Catch: Exception -> L14
        Badger.INSTANCE.checkUnfinishedTasks();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        tb7.a.c("AccountBadger", "doDelayInitTask, checkUnfinishedTasks failed", e);
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
