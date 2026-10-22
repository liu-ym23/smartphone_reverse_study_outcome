package jta;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.common.applog.c0;
import com.ss.android.common.applog.d0;
import el9.a;
import ita.j;
import java.util.concurrent.ConcurrentHashMap;
import kta.u;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public static volatile g a = null;
    public static volatile boolean b = false;
    public static Context c = null;
    public static volatile int d = -1;
    public static volatile boolean e = false;
    public static volatile boolean f = false;
    public static volatile j g = null;
    public static int h = -1;
    public static final m i = null;
    public static l j;
    public static final b k = null;

    static {
        m r0 = new m();
        i = r0;
        j = r0;
        k = new b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.deviceregister.newuser.NewUserModeManager");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.deviceregister.newuser.NewUserModeManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");
    }

    public static int c() {
        return j.getAppId();
    }

    public static String d() {
        return j.getDeviceId();
    }

    public static String e() {
        return j.getInstallId();
    }

    public static boolean f() {
        if (d >= 0) goto L6;
        j.c("DeviceRegisterManager SwitchToBdtracker has not been set!", null);
    L6:
        if (d <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static void b(a r1) {
        j.p(r1);
    }

    public static boolean g(Context r1) {
        return j.r(r1);
    }

    public static void h(eta.b r1) {
        j.b(r1);
        if (f() == false) goto L5;
        i.getClass();
        u.b = r1;
    L5:
        c0.a = r1;
        if (f() == false) goto L8;
        k.b(r1);
        return;
    L8:
        d0.d = r1;
    }

    public g(boolean r2, boolean r3) {
        j.d(c, r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
