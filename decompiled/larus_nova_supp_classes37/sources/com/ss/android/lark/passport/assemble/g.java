package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements Runnable {
    public final /* synthetic */ LogoutReason a;
    public final /* synthetic */ List<User> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(LogoutReason r1, List<? extends User> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        PassportLog.d(PassportUserApi.TAG, "dispatch logout success");
        LogoutReason r1 = this.a;
        List<User> r2 = this.b;
        ozb.a r0 = new ozb.a(r1, r2, r2);
        Iterator r3 = CollectionsKt.toMutableList(PassportUserApi.access$getLogoutListeners$cp()).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ozb.c) r3.next()).b(r0);
        goto L4
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
