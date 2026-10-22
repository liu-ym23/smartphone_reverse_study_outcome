package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils$MetricsArgs;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.extension.TTWebViewExtension;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.webx.blankdetect.BlankUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements IWebViewLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f3780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3781c;
    public final f9.a d;
    public final Lazy e;
    public c f;
    public WebViewLifeState g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f3782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f3783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f3784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap f3786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f3787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap f3788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3789o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f3791q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3792r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f3793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f3794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f3795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f3796w;

    public i(WeakReference r5, m r10) {
        Intrinsics.checkNotNullParameter(r5, "webViewRef");
        Intrinsics.checkNotNullParameter(r10, "webViewMonitorHelperImpl");
        this.f3779a = r5;
        this.f3780b = r10;
        String r11 = "";
        this.f3781c = "";
        this.d = com.bytedance.android.monitorV2.h.e().a().d();
        this.e = LazyKt.lazy(new WebViewDataManager$config$2(this));
        this.f3784j = new HashMap();
        this.f3786l = new HashMap();
        this.f3787m = new Handler(Looper.getMainLooper());
        this.f3788n = new HashMap();
        WebView r12 = a();     // Catch: Throwable -> L20
        if (r12 == null) goto L8;
        WebSettings r13 = r12.getSettings();     // Catch: Throwable -> L20
        if (r13 == null) goto L8;
        String r14 = r13.getUserAgentString();     // Catch: Throwable -> L20
    L9:
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        int r15 = StringsKt.r("Chrome/", 0, 6, r14);     // Catch: Throwable -> L20
        if (r15 == (-1)) goto L14;
        r15 = r15 + 7;     // Catch: Throwable -> L20
    L14:
        List r16 = StringsKt.K(r14.substring(r15), new String[]{" "}, 0, 6);     // Catch: Throwable -> L20
        if (r16.isEmpty() == true) goto L18;
        r11 = (String) r16.get(0);     // Catch: Throwable -> L20
    L8:
        r14 = null;
    L18:
        this.f3789o = r11;
        this.f3790p = true;
        this.f3791q = true;
        this.f3793t = LazyKt.lazy(new WebViewDataManager$webViewRootManager$2(this));
        this.f3794u = LazyKt.lazy(WebViewDataManager$blankConfig$2.f3739a);
        this.f3795v = LazyKt.lazy(WebViewDataManager$enableKernelBlankLog$2.f3741a);
        this.f3796w = new HashMap();
    }

    public final WebView a() {
        WebView r5 = (WebView) this.f3779a.get();
        if (r5 != null) goto L5;
        d5.b.e("WebViewDataManager", "get webView from weakRef: null");
    L5:
        return r5;
    }

    public final void b(WebView r10) {
        JSONObject r5 = new JSONObject();
        boolean r11 = false;
        if (r10.getVisibility() != 0) goto L5;
        boolean r12 = true;
    L6:
        r5.put("hm_webView_visibility", r12);
        if (this.f3785k <= 1) goto L9;
        r11 = true;
    L9:
        r5.put("hm_webView_reuse", r11);
        r5.put("hm_webView_load", this.f3785k);
        JSONObject r13 = new JSONObject();
        j r14 = (j) this.f3784j.get(WebViewLifeState.f3743a);
        if (r14 == null) goto L12;
        long r15 = r14.f3797a;
    L13:
        r13.put("hm_webView_sd", System.currentTimeMillis() - r15);
        r13.put("hm_webView_width", r10.getWidth());
        r13.put("hm_webView_height", r10.getHeight());
        boolean r16 = this.f3791q;
        com.bytedance.android.monitorV2.settings.h r17 = (com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue();
        Intrinsics.checkNotNullParameter(r10, "webView");
        Intrinsics.checkNotNullParameter(r17, "detectConfig");
        Intrinsics.checkNotNullParameter(r5, "category");
        Intrinsics.checkNotNullParameter(r13, LynxMonitorService.KEY_METRICS);
        if (r10.getWidth() > 0) goto L16;
        return;
    L16:
        if (r10.getHeight() <= 0) goto L21;
        JSONObject r18 = new JSONObject();
        r18.put("is_blank", r16);
        r18.put("use_monitor_detect", r17.d());
        r18.put("detect_type", r17.a());
        r18.put("stay_duration", r17.b());
        k r19 = k.d;
        com.bytedance.ies.web.jsbridge2.l r20 = new com.bytedance.ies.web.jsbridge2.l("ttwebview_blank_detect_from_monitor", 1);
        r20.f6292h = qo.a.q(r5, r18);
        r20.f6293i = r13;
        r20.b(1);
        r19.l(r10, r20.a());
        return;
    L21:
        return;
    L12:
        r15 = System.currentTimeMillis();
        goto L13
    L5:
        r12 = false;
        goto L6
    }

    public final void c(WebViewLifeState r5) {
        this.g = r5;
        this.f3784j.put(r5, new j(System.currentTimeMillis()));
    }

    public final void d(JSONObject r14) {
        if (r14 == null) goto L38;
        String r5 = r14.optString("serviceType", "");
        if (Intrinsics.areEqual(r5, "") == false) goto L26;
        c r13 = this.f;
        if (r13 == null) goto L35;
        Intrinsics.checkNotNullParameter(r14, "jsonObject");
        JSONObject r10 = qo.a.c(r14.optString("category", ""));
        JSONObject r11 = qo.a.c(r14.optString(LynxMonitorService.KEY_METRICS, ""));
        JSONObject r12 = qo.a.c(r14.optString("timing", ""));
        JSONObject r15 = qo.a.c(r14.optString("extra", ""));
        String r16 = r14.optString("bid", "");
        int r17 = 0;
        int r18 = r14.optInt("level", 0);
        int r19 = r14.optInt("canSample", 0);
        boolean r110 = r14.optBoolean("canSample", true);
        if (r14.has("level") == false) goto L12;
    L11:
        r17 = r18;
    L16:
        com.bytedance.ies.web.jsbridge2.l r20 = new com.bytedance.ies.web.jsbridge2.l(r14.optString("eventName", ""), 1);
        r20.f6292h = r10;
        r20.f6294j = r15;
        r20.f6295k = r12;
        r20.f6293i = r11;
        r20.b(r17);
        x4.c r111 = r20.a();
        if (TextUtils.isEmpty(r16) == true) goto L19;
        r111.f22948b = r16;
    L19:
        com.bytedance.android.monitorV2.event.b r21 = new com.bytedance.android.monitorV2.event.b(r111);
        LinkedHashMap r112 = r21.e;
        b r22 = (b) r13.f3754a.e.getValue();
        if (r22 == null) goto L22;
        String r23 = r22.d;
    L23:
        r112.put("config_bid", r23);
        r112.put("jsb_bid", r13.d);
        r21.e();
        Intrinsics.checkNotNullParameter(r21, "customEvent");
        f r113 = r13.f3760k;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r21, "event");
        r113.f3775b.c(r113.f3776c, r21, true);
        Lazy r114 = c.f3753x;
        sj.g.l();
        return;
    L22:
        r23 = null;
        goto L23
    L12:
        r18 = 2;
        if (r14.has("canSample") == false) goto L11;
        if (r19 == 0) goto L16;
        if (r110 == true) goto L11;
    L35:
        return;
    L26:
        if (Intrinsics.areEqual(r5, "perf") == false) goto L31;
        r14.optString("url", "");
        c r115 = this.f;
        if (r115 == null) goto L36;
        r115.c(r14);
        return;
    L36:
        return;
    L31:
        c r116 = this.f;
        if (r116 == null) goto L37;
        r116.b(r5, r14);
        return;
    L37:
        return;
    }

    public final void e(boolean r10) {
        if (r10 == true) goto L5;
        return;
    L5:
        if (this.s == false) goto L7;
        return;
    L7:
        this.s = true;
        g(true);
        WebView r11 = a();
        if (r11 == null) goto L28;
        Lazy r5 = com.bytedance.android.monitorV2.webview.ttweb.a.f3832a;
        JSONObject r12 = com.bytedance.android.monitorV2.webview.ttweb.a.a(r11, TTUtils$MetricsArgs.f3824c);
        c r13 = this.f;
        if (r13 == null) goto L26;
        ko.r r14 = new ko.r(r12);
        String r15 = r14.p("webview_error.render_status");
        x4.d r16 = r13.f3759j;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r16.f22961k = r15;
        String r17 = r14.p("webview_error.dom_state");
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.f22962l = r17;
        String r18 = r14.p("webview_error.rendering_phase");
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.f22963m = r18;
        String r19 = r14.p("webview_error.js_hang");
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r16.f22964n = r19;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter("webview_error", STGroup.DICT_KEY);
        Object r20 = r12.opt("webview_error");
        JSONArray r21 = null;
        if (r20 != null) goto L14;
    L16:
        JSONObject r22 = null;
    L17:
        if (r22 == null) goto L26;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter("js_error", STGroup.DICT_KEY);
        Object r23 = r22.opt("js_error");
        if (r23 != null) goto L21;
    L23:
        if (r21 == null) goto L26;
        r16.d = r21.length() + r16.d;
        goto L26
    L21:
        if ((r23 instanceof JSONArray) == false) goto L23;
        r21 = (JSONArray) r23;
        goto L23
    L14:
        if ((r20 instanceof JSONObject) == false) goto L16;
        r22 = (JSONObject) r20;
    L26:
        if (((Boolean) this.f3795v.getValue()).booleanValue() == false) goto L28;
        d5.b.f("WebViewDataManager", "KernelErrorInfo: WebView: " + r11 + ", Url: " + r11.getUrl() + ", KernelInfo: " + r12);
    L28:
        f();
        c r24 = this.f;
        if (r24 == null) goto L33;
        f r25 = r24.f3760k;
        if (r25 == null) goto L33;
        r25.f3775b.a();
    L33:
        this.f3787m.postDelayed(new r(this, 2), 150);
    }

    public final void f() {
        boolean r5 = true;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        com.bytedance.android.monitorV2.event.a r11 = oo.j.b();     // Catch: Throwable -> L6
        c r12 = this.f;     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        Map r13 = com.bytedance.android.monitorV2.i.f3604a;     // Catch: Throwable -> L6
        com.bytedance.android.monitorV2.i.a(r12.g.f22974b, "blank_check", null, null, 12);     // Catch: Throwable -> L6
    L8:
        WebViewLifeState r14 = this.g;     // Catch: Throwable -> L6
        if (r14 == null) goto L11;
        int r15 = r14.ordinal();     // Catch: Throwable -> L6
    L13:
        if (r15 < 3) goto L16;
        r11.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L6
        return;
    L16:
        WebView r16 = a();     // Catch: Throwable -> L6
        if (r16 != null) goto L21;
        r11.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L6
        return;
    L21:
        if (r16.getUrl() != null) goto L23;
    L99:
        r11.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L6
        return;
    L23:
        if (Intrinsics.areEqual(r16.getUrl(), "about:blank") == true) goto L99;
        HashMap r17 = this.f3796w;     // Catch: Throwable -> L6
        String r18 = r16.getUrl();     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L6
        Object r19 = r17.get(r18);     // Catch: Throwable -> L6
        Boolean r20 = Boolean.TRUE;     // Catch: Throwable -> L6
        if (Intrinsics.areEqual(r19, r20) == false) goto L29;
        r11.b(HybridEvent$TerminateType.d);     // Catch: Throwable -> L6
        return;
    L29:
        HashMap r21 = this.f3796w;     // Catch: Throwable -> L6
        String r22 = r16.getUrl();     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L6
        r21.put(r22, r20);     // Catch: Throwable -> L6
        this.d.getClass();     // Catch: Throwable -> L6
        if (Switches.d.f3600a == true) goto L33;
        r11.b(HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L6
        return;
    L33:
        c r23 = this.f;     // Catch: Throwable -> L6
        if (r23 == null) goto L51;
        String[] r24 = ((com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue()).c();     // Catch: Throwable -> L6
        int r25 = r24.length;     // Catch: Throwable -> L6
        int r110 = 0;
    L36:
        if (r110 >= r25) goto L46;
        String r111 = r24[r110];     // Catch: Throwable -> L6
        String r112 = r23.f3755b;     // Catch: Throwable -> L6
        if (r112 != null) goto L41;
        r112 = "";
    L41:
        if (StringsKt.g(r112, r111) == true) goto L42;
        r110 = r110 + 1;     // Catch: Throwable -> L6
        goto L36
    L42:
        r11.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L6
        return;
    L46:
        if ((System.currentTimeMillis() - r23.f3756c) >= ((com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue()).b()) goto L51;
        r11.b(HybridEvent$TerminateType.e);     // Catch: Throwable -> L6
        return;
    L51:
        if (((com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue()).d() == true) goto L53;
        l5.a r26 = new l5.a();     // Catch: Throwable -> L6
        BlankUtils.DetectorResult r113 = BlankUtils.getDetectorResultFast(r16);     // Catch: Throwable -> L6
        r26.f19534a = r113.blankState;     // Catch: Throwable -> L6
        r26.d = r113.costTime;     // Catch: Throwable -> L6
        r26.e = r113.errorCode;     // Catch: Throwable -> L6
        r26.f = r113.errorMsg;     // Catch: Throwable -> L6
    L61:
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L6
        qo.a.t("event_type", "blank", r114);     // Catch: Throwable -> L6
        if (r26.f19534a != 1) goto L64;
        int r115 = 1;
    L65:
        qo.a.e(r115, "is_blank", r114);     // Catch: Throwable -> L6
        qo.a.e(((com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue()).a(), "detect_type", r114);     // Catch: Throwable -> L6
        qo.a.k("cost_time", r26.d, r114);     // Catch: Throwable -> L6
        qo.a.k("collect_time", r26.f19536c, r114);     // Catch: Throwable -> L6
        qo.a.k("calculate_time", r26.f19535b, r114);     // Catch: Throwable -> L6
        if (r26.f19534a != 3) goto L68;
        qo.a.e(r26.e, WsConstants.ERROR_CODE, r114);     // Catch: Throwable -> L6
        qo.a.t("error_msg", r26.f, r114);     // Catch: Throwable -> L6
    L68:
        b r27 = (b) this.e.getValue();     // Catch: Throwable -> L6
        if (r27 == null) goto L73;
        z r28 = r27.f;     // Catch: Throwable -> L6
        if (r28 == null) goto L73;
        r28.b(r26.f19534a);     // Catch: Throwable -> L6
    L73:
        qo.a.k("detect_start_time", System.currentTimeMillis() - r26.d, r114);     // Catch: Throwable -> L6
        c r29 = this.f;     // Catch: Throwable -> L6
        if (r29 == null) goto L106;
        qo.a.k("page_stay_duration", System.currentTimeMillis() - r29.f3756c, r114);     // Catch: Throwable -> L6
    L106:
        TTNetInit.getNetworkQuality().getClass();     // Catch: Throwable -> L78
        TTNetInit.getNetworkQuality().getClass();     // Catch: Throwable -> L78
        JSONObject r30 = new JSONObject();     // Catch: Throwable -> L78
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L78
        qo.a.j(r30, "assist_info", r114);     // Catch: Throwable -> L78
    L79:
        c r31 = this.f;     // Catch: Throwable -> L6
        if (r31 == null) goto L82;
        x4.d r32 = r31.f3759j;     // Catch: Throwable -> L6
        r32.getClass();     // Catch: Throwable -> L6
        JSONObject r33 = new JSONObject();     // Catch: Throwable -> L6
        r32.m(r33);     // Catch: Throwable -> L6
        qo.a.q(r114, r33);     // Catch: Throwable -> L6
    L82:
        c r34 = this.f;     // Catch: Throwable -> L6
        if (r34 == null) goto L85;
        r34.a(r11, r114);     // Catch: Throwable -> L6
    L85:
        c r35 = this.f;     // Catch: Throwable -> L6
        if (r35 == null) goto L94;
        LinkedHashMap r36 = new LinkedHashMap();     // Catch: Throwable -> L6
        int r37 = r26.f19534a;     // Catch: Throwable -> L6
        if (r37 == 1) goto L93;
        if (r37 == 2) goto L92;
        r36.put("error_error_msg", "code:" + r26.e + ", msg:" + r26.f);     // Catch: Throwable -> L6
        r36.put("error_desc", "web blank check fail");     // Catch: Throwable -> L6
        Map r38 = com.bytedance.android.monitorV2.i.f3604a;     // Catch: Throwable -> L6
        com.bytedance.android.monitorV2.i.a(r35.g.f22974b, "internal_error", r36, null, 8);     // Catch: Throwable -> L6
        goto L94
    L92:
        r36.put("result", "0");     // Catch: Throwable -> L6
        Map r39 = com.bytedance.android.monitorV2.i.f3604a;     // Catch: Throwable -> L6
        com.bytedance.android.monitorV2.i.a(r35.g.f22974b, "blank_result", r36, null, 8);     // Catch: Throwable -> L6
        goto L94
    L93:
        r36.put("result", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L6
        Map r40 = com.bytedance.android.monitorV2.i.f3604a;     // Catch: Throwable -> L6
        com.bytedance.android.monitorV2.i.a(r35.g.f22974b, "blank_result", r36, null, 8);     // Catch: Throwable -> L6
    L94:
        b(r16);     // Catch: Throwable -> L6
        StringBuilder r41 = new StringBuilder();     // Catch: Throwable -> L6
        r41.append("handleBlankDetect: session: ");     // Catch: Throwable -> L6
        r41.append(this.f3781c);     // Catch: Throwable -> L6
        r41.append(", webView url: ");     // Catch: Throwable -> L6
        r41.append(r16.getUrl());     // Catch: Throwable -> L6
        r41.append(", result: ");     // Catch: Throwable -> L6
        if (r26.f19534a == 1) goto L98;
        r5 = false;
    L98:
        r41.append(r5);     // Catch: Throwable -> L6
        d5.b.c("WebViewDataManager", r41.toString());     // Catch: Throwable -> L6
        Object r117 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L102:
        Throwable r118 = Result.m127exceptionOrNullimpl(r117);
        if (r118 == null) goto L111;
        mn.h.g("default_handle", r118);
        return;
    L111:
        return;
    L78:
        d5.b.f("WebViewDataManager", "CronetEngine is not created maybe");     // Catch: Throwable -> L6
        goto L79
    L64:
        r115 = 0;
        goto L65
    L53:
        if (((com.bytedance.android.monitorV2.settings.h) this.f3794u.getValue()).a() != 1) goto L59;
        d5.b.f("WebViewDataManager", "kernel detect is blank: " + this.f3791q);     // Catch: Throwable -> L6
        r26 = new l5.a();     // Catch: Throwable -> L6
        if (this.f3791q == false) goto L57;
        int r119 = 1;
    L58:
        r26.f19534a = r119;     // Catch: Throwable -> L6
        goto L61
    L57:
        r119 = 2;
        goto L58
    L59:
        d5.b.f("WebViewDataManager", "final pixel detect");     // Catch: Throwable -> L6
        r26 = l5.b.a(r16);     // Catch: Throwable -> L6
        goto L61
    L11:
        r15 = 0;
    L6:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r117 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L102
    }

    public final void g(boolean r5) {
        WebView r10 = a();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        String r11 = "true";
    L8:
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        r10.evaluateJavascript(String.format(" javascript: (function () {\n                    var target = {}\n                    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n                    var performacess = SlardarHybrid('getLatestPerformance');\n                    var resourcess = SlardarHybrid('getLatestResource');\n                    var cacheData = SlardarHybrid('flushCacheData');\n                    target.performance = performacess;\n                    target.resource = resourcess;\n                    target.cacheData = cacheData;\n                    target.needReport = %s;\n                    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n                })()", Arrays.copyOf(new Object[]{r11}, 1)), null);
        return;
    L7:
        r11 = "false";
        goto L8
    }

    public final boolean h() {
        WebView r5 = a();     // Catch: Throwable -> L8
        if (r5 == null) goto L7;
        return TTWebSdk.isTTWebView(r5);
    L7:
        return false;
    }

    public final void i(com.bytedance.android.monitorV2.event.b r5) {
        Intrinsics.checkNotNullParameter(r5, "customEvent");
        c r10 = this.f;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "customEvent");
        f r11 = r10.f3760k;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        r11.f3775b.c(r11.f3776c, r5, true);
        sj.g.l();
        Unit r12 = Unit.INSTANCE;
    L6:
        if (r12 != null) goto L9;
        r5.b(HybridEvent$TerminateType.e);
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void j() {
        WebViewMonitorJsBridge r5 = new WebViewMonitorJsBridge(this);
        WebView r10 = a();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getSettings().getJavaScriptEnabled() == true) goto L7;
        r10.getSettings().setJavaScriptEnabled(true);
    L7:
        d5.b.f("WebViewDataManager", "registerJsInterface");
        r10.addJavascriptInterface(r5, "iesJsBridgeTransferMonitor");
        b r11 = (b) this.e.getValue();
        if (r11 == null) goto L14;
        String r12 = r11.f3752j;
        if (r12 == null) goto L15;
        r10.addJavascriptInterface(new c4.b(r12), "hybridMonitor");
        return;
    L15:
        return;
    }

    public final void k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        this.f3785k++;
        this.f3786l.put(r10, Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L6:
        c r5 = this.f;
        if (r5 == null) goto L9;
        String r11 = r5.f3755b;
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L13;
    L15:
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("engine_type", "web");
        r12.put("url", r10);
        WebView r13 = (WebView) this.f3779a.get();
        if (r13 == null) goto L23;
        ArrayList r14 = j5.b.b(r13);
        if (r14.isEmpty() == true) goto L23;
        String r15 = (String) r14.get(0);
        Intrinsics.checkNotNullParameter(r15, "monitorId");
        Object r16 = j5.b.c(r15).get("container_name");
        if (r16 == null) goto L23;
        r12.put("container_name", (String) r16);
    L23:
        com.bytedance.android.monitorV2.i.a(null, "url_load", r12, null, 8);
        return;
    L13:
        if (Intrinsics.areEqual(r11, "about:blank") == true) goto L15;
        g(false);
        f();
        goto L15
    L9:
        r11 = null;
        goto L11
    L5:
        if (Intrinsics.areEqual("about:blank", r10) == false) goto L15;
        goto L6
    }

    public final void l(String r12) {
        Intrinsics.checkNotNullParameter(r12, "url");
        c r11 = this.f;
        if (r11 == null) goto L40;
        m5.d r13 = r11.f3768t;
        if (r13.f != 0) goto L7;
        r13.f = System.currentTimeMillis();
    L7:
        WebView r5 = r11.f3754a.a();
        if (r5 == null) goto L38;
        Lazy r10 = com.bytedance.android.monitorV2.webview.ttweb.a.f3832a;
        JSONObject r14 = com.bytedance.android.monitorV2.webview.ttweb.a.a(r5, TTUtils$MetricsArgs.f3823b);
        a5.c r15 = com.bytedance.android.monitorV2.h.e().a().getInitConfig();
        if (r15 == null) goto L19;
        String r16 = r15.f;
        if (r16 == null) goto L19;
        if (Intrinsics.areEqual(r16, "local_test") == true) goto L17;
        r16 = null;
    L17:
        if (r16 == null) goto L19;
        r13.f20010p = r14;
    L19:
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r14, LynxMonitorService.KEY_METRICS);
        JSONObject r17 = r14.optJSONObject(MessageIndication.MESSAGE_TYPE_LOADING);
        if (r17 != null) goto L22;
        r17 = new JSONObject();
    L22:
        JSONObject r18 = r17.optJSONObject("top_level_timing");
        if (r18 != null) goto L25;
        r18 = new JSONObject();
    L25:
        JSONObject r19 = r17.optJSONObject("create_webview_timing");
        if (r19 != null) goto L28;
        r19 = new JSONObject();
    L28:
        JSONObject r20 = r17.optJSONObject("main_resource_timing");
        if (r20 != null) goto L31;
        r20 = new JSONObject();
    L31:
        JSONObject r21 = r17.optJSONObject("render_timing");
        if (r21 != null) goto L34;
        r21 = new JSONObject();
    L34:
        JSONObject r110 = r17.optJSONObject("ttwebview_info");
        if (r110 != null) goto L37;
        r110 = new JSONObject();
    L37:
        JSONObject r22 = new JSONObject();
        td.c.d("fcp", r21.optLong("tick_fcp") - r20.optLong("tick_navigation_start"), r22);
        td.c.d("lcp", r18.optLong("tick_lcp") - r20.optLong("tick_navigation_start"), r22);
        td.c.d("fmp", r21.optLong("tick_fmp") - r20.optLong("tick_navigation_start"), r22);
        td.c.d("tti", r21.optLong("tick_tti") - r20.optLong("tick_navigation_start"), r22);
        td.c.d("dur_main_resource_load", r20.optLong("tick_response_end") - r20.optLong("tick_navigation_start"), r22);
        td.c.d("dur_resource_load", r18.optLong("tick_page_finished") - r18.optLong("tick_page_started"), r22);
        td.c.d("dur_javascript_execute", r21.optLong("dur_js_execution_before_lcp"), r22);
        td.c.d("dur_layout", r18.optLong("dur_layout_before_lcp"), r22);
        td.c.d("dur_paint", r18.optLong("dur_paint_before_lcp"), r22);
        td.c.d("dur_webview_create_time", r18.optLong("tick_create_webview_end") - r18.optLong("tick_create_webview_start"), r22);
        td.c.d("dur_init_ttwebview_provider", r19.optLong("tick_init_ttwebview_provider_end") - r19.optLong("tick_init_ttwebview_provider_start"), r22);
        td.c.d("dur_create_factory_provider", r19.optLong("tick_create_factory_provider_end") - r19.optLong("tick_create_factory_provider_start"), r22);
        td.c.d("dur_webview_chromium_construct", r19.optLong("tick_webview_chromium_construct_end") - r19.optLong("tick_webview_chromium_construct_start"), r22);
        td.c.d("dur_webview_chromium_init", r19.optLong("tick_webview_chromium_init_end") - r19.optLong("tick_webview_chromium_init_start"), r22);
        td.c.d("dur_load_library", r19.optLong("tick_load_library_end") - r19.optLong("tick_load_library_start"), r22);
        td.c.d("dur_start_engines", r19.optLong("tick_start_engines_end") - r19.optLong("tick_start_engines_start"), r22);
        td.c.d("dur_wait_render_process_ready_time", r18.optLong("tick_render_process_ready") - r18.optLong("tick_loadurl"), r22);
        k r23 = k.d;
        com.bytedance.ies.web.jsbridge2.l r24 = new com.bytedance.ies.web.jsbridge2.l("ttwebview_metrics_from_monitor", 1);
        r24.f6293i = r22;
        r24.f6292h = r110;
        r24.b(2);
        r23.l(r5, r24.a());
    L38:
        r11.g();
        Lazy r111 = c.f3753x;
        sj.g.l();
        r11.f3759j.s(3);
        return;
    }

    public final void m(com.bytedance.android.monitorV2.event.a r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        String r5 = r13.f.f22973a;
        c r10 = this.f3783i;
        if (r10 == null) goto L5;
        r10.e();
    L5:
        x4.a r11 = null;
        if (this.f3783i == null) goto L9;
        this.f3783i = null;
    L9:
        if (n5.a.f20204a.contains(r5) == false) goto L12;
        this.f = null;
        this.f3783i = null;
        r13.b(HybridEvent$TerminateType.g);
        return;
    L12:
        Long r12 = (Long) this.f3786l.get(r5);
        if (r12 != null) goto L15;
    L30:
        c r14 = new c(this, r5);
        this.f = r14;
        r14.f3765p = System.currentTimeMillis();
        Unit r15 = Unit.INSTANCE;
    L31:
        c r16 = this.f3783i;
        if (r16 != null) goto L34;
    L47:
        c r17 = this.f;
        if (r17 == null) goto L63;
        Intrinsics.checkNotNullParameter(r13, "event");
        if (Intrinsics.areEqual(r17.f3755b, "about:blank") == true) goto L63;
        i r18 = r17.f3754a;
        WebView r19 = r18.a();
        if (r19 == null) goto L55;
        x4.a r20 = j5.b.g(r19);
    L56:
        r17.f3757h = r20;
        WebView r21 = r18.a();
        if (r21 == null) goto L59;
        r11 = j5.b.d(r21);
    L59:
        r17.f3758i = r11;
        r17.f();
        m5.b r22 = r17.g;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r13.f = r22;
        m5.d r23 = r17.f3768t;
        r23.getClass();
        r23.f20003i = System.currentTimeMillis();
        boolean r24 = r17.f3763n;
        if (r23.e != 0) goto L62;
        r23.e = System.currentTimeMillis();
    L62:
        r23.f20007m = r24;
        r17.g();
        JSONObject r25 = new JSONObject();
        qo.a.k("invoke_ts", System.currentTimeMillis(), r25);
        r17.a(r13, r25);
        d5.b.c("NavigationDataManager", "handlePv");
        Lazy r26 = c.f3753x;
        sj.g.l();
        r17.f3759j.s(1);
        d5.b.c("NavigationDataManager", "handlePageStart: url : " + r17.f3755b);
        goto L63
    L55:
        r20 = null;
    L63:
        this.f3783i = this.f;
        this.f3790p = false;
        this.f3792r = true;
        return;
    L34:
        if (TextUtils.equals(r5, r16.f3755b) == false) goto L47;
        long r27 = r16.g.e;
        if (sk.a.f21938a != 0) goto L39;
        sk.a.f21938a = System.currentTimeMillis();
    L39:
        if (r27 != sk.a.f21938a) goto L47;
        c r110 = this.f;
        if (r110 == null) goto L45;
        r110.f = false;
    L45:
        HashMap r111 = new HashMap();
        r111.put("repeat_page_start_url", r5);
        com.bytedance.android.monitorV2.i.b(r111, null, "repeat_page_start");
        return;
    L15:
        if (this.f != null) goto L18;
        this.f = new c(this, r5);
    L18:
        if (this.f3790p == true) goto L20;
        this.f = new c(this, r5);
    L20:
        c r28 = this.f;
        if (r28 == null) goto L29;
        String r29 = r28.f3755b;
        if (r29 != null) goto L25;
    L26:
        r28.f3755b = r5;
        r28.g.f22973a = r5;
    L27:
        r28.f3763n = true;
        r28.f3765p = r12.longValue();
        goto L29
    L25:
        if (r29.length() != 0) goto L27;
    L29:
        if (((Long) this.f3786l.remove(r5)) != null) goto L31;
        goto L30
    }

    public final void n(int r10) {
        WebView r5 = a();
        if (r5 != null) goto L5;
    L7:
        c r11 = this.f;
        if (r11 == null) goto L61;
        i r12 = r11.f3754a;
        WebView r13 = r12.a();
        m5.d r14 = r11.f3768t;
        if (r13 == null) goto L53;
        if (r10 < r11.s) goto L53;
        if (r13.getSettings().getJavaScriptEnabled() == true) goto L59;
        r13.getSettings().setJavaScriptEnabled(true);
    L59:
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L36
        String r15 = r13.getUrl();     // Catch: Exception -> L36
        if (r15 == null) goto L53;
        if (Intrinsics.areEqual(r15, "about:blank") == true) goto L53;
        if (r11.f == true) goto L53;
        b r16 = (b) r12.e.getValue();     // Catch: Exception -> L36
        r12.d.getClass();     // Catch: Exception -> L36
        Switches r17 = Switches.f;     // Catch: Exception -> L36
        if (r17.f3600a == true) goto L30;
    L38:
        com.bytedance.android.monitorV2.h.e().a();     // Catch: Exception -> L36
        if (TextUtils.isEmpty(r15) == true) goto L53;
        if (r11.f == true) goto L53;
        b r18 = (b) r12.e.getValue();     // Catch: Exception -> L36
        if (r18 != null) goto L45;
        String r19 = "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    L46:
        if (r18 != null) goto L48;
        String r20 = "";
    L49:
        r12.d.getClass();     // Catch: Exception -> L36
        boolean r21 = r17.f3600a;     // Catch: Exception -> L36
        r13.evaluateJavascript(com.bytedance.android.anniex.base.service.e.f(r13.getContext(), r20, r19, r21), null);     // Catch: Exception -> L36
        long r22 = System.currentTimeMillis();     // Catch: Exception -> L36
        r11.f = true;     // Catch: Exception -> L36
        r14.f20002h = r22;     // Catch: Exception -> L36
        r11.g();     // Catch: Exception -> L36
        d5.b.c("NavigationDataManager", "injectJsScript : ".concat(r15));     // Catch: Exception -> L36
        Map r23 = com.bytedance.android.monitorV2.i.f3604a;     // Catch: Exception -> L36
        com.bytedance.android.monitorV2.i.a(r11.g.f22974b, "jssdk_load", null, null, 12);     // Catch: Exception -> L36
        goto L53
    L48:
        r20 = r18.f3751i;     // Catch: Exception -> L36
        goto L49
    L45:
        r19 = r18.f3750h;     // Catch: Exception -> L36
        goto L46
    L30:
        if (Switches.f3597p.f3600a == false) goto L38;
        if (com.bytedance.apm.util.a.e == true) goto L38;
        if (r11.d(r15) == true) goto L38;
    L36:
        e = move-exception;
        mn.h.g("default_handle", e);
    L53:
        if (r10 == 100) goto L55;
        r14.getClass();
        return;
    L55:
        if (r14.g != 0) goto L62;
        r14.g = System.currentTimeMillis();
        return;
    L62:
        return;
    L61:
        return;
    L5:
        if (r5.getSettings().getJavaScriptEnabled() == true) goto L7;
        r5.getSettings().setJavaScriptEnabled(true);
        goto L7
    }

    public final void o() {
        this.f = new c(this);
        c(WebViewLifeState.f3743a);
        WebView r5 = a();
        if (r5 != null) goto L5;
    L10:
        j();
        WebView r10 = a();
        if (r10 == null) goto L14;
        new TTWebViewExtension(r10).setPerformanceTimingListener(new com.bytedance.android.monitorV2.webview.ttweb.b(new com.lynx.tasm.utils.c(4)));
        return;
    L14:
        return;
    L5:
        if (this.f3782h != null) goto L7;
        this.f3782h = new g(this);
    L7:
        g r11 = this.f3782h;
        if (r11 == null) goto L10;
        r11.a(r5);
        goto L10
    }
}
