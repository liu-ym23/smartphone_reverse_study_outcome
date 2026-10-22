package com.obric.assistant.common.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
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

    public static boolean b(int r9, int r10, int r11, boolean r12) {
        FLogger r1 = FLogger.a;
        r1.i("OSPerformanceschedHelper", "internalStartPerformanceSchedMode pid: " + r9 + ", tid: " + r10 + ", timeout: " + r11 + ", isForeground: " + r12);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Class r3 = a("android.app.CollaborationManager");     // Catch: Throwable -> L12
        Class<?> r4 = a("android.app.PerformanceSchedModeConfig");     // Catch: Throwable -> L12
        Object r6 = r4.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L12
        r4.getField("enable").setBoolean(r6, true);     // Catch: Throwable -> L12
        r4.getField("pid").setInt(r6, r9);     // Catch: Throwable -> L12
        r4.getField("tid").setInt(r6, r10);     // Catch: Throwable -> L12
        r4.getField("timeout").setInt(r6, r11);     // Catch: Throwable -> L12
        r4.getField("cpu").setInt(r6, 1);     // Catch: Throwable -> L12
        r4.getField("gpu").setInt(r6, 1);     // Catch: Throwable -> L12
        if (r12 == false) goto L6;
        String r13 = "TYPE_TOP_APP";
    L7:
        Integer r14 = null;
        r4.getField("type").setInt(r6, r4.getField(r13).getInt(null));     // Catch: Throwable -> L12
        Object r15 = r3.getMethod("startPerformanceSchedMode", new Class[]{r4}).invoke(null, new Object[]{r6});     // Catch: Throwable -> L12
        if ((r15 instanceof Integer) == false) goto L10;
        r14 = (Integer) r15;     // Catch: Throwable -> L12
    L10:
        r1.i("OSPerformanceschedHelper", "internalStartPerformanceSchedMode invokeResult: " + r14);     // Catch: Throwable -> L12
        Object r16 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L19;
        FLogger.a.w("OSPerformanceschedHelper", "internalStartPerformanceSchedMode reflect failed", r17);
        r16 = Boolean.FALSE;
    L19:
        return ((Boolean) r16).booleanValue();
    L6:
        r13 = "TYPE_NON_FOREGROUND";
    L12:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
