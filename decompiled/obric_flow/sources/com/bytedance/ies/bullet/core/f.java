package com.bytedance.ies.bullet.core;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.pia.core.setting.Settings;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f5312b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5313a;

    static {
        f5312b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BulletContextManager$Companion$instance$2.f5266a);
    }

    public f() {
        this.f5313a = new ConcurrentHashMap();
    }

    public final e a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        return (e) this.f5313a.get(r5);
    }

    public final e b(String r17, Uri r18, Bundle r19, boolean r20, com.bytedance.ies.bullet.service.sdk.a r21) {
        Uri r5 = r18;
        com.bytedance.ies.bullet.service.sdk.a r10 = r21;
        int r11 = 7;
        Intrinsics.checkNotNullParameter(r17, "bid");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        long r12 = System.currentTimeMillis();
        String r13 = com.lynx.tasm.behavior.utils.d.h(r18, r19);
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(12, r13, "BulletContextManager getOrCreateContext: " + r17 + ", " + r5 + ", " + r19 + ", " + r20 + ", " + r10, null);
        e r15 = a(r13);
        if (r15 != null) goto L5;
        r15 = new e(r13);
        c(r15);
        r15.f5303q = new ad.a(r5);
        r15.f5293c.d(r15);
        boolean r16 = true;
    L6:
        Uri r110 = Uri.EMPTY;
        if (Intrinsics.areEqual(r5, r110) == false) goto L9;
    L164:
        return r15;
    L9:
        if (r15.e != null) goto L11;
        r16 = true;
    L11:
        if (r16 == false) goto L162;
        if (r10 != null) goto L16;
        if (r19 == null) goto L15;
        r10 = new com.bytedance.ies.bullet.service.sdk.a();
        o4.a r111 = new o4.a(r19);
        Intrinsics.checkNotNullParameter(r111, "interceptor");
        r10.f6132a.add(r111);
        goto L16
    L15:
        r10 = null;
    L16:
        if (r10 == null) goto L24;
        Lazy r112 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r113 = av.i.e();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "schemaConfig");
        if (Intrinsics.areEqual(r5, r110) == true) goto L24;
        com.bytedance.ies.bullet.service.sdk.a r114 = (com.bytedance.ies.bullet.service.sdk.a) r113.f6146c.get(r5);
        if (r114 == null) goto L23;
        ArrayList r22 = r10.f6132a;
        Intrinsics.checkNotNullParameter(r22, "interceptors");
        r114.f6132a.addAll(r22);
        goto L24
    L23:
        r113.f6146c.put(r5, r10);
    L24:
        boolean r23 = Intrinsics.areEqual(r17, "webcast");
        if (r20 == false) goto L27;
        Lazy r24 = com.bytedance.ies.bullet.service.sdk.d.e;
        rd.b r25 = av.i.e().a(r17, r5, r23);
    L43:
        r15.e = r25;
        com.bytedance.ies.bullet.service.sdk.b r26 = (com.bytedance.ies.bullet.service.sdk.b) r25;
        r15.f5297k = r26.c();
        Uri r115 = (Uri) new vd.a(r25, "url", 8).f22372b;
        if (r115 == null) goto L47;
        r5 = r115;
    L47:
        r15.f5303q = new ad.a(r5);
        if ((r25 instanceof com.bytedance.ies.bullet.service.sdk.b) == true) goto L51;
        r26 = null;
    L51:
        if (r115 == null) goto L53;
        String r27 = io.reactivex.exceptions.a.b(r115, "default_bid");
    L54:
        ad.a r116 = r15.f5303q;
        Intrinsics.checkNotNull(r116);
        KitType r117 = r116.b();
        if (r26 == null) goto L111;
        if (r27 != null) goto L59;
    L63:
        String r28 = (String) new vd.a(r26, LynxMonitorService.KEY_CHANNEL, "").f22372b;
        String r118 = (String) new vd.a(r26, "bundle", "").f22372b;
        if (r118 == null) goto L66;
        String r119 = StringsKt.A(r118, "/");
    L68:
        if (com.lynx.tasm.utils.k.o(r28) == false) goto L73;
        if (r119 != null) goto L71;
    L72:
        r27 = androidx.constraintlayout.motion.widget.a.m(r28, '/', r119);
    L75:
        if (r27.length() == 0) goto L111;
        ConcurrentHashMap r120 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r121 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r121 == null) goto L111;
        com.bytedance.ies.bullet.base.settings.d r122 = (com.bytedance.ies.bullet.base.settings.d) r121.a(com.bytedance.ies.bullet.base.settings.d.class);
        if (r122 == null) goto L111;
        if (r117 != KitType.d) goto L84;
        List r123 = r122.d();
    L85:
        if (r123 == null) goto L97;
        Iterator r124 = r123.iterator();
    L88:
        if (r124.hasNext() == false) goto L92;
        Object r125 = r124.next();
        if (StringsKt.g(r27, (String) r125) == false) goto L88;
    L94:
        if (((String) r125) == null) goto L97;
        r26.b("loader_name", new vd.a("rl", r11), true);
        goto L111
    L92:
        r125 = null;
    L97:
        if (r117 != KitType.d) goto L99;
        List r126 = r122.a();
    L100:
        if (r126 == null) goto L111;
        Iterator r127 = r126.iterator();
    L103:
        if (r127.hasNext() == false) goto L107;
        Object r128 = r127.next();
        if (StringsKt.g(r27, (String) r128) == false) goto L103;
    L109:
        if (((String) r128) == null) goto L111;
        r26.b("loader_name", new vd.a("forest", r11), false);
        goto L111
    L107:
        r128 = null;
        goto L109
    L99:
        r126 = r122.b();
        goto L100
    L84:
        r123 = r122.e();
        goto L85
    L71:
        if (r119.length() == 0) goto L72;
    L73:
        r27 = "";
        goto L75
    L66:
        r119 = null;
        goto L68
    L59:
        if (StringsKt.P(r27, "http") == true) goto L62;
        r27 = null;
    L62:
        if (r27 != null) goto L75;
    L111:
        rd.e r29 = new rd.e(r25);
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r15.g = r29;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        rd.b r30 = r15.e;
        if (r30 != null) goto L114;
    L116:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r17, "bid");
        rd.b r31 = r15.e;
        if (r31 != null) goto L119;
    L161:
        r15.f5293c.D();
        boolean r32 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r33 = null;
        int r34 = 12;
        com.bytedance.ies.bullet.service.base.b.b(12, r13, "BulletContextManager : needCreateSchemaData " + r16 + " forceCreateNewSchemaData " + r20, null);
    L163:
        com.bytedance.ies.bullet.service.base.b.b(r34, r13, "BulletContextManager getOrCreateContext cost: " + (System.currentTimeMillis() - r12), r33);
        goto L164
    L119:
        if (Intrinsics.areEqual(new vd.a(r31, "__x_param_pia", null).f22372b, Boolean.TRUE) == false) goto L161;
        r15.f5307v.f1118b = true;
        String r35 = (String) new vd.a(r31, "url", null).f22372b;
        if (r35 == null) goto L161;
        boolean r36 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletContext.setupPia: url=".concat(r35), null);
        tc.c r37 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.web.pia.b.class, r17) != null) goto L160;
        LinkedHashMap r38 = com.bytedance.ies.bullet.web.pia.i.f6234a;
        String r39 = r15.getSessionId();
        rd.e r40 = r15.g;
        Intrinsics.checkNotNullParameter(r35, "url");
        Intrinsics.checkNotNullParameter(r17, "bid");
        com.bytedance.ies.bullet.web.pia.i.a(r17);
        if (((oh.f) ai.p.g(oh.f.class)) == null) goto L161;
        String r41 = "bullet-".concat(r17);
        com.bytedance.ies.bullet.web.pia.d r42 = (com.bytedance.ies.bullet.web.pia.d) com.bytedance.ies.bullet.web.pia.i.f6234a.get(r17);
        if (r42 == null) goto L129;
        String r43 = r42.f6223a;
    L130:
        com.bytedance.ies.bullet.web.pia.c r129 = new com.bytedance.ies.bullet.web.pia.c(new com.bytedance.ies.bullet.web.pia.k(r39, r40, r43));
        ConcurrentHashMap r44 = nh.h.f20259a;
        nh.g.f20258a.getClass();
        Lazy r45 = Settings.B;
        if (com.lynx.tasm.p.a().w() == false) goto L161;
        if (oh.d.f20576a.f20577a.containsKey(r41) == true) goto L136;
        com.bytedance.pia.core.utils.j.s("[Warmup] failed to warmup because there is no env for " + r41);
        goto L161
    L136:
        final nh.b r46 = new nh.b();
        r46.d = r35;
        r46.f20233a = r41;
        r46.f20234b = r129;
        r46.f20235c = true;
        String r47 = r46.e();
        if (r47 == null) goto L161;
        if (r47.isEmpty() == true) goto L161;
        monitor-enter(com.bytedance.pia.core.tracing.b.class);
        com.bytedance.frameworks.baselib.network.http.cronet.b r48 = com.bytedance.pia.core.tracing.b.f7104r;     // Catch: Throwable -> L152
        monitor-enter(r48);     // Catch: Throwable -> L152
        Intrinsics.checkNotNullParameter(r47, "name");     // Catch: Throwable -> L154
        com.bytedance.pia.core.tracing.b.f7105t.put(r47, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L154
        monitor-exit(r48);     // Catch: Throwable -> L152
        monitor-exit(com.bytedance.pia.core.tracing.b.class);     // Catch: Throwable -> L152
        FutureTask r49 = new FutureTask(new nh.e(r46));
        if (nh.h.f20259a.putIfAbsent(r47, r49) != null) goto L161;
        com.bytedance.pia.core.utils.j.A("[Runtime] start to warmup, url=".concat(r35));
        nh.f r50 = new nh.f(r47, r49);
        com.bytedance.pia.core.utils.m.b(r49);
        ((Handler) com.bytedance.pia.core.utils.m.f7156b.getValue()).postDelayed(new com.obric.oui.lisitem.a(r50, 19), 30000);
        goto L161
    L154:
        th = move-exception;
        throw th;     // Catch: Throwable -> L152
    L152:
        th = move-exception;
        throw th;
    L129:
        r43 = null;
        goto L130
    L160:
        throw new ClassCastException();
    L114:
        if (Intrinsics.areEqual(new vd.a(r30, "__x_param_annie_pro", null).f22372b, Boolean.TRUE) == false) goto L116;
        r15.f5308w.getClass();
        goto L116
    L53:
        r27 = null;
        goto L54
    L27:
        Lazy r130 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r131 = av.i.e();
        r131.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        rd.b r132 = (rd.b) r131.d.remove(r5);
        if (r19 != null) goto L30;
    L40:
        if (r132 != null) goto L42;
        r25 = av.i.e().a(r17, r5, r23);
        goto L43
    L42:
        r25 = r132;
        goto L43
    L30:
        if ((r132 instanceof com.bytedance.ies.bullet.service.sdk.b) == false) goto L32;
        com.bytedance.ies.bullet.service.sdk.b r133 = (com.bytedance.ies.bullet.service.sdk.b) r132;
    L33:
        if (r133 == null) goto L40;
        if (r133.f6134b != null) goto L40;
        Intrinsics.checkNotNullParameter(r19, "bundle");
        Bundle r134 = r133.f6134b;
        if (r134 != null) goto L39;
        r133.f6134b = r19;
        goto L40
    L39:
        r134.putAll(r19);
        goto L40
    L32:
        r133 = null;
        goto L33
    L162:
        r33 = null;
        r34 = 12;
        goto L163
    L5:
        r16 = r20;
        goto L6
    }

    public final void c(e r5) {
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        ConcurrentHashMap r10 = this.f5313a;
        r10.put(r5.getSessionId(), r5);
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(12, r5.getSessionId(), "BulletContextManager addContext: " + r10.size(), null);
    }
}
