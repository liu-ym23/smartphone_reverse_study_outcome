package com.bytedance.ies.bullet.lynx.impl;

import ai.p;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import androidx.core.app.NotificationCompat;
import av.i;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.core.j;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.q;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.google.gson.Gson;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.u;
import com.lynx.tasm.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile boolean f5654o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.lynx.d f5655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f5656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ies.bullet.ui.common.loader.c f5657c;
    public boolean d;
    public com.bytedance.sdk.xbridge.cn.platform.lynx.a e;
    public com.bytedance.ies.bullet.core.e f;
    public a0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f5658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f9.a f5659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinkedHashMap f5660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f5662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q7.a f5663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ies.bullet.lynx.c f5664n;

    public e(com.bytedance.ies.bullet.lynx.d r5, com.bytedance.ies.bullet.ui.common.loader.c r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        this.f5655a = r5;
        this.f5657c = r10;
        this.f5658h = new c(this);
        this.f5659i = new f9.a(6);
        this.f5662l = LazyKt.lazy(new DefaultLynxDelegate$argusAdapter$2(this));
        this.f5663m = new q7.a(3, this, false, r5);
    }

    public final rd.e a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        com.bytedance.ies.bullet.core.e r13 = this.f;
        if (r13 == null) goto L8;
        rd.e r14 = r13.g;
        if (r14 == null) goto L8;
        rd.b r15 = r14.f21723a;
        if (r15 == null) goto L8;
    L9:
        String r10 = "default_bid";
        if (xq.b.o() == false) goto L39;
        new ArrayList();
        com.bytedance.ies.bullet.core.e r5 = this.f;
        if (r5 == null) goto L14;
        com.lynx.tasm.utils.a.e(r5, r15);
        com.lynx.tasm.utils.a.m(r5, r15);
    L14:
        tc.c r16 = tc.c.f22119c;
        tc.c r17 = tc.c.f22119c;
        com.bytedance.ies.bullet.core.e r18 = this.f;
        if (r18 == null) goto L24;
        p r19 = r18.f5305t;
        if (r19 == null) goto L24;
        List r20 = (List) r19.f288c;
        if (r20 == null) goto L24;
        String r21 = (String) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L24;
        r10 = r21;
    L24:
        com.ivy.ivykit.plugin.impl.utils.b r22 = (com.ivy.ivykit.plugin.impl.utils.b) r17.a(com.ivy.ivykit.plugin.impl.utils.b.class, r10);
        Lazy r23 = com.bytedance.ies.bullet.service.sdk.d.e;
        i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r15, td.b.class);
        com.bytedance.ies.bullet.core.e r110 = this.f;
        if (r110 == null) goto L34;
        p r111 = r110.f5305t;
        if (r111 == null) goto L34;
        List r112 = (List) r111.f288c;
        if (r112 == null) goto L34;
        Iterator r113 = r112.iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        String r24 = (String) r113.next();
        tc.c r25 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.utils.b r26 = (com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, r24);
    L34:
        com.bytedance.ies.bullet.core.e r114 = this.f;
        if (r114 == null) goto L37;
        boolean r115 = sk.a.g(r114);
    L38:
        this.d = r115;
        boolean r116 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultLynxDelegate.generateSchemaModel, useXBridge3=" + this.d, null);
    L68:
        com.bytedance.ies.bullet.core.e r117 = this.f;
        if (r117 == null) goto L74;
        rd.e r118 = r117.g;
        if (r118 == null) goto L74;
        return r118;
    L74:
        Lazy r27 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r28 = i.e();
        String r119 = this.f5655a.f22117a;
        Uri r120 = Uri.parse(r11);
        r28.getClass();
        Intrinsics.checkNotNullParameter(r120, "url");
        return new rd.e(r28.a(r119, r120, false));
    L37:
        r115 = false;
        goto L38
    L39:
        Intrinsics.checkNotNullParameter(r15, "data");
        new ArrayList();
        Lazy r29 = com.bytedance.ies.bullet.service.sdk.d.e;
        i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r15, td.a.class);
        i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r15, td.c.class);
        tc.c r30 = tc.c.f22119c;
        tc.c r31 = tc.c.f22119c;
        com.bytedance.ies.bullet.core.e r32 = this.f;
        if (r32 == null) goto L49;
        p r33 = r32.f5305t;
        if (r33 == null) goto L49;
        List r34 = (List) r33.f288c;
        if (r34 == null) goto L49;
        String r35 = (String) CollectionsKt.firstOrNull(r34);
        if (r35 == null) goto L49;
        r10 = r35;
    L49:
        com.ivy.ivykit.plugin.impl.utils.b r36 = (com.ivy.ivykit.plugin.impl.utils.b) r31.a(com.ivy.ivykit.plugin.impl.utils.b.class, r10);
        i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r15, td.b.class);
        com.bytedance.ies.bullet.core.e r37 = this.f;
        if (r37 == null) goto L53;
        rd.e r38 = new rd.e(r15);
        Intrinsics.checkNotNullParameter(r38, "<set-?>");
        r37.g = r38;
    L53:
        com.bytedance.ies.bullet.core.e r121 = this.f;
        if (r121 == null) goto L63;
        p r122 = r121.f5305t;
        if (r122 == null) goto L63;
        List r123 = (List) r122.f288c;
        if (r123 == null) goto L63;
        Iterator r124 = r123.iterator();
    L61:
        if (r124.hasNext() == false) goto L63;
        String r39 = (String) r124.next();
        tc.c r40 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.utils.b r41 = (com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, r39);
    L63:
        com.bytedance.ies.bullet.core.e r125 = this.f;
        if (r125 == null) goto L66;
        boolean r126 = sk.a.g(r125);
    L67:
        this.d = r126;
        boolean r127 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultLynxDelegate.generateSchemaModel, useXBridge3=" + this.d, null);
        goto L68
    L66:
        r126 = false;
    L8:
        Lazy r128 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r129 = i.e();
        String r42 = this.f5655a.f22117a;
        Uri r43 = Uri.parse(r11);
        r129.getClass();
        Intrinsics.checkNotNullParameter(r43, "url");
        r15 = r129.a(r42, r43, false);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final Map b() {
        Map r5 = PropsUtilsKt.getDeviceProps(KitType.d, com.bytedance.ies.bullet.lynx.init.i.a(), this.f);
        if (r5 != null) goto L5;
        r5 = new LinkedHashMap();
    L5:
        r5.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());
        LinkedHashMap r10 = new LinkedHashMap();
        com.bytedance.ies.bullet.core.e r11 = this.f;
        String r12 = null;
        if (r11 == null) goto L8;
        Context r13 = r11.f5294h;
    L9:
        ConcurrentHashMap r14 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r15 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        ?? r16 = 0;
        r16 = 0;
        if (r15 == null) goto L16;
        xc.d r17 = (xc.d) r15.a(xc.d.class);
        if (r17 == null) goto L16;
        Boolean r18 = r17.L0();
        if (r18 == null) goto L16;
        boolean r19 = r18.booleanValue();
    L17:
        r10.putAll(PropsUtilsKt.getPageCommonProps(r13, r19));
        this.f5660j = r10;
        r10.put("containerVersion", "9.0.0");
        r10.put("containerType", "bullet");
        f r20 = d();
        if (r20 == null) goto L20;
        r20.c();
    L20:
        LinkedHashMap r21 = new LinkedHashMap();
        com.bytedance.ies.bullet.core.e r22 = this.f;
        if (r22 == null) goto L28;
        j r23 = r22.f5306u;
        if (r23 == null) goto L28;
        f r24 = (f) r23.f5320b;
        if (r24 == null) goto L28;
        LinkedHashMap r25 = r24.f5270a;
        Map r26 = r25;
        if (r25 == null) goto L28;
    L29:
        r21.putAll(r26);
        r21.put("protocolVersion", "1.0");
        com.bytedance.ies.bullet.core.e r110 = this.f;
        if (r110 == null) goto L44;
        String r111 = r110.getSessionId();
        if (r111 == null) goto L44;
        if (r111.length() > 0) goto L37;
        r111 = null;
    L37:
        if (r111 == null) goto L44;
        com.bytedance.ies.bullet.core.e r112 = this.f;
        if (r112 == null) goto L42;
        String r113 = r112.getSessionId();
        if (r113 == null) goto L42;
    L43:
        lc.a r114 = new lc.a(r113);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r114, "data");
        r10.put("containerID", r113);
        r10.put("protocolVersion", "1.0");
    L42:
        r113 = "";
    L44:
        Iterator r27 = MapsKt.toMap(r21).entrySet().iterator();
    L46:
        if (r27.hasNext() == false) goto L48;
        Map.Entry r28 = (Map.Entry) r27.next();
        r10.put(r28.getKey(), r28.getValue());
        goto L46
    L48:
        ConcurrentHashMap r29 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.prefetchv2.p.class, "cls");
        if (((com.bytedance.ies.bullet.prefetchv2.p) yc.a.a(com.bytedance.ies.bullet.prefetchv2.p.class, "default_bid")) == null) goto L116;
        com.bytedance.ies.bullet.core.e r30 = this.f;
        if (r30 == null) goto L116;
        Uri r31 = r30.A;
        if (r31 == null) goto L116;
        long r115 = System.currentTimeMillis();
        com.bytedance.ies.bullet.core.e r116 = this.f;
        if (r116 == null) goto L59;
        ad.a r117 = r116.f5303q;
        if (r117 == null) goto L59;
        String r118 = r117.a();
    L60:
        List r32 = com.bytedance.ies.bullet.prefetchv2.p.d(r31, r118, r30);
        if (r32.isEmpty() == true) goto L66;
        Iterator r119 = r32.iterator();
    L64:
        if (r119.hasNext() == false) goto L66;
        ((q) r119.next()).getClass();
    L66:
        String r33 = "Prefetch数据注入props耗时" + (System.currentTimeMillis() - r115) + " ms, uri: " + r31 + ", Props数量: " + r32.size();
        Intrinsics.checkNotNullParameter(r33, "message");
        if (r33 == null) goto L116;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPrefetch", r33, null, 12);
    L59:
        r118 = null;
    L116:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L74
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L77;
        boolean r35 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L74
        com.bytedance.ies.bullet.core.e r36 = this.f;     // Catch: Throwable -> L74
        if (r36 == null) goto L76;
        r12 = r36.getSessionId();     // Catch: Throwable -> L74
    L76:
        com.bytedance.ies.bullet.service.base.b.b(8, r12, "inject global props: " + new Gson().toJson(r10), "XLynxKit");     // Catch: Throwable -> L74
    L77:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L80:
        a0 r37 = this.g;
        if (r37 == null) goto L83;
        r10.put("geckoId", String.valueOf(r37.f));
        r10.put("geckoChannel", r37.s);
    L83:
        r10.put("isColdStart", Boolean.valueOf(this.f5661k));
        r10.put("useXBridge3", Boolean.valueOf(this.d));
        com.bytedance.ies.bullet.core.e r38 = this.f;
        if (r38 == null) goto L86;
        boolean r39 = sk.a.d(r38);
    L87:
        r10.put("usePiperData", Boolean.valueOf(r39));
        ConcurrentHashMap r40 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r41 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r41 == null) goto L94;
        xc.d r42 = (xc.d) r41.a(xc.d.class);
        if (r42 == null) goto L94;
        Boolean r43 = r42.A();
        if (r43 == null) goto L94;
        boolean r44 = r43.booleanValue();
    L95:
        if (r44 == false) goto L102;
        com.bytedance.ies.bullet.core.e r45 = this.f;
        if (r45 == null) goto L101;
        com.bytedance.ies.bullet.core.c r46 = r45.f5308w;
        if (r46 == null) goto L101;
        r16 = Intrinsics.areEqual(r46.f5275b, Boolean.TRUE);
    L101:
        r10.put("isPreload", Integer.valueOf(r16));
    L102:
        com.bytedance.ies.bullet.core.e r47 = this.f;
        if (r47 == null) goto L109;
        com.bytedance.ies.bullet.core.c r48 = r47.f5308w;
        if (r48 == null) goto L109;
        Map r49 = r48.f5277h;
        if (r49 == null) goto L109;
        r10.putAll(r49);
    L109:
        com.bytedance.ies.bullet.core.e r120 = this.f;
        if (r120 == null) goto L114;
        l r121 = r120.f5309x;
        if (r121 == null) goto L114;
        r10.put("res_from", r121.f5347b);
    L114:
        r5.putAll(r10);
        return r5;
    L94:
        r44 = true;
        goto L95
    L86:
        r39 = false;
    L74:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L28:
        r26 = MapsKt.emptyMap();
    L16:
        r19 = false;
        goto L17
    L8:
        r13 = null;
        goto L9
    }

    public final com.bytedance.ies.bullet.lynx.c c() {
        com.bytedance.ies.bullet.lynx.c r5 = new com.bytedance.ies.bullet.lynx.c();
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        boolean r12 = false;
        if (r11 == null) goto L9;
        xc.d r13 = (xc.d) r11.a(xc.d.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.B();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        r5.f5618a = r15;
        String r16 = null;
        boolean r17 = Intrinsics.areEqual(null, "forest");
        r5.f5624k = r17;
        if (r17 == false) goto L13;
        Intrinsics.checkNotNullParameter("disable", "<set-?>");
        Intrinsics.checkNotNullParameter("ttnet", "<set-?>");
    L13:
        LinkedHashMap r18 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r19 = this.f;
        if (r19 == null) goto L16;
        String r20 = r19.getSessionId();
    L17:
        r5.d = (ln.b) cd.a.a(r20).a(ln.b.class);
        com.bytedance.ies.bullet.core.e r21 = this.f;
        if (r21 == null) goto L24;
        j r22 = r21.f5306u;
        if (r22 == null) goto L24;
        ae.a r23 = (ae.a) r22.f5321c;
        if (r23 == null) goto L24;
        TemplateData r24 = com.lynx.tasm.utils.j.c(r23);
    L25:
        com.bytedance.ies.bullet.core.e r110 = this.f;
        if (r110 == null) goto L30;
        Boolean r111 = (Boolean) new vd.a(r110.g.f21723a, "enable_prefetch", Boolean.FALSE).f22372b;
        if (r111 == null) goto L30;
        r12 = r111.booleanValue();
    L30:
        if (r24 != null) goto L46;
        if (r12 == true) goto L46;
        com.bytedance.ies.bullet.lynx.d r25 = this.f5655a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.l.class, "clazz");
        tc.c r112 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.l.class, r25.f22117a) != null) goto L45;
        JSONObject r26 = new JSONObject();
        com.bytedance.ies.bullet.core.e r113 = this.f;
        if (r113 == null) goto L43;
        ad.a r114 = r113.f5303q;
        if (r114 == null) goto L43;
        Uri.parse(r114.a());
        com.bytedance.ies.bullet.lynx.d r115 = this.f5655a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.l.class, "clazz");
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.l.class, r115.f22117a) == null) goto L43;
        throw new ClassCastException();
    L43:
        String r27 = String.valueOf(r26);
        ae.a r28 = new ae.a();
        r28.f161b = r27;
        r24 = com.lynx.tasm.utils.j.c(r28);
        goto L46
    L45:
        throw new ClassCastException();
    L46:
        r5.e = r24;
        boolean r29 = true;
        r5.f = true;
        com.bytedance.ies.bullet.core.e r30 = this.f;
        if (r30 == null) goto L49;
        String r31 = r30.getSessionId();
    L50:
        r5.g = r31;
        com.bytedance.ies.bullet.core.e r32 = this.f;
        if (r32 == null) goto L118;
        Context r33 = r32.f5294h;
        if (r33 == null) goto L118;
        Display r116 = nb.a.e(r33);
        if (r116 == null) goto L118;
        Point r117 = new Point();     // Catch: Exception -> L63
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Exception -> L63
        xc.e r34 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Exception -> L63
        if (r34 == null) goto L65;
        xc.d r35 = (xc.d) r34.a(xc.d.class);     // Catch: Exception -> L63
        if (r35 == null) goto L65;
        Boolean r36 = r35.g();     // Catch: Exception -> L63
        if (r36 == null) goto L65;
        r29 = r36.booleanValue();     // Catch: Exception -> L63
    L65:
        if (r29 == false) goto L67;
        r116.getRealSize(r117);     // Catch: Exception -> L63
    L68:
        com.bytedance.ies.bullet.core.e r37 = this.f;     // Catch: Exception -> L63
        if (r37 == null) goto L73;
        rd.e r38 = r37.g;     // Catch: Exception -> L63
        if (r38 == null) goto L73;
        Intrinsics.areEqual(r37.f, "webcast");     // Catch: Exception -> L63
        com.lynx.tasm.base.a.i(r38);     // Catch: Exception -> L63
        Boolean r39 = Boolean.FALSE;     // Catch: Exception -> L63
    L75:
        if (Intrinsics.areEqual(r39, Boolean.TRUE) == false) goto L101;
        com.bytedance.ies.bullet.core.e r40 = this.f;     // Catch: Exception -> L63
        if (r40 == null) goto L79;
        String r41 = r40.f;     // Catch: Exception -> L63
    L80:
        if (r40 == null) goto L82;
        Context r42 = r40.f5294h;     // Catch: Exception -> L63
    L83:
        if (r40 == null) goto L85;
        rd.e r43 = r40.g;     // Catch: Exception -> L63
    L86:
        if (r40 == null) goto L88;
        Scenes r44 = r40.f5295i;     // Catch: Exception -> L63
    L89:
        Pair r45 = com.lynx.tasm.base.a.h(r41, r42, r43, r44, r33.getResources().getConfiguration());     // Catch: Exception -> L63
        Integer r46 = (Integer) r45.component1();     // Catch: Exception -> L63
        Integer r47 = (Integer) r45.component2();     // Catch: Exception -> L63
        if (r46 == null) goto L102;
        if (r47 == null) goto L102;
        Integer r48 = com.lynx.tasm.base.a.f10117b;     // Catch: Exception -> L63
        if (r48 == null) goto L95;
        int r49 = r48.intValue();     // Catch: Exception -> L63
    L96:
        r5.f5622i = r49;     // Catch: Exception -> L63
        Integer r50 = com.lynx.tasm.base.a.f10118c;     // Catch: Exception -> L63
        if (r50 == null) goto L99;
        int r51 = r50.intValue();     // Catch: Exception -> L63
    L100:
        r5.f5621h = r51;     // Catch: Exception -> L63
        goto L102
    L99:
        r51 = r47.intValue();     // Catch: Exception -> L63
        goto L100
    L95:
        r49 = r46.intValue();     // Catch: Exception -> L63
    L102:
        com.bytedance.ies.bullet.core.e r52 = this.f;     // Catch: Exception -> L63
        if (r52 == null) goto L111;
        p r53 = r52.f5305t;     // Catch: Exception -> L63
        if (r53 == null) goto L111;
        Bundle r54 = (Bundle) r53.f287b;     // Catch: Exception -> L63
        if (r54 == null) goto L111;
        int r55 = r54.getInt("split_width");     // Catch: Exception -> L63
        if (r55 <= 0) goto L111;
        r5.f5622i = r55;     // Catch: Exception -> L63
    L111:
        boolean r56 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Exception -> L63
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultLynxDelegate: screenWidth=" + r5.f5622i + ",screenHeight=" + r5.f5621h, null);     // Catch: Exception -> L63
        goto L118
    L88:
        r44 = null;
        goto L89
    L85:
        r43 = null;
        goto L86
    L82:
        r42 = null;
        goto L83
    L79:
        r41 = null;
        goto L80
    L101:
        r5.f5622i = r117.x;     // Catch: Exception -> L63
        r5.f5621h = r117.y;     // Catch: Exception -> L63
    L73:
        r39 = null;
        goto L75
    L67:
        r116.getSize(r117);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        boolean r57 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r58 = new StringBuilder(" on uri ");
        com.bytedance.ies.bullet.core.e r59 = this.f;
        if (r59 == null) goto L116;
        Uri r60 = r59.f5297k;
    L117:
        r58.append(r60);
        com.bytedance.ies.bullet.service.base.b.g(r58.toString(), "XLynxKit", e);
        goto L118
    L116:
        r60 = null;
    L118:
        String[] r118 = {"assets://bdlynx_core.js"};
        int r61 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPredefine", "show preloadJsFiles", MapsKt.mapOf(TuplesKt.to("preloadJSFiles", r118)), 8);
        if (xq.b.h() == false) goto L127;
        Intrinsics.checkNotNullParameter("", "groupName");
        Intrinsics.checkNotNullParameter("", "groupName");
        if (xq.b.h() == false) goto L123;
        r5.f5619b = com.bytedance.ies.bullet.lynx.c.a(r118);
    L134:
        LinkedHashMap r62 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r63 = this.f;
        if (r63 == null) goto L137;
        r16 = r63.getSessionId();
    L137:
        rb.b r64 = cd.a.a(r16);
        TemplateBundle r65 = (TemplateBundle) r64.a(TemplateBundle.class);
        if (r65 == null) goto L140;
        com.bytedance.ies.bullet.base.utils.logger.a.c("XLynxKit", "templateBundle from providerFactory");
        r5.f5623j = r65;
    L140:
        w r66 = (w) r64.a(w.class);
        a r67 = new a(this);
        Intrinsics.checkNotNullParameter(r67, "lynxClientDelegate");
        r5.f5625l.add(r67);
        return r5;
    L123:
        r5.f5620c = "";
        if (Intrinsics.areEqual("", "-1") == false) goto L126;
        r5.f5619b = new u("", "", r118, false, false, Boolean.FALSE, false);
        goto L134
    L126:
        r5.f5619b = com.bytedance.ies.bullet.lynx.init.d.c("", r118, false, false, false, false);
        goto L134
    L127:
        Intrinsics.checkNotNullParameter("", "groupName");
        if (xq.b.h() == false) goto L130;
        r5.f5619b = com.bytedance.ies.bullet.lynx.c.a(r118);
        goto L134
    L130:
        r5.f5620c = "";
        if (Intrinsics.areEqual("", "-1") == false) goto L133;
        r5.f5619b = new u("", "", r118, false, false, Boolean.FALSE, false);
        goto L134
    L133:
        r5.f5619b = com.bytedance.ies.bullet.lynx.init.d.b("", r118, false, false);
        goto L134
    L49:
        r31 = null;
    L24:
        r24 = null;
        goto L25
    L16:
        r20 = null;
    L9:
        r15 = false;
        goto L10
    }

    public final f d() {
        com.bytedance.ies.bullet.core.e r5 = this.f;
        f r10 = null;
        if (r5 == null) goto L7;
        j r11 = r5.f5306u;
        if (r11 == null) goto L7;
        f r12 = (f) r11.f5320b;
    L8:
        if (r12 == null) goto L14;
        if (r5 == null) goto L13;
        j r13 = r5.f5306u;
        if (r13 == null) goto L13;
        r10 = (f) r13.f5320b;
    L13:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ies.bullet.lynx.impl.LynxEngineGlobalConfig");
    L14:
        return r10;
    L7:
        r12 = null;
        goto L8
    }

    public final com.bytedance.ies.bullet.lynx.c e() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L7;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L7;
        boolean r12 = Intrinsics.areEqual(r11.a(), Boolean.TRUE);
    L8:
        if (r12 == false) goto L17;
        com.bytedance.ies.bullet.core.e r13 = this.f;
        if (r13 == null) goto L12;
        String r14 = r13.f;
    L14:
        if (Intrinsics.areEqual(r14, "webcast") == false) goto L17;
        return c();
    L12:
        r14 = null;
    L17:
        com.bytedance.ies.bullet.lynx.c r15 = this.f5664n;
        if (r15 == null) goto L21;
        Intrinsics.checkNotNull(r15);
        return r15;
    L21:
        com.bytedance.ies.bullet.lynx.c r16 = c();
        this.f5664n = r16;
        Intrinsics.checkNotNull(r16);
        return r16;
    L7:
        r12 = false;
        goto L8
    }
}
