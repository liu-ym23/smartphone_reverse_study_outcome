package com.bytedance.android.annie.util;

import android.text.TextUtils;
import com.bytedance.ai.event.MessageIndication;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public static Method a(Class<?> r10, String r11, Class<?>[] r12) {
        if (r10 != null) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        int r13 = x8.a.a;     // Catch: Throwable -> L9
        String r1 = "thread id : " + ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("Annie_ReflectUtils", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r1, MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Throwable -> L9
        x8.a.d("Annie_ReflectUtils", r1, false);     // Catch: Throwable -> L9
        return r10.getMethod(r11, r12);
    L9:
        th = move-exception;
        int r14 = x8.a.a;
        x8.a.a("Annie_ReflectUtils", "exception in getMethod, pkg : " + r10.getName() + ", function : " + r11 + ", " + th.toString());
        return r10.getDeclaredMethod(r11, r12);
    }

    public static Object b(Class<?> r10, String r11, Object... r12) {
        Object r0 = null;
        if (r10 != null) goto L5;
    L18:
        return r0;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        Object[] r13 = new Object[0];
        Method r14 = a(r10, r11, new Class[0]);     // Catch: Throwable -> L16
        if (r14 == null) goto L19;
        r14.setAccessible(true);     // Catch: Throwable -> L16
        if (r12.length <= 0) goto L14;
        r0 = r14.invoke(r12[0], r13);     // Catch: Throwable -> L16
        goto L19
    L14:
        r0 = r14.invoke(null, r13);     // Catch: Throwable -> L16
    L19:
    L16:
        th = move-exception;
        int r1 = x8.a.a;
        x8.a.a("Annie_ReflectUtils", "exception in invokeMethod, pkg : " + r10.getName() + ", function : " + r11 + ", " + th.toString());
        goto L18
    }
}
