package com.bytedance.android.livesdk.chatroom.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e1 {
    public static volatile boolean a;
    public static volatile boolean b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.samsung.android.feature.SemFloatingFeature");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.samsung.android.feature.SemFloatingFeature");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.samsung.android.feature.SemFloatingFeature");
    }

    @JvmStatic
    public static final boolean b() {
        if (b == true) goto L5;
        boolean r2 = false;
        if (Intrinsics.areEqual(Build.BRAND, "samsung") == true) goto L20;
    L18:
        a = r2;
        b = true;
        return a;
    L20:
        Class r3 = a();     // Catch: Exception -> L11
        Object r4 = r3.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        String r0 = (String) r3.getDeclaredMethod("getString", new Class[]{String.class}).invoke(r4, new Object[]{"SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_MULTI_FOLD"});     // Catch: Exception -> L11
    L13:
        if (r0 != null) goto L15;
    L16:
        r0 = "unknown";
    L17:
        r2 = Intrinsics.areEqual(r0, "TRUE");
        goto L18
    L15:
        if (TextUtils.isEmpty(r0) == false) goto L17;
    L11:
        e = move-exception;
        e.printStackTrace();
        r0 = "";
        goto L13
    L5:
        return a;
    }

    @JvmStatic
    public static final boolean c() {
        if (Intrinsics.areEqual(Build.BRAND, "samsung") == false) goto L22;
        Resources r0 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r0 == null) goto L7;
        Configuration r1 = r0.getConfiguration();
    L8:
        int r3 = -1;
        if (r1 != null) goto L21;
    L18:
        if (r3 != 0) goto L23;
        return true;
    L23:
        return false;
    L21:
        Field r4 = r1.getClass().getDeclaredField("semDisplayDeviceType");     // Catch: Exception -> L16
        r4.setAccessible(true);     // Catch: Exception -> L16
        Object r2 = r4.get(r1);     // Catch: Exception -> L16
        if (r2 == null) goto L15;
        r3 = ((Integer) r2).intValue();     // Catch: Exception -> L16
        goto L18
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L7:
        r1 = null;
        goto L8
    L22:
        return false;
    }

    static {
    }
}
