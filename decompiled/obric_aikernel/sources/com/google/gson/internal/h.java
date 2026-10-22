package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static boolean a(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) r10).isPrimitive() == false) goto L7;
        return true;
    }

    public static <T> Class<T> b(Class<T> r10) {
        if (r10 != Integer.TYPE) goto L7;
        return Integer.class;
    L7:
        if (r10 != Float.TYPE) goto L11;
        return Float.class;
    L11:
        if (r10 != Byte.TYPE) goto L15;
        return Byte.class;
    L15:
        if (r10 != Double.TYPE) goto L19;
        return Double.class;
    L19:
        if (r10 != Long.TYPE) goto L23;
        return Long.class;
    L23:
        if (r10 != Character.TYPE) goto L27;
        return Character.class;
    L27:
        if (r10 != Boolean.TYPE) goto L31;
        return Boolean.class;
    L31:
        if (r10 != Short.TYPE) goto L35;
        return Short.class;
    L35:
        if (r10 != Void.TYPE) goto L38;
        return Void.class;
    L38:
        return r10;
    }
}
