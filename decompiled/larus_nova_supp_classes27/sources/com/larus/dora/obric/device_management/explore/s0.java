package com.larus.dora.obric.device_management.explore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 {
    public static final s0 a = null;
    public static final Gson b = null;

    public s0() {
    }

    static {
        a = new s0();
        b = new GsonBuilder().registerTypeAdapter(DoraObricGlassesImageResource.class, new DoraObricGlassesImageResourceDeserializer()).create();
    }

    public static Object a(String r3, Type r4) {
        Intrinsics.checkNotNullParameter(r4, "typeOfT");
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L25;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(b.fromJson(r3, r4));     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L18;
        g49.d.b("DoraObricGlassesExploreJson", "fromJson failed: " + r6.getMessage());
    L18:
        if (Result.isFailure-impl(r5) == false) goto L21;
        return null;
    L21:
        return r5;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L25:
        return null;
    }
}
