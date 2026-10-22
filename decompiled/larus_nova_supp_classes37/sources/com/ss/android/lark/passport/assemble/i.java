package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements Runnable {
    public final /* synthetic */ User a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ List<User> d;
    public final /* synthetic */ List<User> e;

    public i(User r1, boolean r2, List r3, List r4) {
        this.a = r1;
        this.b = r2;
        this.c = true;
        this.d = r3;
        this.e = r4;
    }

    public final void a() {
        StringBuilder r0 = new StringBuilder("dispatch login, user: ");
        User r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.userId;
    L6:
        r0.append(r2);
        r0.append(", fast:");
        r0.append(this.b);
        PassportLog.d(PassportUserApi.TAG, r0.toString());
        nzb.a r3 = new nzb.a(this.c, this.b, this.d, this.e, this.a);
        Iterator r4 = CollectionsKt.toMutableList(PassportUserApi.access$getLoginListeners$cp()).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ((nzb.b) r4.next()).a(r3);
        goto L8
    L10:
        return;
    L5:
        r2 = null;
        goto L6
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
