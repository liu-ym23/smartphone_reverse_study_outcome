package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Runnable {
    public final /* synthetic */ List<User> a;

    public f(LogoutReason r1, List r2) {
        this.a = r2;
    }

    public final void a() {
        PassportLog.d(PassportUserApi.TAG, "dispatch logout begin");
        Iterator r0 = CollectionsKt.toMutableList(PassportUserApi.access$getLogoutListeners$cp()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ozb.c) r0.next()).a();
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
