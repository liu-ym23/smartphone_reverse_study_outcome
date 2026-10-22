package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static long a() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        pia.b r3 = pia.b.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter("obric.sid_auth.batch.last_attempt_ts_ms", "key");     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Long.valueOf(pia.b.a().getLong("obric.sid_auth.batch.last_attempt_ts_ms", 0)));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L11;
        FLogger.a.e("SidAuthBatchStateStore", "getLastAttemptTsMs fail: " + r5.getMessage());
    L11:
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = 0L;
    L14:
        return ((Number) r4).longValue();
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(long r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r1 = pia.b.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter("obric.sid_auth.batch.last_attempt_ts_ms", "key");     // Catch: Throwable -> L4
        pia.b.a().storeLong("obric.sid_auth.batch.last_attempt_ts_ms", r6);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L10;
        FLogger.a.e("SidAuthBatchStateStore", "updateLastAttemptTsMs fail: " + r3.getMessage());
    L10:
        if (Result.isSuccess-impl(r2) == false) goto L15;
        Unit r4 = (Unit) r2;
        FLogger.a.i("SidAuthBatchStateStore", "updateLastAttemptTsMs tsMs=" + r6);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
