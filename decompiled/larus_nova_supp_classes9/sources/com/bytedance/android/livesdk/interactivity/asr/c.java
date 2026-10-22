package com.bytedance.android.livesdk.interactivity.asr;

import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.config.fw;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.bytedance.speech.speechengine.SpeechEngineLoader;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static boolean a;
    public static boolean b;
    public static Function0<Unit> c;

    public static final class a implements SpeechEngineLoader.PluginAdapter {
        public final /* synthetic */ IHostPlugin a;

        public a(IHostPlugin r1) {
            this.a = r1;
        }

        @JvmStatic
        public static void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
            com.bytedance.librarian.a.c(r4);
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
        }

        public final boolean loadFromHost(String r5) {
            if (r5 != null) goto L10;
            return true;
        L10:
            a(r5);     // Catch: Throwable -> L7
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load " + r5 + " from host success");     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("load " + r5 + " from host failed", th);
            return false;
        }

        public final boolean loadFromPlugin(String r7) {
            if (r7 != null) goto L5;
            return true;
        L5:
            Pair r0 = this.a.loadLibraryV2(4, jc1.a.b(), PluginType.AsrSo.getPackageName(), r7, null);
            if (r0 != null) goto L8;
            Boolean r8 = null;
        L14:
            return Intrinsics.areEqual(r8, Boolean.TRUE);
        L8:
            if (((Boolean) r0.first).booleanValue() == false) goto L10;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load " + r7 + " from plugin success");
        L11:
            r8 = (Boolean) r0.first;
            goto L14
        L10:
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("load " + r7 + " from plugin failed. msg=" + ((String) r0.second));
            goto L11
        }
    }

    public static void b() {
        if (a == true) goto L11;
        IHostContext r2 = TTLiveSDK.hostService().appContext();     // Catch: Throwable -> L6
        String r5 = String.valueOf(r2.appId());     // Catch: Throwable -> L6
        String r4 = r2.getServerDeviceId();     // Catch: Throwable -> L6
        String r11 = r2.getVersionName();     // Catch: Throwable -> L6
        String r13 = r2.getVersionCode();     // Catch: Throwable -> L6
        String r14 = r2.getChannel();     // Catch: Throwable -> L6
        SpeechEngineGenerator.initMonitor(r2.context(), r4, r5, r11, r13, "https://mon.zijieapi.com/monitor/appmonitor/v2/settings", "https://mon.zijieapi.com/monitor/collect/", r14);     // Catch: Throwable -> L6
        a = true;     // Catch: Throwable -> L6
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("init SpeechEngineMonitor. versionName=" + r11 + " versionCode=" + r13 + " channel=" + r14);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("init speech engine monitor failed", th);
        SafetyGuard.a("init speech engine monitor failed", th, null);
        return;
    }

    public static void c() {
        SpeechEngineLoader r0 = SpeechEngineLoader.getInstance();
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load plugin. state=" + r0.state);
        IHostPlugin r1 = k.f(IHostPlugin.class);
        if (r1 != null) goto L5;
        return;
    L5:
        long r2 = SystemClock.elapsedRealtime();
        boolean r4 = r1.load(PluginType.AsrSo.getPackageName());
        long r5 = SystemClock.elapsedRealtime() - r2;
        if (r4 == true) goto L10;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("load plugin failed. cost " + r5 + " ms");
        w52.a.d(-1, "load plugin failed", r5);
        return;
    L10:
        if (((Boolean) fw.a.getValue()).booleanValue() == true) goto L12;
    L18:
        r0.setAdapter(new a(r1));
        SpeechEngineLoader.State r3 = r0.load();
        long r6 = SystemClock.elapsedRealtime() - r2;
        if (r3 != SpeechEngineLoader.State.PLUGIN_LOADED) goto L21;
        boolean r7 = true;
    L22:
        b = r7;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load plugin done. cost=" + r6 + " state=" + r3 + " loaded=" + b);
        if (b == false) goto L27;
        Function0<Unit> r8 = c;
        if (r8 == null) goto L27;
        Unit r9 = (Unit) r8.invoke();
    L27:
        if (r3 == null) goto L44;
        int r10 = com.bytedance.android.livesdk.interactivity.asr.a.a[r3.ordinal()];
        if (r10 != 1) goto L32;
        w52.a.d(-3, "load so failed", r6);
        return;
    L32:
        if (r10 != 2) goto L34;
        w52.a.d(-2, "plugin not exists", r6);
        return;
    L34:
        if (r10 != 3) goto L45;
        w52.a.d(0, "plugin loaded", r6);
        return;
    L45:
        return;
    L44:
        return;
    L21:
        r7 = false;
        goto L22
    L12:
        if (jc1.a.c() == true) goto L18;
        a(c.class.getClassLoader());     // Catch: Throwable -> L15
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load SpeechPluginBridge success");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("load SpeechPluginBridge failed", th);
        w52.a.d(-4, "load SpeechPluginBridge failed", SystemClock.elapsedRealtime() - r2);
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static void a(ClassLoader r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        r3.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
    L12:
        throw th;
    L34:
        r3.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
