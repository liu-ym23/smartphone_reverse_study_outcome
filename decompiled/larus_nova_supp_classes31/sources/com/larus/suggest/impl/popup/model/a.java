package com.larus.suggest.impl.popup.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(JsonElement r2) {
        Object r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isJsonPrimitive() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L25;
        JsonPrimitive r3 = r2.getAsJsonPrimitive();
        if (r3 == null) goto L26;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r4 = Result.constructor-impl(r3.getAsString());     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r4) == true) goto L21;
        r0 = r4;
    L21:
        return (String) r0;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L26:
        return null;
    L25:
        return null;
    }
}
