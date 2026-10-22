package ms.bd.c;

import android.app.Application;
import android.os.Handler;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m implements Runnable {
    public static void b() {
        if (n.g.getAndSet(false) == false) goto L25;
        PthreadHandlerThreadV2 r0 = n.f;     // Catch: Exception -> L15
        ThreadMethodProxy.start(r0);     // Catch: Exception -> L15
        n.h = new Handler(r0.getLooper());     // Catch: Exception -> L15
    L21:
        Application r1 = null;
        Application r2 = (Application) a((String) p2.a(16777217, 0, 0, "b13686", new byte[]{114, 61, 68, 80, 8, 40, 101, 94, 99, 118, 99, 125, 97, 65, 19, 40, 119, 25, 118, ByteCompanionObject.MAX_VALUE, 71, 59, 82, 71, 6, 37})).getMethod((String) p2.a(16777217, 0, 0, "b7437f", new byte[]{112, 32, 85, 85, 13, ByteCompanionObject.MAX_VALUE, 117, 55, 117, 115, ByteCompanionObject.MAX_VALUE, 60, 68, 70, 28, 120, 110, 24}), null).invoke(null, null);     // Catch: Throwable -> L16
    L17:
        r2.registerActivityLifecycleCallbacks(new l());     // Catch: Throwable -> L14
        return;
    L26:
        return;
    L11:
        r2 = r1;
    L10:
        r1 = null;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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
}
