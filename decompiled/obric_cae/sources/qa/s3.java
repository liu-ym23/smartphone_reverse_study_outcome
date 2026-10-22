package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s3 {
    public static boolean A = false;
    public static String B = null;
    public static long C = 0;
    public static boolean D = false;
    public static int E = 0;
    public static int F = 0;
    public static boolean G = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f11064a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11065b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11066c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f11067d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f11068e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f11069f = 20;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f11070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f11071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f11072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f11073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f11074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f11075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static double f11076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f11077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f11078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f11079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f11080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f11081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f11082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f11083t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f11084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f11085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f11086w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f11087x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f11088y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f11089z;

    public static class a implements i4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11090a;

        public a(Context r8) {
            this.f11090a = r8;
        }
    }

    static {
        new ArrayList();
        new ArrayList();
        f11072i = false;
        f11073j = true;
        f11074k = 300000;
        f11075l = false;
        f11076m = 0.618d;
        f11077n = true;
        f11078o = 80;
        f11079p = 5;
        f11080q = 3600000;
        f11081r = true;
        f11082s = false;
        f11083t = false;
        f11084u = true;
        f11085v = -1;
        f11086w = true;
        f11087x = 1;
        f11088y = false;
        f11089z = 5;
        A = false;
        B = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        C = 0;
        D = false;
        E = 20480;
        F = 10800000;
        G = false;
    }

    public static void a(Context r8) {
        if (f11064a == false) goto L5;
        return;
    L5:
        f11064a = true;
        s4 r10 = t3.j();
        a r11 = new a(r8);
        int r12 = i4.f10541a;
        monitor-enter(i4.class);
        if (r8 == null) goto L46;
        if (r10 == null) goto L46;
    L40:
        th = move-exception;
        l.a("at", "rglc", th);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L11:
        if (i4.f10543c != null) goto L13;
        i4.f10543c = r8.getApplicationContext();     // Catch: Throwable -> L40
    L13:
        String r13 = r10.a();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r13) == true) goto L46;
        i4.k(r10);     // Catch: Throwable -> L40
        if (i4.f10552l != null) goto L20;
        i4.f10552l = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L20:
        if (i4.f10551k != null) goto L23;
        i4.f10551k = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L23:
        if (i4.f10550j != null) goto L26;
        i4.f10550j = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L26:
        if (i4.f10552l.containsKey(r13) == true) goto L46;
        i4.e r14 = new i4.e();     // Catch: Throwable -> L40
        r14.f10580a = r10;     // Catch: Throwable -> L40
        r14.f10581b = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";     // Catch: Throwable -> L40
        r14.f10582c = r11;     // Catch: Throwable -> L40
        i4.f10552l.put(r13, r14);     // Catch: Throwable -> L40
        long r15 = 0;
        r15 = i4.f10543c.getSharedPreferences("open_common", 0).getLong(r13, 0);     // Catch: Throwable -> L31
    L33:
        i4.f10550j.put(r13, new i4.h(Long.valueOf(r15), z.k(i4.f10543c, "open_common", r13 + "lct-info")));     // Catch: Throwable -> L40
        Context r16 = i4.f10543c;     // Catch: Throwable -> L40
        if (i4.f10553m == true) goto L38;
        b.f10221b = z.i(r16, "a4", true);     // Catch: Throwable -> L48
        b.f10222c = z.i(r16, "a5", true);     // Catch: Throwable -> L48
        i4.f10553m = true;     // Catch: Throwable -> L48
    L38:
        i4.x(i4.f10543c);     // Catch: Throwable -> L40
        goto L46
    L31:
        th = move-exception;
        q.f("csp", "glv", th);     // Catch: Throwable -> L40
    L46:
        monitor-exit(i4.class);
    }

    public static void b(Context r8, JSONObject r10, SharedPreferences.Editor r11) {
        JSONObject r12 = r10.optJSONObject("13S");     // Catch: Throwable -> L30
        if (r12 == null) goto L48;
        long r13 = (r12.optInt("at", AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID) * 60) * 1000;     // Catch: Throwable -> L7
        f11080q = r13;     // Catch: Throwable -> L7
        x3.g(r11, "13S_at", r13);     // Catch: Throwable -> L7
    L43:
        boolean r14 = i4.o(r12.optString("re"), false);     // Catch: Throwable -> L12
        f11083t = r14;     // Catch: Throwable -> L12
        x3.i(r11, "fr", r14);     // Catch: Throwable -> L12
    L39:
        boolean r15 = i4.o(r12.optString("nla"), true);     // Catch: Throwable -> L33
        f11081r = r15;     // Catch: Throwable -> L33
        x3.i(r11, "13S_nla", r15);     // Catch: Throwable -> L33
    L46:
        boolean r16 = i4.o(r12.optString("asw"), true);     // Catch: Throwable -> L34
        f11084u = r16;     // Catch: Throwable -> L34
        x3.i(r11, "asw", r16);     // Catch: Throwable -> L34
    L45:
        JSONArray r17 = r12.optJSONArray("mlpl");     // Catch: Throwable -> L35
        if (r17 != null) goto L21;
    L24:
        f11082s = false;     // Catch: Throwable -> L35
        r11.remove("13S_mlpl");     // Catch: Throwable -> L27
        goto L50
    L49:
        return;
    L27:
        th = move-exception;
        t3.g("SpUtil", "setPrefsLong", th);     // Catch: Throwable -> L35
        return;
    L21:
        if (r17.length() <= 0) goto L24;
        x3.h(r11, "13S_mlpl", t4.j(r17.toString()));     // Catch: Throwable -> L35
        f11082s = f(r8, r17);     // Catch: Throwable -> L35
        return;
    L50:
        return;
    L12:
        th = move-exception;
        t3.g("AuthUtil", "checkReLocationAble", th);     // Catch: Throwable -> L30
    L7:
        th = move-exception;
        t3.g("AuthUtil", "requestSdkAuthInterval", th);     // Catch: Throwable -> L30
        goto L43
    L48:
        return;
    L30:
        th = move-exception;
        t3.g("AuthUtil", "loadConfigAbleStatus", th);
    }

    public static void c(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("11G");     // Catch: Throwable -> L9
        if (r11 == null) goto L14;
        boolean r12 = i4.o(r11.optString("able"), true);     // Catch: Throwable -> L9
        f11073j = r12;     // Catch: Throwable -> L9
        if (r12 == false) goto L7;
        f11074k = r11.optInt("c", 300) * 1000;     // Catch: Throwable -> L9
    L7:
        f11075l = i4.o(r11.optString("fa"), false);     // Catch: Throwable -> L9
        f11076m = Math.min(1.0d, Math.max(0.2d, r11.optDouble("ms", 0.618d)));     // Catch: Throwable -> L9
        x3.i(r8, "ca", f11073j);     // Catch: Throwable -> L9
        x3.g(r8, "ct", f11074k);     // Catch: Throwable -> L9
        x3.i(r8, "11G_fa", f11075l);     // Catch: Throwable -> L9
        x3.h(r8, "11G_ms", String.valueOf(f11076m));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        t3.g("AuthUtil", "loadConfigDataCacheAble", th);
    }

    public static void d(i4.c r10, SharedPreferences.Editor r11) {
        i4.c.a r12 = r10.f10573c;     // Catch: Throwable -> L23
        if (r12 == null) goto L22;
        boolean r8 = r12.f10574a;     // Catch: Throwable -> L23
        f11065b = r8;     // Catch: Throwable -> L23
        x3.i(r11, "exception", r8);     // Catch: Throwable -> L23
        JSONObject r13 = r12.f10575b;     // Catch: Throwable -> L23
        if (r13 == null) goto L14;
        f11066c = r13.optInt("fn", f11066c);     // Catch: Throwable -> L23
        int r14 = r13.optInt("mpn", f11067d);     // Catch: Throwable -> L23
        f11067d = r14;     // Catch: Throwable -> L23
        if (r14 <= 500) goto L11;
        f11067d = 500;     // Catch: Throwable -> L23
    L11:
        if (f11067d >= 30) goto L13;
        f11067d = 30;     // Catch: Throwable -> L23
    L13:
        f11068e = i4.o(r13.optString("igu"), false);     // Catch: Throwable -> L23
        f11069f = r13.optInt("ms", f11069f);     // Catch: Throwable -> L23
        f11071h = r13.optInt("rot", 0);     // Catch: Throwable -> L23
        f11070g = r13.optInt("pms", 0);     // Catch: Throwable -> L23
    L14:
        s0.a(f11066c, f11068e, f11069f, f11070g);     // Catch: Throwable -> L23
        boolean r15 = f11068e;     // Catch: Throwable -> L23
        int r16 = f11070g;     // Catch: Throwable -> L23
        monitor-enter(u0.class);     // Catch: Throwable -> L23
        u0.f11127a = r15;     // Catch: Throwable -> L19
        u0.f11128b = Math.max(0, r16);     // Catch: Throwable -> L19
        monitor-exit(u0.class);     // Catch: Throwable -> L23
        x3.f(r11, "fn", f11066c);     // Catch: Throwable -> L23
        x3.f(r11, "mpn", f11067d);     // Catch: Throwable -> L23
        x3.i(r11, "igu", f11068e);     // Catch: Throwable -> L23
        x3.f(r11, "ms", f11069f);     // Catch: Throwable -> L23
        x3.f(r11, "rot", f11071h);     // Catch: Throwable -> L23
        x3.f(r11, "pms", f11070g);     // Catch: Throwable -> L23
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L22:
        return;
    L23:
        th = move-exception;
        t3.g("AuthUtil", "loadConfigDataUploadException", th);
    }

    public static boolean e(long r8) {
        if (f11073j == true) goto L5;
        return false;
    L5:
        long r10 = System.currentTimeMillis() - r8;
        long r11 = f11074k;
        if (r11 >= 0) goto L8;
        return true;
    L8:
        if (r10 < r11) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean f(Context r8, JSONArray r10) {
        if (r10.length() <= 0) goto L21;
        if (r8 == null) goto L21;
        int r11 = 0;
    L8:
        if (r11 >= r10.length()) goto L21;
        PackageInfo r12 = r8.getApplicationContext().getPackageManager().getPackageInfo(r10.getString(r11), 256);     // Catch: Throwable -> L13
    L15:
        if (r12 == null) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L19;
        r11 = r11 + 1;
        goto L8
    L19:
        return true;
    L17:
        r13 = false;
    L13:
        r12 = null;
    L21:
        return false;
    }

    public static void g(Context r10) {
        if (f11072i == false) goto L5;
        return;
    L5:
        f11072i = true;
        f11065b = x3.j(r10, "exception", f11065b);     // Catch: Throwable -> L9
        s4 r8 = t3.j();     // Catch: Throwable -> L79
        r8.f11093c = f11065b ? 1 : 0;     // Catch: Throwable -> L79
        q.c(r10, r8);     // Catch: Throwable -> L79
    L80:
        f11066c = x3.a(r10, f11066c, "fn");     // Catch: Throwable -> L20
        f11067d = x3.a(r10, f11067d, "mpn");     // Catch: Throwable -> L20
        f11068e = x3.j(r10, "igu", f11068e);     // Catch: Throwable -> L20
        f11069f = x3.a(r10, f11069f, "ms");     // Catch: Throwable -> L20
        f11071h = x3.a(r10, 0, "rot");     // Catch: Throwable -> L20
        int r11 = x3.a(r10, 0, "pms");     // Catch: Throwable -> L20
        f11070g = r11;     // Catch: Throwable -> L20
        s0.a(f11066c, f11068e, f11069f, r11);     // Catch: Throwable -> L20
        boolean r12 = f11068e;     // Catch: Throwable -> L20
        int r13 = f11070g;     // Catch: Throwable -> L20
        monitor-enter(u0.class);     // Catch: Throwable -> L20
        u0.f11127a = r12;     // Catch: Throwable -> L17
        u0.f11128b = Math.max(0, r13);     // Catch: Throwable -> L17
        monitor-exit(u0.class);     // Catch: Throwable -> L20
    L85:
        f11073j = x3.j(r10, "ca", f11073j);     // Catch: Throwable -> L24
        f11074k = x3.b(r10, "pref", "ct", f11074k);     // Catch: Throwable -> L24
        f11075l = x3.j(r10, "11G_fa", f11075l);     // Catch: Throwable -> L24
        double r14 = Double.valueOf(x3.d(r10, "pref", "11G_ms", String.valueOf(f11076m))).doubleValue();     // Catch: Throwable -> L24
        f11076m = r14;     // Catch: Throwable -> L24
        f11076m = Math.max(0.2d, r14);     // Catch: Throwable -> L24
    L97:
        f11083t = x3.j(r10, "fr", f11083t);     // Catch: Throwable -> L28
    L87:
        f11084u = x3.j(r10, "asw", f11084u);     // Catch: Throwable -> L32
    L99:
        f11085v = x3.b(r10, "pref", "awsi", f11085v);     // Catch: Throwable -> L36
    L107:
        f11086w = x3.j(r10, "15ua", f11086w);     // Catch: Throwable -> L40
        f11087x = x3.a(r10, f11087x, "15un");     // Catch: Throwable -> L40
        C = x3.b(r10, "pref", "15ust", C);     // Catch: Throwable -> L40
    L81:
        f11088y = x3.j(r10, "ok9", f11088y);     // Catch: Throwable -> L44
        f11089z = x3.a(r10, f11089z, "ok10");     // Catch: Throwable -> L44
        B = x3.d(r10, "pref", "ok11", B);     // Catch: Throwable -> L44
    L95:
        x3.j(r10, "17ya", false);     // Catch: Throwable -> L48
        D = x3.j(r10, "17ym", false);     // Catch: Throwable -> L48
        F = ((x3.a(r10, 2, "17yi") * 60) * 60) * 1000;     // Catch: Throwable -> L48
        E = x3.a(r10, 100, "17yx") * 1024;     // Catch: Throwable -> L48
    L93:
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L52
        f11080q = x3.b(r10, "pref", "13S_at", f11080q);     // Catch: Throwable -> L52
        f11081r = x3.j(r10, "13S_nla", f11081r);     // Catch: Throwable -> L52
        f11077n = x3.j(r10, "13J_able", f11077n);     // Catch: Throwable -> L52
        f11078o = x3.a(r10, f11078o, "13J_c");     // Catch: Throwable -> L52
        f11079p = x3.a(r10, f11079p, "13J_t");     // Catch: Throwable -> L52
    L54:
        int r15 = i4.f10541a;
        if (r10 == null) goto L105;
        i4.f10544d = z.i(r10, "a2", true);
    L105:
        String r16 = x3.d(r10, "pref", "13S_mlpl", null);     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r16) == true) goto L91;
        f11082s = f(r10, new JSONArray(t4.n(r16)));     // Catch: Throwable -> L62
    L91:
        boolean r17 = x3.j(r10, "197a", false);     // Catch: Throwable -> L72
        String r18 = x3.d(r10, "pref", "197dv", "");     // Catch: Throwable -> L72
        String r19 = x3.d(r10, "pref", "197tv", "");     // Catch: Throwable -> L72
        if (r17 == true) goto L67;
    L103:
        G = x3.j(r10, "1A6", G);     // Catch: Throwable -> L76
        return;
    L76:
        th = move-exception;
        t3.g("AuthUtil", "loadSdkEnableConfig p13", th);
        return;
    L67:
        if (t3.f11114a.equals(r18) == false) goto L103;
        if (t3.f11115b[0].equals(r19) == false) goto L103;
        t3.f11114a = r19;     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p12", th);
    L62:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p11", th);
    L52:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p10", th);
    L48:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p9", th);
    L44:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p8", th);
    L40:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p7", th);
    L36:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p6", th);
    L32:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p5", th);
    L28:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p4", th);
    L24:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p3", th);
        goto L97
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p2", th);
    L9:
        th = move-exception;
        t3.g("AuthUtil", "loadLastAbleState p1", th);
        goto L80
    }

    public static void h(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.getJSONObject("197");     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        boolean r12 = i4.o(r11.optString("able"), false);     // Catch: Throwable -> L11
        x3.i(r8, "197a", r12);     // Catch: Throwable -> L11
        if (r12 == false) goto L9;
        x3.h(r8, "197dv", r11.optString("sv", ""));     // Catch: Throwable -> L11
        x3.h(r8, "197tv", r11.optString(BdimCategoryConstants.NAME_TV, ""));     // Catch: Throwable -> L11
        return;
    L9:
        x3.h(r8, "197dv", "");     // Catch: Throwable -> L11
        x3.h(r8, "197tv", "");     // Catch: Throwable -> L11
        return;
    L13:
        return;
    }

    public static void i(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("13J");     // Catch: Throwable -> L9
        if (r11 == null) goto L14;
        boolean r12 = i4.o(r11.optString("able"), true);     // Catch: Throwable -> L9
        f11077n = r12;     // Catch: Throwable -> L9
        if (r12 == false) goto L7;
        f11078o = r11.optInt("c", f11078o);     // Catch: Throwable -> L9
        f11079p = r11.optInt("t", f11079p);     // Catch: Throwable -> L9
    L7:
        x3.i(r8, "13J_able", f11077n);     // Catch: Throwable -> L9
        x3.f(r8, "13J_c", f11078o);     // Catch: Throwable -> L9
        x3.f(r8, "13J_t", f11079p);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        t3.g("AuthUtil", "loadConfigDataGpsGeoAble", th);
    }

    public static void j(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("15O");     // Catch: Throwable -> L16
        if (r11 != null) goto L5;
        return;
    L5:
        if (i4.o(r11.optString("able"), false) == false) goto L13;
        JSONArray r12 = r11.optJSONArray("fl");     // Catch: Throwable -> L16
        if (r12 != null) goto L9;
    L12:
        f11085v = r11.optInt("iv", 30) * 1000;     // Catch: Throwable -> L16
    L14:
        x3.g(r8, "awsi", f11085v);     // Catch: Throwable -> L16
        return;
    L9:
        if (r12.length() <= 0) goto L12;
        if (r12.toString().contains(Build.MANUFACTURER) == true) goto L12;
    L13:
        f11085v = -1;     // Catch: Throwable -> L16
    }

    public static void k(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.getJSONObject("17Y");     // Catch: Throwable -> L11
        if (r11 == null) goto L14;
        x3.i(r8, "17ya", i4.o(r11.optString("able"), false));     // Catch: Throwable -> L11
        boolean r12 = i4.o(r11.optString("mup"), false);     // Catch: Throwable -> L11
        D = r12;     // Catch: Throwable -> L11
        x3.i(r8, "17ym", r12);     // Catch: Throwable -> L11
        int r13 = r11.optInt("max", 20);     // Catch: Throwable -> L11
        if (r13 <= 0) goto L7;
        x3.f(r8, "17yx", r13);     // Catch: Throwable -> L11
        E = r13 * 1024;     // Catch: Throwable -> L11
    L7:
        int r14 = r11.optInt("inv", 3);     // Catch: Throwable -> L11
        if (r14 <= 0) goto L15;
        x3.f(r8, "17yi", r14);     // Catch: Throwable -> L11
        F = ((r14 * 60) * 60) * 1000;     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void l(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("15U");     // Catch: Throwable -> L6
        if (r11 == null) goto L9;
        boolean r12 = i4.o(r11.optString("able"), true);     // Catch: Throwable -> L6
        int r13 = r11.optInt("yn", f11087x);     // Catch: Throwable -> L6
        C = r11.optLong("sysTime", C);     // Catch: Throwable -> L6
        x3.i(r8, "15ua", r12);     // Catch: Throwable -> L6
        x3.f(r8, "15un", r13);     // Catch: Throwable -> L6
        x3.g(r8, "15ust", C);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void m(SharedPreferences.Editor r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("17J");     // Catch: Throwable -> L14
        if (r11 == null) goto L17;
        boolean r12 = i4.o(r11.optString("able"), false);     // Catch: Throwable -> L14
        f11088y = r12;     // Catch: Throwable -> L14
        x3.i(r8, "ok9", r12);     // Catch: Throwable -> L14
        if (r12 == false) goto L18;
        String r13 = r11.optString("auth");     // Catch: Throwable -> L14
        String r14 = r11.optString("ht");     // Catch: Throwable -> L14
        B = r14;     // Catch: Throwable -> L14
        x3.h(r8, "ok11", r14);     // Catch: Throwable -> L14
        i4.o(r13, false);     // Catch: Throwable -> L14
        A = i4.o(r11.optString("nr"), false);     // Catch: Throwable -> L14
        String r15 = r11.optString("tm");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r15) == true) goto L19;
        int r16 = Integer.parseInt(r15);     // Catch: Throwable -> L14
        if (r16 > 0) goto L11;
        return;
    L11:
        if (r16 >= 20) goto L21;
        f11089z = r16;     // Catch: Throwable -> L14
        x3.f(r8, "ok10", r16);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}
