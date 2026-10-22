package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import n4a.c4;
import n4a.e5;
import n4a.f5;
import n4a.i4;
import n4a.n;
import n4a.q0;
import n4a.r;
import n4a.s0;
import n4a.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static boolean A = false;
    public static String B = null;
    public static long C = 0;
    public static boolean D = false;
    public static int E = 0;
    public static int F = 0;
    public static boolean G = false;
    public static volatile boolean a = false;
    public static boolean b = true;
    public static int c = 1000;
    public static int d = 200;
    public static boolean e = false;
    public static int f = 20;
    public static int g;
    public static volatile int h;
    public static volatile boolean i;
    public static boolean j;
    public static long k;
    public static boolean l;
    public static double m;
    public static boolean n;
    public static int o;
    public static int p;
    public static long q;
    public static boolean r;
    public static boolean s;
    public static boolean t;
    public static boolean u;
    public static long v;
    public static boolean w;
    public static int x;
    public static boolean y;
    public static int z;

    public static class a implements i.b {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }
    }

    static {
        new ArrayList();
        new ArrayList();
        i = false;
        j = true;
        k = 300000;
        l = false;
        m = 0.618d;
        n = true;
        o = 80;
        p = 5;
        q = 3600000;
        r = true;
        s = false;
        t = false;
        u = true;
        v = -1;
        w = true;
        x = 1;
        y = false;
        z = 5;
        A = false;
        B = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        C = 0;
        D = false;
        E = 20480;
        F = 10800000;
        G = false;
    }

    public static void d(JSONObject r4, SharedPreferences.Editor r5) {
        JSONObject r6 = r4.optJSONObject("11G");     // Catch: Throwable -> L9
        if (r6 == null) goto L14;
        boolean r0 = i.o(r6.optString("able"), true);     // Catch: Throwable -> L9
        j = r0;     // Catch: Throwable -> L9
        if (r0 == false) goto L7;
        k = r6.optInt("c", 300) * 1000;     // Catch: Throwable -> L9
    L7:
        l = i.o(r6.optString("fa"), false);     // Catch: Throwable -> L9
        m = Math.min(1.0d, Math.max(0.2d, r6.optDouble("ms", 0.618d)));     // Catch: Throwable -> L9
        i4.i(r5, "ca", j);     // Catch: Throwable -> L9
        i4.g(r5, "ct", k);     // Catch: Throwable -> L9
        i4.i(r5, "11G_fa", l);     // Catch: Throwable -> L9
        i4.h(r5, "11G_ms", String.valueOf(m));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataCacheAble");
    }

    public static void h(JSONObject r4, SharedPreferences.Editor r5) {
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r4, "197");     // Catch: Throwable -> L11
        if (r6 == null) goto L13;
        boolean r0 = i.o(r6.optString("able"), false);     // Catch: Throwable -> L11
        i4.i(r5, "197a", r0);     // Catch: Throwable -> L11
        if (r0 == false) goto L9;
        i4.h(r5, "197dv", r6.optString("sv", NameKeys.UnloadStrategy_No_Strategy));     // Catch: Throwable -> L11
        i4.h(r5, "197tv", r6.optString("tv", NameKeys.UnloadStrategy_No_Strategy));     // Catch: Throwable -> L11
        return;
    L9:
        i4.h(r5, "197dv", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L11
        i4.h(r5, "197tv", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L11
        return;
    L13:
        return;
    }

    public static void i(JSONObject r2, SharedPreferences.Editor r3) {
        JSONObject r4 = r2.optJSONObject("13J");     // Catch: Throwable -> L9
        if (r4 == null) goto L14;
        boolean r0 = i.o(r4.optString("able"), true);     // Catch: Throwable -> L9
        n = r0;     // Catch: Throwable -> L9
        if (r0 == false) goto L7;
        o = r4.optInt("c", o);     // Catch: Throwable -> L9
        p = r4.optInt("t", p);     // Catch: Throwable -> L9
    L7:
        i4.i(r3, "13J_able", n);     // Catch: Throwable -> L9
        i4.f(r3, "13J_c", o);     // Catch: Throwable -> L9
        i4.f(r3, "13J_t", p);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataGpsGeoAble");
    }

    public static void j(JSONObject r2, SharedPreferences.Editor r3) {
        JSONObject r4 = r2.optJSONObject("15O");     // Catch: Throwable -> L16
        if (r4 != null) goto L5;
        return;
    L5:
        if (i.o(r4.optString("able"), false) == false) goto L13;
        JSONArray r0 = r4.optJSONArray("fl");     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
    L12:
        v = r4.optInt("iv", 30) * 1000;     // Catch: Throwable -> L16
    L14:
        i4.g(r3, "awsi", v);     // Catch: Throwable -> L16
        return;
    L9:
        if (r0.length() <= 0) goto L12;
        if (r0.toString().contains(Build.MANUFACTURER) == true) goto L12;
    L13:
        v = -1;     // Catch: Throwable -> L16
    }

    public static void k(JSONObject r3, SharedPreferences.Editor r4) {
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r3, "17Y");     // Catch: Throwable -> L11
        if (r5 == null) goto L14;
        i4.i(r4, "17ya", i.o(r5.optString("able"), false));     // Catch: Throwable -> L11
        boolean r0 = i.o(r5.optString("mup"), false);     // Catch: Throwable -> L11
        D = r0;     // Catch: Throwable -> L11
        i4.i(r4, "17ym", r0);     // Catch: Throwable -> L11
        int r1 = r5.optInt("max", 20);     // Catch: Throwable -> L11
        if (r1 <= 0) goto L7;
        i4.f(r4, "17yx", r1);     // Catch: Throwable -> L11
        E = r1 * 1024;     // Catch: Throwable -> L11
    L7:
        int r6 = r5.optInt("inv", 3);     // Catch: Throwable -> L11
        if (r6 <= 0) goto L15;
        i4.f(r4, "17yi", r6);     // Catch: Throwable -> L11
        F = ((r6 * 60) * 60) * 1000;     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void l(JSONObject r5, SharedPreferences.Editor r6) {
        JSONObject r7 = r5.optJSONObject("15U");     // Catch: Throwable -> L6
        if (r7 == null) goto L9;
        boolean r0 = i.o(r7.optString("able"), true);     // Catch: Throwable -> L6
        int r1 = r7.optInt("yn", x);     // Catch: Throwable -> L6
        C = r7.optLong("sysTime", C);     // Catch: Throwable -> L6
        i4.i(r6, "15ua", r0);     // Catch: Throwable -> L6
        i4.f(r6, "15un", r1);     // Catch: Throwable -> L6
        i4.g(r6, "15ust", C);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void m(JSONObject r4, SharedPreferences.Editor r5) {
        JSONObject r6 = r4.optJSONObject("17J");     // Catch: Throwable -> L14
        if (r6 == null) goto L17;
        boolean r0 = i.o(r6.optString("able"), false);     // Catch: Throwable -> L14
        y = r0;     // Catch: Throwable -> L14
        i4.i(r5, "ok9", r0);     // Catch: Throwable -> L14
        if (r0 == false) goto L18;
        String r1 = r6.optString("auth");     // Catch: Throwable -> L14
        String r2 = r6.optString("ht");     // Catch: Throwable -> L14
        B = r2;     // Catch: Throwable -> L14
        i4.h(r5, "ok11", r2);     // Catch: Throwable -> L14
        i.o(r1, false);     // Catch: Throwable -> L14
        A = i.o(r6.optString("nr"), false);     // Catch: Throwable -> L14
        String r7 = r6.optString("tm");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r7) == true) goto L19;
        int r8 = CastIntegerProtector.parseInt(r7);     // Catch: Throwable -> L14
        if (r8 > 0) goto L11;
        return;
    L11:
        if (r8 >= 20) goto L21;
        z = r8;     // Catch: Throwable -> L14
        i4.f(r5, "ok10", r8);     // Catch: Throwable -> L14
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

    public static void a(Context r8) {
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        e5 r1 = c4.k();
        a r3 = new a(r8);
        int r4 = i.a;
        monitor-enter(i.class);
        if (r8 == null) goto L46;
        if (r1 == null) goto L46;
    L40:
        th = move-exception;
        n.a(th, "at", "rglc");     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L11:
        if (i.c != null) goto L13;
        i.c = r8.getApplicationContext();     // Catch: Throwable -> L40
    L13:
        String r9 = r1.a();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r9) == true) goto L46;
        i.j(r1);     // Catch: Throwable -> L40
        if (i.l != null) goto L20;
        i.l = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L20:
        if (i.k != null) goto L23;
        i.k = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L23:
        if (i.j != null) goto L26;
        i.j = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L26:
        if (i.l.containsKey(r9) == true) goto L46;
        i.e r5 = new i.e();     // Catch: Throwable -> L40
        r5.a = r1;     // Catch: Throwable -> L40
        r5.b = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";     // Catch: Throwable -> L40
        r5.c = r3;     // Catch: Throwable -> L40
        i.l.put(r9, r5);     // Catch: Throwable -> L40
        long r6 = 0;
        r6 = i.c.getSharedPreferences("open_common", 0).getLong(r9, 0);     // Catch: Throwable -> L31
    L33:
        i.j.put(r9, new i.h(Long.valueOf(r6), y.k(i.c, "open_common", r9 + "lct-info")));     // Catch: Throwable -> L40
        Context r10 = i.c;     // Catch: Throwable -> L40
        if (i.m == true) goto L38;
        n4a.c.b = y.i(r10, "a4", true);     // Catch: Throwable -> L48
        n4a.c.c = y.i(r10, "a5", true);     // Catch: Throwable -> L48
        i.m = true;     // Catch: Throwable -> L48
    L38:
        i.y(i.c);     // Catch: Throwable -> L40
        goto L46
    L31:
        th = move-exception;
        r.f(th, "csp", "glv");     // Catch: Throwable -> L40
    L46:
        monitor-exit(i.class);
    }

    public static boolean e(long r6) {
        if (j == true) goto L5;
        return false;
    L5:
        long r2 = System.currentTimeMillis() - r6;
        long r7 = k;
        if (r7 >= 0) goto L8;
        return true;
    L8:
        if (r2 < r7) goto L13;
        return false;
    L13:
        return true;
    }

    public static void g(Context r9) {
        if (i == false) goto L5;
        return;
    L5:
        i = true;
        b = i4.j(r9, "exception", b);     // Catch: Throwable -> L9
        e5 r4 = c4.k();     // Catch: Throwable -> L81
        r4.c = b ? 1 : 0;     // Catch: Throwable -> L81
        r.b(r9, r4);     // Catch: Throwable -> L81
    L11:
        int r5 = 0;
        c = i4.a(r9, "fn", c);     // Catch: Throwable -> L20
        d = i4.a(r9, "mpn", d);     // Catch: Throwable -> L20
        e = i4.j(r9, "igu", e);     // Catch: Throwable -> L20
        f = i4.a(r9, "ms", f);     // Catch: Throwable -> L20
        h = i4.a(r9, "rot", 0);     // Catch: Throwable -> L20
        int r6 = i4.a(r9, "pms", 0);     // Catch: Throwable -> L20
        g = r6;     // Catch: Throwable -> L20
        q0.a(c, e, f, r6);     // Catch: Throwable -> L20
        boolean r7 = e;     // Catch: Throwable -> L20
        int r8 = g;     // Catch: Throwable -> L20
        monitor-enter(s0.class);     // Catch: Throwable -> L20
        s0.a = r7;     // Catch: Throwable -> L17
        s0.b = Math.max(0, r8);     // Catch: Throwable -> L17
        monitor-exit(s0.class);     // Catch: Throwable -> L20
    L89:
        j = i4.j(r9, "ca", j);     // Catch: Throwable -> L24
        k = i4.b(r9, "pref", "ct", k);     // Catch: Throwable -> L24
        l = i4.j(r9, "11G_fa", l);     // Catch: Throwable -> L24
        double r10 = CastDoubleProtector.valueOf(i4.d(r9, "pref", "11G_ms", String.valueOf(m))).doubleValue();     // Catch: Throwable -> L24
        m = r10;     // Catch: Throwable -> L24
        m = Math.max(0.2d, r10);     // Catch: Throwable -> L24
    L101:
        t = i4.j(r9, "fr", t);     // Catch: Throwable -> L28
    L91:
        u = i4.j(r9, "asw", u);     // Catch: Throwable -> L32
    L103:
        v = i4.b(r9, "pref", "awsi", v);     // Catch: Throwable -> L36
    L109:
        w = i4.j(r9, "15ua", w);     // Catch: Throwable -> L40
        x = i4.a(r9, "15un", x);     // Catch: Throwable -> L40
        C = i4.b(r9, "pref", "15ust", C);     // Catch: Throwable -> L40
    L85:
        y = i4.j(r9, "ok9", y);     // Catch: Throwable -> L44
        z = i4.a(r9, "ok10", z);     // Catch: Throwable -> L44
        B = i4.d(r9, "pref", "ok11", B);     // Catch: Throwable -> L44
    L99:
        i4.j(r9, "17ya", false);     // Catch: Throwable -> L48
        D = i4.j(r9, "17ym", false);     // Catch: Throwable -> L48
        F = ((i4.a(r9, "17yi", 2) * 60) * 60) * 1000;     // Catch: Throwable -> L48
        E = i4.a(r9, "17yx", 100) * 1024;     // Catch: Throwable -> L48
    L95:
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L52
        q = i4.b(r9, "pref", "13S_at", q);     // Catch: Throwable -> L52
        r = i4.j(r9, "13S_nla", r);     // Catch: Throwable -> L52
        n = i4.j(r9, "13J_able", n);     // Catch: Throwable -> L52
        o = i4.a(r9, "13J_c", o);     // Catch: Throwable -> L52
        p = i4.a(r9, "13J_t", p);     // Catch: Throwable -> L52
    L54:
        int r11 = i.a;
        if (r9 == null) goto L107;
        i.d = y.i(r9, "a2", true);
    L107:
        String r3 = i4.d(r9, "pref", "13S_mlpl", null);     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r3) == true) goto L97;
        s = f(r9, new JSONArray(f5.o(r3)));     // Catch: Throwable -> L62
    L97:
        boolean r12 = i4.j(r9, "197a", false);     // Catch: Throwable -> L74
        String r13 = i4.d(r9, "pref", "197dv", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L74
        String r0 = i4.d(r9, "pref", "197tv", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L74
        if (r12 == true) goto L67;
    L83:
        G = i4.j(r9, "1A6", G);     // Catch: Throwable -> L78
        return;
    L78:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadSdkEnableConfig p13");
        return;
    L67:
        if (c4.a.equals(r13) == false) goto L83;
        String[] r2 = c4.b;     // Catch: Throwable -> L74
        int r14 = r2.length;     // Catch: Throwable -> L74
    L69:
        if (r5 >= r14) goto L83;
        if (r2[r5].equals(r0) == false) goto L73;
        c4.a = r0;     // Catch: Throwable -> L74
    L73:
        r5 = r5 + 1;
    L74:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p12");
    L62:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p11");
    L52:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p10");
    L48:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p9");
    L44:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p8");
    L40:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p7");
    L36:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p6");
    L32:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p5");
    L28:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p4");
    L24:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p3");
        goto L101
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p2");
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p1");
        goto L11
    }

    public static void c(i.c r10, SharedPreferences.Editor r11) {
        i.c.a r12 = r10.c;     // Catch: Throwable -> L23
        if (r12 == null) goto L22;
        boolean r0 = r12.a;     // Catch: Throwable -> L23
        b = r0;     // Catch: Throwable -> L23
        i4.i(r11, "exception", r0);     // Catch: Throwable -> L23
        JSONObject r13 = r12.b;     // Catch: Throwable -> L23
        if (r13 == null) goto L14;
        c = r13.optInt("fn", c);     // Catch: Throwable -> L23
        int r7 = r13.optInt("mpn", d);     // Catch: Throwable -> L23
        d = r7;     // Catch: Throwable -> L23
        if (r7 <= 500) goto L11;
        d = 500;     // Catch: Throwable -> L23
    L11:
        if (d >= 30) goto L13;
        d = 30;     // Catch: Throwable -> L23
    L13:
        e = i.o(r13.optString("igu"), false);     // Catch: Throwable -> L23
        f = r13.optInt("ms", f);     // Catch: Throwable -> L23
        h = r13.optInt("rot", 0);     // Catch: Throwable -> L23
        g = r13.optInt("pms", 0);     // Catch: Throwable -> L23
    L14:
        q0.a(c, e, f, g);     // Catch: Throwable -> L23
        boolean r14 = e;     // Catch: Throwable -> L23
        int r8 = g;     // Catch: Throwable -> L23
        monitor-enter(s0.class);     // Catch: Throwable -> L23
        s0.a = r14;     // Catch: Throwable -> L19
        s0.b = Math.max(0, r8);     // Catch: Throwable -> L19
        monitor-exit(s0.class);     // Catch: Throwable -> L23
        i4.f(r11, "fn", c);     // Catch: Throwable -> L23
        i4.f(r11, "mpn", d);     // Catch: Throwable -> L23
        i4.i(r11, "igu", e);     // Catch: Throwable -> L23
        i4.f(r11, "ms", f);     // Catch: Throwable -> L23
        i4.f(r11, "rot", h);     // Catch: Throwable -> L23
        i4.f(r11, "pms", g);     // Catch: Throwable -> L23
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L22:
        return;
    L23:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataUploadException");
    }

    public static boolean f(Context r5, JSONArray r6) {
        if (r6.length() <= 0) goto L21;
        if (r5 == null) goto L21;
        int r1 = 0;
    L8:
        if (r1 >= r6.length()) goto L21;
        String r2 = JSONArrayProtectorUtils.getString(r6, r1);     // Catch: Throwable -> L22
        PackageInfo r3 = r5.getApplicationContext().getPackageManager().getPackageInfo(r2, 256);     // Catch: Throwable -> L13
    L15:
        if (r3 == null) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L19;
        r1 = r1 + 1;
        goto L8
    L19:
        return true;
    L17:
        r4 = false;
    L13:
        r3 = null;
    L21:
        return false;
    }

    public static void b(Context r5, JSONObject r6, SharedPreferences.Editor r7) {
        JSONObject r8 = r6.optJSONObject("13S");     // Catch: Throwable -> L30
        if (r8 == null) goto L48;
        long r2 = (r8.optInt("at", 123) * 60) * 1000;     // Catch: Throwable -> L7
        q = r2;     // Catch: Throwable -> L7
        i4.g(r7, "13S_at", r2);     // Catch: Throwable -> L7
    L43:
        boolean r3 = i.o(r8.optString("re"), false);     // Catch: Throwable -> L12
        t = r3;     // Catch: Throwable -> L12
        i4.i(r7, "fr", r3);     // Catch: Throwable -> L12
    L39:
        boolean r4 = i.o(r8.optString("nla"), true);     // Catch: Throwable -> L33
        r = r4;     // Catch: Throwable -> L33
        i4.i(r7, "13S_nla", r4);     // Catch: Throwable -> L33
    L46:
        boolean r1 = i.o(r8.optString("asw"), true);     // Catch: Throwable -> L34
        u = r1;     // Catch: Throwable -> L34
        i4.i(r7, "asw", r1);     // Catch: Throwable -> L34
    L45:
        JSONArray r9 = r8.optJSONArray("mlpl");     // Catch: Throwable -> L35
        if (r9 != null) goto L21;
    L24:
        s = false;     // Catch: Throwable -> L35
        r7.remove("13S_mlpl");     // Catch: Throwable -> L27
        goto L50
    L49:
        return;
    L27:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsLong");     // Catch: Throwable -> L35
        return;
    L21:
        if (r9.length() <= 0) goto L24;
        i4.h(r7, "13S_mlpl", f5.k(r9.toString()));     // Catch: Throwable -> L35
        s = f(r5, r9);     // Catch: Throwable -> L35
        return;
    L50:
        return;
    L12:
        th = move-exception;
        c4.g(th, "AuthUtil", "checkReLocationAble");     // Catch: Throwable -> L30
    L7:
        th = move-exception;
        c4.g(th, "AuthUtil", "requestSdkAuthInterval");     // Catch: Throwable -> L30
        goto L43
    L48:
        return;
    L30:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigAbleStatus");
    }
}
