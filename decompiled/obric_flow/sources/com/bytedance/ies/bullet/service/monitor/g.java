package com.bytedance.ies.bullet.service.monitor;

import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import com.google.common.base.u;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.TraceEvent;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ym.k;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f6043b;

    public g(h r5) {
        this.f6043b = r5;
        this.f6042a = new e(r5);
    }

    @Override // com.bytedance.ies.bullet.core.o
    public final void a() {
        Log.i("Monitor-Callback", this.f6043b.q() + " onEnterForeground");
        id.c r5 = this.f6043b.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("view_enter_foreground", STGroup.DICT_KEY);
        r5.e("view_enter_foreground", Long.valueOf(System.currentTimeMillis()));
        String r10 = this.f6043b.o().f;
        if (r10 != null) goto L6;
        r10 = "default_bid";
    L6:
        if (Intrinsics.areEqual(r10, "webcast") == false) goto L17;
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r12 == null) goto L14;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L14;
        Boolean r14 = r13.m0();
        if (r14 == null) goto L14;
        boolean r15 = r14.booleanValue();
    L15:
        if (r15 == true) goto L17;
        Looper.myQueue().addIdleHandler(new f(this.f6043b));
    L18:
        ad.a r16 = this.f6043b.o().f5303q;
        if (r16 == null) goto L24;
        String r17 = r16.a();
        if (r17 == null) goto L25;
        ug.a.f(r17, false);
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r15 = false;
    L17:
        ConcurrentHashMap r18 = dd.c.f16640b;
        dd.c.b(this.f6043b.q());
        goto L18
    }

    @Override // com.bytedance.ies.bullet.core.o
    public final void c() {
        Log.i("Monitor-Callback", this.f6043b.q() + " onEnterBackground");
        id.c r5 = this.f6043b.f6045c;
        r5.getClass();
        Intrinsics.checkNotNullParameter("view_enter_background", STGroup.DICT_KEY);
        r5.e("view_enter_background", Long.valueOf(System.currentTimeMillis()));
        if (this.f6043b.f6045c.c("view_enter_foreground") == false) goto L14;
        h r10 = this.f6043b;
        r10.d.e("stay_duration", Long.valueOf(r10.f6045c.f("view_enter_foreground", "view_enter_background")));
        com.bytedance.ies.bullet.core.e r11 = this.f6043b.o();
        id.a r12 = this.f6043b.d;
        Intrinsics.checkNotNullParameter(r11, "mContext");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        ConcurrentHashMap r13 = sb.a.f21884a;
        if (Uri.parse(String.valueOf(r11.f5297k)).getBooleanQueryParameter("enable_advanced_monitor", true) == false) goto L13;
        long r14 = r12.d("stay_duration");
        x r15 = new x("bdx_monitor_stay_duration");
        r15.f6027j = r11.f5303q;
        JSONObject r16 = new JSONObject();
        r16.put("stay_duration", r14);
        r15.f = r16;
        com.lynx.tasm.utils.d.l(r15, r11.d);
        tc.c r17 = tc.c.f22119c;
        tc.c r18 = tc.c.f22119c;
        String r19 = r11.f;
        if (r19 != null) goto L10;
        r19 = "default_bid";
    L10:
        com.bytedance.ies.bullet.service.base.i r20 = (com.bytedance.ies.bullet.service.base.i) r18.a(com.bytedance.ies.bullet.service.base.i.class, r19);
        if (r20 == null) goto L13;
        ((i) r20).d(r15);
    L13:
        id.c r21 = this.f6043b.f6045c;
        r21.getClass();
        Intrinsics.checkNotNullParameter("view_enter_foreground", STGroup.DICT_KEY);
        r21.f852b.remove("view_enter_foreground");
        id.c r22 = this.f6043b.f6045c;
        r22.getClass();
        Intrinsics.checkNotNullParameter("view_enter_background", STGroup.DICT_KEY);
        r22.f852b.remove("view_enter_background");
    L14:
        ad.a r23 = this.f6043b.o().f5303q;
        if (r23 == null) goto L19;
        String r24 = r23.a();
        if (r24 == null) goto L19;
        ug.a.e(r24);
    L19:
        ba.a r25 = this.f6043b.f6047i;
        if (r25.f889b == true) goto L22;
    L27:
        this.f6043b.L();
        return;
    L22:
        if (r25.f888a != true) goto L27;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onEnterBackground-stopFluencyMonitor");
        JSONObject r26 = new JSONObject();
        h r27 = this.f6043b;
        r26.put("stage", "error_stage");
        String r28 = r27.o().d.f5324c.optString("sdk_type");
        if (r28 == null) goto L26;
        r26.put("sdk_type", r28);
    L26:
        this.f6043b.f6047i.b(r26);
        goto L27
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void f() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r10 = this.f6043b;
        com.bytedance.ies.bullet.base.utils.logger.b r11 = (com.bytedance.ies.bullet.base.utils.logger.b) r10.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("bullet_view_create", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "bullet_view_create", null, r11);
        id.c r12 = r10.f6045c;
        r12.getClass();
        Intrinsics.checkNotNullParameter("bullet_view_create", STGroup.DICT_KEY);
        r12.a("bullet_view_create", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final vc.c getLynxClient() {
        return this.f6042a;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void n() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r10 = this.f6043b;
        com.bytedance.ies.bullet.base.utils.logger.b r11 = (com.bytedance.ies.bullet.base.utils.logger.b) r10.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("bullet_view_release", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "bullet_view_release", null, r11);
        id.c r12 = r10.f6045c;
        r12.getClass();
        Intrinsics.checkNotNullParameter("bullet_view_release", STGroup.DICT_KEY);
        r12.a("bullet_view_release", Long.valueOf(System.currentTimeMillis()));
        r10.L();
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void o(Uri r10, com.bytedance.ies.bullet.service.base.h r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r13 = (com.bytedance.ies.bullet.base.utils.logger.b) this.f6043b.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("kit_view_create_end", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "kit_view_create_end", null, r13);
        long r5 = System.currentTimeMillis();
        h r14 = this.f6043b;
        r14.f6045c.a("prepare_component_end", Long.valueOf(r5));
        ExecutorService r15 = d.f6039a;
        d.a(r14.q(), "prepare_component_end", Long.valueOf(r5));
        if ((r11 instanceof vc.d) == false) goto L5;
        String r16 = "create_lynxview";
    L6:
        id.a r17 = r14.d;
        com.lynx.tasm.utils.a.f(r14.f6045c, "prepare_component_start", "prepare_component_end", r17, r16);
        r14.d.a("load_to_kitcreate", Long.valueOf(r14.f6045c.f("container_init_start", "prepare_component_end")));
        if (k.a() == null) goto L10;
        Intrinsics.checkNotNullParameter("create_lynxview", "sectionName");
        TraceEvent.a(0, "create_lynxview");
    L10:
        if (k.a() == null) goto L12;
        Intrinsics.checkNotNullParameter("load_to_kitcreate", "sectionName");
        TraceEvent.a(0, "load_to_kitcreate");
    L12:
        if (r11 == null) goto L20;
        View r18 = r11.a();
        if (r18 == null) goto L20;
        h r19 = this.f6043b;
        String r20 = r19.q();
        ad.a r21 = r19.o().f5303q;
        if (r21 == null) goto L18;
        KitType r22 = r21.b();
    L19:
        String r23 = r22.f6013a;
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r23, "type");
        com.bytedance.android.anniex.scene.core.i r24 = new com.bytedance.android.anniex.scene.core.i(r20, r18, r23, 9);
        d.f6039a.execute(r24);
        goto L20
    L18:
        r22 = KitType.f6011b;
    L20:
        ConcurrentHashMap r25 = dd.c.f16640b;
        dd.c.c(this.f6043b.q(), "view_create_end");
        return;
    L5:
        r16 = "create_webview";
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(TuplesKt.to("url", r5.toString()));
        com.bytedance.ies.bullet.base.utils.logger.b r13 = (com.bytedance.ies.bullet.base.utils.logger.b) this.f6043b.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("load_uri_success", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "load_uri_success", r12, r13);
        com.bytedance.ies.bullet.core.c r14 = this.f6043b.o().f5308w;
        r14.getClass();
        Intrinsics.checkNotNullParameter("success", "<set-?>");
        r14.f5281l = "success";
        ConcurrentHashMap r15 = dd.c.f16640b;
        dd.c.c(this.f6043b.q(), "view_load_end");
        h r16 = this.f6043b;
        if (r16.f6051m == false) goto L14;
        Regex r17 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r18 = r16.o();
        Intrinsics.checkNotNullParameter(r18, "mContext");
        x r19 = new x("bdx_monitor_container_load_url");
        JSONObject r20 = com.lynx.tasm.utils.d.k(NotificationCompat.CATEGORY_STATUS, "success");
        if (r18.f5308w.f5274a == false) goto L7;
        String r21 = "reload_end";
    L8:
        r20.put("stage", r21);
        r19.e = r20;
        hd.b.c(r19, r18);
        tc.c r22 = tc.c.f22119c;
        tc.c r23 = tc.c.f22119c;
        String r24 = r18.f;
        if (r24 != null) goto L11;
        r24 = "default_bid";
    L11:
        com.bytedance.ies.bullet.service.base.i r25 = (com.bytedance.ies.bullet.service.base.i) r23.a(com.bytedance.ies.bullet.service.base.i.class, r24);
        if (r25 == null) goto L14;
        ((i) r25).d(r19);
        goto L14
    L7:
        r21 = "end";
    L14:
        com.bytedance.ies.bullet.core.k r26 = this.f6043b.o().d;
        LoadStage r27 = LoadStage.e;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r26.e = r27;
        com.bytedance.ies.bullet.core.k r28 = this.f6043b.o().d;
        r28.getClass();
        Intrinsics.checkNotNullParameter("load_success", "<set-?>");
        r28.f = "load_success";
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void q(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r10.toString()), TuplesKt.to("message", r11.getMessage())});
        h r13 = this.f6043b;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("fall_back", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "fall_back", r12, r14);
        com.bytedance.ies.bullet.core.c r15 = r13.o().f5308w;
        u r16 = new u();
        Uri r17 = r13.o().f5297k;
        r16.f8670b = r11.getMessage();
        r15.f = r16;
        ExecutorService r18 = d.f6039a;
        String r19 = r13.q();
        Boolean r20 = Boolean.TRUE;
        d.a(r19, "invoke_fallback", r20);
        d.a(r13.q(), "is_fallback", r20);
        d.a(r13.q(), "fallback_url", r10.toString());
        d.a(r13.q(), "fallback_error_msg", String.valueOf(r11.getMessage()));
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r5.toString()), TuplesKt.to("message", r10.getMessage())});
        h r13 = this.f6043b;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("load_fail", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "Monitor-Callback", "load_fail", r12, r14);
        ConcurrentHashMap r15 = dd.c.f16640b;
        dd.c.c(r13.q(), "view_load_fail");
        String r16 = r10.getMessage();
        if (r16 != null) goto L5;
        r16 = "";
    L5:
        AbsBulletMonitorCallback$ErrStage r17 = AbsBulletMonitorCallback$ErrStage.f6030c;
        if (Intrinsics.areEqual(r13.o().f5308w.f5279j.getLoaderResult(), Boolean.FALSE) == false) goto L9;
        r17 = AbsBulletMonitorCallback$ErrStage.d;
    L15:
        if (r13.f6051m == false) goto L18;
        r13.o().f5308w.getClass();
        r13.f(r17, r16);
        return;
    L18:
        return;
    L9:
        if (Intrinsics.areEqual(r13.o().f5309x.f5347b, "unknown") == false) goto L12;
        r17 = AbsBulletMonitorCallback$ErrStage.e;
        goto L15
    L12:
        if (StringsKt.P(r16, "container_error") == false) goto L15;
        r17 = AbsBulletMonitorCallback$ErrStage.f6029b;
        goto L15
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void u(Uri r12, com.bytedance.ies.bullet.core.container.e r13) {
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.URI_KEY);
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r14 = MapsKt.mapOf(TuplesKt.to("url", r12.toString()));
        com.bytedance.ies.bullet.base.utils.logger.b r10 = (com.bytedance.ies.bullet.base.utils.logger.b) this.f6043b.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("load_start", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "load_start", r14, r10);
        tc.c r15 = tc.c.f22119c;
        tc.c r16 = tc.c.f22119c;
        String r11 = this.f6043b.o().f;
        String r17 = "default_bid";
        if (r11 != null) goto L5;
        r11 = "default_bid";
    L5:
        Object r18 = (com.bytedance.ies.bullet.service.base.i) r16.a(com.bytedance.ies.bullet.service.base.i.class, r11);
        if (r18 != null) goto L8;
        Lazy r19 = i.d;
        r18 = m.b();
    L8:
        r18.getClass();
        Regex r110 = hd.b.f17301a;
        com.bytedance.ies.bullet.core.e r111 = this.f6043b.o();
        Intrinsics.checkNotNullParameter(r111, "mContext");
        x r20 = new x("bdx_monitor_container_load_url");
        if (r111.e == null) goto L11;
        ad.a r21 = r111.f5303q;
    L17:
        r20.f6027j = r21;
        JSONObject r22 = new JSONObject();
        if (r111.f5308w.f5274a == false) goto L20;
        String r23 = "reload_begin";
    L21:
        r22.put("stage", r23);
        r22.put("view_type", r111.f5295i.f5286a);
        r20.e = r22;
        com.lynx.tasm.utils.d.l(r20, r111.d);
        tc.c r24 = tc.c.f22119c;
        String r112 = r111.f;
        if (r112 != null) goto L24;
        r112 = "default_bid";
    L24:
        com.bytedance.ies.bullet.service.base.i r113 = (com.bytedance.ies.bullet.service.base.i) r24.a(com.bytedance.ies.bullet.service.base.i.class, r112);
        if (r113 == null) goto L27;
        ((i) r113).d(r20);
    L27:
        com.bytedance.ies.bullet.core.k r114 = this.f6043b.o().d;
        LoadStage r25 = LoadStage.f5268c;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r114.e = r25;
        com.bytedance.ies.bullet.core.k r115 = this.f6043b.o().d;
        r115.getClass();
        Intrinsics.checkNotNullParameter("load_template_start", "<set-?>");
        r115.f = "load_template_start";
        h r116 = this.f6043b;
        r116.f6051m = true;
        if (r13 == null) goto L30;
        r116.f6050l = new WeakReference(r13);
    L30:
        ExecutorService r117 = d.f6039a;
        d.a(this.f6043b.q(), "container_name", "AnnieX");
        long r118 = System.currentTimeMillis();
        h r26 = this.f6043b;
        r26.f6045c.a("container_init_start", Long.valueOf(r118));
        r26.f6045c.a("containerInitTime", Long.valueOf(r118));
        d.a(r26.q(), "container_init_start", Long.valueOf(r118));
        if (this.f6043b.o().B == true) goto L42;
        ConcurrentHashMap r119 = dd.c.f16640b;
        com.bytedance.ies.bullet.core.e r120 = this.f6043b.o();
        Intrinsics.checkNotNullParameter(r120, "bulletContext");
        if (r120.B == false) goto L35;
        Log.d("CpuMemoryHelper", "useCardMode is true. Ignore initRecordConfig");
    L38:
        dd.c.c(this.f6043b.q(), "container_load");
        h r121 = this.f6043b;
        ba.a r27 = r121.f6047i;
        com.bytedance.ies.bullet.core.e r122 = r121.o();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r122, "bulletContext");
        if (r122.B == false) goto L41;
        Log.d("FluencyMonitor", "useCardMode is true. Ignore initRecordConfig");
        goto L42
    L41:
        r27.f889b = Intrinsics.areEqual((Boolean) new vd.a(r122.g.f21723a, "enable_fluency_collection", Boolean.FALSE).f22372b, Boolean.TRUE);
        Log.i("FluencyMonitor", r27 + " enableFluencyCollection:" + r27.f889b);
        Intrinsics.checkNotNullParameter(r122, "bulletContext");
        goto L42
    L35:
        boolean r28 = Intrinsics.areEqual((Boolean) new vd.a(r120.g.f21723a, "enable_perf_collection", Boolean.FALSE).f22372b, Boolean.TRUE);
        boolean r29 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, "initRecordConfig", "initRecordConfig=" + r28, "CpuMemoryHelper");
        if (r28 == false) goto L38;
        LinkedHashMap r30 = new LinkedHashMap();
        r30.put("initTime", Long.valueOf(System.currentTimeMillis()));
        r30.put("appCpuStat", Long.valueOf(com.bytedance.apm.util.a.h()));
        r30.put("totalCpuStat", Long.valueOf(com.bytedance.apm.util.a.m()));
        z4.a r31 = new z4.a();
        r120.f5308w.f5278i = r31;
        Intrinsics.checkNotNullParameter(r30, "initCpuinfoMap");
        com.bytedance.ies.bullet.service.base.b.b(8, "initRecordConfig", "initRecordConfig=" + r28, "CpuMemoryPerfMetric");
        r31.d = r30;
        ((AtomicBoolean) r31.f23391c).set(r28);
    L42:
        ad.a r123 = this.f6043b.o().f5303q;
        if (r123 == null) goto L47;
        String r124 = r123.a();
        if (r124 == null) goto L47;
        mn.h.a().e(this.f6043b.q(), r124);
    L47:
        d.a(this.f6043b.q(), "view_type", this.f6043b.o().f5295i.f5286a);
        String r125 = this.f6043b.q();
        String r126 = this.f6043b.o().f;
        if (r126 == null) goto L51;
        r17 = r126;
    L51:
        d.a(r125, "biz", r17);
        d.a(this.f6043b.q(), "core_view_type", "BulletCard");
        d.a(this.f6043b.q(), "client_component", this.f6043b.o().f5296j.f5185a);
        mn.h.a().c(this.f6043b.q(), this.f6043b.o().f5296j.f5185a);
        String r127 = this.f6043b.q();
        final h r128 = this.f6043b;
        Function1<com.bytedance.salamander.anniex.o, Unit> r129 = new DefaultBulletMonitorCallback$bulletCallback$1$onLoadStart$4(r128);
        Intrinsics.checkNotNullParameter(r127, "sessionId");
        Intrinsics.checkNotNullParameter(r129, "block");
        return;
    L20:
        r23 = "start_load";
        goto L21
    L11:
        ad.a r32 = r111.f5303q;
        if (r32 == null) goto L15;
        Uri r33 = r32.f157a;
        if (r33 == null) goto L15;
    L16:
        r21 = new ad.a(r33);
    L15:
        r33 = Uri.EMPTY;
        goto L16
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r13 = this.f6043b;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("load_model_success", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "load_model_success", null, r14);
        ConcurrentHashMap r15 = dd.c.f16640b;
        dd.c.c(r13.q(), "view_create_begin");
    }
}
