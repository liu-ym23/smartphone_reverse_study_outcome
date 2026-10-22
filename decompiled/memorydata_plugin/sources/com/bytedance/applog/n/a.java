package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    private static final SimpleDateFormat w = null;
    private static final com.bytedance.applog.log.b<HashMap<String, a>> x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f1724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1725b;
    public long c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    protected String m;
    String n;
    int o;

    @Deprecated
    int p;
    public long q;
    public long r;
    public int s;
    protected List<String> t;
    protected com.bytedance.applog.collector.d.a u;
    private JSONObject v;

    static {
        w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        x = new AnonymousClass1();
    }

    public a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        a(0);
        a();
        this.t = Collections.singletonList(h());
    }

    private static void a(HashMap<String, a> r1, a r2) {
        r1.put(r2.h(), r2);
    }

    public static a b(String r7) {
        JSONObject r4 = new JSONObject(r7);     // Catch: Throwable -> L9
        a r8 = (a) ZeusTransformUtils.preCheckCast(((HashMap) ZeusTransformUtils.preCheckCast(x.c(new Object[0]), HashMap.class, "com.obric.memorydata.plugin")).get(r4.optString("k_cls", "")), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r8 != null) goto L8;
        q.a().d(4, "from ipc class not recognized", new Object[0]);     // Catch: Throwable -> L9
        return null;
    L8:
        return r8.n().b(r4);
    L9:
        th = move-exception;
        q.a().a(4, "from ipc failed", th, new Object[0]);
        return null;
    }

    public static String b(long r2) {
        return w.format(new Date(r2));
    }

    public static HashMap<String, a> c() {
        HashMap<String, a> r0 = new HashMap();
        a(r0, new i());
        a(r0, new g());
        a(r0, new j());
        a(r0, new h());
        a[] r1 = d();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r0, r1[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public static a[] d() {
        return new a[]{new c(), new e(null, null, false, null), new d(null, "", new JSONObject())};
    }

    public int a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        this.f1724a = r5.getLong(0);
        this.f1725b = r5.getLong(1);
        this.c = r5.getLong(2);
        this.i = r5.getInt(3);
        this.e = r5.getLong(4);
        this.f = r5.getLong(5);
        this.d = r5.getString(6);
        this.g = r5.getString(7);
        this.h = r5.getString(8);
        this.j = r5.getInt(9);
        this.k = r5.getInt(10);
        this.l = r5.getInt(11);
        this.m = r5.getString(12);
        this.o = r5.getInt(13);
        this.p = r5.getInt(14);
        String r0 = r5.getString(15);
        if (o.a(r0) == true) goto L8;
    L5:
        this.r = r5.getLong(16);
        this.s = r5.getInt(17);
        return 18;
    L8:
        this.q = Long.parseLong(r0);     // Catch: Throwable -> L7
        goto L5
    }

    public void a() {
        long r0 = com.bytedance.applog.monitor.v3.f.a();
        this.q = r0;
        this.r = r0;
    }

    public void a(int r1) {
        this.o = r1;
    }

    public void a(long r3) {
        if (r3 != 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this.f1725b = r3;
    }

    public void a(ContentValues r3) {
        r3.put("local_time_ms", Long.valueOf(this.f1725b));
        r3.put("tea_event_index", Long.valueOf(this.c));
        r3.put("nt", Integer.valueOf(this.i));
        r3.put(Header.KEY_USER_ID, Long.valueOf(this.e));
        r3.put("uid", Long.valueOf(this.f));
        r3.put("session_id", this.d);
        r3.put(Api.KEY_USER_UNIQUE_ID, this.g);
        r3.put("ab_sdk_version", this.h);
        r3.put("user_type", Integer.valueOf(this.j));
        r3.put("user_is_login", Integer.valueOf(this.k));
        r3.put("user_is_auth", Integer.valueOf(this.l));
        r3.put("_app_id", this.m);
        r3.put("priority", Integer.valueOf(this.o));
        r3.put("forward", Integer.valueOf(this.p));
        r3.put("_local_event_id", String.valueOf(this.q));
        r3.put("monitor_id", Long.valueOf(this.r));
        r3.put("event_stained", Integer.valueOf(this.s));
    }

    public void a(com.bytedance.applog.collector.d.a r1) {
        this.u = r1;
    }

    public void a(String r1) {
        this.m = r1;
    }

    public void a(JSONObject r4) {
        r4.put("local_time_ms", this.f1725b);
        r4.put("_app_id", this.m);
        r4.put("priority", this.o);
        r4.put("forward", this.p);
        r4.put("_local_event_id", this.q);
        r4.put("monitor_id", this.r);
    }

    final ContentValues b(ContentValues r1) {
        if (r1 != null) goto L4;
        r1 = new ContentValues();
    L5:
        a(r1);
        return r1;
    L4:
        r1.clear();
        goto L5
    }

    public a b(JSONObject r6) {
        this.f1725b = r6.optLong("local_time_ms", 0);
        this.f1724a = 0;
        this.c = 0;
        this.i = 0;
        this.e = 0;
        this.f = 0;
        this.d = null;
        this.g = null;
        this.h = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = r6.optString("_app_id");
        this.o = r6.optInt("priority", -1);
        this.p = r6.optInt("forward");
        this.q = r6.optLong("_local_event_id", 0);
        this.r = r6.optLong("monitor_id", 0);
        return this;
    }

    public String b() {
        return this.m;
    }

    public final void c(JSONObject r7) {
        com.bytedance.applog.b r0 = com.bytedance.applog.a.b(this.m);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        r7.put(Header.KEY_USER_ID, this.e);
    L13:
        if (r1 == false) goto L15;
    L16:
        r7.put("uid", this.f);
    L17:
        if (r1 == false) goto L19;
    L20:
        r7.put("user_type", this.j);
    L21:
        if (r1 == false) goto L23;
    L24:
        r7.put("user_is_login", this.k);
    L25:
        if (r1 == false) goto L27;
    L28:
        r7.put("user_is_auth", this.l);
        return;
    L27:
        if (this.l > 0) goto L28;
        return;
    L23:
        if (this.k <= 0) goto L25;
    L19:
        if (this.j <= 0) goto L21;
    L15:
        if (this.f <= 0) goto L17;
    L11:
        if (this.e <= 0) goto L13;
    L5:
        if (r0.F() == false) goto L7;
        r1 = true;
        goto L9
    }

    public /* synthetic */ Object clone() {
        return n();
    }

    public List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, Header.KEY_USER_ID, TypedValues.Custom.S_INT, "uid", TypedValues.Custom.S_INT, "session_id", "varchar", Api.KEY_USER_UNIQUE_ID, "varchar", "ab_sdk_version", "varchar", "user_type", TypedValues.Custom.S_INT, "user_is_login", TypedValues.Custom.S_INT, "user_is_auth", TypedValues.Custom.S_INT, "_app_id", "varchar", "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT, "_local_event_id", "varchar", "monitor_id", TypedValues.Custom.S_INT, "event_stained", TypedValues.Custom.S_INT});
    }

    public abstract JSONObject f();

    final String g() {
        List<String> r0 = e();
        if (r0 == null) goto L9;
        StringBuilder r1 = new StringBuilder(128);
        r1.append("create table if not exists ").append(h()).append("(");
        int r6 = 0;
    L6:
        if (r6 >= r0.size()) goto L8;
        r1.append((String) ZeusTransformUtils.preCheckCast(r0.get(r6), String.class, "com.obric.memorydata.plugin")).append(" ").append((String) ZeusTransformUtils.preCheckCast(r0.get(r6 + 1), String.class, "com.obric.memorydata.plugin")).append(",");
        r6 = r6 + 2;
        goto L6
    L8:
        r1.delete(r1.length() - 1, r1.length());
        r1.append(")");
        return r1.toString();
    L9:
        return null;
    }

    abstract String h();

    public abstract String i();

    public long j() {
        String r0 = o();
        long r2 = 0;
        if (o.a(r0) == false) goto L5;
        r2 = 0 + ((long) r0.length());
    L5:
        String r4 = p();
        if (o.a(r4) == true) goto L8;
        return r2;
    L8:
        return r2 + ((long) r4.length());
    }

    public final JSONObject k() {
        JSONObject r0 = new JSONObject();
        r0.put("k_cls", h());     // Catch: Throwable -> L5
        a(r0);     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        s().a(4, this.t, "toIpcJson failed", th, new Object[0]);
        goto L7
    }

    public final JSONObject l() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.v != null) goto L6;
        this.v = m();     // Catch: Throwable -> L9
    L6:
        JSONObject r0 = this.v;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    }

    public final JSONObject m() {
        JSONObject r0 = new JSONObject();
        this.n = b(this.f1725b);     // Catch: Throwable -> L5
        return f();
    L5:
        th = move-exception;
        com.bytedance.applog.b r1 = com.bytedance.applog.a.b(this.m);
        if (r1 == null) goto L12;
        r1.ab().a(StatsCountKeys.PACK_ERROR_COUNT);
        if (ZeusTransformUtils.instanceOf(th, JSONException.class) == false) goto L11;
        r1.ab().a(StatsCountKeys.JSON_ERROR_COUNT);
    L11:
        r1.ab().a(h() + " to pack json failed", th);
    L12:
        s().a(4, this.t, "toPackJson failed", th, new Object[0]);
        return r0;
    }

    public a n() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        r0.a();     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        s().a(4, this.t, "Clone data failed", th, new Object[0]);
        return null;
    }

    public String o() {
        return "sid:" + this.d;
    }

    public String p() {
        return null;
    }

    public int q() {
        return this.o;
    }

    public long r() {
        return this.f1724a;
    }

    public com.bytedance.applog.log.j s() {
        com.bytedance.applog.log.j r0 = com.bytedance.applog.log.c.b(this.m);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return q.a();
    }

    public String toString() {
        String r0 = h();
        if (getClass().getSimpleName().equalsIgnoreCase(r0) == true) goto L5;
        r0 = r0 + ", " + getClass().getSimpleName();
    L5:
        String r1 = this.d;
        String r3 = "-";
        if (r1 == null) goto L12;
        int r4 = r1.indexOf("-");
        if (r4 < 0) goto L10;
        r1 = r1.substring(0, r4);
    L10:
        r3 = r1;
    L12:
        return "{" + r0 + ", " + o() + ", " + r3 + ", " + this.f1725b + ", id=" + this.q + "}";
    }
}
