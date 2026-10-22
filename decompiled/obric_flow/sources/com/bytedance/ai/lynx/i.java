package com.bytedance.ai.lynx;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.l0;
import com.lynx.tasm.navigator.NavigationModule;
import com.lynx.tasm.t;
import com.lynx.tasm.u;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static g a(Application r18, String r19, String r20, String r21, com.bytedance.ai.bridge.method.net.e r22) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "bid");
        BuildersKt.launch$default(h0.a(t2.b.f22090b), null, null, new AppletLynxViewApi$createLynxView$1(r19, null), 3, null);
        AtomicBoolean r10 = s0.a.f21798a;
        h5.b r11 = new h5.b();
        l0 r12 = LynxView.builder();
        t r13 = new t();
        r13.f10962b = true;
        r12.f10900c.f10894c = new u(r13);
        r12.a(NavigationModule.class, null, NavigationModule.NAME);
        r12.a(LynxViewMonitorModule.class, r11, "hybridMonitor");
        List<com.lynx.tasm.behavior.a> r14 = new XElementBehavior().create();
        r14.addAll(CollectionsKt.toList(com.ivy.ivykit.plugin.impl.render.c.f9523a.values()));
        r14.addAll(AISDKLynxBehaviorRegistry.getExtraBehaviors());
        r14.add(new com.bytedance.ai.applet.components.view.b("animax-view", false, false, false, 1));
        r12.f10898a = Float.valueOf(r18.getResources().getDisplayMetrics().density);
        r12.f10908o = r18.getResources().getConfiguration().fontScale;
        r12.c(r14);
        r12.f10915w = new d(r18, r20, r21);
        r12.b("EXTERNAL_JS_SOURCE", new e(r20, r21));
        Intrinsics.checkNotNull(r12);
        r22.invoke(r12);
        String r5 = UUID.randomUUID().toString();
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r5, "containerId");
        Intrinsics.checkNotNullParameter(r19, "bid");
        Intrinsics.checkNotNullParameter(r12, "lynxViewBuilder");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r15 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r18, r5);
        Intrinsics.checkNotNullParameter(r12, "lynxViewBuilder");
        r12.a(XBridgeLynxModule.class, r15, "bridge");
        g r16 = new g(r18, r5, r19, r12);
        r11.f17282a = r16;
        Intrinsics.checkNotNullParameter("aisdk_hybrid_bid", "bid");
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r17 = new com.obric.oui.constraintlayout.core.widgets.analyzer.f("aisdk_hybrid_bid", new com.bytedance.android.monitorV2.webview.a());
        r17.f12568b = false;
        r17.d = "AISDK";
        qo.a.h(r16, r17);
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        com.bytedance.android.monitorV2.lynx.d.e(r16, "container_name", "AISDK");
        com.bytedance.android.monitorV2.lynx.d.e(r16, "render_type", LynxMonitorService.DEFAULT_PID);
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AppletLynxViewApi$initMonitorConfig$1(r5, r16, null), 3, null);
        Intrinsics.checkNotNullParameter(r15, "lynxBDXBridge");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r23 = r16.e;
        String r24 = r16.f2182b;
        if (r23 == null) goto L10;
        Intrinsics.checkNotNullParameter(r24, "bid");
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r25 = r23.t();
        if (r25 == null) goto L9;
        rb.b r26 = (rb.b) r25.a(rb.b.class);
        if (r26 == null) goto L9;
        r26.f21717a.clear();
    L9:
        r23.r();
    L10:
        r16.e = r15;
        c(r15, r16, r16.f2181a, r24);
        return r16;
    }

    public static Object b(String r5, String r10, ContinuationImpl r11) {
        return BuildersKt.withContext(t2.b.f22089a, new AppletLynxViewApi$getTemplateBundle$2(r5, r10, null), r11);
    }

    public static void c(com.bytedance.sdk.xbridge.cn.platform.lynx.a r10, LynxView r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "lynxBdxBridge");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        Intrinsics.checkNotNullParameter(r13, "bid");
        r10.s(r11);
        Context r5 = r11.getContext();
        rb.b r14 = new rb.b();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r14.b(Context.class, new rb.a(r5));
        Intrinsics.checkNotNullParameter(LynxView.class, "clazz");
        r14.b(LynxView.class, new rb.a(r11));
        ib.d r15 = new ib.d(3);
        Intrinsics.checkNotNullParameter(de.d.class, "clazz");
        r14.b(de.d.class, new rb.a(r15));
        m.b r16 = new m.b(3);
        Intrinsics.checkNotNullParameter(de.b.class, "clazz");
        r14.b(de.b.class, new rb.a(r16));
        RefType r17 = RefType.f7473a;
        Intrinsics.checkNotNullParameter(rb.b.class, "clazz");
        Intrinsics.checkNotNullParameter(r17, "refType");
        cj.a r18 = r10.f7456h;
        List r19 = null;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r18 = null;
    L5:
        r18.getClass();
        Intrinsics.checkNotNullParameter(rb.b.class, "clazz");
        Intrinsics.checkNotNullParameter(r17, "refType");
        ConcurrentHashMap r20 = r18.d;
        cj.c r21 = new cj.c();
        r21.f1193b = r14;
        r20.put(rb.b.class, r21);
        s6.b r22 = new s6.b(3);
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r23 = r10.t();
        r23.getClass();
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r23.d.put(kj.c.class, new cj.c(r22));
        rb.b r24 = (rb.b) r10.t().a(rb.b.class);
        if (r24 == null) goto L8;
        r9.c r25 = new r9.c(3);
        Intrinsics.checkNotNullParameter(ee.a.class, "clazz");
        r24.b(ee.a.class, new rb.a(r25, 0));
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r24.b(kj.c.class, new rb.a(r22, 0));
        m r26 = new m(r10, r11, r12, r13);
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.container.e.class, "clazz");
        r24.b(com.bytedance.ies.bullet.core.container.e.class, new rb.a(r26, 0));
    L8:
        tc.c r110 = tc.c.f22119c;
        pb.a r111 = (pb.a) tc.c.f22119c.a(pb.a.class, r13);
        if (r111 == null) goto L24;
        boolean r112 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultLynxDelegate.onLynxViewCreated, createMethodFinder from ".concat(r111.getClass().getName()), null);
        rb.b r113 = (rb.b) r10.t().a(rb.b.class);
        if (r113 == null) goto L13;
        r19 = r111.c(r113);
    L13:
        if (r19 == null) goto L19;
        Iterator r114 = r19.iterator();
    L16:
        if (r114.hasNext() == false) goto L19;
        r10.g((com.bytedance.sdk.xbridge.cn.protocol.h) r114.next());
    L19:
        if ((r111 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L24;
        com.ivy.ivykit.plugin.impl.jsb.c r115 = (com.ivy.ivykit.plugin.impl.jsb.c) r111;
        rb.b r116 = (rb.b) r10.t().a(rb.b.class);
        if (r116 != null) goto L23;
        r116 = new rb.b();
    L23:
        Intrinsics.checkNotNullParameter(r116, "providerFactory");
    L24:
        j r117 = new j(0);
        Intrinsics.checkNotNullParameter(r117, "finder");
        ((List) r10.d.getValue()).add(0, r117);
    }
}
