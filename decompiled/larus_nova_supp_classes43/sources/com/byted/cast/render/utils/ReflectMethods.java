package com.byted.cast.render.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ReflectMethods {
    private static final String TAG = null;

    public ReflectMethods() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        TAG = ReflectMethods.class.getName();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_render_utils_ReflectMethods_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r11 = access$000(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class r12 = access$000(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public static Object invokeStaticMethod(String r10, String r11, Class[] r12, Object[] r13) {
        Class r14 = INVOKESTATIC_com_byted_cast_render_utils_ReflectMethods_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r10);     // Catch: Exception -> L17
        Method r15 = null;
    L5:
        if (r14 == Object.class) goto L10;
        r15 = r14.getMethod(r11, r12);     // Catch: Exception -> L20
        if (r15 != null) goto L10;
    L9:
        r14 = r14.getSuperclass();     // Catch: Exception -> L17
    L10:
        if (r15 != null) goto L12;
        Logger.i(TAG, "not found " + r11 + " method");     // Catch: Exception -> L17
        return null;
    L12:
        if (r15.isAccessible() == true) goto L14;
        r15.setAccessible(true);     // Catch: Exception -> L17
    L14:
        Object r1 = r15.invoke(null, r13);     // Catch: Exception -> L17
        Logger.d(TAG, "invoke " + r11 + " method succeed");     // Catch: Exception -> L17
        return r1;
    L17:
        e = move-exception;
        Logger.i(TAG, "invoke " + r11 + " method failed: " + e);
        return null;
    }
}
