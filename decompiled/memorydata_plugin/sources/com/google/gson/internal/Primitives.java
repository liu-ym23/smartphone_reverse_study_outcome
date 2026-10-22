package com.google.gson.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).isPrimitive() == false) goto L7;
        return true;
    }

    public static boolean isWrapperType(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (r3 != Integer.class) goto L5;
    L22:
        return true;
    L5:
        if (r3 == Float.class) goto L22;
        if (r3 == Byte.class) goto L22;
        if (r3 == Double.class) goto L22;
        if (r3 == Long.class) goto L22;
        if (r3 == Character.class) goto L22;
        if (r3 == Boolean.class) goto L22;
        if (r3 == Short.class) goto L22;
        if (r3 == Void.class) goto L22;
        return false;
    }

    public static <T> Class<T> unwrap(Class<T> r1) {
        if (r1 != Integer.class) goto L7;
        return Integer.TYPE;
    L7:
        if (r1 != Float.class) goto L11;
        return Float.TYPE;
    L11:
        if (r1 != Byte.class) goto L15;
        return Byte.TYPE;
    L15:
        if (r1 != Double.class) goto L19;
        return Double.TYPE;
    L19:
        if (r1 != Long.class) goto L23;
        return Long.TYPE;
    L23:
        if (r1 != Character.class) goto L27;
        return Character.TYPE;
    L27:
        if (r1 != Boolean.class) goto L31;
        return Boolean.TYPE;
    L31:
        if (r1 != Short.class) goto L35;
        return Short.TYPE;
    L35:
        if (r1 == Void.class) goto L37;
        return r1;
    L37:
        return Void.TYPE;
    }

    public static <T> Class<T> wrap(Class<T> r1) {
        if (r1 != Integer.TYPE) goto L7;
        return Integer.class;
    L7:
        if (r1 != Float.TYPE) goto L11;
        return Float.class;
    L11:
        if (r1 != Byte.TYPE) goto L15;
        return Byte.class;
    L15:
        if (r1 != Double.TYPE) goto L19;
        return Double.class;
    L19:
        if (r1 != Long.TYPE) goto L23;
        return Long.class;
    L23:
        if (r1 != Character.TYPE) goto L27;
        return Character.class;
    L27:
        if (r1 != Boolean.TYPE) goto L31;
        return Boolean.class;
    L31:
        if (r1 != Short.TYPE) goto L35;
        return Short.class;
    L35:
        if (r1 != Void.TYPE) goto L38;
        return Void.class;
    L38:
        return r1;
    }
}
