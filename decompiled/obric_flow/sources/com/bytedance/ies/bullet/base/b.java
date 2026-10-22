package com.bytedance.ies.bullet.base;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import av.i;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.android.monitorV2.k;
import com.bytedance.ies.bullet.core.r;
import com.bytedance.ies.bullet.core.s;
import com.bytedance.ies.bullet.core.u;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.kit.resourceloader.h;
import com.bytedance.ies.bullet.pool.f;
import com.bytedance.ies.bullet.prefetchv2.p;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.j;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.receiver.headset.HeadSetReceiver;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import li.n;
import tc.d;
import ym.m;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f5175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f5176b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5177c = null;

    static {
        f5176b = new Object();
        f5177c = new a();
    }

    public static void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (f5175a == true) goto L28;
        String r10 = r5.getApplicationContext().getPackageName();
        if (StringsKt.P(r10, "com.ss.android.ugc.aweme") == false) goto L9;
    L7:
        r10 = "com.ss.android.ugc.aweme";
    L20:
        String r11 = r10.concat(".bullet.BulletDefaultInitializer");
        Class.forName(r11).newInstance();     // Catch: Throwable -> L23
        c(false, "initializeDefaultBid failed, class name = " + r11 + ", error info = invalid initialize", null);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        StringBuilder r12 = e.b("initializeDefaultBid failed, class name = ", r11, ", error info = ");
        r12.append(th.getMessage());
        c(false, r12.toString(), th);
        return;
    L9:
        if (r10.equals("com.ss.android.ugc.live") == true) goto L7;
        if (r10.equals("com.ss.android.yumme.video") == true) goto L7;
        if (r10.equals("com.ss.android.ugc.livelite") == true) goto L7;
        if (r10.equals("my.maya.android") == false) goto L20;
    }

    public static void b(c r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletSdk:init start with " + r5.f5179b, "XInit");
        if ("default_bid" == r5.f5179b) goto L6;
        a(r5.f5178a);
    L6:
        if ("default_bid" == r5.f5179b) goto L8;
        e(r5);
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletSdk:init success with " + r5.f5179b, "XInit");
        return;
    L8:
        if (f5175a == false) goto L10;
        return;
    L10:
        Object r11 = f5176b;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (f5175a == false) goto L16;
        monitor-exit(r11);
        return;
    L16:
        e(r5);     // Catch: Throwable -> L19
        f5175a = true;     // Catch: Throwable -> L19
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletSdk: init success with " + r5.f5179b, "XInit");     // Catch: Throwable -> L19
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r11);
    }

    public static void c(boolean r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "errMsg");
        if (r5 == false) goto L7;
        if (r11 == null) goto L6;
        throw r11;
    L6:
        throw new RuntimeException(r10);
    L7:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r10, LogLevel.d, "XInit");
    }

    public static boolean d(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter("default_bid", "bid");
        if (Intrinsics.areEqual(m.f(r11, "mix_container_type"), "anniex") == false) goto L6;
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("BulletMixSwitch", "match  AnnieXDefault schema is: " + r11, null, 12);
        return com.bytedance.android.anniex.assemble.a.c(r10, r11);
    L6:
        a(r10);
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("BulletMixSwitch", "match  AnnieXBullet schema is: " + r11, null, 12);
        com.bytedance.ies.bullet.service.router.a r13 = (com.bytedance.ies.bullet.service.router.a) yc.a.a(com.bytedance.ies.bullet.service.router.a.class, "default_bid");
        if (r13 != null) goto L9;
        return false;
    L9:
        return r13.b(r10, r11, new com.bytedance.ies.bullet.service.base.router.config.a());
    }

    public static void e(c r16) {
        int r5 = 6;
        int r10 = 0;
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "BulletSdk:init internal start with " + r16.f5179b, "XInit");
        String r12 = r16.f5179b;
        d r13 = r16.g;
        Application r14 = r16.f5178a;
        mb.b r15 = r16.d;
        Boolean r17 = r16.f5180c;
        if (r17 == null) goto L5;
        boolean r18 = r17.booleanValue();
    L6:
        wc.e r19 = r16.e;
        rd.a r110 = r16.f;
        m.b r111 = new m.b(r5);
        f r112 = new f();
        if (f5175a == false) goto L9;
    L42:
        String r20 = com.bytedance.ies.bullet.settings.b.class.getName();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r20, "clazzName");
        rc.c r21 = (rc.c) r13.f22122a.get(r20);
        if (r21 == null) goto L45;
        tc.c r22 = tc.c.f22119c;
        tc.c.f22119c.c(r16.f5179b, com.bytedance.ies.bullet.settings.b.class, (com.bytedance.ies.bullet.settings.b) r21);
    L45:
        ConcurrentHashMap r23 = mb.a.f20054a;
        if (r15 != null) goto L50;
        r15 = (mb.b) mb.a.f20054a.get("default_bid");
        if (r15 != null) goto L50;
        r15 = new mb.b();
    L50:
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r15, "debugInfo");
        mb.a.f20054a.put(r12, r15);
        if (r19 == null) goto L77;
        ConcurrentHashMap r24 = g.f5451a;
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r19, "config");
        dc.b.a("register ResourceLoader with ".concat(r12));
        com.bytedance.ies.bullet.forest.c.f5393a.b(r12, r19);
        ConcurrentHashMap r25 = g.f5451a;
        h r26 = new h();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r26.e = r12;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r26.f = r19;
        String r27 = r19.f.getAccessKey();
        GeckoConfig r28 = r19.f;
        Intrinsics.checkNotNullParameter(r27, "ak");
        Intrinsics.checkNotNullParameter(r28, "config");
        if (r26.f == null) goto L60;
        com.bytedance.ies.bullet.kit.resourceloader.c r113 = (com.bytedance.ies.bullet.kit.resourceloader.c) r28.getLoaderDepender();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r113.f5446a = r26;
        r26.d().g.put(r27, r28);
        if (r28.getNetworkImpl() == null) goto L57;
    L61:
        r25.put(r12, r26);
        ja.d r29 = ec.a.f16815a;
        int r30 = r19.f22829h;
        if (r30 >= 1) goto L64;
        r29.getClass();
    L75:
        com.bytedance.ies.bullet.core.h r31 = com.bytedance.ies.bullet.core.h.g;
        r31.d = r19.f22828c;
        r31.e = r19.d;
        r31.f = r19.e;
    L79:
        if (r110 == null) goto L85;
        Lazy r32 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r33 = i.e();
        r33.getClass();
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r110, "globalSchemaConfig");
        if (r33.f6145b.containsKey(r12) == true) goto L87;
        r33.f6145b.put(r12, r110);
    L87:
        HeadSetReceiver r34 = pd.a.f21324a;
        Intrinsics.checkNotNullParameter(r14, "context");
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L91
        if (pd.a.f21325b == true) goto L93;
        HeadSetReceiver r36 = pd.a.f21324a;     // Catch: Throwable -> L91
        int r37 = HeadSetReceiver.f6124b;     // Catch: Throwable -> L91
        IntentFilter r38 = new IntentFilter();     // Catch: Throwable -> L91
        r38.addAction("android.intent.action.HEADSET_PLUG");     // Catch: Throwable -> L91
        r38.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L91
        r14.registerReceiver(r36, r38);     // Catch: Throwable -> L91
        pd.a.f21325b = true;     // Catch: Throwable -> L91
    L93:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L91
    L96:
        com.bytedance.ies.bullet.service.router.a r39 = new com.bytedance.ies.bullet.service.router.a(r12, r111);
        ConcurrentHashMap r40 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r39, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(com.bytedance.ies.bullet.service.router.a.class, r39, r12);
        yc.a.b(com.bytedance.ies.bullet.pool.g.class, new com.bytedance.ies.bullet.pool.g(r112, r12), r12);
        com.bytedance.ies.bullet.service.preload.c r41 = new com.bytedance.ies.bullet.service.preload.c();
        Intrinsics.checkNotNullParameter(r41, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(com.bytedance.ies.bullet.service.preload.c.class, r41, "default_bid");
        jb.a r42 = new jb.a();
        Intrinsics.checkNotNullParameter(r42, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(jb.a.class, r42, "default_bid");
        p r43 = new p();
        Intrinsics.checkNotNullParameter(r43, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(p.class, r43, "default_bid");
        Intrinsics.checkNotNullParameter(r14, "application");
        com.bytedance.ies.bullet.preloadv2.e r44 = new com.bytedance.ies.bullet.preloadv2.e();
        if (com.bytedance.ies.bullet.preloadv2.e.f5883b == true) goto L99;
        com.bytedance.ies.bullet.preloadv2.e.f5883b = true;
        r14.registerComponentCallbacks(new com.bytedance.ies.bullet.preloadv2.d());
        u.a(null);
    L99:
        Intrinsics.checkNotNullParameter(r44, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(com.bytedance.ies.bullet.preloadv2.e.class, r44, "default_bid");
        lj.a r45 = new lj.a();
        Intrinsics.checkNotNullParameter(r45, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(lj.a.class, r45, "default_bid");
        md.b r46 = new md.b();
        tc.c r47 = tc.c.f22119c;
        tc.c.f22119c.c(r12, j.class, r46);
        tc.c r48 = tc.c.f22119c;
        r48.getClass();
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "serviceMap");
        d r49 = r48.b(r12);
        Intrinsics.checkNotNullParameter(r13, "other");
        Iterator r50 = r13.f22122a.entrySet().iterator();
    L101:
        if (r50.hasNext() == false) goto L103;
        Map.Entry r51 = (Map.Entry) r50.next();
        r49.a((String) r51.getKey(), (rc.c) r51.getValue());
        goto L101
    L103:
        ArrayList r52 = new ArrayList();
        Iterator r53 = r13.f22122a.entrySet().iterator();
    L105:
        if (r53.hasNext() == false) goto L107;
        r52.add(((Map.Entry) r53.next()).getKey());
        goto L105
    L107:
        Iterator r54 = r52.iterator();
    L109:
        if (r54.hasNext() == false) goto L111;
        String r55 = (String) r54.next();
        boolean r56 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, com.lynx.tasm.utils.b.j("BulletSdk: insert service ", r55, " for ", r12), "XInit");
        goto L109
    L111:
        yc.a.b(com.bytedance.ies.bullet.service.preload.b.class, new com.bytedance.ies.bullet.service.preload.b(r14, r12), r12);
        if (r16.f5181h == null) goto L126;
        boolean r57 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, "BulletSdk, register settings service");
        c5.a r58 = r16.f5181h;
        if (r58 == null) goto L125;
        xc.a r59 = (xc.a) r58.f1119c;
        com.bytedance.ies.bullet.core.h r60 = com.bytedance.ies.bullet.core.h.g;
        String r61 = r60.d;
        if (r61 != null) goto L118;
    L119:
        r60.d = r59.f23012a;
    L120:
        String r62 = r60.f;
        if (r62 != null) goto L123;
    L124:
        r60.f = r59.d;
        goto L125
    L123:
        if (r62.length() != 0) goto L125;
    L118:
        if (r61.length() != 0) goto L120;
    L125:
        c5.a r63 = r16.f5181h;
        Intrinsics.checkNotNull(r63);
        com.bytedance.ies.bullet.settings.a r64 = new com.bytedance.ies.bullet.settings.a(r63);
        r64.d = new o(r64, 3);
        Intrinsics.checkNotNullParameter(r64, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(xc.e.class, r64, "default_bid");
    L126:
        com.bytedance.ies.bullet.secure.e r65 = r16.f5182i;
        if (r65 == null) goto L143;
        Lazy r66 = com.bytedance.ies.bullet.secure.f.f5904c;
        com.bytedance.ies.bullet.secure.f r67 = wn.h.e();
        r67.getClass();
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r65, "config");
        String r68 = com.bytedance.ies.bullet.core.h.g.d;
        if (r68 == null) goto L134;
        n r69 = pi.a.f21354a;
        Intrinsics.checkNotNullParameter(r68, Constant.APPID);
        if (pi.a.f.containsKey(r68) == false) goto L134;
        pi.a.f21354a = new n(true, 2);
    L134:
        if (Intrinsics.areEqual("default_bid", r12) == false) goto L139;
        com.bytedance.ies.bullet.base.utils.logger.a.g("HybridSecureManager", "setSecureConfig: set global config", null, 12);
        if (r67.f5905a != null) goto L143;
        r67.f5905a = r65;
        goto L143
    L139:
        int r70 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("HybridSecureManager", "setSecureConfig: set config for ".concat(r12), null, 12);
        if (((com.bytedance.ies.bullet.secure.e) r67.f5906b.get(r12)) != null) goto L143;
        r67.f5906b.put(r12, r65);
    L143:
        int r71 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XInit", "init internal success", MapsKt.mapOf(TuplesKt.to("bid", r16.f5179b)), 8);
        return;
    L91:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L96
    L85:
        if (Intrinsics.areEqual("default_bid", r12) == false) goto L87;
        c(r18, r12.concat(" should have schemaConfig"), null);
        goto L87
    L64:
        k r73 = (k) r29.f18303c;
        if (r73 != null) goto L67;
    L68:
        ((ConcurrentHashMap) r29.f18301a).clear();
        k r74 = (k) r29.f18303c;
        if (r74 == null) goto L71;
        r74.evictAll();
    L71:
        k r75 = (k) r29.f18302b;
        if (r75 == null) goto L74;
        r75.evictAll();
    L74:
        ((ConcurrentHashMap) r29.d).clear();
        r29.f18303c = new k(r30, 5);
        r29.f18302b = new k(r30, 6);
        goto L75
    L67:
        if (r73.maxSize() <= r30) goto L75;
    L57:
        if (r28.getLocalInfo().length() <= 0) goto L59;
        r26.d().getClass();
        r28.setNetworkImpl(null);
        goto L61
    L59:
        r26.d().getClass();
        r28.setNetworkImpl(null);
        goto L61
    L60:
        dc.b.b("ResourceLoaderConfig 实例未初始化，registerGeckoConfig未执行");
        goto L61
    L77:
        if (Intrinsics.areEqual("default_bid", r12) == false) goto L79;
        c(r18, r12.concat(" should have resourceLoaderConfig"), null);
        goto L79
    L9:
        if (Intrinsics.areEqual(r12, "default_bid") == false) goto L42;
        r14.registerComponentCallbacks(f5177c);
        com.bytedance.ies.bullet.service.base.b.f5956a = r18;
        com.bytedance.ies.bullet.core.h r114 = com.bytedance.ies.bullet.core.h.g;
        r114.f5316b = r14;
        r114.f5315a = r18;
        Lambda r115 = com.bytedance.ies.bullet.service.monitor.c.f6038a;
        BulletSdk$initInternal$1 r116 = BulletSdk$initInternal$1.f5174a;
        Intrinsics.checkNotNullParameter(r116, "func");
        com.bytedance.ies.bullet.service.monitor.c.f6038a = r116;
        ConcurrentHashMap r76 = g.f5451a;
        Intrinsics.checkNotNullParameter(r14, "application");
        dc.b.a("init ResourceLoader");
        g.f5452b = r14;
        g.f5453c = r18;
        if (g.e != null) goto L13;
        g.e = new com.bytedance.ies.bullet.preloadv2.a();
    L13:
        s r77 = s.f5352a;
        monitor-enter(r77);
        Intrinsics.checkNotNullParameter(r14, "application");     // Catch: Throwable -> L39
        if (s.f5353b == false) goto L19;
        monitor-exit(r77);
    L21:
        s6.b r78 = new s6.b(5);
        Intrinsics.checkNotNullParameter(r78, "logger");
        com.bytedance.sdk.xbridge.cn.utils.f.f7505a = r78;
        ib.d r79 = new ib.d(0);
        Intrinsics.checkNotNullParameter(r79, "configProvider");
        ki.a.a("XBridgeAuthRecoveryManager.setConfigProvider: configProvider=".concat(ib.d.class.getName()));
        com.lynx.tasm.base.h.f10132b = r79;
        if (com.lynx.tasm.base.h.f10131a != null) goto L24;
        com.lynx.tasm.base.h.f10131a = Long.valueOf(System.currentTimeMillis());
    L24:
        Lazy r80 = com.bytedance.ies.bullet.base.storage.a.f5225a;
        SharedPreferences r117 = (SharedPreferences) r80.getValue();
        if (r117 == null) goto L27;
        String r81 = r117.getString("version_name", null);
    L29:
        if (Intrinsics.areEqual("9.0.0", r81) == true) goto L42;
        SharedPreferences r82 = (SharedPreferences) r80.getValue();
        if (r82 == null) goto L42;
        SharedPreferences.Editor r83 = r82.edit();
        if (r83 == null) goto L42;
        SharedPreferences.Editor r84 = r83.clear();
        if (r84 == null) goto L42;
        SharedPreferences.Editor r85 = r84.putString("version_name", "9.0.0");
        if (r85 == null) goto L42;
        r85.apply();
        goto L42
    L27:
        r81 = null;
        goto L29
    L19:
        s.f5353b = true;     // Catch: Throwable -> L39
        r14.registerActivityLifecycleCallbacks(new r(r10));     // Catch: Throwable -> L39
        monitor-exit(r77);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L5:
        r18 = false;
        goto L6
    }
}
