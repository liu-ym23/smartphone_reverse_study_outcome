package com.ivy.ivykit.plugin.impl.utils;

import android.app.Application;
import com.bytedance.ies.bullet.base.c;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.google.common.reflect.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ivy.ivykit.api.plugin.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ul.d;
import w8.f;
import wc.e;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static c a(Application r29, String r30, String r31, d r32, h r33) {
        Intrinsics.checkNotNullParameter(r29, "application");
        Intrinsics.checkNotNullParameter(r30, "bid");
        Intrinsics.checkNotNullParameter(r31, "monitorBid");
        Intrinsics.checkNotNullParameter(r32, "geckoConfigs");
        Intrinsics.checkNotNullParameter(r33, "pluginConfig");
        boolean r10 = k5.d.f18612q;
        mb.b r11 = new mb.b();
        r11.f20055a = false;
        r11.f20056b = "YOUR_PREFIX";
        s6.b r12 = new s6.b(8);
        c r13 = new c(r29, r30);
        r13.f5180c = Boolean.valueOf(r10);
        Intrinsics.checkNotNullParameter(r11, "config");
        r13.d = r11;
        Intrinsics.checkNotNullParameter(r12, "log");
        rd.a r14 = new rd.a(r30);
        Intrinsics.checkNotNullParameter(r14, "config");
        r13.f = r14;
        String r16 = r32.getHost();
        String r18 = String.valueOf(0);
        ArrayList r17 = new ArrayList();
        String r19 = k5.d.f18606k;
        String r20 = k5.d.f18610o;
        GeckoConfig r5 = new GeckoConfig(((ul.c) r32.getAppConfigs().get(0)).getAccessKey(p.a()), ((ul.c) r32.getAppConfigs().get(0)).getRootDir(r29), new com.bytedance.ies.bullet.kit.resourceloader.c(), false, false, 16, null);
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r21 = r32.getAppConfigs().iterator();
    L4:
        if (r21.hasNext() == false) goto L6;
        ul.c r110 = (ul.c) r21.next();
        r15.put(r110.getAccessKey(p.a()), new GeckoConfig(r110.getAccessKey(p.a()), r110.getRootDir(r29), new com.bytedance.ies.bullet.kit.resourceloader.c(), false, false, 16, null));
        goto L4
    L6:
        com.bytedance.ies.bullet.kit.resourceloader.b r23 = new com.bytedance.ies.bullet.kit.resourceloader.b();
        tc.c r22 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r24 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r24 == null) goto L9;
        com.bytedance.ies.bullet.service.base.d r25 = (com.bytedance.ies.bullet.service.base.d) r24.f6163b.getValue();
    L9:
        e r26 = new e(r16, r17, r18, r19, r20, r5, r15, r23);
        Intrinsics.checkNotNullParameter(r26, "config");
        r13.e = r26;
        ld.a r27 = new ld.a();
        Intrinsics.checkNotNullParameter(r27, "config");
        r13.a(ld.b.class, new ld.b(r27));
        com.ivy.ivykit.plugin.impl.applet.e r28 = null;
        r13.a(com.bytedance.ies.bullet.service.webkit.c.class, new com.bytedance.ies.bullet.service.webkit.c(null, 3));
        r13.a(pb.a.class, new com.ivy.ivykit.plugin.impl.jsb.c(1));
        Intrinsics.checkNotNullParameter("bullet", "name");
        Intrinsics.checkNotNullParameter(r31, "tag");
        w r111 = new w("bullet", 11);
        if (r31 == null) goto L12;
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r111.f9377c = r31;
    L12:
        r13.a(i.class, new com.bytedance.ies.bullet.service.monitor.i(r111));
        if (r33.f9495a == false) goto L15;
        com.bytedance.ies.bullet.secure.e r34 = new com.bytedance.ies.bullet.secure.e();
        AnnieXInit$annieXInitConfig$1$2 r35 = AnnieXInit$annieXInitConfig$1$2.f9530a;
        Intrinsics.checkNotNullParameter(r35, "createDenyView");
        r34.f5901a = r35;
        AnnieXInit$annieXInitConfig$1$3 r36 = AnnieXInit$annieXInitConfig$1$3.f9531a;
        Intrinsics.checkNotNullParameter(r36, "createNoticeView");
        r34.f5902b = r36;
        r9.c r37 = new r9.c(8);
        Intrinsics.checkNotNullParameter(r37, "networkDepend");
        r34.f5903c = r37;
        SccConfig r38 = new SccConfig();
        r38.c(Boolean.valueOf(r33.f9495a));
        ArrayList r39 = new ArrayList();
        r39.add(IIvyAIPackageResourceService.HOST);
        Unit r112 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r39, "allowList");
        r38.d(r39);
        Intrinsics.checkNotNullParameter(r38, "sccConfig");
        r34.d = r38;
        Intrinsics.checkNotNullParameter(r34, "config");
        r13.f5182i = r34;
    L15:
        com.bytedance.ies.bullet.lynx.init.b r40 = new com.bytedance.ies.bullet.lynx.init.b(r29);
        com.bytedance.ies.bullet.lynx.init.i.f5683b = r10;
        Intrinsics.checkNotNullParameter(r29, "application");
        we.a r41 = new we.a();
        r41.f22857a = r29;
        Intrinsics.checkNotNullParameter(r41, "initImageConfig");
        r40.d = r41;
        sg.a r42 = new sg.a();
        r42.f21902a = r40;
        Application r43 = com.bytedance.ies.bullet.lynx.init.i.f5682a;
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        com.bytedance.ies.bullet.lynx.init.i.f5682a = r29;
        r13.a(com.bytedance.ies.bullet.lynx.d.class, new com.bytedance.ies.bullet.lynx.d(r42));
        r13.a(b.class, new b());
        r13.a(com.ivy.ivykit.plugin.impl.web.i.class, new com.ivy.ivykit.plugin.impl.web.i());
        com.bytedance.ies.bullet.settings.b r44 = new com.bytedance.ies.bullet.settings.b();
        ((com.bytedance.ies.bullet.service.base.d) r44.f6163b.getValue()).getClass();
        Unit r45 = Unit.INSTANCE;
        r13.a(com.bytedance.ies.bullet.settings.b.class, r44);
        ConcurrentHashMap r46 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        Object r47 = yc.a.a(xc.e.class, "default_bid");
        if ((r47 instanceof com.ivy.ivykit.plugin.impl.applet.e) == false) goto L18;
        r28 = (com.ivy.ivykit.plugin.impl.applet.e) r47;
    L18:
        if (r28 == null) goto L20;
        return r13;
    L20:
        String r48 = String.valueOf(0);
        String r49 = k5.d.f18610o;
        c5.a r50 = new c5.a(new xc.a(r48, k5.d.f18606k, r49, r49), new f());
        r50.f1118b = true;
        Intrinsics.checkNotNullParameter(r50, "config");
        r13.f5181h = r50;
        return r13;
    }
}
