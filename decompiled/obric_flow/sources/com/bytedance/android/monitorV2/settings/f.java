package com.bytedance.android.monitorV2.settings;

import com.bytedance.ies.bullet.base.settings.i;
import com.bytedance.ies.bullet.base.settings.j;
import com.bytedance.ies.bullet.base.settings.m;
import com.bytedance.ies.bullet.base.settings.n;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3728b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f3727a = r10;
        this.f3728b = r5;
    }

    public final void a(qg.c r13) {
        switch(this.f3727a) {
            case 0: goto L128;
            default: goto L133;
        };
    L128:
        android.support.v4.media.c r12 = (android.support.v4.media.c) this.f3728b;
        r12.getClass();
        IMonitorSettings r14 = (IMonitorSettings) pg.a.b("hybrid_monitor").a(IMonitorSettings.class);
        ((r6.a) r12.f367a).g(h.class, r14.getWebBlankConfig());
        ((r6.a) r12.f367a).g(d.class, r14.getMonitorConfig());
        ((r6.a) r12.f367a).g(c.class, r14.getLynxBlankConfig());
        r12.getClass();
        return;
    L133:
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L130
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, "bullet onUpdate,appSettings = " + r13.f21511a + ",userSettings = " + r13.f21512b);     // Catch: Throwable -> L130
    L6:
        IBulletSettings r15 = (IBulletSettings) pg.a.b("Bullet").a(IBulletSettings.class);
        rb.b r10 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xc.h r11 = r15.getResourceLoaderConfig();
        r10.getClass();
        Intrinsics.checkNotNullParameter(xc.h.class, "clazz");
        r10.b(xc.h.class, new rb.a(r11, 0));
        rb.b r16 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xc.d r17 = r15.getCommonConfig();
        r16.getClass();
        Intrinsics.checkNotNullParameter(xc.d.class, "clazz");
        r16.b(xc.d.class, new rb.a(r17, 0));
        rb.b r18 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        n r19 = r15.getWebConfig();
        r18.getClass();
        Intrinsics.checkNotNullParameter(n.class, "clazz");
        r18.b(n.class, new rb.a(r19, 0));
        rb.b r20 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xc.f r21 = r15.getMonitorConfig();
        r20.getClass();
        Intrinsics.checkNotNullParameter(xc.f.class, "clazz");
        r20.b(xc.f.class, new rb.a(r21, 0));
        rb.b r22 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xc.g r23 = r15.getPineappleConfig();
        r22.getClass();
        Intrinsics.checkNotNullParameter(xc.g.class, "clazz");
        r22.b(xc.g.class, new rb.a(r23, 0));
        rb.b r24 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        j r25 = r15.getMixConfig();
        r24.getClass();
        Intrinsics.checkNotNullParameter(j.class, "clazz");
        r24.b(j.class, new rb.a(r25, 0));
        rb.b r26 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        m r27 = r15.getSecuritySettingConfig();
        r26.getClass();
        Intrinsics.checkNotNullParameter(m.class, "clazz");
        r26.b(m.class, new rb.a(r27, 0));
        rb.b r28 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        com.bytedance.ies.bullet.base.settings.d r29 = r15.getForestSettingConfig();
        r28.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.base.settings.d.class, "clazz");
        r28.b(com.bytedance.ies.bullet.base.settings.d.class, new rb.a(r29, 0));
        rb.b r30 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xb.c r31 = r15.getAnnieXPredefineConfig();
        r30.getClass();
        Intrinsics.checkNotNullParameter(xb.c.class, "clazz");
        r30.b(xb.c.class, new rb.a(r31, 0));
        rb.b r32 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        com.bytedance.ies.bullet.base.settings.b r33 = r15.getArgusSecuritySettingConfig();
        r32.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.base.settings.b.class, "clazz");
        r32.b(com.bytedance.ies.bullet.base.settings.b.class, new rb.a(r33, 0));
        rb.b r34 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        xb.d r35 = r15.getAnnieXPredefineWasmConfig();
        r34.getClass();
        Intrinsics.checkNotNullParameter(xb.d.class, "clazz");
        r34.b(xb.d.class, new rb.a(r35, 0));
        rb.b r36 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        com.bytedance.pia.core.setting.c r37 = r15.getPIAConfig();
        r36.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.pia.core.setting.c.class, "clazz");
        r36.b(com.bytedance.pia.core.setting.c.class, new rb.a(r37, 0));
        rb.b r38 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).f6162c;
        com.bytedance.ies.bullet.base.settings.c r39 = r15.getClientAiConfig();
        r38.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.base.settings.c.class, "clazz");
        r38.b(com.bytedance.ies.bullet.base.settings.c.class, new rb.a(r39, 0));
        SccConfig r110 = r15.getSccSettingsConfig();
        if (r110 == null) goto L9;
        Lazy r40 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
        Intrinsics.checkNotNullParameter(r110, "sccConfig");
        vf.b.b(r110.e(), vf.a.d);
    L9:
        o r111 = ((com.bytedance.ies.bullet.settings.a) this.f3728b).d;
        if (r111 == null) goto L127;
        xc.d r112 = (xc.d) ((com.bytedance.ies.bullet.settings.a) r111.f23310b).a(xc.d.class);
        if (r112 == null) goto L16;
        Boolean r113 = r112.r0();
        if (r113 == null) goto L16;
        boolean r114 = r113.booleanValue();
    L17:
        boolean r41 = com.bytedance.ies.bullet.service.base.b.f5956a;
        Lazy r42 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        com.bytedance.sdk.xbridge.cn.utils.f.i("BulletLog", "BulletLogger setDrop " + r114);
        com.bytedance.ies.bullet.service.base.b.d = r114;
        ki.a r43 = ki.a.f18646a;
        ki.a.f18648c = r114;
        xc.h r115 = (xc.h) ((com.bytedance.ies.bullet.settings.a) r111.f23310b).a(xc.h.class);
        int r44 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        xc.d r45 = (xc.d) ((com.bytedance.ies.bullet.settings.a) r111.f23310b).a(xc.d.class);
        if (r45 == null) goto L20;
        int r46 = r45.p();
    L21:
        com.bytedance.ies.bullet.base.utils.logger.a.f5258a = r46;
        if (r115 == null) goto L38;
        boolean r47 = r115.a();
        int r48 = r115.g();
        boolean r49 = r115.e();
        Map r50 = r115.h();
        if (r50 != null) goto L26;
        r50 = new LinkedHashMap();
    L26:
        ConcurrentHashMap r51 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        Intrinsics.checkNotNullParameter(r50, "prefix2ak");
        Iterator r52 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a.entrySet().iterator();
    L28:
        if (r52.hasNext() == false) goto L30;
        wc.e r53 = ((com.bytedance.ies.bullet.kit.resourceloader.h) ((Map.Entry) r52.next()).getValue()).d();
        r53.f22830i = r47;
        r53.f22829h = r48;
        r53.f22831j = r49;
        r53.f22833l.putAll(r50);
        goto L28
    L30:
        boolean r54 = com.bytedance.ies.bullet.preloadv2.c.f5880a;
        com.bytedance.ies.bullet.preloadv2.c.f5880a = r115.b();
        com.bytedance.ies.bullet.preloadv2.c.f5881b = r115.j();
        com.bytedance.ies.bullet.preloadv2.c.f5882c = r115.i() * 1048576;
        boolean r55 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a = r115.c();
        if (r115.d() == true) goto L36;
        tc.c r116 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r117 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r117 == null) goto L35;
        com.bytedance.ies.bullet.service.base.d r118 = (com.bytedance.ies.bullet.service.base.d) r117.f6163b.getValue();
    L35:
        boolean r119 = false;
    L37:
        com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b = r119;
        goto L38
    L36:
        r119 = true;
    L38:
        jb.d r120 = jb.d.f18316a;
        monitor-enter(r120);
        System.currentTimeMillis();     // Catch: Throwable -> L124
        monitor-exit(r120);     // Catch: Throwable -> L124
        com.bytedance.ies.bullet.base.settings.b r121 = (com.bytedance.ies.bullet.base.settings.b) ((com.bytedance.ies.bullet.settings.a) r111.f23310b).a(com.bytedance.ies.bullet.base.settings.b.class);
        if (r121 == null) goto L45;
        String r122 = r121.f5195a;
    L46:
        Lazy r56 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
        if (r122 != null) goto L49;
        com.bytedance.ies.bullet.base.utils.logger.a.g("HybridSecureManager", "updateArgusJSONConfig: config is null", null, 12);
    L49:
        m r123 = (m) ((com.bytedance.ies.bullet.settings.a) r111.f23310b).a(m.class);
        if (r123 == null) goto L119;
        wn.h.e().getClass();
        Intrinsics.checkNotNullParameter(r123, "data");
        com.bytedance.ies.argus.repository.d r124 = new com.bytedance.ies.argus.repository.d();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        CollectionsKt.emptyList();
        CollectionsKt.listOf(new Integer[]{-1, 104});
        com.bytedance.ies.bullet.base.settings.f r57 = r123.b();
        if (r57 == null) goto L60;
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        MapsKt.emptyMap();
        Map r58 = r57.a();
        LinkedHashMap r59 = new LinkedHashMap();
        if (r58 == null) goto L60;
        Iterator r60 = r58.entrySet().iterator();
    L57:
        if (r60.hasNext() == false) goto L60;
        Map.Entry r61 = (Map.Entry) r60.next();
        String r62 = (String) r61.getKey();
        i r63 = (i) r61.getValue();
        r9.c r125 = new r9.c(5);
        MapsKt.emptyMap();
        r63.getClass();
        r59.put(r62, r125);
    L60:
        if (r123.c() == null) goto L63;
        CollectionsKt.emptyList();
    L63:
        if (r123.d() == null) goto L65;
        CollectionsKt.listOf(new Integer[]{-1, 104});
    L65:
        Intrinsics.checkNotNullParameter(r124, "data");
        Lazy r64 = com.bytedance.ies.argus.repository.a.d;
        l9.o.c().getClass();
        Intrinsics.checkNotNullParameter(r124, "data");
        int r126 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r65 = new StringBuilder("updateJSBAuthConfig, enableJSBAuthV3: ");
        com.bytedance.ies.bullet.base.settings.f r66 = r123.b();
        if (r66 == null) goto L68;
        Boolean r67 = Boolean.valueOf(r66.c());
    L69:
        r65.append(r67);
        com.bytedance.ies.bullet.base.utils.logger.a.c("HybridSecureManager", r65.toString());
        com.bytedance.ies.bullet.base.settings.f r127 = r123.b();
        if (r127 != null) goto L72;
    L79:
        com.bytedance.ies.bullet.base.settings.h r128 = r123.c();
        li.n r68 = pi.a.f21354a;
        List r69 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r69, "forceDegradeCodeList");
        li.i r70 = new li.i();
        r70.f19663a = null;
        r70.f19664b = r69;
        if (r128 == null) goto L82;
        String[] r71 = r128.b();
    L83:
        r70.f19663a = r71;
        if (r128 == null) goto L87;
        List r129 = r128.a();
        if (r129 == null) goto L87;
    L88:
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r70.f19664b = r129;
        Intrinsics.checkNotNullParameter(r70, "config");
        com.bytedance.ies.bullet.base.settings.f r130 = r123.b();
        if (r130 == null) goto L91;
        Map r131 = r130.a();
    L92:
        if (r131 == null) goto L106;
        Iterator r132 = r131.entrySet().iterator();
    L95:
        if (r132.hasNext() == false) goto L106;
        Map.Entry r72 = (Map.Entry) r132.next();
        String r73 = (String) r72.getKey();
        i r74 = (i) r72.getValue();
        LinkedHashMap r75 = pi.a.f21356c;
        li.g r76 = new li.g();
        r76.f19658a = r74.c();
        String[] r77 = r74.e();
        if (r77 != null) goto L99;
        r77 = new String[0];
    L99:
        Intrinsics.checkNotNullParameter(r77, "<set-?>");
        r76.f19659b = r77;
        r76.f19660c = r74.b();
        String[] r78 = r74.d();
        if (r78 != null) goto L102;
        r78 = new String[0];
    L102:
        Intrinsics.checkNotNullParameter(r78, "<set-?>");
        r76.d = r78;
        Map r79 = r74.a();
        if (r79 != null) goto L105;
        r79 = MapsKt.emptyMap();
    L105:
        Intrinsics.checkNotNullParameter(r79, "<set-?>");
        r76.e = r79;
        r75.put(r73, r76);
    L106:
        com.bytedance.ies.bullet.base.settings.f r133 = r123.b();
        if (r133 == null) goto L109;
        com.bytedance.ies.bullet.base.settings.g r134 = r133.f();
    L110:
        li.n r80 = pi.a.f21354a;
        if (r134 == null) goto L113;
        Map r81 = r134.a();
    L114:
        pi.a.d = r81;
        if (r134 == null) goto L117;
        Map r135 = r134.b();
    L118:
        pi.a.e = r135;
        goto L119
    L117:
        r135 = null;
        goto L118
    L113:
        r81 = null;
        goto L114
    L109:
        r134 = null;
        goto L110
    L91:
        r131 = null;
    L87:
        r129 = CollectionsKt.emptyList();
        goto L88
    L82:
        r71 = null;
        goto L83
    L72:
        if (r127.c() == false) goto L77;
        li.n r82 = new li.n(false, 7);
        r82.f19675a = true;
        Map r83 = r127.g();
        if (r83 != null) goto L76;
        r83 = MapsKt.emptyMap();
    L76:
        Intrinsics.checkNotNullParameter(r83, "<set-?>");
        r82.f19676b = r83;
        r82.f19677c = r127.b();
    L78:
        li.n r136 = pi.a.f21354a;
        Intrinsics.checkNotNullParameter(r82, "config");
        pi.a.f21355b = r82;
        goto L79
    L77:
        r82 = new li.n(false, 6);
        goto L78
    L68:
        r67 = null;
    L119:
        if (r123 == null) goto L121;
        com.bytedance.ies.bullet.base.settings.e r137 = r123.a();
    L122:
        if (r137 == null) goto L140;
        ((com.bytedance.ies.bullet.secure.d) com.bytedance.ies.bullet.secure.d.f5900a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r137, "config");
        int r138 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("GeckoLoaderSecureManager", "update GeckoLoaderSecure config, mode: " + r137.a(), null, 12);
        com.bytedance.ies.bullet.forest.c.f5394b.f4380c = r137.a();
        return;
    L140:
        return;
    L121:
        r137 = null;
        goto L122
    L45:
        r122 = null;
    L124:
        th = move-exception;
        throw th;
    L20:
        r46 = 4;
    L16:
        r114 = false;
        goto L17
    }
}
