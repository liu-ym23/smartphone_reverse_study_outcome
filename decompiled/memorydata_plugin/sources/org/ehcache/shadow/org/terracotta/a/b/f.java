package org.ehcache.shadow.org.terracotta.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static a<Object> a(Object r1, Field r2) {
        r2.setAccessible(true);
        if (Modifier.isFinal(r2.getModifiers()) == false) goto L10;
        return new b(r2.get(r1));
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        return new h(r1, r2);
    }

    public static org.ehcache.shadow.org.terracotta.a.c a(Object r2) {
        HashMap r0 = new HashMap();
        r0.putAll(b(r2));
        r0.putAll(c(r2));
        r0.putAll(d(r2));
        return new d(r2.getClass(), r0);
    }

    private static Map<? extends String, ? extends a<Object>> b(Object r3) {
        org.ehcache.shadow.org.terracotta.a.a.a r0 = (org.ehcache.shadow.org.terracotta.a.a.a) ZeusTransformUtils.preCheckCast(r3.getClass().getAnnotation(org.ehcache.shadow.org.terracotta.a.a.a.class), org.ehcache.shadow.org.terracotta.a.a.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return Collections.singletonMap(r0.a(), new g(r3));
    }

    private static Map<String, a<Object>> c(Object r8) {
        HashMap r0 = new HashMap();
        Method[] r1 = r8.getClass().getMethods();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        Method r4 = r1[r3];
        if (r4.getParameterTypes().length != 0) goto L11;
        if (r4.getReturnType() == Void.TYPE) goto L11;
        org.ehcache.shadow.org.terracotta.a.a.a r5 = (org.ehcache.shadow.org.terracotta.a.a.a) ZeusTransformUtils.preCheckCast(r4.getAnnotation(org.ehcache.shadow.org.terracotta.a.a.a.class), org.ehcache.shadow.org.terracotta.a.a.a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        r0.put(r5.a(), new i(r8, r4));
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return r0;
    }

    private static Map<String, a<Object>> d(Object r9) {
        HashMap r0 = new HashMap();
        Class<?> r1 = r9.getClass();
    L3:
        if (r1 == null) goto L11;
        Field[] r2 = r1.getDeclaredFields();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        Field r5 = r2[r4];
        org.ehcache.shadow.org.terracotta.a.a.a r6 = (org.ehcache.shadow.org.terracotta.a.a.a) ZeusTransformUtils.preCheckCast(r5.getAnnotation(org.ehcache.shadow.org.terracotta.a.a.a.class), org.ehcache.shadow.org.terracotta.a.a.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        r0.put(r6.a(), a(r9, r5));
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        r1 = r1.getSuperclass();
        goto L3
    L11:
        return r0;
    }
}
