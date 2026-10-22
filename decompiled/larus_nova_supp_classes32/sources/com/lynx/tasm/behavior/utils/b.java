package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.LynxUIMethod;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final HashMap<Class, HashMap<String, Method>> a = null;

    static {
        a = new HashMap();
    }

    public static HashMap<String, Method> a(Class<?> r6) {
        HashMap<Class, HashMap<String, Method>> r0 = a;
        if (r0.containsKey(r6) == true) goto L5;
        HashMap<String, Method> r1 = new HashMap();
        Method[] r2 = r6.getDeclaredMethods();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        Method r5 = r2[r4];
        if (((LynxUIMethod) r5.getAnnotation(LynxUIMethod.class)) == null) goto L11;
        r1.put(r5.getName(), r5);
    L11:
        r4 = r4 + 1;
        goto L7
    L12:
        Class<? super Object> r7 = r6.getSuperclass();
        if (r7 == null) goto L15;
        r1.putAll(a(r7));
    L15:
        a.put(r6, r1);
        return r1;
    L5:
        return r0.get(r6);
    }
}
