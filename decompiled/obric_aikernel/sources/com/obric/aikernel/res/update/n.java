package com.obric.aikernel.res.update;

import android.os.SystemClock;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final long a() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m32constructorimpl(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L4
    L7:
        if (Result.m35exceptionOrNullimpl(r11) == null) goto L11;
        r11 = Long.valueOf(System.currentTimeMillis());
    L11:
        return ((Number) r11).longValue();
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
