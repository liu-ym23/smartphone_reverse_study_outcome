package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import android.util.AndroidRuntimeException;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.base.log.LynxLog;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5686a;

    public static void a(sg.a r11, rc.f r12) {
        Intrinsics.checkNotNullParameter(r11, "lynxConfig");
        Intrinsics.checkNotNullParameter(r12, "token");
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        LogLevel r10 = LogLevel.f5954b;
        com.bytedance.ies.bullet.service.base.b.d("LynxKitEnv start init", r10, "XLynxKit");
        boolean r13 = true;
        if (io.reactivex.internal.observers.h.g == true) goto L6;
        io.reactivex.internal.observers.h.g = true;
        mn.h.i().execute(new com.bytedance.android.anniex.worker.a(13));
        mn.h.i().execute(new com.bytedance.android.anniex.worker.a(14));
        mn.h.i().execute(new com.lynx.tasm.b());
    L6:
        b r14 = (b) r11.f21902a;
        j r15 = j.f5684a;
        we.a r16 = r14.d;
        if (r16 == null) goto L12;
        LynxEnv r17 = LynxEnv.inst();
        if (Fresco.f7728c == true) goto L11;
        Fresco.a((Application) r16.f22857a);
    L11:
        r17.setBackgroundImageLoader(new com.lynx.tasm.ui.image.j());
    L12:
        com.bytedance.ies.bullet.service.base.b.d("LynxKitEnv behaviors size == " + ((b) r11.f21902a).f5669b.size(), r10, "XLynxKit");
        sj.k r18 = new sj.k(r11, false);
        LynxEnv.inst().setResProvider(new com.bytedance.kit.nglynx.resource.a(r12));
        LynxEnv.inst().setCheckPropsSetter(true);
        tc.c r19 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r20 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r20 == null) goto L15;
        com.bytedance.ies.bullet.service.base.d r21 = (com.bytedance.ies.bullet.service.base.d) r20.f6163b.getValue();
    L15:
        LynxEnv.inst().init(i.a(), r15, new com.bytedance.ies.bullet.lynx.resource.e(r12), r18, null);
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L25;
        Intrinsics.checkNotNullParameter(r12, "serviceToken");
        com.bytedance.ies.bullet.service.base.i r110 = (com.bytedance.ies.bullet.service.base.i) r12.a(com.bytedance.ies.bullet.service.base.i.class);
        Lazy r111 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;     // Catch: Throwable -> L20
        com.bytedance.sdk.xbridge.cn.utils.f.g();     // Catch: Throwable -> L20
    L21:
        com.bytedance.ies.bullet.settings.b r112 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r112 == null) goto L24;
        com.bytedance.ies.bullet.service.base.d r113 = (com.bytedance.ies.bullet.service.base.d) r112.f6163b.getValue();
    L24:
        b(true);
    L20:
        new AndroidRuntimeException("Just warning log, No ALog dependency found").printStackTrace();
    L25:
        Iterator r114 = ((b) r11.f21902a).f5670c.entrySet().iterator();
    L27:
        if (r114.hasNext() == false) goto L29;
        Map.Entry r22 = (Map.Entry) r114.next();
        LynxEnv r23 = LynxEnv.inst();
        String r24 = (String) r22.getKey();
        ((lc.b) r22.getValue()).getClass();
        r23.registerModule(r24, LynxBridgeModule.class, ((lc.b) r22.getValue()).f19598a);
        goto L27
    L29:
        Function1 r115 = ((b) r11.f21902a).e;
        LynxEnv r25 = LynxEnv.inst();
        ((LynxConfig$Builder$additionInit$1) r115).getClass();
        Intrinsics.checkNotNullParameter(r25, "$this$null");
        Unit r116 = Unit.INSTANCE;
        LynxEventReporter.addObserver(new com.bytedance.android.monitorV2.lynx.e());
        if (i.f5683b == true) goto L32;
        LynxEnv.inst().enableRedBox(false);
        LynxEnv.inst().enableLynxDebug(false);
    L45:
        ConcurrentHashMap r117 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r118 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r118 == null) goto L50;
        xc.d r119 = (xc.d) r118.a(xc.d.class);
        if (r119 == null) goto L50;
        r13 = r119.n0();
    L50:
        if (r13 == false) goto L58;
        h.f.b(k.f5685a, h.f.g);
        return;
    L58:
        return;
    L32:
        ArrayList r120 = ((b) r11.f21902a).f5668a;
        if (r120.size() > 0) goto L36;
        r120 = null;
    L36:
        if (r120 == null) goto L45;
        ArrayList r121 = c.f5671a;
        LynxEnv.inst().enableLynxDebug(true);
        LynxEnv.inst().enableDevtool(true);
        LynxDevtoolGlobalHelper.getInstance().registerCardListener(c.f5672b);
        Iterator r122 = r120.iterator();
    L39:
        if (r122.hasNext() == false) goto L45;
        if (r122.next() != null) goto L44;
        ArrayList r123 = c.f5671a;
        Intrinsics.checkNotNullParameter(null, "processor");
        c.f5671a.add(null);
        goto L39
    L44:
        throw new ClassCastException();
    }

    public static void b(boolean r5) {
        monitor-enter(l.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f5686a == true) goto L9;
        f5686a = c();     // Catch: Throwable -> L7
    L9:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(l.class);
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("LynxKitEnv tryInitVmSdk: fromInit=" + r5 + ", isVmSdkReady=" + f5686a, LogLevel.f5954b, "XLynxKit");
    }

    public static boolean c() {
        if (StringsKt.P(i.a().getApplicationContext().getPackageName(), "com.ss.android.ugc.aweme") == false) goto L5;
        wj.a r5 = ik.a.f17574a;
        a r10 = new a();
        r5.getClass();
        r5.f22868a.put(a.class.getName(), r10);
    L5:
        wj.a r11 = ik.a.f17574a;
        r11.getClass();
        Object r12 = r11.f22868a.get(a.class.getName());
        if (r12 == null) goto L8;
        a r13 = (a) r12;
    L9:
        if (r13 != null) goto L11;
        String r14 = "";
    L12:
        String r15 = ak.a.a();
        boolean r16 = d(r14, "v8_libfull.cr");
        boolean r17 = d(r15, "napi_v8");
        System.loadLibrary("lynx_v8_bridge");     // Catch: Throwable -> L15
        boolean r18 = true;
    L17:
        if (r18 == false) goto L19;
        String r19 = " Success";
    L20:
        LynxLog.b(2, "LynxKitEnv", "vmsdk load liblynx_v8_bridge.so".concat(r19));
        if (r18 == true) goto L23;
        r18 = d(r15, "lynx_v8_bridge");
    L23:
        if (r16 == false) goto L30;
        if (r17 == false) goto L31;
        if (r18 == true) goto L27;
        return false;
    L27:
        return true;
    L31:
        return false;
    L30:
        return false;
    L19:
        r19 = " Failed";
    L15:
        th = move-exception;
        LynxLog.b(4, "LynxKitEnv", "vmsdk load liblynx_v8_bridge.so in host error:" + th.getMessage());
        r18 = false;
        goto L17
    L11:
        r14 = "com.ss.android.ugc.aweme.v8";
        goto L12
    L8:
        r13 = null;
        goto L9
    }

    public static boolean d(String r10, String r11) {
        String r5 = ak.a.b(r10, r11);     // Catch: Throwable -> L9
        if (r5 != null) goto L6;
    L11:
        LynxLog.b(4, "LynxKitEnv", r10 + " plugin's lib" + r11 + ".so not found");     // Catch: Throwable -> L9
    L14:
        boolean r12 = false;
    L15:
        StringBuilder r13 = new StringBuilder("vmsdk loadLibrary: lib");
        r13.append(r11);
        r13.append(".so, PluginName: ");
        r13.append(r10);
        if (r12 == false) goto L18;
        String r14 = " Success";
    L19:
        com.lynx.tasm.behavior.ui.utils.e.i(r13, r14, 2, "LynxKitEnv");
        return r12;
    L18:
        r14 = " Failed";
        goto L19
    L6:
        if (r5.length() == 0) goto L11;
        System.load(r5);     // Catch: Throwable -> L9
        r12 = true;
    L9:
        th = move-exception;
        StringBuilder r15 = com.lynx.tasm.base.a.e("vmsdk loadLibrary: lib", r11, ".so, PluginName: ", r10, " error:");
        r15.append(th.getMessage());
        LynxLog.b(4, "LynxKitEnv", r15.toString());
        goto L14
    }
}
