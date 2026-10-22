package com.lark.kmp.containerization;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<d<?>, c<?>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static c a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Object r0 = ((LinkedHashMap) a).get(r10);
        if ((r0 instanceof c) == false) goto L5;
        c r1 = (c) r0;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalArgumentException("Scope " + Reflection.getOrCreateKotlinClass(r10.getClass()).getSimpleName() + " not initialize");
    L5:
        r1 = null;
        goto L6
    }
}
