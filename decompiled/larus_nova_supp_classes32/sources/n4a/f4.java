package n4a;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f4 {
    public static Object b(Object r5, Class<?> r6, String r7, Object... r8) throws Exception {
        Class<?>[] r0 = new Class[r8.length];
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Class<?> r3 = r8[r2].getClass();
        r0[r2] = r3;
        if (r3 != Integer.class) goto L8;
        r0[r2] = Integer.TYPE;
    L8:
        if (r0[r2] != Boolean.class) goto L11;
        r0[r2] = Boolean.TYPE;
    L11:
        if (r0[r2] != Double.class) goto L13;
        r0[r2] = Double.TYPE;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        Method r9 = r6.getDeclaredMethod(r7, r0);
        if (r9.isAccessible() == true) goto L26;
        r9.setAccessible(true);
    L26:
        return r9.invoke(r5, r8);
    L19:
        th = move-exception;
        if ((th instanceof InvocationTargetException) == false) goto L23;
        c4.g(th.getTargetException(), "Reflect", "invokeMethod ".concat(r7));     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public static Object c(Object r1, String r2, Object... r3) {
        return b(r1, r1.getClass(), r2, r3);
    L4:
        return null;
    }

    public static Object d(String r1, String r2) throws Exception {
        Class r3 = a(r1);
        Field r4 = r3.getField(r2);
        r4.setAccessible(true);
        return r4.get(r3);
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

    public static Object e(String r0, String r1, Object[] r2, Class<?>[] r3) throws Exception {
        Method r4 = a(r0).getDeclaredMethod(r1, r3);
        if (r4.isAccessible() == true) goto L6;
        r4.setAccessible(true);
    L6:
        return r4.invoke(null, r2);
    }
}
