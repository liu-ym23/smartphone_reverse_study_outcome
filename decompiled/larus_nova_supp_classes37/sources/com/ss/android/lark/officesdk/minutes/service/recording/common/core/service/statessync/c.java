package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static String a(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r2 = null;
        if (r1 == false) goto L26;
        return null;
    L26:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        String r5 = new JSONObject(r3).optString("message");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L18
        if ((true ^ StringsKt.isBlank(r5)) == true) goto L16;
        r5 = null;
    L16:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r6) == true) goto L25;
        r2 = r6;
    L25:
        return (String) r2;
    L18:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean b(ErrorResult r2) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Gson r3 = e0.a;     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        String r4 = r2.getDebugMsg();     // Catch: Throwable -> L13
    L7:
        gvb.b r5 = (gvb.b) e0.a(r4, gvb.b.class);     // Catch: Throwable -> L13
        if (r5 == null) goto L10;
        MmHttpErrorMsg r6 = r5.b();     // Catch: Throwable -> L13
    L11:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == true) goto L19;
        r0 = r7;
    L19:
        MmHttpErrorMsg r8 = (MmHttpErrorMsg) r0;
        if (r8 != null) goto L23;
        return false;
    L23:
        if (r8.isShow() == false) goto L25;
    L26:
        return true;
    L25:
        if (r8.isOverride() == true) goto L26;
        return false;
    L10:
        r6 = null;
        goto L11
    L6:
        r4 = null;
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
