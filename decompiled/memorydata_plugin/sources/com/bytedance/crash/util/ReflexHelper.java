package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflexHelper {
    public ReflexHelper() {
    }

    public static Field getField(String r1, String r2) {
        Field r3 = ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getDeclaredField(r2);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3;
    L4:
        return null;
    }

    public static Method getMethod(Object r0, String r1, Class<?>... r2) {
        return r0.getClass().getMethod(r1, r2);
    }

    public static Method getMethod(String r1, String r2, Class<?>... r3) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getMethod(r2, r3);
    }

    public static Object getObject(Field r0, Object r1) {
        return r0.get(r1);
    L4:
        return null;
    }

    public static int getStaticInt(String r1, String r2) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getField(r2).getInt(null);
    }

    public static Object getStaticObject(String r1, String r2) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getField(r2).get(null);
    }
}
