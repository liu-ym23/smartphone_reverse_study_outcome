package com.bytedance.android.anniex.lite;

import android.app.Application;
import android.net.Uri;
import android.util.LruCache;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import b4.d;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.forest.h;
import com.bytedance.ies.bullet.forest.u;
import com.bytedance.ies.bullet.lynx.init.i;
import com.bytedance.ies.bullet.prefetchv2.o;
import com.google.android.material.timepicker.TimeModel;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.l;
import wc.g;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f3222a = null;

    static {
        f3222a = new LruCache(5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b4.c a(Uri r51, String r52, String r53) {
        Intrinsics.checkNotNullParameter(r52, "bid");
        Intrinsics.checkNotNullParameter(r51, "schema");
        Intrinsics.checkNotNullParameter(r53, "sessionId");
        com.bytedance.android.anniex.monitor.c.v(r52, r53);
        Intrinsics.checkNotNullParameter(r51, LynxResourceModule.URI_KEY);
        if (r51.isHierarchical() == true) goto L5;
        d r5 = new d(false, null, null, null, 0, 0, 0.0f, false, false, false, false, false, false, false, 0.0f, ViewCompat.MEASURED_SIZE_MASK);
        boolean r10 = true;
    L111:
        Intrinsics.checkNotNullParameter(r52, "bid");
        Intrinsics.checkNotNullParameter(r51, "schema");
        if (xq.b.t() == false) goto L149;
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r12 = (e) yc.a.a(e.class, "default_bid");
        if (r12 == null) goto L120;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L120;
        Boolean r14 = r13.b0();
        if (r14 == null) goto L120;
        boolean r15 = r14.booleanValue();
    L121:
        if (r15 == false) goto L149;
        ArrayList r16 = new ArrayList();
        tc.c r17 = tc.c.f22119c;
        if (((com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, r52)) == null) goto L126;
        List r18 = com.ivy.ivykit.plugin.impl.utils.b.d(new rb.b());
    L127:
        r16.addAll(CollectionsKt.m(r18));
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r19 = (e) yc.a.a(e.class, "default_bid");
        if (r19 == null) goto L134;
        xc.d r20 = (xc.d) r19.a(xc.d.class);
        if (r20 == null) goto L134;
        Boolean r21 = r20.h0();
        if (r21 == null) goto L134;
        boolean r22 = r21.booleanValue();
    L135:
        if (r22 == false) goto L137;
        com.bytedance.android.anniex.base.service.c.a(x3.c.class, r52);
    L137:
        ArrayList r23 = new ArrayList();
        Iterator r24 = r16.iterator();
    L139:
        if (r24.hasNext() == false) goto L146;
        Object r25 = r24.next();
        if ((r25 instanceof com.lynx.tasm.behavior.a) == false) goto L143;
        com.lynx.tasm.behavior.a r26 = (com.lynx.tasm.behavior.a) r25;
    L144:
        if (r26 == null) goto L139;
        r23.add(r26);
        goto L139
    L143:
        r26 = null;
        goto L144
    L146:
        boolean r27 = r23.isEmpty();
        List r28 = r23;
        if (r27 == true) goto L149;
    L150:
        if (r28 != null) goto L152;
        r28 = CollectionsKt.emptyList();
    L152:
        d r29 = d.a(r5, r28, null, 16769023);
        ConcurrentHashMap r30 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r31 = (e) yc.a.a(e.class, "default_bid");
        if (r31 == null) goto L155;
        xc.d r32 = (xc.d) r31.a(xc.d.class);
    L155:
        l r110 = new l(r52, r29);
        Intrinsics.checkNotNullParameter(r51, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r53, "sessionId");
        Intrinsics.checkNotNullParameter("annieXCard", "enterFrom");
        String r49 = "AnnieXLynxModelBuilder:buildInCompactMode";
        TraceEvent.c(r49);
        String r33 = com.bytedance.android.anniex.utils.e.c(r51, (String) r110.f19574b, r53);     // Catch: Throwable -> L170
        if (r33 != null) goto L159;
        String r34 = "";
    L161:
        if (r34.length() <= 0) goto L163;
        boolean r111 = r10;
    L165:
        if (r111 == false) goto L173;
        String r35 = io.reactivex.exceptions.a.h(r51, "ssr_mode");     // Catch: Throwable -> L170
        if (r35 != null) goto L169;
        r35 = "mix";
    L169:
        String r36 = r35;
        boolean r37 = r51.getBooleanQueryParameter("enable_element_tree_reuse", false);     // Catch: Throwable -> L170
        String r210 = com.bytedance.android.anniex.utils.e.j(r51);     // Catch: Throwable -> L170
        String r211 = r51.toString();     // Catch: Throwable -> L170
        d r38 = l.c(r110, r51);     // Catch: Throwable -> L170
        String r54 = r34;
        boolean r212 = Intrinsics.areEqual(r51.getQueryParameter("enable_preload"), "all");     // Catch: Throwable -> L170
        boolean r112 = r51.getBooleanQueryParameter("enable_lynx_predecode", false);     // Catch: Throwable -> L170
        if (r111 == true) goto L178;
    L181:
        boolean r213 = r111;
        String r113 = r15;
        g r39 = new g(r113);     // Catch: Throwable -> L170
        String r40 = (String) r110.f19574b;     // Catch: Throwable -> L170
        Intrinsics.checkNotNullParameter(r40, "<set-?>");     // Catch: Throwable -> L170
        r39.f22838c = r40;     // Catch: Throwable -> L170
        if (r210 != null) goto L184;
    L199:
        String r41 = r51.getQueryParameter("dynamic");     // Catch: Throwable -> L170
        if (r41 == null) goto L202;
        Integer r42 = StringsKt.toIntOrNull(r41);     // Catch: Throwable -> L170
    L203:
        r39.d = r42;     // Catch: Throwable -> L170
        if (r112 == true) goto L254;
        boolean r47 = r37;
        String r114 = null;
        String r115 = "dynamic";
        zm.c r43 = f.f5397a;     // Catch: Throwable -> L208
        boolean r116 = true;
        f.f(r211, r212, r53, PreloadType.f4333a, true, "AnnieX_card", r39);     // Catch: Throwable -> L208
    L214:
        if (r54.length() <= 0) goto L220;
        zm.c r44 = f.f5397a;     // Catch: Throwable -> L208
        g r45 = new g(r113);     // Catch: Throwable -> L208
        String r117 = r54;
        Intrinsics.checkNotNullParameter(r117, "<set-?>");     // Catch: Throwable -> L208
        r45.f22839h = r117;     // Catch: Throwable -> L208
        r45.f22850t = 5;     // Catch: Throwable -> L208
        r45.f22852v = false;     // Catch: Throwable -> L208
        r45.f22851u = MapsKt.mapOf(new Pair[]{TuplesKt.to("x-accept-engine-version", LynxEnv.inst().getSSRApiVersion()), TuplesKt.to("x-lynx-ssr-accept-type", "binary_v1")});     // Catch: Throwable -> L208
        String r46 = r51.getQueryParameter(r115);     // Catch: Throwable -> L208
        if (r46 == null) goto L218;
        Integer r48 = StringsKt.toIntOrNull(r46);     // Catch: Throwable -> L208
    L219:
        r45.d = r48;     // Catch: Throwable -> L208
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L208
        boolean r118 = false;
        f.g(r211, r212, r53, "AnnieX_card", r45, new h(r53, (String) r110.f19574b, r112, r212, 16));     // Catch: Throwable -> L208
    L221:
        Intrinsics.checkNotNullParameter(r51, "<this>");     // Catch: Throwable -> L208
        if (StringsKt.m(io.reactivex.exceptions.a.h(r51, "enable_prefetch"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L233;
        ConcurrentHashMap r55 = yc.a.f23246a;     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L208
        e r56 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L208
        if (r56 == null) goto L230;
        xc.d r57 = (xc.d) r56.a(xc.d.class);     // Catch: Throwable -> L208
        if (r57 == null) goto L230;
        Boolean r58 = r57.q0();     // Catch: Throwable -> L208
        if (r58 == null) goto L230;
        boolean r59 = r58.booleanValue();     // Catch: Throwable -> L208
    L231:
        if (r59 == false) goto L234;
        ExecutorService r60 = o.f5870a;     // Catch: Throwable -> L208
        String r61 = (String) r110.f19574b;     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter(r51, LynxResourceModule.URI_KEY);     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter(r61, "bid");     // Catch: Throwable -> L208
        o.b(r51, r61, null, null, null, 48);     // Catch: Throwable -> L208
        goto L233
    L234:
        ExecutorService r62 = o.f5870a;     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter(r51, LynxResourceModule.URI_KEY);     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter("default_bid", "bid");     // Catch: Throwable -> L208
        o.b(r51, "default_bid", null, null, null, 48);     // Catch: Throwable -> L208
    L230:
        r59 = r116;
    L233:
        boolean r119 = r213;
        TemplateData r63 = l.e(r110, r51, r53);     // Catch: Throwable -> L208
        if (r119 == false) goto L238;
        r114 = r117;
    L238:
        if (r114 != null) goto L242;
        if (r210 != null) goto L241;
        String r64 = r211;
    L243:
        String r65 = (String) r110.f19574b;     // Catch: Throwable -> L208
        if (r117.length() <= 0) goto L246;
        boolean r66 = r116;
    L247:
        b4.c r67 = new b4.c(r64, r51, r65, r63, r38, r53, r66, null);     // Catch: Throwable -> L208
        r67.f863i = r119;     // Catch: Throwable -> L208
        Intrinsics.checkNotNullParameter(r36, "<set-?>");     // Catch: Throwable -> L208
        r67.f864j = r36;     // Catch: Throwable -> L208
        r67.f865k = r47;     // Catch: Throwable -> L208
        com.bytedance.android.anniex.monitor.c.A(r53);     // Catch: Throwable -> L208
        TraceEvent.a(0, r49);
        f3222a.put(r53, r67);
        return r67;
    L246:
        r66 = r118;
        goto L247
    L241:
        r64 = r210;
        goto L243
    L242:
        r64 = r114;
        goto L243
    L218:
        r48 = r114;
        goto L219
    L220:
        r117 = r54;
        r118 = false;
        goto L221
    L254:
        zm.c r68 = f.f5397a;     // Catch: Throwable -> L210
        r115 = "dynamic";
        r47 = r37;
        r114 = null;
        f.g(r211, r212, r53, "AnnieX_card", r39, new u(r38.f880t, 2));     // Catch: Throwable -> L208
        r116 = true;
    L210:
        th = th;
        r49 = r49;
    L209:
        String r69 = r49;
    L250:
        TraceEvent.a(0, r69);
        throw th;
    L202:
        r42 = null;
        goto L203
    L184:
        if (r210.length() == 0) goto L199;
        if (Intrinsics.areEqual(r36, "mix") == true) goto L256;
    L197:
        String r70 = r210;
    L198:
        Intrinsics.checkNotNullParameter(r70, "<set-?>");     // Catch: Throwable -> L170
        r39.f22839h = r70;     // Catch: Throwable -> L170
        goto L199
    L256:
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L190
        Object r72 = Result.m124constructorimpl(Uri.parse(r210).buildUpon().appendQueryParameter("disable_cdn", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).build().toString());     // Catch: Throwable -> L190
    L193:
        if (Result.m130isFailureimpl(r72) == false) goto L195;
        r72 = null;
    L195:
        r70 = (String) r72;     // Catch: Throwable -> L170
        if (r70 != null) goto L198;
    L190:
        th = move-exception;
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L170
        r72 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        goto L193
    L178:
        if (Intrinsics.areEqual(r36, "mix") == true) goto L181;
        r47 = r37;
        r213 = r111;
        r113 = r15;
        r114 = null;
        r116 = true;
        r115 = "dynamic";
    L208:
        th = th;
        goto L209
    L173:
        r35 = r15;
        goto L169
    L163:
        r111 = false;
        goto L165
    L159:
        r34 = r33;
    L170:
        th = th;
        r69 = r49;
    L134:
        r22 = r10;
        goto L135
    L126:
        r18 = CollectionsKt.emptyList();
    L120:
        r15 = r10;
    L149:
        r28 = null;
        goto L150
    L5:
        HashMap r74 = new HashMap();
        if (r51.getBooleanQueryParameter("enable_lynx_config", false) == false) goto L14;
        Iterator<String> r75 = r51.getQueryParameterNames().iterator();
    L9:
        if (r75.hasNext() == false) goto L14;
        String r76 = r75.next();
        String r77 = r51.getQueryParameter(r76);
        if (k.o(r77) == false) goto L9;
        r74.put(r76, r77);
    L14:
        String r78 = r51.getQueryParameter("group");
        if (r78 != null) goto L17;
        r78 = "";
    L17:
        boolean r79 = r51.getBooleanQueryParameter("use_storage_group", false);
        boolean r80 = r51.getBooleanQueryParameter("enable_canvas", false);
        boolean r214 = r51.getBooleanQueryParameter("enable_canvas_optimize", false);
        boolean r120 = r51.getBooleanQueryParameter("enable_dynamic_v8", false);
        boolean r215 = r51.getBooleanQueryParameter("share_group", true);
        if (r80 == false) goto L23;
        if (Intrinsics.areEqual(r78, "-1") == true) goto L23;
        r78 = r78.concat("_canvas");
    L23:
        if (r79 == false) goto L26;
        com.lynx.tasm.u r81 = v0.i(r78, r215, r80, new String[]{"assets://bdlynx_core.js"}, r120, r214, true);
    L25:
        com.lynx.tasm.u r310 = r81;
        boolean r410 = r51.getBooleanQueryParameter("enable_code_cache", false);
        String r82 = r51.getQueryParameter("lynx_preset_height");
        String r83 = r51.getQueryParameter("lynx_preset_width");
        String r84 = r51.getQueryParameter("lynx_preset_height_spec");
        String r85 = r51.getQueryParameter("lynx_preset_width_spec");
        if (r83 != null) goto L50;
        if (r82 != null) goto L50;
        int r86 = 0;
        int r216 = 0;
    L56:
        if (r85 == null) goto L59;
        if (r84 == null) goto L59;
        int r311 = Integer.parseInt(r85);
        int r312 = Integer.parseInt(r84);
    L60:
        String r87 = r51.getQueryParameter("thread_strategy");
        if (r87 == null) goto L63;
        Integer r88 = Integer.valueOf(Integer.parseInt(r87));
    L64:
        ThreadStrategyForRendering r89 = ThreadStrategyForRendering.f10065b;
        if (r88 != null) goto L68;
    L70:
        ThreadStrategyForRendering r90 = ThreadStrategyForRendering.f10066c;
        if (r88 != null) goto L74;
    L76:
        r90 = ThreadStrategyForRendering.d;
        if (r88 != null) goto L80;
    L82:
        r90 = ThreadStrategyForRendering.e;
        if (r88 != null) goto L86;
    L88:
        ThreadStrategyForRendering r313 = r89;
    L89:
        boolean r91 = r51.getBooleanQueryParameter("enable_font_scale", false);
        String r92 = r51.getQueryParameter("font_scale");
        if (r91 == false) goto L94;
        if (r92 != null) goto L94;
        Application r93 = i.f5682a;
    L93:
        Float r94 = null;
    L97:
        if (r94 == null) goto L99;
        float r314 = r94.floatValue();
    L100:
        boolean r95 = r51.getBooleanQueryParameter("enable_view_zoom", false);
        String r96 = r51.getQueryParameter("view_zoom");
        if (r95 == false) goto L105;
        if (r96 != null) goto L105;
        Application r97 = i.f5682a;
    L104:
        Float r98 = null;
    L107:
        if (r98 == null) goto L109;
        float r411 = r98.floatValue();
    L110:
        boolean r315 = r51.getBooleanQueryParameter("create_view_async", false);
        r10 = true;
        String r316 = r78;
        r5 = new d(r51.getBooleanQueryParameter("preset_safe_point", false), r313, r310, r316, r312, r311, r314, r315, r51.getBooleanQueryParameter("enable_sync_flush", false), !r51.getBooleanQueryParameter("disable_auto_expose", false), r51.getBooleanQueryParameter("enable_pending_js_task", false), r51.getBooleanQueryParameter("air_strict_mode", false), r410, r51.getBooleanQueryParameter("enable_vsync_aligned_message_loop", false), r411, 2488832);
        goto L111
    L109:
        r411 = 1.0f;
    L105:
        if (r96 == null) goto L104;
        r98 = Float.valueOf(Float.parseFloat(r96));
        goto L107
    L99:
        r314 = 1.0f;
    L94:
        if (r92 == null) goto L93;
        r94 = Float.valueOf(Float.parseFloat(r92));
        goto L97
    L86:
        if (r88.intValue() != 3) goto L88;
    L87:
        r313 = r90;
        goto L89
    L80:
        if (r88.intValue() != 2) goto L82;
    L74:
        if (r88.intValue() != 1) goto L76;
    L68:
        if (r88.intValue() != 0) goto L70;
    L63:
        r88 = null;
    L59:
        r312 = r86;
        r311 = r216;
    L50:
        if (r83 == null) goto L52;
        r216 = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(r83), BasicMeasure.EXACTLY);
        int r99 = 0;
    L53:
        if (r82 == null) goto L55;
        r86 = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(r82), BasicMeasure.EXACTLY);
        goto L56
    L55:
        r86 = View.MeasureSpec.makeMeasureSpec(r99, r99);
        goto L56
    L52:
        r99 = 0;
        r216 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L53
    L26:
        if (r214 == false) goto L28;
        r81 = v0.i(r78, r215, r80, new String[]{"assets://bdlynx_core.js"}, r120, r214, false);
        goto L25
    L28:
        String[] r100 = {"assets://bdlynx_core.js"};
        Intrinsics.checkNotNullParameter(r78, "groupName");
        ConcurrentHashMap r101 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r102 = (e) yc.a.a(e.class, "default_bid");
        if (r102 == null) goto L35;
        xc.d r103 = (xc.d) r102.a(xc.d.class);
        if (r103 == null) goto L35;
        Boolean r104 = r103.v0();
        if (r104 == null) goto L35;
        boolean r105 = r104.booleanValue();
    L36:
        if (r105 == false) goto L39;
        r81 = com.bytedance.ies.bullet.lynx.init.d.a(r78, r215, r80, r100, r120, false);
        goto L25
    L39:
        if (Intrinsics.areEqual(r78, "-1") == false) goto L41;
        r81 = new com.lynx.tasm.u(r78, r78, r100, r80, r120, Boolean.FALSE, false);
        goto L25
    L41:
        if (r215 == false) goto L43;
        r81 = com.bytedance.ies.bullet.lynx.init.d.b(r78, r100, r80, r120);
        goto L25
    L43:
        String r217 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(com.lynx.tasm.u.g)});
        com.lynx.tasm.u.g++;
        r81 = new com.lynx.tasm.u(r78, r217, r100, r80, r120, Boolean.FALSE, false);
    L35:
        r105 = false;
        goto L36
    }
}
