package com.bytedance.ies.bullet.service.monitor;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.core.p;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.google.common.base.u;
import com.google.common.reflect.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.base.TraceEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;
import ym.k;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends b implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static com.bytedance.ies.bullet.lynx.d f6044p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final id.c f6045c;
    public final id.a d;
    public final id.c e;
    public final id.a f;
    public final id.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final id.a f6046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ba.a f6047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final id.b f6048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f6049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference f6050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f6052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s6.c f6053o;

    public h() {
        this.f6045c = new id.c(1);
        this.d = new id.a(1);
        this.e = new id.c(1);
        this.f = new id.a(1);
        this.g = new id.c(1);
        this.f6046h = new id.a(1);
        this.f6047i = new ba.a(1);
        this.f6048j = new id.b(1);
        this.f6049k = new g(this);
        this.f6052n = new AtomicInteger(0);
        this.f6053o = new s6.c(6);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void A() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("render_template_end", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "render_template_end", null, r10);
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("render_template_end", STGroup.DICT_KEY);
        r11.a("render_template_end", Long.valueOf(System.currentTimeMillis()));
        com.lynx.tasm.utils.a.f(r11, "render_template_start", "render_template_end", this.d, "render_template_main");
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void B() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("prepare_template_start", "msg");
        KitType r11 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "prepare_template_start", null, r10);
        long r12 = System.currentTimeMillis();
        if (this.f6045c.c("prepare_template_start") == true) goto L9;
        id.c r13 = this.f6045c;
        r13.getClass();
        Intrinsics.checkNotNullParameter("prepare_template_start", STGroup.DICT_KEY);
        r13.a("prepare_template_start", Long.valueOf(System.currentTimeMillis()));
        ExecutorService r14 = d.f6039a;
        d.a(q(), "prepare_template_start", Long.valueOf(r12));
        String r15 = q();
        if (u8.a.q(o()) == false) goto L7;
        String r16 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L8:
        d.b(r15, "enableForest", r16);
        goto L9
    L7:
        r16 = "0";
    L9:
        ad.a r17 = o().f5303q;
        if (r17 == null) goto L13;
        r11 = r17.b();
    L13:
        if (r11 != KitType.d) goto L21;
        this.d.a("kitcreate_to_rl", Long.valueOf(this.f6045c.f("prepare_component_end", "prepare_template_start")));
        if (k.a() == null) goto L18;
        Intrinsics.checkNotNullParameter("resource_load", "sectionName");
        TraceEvent.c("resource_load");
    L18:
        if (k.a() == null) goto L22;
        Intrinsics.checkNotNullParameter("download_template", "sectionName");
        TraceEvent.c("download_template");
        return;
    L22:
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void C() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("prepare_template_end", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "prepare_template_end", null, r10);
        long r11 = System.currentTimeMillis();
        id.c r12 = this.f6045c;
        if (r12.c("prepare_template_end") == true) goto L5;
        r12.getClass();
        Intrinsics.checkNotNullParameter("prepare_template_end", STGroup.DICT_KEY);
        r12.a("prepare_template_end", Long.valueOf(System.currentTimeMillis()));
        ExecutorService r13 = d.f6039a;
        d.a(q(), "prepare_template_end", Long.valueOf(r11));
        Regex r14 = hd.b.f17301a;
        hd.b.b(o(), "download_template");
    L5:
        ExecutorService r15 = d.f6039a;
        d.a(q(), "template_res_type", o().f5309x.f5347b);
        Long r16 = Long.valueOf(r12.f("prepare_template_start", "prepare_template_end"));
        this.d.a("download_template", r16);
        if (k.a() == null) goto L8;
        Intrinsics.checkNotNullParameter("download_template", "sectionName");
        TraceEvent.a(0, "download_template");
    L8:
        com.bytedance.ies.bullet.core.k r17 = o().d;
        LoadStage r18 = LoadStage.d;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r17.e = r18;
        com.bytedance.ies.bullet.core.k r19 = o().d;
        r19.getClass();
        Intrinsics.checkNotNullParameter("load_template_end", "<set-?>");
        r19.f = "load_template_end";
        String r20 = q();
        long r21 = o().f5309x.d;
        String r22 = o().f5309x.f5347b;
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        Intrinsics.checkNotNullParameter(r22, "resFrom");
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void D() {
        Log.i("Monitor-Callback", q() + " onSchemaPrepared");
        rd.b r5 = o().e;
        if (r5 == null) goto L5;
        long r10 = ((com.bytedance.ies.bullet.service.sdk.b) r5).f6137i;
        this.f6045c.a("prepare_init_data_start", Long.valueOf(r10));
        ExecutorService r11 = d.f6039a;
        d.a(q(), "prepare_init_data_start", Long.valueOf(r10));
    L5:
        rd.b r12 = o().e;
        if (r12 == null) goto L8;
        long r13 = ((com.bytedance.ies.bullet.service.sdk.b) r12).f6138j;
        this.f6045c.a("prepare_init_data_end", Long.valueOf(r13));
        com.lynx.tasm.utils.a.f(this.f6045c, "prepare_init_data_start", "prepare_init_data_end", this.d, "schema_convert");
        ExecutorService r14 = d.f6039a;
        d.a(q(), "prepare_init_data_end", Long.valueOf(r13));
    L8:
        ExecutorService r15 = d.f6039a;
        String r16 = q();
        rd.b r17 = o().e;
        if (r17 == null) goto L13;
        Object r18 = ((com.bytedance.ies.bullet.service.sdk.b) r17).f6135c;
        if (r18 == null) goto L13;
    L14:
        d.a(r16, "schema", r18);
        return;
    L13:
        r18 = String.valueOf(o().f5297k);
        goto L14
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void E() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("web_load_url", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "web_load_url", null, r10);
        ContainerStandardMonitor.INSTANCE.collect(q(), "engineview_render_start", Long.valueOf(System.currentTimeMillis()));
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("page_load", STGroup.DICT_KEY);
        r11.a("page_load", Long.valueOf(System.currentTimeMillis()));
        com.lynx.tasm.utils.a.f(r11, "prepare_component_end", "page_load", this.d, "kitcreate_to_loadurl");
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void F() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_web_page_finished", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_web_page_finished", null, r10);
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("page_finish", STGroup.DICT_KEY);
        r11.a("page_finish", Long.valueOf(System.currentTimeMillis()));
        id.a r12 = this.d;
        com.lynx.tasm.utils.a.f(r11, "page_start", "page_finish", r12, "web_render");
        com.lynx.tasm.utils.a.f(r11, "containerInitTime", "page_finish", r12, "first_screen");
        this.f6052n.addAndGet(2);
        K();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void G() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_web_page_started", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_web_page_started", null, r10);
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("page_start", STGroup.DICT_KEY);
        r11.a("page_start", Long.valueOf(System.currentTimeMillis()));
        id.a r12 = this.d;
        com.lynx.tasm.utils.a.f(r11, "page_load", "page_start", r12, "loadurl_to_pagestart");
        com.lynx.tasm.utils.a.f(r11, "prepare_component_end", "page_start", r12, "kitcreate_to_pagestart");
        com.lynx.tasm.utils.a.f(r11, "containerInitTime", "page_start", r12, "init_to_start_render");
        ConcurrentHashMap r13 = dd.c.f16640b;
        dd.c.c(q(), "view_page_start");
        this.f6052n.set(0);
        List r14 = CollectionsKt.listOf(new Pair[]{new Pair("about_load_url_start", "about_load_url_end"), new Pair("web_load_url_start", "web_load_url_end")});
        id.b r15 = this.f6048j;
        r12.a("sec_dur_loadurl_to_pagestart", Long.valueOf(r15.f(r14)));
        r12.a("sec_dur_load_url_interval", Long.valueOf(r15.f(CollectionsKt.listOf(new Pair("about_load_url_end", "web_load_url_start")))));
        r12.a("sec_dur_init_to_start_render", Long.valueOf(r15.f(CollectionsKt.listOf(new Pair[]{new Pair("create_container_start", "create_container_end"), new Pair("on_container_created_start", "on_container_created_end"), new Pair("about_load_url_start", "about_load_url_end"), new Pair("web_load_url_start", "web_load_url_end")}))));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void H() {
        Intrinsics.checkNotNullParameter("kit_load_start", STGroup.DICT_KEY);
        Log.i("Monitor-Callback", q() + " recordTimeStamp kit_load_start");
        id.c r5 = this.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("kit_load_start", STGroup.DICT_KEY);
        r5.a("kit_load_start", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void I() {
        Regex r5 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r10 = o();
        Intrinsics.checkNotNullParameter(r10, "mContext");
        x r11 = new x("bdx_monitor_container_page_error_page_click");
        r11.f6027j = r10.f5303q;
        com.lynx.tasm.utils.d.l(r11, r10.d);
        tc.c r12 = tc.c.f22119c;
        tc.c r13 = tc.c.f22119c;
        String r14 = r10.f;
        if (r14 != null) goto L5;
        r14 = "default_bid";
    L5:
        com.bytedance.ies.bullet.service.base.i r15 = (com.bytedance.ies.bullet.service.base.i) r13.a(com.bytedance.ies.bullet.service.base.i.class, r14);
        if (r15 == null) goto L9;
        ((i) r15).d(r11);
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void J() {
        Regex r5 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r10 = o();
        Intrinsics.checkNotNullParameter(r10, "mContext");
        x r11 = new x("bdx_monitor_container_page_error_page_show");
        r11.f6027j = r10.f5303q;
        com.lynx.tasm.utils.d.l(r11, r10.d);
        tc.c r12 = tc.c.f22119c;
        tc.c r13 = tc.c.f22119c;
        String r14 = r10.f;
        if (r14 != null) goto L5;
        r14 = "default_bid";
    L5:
        com.bytedance.ies.bullet.service.base.i r15 = (com.bytedance.ies.bullet.service.base.i) r13.a(com.bytedance.ies.bullet.service.base.i.class, r14);
        if (r15 == null) goto L9;
        ((i) r15).d(r11);
        return;
    }

    public final void K() {
        StringBuilder r5 = new StringBuilder();
        r5.append(q());
        r5.append(" onSetup ");
        AtomicInteger r10 = this.f6052n;
        r5.append(r10.get());
        Log.i("Monitor-Callback", r5.toString());
        if (r10.get() <= 2) goto L9;
        LinkedHashMap r11 = cd.a.f1171a;
        if (cd.a.a(q()).a(p.class) != null) goto L8;
        return;
    L8:
        throw new ClassCastException();
    }

    public final void L() {
        Log.i("Monitor-Callback", q() + " onViewDisappear");
        dd.c.d("", true);
        if (this.f6051m == false) goto L9;
        ad.a r5 = o().f5303q;
        if (r5 == null) goto L9;
        String r10 = r5.a();
        if (r10 == null) goto L9;
        ug.a.e(r10);
    L9:
        WeakReference r11 = this.f6050l;
        if (r11 == null) goto L12;
        com.bytedance.ies.bullet.core.container.e r12 = (com.bytedance.ies.bullet.core.container.e) r11.get();
    L13:
        if (r12 != null) goto L15;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("empty containerRef", LogLevel.d, "Monitor-Callback");
    L15:
        WeakReference r14 = this.f6050l;
        if (r14 == null) goto L18;
        Object r15 = (com.bytedance.ies.bullet.core.container.e) r14.get();
    L20:
        if ((r15 instanceof View) == false) goto L22;
        View r16 = (View) r15;
    L23:
        if (r16 != null) goto L25;
    L40:
        boolean r17 = false;
    L41:
        ConcurrentHashMap r18 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r19 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r19 == null) goto L46;
        xc.d r20 = (xc.d) r19.a(xc.d.class);
        if (r20 == null) goto L46;
        boolean r21 = Intrinsics.areEqual(r20.p0(), Boolean.FALSE);
    L47:
        if (r21 == false) goto L49;
        r17 = true;
    L49:
        String r22 = "update";
        String r110 = "view_type";
        boolean r111 = r17;
        if (this.f6051m == false) goto L62;
        WeakReference r23 = this.f6050l;
        if (r23 == null) goto L54;
        com.bytedance.ies.bullet.core.container.e r24 = (com.bytedance.ies.bullet.core.container.e) r23.get();
    L55:
        if (r24 == null) goto L63;
        if (r111 == false) goto L62;
        if (Intrinsics.areEqual(o().f5308w.f5281l, "success") == true) goto L63;
        if (Intrinsics.areEqual(o().f5308w.f5281l, "update") == false) goto L62;
    L63:
        com.bytedance.ies.bullet.service.base.h r25 = o().f5298l;
        if (o().d.f5323b == false) goto L67;
        this.d.a("before_bullet_duration", Long.valueOf(this.f6045c.d("containerInitTime") - o().d.d.optLong("entry_start_timestamp")));
    L67:
        com.bytedance.ies.bullet.core.e r26 = o();
        id.c r27 = this.f6045c;
        id.a r28 = this.d;
        Intrinsics.checkNotNullParameter(r26, "mContext");
        Intrinsics.checkNotNullParameter(r27, "timeStampMap");
        Object r29 = "0";
        Intrinsics.checkNotNullParameter(r28, "durationMap");
        ad.a r112 = r26.f5303q;
        if (r112 == null) goto L70;
        KitType r113 = r112.b();
    L72:
        if (r113 != KitType.d) goto L74;
        String r30 = "bdx_monitor_lynx_timeline";
    L75:
        x r114 = new x(r30);
        r114.f6027j = r26.f5303q;
        JSONObject r31 = new JSONObject();
        r31.put("view_type", r26.f5295i.f5286a);
        CacheType r115 = r26.f5308w.e;
        int r210 = -1;
        if (r115 != null) goto L78;
        int r116 = -1;
    L79:
        String r211 = "reuse";
        if (r116 == 1) goto L84;
        if (r116 == 2) goto L83;
        String r32 = "new";
    L85:
        r31.put("view_from", r32);
        if (r26.f5308w.f5276c == false) goto L88;
        Object r33 = "precreate";
    L89:
        r31.put("kitview_from", r33);
        if (r26.f5309x.e == false) goto L92;
        Object r34 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L93:
        r31.put("res_memory", r34);
        r31.put("res_from", r26.f5309x.f5347b);
        if (r26.f5308w.f == null) goto L96;
        boolean r35 = true;
    L97:
        r31.put("fallback", r35);
        u r36 = r26.f5308w.f;
        if (r36 == null) goto L100;
        String r37 = r36.f8670b;
    L101:
        r31.put("fallback_reason", r37);
        Boolean r38 = r26.f5308w.f5279j.isLoaderTasksReady();
        if (r38 != null) goto L104;
    L108:
        Boolean r39 = r26.f5308w.f5279j.getLoaderResult();
        if (r39 != null) goto L111;
    L115:
        r31.put("res_version", r26.f5309x.d);
        r114.e = r31;
        JSONObject r40 = new JSONObject();
        r40.put("res_size", r26.f5309x.f5348c);
        r40.put("containerInitTime", r27.d("containerInitTime"));
        long r117 = r27.d("lynx_first_screen");
        if (r117 <= 0) goto L118;
        r40.put("lynx_first_screen", r117);
    L118:
        String r118 = "duration";
        long r41 = r27.d("page_finish");
        if (r41 <= 0) goto L121;
        r40.put("page_finish", r41);
    L121:
        Iterator<Map.Entry<String, Object>> r42 = r26.f5308w.f5279j.getLoaderPerfMetric().entrySet().iterator();
    L123:
        if (r42.hasNext() == false) goto L125;
        Map.Entry<String, Object> r43 = r42.next();
        r40.put(r43.getKey(), r43.getValue());
        goto L123
    L125:
        td.b.f(r40, r28.f852b);
        r114.f = r40;
        r26.d.b((JSONObject) r114.e, r40);
        tc.c r44 = tc.c.f22119c;
        tc.c r45 = tc.c.f22119c;
        String r46 = r26.f;
        if (r46 != null) goto L128;
        r46 = "default_bid";
    L128:
        com.bytedance.ies.bullet.service.base.i r47 = (com.bytedance.ies.bullet.service.base.i) r45.a(com.bytedance.ies.bullet.service.base.i.class, r46);
        if (r47 == null) goto L132;
        ((i) r47).d(r114);
    L132:
        if ((o().f5298l instanceof vc.d) == false) goto L153;
        com.bytedance.ies.bullet.core.e r48 = o();
        id.c r49 = this.f6045c;
        Intrinsics.checkNotNullParameter(r48, "mContext");
        Intrinsics.checkNotNullParameter(r49, "timeStampMap");
        x r50 = new x("bdx_monitor_user_first_screen_duration");
        r50.f6027j = r48.f5303q;
        JSONObject r51 = new JSONObject();
        CacheType r52 = r48.f5308w.e;
        if (r52 != null) goto L136;
    L135:
        int r53 = r210;
        if (r53 != 1) goto L139;
        String r54 = "precreate";
    L143:
        r51.put("source", r54);
        r51.put("view_type", r48.f5295i.f5286a);
        if (r48.f5309x.e == false) goto L146;
        Object r55 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L147:
        r51.put("res_memory", r55);
        r50.e = r51;
        JSONObject r56 = new JSONObject();
        r56.put(r118, r49.d("lynx_first_screen") - r49.d("containerInitTime"));
        r50.f = r56;
        tc.c r57 = tc.c.f22119c;
        String r58 = r48.f;
        if (r58 != null) goto L150;
        r58 = r6;
    L150:
        com.bytedance.ies.bullet.service.base.i r59 = (com.bytedance.ies.bullet.service.base.i) r57.a(com.bytedance.ies.bullet.service.base.i.class, r58);
        if (r59 == null) goto L153;
        ((i) r59).d(r50);
        goto L153
    L146:
        r55 = r29;
        goto L147
    L139:
        if (r53 == 2) goto L141;
        r211 = "none";
    L141:
        r54 = r211;
        goto L143
    L136:
        r210 = id.d.f17569a[r52.ordinal()];
    L153:
        com.bytedance.ies.bullet.core.e r60 = o();
        Intrinsics.checkNotNullParameter(r60, "mContext");
        com.bytedance.ies.bullet.core.k r61 = r60.d;
        if (r61.f5323b == true) goto L156;
        String r62 = "res_memory";
        String r119 = "entry_start_timestamp";
        Object r63 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L211:
        t();
    L213:
        if (this.f6051m == false) goto L273;
        WeakReference r64 = this.f6050l;
        if (r64 == null) goto L217;
        com.bytedance.ies.bullet.core.container.e r120 = (com.bytedance.ies.bullet.core.container.e) r64.get();
    L218:
        if (r120 == null) goto L222;
        if (r111 == false) goto L273;
    L222:
        String r65 = o().f5308w.f5281l;
        Regex r66 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r67 = o();
        long r68 = o().d.d.optLong(r119);
        if (r68 > 0) goto L226;
        r68 = this.f6045c.d("containerInitTime");
    L226:
        Intrinsics.checkNotNullParameter(r67, "mContext");
        Intrinsics.checkNotNullParameter(r65, NotificationCompat.CATEGORY_STATUS);
        x r69 = new x("bdx_monitor_container_exit");
        r69.f6027j = r67.f5303q;
        JSONObject r70 = new JSONObject();
        r70.put(r110, r67.f5295i.f5286a);
        if (r67.f5309x.e == false) goto L229;
        Object r121 = r63;
    L230:
        r70.put(r62, r121);
        r70.put(NotificationCompat.CATEGORY_STATUS, r65);
        r69.e = r70;
        JSONObject r71 = new JSONObject();
        r71.put(r118, System.currentTimeMillis() - r68);
        r69.f = r71;
        com.lynx.tasm.utils.d.l(r69, r67.d);
        tc.c r72 = tc.c.f22119c;
        tc.c r73 = tc.c.f22119c;
        String r74 = r67.f;
        if (r74 != null) goto L233;
        r74 = r21;
    L233:
        com.bytedance.ies.bullet.service.base.i r75 = (com.bytedance.ies.bullet.service.base.i) r73.a(com.bytedance.ies.bullet.service.base.i.class, r74);
        if (r75 == null) goto L236;
        ((i) r75).d(r69);
    L236:
        hd.b.a(o());
        int r76 = r65.hashCode();
        if (r76 != (-1867169789)) goto L239;
        Object r77 = r11;
        if (r65.equals(r77) == false) goto L273;
    L254:
        com.bytedance.ies.bullet.core.e r78 = o();
        Intrinsics.checkNotNullParameter(r78, "mContext");
        x r79 = new x("bdx_monitor_container_load_url");
        JSONObject r80 = com.lynx.tasm.utils.d.k(NotificationCompat.CATEGORY_STATUS, "cancel");
        String r81 = "end";
        if (Intrinsics.areEqual(r78.f5308w.f5281l, r77) == false) goto L257;
        r80.put("cancel_stage", "end");
        r80.put("stage", r22);
    L261:
        long r82 = r78.d.d.optLong(r119);
        if (r82 > 0) goto L265;
        r82 = System.currentTimeMillis();
    L265:
        r80.put("stay_duration", System.currentTimeMillis() - r82);
        r79.e = r80;
        hd.b.c(r79, r78);
        tc.c r83 = tc.c.f22119c;
        String r84 = r78.f;
        if (r84 != null) goto L268;
        String r85 = r21;
    L269:
        com.bytedance.ies.bullet.service.base.i r86 = (com.bytedance.ies.bullet.service.base.i) r83.a(com.bytedance.ies.bullet.service.base.i.class, r85);
        if (r86 == null) goto L272;
        ((i) r86).d(r79);
    L272:
        ConcurrentHashMap r87 = dd.c.f16640b;
        dd.c.c(q(), "view_load_cancel");
        goto L273
    L268:
        r85 = r84;
        goto L269
    L257:
        r80.put("cancel_stage", r78.d.e.f5269a);
        if (r78.f5308w.f5274a == false) goto L260;
        r81 = "reload_end";
    L260:
        r80.put("stage", r81);
        goto L261
    L239:
        if (r76 == (-1367724422)) goto L248;
        if (r76 != (-1086574198)) goto L273;
        if (r65.equals("failure") == false) goto L273;
        t();
        goto L273
    L248:
        if (r65.equals("cancel") == false) goto L273;
        r77 = "success";
        goto L254
    L229:
        r121 = r29;
        goto L230
    L217:
        r120 = null;
    L273:
        this.f6051m = false;
        dd.c.f16639a = -1;
        return;
    L156:
        JSONObject r88 = r61.f5324c;
        JSONObject r89 = r61.d;
        x r90 = new x("bdx_monitor_timeline_full");
        r90.f6027j = r60.f5303q;
        JSONObject r91 = new JSONObject();
        td.b.f(r91, r88);
        Object r92 = r91.opt("tracert_id");
        if ((r92 instanceof String) == false) goto L159;
        String r93 = (String) r92;
    L160:
        if (r93 != null) goto L162;
    L163:
        ad.a r94 = r60.f5303q;
        if (r94 == null) goto L166;
        String r95 = r94.a();
    L167:
        r91.put("tracert_id", r95);
    L168:
        r90.e = r91;
        JSONObject r96 = new JSONObject();
        td.b.f(r96, r89);
        JSONObject r97 = (JSONObject) r90.e;
        if (r97 == null) goto L171;
        Object r98 = r97.opt("is_data_injected");
    L172:
        String r99 = String.valueOf(r98);
        r63 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        if (Intrinsics.areEqual(r99, r63) == false) goto L178;
        r62 = "res_memory";
        long r100 = 0;
        if (r96.optLong("draw_end") <= 0) goto L180;
        long r122 = r96.optLong("draw_end");
    L177:
        r119 = "entry_start_timestamp";
        long r212 = r96.optLong(r119);
        if (r96.optLong("draw_end") == r100) goto L189;
        r96.put("fcp_time", r96.optLong("draw_end") - r212);
    L189:
        r96.put("full_time", Math.max(0, r122 - r212));
        if (r96.optLong("page_commit_start") == 0) goto L197;
        if (r96.optLong("page_commit_end") == 0) goto L197;
        long r101 = r96.optLong("page_commit_end") - r96.optLong("page_commit_start");
        if (r101 <= 0) goto L197;
        r96.put("page_commit_duration", r101);
    L197:
        if (r96.optLong("api_request_end") == 0) goto L200;
        r96.put("render_cost", r122 - r96.optLong("api_request_end"));
    L200:
        if (r96.optLong("api_request_duration") != 0) goto L204;
        long r102 = r96.optLong("api_request_end") - r96.optLong("api_request_start");
        if (r102 <= 0) goto L204;
        r96.put("api_request_duration", r102);
    L204:
        r90.f = r96;
        r60.d.f5323b = false;
        tc.c r103 = tc.c.f22119c;
        String r104 = r60.f;
        if (r104 != null) goto L207;
        r104 = r6;
    L207:
        rc.c r105 = (com.bytedance.ies.bullet.service.base.i) r103.a(com.bytedance.ies.bullet.service.base.i.class, r104);
        if (r105 != null) goto L210;
        Lazy r106 = i.d;
        r105 = m.b();
    L210:
        ((i) r105).d(r90);
    L180:
        if (r96.optLong("update_draw_end") <= r100) goto L183;
        r122 = r96.optLong("update_draw_end");
        goto L177
    L183:
        if (r96.optLong("page_finish") <= r100) goto L185;
        r122 = r96.optLong("page_finish");
        goto L177
    L185:
        r122 = r100;
        goto L177
    L178:
        r62 = "res_memory";
        r100 = 0;
        goto L180
    L171:
        r98 = null;
        goto L172
    L166:
        r95 = null;
        goto L167
    L162:
        if (r93.length() != 0) goto L168;
    L159:
        r93 = null;
        goto L160
    L111:
        if (r39.booleanValue() == false) goto L113;
        Object r107 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L114:
        r31.put("loaderTasksResult", r107);
        goto L115
    L113:
        r107 = r29;
        goto L114
    L104:
        if (r38.booleanValue() == false) goto L106;
        Object r108 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L107:
        r31.put("isLoaderTasksReady", r108);
        goto L108
    L106:
        r108 = r29;
        goto L107
    L100:
        r37 = null;
        goto L101
    L96:
        r35 = false;
        goto L97
    L92:
        r34 = r29;
        goto L93
    L88:
        r33 = "new";
        goto L89
    L83:
        r32 = "reuse";
        goto L85
    L84:
        r32 = "prerender";
        goto L85
    L78:
        r116 = id.d.f17569a[r115.ordinal()];
        goto L79
    L74:
        r30 = "bdx_monitor_web_timeline";
        goto L75
    L70:
        r113 = null;
        goto L72
    L54:
        r24 = null;
    L62:
        String r109 = "default_bid";
        r22 = "update";
        r62 = "res_memory";
        r119 = "entry_start_timestamp";
        r29 = "0";
        r63 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        r118 = "duration";
        r110 = "view_type";
    L46:
        r21 = false;
        goto L47
    L25:
        if (r16.getVisibility() != 0) goto L40;
        if (o().f5308w.f5280k == true) goto L40;
        WeakReference r123 = this.f6050l;
        if (r123 == null) goto L31;
        Object r124 = (com.bytedance.ies.bullet.core.container.e) r123.get();
    L33:
        if ((r124 instanceof View) == false) goto L35;
        View r125 = (View) r124;
    L36:
        if (r125 == null) goto L40;
        if (r125.isAttachedToWindow() != true) goto L40;
        r17 = true;
        goto L41
    L35:
        r125 = null;
        goto L36
    L31:
        r124 = null;
        goto L33
    L22:
        r16 = null;
        goto L23
    L18:
        r15 = null;
        goto L20
    L12:
        r12 = null;
        goto L13
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final long a(String r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        id.c r5 = this.f6045c;
        long r11 = 0;
        if (r5.d(r10) <= 0) goto L5;
        r11 = r5.d(r10);
    L14:
        Log.i("Monitor-Callback", q() + " getPerfMetric " + r10 + ' ' + r11);
        return r11;
    L5:
        id.a r12 = this.d;
        if (r12.d(r10) <= 0) goto L8;
        r11 = r12.d(r10);
        goto L14
    L8:
        id.c r13 = this.e;
        if (r13.d(r10) <= 0) goto L11;
        r11 = r13.d(r10);
        goto L14
    L11:
        id.a r14 = this.f;
        if (r14.d(r10) <= 0) goto L14;
        r11 = r14.d(r10);
        goto L14
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final LinkedHashMap b() {
        LinkedHashMap r5 = new LinkedHashMap();
        id.c r10 = this.f6045c;
        r5.put("containerInitTime", Long.valueOf(r10.d("containerInitTime")));
        r5.put("open_time", Long.valueOf(r10.d("open_time")));
        r5.put("container_init_start", Long.valueOf(r10.d("container_init_start")));
        r5.put("container_init_end", Long.valueOf(r10.d("container_init_end")));
        Log.i("Monitor-Callback", q() + " generatePerfMapForGlobalProps " + r5);
        return r5;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void c(long r10, boolean r11) {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(q() + " onLoadEntryBullet " + r10 + ' ' + r11, LogLevel.f5954b, "Monitor-Callback");
        if (r11 == false) goto L5;
        this.f6045c.a("open_time", Long.valueOf(r10));
    L6:
        String r12 = null;
        if (this.f6045c.c("containerInitTime") == true) goto L42;
        if (k.a() == null) goto L12;
        Intrinsics.checkNotNullParameter("init_to_start_render", "sectionName");
        TraceEvent.c("init_to_start_render");
    L12:
        if (k.a() == null) goto L14;
        Intrinsics.checkNotNullParameter("load_to_kitcreate", "sectionName");
        TraceEvent.c("load_to_kitcreate");
    L14:
        this.f6045c.a("containerInitTime", Long.valueOf(r10));
        ConcurrentHashMap r13 = sb.a.f21884a;
        com.bytedance.ies.bullet.core.e r14 = o();
        long r15 = this.f6045c.d("containerInitTime");
        Intrinsics.checkNotNullParameter(r14, "bulletContext");
        if (Uri.parse(String.valueOf(r14.f5297k)).getBooleanQueryParameter("enable_advanced_monitor", true) == false) goto L26;
        Uri r16 = r14.f5297k;
        if (r16 == null) goto L23;
        String r17 = io.reactivex.exceptions.a.h(r16, "__x_session_id");
        if (r17 == null) goto L23;
        com.bytedance.ies.bullet.core.k r18 = (com.bytedance.ies.bullet.core.k) sb.a.f21884a.remove(r17);
        if (r18 == null) goto L23;
        com.bytedance.ies.bullet.service.base.b.a(6, "use oldMonitorContext with monitorId " + r18.f5322a, null);
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r14.d = r18;
        t9.a r19 = r14.f5310y;
        JSONObject r20 = r18.f5324c;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "category");
        r20.optBoolean("skipBizLogic", false);
        r20.optBoolean("asyncAdblockInit", false);
        r20.optBoolean("skipAnimation", false);
        r20.optBoolean("skipPageProvideView", false);
    L23:
        com.bytedance.ies.bullet.core.k r21 = r14.d;
        r14.getSessionId();
        r21.getClass();
        com.bytedance.ies.bullet.service.base.b.a(6, "Tracert associate sessionId " + r14.getSessionId() + " with monitorId " + r14.d.f5322a, null);
        com.bytedance.ies.bullet.core.k r22 = r14.d;
        if (r22.f5323b == true) goto L26;
        r22.a(Long.valueOf(r15), "undefine", "bullet");
    L26:
        Regex r23 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r24 = o();
        Intrinsics.checkNotNullParameter(r24, "mContext");
        x r25 = new x("bdx_monitor_container_load_url");
        if (r24.e == null) goto L29;
        ad.a r26 = r24.f5303q;
    L35:
        r25.f6027j = r26;
        JSONObject r27 = new JSONObject();
        r27.put("view_type", r24.f5295i.f5286a);
        r27.put("stage", "begin");
        r25.e = r27;
        com.lynx.tasm.utils.d.l(r25, r24.d);
        tc.c r28 = tc.c.f22119c;
        tc.c r29 = tc.c.f22119c;
        String r30 = r24.f;
        if (r30 != null) goto L38;
        r30 = "default_bid";
    L38:
        com.bytedance.ies.bullet.service.base.i r31 = (com.bytedance.ies.bullet.service.base.i) r29.a(com.bytedance.ies.bullet.service.base.i.class, r30);
        if (r31 == null) goto L44;
        ((i) r31).d(r25);
    L44:
        ad.a r32 = o().f5303q;
        if (r32 == null) goto L49;
        String r33 = r32.a();
        if (r33 == null) goto L49;
        ug.a.f(r33, true);
    L49:
        String r34 = com.bytedance.android.monitorV2.exception.b.f3568a;
        ad.a r35 = o().f5303q;
        if (r35 == null) goto L52;
        String r36 = r35.a();
    L53:
        ad.a r37 = o().f5303q;
        if (r37 == null) goto L56;
        r12 = r37.f157a.toString();
    L56:
        com.bytedance.android.monitorV2.exception.b.b(r36, r12);
        return;
    L52:
        r36 = null;
        goto L53
    L29:
        ad.a r38 = r24.f5303q;
        if (r38 == null) goto L33;
        Uri r39 = r38.f157a;
        if (r39 == null) goto L33;
    L34:
        r26 = new ad.a(r39);
    L33:
        r39 = Uri.EMPTY;
        goto L34
    L42:
        if (this.f6045c.c("container_create") == false) goto L44;
        this.f6045c.a("containerInitTime", Long.valueOf(r10));
        com.lynx.tasm.utils.a.f(this.f6045c, "container_create", "container_init_start", this.d, "create_to_load");
        goto L44
    L5:
        this.f6045c.a("container_init_start", Long.valueOf(r10));
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void d(com.bytedance.ies.bullet.core.e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.d(r5);
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L12;
        xc.f r12 = (xc.f) r11.a(xc.f.class);
        if (r12 == null) goto L12;
        Map r13 = r12.b();
        if (r13 == null) goto L12;
        Iterator r14 = r13.entrySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        Map.Entry r15 = (Map.Entry) r14.next();
        ContainerStandardMonitor.INSTANCE.addContext(q(), (String) r15.getKey(), (String) r15.getValue());
    L12:
        boolean r16 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(q() + " onBulletContextCreated", LogLevel.f5954b, "Monitor-Callback");
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void e(com.bytedance.ies.bullet.core.e r5, Integer r10, Float r11) {
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        Log.i("Monitor-Callback", q() + " onBlankDetected " + r10 + ", " + r11);
        Regex r12 = hd.b.f17301a;
        Intrinsics.checkNotNullParameter(r5, "mContext");
        x r13 = new x("bdx_monitor_blank_detect");
        r13.f6027j = r5.f5303q;
        JSONObject r14 = new JSONObject();
        if (r10 == null) goto L5;
        r14.put("is_blank", r10.intValue());
        r14.put("container_type", "web");
    L5:
        if (r11 == null) goto L7;
        r14.put("visible_percent", r11);
        r14.put("container_type", "lynx");
    L7:
        r13.f = r14;
        com.lynx.tasm.utils.d.l(r13, r5.d);
        tc.c r15 = tc.c.f22119c;
        tc.c r16 = tc.c.f22119c;
        String r17 = r5.f;
        if (r17 != null) goto L10;
        r17 = "default_bid";
    L10:
        com.bytedance.ies.bullet.service.base.i r18 = (com.bytedance.ies.bullet.service.base.i) r16.a(com.bytedance.ies.bullet.service.base.i.class, r17);
        if (r18 == null) goto L14;
        ((i) r18).d(r13);
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void f(AbsBulletMonitorCallback$ErrStage r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "errStage");
        Intrinsics.checkNotNullParameter(r19, "errMessage");
        Log.i("Monitor-Callback", q() + " onLoadError " + r18 + ", " + r19);
        com.bytedance.ies.bullet.core.c r5 = o().f5308w;
        r5.getClass();
        Intrinsics.checkNotNullParameter("failure", "<set-?>");
        r5.f5281l = "failure";
        ContainerStandardMonitor r10 = ContainerStandardMonitor.INSTANCE;
        ExecutorService r11 = d.f6039a;
        String r12 = q();
        if (o().f5308w.f == null) goto L5;
        boolean r13 = true;
    L6:
        d.a(r12, "is_fallback", Boolean.valueOf(r13));
        tc.c r14 = tc.c.f22119c;
        tc.c r15 = tc.c.f22119c;
        String r16 = o().f;
        String r17 = "default_bid";
        if (r16 != null) goto L9;
        r16 = "default_bid";
    L9:
        rc.c r20 = (com.bytedance.ies.bullet.service.base.i) r15.a(com.bytedance.ies.bullet.service.base.i.class, r16);
        if (r20 != null) goto L12;
        Lazy r21 = i.d;
        r20 = m.b();
    L12:
        w r22 = ((i) r20).f6054b;
        com.bytedance.ies.bullet.service.base.h r23 = o().f5298l;
        KitType r110 = null;
        if (r23 == null) goto L15;
        View r24 = r23.a();
    L16:
        String r25 = q();
        String r26 = (String) r22.f9377c;
        if (r26 != null) goto L19;
        r26 = "";
    L19:
        r10.reportError(r24, r25, -1, r19, r26, "");
        com.bytedance.ies.bullet.core.k r27 = o().d;
        int r28 = r18.ordinal();
        if (r28 == 0) goto L37;
        if (r28 != 1) goto L23;
        ad.a r29 = o().f5303q;
        if (r29 == null) goto L33;
        r110 = r29.b();
    L33:
        if (r110 != KitType.d) goto L36;
        int r30 = 50000000;
    L35:
        int r31 = r30;
        String r32 = "load_engine_fail";
    L38:
        r27.getClass();
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r27.f = r32;
        r27.f5325h = r31;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r27.g = r19;
        Regex r33 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r34 = o();
        Intrinsics.checkNotNullParameter(r34, "mContext");
        Intrinsics.checkNotNullParameter(r18, "errStage");
        Intrinsics.checkNotNullParameter(r19, "errMessage");
        x r35 = new x("bdx_monitor_container_load_url");
        JSONObject r36 = new JSONObject();
        String r37 = r34.d.f5324c.optString("tracert_id");
        if (r37 == null) goto L41;
        r36.put("tracert_id", r37);
    L41:
        String r38 = r34.d.f5324c.optString("sdk_type");
        if (r38 == null) goto L44;
        r36.put("sdk_type", r38);
    L44:
        r35.e = r36;
        hd.b.c(r35, r34);
        hd.b.e(r35, r18, r19);
        tc.c r39 = tc.c.f22119c;
        String r40 = r34.f;
        if (r40 == null) goto L48;
        r17 = r40;
    L48:
        com.bytedance.ies.bullet.service.base.i r41 = (com.bytedance.ies.bullet.service.base.i) r39.a(com.bytedance.ies.bullet.service.base.i.class, r17);
        if (r41 == null) goto L52;
        ((i) r41).d(r35);
        return;
    L52:
        return;
    L36:
        r30 = 47000000;
        goto L35
    L23:
        if (r28 != 2) goto L25;
        r32 = "load_plugin_fail";
        r31 = 35000000;
        goto L38
    L25:
        if (r28 == 4) goto L27;
        r32 = "load_fail";
        r31 = 99999999;
        goto L38
    L27:
        r32 = "load_template_fail";
        r31 = 63000000;
        goto L38
    L37:
        r32 = "load_container_fail";
        r31 = 33000000;
        goto L38
    L15:
        r24 = null;
        goto L16
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void g(BulletCardView r10) {
        Intrinsics.checkNotNullParameter(r10, "monitorContainer");
        Log.i("Monitor-Callback", q() + " onBulletViewAttached");
        id.c r5 = this.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("view_attach", STGroup.DICT_KEY);
        r5.e("view_attach", Long.valueOf(System.currentTimeMillis()));
        this.f6050l = new WeakReference(r10);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void i(Long r10) {
        Log.i("Monitor-Callback", q() + " onContainerCreated " + r10);
        if (r10 == null) goto L5;
        long r5 = r10.longValue();
    L7:
        if (this.f6045c.c("container_create") == true) goto L32;
        this.f6045c.a("container_create", Long.valueOf(r5));
        rd.b r11 = o().e;
        Unit r12 = null;
        if (r11 == null) goto L13;
        Bundle r13 = ((com.bytedance.ies.bullet.service.sdk.b) r11).f6134b;
        if (r13 == null) goto L13;
        Long r14 = Long.valueOf(r13.getLong("open_time"));
    L15:
        if (r14 != null) goto L17;
    L22:
        long r15 = r5;
    L23:
        if (r12 != null) goto L28;
        r15 = this.f6045c.d("open_time");
        if (r15 > 0) goto L28;
        r15 = r5;
    L28:
        ExecutorService r16 = d.f6039a;
        d.a(q(), "open_time", Long.valueOf(r15));
        d.a(q(), "container_create", Long.valueOf(r5));
        if (this.f6045c.c("open_time") == false) goto L33;
        com.lynx.tasm.utils.a.f(this.f6045c, "open_time", "container_create", this.d, "router_to_create");
        return;
    L33:
        return;
    L17:
        if (r14.longValue() != 0) goto L20;
        r14 = null;
    L20:
        if (r14 == null) goto L22;
        r15 = r14.longValue();
        r12 = Unit.INSTANCE;
    L13:
        r14 = null;
        goto L15
    L32:
        return;
    L5:
        r5 = System.currentTimeMillis();
        goto L7
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void j(String r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "block");
        long r11 = System.currentTimeMillis();
        r10.invoke();
        long r12 = System.currentTimeMillis() - r11;
        this.d.a(r5, Long.valueOf(r12));
        Log.i("Monitor-Callback", q() + " recordDuration " + r5 + ' ' + r12);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void k(String r5, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Log.i("Monitor-Callback", q() + " onCpuMemoryInject " + r5 + ' ' + r10 + ' ' + r11);
        if (o().f5308w.f5278i != null) goto L5;
        o().f5308w.f5278i = new z4.a();
    L5:
        s6.c r12 = this.f6053o;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "eventName");
        boolean r13 = Intrinsics.areEqual(r5, "bdx_monitor_cpu");
        x r14 = (x) r12.f21829c;
        x r15 = (x) r12.f21828b;
        if (r13 == false) goto L11;
        JSONObject r16 = (JSONObject) r15.e;
        if (r16 == null) goto L22;
        td.b.f(r16, r10);
    L22:
        if (Intrinsics.areEqual(r5, "bdx_monitor_cpu") == false) goto L28;
        JSONObject r17 = (JSONObject) r15.f;
        if (r17 == null) goto L40;
        td.b.f(r17, r11);
        return;
    L40:
        return;
    L28:
        if (Intrinsics.areEqual(r5, "bdx_monitor_memory") == false) goto L33;
        JSONObject r18 = (JSONObject) r14.f;
        if (r18 == null) goto L41;
        td.b.f(r18, r11);
        return;
    L41:
        return;
    L33:
        JSONObject r19 = (JSONObject) r15.f;
        if (r19 == null) goto L36;
        td.b.f(r19, r11);
    L36:
        JSONObject r20 = (JSONObject) r14.f;
        if (r20 == null) goto L42;
        td.b.f(r20, r11);
        return;
    L42:
        return;
    L11:
        if (Intrinsics.areEqual(r5, "bdx_monitor_memory") == false) goto L15;
        JSONObject r21 = (JSONObject) r14.e;
        if (r21 == null) goto L22;
        td.b.f(r21, r10);
        goto L22
    L15:
        JSONObject r22 = (JSONObject) r15.e;
        if (r22 == null) goto L18;
        td.b.f(r22, r10);
    L18:
        JSONObject r23 = (JSONObject) r14.e;
        if (r23 == null) goto L22;
        td.b.f(r23, r10);
        goto L22
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final o l() {
        return this.f6049k;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void m(BulletCardView r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorContainer");
        Log.i("Monitor-Callback", q() + " onReload");
        L();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void n(String r5) {
        LinkedHashMap r10 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.k(q(), r5);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void p(String r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        id.b r10 = this.f6048j;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        r10.a(r5, Long.valueOf(System.nanoTime()));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void r() {
        Log.i("Monitor-Callback", q() + " onBulletViewDetached");
        id.c r5 = this.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("view_detach", STGroup.DICT_KEY);
        r5.e("view_detach", Long.valueOf(System.currentTimeMillis()));
        L();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void s() {
        Log.i("Monitor-Callback", q() + " onContainerLoaderStart");
        long r5 = System.currentTimeMillis();
        this.f6045c.a("container_init_end", Long.valueOf(r5));
        ExecutorService r10 = d.f6039a;
        d.a(q(), "container_init_end", Long.valueOf(r5));
        d.b(q(), "annie_view_type", o().f5295i.f5286a);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void t() {
        Log.i("Monitor-Callback", q() + " onCpuMemoryReport");
        if (o().B == false) goto L6;
        Log.d("Monitor-Callback", "useCodeMode is true. Ignore onCpuMemoryReport");
        return;
    L6:
        h.f.b(new com.airbnb.lottie.m(this, 6), h.f.g);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void u() {
        Log.i("Monitor-Callback", q() + " onJsbRegisterBegin");
        id.c r5 = this.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("jsb_register_start", STGroup.DICT_KEY);
        r5.a("jsb_register_start", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void v() {
        Log.i("Monitor-Callback", q() + " onJsbRegisterEnd");
        id.c r5 = this.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("jsb_register_end", STGroup.DICT_KEY);
        r5.e("jsb_register_end", Long.valueOf(System.currentTimeMillis()));
        com.lynx.tasm.utils.a.f(r5, "jsb_register_start", "jsb_register_end", this.d, "jsb_register");
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void w() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("kit_view_create_start", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "kit_view_create_start", null, r10);
        long r11 = System.currentTimeMillis();
        Long r12 = Long.valueOf(r11);
        this.f6045c.a("prepare_component_start", r12);
        ExecutorService r13 = d.f6039a;
        d.a(q(), "prepare_component_start", Long.valueOf(r11));
        Long r14 = Long.valueOf(o().f5308w.f5279j.getDuration());
        this.d.a("loader_task_duration", r14);
        if (k.a() == null) goto L6;
        Intrinsics.checkNotNullParameter("create_lynxview", "sectionName");
        TraceEvent.c("create_lynxview");
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void x() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("read_template_start", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "read_template_start", null, r10);
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("read_template_start", STGroup.DICT_KEY);
        r11.a("read_template_start", Long.valueOf(System.currentTimeMillis()));
        if (k.a() == null) goto L6;
        Intrinsics.checkNotNullParameter("read_template", "sectionName");
        TraceEvent.c("read_template");
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void y() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("read_template_end", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "read_template_end", null, r10);
        Log.i("Monitor-Callback", q() + " onLynxReadTemplateEnd");
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("read_template_end", STGroup.DICT_KEY);
        r11.a("read_template_end", Long.valueOf(System.currentTimeMillis()));
        id.a r12 = this.d;
        com.lynx.tasm.utils.a.f(r11, "prepare_template_end", "read_template_end", r12, "read_template");
        r12.a("resource_load", Long.valueOf(r11.f("prepare_template_start", "read_template_end")));
        if (k.a() == null) goto L6;
        Intrinsics.checkNotNullParameter("read_template", "sectionName");
        TraceEvent.a(0, "read_template");
    L6:
        if (k.a() == null) goto L9;
        Intrinsics.checkNotNullParameter("resource_load", "sectionName");
        TraceEvent.a(0, "resource_load");
        return;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.b
    public final void z() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("render_template_start", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "render_template_start", null, r10);
        ContainerStandardMonitor.INSTANCE.collect(q(), "engineview_render_start", Long.valueOf(System.currentTimeMillis()));
        id.c r11 = this.f6045c;
        r11.getClass();
        Intrinsics.checkNotNullParameter("render_template_start", STGroup.DICT_KEY);
        r11.a("render_template_start", Long.valueOf(System.currentTimeMillis()));
        id.a r12 = this.d;
        com.lynx.tasm.utils.a.f(r11, "read_template_end", "render_template_start", r12, "rl_to_render");
        r12.a("init_to_start_render", Long.valueOf(r11.f("containerInitTime", "render_template_start")));
        if (k.a() == null) goto L5;
        Intrinsics.checkNotNullParameter("init_to_start_render", "sectionName");
        TraceEvent.a(0, "init_to_start_render");
    L5:
        this.f6052n.set(0);
    }
}
