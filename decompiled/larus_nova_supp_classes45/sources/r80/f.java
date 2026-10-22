package r80;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import j40.q0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class f implements com.bytedance.android.live.core.utils.screen.a, com.bytedance.android.live.core.utils.screen.b {
    public static final List<String> a = null;

    public f() {
    }

    static {
        a = (List) q0.a.getValue();
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final boolean isFoldScreen() {
        String r0 = Build.MODEL;
        Logger.d(r0);
        List<String> r1 = a;
        if (r1 != null) goto L5;
    L6:
        Context r2 = s1.getContext();
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L14;
        if (r2 == null) goto L14;
        if (r2.getPackageManager() == null) goto L14;
        if (r2.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        r3 = false;
        goto L15
    L5:
        if (r1.contains(r0) == false) goto L6;
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class c(ClassLoader r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r3.loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.android.util.HwNotchSizeUtil");
    L12:
        throw th;
    L34:
        Class<?> r5 = r3.loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.android.util.HwNotchSizeUtil");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("com.huawei.android.util.HwNotchSizeUtil");
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final int a(Configuration r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        Logger.d(f.class.getSimpleName(), "screenHeightDp:" + r5.screenHeightDp + " screenWidthDp:" + r5.screenWidthDp);
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        float r0 = (r5.screenHeightDp * 1.0f) / r5.screenWidthDp;
        ALogger.d("ttlive_ratio", "huawei height " + r5.screenHeightDp + " width: " + r5.screenWidthDp);
        if (r0 >= 0.75f) goto L11;
        return 1;
    L11:
        if (r0 > 1.5f) goto L16;
        return 0;
    L16:
        return 1;
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r5) {
        Class r6 = c(r5.getClassLoader());     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9 Throwable -> L11
        return ((Boolean) r6.getMethod("hasNotchInScreen", new Class[0]).invoke(r6, new Object[0])).booleanValue();
    L7:
        Logger.d("Huawei", "hasNotchInScreen NoSuchMethodException");     // Catch: Throwable -> L11
        return false;
    L9:
        Logger.d("Huawei", "hasNotchInScreen ClassNotFoundException");     // Catch: Throwable -> L11
    L5:
        Logger.d("Huawei", "hasNotchInScreen Exception");     // Catch: Throwable -> L11
        return false;
    L10:
        return false;
    }
}
