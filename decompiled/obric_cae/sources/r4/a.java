package r4;

import android.content.ContentValues;
import android.database.Cursor;
import c4.m;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
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
    public static final SimpleDateFormat F = null;
    public static final C0144a G = null;
    public long A;
    public long B;
    public int C;
    public final List<String> D;
    public v3.c.a E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11450b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f11451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f11454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f11455q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f11456r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11457s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f11458t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11459u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11460v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f11461w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f11462x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11463y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Deprecated
    public int f11464z;

    /* JADX INFO: renamed from: r4.a$a, reason: collision with other inner class name */
    public static class C0144a extends c4.b {
        public C0144a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            HashMap r10 = new HashMap();
            r10.put("page", new j());
            r10.put("launch", new g());
            r10.put("terminate", new k());
            r10.put("pack", new i());
            a[] r11 = a.d();
            int r12 = 0;
        L4:
            if (r12 >= 3) goto L6;
            a r13 = r11[r12];
            r10.put(r13.i(), r13);
            r12 = r12 + 1;
            goto L4
        L6:
            return r10;
        }
    }

    static {
        F = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        G = new C0144a();
    }

    public a() {
        this.f11458t = 0;
        this.f11459u = 0;
        this.f11460v = 0;
        this.f11463y = -1;
        this.f11464z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        l(0);
        long r8 = i4.h.f8231a.incrementAndGet();
        this.A = r8;
        this.B = r8;
        this.D = Collections.singletonList(i());
    }

    public static a[] d() {
        return new a[]{new c(), new e(null, null, null, 0), new d(new JSONObject())};
    }

    public final a a() {
        a r8 = (a) super.clone();     // Catch: Throwable -> L4
        r8.getClass();     // Catch: Throwable -> L4
        long r10 = i4.h.f8231a.incrementAndGet();     // Catch: Throwable -> L4
        r8.A = r10;     // Catch: Throwable -> L4
        r8.B = r10;     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        h().m(4, this.D, "Clone data failed", th, new Object[0]);
        return null;
    }

    public final String b() {
        List<String> r8 = e();
        if (r8 == null) goto L9;
        StringBuilder r10 = new StringBuilder(128);
        r10.append("create table if not exists ");
        r10.append(i());
        r10.append("(");
        int r11 = 0;
    L6:
        if (r11 >= r8.size()) goto L8;
        r10.append(r8.get(r11));
        r10.append(" ");
        r10.append(r8.get(r11 + 1));
        r10.append(",");
        r11 = r11 + 2;
        goto L6
    L8:
        r10.delete(r10.length() - 1, r10.length());
        r10.append(")");
        return r10.toString();
    L9:
        return null;
    }

    public final void c(JSONObject r8) {
        r3.b.a(this.f11461w);
        long r10 = this.f11453o;
        if (r10 <= 0) goto L5;
        r8.put("user_id", r10);
    L5:
        long r11 = this.f11454p;
        if (r11 <= 0) goto L8;
        r8.put("uid", r11);
    L8:
        int r12 = this.f11458t;
        if (r12 <= 0) goto L11;
        r8.put("user_type", r12);
    L11:
        int r13 = this.f11459u;
        if (r13 <= 0) goto L14;
        r8.put("user_is_login", r13);
    L14:
        int r14 = this.f11460v;
        if (r14 <= 0) goto L18;
        r8.put("user_is_auth", r14);
        return;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", MultiProcessSharedProvider.INT_TYPE, "tea_event_index", MultiProcessSharedProvider.INT_TYPE, "nt", MultiProcessSharedProvider.INT_TYPE, "user_id", MultiProcessSharedProvider.INT_TYPE, "uid", MultiProcessSharedProvider.INT_TYPE, QesdkUtils.TAGS.JSON_TAG_SESSION_ID, "varchar", "user_unique_id", "varchar", "ab_sdk_version", "varchar", "user_type", MultiProcessSharedProvider.INT_TYPE, "user_is_login", MultiProcessSharedProvider.INT_TYPE, "user_is_auth", MultiProcessSharedProvider.INT_TYPE, "_app_id", "varchar", "priority", MultiProcessSharedProvider.INT_TYPE, "forward", MultiProcessSharedProvider.INT_TYPE, "_local_event_id", "varchar", "monitor_id", MultiProcessSharedProvider.INT_TYPE, "event_stained", MultiProcessSharedProvider.INT_TYPE});
    }

    public String f() {
        return null;
    }

    public String g() {
        return "sid:" + this.f11452n;
    }

    public final c4.g h() {
        String r8 = this.f11461w;
        c4.g r10 = (c4.g) c4.c.f3327c.get(r8);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return m.u();
    }

    public abstract String i();

    public void j(Cursor r8) {
        this.f11449a = r8.getLong(0);
        this.f11450b = r8.getLong(1);
        this.f11451m = r8.getLong(2);
        this.f11457s = r8.getInt(3);
        this.f11453o = r8.getLong(4);
        this.f11454p = r8.getLong(5);
        this.f11452n = r8.getString(6);
        this.f11455q = r8.getString(7);
        this.f11456r = r8.getString(8);
        this.f11458t = r8.getInt(9);
        this.f11459u = r8.getInt(10);
        this.f11460v = r8.getInt(11);
        this.f11461w = r8.getString(12);
        this.f11463y = r8.getInt(13);
        this.f11464z = r8.getInt(14);
        String r10 = r8.getString(15);
        if (v4.i.h(r10) == true) goto L8;
    L5:
        this.B = r8.getLong(16);
        this.C = r8.getInt(17);
        return;
    L8:
        this.A = Long.parseLong(r10);     // Catch: Throwable -> L7
        goto L5
    }

    public a k(JSONObject r8) {
        this.f11450b = r8.optLong("local_time_ms", 0);
        this.f11449a = 0;
        this.f11451m = 0;
        this.f11457s = 0;
        this.f11453o = 0;
        this.f11454p = 0;
        this.f11452n = null;
        this.f11455q = null;
        this.f11456r = null;
        this.f11458t = 0;
        this.f11459u = 0;
        this.f11460v = 0;
        this.f11461w = r8.optString("_app_id");
        this.f11463y = r8.optInt("priority", -1);
        this.f11464z = r8.optInt("forward");
        this.A = r8.optLong("_local_event_id", 0);
        this.B = r8.optLong("monitor_id", 0);
        return this;
    }

    public final void l(long r8) {
        if (r8 != 0) goto L5;
        r8 = System.currentTimeMillis();
    L5:
        this.f11450b = r8;
    }

    public final JSONObject m() {
        JSONObject r8 = new JSONObject();
        this.f11462x = F.format(new Date(this.f11450b));     // Catch: Throwable -> L5
        return p();
    L5:
        th = move-exception;
        r3.c r10 = r3.b.a(this.f11461w);
        if (r10 == null) goto L12;
        i4.k r11 = i4.k.R;
        i4.f r12 = r10.f11417y;
        r12.b(r11, 1);
        if ((th instanceof JSONException) == false) goto L11;
        r12.b(i4.k.X, 1);
    L11:
        r12.g(i() + " to pack json failed", th);
    L12:
        h().m(4, this.D, "toPackJson failed", th, new Object[0]);
        return r8;
    }

    public void n(ContentValues r8) {
        r8.put("local_time_ms", Long.valueOf(this.f11450b));
        r8.put("tea_event_index", Long.valueOf(this.f11451m));
        r8.put("nt", Integer.valueOf(this.f11457s));
        r8.put("user_id", Long.valueOf(this.f11453o));
        r8.put("uid", Long.valueOf(this.f11454p));
        r8.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, this.f11452n);
        r8.put("user_unique_id", this.f11455q);
        r8.put("ab_sdk_version", this.f11456r);
        r8.put("user_type", Integer.valueOf(this.f11458t));
        r8.put("user_is_login", Integer.valueOf(this.f11459u));
        r8.put("user_is_auth", Integer.valueOf(this.f11460v));
        r8.put("_app_id", this.f11461w);
        r8.put("priority", Integer.valueOf(this.f11463y));
        r8.put("forward", Integer.valueOf(this.f11464z));
        r8.put("_local_event_id", String.valueOf(this.A));
        r8.put("monitor_id", Long.valueOf(this.B));
        r8.put("event_stained", Integer.valueOf(this.C));
    }

    public void o(JSONObject r8) {
        r8.put("local_time_ms", this.f11450b);
        r8.put("_app_id", this.f11461w);
        r8.put("priority", this.f11463y);
        r8.put("forward", this.f11464z);
        r8.put("_local_event_id", this.A);
        r8.put("monitor_id", this.B);
    }

    public abstract JSONObject p();

    public String toString() {
        String r8 = i();
        if (getClass().getSimpleName().equalsIgnoreCase(r8) == true) goto L5;
        StringBuilder r10 = android.aimedia.a.k(r8, ", ");
        r10.append(getClass().getSimpleName());
        r8 = r10.toString();
    L5:
        String r11 = this.f11452n;
        String r12 = "-";
        if (r11 == null) goto L11;
        int r13 = r11.indexOf("-");
        if (r13 < 0) goto L10;
        r11 = r11.substring(0, r13);
    L10:
        r12 = r11;
    L11:
        StringBuilder r14 = defpackage.b.h("{", r8, ", ");
        r14.append(g());
        r14.append(", ");
        r14.append(r12);
        r14.append(", ");
        r14.append(this.f11450b);
        r14.append(", id=");
        r14.append(this.A);
        r14.append("}");
        return r14.toString();
    }
}
