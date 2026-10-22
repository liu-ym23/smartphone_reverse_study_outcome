package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.multi.d;
import com.larus.platform.api.IAccountRemovedCacheService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import va7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$e extends a {
    public final /* synthetic */ q38.b a;
    public final /* synthetic */ MultiAccountServiceImpl b;
    public final /* synthetic */ q38.b c;
    public final /* synthetic */ n38.k d;

    public final void onSuccess(ua7.b r13) {
        Intrinsics.checkNotNullParameter(r13, "response");
        Gson r14 = d.a;
        d.e(this.a);
        MultiAccountServiceImpl r15 = this.b;
        String r0 = this.a.g();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = this.a.j();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        int r3 = MultiAccountServiceImpl.f;
        r15.getClass();
        IAccountRemovedCacheService.a.a(r0);
        Iterator r16 = r15.e.iterator();
    L11:
        if (r16.hasNext() == false) goto L20;
        IMultiAccountService.a r4 = (IMultiAccountService.a) r16.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        r4.a(r0, r1);     // Catch: Throwable -> L15
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L11;
        FLogger.a.e("MultiAccountServiceImpl", "dispatchAccountRemoved failed: " + r7, r7);
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L20:
        n38.b r17 = new n38.b(this.c, this.a, true, 0, null);
        n38.k r9 = this.d;
        if (r9 == null) goto L31;
        r9.b(r17);
        return;
    }

    public final void onError(ua7.b r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "response");
        String r6 = r8.i;
        FLogger.a.e("MultiAccountServiceImpl", "removeAccount by IBDAccountExtraApi fail, code=" + r9 + ", msg=" + r6);
        n38.b r10 = new n38.b(this.c, this.a, false, r9, r6);
        n38.k r11 = this.d;
        if (r11 == null) goto L6;
        r11.a(r10);
        return;
    }

    public MultiAccountServiceImpl$e(q38.b r1, MultiAccountServiceImpl r2, q38.b r3, n38.k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
