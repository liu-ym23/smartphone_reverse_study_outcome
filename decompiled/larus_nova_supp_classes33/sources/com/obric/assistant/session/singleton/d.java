package com.obric.assistant.session.singleton;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final d a = null;
    public static final String b = null;
    public static Object c;
    public static Method d;
    public static Method e;

    public d() {
    }

    static {
        a = new d();
        b = d.class.getSimpleName();
    }

    public static ComponentName b() {
        ComponentName r1 = null;
        Method r2 = e;     // Catch: Throwable -> L23
        if (r2 == null) goto L30;
    L15:
        if (r2 == null) goto L17;
        Object r3 = r2.invoke(d(), new Object[0]);     // Catch: Throwable -> L23
    L18:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.content.ComponentName");     // Catch: Throwable -> L23
        ComponentName r4 = (ComponentName) r3;     // Catch: Throwable -> L23
        FLogger.a.i(b, "getActiveServiceComponentName: " + r4);     // Catch: Throwable -> L21
        return r4;
    L21:
        th = th;
        r1 = r4;
    L24:
        FLogger.a.e(b, "getActiveServiceComponentName exception", th);
        return r1;
    L17:
        r3 = null;
        goto L18
    L30:
        Class r5 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        r2 = r5.getMethod("getActiveServiceComponentName", new Class[0]);     // Catch: Throwable -> L11
    L14:
        e = r2;     // Catch: Throwable -> L23
        goto L15
    L13:
        r2 = null;
    L11:
        th = move-exception;
        FLogger.a.e(b, "get mGetActiveServiceComponentMethod exception", th);     // Catch: Throwable -> L23
    L23:
        th = th;
        goto L24
    }

    public static Object d() {
        Object r0 = c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = null;
        Class r2 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L13
        if (r2 == null) goto L9;
        Constructor r3 = r2.getDeclaredConstructor(new Class[]{Context.class});     // Catch: Throwable -> L13
    L10:
        if (r3 == null) goto L15;
        r1 = r3.newInstance(new Object[]{AppHost.a.getApplication()});     // Catch: Throwable -> L13
    L15:
        c = r1;
        return r1;
    L9:
        r3 = null;
    L13:
        th = move-exception;
        FLogger.a.e(b, "get mAssistUtils exception", th);
        goto L15
    }

    public static Method e() {
        Method r0 = d;
        if (r0 == null) goto L14;
        return r0;
    L14:
        Class r1 = c("com.android.internal.app.AssistUtils");     // Catch: Throwable -> L9
        if (r1 == null) goto L11;
        Method r2 = r1.getMethod("showSessionForActiveService", new Class[]{Bundle.class, Integer.TYPE, c("com.android.internal.app.IVoiceInteractionSessionShowCallback"), IBinder.class});     // Catch: Throwable -> L9
    L12:
        d = r2;
        return r2;
    L11:
        r2 = null;
    L9:
        th = move-exception;
        FLogger.a.e(b, "get mShowSessionMethod exception", th);
        goto L11
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

    public static Class c(String r4) {
        return a(r4);
    L4:
        th = move-exception;
        FLogger.a.e(b, "getClass failed for ".concat(r4), th);
        return null;
    }
}
