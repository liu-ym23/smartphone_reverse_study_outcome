package com.bytedance.android.anniex.monitor;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.scene.core.j;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.forest.m;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$ErrStage;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.TraceEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import org.json.JSONObject;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f3335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f3336b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f3337c = null;
    public static final LinkedHashMap d = null;
    public static final LinkedHashMap e = null;
    public static final LinkedHashMap f = null;
    public static final LinkedHashMap g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LinkedHashMap f3338h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LinkedHashMap f3339i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f3340j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CopyOnWriteArraySet f3341k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f3342l = false;

    static {
        f3335a = new LinkedHashMap();
        f3336b = new LinkedHashMap();
        f3337c = new LinkedHashMap();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        f3338h = new LinkedHashMap();
        f3339i = new LinkedHashMap();
        f3340j = LazyKt.lazy(MonitorManager$handler$2.f3263a);
        f3341k = new CopyOnWriteArraySet();
        LazyKt.lazy(MonitorManager$devtoolReportFunction$2.f3262a);
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r10 = (e) yc.a.a(e.class, "default_bid");
        if (r10 == null) goto L7;
        d r11 = (d) r10.a(d.class);
        if (r11 == null) goto L7;
        boolean r12 = r11.P0();
    L8:
        f3342l = r12;
        return;
    L7:
        r12 = true;
        goto L8
    }

    public static void A(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onLynxModelCreateEnd$1$1(r5, r10));
        TraceEvent.a(0, "lynx_model_init");
    }

    public static void B(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onLynxReadTemplateBegin$1$1(r5, r10));
        TraceEvent.c("read_template");
    }

    public static void C(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onLynxRenderTemplateBegin$1$1(r5, r10));
        TraceEvent.a(0, "rl_to_render");
    }

    public static void D(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onLynxRenderTemplateEnd$1$1(r5, r10));
    }

    public static void E(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onPageStart$1$1(r5, r10));
    }

    public static void F(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        TraceEvent.c("resource_load");
        TraceEvent.c("download_template");
        o(r5, new MonitorManager$onPrepareTemplateBegin$1$1(r5, r10));
    }

    public static void G(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onPrepareTemplateEnd$1$1(r5, r10));
        TraceEvent.a(0, "download_template");
    }

    public static void H(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        o(r5, new MonitorManager$removeMonitorInfo$1(r5));
        CopyOnWriteArraySet r10 = f3341k;
        if (r10.contains(r5) == false) goto L6;
        j5.b r11 = j5.e.f18241a;
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        j5.e.f18243c.post(new com.bytedance.apm.d(r5, 6));
        r10.remove(r5);
        return;
    }

    public static void I(String r10) {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r11 = (e) yc.a.a(e.class, "default_bid");
        if (r11 == null) goto L7;
        d r12 = (d) r11.a(d.class);
        if (r12 == null) goto L7;
        boolean r13 = r12.z0();
    L8:
        if (r13 == false) goto L48;
        LinkedHashMap r14 = f3339i;
        a r15 = (a) r14.get(r10);
        int r16 = 0;
        if (r15 != null) goto L13;
    L15:
        boolean r17 = false;
    L16:
        if (r17 == true) goto L49;
        a r18 = (a) r14.get(r10);
        if (r18 == null) goto L22;
        r18.f3331b = true;
    L22:
        x4.d r19 = j5.e.a(r10);
        k8.a r20 = r19.f22957c;
        if (r20.f18625b == 99999999) goto L25;
        r16 = r20.f18626c;
        String r21 = (String) r20.d;
    L32:
        l r22 = J(r10);
        x r23 = new x("bdx_monitor_end_to_end_trace");
        r23.f6027j = p(r10).f5328k;
        JSONObject r24 = new JSONObject();
        a r25 = (a) r14.get(r10);
        String r26 = null;
        if (r25 == null) goto L35;
        String r27 = r25.f3332c;
    L36:
        a r28 = (a) r14.get(r10);
        if (r28 == null) goto L39;
        r26 = r28.e;
    L39:
        r24.put("stage", r26);
        r24.put(NotificationCompat.CATEGORY_STATUS, r27);
        r24.put("error_message", r21);
        r24.put("template_res_type", r22.f5347b);
        r24.put("domain_error_code", r16);
        r23.e = r24;
        JSONObject r29 = new JSONObject();
        long r30 = q(r10, f3335a).d("open_time");
        if (r30 > 0) goto L43;
        r30 = System.currentTimeMillis();
    L43:
        r29.put("stay_duration", System.currentTimeMillis() - r30);
        r29.put("native_error_count", r19.e);
        r29.put("res_loader_error_count", r19.f22960j);
        r29.put("res_loader_error_template_count", r19.f22960j);
        r29.put("static_error_count", r19.f);
        r29.put("fetch_error_count", r19.g);
        r29.put("jsb_error_count", r19.f22958h);
        r29.put("js_exception_error_count", r19.d);
        r23.f = r29;
        r23.d = r10;
        tc.c r110 = tc.c.f22119c;
        i r111 = (i) tc.c.f22119c.a(i.class, "default_bid");
        if (r111 == null) goto L47;
        ((com.bytedance.ies.bullet.service.monitor.i) r111).d(r23);
        return;
    L47:
        return;
    L35:
        r27 = null;
        goto L36
    L25:
        a r31 = (a) r14.get(r10);
        if (r31 == null) goto L28;
        r16 = r31.g;
    L28:
        a r32 = (a) r14.get(r10);
        if (r32 == null) goto L31;
        r21 = r32.f;
        goto L32
    L31:
        r21 = "";
        goto L32
    L49:
        return;
    L13:
        if (r15.f3331b != true) goto L15;
        r17 = true;
        goto L16
    L48:
        return;
    L7:
        r13 = true;
        goto L8
    }

    public static l J(String r5) {
        LinkedHashMap r10 = f3338h;
        if (r10.containsKey(r5) == false) goto L6;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (l) r11;
    L6:
        l r12 = new l();
        r10.put(r5, r12);
        return r12;
    }

    public static id.a a(String r5, LinkedHashMap r10) {
        if (r10.containsKey(r5) == false) goto L6;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (id.a) r11;
    L6:
        id.a r12 = new id.a(1);
        r10.put(r5, r12);
        return r12;
    }

    public static final String b(AbsBulletMonitorCallback$ErrStage r5) {
        int r10 = r5.ordinal();
        if (r10 != 0) goto L5;
        return "load_container_fail";
    L5:
        if (r10 != 1) goto L7;
        return "load_engine_fail";
    L7:
        if (r10 != 2) goto L9;
        return "load_plugin_fail";
    L9:
        if (r10 == 4) goto L12;
        return "load_fail";
    L12:
        return "load_template_fail";
    }

    public static AtomicInteger c(String r5) {
        LinkedHashMap r10 = f;
        if (r10.containsKey(r5) == false) goto L6;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (AtomicInteger) r11;
    L6:
        AtomicInteger r12 = new AtomicInteger(0);
        r10.put(r5, r12);
        return r12;
    }

    public static void d(int r5, final String r10) {
        if ((r5 & 2) == 0) goto L5;
        final boolean r11 = false;
    L6:
        KitType r12 = KitType.d;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "kitType");
        o(r10, new MonitorManager$reportInfo$1(r10, r11));
        return;
    L5:
        r11 = true;
        goto L6
    }

    public static void e(final Uri r5, final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        o(r10, new MonitorManager$updateUriIdentifier$1(r10, r5));
    }

    public static void f(final AnnieXCardScene r5, final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "annieXCardScene");
        o(r10, new MonitorManager$onLoadStart$1(r5, r10));
    }

    public static void g(final AnnieXLynxView r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r11 = System.currentTimeMillis();
        o(r10, new MonitorManager$onKitViewCreateEnd$1$1(r10, r11, r5));
        TraceEvent.a(0, "create_lynxview");
    }

    public static void h(final String r12, final m r13, final String r14, final long r15, final double r17) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "customResFrom");
        final long r5 = System.currentTimeMillis();
        o(r12, new MonitorManager$onLynxReadTemplateEnd$1$1(r13, r12, r5, r14, r15, r17));
        TraceEvent.a(0, "read_template");
        TraceEvent.a(0, "resource_load");
        TraceEvent.c("rl_to_render");
    }

    public static void i(final String r10, final AbsBulletMonitorCallback$ErrStage r11, final String r12, final String r13, final AnnieXLynxView r14) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "errStage");
        Intrinsics.checkNotNullParameter(r13, "errMessage");
        if (TraceEvent.f10115c == true) goto L5;
        Log.e("AnnieXMonitorManager", r12 + " onLoadError " + r11 + ", " + r13);
    L5:
        o(r12, new MonitorManager$onLoadFail$2(r12, r11, r13, r10, r14));
    }

    public static void j(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        long r5 = r11.longValue();
        q(r10, f3335a).a("open_time", r11);
        j5.b r12 = j5.e.f18241a;
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.D(r10, "monitorId", "open_time", "field", "collectLong [monitorId:");
        r13.append(r10);
        r13.append("][field:open_time][value:");
        r13.append(r5);
        r13.append(']');
        d5.b.f("ContainerStandardApi", r13.toString());
        j5.e.c(r10, "open_time", r11);
    }

    public static void k(final String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        if (f3342l == true) goto L5;
        return;
    L5:
        final boolean r11 = ((Boolean) com.bytedance.android.anniex.scene.settings.a.f3449c.getValue()).booleanValue();
        if (r11 == false) goto L16;
        j r12 = h.a();
        if (r10 != null) goto L14;
        ad.a r13 = p(r5).f5328k;
        if (r13 == null) goto L12;
        String r14 = r13.a();
    L13:
        String r15 = String.valueOf(r14);
    L15:
        r12.e(r5, r15);
        goto L16
    L12:
        r14 = null;
        goto L13
    L14:
        r15 = r10;
    L16:
        o(r5, new MonitorManager$onAttachToWindow$1(r11, r5, r10));
    }

    public static void l(final String r10, final String r11, final AnnieXCardScene r12) {
        Intrinsics.checkNotNullParameter(r10, "originalSessionId");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "annieXCardScene");
        final long r5 = System.currentTimeMillis();
        o(r11, new MonitorManager$onLynxViewReused$1$1(r11, r12, r10, r5));
    }

    public static void m(final String r5, final Map r10, final LynxDevtool r11) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        o(r5, new MonitorManager$onTimingSetup$1(r5, r10, r11));
    }

    public static void n(final String r5, final Map r10, final Map r11, final String r12) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        o(r5, new MonitorManager$onTimingUpdate$1(r5, r10, r11, r12));
    }

    public static void o(String r5, Function0 r10) {
        if (f3341k.contains(r5) == true) goto L6;
        ((Handler) f3340j.getValue()).post(new b(0, r10));
        return;
    }

    public static k p(String r5) {
        LinkedHashMap r10 = g;
        if (r10.containsKey(r5) == false) goto L6;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (k) r11;
    L6:
        k r12 = new k(r5);
        r10.put(r5, r12);
        return r12;
    }

    public static id.c q(String r5, LinkedHashMap r10) {
        if (r10.containsKey(r5) == false) goto L6;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (id.c) r11;
    L6:
        id.c r12 = new id.c(1);
        r10.put(r5, r12);
        return r12;
    }

    public static void r(final String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "viewType");
        o(r5, new MonitorManager$onClientComponent$1(r5, r10));
    }

    public static void s(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onFirstScreen$1$1(r5, r10));
    }

    public static void t(final String r5, final String r10) {
        AbsBulletMonitorCallback$ErrStage r11 = AbsBulletMonitorCallback$ErrStage.f6029b;
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "errStage");
        Intrinsics.checkNotNullParameter("open_dialog_fragment_with_no_activity", "errMessage");
        o(r10, new MonitorManager$onContainerError$1(r10, r5));
    }

    public static void u(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onJsbRegisterBegin$1$1(r5, r10));
    }

    public static void v(final String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r11 = System.currentTimeMillis();
        TraceEvent.c("lynx_model_init");
        o(r10, new MonitorManager$onLynxModelCreateBegin$1$1(r10, r5, r11));
    }

    public static void w(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onJsbRegisterEnd$1$1(r5, r10));
    }

    public static void x(final String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r11 = System.currentTimeMillis();
        TraceEvent.c("web_model_init");
        o(r10, new MonitorManager$onWebModelCreateBegin$1$1(r10, r5, r11));
    }

    public static void y(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        TraceEvent.c("create_lynxview");
        o(r5, new MonitorManager$onKitViewCreateBegin$1$1(r5, r10));
    }

    public static void z(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        final long r10 = System.currentTimeMillis();
        o(r5, new MonitorManager$onLoadSuccess$1$1(r5, r10));
    }
}
