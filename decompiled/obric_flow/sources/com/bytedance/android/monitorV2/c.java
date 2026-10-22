package com.bytedance.android.monitorV2;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$DataType;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.monitorV2.dataprocessor.b f3517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bi.e f3518b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f3519c = null;

    static {
        com.bytedance.android.monitorV2.dataprocessor.b r5 = new com.bytedance.android.monitorV2.dataprocessor.b();
        f3517a = r5;
        f3518b = new bi.e(4);
        f3519c = new ConcurrentHashMap();
        TypedDataDispatcher$DataType r10 = TypedDataDispatcher$DataType.f3527c;
        b r11 = new b();
        Intrinsics.checkNotNullParameter(r10, "dataType");
        Intrinsics.checkNotNullParameter(r11, "dataProcessor");
        r5.f3533b.put(r10, r11);
    }

    public static final void a(com.bytedance.android.monitorV2.event.a r11, com.bytedance.android.monitorV2.webview.a r12) {
        d5.b.f("DataReporter", "reportCommonEventInner: " + r11.f.f22975c + ", " + r11.f3557a);     // Catch: Throwable -> L7
        k5.h.g(r11);     // Catch: Throwable -> L7
        String r5 = k5.h.a(r11);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r5, "bid");     // Catch: Throwable -> L7
        BidInfo$BidConfig r10 = h.e().a().a().f(r5);     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r11.f3557a, "jsbPv") == false) goto L9;
        Method r13 = u4.d.f22248a;     // Catch: Throwable -> L7
        u4.d.a(r11, r10.bid);     // Catch: Throwable -> L7
        return;
    L9:
        boolean r14 = f(r11, r10);     // Catch: Throwable -> L7
        Method r15 = u4.d.f22248a;     // Catch: Throwable -> L7
        String r16 = r10.bid;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("custom", "eventName");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r16, "bid");     // Catch: Throwable -> L7
        boolean r17 = true;
        if (TextUtils.isEmpty("custom") == false) goto L14;
    L20:
        u4.d.b(r11, r5, r14);     // Catch: Throwable -> L7
        if (r14 == true) goto L24;
        r11.f();     // Catch: Throwable -> L7
        return;
    L24:
        String r18 = r11.f3557a;     // Catch: Throwable -> L7
        String r19 = r10.bid;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r18, "eventName");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r19, "bid");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r18) == false) goto L28;
    L34:
        JSONObject r20 = k5.h.c(r11);     // Catch: Throwable -> L7
        ConcurrentHashMap r21 = f3519c;     // Catch: Throwable -> L7
        AtomicLong r22 = (AtomicLong) r21.get(r5);     // Catch: Throwable -> L7
        if (r22 != null) goto L37;
        r22 = new AtomicLong();     // Catch: Throwable -> L7
        r21.put(r5, r22);     // Catch: Throwable -> L7
    L37:
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L7
        qo.a.t("uuid", UUID.randomUUID().toString(), r23);     // Catch: Throwable -> L7
        qo.a.k("inc_id", r22.incrementAndGet(), r23);     // Catch: Throwable -> L7
        qo.a.j(r11.a(), "trace_id", r23);     // Catch: Throwable -> L7
        qo.a.j(r23, "debugLog", r20);     // Catch: Throwable -> L7
        String r24 = r11.f.f22975c;     // Catch: Throwable -> L7
        if (r24 != null) goto L40;
        r24 = "";
    L40:
        e(r12, r20, r11.f3557a, r24, r11);     // Catch: Throwable -> L7
        return;
    L28:
        if (com.bytedance.apm.util.a.d == true) goto L31;
        r17 = h.e().a().a().f(r19).tea_switch;     // Catch: Throwable -> L7
    L31:
        if (r17 == false) goto L34;
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L7
        qo.a.t("event_name", r18, r25);     // Catch: Throwable -> L7
        qo.a.t("bid", r19, r25);     // Catch: Throwable -> L7
        u4.d.c("hybridmonitor_report_sample", r25);     // Catch: Throwable -> L7
        goto L34
    L14:
        if (com.bytedance.apm.util.a.d == false) goto L16;
        boolean r26 = true;
    L17:
        if (r26 == false) goto L20;
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L7
        qo.a.t("event_name", "custom", r27);     // Catch: Throwable -> L7
        qo.a.t("bid", r16, r27);     // Catch: Throwable -> L7
        u4.d.c("hybridmonitor_report_all", r27);     // Catch: Throwable -> L7
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, new JSONObject(com.lynx.tasm.utils.g.d("{\"extra\":{\"client_category\":{\"bid\":\"", r16, "\",\"event_type\":\"custom\"},\"client_extra\":{\"event_name\":\"hybridmonitor_report_all\"},\"ev_type\":\"custom\"}}")));     // Catch: Throwable -> L7
        goto L20
    L16:
        r26 = h.e().a().a().f(r16).tea_switch;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r11.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
    }

    public static void b(com.bytedance.android.monitorV2.event.a r5, Boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "commonEvent");
        TypedDataDispatcher$DataType r11 = TypedDataDispatcher$DataType.f3527c;
        Pair r12 = new Pair(r5, null);
        boolean r13 = r10.booleanValue();
        f3517a.c(r11, r12, r13);
    }

    public static final void c(com.bytedance.android.monitorV2.event.b r14) {
        StringBuilder r5 = new StringBuilder("monitorCustom: ");     // Catch: Throwable -> L18
        x4.c r10 = r14.f3553m;     // Catch: Throwable -> L18
        r5.append(r10);     // Catch: Throwable -> L18
        d5.b.f("DataReporter", r5.toString());     // Catch: Throwable -> L18
        k5.h.g(r14);     // Catch: Throwable -> L18
        String r11 = k5.h.a(r14);     // Catch: Throwable -> L18
        JSONObject r12 = k5.h.d(r14);     // Catch: Throwable -> L18
        r10.f22948b = r11;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r11, "<set-?>");     // Catch: Throwable -> L18
        r14.f3561i = r11;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r11, "bid");     // Catch: Throwable -> L18
        BidInfo$BidConfig r13 = h.e().a().a().f(r11);     // Catch: Throwable -> L18
        Method r15 = u4.d.f22248a;     // Catch: Throwable -> L18
        String r16 = r13.bid;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("custom", "eventName");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r16, "bid");     // Catch: Throwable -> L18
        boolean r17 = true;
        if (TextUtils.isEmpty("custom") == true) goto L15;
        if (com.bytedance.apm.util.a.d == false) goto L10;
        boolean r18 = true;
    L11:
        if (r18 == false) goto L15;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L18
        qo.a.t("event_name", "custom", r19);     // Catch: Throwable -> L18
        qo.a.t("bid", r16, r19);     // Catch: Throwable -> L18
        u4.d.c("hybridmonitor_report_all", r19);     // Catch: Throwable -> L18
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, new JSONObject(com.lynx.tasm.utils.g.d("{\"extra\":{\"client_category\":{\"bid\":\"", r16, "\",\"event_type\":\"custom\"},\"client_extra\":{\"event_name\":\"hybridmonitor_report_all\"},\"ev_type\":\"custom\"}}")));     // Catch: Throwable -> L18
        goto L15
    L10:
        r18 = h.e().a().a().f(r16).tea_switch;     // Catch: Throwable -> L18
    L15:
        if (f(r14, r13) == true) goto L20;
        r14.f();     // Catch: Throwable -> L18
        return;
    L20:
        String r20 = r13.bid;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("custom", "eventName");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r20, "bid");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty("custom") == false) goto L24;
    L30:
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L18
        d5.b.f("DataReporter", String.format("do report bid: %s, event: %s", Arrays.copyOf(new Object[]{r10.f22948b, r10.f22949c}, 2)));     // Catch: Throwable -> L18
        ConcurrentHashMap r22 = f3519c;     // Catch: Throwable -> L18
        AtomicLong r23 = (AtomicLong) r22.get(r11);     // Catch: Throwable -> L18
        if (r23 != null) goto L33;
        r23 = new AtomicLong();     // Catch: Throwable -> L18
        r22.put(r11, r23);     // Catch: Throwable -> L18
    L33:
        JSONObject r24 = new JSONObject();     // Catch: Throwable -> L18
        qo.a.t("uuid", UUID.randomUUID().toString(), r24);     // Catch: Throwable -> L18
        qo.a.k("inc_id", r23.incrementAndGet(), r24);     // Catch: Throwable -> L18
        qo.a.j(r14.a(), "trace_id", r24);     // Catch: Throwable -> L18
        qo.a.j(r24, "debugLog", r12);     // Catch: Throwable -> L18
        e(r10.f22954l, r12, "custom", "", r14);     // Catch: Throwable -> L18
        return;
    L24:
        if (com.bytedance.apm.util.a.d == true) goto L27;
        r17 = h.e().a().a().f(r20).tea_switch;     // Catch: Throwable -> L18
    L27:
        if (r17 == false) goto L30;
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L18
        qo.a.t("event_name", "custom", r25);     // Catch: Throwable -> L18
        qo.a.t("bid", r20, r25);     // Catch: Throwable -> L18
        u4.d.c("hybridmonitor_report_sample", r25);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        mn.h.g("default_handle", th);
        d5.b.e("DataReporter", "monitorCustom error: " + th.getMessage());
    }

    public static void d(com.bytedance.android.monitorV2.event.b r5, Boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customEvent");
        TypedDataDispatcher$DataType r11 = TypedDataDispatcher$DataType.f3527c;
        Pair r12 = new Pair(r5, null);
        boolean r13 = r10.booleanValue();
        f3517a.c(r11, r12, r13);
    }

    public static void e(com.bytedance.android.monitorV2.webview.a r18, JSONObject r19, String r20, String r21, com.bytedance.android.monitorV2.event.d r22) {
        bi.e r5 = f3518b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r19, "jsonObj");
        Intrinsics.checkNotNullParameter(r20, "eventType");
        Intrinsics.checkNotNullParameter(r21, "containerType");
        String r10 = "custom";
        if (TextUtils.equals("custom", r20) == true) goto L6;
        r10 = r21 + '_' + r20 + '_' + qo.a.p("navigation_id", r19.optJSONObject("nativeBase"));
    L6:
        Map r11 = (Map) r5.d;
        if (r11.containsKey(r20) == true) goto L9;
    L29:
        int r12 = r5.f930b;
        if (r12 <= 0) goto L32;
        qo.a.e(r12, "native_repeat_count", (JSONObject) r5.e);
        g((JSONObject) r5.e, (String) r5.f931c, (String) r5.f, null);
        r5.f930b = 0;
    L32:
        g(r19, r20, r21, r22);
    L33:
        r5.e = r19;
        r5.f931c = r20;
        r5.f = r21;
        return;
    L9:
        if (TextUtils.equals(r10, null) == false) goto L29;
        w4.a r13 = (w4.a) r11.get(r20);
        if (r13 == null) goto L33;
        JSONObject r14 = (JSONObject) r5.e;
        switch(r13.f22714a) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            default: goto L14;
        };
    L14:
        boolean r15 = qo.a.o(r19.optJSONObject("nativeInfo"), qo.a.d(r14, "nativeInfo"), new String[]{"scene", WsConstants.ERROR_CODE, "error_msg", "http_status"});
    L21:
        if (r15 == false) goto L25;
        r5.f930b++;
        if (r22 == null) goto L33;
        r22.b(HybridEvent$TerminateType.d);
        goto L33
    L25:
        int r16 = r5.f930b;
        if (r16 <= 0) goto L28;
        qo.a.e(r16, "native_repeat_count", (JSONObject) r5.e);
        g((JSONObject) r5.e, (String) r5.f931c, (String) r5.f, null);
        r5.f930b = 0;
    L28:
        g(r19, r20, r21, r22);
        goto L33
    L15:
        r15 = qo.a.o(r19.optJSONObject("nativeInfo"), qo.a.d(r14, "nativeInfo"), new String[]{"bridge_name", "status_code", "status_description"});
        goto L21
    L16:
        r15 = qo.a.o(r19.optJSONObject("nativeInfo"), qo.a.d(r14, "nativeInfo"), new String[]{"bridge_name", WsConstants.ERROR_CODE, "error_message"});
        goto L21
    L17:
        r15 = qo.a.o(r19.optJSONObject("nativeInfo"), qo.a.d(r14, "nativeInfo"), new String[]{"url", "method", "status_code", "request_error_code", "request_error_msg", "error_no", "error_msg"});
        goto L21
    L18:
        if (r14 == null) goto L20;
        r15 = r19.toString().equals(r14.toString());
        goto L21
    L20:
        r15 = false;
        goto L21
    }

    public static boolean f(com.bytedance.android.monitorV2.event.d r19, BidInfo$BidConfig r20) {
        int r17 = -1;
        boolean r18 = false;
        if ((r19 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L209;
        com.bytedance.android.monitorV2.event.a r5 = (com.bytedance.android.monitorV2.event.a) r19;
        String r10 = r5.f.f22975c;
        if (Intrinsics.areEqual(r10, "web") == false) goto L113;
        String r11 = r5.f3557a;
        if (com.bytedance.apm.util.a.d == false) goto L10;
        return true;
    L10:
        r11.getClass();
        switch(r11.hashCode()) {
            case -1898518694: goto L86;
            case -1577087617: goto L82;
            case -1323516222: goto L78;
            case -892481938: goto L74;
            case -588767010: goto L70;
            case -109980519: goto L66;
            case 2994720: goto L62;
            case 3437289: goto L58;
            case 93819220: goto L54;
            case 194292771: goto L50;
            case 281935726: goto L46;
            case 299602137: goto L42;
            case 831602183: goto L38;
            case 1008268974: goto L34;
            case 1157772918: goto L30;
            case 1521451035: goto L26;
            case 1727072305: goto L22;
            case 1830775838: goto L18;
            case 1910899023: goto L14;
            default: goto L12;
        };
    L12:
        byte r12 = -1;
    L89:
        switch(r12) {
            case 0: goto L109;
            case 1: goto L108;
            case 2: goto L107;
            case 3: goto L106;
            case 4: goto L107;
            case 5: goto L105;
            case 6: goto L104;
            case 7: goto L103;
            case 8: goto L102;
            case 9: goto L101;
            case 10: goto L100;
            case 11: goto L99;
            case 12: goto L98;
            case 13: goto L97;
            case 14: goto L96;
            case 15: goto L95;
            case 16: goto L94;
            case 17: goto L93;
            case 18: goto L91;
            default: goto L90;
        };
    L90:
        boolean r13 = r18;
        d5.b.f("HybridMonitor", "sampling eventType: " + r11 + ", sampleHit: " + r13 + ", use: " + r20.bid);
        return r13;
    L91:
        boolean r14 = r20.jsb_error_web;
    L92:
        r18 = r14;
        goto L90
    L93:
        r14 = r20.res_loader_error_template_web;
        goto L92
    L94:
        r14 = r20.native_error_web;
        goto L92
    L95:
        r14 = r20.res_loader_error_web;
        goto L92
    L96:
        r14 = r20.res_loader_perf_web;
        goto L92
    L97:
        r14 = r20.navigation_start_web;
        goto L92
    L98:
        r14 = r20.container_error;
        goto L92
    L99:
        r14 = r20.js_exception_web;
        goto L92
    L100:
        r14 = r20.fetch_error_web;
        goto L92
    L101:
        r14 = r20.res_loader_perf_template_web;
        goto L92
    L102:
        r14 = r20.blank_web;
        goto L92
    L103:
        r14 = r20.perf_web;
        goto L92
    L104:
        r14 = r20.ajax_web;
        goto L92
    L105:
        r14 = r20.static_sri_web;
        goto L92
    L106:
        r14 = r20.static_error_web;
        goto L92
    L107:
        r14 = r20.jsb_perf_web;
        goto L92
    L108:
        r14 = r20.static_perf_web;
        goto L92
    L109:
        r14 = r20.falcon_perf_web;
        goto L92
    L14:
        if (r11.equals("jsbError") == false) goto L278;
        r12 = 18;
        goto L89
    L278:
        r12 = -1;
        goto L89
    L18:
        if (r11.equals("res_loader_error_template") == false) goto L279;
        r12 = 17;
        goto L89
    L279:
        r12 = -1;
        goto L89
    L22:
        if (r11.equals("nativeError") == false) goto L280;
        r12 = 16;
        goto L89
    L280:
        r12 = -1;
        goto L89
    L26:
        if (r11.equals("res_loader_error") == false) goto L281;
        r12 = 15;
        goto L89
    L281:
        r12 = -1;
        goto L89
    L30:
        if (r11.equals("res_loader_perf") == false) goto L282;
        r12 = 14;
        goto L89
    L282:
        r12 = -1;
        goto L89
    L34:
        if (r11.equals("navigationStart") == false) goto L283;
        r12 = 13;
        goto L89
    L283:
        r12 = -1;
        goto L89
    L38:
        if (r11.equals("containerError") == false) goto L284;
        r12 = 12;
        goto L89
    L284:
        r12 = -1;
        goto L89
    L42:
        if (r11.equals("js_exception") == false) goto L285;
        r12 = 11;
        goto L89
    L285:
        r12 = -1;
        goto L89
    L46:
        if (r11.equals("fetchError") == false) goto L286;
        r12 = 10;
        goto L89
    L286:
        r12 = -1;
        goto L89
    L50:
        if (r11.equals("res_loader_perf_template") == false) goto L287;
        r12 = 9;
        goto L89
    L287:
        r12 = -1;
        goto L89
    L54:
        if (r11.equals("blank") == false) goto L288;
        r12 = 8;
        goto L89
    L288:
        r12 = -1;
        goto L89
    L58:
        if (r11.equals("perf") == false) goto L289;
        r12 = 7;
        goto L89
    L289:
        r12 = -1;
        goto L89
    L62:
        if (r11.equals("ajax") == false) goto L290;
        r12 = 6;
        goto L89
    L290:
        r12 = -1;
        goto L89
    L66:
        if (r11.equals("static_sri") == false) goto L291;
        r12 = 5;
        goto L89
    L291:
        r12 = -1;
        goto L89
    L70:
        if (r11.equals("jsbPerfV2") == false) goto L292;
        r12 = 4;
        goto L89
    L292:
        r12 = -1;
        goto L89
    L74:
        if (r11.equals("static") == false) goto L293;
        r12 = 3;
        goto L89
    L293:
        r12 = -1;
        goto L89
    L78:
        if (r11.equals("jsbPerf") == false) goto L294;
        r12 = 2;
        goto L89
    L294:
        r12 = -1;
        goto L89
    L82:
        if (r11.equals("resource_performance") == false) goto L295;
        r12 = 1;
        goto L89
    L295:
        r12 = -1;
        goto L89
    L86:
        if (r11.equals("falconPerf") == false) goto L296;
        r12 = 0;
        goto L89
    L296:
        r12 = -1;
        goto L89
    L113:
        if (Intrinsics.areEqual(r10, "lynx") == false) goto L199;
        String r15 = r5.f3557a;
        if (com.bytedance.apm.util.a.d == false) goto L118;
        return true;
    L118:
        r15.getClass();
        switch(r15.hashCode()) {
            case -1480388560: goto L178;
            case -1323516222: goto L174;
            case -892481938: goto L170;
            case -588767010: goto L166;
            case 93819220: goto L162;
            case 194292771: goto L158;
            case 281935726: goto L154;
            case 299602137: goto L150;
            case 831602183: goto L146;
            case 1008268974: goto L142;
            case 1157772918: goto L138;
            case 1521451035: goto L134;
            case 1727072305: goto L130;
            case 1830775838: goto L126;
            case 1910899023: goto L122;
            default: goto L120;
        };
    L120:
        byte r16 = -1;
    L181:
        switch(r16) {
            case 0: goto L196;
            case 1: goto L195;
            case 2: goto L194;
            case 3: goto L195;
            case 4: goto L193;
            case 5: goto L192;
            case 6: goto L191;
            case 7: goto L190;
            case 8: goto L189;
            case 9: goto L188;
            case 10: goto L187;
            case 11: goto L186;
            case 12: goto L185;
            case 13: goto L184;
            case 14: goto L183;
            default: goto L182;
        };
    L182:
        boolean r21 = false;
    L197:
        d5.b.f("HybridMonitor", "sampling eventType: " + r15 + ", sampleHit: " + r21 + ", use: " + r20.bid);
        return r21;
    L183:
        r21 = r20.jsb_error_lynx;
        goto L197
    L184:
        r21 = r20.res_loader_error_template_lynx;
        goto L197
    L185:
        r21 = r20.native_error_lynx;
        goto L197
    L186:
        r21 = r20.res_loader_error_lynx;
        goto L197
    L187:
        r21 = r20.res_loader_perf_lynx;
        goto L197
    L188:
        r21 = r20.navigation_start_lynx;
        goto L197
    L189:
        r21 = r20.container_error;
        goto L197
    L190:
        r21 = r20.js_exception_lynx;
        goto L197
    L191:
        r21 = r20.fetch_error_lynx;
        goto L197
    L192:
        r21 = r20.res_loader_perf_template_lynx;
        goto L197
    L193:
        r21 = r20.blank_lynx;
        goto L197
    L194:
        r21 = r20.static_error_lynx;
        goto L197
    L195:
        r21 = r20.jsb_perf_lynx;
        goto L197
    L196:
        r21 = r20.performance_lynx;
        goto L197
    L122:
        if (r15.equals("jsbError") == false) goto L297;
        r16 = 14;
        goto L181
    L297:
        r16 = -1;
        goto L181
    L126:
        if (r15.equals("res_loader_error_template") == false) goto L298;
        r16 = 13;
        goto L181
    L298:
        r16 = -1;
        goto L181
    L130:
        if (r15.equals("nativeError") == false) goto L299;
        r16 = 12;
        goto L181
    L299:
        r16 = -1;
        goto L181
    L134:
        if (r15.equals("res_loader_error") == false) goto L300;
        r16 = 11;
        goto L181
    L300:
        r16 = -1;
        goto L181
    L138:
        if (r15.equals("res_loader_perf") == false) goto L301;
        r16 = 10;
        goto L181
    L301:
        r16 = -1;
        goto L181
    L142:
        if (r15.equals("navigationStart") == false) goto L302;
        r16 = 9;
        goto L181
    L302:
        r16 = -1;
        goto L181
    L146:
        if (r15.equals("containerError") == false) goto L303;
        r16 = 8;
        goto L181
    L303:
        r16 = -1;
        goto L181
    L150:
        if (r15.equals("js_exception") == false) goto L304;
        r16 = 7;
        goto L181
    L304:
        r16 = -1;
        goto L181
    L154:
        if (r15.equals("fetchError") == false) goto L305;
        r16 = 6;
        goto L181
    L305:
        r16 = -1;
        goto L181
    L158:
        if (r15.equals("res_loader_perf_template") == false) goto L306;
        r16 = 5;
        goto L181
    L306:
        r16 = -1;
        goto L181
    L162:
        if (r15.equals("blank") == false) goto L307;
        r16 = 4;
        goto L181
    L307:
        r16 = -1;
        goto L181
    L166:
        if (r15.equals("jsbPerfV2") == false) goto L308;
        r16 = 3;
        goto L181
    L308:
        r16 = -1;
        goto L181
    L170:
        if (r15.equals("static") == false) goto L309;
        r16 = 2;
        goto L181
    L309:
        r16 = -1;
        goto L181
    L174:
        if (r15.equals("jsbPerf") == false) goto L310;
        r16 = 1;
        goto L181
    L310:
        r16 = -1;
        goto L181
    L178:
        if (r15.equals("performance") == false) goto L311;
        r16 = 0;
        goto L181
    L311:
        r16 = -1;
        goto L181
    L199:
        String r22 = r5.f3557a;
        if (com.bytedance.apm.util.a.d == false) goto L203;
        return true;
    L203:
        r22.getClass();
        if (r22.equals("containerError") == true) goto L207;
        return false;
    L207:
        return r20.container_error;
    L209:
        if ((r19 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L277;
        com.bytedance.android.monitorV2.event.b r23 = (com.bytedance.android.monitorV2.event.b) r19;
        Intrinsics.checkNotNullParameter(r23, "customEvent");
        String r24 = r23.f3561i;
        x4.c r25 = r23.f3553m;
        String r26 = r25.f22949c;
        if (TextUtils.isEmpty(r26) == false) goto L214;
        return false;
    L214:
        if (com.bytedance.apm.util.a.d == false) goto L216;
        int r27 = 1;
    L221:
        if (r27 != 1) goto L225;
        StringCompanionObject r28 = StringCompanionObject.INSTANCE;
        d5.b.f("DataReporter", String.format("bid: %s, event: %s, sample hit", Arrays.copyOf(new Object[]{r24, r26}, 2)));
        return true;
    L225:
        if (com.bytedance.apm.util.a.d == false) goto L227;
        int r29 = 1;
    L231:
        if (r29 != 0) goto L234;
        StringCompanionObject r30 = StringCompanionObject.INSTANCE;
        d5.b.f("DataReporter", String.format("bid: %s, event: %s, sample not hit", Arrays.copyOf(new Object[]{r24, r26}, 2)));
        return false;
    L234:
        StringCompanionObject r31 = StringCompanionObject.INSTANCE;
        d5.b.f("DataReporter", String.format("bid: %s, event: %s, sample not found, checking all...", Arrays.copyOf(new Object[]{r24, r26}, 2)));
        String r32 = r25.f22949c;
        if (TextUtils.isEmpty(r32) == false) goto L238;
        return false;
    L238:
        if (com.bytedance.apm.util.a.d == false) goto L241;
        int r33 = 1;
    L245:
        if (r33 != 1) goto L249;
        d5.b.f("DataReporter", String.format("event: %s, sample hit", Arrays.copyOf(new Object[]{r32}, 1)));
        return true;
    L249:
        if (com.bytedance.apm.util.a.d == false) goto L251;
        r17 = 1;
    L255:
        if (r17 != 0) goto L258;
        d5.b.f("DataReporter", String.format("event: %s, sample not hit", Arrays.copyOf(new Object[]{r32}, 1)));
        return false;
    L258:
        d5.b.f("DataReporter", String.format("event: %s, sample not found, checking canSample level...", Arrays.copyOf(new Object[]{r32}, 1)));
        BidInfo$BidConfig r34 = h.e().a().a().f(r23.f3561i);
        if (r34 != null) goto L261;
        return false;
    L261:
        int r35 = r25.f22953k;
        if (com.bytedance.apm.util.a.d == false) goto L265;
        return true;
    L265:
        switch(r35) {
            case 0: goto L274;
            case 1: goto L273;
            case 2: goto L272;
            case 3: goto L271;
            case 4: goto L270;
            case 5: goto L269;
            case 6: goto L268;
            case 7: goto L267;
            default: goto L266;
        };
    L266:
        boolean r36 = r34.custom_p8;
    L275:
        d5.b.f("CustomMonitor", "canSample level: " + r35 + ", sampleHit: " + r36 + ", use: " + r34.bid);
        return r36;
    L267:
        r36 = r34.custom_p7;
        goto L275
    L268:
        r36 = r34.custom_p6;
        goto L275
    L269:
        r36 = r34.custom_p5;
        goto L275
    L270:
        r36 = r34.custom_p4;
        goto L275
    L271:
        r36 = r34.custom_p3;
        goto L275
    L272:
        r36 = r34.custom_p2;
        goto L275
    L273:
        r36 = r34.custom_p1;
        goto L275
    L274:
        r36 = r34.custom_p0;
        goto L275
    L251:
        HashMap r37 = h.e().a().e();
        if (r37.containsKey(r32) == false) goto L255;
        r17 = ((Integer) r37.get(r32)).intValue();
        goto L255
    L241:
        HashMap r38 = h.e().a().e();
        if (r38.containsKey(r32) == true) goto L244;
        r33 = -1;
        goto L245
    L244:
        r33 = ((Integer) r38.get(r32)).intValue();
        goto L245
    L227:
        Map<String, Integer> r39 = h.e().a().a().f(r24).eventNameSample;
        if (r39.containsKey(r26) == true) goto L230;
        r29 = -1;
        goto L231
    L230:
        r29 = r39.get(r26).intValue();
        goto L231
    L216:
        Map<String, Integer> r40 = h.e().a().a().f(r24).eventNameSample;
        if (r40.containsKey(r26) == true) goto L219;
        r27 = -1;
        goto L221
    L219:
        r27 = r40.get(r26).intValue();
        goto L221
    L277:
        return false;
    }

    public static void g(JSONObject r10, String r11, String r12, com.bytedance.android.monitorV2.event.d r13) {
        if (r10 == null) goto L75;
        if (r11 == null) goto L75;
        if (r12 == null) goto L75;
        JSONObject r5 = new JSONObject();
        qo.a.j(r10, "extra", r5);
        if (Intrinsics.areEqual("custom", r11) == false) goto L84;
        String r14 = r10.getJSONObject("bid_info").getString("setting_bid");     // Catch: JSONException -> L15
    L18:
        Method r15 = u4.d.f22248a;
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r14, "bid");
        boolean r16 = true;
        if (TextUtils.isEmpty(r11) == false) goto L22;
    L86:
        String r17 = u4.c.a(r11, r12, r5);     // Catch: Throwable -> L34
        if (r13 != null) goto L82;
    L80:
        d5.b.f("DataReporter", "upload ".concat(r11));     // Catch: Throwable -> L47
        if (Intrinsics.areEqual("jsbPerf", r11) == false) goto L42;
    L49:
        if (r16 == true) goto L60;
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L47
        if (r13 == null) goto L54;
        String r19 = r13.f3559c;     // Catch: Throwable -> L47
        if (r19 == null) goto L54;
    L55:
        String r20 = r5.toString();     // Catch: Throwable -> L47
        if (r20.length() <= 500) goto L59;
        r20 = r20.substring(0, 500);     // Catch: Throwable -> L47
    L59:
        d5.b.f("DataReporter", String.format("report: session: %s event: %s container: %s data: %s", Arrays.copyOf(new Object[]{r19, r11, r12, r20}, 4)));     // Catch: Throwable -> L47
    L54:
        r19 = "null";
    L60:
        h r110 = h.e();     // Catch: Throwable -> L47
        CopyOnWriteArrayList r111 = r110.f3584h;     // Catch: Throwable -> L47
        if (r111 != null) goto L63;
        return;
    L63:
        if (r111.size() <= 0) goto L96;
        Iterator r112 = r110.f3584h.iterator();     // Catch: Throwable -> L47
    L65:
        if (r112.hasNext() == false) goto L99;
        t4.b r113 = (t4.b) r112.next();     // Catch: Throwable -> L47
        if (r113 == null) goto L65;
        r113.a(r17, r11, r5);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L47
        goto L65
    L99:
        return;
    L96:
        return;
    L42:
        if (Intrinsics.areEqual("jsbPerfV2", r11) == true) goto L49;
        if (Intrinsics.areEqual("custom", r11) == true) goto L49;
        r16 = false;
    L47:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L82:
        r13.h();     // Catch: Throwable -> L32
    L32:
        th = th;
    L36:
        if (r13 == null) goto L38;
        r13.b(HybridEvent$TerminateType.f3542c);
    L38:
        mn.h.g("default_handle", th);
    L34:
        th = th;
        r17 = "bd_hybrid_monitor_service_all_in_one";
        goto L36
    L22:
        if (com.bytedance.apm.util.a.d == false) goto L24;
        boolean r21 = true;
    L25:
        if (r21 == false) goto L86;
        JSONObject r22 = new JSONObject();
        qo.a.t("event_name", r11, r22);
        qo.a.t("bid", r14, r22);
        u4.d.c("hybridmonitor_report_sample_before_send", r22);
        goto L86
    L24:
        r21 = h.e().a().a().f(r14).tea_switch;
    L15:
        e = move-exception;
        mn.h.g("default_handle", e);
    L17:
        r14 = "";
        goto L18
    L84:
        r14 = r10.getJSONObject("nativeBase").getJSONObject("bid_info").getString("setting_bid");     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        mn.h.g("default_handle", e);
    L75:
        if (r13 == null) goto L98;
        r13.b(HybridEvent$TerminateType.f3541b);
        return;
    }
}
