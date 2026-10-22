package com.larus.bmhome.instruction.suggest;

import com.larus.im.internal.delegate.c0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final Map a(String r6) {
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L27
        h r2 = h.a;     // Catch: Throwable -> L27
        if (StringsKt.isBlank(r6) == false) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L32;
    L18:
        Object r7 = null;
    L19:
        Map r8 = (Map) r7;     // Catch: Throwable -> L27
        if (r8 != null) goto L22;
        r8 = MapsKt.emptyMap();     // Catch: Throwable -> L27
    L22:
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L27
    L23:
        if (r9.hasNext() == false) goto L35;
        Map.Entry r0 = (Map.Entry) r9.next();     // Catch: Throwable -> L27
        r1.put(String.valueOf(r0.getKey()), String.valueOf(r0.getValue()));     // Catch: Throwable -> L27
        goto L23
    L35:
        return r1;
    L32:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        r2.getClass();     // Catch: Throwable -> L11
        r7 = Result.constructor-impl(h.b.fromJson(r6, new d().getType()));     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L27
        if (r5 == null) goto L17;
        c0 r10 = c0.b;     // Catch: Throwable -> L27
        StringBuilder r11 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L27
        r11.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L27
        r10.e("GsonHolder", r11.toString());     // Catch: Throwable -> L27
    L17:
        if (Result.isFailure-impl(r7) == false) goto L19;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L13
    L6:
        r3 = false;
    L27:
        th = move-exception;
        FLogger.a.e("PromptSelectActionDispatcher", "toStringMap err=" + th.getMessage());
        return new LinkedHashMap();
    }
}
