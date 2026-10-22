package com.larus.asr;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a2 {
    public static final Integer a(Context r1, Integer r2) {
        if (r2 == null) goto L14;
        r2.intValue();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Object r3 = Result.constructor-impl(Integer.valueOf(ContextCompat.getColor(r1, r2.intValue())));     // Catch: Throwable -> L6
    L8:
        Object r4 = r2;
        if (Result.isFailure-impl(r3) == true) goto L13;
        r4 = r3;
    L13:
        return (Integer) r4;
    L6:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    L14:
        return null;
    }
}
