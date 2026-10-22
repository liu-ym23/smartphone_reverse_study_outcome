package caa;

import android.os.Vibrator;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(new d());
        b = LazyKt.lazy(new e());
        c = LazyKt.lazy(new f());
        d = LazyKt.lazy(new g());
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

    public static void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "effect");
        ISysLogDepend.c.d("SystemHiddenApiHelper", "performVibratorSmtFeedback " + r6);
        Class r0 = (Class) c.getValue();     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        Field r7 = r0.getField(r6);     // Catch: Throwable -> L8
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getInt(null));     // Catch: Throwable -> L8
    L11:
        if (r8 == null) goto L20;
        int r9 = r8.intValue();     // Catch: Throwable -> L8
        Method r1 = (Method) d.getValue();     // Catch: Throwable -> L8
        if (r1 == null) goto L21;
        r1.invoke(null, new Object[]{(Vibrator) b.getValue(), Integer.valueOf(r9)});     // Catch: Throwable -> L8
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r8 = null;
    L8:
        th = move-exception;
        ISysLogDepend.c.e("SystemHiddenApiHelper", "vibrator invoke failed", th);
    }
}
