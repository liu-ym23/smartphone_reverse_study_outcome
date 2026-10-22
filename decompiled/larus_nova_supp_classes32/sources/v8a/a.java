package v8a;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final Method a = null;
    public static final Method b = null;
    public static final Class c = null;
    public static final Class d = null;
    public static final PathClassLoader e = null;
    public static final Constructor<Class> f = null;
    public static final Object g = null;

    static {
        if (Build.VERSION.SDK_INT > 33) goto L5;
        String r2 = "/system/framework/MiuiBooster.jar";
    L6:
        a = null;
        b = null;
        d = null;
        f = null;
        g = null;
        PathClassLoader r4 = new PathClassLoader(r2, ClassLoader.getSystemClassLoader());     // Catch: Exception -> L33
        e = r4;     // Catch: Exception -> L33
        Class r3 = a(r4, "com.miui.performance.MiuiBooster");     // Catch: Exception -> L33
        c = r3;     // Catch: Exception -> L33
        f = r3.getConstructor(new Class[0]);     // Catch: Exception -> L33
        a = r3.getDeclaredMethod("checkPermission", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L42
    L80:
        d = a(e, "com.miui.performance.IThermalEventCallBack");     // Catch: Exception -> L43
    L63:
        b = c.getDeclaredMethod("checkPermission", new Class[]{Context.class, String.class, Integer.TYPE, String.class});     // Catch: Exception -> L44
    L82:
        Class<?> r6 = Integer.TYPE;     // Catch: Exception -> L45
        c.getDeclaredMethod("requestCpuHighFreq", new Class[]{r6, r6, r6});     // Catch: Exception -> L45
    L68:
        c.getDeclaredMethod("cancelCpuHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L46
    L88:
        Class<?> r7 = Integer.TYPE;     // Catch: Exception -> L47
        c.getDeclaredMethod("requestThreadPriority", new Class[]{r7, r7, r7});     // Catch: Exception -> L47
    L66:
        Class<?> r8 = Integer.TYPE;     // Catch: Exception -> L48
        c.getDeclaredMethod("cancelThreadPriority", new Class[]{r8, r8});     // Catch: Exception -> L48
    L86:
        Class<?> r9 = Integer.TYPE;     // Catch: Exception -> L49
        c.getDeclaredMethod("requestGpuHighFreq", new Class[]{r9, r9, r9});     // Catch: Exception -> L49
    L74:
        c.getDeclaredMethod("cancelGpuHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L50
    L94:
        Class<?> r10 = Integer.TYPE;     // Catch: Exception -> L51
        c.getDeclaredMethod("requestDdrHighFreq", new Class[]{r10, r10, r10});     // Catch: Exception -> L51
    L96:
        c.getDeclaredMethod("cancelDdrHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L52
    L92:
        Class<?> r11 = Integer.TYPE;     // Catch: Exception -> L53
        c.getDeclaredMethod("requestBindCore", new Class[]{r11, int[].class, r11, r11});     // Catch: Exception -> L53
    L72:
        Class<?> r12 = Integer.TYPE;     // Catch: Exception -> L54
        c.getDeclaredMethod("cancelBindCore", new Class[]{r12, r12});     // Catch: Exception -> L54
    L90:
        c.getDeclaredMethod("requestIOPrefetch", new Class[]{Integer.TYPE, String.class});     // Catch: Exception -> L55
    L61:
        Class<?> r13 = Integer.TYPE;     // Catch: Exception -> L56
        c.getDeclaredMethod("getSystemState", new Class[]{r13, Context.class, r13});     // Catch: Exception -> L56
    L102:
        Class<?> r14 = Integer.TYPE;     // Catch: Exception -> L57
        c.getDeclaredMethod("setDynamicRefreshRateScene", new Class[]{r14, String.class, r14});     // Catch: Exception -> L57
    L78:
        c.getDeclaredMethod("registerThermalEventCallback", new Class[]{Integer.TYPE, d});     // Catch: Exception -> L27
    L70:
        c.getDeclaredMethod("unRegisterThermalEventCallback", new Class[]{Integer.TYPE, d});     // Catch: Exception -> L58
    L84:
        Class<?> r5 = Integer.TYPE;     // Catch: Exception -> L59
        c.getDeclaredMethod("requestThreadLevelPro", new Class[]{r5, int[].class, r5, r5});     // Catch: Exception -> L59
    L76:
        Class<?> r1 = Integer.TYPE;     // Catch: Exception -> L60
        c.getDeclaredMethod("cancelThreadLevelPro", new Class[]{r1, r1});     // Catch: Exception -> L60
    L100:
        Constructor<Class> r0 = f;     // Catch: Exception -> L39
        if (r0 == null) goto L104;
        g = r0.newInstance(new Object[0]);     // Catch: Exception -> L39
        return;
    L104:
        return;
    L39:
        e = move-exception;
        e.toString();
        return;
    L27:
        e = move-exception;
        e.toString();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.toString();
        goto L100
    L5:
        r2 = "/system_ext/framework/MiuiBooster.jar";
        goto L6
    }

    public static boolean bindService() {
        return false;
    }

    public static void unbindService() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
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
        return MiraPluginFix.loadClass(r3);
    }
}
