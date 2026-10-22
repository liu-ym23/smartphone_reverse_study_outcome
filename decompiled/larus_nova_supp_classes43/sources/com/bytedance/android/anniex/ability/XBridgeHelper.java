package com.bytedance.android.anniex.ability;

import android.content.Context;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.utils.WebcastContainerInitializerInAnnieX;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.TraceEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class XBridgeHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a implements ue7.b {
        public final /* synthetic */ ra.a a;

        public final String a() {
            String r0 = UriProtector.getQueryParameter(this.a.b, com.bytedance.android.ec.core.event.a.KEY_APP_ID);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public a(ra.a r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static void d(String r10, LynxBDXBridge r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        if (r11 == null) goto L18;
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r12 = r11.D();
        if (r12 == null) goto L19;
        m16.b r13 = (m16.b) r12.getService(m16.b.class);
        if (r13 == null) goto L20;
        com.bytedance.android.anniex.assemble.a r0 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r1 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r10, IAnnieXContextProvider.class);
        if (r1 == null) goto L12;
        r1.W();
    L12:
        if (AnnieXSettings.a() == true) goto L16;
        s26.d r14 = s26.d.c;
        IAnnieXContextProvider r15 = (IAnnieXContextProvider) s26.d.c.d(r10, IAnnieXContextProvider.class);
        if (r15 == null) goto L16;
        r15.W();
    L16:
        r13.h();
        return;
    L20:
        return;
    L19:
        return;
    }

    public static LynxBDXBridge a(Context r10, ra.a r11, LynxViewBuilder r12) {
        String r0 = "webcast";
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        Intrinsics.checkNotNullParameter(r12, "lynxViewBuilder");
        TraceEvent.beginSection("XBridgeHelper:getLynxBridge");
    L25:
        th = move-exception;
        TraceEvent.endSection("XBridgeHelper:getLynxBridge");
        throw th;
    L4:
        if (Intrinsics.areEqual(r11.c, "webcast") == true) goto L8;
        r0 = "";
    L8:
        if (r11.k == true) goto L18;
        ra.a.C0191a r13 = r11.o;     // Catch: Throwable -> L25
        if (r13 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == true) goto L18;
        boolean r15 = false;
    L20:
        if (r15 != true) goto L22;
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r16 = new com.bytedance.sdk.xbridge.cn.platform.lynx.c(false);     // Catch: Throwable -> L25
        String r17 = r11.g;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r16, "optConfig");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r10, "context");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r17, "containerID");     // Catch: Throwable -> L25
        LynxBDXBridge r18 = new LynxBDXBridge(r10, r17);     // Catch: Throwable -> L25
        r18.G(r12);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r0, "<set-?>");     // Catch: Throwable -> L25
        r18.l = r0;     // Catch: Throwable -> L25
    L23:
        TraceEvent.endSection("XBridgeHelper:getLynxBridge");
        return r18;
    L22:
        r18 = new LynxBDXBridge(r10, r11.g);     // Catch: Throwable -> L25
        r18.G(r12);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r0, "<set-?>");     // Catch: Throwable -> L25
        r18.l = r0;     // Catch: Throwable -> L25
        goto L23
    L12:
        if (r13.a != true) goto L14;
        r14 = true;
    L18:
        r15 = true;
        goto L20
    }

    public static void b(final LynxBDXBridge r10, final AnnieXLynxView r11, final ra.a r12) {
        Intrinsics.checkNotNullParameter(r10, "lynxBdxBridge");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "lynxModel");
        if (Intrinsics.areEqual(r12.c, "Loki") == true) goto L5;
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.k(r12.g);
    L5:
        r10.E(r11);
        ra.a.C0191a r1 = r12.o;
        if (r1 == null) goto L10;
        boolean r13 = true;
        if (r1.e != true) goto L10;
    L11:
        if (r13 == false) goto L18;
        Function0<Unit> r14 = new XBridgeHelper$initBridge$1(r10, r11, r12);
        Intrinsics.checkNotNullParameter(r14, "block");
        if (r10.s != null) goto L15;
        r10.s = new ArrayList();
    L15:
        List r15 = r10.s;
        if (r15 == null) goto L20;
        ((ArrayList) r15).add(r14);
    L20:
        if (Intrinsics.areEqual(r12.c, "Loki") == true) goto L23;
        Map<String, i36.d> r16 = MonitorManager.a;
        MonitorManager.l(r12.g);
        return;
    L23:
        return;
    L18:
        c(r10, r11, r12);
    L10:
        r13 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(LynxBDXBridge r10, AnnieXLynxView r11, ra.a r12) {
        Context r1 = r11.getContext();
        m16.b r13 = new m16.b();
        r13.g(Context.class, r1);
        r13.g(LynxView.class, r11);
        r13.g(XBridgeMethod.b.class, new g(r11));
        r13.g(IDLXBridgeMethod.b.class, new h(r11));
        r10.x(m16.b.class, r13);
        com.bytedance.android.anniex.assemble.a r0 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXCustomActivityService r14 = (IAnnieXCustomActivityService) com.bytedance.android.anniex.assemble.a.g(r12.c, IAnnieXCustomActivityService.class);
        if (r14 == null) goto L5;
        r10.x(IAnnieXCustomActivityService.class, r14);
    L5:
        r10.x(ue7.b.class, new a(r12));
        k r15 = new k(r12, r11);
        r10.D().a(ue7.c.class, r15);
        m16.b r16 = (m16.b) r10.D().getService(m16.b.class);
        if (r16 != null) goto L8;
    L30:
        s26.d r17 = s26.d.c;
        k16.a r18 = (k16.b) s26.d.c.d(r12.c, k16.b.class);
        if (r18 == null) goto L54;
        m16.b r19 = (m16.b) r10.D().getService(m16.b.class);
        if (r19 == null) goto L35;
        List r20 = r18.L(r19);
    L36:
        if (r20 == null) goto L42;
        Iterator r21 = r20.iterator();
    L39:
        if (r21.hasNext() == false) goto L42;
        r10.d((MethodFinder) r21.next());
    L42:
        if ((r18 instanceof k16.a) == false) goto L54;
        m16.b r22 = (m16.b) r10.D().getService(m16.b.class);
        if (r22 != null) goto L46;
        r22 = new m16.b();
    L46:
        k16.a r23 = r18;
        MethodFinder r24 = r23.G0(r22);
        if (r24 == null) goto L50;
        r10.e(r24, 0);
    L50:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r12.b, "enable_annie_jsb_for_common"), "1") == false) goto L52;
        WebcastContainerInitializerInAnnieX.a(r12, r11, r10, r22);
    L52:
        Intrinsics.checkNotNullParameter(r22, "providerFactory");
        r23.H0(r22);
        goto L54
    L35:
        r20 = null;
    L54:
        if (com.bytedance.ies.bullet.service.base.h.j() == false) goto L67;
        s26.d r25 = s26.d.c;
        m0 r26 = s26.d.c.c(m0.class);
        if (r26 == null) goto L62;
        com.bytedance.ies.bullet.service.base.d r27 = r26.a0();
        if (r27 == null) goto L62;
        r10.F(false, r27.n);
    L62:
        if (Intrinsics.areEqual(r12.c, "webcast") == false) goto L66;
        r10.F(true, CollectionsKt.listOf(new com.bytedance.sdk.xbridge.cn.optimize.c(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}), SetsKt.hashSetOf(new String[]{"sendLogV3", "setStorage"}), 26)));
        return;
    L66:
        return;
    L67:
        return;
    L8:
        if (r12.k == true) goto L29;
        ra.a.C0191a r28 = r12.o;
        if (r28 != null) goto L12;
    L14:
        boolean r29 = false;
    L15:
        if (r29 == true) goto L29;
        if (r10.getContext() == null) goto L19;
        Intrinsics.checkNotNull(r10.getContext());
    L20:
        String r30 = r12.c;
        if (AnnieXSettings.a() == false) goto L23;
        IAnnieXContextProvider r31 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r30, IAnnieXContextProvider.class);
    L27:
        if (r31 == null) goto L29;
        r31.A0();
        goto L29
    L23:
        IAnnieXContextProvider r32 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r30, IAnnieXContextProvider.class);
        if (r32 != null) goto L26;
        s26.d r33 = s26.d.c;
        r31 = (IAnnieXContextProvider) s26.d.c.d(r30, IAnnieXContextProvider.class);
        goto L27
    L26:
        r31 = r32;
        goto L27
    L19:
        r11.getContext();
        goto L20
    L12:
        if (r28.a != true) goto L14;
        r29 = true;
    L29:
        r16.d(p56.b.class, new i(r12));
        r16.d(ue7.c.class, r15);
        r16.d(h16.e.class, new j(r12, r11, r10));
        goto L30
    }
}
