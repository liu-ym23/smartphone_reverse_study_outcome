package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Set<Class<?>> d = null;
    public static final Set<Class<?>> e = null;
    public final Class[] a;
    public boolean b;
    public String c;

    static {
        d = b(JavaOnlyMap.class);
        e = b(JavaOnlyArray.class);
    }

    public e(Method r2) {
        this.b = false;
        r2.setAccessible(true);
        this.a = r2.getParameterTypes();
    }

    public static char a(Class r1) {
        if (r1.equals(Byte.TYPE) == false) goto L7;
        return 'b';
    L7:
        if (r1.equals(Byte.class) == false) goto L11;
        return 'B';
    L11:
        if (r1.equals(Short.TYPE) == false) goto L15;
        return 's';
    L15:
        if (r1.equals(Short.class) == false) goto L19;
        return 'S';
    L19:
        if (r1.equals(Long.TYPE) == false) goto L23;
        return 'l';
    L23:
        if (r1.equals(Long.class) == false) goto L27;
        return 'L';
    L27:
        if (r1.equals(Character.TYPE) == false) goto L31;
        return 'c';
    L31:
        if (r1.equals(Character.class) == false) goto L35;
        return 'C';
    L35:
        if (r1.equals(Boolean.TYPE) == false) goto L39;
        return 'z';
    L39:
        if (r1.equals(Boolean.class) == false) goto L43;
        return 'Z';
    L43:
        if (r1.equals(Integer.TYPE) == false) goto L47;
        return 'i';
    L47:
        if (r1.equals(Integer.class) == false) goto L51;
        return 'I';
    L51:
        if (r1.equals(Double.TYPE) == false) goto L55;
        return 'd';
    L55:
        if (r1.equals(Double.class) == false) goto L59;
        return 'D';
    L59:
        if (r1.equals(Float.TYPE) == false) goto L63;
        return 'f';
    L63:
        if (r1.equals(Float.class) == false) goto L67;
        return 'F';
    L67:
        if (r1.equals(String.class) == false) goto L70;
        return 'T';
    L70:
        return 0;
    }

    public static Set<Class<?>> b(Class<?> r2) {
        HashSet r0 = new HashSet();
        r0.add(r2);
        Class<? super Object> r1 = r2.getSuperclass();
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Class<?>[] r3 = r2.getInterfaces();
        if (r3.length <= 0) goto L8;
        r0.addAll(Arrays.asList(r3));
    L8:
        return r0;
    }
}
