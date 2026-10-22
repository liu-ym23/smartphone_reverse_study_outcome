package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.multi.d;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$g implements n38.k {
    public final /* synthetic */ n38.k a;
    public final /* synthetic */ q38.b b;
    public final /* synthetic */ MultiAccountServiceImpl c;
    public final /* synthetic */ List<q38.b> d;
    public final /* synthetic */ Set<String> e;
    public final /* synthetic */ AccountSwitchReason f;

    @Override // n38.k
    public final void a(n38.b r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        int r0 = r8.d;
        String r3 = null;
        if (r0 != 1) goto L5;
    L14:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("switch to ");
        q38.b r4 = r8.b;
        if (r4 == null) goto L17;
        r3 = r4.j();
    L17:
        r2.append(r3);
        r2.append(" failed, code = ");
        r2.append(r8.d);
        r2.append(", try next candidate");
        r1.i("MultiAccountServiceImpl", r2.toString());
        Gson r5 = d.a;
        d.e(this.b);
        MultiAccountServiceImpl.k(this.c, this.d, this.e, this.a, this.f, r8);
        return;
    L5:
        if (r0 == 4) goto L14;
        if (r0 == 1011) goto L14;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("switch to ");
        q38.b r9 = r8.b;
        if (r9 == null) goto L11;
        r3 = r9.j();
    L11:
        r7.append(r3);
        r7.append(" failed, code = ");
        r7.append(r8.d);
        r7.append(", Abort");
        r6.i("MultiAccountServiceImpl", r7.toString());
        n38.k r10 = this.a;
        if (r10 == null) goto L19;
        r10.a(r8);
        return;
    }

    @Override // n38.k
    public final void b(n38.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        n38.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public MultiAccountServiceImpl$g(n38.k r1, q38.b r2, MultiAccountServiceImpl r3, List<q38.b> r4, Set<String> r5, AccountSwitchReason r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
