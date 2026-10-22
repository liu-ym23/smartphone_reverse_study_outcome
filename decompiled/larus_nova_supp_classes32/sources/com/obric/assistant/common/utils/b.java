package com.obric.assistant.common.utils;

import android.system.Os;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static boolean a(String r17, Function1 r18, Function1 r19) {
        Intrinsics.checkNotNullParameter(r17, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r18, "onUpdated");
        Intrinsics.checkNotNullParameter(r19, "onError");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        String r5 = Os.getenv("ADSP_LIBRARY_PATH");     // Catch: Throwable -> L24
        if (r5 != null) goto L6;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        List r6 = StringsKt.split$default(r5, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L24
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L24
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L24
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();     // Catch: Throwable -> L24
        if ((true ^ StringsKt.isBlank((String) r9)) == false) goto L8;
        r7.add(r9);     // Catch: Throwable -> L24
        goto L8
    L13:
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r7), r17) == true) goto L22;
        List r10 = CollectionsKt.listOf(r17);     // Catch: Throwable -> L24
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L24
        Iterator r12 = r7.iterator();     // Catch: Throwable -> L24
    L17:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();     // Catch: Throwable -> L24
        if ((!Intrinsics.areEqual((String) r13, r17)) == false) goto L17;
        r11.add(r13);     // Catch: Throwable -> L24
        goto L17
    L21:
        String r0 = CollectionsKt.joinToString$default(CollectionsKt.plus(r10, r11), ";", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L24
        Os.setenv("ADSP_LIBRARY_PATH", r0, true);     // Catch: Throwable -> L24
        r18.invoke(r0);     // Catch: Throwable -> L24
    L22:
        Object r1 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L24
    L26:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L29;
        r19.invoke(r2);
    L29:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L33;
        r1 = r3;
    L33:
        return ((Boolean) r1).booleanValue();
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
