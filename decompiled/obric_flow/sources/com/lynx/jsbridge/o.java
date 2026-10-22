package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final HashSet d = null;
    public static final HashSet e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class[] f9931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9933c;

    static {
        HashSet r5 = new HashSet();
        r5.add(JavaOnlyMap.class);
        Class r10 = JavaOnlyMap.class.getSuperclass();
        if (r10 == null) goto L5;
        r5.add(r10);
    L5:
        Class<?>[] r11 = JavaOnlyMap.class.getInterfaces();
        if (r11.length <= 0) goto L8;
        r5.addAll(Arrays.asList(r11));
    L8:
        d = r5;
        HashSet r12 = new HashSet();
        r12.add(JavaOnlyArray.class);
        Class r13 = JavaOnlyArray.class.getSuperclass();
        if (r13 == null) goto L11;
        r12.add(r13);
    L11:
        Class<?>[] r14 = JavaOnlyArray.class.getInterfaces();
        if (r14.length <= 0) goto L14;
        r12.addAll(Arrays.asList(r14));
    L14:
        e = r12;
    }

    public o(Method r5) {
        this.f9932b = false;
        r5.setAccessible(true);
        this.f9931a = r5.getParameterTypes();
    }

    public static char a(Class r5) {
        if (r5.equals(Byte.TYPE) == false) goto L7;
        return 'b';
    L7:
        if (r5.equals(Byte.class) == false) goto L11;
        return 'B';
    L11:
        if (r5.equals(Short.TYPE) == false) goto L15;
        return 's';
    L15:
        if (r5.equals(Short.class) == false) goto L19;
        return 'S';
    L19:
        if (r5.equals(Long.TYPE) == false) goto L23;
        return 'l';
    L23:
        if (r5.equals(Long.class) == false) goto L27;
        return 'L';
    L27:
        if (r5.equals(Character.TYPE) == false) goto L31;
        return 'c';
    L31:
        if (r5.equals(Character.class) == false) goto L35;
        return 'C';
    L35:
        if (r5.equals(Boolean.TYPE) == false) goto L39;
        return 'z';
    L39:
        if (r5.equals(Boolean.class) == false) goto L43;
        return 'Z';
    L43:
        if (r5.equals(Integer.TYPE) == false) goto L47;
        return 'i';
    L47:
        if (r5.equals(Integer.class) == false) goto L51;
        return 'I';
    L51:
        if (r5.equals(Double.TYPE) == false) goto L55;
        return 'd';
    L55:
        if (r5.equals(Double.class) == false) goto L59;
        return 'D';
    L59:
        if (r5.equals(Float.TYPE) == false) goto L63;
        return 'f';
    L63:
        if (r5.equals(Float.class) == false) goto L67;
        return 'F';
    L67:
        if (r5.equals(String.class) == false) goto L70;
        return 'T';
    L70:
        return 0;
    }
}
