package com.bytedance.android.live.browser;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.lynx.AnnieXLiveLynxGlobalConfigService;
import com.bytedance.android.annie.business.web.AnnieXLiveWebGlobalConfigService;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.debug.DebugTatPosition;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.live.browser.jsbridge.asr.AnnieBridgeAsrService;
import com.bytedance.android.live.browser.service.AnnieAbilityProviderImpl;
import com.bytedance.android.live.browser.service.AnnieExternalServiceImpl;
import com.bytedance.android.live.browser.service.AnniePerformanceServiceImpl;
import com.bytedance.android.live.browser.service.h0;
import com.bytedance.android.live.browser.utils.DegradeUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g4;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.config.gw0;
import com.bytedance.android.livesdk.config.n01;
import com.bytedance.android.livesdk.config.sd;
import com.bytedance.android.livesdk.config.v7;
import com.bytedance.android.livesdk.j0;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.xelement.XElementConfigLite;
import com.bytedance.ies.xelement.XElementInitializerLite;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnnieNGInitHelper {
    public static boolean a;
    public static boolean b;
    public static volatile boolean c;
    public static volatile boolean d;

    public static final class a implements c9.c {
        public a() {
        }

        public final String getTagName() {
            return "annie";
        }

        public final void a(String r1) {
            if (r1 == null) goto L5;
            p20.e.b(r1);
            return;
        }

        public final void b(com.bytedance.ies.web.jsbridge2.c0 r3) {
            Intrinsics.checkNotNullParameter(r3, "call");
            String r0 = p20.e.a;
            Intrinsics.checkNotNullParameter(r3, "jsCall");
            if (p20.e.a() == false) goto L7;
            ALogger.i("DebugHybridTools", "lynx-> jsbInfo=" + r3);
            return;
        }

        public final void e(BaseHybridParamVoNew r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (((HybridSchemaParam) r2).b == null) goto L8;
            ((ArrayList) p20.e.b).clear();
            ((ArrayList) p20.e.c).clear();
            p20.e.a = "";
            ALogger.i("DebugHybridTools", "finishRecord");
            return;
        }

        public final void f(String r1) {
            if (r1 == null) goto L5;
            p20.e.b(r1);
            return;
        }

        public final void g(BaseHybridParamVoNew r2) {
            if (r2 == null) goto L10;
            String r3 = ((HybridSchemaParam) r2).b;
            if (r3 == null) goto L11;
            String r0 = p20.e.a;
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
            p20.e.a = r3;
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void c(JSONObject r3, com.bytedance.ies.web.jsbridge2.c0 r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r4, "jsbCall");
            String r1 = p20.e.a;
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r4, "jsCall");
            if (p20.e.a() == false) goto L7;
            ALogger.i("DebugHybridTools", "lynx-> jsbInfo=" + r4 + "，callackinfo " + r3);
            return;
        }

        public final void d(Context r6, AnnieCard r7) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "annieCard");
            String r1 = null;
            if ((r6 instanceof FragmentActivity) == true) goto L5;
            r6 = null;
        L5:
            FragmentActivity r8 = (FragmentActivity) r6;
            CardParamVoNew r0 = r7.getMHybridParamVoNew();
            if (r8 == null) goto L21;
            IHybridBaseService r2 = (IHybridBaseService) jc1.k.f(IHybridBaseService.class);
            if (r2 == null) goto L22;
            if (r0 == null) goto L12;
            String r3 = ((HybridSchemaParam) r0).b;
            if (r3 == null) goto L12;
        L14:
            if (r7.hybridType() != IHybridComponent.HybridType.LYNX) goto L16;
            boolean r9 = true;
        L17:
            if (r0 == null) goto L19;
            r1 = r0.o();
        L19:
            r2.showHybridDebugFragment(r8, r3, r9, r1);
            return;
        L16:
            r9 = false;
        L12:
            r3 = "";
            goto L14
        L22:
            return;
        }
    }

    public AnnieNGInitHelper() {
    }

    public static void e() {
        com.bytedance.android.annie.a.e(f9.b.class, new AnnieExternalServiceImpl(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.service.resource.f.class, new com.bytedance.android.annie.resource.j(), true, 4);
    }

    static {
    }

    public static final void a(d8.b r2, w r3) {
        if (((Boolean) gw0.a.getValue()).booleanValue() == false) goto L5;
        ((Boolean) n01.a.getValue()).booleanValue();
        ConcurrentHashMap r0 = m8.c.a;
    L5:
        r2.a = new b(r3);
        r2.b = new c(r3);
        r2.c = new d(r3);
        r2.f = new e(r3);
        r2.g = new f(r3);
        r2.d = v20.a.a;
        r2.e = new g(r3);
        r2.h = new h();
        XElementInitializerLite.Companion.getClass();
        XElementInitializerLite r4 = (XElementInitializerLite) XElementInitializerLite.access$getInstance$delegate$cp().getValue();
        AnnieNGInitHelper$createLynxConfig$1$8 r5 = AnnieNGInitHelper$createLynxConfig$1$8.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "provider");
        r4.setConfig(new XElementConfigLite(r5, null));
    }

    public static void b(final w r12, final Boolean r13) {
        if (com.bytedance.android.annie.ng.g.g == false) goto L6;
        return;
    L6:
        if (((Boolean) v7.a.getValue()).booleanValue() == false) goto L16;
        BulletLogger.k("=======BulletSdk start:init start with webcast", null, "XInit", 2);
        Application r0 = jc1.a.b();
        if (r0 == null) goto L16;
        com.bytedance.ies.bullet.base.c r5 = new com.bytedance.ies.bullet.base.c(r0, "webcast");
        g16.b r6 = new g16.b();
        boolean r7 = true;
        r6.a = true;
        r6.b = "annie";
        Unit r8 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "config");
        r5.d = r6;
        com.bytedance.ies.bullet.service.sdk.b r9 = new com.bytedance.ies.bullet.service.sdk.b(new t36.b("webcast"));
        r9.a(new j7.a());
        r9.a(new o20.a());
        r9.a(new u36.a("webcast"));
        Intrinsics.checkNotNullParameter(r9, "config");
        r5.f = r9;
        q0 r11 = new q0("Annie");
        r11.d = "88888";
        r5.b(r11);
        LynxConfig.Builder r14 = new LynxConfig.Builder(r5.a);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
    L15:
        com.bytedance.ies.bullet.lynx.init.h.c = r7;
        tx1.b.a.getClass();
        com.bytedance.ies.bullet.lynx.init.h.d = Float.valueOf(tx1.b.a());
        com.bytedance.ies.bullet.lynx.init.h.e = Float.valueOf(tx1.b.a());
        r5.a(u26.c.class, new com.bytedance.ies.bullet.lynx.i(new LynxConfig(r14.a, r14), new com.bytedance.android.annie.business.lynx.e()));
        r5.a(v16.b.class, new AnnieXLiveLynxGlobalConfigService());
        r5.a(e26.b.class, new AnnieXLiveWebGlobalConfigService(r0.getApplicationContext()));
        Annie.registerService$default(b9.b.class, new h7.a(), null, 4, null);
        com.bytedance.android.annie.business.latch.f r1 = new com.bytedance.android.annie.business.latch.f(0);
        Annie.registerService$default(IAnnieBusinessLatchService.class, r1, null, 4, null);
        Annie.registerService$default(com.bytedance.android.annie.business.latch.l.class, r1, null, 4, null);
        r5.a(k16.b.class, new o20.b());
        boolean r2 = BulletSdk.a;
        BulletSdk.d(r5);
        BulletLogger.k("=======BulletSdk end:init start with webcast", null, "XInit", 2);
        goto L16
    L12:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L15;
        r7 = false;
    L16:
        com.bytedance.android.annie.ng.d.a r3 = new com.bytedance.android.annie.ng.d.a(jc1.a.b());
        AnnieNGInitHelper$initAnnieEnv$2 r4 = AnnieNGInitHelper$initAnnieEnv$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L20;
        r4.invoke(com.bytedance.android.annie.ng.e.d);
    L20:
        AnnieNGInitHelper$initAnnieEnv$3 r15 = AnnieNGInitHelper$initAnnieEnv$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L24;
        r15.invoke(com.bytedance.android.annie.ng.e.a);
    L24:
        AnnieNGInitHelper$initAnnieEnv$4 r16 = AnnieNGInitHelper$initAnnieEnv$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r16, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L28;
        r16.invoke(com.bytedance.android.annie.ng.e.c);
    L28:
        Function1<o8.c, Unit> r17 = new AnnieNGInitHelper$initAnnieEnv$5(r13);
        Intrinsics.checkNotNullParameter(r17, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L32;
        r17.invoke(com.bytedance.android.annie.ng.e.b);
    L32:
        Function1<d8.b, Unit> r18 = new AnnieNGInitHelper$initAnnieEnv$6(r12);
        d8.b r19 = e8.c.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r18, "block");
        com.bytedance.android.annie.ng.g.d("annie_lynx", new e8.b(r18));
        gw0 r21 = gw0.a;
        if (((Boolean) r21.getValue()).booleanValue() == false) goto L35;
        i r22 = new i(r12);
        ConcurrentHashMap r23 = m8.c.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.bytedance.android.annie.ng.g.d("annie_monitor_lynx", new m8.b(r22, "host"));
    L35:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.bytedance.android.annie.ng.g.d("annie_pia", new com.bytedance.android.annie.pia.a(r3));
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.bytedance.android.annie.ng.g.d("annie_forest", new t8.a());
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.bytedance.android.annie.ng.g.d("annie_protobuf", new q8.a());
        r3.a();
        com.bytedance.android.annie.ng.a.a r24 = new com.bytedance.android.annie.ng.a.a("webcast");
        AnnieNGInitHelper$initAnnieEnv$8 r25 = AnnieNGInitHelper$initAnnieEnv$8.INSTANCE;
        Intrinsics.checkNotNullParameter(r25, "block");
        r25.invoke(r24.b);
        AnnieNGInitHelper$initAnnieEnv$9 r26 = AnnieNGInitHelper$initAnnieEnv$9.INSTANCE;
        Intrinsics.checkNotNullParameter(r26, "block");
        r26.invoke(r24.c);
        Function1<d8.b, Unit> r27 = new AnnieNGInitHelper$initAnnieEnv$10(r12);
        Intrinsics.checkNotNullParameter(r24, "<this>");
        Intrinsics.checkNotNullParameter(r27, "block");
        com.bytedance.android.annie.ng.g.c(r24.a, "annie_lynx", new e8.a(r27, r24));
        if (((Boolean) r21.getValue()).booleanValue() == false) goto L38;
        i r110 = new i(r12);
        ConcurrentHashMap r111 = m8.c.a;
        Intrinsics.checkNotNullParameter(r24, "<this>");
        com.bytedance.android.annie.ng.g.c(r24.a, "annie_monitor_lynx", new m8.a(r110, r24));
    L38:
        r24.a();
    }

    public static void c(v r4, w r5, u r6) {
        Boolean r0 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r4, "jsBridgeService");
        Intrinsics.checkNotNullParameter(r5, "lynxService");
        Intrinsics.checkNotNullParameter(r6, "h5Service");
        ALogger.i("AnnieNGInitHelper", "initAnnieEnv start");
        if (jc1.k.f(IMiddleWareHostContext.class) != null) goto L5;
        ALogger.e("AnnieNGInitHelper", "initAnnieEnv skip by IMiddleWareHostContext is null");
        return;
    L5:
        b(r5, r0);
        if (b == true) goto L8;
        b = true;
        ALogger.i("AnnieNGInitHelper", "initAnnieEnv, registerService");
        f(r4, r5, r6);
    L9:
        int r7 = n30.b.a;
        com.bytedance.android.annie.xbridge.mix.e r8 = null;
        if (i8.f.c.compareAndSet(false, true) == false) goto L12;
    L14:
        Annie.registerService$default(k9.e.class, new i8.c(), null, 4, null);
        Annie.registerService$default(m9.d.class, new i8.e(), null, 4, null);
        a9.j.a.I0(new i8.d());
    L15:
        int r9 = com.bytedance.android.annie.monitor.web.b.a;
        Annie.registerService$default(n9.b.class, new com.bytedance.android.annie.monitor.web.a(), null, 4, null);
        Intrinsics.checkNotNullParameter(new j(), "monitorContext");
        com.bytedance.android.annie.protobuf.a.a();
        r4.registerState();
        r4.registerMatchShareMethods();
        if (Intrinsics.areEqual(r0, r0) == false) goto L21;
        e();
        if (a == true) goto L21;
        a = true;
        int r11 = com.bytedance.android.annie.service.prefetch.c.a;
        com.bytedance.android.annie.service.prefetch.t r12 = new com.bytedance.android.annie.service.prefetch.t();
        Intrinsics.checkNotNullParameter(r12, "config");
        Annie.getService$default(com.bytedance.android.annie.service.prefetch.p.class, null, 2, null).E(r12);
        Annie.getService$default(ILatchService.class, null, 2, null).initPrefetch();
    L21:
        if (d == true) goto L26;
        IMiddlewareHostApp r13 = jc1.k.f(IMiddlewareHostApp.class);
        if (r13 == null) goto L26;
        r13.registerLiveLifeCycleListener(new l());
        d = true;
    L26:
        r4.registerDataShare();
        com.bytedance.android.annie.param.j.b.a.getClass();
        if (com.bytedance.android.annie.param.i.b != null) goto L30;
        Observable.fromCallable(com.bytedance.android.annie.param.g.a).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.annie.param.h.a, Functions.emptyConsumer());
    L30:
        r4.initTTLiveSdkJsb();
        IMiddleWareHostContext r14 = jc1.k.f(IMiddleWareHostContext.class);
        if (r14 == null) goto L33;
        r14.initHostJsbRegister();
    L33:
        com.bytedance.android.annie.xbridge.mix.e r15 = com.bytedance.android.annie.xbridge.mix.t.a;
        int r16 = com.bytedance.android.live.browser.utils.g.a;
        IH5AssistService r17 = (IH5AssistService) jc1.k.f(IH5AssistService.class);
        if (r17 == null) goto L36;
        r8 = r17.getExternalMethodInjector();
    L36:
        com.bytedance.android.annie.xbridge.mix.t.a = r8;
        return;
    L12:
        if (com.bytedance.ies.bullet.service.base.h.t() == false) goto L14;
    L8:
        ALogger.i("AnnieNGInitHelper", "initAnnieEnv, skip registerService");
        goto L9
    }

    public static boolean d(v r6, final w r7, u r8) {
        Intrinsics.checkNotNullParameter(r6, "jsBridgeService");
        Intrinsics.checkNotNullParameter(r7, "lynxService");
        Intrinsics.checkNotNullParameter(r8, "h5Service");
        com.bytedance.android.annie.xbridge.mix.e r1 = null;
        final boolean r2 = true;
        if (c == true) goto L44;
        ALogger.i("AnnieNGInitHelper", "initAnnieXCardEnv, initAnnieXCardLiveEnv");
        if (jc1.k.f(IMiddleWareHostContext.class) != null) goto L7;
        ALogger.e("AnnieNGInitHelper", "initAnnieXCardLiveEnv skip by IMiddleWareHostContext is null");
        return true ^ ((Boolean) j0.a.getValue()).booleanValue();
    L7:
        com.bytedance.android.annie.ng.d.a r0 = new com.bytedance.android.annie.ng.d.a(jc1.a.b());
        AnnieNGInitHelper$initAnnieXCardLiveEnv$1 r3 = AnnieNGInitHelper$initAnnieXCardLiveEnv$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L11;
        r3.invoke(com.bytedance.android.annie.ng.e.d);
    L11:
        AnnieNGInitHelper$initAnnieXCardLiveEnv$2 r4 = AnnieNGInitHelper$initAnnieXCardLiveEnv$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L15;
        r4.invoke(com.bytedance.android.annie.ng.e.a);
    L15:
        AnnieNGInitHelper$initAnnieXCardLiveEnv$3 r5 = AnnieNGInitHelper$initAnnieXCardLiveEnv$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L19;
        r5.invoke(com.bytedance.android.annie.ng.e.c);
    L19:
        Function1<o8.c, Unit> r9 = new AnnieNGInitHelper$initAnnieXCardLiveEnv$4(r2);
        Intrinsics.checkNotNullParameter(r9, "block");
        if (com.bytedance.android.annie.ng.g.g == true) goto L23;
        r9.invoke(com.bytedance.android.annie.ng.e.b);
    L23:
        Function1<d8.b, Unit> r11 = new AnnieNGInitHelper$initAnnieXCardLiveEnv$5(r7);
        d8.b r12 = e8.c.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        com.bytedance.android.annie.ng.g.d("annie_lynx", new e8.b(r11));
        boolean r13 = BulletSdk.a;
        BulletSdk.c(r0.a);
        Application r14 = r0.a;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        com.bytedance.android.annie.ng.g.a = r14;
        com.bytedance.android.annie.ng.d r15 = new com.bytedance.android.annie.ng.d(com.bytedance.android.annie.ng.e.b, com.bytedance.android.annie.ng.e.c, com.bytedance.android.annie.ng.e.d);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        com.bytedance.android.annie.ng.g.b = r15;
        Map r16 = com.bytedance.android.annie.ng.i.b;
        monitor-enter(r16);
        Iterator r17 = ((LinkedHashMap) r16).entrySet().iterator();     // Catch: Throwable -> L40
    L27:
        if (r17.hasNext() == false) goto L29;
        ((com.bytedance.android.annie.ng.j) ((Map.Entry) r17.next()).getValue()).onCallback();     // Catch: Throwable -> L40
        goto L27
    L29:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(r16);
        Annie.registerService$default(i9.c.class, new com.bytedance.android.live.browser.service.t(), null, 4, null);
        f(r6, r7, r8);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L37
        if (((Boolean) sd.a.getValue()).booleanValue() == false) goto L35;
        r6.registerDataShare();     // Catch: Throwable -> L37
    L35:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        c = true;
    L37:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        th = move-exception;
        throw th;
    L44:
        if (com.bytedance.android.annie.xbridge.mix.t.a != null) goto L56;
        int r22 = com.bytedance.android.live.browser.utils.g.a;
        IH5AssistService r23 = (IH5AssistService) jc1.k.f(IH5AssistService.class);
        if (r23 == null) goto L48;
        r1 = r23.getExternalMethodInjector();
    L48:
        com.bytedance.android.annie.xbridge.mix.t.a = r1;
        return true;
    L56:
        return true;
    }

    public static void f(v r5, w r6, u r7) {
        com.bytedance.android.annie.a.e(w8.c.class, new AnnieAbilityProviderImpl(r5, r7, r6), true, 4);
        com.bytedance.android.annie.a.e(y9.n.class, new com.bytedance.android.live.browser.service.q(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.service.network.i.class, new com.bytedance.android.live.browser.service.r(), true, 4);
        com.bytedance.android.annie.a.e(d9.b.class, new com.bytedance.android.live.browser.service.m(), true, 4);
        com.bytedance.android.annie.a.e(i9.d.class, new h0(r6), true, 4);
        Annie.registerService$default(i9.c.class, new com.bytedance.android.live.browser.service.t(), null, 4, null);
        com.bytedance.android.annie.a.e(ca.b.class, new com.bytedance.android.live.browser.service.f0(r7), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.bridge.o.class, new com.bytedance.android.live.browser.service.k(), true, 4);
        com.bytedance.android.annie.a.e(m9.c.class, new AnniePerformanceServiceImpl(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.bridge.r.class, new com.bytedance.android.live.browser.service.v(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.bridge.n.class, new com.bytedance.android.live.browser.service.j(), true, 4);
        com.bytedance.android.annie.a.e(w9.c.class, new com.bytedance.android.live.browser.service.y(), true, 4);
        com.bytedance.android.annie.a.e(z8.b.class, new com.bytedance.android.live.browser.service.h(), true, 4);
        e();
        com.bytedance.android.annie.a.e(r9.d.class, new com.bytedance.android.live.browser.service.u(r6), true, 4);
        com.bytedance.android.annie.a.e(aa.b.class, new com.bytedance.android.live.browser.service.d0(), true, 4);
        com.bytedance.android.annie.a.e(x8.d.class, new com.bytedance.android.live.browser.service.a(), true, 4);
        com.bytedance.android.annie.a.e(x9.b.class, new com.bytedance.android.live.browser.service.z(), true, 4);
        com.bytedance.android.annie.a.e(da.b.class, new com.bytedance.android.live.browser.service.g0(r5), true, 4);
        com.bytedance.android.annie.a.e(z9.b.class, new com.bytedance.android.live.browser.service.b0(), true, 4);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
    L6:
        c9.a.a.E0(DebugTatPosition.TOP_RIGHT, new a());
    L7:
        com.bytedance.android.annie.a.e(e9.b.class, new com.bytedance.android.live.browser.service.n(r7), true, 4);
        com.bytedance.android.annie.a.e(u9.b.class, new com.bytedance.android.live.browser.service.l(r6), true, 4);
        com.bytedance.android.annie.a.e(IAnnieNetworkService.class, new com.bytedance.android.live.browser.service.x(), true, 4);
        com.bytedance.android.annie.a.e(k9.c.class, new com.bytedance.android.live.browser.service.s(r6), true, 4);
        com.bytedance.android.annie.a.e(f9.b.class, new AnnieExternalServiceImpl(), true, 4);
        ALogger.i("AnnieNGInitHelper", "initAnnieEnv, registerService with IFinalGlobalPropsParamsService");
        com.bytedance.android.annie.a.e(p9.f.class, new com.bytedance.android.live.browser.service.o(), true, 4);
        com.bytedance.android.annie.a.e(v9.c.class, new com.bytedance.android.live.browser.service.c0(), true, 4);
        com.bytedance.android.annie.a.e(y8.c.class, new com.bytedance.android.live.browser.service.i(), true, 4);
        com.bytedance.android.annie.a.e(a9.d.class, new AnnieBridgeAsrService(), true, 4);
        com.bytedance.android.annie.a.e(a9.e.class, new a9.c(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.param.m.class, new com.bytedance.android.live.browser.service.p(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.xbridge.mix.f.class, new com.bytedance.android.live.browser.service.w(), true, 4);
        com.bytedance.android.annie.a.e(com.bytedance.android.annie.param.n.class, new com.bytedance.android.live.browser.service.e0(), true, 4);
        Lazy r8 = DegradeUtils.a;
        if (((Boolean) g4.a.getValue()).booleanValue() == true) goto L15;
        Lazy r9 = DegradeUtils.a;
        if (((IPerformanceStrategyManager) r9.getValue()) == null) goto L16;
        IPerformanceStrategyManager r11 = (IPerformanceStrategyManager) r9.getValue();
        Intrinsics.checkNotNull(r11);
        r11.registerPerformanceStrategyTask(950, new com.bytedance.android.live.browser.utils.a());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        goto L6
    }
}
