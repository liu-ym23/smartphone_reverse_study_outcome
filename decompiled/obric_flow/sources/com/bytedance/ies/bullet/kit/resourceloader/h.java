package com.bytedance.ies.bullet.kit.resourceloader;

import ai.j0;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5456c;
    public final List d;
    public String e;
    public wc.e f;
    public final LinkedHashMap g;

    public h() {
        this.f5454a = new ArrayList();
        this.f5455b = new ArrayList();
        this.d = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b, LoaderType.f5995c});
        this.g = new LinkedHashMap();
    }

    public static void e(h r10, String r11, a0 r12, wc.g r13, j r14) {
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r12, "resInfo");
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r14, "interval");
        Uri r5 = r12.f5932a;
        String r15 = null;
        if (r5.isHierarchical() == false) goto L5;
        Uri r16 = r5;
    L7:
        if (r16 == null) goto L18;
        String r17 = r16.getQueryParameter("disable_builtin");
        if (r17 == null) goto L11;
        Intrinsics.areEqual(r17, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L11:
        String r18 = r16.getQueryParameter("disable_offline");
        if (r18 == null) goto L14;
        Intrinsics.areEqual(r18, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        goto L18
    L14:
        String r19 = r16.getQueryParameter("disable_gecko");
        if (r19 == null) goto L18;
        Intrinsics.areEqual(r19, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L18:
        if (k.o(r13.f22839h) == false) goto L26;
        String r20 = i.d(r5, "need_common_params");
        dc.b.a("needCommonParams " + r20);
        if (r20 == null) goto L25;
        int r21 = com.bytedance.ies.bullet.secure.g.f5907a;
        if (com.bytedance.ies.bullet.secure.g.b(Uri.parse(r13.f22839h)) == false) goto L24;
        String r22 = Uri.parse(r13.f22839h).buildUpon().appendQueryParameter("need_common_params", r20).build().toString();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r13.f22839h = r22;
        goto L26
    L24:
        String r23 = m.n(Uri.parse(r13.f22839h), "need_common_params").buildUpon().appendQueryParameter("need_common_params", "0").build().toString();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r13.f22839h = r23;
        goto L26
    L25:
        String r24 = Uri.parse(r13.f22839h).buildUpon().appendQueryParameter("need_common_params", "0").build().toString();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r13.f22839h = r24;
    L26:
        String r25 = "";
        if (r13.f22836a.length() == 0) goto L80;
    L41:
        boolean r26 = false;
        if (r13.f.length() != 0) goto L45;
    L46:
        ConcurrentHashMap r27 = a.f5444a;
        if (r13.f22839h.length() <= 0) goto L49;
        r11 = r13.f22839h;
    L49:
        fc.a r28 = a.a(r11, r10.d(), r13.f22838c, false, r13);
        if (r28 != null) goto L52;
    L54:
        String r29 = null;
    L55:
        if (r29 != null) goto L57;
        r29 = "";
    L57:
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r13.f = r29;
        if (r28 != null) goto L60;
    L62:
        if (r15 == null) goto L65;
        r25 = r15;
    L65:
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r13.g = r25;
    L66:
        int r30 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r31 = MapsKt.mapOf(new Pair[]{TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r13.f), TuplesKt.to("bundle", r13.g), TuplesKt.to("skipGeckoInfo", Boolean.FALSE)});
        com.bytedance.ies.bullet.base.utils.logger.b r32 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r33 = r13.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r33, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("resourceSession", r33, r32.f5260a);
        Unit r34 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("show channel bundle", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "show channel bundle", r31, r32);
        if (Intrinsics.areEqual(r5.getQueryParameter("onlyLocal"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L69;
    L70:
        r26 = true;
    L71:
        r13.e = r26;
        r10.d().getClass();
        ug.d r35 = r12.f5950x;
        JSONObject r36 = (JSONObject) r35.d;
        if (r36 == null) goto L75;
        long r37 = SystemClock.uptimeMillis();
        long r38 = r37 - r14.f5459b;
        r14.f5459b = r37;
        r36.put("parse", r38);
    L75:
        if (k.o(r13.f22839h) == false) goto L77;
        String r39 = r13.f22839h;
    L78:
        r35.f22358c = r39;
        return;
    L77:
        r39 = k.i(r5);
        goto L78
    L69:
        if (r13.e == false) goto L71;
    L60:
        if (r28.f16890c == false) goto L62;
        r15 = r28.f16889b;
        goto L62
    L52:
        if (r28.f16890c == false) goto L54;
        r29 = r28.f16888a;
        goto L55
    L45:
        if (r13.g.length() != 0) goto L66;
    L80:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L33
        String r41 = r5.getQueryParameter("accessKey");     // Catch: Throwable -> L33
        if (r41 != null) goto L31;
        r41 = "";
    L31:
        Object r42 = Result.m124constructorimpl(r41);     // Catch: Throwable -> L33
    L36:
        if (Result.m130isFailureimpl(r42) == false) goto L38;
        r42 = "";
    L38:
        String r43 = (String) r42;
        Intrinsics.checkNotNullParameter(r43, "<set-?>");
        r13.f22836a = r43;
        if (r43.length() != 0) goto L41;
        String r44 = r10.d().f.getAccessKey();
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r13.f22836a = r44;
    L33:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r42 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L36
    L5:
        r16 = null;
        goto L7
    }

    public d a(final String r31, final wc.g r32, final Function1 r33, final Function1 r34) {
        Intrinsics.checkNotNullParameter(r31, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r32, "config");
        Intrinsics.checkNotNullParameter(r33, "resolve");
        Intrinsics.checkNotNullParameter(r34, "reject");
        String r5 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r32.f22848q = r5;
        final com.bytedance.ies.bullet.base.utils.logger.b r14 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r10 = r32.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("resourceSession", r10, r14.f5260a);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r31), TuplesKt.to("config", r32.toString()), TuplesKt.to("type", "async")});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("ResourceLoader start load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "ResourceLoader start load", r12, r14);
        wc.e r13 = d();
        long r26 = SystemClock.elapsedRealtime();
        Uri r15 = Uri.parse(r31);
        final j r16 = new j();
        String r17 = this.e;
        if (r17 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r17 = null;
    L6:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r32.f22838c = r17;
        final d r18 = new d();
        if (g.f5452b != null) goto L11;
        dc.b.b("ResourceLoader_Async service not init ");
        r34.invoke(new Throwable("resource loader service not init"));
        return r18;
    L11:
        if (r15.isHierarchical() == true) goto L14;
        dc.b.b("ResourceLoader_Async url: " + r15 + " is not hierarchical url ");
        r34.invoke(new Throwable("is not hierarchical url"));
        return r18;
    L14:
        Map r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r31), TuplesKt.to("taskConfig", r32.toString())});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("start async fetch", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "start async fetch", r19, r14);
        r13.getClass();
        this.f5456c = (this.f5456c + 1) % 10;
        ArrayList r20 = bc.a.f903a;
        Intrinsics.checkNotNullParameter(r31, "url");
        Intrinsics.checkNotNullParameter(r32, "config");
        Iterator r21 = bc.a.f904b.iterator();
        if (r21.hasNext() == true) goto L43;
        final a0 r110 = new a0(r15, null, null, null, false, 0, null, null, null, r26, 3070);
        int r22 = this.f5456c;
        ug.d r111 = r110.f5950x;
        if (r22 != 0) goto L19;
    L22:
        r111.d = new JSONObject();
    L23:
        String r23 = r32.f22840i;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r110.f5945r = r23;
        e(this, r31, r110, r32, r16);
        GeckoConfig r24 = r13.a(r32.f22836a);
        if (r13.f22831j == false) goto L26;
        final wc.g r25 = ((c) r24.getLoaderDepender()).c(r15, r32);
    L27:
        g(r15);
        i.d(r15, "memory_cache_priority");
        JSONObject r27 = (JSONObject) r111.d;
        if (r27 == null) goto L31;
        long r112 = SystemClock.uptimeMillis();
        long r113 = r112 - r16.f5459b;
        r16.f5459b = r112;
        r27.put("parse", r113);
    L31:
        com.bytedance.ies.bullet.kit.resourceloader.pipeline.a r114 = b(r15, r25);
        Map r28 = MapsKt.mapOf(new Pair[]{TuplesKt.to("loaderChain", r114.a()), TuplesKt.to("url", r31)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("loadAsync create loader chain", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "loadAsync create loader chain", r28, r14);
        Intrinsics.checkNotNullParameter(r114.a(), "<set-?>");
        JSONObject r29 = (JSONObject) r111.d;
        if (r29 == null) goto L36;
        long r115 = SystemClock.uptimeMillis();
        long r116 = r115 - r16.f5459b;
        r16.f5459b = r115;
        r29.put("create_pipeline", r116);
    L36:
        r110.f5939l = i.e(r110, r25);
        JSONObject r30 = (JSONObject) r111.d;
        if (r30 == null) goto L40;
        long r117 = SystemClock.uptimeMillis();
        long r35 = r117 - r16.f5459b;
        r16.f5459b = r117;
        r30.put("find_config", r35);
    L40:
        Map r36 = MapsKt.mapOf(new Pair[]{TuplesKt.to("resInfo", r110.toString()), TuplesKt.to("url", r31), TuplesKt.to("taskConfig", r32.toString())});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("loadAsync start load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "loadAsync start load", r36, r14);
        bc.a.a(r110, r25);
        e r118 = new e(r110, r25);
        r118.f5450c = true;
        r114.c(r118, new ResourceLoaderService$loadAsync$2(this, r18, r16, r32, r110, r25, r31, r14, r33), new ResourceLoaderService$loadAsync$3(r110, r16, this, r18, r32, r25, r31, r14, r34));
        this.g.put(r18, r114);
        return r18;
    L26:
        r25 = r32;
        goto L27
    L19:
        if (gc.e.b(r31, r13) == false) goto L22;
        r111.d = null;
        goto L23
    L43:
        throw androidx.constraintlayout.motion.widget.a.g(r21);
    }

    public final com.bytedance.ies.bullet.kit.resourceloader.pipeline.a b(Uri r10, wc.g r11) {
        ArrayList r5 = new ArrayList();
        ArrayList r12 = bc.a.f903a;
        if (r12.isEmpty() == true) goto L5;
        r5.addAll(r12);
    L5:
        List r13 = r11.f22837b.f22823c;
        if (r13 == null) goto L8;
        r5.addAll(r13);
    L8:
        r5.addAll(this.f5454a);
        int r14 = r5.size();
        if (r11.f22837b.f22822b.isEmpty() == false) goto L14;
        wc.a r15 = r11.f22837b;
        if (r15.f22821a == true) goto L14;
        List r16 = this.d;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.f22822b = r16;
    L14:
        if (g(r10) == false) goto L17;
        r5.add(cc.d.class);
    L17:
        if (g.e == null) goto L19;
        r5.add(com.bytedance.ies.bullet.preloadv2.a.class);
    L19:
        Iterator r17 = r11.f22837b.f22822b.iterator();
    L21:
        if (r17.hasNext() == false) goto L32;
        int r18 = ((LoaderType) r17.next()).ordinal();
        if (r18 != 0) goto L25;
        r5.add(cc.c.class);
        goto L21
    L25:
        if (r18 != 1) goto L27;
        r5.add(cc.a.class);
        goto L21
    L27:
        if (r18 != 2) goto L21;
        r5.add(cc.b.class);
        goto L21
    L32:
        r5.addAll(this.f5455b);
        ArrayList r19 = r11.f22837b.d;
        if (r19 == null) goto L35;
        int r20 = r5.size();
        r5.addAll(r19);
    L36:
        List r21 = r11.f22837b.e;
        if (r21 == null) goto L39;
        r5.removeAll(r21);
    L39:
        com.bytedance.ies.bullet.kit.resourceloader.pipeline.a r22 = new com.bytedance.ies.bullet.kit.resourceloader.pipeline.a(r5, this);
        r22.f5471c = r14;
        r22.d = r20;
        return r22;
    L35:
        r20 = -1;
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0 c(final String r32, wc.g r33) {
        Intrinsics.checkNotNullParameter(r32, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r33, "config");
        String r5 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r33.f22848q = r5;
        final com.bytedance.ies.bullet.base.utils.logger.b r12 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r10 = r33.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("resourceSession", r10, r12.f5260a);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r32), TuplesKt.to("config", r33.toString()), TuplesKt.to("type", "sync")});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("ResourceLoader start load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "ResourceLoader start load", r13, r12);
        long r24 = SystemClock.elapsedRealtime();
        final j r14 = new j();
        d().getClass();
        int r15 = this.f5456c + 1;
        d().getClass();
        this.f5456c = r15 % 10;
        String r16 = this.e;
        if (r16 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r16 = null;
    L6:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r33.f22838c = r16;
        if (g.f5452b != null) goto L10;
        dc.b.b("ResourceLoader_sync did not init yet");
        return null;
    L10:
        Uri r17 = Uri.parse(r32);
        if (r17.isHierarchical() == true) goto L14;
        return null;
    L14:
        if (r33.f22836a.length() == 0) goto L54;
    L29:
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        ArrayList r19 = bc.a.f903a;
        Intrinsics.checkNotNullParameter(r32, "url");
        Intrinsics.checkNotNullParameter(r33, "config");
        Iterator r110 = bc.a.f904b.iterator();
        if (r110.hasNext() == true) goto L53;
        final a0 r111 = new a0(r17, null, null, null, false, 0, null, null, null, r24, 3070);
        int r112 = this.f5456c;
        ug.d r113 = r111.f5950x;
        if (r112 == 0) goto L37;
        ArrayList r114 = gc.e.f17086a;
        if (gc.e.b(r32, d()) == false) goto L37;
        r113.d = null;
    L38:
        String r20 = r33.f22840i;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r111.f5945r = r20;
        e(this, r32, r111, r33, r14);
        GeckoConfig r21 = d().a(r33.f22836a);
        if (d().f22831j == false) goto L41;
        Uri r115 = r17;
        wc.g r22 = ((c) r21.getLoaderDepender()).c(r115, r33);
    L42:
        int r116 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r23 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r32), TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r22.f), TuplesKt.to("bundle", r22.g), TuplesKt.to("config", r33.toString())});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("show channel/bundle before load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "show channel/bundle before load", r23, r12);
        g(r115);
        i.d(r115, "memory_cache_priority");
        r111.f5939l = i.e(r111, r22);
        JSONObject r25 = (JSONObject) r113.d;
        if (r25 == null) goto L46;
        long r26 = SystemClock.uptimeMillis();
        long r117 = r26 - r14.f5459b;
        r14.f5459b = r26;
        r25.put("find_config", r117);
    L46:
        com.bytedance.ies.bullet.kit.resourceloader.pipeline.a r27 = b(r115, r22);
        Map r28 = MapsKt.mapOf(new Pair[]{TuplesKt.to("loaderChain", r27.a()), TuplesKt.to("url", r32)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("loadSync create loader chain", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "loadSync create loader chain", r28, r12);
        Intrinsics.checkNotNullParameter(r27.a(), "<set-?>");
        JSONObject r29 = (JSONObject) r113.d;
        if (r29 == null) goto L50;
        long r118 = SystemClock.uptimeMillis();
        long r30 = r118 - r14.f5459b;
        r14.f5459b = r118;
        r29.put("create_pipeline", r30);
    L50:
        Map r31 = MapsKt.mapOf(new Pair[]{TuplesKt.to("resInfo", r14.toString()), TuplesKt.to("url", r32)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("loadSync start load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "loadSync start load", r31, r12);
        final wc.g r34 = r22;
        bc.a.a(r111, r34);
        e r119 = new e(r111, r34);
        r119.f5450c = false;
        r27.c(r119, new ResourceLoaderService$loadSync$3(r18, r111, r14, r34, r32, r12, this), new ResourceLoaderService$loadSync$4(r32, r111, r34, r12, r14, this));
        Intrinsics.checkNotNullParameter(r111.f5951y.toString(), "<set-?>");
        return (a0) r18.element;
    L41:
        r115 = r17;
        r22 = r33;
    L37:
        r113.d = new JSONObject();
        goto L38
    L53:
        throw androidx.constraintlayout.motion.widget.a.g(r110);
    L54:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L18
        String r36 = r17.getQueryParameter("accessKey");     // Catch: Throwable -> L18
        if (r36 != null) goto L20;
        r36 = "";
    L20:
        Object r37 = Result.m124constructorimpl(r36);     // Catch: Throwable -> L18
    L23:
        String r120 = d().f.getAccessKey();
        if (Result.m130isFailureimpl(r37) == false) goto L26;
        r37 = r120;
    L26:
        String r38 = (String) r37;
        Intrinsics.checkNotNullParameter(r38, "<set-?>");
        r33.f22836a = r38;
        if (r38.length() != 0) goto L29;
        String r39 = d().f.getAccessKey();
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r33.f22836a = r39;
    L18:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r37 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public final wc.e d() {
        wc.e r5 = this.f;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void f(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        dc.b.a("deleteResource " + r5);
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L9;
        xc.d r12 = (xc.d) r11.a(xc.d.class);
        if (r12 == null) goto L9;
        Boolean r13 = r12.l0();
        if (r13 == null) goto L9;
        boolean r14 = r13.booleanValue();
    L10:
        if (r14 == true) goto L12;
    L14:
        ResourceFrom r15 = r5.d;
    L16:
        if (r15 != ResourceFrom.f5925a) goto L22;
        dc.b.a("deleteResource gecko");     // Catch: Throwable -> L19
        ec.a.f16815a.c(r5);     // Catch: Throwable -> L19
        wc.c r16 = d().a(r5.f5947u).getLoaderDepender();     // Catch: Throwable -> L19
        wc.g r17 = new wc.g(r5.f5947u);     // Catch: Throwable -> L19
        String r18 = r5.s;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Throwable -> L19
        r17.f = r18;     // Catch: Throwable -> L19
        ((c) r16).d(r17);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        if (r15 != ResourceFrom.f5927c) goto L38;
        dc.b.a("deleteResource cdn");
        String r19 = r5.f5933b;     // Catch: Throwable -> L30
        if (r19 == null) goto L39;
        File r20 = new File(r19);     // Catch: Throwable -> L30
        dc.b.a("deleteResource gecko " + r5.f5933b);     // Catch: Throwable -> L30
        if (r20.exists() == false) goto L40;
        r20.delete();     // Catch: Throwable -> L30
        return;
    L40:
        return;
    L39:
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        return;
    L38:
        return;
    L12:
        if ((r5 instanceof com.bytedance.ies.bullet.forest.m) == false) goto L14;
        r15 = ((com.bytedance.ies.bullet.forest.m) r5).B;
    L9:
        r14 = true;
        goto L10
    }

    public final boolean g(Uri r5) {
        String r10 = r5.getQueryParameter("__dev");
        if (Intrinsics.areEqual(r10, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == true) goto L16;
        if (r10 == null) goto L8;
        if (r10.length() == 0) goto L8;
    L10:
        String r11 = i.d(r5, "enable_memory_cache");
        if (k.o(r11) == false) goto L15;
        return Intrinsics.areEqual(r11, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L15:
        return d().f22830i;
    L8:
        if (g.f5453c == false) goto L10;
        return false;
    L16:
        return false;
    }

    public final LinkedHashMap h() {
        if (this.f == null) goto L54;
        String r5 = d().f.getAccessKey();
        GeckoConfig r12 = d().a(r5);
        wc.c r10 = r12.getLoaderDepender();
        String r13 = r12.getOfflineDir();
        c r11 = (c) r10;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "offlineDir");
        Intrinsics.checkNotNullParameter(r5, "accessKey");
        if (r11.f5446a != null) goto L7;
    L52:
        dc.b.b("RL实例未初始化，getPreloadConfigs未执行");
        return new LinkedHashMap();
    L7:
        if (r11.a().f == null) goto L52;
        wc.e r14 = r11.a().d();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "ak");
        GeckoConfig r15 = (GeckoConfig) r14.g.get(r5);
        if (r15 != null) goto L11;
        r15 = r14.f;
    L11:
        File r16 = r11.b(r13, r5, r15.isRelativePath());
        File r17 = new File(r16, r5);
        LinkedHashMap r18 = new LinkedHashMap();
        if (r17.isDirectory() == true) goto L14;
    L51:
        return r18;
    L14:
        if (r17.exists() == false) goto L51;
        File[] r19 = r17.listFiles();
        if (r19 == null) goto L51;
        int r20 = r19.length;
        int r21 = 0;
    L18:
        if (r21 >= r20) goto L51;
        File r22 = r19[r21];
        if (r22.isDirectory() == false) goto L50;
        String r23 = r16.getAbsolutePath();
        String r24 = r22.getName();
        if (TextUtils.isEmpty(r5) == false) goto L24;
    L38:
        Long r25 = null;
    L40:
        if (r25 == null) goto L42;
        long r26 = r25.longValue();
    L44:
        if (r26 <= 0) goto L50;
        StringBuilder r27 = new StringBuilder();
        r27.append(r22.getAbsolutePath());
        String r28 = File.separator;
        r27.append(r28);
        r27.append(r25);
        r27.append(r28);
        r27.append("res");
        File r29 = new File(j0.q(r27, r28, "preload.json"));
        if (r29.exists() == false) goto L50;
        if (r29.canRead() == false) goto L50;
        r18.put(r22.getName(), r29.getAbsolutePath());
        goto L50
    L42:
        r26 = 0;
        goto L44
    L24:
        if (TextUtils.isEmpty(r24) == true) goto L38;
        StringBuilder r30 = com.lynx.tasm.base.a.e("GeckoXDepender getLatestChannelVersion:rootdir:", r23, ",accessKey:", r5, ",channel:");
        r30.append(r24);
        dc.b.a(r30.toString());
        File r31 = new File(r23, r5);     // Catch: Throwable -> L30
        if (r31.exists() == true) goto L32;
        r31.mkdirs();     // Catch: Throwable -> L30
    L32:
        File r32 = new File(r31.getAbsolutePath(), r24);     // Catch: Throwable -> L30
        if (r32.exists() == true) goto L35;
        r32.mkdirs();     // Catch: Throwable -> L30
    L35:
        String[] r33 = r32.getAbsolutePath().split("/");     // Catch: Throwable -> L30
        String r34 = r33[r33.length - 2];     // Catch: Throwable -> L30
        String r35 = r33[r33.length - 1];     // Catch: Throwable -> L30
        r25 = com.bytedance.geckox.utils.d.a(r32);     // Catch: Throwable -> L30
        dc.b.a("getLatestChannelVersion:" + r25);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Intrinsics.checkNotNullParameter("getLatestChannelVersion failed", "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        dc.b.f16633a.a("[ResourceLoader] ".concat("getLatestChannelVersion failed"), th);
    L50:
        r21 = r21 + 1;
        goto L18
    L54:
        dc.b.b("ResourceLoaderConfig 实例未初始化，getPreloadConfigs未执行");
        return new LinkedHashMap();
    }
}
