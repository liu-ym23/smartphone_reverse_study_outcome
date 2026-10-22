package com.bytedance.android.monitorV2.webview;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.room.writer.DaoWriter;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f3753x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f3754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3756c;
    public String d;
    public JSONObject e;
    public boolean f;
    public final m5.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x4.a f3757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x4.a f3758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x4.d f3759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f3760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f3765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f3766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f3767r;
    public final int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m5.d f3768t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final x4.i f3769u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i4.a f3770v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f3771w;

    static {
        f3753x = LazyKt.lazy(NavigationDataManager$Companion$navigationInfoCollector$2.f3734a);
    }

    public c(i r5) {
        Intrinsics.checkNotNullParameter(r5, "webViewDataManager");
        this.f3754a = r5;
        this.f3756c = System.currentTimeMillis();
        this.d = "";
        this.e = new JSONObject();
        m5.b r10 = new m5.b();
        this.g = r10;
        this.f3759j = new x4.d(r10);
        this.f3760k = new f(this);
        new BidInfo$BidConfig("__hybrid_default");
        new NavigationDataManager$dataHandlerPostProcessor$1(this);
        this.f3761l = "web";
        this.f3762m = "web";
        this.f3764o = true;
        this.f3767r = System.currentTimeMillis() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + UUID.randomUUID().toString();
        this.s = 15;
        this.f3768t = new m5.d(r10);
        this.f3769u = new x4.i();
        this.f3770v = new i4.a(CollectionsKt.listOf(new String[]{"res_loader_perf_template", "res_loader_perf", "jsbPerf"}), 20);
        this.f3771w = LazyKt.lazy(new NavigationDataManager$perfEvent$2(this));
        d5.b.c("NavigationDataManager", "buildNewNavigation cache new url : " + this.f3755b);
        if (r5.h() == false) goto L5;
        this.f3762m = "ttweb";
    L5:
        Map r11 = MapsKt.toMap(r5.f3788n);
        Iterator r12 = r11.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        String r13 = (String) r12.next();
        Integer r14 = (Integer) r11.get(r13);
        if (r14 == null) goto L7;
        qo.a.j(Integer.valueOf(r14.intValue()), r13, this.g.f19996m);
        goto L7
    L11:
        WebView r15 = this.f3754a.a();
        x4.a r16 = null;
        if (r15 == null) goto L14;
        x4.a r17 = j5.b.g(r15);
    L15:
        this.f3757h = r17;
        WebView r18 = this.f3754a.a();
        if (r18 == null) goto L18;
        r16 = j5.b.d(r18);
    L18:
        this.f3758i = r16;
        f();
        return;
    L14:
        r17 = null;
        goto L15
    }

    public final void a(com.bytedance.android.monitorV2.event.a r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (Intrinsics.areEqual("blank", r5.f3557a) == false) goto L5;
        qo.a.k("enter_page_time", this.f3756c, r10);
    L5:
        m5.b r11 = this.g;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.f = r11;
        String r12 = r5.f3557a;
        if (r10 != null) goto L8;
        r10 = new JSONObject();
    L8:
        r5.f3550m = new m5.c(r12, r10);
        f r13 = this.f3760k;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        r13.f3775b.c(r13.f3776c, r5, true);
        sj.g.l();
        this.f3759j.u(r5);
        String r14 = r5.f3557a;
        m5.d r15 = this.f3768t;
        r15.getClass();
        if (TextUtils.isEmpty(r14) == true) goto L16;
        JSONObject r16 = r15.f20008n;
        int r17 = 0;
        if (r16 == null) goto L15;
        r17 = r16.optInt(r14, 0);
    L15:
        qo.a.e(r17 + 1, r14, r16);
        r15.f20009o.add(r14);
        d5.b.c("WebPerfReportData", "addCount: " + r14);
    L16:
        this.f3770v.o(r5);
    }

    public final void b(String r10, JSONObject r11) {
        int r5 = 0;
        if (r10 == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a(r10);
        r12.e();
        LinkedHashMap r13 = r12.e;
        b r14 = (b) this.f3754a.e.getValue();
        if (r14 == null) goto L7;
        String r15 = r14.d;
    L8:
        r13.put("config_bid", r15);
        m5.b r16 = this.g;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r12.f = r16;
        r12.f3552o = qo.a.d(r11, "jsInfo");
        r12.g = qo.a.d(r11, "jsBase");
        f r17 = this.f3760k;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r12, "event");
        r17.f3775b.c(r17.f3776c, r12, true);
        sj.g.l();
        x4.d r18 = this.f3759j;
        r18.u(r12);
        Intrinsics.checkNotNullParameter(r12, "event");
        r18.t(r12, 0, "");
        goto L9
    L7:
        r15 = null;
    L9:
        m5.d r19 = this.f3768t;
        r19.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        JSONObject r20 = r19.f20008n;
        if (r20 == null) goto L16;
        r5 = r20.optInt(r10, 0);
    L16:
        qo.a.e(r5 + 1, r10, r20);
        r19.f20009o.add(r10);
        d5.b.c("WebPerfReportData", "addCount: " + r10);
    }

    public final void c(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        m5.d r5 = this.f3768t;
        r5.getClass();
        if (r10 == null) goto L6;
        r5.f20000b = new JSONObject();
        r5.f20001c = new JSONObject();
        qo.a.m(r5.f20000b, r10.optJSONObject("jsBase"));
        qo.a.m(r5.f20001c, r10.optJSONObject("jsInfo"));
    L6:
        if (this.f3766q == false) goto L8;
        return;
    L8:
        ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).g = r10.optJSONObject("jsBase");
        ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).f3552o = r10.optJSONObject("jsInfo");
        JSONObject r11 = ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).f3552o;
        if (r11 == null) goto L21;
        Function1<Long, Unit> r12 = new NavigationDataManager$coverPerfEvent$1$1(this);
        ko.r r13 = new ko.r(r11);
        long r14 = r13.o("actual_fmp").longValue();
        if (r14 != 0) goto L13;
        r14 = r13.o("fmp").longValue();
    L13:
        long r15 = r13.o("timing.navigationStart").longValue();
        if (r14 != 0) goto L17;
        long r16 = System.currentTimeMillis();
    L20:
        r12.invoke(Long.valueOf(r16));
        goto L21
    L17:
        if (r15 != 0) goto L19;
        r16 = System.currentTimeMillis();
        goto L20
    L19:
        r16 = r15 + r14;
    L21:
        ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).g();
        JSONObject r17 = ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).f3552o;
        if (r17 != null) goto L24;
    L26:
        d5.b.f("NavigationDataManager", "coverPerf " + ((com.bytedance.android.monitorV2.event.a) this.f3771w.getValue()).hashCode());
        return;
    L24:
        if (r17.has("actual_fmp") == false) goto L26;
        this.f3759j.s(4);
        goto L26
    }

    public final boolean d(String r10) {
        if (this.f3764o == true) goto L28;
        return false;
    L28:
        String r11 = Uri.parse(r10).getHost();     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        List r12 = StringsKt.K(r11, new String[]{"."}, 0, 6);     // Catch: Throwable -> L8
    L11:
        String r5 = "";
        if (r12 == null) goto L19;
        int r13 = r12.size();     // Catch: Throwable -> L8
        if (r13 < 2) goto L17;
        String r14 = ((String) r12.get(r13 - 2)) + '.' + ((String) r12.get(r13 - 1));     // Catch: Throwable -> L8
    L16:
        r5 = r14;
        goto L19
    L17:
        r14 = (String) CollectionsKt.last(r12);     // Catch: Throwable -> L8
    L19:
        if (r5.length() > 0) goto L21;
    L24:
        this.f3764o = false;     // Catch: Throwable -> L8
        return false;
    L21:
        if (com.bytedance.android.monitorV2.h.e().a().f().contains(r5) == false) goto L24;
        this.f3764o = true;     // Catch: Throwable -> L8
        return true;
    L10:
        r12 = null;
    L8:
        th = move-exception;
        mn.h.g("default_handle", th);
        this.f3764o = false;
        return false;
    }

    public final void e() {
        if (this.f3755b != null) goto L6;
        return;
    L6:
        if (this.f3766q == false) goto L8;
        return;
    L8:
        this.f3766q = true;
        m5.d r5 = this.f3768t;
        r5.getClass();
        r5.f20004j = System.currentTimeMillis();
        g();
        d5.b.f("NavigationDataManager", "clearNavigationData");
        f();
        g();
        f r10 = this.f3760k;
        com.bytedance.android.monitorV2.event.a r11 = (com.bytedance.android.monitorV2.event.a) this.f3771w.getValue();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "event");
        r10.f3775b.c(r10.f3776c, r11, true);
        sj.g.l();
        this.f3760k.f3775b.a();
    }

    public final void f() {
        i r5 = this.f3754a;
        r5.getClass();
        JSONObject r10 = new JSONObject();
        j r11 = (j) r5.f3784j.get(WebViewLifeState.f3744b);
        Long r12 = null;
        if (r11 == null) goto L5;
        Long r13 = Long.valueOf(r11.f3797a);
    L6:
        qo.a.j(r13, "attach_ts", r10);
        j r14 = (j) r5.f3784j.get(WebViewLifeState.f3745c);
        if (r14 == null) goto L9;
        Long r15 = Long.valueOf(r14.f3797a);
    L10:
        qo.a.j(r15, "detach_ts", r10);
        j r16 = (j) r5.f3784j.get(WebViewLifeState.f3743a);
        if (r16 == null) goto L13;
        r12 = Long.valueOf(r16.f3797a);
    L13:
        qo.a.j(r12, "container_init_ts", r10);
        boolean r17 = false;
        if (r5.f3785k <= 1) goto L16;
        boolean r18 = true;
    L17:
        qo.a.j(Boolean.valueOf(r18), "container_reuse", r10);
        qo.a.t("web_version", r5.f3789o, r10);
        m5.b r19 = this.g;
        r19.getClass();
        Iterator<String> r20 = r10.keys();
    L19:
        if (r20.hasNext() == false) goto L21;
        String r21 = r20.next();
        qo.a.j(r10.opt(r21), r21, r19.f19995l);
        goto L19
    L21:
        r19.f22975c = this.f3761l;
        String r22 = this.f3762m;
        r19.f19994k = r22;
        r19.f22973a = this.f3755b;
        if (sk.a.f21938a != 0) goto L24;
        sk.a.f21938a = System.currentTimeMillis();
    L24:
        r19.e = sk.a.f21938a;
        r19.f19993j = this.f3765p;
        r19.f22974b = this.f3767r;
        JSONObject r23 = new JSONObject();
        WebView r24 = r5.a();
        if (r24 == null) goto L33;
        k r25 = k.d;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.bytedance.android.monitorV2.webview.WebViewMonitorHelper");
        if (r25.v() == true) goto L29;
    L31:
        r23.put("use_ttweb_hook", r17);
        r23.put("webview_type", r22);
        goto L33
    L29:
        if (com.bytedance.android.monitorV2.webview.ttweb.a.b(r24) == false) goto L31;
        r17 = true;
    L33:
        if (r19.g != null) goto L35;
        r19.g = new JSONObject();
    L35:
        qo.a.m(r19.g, r23);
        WebView r26 = r5.a();
        if (r26 == null) goto L47;
        Activity r27 = l9.o.a(r26.getContext());
        if (r27 == null) goto L48;
        com.bytedance.android.monitorV2.h r28 = com.bytedance.android.monitorV2.h.e();
        if (r28.f3583c == false) goto L44;
        com.bytedance.android.monitorV2.f r29 = r28.d;
        if (r29 == null) goto L44;
        r29.a(r27);
    L44:
        r19.d = r27.getClass().getName();
        return;
    L48:
        return;
    L47:
        return;
    L16:
        r18 = false;
        goto L17
    L9:
        r15 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public final void g() {
        Lazy r5 = this.f3771w;
        com.bytedance.android.monitorV2.event.a r10 = (com.bytedance.android.monitorV2.event.a) r5.getValue();
        r10.f3560h = this.f3757h;
        com.bytedance.android.monitorV2.event.a r11 = (com.bytedance.android.monitorV2.event.a) r5.getValue();
        r11.f3551n = this.f3758i;
        com.bytedance.android.monitorV2.event.a r12 = (com.bytedance.android.monitorV2.event.a) r5.getValue();
        r12.getClass();
        m5.b r13 = this.g;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.f = r13;
        m5.c r14 = this.f3768t.d;
        x4.i r15 = this.f3769u;
        r15.f22978b = r14;
        ((com.bytedance.android.monitorV2.event.a) r5.getValue()).f3550m = r15;
        ((com.bytedance.android.monitorV2.event.a) r5.getValue()).g();
    }

    public c(i r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "webViewDataManager");
        Intrinsics.checkNotNullParameter(r10, "url");
        this(r5);
        this.f3755b = r10;
        this.g.f22973a = r10;
    }
}
