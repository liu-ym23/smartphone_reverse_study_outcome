package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1684a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f1685b = 1024;
    public static volatile int c = 10;
    public static volatile boolean d = true;
    public static volatile boolean e = true;
    public static volatile long f = 300000;
    public static volatile long g = 30000;
    public static volatile int h = 7;
    public static volatile boolean i = false;
    public static volatile int j;
    public static volatile int k;
    public static volatile Map<String, Integer> l;
    private volatile boolean A;
    private SharedPreferences m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private Map<String, Integer> y;
    private JSONObject z;

    static {
    }

    public b() {
        this.n = f1684a;
        this.o = f1685b * 1024;
        this.p = c;
        this.q = d;
        this.r = e;
        this.s = f;
        this.t = g;
        this.u = h;
        this.v = i;
        this.w = j;
        this.x = k;
        this.y = l;
        this.z = null;
        this.A = false;
    }

    private void b(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.y.clear();
        Iterator<String> r0 = r5.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        int r2 = r5.optInt(r1, 0);
        if (r2 <= 0) goto L6;
        if (r2 > 10000) goto L6;
        this.y.put(r1, Integer.valueOf(r2));
        goto L6
    }

    private void n() {
        JSONObject r0 = this.z;
        if (r0 == null) goto L9;
        if (this.m == null) goto L9;
        a(r0);
        return;
    L9:
        if (this.m.contains("enabled") == true) goto L11;
        this.n = f1684a;
        this.o = f1685b * 1024;
        this.p = c;
        this.q = d;
        this.r = e;
        this.s = f;
        this.t = g;
        this.u = h;
        this.v = i;
        this.w = j;
        this.x = k;
        this.y = l;
    L15:
        if (this.A == false) goto L21;
        a(true);
        return;
    L21:
        return;
    L11:
        this.n = this.m.getBoolean("enabled", f1684a);
        this.o = this.m.getInt("max_request_body_size_kb", f1685b * 1024);
        this.p = this.m.getInt("max_request_count", c);
        this.q = this.m.getBoolean("error_report_enable", d);
        this.r = this.m.getBoolean("latency_report_enable", e);
        this.s = this.m.getLong("report_interval_ms", f);
        this.t = this.m.getLong("coldstart_report_delay_ms", g);
        this.u = this.m.getInt("data_keep_alive_days", h);
        this.v = this.m.getBoolean("sentry_enabled", i);
        this.w = this.m.getInt("sentry_coldstart_sampling_rate", j);
        this.x = this.m.getInt("network_coldstart_sampling_rate", k);
        String r1 = this.m.getString("sentry_events", null);
        if (TextUtils.isEmpty(r1) == true) goto L15;
        b(new JSONObject(r1));     // Catch: Throwable -> L18
        goto L15
    }

    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.m = r5.getSharedPreferences(r4 + "@applog_monitor_config", 0);
        n();
    }

    public void a(JSONObject r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SharedPreferences.Editor r0 = null;
        SharedPreferences r1 = this.m;
        if (r1 == null) goto L7;
        r0 = r1.edit();
    L8:
        boolean r3 = false;
        if (r8.optInt("enabled", f1684a ? 1 : 0) != 1) goto L11;
        boolean r2 = true;
    L12:
        this.n = r2;
        if (r0 == null) goto L16;
        r0.putBoolean("enabled", r2);
    L16:
        if (r8.has("max_request_body_size_kb") == false) goto L21;
        int r4 = r8.optInt("max_request_body_size_kb", f1685b) * 1024;
        this.o = r4;
        if (r0 == null) goto L21;
        r0.putInt("max_request_body_size_kb", r4);
    L21:
        if (r8.has("max_request_count") == false) goto L26;
        int r5 = r8.optInt("max_request_count", c);
        this.p = r5;
        if (r0 == null) goto L26;
        r0.putInt("max_request_count", r5);
    L26:
        if (r8.has("error_report_enable") == false) goto L35;
        if (r8.optInt("error_report_enable", d ? 1 : 0) != 1) goto L30;
        boolean r6 = true;
    L31:
        this.q = r6;
        if (r0 == null) goto L35;
        r0.putBoolean("error_report_enable", r6);
        goto L35
    L30:
        r6 = false;
    L35:
        if (r8.has("latency_report_enable") == false) goto L44;
        if (r8.optInt("latency_report_enable", e ? 1 : 0) != 1) goto L39;
        boolean r7 = true;
    L40:
        this.r = r7;
        if (r0 == null) goto L44;
        r0.putBoolean("latency_report_enable", r7);
        goto L44
    L39:
        r7 = false;
    L44:
        if (r8.has("report_interval_ms") == false) goto L49;
        long r9 = r8.optLong("report_interval_ms", f);
        this.s = r9;
        if (r0 == null) goto L49;
        r0.putLong("report_interval_ms", r9);
    L49:
        if (r8.has("coldstart_report_delay_ms") == false) goto L54;
        long r10 = r8.optLong("coldstart_report_delay_ms", g);
        this.t = r10;
        if (r0 == null) goto L54;
        r0.putLong("coldstart_report_delay_ms", r10);
    L54:
        if (r8.has("data_keep_alive_days") == false) goto L59;
        int r11 = r8.optInt("data_keep_alive_days", h);
        this.u = r11;
        if (r0 == null) goto L59;
        r0.putLong("data_keep_alive_days", r11);
    L59:
        if (r8.has("sentry_enabled") == false) goto L67;
        if (r8.optInt("sentry_enabled", i ? 1 : 0) != 1) goto L63;
        r3 = true;
    L63:
        this.v = r3;
        if (r0 == null) goto L67;
        r0.putBoolean("sentry_enabled", r3);
    L67:
        if (r8.has("sentry_coldstart_sampling_rate") == false) goto L72;
        int r12 = r8.optInt("sentry_coldstart_sampling_rate", j);
        this.w = r12;
        if (r0 == null) goto L72;
        r0.putInt("sentry_coldstart_sampling_rate", r12);
    L72:
        if (r8.has("network_coldstart_sampling_rate") == false) goto L77;
        int r13 = r8.optInt("network_coldstart_sampling_rate", k);
        this.x = r13;
        if (r0 == null) goto L77;
        r0.putInt("network_coldstart_sampling_rate", r13);
    L77:
        if (r8.has("sentry_events") == false) goto L81;
        JSONObject r14 = r8.optJSONObject("sentry_events");
        b(r14);
        if (r0 == null) goto L81;
        r0.putString("sentry_events", r14.toString());
    L81:
        if (r0 == null) goto L84;
        r0.apply();
    L84:
        if (this.A == false) goto L87;
        a(true);
        return;
    L87:
        return;
    L11:
        r2 = false;
        goto L12
    L7:
        this.z = r8;
        goto L8
    }

    public void a(boolean r1) {
        if (r1 == true) goto L5;
        this.A = false;
        return;
    L5:
        this.A = true;
        f1684a = true;
        i = true;
        j = 10000;
        k = 10000;
        l = null;
        this.n = f1684a;
        this.v = i;
        this.w = j;
        this.x = k;
        this.y = l;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.o;
    }

    public int c() {
        return this.p;
    }

    public boolean d() {
        return this.q;
    }

    public boolean e() {
        return this.r;
    }

    public long f() {
        return this.s;
    }

    public long g() {
        return this.t;
    }

    public int h() {
        return this.u;
    }

    public boolean i() {
        return this.v;
    }

    public int j() {
        return this.w;
    }

    public int k() {
        return this.x;
    }

    public boolean l() {
        return this.A;
    }

    public Map<String, Integer> m() {
        return this.y;
    }
}
