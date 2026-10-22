package com.bytedance.platform.godzilla.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static Field a(Class<?> r6, String r7) {
        Field r8 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7}), Field.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
