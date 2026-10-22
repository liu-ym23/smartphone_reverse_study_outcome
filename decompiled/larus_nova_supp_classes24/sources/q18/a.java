package q18;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import i18.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final List<String> a;
    public final Map<Class<? extends d>, Map<String, us5.b>> b;

    /* JADX INFO: renamed from: q18.a$a, reason: collision with other inner class name */
    public static class C0120a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new ArrayList();
        this.b = new ConcurrentHashMap();
        int r1 = 0;
    L4:
        if (r1 >= ((ArrayList) this.a).size()) goto L11;
        String r2 = ((String) ListProtector.get(this.a, r1)).replace("/", ".");
        b(((vs5.a) a(r2.substring(0, r2.indexOf(".class"))).newInstance()).a());     // Catch: Exception -> L8
    L10:
        r1 = r1 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
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

    public final void b(Map<Class, us5.a> r4) {
        Iterator<Map.Entry<Class, us5.a>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<Class, us5.a> r0 = r5.next();
        if (this.b.get(r0.getKey()) != null) goto L8;
        new HashMap();
    L8:
        us5.a r1 = r0.getValue();
        if (r1 == null) goto L4;
        monitor-enter(r1);
        monitor-exit(r1);
        goto L4
    }
}
