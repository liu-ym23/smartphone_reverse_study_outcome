package com.larus.voicecall.impl.notification;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
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

    public static boolean d() {
        String r0 = Build.MANUFACTURER;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r0.toUpperCase(Locale.getDefault()), "HONOR", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e() {
        String r0 = Build.MANUFACTURER;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.equals(r0, "OnePlus", true) == false) goto L7;
        return true;
    }

    public static int b() {
        if (d() == true) goto L5;
        return 0;
    L5:
        String r0 = f("ro.build.version.magic");
        boolean r3 = true;
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r0 = f("ro.build.version.magicui");
    L12:
        if (r0.length() == 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        return 0;
    L17:
        MatchResult r1 = Regex.find$default(new Regex("(\\d+)"), r0, 0, 2, null);
        if (r1 != null) goto L20;
        return 0;
    L20:
        Integer r4 = StringsKt.toIntOrNull(r1.getValue());
        if (r4 != null) goto L23;
        return 0;
    L23:
        return r4.intValue();
    L8:
        r2 = false;
        goto L9
    }

    public static boolean c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (d() == false) goto L8;
        if (b() < 8) goto L8;
        return true;
    L8:
        if ((r3.getResources().getConfiguration().uiMode & 48) == 32) goto L12;
        return false;
    L12:
        return true;
    }

    public static String f(String r8) {
        Method r1 = a().getMethod("get", new Class[]{String.class, String.class});     // Catch: Throwable -> L10
        Object[] r2 = {r8, NameKeys.UnloadStrategy_No_Strategy};     // Catch: Throwable -> L10
        String r9 = null;
        Object r3 = r1.invoke(null, r2);     // Catch: Throwable -> L10
        if ((r3 instanceof String) == false) goto L6;
        r9 = (String) r3;     // Catch: Throwable -> L10
    L6:
        if (r9 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return r9;
    L14:
        return NameKeys.UnloadStrategy_No_Strategy;
    }
}
