package qna;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static Object a;
    public static Method b;
    public static Field c;
    public static final Lazy d = null;

    static {
        d = LazyKt.lazy(new b());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r2 = Class.forName("sun.misc.Unsafe");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.misc.Unsafe");     // Catch: Throwable -> L17
    L16:
        return r2;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.misc.Unsafe");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.misc.Unsafe");
    L34:
        Class<?> r3 = Class.forName("sun.misc.Unsafe");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.misc.Unsafe");     // Catch: Throwable -> L8
    L7:
        return r3;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.misc.Unsafe");
    L12:
        throw th;
    }

    public static int b(Thread r8) {
        Intrinsics.checkNotNullParameter(r8, "t");
        Field r0 = c;
        if (r0 != null) goto L23;
    L7:
        long r3 = 0;
    L9:
        if (r3 == 0) goto L25;
        Method r1 = b;     // Catch: Throwable -> L20
        Integer r2 = null;
        if (r1 == null) goto L13;
        Object r4 = r1.invoke(a, new Object[]{Long.valueOf(r3 + ((long) ((Number) d.getValue()).intValue()))});     // Catch: Throwable -> L20
    L15:
        if ((r4 instanceof Integer) == false) goto L17;
        r2 = (Integer) r4;     // Catch: Throwable -> L20
    L17:
        if (r2 == null) goto L26;
        return r2.intValue();
    L26:
        return 0;
    L13:
        r4 = null;
    L27:
        return 0;
    L25:
        return 0;
    L23:
        Object r9 = r0.get(r8);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L6
        r3 = ((Long) r9).longValue();     // Catch: Throwable -> L6
        goto L9
    }
}
