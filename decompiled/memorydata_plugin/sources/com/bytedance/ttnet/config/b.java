package com.bytedance.ttnet.config;

import android.content.Context;
import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.j;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f3239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f3240b = null;
    private static final AtomicBoolean c = null;
    private static final AtomicBoolean d = null;
    private static final AtomicBoolean e = null;
    private static final AtomicBoolean f = null;
    private static final List<String> g = null;

    static {
        f3239a = new AtomicBoolean(false);
        f3240b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(true);
        g = new CopyOnWriteArrayList();
    }

    public static void a(Object r11) {
        JSONObject r1 = null;
    L100:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (ZeusTransformUtils.instanceOf(r11, d.b.class) == false) goto L10;
        JSONObject r12 = ((d.b) ZeusTransformUtils.preCheckCast(r11, d.b.class, "com.obric.memorydata.plugin")).b();     // Catch: JSONException -> L100
        if (r12 == null) goto L15;
    L8:
        r1 = r12.optJSONObject("data");     // Catch: JSONException -> L100
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        AtomicBoolean r13 = f3239a;     // Catch: JSONException -> L100
        if (r1.optInt("enable_json_wrapper") <= 0) goto L20;
        boolean r2 = true;
    L21:
        r13.set(r2);     // Catch: JSONException -> L100
        AtomicBoolean r14 = f3240b;     // Catch: JSONException -> L100
        if (r1.optInt("enable_tnc_jsonopt") <= 0) goto L24;
        boolean r3 = true;
    L25:
        r14.set(r3);     // Catch: JSONException -> L100
        JSONObject r15 = r1.optJSONObject("cronet_fallback_config");     // Catch: JSONException -> L100
        if (r15 == null) goto L52;
        AtomicBoolean r4 = c;     // Catch: JSONException -> L100
        if (r15.optInt("enable_with_contain_armabi") <= 0) goto L30;
        boolean r6 = true;
    L31:
        r4.set(r6);     // Catch: JSONException -> L100
        AtomicBoolean r7 = d;     // Catch: JSONException -> L100
        if (r15.optInt("disable_reason_boot") <= 0) goto L34;
        boolean r8 = true;
    L35:
        r7.set(r8);     // Catch: JSONException -> L100
        AtomicBoolean r9 = e;     // Catch: JSONException -> L100
        if (r15.optInt("disable_reason_cronet_exception") <= 0) goto L38;
        boolean r10 = true;
    L39:
        r9.set(r10);     // Catch: JSONException -> L100
        AtomicBoolean r16 = f;     // Catch: JSONException -> L100
        if (r15.optInt("disable_reason_null_appconfig", 1) <= 0) goto L42;
        boolean r17 = true;
    L43:
        r16.set(r17);     // Catch: JSONException -> L100
        JSONArray r18 = r15.optJSONArray("merge_model_black_list");     // Catch: JSONException -> L100
        List<String> r19 = g;     // Catch: JSONException -> L100
        a(r18, r19);     // Catch: JSONException -> L100
        if (r7.get() == false) goto L47;
        AppConfig.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).resetCronetBootSucceed();     // Catch: JSONException -> L100
    L47:
        if (r19.contains(Build.MODEL) == false) goto L50;
        AppConfig.sCronetUnsupportedModel = true;     // Catch: JSONException -> L100
    L50:
        if (Logger.debug() == false) goto L52;
        Logger.d("ExperimentalSwitches", "sEnableWithContainArmabi is " + r4);     // Catch: JSONException -> L100
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonCronetException is " + r9);     // Catch: JSONException -> L100
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonBoot is " + r7);     // Catch: JSONException -> L100
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonNullAppconfig is " + r16);     // Catch: JSONException -> L100
        goto L52
    L42:
        r17 = false;
        goto L43
    L38:
        r10 = false;
        goto L39
    L34:
        r8 = false;
        goto L35
    L30:
        r6 = false;
    L52:
        JSONObject r110 = r1.optJSONObject("ttnet_okio");     // Catch: JSONException -> L100
        if (r110 == null) goto L64;
        if (r110.optInt("okio_read_enabled", 1) <= 0) goto L57;
        boolean r0 = true;
    L58:
        com.bytedance.frameworks.baselib.network.http.impl.a.c(r0);     // Catch: JSONException -> L100
        if (r110.optInt("zero_copy_enabled", 1) <= 0) goto L61;
        boolean r111 = true;
    L62:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.a.a(r111);     // Catch: JSONException -> L100
        goto L64
    L61:
        r111 = false;
        goto L62
    L57:
        r0 = false;
    L64:
        if (r1.optInt("enable_monitor_v2") <= 0) goto L66;
        boolean r112 = true;
    L67:
        j.a(r112);     // Catch: JSONException -> L100
        com.bytedance.frameworks.baselib.network.http.f.a(r112);     // Catch: JSONException -> L100
        if (r1.optInt("disallow_dup_report") <= 0) goto L70;
        boolean r113 = true;
    L71:
        j.b(r113);     // Catch: JSONException -> L100
        com.bytedance.frameworks.baselib.network.http.f.b(r113);     // Catch: JSONException -> L100
        if (r1.optInt("fix_cancel_req_report_v2") <= 0) goto L74;
        boolean r114 = true;
    L75:
        if (r114 == false) goto L78;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.a.a();     // Catch: JSONException -> L100
    L78:
        if (r1.optInt("sync_report_log") <= 0) goto L80;
        boolean r115 = true;
    L81:
        RetrofitMetrics.setSyncReport(r115);     // Catch: JSONException -> L100
        if (r1.optInt("report_new_metrics") <= 0) goto L84;
        boolean r116 = true;
    L85:
        RetrofitMetrics.setReportNewMetrics(r116);     // Catch: JSONException -> L100
        if (r1.optInt("use_thread_pool") <= 0) goto L88;
        boolean r117 = true;
    L89:
        if (r117 == false) goto L92;
        RetrofitMetrics.setLogReporter(new com.bytedance.frameworks.baselib.network.b.a());     // Catch: JSONException -> L100
    L92:
        if (r1.optInt("opt_reflection") <= 0) goto L94;
        boolean r118 = true;
    L95:
        if (r118 == false) goto L97;
        com.bytedance.frameworks.baselib.network.utils.a.a(true);     // Catch: JSONException -> L100
        com.bytedance.frameworks.baselib.network.http.f.c(true);     // Catch: JSONException -> L100
    L98:
        RetrofitMetrics.setReportDetail(r1.optInt("report_detail", -1));     // Catch: JSONException -> L100
        return;
    L97:
        com.bytedance.frameworks.baselib.network.utils.a.a(false);     // Catch: JSONException -> L100
        com.bytedance.frameworks.baselib.network.http.f.c(false);     // Catch: JSONException -> L100
        goto L98
    L94:
        r118 = false;
        goto L95
    L88:
        r117 = false;
        goto L89
    L84:
        r116 = false;
        goto L85
    L80:
        r115 = false;
        goto L81
    L74:
        r114 = false;
        goto L75
    L70:
        r113 = false;
        goto L71
    L66:
        r112 = false;
        goto L67
    L24:
        r3 = false;
        goto L25
    L20:
        r2 = false;
        goto L21
    L10:
        if (ZeusTransformUtils.instanceOf(r11, JSONObject.class) == true) goto L12;
    L14:
        r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L100
        goto L15
    L12:
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin")).isNull("data") == true) goto L14;
        r12 = (JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L100
        goto L8
    }

    private static void a(JSONArray r2, List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        r4.clear();
        if (r2 != null) goto L8;
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= r2.length()) goto L16;
        r4.add(r2.getString(r0));     // Catch: JSONException -> L13
        r0 = r0 + 1;
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean a() {
        return f3239a.get();
    }

    public static boolean b() {
        return f3240b.get();
    }

    public static boolean c() {
        return c.get();
    }

    public static boolean d() {
        return e.get();
    }

    public static boolean e() {
        return f.get();
    }
}
