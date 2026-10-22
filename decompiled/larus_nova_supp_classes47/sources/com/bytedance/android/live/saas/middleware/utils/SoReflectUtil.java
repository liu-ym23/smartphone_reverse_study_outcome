package com.bytedance.android.live.saas.middleware.utils;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class SoReflectUtil {
    public SoReflectUtil() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_saas_middleware_utils_SoReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static Constructor<?> findConstructor(Object r3, Class<?>... r4) throws NoSuchMethodException {
        Class<?> r0 = r3.getClass();
    L3:
        if (r0 == null) goto L10;
        Constructor<?> r1 = r0.getDeclaredConstructor(r4);     // Catch: NoSuchMethodException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Constructor with parameters " + Arrays.asList(r4) + " not found in " + r3.getClass());
    }

    public static Field findField(Object r3, String r4) throws NoSuchFieldException {
        Class<?> r0 = r3.getClass();
    L3:
        if (r0 == null) goto L10;
        Field r1 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r4 + " not found in " + r3.getClass());
    }

    public static Object getActivityThread(Context r4, Class<?> r5) {
        if (r5 == null) goto L11;
    L5:
        Method r6 = r5.getMethod("currentActivityThread", new Class[0]);     // Catch: Throwable -> L10
        r6.setAccessible(true);     // Catch: Throwable -> L10
        Object r7 = r6.invoke(null, new Object[0]);     // Catch: Throwable -> L10
        if (r7 != null) goto L13;
        if (r4 == null) goto L14;
        Field r8 = r4.getClass().getField("mLoadedApk");     // Catch: Throwable -> L10
        r8.setAccessible(true);     // Catch: Throwable -> L10
        Object r9 = r8.get(r4);     // Catch: Throwable -> L10
        Field r10 = r9.getClass().getDeclaredField("mActivityThread");     // Catch: Throwable -> L10
        r10.setAccessible(true);     // Catch: Throwable -> L10
        return r10.get(r9);
    L10:
        return null;
    L14:
        return r7;
    L13:
        return r7;
    L11:
        r5 = INVOKESTATIC_com_bytedance_android_live_saas_middleware_utils_SoReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L10
        goto L5
    }

    public static Field findField(Class<?> r3, String r4) throws NoSuchFieldException {
        Class<?> r0 = r3;
    L3:
        if (r0 == null) goto L10;
        Field r1 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r4 + " not found in " + r3);
    }

    public static void expandFieldArray(Object r4, String r5, Object[] r6) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field r7 = findField(r4, r5);
        Object[] r0 = (Object[]) r7.get(r4);
        Object[] r1 = (Object[]) Array.newInstance(r0.getClass().getComponentType(), r0.length + r6.length);
        System.arraycopy(r6, 0, r1, 0, r6.length);
        System.arraycopy(r0, 0, r1, r6.length, r0.length);
        r7.set(r4, r1);
    }

    public static Method findMethod(Object r3, String r4, Class<?>... r5) throws NoSuchMethodException {
        Class<?> r0 = r3.getClass();
    L3:
        if (r0 == null) goto L10;
        Method r1 = r0.getDeclaredMethod(r4, r5);     // Catch: NoSuchMethodException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Method " + r4 + " with parameters " + Arrays.asList(r5) + " not found in " + r3.getClass());
    }

    public static int getValueOfStaticIntField(Class<?> r0, String r1, int r2) {
        return findField(r0, r1).getInt(null);
    L4:
        return r2;
    }

    public static void reduceFieldArray(Object r4, String r5, int r6) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (r6 > 0) goto L4;
        return;
    L4:
        Field r7 = findField(r4, r5);
        Object[] r0 = (Object[]) r7.get(r4);
        int r1 = r0.length - r6;
        if (r1 > 0) goto L7;
        return;
    L7:
        Object[] r2 = (Object[]) Array.newInstance(r0.getClass().getComponentType(), r1);
        System.arraycopy(r0, r6, r2, 0, r1);
        r7.set(r4, r2);
    }

    public static Method findMethod(Class<?> r3, String r4, Class<?>... r5) throws NoSuchMethodException {
    L2:
        if (r3 == null) goto L9;
        Method r0 = r3.getDeclaredMethod(r4, r5);     // Catch: NoSuchMethodException -> L7
        if (r0.isAccessible() == true) goto L6;
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L6:
        return r0;
    L7:
        r3 = r3.getSuperclass();
        goto L2
    L9:
        throw new NoSuchMethodException("Method " + r4 + " with parameters " + Arrays.asList(r5) + " not found in " + r3);
    }
}
