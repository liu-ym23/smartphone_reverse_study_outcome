package l1;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.Header;
import f1.m;
import f1.n;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import o1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final SimpleDateFormat f10825x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final o1.a<HashMap<String, a>> f10826y = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f10827c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10838q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f10839r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f10840s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f10841t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f10842u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f10843v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected List<String> f10844w;

    /* JADX INFO: renamed from: l1.a$a, reason: collision with other inner class name */
    static class C0228a extends o1.a<HashMap<String, a>> {
        C0228a() {
        }

        @Override // o1.a
        protected /* bridge */ /* synthetic */ HashMap<String, a> a(Object[] r10) {
            return c(r10);
        }

        protected HashMap<String, a> c(Object... r10) {
            return a.h();
        }
    }

    static {
        f10825x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        f10826y = new C0228a();
    }

    public a() {
        this.f10836o = 0;
        this.f10837p = 0;
        this.f10838q = 0;
        this.f10841t = -1;
        this.f10842u = 0;
        x(0);
        this.f10844w = Collections.singletonList(q());
        if (m.c() == true) goto L6;
        this.f10843v = p.k();
        return;
    }

    public static String f(long r10) {
        return f10825x.format(new Date(r10));
    }

    public static a g(String r10) {
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L9
        a r12 = f10826y.b(new Object[0]).get(r11.optString("k_cls", ""));     // Catch: Throwable -> L9
        if (r12 != null) goto L8;
        n.B().s(4, "from ipc class not recognized", new Object[0]);     // Catch: Throwable -> L9
        return null;
    L8:
        return r12.b().s(r11);
    L9:
        th = move-exception;
        n.B().v(4, "from ipc failed", th, new Object[0]);
        return null;
    }

    public static HashMap<String, a> h() {
        HashMap<String, a> r10 = new HashMap();
        t(r10, new h());
        t(r10, new f());
        t(r10, new i());
        t(r10, new g());
        a[] r11 = i();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        t(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public static a[] i() {
        return new a[]{new c(), new e(null, null, false, null), new d(null, "", new JSONObject())};
    }

    private static void t(HashMap<String, a> r10, a r11) {
        r10.put(r11.q(), r11);
    }

    final ContentValues A(@Nullable ContentValues r10) {
        if (r10 != null) goto L4;
        r10 = new ContentValues();
    L5:
        B(r10);
        return r10;
    L4:
        r10.clear();
        goto L5
    }

    protected void B(@NonNull ContentValues r10) {
        r10.put("local_time_ms", Long.valueOf(this.f10828g));
        r10.put("tea_event_index", Long.valueOf(this.f10829h));
        r10.put("nt", Integer.valueOf(this.f10835n));
        r10.put(Header.KEY_USER_ID, Long.valueOf(this.f10831j));
        r10.put("uid", Long.valueOf(this.f10832k));
        r10.put("session_id", this.f10830i);
        r10.put(Api.KEY_USER_UNIQUE_ID, this.f10833l);
        r10.put("ab_sdk_version", this.f10834m);
        r10.put("user_type", Integer.valueOf(this.f10836o));
        r10.put("user_is_login", Integer.valueOf(this.f10837p));
        r10.put("user_is_auth", Integer.valueOf(this.f10838q));
        r10.put("_app_id", this.f10839r);
        r10.put("priority", Integer.valueOf(this.f10841t));
        r10.put("forward", Integer.valueOf(this.f10842u));
        r10.put("_local_event_id", this.f10843v);
    }

    protected void C(@NonNull JSONObject r10) {
        r10.put("local_time_ms", this.f10828g);
        r10.put("_app_id", this.f10839r);
        r10.put("priority", this.f10841t);
        r10.put("forward", this.f10842u);
        r10.put("_local_event_id", this.f10843v);
    }

    protected abstract JSONObject D();

    public a b() {
        a r10 = (a) super.clone();     // Catch: Throwable -> L4
        r10.f10843v = p.k();     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        o().r(4, this.f10844w, "Clone data failed", th, new Object[0]);
        return null;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    final String d() {
        List<String> r10 = k();
        if (r10 == null) goto L9;
        StringBuilder r11 = new StringBuilder(128);
        r11.append("create table if not exists ");
        r11.append(q());
        r11.append("(");
        int r12 = 0;
    L6:
        if (r12 >= r10.size()) goto L8;
        r11.append(r10.get(r12));
        r11.append(" ");
        r11.append(r10.get(r12 + 1));
        r11.append(",");
        r12 = r12 + 2;
        goto L6
    L8:
        r11.delete(r11.length() - 1, r11.length());
        r11.append(")");
        return r11.toString();
    L9:
        return null;
    }

    protected final void e(@NonNull JSONObject r10) {
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(this.f10839r);
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L9:
        if (r12 == false) goto L11;
    L12:
        r10.put(Header.KEY_USER_ID, this.f10831j);
    L13:
        if (r12 == false) goto L15;
    L16:
        r10.put("uid", this.f10832k);
    L17:
        if (r12 == false) goto L19;
    L20:
        r10.put("user_type", this.f10836o);
    L21:
        if (r12 == false) goto L23;
    L24:
        r10.put("user_is_login", this.f10837p);
    L25:
        if (r12 == false) goto L27;
    L28:
        r10.put("user_is_auth", this.f10838q);
        return;
    L27:
        if (this.f10838q > 0) goto L28;
        return;
    L23:
        if (this.f10837p <= 0) goto L25;
    L19:
        if (this.f10836o <= 0) goto L21;
    L15:
        if (this.f10832k <= 0) goto L17;
    L11:
        if (this.f10831j <= 0) goto L13;
    L5:
        if (r11.D() == false) goto L7;
        r12 = true;
        goto L9
    }

    public String j() {
        return this.f10839r;
    }

    protected List<String> k() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, Header.KEY_USER_ID, TypedValues.Custom.S_INT, "uid", TypedValues.Custom.S_INT, "session_id", "varchar", Api.KEY_USER_UNIQUE_ID, "varchar", "ab_sdk_version", "varchar", "user_type", TypedValues.Custom.S_INT, "user_is_login", TypedValues.Custom.S_INT, "user_is_auth", TypedValues.Custom.S_INT, "_app_id", "varchar", "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT, "_local_event_id", "varchar"});
    }

    protected String l() {
        return null;
    }

    protected String m() {
        return "sid:" + this.f10830i;
    }

    public int n() {
        return this.f10842u;
    }

    protected f1.g o() {
        f1.g r10 = f1.b.x(this.f10839r);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return n.B();
    }

    public int p() {
        return this.f10841t;
    }

    @NonNull
    abstract String q();

    public int r(@NonNull Cursor r10) {
        this.f10827c = r10.getLong(0);
        this.f10828g = r10.getLong(1);
        this.f10829h = r10.getLong(2);
        this.f10835n = r10.getInt(3);
        this.f10831j = r10.getLong(4);
        this.f10832k = r10.getLong(5);
        this.f10830i = r10.getString(6);
        this.f10833l = r10.getString(7);
        this.f10834m = r10.getString(8);
        this.f10836o = r10.getInt(9);
        this.f10837p = r10.getInt(10);
        this.f10838q = r10.getInt(11);
        this.f10839r = r10.getString(12);
        this.f10841t = r10.getInt(13);
        this.f10842u = r10.getInt(14);
        this.f10843v = r10.getString(15);
        return 16;
    }

    protected a s(@NonNull JSONObject r10) {
        this.f10828g = r10.optLong("local_time_ms", 0);
        this.f10827c = 0;
        this.f10829h = 0;
        this.f10835n = 0;
        this.f10831j = 0;
        this.f10832k = 0;
        this.f10830i = null;
        this.f10833l = null;
        this.f10834m = null;
        this.f10836o = 0;
        this.f10837p = 0;
        this.f10838q = 0;
        this.f10839r = r10.optString("_app_id");
        this.f10841t = r10.optInt("priority", -1);
        this.f10842u = r10.optInt("forward");
        this.f10843v = r10.optString("_local_event_id", p.k());
        return this;
    }

    @NonNull
    public String toString() {
        String r10 = q();
        if (getClass().getSimpleName().equalsIgnoreCase(r10) == true) goto L5;
        r10 = r10 + ", " + getClass().getSimpleName();
    L5:
        String r11 = this.f10830i;
        String r12 = "-";
        if (r11 == null) goto L12;
        int r13 = r11.indexOf("-");
        if (r13 < 0) goto L10;
        r11 = r11.substring(0, r13);
    L10:
        r12 = r11;
    L12:
        return "{" + r10 + ", " + m() + ", " + r12 + ", " + this.f10828g + "}";
    }

    public void u(String r10) {
        this.f10839r = r10;
    }

    public void v(int r10) {
        this.f10842u = r10;
    }

    public void w(int r10) {
        this.f10841t = r10;
    }

    public void x(long r10) {
        if (r10 != 0) goto L5;
        r10 = System.currentTimeMillis();
    L5:
        this.f10828g = r10;
    }

    @NonNull
    public final JSONObject y() {
        JSONObject r10 = new JSONObject();
        r10.put("k_cls", q());     // Catch: Throwable -> L5
        C(r10);     // Catch: Throwable -> L5
    L7:
        return r10;
    L5:
        th = move-exception;
        o().r(4, this.f10844w, "toIpcJson failed", th, new Object[0]);
        goto L7
    }

    @NonNull
    public final JSONObject z() {
        JSONObject r10 = new JSONObject();
        this.f10840s = f(this.f10828g);     // Catch: Throwable -> L5
        return D();
    L5:
        th = move-exception;
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(this.f10839r);
        if (r11 == null) goto L9;
        r11.R().i(this, MonitorState.f_to_pack);
        r11.R().m(MonitorKey.f_to_pack_event, com.bytedance.applog.monitor.a.c(this));
    L9:
        o().r(4, this.f10844w, "toPackJson failed", th, new Object[0]);
        return r10;
    }
}
