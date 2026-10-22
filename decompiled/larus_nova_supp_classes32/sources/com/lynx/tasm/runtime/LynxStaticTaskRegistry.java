package com.lynx.tasm.runtime;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
final class LynxStaticTaskRegistry {
    public static final ConcurrentHashMap<String, a> a = null;

    public static class a {
        public final Object a;
        public final Method b;

        public a(Object r1, Method r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public LynxStaticTaskRegistry() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

    public static Method b(Object r5) {
        Method[] r6 = r5.getClass().getMethods();
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Method r2 = r6[r1];
        if ("invoke".equals(r2.getName()) == false) goto L9;
        if (r2.getParameterTypes().length != 1) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    public static Object c(Class<?> r6) throws Exception {
        Object r4 = r6.getMethod("getTask", new Class[0]).invoke(null, new Object[0]);     // Catch: NoSuchMethodException -> L5
    L8:
        if (r4 == null) goto L10;
        return r4;
    L10:
        Object r7 = r6.getField("Companion").get(null);
        return r7.getClass().getMethod("getTask", new Class[0]).invoke(r7, new Object[0]);
    L14:
        return r7.getClass().getField("task").get(r7);
    L5:
        r4 = r6.getField("task").get(null);     // Catch: NoSuchFieldException -> L7
    L7:
        r4 = null;
        goto L8
    }

    public static boolean d(a r4, long r5) {
        r4.b.invoke(r4.a, new Object[]{Long.valueOf(r5)});     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        LLog.w("LynxStaticTaskRegistry", "Failed to invoke native task: " + e.getMessage());
        return false;
    }

    public static boolean executeTaskForId(String r7, long r8) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
    L35:
        return false;
    L5:
        if (r8 == 0) goto L35;
        if (r7.startsWith("kmp:jvm:") == false) goto L11;
        String r2 = r7.substring(8);
    L15:
        if (TextUtils.isEmpty(r2) == false) goto L17;
        return false;
    L17:
        ConcurrentHashMap<String, a> r4 = a;
        a r5 = r4.get(r2);
        if (r5 != null) goto L20;
        Object r6 = c(a(r2));     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r6 != null) goto L24;
        return false;
    L24:
        Method r9 = b(r6);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r9 != null) goto L28;
        LLog.w("LynxStaticTaskRegistry", "No invoke method found on native task: ".concat(r6.getClass().getName()));     // Catch: Exception -> L33 ClassNotFoundException -> L36
        return false;
    L28:
        a r1 = new a(r6, r9);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        a r3 = r4.putIfAbsent(r2, r1);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r3 == null) goto L32;
        r1 = r3;
    L32:
        return d(r1, r8);
    L33:
        e = move-exception;
        LLog.w("LynxStaticTaskRegistry", "Failed to resolve static task for id " + r7 + ": " + e.getMessage());
        goto L35
    L20:
        return d(r5, r8);
    L11:
        if (r7.startsWith("kmp:") == false) goto L13;
        r2 = null;
        goto L15
    L13:
        r2 = r7;
        goto L15
    }
}
