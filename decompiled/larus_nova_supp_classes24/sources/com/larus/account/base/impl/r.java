package com.larus.account.base.impl;

import com.larus.login.impl.switchbind.SwitchBindViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import ua7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r extends a<xa7.c> {
    public final /* synthetic */ n38.m a;

    public r(SwitchBindViewModel.executeSwitch.1.a r1) {
        this.a = r1;
    }

    public final void onResponse(ua7.b r6) {
        xa7.c r7 = (xa7.c) r6;
        if (r7 == null) goto L7;
        boolean r3 = true;
        if (((ua7.b) r7).c != true) goto L7;
    L9:
        if (r3 == true) goto L35;
        n38.m r0 = this.a;
        if (r7 == null) goto L27;
        int r1 = ((ua7.b) r7).g;
    L28:
        if (r7 == null) goto L30;
        String r8 = ((ua7.b) r7).i;
    L31:
        if (r8 != null) goto L33;
        r8 = "";
    L33:
        r0.a(r1, r8, null, null);
        return;
    L30:
        r8 = null;
        goto L31
    L27:
        r1 = -1;
        goto L28
    L35:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        String r9 = r7.z.toString();     // Catch: Throwable -> L12
        FLogger.a.i("solveConflictAndSwitchBind", "jsonStr:" + r9);     // Catch: Throwable -> L12
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r2 = Result.exceptionOrNull-impl(r10);
        if (r2 == null) goto L18;
        FLogger.a.e("solveConflictAndSwitchBind", String.valueOf(r2));
    L18:
        if (Result.isFailure-impl(r10) == false) goto L21;
        r10 = null;
    L21:
        if (((Unit) r10) == null) goto L23;
    L23:
        this.a.onSuccess(null);
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = false;
        goto L9
    }
}
