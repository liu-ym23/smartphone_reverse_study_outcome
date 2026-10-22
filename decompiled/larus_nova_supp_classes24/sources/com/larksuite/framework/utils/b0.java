package com.larksuite.framework.utils;

import android.os.Build;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b0 {
    public static Field a(Class<?> r6, String r7) {
    L8:
        e = move-exception;
        Log.e("ReflectionUtil", e.getMessage());
        return null;
    L3:
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return r6.getDeclaredField(r7);
    L7:
        return (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7});
    }

    public static Method b(Class<?> r7, String r8, Class... r9) {
    L8:
        e = move-exception;
        Log.e("ReflectionUtil", e.getMessage());
        return null;
    L3:
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return r7.getDeclaredMethod(r8, new Class[0]);
    L7:
        return (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});
    }
}
