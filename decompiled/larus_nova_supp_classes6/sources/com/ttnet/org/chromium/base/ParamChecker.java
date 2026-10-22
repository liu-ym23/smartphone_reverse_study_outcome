package com.ttnet.org.chromium.base;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParamChecker {
    public ParamChecker() {
    }

    private static String getTypeName(Class<?> r1) {
        if (r1 != null) goto L6;
        return "null";
    L6:
        if (r1.isArray() == false) goto L10;
        return r1.getCanonicalName();
    L10:
        if (r1.isPrimitive() == false) goto L14;
        return r1.getName();
    L14:
        return r1.getCanonicalName();
    }

    private static Class<?> toWrapperClass(Class<?> r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2.isPrimitive() == false) goto L44;
        String r0 = r2.getName();
        if (r0.equals("double") == false) goto L9;
        return Double.class;
    L9:
        if (r0.equals("int") == false) goto L11;
        return Integer.class;
    L11:
        if (r0.equals("byte") == false) goto L13;
        return Byte.class;
    L13:
        if (r0.equals("char") == false) goto L15;
        return Character.class;
    L15:
        if (r0.equals("long") == false) goto L17;
        return Long.class;
    L17:
        if (r0.equals("void") == false) goto L19;
        return Void.class;
    L19:
        if (r0.equals("boolean") == false) goto L21;
        return Boolean.class;
    L21:
        if (r0.equals("float") == false) goto L23;
        return Float.class;
    L23:
        if (r0.equals("short") == true) goto L25;
        return r2;
    L25:
        return Short.class;
    L44:
        return r2;
    }

    public static void check(Class<?>[] r7, Object... r8) {
        Objects.requireNonNull(r7, "parameterType should not be null");
        if (r8 != null) goto L6;
        r8 = new Object[0];
    L6:
        if (r7.length != r8.length) goto L21;
        int r1 = 0;
    L9:
        if (r1 >= r7.length) goto L19;
        Class<?> r2 = r7[r1];
        Object r5 = r8[r1];
        if (isTypeCompatible(r2, r5) == false) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        String r9 = getTypeName(r2);
        if (r5 != null) goto L15;
        String r10 = "null";
    L17:
        throw new IllegalArgumentException(String.format("The param %d type mismatch: expected %s, actual %s", new Object[]{Integer.valueOf(r1 + 1), r9, r10}));
    L15:
        r10 = getTypeName(r5.getClass());
        goto L17
    L19:
        return;
    L21:
        throw new IllegalArgumentException(String.format("param count mismatch: expected %d, actual %d", new Object[]{Integer.valueOf(r7.length), Integer.valueOf(r8.length)}));
    }

    private static boolean isTypeCompatible(Class<?> r0, Object r1) {
        if (r1 != null) goto L6;
        return !r0.isPrimitive();
    L6:
        return toWrapperClass(r0).isAssignableFrom(toWrapperClass(r1.getClass()));
    }
}
