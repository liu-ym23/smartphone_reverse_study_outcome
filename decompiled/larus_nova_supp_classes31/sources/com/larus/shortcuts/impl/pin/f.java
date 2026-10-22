package com.larus.shortcuts.impl.pin;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final String[] a = null;

    public static final class a {
        public final String a;
        public final String b;

        public final String a() {
            String r0 = this.a;
            if (Intrinsics.areEqual(r0, "miui") == false) goto L15;
            String[] r1 = f.a;
            String r2 = this.b;
            Matcher r3 = PatternProtector.compile("V\\d+(.\\d+)*").matcher(r2);     // Catch: Exception -> L29
            if (r3.find() == false) goto L9;
            String r4 = r3.group(0);     // Catch: Exception -> L29
        L11:
            if (TextUtils.isEmpty(r4) == false) goto L35;
            return "";
        L35:
            return r4.substring(1);
        L9:
            r4 = "";
            goto L11
        L15:
            if (Intrinsics.areEqual(r0, "emui") == false) goto L36;
            String[] r5 = f.a;
            String r6 = this.b;
            Matcher r7 = PatternProtector.compile("EmotionUI_\\d+(.\\d+)*").matcher(r6);     // Catch: Exception -> L30
            if (r7.find() == false) goto L21;
            String r8 = r7.group(0);     // Catch: Exception -> L30
        L23:
            if (TextUtils.isEmpty(r8) == false) goto L25;
            return "";
        L25:
            if (r8.length() > 10) goto L28;
            return "";
        L28:
            return r8.substring(10);
        L21:
            r8 = "";
            goto L23
        L36:
            return "";
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "romType");
            Intrinsics.checkNotNullParameter(r3, "romInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public f() {
    }

    static {
        a = new String[]{"samsung", "nexus", "pixel"};
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("miui.os.Build");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static boolean b() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        Intrinsics.checkNotNull(r0);
        if (StringsKt.contains$default(r0.toLowerCase(Locale.US), "oppo", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static boolean c() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == true) goto L7;
        if (StringsKt.contains$default(r0.toLowerCase(Locale.US), "flyme", false, 2, null) == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(Build.USER.toLowerCase(Locale.US), "flyme") == true) goto L10;
        return false;
    }

    public static boolean d() {
        String r0 = DeviceUtils.getSystemProperty("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r0.toLowerCase(Locale.US), "funtouch", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
