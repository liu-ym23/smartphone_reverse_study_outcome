package com.obric.oui.material;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s {
    public static <T> ConcurrentHashMap<String, T> a(Class<?> r2, Class<?> r3) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        f(r2, r2.getDeclaredFields(), r3, r0);     // Catch: Throwable -> L5
    L6:
        return r0;
    }

    public static <T> ConcurrentHashMap<String, T> b(Object r2, Class<?> r3) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        if (r2 != null) goto L8;
    L7:
        return r0;
    L8:
        f(r2, r2.getClass().getDeclaredFields(), r3, r0);     // Catch: Throwable -> L6
        goto L7
    }

    public static <T> T c(String r2, Map<String, T> r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        String r4 = r2.toLowerCase(Locale.ROOT).trim();
        if (r4.length() != 0) goto L10;
        return null;
    L10:
        return r3.get(r4);
    L11:
        return null;
    }

    public static <T> void e(ConcurrentHashMap<String, T> r3, Map<String, ? extends T> r4, boolean r5) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, ? extends T>> r6 = r4.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L32;
        Map.Entry<String, ? extends T> r0 = r6.next();
        String r1 = r0.getKey();
        if (r1 == null) goto L9;
        String r2 = r1.toLowerCase(Locale.ROOT).trim();
        if (r2.length() == 0) goto L9;
        if (r5 == true) goto L17;
        r3.putIfAbsent(r2, r0.getValue());
        goto L9
    L17:
        r3.put(r2, r0.getValue());
        goto L9
    L32:
        return;
    L31:
        return;
    }

    public static <T> void d(ConcurrentHashMap<String, T> r0, Object r1, Class<?> r2, boolean r3) {
        e(r0, b(r1, r2), r3);
    }

    public static void f(Object r7, Field[] r8, Class r9, ConcurrentHashMap r10) throws Exception {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L50;
        Field r3 = r8[r2];
        Class<?> r4 = r3.getType();
        if (r9.isAssignableFrom(r4) == false) goto L8;
    L42:
        boolean r5 = true;
    L44:
        if (r5 == false) goto L49;
        r3.setAccessible(true);
        Object r6 = r3.get(r7);
        if (r6 == null) goto L49;
        r10.put(r3.getName().toLowerCase(Locale.ROOT), r6);
    L49:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4.isPrimitive() == true) goto L11;
    L43:
        r5 = false;
        goto L44
    L11:
        if (r4 != Float.TYPE) goto L15;
        if (r9 == Float.class) goto L42;
    L15:
        if (r4 != Integer.TYPE) goto L19;
        if (r9 == Integer.class) goto L42;
    L19:
        if (r4 != Boolean.TYPE) goto L23;
        if (r9 == Boolean.class) goto L42;
    L23:
        if (r4 != Long.TYPE) goto L27;
        if (r9 == Long.class) goto L42;
    L27:
        if (r4 != Double.TYPE) goto L31;
        if (r9 == Double.class) goto L42;
    L31:
        if (r4 != Short.TYPE) goto L35;
        if (r9 == Short.class) goto L42;
    L35:
        if (r4 != Byte.TYPE) goto L39;
        if (r9 == Byte.class) goto L42;
    L39:
        if (r4 != Character.TYPE) goto L43;
        if (r9 != Character.class) goto L43;
    }
}
