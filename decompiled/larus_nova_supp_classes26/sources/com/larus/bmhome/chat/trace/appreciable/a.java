package com.larus.bmhome.chat.trace.appreciable;

import com.google.gson.Gson;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(Object r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        JSONObject r4 = null;
    L10:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == true) goto L19;
        r0 = r5;
    L19:
        return (JSONObject) r0;
    L7:
        if ((r3 instanceof JSONObject) == false) goto L9;
        r4 = (JSONObject) r3;     // Catch: Throwable -> L12
        goto L10
    L9:
        r4 = new JSONObject(new Gson().toJson(r3));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static JSONObject b(Object r3, Object r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r5 = a(r3);     // Catch: Throwable -> L13
        JSONObject r6 = a(r4);     // Catch: Throwable -> L13
        if (r5 != null) goto L5;
        return r6;
    L5:
        if (r6 != null) goto L7;
        return r5;
    L7:
        Iterator<String> r1 = r5.keys();     // Catch: Throwable -> L13
    L9:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();     // Catch: Throwable -> L13
        r6.put(r2, r5.get(r2));     // Catch: Throwable -> L13
        goto L9
    L12:
        return r6;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == false) goto L18;
        r8 = null;
    L18:
        return (JSONObject) r8;
    }
}
