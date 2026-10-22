package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.LinkminkToolsCommonResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import w20.fa;
import w20.g2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "linkminkToolsCommon")
public final class b0 extends g2<fa, LinkminkToolsCommonResultModel> {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.android.livesdk.debugtools.floatwindow.DebugToolInstance");
        }

        public static void b(Context r5, String r6) {
            Class r0 = a();     // Catch: Throwable -> L12
            Object r2 = null;
            Object r1 = r0.getDeclaredField("INSTANCE").get(null);     // Catch: Throwable -> L12
            Iterator r3 = ArraysKt.asList(r0.getDeclaredMethods()).iterator();     // Catch: Throwable -> L12
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r4 = r3.next();     // Catch: Throwable -> L12
            if (Intrinsics.areEqual(((Method) r4).getName(), r6) == false) goto L4;
            r2 = r4;
        L8:
            Method r7 = (Method) r2;     // Catch: Throwable -> L12
            if (r7 == null) goto L20;
            r7.invoke(r1, new Object[]{r5});     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L12:
            th = move-exception;
            ALogger.d("DebugToolInstance", r6 + " error: " + th);
        }
    }

    static {
        a = new a();
    }

    public b0() {
    }

    public final void invoke(Object r5, CallContext r6) {
        fa r7 = (fa) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        fa.a r8 = r7.a();
        if (r8 == null) goto L5;
        Boolean r9 = r8.a();
    L6:
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r1) == false) goto L13;
        a r10 = a;
        Application r2 = jc1.a.b();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        a.b(r2, "init");
        Context r3 = com.bytedance.android.live.core.utils.a.d();
        if (r3 != null) goto L12;
        r3 = r6.getContext();
    L12:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        a.b(r3, "show");
        com.bytedance.android.livesdk.sharedpref.e r11 = b6.H;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r1);
        return;
    L13:
        a r12 = a;
        Context r13 = r6.getContext();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        a.b(r13, "hide");
        com.bytedance.android.livesdk.sharedpref.e r14 = b6.H;
        Boolean r15 = Boolean.FALSE;
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r15);
        return;
    L5:
        r9 = null;
        goto L6
    }
}
