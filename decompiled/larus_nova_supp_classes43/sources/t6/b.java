package t6;

import com.bytedance.android.ad.sdk.spi.ReflectServiceFactory;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b {
    public final ConcurrentHashMap<Class<?>, d<?>> a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public <T> T b(Class<T> r10, Object r11) {
        d<?> r12 = this.a.get(r10);
        if (r12 == null) goto L5;
        Object r13 = r12.create();
    L7:
        if (r10.isInstance(r13) == false) goto L10;
        return r10.cast(r13);
    L10:
        if (r10.isAnnotationPresent(ReflectServiceFactory.class) == false) goto L31;
        ReflectServiceFactory r14 = (ReflectServiceFactory) r10.getAnnotation(ReflectServiceFactory.class);
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.implClassName().length() <= 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == false) goto L33;
        T r15 = r10.cast(a(r14.implClassName()).newInstance());     // Catch: Throwable -> L26
        if (r15 != null) goto L21;
        return null;
    L21:
        if (r14.singleton() == false) goto L35;
        c r16 = new c(r15);     // Catch: Throwable -> L26
        if (this.a.containsKey(r10) == true) goto L35;
        this.a.put(r10, r16);     // Catch: Throwable -> L26
    L35:
        return r15;
    L26:
        Objects.toString(r10);
        return null;
    L33:
        return null;
    L16:
        r1 = false;
        goto L17
    L31:
        return null;
    L5:
        r13 = null;
        goto L7
    }
}
