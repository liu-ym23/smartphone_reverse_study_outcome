package dmb;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements xm4.a.a {
    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c(String r3) throws ClassNotFoundException {
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

    public static Object d(String r5) {
        Class r3 = c(r5);     // Catch: ClassNotFoundException -> L9
        if (iua.a.class.isAssignableFrom(r3) == false) goto L7;
        Object r2 = ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(r3, true);     // Catch: ClassNotFoundException -> L9
        tt5.a.h("DocABTest", "getABTestValue<" + r3 + ">: " + r2);     // Catch: ClassNotFoundException -> L9
        return r2;
    L7:
        tt5.a.d("DocABTest", "error: Class<" + r5 + "> doesn't inherit from class<LarkExperimentConfig>.");     // Catch: ClassNotFoundException -> L9
        return null;
    L9:
        tt5.a.d("DocABTest", "error: Class< " + r5 + "> not found.");
        return null;
    }

    public final Boolean a(String r2) {
        Object r3 = d(r2);
        if ((r3 instanceof Boolean) == true) goto L5;
        return null;
    L5:
        return (Boolean) r3;
    }

    public final String b(String r2) {
        Object r3 = d(r2);
        if ((r3 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r3;
    }
}
