package pta;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.data.ISmModel;
import i84.u;
import ita.j;
import ita.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static final a a = null;

    public static class a extends e<Boolean> {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class c() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.huawei.system.BuildEx");
        }

        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r4) {
            Class r5 = c();     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r5.getMethod("getOsBrand", new Class[0]).invoke(r5, new Object[0])));
        L5:
            return Boolean.FALSE;
        }
    }

    static {
        a = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static boolean f() {
        Class r2 = a();     // Catch: Exception -> L7
        String r3 = (String) r2.getDeclaredMethod("get", new Class[]{String.class}).invoke(r2, new Object[]{"ro.build.version.emui"});     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r3) == true) goto L9;
        j.b("Honor# oldHonor device, version is" + r3, null);     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        j.c("Honor# " + e.getMessage(), e);
        goto L9
    }

    public static boolean g() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase().contains("oppo");
    }

    public static boolean h() {
        return a.b(new Object[0]).booleanValue();
    }

    public static boolean i() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r1.toLowerCase().startsWith("honor") == false) goto L11;
    L12:
        return true;
    L11:
        if ("HONOR".equalsIgnoreCase(r1) == true) goto L12;
        return false;
    L5:
        if (r0.toLowerCase().startsWith("honor") == true) goto L12;
        goto L6
    }

    public static boolean j() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.toLowerCase().startsWith("huawei") == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.toLowerCase().startsWith("huawei") == true) goto L10;
        goto L6
    }

    public static String c() {
        String r0 = k.d();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("emotionui") == true) goto L9;
        if (r0.toLowerCase().contains("magicui") == true) goto L9;
        return "";
    L9:
        return r0 + "_" + Build.DISPLAY;
    }

    public static String d() {
    L60:
        th = move-exception;
        th.printStackTrace();
    L63:
        return Build.DISPLAY;
    L4:
        String r2 = "";
        if (k.j() == false) goto L11;
        if (k.j() == true) goto L9;
        return "";
    L9:
        return "miui_" + e("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L11:
        if (k.f() == false) goto L19;
        String r0 = Build.DISPLAY;     // Catch: Throwable -> L60
        if (r0 != null) goto L15;
        return "";
    L15:
        if (r0.toLowerCase().contains("flyme") == true) goto L17;
        return "";
    L17:
        return r0;
    L19:
        if (g() == true) goto L21;
        String r1 = c();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r1) == true) goto L27;
        return r1;
    L27:
        boolean r3 = false;
        boolean r5 = !TextUtils.isEmpty((String) u.a("ro.vivo.os.build.display.id"));
    L31:
        if (r5 == true) goto L33;
        String r4 = Build.DISPLAY;     // Catch: Throwable -> L60
        if (StringUtils.isEmpty(r4) == false) goto L37;
    L39:
        boolean r6 = false;
    L40:
        if (r6 == true) goto L42;
        String r7 = Build.MANUFACTURER + Build.BRAND;     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r7) == true) goto L51;
        String r8 = r7.toLowerCase();     // Catch: Throwable -> L60
        if (r8.contains("360") == false) goto L49;
    L50:
        r3 = true;
        goto L51
    L49:
        if (r8.contains("qiku") == true) goto L50;
    L51:
        if (r3 == false) goto L55;
        return e("ro.build.uiversion") + "_" + r4;
    L55:
        if ((true ^ StringUtils.isEmpty(e("ro.letv.release.version"))) == false) goto L58;
        r2 = "eui_" + e("ro.letv.release.version") + "_" + r4;     // Catch: Throwable -> L60
    L58:
        if (TextUtils.isEmpty(r2) == true) goto L63;
        return r2;
    L42:
        return r4 + "_" + e("ro.gn.sv.version");
    L37:
        if (r4.toLowerCase().contains("amigo") == false) goto L39;
        r6 = true;
        goto L40
    L33:
        return u.a("ro.vivo.os.build.display.id") + "_" + u.a("ro.vivo.product.version");
    L30:
        r5 = false;
        goto L31
    L21:
        if (g() == true) goto L23;
        return "";
    L23:
        return "coloros_" + e("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String e(String r7) {
        String r3 = "";
        Process r1 = b(Runtime.getRuntime(), "getprop ".concat(r7));     // Catch: Throwable -> L12
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r1.getInputStream()), ISmModel.VERSION_0400);     // Catch: Throwable -> L12
        r3 = r4.readLine();     // Catch: Throwable -> L10
        r1.destroy();     // Catch: Throwable -> L10
        r4.close();     // Catch: IOException -> L7
    L9:
        return r3;
    L7:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L10:
        th = th;
    L38:
        j.c("Unable to read sysprop ".concat(r7), th);     // Catch: Throwable -> L21
        if (r4 != null) goto L28;
    L20:
        return r3;
    L28:
        r4.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L21:
        th = move-exception;
        if (r4 != null) goto L30;
    L27:
        throw th;
    L30:
        r4.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L12:
        th = th;
        r4 = null;
        goto L38
    }

    public static Process b(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }
}
