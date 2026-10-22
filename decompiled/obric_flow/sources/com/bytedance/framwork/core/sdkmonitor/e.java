package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdklib.util.NetUtils$NetworkType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.services.apm.api.IHttpService;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements fa.b, ia.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f4710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ea.d f4711c;
    public ea.b d;
    public volatile long e;
    public volatile long f;
    public volatile int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f4712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f4713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f4714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile JSONObject f4715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile IHttpService f4716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f4717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f4718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList f4719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f4720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f4721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f4722r;
    public volatile boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f4723t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinkedList f4724u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f4725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f4726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4727x;

    public e(String r5) {
        this.e = 0;
        this.f4719o = new LinkedList();
        this.f4722r = true;
        this.f4724u = new LinkedList();
        this.f4726w = r5;
        this.f4723t = false;
        this.f4725v = new b();
    }

    public static void i(e r5, JSONObject r10) {
        r5.getClass();
        if (r10.length() <= 0) goto L11;
        r5.r(r10.getJSONObject("ret"));     // Catch: Throwable -> L8
        SharedPreferences.Editor r11 = r5.n().edit();     // Catch: Throwable -> L8
        r11.putLong("monitor_configure_refresh_time", System.currentTimeMillis());     // Catch: Throwable -> L8
        r11.putInt("monitor_config_update", 1);     // Catch: Throwable -> L8
        r11.putString("monitor_net_config", r10.getJSONObject("ret").toString());     // Catch: Throwable -> L8
        r11.apply();     // Catch: Throwable -> L8
        if (r5.f4723t == true) goto L12;
        r5.f4723t = true;     // Catch: Throwable -> L8
        r5.f4725v.a(r5);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void k(StringBuilder r5, String r10, String r11) {
        if (r5.charAt(r5.length() - 1) == '?') goto L18;
        r5.append("&");
    L18:
        r5.append(URLEncoder.encode(r10, "UTF-8"));
        r5.append('=');
        r5.append(URLEncoder.encode(r11, "UTF-8"));
        return;
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L13:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // ia.b
    public final void a(long r5) {
        if (this.f > 0) goto L5;
        return;
    L5:
        s();
    }

    @Override // fa.b
    public final int b() {
        if (this.g > 0) goto L7;
        return 120;
    L7:
        return this.g;
    }

    @Override // fa.b
    public final boolean c() {
        if (this.f4721q == false) goto L6;
        return this.f4721q;
    L6:
        return this.f4720p;
    }

    @Override // fa.b
    public final JSONObject d() {
        return this.f4710b;
    }

    @Override // fa.b
    public final List e() {
        return this.f4724u;
    }

    @Override // fa.b
    public final int f() {
        if (this.f4713i > 0) goto L7;
        return 4;
    L7:
        return this.f4713i;
    }

    @Override // fa.b
    public final int g() {
        if (this.f4712h > 0) goto L7;
        return 100;
    L7:
        return this.f4712h;
    }

    @Override // fa.b
    public final int h() {
        if (this.f4714j > 0) goto L7;
        return 15;
    L7:
        return this.f4714j;
    }

    public final StringBuilder j(String r5) {
        StringBuilder r10 = new StringBuilder(r5);
        if (TextUtils.isDigitsOnly(r5) == false) goto L5;
    L20:
        return r10;
    L5:
        if (this.f4718n == null) goto L20;
        if (r5.contains("?") == true) goto L10;
        r10.append("?");
    L10:
        k(r10, WsConstants.KEY_SDK_VERSION, String.valueOf(400));
        Map r11 = this.f4718n;
        if (r11 == null) goto L20;
        if (r11.size() <= 0) goto L20;
        Iterator r12 = r11.entrySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r13.getKey() == null) goto L16;
        k(r10, String.valueOf(r13.getKey()), String.valueOf(r13.getValue()));
        goto L16
    }

    public final IHttpService l() {
        if (this.f4716l != null) goto L6;
        this.f4716l = (IHttpService) og.a.a(IHttpService.class);
    L6:
        return this.f4716l;
    }

    public final int m() {
        Context r5 = this.f4709a;
        int r10 = com.bytedance.framwork.core.sdklib.util.a.f4699a;
        NetworkInfo r11 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L20
        if (r11 != null) goto L6;
    L18:
        NetUtils$NetworkType r12 = NetUtils$NetworkType.NONE;     // Catch: Throwable -> L20
    L23:
    L22:
        return r12.getValue();
    L6:
        if (r11.isAvailable() == false) goto L18;
        int r13 = r11.getType();     // Catch: Throwable -> L20
        if (1 != r13) goto L11;
        r12 = NetUtils$NetworkType.WIFI;     // Catch: Throwable -> L20
        goto L23
    L11:
        if (r13 == 0) goto L13;
        r12 = NetUtils$NetworkType.MOBILE;     // Catch: Throwable -> L20
        goto L23
    L13:
        switch(((TelephonyManager) r5.getSystemService("phone")).getNetworkType()) {
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L16;
            case 15: goto L16;
            default: goto L14;
        };     // Catch: Throwable -> L20
    L14:
        r12 = NetUtils$NetworkType.MOBILE;     // Catch: Throwable -> L20
        goto L23
    L15:
        r12 = NetUtils$NetworkType.MOBILE_4G;     // Catch: Throwable -> L20
        goto L23
    L16:
        r12 = NetUtils$NetworkType.MOBILE_3G;     // Catch: Throwable -> L20
    L20:
        r12 = NetUtils$NetworkType.MOBILE;
        goto L22
    }

    public final SharedPreferences n() {
        String r5 = f4.a.i(this.f4709a);
        return this.f4709a.getSharedPreferences("monitor_config" + this.f4726w + r5, 0);
    }

    public final void o() {
        SharedPreferences r5 = n();
        String r10 = r5.getString("monitor_net_config", null);
        this.e = r5.getLong("monitor_configure_refresh_time", 0);
        boolean r11 = false;
        if (r5.getInt("monitor_config_update", 0) != 1) goto L5;
        r11 = true;
    L5:
        ia.a.f17554a.t(this);
        if (TextUtils.isEmpty(r10) == false) goto L15;
    L13:
        s();
        return;
    L15:
        this.f4723t = true;     // Catch: Exception -> L12
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L12
        if (r11 == true) goto L10;
        r12.remove("report_host_new");     // Catch: Exception -> L12
    L10:
        r(r12);     // Catch: Exception -> L12
    L12:
        Log.e("monitor_config", "config error");
        goto L13
    }

    public final void p(String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        if (this.f4723t == true) goto L16;
        b r10 = this.f4725v;     // Catch: Throwable -> L18
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L18
        g r15 = new g();     // Catch: Throwable -> L18
        r15.f4731a = r11;     // Catch: Throwable -> L18
        r15.f4732b = r12;     // Catch: Throwable -> L18
        r15.f4733c = r13;     // Catch: Throwable -> L18
        r15.d = r14;     // Catch: Throwable -> L18
        r15.e = r5;     // Catch: Throwable -> L18
        LinkedList r16 = r10.f4703a;     // Catch: Throwable -> L18
        monitor-enter(r16);     // Catch: Throwable -> L18
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L7:
        if (r10.f4703a.size() <= r10.d) goto L11;
        r10.f4703a.poll();     // Catch: Throwable -> L9
    L11:
        r10.f4703a.add(r15);     // Catch: Throwable -> L9
        monitor-exit(r16);     // Catch: Throwable -> L9
        goto L23
    L22:
        return;
    L16:
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L18
        ia.a.f17554a.w(new c(this, r11, r12, r13, r14, r17));     // Catch: Throwable -> L18
        return;
    }

    public final void q(String r5, JSONObject r10, JSONObject r11, JSONObject r12, long r13) {
        if (r12 == null) goto L35;
    L5:
        r12.put("log_type", "service_monitor");     // Catch: Throwable -> L34
        r12.put(NotificationCompat.CATEGORY_SERVICE, r5);     // Catch: Throwable -> L34
        r12.put(NotificationCompat.CATEGORY_STATUS, 0);     // Catch: Throwable -> L34
        r12.put("network_type", m());     // Catch: Throwable -> L34
        String r14 = null;
        r12.put("value", null);     // Catch: Throwable -> L34
        if (r10 == null) goto L8;
        r12.put("category", r10);     // Catch: Throwable -> L34
    L8:
        if (r11 == null) goto L11;
        r12.put(LynxMonitorService.KEY_METRIC, r11);     // Catch: Throwable -> L34
    L11:
        if (r12.isNull("timestamp") == false) goto L13;
        r12.put("timestamp", r13);     // Catch: Throwable -> L34
    L13:
        d r15 = this.f4717m;     // Catch: Throwable -> L34
        if (r15 == null) goto L16;
        String r16 = r15.getSessionId();     // Catch: Throwable -> L34
    L18:
        if (TextUtils.isEmpty(r16) == true) goto L24;
        d r17 = this.f4717m;     // Catch: Throwable -> L34
        if (r17 == null) goto L22;
        r14 = r17.getSessionId();     // Catch: Throwable -> L34
    L22:
        r12.put("session_id", r14);     // Catch: Throwable -> L34
    L24:
        if (this.f4711c != null) goto L26;
        return;
    L26:
        if (this.f4715k != null) goto L28;
        return;
    L28:
        if (TextUtils.isEmpty(r5) == false) goto L31;
        return;
    L31:
        if (this.f4715k.opt(r5) == null) goto L40;
        this.f4711c.b("service_monitor", "service_monitor", r12);     // Catch: Throwable -> L34
        return;
    L41:
        return;
    L40:
        return;
    L16:
        r16 = null;
        goto L18
    L35:
        r12 = new JSONObject();     // Catch: Throwable -> L34
        goto L5
    }

    public final synchronized void r(JSONObject r13) {
        monitor-enter(this);
        if (r13 != null) goto L85;
        monitor-exit(this);
        return;
    L85:
        JSONObject r5 = r13.optJSONObject("general");     // Catch: Throwable -> L15
        JSONObject r10 = null;
        if (r5 != null) goto L9;
        JSONObject r11 = null;
    L11:
        if (r11 == null) goto L63;
        JSONObject r12 = r11.optJSONObject("fetch_setting");     // Catch: Throwable -> L15
        if (r12 == null) goto L18;
        this.f = r12.optLong("fetch_setting_interval", 1200);     // Catch: Throwable -> L15
    L18:
        if (this.f >= 600) goto L22;
        this.f = 600;     // Catch: Throwable -> L15
    L22:
        if (((System.currentTimeMillis() - this.e) / 1000) <= this.f) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L28;
        monitor-exit(this);
        return;
    L28:
        JSONObject r15 = r11.optJSONObject("report_setting");     // Catch: Throwable -> L15
        if (r15 == null) goto L63;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L15
        JSONArray r17 = r15.optJSONArray("hosts");     // Catch: Throwable -> L15 Exception -> L84
        if (r17 == null) goto L51;
        if (r17.length() <= 0) goto L51;
        int r18 = r17.length();     // Catch: Throwable -> L15 Exception -> L84
        int r19 = 0;
    L36:
        if (r19 >= r18) goto L51;
        String r110 = r17.getString(r19);     // Catch: Throwable -> L15 Exception -> L84
        if (this.f4727x == false) goto L45;
        if (r110.contains(".snssdk.") == true) goto L43;
        if (r110.contains(".toutiao.") == false) goto L45;
    L43:
        r16.clear();     // Catch: Throwable -> L15 Exception -> L84
    L45:
        if (TextUtils.isEmpty(r110) == true) goto L49;
        if (r110.indexOf(46) <= 0) goto L49;
        r16.add(r110);     // Catch: Throwable -> L15 Exception -> L84
    L49:
        r19 = r19 + 1;
    L51:
        if (r16.isEmpty() == true) goto L53;
        this.f4724u = f.a(r16);     // Catch: Throwable -> L15
    L53:
        this.g = r15.optInt("uploading_interval", 120);     // Catch: Throwable -> L15
        if (this.g >= 0) goto L56;
        int r20 = 120;
    L57:
        this.g = r20;     // Catch: Throwable -> L15
        this.f4712h = r15.optInt("once_max_count", 100);     // Catch: Throwable -> L15
        if (this.f4712h >= 0) goto L60;
        int r21 = 100;
    L61:
        this.f4712h = r21;     // Catch: Throwable -> L15
        this.f4713i = r15.optInt("max_retry_count", 4);     // Catch: Throwable -> L15
        this.f4714j = r15.optInt("report_fail_base_interval", 15);     // Catch: Throwable -> L15
        r15.optInt("log_send_switch", 1);     // Catch: Throwable -> L15
        r15.optLong("more_channel_stop_interval", 1800);     // Catch: Throwable -> L15
        this.f4722r = r15.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L15
        r15.optLong("memory_store_cache_max_count", 2000);     // Catch: Throwable -> L15
        this.f4720p = r15.optBoolean("log_remove_switch", false);     // Catch: Throwable -> L15
        goto L63
    L60:
        r21 = this.f4712h;     // Catch: Throwable -> L15
        goto L61
    L56:
        r20 = this.g;     // Catch: Throwable -> L15
        goto L57
    L24:
        r14 = false;
    L63:
        if (r13.length() > 0) goto L67;
        this.f4724u = null;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L67:
        JSONObject r22 = r13.optJSONObject("custom_event_settings");     // Catch: Throwable -> L15
        if (r22 == null) goto L70;
        this.f4715k = r22.optJSONObject("allow_service_name");     // Catch: Throwable -> L15
        r22.optJSONObject("allow_log_type");     // Catch: Throwable -> L15
    L70:
        JSONObject r111 = r13.optJSONObject("network_image_modules");     // Catch: Throwable -> L15
        if (r111 == null) goto L74;
        r10 = r111.optJSONObject("network");     // Catch: Throwable -> L15
    L74:
        if (r10 == null) goto L77;
        r10.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L15
        r10.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L15
        dn.a.S("api_block_list", r10);     // Catch: Throwable -> L15
        dn.a.T("api_block_list", r10);     // Catch: Throwable -> L15
        dn.a.S("api_allow_list", r10);     // Catch: Throwable -> L15
        dn.a.T("api_allow_list", r10);     // Catch: Throwable -> L15
    L77:
        if (this.d != null) goto L79;
        Context r23 = this.f4709a;     // Catch: Throwable -> L15
        String r24 = this.f4726w;     // Catch: Throwable -> L15
        ea.b r112 = new ea.b();     // Catch: Throwable -> L15
        r112.f16797a = 0;     // Catch: Throwable -> L15
        r112.f16798b = 120;     // Catch: Throwable -> L15
        r112.f16799c = 100;     // Catch: Throwable -> L15
        r112.f16800h = true;     // Catch: Throwable -> L15
        r112.f16801i = false;     // Catch: Throwable -> L15
        r112.f = r23;     // Catch: Throwable -> L15
        r112.d = ea.c.b(r23);     // Catch: Throwable -> L15
        r112.e = r24;     // Catch: Throwable -> L15
        this.d = r112;     // Catch: Throwable -> L15
        r112.c();     // Catch: Throwable -> L15
    L79:
        this.d.d();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L9:
        r11 = r5.optJSONObject("slardar_api_settings");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final void s() {
        if (this.f >= 600) goto L6;
        this.f = 600;
    L6:
        if (((System.currentTimeMillis() - this.e) / 1000) > this.f) goto L8;
        return;
    L8:
        if (f4.b.l(this.f4709a) == true) goto L10;
        return;
    L10:
        monitor-enter(e.class);
        this.e = System.currentTimeMillis();     // Catch: Throwable -> L15
        monitor-exit(e.class);     // Catch: Throwable -> L15
        ia.a.f17554a.w(new a6.a(this, 15));     // Catch: Throwable -> L19
        return;
    L26:
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
