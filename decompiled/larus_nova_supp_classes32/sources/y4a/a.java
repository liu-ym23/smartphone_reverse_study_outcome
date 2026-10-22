package y4a;

import android.os.Build;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.setting.AnimaXSettingValue;
import com.lynx.animax.util.AnimaXLog;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final String a = null;
    public static int b;
    public static final boolean c = false;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static boolean i;

    static {
        String r0 = Build.MODEL.toLowerCase();
        a = r0;
        b = -1;
        c = Arrays.asList(new String[]{"m6 note", "m721c"}).contains(r0);
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
    }

    public static boolean c() {
        if (d == true) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        boolean r1 = Process.is64Bit();     // Catch: Exception -> L16
    L13:
        e = !r1;
        d = true;
    L8:
        Class r2 = a("dalvik.system.VMRuntime");     // Catch: Exception -> L16
        Boolean r3 = (Boolean) r2.getDeclaredMethod("is64Bit", new Class[0]).invoke(r2.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L16
        if (r3 == null) goto L12;
        r1 = r3.booleanValue();     // Catch: Exception -> L16
        goto L13
    L19:
        r1 = true;
    L12:
        r1 = true;
    L15:
        return e;
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

    public static boolean e(String r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L10;
        if ("1".equals(r1) == false) goto L8;
    L9:
        return true;
    L8:
        if ("true".equalsIgnoreCase(r1) == false) goto L10;
        goto L9
    }

    public static String b(String r1, BaseAbility r2) {
        w4a.c r3 = (w4a.c) r2.c.a(w4a.c.class);
        if (r3 == null) goto L7;
        AnimaXSettingValue r4 = r3.a(r1);
        if (r4 == null) goto L7;
        return r4.b();
    L7:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static boolean d(String r2, BaseAbility r3) {
        w4a.c r4 = (w4a.c) r3.c.a(w4a.c.class);
        if (r4 != null) goto L27;
        return false;
    L27:
        AnimaXSettingValue r5 = r4.a(r2);     // Catch: Throwable -> L24
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.d() == false) goto L13;
        return e(r5.b());
    L13:
        if (r5.c() == false) goto L26;
        Collection<String> r6 = r5.a();     // Catch: Throwable -> L24
        if (r6.isEmpty() == true) goto L28;
        String r7 = a;     // Catch: Throwable -> L24
        if (r7 != null) goto L19;
        return false;
    L19:
        if (r7.isEmpty() == false) goto L21;
        return false;
    L21:
        if (r6.contains(r7) == false) goto L31;
        return true;
    L31:
        return false;
    L28:
        return false;
    L26:
        return false;
    L24:
        th = move-exception;
        AnimaXLog.a("DeviceUtil", "isInSettingList fail, message" + th.getMessage());
        goto L26
    }
}
