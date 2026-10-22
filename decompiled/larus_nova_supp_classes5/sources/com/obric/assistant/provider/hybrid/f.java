package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import q38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public f() {
    }

    public Bundle call(String r10, Bundle r11) {
        a r12 = ILoginService.a.getAccountInfo();
        boolean r13 = r12.a;
        if (r13 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = null;
        if (r13 == false) goto L15;
        String r14 = r12.d;
        if (r14 == null) goto L15;
        if ((!StringsKt.isBlank(r14)) == false) goto L15;
    L16:
        if (r2 == true) goto L71;
        r3 = r14;
    L63:
        Bundle r0 = new Bundle();
        r0.putBoolean("is_login", r13);
        r0.putBoolean("is_enterprise", r2);
        if (r14 != null) goto L66;
        r14 = "";
    L66:
        r0.putString("current_sec_id", r14);
        if (r3 != null) goto L69;
        r3 = "";
    L69:
        r0.putString("personal_sec_id", r3);
        return r0;
    L71:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        Object r5 = Result.constructor-impl(IMultiAccountService.a.g());     // Catch: Throwable -> L20
    L22:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L25;
        FLogger.a.w("QueryAccountInfo", "getLocalAccountList failed: " + r6.getMessage(), r6);
    L25:
        List r7 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r5) == false) goto L28;
        r5 = r7;
    L28:
        List r8 = (List) r5;
        Iterator r9 = r8.iterator();
    L30:
        if (r9.hasNext() == false) goto L41;
        Object r15 = r9.next();
        q38.b r16 = (q38.b) r15;
        if (r16.k() == true) goto L34;
    L38:
        boolean r17 = false;
    L39:
        if (r17 == false) goto L30;
    L42:
        q38.b r18 = (q38.b) r15;
        if (r18 != null) goto L57;
        Iterator r19 = r8.iterator();
    L46:
        if (r19.hasNext() == false) goto L55;
        Object r20 = r19.next();
        q38.b r21 = (q38.b) r20;
        if (r21.d() == true) goto L50;
    L52:
        boolean r22 = false;
    L53:
        if (r22 == false) goto L46;
    L56:
        r18 = (q38.b) r20;
        goto L57
    L50:
        if (r21.l() == true) goto L52;
        r22 = true;
        goto L53
    L55:
        r20 = null;
    L57:
        if (r18 == null) goto L63;
        String r1 = r18.g();
        if (r1 == null) goto L63;
        if ((true ^ StringsKt.isBlank(r1)) == false) goto L63;
        r3 = r1;
        goto L63
    L34:
        if (r16.d() == false) goto L38;
        if (r16.l() == true) goto L38;
        r17 = true;
        goto L39
    L41:
        r15 = null;
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r14 = null;
        goto L16
    L5:
        if (r12.g == false) goto L7;
        r2 = true;
        goto L8
    }
}
