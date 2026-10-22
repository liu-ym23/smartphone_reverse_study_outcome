package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public static void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r1 = pia.b.a;     // Catch: Throwable -> L4
        pia.b.d("obric.sid_auth.registered_version");     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L12;
        FLogger.a.e("SidAuthRegisterStateStore", "clear fail: " + r3.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r1 = pia.b.a;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(pia.b.b("obric.sid_auth.registered_version"));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L10;
        FLogger.a.e("SidAuthRegisterStateStore", "getRegisteredVersion fail: " + r3.getMessage());
    L10:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = "";
    L13:
        return (String) r2;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "version");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        pia.b r2 = pia.b.a;     // Catch: Throwable -> L10
        pia.b.c("obric.sid_auth.registered_version", r6);     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        FLogger.a.e("SidAuthRegisterStateStore", "markRegistered fail version=" + r6 + ": " + r4.getMessage());
    L16:
        if (Result.isSuccess-impl(r3) == false) goto L21;
        Unit r5 = (Unit) r3;
        FLogger.a.i("SidAuthRegisterStateStore", "markRegistered version=".concat(r6));
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
