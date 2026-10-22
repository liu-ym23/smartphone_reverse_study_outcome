package com.larus.voicecall.impl.subtitle;

import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final List<Block> a(List<Block> r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "newBlockData");
        if (StringsKt.isBlank(r7) == false) goto L5;
        return r6;
    L5:
        List<Block> r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L27
        if (r7 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L43;
    L24:
        Object r8 = null;
    L25:
        Object r9 = Result.constructor-impl((List) r8);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r9) == false) goto L32;
        r9 = null;
    L32:
        List r10 = (List) r9;
        if (r10 == null) goto L35;
        r1 = CollectionsKt.toMutableList(r10);
    L35:
        if (r1 != null) goto L37;
        return r6;
    L37:
        if (r6 != null) goto L39;
        return r1;
    L39:
        Lazy r11 = com.larus.im.internal.core.message.concat.b.a;
        return com.larus.im.internal.core.message.concat.b.b(CollectionsKt.toMutableList(r6), r1);
    L43:
        r3.getClass();     // Catch: Throwable -> L17
        r8 = Result.constructor-impl(zd9.h.b.fromJson(r7, new a().getType()));     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L27
        if (r5 == null) goto L23;
        com.larus.im.internal.delegate.c0 r12 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L27
        StringBuilder r13 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L27
        r13.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L27
        r12.e("GsonHolder", r13.toString());     // Catch: Throwable -> L27
    L23:
        if (Result.isFailure-impl(r8) == false) goto L25;
    L17:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L27
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L19
    L9:
        if (StringsKt.isBlank(r7) == true) goto L12;
        r4 = false;
    L27:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }
}
