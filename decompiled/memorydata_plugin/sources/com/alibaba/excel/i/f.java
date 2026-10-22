package com.alibaba.excel.i;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f213a;

    static {
        f213a = com.alibaba.excel.metadata.m.class;
    }

    private static String a(char r1, String r2) {
        return r1 + r2.substring(1);
    }

    public static String a(Field r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r4 = r3.getName();
        if (o.b(r4) == false) goto L8;
    L19:
        return r4;
    L8:
        if (r4.length() < 2) goto L19;
        char r0 = r4.charAt(0);
        char r1 = r4.charAt(1);
        if (Character.isUpperCase(r0) != Character.isUpperCase(r1)) goto L14;
        return r4;
    L14:
        if (Character.isUpperCase(r0) == false) goto L18;
        char r2 = Character.toLowerCase(r0);
    L17:
        return a(r2, r4);
    L18:
        r2 = Character.toUpperCase(r0);
        goto L17
    }
}
