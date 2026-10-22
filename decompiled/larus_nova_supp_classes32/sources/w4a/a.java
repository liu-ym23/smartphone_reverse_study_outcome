package w4a;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.service.IAutoRegisterAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static volatile a b;
    public static final String[] c = null;
    public final Map<e, Map<Class<? extends IAnimaXService>, IAnimaXService>> a;

    static {
        c = new String[]{"com.lynx.animax.service.AnimaXFrescoImageService", "com.lynx.animax.monitor.common.AnimaXCommonMonitorService"};
    }

    public static a b() {
        if (b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public a() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        this.a = r0;
        r0.put(e.b, new ConcurrentHashMap());
        String[] r1 = c;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L13;
        String r5 = r1[r4];
        Class r6 = a(r5);     // Catch: Exception -> L10
        if (IAutoRegisterAnimaXService.class.isAssignableFrom(r6) == true) goto L8;
        AnimaXLog.d("AnimaXServiceCenter", "Class " + r5 + " does not implement IAutoRegisterAnimaXService");     // Catch: Exception -> L10
    L12:
        r4 = r4 + 1;
        goto L3
    L8:
        IAutoRegisterAnimaXService r7 = (IAutoRegisterAnimaXService) r6.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        c(r7.getAutoRegisterServiceScope(), r7.getServiceClass(), r7);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        AnimaXLog.a("AnimaXServiceCenter", "Failed to auto-register service " + r5 + ": " + e.toString());
        goto L12
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

    public final void c(e r4, Class<? extends IAnimaXService> r5, IAnimaXService r6) {
        Map r0 = (Map) ((ConcurrentHashMap) this.a).get(r4);
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        ((ConcurrentHashMap) this.a).put(r4, r0);
    L5:
        boolean r1 = r0.containsKey(r5);
        if (r1 == true) goto L8;
        r0.put(r5, r6);
    L8:
        AnimaXLog.b("AnimaXServiceCenter", String.format("Register service %s with instance %s in scope %s, result: %s", new Object[]{r5.getSimpleName(), r6, r4, Boolean.valueOf(!r1)}));
    }
}
