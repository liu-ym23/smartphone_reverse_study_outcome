package com.bytedance.android.annie.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x {
    static {
    }

    public static long b() {
        Long r1 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        Object r11 = o.b(a(), "getServerTime", new Object[0]);     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L11:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L15;
        int r14 = x8.a.a;
        x8.a.b("TimeUtil", "getServerTime error: " + r13, false);
    L15:
        if ((r11 instanceof Long) == false) goto L17;
        r1 = (Long) r11;
    L17:
        if (r1 != null) goto L25;
        return 0;
    L25:
        return r1.longValue();
    L6:
        Throwable th2 = th;
    L10:
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th2));
    L8:
        th = move-exception;
        th2 = th;
        r11 = null;
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("ek7.b");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckydog.api.LuckyDogSDK");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckydog.api.LuckyDogSDK");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("ek7.b");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckydog.api.LuckyDogSDK");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckydog.api.LuckyDogSDK");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.luckydog.api.LuckyDogSDK");
    }
}
