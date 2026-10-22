package ry;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final Map<Class<?>, Class<?>> a = null;

    public static class a<T> {
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        Class r2 = Boolean.TYPE;
        r0.put(Boolean.class, r2);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        Class r3 = Integer.TYPE;
        r0.put(Integer.class, r3);
        Class r4 = Float.TYPE;
        r0.put(Float.class, r4);
        Class r5 = Long.TYPE;
        r0.put(Long.class, r5);
        r0.put(Double.class, Double.TYPE);
        r0.put(r2, r2);
        Class r1 = Byte.TYPE;
        r0.put(r1, r1);
        Class r6 = Character.TYPE;
        r0.put(r6, r6);
        Class r7 = Short.TYPE;
        r0.put(r7, r7);
        r0.put(r3, r3);
        r0.put(r4, r4);
        r0.put(r5, r5);
        Class r8 = Double.TYPE;
        r0.put(r8, r8);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class b(ClassLoader r5) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r6 = Class.forName("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", true, r5);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom.live.adapter.ECLiveAdapter");     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom.live.adapter.ECLiveAdapter");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ecom.live.adapter.ECLiveAdapter");
    L34:
        Class<?> r7 = Class.forName("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", true, r5);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom.live.adapter.ECLiveAdapter");     // Catch: Throwable -> L8
    L7:
        return r7;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom.live.adapter.ECLiveAdapter");
    L12:
        throw th;
    }

    public static Class<?>[] e(Object... r5) {
        if (r5.length <= 0) goto L22;
        Class<?>[] r0 = new Class[r5.length];
        int r2 = 0;
    L6:
        if (r2 >= r5.length) goto L18;
        Object r3 = r5[r2];
        if (r3 != null) goto L10;
    L12:
        if (r3 != null) goto L14;
        Class<?> r4 = null;
    L15:
        r0[r2] = r4;
    L16:
        r2 = r2 + 1;
        goto L6
    L14:
        r4 = r3.getClass();
        goto L15
    L10:
        if ((r3 instanceof a) == false) goto L12;
        a r6 = (a) r3;
        r0[r2] = null;
        goto L16
    L18:
        return r0;
    L22:
        return null;
    }

    public static Object[] f(Object... r5) {
        if (r5.length <= 0) goto L19;
        Object[] r0 = new Object[r5.length];
        int r2 = 0;
    L6:
        if (r2 >= r5.length) goto L15;
        Object r3 = r5[r2];
        if (r3 != null) goto L10;
    L12:
        r0[r2] = r3;
    L13:
        r2 = r2 + 1;
        goto L6
    L10:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        r0[r2] = null;
        goto L13
    L15:
        return r0;
    L19:
        return null;
    }

    public static <T> T d(Object r3, String r4) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r0 = r3.getClass();
        Field r1 = null;
    L4:
        if (r1 != null) goto L12;
        r1 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L7
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r0 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r0 = r0.getSuperclass();
        goto L8
    L12:
        r1.setAccessible(true);
        return (T) r1.get(r3);
    }

    public static Method c(Class<?> r11, String r12, Class<?>... r13) throws NoSuchMethodException, SecurityException {
        Method[] r0 = r11.getDeclaredMethods();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L35;
        Method r5 = r0[r3];
        if (r5.getName().equals(r12) == false) goto L34;
        Class<?>[] r6 = r5.getParameterTypes();
        if (r6 != null) goto L13;
        if (r13 != null) goto L11;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == false) goto L34;
    L36:
        if (r5 == null) goto L38;
        r5.setAccessible(true);
        return r5;
    L38:
        if (r11.getSuperclass() == null) goto L42;
        return c(r11.getSuperclass(), r12, r13);
    L42:
        throw new NoSuchMethodException();
    L11:
        if (r13.length == 0) goto L31;
    L29:
        r7 = false;
        goto L32
    L13:
        if (r13 != null) goto L18;
        if (r6.length != 0) goto L29;
    L18:
        if (r6.length != r13.length) goto L29;
        int r8 = 0;
    L22:
        if (r8 >= r6.length) goto L31;
        if (r6[r8].isAssignableFrom(r13[r8]) == true) goto L30;
        Map<Class<?>, Class<?>> r9 = a;
        HashMap r14 = (HashMap) r9;
        if (r14.containsKey(r6[r8]) == false) goto L29;
        if (((Class) r14.get(r6[r8])).equals(r14.get(r13[r8])) == false) goto L29;
    L30:
        r8 = r8 + 1;
    L34:
        r3 = r3 + 1;
        goto L4
    L35:
        r5 = null;
        goto L36
    }
}
