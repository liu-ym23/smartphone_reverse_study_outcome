package com.ss.android.lark.coremd.ext;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public static final ConcurrentHashMap<Class<?>, Object> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static Object a(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        ConcurrentHashMap<Class<?>, Object> r0 = a;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L9;
        Object r2 = r3.getConstructor(new Class[0]).newInstance(new Object[0]);
        Object r4 = r0.putIfAbsent(r3, r2);
        if (r4 != null) goto L8;
        return r2;
    L8:
        return r4;
    L9:
        return r1;
    }
}
