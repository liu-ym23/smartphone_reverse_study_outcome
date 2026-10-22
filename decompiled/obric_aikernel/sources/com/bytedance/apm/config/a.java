package com.bytedance.apm.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.block.g;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.d;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.r;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.monitor.EventConfigService;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.monitor.collector.h;
import e0.e;
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
public class a implements q0.b.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f883c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile JSONObject f885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile JSONObject f886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile JSONObject f887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile SharedPreferences f890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IQueryParams f891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private JSONObject f892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f897t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f898u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f899v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile long f900w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile long f901x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<u4.a> f902y;

    /* JADX INFO: renamed from: com.bytedance.apm.config.a$a, reason: collision with other inner class name */
    class C0033a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f903a;

        /* JADX INFO: renamed from: com.bytedance.apm.config.a$a$a, reason: collision with other inner class name */
        class RunnableC0034a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ C0033a f904c;

            RunnableC0034a(C0033a r10) {
                this.f904c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a(this.f904c.f903a);     // Catch: Throwable -> L4
                return;
            }
        }

        C0033a(a r10) {
            this.f903a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 == null) goto L17;
            String r12 = r11.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L14
            String r13 = r.a(d.g());     // Catch: Throwable -> L14
            if (d.D() == false) goto L7;
            e.d("apm_initializing", new String[]{"BroadcastReceiver.onReceive, processName:", r12, "currentProcessName:", r13});     // Catch: Throwable -> L14
        L7:
            if (TextUtils.isEmpty(r12) == false) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r13) == false) goto L11;
            return;
        L11:
            if (r12.equals(r13) == true) goto L20;
            q0.b.f().i(new RunnableC0034a(this));     // Catch: Throwable -> L14
            return;
        L20:
            return;
        L21:
            return;
        }
    }

    class b implements Runnable {
        b(a r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent r10 = new Intent("com.apm.setting.update.action");     // Catch: Exception -> L6
            r10.putExtra("PROCESS_NAME", r.a(d.g()));     // Catch: Exception -> L6
            d.g().sendBroadcast(r10);     // Catch: Exception -> L6
            if (d.D() == false) goto L9;
            e.d("apm_initializing", new String[]{"BroadcastReceiver.sendBroadUpdateSetting"});     // Catch: Exception -> L6
            return;
        L9:
            return;
        }
    }

    class c implements h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f905a;

        /* JADX INFO: renamed from: com.bytedance.apm.config.a$c$a, reason: collision with other inner class name */
        class RunnableC0035a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f906c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f907g;

            RunnableC0035a(c r10, long r11) {
                this.f907g = r10;
                this.f906c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
                r10.put("looper_monitor", this.f906c);     // Catch: JSONException -> L4
                JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
                r11.put("is_main_process", a.b(this.f907g.f905a));     // Catch: JSONException -> L4
                com.bytedance.apm.c.h(CommonConsts.APM_INNER_EVENT_COST, r11, r10, null);     // Catch: JSONException -> L4
                return;
            }
        }

        c(a r10) {
            this.f905a = r10;
        }

        @Override // com.bytedance.monitor.collector.h.c
        public void a(long r10) {
            q0.b.f().i(new RunnableC0035a(this, r10));
        }
    }

    a() {
        this.f884g = false;
        this.f888k = v.a.f13152a;
        this.f889l = 1200;
        this.f894q = -1;
        this.f895r = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        this.f896s = -1;
        this.f897t = false;
    }

    private void A() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("com.apm.setting.update.action");
        C0033a r11 = new C0033a(this);
        if (d.g() == null) goto L16;
    L9:
        th = move-exception;
        Logger.e("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        d.g().registerReceiver(r11, r10, 2);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        d.g().registerReceiver(r11, r10);     // Catch: Throwable -> L9
        goto L12
    }

    private void D(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        boolean r12 = true;
        if (r11 == null) goto L5;
        com.bytedance.apm.internal.a.j(32, !r11.optBoolean("enable_salvage_log", true));
    L5:
        JSONObject r13 = i.g(r10, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "smooth");
        if (r13 != null) goto L8;
    L20:
        JSONObject r14 = i.g(r10, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "start_trace");
        if (r14 != null) goto L23;
    L39:
        if (r13 != null) goto L41;
        if (r14 != null) goto L41;
        return;
    L41:
        com.bytedance.apm.internal.a.f();
        return;
    L23:
        if (r14.optInt("enable_perf_data_collect", 0) != 1) goto L25;
        boolean r15 = true;
    L26:
        com.bytedance.apm.internal.a.j(4, r15);
        if (r14.optInt("enable_lock_data_collect", 0) != 1) goto L29;
        boolean r16 = true;
    L30:
        com.bytedance.apm.internal.a.j(8, r16);
        if (r14.optInt("enable_long_sleep_data_collect", 0) != 1) goto L33;
        boolean r17 = true;
    L34:
        com.bytedance.apm.internal.a.j(16, r17);
        if (r14.optInt("enable_thread_cpu_collect", 0) == 1) goto L38;
        r12 = false;
    L38:
        com.bytedance.apm.internal.a.j(128, r12);
        com.bytedance.apm.internal.a.h(r14.optInt("thread_cpu_collect_count", 0));
        goto L39
    L33:
        r17 = false;
        goto L34
    L29:
        r16 = false;
        goto L30
    L25:
        r15 = false;
        goto L26
    L8:
        if (r13.optInt("block_enable_upload", 0) != 1) goto L10;
        boolean r18 = true;
    L11:
        com.bytedance.apm.internal.a.j(1, r18);
        if (r13.optInt("enable_trace", 0) != 1) goto L14;
        boolean r19 = true;
    L15:
        com.bytedance.apm.internal.a.j(2, r19);
        if (r13.optInt("enable_stack_sampling", 0) != 1) goto L18;
        boolean r20 = true;
    L19:
        com.bytedance.apm.internal.a.j(64, r20);
        com.bytedance.apm.internal.a.g(r13.optLong("atrace_tag", 0));
        com.bytedance.apm.internal.a.i(-536870912, g.c(r10) << 29);
        goto L20
    L18:
        r20 = false;
        goto L19
    L14:
        r19 = false;
        goto L15
    L10:
        r18 = false;
        goto L11
    }

    private void E() {
        q0.b.f().j(new b(this), 1000);
    }

    private void F(JSONObject r10) {
        if (i.d(r10) == false) goto L5;
        return;
    L5:
        JSONObject r11 = i.g(r10, SlardarSettingsConstants.SETTING_GENERAL, SlardarSettingsConstants.SETTING_GENERAL_API);
        if (r11 == null) goto L13;
        JSONObject r12 = r11.optJSONObject("fetch_setting");
        if (r12 == null) goto L11;
        this.f889l = r12.optLong("fetch_setting_interval", 1200);
    L11:
        if (this.f889l >= 600) goto L13;
        this.f889l = 600;
    L13:
        JSONObject r13 = r10.optJSONObject("custom_event_settings");
        if (r13 == null) goto L16;
        this.f885h = r13.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        this.f886i = r13.optJSONObject("allow_metric_type");
        this.f887j = r13.optJSONObject("allow_service_name");
    L16:
        this.f892o = r10;
        JSONObject r14 = i(EventConfigService.EXCEPTION_MODULE);
        if (r14 == null) goto L26;
        JSONObject r15 = r14.optJSONObject(CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (r15 == null) goto L26;
        if (r15.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD) != 1) goto L23;
        boolean r16 = true;
    L24:
        this.f884g = r16;
        goto L26
    L23:
        r16 = false;
    L26:
        if (l(CommonConsts.APM_INNER_EVENT_COST) == false) goto L29;
        h.m(new c(this));
        h.e(true);
        return;
    }

    private boolean G() {
        String r10 = x();
        if (e0.a.c() == null) goto L6;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L29
        r11.put("updateFromLocal", TextUtils.isEmpty(r10));     // Catch: Exception -> L29
        e0.a.c().d("SlardarConfigFetcher", r11.toString());     // Catch: Exception -> L29
    L6:
        if (d.D() == false) goto L9;
        Logger.d("SlardarConfigFetcher", "configStr:" + r10);
    L9:
        if (d.D() == false) goto L12;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r10});
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L30;
    L24:
        boolean r12 = true;
    L26:
        if (d.D() == false) goto L28;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r12});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_LOCAL", "needForceRefreshFromNet:" + r12 + " localConfig:" + r10);
    L28:
        return r12;
    L30:
        JSONObject r13 = new JSONObject(r10);     // Catch: Exception -> L23
        this.f893p = true;     // Catch: Exception -> L23
        int r14 = this.f890m.getInt("setting_version", 0);     // Catch: Exception -> L23
        if (d.D() == false) goto L17;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r14});     // Catch: Exception -> L23
    L17:
        if (r14 != 5) goto L24;
        this.f894q = z();     // Catch: Exception -> L23
        this.f900w = this.f890m.getLong("monitor_last_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        this.f901x = this.f890m.getLong("monitor_last_full_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        if (d.D() == false) goto L21;
        Logger.d("SlardarConfigFetcher", "lastCalculateTimestamp:" + this.f900w);     // Catch: Exception -> L23
    L21:
        d.e(Constants.KEY_CONFIG_TIME, this.f894q + "");     // Catch: Exception -> L23
        ApmContext.setConfigTime(this.f894q);     // Catch: Exception -> L23
        F(r13);     // Catch: Exception -> L23
        w(r13, true);     // Catch: Exception -> L23
        v();     // Catch: Exception -> L23
        r12 = false;
    L23:
        e.c(e0.b.f8547a, new String[]{"config read error"});
        goto L24
    }

    static /* synthetic */ boolean a(a r10) {
        return r10.G();
    }

    static /* synthetic */ boolean b(a r10) {
        return r10.f899v;
    }

    public static byte[] d(byte[] r10, Map<String, String> r11) {
        if (r10.length <= 128) goto L14;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = new GZIPOutputStream(r12);
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L9
        r13.close();
        byte[] r14 = r12.toByteArray();
        r11.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        return r14;
    L7:
        th = move-exception;
        r13.close();
        throw th;
    L9:
        e = move-exception;
        t4.a.d(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L14:
        return r10;
    }

    private List<String> e(List<String> r10) {
        if (j.b(r10) == true) goto L14;
        ArrayList r11 = new ArrayList(2);     // Catch: MalformedURLException -> L15
        int r12 = r10.size();     // Catch: MalformedURLException -> L15
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L12;
        String r14 = new URL(r10.get(r13)).getHost();     // Catch: MalformedURLException -> L15
        if (TextUtils.isEmpty(r14) == true) goto L11;
        if (r14.indexOf(46) <= 0) goto L11;
        r11.add(ReportConsts.HTTPS + r14 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L15
    L11:
        r13 = r13 + 1;
        goto L5
    L12:
        return r11;
    L14:
        return Collections.emptyList();
    }

    private boolean n(t4.c r10) {
        if (r10 == null) goto L18;
        if (r10.c() != 200) goto L18;
        byte[] r11 = r10.b();
        if (r11 != null) goto L9;
        return false;
    L9:
        JSONObject r12 = new JSONObject(new String(r11));
        if (d.D() == false) goto L12;
        Logger.d("SlardarConfigFetcher", "resultJSON:" + r12);
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_RESULT", r12.toString());
    L12:
        JSONObject r13 = r12.optJSONObject(d.j().optString("aid"));
        if (r13 != null) goto L16;
        return false;
    L16:
        return H(r13);
    L18:
        if (d.D() == false) goto L24;
        DoctorManager r14 = DoctorManager.getInstance();
        StringBuilder r15 = new StringBuilder();
        r15.append("statusCode error:");
        if (r10 != null) goto L22;
        Object r16 = "null";
    L23:
        r15.append(r16);
        r14.b("APM_SETTING_UPDATE_FROM_NET_ERROR", r15.toString());
        goto L24
    L22:
        r16 = Integer.valueOf(r10.c());
    L24:
        return false;
    }

    private void q() {
        if (this.f897t == true) goto L9;
        this.f897t = true;
        if (s() == false) goto L7;
        q0.b.f().c(this);
    L7:
        A();
        return;
    }

    private void r() {
        if (this.f890m != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f890m != null) goto L8;
        this.f890m = MonitorSharedPreferences.getSharedPreferences(d.g(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private boolean s() {
        if (this.f899v == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f898u == true) goto L8;
        return false;
    }

    private boolean t(long r10) {
        long r11 = this.f895r;
        if (r11 <= VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L10;
        if ((r10 - this.f896s) <= r11) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r10 - this.f894q) <= (this.f889l * 1000)) goto L13;
        return true;
    L13:
        return false;
    }

    private void v() {
        if (this.f883c == true) goto L17;
        this.f883c = true;
        List<u4.a> r10 = this.f902y;
        if (r10 == null) goto L24;
        Iterator<u4.a> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L25;
        r11.next().onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (d.D() == false) goto L16;
        th.printStackTrace();
    L16:
        t4.a.c(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    private void w(JSONObject r10, boolean r11) {
        List<u4.a> r12 = this.f902y;
        if (r12 == null) goto L15;
        Iterator<u4.a> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L22;
        r13.next().onRefresh(r10, r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (d.D() == false) goto L14;
        th.printStackTrace();
    L14:
        t4.a.c(th);
        goto L6
    L22:
        return;
    }

    private void y(boolean r13) {
        if (d.D() == false) goto L6;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet." + s() + " " + t(System.currentTimeMillis())});
        DoctorManager r10 = DoctorManager.getInstance();
        StringBuilder r11 = new StringBuilder();
        r11.append("queryFromNet:");
        r11.append(r13);
        r10.b("APM_SETTING_UPDATE_FROM_NET", r11.toString());
    L6:
        if (s() == false) goto L11;
        if (r13 == false) goto L9;
    L10:
        boolean r14 = true;
    L12:
        if (r14 == true) goto L15;
        return;
    L15:
        if (m.b(d.g()) == false) goto L17;
        IQueryParams r15 = this.f891n;
        if (r15 == null) goto L60;
        if (r15.getQueryParams() == null) goto L60;
        if (this.f891n.getQueryParams().isEmpty() == true) goto L60;
        if (this.f900w != 0) goto L31;
        this.f900w = this.f890m.getLong("monitor_last_calculate_timestamp_v5", 0);
    L31:
        if (this.f901x != 0) goto L33;
        this.f901x = this.f890m.getLong("monitor_last_full_calculate_timestamp_v5", 0);
    L33:
        this.f896s = System.currentTimeMillis();
        Iterator<String> r16 = this.f888k.iterator();
        boolean r12 = false;
    L35:
        if (r16.hasNext() == false) goto L54;
        String r17 = r16.next();
        JSONObject r18 = C();     // Catch: Throwable -> L50
        String r19 = d.j().optString("aid");     // Catch: Throwable -> L50
        HashMap r20 = new HashMap();     // Catch: Throwable -> L50
        r20.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);     // Catch: Throwable -> L50
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r19) == false) goto L40;
    L42:
        com.bytedance.apm.impl.a r21 = new com.bytedance.apm.impl.a(r17, r20, d(r110.toString().getBytes(), r20));     // Catch: Throwable -> L50
        t4.c r22 = d.d(r21.f953a, r21.f955c, r21.f954b);     // Catch: Throwable -> L50
        if (d.D() == false) goto L45;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_REQUEST", r21.f953a);     // Catch: Throwable -> L50
    L45:
        r12 = n(r22);     // Catch: Throwable -> L50
        if (d.D() == false) goto L48;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r22.b().length + " " + r12});     // Catch: Throwable -> L50
    L48:
        if (r12 == false) goto L35;
    L40:
        if (r19.equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L42;
        r110.put(r19, r18);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (d.D() == false) goto L35;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "queFromNetError:" + th);
    L54:
        if (r12 == true) goto L56;
        long r23 = Math.min(this.f895r * 2, 600000);
    L57:
        this.f895r = r23;
        return;
    L56:
        r23 = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
    L60:
        if (d.D() == false) goto L74;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L74:
        return;
    L17:
        if (d.D() == false) goto L73;
        e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L73:
        return;
    L9:
        if (t(System.currentTimeMillis()) == true) goto L10;
    L11:
        r14 = false;
        goto L12
    }

    private long z() {
        return this.f890m.getLong("monitor_configure_refresh_time", 0);
    }

    void B(u4.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<u4.a> r11 = this.f902y;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }

    public JSONObject C() {
        IQueryParams r10 = this.f891n;
        if (r10 != null) goto L5;
    L7:
        Map<String, String> r11 = null;
    L9:
        if (r11 == null) goto L11;
        HashMap r12 = new HashMap(r11);
    L12:
        r12.put("last_calculate_timestamp", String.valueOf(this.f900w / 1000));
        r12.put("last_full_calculate_timestamp", String.valueOf(this.f901x / 1000));
        if ((System.currentTimeMillis() - this.f900w) < 345600000) goto L15;
        r12.put("force_refresh", String.valueOf(1));
    L15:
        r12.put("minor_version", NetConst.ENCRYPT_VERISON_CODE);
        return new JSONObject(r12);
    L11:
        r12 = new HashMap();
        goto L12
    L5:
        if (r10.getQueryParams() == null) goto L7;
        r11 = this.f891n.getQueryParams();
        goto L9
    }

    public boolean H(JSONObject r15) {
        int r10 = r15.optInt("code", -1);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (r10 != 1) goto L9;
        this.f894q = System.currentTimeMillis();
        this.f900w = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f901x = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r16 = this.f890m.edit();
        r16.putLong("monitor_configure_refresh_time", this.f894q);
        r16.putLong("monitor_last_calculate_timestamp_v5", this.f900w);
        r16.putLong("monitor_last_full_calculate_timestamp_v5", this.f901x);
        r16.commit();
        return true;
    L9:
        if (r10 != 0) goto L11;
    L14:
        JSONObject r11 = null;
        JSONObject r12 = r15.optJSONObject("data");
        if (r12 == null) goto L17;
        r11 = r12;
    L26:
        if (r11 != null) goto L48;
        return false;
    L48:
        JSONObject r13 = r15.optJSONObject("data_to_merge");     // Catch: JSONException -> L32
        if (r13 == null) goto L46;
        JsonUtils.mergeNestedData(r11, r13);     // Catch: JSONException -> L32
    L46:
        JSONObject r14 = r15.optJSONObject("data_to_delete");     // Catch: JSONException -> L40
        if (r14 == null) goto L44;
        JsonUtils.deleteNestedData(r11, r14);     // Catch: JSONException -> L40
    L44:
        this.f900w = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f901x = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.f894q = System.currentTimeMillis();
        this.f893p = false;
        F(r11);
        D(r11);
        SharedPreferences.Editor r17 = this.f890m.edit();
        r17.putString("monitor_net_config", r11.toString());
        r17.putInt("setting_version", 5);
        r17.putLong("monitor_configure_refresh_time", this.f894q);
        r17.putLong("monitor_last_calculate_timestamp_v5", this.f900w);
        r17.putLong("monitor_last_full_calculate_timestamp_v5", this.f901x);
        r17.commit();
        w(r11, false);
        v();
        d.e(Constants.KEY_CONFIG_TIME, this.f894q + "");
        ApmContext.setConfigTime(this.f894q);
        E();
        e0.a.d("apm_debug", "APM_SETTING_READY");
        return true;
    L40:
        e = move-exception;
        t4.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (d.D() == false) goto L44;
        Logger.e("SlardarConfigFetcher", "error nested data: dataToDelete");
    L32:
        e = move-exception;
        t4.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (d.D() == false) goto L46;
        Logger.e("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L46
    L17:
        String r18 = x();
        if (TextUtils.isEmpty(r18) == false) goto L50;
        r18 = "{}";
    L50:
        r11 = new JSONObject(r18);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        t4.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (d.D() == false) goto L26;
        Logger.e("SlardarConfigFetcher", "error parse configStr:" + r18);
        goto L26
    L11:
        if (r10 == 2) goto L14;
        return false;
    }

    void c(u4.a r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f902y != null) goto L8;
        this.f902y = new CopyOnWriteArrayList();
    L8:
        if (this.f902y.contains(r10) == true) goto L11;
        this.f902y.add(r10);
    L11:
        if (d.D() == false) goto L14;
        e.d("apm_initializing", new String[]{"addConfigListener, mReady=" + this.f883c});
    L14:
        if (this.f883c == false) goto L17;
        r10.onRefresh(this.f892o, this.f893p);
        r10.onReady();
        return;
    }

    @WorkerThread
    public void f(@Nullable IQueryParams r10, @Nullable List<String> r11) {
        G();
        if (r10 == null) goto L6;
        this.f891n = r10;
    L6:
        if (j.b(r11) == true) goto L8;
        this.f888k = new ArrayList(r11);
    L8:
        y(true);
    }

    public JSONObject g() {
        return this.f892o;
    }

    int h(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r12 = this.f892o;
        if (r12 == null) goto L9;
        return r12.optInt(r10, r11);
    L9:
        return r11;
    }

    JSONObject i(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        JSONObject r11 = this.f892o;
        if (r11 == null) goto L10;
        return r11.optJSONObject(r10);
    L10:
        return new JSONObject();
    }

    public boolean j(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r10, LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L9;
        r10 = LogTypeName.MONITOR_TYPE_OLD_BLOCK;
    L9:
        if (TextUtils.equals(r10, "core_exception_monitor") == false) goto L13;
        return this.f884g;
    L13:
        if (this.f885h != null) goto L16;
        return false;
    L16:
        if (this.f885h.optInt(r10) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    boolean k(String r10) {
        if (this.f886i != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f886i.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean l(String r10) {
        if (this.f887j != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f887j.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean m(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r11 = this.f892o;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.optBoolean(r10);
    L9:
        return false;
    }

    @WorkerThread
    void o() {
        boolean r10 = G();
        if (d.I() == true) goto L5;
        return;
    L5:
        if (this.f894q <= System.currentTimeMillis()) goto L7;
        r10 = true;
    L7:
        y(r10);
    }

    @Override // q0.b.e
    public void onTimeEvent(long r10) {
        y(false);
    }

    public void p(boolean r10, IQueryParams r11, List<String> r12) {
        this.f898u = r10;
        this.f899v = d.I();
        r();
        this.f891n = r11;
        if (j.b(r12) == true) goto L5;
        this.f888k = e(r12);
    L5:
        q();
    }

    boolean u() {
        return this.f883c;
    }

    String x() {
        r();
        return this.f890m.getString("monitor_net_config", "");
    }
}
