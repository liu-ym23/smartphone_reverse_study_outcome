package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eu {
    private static double A = 0.0d;
    private static boolean B = false;
    private static int C = 0;
    private static int D = 0;
    private static boolean E = false;
    private static boolean F = false;
    private static boolean G = false;
    private static boolean H = false;
    private static long I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static boolean f5510J = false;
    private static int K = 0;
    private static boolean L = false;
    private static int M = 0;
    private static boolean N = false;
    private static String O = null;
    private static long P = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f5511a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f5512b = 0;
    static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 0;
    public static int g = 0;
    public static boolean h = false;
    private static volatile boolean i = false;
    private static boolean j = true;
    private static int k = 1000;
    private static int l = 200;
    private static boolean m = false;
    private static int n = 20;
    private static int o = 0;
    private static volatile int p = 0;
    private static boolean q = true;
    private static boolean r = false;
    private static int s = -1;
    private static long t;
    private static ArrayList<String> u;
    private static ArrayList<String> v;
    private static volatile boolean w;
    private static boolean x;
    private static long y;
    private static boolean z;

    static {
        u = new ArrayList();
        v = new ArrayList();
        w = false;
        x = true;
        y = 300000;
        z = false;
        A = 0.618d;
        B = true;
        C = 80;
        D = 5;
        f5511a = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        E = false;
        F = true;
        G = false;
        f5512b = 0;
        c = false;
        H = true;
        I = -1;
        f5510J = true;
        K = 1;
        L = false;
        M = 5;
        N = false;
        O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        P = 0;
        d = false;
        e = false;
        f = 20480;
        g = 10800000;
        h = false;
    }

    public static void a(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (i == false) goto L5;
        return;
    L5:
        i = true;
        fn.a(r4, ev.c(), ev.d(), new AnonymousClass1(r4));
    }

    private static void a(Context r5, JSONObject r6, SharedPreferences.Editor r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences.Editor r9 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r7, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        JSONObject r10 = r6.optJSONObject("13S");     // Catch: Throwable -> L23
        if (r10 == null) goto L38;
        long r2 = (r10.optInt("at", 123) * 60) * 1000;     // Catch: Throwable -> L7
        f5511a = r2;     // Catch: Throwable -> L7
        fc.a(r9, "13S_at", r2);     // Catch: Throwable -> L7
    L9:
        e(r10, r9);     // Catch: Throwable -> L23
        boolean r3 = fn.a(r10.optString("nla"), true);     // Catch: Throwable -> L26
        F = r3;     // Catch: Throwable -> L26
        fc.a(r9, "13S_nla", r3);     // Catch: Throwable -> L26
    L34:
        boolean r1 = fn.a(r10.optString("asw"), true);     // Catch: Throwable -> L27
        H = r1;     // Catch: Throwable -> L27
        fc.a(r9, "asw", r1);     // Catch: Throwable -> L27
    L31:
        JSONArray r11 = r10.optJSONArray("mlpl");     // Catch: Throwable -> L28
        if (r11 != null) goto L17;
    L21:
        G = false;     // Catch: Throwable -> L28
        fc.a(r9, "13S_mlpl");     // Catch: Throwable -> L28
        return;
    L17:
        if (r11.length() <= 0) goto L21;
        if (r8 == null) goto L21;
        fc.a(r9, "13S_mlpl", fx.b(r11.toString()));     // Catch: Throwable -> L28
        G = a(r8, r11);     // Catch: Throwable -> L28
        return;
    L39:
        return;
    L7:
        th = move-exception;
        ev.a(th, "AuthUtil", "requestSdkAuthInterval");     // Catch: Throwable -> L23
        goto L9
    L38:
        return;
    L23:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadConfigAbleStatus");
    }

    private static void a(fn.b r9, SharedPreferences.Editor r10) {
        SharedPreferences.Editor r11 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r10, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        fn.b.a r12 = r9.g;     // Catch: Throwable -> L17
        if (r12 == null) goto L22;
        boolean r0 = r12.f5563a;     // Catch: Throwable -> L17
        j = r0;     // Catch: Throwable -> L17
        fc.a(r11, CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r0);     // Catch: Throwable -> L17
        JSONObject r13 = r12.c;     // Catch: Throwable -> L17
        if (r13 == null) goto L15;
        k = r13.optInt("fn", k);     // Catch: Throwable -> L17
        int r6 = r13.optInt("mpn", l);     // Catch: Throwable -> L17
        l = r6;     // Catch: Throwable -> L17
        if (r6 <= 500) goto L12;
        l = 500;     // Catch: Throwable -> L17
    L12:
        if (l >= 30) goto L14;
        l = 30;     // Catch: Throwable -> L17
    L14:
        m = fn.a(r13.optString("igu"), false);     // Catch: Throwable -> L17
        n = r13.optInt("ms", n);     // Catch: Throwable -> L17
        p = r13.optInt("rot", 0);     // Catch: Throwable -> L17
        o = r13.optInt("pms", 0);     // Catch: Throwable -> L17
    L15:
        av.a(k, m, n, o);     // Catch: Throwable -> L17
        ax.a(m, o);     // Catch: Throwable -> L17
        fc.a(r11, "fn", k);     // Catch: Throwable -> L17
        fc.a(r11, "mpn", l);     // Catch: Throwable -> L17
        fc.a(r11, "igu", m);     // Catch: Throwable -> L17
        fc.a(r11, "ms", n);     // Catch: Throwable -> L17
        fc.a(r11, "rot", p);     // Catch: Throwable -> L17
        fc.a(r11, "pms", o);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    L17:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadConfigDataUploadException");
    }

    private static void a(JSONObject r7, SharedPreferences.Editor r8) {
        SharedPreferences.Editor r9 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r8, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        JSONObject r10 = r7.optJSONObject("11G");     // Catch: Throwable -> L10
        if (r10 == null) goto L15;
        boolean r0 = fn.a(r10.optString("able"), true);     // Catch: Throwable -> L10
        x = r0;     // Catch: Throwable -> L10
        if (r0 == false) goto L8;
        y = r10.optInt("c", 300) * 1000;     // Catch: Throwable -> L10
    L8:
        z = fn.a(r10.optString("fa"), false);     // Catch: Throwable -> L10
        A = Math.min(1.0d, Math.max(0.2d, r10.optDouble("ms", 0.618d)));     // Catch: Throwable -> L10
        fc.a(r9, "ca", x);     // Catch: Throwable -> L10
        fc.a(r9, "ct", y);     // Catch: Throwable -> L10
        fc.a(r9, "11G_fa", z);     // Catch: Throwable -> L10
        fc.a(r9, "11G_ms", String.valueOf(A));     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadConfigDataCacheAble");
    }

    public static boolean a() {
        return j;
    }

    public static boolean a(long r6) {
        if (x == true) goto L5;
        return false;
    L5:
        long r2 = fd.a() - r6;
        long r7 = y;
        if (r7 >= 0) goto L8;
        return true;
    L8:
        if (r2 < r7) goto L13;
        return false;
    L13:
        return true;
    }

    static boolean a(Context r2, fn.b r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences.Editor r0 = fc.a(r4, "pref");     // Catch: Throwable -> L14
        a(r3, r0);     // Catch: Throwable -> L21
        c(r4);     // Catch: Throwable -> L21
        JSONObject r5 = r3.f;     // Catch: Throwable -> L21
        if (r5 != null) goto L10;
        if (r0 != null) goto L23;
    L9:
        return true;
    L23:
        fc.a(r0);     // Catch: Throwable -> L19
        goto L9
    L10:
        a(r4, r5, r0);     // Catch: Throwable -> L21
        a(r5, r0);     // Catch: Throwable -> L21
        d(r5, r0);     // Catch: Throwable -> L21
        f(r5, r0);     // Catch: Throwable -> L21
        h(r5, r0);     // Catch: Throwable -> L21
        g(r5, r0);     // Catch: Throwable -> L21
        i(r5, r0);     // Catch: Throwable -> L21
        b(r5, r0);     // Catch: Throwable -> L21
        c(r5, r0);     // Catch: Throwable -> L21
        if (r0 != null) goto L25;
    L13:
        return true;
    L25:
        fc.a(r0);     // Catch: Throwable -> L20
    L15:
        if (r0 == null) goto L33;
        fc.a(r0);     // Catch: Throwable -> L22
        return false;
    L34:
        return false;
    L33:
        return false;
    L14:
        r0 = null;
        goto L15
    }

    private static boolean a(Context r3, JSONArray r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L17;
    L15:
        return false;
    L17:
        if (r4.length() <= 0) goto L15;
        if (r5 == null) goto L15;
        int r1 = 0;
    L9:
        if (r1 >= r4.length()) goto L15;
        if (fd.b(r5, r4.getString(r1)) == true) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return true;
    }

    public static int b() {
        return l;
    }

    public static void b(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (w == false) goto L5;
        return;
    L5:
        w = true;
        j = fc.a(r9, "pref", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, j);     // Catch: Throwable -> L8
        c(r9);     // Catch: Throwable -> L8
    L10:
        int r3 = 0;
        k = fc.a(r9, "pref", "fn", k);     // Catch: Throwable -> L13
        l = fc.a(r9, "pref", "mpn", l);     // Catch: Throwable -> L13
        m = fc.a(r9, "pref", "igu", m);     // Catch: Throwable -> L13
        n = fc.a(r9, "pref", "ms", n);     // Catch: Throwable -> L13
        p = fc.a(r9, "pref", "rot", 0);     // Catch: Throwable -> L13
        int r4 = fc.a(r9, "pref", "pms", 0);     // Catch: Throwable -> L13
        o = r4;     // Catch: Throwable -> L13
        av.a(k, m, n, r4);     // Catch: Throwable -> L13
        ax.a(m, o);     // Catch: Throwable -> L13
    L89:
        x = fc.a(r9, "pref", "ca", x);     // Catch: Throwable -> L17
        y = fc.a(r9, "pref", "ct", y);     // Catch: Throwable -> L17
        z = fc.a(r9, "pref", "11G_fa", z);     // Catch: Throwable -> L17
        double r5 = Double.valueOf(fc.a(r9, "pref", "11G_ms", String.valueOf(A))).doubleValue();     // Catch: Throwable -> L17
        A = r5;     // Catch: Throwable -> L17
        A = Math.max(0.2d, r5);     // Catch: Throwable -> L17
    L91:
        c = fc.a(r9, "pref", "fr", c);     // Catch: Throwable -> L21
    L93:
        H = fc.a(r9, "pref", "asw", H);     // Catch: Throwable -> L25
    L95:
        I = fc.a(r9, "pref", "awsi", I);     // Catch: Throwable -> L29
    L75:
        f5510J = fc.a(r9, "pref", "15ua", f5510J);     // Catch: Throwable -> L33
        K = fc.a(r9, "pref", "15un", K);     // Catch: Throwable -> L33
        P = fc.a(r9, "pref", "15ust", P);     // Catch: Throwable -> L33
    L83:
        L = fc.a(r9, "pref", "ok9", L);     // Catch: Throwable -> L37
        M = fc.a(r9, "pref", "ok10", M);     // Catch: Throwable -> L37
        O = fc.a(r9, "pref", "ok11", O);     // Catch: Throwable -> L37
    L87:
        d = fc.a(r9, "pref", "17ya", false);     // Catch: Throwable -> L41
        e = fc.a(r9, "pref", "17ym", false);     // Catch: Throwable -> L41
        g = ((fc.a(r9, "pref", "17yi", 2) * 60) * 60) * 1000;     // Catch: Throwable -> L41
        f = fc.a(r9, "pref", "17yx", 100) * 1024;     // Catch: Throwable -> L41
    L85:
        f5512b = fd.b();     // Catch: Throwable -> L45
        f5511a = fc.a(r9, "pref", "13S_at", f5511a);     // Catch: Throwable -> L45
        F = fc.a(r9, "pref", "13S_nla", F);     // Catch: Throwable -> L45
        B = fc.a(r9, "pref", "13J_able", B);     // Catch: Throwable -> L45
        C = fc.a(r9, "pref", "13J_c", C);     // Catch: Throwable -> L45
        D = fc.a(r9, "pref", "13J_t", D);     // Catch: Throwable -> L45
    L47:
        fn.b(r9);
        String r6 = fc.a(r9, "pref", "13S_mlpl", null);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r6) == true) goto L73;
        G = a(r9, new JSONArray(fx.c(r6)));     // Catch: Throwable -> L52
    L73:
        boolean r7 = fc.a(r9, "pref", "197a", false);     // Catch: Throwable -> L64
        String r10 = fc.a(r9, "pref", "197dv", "");     // Catch: Throwable -> L64
        String r0 = fc.a(r9, "pref", "197tv", "");     // Catch: Throwable -> L64
        if (r7 == true) goto L57;
    L77:
        h = fc.a(r9, "pref", "1A6", h);     // Catch: Throwable -> L68
        return;
    L68:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadSdkEnableConfig p13");
        return;
    L57:
        if (ev.f5514a.equals(r10) == false) goto L77;
        String[] r11 = ev.f5515b;     // Catch: Throwable -> L64
        int r12 = r11.length;     // Catch: Throwable -> L64
    L59:
        if (r3 >= r12) goto L77;
        if (r11[r3].equals(r0) == false) goto L63;
        ev.f5514a = r0;     // Catch: Throwable -> L64
    L63:
        r3 = r3 + 1;
    L64:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p12");
    L52:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p11");
    L45:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p10");
    L41:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p9");
    L37:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p8");
    L33:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p7");
    L29:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p6");
    L25:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p5");
    L21:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p4");
    L17:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p3");
    L13:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p2");
    L8:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadLastAbleState p1");
        goto L10
    }

    private static void b(JSONObject r4, SharedPreferences.Editor r5) {
        SharedPreferences.Editor r6 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r5, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
        return;
    L15:
        JSONObject r7 = r4.getJSONObject("197");     // Catch: Throwable -> L14
        if (r7 == null) goto L16;
        boolean r0 = fn.a(r7.optString("able"), false);     // Catch: Throwable -> L14
        fc.a(r6, "197a", r0);     // Catch: Throwable -> L14
        if (r0 == false) goto L12;
        fc.a(r6, "197dv", r7.optString("sv", ""));     // Catch: Throwable -> L14
        fc.a(r6, "197tv", r7.optString(com.tom_roush.pdfbox.pdmodel.a.d.f.e, ""));     // Catch: Throwable -> L14
        return;
    L12:
        fc.a(r6, "197dv", "");     // Catch: Throwable -> L14
        fc.a(r6, "197tv", "");     // Catch: Throwable -> L14
        return;
    L16:
        return;
    }

    public static int c() {
        if (p >= 0) goto L6;
        p = 0;
    L6:
        return p;
    }

    public static void c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        fw r0 = ev.c();     // Catch: Throwable -> L5
        r0.a(j);     // Catch: Throwable -> L5
        q.a(r3, r0);     // Catch: Throwable -> L5
        return;
    }

    private static void c(JSONObject r3, SharedPreferences.Editor r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r4, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        JSONObject r6 = r3.getJSONObject("1A6");     // Catch: Throwable -> L9
        if (r6 == null) goto L12;
        boolean r7 = fn.a(r6.optString("ic"), false);     // Catch: Throwable -> L9
        fc.a(r5, "1A6", r7);     // Catch: Throwable -> L9
        h = r7;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static long d() {
        return y;
    }

    private static void d(JSONObject r2, SharedPreferences.Editor r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        JSONObject r5 = r2.optJSONObject("13J");     // Catch: Throwable -> L10
        if (r5 == null) goto L15;
        boolean r0 = fn.a(r5.optString("able"), true);     // Catch: Throwable -> L10
        B = r0;     // Catch: Throwable -> L10
        if (r0 == false) goto L8;
        C = r5.optInt("c", C);     // Catch: Throwable -> L10
        D = r5.optInt("t", D);     // Catch: Throwable -> L10
    L8:
        fc.a(r4, "13J_able", B);     // Catch: Throwable -> L10
        fc.a(r4, "13J_c", C);     // Catch: Throwable -> L10
        fc.a(r4, "13J_t", D);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        ev.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
    }

    private static void e(JSONObject r2, SharedPreferences.Editor r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        return;
    L10:
        boolean r5 = fn.a(r2.optString("re"), false);     // Catch: Throwable -> L7
        c = r5;     // Catch: Throwable -> L7
        fc.a(r4, "fr", r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ev.a(th, "AuthUtil", "checkReLocationAble");
    }

    public static boolean e() {
        return x;
    }

    private static void f(JSONObject r2, SharedPreferences.Editor r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        JSONObject r5 = r2.optJSONObject("15O");     // Catch: Throwable -> L17
        if (r5 != null) goto L6;
        return;
    L6:
        if (fn.a(r5.optString("able"), false) == false) goto L14;
        JSONArray r0 = r5.optJSONArray("fl");     // Catch: Throwable -> L17
        if (r0 != null) goto L10;
    L13:
        I = r5.optInt("iv", 30) * 1000;     // Catch: Throwable -> L17
    L15:
        fc.a(r4, "awsi", I);     // Catch: Throwable -> L17
        return;
    L10:
        if (r0.length() <= 0) goto L13;
        if (r0.toString().contains(Build.MANUFACTURER) == true) goto L13;
    L14:
        I = -1;     // Catch: Throwable -> L17
    }

    public static boolean f() {
        return z;
    }

    public static double g() {
        return A;
    }

    private static void g(JSONObject r3, SharedPreferences.Editor r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r4, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L15;
        return;
    L15:
        JSONObject r6 = r3.getJSONObject("17Y");     // Catch: Throwable -> L14
        if (r6 == null) goto L17;
        boolean r0 = fn.a(r6.optString("able"), false);     // Catch: Throwable -> L14
        d = r0;     // Catch: Throwable -> L14
        fc.a(r5, "17ya", r0);     // Catch: Throwable -> L14
        boolean r1 = fn.a(r6.optString("mup"), false);     // Catch: Throwable -> L14
        e = r1;     // Catch: Throwable -> L14
        fc.a(r5, "17ym", r1);     // Catch: Throwable -> L14
        int r2 = r6.optInt("max", 20);     // Catch: Throwable -> L14
        if (r2 <= 0) goto L10;
        fc.a(r5, "17yx", r2);     // Catch: Throwable -> L14
        f = r2 * 1024;     // Catch: Throwable -> L14
    L10:
        int r7 = r6.optInt("inv", 3);     // Catch: Throwable -> L14
        if (r7 <= 0) goto L18;
        fc.a(r5, "17yi", r7);     // Catch: Throwable -> L14
        g = ((r7 * 60) * 60) * 1000;     // Catch: Throwable -> L14
        return;
    L18:
        return;
    L17:
        return;
    }

    private static void h(JSONObject r5, SharedPreferences.Editor r6) {
        SharedPreferences.Editor r7 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        JSONObject r8 = r5.optJSONObject("15U");     // Catch: Throwable -> L7
        if (r8 == null) goto L10;
        boolean r0 = fn.a(r8.optString("able"), true);     // Catch: Throwable -> L7
        int r1 = r8.optInt("yn", K);     // Catch: Throwable -> L7
        P = r8.optLong("sysTime", P);     // Catch: Throwable -> L7
        fc.a(r7, "15ua", r0);     // Catch: Throwable -> L7
        fc.a(r7, "15un", r1);     // Catch: Throwable -> L7
        fc.a(r7, "15ust", P);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    private static void i(JSONObject r4, SharedPreferences.Editor r5) {
        SharedPreferences.Editor r6 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r5, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
        return;
    L18:
        JSONObject r7 = r4.optJSONObject("17J");     // Catch: Throwable -> L17
        if (r7 == null) goto L20;
        boolean r0 = fn.a(r7.optString("able"), false);     // Catch: Throwable -> L17
        L = r0;     // Catch: Throwable -> L17
        fc.a(r6, "ok9", r0);     // Catch: Throwable -> L17
        if (r0 == false) goto L21;
        String r1 = r7.optString("auth");     // Catch: Throwable -> L17
        String r2 = r7.optString("ht");     // Catch: Throwable -> L17
        O = r2;     // Catch: Throwable -> L17
        fc.a(r6, "ok11", r2);     // Catch: Throwable -> L17
        fn.a(r1, false);     // Catch: Throwable -> L17
        N = fn.a(r7.optString(LocationInfoConst.NR), false);     // Catch: Throwable -> L17
        String r8 = r7.optString("tm");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r8) == true) goto L22;
        int r9 = Integer.parseInt(r8);     // Catch: Throwable -> L17
        if (r9 > 0) goto L14;
        return;
    L14:
        if (r9 >= 20) goto L24;
        M = r9;     // Catch: Throwable -> L17
        fc.a(r6, "ok10", r9);     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return L;
    }

    public static String r() {
        return fx.c(O);
    }

    public static boolean s() {
        if (f5510J == true) goto L5;
        return false;
    L5:
        if (K <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }
}
