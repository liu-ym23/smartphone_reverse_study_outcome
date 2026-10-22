package com.bytedance.apm.config;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.k;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.monitor.EventConfigService;
import com.bytedance.monitor.collector.h;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.bytedance.apm.l.b.InterfaceC0091b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1261b;
    private volatile JSONObject c;
    private volatile JSONObject d;
    private volatile JSONObject e;
    private List<String> f;
    private volatile long g;
    private volatile SharedPreferences h;
    private com.bytedance.apm.core.d i;
    private JSONObject j;
    private boolean k;
    private long l;
    private long m;
    private long n;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private volatile long r;
    private volatile long s;
    private List<com.bytedance.services.slardar.config.a> t;

    g() {
        this.f1261b = false;
        this.f = com.bytedance.apm.b.a.f1111a;
        this.g = 1200;
        this.l = -1;
        this.m = 60000;
        this.n = -1;
        this.o = false;
    }

    private List<String> a(List<String> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (i.a(r6) == true) goto L15;
        ArrayList r8 = new ArrayList(2);     // Catch: MalformedURLException -> L16
        int r1 = r6.size();     // Catch: MalformedURLException -> L16
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        String r3 = new URL((String) ZeusTransformUtils.preCheckCast(r6.get(r2), String.class, "com.obric.memorydata.plugin")).getHost();     // Catch: MalformedURLException -> L16
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r3.indexOf(46) <= 0) goto L12;
        r8.add(ReportConsts.HTTPS + r3 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L16
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        return r8;
    L15:
        return Collections.emptyList();
    }

    private void a(JSONObject r4, boolean r5) {
        List<com.bytedance.services.slardar.config.a> r3 = this.t;
        if (r3 == null) goto L15;
        Iterator<com.bytedance.services.slardar.config.a> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L22;
        ((com.bytedance.services.slardar.config.a) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin")).onRefresh(r4, r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L14;
        th.printStackTrace();
    L14:
        com.bytedance.services.apm.api.a.a(th);
        goto L6
    L22:
        return;
    }

    private void a(boolean r14) {
        if (com.bytedance.apm.b.k() == false) goto L6;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet." + l() + " " + b(System.currentTimeMillis())});
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET", "queryFromNet:" + r14);
    L6:
        if (l() == false) goto L11;
        if (r14 == false) goto L9;
    L10:
        boolean r15 = true;
    L12:
        if (r15 == true) goto L15;
        return;
    L15:
        if (k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L17;
        com.bytedance.apm.core.d r16 = this.i;
        if (r16 == null) goto L60;
        if (r16.a() == null) goto L60;
        if (this.i.a().isEmpty() == true) goto L60;
        if (this.r != 0) goto L31;
        this.r = this.h.getLong("monitor_last_calculate_timestamp_v5", 0);
    L31:
        if (this.s != 0) goto L33;
        this.s = this.h.getLong("monitor_last_full_calculate_timestamp_v5", 0);
    L33:
        this.n = System.currentTimeMillis();
        Iterator<String> r17 = this.f.iterator();
        boolean r6 = false;
    L35:
        if (r17.hasNext() == false) goto L54;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r8 = d();     // Catch: Throwable -> L50
        String r9 = com.bytedance.apm.b.s().optString("aid");     // Catch: Throwable -> L50
        HashMap r10 = new HashMap();     // Catch: Throwable -> L50
        r10.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L50
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r9) == false) goto L40;
    L42:
        com.bytedance.apm.impl.a r12 = new com.bytedance.apm.impl.a(r7, r10, a(r11.toString().getBytes(), r10));     // Catch: Throwable -> L50
        com.bytedance.services.apm.api.c r13 = com.bytedance.apm.b.a(r12.f1371a, r12.c, r12.f1372b);     // Catch: Throwable -> L50
        if (com.bytedance.apm.b.k() == false) goto L45;
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_REQUEST", r12.f1371a);     // Catch: Throwable -> L50
    L45:
        r6 = a(r13);     // Catch: Throwable -> L50
        if (com.bytedance.apm.b.k() == false) goto L48;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r13.b().length + " " + r6});     // Catch: Throwable -> L50
    L48:
        if (r6 == false) goto L35;
    L40:
        if (r9.equals("0") == true) goto L42;
        r11.put(r9, r8);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L35;
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_ERROR", "queFromNetError:" + th);
    L54:
        if (r6 == true) goto L56;
        long r0 = Math.min(this.m * 2, 600000);
    L57:
        this.m = r0;
        return;
    L56:
        r0 = 60000;
    L60:
        if (com.bytedance.apm.b.k() == false) goto L74;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L74:
        return;
    L17:
        if (com.bytedance.apm.b.k() == false) goto L73;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L73:
        return;
    L9:
        if (b(System.currentTimeMillis()) == true) goto L10;
    L11:
        r15 = false;
        goto L12
    }

    static /* synthetic */ boolean a(g r0) {
        return r0.g();
    }

    private boolean a(com.bytedance.services.apm.api.c r5) {
        if (r5 == null) goto L18;
        if (r5.a() != 200) goto L18;
        byte[] r6 = r5.b();
        if (r6 != null) goto L9;
        return false;
    L9:
        JSONObject r1 = new JSONObject(new String(r6));
        if (com.bytedance.apm.b.k() == false) goto L12;
        Logger.d("SlardarConfigFetcher", "resultJSON:" + r1);
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_RESULT", r1.toString());
    L12:
        JSONObject r7 = r1.optJSONObject(com.bytedance.apm.b.s().optString("aid"));
        if (r7 != null) goto L16;
        return false;
    L16:
        return a(r7);
    L18:
        if (com.bytedance.apm.b.k() == false) goto L24;
        DoctorManager r4 = DoctorManager.getInstance();
        StringBuilder r2 = new StringBuilder().append("statusCode error:");
        if (r5 != null) goto L22;
        Object r8 = "null";
    L23:
        r4.a("APM_SETTING_UPDATE_FROM_NET_ERROR", r2.append(r8).toString());
        goto L24
    L22:
        r8 = Integer.valueOf(r5.a());
    L24:
        return false;
    }

    public static byte[] a(byte[] r2, Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r2.length <= 128) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        r1.close();
        byte[] r5 = r0.toByteArray();
        r4.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        return r5;
    L9:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L14:
        return r2;
    }

    private void b(JSONObject r5) {
        if (JsonUtils.b(r5) == false) goto L5;
        return;
    L5:
        JSONObject r0 = JsonUtils.a(r5, SlardarSettingsConstants.SETTING_GENERAL, SlardarSettingsConstants.SETTING_GENERAL_API);
        if (r0 == null) goto L13;
        JSONObject r1 = r0.optJSONObject("fetch_setting");
        if (r1 == null) goto L11;
        this.g = r1.optLong("fetch_setting_interval", 1200);
    L11:
        if (this.g >= 600) goto L13;
        this.g = 600;
    L13:
        JSONObject r2 = r5.optJSONObject("custom_event_settings");
        if (r2 == null) goto L16;
        this.c = r2.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        this.d = r2.optJSONObject("allow_metric_type");
        this.e = r2.optJSONObject("allow_service_name");
    L16:
        this.j = r5;
        JSONObject r6 = e(EventConfigService.EXCEPTION_MODULE);
        if (r6 == null) goto L26;
        JSONObject r7 = r6.optJSONObject(CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (r7 == null) goto L26;
        if (r7.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD) != 1) goto L23;
        boolean r8 = true;
    L24:
        this.f1261b = r8;
        goto L26
    L23:
        r8 = false;
    L26:
        if (c(CommonConsts.APM_INNER_EVENT_COST) == false) goto L29;
        h.a(new AnonymousClass3(this));
        h.a(true);
        return;
    }

    private boolean b(long r8) {
        long r0 = this.m;
        if (r0 <= 60000) goto L10;
        if ((r8 - this.n) <= r0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r8 - this.l) <= (this.g * 1000)) goto L13;
        return true;
    L13:
        return false;
    }

    static /* synthetic */ boolean b(g r0) {
        return r0.q;
    }

    private void c(JSONObject r7) {
        JSONObject r6 = r7.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        boolean r0 = true;
        if (r6 == null) goto L5;
        com.bytedance.apm.internal.a.a(32, !r6.optBoolean("enable_salvage_log", true));
    L5:
        JSONObject r1 = JsonUtils.a(r7, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "smooth");
        if (r1 != null) goto L8;
    L20:
        JSONObject r8 = JsonUtils.a(r7, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "start_trace");
        if (r8 != null) goto L23;
    L39:
        if (r1 != null) goto L41;
        if (r8 != null) goto L41;
        return;
    L41:
        com.bytedance.apm.internal.a.a();
        return;
    L23:
        if (r8.optInt("enable_perf_data_collect", 0) != 1) goto L25;
        boolean r3 = true;
    L26:
        com.bytedance.apm.internal.a.a(4, r3);
        if (r8.optInt("enable_lock_data_collect", 0) != 1) goto L29;
        boolean r4 = true;
    L30:
        com.bytedance.apm.internal.a.a(8, r4);
        if (r8.optInt("enable_long_sleep_data_collect", 0) != 1) goto L33;
        boolean r5 = true;
    L34:
        com.bytedance.apm.internal.a.a(16, r5);
        if (r8.optInt("enable_thread_cpu_collect", 0) == 1) goto L38;
        r0 = false;
    L38:
        com.bytedance.apm.internal.a.a(128, r0);
        com.bytedance.apm.internal.a.a(r8.optInt("thread_cpu_collect_count", 0));
        goto L39
    L33:
        r5 = false;
        goto L34
    L29:
        r4 = false;
        goto L30
    L25:
        r3 = false;
        goto L26
    L8:
        if (r1.optInt("block_enable_upload", 0) != 1) goto L10;
        boolean r9 = true;
    L11:
        com.bytedance.apm.internal.a.a(1, r9);
        if (r1.optInt("enable_trace", 0) != 1) goto L14;
        boolean r10 = true;
    L15:
        com.bytedance.apm.internal.a.a(2, r10);
        if (r1.optInt("enable_stack_sampling", 0) != 1) goto L18;
        boolean r11 = true;
    L19:
        com.bytedance.apm.internal.a.a(64, r11);
        com.bytedance.apm.internal.a.a(r1.optLong("atrace_tag", 0));
        com.bytedance.apm.internal.a.a(-536870912, com.bytedance.apm.block.g.a(r7) << 29);
        goto L20
    L18:
        r11 = false;
        goto L19
    L14:
        r10 = false;
        goto L15
    L10:
        r9 = false;
        goto L11
    }

    private void f() {
        if (this.o == true) goto L9;
        this.o = true;
        if (l() == false) goto L7;
        com.bytedance.apm.l.b.a().a(this);
    L7:
        h();
        return;
    }

    private boolean g() {
        String r0 = e();
        if (com.bytedance.apm.e.a.c() == null) goto L6;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L29
        r1.put("updateFromLocal", TextUtils.isEmpty(r0));     // Catch: Exception -> L29
        com.bytedance.apm.e.a.c().b("SlardarConfigFetcher", r1.toString());     // Catch: Exception -> L29
    L6:
        if (com.bytedance.apm.b.k() == false) goto L9;
        Logger.d("SlardarConfigFetcher", "configStr:" + r0);
    L9:
        if (com.bytedance.apm.b.k() == false) goto L12;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r0});
    L12:
        if (TextUtils.isEmpty(r0) == false) goto L32;
    L24:
        boolean r10 = true;
    L26:
        if (com.bytedance.apm.b.k() == false) goto L28;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r10});
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_LOCAL", "needForceRefreshFromNet:" + r10 + " localConfig:" + r0);
    L28:
        return r10;
    L32:
        JSONObject r2 = new JSONObject(r0);     // Catch: Exception -> L23
        this.k = true;     // Catch: Exception -> L23
        int r6 = this.h.getInt("setting_version", 0);     // Catch: Exception -> L23
        if (com.bytedance.apm.b.k() == false) goto L17;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r6});     // Catch: Exception -> L23
    L17:
        if (r6 != 5) goto L24;
        this.l = j();     // Catch: Exception -> L23
        this.r = this.h.getLong("monitor_last_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        this.s = this.h.getLong("monitor_last_full_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        if (com.bytedance.apm.b.k() == false) goto L21;
        Logger.d("SlardarConfigFetcher", "lastCalculateTimestamp:" + this.r);     // Catch: Exception -> L23
    L21:
        com.bytedance.apm.b.a(Constants.KEY_CONFIG_TIME, this.l + "");     // Catch: Exception -> L23
        ApmContext.setConfigTime(this.l);     // Catch: Exception -> L23
        b(r2);     // Catch: Exception -> L23
        a(r2, true);     // Catch: Exception -> L23
        m();     // Catch: Exception -> L23
        r10 = false;
    L23:
        com.bytedance.apm.e.e.a(com.bytedance.apm.e.b.f1307a, new String[]{"config read error"});
        goto L24
    }

    private void h() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("com.apm.setting.update.action");
        PluginBroadcastReceiver r1 = new AnonymousClass1(this);
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L16;
    L9:
        th = move-exception;
        Logger.e("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1, r0, 2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L12
    }

    private void i() {
        com.bytedance.apm.l.b.a().a(new AnonymousClass2(this), 1000);
    }

    private long j() {
        return this.h.getLong("monitor_configure_refresh_time", 0);
    }

    private void k() {
        if (this.h != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.h != null) goto L8;
        this.h = com.bytedance.apm.core.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private boolean l() {
        if (this.q == false) goto L5;
    L8:
        return true;
    L5:
        if (this.p == true) goto L8;
        return false;
    }

    private void m() {
        if (this.f1260a == true) goto L17;
        this.f1260a = true;
        List<com.bytedance.services.slardar.config.a> r3 = this.t;
        if (r3 == null) goto L24;
        Iterator<com.bytedance.services.slardar.config.a> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L25;
        ((com.bytedance.services.slardar.config.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin")).onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L16;
        th.printStackTrace();
    L16:
        com.bytedance.services.apm.api.a.a(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    int a(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.j;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }

    void a() {
        boolean r0 = g();
        if (com.bytedance.apm.b.f() == true) goto L5;
        return;
    L5:
        if (this.l <= System.currentTimeMillis()) goto L7;
        r0 = true;
    L7:
        a(r0);
    }

    @Override // com.bytedance.apm.l.b.InterfaceC0091b
    public void a(long r1) {
        a(false);
    }

    public void a(com.bytedance.apm.core.d r3, List<String> r4) {
        com.bytedance.apm.core.d r5 = (com.bytedance.apm.core.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.core.d.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        g();
        if (r5 == null) goto L6;
        this.i = r5;
    L6:
        if (i.a(r6) == true) goto L8;
        this.f = new ArrayList(r6);
    L8:
        a(true);
    }

    void a(com.bytedance.services.slardar.config.a r5) {
        com.bytedance.services.slardar.config.a r6 = (com.bytedance.services.slardar.config.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return;
    L6:
        if (this.t != null) goto L9;
        this.t = new CopyOnWriteArrayList();
    L9:
        if (this.t.contains(r6) == true) goto L12;
        this.t.add(r6);
    L12:
        if (com.bytedance.apm.b.k() == false) goto L15;
        com.bytedance.apm.e.e.c("apm_initializing", new String[]{"addConfigListener, mReady=" + this.f1260a});
    L15:
        if (this.f1260a == false) goto L18;
        r6.onRefresh(this.j, this.k);
        r6.onReady();
        return;
    }

    public void a(boolean r3, com.bytedance.apm.core.d r4, List<String> r5) {
        com.bytedance.apm.core.d r6 = (com.bytedance.apm.core.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.apm.core.d.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.p = r3;
        this.q = com.bytedance.apm.b.f();
        k();
        this.i = r6;
        if (i.a(r7) == true) goto L5;
        this.f = a(r7);
    L5:
        f();
    }

    public boolean a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r3, LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L9;
        r3 = LogTypeName.MONITOR_TYPE_OLD_BLOCK;
    L9:
        if (TextUtils.equals(r3, "core_exception_monitor") == false) goto L13;
        return this.f1261b;
    L13:
        if (this.c != null) goto L16;
        return false;
    L16:
        if (this.c.optInt(r3) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    public boolean a(JSONObject r15) {
        int r0 = r15.optInt("code", -1);
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 != 1) goto L9;
        this.l = System.currentTimeMillis();
        this.r = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.s = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r16 = this.h.edit();
        r16.putLong("monitor_configure_refresh_time", this.l);
        r16.putLong("monitor_last_calculate_timestamp_v5", this.r);
        r16.putLong("monitor_last_full_calculate_timestamp_v5", this.s);
        r16.commit();
        return true;
    L9:
        if (r0 != 0) goto L11;
    L14:
        JSONObject r1 = null;
        JSONObject r10 = r15.optJSONObject("data");
        if (r10 == null) goto L17;
        r1 = r10;
    L26:
        if (r1 != null) goto L46;
        return false;
    L46:
        JSONObject r11 = r15.optJSONObject("data_to_merge");     // Catch: JSONException -> L32
        if (r11 == null) goto L48;
        com.bytedance.apm6.util.JsonUtils.mergeNestedData(r1, r11);     // Catch: JSONException -> L32
    L48:
        JSONObject r12 = r15.optJSONObject("data_to_delete");     // Catch: JSONException -> L40
        if (r12 == null) goto L44;
        com.bytedance.apm6.util.JsonUtils.deleteNestedData(r1, r12);     // Catch: JSONException -> L40
    L44:
        this.r = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.s = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.l = System.currentTimeMillis();
        this.k = false;
        b(r1);
        c(r1);
        SharedPreferences.Editor r17 = this.h.edit();
        r17.putString("monitor_net_config", r1.toString());
        r17.putInt("setting_version", 5);
        r17.putLong("monitor_configure_refresh_time", this.l);
        r17.putLong("monitor_last_calculate_timestamp_v5", this.r);
        r17.putLong("monitor_last_full_calculate_timestamp_v5", this.s);
        r17.commit();
        a(r1, false);
        m();
        com.bytedance.apm.b.a(Constants.KEY_CONFIG_TIME, this.l + "");
        ApmContext.setConfigTime(this.l);
        i();
        com.bytedance.apm.e.a.b("apm_debug", "APM_SETTING_READY");
        return true;
    L40:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (com.bytedance.apm.b.k() == false) goto L44;
        Logger.e("SlardarConfigFetcher", "error nested data: dataToDelete");
    L32:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (com.bytedance.apm.b.k() == false) goto L48;
        Logger.e("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L48
    L17:
        String r13 = e();
        if (TextUtils.isEmpty(r13) == false) goto L50;
        r13 = "{}";
    L50:
        r1 = new JSONObject(r13);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (com.bytedance.apm.b.k() == false) goto L26;
        Logger.e("SlardarConfigFetcher", "error parse configStr:" + r13);
        goto L26
    L11:
        if (r0 == 2) goto L14;
        return false;
    }

    void b(com.bytedance.services.slardar.config.a r3) {
        com.bytedance.services.slardar.config.a r4 = (com.bytedance.services.slardar.config.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<com.bytedance.services.slardar.config.a> r2 = this.t;
        if (r2 == null) goto L9;
        r2.remove(r4);
        return;
    }

    boolean b() {
        return this.f1260a;
    }

    boolean b(String r3) {
        if (this.d != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.d.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public JSONObject c() {
        return this.j;
    }

    boolean c(String r3) {
        if (this.e != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.e.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public JSONObject d() {
        com.bytedance.apm.core.d r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        Map<String, String> r1 = null;
    L9:
        if (r1 == null) goto L11;
        HashMap r2 = new HashMap(r1);
    L12:
        r2.put("last_calculate_timestamp", String.valueOf(this.r / 1000));
        r2.put("last_full_calculate_timestamp", String.valueOf(this.s / 1000));
        if ((System.currentTimeMillis() - this.r) < 345600000) goto L15;
        r2.put("force_refresh", String.valueOf(1));
    L15:
        r2.put("minor_version", "1");
        return new JSONObject(r2);
    L11:
        r2 = new HashMap();
        goto L12
    L5:
        if (r0.a() == null) goto L7;
        r1 = this.i.a();
        goto L9
    }

    boolean d(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.j;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    String e() {
        k();
        return this.h.getString("monitor_net_config", "");
    }

    JSONObject e(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONObject r1 = this.j;
        if (r1 == null) goto L10;
        return r1.optJSONObject(r2);
    L10:
        return new JSONObject();
    }
}
