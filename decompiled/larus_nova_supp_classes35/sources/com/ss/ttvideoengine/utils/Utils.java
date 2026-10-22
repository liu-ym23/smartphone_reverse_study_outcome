package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class Utils {
    private static Object sGson;
    private static boolean sGsonNotFound;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private Utils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    public static String toJson(Object r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if (sGsonNotFound == false) goto L9;
        return null;
    L9:
        if (sGson == null) goto L23;
    L13:
        Object r1 = sGson;
        if (r1 != null) goto L21;
    L19:
        return null;
    L21:
        Object r8 = r1.getClass().getDeclaredMethod("toJson", new Class[]{Object.class}).invoke(sGson, new Object[]{r7});     // Catch: Throwable -> L20
        if ((r8 instanceof String) == false) goto L19;
        return String.valueOf(r8);
    L23:
        sGson = INVOKESTATIC_com_ss_ttvideoengine_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.google.gson.Gson").newInstance();     // Catch: Throwable -> L12
        sGsonNotFound = false;     // Catch: Throwable -> L12
    L12:
        sGsonNotFound = true;
        goto L13
    }

    public static String toString(Object r2) {
        String r0 = toJson(r2);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return String.valueOf(r2);
    }
}
