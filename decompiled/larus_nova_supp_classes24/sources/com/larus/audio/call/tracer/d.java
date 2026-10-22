package com.larus.audio.call.tracer;

import com.larus.audio.call.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import juc.v;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import nuc.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final Map<String, String> a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "logTag");
        if (StringsKt.isBlank(r6) == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L11
        ouc.a.a r1 = ouc.a.d;     // Catch: Throwable -> L11
        kotlinx.serialization.modules.d r2 = ((ouc.a) r1).b;     // Catch: Throwable -> L11
        Iterator r8 = ((Map) r1.c(new a1(kuc.a.d(v.a(r2, Reflection.getOrCreateKotlinClass(Object.class))), kuc.a.d(v.a(r2, Reflection.getOrCreateKotlinClass(Object.class)))), r6)).entrySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r8.next();     // Catch: Throwable -> L11
        r0.put(String.valueOf(r3.getKey()), String.valueOf(r3.getValue()));     // Catch: Throwable -> L11
        goto L8
    L18:
        return r0;
    L11:
        th = move-exception;
        f.c().l().e(r7, "toStringMap err=" + th.getMessage());
        return new LinkedHashMap();
    L5:
        return new LinkedHashMap();
    }
}
