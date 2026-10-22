package com.larus.camera.impl.utils;

import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.m0;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new z());
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

    public static boolean b(FragmentActivity r6) {
        Class r1 = a();     // Catch: Exception -> L13
        Object r2 = r1.getMethod("get", new Class[]{String.class}).invoke(r1, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L13
        String r3 = (String) r2;     // Catch: Exception -> L13
        if (Intrinsics.areEqual("1", r3) == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(TriggerSendLoading.NO_LOADING, r3) == false) goto L9;
        return true;
    L9:
        Resources r7 = r6.getResources();     // Catch: Exception -> L13
        int r4 = r7.getIdentifier("config_showNavigationBar", "bool", "android");     // Catch: Exception -> L13
        if (r4 <= 0) goto L16;
        return r7.getBoolean(r4);
    L16:
        return false;
    L17:
        return false;
    }

    public static boolean c(FragmentActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        if (Build.VERSION.SDK_INT < 23) goto L16;
        WindowInsets r4 = r3.getRootWindowInsets();
        if (r4 != null) goto L9;
        return b(r2);
    L9:
        if (b(r2) == true) goto L11;
    L13:
        return false;
    L11:
        if (m0.d(r4) == false) goto L13;
        return true;
    L16:
        return b(r2);
    }
}
