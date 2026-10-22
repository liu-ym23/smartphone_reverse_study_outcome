package g1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.applog.n;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import f1.e;
import f1.k;
import f1.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import o1.j;
import o1.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List<String> f8913o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f8915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedPreferences f8916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f8917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f8918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile JSONObject f8919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashSet<String> f8920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<String> f8921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile HashSet<String> f8922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f8923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile h1.a f8924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final n1.a f8925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.bytedance.applog.c f8926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a1.c f8927n;

    class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h1.a f8928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f8929b;

        a(b r10, h1.a r11) {
            this.f8929b = r10;
            this.f8928a = r11;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("appId", b.a(this.f8929b).getAppId());     // Catch: Throwable -> L5
            r10.put("config", this.f8928a.c());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    /* JADX INFO: renamed from: g1.b$b, reason: collision with other inner class name */
    class C0171b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8930a;

        C0171b(b r10) {
            this.f8930a = r10;
        }

        @Override // f1.e.b
        public Object a() {
            if (this.f8930a.j() > 0) goto L6;
            return null;
        L6:
            JSONObject r10 = new JSONObject();
            JSONObject r11 = new JSONObject();
            r10.put("appId", b.a(this.f8930a).getAppId());     // Catch: Throwable -> L25
            long r12 = b.b(this.f8930a).getLong("session_interval", 0);     // Catch: Throwable -> L25
            String r13 = k.D;     // Catch: Throwable -> L25
            String r14 = "--";
            if (r12 <= 0) goto L11;
            String r15 = r12 + "ms";     // Catch: Throwable -> L25
        L12:
            r11.put(r13, r15);     // Catch: Throwable -> L25
            long r16 = b.b(this.f8930a).getLong("batch_event_interval", 0);     // Catch: Throwable -> L25
            String r17 = k.E;     // Catch: Throwable -> L25
            if (r16 <= 0) goto L15;
            String r18 = r16 + "ms";     // Catch: Throwable -> L25
        L16:
            r11.put(r17, r18);     // Catch: Throwable -> L25
            long r19 = b.b(this.f8930a).getLong("abtest_fetch_interval", 0);     // Catch: Throwable -> L25
            String r20 = k.F;     // Catch: Throwable -> L25
            if (r19 <= 0) goto L19;
            String r21 = r19 + "ms";     // Catch: Throwable -> L25
        L20:
            r11.put(r20, r21);     // Catch: Throwable -> L25
            r11.put(k.G, b.b(this.f8930a).getBoolean("bav_log_collect", false));     // Catch: Throwable -> L25
            r11.put(k.H, b.b(this.f8930a).getBoolean("bav_ab_config", false));     // Catch: Throwable -> L25
            r11.put(k.I, b.b(this.f8930a).getString("real_time_events", "[]"));     // Catch: Throwable -> L25
            r11.put(k.f8807J, b.b(this.f8930a).getBoolean("forbid_report_phone_detail_info", false));     // Catch: Throwable -> L25
            long r22 = b.b(this.f8930a).getLong("fetch_interval", 0);     // Catch: Throwable -> L25
            String r23 = k.K;     // Catch: Throwable -> L25
            if (r22 <= 0) goto L23;
            r14 = r22 + "ms";     // Catch: Throwable -> L25
        L23:
            r11.put(r23, r14);     // Catch: Throwable -> L25
            r11.put(k.L, p.h(this.f8930a.m()));     // Catch: Throwable -> L25
            r11.put(k.M, b.b(this.f8930a).getString("log_back", ""));     // Catch: Throwable -> L25
            r11.put(k.N, this.f8930a.E());     // Catch: Throwable -> L25
            r11.put(k.O, this.f8930a.v());     // Catch: Throwable -> L25
            r11.put(k.P, this.f8930a.C());     // Catch: Throwable -> L25
            r10.put("config", r11);     // Catch: Throwable -> L25
            goto L24
        L19:
            r21 = "--";
            goto L20
        L15:
            r18 = "--";
            goto L16
        L11:
            r15 = "--";
        L24:
            return r10;
        }
    }

    static {
        f8913o = Collections.singletonList("ConfigManager");
    }

    public b(com.bytedance.applog.c r10, Context r11, n r12) {
        this.f8923j = 0;
        this.f8926m = r10;
        this.f8914a = r11;
        this.f8915b = r12;
        this.f8918e = r11.getSharedPreferences(r12.A(), 0);
        this.f8916c = r11.getSharedPreferences(com.bytedance.applog.b.b(r10, "header_custom"), 0);
        this.f8917d = r11.getSharedPreferences(com.bytedance.applog.b.b(r10, "last_sp_session"), 0);
        this.f8920g = new HashSet();
        this.f8921h = new HashSet();
        this.f8925l = new n1.a(r10, this, n());
        if (r10.e0() == false) goto L6;
        M(h1.c.b(r10, this), false);
        return;
    }

    private boolean G(long r10) {
        if (r10 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 300000) goto L7;
        return true;
    }

    static /* synthetic */ com.bytedance.applog.c a(b r10) {
        return r10.f8926m;
    }

    static /* synthetic */ SharedPreferences b(b r10) {
        return r10.f8918e;
    }

    private HashSet<String> w() {
        HashSet<String> r10 = this.f8922i;
        if (r10 == null) goto L15;
        return r10;
    L15:
        JSONArray r11 = new JSONArray(this.f8918e.getString("real_time_events", "[]"));     // Catch: Throwable -> L12
        int r12 = r11.length();     // Catch: Throwable -> L12
        HashSet<String> r13 = new HashSet();     // Catch: Throwable -> L12
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L21;
        String r15 = r11.getString(r14);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r15) == true) goto L10;
        r13.add(r15);     // Catch: Throwable -> L12
    L10:
        r14 = r14 + 1;
        goto L6
    L21:
        return r13;
    L12:
        th = move-exception;
        this.f8926m.P().u(f8913o, "get real time events failed", th, new Object[0]);
        return new HashSet();
    }

    String A() {
        return this.f8915b.B();
    }

    String B() {
        return this.f8916c.getString(Api.KEY_USER_UNIQUE_ID, null);
    }

    public boolean C() {
        return this.f8918e.getBoolean("ignore_event_priority", false);
    }

    public boolean D() {
        if (this.f8915b.w() != 0) goto L6;
        this.f8915b.e0(!p.i(this.f8914a).contains(":"));
    L6:
        if (this.f8915b.w() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean E() {
        if (v() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean F() {
        return this.f8915b.V();
    }

    public void H(@NonNull JSONObject r10) {
        this.f8925l.c(r10, n(), null);
        h1.c.e(r10, this.f8924k);
    }

    public void I(@NonNull JSONObject r10) {
        this.f8923j = r10.optLong("batch_event_interval", 0) * 1000;
        this.f8926m.P().o(f8913o, "parseCommonConfigFromResp mEventIntervalFromLogResp: " + this.f8923j, new Object[0]);
    }

    public void J() {
        m.d("remote_settings", new C0171b(this));
    }

    public void K(JSONObject r18) {
        boolean r10 = true;
        this.f8926m.P().o(f8913o, "setConfig: {}", new Object[]{r18});
        this.f8919f = r18;
        long r11 = System.currentTimeMillis();
        SharedPreferences.Editor r12 = this.f8918e.edit();
        long r13 = r18.optInt("session_interval", 0);
        if (r13 > 0) goto L5;
    L7:
        r12.remove("session_interval");
    L8:
        long r14 = ((long) r18.optInt("batch_event_interval", 60)) * 1000;
        if (G(r14) == false) goto L11;
        r12.putLong("batch_event_interval", r14);
    L12:
        int r15 = r18.optInt("send_launch_timely", 0);
        if (r15 > 0) goto L15;
    L17:
        r12.remove("send_launch_timely");
    L18:
        long r16 = r18.optInt("abtest_fetch_interval", 0);
        if (r16 > 20) goto L21;
    L23:
        r12.remove("abtest_fetch_interval");
    L25:
        if (r18.optBoolean("bav_ab_config", false) == false) goto L27;
        r12.putBoolean("bav_ab_config", true);
    L28:
        JSONArray r17 = r18.optJSONArray("real_time_events");
        if (r17 != null) goto L31;
    L33:
        r12.remove("real_time_events");
    L34:
        this.f8922i = null;
        int r19 = r18.optInt("http_monitor_port", 0);
        if (r19 <= 0) goto L37;
        r12.putInt("http_monitor_port", r19);
    L37:
        r12.putLong("app_log_last_config_time", r11);
        int r20 = r18.optInt("forbid_report_phone_detail_info", -1);
        if (r20 < 0) goto L43;
        if (r20 <= 0) goto L41;
        boolean r21 = true;
    L42:
        r12.putBoolean("forbid_report_phone_detail_info", r21);
        goto L43
    L41:
        r21 = false;
    L43:
        long r22 = r18.optLong("fetch_interval", 21600) * 1000;
        if (r22 >= 1800000) goto L46;
    L47:
        r22 = 21600000;
    L48:
        r12.putLong("fetch_interval", r22);
        r12.putInt("content_encode_method", r18.optInt("content_encode_method", 0));
        r12.putLong("max_pack_size", r18.optLong("max_pack_size", 0));
        JSONObject r23 = r18.optJSONObject("log_back");
        if (r23 == null) goto L52;
        R(r23);
    L52:
        if (r18.optInt("ignore_event_priority", 0) == 1) goto L55;
        r10 = false;
    L55:
        r12.putBoolean("ignore_event_priority", r10);
        r12.apply();
        J();
        return;
    L46:
        if (r22 <= 172800000) goto L48;
    L31:
        if (r17.length() <= 0) goto L33;
        r12.putString("real_time_events", r17.toString());
        goto L34
    L27:
        r12.remove("bav_ab_config");
        goto L28
    L21:
        if (r16 > GuardFile.DEFAULT_EXPIRE_TIME) goto L23;
        r12.putLong("abtest_fetch_interval", r16 * 1000);
        goto L25
    L15:
        if (r15 > GuardFile.DEFAULT_EXPIRE_TIME) goto L17;
        r12.putInt("send_launch_timely", r15);
        goto L18
    L11:
        r12.remove("batch_event_interval");
        goto L12
    L5:
        if (r13 > GuardFile.DEFAULT_EXPIRE_TIME) goto L7;
        r12.putLong("session_interval", r13 * 1000);
        goto L8
    }

    public void L(a1.c r10) {
        this.f8927n = r10;
    }

    public void M(h1.a r10, boolean r11) {
        if (C() == false) goto L5;
        return;
    L5:
        this.f8924k = r10;
        if (r11 == false) goto L10;
        a1.c r12 = this.f8927n;
        if (r12 == null) goto L10;
        r12.Y();
    L10:
        m.d("priority_config", new a(this, r10));
    }

    public void N(String r10, int r11) {
        this.f8917d.edit().putString("session_last_day", r10).putInt("session_order", r11).apply();
    }

    public void O(long r10) {
        this.f8917d.edit().putLong("latest_forground_session_time", r10).apply();
    }

    public void P(HashSet<String> r10, HashSet<String> r11) {
        if (r10 == null) goto L4;
        this.f8920g.addAll(r10);
    L4:
        if (r11 == null) goto L7;
        this.f8921h.addAll(r11);
        return;
    }

    public void Q(h1.b r10, int r11) {
        a1.c r12 = this.f8927n;
        if (r12 == null) goto L6;
        r12.X(r10, r11);
        return;
    }

    public void R(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r11 = u();
        if (r11 == null) goto L8;
        j.b(r10, r11);
        r10 = r11;
    L8:
        this.f8918e.edit().putString("log_back", r10.toString()).apply();
    }

    public boolean c() {
        return this.f8915b.a();
    }

    public boolean d(ArrayList<l1.a> r10) {
        if (r10 != null) goto L5;
    L30:
        return true;
    L5:
        if (r10.size() == 0) goto L30;
        if (this.f8920g.size() == 0) goto L10;
    L12:
        Iterator<l1.a> r11 = r10.iterator();
    L14:
        if (r11.hasNext() == false) goto L30;
        l1.a r12 = r11.next();
        if ((r12 instanceof l1.c) == true) goto L17;
        if ((r12 instanceof l1.e) == false) goto L14;
        l1.e r13 = (l1.e) r12;
        if (this.f8921h.contains(r13.F()) == false) goto L14;
        r11.remove();
        this.f8926m.R().h(MonitorKey.event_v3, MonitorState.f_filter);
        com.bytedance.applog.monitor.a r14 = this.f8926m.R();
        MonitorKey r15 = MonitorKey.filtered_event;
        String r16 = r13.F();
    L24:
        r14.m(r15, r16);
        goto L14
    L17:
        l1.c r17 = (l1.c) r12;
        StringBuilder r18 = new StringBuilder();
        r18.append(r17.A);
        if (TextUtils.isEmpty(r17.B) == true) goto L20;
        String r19 = r17.B;
    L21:
        r18.append(r19);
        r16 = r18.toString();
        if (this.f8920g.contains(r16) == false) goto L14;
        r11.remove();
        this.f8926m.R().h(MonitorKey.event, MonitorState.f_filter);
        r14 = this.f8926m.R();
        r15 = MonitorKey.filtered_event;
        goto L24
    L20:
        r19 = "";
        goto L21
    L10:
        if (this.f8921h.size() != 0) goto L12;
        return true;
    }

    public ArrayList<l1.a> e(List<l1.a> r10) {
        Iterator<l1.a> r11 = r10.iterator();
        ArrayList<l1.a> r12 = null;
    L4:
        if (r11.hasNext() == false) goto L15;
        l1.a r13 = r11.next();
        if ((r13 instanceof l1.e) == false) goto L4;
        l1.e r14 = (l1.e) r13;
        if (r14.p() == 0) goto L11;
        if (w().contains(r14.F()) == false) goto L4;
    L11:
        r11.remove();
        if (r12 != null) goto L14;
        r12 = new ArrayList();
    L14:
        r12.add(r13);
        goto L4
    L15:
        return r12;
    }

    String f() {
        return this.f8916c.getString("ab_sdk_version", "");
    }

    public String g() {
        String r10 = this.f8915b.j();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = A();
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L16;
        Bundle r11 = this.f8914a.getPackageManager().getApplicationInfo(this.f8914a.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r11.getString("UMENG_CHANNEL");
    L17:
        return r10;
    L11:
        th = move-exception;
        this.f8926m.P().u(f8913o, "getChannel failed", th, new Object[0]);
        return r10;
    L16:
        return r10;
    }

    public JSONObject h() {
        return this.f8919f;
    }

    public long i() {
        return this.f8918e.getLong("fetch_interval", 21600000);
    }

    public long j() {
        return this.f8918e.getLong("app_log_last_config_time", 0);
    }

    public Context k() {
        return this.f8914a;
    }

    public n1.a l() {
        return this.f8925l;
    }

    public int m() {
        return this.f8918e.getInt("content_encode_method", 0);
    }

    public long n() {
        if (G(this.f8923j) == false) goto L7;
        return this.f8923j;
    L7:
        return this.f8918e.getLong("batch_event_interval", VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
    }

    public h1.a o() {
        return this.f8924k;
    }

    public h1.b p(int r10) {
        h1.a r11 = this.f8924k;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.a(r10);
    }

    public n q() {
        return this.f8915b;
    }

    public String r() {
        return this.f8918e.getString("channel", "");
    }

    public String s() {
        return this.f8917d.getString("session_last_day", "");
    }

    public long t() {
        return this.f8917d.getLong("latest_forground_session_time", 0);
    }

    public JSONObject u() {
        String r10 = this.f8918e.getString("log_back", "");
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r10);
    L7:
        th = move-exception;
        this.f8926m.P().j("json parse to logback failed", th, new Object[0]);
        return null;
    }

    public long v() {
        return this.f8918e.getLong("max_pack_size", 0);
    }

    public long x() {
        return this.f8918e.getLong("session_interval", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    public int y() {
        return this.f8917d.getInt("session_order", 0);
    }

    public SharedPreferences z() {
        return this.f8918e;
    }
}
