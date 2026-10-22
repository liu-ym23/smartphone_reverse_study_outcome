package com.bytedance.android.ec.core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        Object r12 = null;
        if (r11 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r10, "{}") == true) goto L106;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L77
        JsonObject r14 = (JsonObject) u0.b(r10, JsonObject.class);     // Catch: Throwable -> L77
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L77
        Iterator r16 = r14.entrySet().iterator();     // Catch: Throwable -> L77
    L16:
        if (r16.hasNext() == false) goto L72;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L77
        CharSequence r18 = (CharSequence) r17.getKey();     // Catch: Throwable -> L77
        if (r18 != null) goto L20;
    L23:
        boolean r19 = true;
    L24:
        if (r19 == true) goto L42;
        JsonElement r20 = (JsonElement) r17.getValue();     // Catch: Throwable -> L77
        if (r20 == null) goto L42;
        if (r20.isJsonPrimitive() != true) goto L42;
        String r21 = ((JsonElement) r17.getValue()).getAsString();     // Catch: Throwable -> L77
        if (r21 != null) goto L32;
    L35:
        boolean r22 = true;
    L37:
        if ((!r22) == true) goto L40;
        r21 = null;
    L40:
        if (r21 == null) goto L16;
        r15.put(r17.getKey(), r21);     // Catch: Throwable -> L77
        goto L16
    L32:
        if (StringsKt.isBlank(r21) == true) goto L35;
        r22 = false;
    L42:
        CharSequence r23 = (CharSequence) r17.getKey();     // Catch: Throwable -> L77
        if (r23 != null) goto L45;
    L48:
        boolean r24 = true;
    L49:
        if (r24 == true) goto L16;
        JsonElement r25 = (JsonElement) r17.getValue();     // Catch: Throwable -> L77
        if (r25 == null) goto L16;
        if (r25.isJsonObject() != true) goto L16;
        String r26 = u0.d(r17.getValue());     // Catch: Throwable -> L77
        if (r26 != null) goto L57;
    L60:
        boolean r27 = true;
    L61:
        if (r27 == false) goto L63;
    L65:
        boolean r28 = false;
    L66:
        if (r28 == true) goto L69;
        r26 = null;
    L69:
        if (r26 == null) goto L16;
        r15.put(r17.getKey(), r26);     // Catch: Throwable -> L77
        goto L16
    L63:
        if ((!Intrinsics.areEqual(r26, "{}")) == false) goto L65;
        r28 = true;
        goto L66
    L57:
        if (StringsKt.isBlank(r26) == true) goto L60;
        r27 = false;
        goto L61
    L45:
        if (StringsKt.isBlank(r23) == true) goto L48;
        r24 = false;
        goto L49
    L20:
        if (StringsKt.isBlank(r18) == true) goto L23;
        r19 = false;
        goto L24
    L72:
        if ((!r15.isEmpty()) == true) goto L75;
        r15 = null;
    L75:
        Object r29 = Result.constructor-impl(r15);     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r29) == true) goto L84;
        r12 = r29;
    L84:
        return (Map) r12;
    L77:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L106:
        return null;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r11 = false;
        goto L9
    }

    public static Object b(String r1, Class r10) {
        Intrinsics.checkNotNullParameter(r1, "json");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return new Gson().fromJson(r1, r10);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
