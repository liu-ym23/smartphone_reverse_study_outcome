package e84;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v implements m {
    public static final Object a = null;
    public static final Class<?> b = null;
    public static final Method c = null;

    public final String getName() {
        return "Xiaomi";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.id.impl.IdProviderImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.id.impl.IdProviderImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.android.id.impl.IdProviderImpl");
    }

    static {
        Class<?> r0 = b();     // Catch: Exception -> L4
        b = r0;     // Catch: Exception -> L4
        a = r0.newInstance();     // Catch: Exception -> L4
        c = r0.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.bdinstall.t.b("Oaid#static reflect exception! " + e.getMessage());
    }

    public v() {
    }

    public final boolean a(Context r1) {
        if (b != null) goto L5;
    L9:
        return false;
    L5:
        if (a == null) goto L9;
        if (c == null) goto L9;
        return true;
    }

    public final m$a getOaid(Context r7) {
        m$a r1 = new m$a();     // Catch: Exception -> L14
        Method r2 = c;     // Catch: Exception -> L14
        Object r3 = a;     // Catch: Exception -> L14
        if (r3 == null) goto L11;
        if (r2 == null) goto L11;
        Object r8 = r2.invoke(r3, new Object[]{r7});     // Catch: Exception -> L17
        if (r8 == null) goto L11;
        String r9 = (String) r8;     // Catch: Exception -> L17
    L12:
        r1.a = r9;     // Catch: Exception -> L14
        return r1;
    L11:
        r9 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
