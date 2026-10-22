package wqa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.utils.g;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import sa7.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a implements f {
    public k a;
    public g b;

    public a() {
    }

    @Override // wqa.f
    public final k a() {
        k r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        tb7.a.a("AbsTTAccountConfig", "call getNetwork");
        k r1 = (k) g("com.ss.android.account.adapter.NetworkAdapter").newInstance();     // Catch: Exception -> L8
        this.a = r1;     // Catch: Exception -> L8
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // wqa.f
    public final g getMonitor() {
        g r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        tb7.a.a("AbsTTAccountConfig", "call getMonitor");
        g r1 = (g) g("com.ss.android.account.adapter.MonitorAdapter").newInstance();     // Catch: Exception -> L8
        this.b = r1;     // Catch: Exception -> L8
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class g(String r3) throws ClassNotFoundException {
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
}
