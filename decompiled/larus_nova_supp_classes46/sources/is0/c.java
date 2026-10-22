package is0;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static ILivePlayerService a;
    public static a b;

    @JvmStatic
    public static final ILivePlayerService c() {
        if (a == null) goto L11;
    L9:
        ILivePlayerService r0 = a;
        Intrinsics.checkNotNull(r0);
        return r0;
    L11:
        Object r1 = b(a("com.bytedance.android.livesdk.player.LivePlayerService"));     // Catch: Exception -> L7
    L8:
        a = (ILivePlayerService) r1;
    L7:
        r1 = null;
        goto L8
    }

    static {
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

    public static Object b(Class r4) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<?>[] r0 = r4.getDeclaredConstructors();
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L19;
        Constructor<?> r1 = r0[0];
        r1.setAccessible(true);
        Class<?>[] r2 = r1.getParameterTypes();
        if (r2 == null) goto L17;
        if (r2.length == 0) goto L17;
        throw new ClassNotFoundException("not found ".concat(r4.getSimpleName()));
    L17:
        return r1.newInstance(new Object[0]);
    L19:
        throw new IllegalArgumentException(("Can't get even one available constructor for " + r4).toString());
    L5:
        if (r0.length == 0) goto L7;
        r3 = true;
        goto L8
    }
}
