package ms.bd.c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u3 {
    public static volatile u3 f;
    public final PthreadHandlerThreadV2 a;
    public final Context b;
    public boolean c;
    public DisplayManager d;
    public e0 e;

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.c = true;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(new PthreadThreadV2(new t3(this), "ms/bd/c/u3"));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void finalize() {
        monitor-enter(this);
        DisplayManager r0 = this.d;     // Catch: Throwable -> L17
        if (r0 == null) goto L21;
        e0 r1 = this.e;     // Catch: Throwable -> L17
        if (r1 == null) goto L21;
        r0.unregisterDisplayListener(r1);     // Catch: Throwable -> L17
    L21:
        PthreadHandlerThreadV2 r2 = this.a;     // Catch: Throwable -> L14
        if (r2 != null) goto L19;
    L11:
        monitor-exit(this);
        super.finalize();
        return;
    L19:
        r2.quitSafely();     // Catch: Throwable -> L18
    L14:
        th = move-exception;
        throw th;
    }

    public u3(Context r39) {
        this.c = false;
        Context r2 = r39.getApplicationContext();
        this.b = r2;
        if ((r2 instanceof Application) == false) goto L17;
    L14:
        this.a = new PthreadHandlerThreadV2((String) p2.a(16777217, 0, 0, "a1e5d9", new byte[]{93, 0, 37, 115}));
        return;
    L17:
        Context r3 = null;
        r3 = (Application) a((String) p2.a(16777217, 0, 0, "47a00e", new byte[]{36, 59, 22, 86, 0, 123, 51, 88, 49, 112, 53, 123, 51, 71, 27, 123, 33, 31, 36, 121, 17, 61, 0, 65, 14, 118})).getMethod((String) p2.a(16777217, 0, 0, "23394a", new byte[]{32, 36, 82, 95, 14, 120, 37, 51, 114, 121, 47, 56, 67, 76, 31, ByteCompanionObject.MAX_VALUE, 62, 28}), null).invoke(null, null);     // Catch: Throwable -> L16
    L11:
        if (r3 != null) goto L13;
        r3 = this.b;
    L13:
        this.b = r3;
    L9:
        r3 = null;
        goto L11
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
