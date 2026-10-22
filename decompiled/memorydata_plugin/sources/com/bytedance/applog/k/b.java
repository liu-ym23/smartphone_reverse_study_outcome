package com.bytedance.applog.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.exception.ExceptionType;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.e;
import com.bytedance.applog.o;
import com.bytedance.applog.util.i;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.resource.utils.GuardFile;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1616b;
    private final o c;
    private final SharedPreferences d;
    private final SharedPreferences e;
    private final SharedPreferences f;
    private volatile String g;
    private volatile JSONObject h;
    private final HashSet<String> i;
    private final HashSet<String> j;
    private volatile HashSet<String> k;
    private long l;
    private volatile com.bytedance.applog.priority.a m;
    private final com.bytedance.applog.q.a n;
    private final com.bytedance.applog.b o;
    private volatile com.bytedance.applog.h.a p;
    private com.bytedance.applog.e.c q;
    private volatile String r;
    private volatile String s;
    private volatile boolean t;
    private final Map<String, List<String>> u;
    private List<String> v;

    static {
        f1615a = Collections.singletonList("ConfigManager");
    }

    public b(com.bytedance.applog.b r5, Context r6, o r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.l = 0;
        this.t = true;
        this.u = new ConcurrentHashMap();
        this.v = null;
        this.o = r5;
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.f1616b = r9;
        this.c = r7;
        this.f = r9.getSharedPreferences(r7.F(), 0);
        this.d = r9.getSharedPreferences(com.bytedance.applog.a.a(r5, "header_custom"), 0);
        this.e = r9.getSharedPreferences(com.bytedance.applog.a.a(r5, "last_sp_session"), 0);
        this.i = new HashSet();
        this.j = new HashSet();
        this.n = new com.bytedance.applog.q.a(r5, this, u());
        if (r5.K() == false) goto L6;
        a(com.bytedance.applog.priority.c.a(r5, this));
    L6:
        if (r5.aH() == false) goto L9;
        a(com.bytedance.applog.h.b.a(r5));
        return;
    }

    private HashSet<String> H() {
        if (this.k != null) goto L6;
        this.k = a(null);
    L6:
        return this.k;
    }

    static /* synthetic */ com.bytedance.applog.b a(b r0) {
        return r0.o;
    }

    private HashSet<String> a(JSONArray r5) {
        HashSet<String> r0 = new HashSet();
        if (r5 == null) goto L13;
    L5:
        int r4 = r5.length();     // Catch: Throwable -> L12
        int r1 = 0;
    L6:
        if (r1 >= r4) goto L11;
        String r2 = r5.getString(r1);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r0.add(r2);     // Catch: Throwable -> L12
    L10:
        r1 = r1 + 1;
    L11:
        return r0;
    L13:
        r5 = new JSONArray(this.f.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));     // Catch: Throwable -> L12
        goto L5
    }

    private void a(SharedPreferences.Editor r5, JSONArray r6) {
        SharedPreferences.Editor r7 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r5, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L20:
        this.v = null;
        if (r7 == null) goto L28;
        r7.remove("header_custom_allow");
        return;
    L28:
        return;
    L5:
        if (r6.length() == 0) goto L20;
        this.v = new ArrayList();
        int r1 = 0;
    L9:
        if (r1 >= r6.length()) goto L14;
        String r2 = r6.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        this.v.add(r2);
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        com.bytedance.applog.e.c r4 = this.q;
        if (r4 == null) goto L17;
        r4.h().h();
    L17:
        if (r7 == null) goto L27;
        r7.putString("header_custom_allow", r6.toString());
        return;
    }

    static /* synthetic */ com.bytedance.applog.h.a b(b r0) {
        return r0.p;
    }

    private void b(SharedPreferences.Editor r9, JSONObject r10) {
        SharedPreferences.Editor r11 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r9, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (this.u.isEmpty() == true) goto L5;
        this.u.clear();
    L5:
        if (r10 != null) goto L7;
    L30:
        if (r11 != null) goto L32;
        return;
    L32:
        if (this.u.isEmpty() == false) goto L34;
        r11.remove("params_block");
        return;
    L34:
        r11.putString("params_block", r10.toString());
        return;
    L7:
        if (r10.length() <= 0) goto L30;
        Iterator<String> r0 = r10.keys();
    L10:
        if (r0.hasNext() == false) goto L30;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONArray r3 = r10.optJSONArray(r2);
        if (r3 == null) goto L10;
        if (r3.length() == 0) goto L10;
        HashSet r4 = new HashSet();
        int r5 = 0;
    L21:
        if (r5 >= r3.length()) goto L27;
        String r6 = r3.optString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        r4.add(r6);
    L25:
        r5 = r5 + 1;
        goto L21
    L27:
        if (r4.isEmpty() == true) goto L10;
        this.u.put(r2, new ArrayList(r4));
        goto L10
    }

    private boolean b(long r3) {
        if (r3 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 300000) goto L7;
        return true;
    }

    static /* synthetic */ SharedPreferences c(b r0) {
        return r0.f;
    }

    public com.bytedance.applog.q.a A() {
        return this.n;
    }

    public long B() {
        return this.f.getLong("max_pack_size", 0);
    }

    public boolean C() {
        if (B() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public JSONObject D() {
        String r0 = this.f.getString("log_back", "");
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r0);
    L7:
        th = move-exception;
        this.o.aA().a("json parse to logback failed", th, new Object[0]);
        return null;
    }

    public boolean E() {
        return this.f.getBoolean("ignore_event_priority", false);
    }

    public com.bytedance.applog.h.a F() {
        return this.p;
    }

    public void G() {
        if (p.a() == false) goto L5;
        return;
    L5:
        p.a("remote_settings", new AnonymousClass3(this));
    }

    public com.bytedance.applog.priority.b a(int r1) {
        com.bytedance.applog.priority.a r0 = this.m;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1);
    }

    public ArrayList<com.bytedance.applog.n.a> a(List<com.bytedance.applog.n.a> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
        ArrayList<com.bytedance.applog.n.a> r0 = null;
    L4:
        if (r7.hasNext() == false) goto L15;
        com.bytedance.applog.n.a r2 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L4;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        if (r3.q() == 0) goto L11;
        if (H().contains(r3.u()) == false) goto L4;
    L11:
        r7.remove();
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r2);
        goto L4
    L15:
        return r0;
    }

    public void a() {
        if (this.o.aR() == false) goto L11;
        String r0 = this.f.getString("header_custom_allow", null);
        if (TextUtils.isEmpty(r0) == true) goto L11;
        a(null, new JSONArray(r0));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.o.ab().a("parse custom header control config failed", th);
    L11:
        if (this.o.aQ() == false) goto L23;
        String r1 = this.f.getString("params_block", null);
        if (TextUtils.isEmpty(r1) == true) goto L24;
        b(null, new JSONObject(r1));     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        this.o.ab().a("parse event params control config failed", th);
        return;
    L24:
        return;
    }

    public void a(long r2) {
        this.e.edit().putLong("latest_forground_session_time", r2).apply();
    }

    public void a(SharedPreferences.Editor r3, JSONObject r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        JSONObject r0 = D();
        if (r0 == null) goto L10;
        i.a(r4, r0);
        r4 = r0;
    L10:
        if (r5 == null) goto L12;
        r5.putString("log_back", r4.toString());
        return;
    L12:
        this.f.edit().putString("log_back", r4.toString()).apply();
    }

    public void a(com.bytedance.applog.e.c r1) {
        this.q = r1;
    }

    public void a(com.bytedance.applog.h.a r2) {
        if (r2 != null) goto L4;
    L6:
        this.p = r2;
        if (this.p == null) goto L12;
        com.bytedance.applog.e.c r3 = this.q;
        if (r3 == null) goto L12;
        r3.p();
    L12:
        if (this.p != null) goto L14;
        return;
    L14:
        if (p.a() == true) goto L18;
        p.a("forward_config", new AnonymousClass2(this));
        return;
    L18:
        return;
    L4:
        if (r2.equals(this.p) == false) goto L6;
    }

    public void a(final com.bytedance.applog.priority.a r2) {
        if (E() == false) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        this.m = r2;
        if (r0 == false) goto L17;
        com.bytedance.applog.e.c r1 = this.q;
        if (r1 == null) goto L17;
        r1.p();
    L17:
        if (p.a() == true) goto L21;
        if (r2 == null) goto L22;
        p.a("priority_config", new AnonymousClass1(this, r2));
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (r2.a(this.m) == true) goto L10;
        r0 = false;
        goto L11
    }

    public void a(com.bytedance.applog.priority.b r1, int r2) {
        com.bytedance.applog.e.c r0 = this.q;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(String r2, int r3) {
        this.e.edit().putString("session_last_day", r2).putInt("session_order", r3).apply();
    }

    public void a(HashSet<String> r2, HashSet<String> r3) {
        if (r2 == null) goto L4;
        this.i.addAll(r2);
    L4:
        if (r3 == null) goto L7;
        this.j.addAll(r3);
        return;
    }

    public void a(JSONObject r18) {
        boolean r4 = true;
        this.o.aA().b(f1615a, "setConfig: {}", new Object[]{r18});
        this.h = r18;
        long r2 = System.currentTimeMillis();
        SharedPreferences.Editor r5 = this.f.edit();
        long r8 = r18.optInt("session_interval", 0);
        if (r8 > 0) goto L5;
    L7:
        r5.remove("session_interval");
    L8:
        long r10 = ((long) r18.optInt("batch_event_interval", 60)) * 1000;
        if (b(r10) == false) goto L11;
        r5.putLong("batch_event_interval", r10);
    L12:
        int r9 = r18.optInt("send_launch_timely", 0);
        if (r9 > 0) goto L15;
    L17:
        r5.remove("send_launch_timely");
    L18:
        long r11 = r18.optInt("abtest_fetch_interval", 0);
        if (r11 > 20) goto L21;
    L23:
        r5.remove("abtest_fetch_interval");
    L25:
        if (r18.optBoolean("bav_ab_config", false) == false) goto L27;
        r5.putBoolean("bav_ab_config", true);
    L28:
        JSONArray r12 = r18.optJSONArray("real_time_events");
        if (r12 != null) goto L31;
    L33:
        this.k = new HashSet();
        r5.remove("real_time_events");
    L34:
        int r13 = r18.optInt("http_monitor_port", 0);
        if (r13 <= 0) goto L37;
        r5.putInt("http_monitor_port", r13);
    L37:
        r5.putLong("app_log_last_config_time", r2);
        int r3 = r18.optInt("forbid_report_phone_detail_info", -1);
        if (r3 < 0) goto L43;
        if (r3 <= 0) goto L41;
        boolean r6 = true;
    L42:
        r5.putBoolean("forbid_report_phone_detail_info", r6);
        goto L43
    L41:
        r6 = false;
    L43:
        long r7 = r18.optLong("fetch_interval", 21600) * 1000;
        if (r7 >= 1800000) goto L46;
    L47:
        r7 = 21600000;
    L48:
        r5.putLong("fetch_interval", r7);
        r5.putInt("content_encode_method", r18.optInt("content_encode_method", 0));
        r5.putLong("max_pack_size", r18.optLong("max_pack_size", 0));
        JSONObject r14 = r18.optJSONObject("log_back");
        if (r14 == null) goto L52;
        a(r5, r14);
    L52:
        if (r18.optInt("ignore_event_priority", 0) == 1) goto L55;
        r4 = false;
    L55:
        r5.putBoolean("ignore_event_priority", r4);
        if (this.o.aQ() == false) goto L59;
        b(r5, r18.optJSONObject("params_block"));
    L59:
        if (this.o.aR() == false) goto L61;
        a(r5, r18.optJSONArray("header_custom_allow"));
    L61:
        r5.apply();
        if (r18.has("monitor_config") == false) goto L64;
        this.o.ab().a().a(r18.optJSONObject("monitor_config"));
    L64:
        G();
        return;
    L46:
        if (r7 <= 172800000) goto L48;
    L31:
        if (r12.length() <= 0) goto L33;
        this.k = a(r12);
        r5.putString("real_time_events", r12.toString());
        goto L34
    L27:
        r5.remove("bav_ab_config");
        goto L28
    L21:
        if (r11 > GuardFile.DEFAULT_EXPIRE_TIME) goto L23;
        r5.putLong("abtest_fetch_interval", r11 * 1000);
        goto L25
    L15:
        if (r9 > GuardFile.DEFAULT_EXPIRE_TIME) goto L17;
        r5.putInt("send_launch_timely", r9);
        goto L18
    L11:
        r5.remove("batch_event_interval");
        goto L12
    L5:
        if (r8 > GuardFile.DEFAULT_EXPIRE_TIME) goto L7;
        r5.putLong("session_interval", r8 * 1000);
        goto L8
    }

    public void a(boolean r1) {
        this.t = r1;
    }

    public boolean a(String r3) {
        if (this.o.aR() == true) goto L5;
        return true;
    L5:
        List<String> r0 = this.v;
        if (r0 != null) goto L8;
        return true;
    L8:
        if (r0.isEmpty() == false) goto L10;
        return true;
    L10:
        if (this.v.contains(r3) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public boolean a(String r3, String r4) {
        if (this.o.aQ() == true) goto L6;
        return true;
    L6:
        if (this.u.containsKey(r3) == true) goto L8;
        return true;
    L8:
        List r2 = (List) ZeusTransformUtils.preCheckCast(this.u.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
    L15:
        return true;
    L11:
        if (r2.isEmpty() == true) goto L15;
        return !r2.contains(r4);
    }

    public boolean a(ArrayList<com.bytedance.applog.n.a> r6) {
        if (r6 != null) goto L5;
    L30:
        return true;
    L5:
        if (r6.size() == 0) goto L30;
        if (this.i.size() == 0) goto L10;
    L12:
        Iterator<com.bytedance.applog.n.a> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L30;
        com.bytedance.applog.n.a r1 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.c.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L14;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.memorydata.plugin");
        if (this.j.contains(r2.u()) == false) goto L14;
        com.bytedance.applog.monitor.b.a(this.o.ab(), EventStage.FILTER_SERVER_BLOCKED, r1);
        r7.remove();
    L24:
        this.o.ab().a(StatsCountKeys.APPLOG_BLOCK_EVENT_COUNT);
        this.o.ab().a(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
        com.bytedance.applog.monitor.exception.b.a().a(ExceptionType.InterruptionBlockList, r1.o());
        goto L14
    L17:
        com.bytedance.applog.n.c r3 = (com.bytedance.applog.n.c) ZeusTransformUtils.preCheckCast(r1, com.bytedance.applog.n.c.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append(r3.w);
        if (TextUtils.isEmpty(r3.x) == true) goto L20;
        String r5 = r3.x;
    L21:
        String r8 = r4.append(r5).toString();
        if (this.i.contains(r8) == false) goto L14;
        r7.remove();
        com.bytedance.applog.monitor.b.a(this.o.ab(), EventStage.FILTER_SERVER_BLOCKED, r1);
        goto L24
    L20:
        r5 = "";
        goto L21
    L10:
        if (this.j.size() != 0) goto L12;
        return true;
    }

    public void b(JSONObject r5) {
        this.l = r5.optLong("batch_event_interval", 0) * 1000;
        this.o.aA().b(f1615a, "parseCommonConfigFromResp mEventIntervalFromLogResp: {}", new Object[]{Long.valueOf(this.l)});
    }

    public boolean b() {
        return this.c.b();
    }

    public boolean b(String r2) {
        if (this.o.aQ() == true) goto L7;
        return true;
    L7:
        return this.u.containsKey(r2);
    }

    public o c() {
        return this.c;
    }

    void c(String r2) {
        this.r = r2;
        this.d.edit().putString("ab_sdk_version", r2).apply();
    }

    public void c(JSONObject r5) {
        this.n.a(r5, u(), null);
        com.bytedance.applog.priority.c.a(r5, this.m);
    }

    public String d() {
        return this.e.getString("session_last_day", "");
    }

    void d(String r1) {
        this.s = r1;
    }

    public int e() {
        return this.e.getInt("session_order", 0);
    }

    void e(String r5) {
        this.o.aA().b(f1615a, "setExternalAbVersion: {}", new Object[]{r5});
        this.d.edit().putString("external_ab_version", r5).apply();
        this.g = null;
    }

    public SharedPreferences f() {
        return this.f;
    }

    public boolean g() {
        return this.c.e();
    }

    public Context getContext() {
        return this.f1616b;
    }

    public JSONObject h() {
        return this.h;
    }

    public boolean i() {
        return this.t;
    }

    public long j() {
        return this.f.getLong("app_log_last_config_time", 0);
    }

    public int k() {
        return this.f.getInt("content_encode_method", 0);
    }

    public String l() {
        return this.c.f();
    }

    public String m() {
        String r0 = this.c.g();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = w();
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        Bundle r1 = this.f1616b.getPackageManager().getApplicationInfo(this.f1616b.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r1.getString("UMENG_CHANNEL");
    L17:
        return r0;
    L11:
        th = move-exception;
        this.o.aA().a(f1615a, "getChannel failed", th, new Object[0]);
        return r0;
    L16:
        return r0;
    }

    public String n() {
        return this.f.getString("channel", "");
    }

    String o() {
        if (this.r != null) goto L6;
        this.r = this.d.getString("ab_sdk_version", "");
    L6:
        return this.r;
    }

    String p() {
        if (this.s != null) goto L6;
        this.s = this.d.getString(Api.KEY_USER_UNIQUE_ID, "");
    L6:
        return this.s;
    }

    public boolean q() {
        if (this.c.j() != 0) goto L6;
        this.c.b(!com.bytedance.applog.util.o.a(this.f1616b).contains(ParameterizedMessage.ERROR_MSG_SEPARATOR));
    L6:
        if (this.c.j() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    String r() {
        String r0 = this.g;
        if (TextUtils.isEmpty(r0) == false) goto L11;
        monitor-enter(this);
        r0 = this.d.getString("external_ab_version", "");     // Catch: Throwable -> L8
        this.g = r0;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        return r0;
    }

    public int s() {
        return this.f.getInt("http_monitor_port", 0);
    }

    public long t() {
        return this.f.getLong("session_interval", 30000);
    }

    public long u() {
        if (b(this.l) == false) goto L7;
        return this.l;
    L7:
        return this.f.getLong("batch_event_interval", 60000);
    }

    public String v() {
        return this.c.s();
    }

    String w() {
        return this.c.t();
    }

    public long x() {
        return this.f.getLong("fetch_interval", 21600000);
    }

    public long y() {
        return this.e.getLong("latest_forground_session_time", 0);
    }

    public com.bytedance.applog.priority.a z() {
        return this.m;
    }
}
