package com.obric.sva.sdk.boost;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DoubleReflector {
    private static final String TAG = "DoubleReflector";
    private static Method mForNameMethod;
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;

    public DoubleReflector() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L4
        mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L4
        mForNameMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L4
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_boost_DoubleReflector_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public static Class<?> getClass(String r4) throws Exception {
        Class<?> r2 = null;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r0 = mForNameMethod;
        if (r0 == null) goto L7;
        r2 = (Class) r0.invoke(null, new Object[]{r4});
    L7:
        if (r2 == null) goto L9;
        return r2;
    L9:
        return INVOKESTATIC_com_obric_sva_sdk_boost_DoubleReflector_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r4);
    }

    public static Constructor getConstructor(Class<?> r3, Class<?>... r4) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r0 = mGetDeclaredConstructorMethod;
        if (r0 == null) goto L7;
        Constructor r1 = (Constructor) r0.invoke(r3, new Object[]{r4});
    L8:
        if (r1 == null) goto L10;
        return r1;
    L10:
        return r3.getDeclaredConstructor(r4);
    L7:
        r1 = null;
        goto L8
    }

    public static Field getField(Class<?> r3, String r4) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r0 = mGetDeclaredFieldMethod;
        if (r0 == null) goto L7;
        Field r1 = (Field) r0.invoke(r3, new Object[]{r4});
    L8:
        if (r1 == null) goto L10;
        return r1;
    L10:
        return r3.getDeclaredField(r4);
    L7:
        r1 = null;
        goto L8
    }

    public static Object readField(Object r1, String r2) {
        Field r3 = getField(r1.getClass(), r2);     // Catch: Throwable -> L4
        r3.setAccessible(true);     // Catch: Throwable -> L4
        return r3.get(r1);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethod(Class<?> r3, String r4, Class<?>... r5) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r0 = mGetDeclaredMethod;
        if (r0 == null) goto L7;
        Method r1 = (Method) r0.invoke(r3, new Object[]{r4, r5});
    L8:
        if (r1 == null) goto L10;
        return r1;
    L10:
        return r3.getDeclaredMethod(r4, r5);
    L7:
        r1 = null;
        goto L8
    }
}
