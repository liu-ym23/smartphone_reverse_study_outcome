package com.bytedance.ies.argus.util;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final JSONObject a(Object r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        JSONObject r13 = r11.put(r10, r5);     // Catch: Throwable -> L6
    L9:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L6
    L12:
        Object r15 = r11;
        if (Result.m127exceptionOrNullimpl(r14) != null) goto L16;
        r15 = r14;
    L16:
        return (JSONObject) r15;
    L8:
        r13 = r11;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final JSONObject b(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L25;
        return r5;
    L25:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L11
    L7:
        if (r12.hasNext() == false) goto L17;
        String r13 = r12.next();     // Catch: Throwable -> L11
        Object r14 = r10.get(r13);     // Catch: Throwable -> L11
        if ((r14 instanceof String) == false) goto L13;
        String r15 = (String) r14;     // Catch: Throwable -> L11
    L14:
        if (r15 != null) goto L16;
        r15 = r14.toString();     // Catch: Throwable -> L11
    L16:
        a(r15, r13, r5);     // Catch: Throwable -> L11
        goto L7
    L13:
        r15 = null;
        goto L14
    L17:
        Object r16 = Result.m124constructorimpl(r5);     // Catch: Throwable -> L11
    L20:
        Object r17 = r5;
        if (Result.m127exceptionOrNullimpl(r16) != null) goto L24;
        r17 = r16;
    L24:
        return (JSONObject) r17;
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static void c(ArrayList r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((Boolean) BuildersKt.runBlocking$default(null, new CommonUtils$safelyAwaitAll$1(r5, null), 1, null)).getClass();
    }

    public static final JSONObject d(Object r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 != null) goto L8;
        r5 = "null";
    L8:
        Object r13 = Result.m124constructorimpl(r11.put(r10, r5));     // Catch: Throwable -> L6
    L11:
        Object r14 = r11;
        if (Result.m127exceptionOrNullimpl(r13) != null) goto L15;
        r14 = r13;
    L15:
        return (JSONObject) r14;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
