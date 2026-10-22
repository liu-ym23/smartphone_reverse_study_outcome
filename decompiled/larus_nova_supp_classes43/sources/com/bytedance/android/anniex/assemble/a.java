package com.bytedance.android.anniex.assemble;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.android.anniex.container.holder.AnnieXSLFragmentHolder;
import com.bytedance.android.anniex.container.popup.AnnieXPopUpService;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.e0;
import com.bytedance.ies.bullet.service.base.f0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.AnnieXSL;
import com.lynx.tasm.group.c;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q26.f;
import q26.i;
import q26.k;
import s26.d;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static com.bytedance.ies.bullet.redirect.a b;
    public static final Object c = null;
    public static final Map<Integer, c> d = null;

    public a() {
    }

    static {
        a = new a();
        c = new Object();
        d = Collections.synchronizedMap(new LinkedHashMap());
    }

    public static LinkedHashMap e() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, WeakReference<ia.c>>> r1 = AnnieXContainerManager.INSTANCE.getAllContainer().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, WeakReference<ia.c>> r10 = r1.next();
        ia.c r11 = r10.getValue().get();
        if (r11 == null) goto L4;
        r0.put(r10.getKey(), new WeakReference(r11));
        goto L4
    L8:
        return r0;
    }

    @JvmStatic
    public static final void h() {
        AnnieXRuntime.a().getClass();
    }

    public static boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        return AnnieXContainerManager.closeContainerById$default(AnnieXContainerManager.INSTANCE, r10, false, 2, null);
    }

    public static ja.b b(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        com.bytedance.android.anniex.base.builder.b r0 = new com.bytedance.android.anniex.base.builder.b();
        r10.invoke(r0);
        if (r0.c.getBoolean("bundle_annie_x_salamander", false) == false) goto L6;
        return new AnnieXSLFragmentHolder(r0);
    L6:
        return new com.bytedance.android.anniex.container.holder.b(r0);
    }

    public static void d(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "application");
        ha.a r0 = (ha.a) AnnieXRuntime.a.getValue();
        if (r0 == null) goto L6;
        r0.initRelax(r1);
        return;
    }

    public static n26.a f(Application r10) {
        Intrinsics.checkNotNullParameter(r10, "application");
        if (b != null) goto L15;
        Object r0 = c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        boolean r1 = BulletSdk.a;     // Catch: Throwable -> L12
        BulletSdk.c(r10);     // Catch: Throwable -> L12
        b = new com.bytedance.ies.bullet.redirect.a();     // Catch: Throwable -> L12
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    L15:
        com.bytedance.ies.bullet.redirect.a r12 = b;
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    public final void c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        HybridLogger.m("XInit", "call ensureLynxInitialized", null, null, 12);
        boolean r0 = BulletSdk.a;
        if (BulletSdk.a == true) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (BulletSdk.a == true) goto L8;
        BulletSdk.c(r10);     // Catch: Throwable -> L11
    L8:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        d r12 = d.c;
        u26.c r13 = d.c.c(u26.c.class);
        if (r13 == null) goto L22;
        HybridLogger.m("XInit", "call initKit", null, null, 12);
        if (r13.i0() == true) goto L23;
        h r14 = h.h;
        r13.u(new q26.b("default_bid", new q26.a(r14.b, r14.a)));
        return;
    L23:
        return;
    }

    public static e g(String r1, Class r10) {
        Intrinsics.checkNotNullParameter(r1, "bid");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        AnnieXServiceCenter.a.getClass();
        return AnnieXServiceCenter.d(r1, r10);
    }

    public static /* synthetic */ void j(Context r1, Uri r10) {
        i(r1, r10, AnnieX$open$1.INSTANCE);
    }

    @Deprecated(message = "容器不保证使用此方法注入的端能力一定会生效", replaceWith = @ReplaceWith(expression = "IAnnieXHostDepend.createServiceProvider", imports = {}))
    public static void k(String r10, AnnieXServiceProvider r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "serviceProvider");
        AnnieXServiceCenter.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "serviceProvider");
        if (AnnieXServiceCenter.e().containsKey(r10) == false) goto L5;
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.i("XInit", "duplicate register ServiceProvider on bid=".concat(r10), null, 12);
        return;
    L5:
        AnnieXServiceCenter.e().put(r10, new AnnieXServiceCenter.a(r11));
    }

    public static boolean i(Context r28, Uri r29, Function1 r30) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r30, "block");
        b r10 = new b();
        r30.invoke(r10);
        if (r10.a != null) goto L5;
        AnnieXSL.a r1 = AnnieXSL.Companion;
        String r11 = r29.toString();
        r1.getClass();
        r10.a = Boolean.valueOf(AnnieXSL.a.a(r11));
    L5:
        String r12 = "default_bid";
        if (Intrinsics.areEqual(r10.b, "default_bid") == true) goto L8;
        r12 = r10.b;
    L10:
        String r13 = r12;
    L12:
        boolean r14 = BulletSdk.a;
        BulletSdk.c(r28);
        int r15 = com.bytedance.android.anniex.ability.a.a;
        com.bytedance.ies.bullet.service.base.router.config.b r16 = r10.c;
        Boolean r17 = r10.a;
        Boolean r18 = Boolean.TRUE;
        r16.e = Intrinsics.areEqual(r17, r18);
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "uri");
        Intrinsics.checkNotNullParameter(r16, "config");
        Intrinsics.checkNotNullParameter(r13, "bid");
        long r110 = System.currentTimeMillis();
        com.bytedance.android.anniex.utils.h r111 = new com.bytedance.android.anniex.utils.h();
        String r20 = com.bytedance.android.anniex.utils.c.getType(r29);
        String r21 = "flow";
        if (Intrinsics.areEqual(r20, "_popup") == false) goto L22;
        String r22 = w36.a.a(r29, "popup_type_opt");
        if (r22 == null) goto L17;
        r21 = r22;
    L21:
        Triple r23 = new Triple(r18, r21, Boolean.valueOf(com.bytedance.android.anniex.utils.c.a(r21)));
    L44:
        boolean r0 = ((Boolean) r23.component1()).booleanValue();
        String r24 = (String) r23.component2();
        if (((Boolean) r23.component3()).booleanValue() == false) goto L67;
        String r25 = w36.a.a(r29, "__bullet_trident_call_id");
        if (r25 != null) goto L49;
        r25 = "";
    L49:
        String r26 = i.b(r29, r16.a);
        Map<String, i36.d> r27 = MonitorManager.a;
        MonitorManager.e(r26, Long.valueOf(r110));
        SLMonitorCompat r31 = SLMonitorCompat.a;
        if (r0 == false) goto L52;
        SLMonitorCompat.ViewType r32 = SLMonitorCompat.ViewType.Popup;
    L53:
        String r33 = r32.getValue();
        r31.getClass();
        SLMonitorCompat.p(r26, r29, r33);
        String r34 = r13;
        ILitePageService r35 = (ILitePageService) g(r34, ILitePageService.class);
        if (r35 == null) goto L63;
        new Bundle();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        Bundle r36 = r16.a;
        r36.putString("__x_session_id", r26);
        r36.putString("__x_inner_schema", r29.toString());
        if (r0 == false) goto L58;
        r36.putString("popup_type_opt", r24);
    L59:
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        Intrinsics.checkNotNullParameter(r16.d, "<set-?>");
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        Object r37 = r16.a.get("bdx_act_request_code");
        if ((r37 instanceof Integer) == false) goto L62;
        Integer r38 = (Integer) r37;
    L62:
        Boolean r39 = Boolean.valueOf(r35.show());
    L65:
        if (Intrinsics.areEqual(r39, r18) == true) goto L106;
    L68:
        Map r40 = x26.a.a;
        g r41 = (g) x26.a.a(g.class);
        if (r41 == null) goto L75;
        w26.e r42 = (w26.e) r41.n0(w26.e.class);
        if (r42 == null) goto L75;
        Boolean r43 = r42.R1();
        if (r43 == null) goto L75;
        boolean r44 = r43.booleanValue();
    L76:
        if (r44 == false) goto L89;
        String r45 = UriProtector.getQueryParameter(r29, "enable_prefetch");
        if (Intrinsics.areEqual(r45, "1") == false) goto L80;
    L83:
        boolean r46 = true;
    L84:
        if (r46 == false) goto L89;
        ExecutorService r47 = BulletLogger.a;
        com.bytedance.ies.bullet.base.utils.logger.a r48 = null;
        BulletLogger.k("AnnieXRouterService.doOptimiseTask, enablePrefetch, currentUri=" + r29, null, null, 6);
        Lazy r49 = BulletContextManager.b;
        BulletContext r50 = BulletContextManager.c(BulletContextManager.a.a(), r34, r29, null);
        e0 r51 = f0.a();
        if (r51 == null) goto L91;
        r51.A(r29, r34, r50);
        r50.A = r29;
    L91:
        if (Intrinsics.areEqual(r34, "liveSaaS") == false) goto L94;
        g(r34, IAnnieXBizPropsProvider.class);
    L94:
        if (Intrinsics.areEqual(r20, "_page") == false) goto L97;
        f r52 = new com.bytedance.android.anniex.container.ui.f();
        Intrinsics.checkNotNullParameter(r34, "bid");
        ((s26.a) r52).a = r34;
    L100:
        HybridLogger r53 = HybridLogger.a;
        HybridLogger.m("XRouter", "get annieX ui service", MapsKt.mapOf(TuplesKt.to("uiType", r20)), r48, 8);
        k r54 = new k();
        r54.e = r48;
        Object r55 = r16.a.get("bdx_act_request_code");
        if ((r55 instanceof Integer) == false) goto L103;
        com.bytedance.ies.bullet.base.utils.logger.a r56 = (Integer) r55;
    L104:
        r54.f = r56;
        boolean r57 = r52.u0(r28, r29, r54);
        HybridLogger.m("XRouter", "AnnieXUIService show result", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RESULT, Boolean.valueOf(r57)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEME, r29.toString())}), r48, 8);
        return r57;
    L103:
        r56 = r48;
        goto L104
    L97:
        if (Intrinsics.areEqual(r20, "_popup") == false) goto L99;
        r52 = new AnnieXPopUpService();
        Intrinsics.checkNotNullParameter(r34, "bid");
        ((s26.a) r52).a = r34;
        goto L100
    L99:
        r52 = new com.bytedance.android.anniex.container.ui.f();
        Intrinsics.checkNotNullParameter(r34, "bid");
        ((s26.a) r52).a = r34;
        goto L100
    L80:
        if (Intrinsics.areEqual(r45, "true") == true) goto L83;
        r46 = false;
    L89:
        r48 = null;
    L75:
        r44 = false;
        goto L76
    L106:
        return r39.booleanValue();
    L58:
        r36.putString("page_type_opt", r111.a);
        goto L59
    L63:
        r39 = null;
        goto L65
    L52:
        r32 = SLMonitorCompat.ViewType.Page;
        goto L53
    L67:
        r34 = r13;
        goto L68
    L17:
        if (r16.e == true) goto L21;
        r21 = null;
        goto L21
    L22:
        String r58 = w36.a.a(r29, "page_type_opt");
        if (r58 != null) goto L35;
        Map r59 = x26.a.a;
        g r60 = (g) x26.a.a(g.class);
        if (r60 == null) goto L31;
        w26.e r61 = (w26.e) r60.n0(w26.e.class);
        if (r61 == null) goto L31;
        Boolean r62 = r61.v();
        if (r62 == null) goto L31;
        boolean r63 = r62.booleanValue();
    L32:
        if (r63 == false) goto L34;
        String r64 = "flow";
    L36:
        r111.a = r64;
        Boolean r65 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r111, "pageOptContainer");
        Intrinsics.checkNotNullParameter(r29, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        boolean r112 = com.bytedance.android.anniex.utils.c.e;
        String r113 = r64;
        if (com.bytedance.android.anniex.utils.c.b(r111, r29, r112, com.bytedance.android.anniex.utils.c.d, com.bytedance.android.anniex.utils.c.c, "flow") == true) goto L42;
        Intrinsics.checkNotNullParameter(r111, "pageOptContainer");
        Intrinsics.checkNotNullParameter(r29, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (com.bytedance.android.anniex.utils.c.b(r111, r29, r112, com.bytedance.android.anniex.utils.c.b, com.bytedance.android.anniex.utils.c.a, "lite_page") == true) goto L42;
        boolean r66 = false;
    L43:
        r23 = new Triple(r65, r113, Boolean.valueOf(r66));
    L42:
        r66 = true;
        goto L43
    L34:
        r64 = null;
    L31:
        r63 = true;
        goto L32
    L35:
        r64 = r58;
        goto L36
    L8:
        String r67 = UriProtector.getQueryParameter(r29, "bid");
        if (r67 == null) goto L10;
        r13 = r67;
        goto L12
    }
}
