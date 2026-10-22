package com.bytedance.ies.bullet.forest;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Scene[] f5408b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f5409c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zm.c f5410a;

    static {
        f5408b = new Scene[]{Scene.f4345a, Scene.f4351k};
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L7;
        com.bytedance.ies.bullet.base.settings.d r11 = (com.bytedance.ies.bullet.base.settings.d) r10.a(com.bytedance.ies.bullet.base.settings.d.class);
        if (r11 == null) goto L7;
        boolean r12 = Intrinsics.areEqual(r11.f(), Boolean.TRUE);
    L8:
        f5409c = r12;
        return;
    L7:
        r12 = false;
        goto L8
    }

    public k() {
        this.f5410a = new zm.c(3);
    }

    public final j a(String r23, boolean r24, String r25, Scene r26, String r27, wc.g r28) {
        Intrinsics.checkNotNullParameter(r23, "srcUrl");
        Intrinsics.checkNotNullParameter(r26, "scene");
        boolean r5 = ArraysKt.contains(f5408b, r26);
        zm.c r10 = this.f5410a;
        if (r5 == false) goto L5;
        Uri r11 = Uri.parse(r23);
    L23:
        if (r28 == null) goto L31;
        String r12 = r28.f22839h;
        if (r12 == null) goto L31;
        if (r12.length() > 0) goto L30;
        r12 = null;
    L30:
        if (r12 == null) goto L31;
    L42:
        if (r12 == null) goto L44;
        Uri r13 = Uri.parse(r12);
    L45:
        t r14 = new t(r23, r12);
        j r15 = (j) r10.e(r14, r27);
        if (r15 == null) goto L48;
        com.bytedance.forest.model.t r16 = r15.d;
    L49:
        if (r16 == null) goto L51;
        com.bytedance.forest.model.t r17 = new com.bytedance.forest.model.t(r16, r24);
        r17.H = r26;
    L52:
        if (r28 == null) goto L54;
        WebResourceRequest r18 = r28.s;
    L55:
        r17.f4425z = r18;
        if (r28 == null) goto L62;
        String r19 = r28.f22849r;
        if (r19 == null) goto L62;
        r12 = r12;
        r13 = r13;
        r14 = r14;
    L87:
        String r20 = "";
        if (r19 != null) goto L91;
        r19 = "";
    L91:
        Lazy r21 = r17.f4421v;
        ((Map) r21.getValue()).put("x-forest-injected-ua", r19);
        if (r28 == null) goto L96;
        Map r22 = r28.f22851u;
        if (r22 == null) goto L96;
        r17.E.putAll(r22);
    L96:
        String r29 = r17.f4406b;
        if (r29.length() > 0) goto L100;
        r29 = null;
    L100:
        if (r29 != null) goto L114;
        c r30 = c.f5393a;
        if (r28 == null) goto L104;
        String r31 = r28.f22838c;
    L105:
        ConcurrentHashMap r32 = c.f5395c;
        if (r31 != null) goto L108;
        r31 = "default_bid";
    L108:
        com.bytedance.forest.model.l r33 = (com.bytedance.forest.model.l) r32.get(r31);
        if (r33 == null) goto L111;
        r29 = r33.f4386b;
    L112:
        if (r29 != null) goto L114;
    L115:
        r17.f4406b = r20;
        if (r26 == Scene.f) goto L122;
        if (r28 == null) goto L119;
        boolean r34 = r28.f22852v;
    L120:
        if (r34 == false) goto L122;
        boolean r35 = true;
    L123:
        r17.g = r35;
        r17.f4410j = true;
        if (Intrinsics.areEqual(r25, "downloader") == false) goto L126;
        NetWorker r36 = NetWorker.f4466b;
    L127:
        r17.A = r36;
        if (r27 == null) goto L130;
        ((Map) r21.getValue()).put("rl_container_uuid", r27);
    L130:
        if (r15 == null) goto L141;
        if (r28 == null) goto L137;
        String r37 = r28.f22838c;
        if (r37 == null) goto L137;
        String r38 = r37;
    L139:
        return new j(r15.f5405a, r15.f5406b, r15.f5407c, r17, r5, r38, r27);
    L137:
        r38 = r7;
        goto L139
    L141:
        if (r11 != null) goto L144;
        if (r13 != null) goto L144;
        Uri r110 = r13;
    L300:
        if (r28 == null) goto L305;
        Integer r39 = r28.f22850t;
        if (r39 == null) goto L305;
    L318:
        int r40 = r39.intValue();
    L320:
        r17.C = r40;
        if (f5409c == false) goto L325;
        if (r11 == null) goto L325;
        String r41 = r11.getQueryParameter("forest_session_id");
    L326:
        r17.f4420u = r41;
        if (r5 == true) goto L340;
        if (r11 == null) goto L362;
        String r42 = r11.getQueryParameter("dynamic");
        if (r42 != null) goto L422;
    L337:
        boolean r43 = false;
    L338:
        r17.f = r43;
        goto L362
    L422:
        int r44 = Integer.parseInt(r42);     // Catch: Throwable -> L418
        if (r44 == 1) goto L336;
        if (r44 != 2) goto L337;
    L336:
        r43 = true;
    L362:
        ArrayList r45 = new ArrayList();
        if (r110 == null) goto L367;
        String r46 = r110.getQueryParameter("prefix");
        if (r46 == null) goto L367;
        r45.add(r46);
    L367:
        if (r11 == null) goto L371;
        String r47 = r11.getQueryParameter("prefix");
        if (r47 == null) goto L371;
        r45.add(r47);
    L371:
        if (r28 == null) goto L378;
        r45.addAll(r28.f22847p);
        jg.k r48 = r28.f22846o;
        if (r48 == null) goto L378;
        wc.b r49 = (wc.b) r48.b(wc.b.class);
        if (r49 == null) goto L378;
        r45.add(r49.f22824a);
    L378:
        if (r45.isEmpty() == true) goto L381;
        r17.e = r45;
    L381:
        if (r110 == null) goto L384;
        String r50 = r110.getQueryParameter("forest_key_include");
        if (r50 == null) goto L384;
    L387:
        if (r50 == null) goto L396;
        List r51 = StringsKt.K(r50, new String[]{","}, 0, 6);
        if (r51 == null) goto L396;
        if (r51.isEmpty() == false) goto L394;
        r51 = null;
    L394:
        if (r51 == null) goto L396;
        Set r52 = CollectionsKt.toSet(r51);
    L397:
        r17.F = r52;
        if (r110 == null) goto L403;
        String r53 = r110.getQueryParameter("forest_key_ua_include");
        if (r53 == null) goto L403;
        String r54 = r53;
    L406:
        r17.G = Intrinsics.areEqual(r54, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        if (r5 == false) goto L409;
        Intrinsics.checkNotNull(r11);
        r110 = r11;
    L410:
        if (r28 == null) goto L415;
        String r55 = r28.f22838c;
        if (r55 == null) goto L415;
        String r56 = r55;
    L416:
        j r57 = new j(r110, r23, r12, r17, r5, r56, r27);
        r10.l(r27, r14, r57);
        return r57;
    L415:
        r56 = r7;
        goto L416
    L409:
        Intrinsics.checkNotNull(r110);
    L403:
        if (r11 == null) goto L405;
        r54 = r11.getQueryParameter("forest_key_ua_include");
        goto L406
    L405:
        r54 = null;
    L396:
        r52 = null;
    L384:
        if (r11 == null) goto L386;
        r50 = r11.getQueryParameter("forest_key_include");
        goto L387
    L386:
        r50 = null;
        goto L387
    L340:
        if (com.lynx.tasm.behavior.utils.d.g(r12) == false) goto L362;
        if (r11 == null) goto L351;
        String r58 = r11.getQueryParameter("accessKey");
        if (r58 == null) goto L346;
        r17.f4406b = r58;
    L346:
        String r59 = r11.getQueryParameter(LynxMonitorService.KEY_CHANNEL);
        String r60 = r11.getQueryParameter("bundle");
        if (com.lynx.tasm.behavior.utils.d.g(r59) == false) goto L351;
        if (com.lynx.tasm.behavior.utils.d.g(r60) == false) goto L351;
        r17.f4407c = r59;
        r17.d = r60;
    L351:
        if (r11 == null) goto L362;
        String r61 = r11.getQueryParameter("dynamic");
        if (r61 != null) goto L420;
    L360:
        boolean r62 = false;
    L361:
        r17.f = r62;
        goto L362
    L420:
        int r63 = Integer.parseInt(r61);     // Catch: Throwable -> L419
        if (r63 == 1) goto L359;
        if (r63 != 2) goto L360;
    L359:
        r62 = true;
    L325:
        r41 = null;
    L305:
        if (r110 == null) goto L309;
        String r64 = r110.getQueryParameter("forest_max_age");
        if (r64 == null) goto L309;
        Integer r65 = StringsKt.toIntOrNull(r64);
    L310:
        if (r65 == null) goto L312;
        r39 = r65;
        goto L318
    L312:
        if (r11 == null) goto L316;
        String r66 = r11.getQueryParameter("forest_max_age");
        if (r66 == null) goto L316;
        r39 = StringsKt.toIntOrNull(r66);
    L317:
        if (r39 != null) goto L318;
        r40 = 0;
    L316:
        r39 = null;
    L309:
        r65 = null;
    L144:
        r110 = r13;
        if (r13 == null) goto L149;
        String r67 = r110.getQueryParameter("read_res_info_in_main");
        if (r67 == null) goto L149;
        boolean r68 = Intrinsics.areEqual(r67, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L154:
        r17.f4409i = r68;
        if (r110 == null) goto L159;
        String r69 = r110.getQueryParameter("disable_offline");
        if (r69 == null) goto L159;
        Boolean r70 = Boolean.valueOf(Intrinsics.areEqual(r69, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L164:
        Boolean r71 = Boolean.TRUE;
        if (Intrinsics.areEqual(r70, r71) == false) goto L167;
    L179:
        boolean r72 = true;
    L180:
        r17.f4413m = r72;
        if (Intrinsics.areEqual(r70, r71) == false) goto L183;
    L195:
        boolean r73 = true;
    L196:
        r17.f4412l = r73;
        if (r110 == null) goto L201;
        String r74 = r110.getQueryParameter("disable_cdn");
        if (r74 == null) goto L201;
    L204:
        boolean r75 = Intrinsics.areEqual(r74, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L206:
        r17.f4411k = r75;
        if (r110 == null) goto L211;
        String r76 = r110.getQueryParameter("disable_gecko_update");
        if (r76 == null) goto L211;
        boolean r77 = Intrinsics.areEqual(r76, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L216:
        r17.f4414n = r77;
        if (r110 == null) goto L221;
        String r78 = r110.getQueryParameter("only_local");
        if (r78 == null) goto L221;
    L224:
        boolean r79 = Intrinsics.areEqual(r78, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L226:
        r17.f4415o = r79;
        if (Intrinsics.areEqual(r70, r71) == false) goto L229;
    L242:
        boolean r80 = false;
    L243:
        r17.s = Boolean.valueOf(r80);
        if (r110 == null) goto L248;
        String r81 = r110.getQueryParameter("enable_memory_cache");
        if (r81 == null) goto L248;
        r71 = Boolean.valueOf(Intrinsics.areEqual(r81, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L252:
        r17.f4418r = r71;
        if (r110 == null) goto L257;
        String r82 = r110.getQueryParameter("ignore_wait_reused_request");
        if (r82 == null) goto L257;
        boolean r83 = Intrinsics.areEqual(r82, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L262:
        r17.f4424y = r83;
        if (r110 == null) goto L267;
        String r84 = r110.getQueryParameter("streaming_load");
        if (r84 == null) goto L267;
        boolean r85 = Intrinsics.areEqual(r84, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L272:
        if (r85 == false) goto L278;
        Scene r86 = r17.H;
        if (r86 != Scene.f4351k) goto L276;
    L277:
        boolean r87 = true;
    L279:
        r17.B = r87;
        if (r110 == null) goto L284;
        String r88 = r110.getQueryParameter("forest_buffer_mode");
        if (r88 == null) goto L284;
        boolean r89 = Intrinsics.areEqual(r88, "concurrent");
    L289:
        r17.f4408h = r89;
        if (r110 == null) goto L294;
        String r90 = r110.getQueryParameter("forest_newly_builtin");
        if (r90 == null) goto L294;
        boolean r91 = Intrinsics.areEqual(r90, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L299:
        r17.D = r91;
    L294:
        if (r11 == null) goto L298;
        String r92 = r11.getQueryParameter("forest_newly_builtin");
        if (r92 == null) goto L298;
        r91 = Intrinsics.areEqual(r92, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L298:
        r91 = false;
    L284:
        if (r11 == null) goto L288;
        String r93 = r11.getQueryParameter("forest_buffer_mode");
        if (r93 == null) goto L288;
        r89 = Intrinsics.areEqual(r93, "concurrent");
    L288:
        r89 = false;
        goto L289
    L276:
        if (r86 == Scene.f4352l) goto L277;
    L278:
        r87 = false;
    L267:
        if (r11 == null) goto L271;
        String r94 = r11.getQueryParameter("streaming_load");
        if (r94 == null) goto L271;
        r85 = Intrinsics.areEqual(r94, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L271:
        r85 = false;
    L257:
        if (r11 == null) goto L261;
        String r95 = r11.getQueryParameter("ignore_wait_reused_request");
        if (r95 == null) goto L261;
        r83 = Intrinsics.areEqual(r95, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L261:
        r83 = false;
    L248:
        if (r11 == null) goto L252;
        String r96 = r11.getQueryParameter("enable_memory_cache");
        if (r96 == null) goto L252;
        r71 = Boolean.valueOf(Intrinsics.areEqual(r96, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
        goto L252
    L229:
        if (r110 == null) goto L234;
        String r97 = r110.getQueryParameter("disable_cdn_cache");
        if (r97 == null) goto L234;
        boolean r98 = Intrinsics.areEqual(r97, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L238:
        boolean r99 = !r98;
    L240:
        if (r99 == false) goto L242;
        r80 = true;
    L234:
        if (r11 == null) goto L239;
        String r100 = r11.getQueryParameter("disable_cdn_cache");
        if (r100 == null) goto L239;
        r98 = Intrinsics.areEqual(r100, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L239:
        r99 = true;
    L221:
        if (r11 == null) goto L225;
        r78 = r11.getQueryParameter("only_local");
        if (r78 != null) goto L224;
    L225:
        r79 = false;
    L211:
        if (r11 == null) goto L215;
        String r101 = r11.getQueryParameter("disable_gecko_update");
        if (r101 == null) goto L215;
        r77 = Intrinsics.areEqual(r101, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L215:
        r77 = false;
    L201:
        if (r11 == null) goto L205;
        r74 = r11.getQueryParameter("disable_cdn");
        if (r74 != null) goto L204;
    L205:
        r75 = false;
        goto L206
    L183:
        if (r110 == null) goto L187;
        String r102 = r110.getQueryParameter("disable_builtin");
        if (r102 == null) goto L187;
        boolean r103 = Intrinsics.areEqual(r102, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L192:
        if (r103 == true) goto L195;
        r73 = false;
    L187:
        if (r11 == null) goto L191;
        String r104 = r11.getQueryParameter("disable_builtin");
        if (r104 == null) goto L191;
        r103 = Intrinsics.areEqual(r104, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L191:
        r103 = false;
        goto L192
    L167:
        if (r110 == null) goto L171;
        String r105 = r110.getQueryParameter("disable_gecko");
        if (r105 == null) goto L171;
        boolean r106 = Intrinsics.areEqual(r105, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L176:
        if (r106 == true) goto L179;
        r72 = false;
    L171:
        if (r11 == null) goto L175;
        String r107 = r11.getQueryParameter("disable_gecko");
        if (r107 == null) goto L175;
        r106 = Intrinsics.areEqual(r107, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L175:
        r106 = false;
    L159:
        if (r11 == null) goto L163;
        String r108 = r11.getQueryParameter("disable_offline");
        if (r108 == null) goto L163;
        r70 = Boolean.valueOf(Intrinsics.areEqual(r108, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L163:
        r70 = null;
    L149:
        if (r11 == null) goto L153;
        String r109 = r11.getQueryParameter("read_res_info_in_main");
        if (r109 == null) goto L153;
        r68 = Intrinsics.areEqual(r109, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L153:
        r68 = true;
        goto L154
    L126:
        r36 = NetWorker.f4465a;
        goto L127
    L119:
        r34 = true;
    L122:
        r35 = false;
        goto L123
    L111:
        r29 = null;
        goto L112
    L104:
        r31 = null;
    L114:
        r20 = r29;
    L62:
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread()) == true) goto L64;
    L68:
        r12 = r12;
        r13 = r13;
        r14 = r14;
        r19 = null;
        goto L87
    L64:
        if (r26 != Scene.f4351k) goto L66;
    L69:
        Forest r111 = f.a();
        if (r111 == null) goto L68;
        Application r112 = r111.getApplication();
        if (r112 == null) goto L68;
        if (r28 == null) goto L76;
        String r113 = r28.f22838c;
        if (r113 == null) goto L76;
    L77:
        Intrinsics.checkNotNullParameter(r112, "context");
        Intrinsics.checkNotNullParameter(r113, "bid");
        com.bytedance.ies.bullet.kit.web.j r114 = new com.bytedance.ies.bullet.kit.web.j();
        com.bytedance.ies.bullet.core.e r115 = new com.bytedance.ies.bullet.core.e();
        r115.C = true;
        r115.f = r113;
        r114.d(r115, CollectionsKt.emptyList());
        SSWebView r116 = new com.lynx.tasm.behavior.ui.utils.n(new com.bytedance.ies.bullet.service.webkit.c(null, 3)).l(r112);
        if (r114.e == null) goto L81;
        WebSettings r117 = r116.getSettings();
        rb.b r118 = new rb.b();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r118.b(Context.class, new rb.a(r112, 0));
        Unit r119 = Unit.INSTANCE;
        com.ivy.ivykit.plugin.impl.web.i.d(r117, r116, r118);
    L81:
        Iterator r120 = CollectionsKt.reversed(r114.f).iterator();
    L83:
        if (r120.hasNext() == false) goto L85;
        com.ivy.ivykit.plugin.impl.web.i r121 = (com.ivy.ivykit.plugin.impl.web.i) r120.next();
        WebSettings r122 = r116.getSettings();
        rb.b r123 = new rb.b();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        Iterator r210 = r120;
        r123.b(Context.class, new rb.a(r112, 0));
        Unit r124 = Unit.INSTANCE;
        r121.getClass();
        com.ivy.ivykit.plugin.impl.web.i.d(r122, r116, r123);
        r120 = r210;
        goto L83
    L85:
        r19 = r116.getSettings().getUserAgentString();
    L76:
        r113 = "default_bid";
        goto L77
    L66:
        if (r26 != Scene.f4352l) goto L68;
    L54:
        r18 = null;
        goto L55
    L51:
        r17 = new com.bytedance.forest.model.t(r26);
        goto L52
    L48:
        r16 = null;
        goto L49
    L44:
        r13 = null;
    L31:
        if (r5 == true) goto L33;
        r12 = r23;
    L34:
        if (r12 != null) goto L42;
        if (r11 == null) goto L37;
        r12 = r11.getQueryParameter("annie_x_url");
    L38:
        if (r12 != null) goto L42;
        if (r11 == null) goto L41;
        r12 = io.reactivex.exceptions.a.b(r11, "default_bid");
        goto L42
    L41:
        r12 = null;
        goto L42
    L37:
        r12 = null;
        goto L38
    L33:
        r12 = null;
        goto L34
    L5:
        ConcurrentHashMap r125 = zm.c.i((LinkedHashMap) r10.f23470b, r27, false);
        if (r125 == null) goto L21;
        Set r126 = r125.entrySet();
        if (r126 == null) goto L21;
        Iterator r127 = r126.iterator();
    L11:
        if (r127.hasNext() == false) goto L15;
        Object r128 = r127.next();
        if (((j) ((Map.Entry) r128).getValue()).e == false) goto L11;
    L16:
        Map.Entry r129 = (Map.Entry) r128;
        if (r129 == null) goto L21;
        j r130 = (j) r129.getValue();
        if (r130 == null) goto L21;
        r11 = r130.f5405a;
        goto L23
    L15:
        r128 = null;
    L21:
        r11 = null;
        goto L23
    }
}
