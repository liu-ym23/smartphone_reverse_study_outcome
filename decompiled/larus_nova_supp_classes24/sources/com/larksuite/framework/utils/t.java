package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.HwChangeButtonWindowCtrl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.HwChangeButtonWindowCtrl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.HwChangeButtonWindowCtrl");
    }

    public static void b(Activity r5) {
    L28:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (Build.VERSION.SDK_INT == 26) goto L5;
        return;
    L5:
        if (RomUtils.g() == false) goto L38;
        Class r0 = a();     // Catch: Exception -> L28
        Field r1 = r0.getDeclaredField("mInstanceMap");     // Catch: Exception -> L28
        r1.setAccessible(true);     // Catch: Exception -> L28
        Object r6 = ((HashMap) r1.get(r0)).get(Integer.valueOf(r5.hashCode()));     // Catch: Exception -> L28
        if (r6 == null) goto L39;
        String r2 = "destoryView";
        Class<?> r3 = r6.getClass();     // Catch: Exception -> L28
    L12:
        if (r3 == Object.class) goto L16;
        Method r4 = r3.getDeclaredMethod(r2, null);     // Catch: Exception -> L15
    L17:
        r4.setAccessible(true);     // Catch: Exception -> L28
        r4.invoke(r6, null);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L22 IllegalArgumentException -> L24 Exception -> L28
    L42:
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L15:
        r3 = r3.getSuperclass();     // Catch: Exception -> L28
        goto L12
    L16:
        r4 = null;
        goto L17
    L39:
        return;
    }

    public static void c(Context r6) {
        InputMethodManager r0 = (InputMethodManager) r6.getSystemService("input_method");
        if (r0 != null) goto L5;
        return;
    L5:
        String[] r1 = {"mCurRootView", "mServedView", "mNextServedView"};
        int r2 = 0;
    L7:
        if (r2 >= 3) goto L21;
        String r3 = r1[r2];
        Field r4 = r0.getClass().getDeclaredField(r3);     // Catch: Exception -> L18
        if (r4.isAccessible() == true) goto L12;
        r4.setAccessible(true);     // Catch: Exception -> L18
    L12:
        Object r5 = r4.get(r0);     // Catch: Exception -> L18
        if ((r5 instanceof View) == false) goto L20;
        if (((View) r5).getContext() != r6) goto L29;
        r4.set(r0, null);     // Catch: Exception -> L18
        goto L20
    L29:
        return;
    L20:
        r2 = r2 + 1;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
