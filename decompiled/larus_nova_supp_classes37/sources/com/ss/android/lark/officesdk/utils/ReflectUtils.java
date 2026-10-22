package com.ss.android.lark.officesdk.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReflectUtils {

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String r1) {
            super(r1);
        }

        public ReflectException(Throwable r1) {
            super(r1);
        }

        public ReflectException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public static <T> Class<T> a(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Type r3 = r2.getClass().getGenericSuperclass();
        if ((r3 instanceof ParameterizedType) == false) goto L16;
        if (r3 != null) goto L9;
        Type[] r4 = null;
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.length > 0) goto L15;
        return null;
    L15:
        return (Class) r4[0];
    L9:
        r4 = ((ParameterizedType) r3).getActualTypeArguments();
        goto L10
    L16:
        return null;
    }

    public static <T> Class<T> b(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Class<?> r4 = r3.getClass();
    L6:
        if (r4 == null) goto L12;
        if (r4.getGenericInterfaces() == null) goto L11;
        if (r4.getGenericInterfaces().length != 0) goto L12;
    L11:
        r4 = r4.getSuperclass();
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        Type[] r5 = r4.getGenericInterfaces();
        if (r5 != null) goto L17;
    L22:
        Type[] r6 = null;
    L23:
        if (r6 != null) goto L25;
        return null;
    L25:
        if (r6.length > 0) goto L28;
        return null;
    L28:
        return (Class) r6[0];
    L17:
        if (r5.length <= 0) goto L22;
        Type r7 = r5[0];
        if ((r7 instanceof ParameterizedType) == false) goto L22;
        r6 = ((ParameterizedType) r7).getActualTypeArguments();
        goto L23
    }
}
