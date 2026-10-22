package bkb;

import android.content.Context;
import com.bytedance.geckox.GeckoBuildInManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.iesgurd.core.e");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.iesgurd.core.GeckoBuildInManager");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.iesgurd.core.GeckoBuildInManager");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.iesgurd.core.e");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.iesgurd.core.GeckoBuildInManager");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.iesgurd.core.GeckoBuildInManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.iesgurd.core.GeckoBuildInManager");
    }

    public static d b(Context r11, String r12, String r13, String r14) {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L27;
        Class r1 = a();     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        Object r15 = r1.getMethod("getBuildInPath", new Class[]{Context.class, String.class, String.class, String.class}).invoke(r1.getField("INSTANCE").get(null), new Object[]{r11, r12, r13, r14});     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        if (r15 != null) goto L8;
        d r16 = new d(null, null, "IESGurd returns null IESGurdBuildInPath");     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
    L24:
        return r16;
    L8:
        Class<?> r17 = r15.getClass();     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        r16 = new d((String) r17.getMethod("getPath", new Class[0]).invoke(r15, new Object[0]), (Long) r17.getMethod("getVersion", new Class[0]).invoke(r15, new Object[0]), (String) r17.getMethod("getFailMsg", new Class[0]).invoke(r15, new Object[0]));     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
    L19:
        e = move-exception;
        d r18 = new d(null, null, "IESGurd API is unavailable in OfficeSDK host: " + e);
    L28:
        return r18;
    L10:
        e = e;
    L14:
        if ((e instanceof InvocationTargetException) == false) goto L18;
        InvocationTargetException r19 = (InvocationTargetException) e;
        if (r19.getTargetException() == null) goto L18;
        e = r19.getTargetException();
    L18:
        r18 = new d(null, null, "IESGurd getBuildInPath failed: " + e);
    L12:
        e = e;
        goto L14
    L27:
        return c(r11, r12, r13, r14);
    }

    public static d c(Context r1, String r2, String r3, String r4) {
        GeckoBuildInManager.GeckoBuildInPath r5 = GeckoBuildInManager.INSTANCE.getBuildInPath(r1, r2, r3, r4);
        if (r5 != null) goto L7;
        return new d(null, null, "geckox returns null GeckoBuildInPath");
    L7:
        return new d(r5.getPath(), r5.getVersion(), r5.getFailMsg());
    }
}
