package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.apm.core.DefaultDynamicParams;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.s;
import com.bytedance.apm.util.t;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.constant.CommonKey;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static IQueryParams A;
    private static MonitorableInterceptor B;
    static long C;
    static long D;
    static long E;
    static long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static JSONObject f915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static IDynamicParams f916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, String> f917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static IHttpService f918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static t4.h f919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static long f920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile int f921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static long f923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f925r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static boolean f927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static boolean f928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static boolean f929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static List<String> f930w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static g f931x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f932y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static e f933z;

    static {
        f915h = new JSONObject();
        f916i = new DefaultDynamicParams();
        f917j = Collections.emptyMap();
        f918k = new DefaultHttpServiceImpl();
        f920m = -1;
        f921n = -1;
        f922o = false;
        f929v = true;
        f932y = false;
        A = null;
    }

    public static long A() {
        return f914g;
    }

    public static long B() {
        if (f920m != (-1)) goto L6;
        f920m = System.currentTimeMillis();
    L6:
        return f920m;
    }

    public static String C(long r10) {
        long r11 = r10 - f924q;
        if (r11 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) goto L7;
        return "0 - 30s";
    L7:
        if (r11 >= VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L11;
        return "30s - 1min";
    L11:
        if (r11 >= AnrManager.ANR_MIN_INTERVAL) goto L15;
        return "1min - 2min";
    L15:
        if (r11 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r11 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r11 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r11 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean D() {
        if (f909b == false) goto L5;
    L8:
        return true;
    L5:
        if (f911d == true) goto L8;
        return false;
    }

    public static boolean E() {
        return f927t;
    }

    public static boolean F() {
        return f932y;
    }

    public static boolean G() {
        return f910c;
    }

    public static boolean H() {
        JSONObject r10 = f915h;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.optString("channel") != null) goto L8;
        return false;
    L8:
        return f915h.optString("channel").contains("local");
    }

    public static boolean I() {
        boolean r10 = true;
        if (f926s == false) goto L6;
        return true;
    L6:
        if (f908a == null) goto L8;
        String r11 = h();
        if (r11 != null) goto L12;
    L14:
        if (r11 != null) goto L16;
    L18:
        r10 = false;
    L19:
        f926s = r10;
    L21:
        return f926s;
    L16:
        if (r11.equals(f908a.getPackageName()) == false) goto L18;
    L12:
        if (r11.contains(":") == false) goto L14;
        f926s = false;
        goto L21
    L8:
        return J();
    }

    public static boolean J() {
        if (f926s == false) goto L5;
        return true;
    L5:
        String r10 = h();
        if (r10 != null) goto L8;
    L11:
        return true;
    L8:
        if (r10.contains(":") == false) goto L11;
        return false;
    }

    public static boolean K() {
        return f929v;
    }

    public static boolean L() {
        return f922o;
    }

    public static void M(String r10) {
    }

    public static void N(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        long r11 = f923p;
        if (r11 != 0) goto L8;
    L9:
        f923p = r10;
        return;
    L8:
        if (r10 < r11) goto L9;
    }

    public static void O(Context r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f908a = com.bytedance.apm.util.a.a(r10);
    }

    public static void P(String r10) {
        f925r = r10;
    }

    public static void Q(boolean r10) {
        f909b = r10;
        ApmBaseContext.setDebugMode(D());
    }

    public static void R(boolean r10) {
        f927t = r10;
    }

    public static synchronized void S(IDynamicParams r10) {
        monitor-enter(d.class);
        f916i = r10;     // Catch: Throwable -> L39
        Map<String, String> r11 = r10.getCommonParams();     // Catch: Throwable -> L39
        f917j = r11;     // Catch: Throwable -> L39
        if (r11 != null) goto L8;
        f917j = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (f917j.containsKey("aid") == true) goto L11;
        f917j.put("aid", f915h.optString("aid"));     // Catch: Throwable -> L39
    L11:
        if (f917j.containsKey("device_id") == true) goto L14;
        f917j.put("device_id", f915h.optString("device_id"));     // Catch: Throwable -> L39
    L14:
        if (f917j.containsKey("device_platform") == true) goto L16;
        f917j.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        f917j.put("os", "Android");     // Catch: Throwable -> L39
        if (f917j.containsKey("update_version_code") == true) goto L20;
        f917j.put("update_version_code", f915h.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (f917j.containsKey("version_code") == true) goto L23;
        f917j.put("version_code", f915h.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (f917j.containsKey("channel") == true) goto L26;
        f917j.put("channel", f915h.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (f917j.containsKey("os_api") == true) goto L29;
        f917j.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L39
    L29:
        if (D() == false) goto L34;
        if (f917j.containsKey(CommonKey.KEY_LOG_LEVEL) == true) goto L34;
        f917j.put(CommonKey.KEY_LOG_LEVEL, "debug");     // Catch: Throwable -> L39
    L34:
        if (f931x != null) goto L36;
        f931x = new g();     // Catch: Throwable -> L39
    L36:
        f931x.r(new HashMap(f917j));     // Catch: Throwable -> L39
        monitor-exit(d.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized void T(JSONObject r10) {
        monitor-enter(d.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (f931x != null) goto L7;
        f931x = new g();     // Catch: Throwable -> L23 Exception -> L76
    L7:
        r10.put("os", "Android");     // Catch: Throwable -> L23 Exception -> L76
        r10.put("device_platform", "android");     // Catch: Throwable -> L23 Exception -> L76
        r10.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("device_model", Build.MODEL);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("device_brand", Build.BRAND);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("process_name", com.bytedance.apm.util.a.b(Process.myPid()));     // Catch: Throwable -> L23 Exception -> L76
        r10.put("sid", B());     // Catch: Throwable -> L23 Exception -> L76
        r10.put(Constants.KEY_PHONE_STARTUP_TIME, s());     // Catch: Throwable -> L23 Exception -> L76
        r10.put(Constants.KEY_VERIFY_INFO, t.a());     // Catch: Throwable -> L23 Exception -> L76
        r10.put("rom_version", s.l());     // Catch: Throwable -> L23 Exception -> L76
        PackageInfo r11 = null;
        if (r10.has("version_name") == true) goto L11;
        r11 = g().getPackageManager().getPackageInfo(g().getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L76
        r10.put("version_name", r11.versionName);     // Catch: Throwable -> L23 Exception -> L76
    L11:
        if (TextUtils.isEmpty(r10.optString("app_version")) == false) goto L14;
        r10.put("app_version", r10.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L76
    L14:
        if (r10.has("version_code") == true) goto L19;
        if (r11 != null) goto L17;
        r11 = g().getPackageManager().getPackageInfo(g().getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L76
    L17:
        r10.put("version_code", r11.versionCode);     // Catch: Throwable -> L23 Exception -> L76
    L19:
        if (TextUtils.isEmpty(r10.optString("package")) == false) goto L21;
        r10.put("package", g().getPackageName());     // Catch: Throwable -> L23 Exception -> L76
    L21:
        r10.put(Constants.KEY_MONITOR_VERSION, "5.0.21.45-rc.0");     // Catch: Throwable -> L23 Exception -> L76
    L25:
        f931x.s(r10.optString("process_name"));     // Catch: Throwable -> L23
        f931x.p(r10.optString("device_id"));     // Catch: Throwable -> L23
        f931x.m(r10.optInt("aid"));     // Catch: Throwable -> L23 Exception -> L77
        f931x.o(r10.optString("channel"));     // Catch: Throwable -> L23 Exception -> L77
        if (r10.has("update_version_code") == false) goto L34;
        if ((r10.get("update_version_code") instanceof String) == false) goto L32;
        g r12 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        int r13 = Integer.valueOf(r10.optString("update_version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L31:
        r12.v(r13);     // Catch: Throwable -> L23 Exception -> L77
        goto L34
    L32:
        r12 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        r13 = r10.optInt("update_version_code");     // Catch: Throwable -> L23 Exception -> L77
    L34:
        if (r10.has("version_name") == false) goto L37;
        f931x.x(r10.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L77
    L37:
        if (r10.has("manifest_version_code") == false) goto L44;
        if ((r10.get("manifest_version_code") instanceof String) == false) goto L42;
        g r14 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        int r15 = Integer.valueOf(r10.optString("manifest_version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L41:
        r14.q(r15);     // Catch: Throwable -> L23 Exception -> L77
        goto L44
    L42:
        r14 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        r15 = r10.optInt("manifest_version_code");     // Catch: Throwable -> L23 Exception -> L77
    L44:
        if (r10.has("version_code") == false) goto L51;
        if ((r10.get("version_code") instanceof String) == false) goto L49;
        g r16 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        int r17 = Integer.valueOf(r10.optString("version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L48:
        r16.w(r17);     // Catch: Throwable -> L23 Exception -> L77
        goto L51
    L49:
        r16 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        r17 = r10.optInt("version_code");     // Catch: Throwable -> L23 Exception -> L77
    L51:
        if (r10.has("app_version") == false) goto L53;
        f931x.n(r10.optString("app_version"));     // Catch: Throwable -> L23 Exception -> L77
    L53:
        String r18 = t.a();     // Catch: Throwable -> L23 Exception -> L77
        if (TextUtils.isEmpty(r18) == true) goto L60;
        if (r18.equals("null") == true) goto L60;
        r10.put("release_build", r18);     // Catch: Throwable -> L23 Exception -> L77
        g r19 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        String r20 = r10.optString("release_build");     // Catch: Throwable -> L23 Exception -> L77
    L58:
        r19.t(r20);     // Catch: Throwable -> L23 Exception -> L77
    L60:
        if (t.a().isEmpty() == true) goto L63;
        r19 = f931x;     // Catch: Throwable -> L23 Exception -> L77
        r20 = t.a();     // Catch: Throwable -> L23 Exception -> L77
    L63:
        f931x.u(com.bytedance.apm.util.i.c(r10));     // Catch: Throwable -> L23
        if (f915h != null) goto L66;
        f915h = r10;     // Catch: Throwable -> L23
    L72:
        monitor-exit(d.class);
        return;
    L66:
        Iterator<String> r21 = r10.keys();     // Catch: Throwable -> L23
    L68:
        if (r21.hasNext() == false) goto L72;
        String r22 = r21.next();     // Catch: Throwable -> L23
        f915h.put(r22, r10.get(r22));     // Catch: Throwable -> L23 JSONException -> L78
        goto L68
    }

    public static void U(IHttpService r10) {
        if (r10 == null) goto L5;
        f918k = r10;
        return;
    }

    public static void V(long r10) {
        f912e = r10;
    }

    public static void W(long r10) {
        C = r10;
    }

    public static void X(long r10) {
        D = r10;
    }

    public static void Y(long r10) {
        E = r10;
    }

    public static void Z(long r10) {
        F = r10;
    }

    public static t4.g a(String r10, String r11, boolean r12) {
        return f918k.buildMultipartUpload(r10, r11, r12);
    }

    public static void a0(long r10) {
        f913f = r10;
    }

    public static t4.g b(String r10, String r11, boolean r12, Map<String, String> r13) {
        return f918k.buildMultipartUpload(r10, r11, r12, r13);
    }

    public static void b0(long r10) {
        f924q = r10;
    }

    public static t4.c c(String r10, Map<String, String> r11) {
        return f918k.doGet(r10, r11);
    }

    public static void c0(long r10) {
    }

    public static t4.c d(String r10, byte[] r11, Map<String, String> r12) {
        return f918k.doPost(r10, r11, r12);
    }

    public static void d0(boolean r10) {
        f910c = r10;
    }

    public static boolean e(String r10, String r11) {
        if (f915h != null) goto L6;
        return false;
    L6:
        if (r10.equals("release_build") == false) goto L12;
        return false;
    L12:
        f915h.put(r10, r11);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static void e0(boolean r10) {
        f932y = r10;
    }

    public static long f() {
        return f923p;
    }

    public static void f0(int r10) {
        f921n = r10;
    }

    public static Context g() {
        return f908a;
    }

    public static synchronized void g0(IQueryParams r10) {
        monitor-enter(d.class);
        A = r10;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String h() {
        if (TextUtils.isEmpty(f925r) == false) goto L6;
        f925r = com.bytedance.apm.util.a.b(Process.myPid());
    L6:
        return f925r;
    }

    public static void h0(t4.h r10) {
        f919l = r10;
    }

    public static IDynamicParams i() {
        return f916i;
    }

    public static void i0(List<String> r10) {
        f930w = r10;
    }

    public static JSONObject j() {
        return new JSONObject(String.valueOf(f915h));
    L5:
        return new JSONObject();
    }

    public static void j0(long r10) {
        f914g = r10;
    }

    @Deprecated
    public static JSONObject k() {
        return f915h;
    }

    public static void k0(long r10) {
    }

    public static IHttpService l() {
        return f918k;
    }

    public static void l0(boolean r10) {
        f928u = r10;
    }

    public static long m() {
        return f912e;
    }

    public static boolean m0() {
        return f928u;
    }

    public static long n() {
        return f913f;
    }

    public static t4.c n0(String r10, List<File> r11, Map<String, String> r12) {
        return f918k.uploadFiles(r10, r11, r12);
    }

    public static long o() {
        return C;
    }

    public static long p() {
        return D;
    }

    public static long q() {
        return E;
    }

    public static long r() {
        return F;
    }

    public static long s() {
        if (f924q != 0) goto L6;
        f924q = System.currentTimeMillis();
    L6:
        return f924q;
    }

    public static MonitorableInterceptor t() {
        return B;
    }

    public static int u() {
        return f921n;
    }

    public static synchronized g v() {
        monitor-enter(d.class);
        g r10 = f931x;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> w() {
        monitor-enter(d.class);
        IQueryParams r10 = A;     // Catch: Throwable -> L25
        if (r10 == null) goto L17;
        Map<String, String> r11 = r10.getQueryParams();     // Catch: Throwable -> L25
        if (r11 == null) goto L17;
        if (r11.size() <= 0) goto L17;
        if (f931x.f() == null) goto L15;
        HashMap r12 = new HashMap(f931x.f());     // Catch: Throwable -> L25
        r12.putAll(r11);     // Catch: Throwable -> L25
        monitor-exit(d.class);
        return r12;
    L15:
        monitor-exit(d.class);
        return r11;
    L17:
        g r13 = f931x;     // Catch: Throwable -> L25
        if (r13 == null) goto L23;
        Map<String, String> r14 = r13.f();     // Catch: Throwable -> L25
        monitor-exit(d.class);
        return r14;
    L23:
        monitor-exit(d.class);
        return null;
    L25:
        th = move-exception;
        throw th;
    }

    public static e x() {
        return f933z;
    }

    public static synchronized Map<String, String> y() {
        monitor-enter(d.class);
        IQueryParams r10 = A;     // Catch: Throwable -> L16
        if (r10 == null) goto L13;
        Map<String, String> r11 = r10.getQueryParams();     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        if (r11.size() <= 0) goto L13;
        HashMap r12 = new HashMap(f917j);     // Catch: Throwable -> L16
        r12.putAll(r11);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r12;
    L13:
        Map<String, String> r13 = f917j;     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r13;
    L16:
        th = move-exception;
        throw th;
    }

    public static t4.h z() {
        return f919l;
    }
}
