package com.bytedance.android.anniex.api;

import android.net.Uri;
import android.os.Build;
import com.bytedance.android.anniex.ability.f;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.i;
import com.bytedance.ies.bullet.forest.w;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v26.l;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final Map<String, Object> b;
    public final ra.b c;
    public final boolean d;
    public Map<String, Object> e;

    public static final class a {
    }

    static {
    }

    public static final String b(d r10, Uri r11) {
        r10.getClass();
        TraceEvent.beginSection("AnnieXLynxModelBuilder:preBuild");
        String r1 = UUID.randomUUID().toString();     // Catch: Throwable -> L6
        Map<String, i36.d> r12 = MonitorManager.a;     // Catch: Throwable -> L6
        String r13 = r10.a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r13, "bid");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r1, "sessionId");     // Catch: Throwable -> L6
        MonitorManager.s(r13, r1, "AnnieXCard");     // Catch: Throwable -> L6
        MonitorManager.e0(r1, r11);     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        return r1;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        throw th;
    }

    public static final ra.b c(d r23, Uri r24) {
        r23.getClass();
        TraceEvent.beginSection("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        ra.b r10 = r23.c;     // Catch: Throwable -> L11
        if (r10.u == false) goto L9;
        r10 = ra.b.b(r10, false, null, null, null, 0, 0, 0.0f, false, false, null, false, null, null, false, false, false, k.a(r24), false, 0.0f, 14680063);     // Catch: Throwable -> L11
        if (h.Y() == false) goto L8;
        ra.b r11 = r23.c;     // Catch: Throwable -> L11
        r10.y = r11.y;     // Catch: Throwable -> L11
        r10.z = r11.z;     // Catch: Throwable -> L11
    L8:
        r10.A = r23.c.A;     // Catch: Throwable -> L11
    L9:
        TraceEvent.endSection("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        return r10;
    L11:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        throw th;
    }

    public d(String r28, Map r29, ra.b r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        String r1 = "default_bid";
    L7:
        if ((r31 & 2) == 0) goto L9;
        Map r10 = MapsKt.emptyMap();
    L11:
        if ((r31 & 4) == 0) goto L13;
        ra.b r11 = new ra.b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
    L14:
        Intrinsics.checkNotNullParameter(r1, "bid");
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        Intrinsics.checkNotNullParameter(r11, "lynxViewBuilderParams");
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = false;
        return;
    L13:
        r11 = r30;
        goto L14
    L9:
        r10 = r29;
        goto L11
    L5:
        r1 = r28;
        goto L7
    }

    public static final TemplateData a(d r10, Uri r11, String r12, Map r13) {
        r10.getClass();
        TraceEvent.beginSection("AnnieXLynxModelBuilder:mergeGlobalProps");
        HybridLogger r14 = HybridLogger.a;     // Catch: Throwable -> L40
        HybridLogger.m("AnnieX", "mergeGlobalProps:" + r12, null, null, 12);     // Catch: Throwable -> L40
        if (r10.e != null) goto L20;
        ConcurrentHashMap<String, Object> r15 = f.a;     // Catch: Throwable -> L40
        Map<String, Object> r16 = f.k(KitType.LYNX, r10.a);     // Catch: Throwable -> L40
        r16.put("useXBridge3", Boolean.TRUE);     // Catch: Throwable -> L40
        r16.put("usePiperData", Boolean.FALSE);     // Catch: Throwable -> L40
        if (h.G() == true) goto L12;
        Iterator<Map.Entry<String, Object>> r17 = r10.b.entrySet().iterator();     // Catch: Throwable -> L40
    L9:
        if (r17.hasNext() == false) goto L12;
        Map.Entry<String, Object> r18 = r17.next();     // Catch: Throwable -> L40
        r16.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L40
    L12:
        if (r16.get("osVersion") != null) goto L14;
    L18:
        List r19 = i16.a.a;     // Catch: Throwable -> L40
        String r20 = Build.VERSION.RELEASE;     // Catch: Throwable -> L40
        String r21 = "get osVersion by cache == null, osVersion is" + r20;     // Catch: Throwable -> L40
        HybridLogger.m("AnnieX", r21, null, null, 12);     // Catch: Throwable -> L40
        r16.put("osVersion", r20);     // Catch: Throwable -> L40
        com.bytedance.android.anniex.monitor.a.a(r21);     // Catch: Throwable -> L40
    L19:
        r10.e = r16;     // Catch: Throwable -> L40
        goto L20
    L14:
        if (String.valueOf(r16.get("osVersion")).length() != 0) goto L16;
        boolean r22 = true;
    L17:
        if (r22 == false) goto L19;
    L16:
        r22 = false;
    L20:
        TemplateData r0 = TemplateData.empty();     // Catch: Throwable -> L40
        Map<String, Object> r1 = r10.e;     // Catch: Throwable -> L40
        if (r1 == null) goto L32;
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L40
        r0.updateData(r1);     // Catch: Throwable -> L40
        if (h.G() == false) goto L25;
        r0.updateData(r10.b);     // Catch: Throwable -> L40
    L25:
        ConcurrentHashMap<String, Object> r23 = f.a;     // Catch: Throwable -> L40
        KitType r24 = KitType.LYNX;     // Catch: Throwable -> L40
        r0.updateData(f.s(r24, r11, r10.a, r12, r10.d));     // Catch: Throwable -> L40
        r0.put("containerID", r12);     // Catch: Throwable -> L40
        r0.put("monitorSessionID", r12);     // Catch: Throwable -> L40
        com.bytedance.android.anniex.assemble.a r110 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L40
        IAnnieXBizPropsProvider r111 = (IAnnieXBizPropsProvider) com.bytedance.android.anniex.assemble.a.g(r10.a, IAnnieXBizPropsProvider.class);     // Catch: Throwable -> L40
        if (r111 == null) goto L30;
        Map<String, Object> r25 = r111.b(r24, r10.a, r11);     // Catch: Throwable -> L40
        if (r25 == null) goto L30;
        r0.updateData(r25);     // Catch: Throwable -> L40
    L30:
        if (r13 == null) goto L32;
        r0.updateData(r13);     // Catch: Throwable -> L40
    L32:
        TraceEvent.beginSection("TemplateData:flush");     // Catch: Throwable -> L40
        r0.flush();     // Catch: Throwable -> L37
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L37
        TraceEvent.endSection("TemplateData:flush");     // Catch: Throwable -> L40
        TraceEvent.endSection("AnnieXLynxModelBuilder:mergeGlobalProps");
        return r0;
    L37:
        th = move-exception;
        TraceEvent.endSection("TemplateData:flush");     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:mergeGlobalProps");
        throw th;
    }

    public static ra.a j(d r21, byte[] r22, Uri r23, TemplateData r24) {
        Intrinsics.checkNotNullParameter(r22, "template");
        Intrinsics.checkNotNullParameter(r23, "uri");
        Intrinsics.checkNotNullParameter("annieXCard", "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
        AnnieXRuntime.a().getClass();     // Catch: Throwable -> L16
        String r17 = b(r21, r23);     // Catch: Throwable -> L16
        ra.b r10 = c(r21, r23);     // Catch: Throwable -> L16
        Map<String, Object> r11 = r21.b;     // Catch: Throwable -> L16
        if (r11 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        TemplateData r13 = null;
    L13:
        String r14 = r23.toString();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r22, "<this>");     // Catch: Throwable -> L16
        ra.a r15 = new ra.a(r14, r23, null, r13, null, r10, r17, r24, new ra.a.b(r22), false, true, null, "annieXCard", null, 27156);     // Catch: Throwable -> L16
        r15.r = false;     // Catch: Throwable -> L16
        Map<String, i36.d> r1 = MonitorManager.a;     // Catch: Throwable -> L16
        MonitorManager.t(r17);     // Catch: Throwable -> L16
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        return r15;
    L12:
        TemplateData r16 = TemplateData.empty();     // Catch: Throwable -> L16
        r16.updateData(r21.b);     // Catch: Throwable -> L16
        r13 = r16;
        goto L13
    L6:
        if (r11.isEmpty() == true) goto L9;
        r12 = false;
    L16:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        throw th;
    }

    public final ra.a d(Uri r10, TemplateData r11, Map r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r13, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:build");
        ra.a r14 = e(r10, true, r11, r12, false, r13);     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        return r14;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        throw th;
    }

    public static /* synthetic */ ra.a g(d r10, Uri r11, TemplateData r12, Map r13, int r14) {
        String r1 = null;
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        if ((r14 & 16) == 0) goto L12;
        r1 = "annieXCard";
    L12:
        return r10.d(r11, r12, r13, r1);
    }

    public static /* synthetic */ ra.a i(d r10, Uri r11, boolean r12, TemplateData r13, boolean r14, int r15) {
        String r1 = null;
        if ((r15 & 4) == 0) goto L5;
        TemplateData r16 = null;
    L7:
        if ((r15 & 32) == 0) goto L10;
        r1 = "annieXCard";
    L10:
        return r10.e(r11, r12, r16, null, r14, r1);
    L5:
        r16 = r13;
        goto L7
    }

    public final ra.a e(Uri r10, boolean r11, TemplateData r12, Map<String, ? extends Object> r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r15, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:build");
        ra.a r16 = h(this, r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        return r16;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        throw th;
    }

    public static ra.a h(d r12, Uri r13, boolean r14, TemplateData r15, Map r16, boolean r17, String r18) {
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "uri");
        Intrinsics.checkNotNullParameter(r18, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        throw th;
    L4:
        if (Intrinsics.areEqual(r12.a, "Loki") == false) goto L6;
        AnnieXRuntime.a().getClass();     // Catch: Throwable -> L9
        int r1 = com.bytedance.android.anniex.utils.f.a;     // Catch: Throwable -> L9
        ra.a r0 = com.bytedance.android.anniex.utils.f.a(r13, r12.a, r12.c, UUID.randomUUID().toString());     // Catch: Throwable -> L9
    L7:
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        return r0;
    L6:
        r0 = r12.f(r13, b(r12, r13), r14, r15, r16, r17, r18, true, null);     // Catch: Throwable -> L9
        goto L7
    }

    public final ra.a f(Uri r36, String r37, boolean r38, TemplateData r39, Map<String, ? extends Object> r40, boolean r41, String r42, boolean r43, Forest r44) {
        Intrinsics.checkNotNullParameter(r36, "uri");
        Intrinsics.checkNotNullParameter(r37, "sessionId");
        Intrinsics.checkNotNullParameter(r42, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
        AnnieXRuntime.a().getClass();     // Catch: Throwable -> L141
        TemplateData r0 = k.b(r36, this.a, r37);     // Catch: Throwable -> L141
        String r10 = "";
        if (r0 != null) goto L7;
    L13:
        TemplateData r13 = "";
    L16:
        if (r13.length() <= 0) goto L18;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L24;
        r10 = a36.b.e(r36, "ssr_mode");     // Catch: Throwable -> L141
        if (r10 != null) goto L24;
        String r12 = "mix";
    L25:
        if (r44 != null) goto L27;
        com.bytedance.ies.bullet.forest.f r14 = ForestLoader.a;     // Catch: Throwable -> L141
        Forest r15 = ForestLoader.d();     // Catch: Throwable -> L141
    L28:
        boolean r16 = r36.getBooleanQueryParameter("enable_element_tree_reuse", false);     // Catch: Throwable -> L141
        TemplateData r17 = k.c(r36);     // Catch: Throwable -> L141
        TemplateData r19 = r36.toString();     // Catch: Throwable -> L141
        ra.b r18 = c(this, r36);     // Catch: Throwable -> L141
        String r110 = "1";
        if (r38 == false) goto L82;
        boolean r23 = Intrinsics.areEqual(r36.getQueryParameter("enable_preload"), "all");     // Catch: Throwable -> L141
        boolean r22 = r36.getBooleanQueryParameter("enable_lynx_predecode", false);     // Catch: Throwable -> L141
        if (r11 == true) goto L35;
    L38:
        l r111 = new l();     // Catch: Throwable -> L141
        r111.b(this.a);     // Catch: Throwable -> L141
        if (r17 != null) goto L41;
    L44:
        boolean r20 = true;
    L45:
        if (r20 == false) goto L47;
    L59:
        String r1 = r36.getQueryParameter("dynamic");     // Catch: Throwable -> L141
        if (r1 == null) goto L62;
        Integer r21 = StringsKt.toIntOrNull(r1);     // Catch: Throwable -> L141
    L63:
        r111.f = r21;     // Catch: Throwable -> L141
        if (r22 == false) goto L66;
        com.bytedance.ies.bullet.forest.f r24 = ForestLoader.a;     // Catch: Throwable -> L141
        TemplateData r26 = r13;
        String r28 = "<set-?>";
        String r29 = "dynamic";
        Forest r310 = r15;
        TemplateData r25 = r26;
        boolean r27 = r11;
        TemplateData r30 = null;
        ForestLoader.n(r15, r19, r23, r37, PreloadType.LYNX, "AnnieX_card", r111, true, new w(r18.v, 2), 1024);     // Catch: Throwable -> L141
    L68:
        if (r25.length() <= 0) goto L70;
        boolean r112 = true;
    L71:
        if (r112 == false) goto L81;
        com.bytedance.ies.bullet.forest.f r31 = ForestLoader.a;     // Catch: Throwable -> L141
        if (r44 != null) goto L75;
        Forest r32 = ForestLoader.d();     // Catch: Throwable -> L141
    L76:
        PreloadType r113 = PreloadType.LYNX;     // Catch: Throwable -> L141
        l r114 = new l();     // Catch: Throwable -> L141
        TemplateData r115 = r25;
        String r116 = r28;
        Intrinsics.checkNotNullParameter(r115, r116);     // Catch: Throwable -> L141
        r114.k = r115;     // Catch: Throwable -> L141
        r114.E = 5;     // Catch: Throwable -> L141
        r114.G = false;     // Catch: Throwable -> L141
        r114.F = MapsKt.mapOf(new Pair[]{TuplesKt.to("x-accept-engine-version", LynxEnv.inst().getSSRApiVersion()), TuplesKt.to("x-lynx-ssr-accept-type", "binary_v1")});     // Catch: Throwable -> L141
        String r33 = r36.getQueryParameter(r29);     // Catch: Throwable -> L141
        if (r33 == null) goto L79;
        TemplateData r34 = StringsKt.toIntOrNull(r33);     // Catch: Throwable -> L141
    L80:
        r114.f = r34;     // Catch: Throwable -> L141
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L141
        String r311 = r116;
        TemplateData r210 = r115;
        ForestLoader.n(r32, r19, r23, r37, r113, "AnnieX_card", r114, true, new i(r37, this.a, r22, r23, 16), 1024);     // Catch: Throwable -> L141
    L83:
        if (r43 == false) goto L98;
        Intrinsics.checkNotNullParameter(r36, "<this>");     // Catch: Throwable -> L141
        if (StringsKt.equals$default(a36.b.e(r36, "enable_prefetch"), r110, false, 2, r30) == false) goto L98;
        Map r45 = x26.a.a;     // Catch: Throwable -> L141
        g r46 = (g) x26.a.a(g.class);     // Catch: Throwable -> L141
        if (r46 == null) goto L93;
        e r47 = (e) r46.n0(e.class);     // Catch: Throwable -> L141
        if (r47 == null) goto L93;
        Boolean r48 = r47.s1();     // Catch: Throwable -> L141
        if (r48 == null) goto L93;
        boolean r49 = r48.booleanValue();     // Catch: Throwable -> L141
    L94:
        if (r49 == false) goto L96;
        a0 r50 = a0.a;     // Catch: Throwable -> L141
        a0.e(r36, this.a, 2);     // Catch: Throwable -> L141
        goto L98
    L96:
        a0.e(r36, r30, 6);     // Catch: Throwable -> L141
    L93:
        r49 = true;
    L98:
        if (r41 == false) goto L126;
        Map<String, Object> r51 = this.b;     // Catch: Throwable -> L141
        if (r51 != null) goto L102;
    L105:
        boolean r117 = true;
    L106:
        if (r117 == false) goto L116;
        if (r40 != null) goto L109;
    L112:
        boolean r118 = true;
    L113:
        if (r118 == true) goto L115;
        TemplateData r52 = TemplateData.empty();     // Catch: Throwable -> L141
        r52.updateData(r40);     // Catch: Throwable -> L141
    L127:
        TemplateData r53 = r52;
    L128:
        if (r27 == false) goto L130;
        r30 = r210;
    L130:
        if (r30 != null) goto L134;
        if (r17 != null) goto L133;
        r30 = r19;
        goto L134
    L133:
        r30 = r17;
    L134:
        String r54 = this.a;     // Catch: Throwable -> L141
        if (r210.length() <= 0) goto L137;
        boolean r119 = true;
    L138:
        ra.a r120 = new ra.a(r30, r36, r54, r53, null, r18, r37, r39, null, r119, r41, null, r42, null, 26896);     // Catch: Throwable -> L141
        r120.p = r27;     // Catch: Throwable -> L141
        String r55 = r12;
        Intrinsics.checkNotNullParameter(r55, r311);     // Catch: Throwable -> L141
        r120.q = r55;     // Catch: Throwable -> L141
        r120.s = r16;     // Catch: Throwable -> L141
        r120.r = false;     // Catch: Throwable -> L141
        r120.t = r310;     // Catch: Throwable -> L141
        Map<String, i36.d> r56 = MonitorManager.a;     // Catch: Throwable -> L141
        MonitorManager.t(r37);     // Catch: Throwable -> L141
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        return r120;
    L137:
        r119 = false;
        goto L138
    L115:
        r53 = r30;
        goto L128
    L109:
        if (r40.isEmpty() == true) goto L112;
        r118 = false;
        goto L113
    L116:
        r52 = TemplateData.empty();     // Catch: Throwable -> L141
        r52.updateData(this.b);     // Catch: Throwable -> L141
        if (r40 != null) goto L119;
    L122:
        boolean r121 = true;
    L123:
        if (r121 == true) goto L127;
        r52.updateData(r40);     // Catch: Throwable -> L141
        goto L127
    L119:
        if (r40.isEmpty() == true) goto L122;
        r121 = false;
        goto L123
    L102:
        if (r51.isEmpty() == true) goto L105;
        r117 = false;
        goto L106
    L126:
        r52 = a(this, r36, r37, r40);     // Catch: Throwable -> L141
        goto L127
    L79:
        r34 = r30;
        goto L80
    L75:
        r32 = r44;
        goto L76
    L81:
        r210 = r25;
        r311 = r28;
        goto L83
    L70:
        r112 = false;
        goto L71
    L66:
        r28 = "<set-?>";
        r29 = "dynamic";
        r310 = r15;
        r27 = r11;
        r25 = r13;
        r30 = null;
        com.bytedance.ies.bullet.forest.f r57 = ForestLoader.a;     // Catch: Throwable -> L141
        ForestLoader.k(r310, r19, r23, r37, PreloadType.LYNX, true, "AnnieX_card", r111, 512);     // Catch: Throwable -> L141
        goto L68
    L62:
        r21 = null;
        goto L63
    L47:
        if (Intrinsics.areEqual(r12, "mix") == true) goto L146;
    L57:
        TemplateData r58 = r17;
    L58:
        r111.c(r58);     // Catch: Throwable -> L141
        goto L59
    L146:
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L50
        Object r60 = Result.constructor-impl(Uri.parse(r17).buildUpon().appendQueryParameter("disable_cdn", "1").build().toString());     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r60) == false) goto L55;
        r60 = null;
    L55:
        r58 = (String) r60;     // Catch: Throwable -> L141
        if (r58 != null) goto L58;
    L50:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L141
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L53
    L41:
        if (r17.length() == 0) goto L44;
        r20 = false;
        goto L45
    L35:
        if (Intrinsics.areEqual(r12, "mix") == true) goto L38;
        r28 = "<set-?>";
        r29 = "dynamic";
        r310 = r15;
        r27 = r11;
        r25 = r13;
        r30 = null;
        goto L68
    L82:
        r311 = "<set-?>";
        r18 = r18;
        r16 = r16;
        r310 = r15;
        r12 = r12;
        r27 = r11;
        r210 = r13;
        r110 = "1";
        r30 = null;
        goto L83
    L27:
        r15 = r44;
    L24:
        r12 = r10;
        goto L25
    L18:
        r11 = false;
        goto L20
    L7:
        if (com.bytedance.android.anniex.utils.i.a(r0) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L13;
        r13 = r0;
    L141:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        throw th;
    }
}
