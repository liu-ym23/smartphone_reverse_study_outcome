package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fn {
    private static ConcurrentHashMap<String, Boolean> A = null;
    private static ConcurrentHashMap<String, Boolean> B = null;
    private static ArrayList<ao.a> C = null;
    private static volatile boolean D = false;
    private static Queue<ao.c> E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5557a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5558b = "";
    public static Context c = null;
    public static volatile boolean d = false;
    public static int e = 0;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    private static String k = "6";
    private static String l = "4";
    private static String m = "9";
    private static String n = "8";
    private static volatile boolean o = true;
    private static Vector<e> p;
    private static Map<String, Integer> q;
    private static String r;
    private static long s;
    private static volatile ConcurrentHashMap<String, g> t;
    private static volatile ConcurrentHashMap<String, Long> u;
    private static volatile ConcurrentHashMap<String, d> v;
    private static boolean w;
    private static boolean x;
    private static int y;
    private static int z;

    public interface a {
        void a(b r1);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public JSONObject f5561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f5562b;
        public String c;
        public int d;
        public long e;
        public JSONObject f;
        public a g;
        public C0223b h;
        private boolean i;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f5563a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f5564b;
            public JSONObject c;

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.loc.fn$b$b, reason: collision with other inner class name */
        public static class C0223b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f5565a;

            public C0223b() {
            }
        }

        public b() {
            this.d = -1;
            this.e = 0;
        }

        static /* synthetic */ boolean a(b r0, boolean r1) {
            r0.i = r1;
            return r1;
        }
    }

    static class c extends am {
        private String h;
        private Map<String, String> i;
        private String j;
        private String k;
        private String l;

        c(Context r3, fw r4, String r5, String r6, String r7, String r8) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
            this.h = r5;
            this.i = null;
            this.j = r6;
            this.k = r7;
            this.l = r8;
            a(bo.c.f5374b);
            a(bo.a.d);
        }

        private static String a(String r1, String r2) {
            if (TextUtils.isEmpty(r2) == true) goto L9;
            return Uri.parse(r1).buildUpon().encodedAuthority(r2).build().toString();
        L9:
            return r1;
        L10:
            return r1;
        }

        @Override // com.loc.bo
        public final Map<String, String> a() {
            if (TextUtils.isEmpty(this.l) == true) goto L6;
            HashMap r0 = new HashMap();
            r0.put("host", this.l);
            return r0;
        L6:
            return null;
        }

        @Override // com.loc.bo
        public final String c() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.j);
        }

        @Override // com.loc.am
        public final String i() {
            return "3.0";
        }

        @Override // com.loc.am
        public final byte[] j() {
            return null;
        }

        @Override // com.loc.am
        public final byte[] k() {
            String r0 = fp.p(this.f5296a);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r0 = ft.a(new StringBuilder(r0).reverse().toString());
        L5:
            HashMap r1 = new HashMap();
            if (TextUtils.isEmpty(this.h) == false) goto L8;
            String r2 = "";
        L9:
            r1.put("authkey", r2);
            r1.put("plattype", "android");
            r1.put("ccver", "1");
            r1.put("product", this.f5297b.a());
            r1.put("version", this.f5297b.b());
            r1.put("output", "json");
            r1.put("androidversion", new StringBuilder().append(Build.VERSION.SDK_INT).toString());
            r1.put("deviceId", r0);
            r1.put("manufacture", Build.MANUFACTURER);
            Map<String, String> r3 = this.i;
            if (r3 != null) goto L12;
        L14:
            r1.put("abitype", fx.a(this.f5296a));
            r1.put("ext", this.f5297b.d());
            return fx.a(fx.a(r1));
        L12:
            if (r3.isEmpty() == true) goto L14;
            r1.putAll(this.i);
            goto L14
        L8:
            r2 = this.h;
            goto L9
        }

        @Override // com.loc.bo
        public final String o() {
            if (TextUtils.isEmpty(this.l) == true) goto L7;
            return this.l;
        L7:
            return super.o();
        }

        @Override // com.loc.fs, com.loc.bo
        public final String p() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.k);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        fw f5566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5567b;
        a c;

        private d() {
        }

        /* synthetic */ d(byte r1) {
            this();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5569b;
        private AtomicInteger c;

        public e(String r1, String r2, int r3) {
            this.f5568a = r1;
            this.f5569b = r2;
            this.c = new AtomicInteger(r3);
        }

        static /* synthetic */ String a(e r0) {
            return r0.f5569b;
        }

        public static e b(String r5) {
            if (TextUtils.isEmpty(r5) == false) goto L8;
            return null;
        L8:
            JSONObject r0 = new JSONObject(r5);     // Catch: Throwable -> L7
            return new e(r0.optString("a"), r0.optString(com.bytedance.apm.util.f.f1488a), r0.optInt(o.g));
        L7:
            return null;
        }

        static /* synthetic */ AtomicInteger b(e r0) {
            return r0.c;
        }

        static /* synthetic */ String c(e r0) {
            return r0.f5568a;
        }

        public final int a() {
            AtomicInteger r0 = this.c;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.get();
        }

        public final void a(String r1) {
            this.f5569b = r1;
        }

        public final String b() {
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
            r0.put("a", this.f5568a);     // Catch: Throwable -> L4
            r0.put(com.bytedance.apm.util.f.f1488a, this.f5569b);     // Catch: Throwable -> L4
            r0.put(o.g, this.c.get());     // Catch: Throwable -> L4
            return r0.toString();
        L4:
            return "";
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f5570a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f5571b = false;
        public static boolean c = true;
        public static int d = 0;
        public static boolean e = false;
        public static int f;

        static {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5573b;

        g(Long r3, String r4) {
            this.f5572a = 0;
            this.f5573b = "";
            this.f5572a = r3.longValue();
            this.f5573b = r4;
        }
    }

    static {
        p = new Vector();
        q = new HashMap();
        r = null;
        s = 0;
        d = false;
        t = new ConcurrentHashMap(8);
        u = new ConcurrentHashMap(8);
        v = new ConcurrentHashMap(8);
        w = false;
        x = false;
        e = 5000;
        f = true;
        g = false;
        y = 3;
        h = true;
        i = false;
        z = 3;
        j = false;
        A = new ConcurrentHashMap();
        B = new ConcurrentHashMap();
        C = new ArrayList();
        E = new LinkedList();
    }

    public static long a(List<String> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L5:
        if (r3.size() <= 0) goto L17;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r4) == true) goto L18;
        return Long.valueOf(r4).longValue();
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static b a(Context r6, fw r7, String r8, String r9, String r10, String r11) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    }

    private static synchronized e a(Context r7, String r8, String r9) {
        monitor-enter(fn.class);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r8) == true) goto L15;
        int r1 = 0;
    L8:
        if (r1 >= p.size()) goto L15;
        e r4 = (e) ZeusTransformUtils.preCheckCast(p.get(r1), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r4 == null) goto L14;
        if (r8.equals(e.c(r4)) == false) goto L14;
    L16:
        if (r4 == null) goto L19;
        monitor-exit(fn.class);
        return r4;
    L19:
        if (r10 != null) goto L22;
        monitor-exit(fn.class);
        return null;
    L22:
        e r11 = e.b(z.b(r10, r9, r8, ""));     // Catch: Throwable -> L31
        String r12 = fx.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L31
        if (r11 != null) goto L26;
        r11 = new e(r8, r12, 0);     // Catch: Throwable -> L31
    L26:
        if (r12.equals(e.a(r11)) == true) goto L28;
        r11.a(r12);     // Catch: Throwable -> L31
        e.b(r11).set(0);     // Catch: Throwable -> L31
    L28:
        p.add(r11);     // Catch: Throwable -> L31
        monitor-exit(fn.class);
        return r11;
    L14:
        r1 = r1 + 1;
    L15:
        r4 = null;
    L31:
        th = move-exception;
        throw th;
    }

    public static String a(String r2) {
        if (v.containsKey(r2) == false) goto L8;
        d r3 = (d) ZeusTransformUtils.preCheckCast(v.get(r2), d.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.f5567b;
    L8:
        return null;
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return;
    }

    private static void a(Context r3, fw r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put("amap_sdk_auth_fail", "1");
        r0.put("amap_sdk_auth_fail_type", r5);
        r0.put("amap_sdk_name", r4.a());
        r0.put("amap_sdk_version", r4.c());
        String r7 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r7) == false) goto L8;
        return;
    L8:
        aw r8 = new aw(r6, "core", "2.0", "O001");     // Catch: l -> L7
        r8.a(r7);     // Catch: l -> L7
        ax.a(r8, r6);     // Catch: l -> L7
        return;
    }

    public static synchronized void a(Context r4, fw r5, String r6, a r7) {
        monitor-enter(fn.class);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r8 == null) goto L33;
        if (r5 == null) goto L33;
    L29:
        th = move-exception;
        n.a(th, "at", "rglc");     // Catch: Throwable -> L35
        return;
    L9:
        if (c != null) goto L11;
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
    L11:
        String r10 = r5.a();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r10) == false) goto L15;
        monitor-exit(fn.class);
        return;
    L15:
        a(r5);     // Catch: Throwable -> L29
        if (v != null) goto L19;
        v = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L19:
        if (u != null) goto L22;
        u = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L22:
        if (t != null) goto L25;
        t = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L25:
        if (v.containsKey(r10) == true) goto L27;
        d r1 = new d(0);     // Catch: Throwable -> L29
        r1.f5566a = r5;     // Catch: Throwable -> L29
        r1.f5567b = r6;     // Catch: Throwable -> L29
        r1.c = r9;     // Catch: Throwable -> L29
        v.put(r10, r1);     // Catch: Throwable -> L29
        long r11 = z.a(c, "open_common", r10, 0);     // Catch: Throwable -> L29
        t.put(r10, new g(Long.valueOf(r11), z.b(c, "open_common", r10 + "lct-info", "")));     // Catch: Throwable -> L29
        d(c);     // Catch: Throwable -> L29
        e(c);     // Catch: Throwable -> L29
    L27:
        monitor-exit(fn.class);
        return;
    L33:
        monitor-exit(fn.class);
        return;
    L35:
        th = move-exception;
        throw th;
    }

    private static void a(Context r18, fw r19, String r20, b r21, JSONObject r22) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        b.a r10 = new b.a();
        r10.f5563a = false;
        r10.f5564b = false;
        r21.g = r10;
        String[] r0 = r20.split(";");     // Catch: Throwable -> L13
        if (r0 == null) goto L16;
        if (r0.length <= 0) goto L16;
        int r12 = r0.length;     // Catch: Throwable -> L13
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L16;
        String r14 = r0[r13];     // Catch: Throwable -> L13
        if (r22.has(r14) == false) goto L12;
        r21.f.putOpt(r14, r22.get(r14));     // Catch: Throwable -> L13
    L12:
        r13 = r13 + 1;
    L16:
        if (fx.a(r22, "16H") == false) goto L22;
        b.a(r21, a(r22.getJSONObject("16H").optString("able"), false));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 16H");
    L22:
        if (fx.a(r22, "11K") == false) goto L30;
        JSONObject r1 = r22.getJSONObject("11K");     // Catch: Throwable -> L27
        r10.f5563a = a(r1.getString("able"), false);     // Catch: Throwable -> L27
        if (r1.has(com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L30;
        r10.c = r1.getJSONObject(com.tom_roush.pdfbox.pdmodel.a.d.f.g);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 11K");
    L30:
        if (fx.a(r22, "145") == false) goto L36;
        r21.f5561a = r22.getJSONObject("145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 145");
    L36:
        if (fx.a(r22, "14D") == false) goto L42;
        r21.f5562b = r22.getJSONObject("14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 14D");
    L42:
        if (fx.a(r22, "151") == false) goto L51;
        JSONObject r2 = r22.getJSONObject("151");     // Catch: Throwable -> L48
        b.C0223b r8 = new b.C0223b();     // Catch: Throwable -> L48
        if (r2 == null) goto L46;
        r8.f5565a = a(r2.optString("able"), false);     // Catch: Throwable -> L48
    L46:
        r21.h = r8;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 151");
    L51:
        if (fx.a(r22, "17S") == true) goto L155;
    L99:
        String r16 = "ust";
        String r17 = "umv";
        String r23 = "open_common";
    L101:
        if (fx.a(r22, "15K") == true) goto L169;
    L122:
        String r3 = r23;
    L124:
        if (fx.a(r22, "183") == false) goto L130;
        an.a(r19, r22.getJSONObject("183"));     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 183");
    L130:
        if (fx.a(r22, "17I") == false) goto L136;
        JSONObject r4 = r22.getJSONObject("17I");     // Catch: Throwable -> L133
        boolean r5 = a(r4.optString("na"), false);     // Catch: Throwable -> L133
        boolean r6 = a(r4.optString("aa"), false);     // Catch: Throwable -> L133
        com.loc.b.d = r5;     // Catch: Throwable -> L133
        com.loc.b.e = r6;     // Catch: Throwable -> L133
        SharedPreferences.Editor r7 = z.a(r9, r3);     // Catch: Throwable -> L133
        z.a(r7, "a4", r5);     // Catch: Throwable -> L133
        z.a(r7, "a5", r6);     // Catch: Throwable -> L133
        z.a(r7);     // Catch: Throwable -> L133
    L133:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 17I");
    L136:
        if (fx.a(r22, "1A4") == false) goto L176;
        JSONObject r11 = r22.getJSONObject("1A4");     // Catch: Throwable -> L139
        String r15 = r11.optString("ada");     // Catch: Throwable -> L139
        boolean r24 = a(r15, fy.c);     // Catch: Throwable -> L139
        long r25 = r11.optLong("iv", fy.f5601a);     // Catch: Throwable -> L139
        fy.d = r24;     // Catch: Throwable -> L139
        fy.f5602b = r25;     // Catch: Throwable -> L139
        SharedPreferences.Editor r26 = z.a(r9, r3);     // Catch: Throwable -> L139
        z.a(r26, "a16", r15);     // Catch: Throwable -> L139
        z.a(r26, "a17", r25);     // Catch: Throwable -> L139
        z.a(r26);     // Catch: Throwable -> L139
        return;
    L139:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 1A4");
        return;
    L176:
        return;
    L169:
        JSONObject r27 = r22.getJSONObject("15K");     // Catch: Throwable -> L120
        if (r27 == null) goto L122;
        boolean r28 = a(r27.optString("ucf"), f.f5570a);     // Catch: Throwable -> L120
        boolean r29 = a(r27.optString("fsv2"), f.f5571b);     // Catch: Throwable -> L120
        boolean r30 = a(r27.optString("usc"), f.c);     // Catch: Throwable -> L120
        String r110 = r17;
        int r31 = r27.optInt(r110, f.d);     // Catch: Throwable -> L120
        String r111 = r16;
        boolean r112 = a(r27.optString(r111), f.e);     // Catch: Throwable -> L120
        int r32 = r27.optInt("ustv", f.f);     // Catch: Throwable -> L120
        if (r28 == f.f5570a) goto L107;
    L116:
        f.f5570a = r28;     // Catch: Throwable -> L120
        f.f5571b = r29;     // Catch: Throwable -> L120
        f.c = r30;     // Catch: Throwable -> L120
        f.d = r31;     // Catch: Throwable -> L120
        f.e = r112;     // Catch: Throwable -> L120
        f.f = r32;     // Catch: Throwable -> L120
        r3 = r23;
        SharedPreferences.Editor r33 = z.a(r9, r3);     // Catch: Throwable -> L142
        z.a(r33, "ucf", f.f5570a);     // Catch: Throwable -> L142
        z.a(r33, "fsv2", f.f5571b);     // Catch: Throwable -> L142
        z.a(r33, "usc", f.c);     // Catch: Throwable -> L142
        z.a(r33, r110, f.d);     // Catch: Throwable -> L142
        z.a(r33, r111, f.e);     // Catch: Throwable -> L142
        z.a(r33, "ustv", f.f);     // Catch: Throwable -> L142
        z.a(r33);     // Catch: Throwable -> L142
        goto L124
    L107:
        if (r29 != f.f5571b) goto L116;
        if (r30 != f.c) goto L116;
        if (r31 != f.d) goto L116;
        if (r112 != f.e) goto L116;
        if (r32 == f.d) goto L122;
    L120:
        th = move-exception;
        r3 = r23;
        n.a(th, "AuthConfigManager", "load 15K");
        goto L124
    L155:
        JSONObject r34 = r22.getJSONObject("17S");     // Catch: Throwable -> L94
        if (r34 == null) goto L59;
        boolean r35 = a(r34.optString("able"), false);     // Catch: Throwable -> L94
        if (r35 == o) goto L59;
        o = r35;     // Catch: Throwable -> L94
        if (r9 == null) goto L59;
        SharedPreferences.Editor r113 = z.a(r9, "open_common");     // Catch: Throwable -> L94
        z.a(r113, "a2", r35);     // Catch: Throwable -> L94
        z.a(r113);     // Catch: Throwable -> L94
    L59:
        if (r34 == null) goto L99;
        boolean r36 = a(r34.optString("static_enable"), true);     // Catch: Throwable -> L94
        boolean r114 = a(r34.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L94
        int r115 = r34.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L94
        int r116 = r34.optInt("static_retry", 3);     // Catch: Throwable -> L94
        boolean r117 = a(r34.optString("bgp_enable"), true);     // Catch: Throwable -> L94
        r16 = "ust";
        boolean r118 = a(r34.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L92
        r17 = "umv";
        int r37 = r34.optInt("bgp_retry", 3);     // Catch: Throwable -> L90
        boolean r38 = a(r34.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L90
        if (r36 == f) goto L67;
    L80:
        f = r36;     // Catch: Throwable -> L90
        g = r114;     // Catch: Throwable -> L90
        e = r115;     // Catch: Throwable -> L90
        y = r116;     // Catch: Throwable -> L90
        h = r117;     // Catch: Throwable -> L90
        i = r118;     // Catch: Throwable -> L90
        z = r37;     // Catch: Throwable -> L90
        j = r38;     // Catch: Throwable -> L90
        if (r9 == null) goto L85;
        SharedPreferences.Editor r39 = z.a(r9, "open_common");     // Catch: Throwable -> L90
        r23 = "open_common";
        z.a(r39, "a13", r36);     // Catch: Throwable -> L88
        z.a(r39, "a6", r117);     // Catch: Throwable -> L88
        z.a(r39, "a7", r114);     // Catch: Throwable -> L88
        z.a(r39, "a8", r115);     // Catch: Throwable -> L88
        z.a(r39, "a9", r116);     // Catch: Throwable -> L88
        z.a(r39, "a10", r118);     // Catch: Throwable -> L88
        z.a(r39, "a11", r37);     // Catch: Throwable -> L88
        z.a(r39, "a12", r38);     // Catch: Throwable -> L88
        z.a(r39);     // Catch: Throwable -> L88
    L86:
        new StringBuilder("static_enable=").append(f);     // Catch: Throwable -> L88
        ao.a();     // Catch: Throwable -> L88
        new StringBuilder("bgp_enable=").append(h);     // Catch: Throwable -> L88
        ao.a();     // Catch: Throwable -> L88
        new StringBuilder("static_ip_direct_enable=").append(g);     // Catch: Throwable -> L88
        ao.a();     // Catch: Throwable -> L88
        new StringBuilder("bgp_ip_direct_enable=").append(i);     // Catch: Throwable -> L88
        ao.a();     // Catch: Throwable -> L88
        new StringBuilder("perf_data_upload_enable=").append(j);     // Catch: Throwable -> L88
        ao.a();     // Catch: Throwable -> L88
    L88:
        th = th;
    L98:
        n.a(th, "AuthConfigManager", "load 17S");
    L85:
        r23 = "open_common";
        goto L86
    L67:
        if (r114 != g) goto L80;
        if (r115 != e) goto L80;
        if (r116 != y) goto L80;
        if (r117 != h) goto L80;
        if (r118 != i) goto L80;
        if (r37 != z) goto L80;
        if (r38 == j) goto L85;
    L90:
        th = th;
    L97:
        r23 = "open_common";
    L92:
        th = th;
    L96:
        r17 = "umv";
    L94:
        th = th;
        r16 = "ust";
    L13:
        th = move-exception;
        n.a(th, "at", "co");
        goto L16
    }

    private static void a(Context r2, fw r3, Throwable r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4.getMessage());
    }

    public static void a(Context r2, String r3) {
        fm.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private static void a(Context r2, String r3, String r4, e r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(e.c(r5)) == true) goto L15;
        String r7 = r5.b();
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return;
    L10:
        if (r6 != null) goto L12;
        return;
    L12:
        SharedPreferences.Editor r8 = z.a(r6, r4);
        r8.putString(r3, r7);
        z.a(r8);
        return;
    }

    public static void a(ao.c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (c == null) goto L15;
        HashMap r0 = new HashMap();
        r0.put("serverip", r5.c);
        r0.put("hostname", r5.e);
        r0.put("path", r5.d);
        r0.put("csid", r5.f5312a);
        r0.put("degrade", String.valueOf(r5.f5313b.a()));
        r0.put("errorcode", String.valueOf(r5.m));
        r0.put("errorsubcode", String.valueOf(r5.n));
        r0.put("connecttime", String.valueOf(r5.h));
        r0.put("writetime", String.valueOf(r5.i));
        r0.put("readtime", String.valueOf(r5.j));
        r0.put("datasize", String.valueOf(r5.l));
        r0.put("totaltime", String.valueOf(r5.f));
        String r6 = new JSONObject(r0).toString();
        "--埋点--".concat(String.valueOf(r6));
        ao.a();
        if (TextUtils.isEmpty(r6) == false) goto L12;
        return;
    L12:
        aw r1 = new aw(c, "core", "2.0", "O008");     // Catch: l -> L11
        r1.a(r6);     // Catch: l -> L11
        ax.a(r1, c);     // Catch: l -> L11
        return;
    L16:
        return;
    }

    private static void a(fw r2) {
        if (r2 == null) goto L17;
        if (TextUtils.isEmpty(r2.a()) == false) goto L6;
        return;
    L6:
        String r0 = r2.c();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = r2.b();     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return;
    L12:
        com.loc.b.a(r2.a(), r0);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    private static synchronized void a(String r4, long r5, String r7) {
        monitor-enter(fn.class);
    L19:
        th = move-exception;
        n.a(th, "at", "ucut");     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (v != null) goto L7;
    L17:
        monitor-exit(fn.class);
        return;
    L7:
        if (v.containsKey(r4) == false) goto L17;
        if (t != null) goto L12;
        t = new ConcurrentHashMap(8);     // Catch: Throwable -> L19
    L12:
        t.put(r4, new g(Long.valueOf(r5), r7));     // Catch: Throwable -> L19
        Context r1 = c;     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        SharedPreferences.Editor r2 = z.a(r1, "open_common");     // Catch: Throwable -> L19
        z.a(r2, r4, r5);     // Catch: Throwable -> L19
        z.a(r2, r4 + "lct-info", r7);     // Catch: Throwable -> L19
        z.a(r2);     // Catch: Throwable -> L19
    L15:
        monitor-exit(fn.class);
    }

    private static void a(String r4, String r5) {
        e r0 = a(c, r4, r5);
        String r1 = fx.a(System.currentTimeMillis(), "yyyyMMdd");
        if (r1.equals(e.a(r0)) == true) goto L5;
        r0.a(r1);
        e.b(r0).set(0);
    L5:
        e.b(r0).incrementAndGet();
        a(c, r4, r5, r0);
    }

    public static synchronized void a(final String r4, boolean r5, final String r6, final String r7, final String r8) {
        monitor-enter(fn.class);
    L29:
        th = move-exception;
        n.a(th, "at", "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        monitor-exit(fn.class);
        return;
    L9:
        if (u != null) goto L11;
        u = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        u.put(r4, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (v != null) goto L16;
        monitor-exit(fn.class);
        return;
    L16:
        if (v.containsKey(r4) == true) goto L20;
        monitor-exit(fn.class);
        return;
    L20:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        monitor-exit(fn.class);
        return;
    L23:
        if (r5 == true) goto L25;
    L26:
        bp.a().b(new AnonymousClass1(r4, r6, r7, r8));     // Catch: Throwable -> L29
        monitor-exit(fn.class);
        return;
    L25:
        an.a(true, r4);     // Catch: Throwable -> L29
        goto L26
    }

    public static void a(String r4, boolean r5, boolean r6, boolean r7) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (c == null) goto L32;
        HashMap r0 = new HashMap();
        r0.put("url", r4);
        r0.put("downLevel", String.valueOf(r5));
        String r1 = "0";
        if (fp.j(c) != 0) goto L10;
        Object r8 = "0";
    L11:
        r0.put("ant", r8);
        if (r7 == false) goto L16;
        if (r5 == false) goto L15;
        String r9 = m;
    L19:
        r0.put("type", r9);
        if (r6 == true) goto L23;
        r1 = "1";
    L23:
        r0.put("status", r1);
        String r10 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r10) == false) goto L29;
        return;
    L29:
        aw r11 = new aw(c, "core", "2.0", "O002");     // Catch: l -> L28
        r11.a(r10);     // Catch: l -> L28
        ax.a(r11, c);     // Catch: l -> L28
        return;
    L33:
        return;
    L15:
        r9 = n;
        goto L19
    L16:
        if (r5 == false) goto L18;
        r9 = k;
        goto L19
    L18:
        r9 = l;
        goto L19
    L10:
        r8 = "1";
        goto L11
    }

    public static void a(boolean r4, ao.a r5) {
        if (D == false) goto L33;
        if (r5 == null) goto L46;
        ArrayList<ao.a> r0 = C;
        monitor-enter(r0);
        if (r4 == true) goto L34;
    L23:
        D = false;     // Catch: Throwable -> L30
        Iterator<ao.a> r6 = C.iterator();     // Catch: Throwable -> L30
    L24:
        ao.a();     // Catch: Throwable -> L30
        if (r6.hasNext() == false) goto L27;
        ao.a r7 = (ao.a) ZeusTransformUtils.preCheckCast(r6.next(), ao.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        new StringBuilder("----path=").append(r7.e).append("-counts=").append(r7.j).append("-code=").append(r7.f).append("----");     // Catch: Throwable -> L30
        goto L24
    L27:
        ao.a();     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L34:
        Iterator<ao.a> r8 = C.iterator();     // Catch: Throwable -> L30
    L11:
        if (r8.hasNext() == false) goto L23;
        ao.a r1 = (ao.a) ZeusTransformUtils.preCheckCast(r8.next(), ao.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r1.f5309b.equals(r5.f5309b) == false) goto L11;
        if (r1.e.equals(r5.e) == false) goto L11;
        if (r1.f != r5.f) goto L11;
        if (r1.j != r5.j) goto L22;
        r8.remove();     // Catch: Throwable -> L30
    L21:
        ao.a();     // Catch: Throwable -> L30
        goto L11
    L22:
        r1.j.set(r1.j.get() - r5.j.get());     // Catch: Throwable -> L30
        goto L21
    L46:
        return;
    }

    public static void a(boolean r2, String r3) {
        "--markHostNameFailed---hostname=".concat(String.valueOf(r3));     // Catch: Throwable -> L25
        ao.a();     // Catch: Throwable -> L25
        if (f == true) goto L7;
        if (r2 == true) goto L7;
        return;
    L7:
        if (i == true) goto L11;
        if (r2 == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r3) == false) goto L14;
        return;
    L14:
        if (r2 == true) goto L21;
        if (A.get(r3) == null) goto L18;
        return;
    L18:
        A.put(r3, Boolean.TRUE);     // Catch: Throwable -> L25
        a(b(r3, "a14"), "open_common");     // Catch: Throwable -> L25
        return;
    L21:
        if (B.get(r3) == null) goto L23;
        return;
    L23:
        B.put(r3, Boolean.TRUE);     // Catch: Throwable -> L25
        a(b(r3, "a15"), "open_common");     // Catch: Throwable -> L25
        return;
    }

    public static boolean a() {
        if (c == null) goto L11;
        i();
        if (c() == true) goto L8;
        return false;
    L8:
        if (b() == false) goto L11;
        return true;
    L11:
        if (o == true) goto L13;
        return false;
    L13:
        e r0 = a(c, "IPV6_CONFIG_NAME", "open_common");
        if (r0 != null) goto L17;
        return false;
    L17:
        if (r0.a() >= 5) goto L19;
        return true;
    L19:
        return false;
    }

    public static synchronized boolean a(String r7, long r8) {
        monitor-enter(fn.class);
        boolean r1 = false;
        if (TextUtils.isEmpty(r7) == false) goto L9;
        monitor-exit(fn.class);
        return false;
    L9:
        g r2 = f(r7);     // Catch: Throwable -> L26
        long r3 = 0;
        if (r2 == null) goto L12;
        long r5 = r2.f5572a;     // Catch: Throwable -> L26
    L14:
        if (r8 == r5) goto L24;
        if (u != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r3) <= 30000) goto L24;
        r1 = true;
        goto L24
    L18:
        if (u.containsKey(r7) == false) goto L20;
        r3 = ((Long) ZeusTransformUtils.preCheckCast(u.get(r7), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r5 = 0;
    L24:
        monitor-exit(fn.class);
        return r1;
    }

    public static boolean a(String r2, boolean r3) {
    L10:
        return r3;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r3;
    L5:
        String[] r4 = URLDecoder.decode(r2).split("/");     // Catch: Throwable -> L10
        if ((r4[r4.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean a(InetAddress r1) {
        if (r1.isLoopbackAddress() == false) goto L5;
        return true;
    L5:
        if (r1.isLinkLocalAddress() == false) goto L7;
        return true;
    L7:
        if (r1.isAnyLocalAddress() == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.loc.fr] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.loc.fn$b] */
    /* JADX WARN: Type inference failed for: r11v14, types: [com.loc.fn$b] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [com.loc.fn$b] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r12v9, types: [android.content.Context] */
    private static b b(Context r23, fw r24, String r25, String r26, String r27, String r28) {
        String r10 = "info";
        ?? r11 = "result";
        ?? r12 = "ver";
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        b r4 = new b();
        r4.f = new JSONObject();
        if (r5 == null) goto L5;
        c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L5:
        e();
        String r16 = null;
        a(r24);     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 l -> L71
        new ak();     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 l -> L71
        boolean r0 = TextUtils.isEmpty(r25);     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 l -> L71
    L143:
        if (r0 == false) goto L139;
        String r17 = r25;
    L133:
        d(r5);     // Catch: Throwable -> L124 l -> L54
        e(r5);     // Catch: Throwable -> L124 l -> L54
        String r19 = "result";
        r11 = r4;
        String r20 = "ver";
        r12 = r5;
        String r21 = "infocode";
        String r22 = "info";
        r10 = "at";
        aq r1 = ak.a(new c(r5, r24, r17, r26, r27, r28));     // Catch: l -> L50 Throwable -> L123
        if (r0 == false) goto L20;
        return r11;
    L20:
        if (r1 != null) goto L137;
        byte[] r2 = null;
    L42:
        byte[] r3 = new byte[16];     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        byte[] r6 = new byte[r2.length - 16];     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        System.arraycopy(r2, 0, r3, 0, 16);     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        System.arraycopy(r2, 16, r6, 0, r2.length - 16);     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        SecretKeySpec r7 = new SecretKeySpec(r3, fx.c("EQUVT"));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        Cipher r8 = Cipher.getInstance(fx.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        r8.init(2, r7, new IvParameterSpec(fx.c()));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        r16 = fx.a(r8.doFinal(r6));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        ?? r13 = r11;
        ?? r14 = r12;
    L75:
        String r9 = r17;
        if (r2 != null) goto L79;
        return r13;
    L79:
        if (TextUtils.isEmpty(r16) == false) goto L81;
        r16 = fx.a(r2);
    L81:
        String r15 = r16;
        if (TextUtils.isEmpty(r15) == false) goto L127;
        a(r14, r24, "result is null");
    L127:
        JSONObject r18 = new JSONObject(r15);     // Catch: Throwable -> L119
        if (r18.has("status") == false) goto L121;
        int r29 = r18.getInt("status");     // Catch: Throwable -> L119
        if (r29 != 1) goto L89;
        f5557a = 1;     // Catch: Throwable -> L119
    L104:
        String r30 = r20;
    L109:
        th = move-exception;
        n.a(th, r10, "lc");     // Catch: Throwable -> L119
    L111:
        String r31 = r19;
        if (fx.a(r18, r31) == false) goto L121;
        JSONObject r32 = r18.getJSONObject(r31);     // Catch: Throwable -> L119
        a(r14, r24, r9, r13, r32);     // Catch: Throwable -> L119
        JSONObject r33 = r32.getJSONObject("15K");     // Catch: Throwable -> L122
        boolean r34 = a(r33.optString("isTargetAble"), false);     // Catch: Throwable -> L122
        if (a(r33.optString("able"), false) == true) goto L117;
        fr.a();     // Catch: Throwable -> L122
        fr.b(r14);     // Catch: Throwable -> L122
    L130:
        goto L121
    L117:
        fr.a().a(r14, r34);     // Catch: Throwable -> L122
        goto L130
    L106:
        if (r18.has(r30) == false) goto L111;
        r13.d = r18.getInt(r30);     // Catch: Throwable -> L109
    L89:
        if (r29 != 0) goto L104;
        if (r1 == null) goto L93;
        String r35 = r1.c;     // Catch: Throwable -> L119
        String r36 = r1.d;     // Catch: Throwable -> L119
    L94:
        fx.a(r14, r35, r36, r18);     // Catch: Throwable -> L119
        f5557a = 0;     // Catch: Throwable -> L119
        String r37 = r22;
        if (r18.has(r37) == false) goto L97;
        f5558b = r18.getString(r37);     // Catch: Throwable -> L119
    L97:
        String r38 = "";
        String r39 = r21;
        if (r18.has(r39) == false) goto L100;
        r38 = r18.getString(r39);     // Catch: Throwable -> L119
    L100:
        q.a(r24, "/v3/iasdkauth", f5558b, r36, r35, r38);     // Catch: Throwable -> L119
        if (f5557a != 0) goto L104;
        r13.c = f5558b;     // Catch: Throwable -> L119
        return r13;
    L93:
        r35 = "authcsid";
        r36 = "authgsid";
    L121:
        return r13;
    L119:
        th = move-exception;
        n.a(th, r10, "lc");
        goto L121
    L48:
        e = e;
    L74:
        r11.c = e.a();
        a(r12, r24, e.a());
        q.a(r24, "/v3/iasdkauth", e);
        r13 = r11;
        r14 = r12;
    L46:
        e = e;
    L70:
        a(r12, r24, e);
        r13 = r11;
        r14 = r12;
    L44:
        e = th;
    L66:
        q.b(e, r10, "lc");
        goto L70
    L137:
        r2 = r1.f5322a;     // Catch: Throwable -> L35 IllegalBlockSizeException -> L37 l -> L39
        Map<String, List<String>> r40 = r1.f5323b;     // Catch: Throwable -> L33
        if (r40 == null) goto L42;
        if (r40.containsKey("lct") == false) goto L42;
        List r41 = (List) ZeusTransformUtils.preCheckCast(r40.get("lct"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        List r42 = (List) ZeusTransformUtils.preCheckCast(r40.get("lct-info"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        r11.e = a(r41);     // Catch: Throwable -> L33
        String r43 = b(r42);     // Catch: Throwable -> L33
        if (r11.e == 0) goto L42;
        if (r24 == null) goto L42;
        String r44 = r24.a();     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r44) == true) goto L42;
        a(r44, r11.e, r43);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        q.b(th, r10, "lct");     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 l -> L48
        goto L42
    L39:
        e = e;
        r2 = null;
    L37:
        e = e;
        r2 = null;
    L35:
        e = th;
        r2 = null;
        goto L66
    L50:
        e = move-exception;
        throw e;     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 l -> L61
    L54:
        e = e;
    L56:
        throw e;     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 l -> L61
    L53:
        throw new l("未知的错误");     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 l -> L61
    L139:
        r17 = c(r25);     // Catch: Throwable -> L10 l -> L12
        goto L133
    L12:
        e = e;
    L61:
        e = e;
    L73:
        r1 = null;
        r2 = null;
    L59:
        e = e;
    L69:
        r1 = null;
        r2 = null;
    L57:
        e = th;
    L65:
        r1 = null;
        r2 = null;
    L71:
        e = e;
        r21 = "infocode";
        r22 = "info";
        r19 = "result";
        r20 = "ver";
        r11 = r4;
        r12 = r5;
        r10 = "at";
        r17 = r25;
    L67:
        e = e;
        r21 = "infocode";
        r22 = "info";
        r19 = "result";
        r20 = "ver";
        r11 = r4;
        r12 = r5;
        r10 = "at";
        r17 = r25;
    L63:
        e = th;
        r21 = "infocode";
        r22 = "info";
        r19 = "result";
        r20 = "ver";
        r11 = r4;
        r12 = r5;
        r10 = "at";
        r17 = r25;
        goto L65
    }

    public static fw b(String r2) {
        d r3 = (d) ZeusTransformUtils.preCheckCast(v.get(r2), d.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.f5566a;
    }

    private static String b(String r1, String r2) {
        return r2 + "_" + ft.a(r1.getBytes());
    }

    private static String b(List<String> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        return "";
    L12:
        if (r3.size() <= 0) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r4) == true) goto L15;
        return r4;
    L15:
        return "";
    L14:
        return "";
    L16:
        return "";
    }

    public static void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        o = z.a(r4, "open_common", "a2", true);
    }

    public static void b(ao.c r10) {
        ArrayList<ao.a> r0 = C;
        monitor-enter(r0);
        int r1 = 0;
        boolean r2 = false;
    L26:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= C.size()) goto L18;
        ao.a r3 = (ao.a) ZeusTransformUtils.preCheckCast(C.get(r1), ao.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r10.c.equals(r3.f5309b) == false) goto L17;
        if (r10.d.equals(r3.e) == false) goto L17;
        if (r10.m != r3.f) goto L17;
        if (r3.f != 1) goto L16;
        r3.i = ((((long) r3.j.get()) * r3.i) + r10.f) / ((long) (r3.j.get() + 1));     // Catch: Throwable -> L23
    L16:
        r3.j.getAndIncrement();     // Catch: Throwable -> L23
        r2 = true;
    L17:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        goto L26
    L18:
        if (r2 == true) goto L20;
        C.add(new ao.a(r10));     // Catch: Throwable -> L23
    L20:
        ao.a();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
    }

    public static synchronized void b(String r2, boolean r3) {
        monitor-enter(fn.class);
        a(r2, r3, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(fn.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        Context r0 = c;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = fp.o(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(q.get(r1.toUpperCase()), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static String c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return r1;
    L5:
        return r1 + ";15K;16H;17I;1A4;17S;183";
    }

    private static void c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        f = z.a(r5, "open_common", "a13", true);
        h = z.a(r5, "open_common", "a6", true);
        g = z.a(r5, "open_common", "a7", false);
        e = z.a(r5, "open_common", "a8", 5000);
        y = z.a(r5, "open_common", "a9", 3);
        i = z.a(r5, "open_common", "a10", false);
        z = z.a(r5, "open_common", "a11", 3);
        j = z.a(r5, "open_common", "a12", false);
    }

    public static void c(ao.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (j == true) goto L7;
        return;
    L7:
        Queue<ao.c> r0 = E;
        monitor-enter(r0);
        E.offer(r2);     // Catch: Throwable -> L12
        ao.a();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean c() {
        Context r0 = c;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = fp.o(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(q.get(r1.toUpperCase()), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void d() {
        e r2 = a(c, "IPV6_CONFIG_NAME", "open_common");     // Catch: Throwable -> L7
        String r3 = fx.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L7
        if (r3.equals(e.a(r2)) == true) goto L5;
        r2.a(r3);     // Catch: Throwable -> L7
        e.b(r2).set(0);     // Catch: Throwable -> L7
    L5:
        e.b(r2).incrementAndGet();     // Catch: Throwable -> L7
        a(c, "IPV6_CONFIG_NAME", "open_common", r2);     // Catch: Throwable -> L7
        return;
    }

    private static void d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (w == false) goto L6;
        return;
    L6:
        com.loc.b.d = z.a(r4, "open_common", "a4", true);     // Catch: Throwable -> L8
        com.loc.b.e = z.a(r4, "open_common", "a5", true);     // Catch: Throwable -> L8
        w = true;     // Catch: Throwable -> L8
        return;
    }

    public static synchronized boolean d(String r5) {
        monitor-enter(fn.class);
    L24:
        th = move-exception;
        n.a(th, "at", "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(fn.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        monitor-exit(fn.class);
        return false;
    L10:
        if (v != null) goto L14;
        monitor-exit(fn.class);
        return false;
    L14:
        if (u != null) goto L17;
        u = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (v.containsKey(r5) == false) goto L26;
        if (u.containsKey(r5) == true) goto L26;
        u.put(r5, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(fn.class);
        return true;
    }

    public static void e() {
        if (d == false) goto L11;
        return;
    L11:
        Context r1 = c;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        d = true;     // Catch: Throwable -> L10
        fr.a().a(r1);     // Catch: Throwable -> L10
        b(r1);     // Catch: Throwable -> L10
        c(r1);     // Catch: Throwable -> L10
        f.f5570a = z.a(r1, "open_common", "ucf", f.f5570a);     // Catch: Throwable -> L10
        f.f5571b = z.a(r1, "open_common", "fsv2", f.f5571b);     // Catch: Throwable -> L10
        f.c = z.a(r1, "open_common", "usc", f.c);     // Catch: Throwable -> L10
        f.d = z.a(r1, "open_common", "umv", f.d);     // Catch: Throwable -> L10
        f.e = z.a(r1, "open_common", "ust", f.e);     // Catch: Throwable -> L10
        f.f = z.a(r1, "open_common", "ustv", f.f);     // Catch: Throwable -> L10
        return;
    }

    private static void e(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (x == false) goto L6;
        return;
    L6:
        fy.d = a(z.b(r6, "open_common", "a16", ""), true);     // Catch: Throwable -> L8
        fy.f5602b = z.a(r6, "open_common", "a17", fy.f5601a);     // Catch: Throwable -> L8
        x = true;     // Catch: Throwable -> L8
        return;
    }

    public static synchronized void e(String r2) {
        monitor-enter(fn.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (u != null) goto L9;
        monitor-exit(fn.class);
        return;
    L9:
        if (u.containsKey(r2) == false) goto L11;
        u.remove(r2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(fn.class);
    }

    public static ao.a f() {
        if (D == false) goto L5;
        return null;
    L5:
        ArrayList<ao.a> r0 = C;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (D == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(C);     // Catch: Throwable -> L18
        if (C.size() <= 0) goto L16;
        ao.a r1 = ((ao.a) ZeusTransformUtils.preCheckCast(C.get(0), ao.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L18
        D = true;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r1;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    }

    public static synchronized g f(String r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.loc.fn> r0 = com.loc.fn.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.fn$g> r1 = com.loc.fn.t     // Catch: java.lang.Throwable -> L2a
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L2a
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2a
            com.loc.fn.t = r1     // Catch: java.lang.Throwable -> L2a
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.fn$g> r1 = com.loc.fn.t     // Catch: java.lang.Throwable -> L2a
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L32
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.fn$g> r1 = com.loc.fn.t     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.Class<com.loc.fn$g> r1 = com.loc.fn.g.class
            java.lang.String r2 = "com.obric.memorydata.plugin"
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, r1, r2)     // Catch: java.lang.Throwable -> L2a
            com.loc.fn$g r3 = (com.loc.fn.g) r3     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            return r3
        L2a:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            com.loc.n.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L41
        L32:
            com.loc.fn$g r3 = new com.loc.fn$g     // Catch: java.lang.Throwable -> L41
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = ""
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r0)
            return r3
        L41:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.fn.f(java.lang.String):com.loc.fn$g");
    }

    public static ao.c g() {
        Queue<ao.c> r0 = E;
        monitor-enter(r0);
        ao.c r1 = (ao.c) ZeusTransformUtils.preCheckCast(E.poll(), ao.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean g(String r4) {
    L25:
        return true;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return true;
    L7:
        if (f == true) goto L10;
        return false;
    L10:
        if (A.get(r4) != null) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        Context r2 = c;     // Catch: Throwable -> L25
        if (r2 != null) goto L18;
        return true;
    L18:
        e r5 = a(r2, b(r4, "a14"), "open_common");     // Catch: Throwable -> L25
        if (r5 != null) goto L21;
        return true;
    L21:
        if (r5.a() >= y) goto L24;
        return true;
    L24:
        return false;
    L12:
        r1 = false;
        goto L13
    }

    static /* synthetic */ ConcurrentHashMap h() {
        return v;
    }

    public static boolean h(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return false;
    L7:
        if (i == true) goto L10;
        return false;
    L10:
        if (B.get(r4) != null) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        Context r2 = c;     // Catch: Throwable -> L25
        if (r2 != null) goto L18;
        return true;
    L18:
        e r5 = a(r2, b(r4, "a15"), "open_common");     // Catch: Throwable -> L25
        if (r5 != null) goto L21;
        return true;
    L21:
        if (r5.a() >= z) goto L24;
        return true;
    L12:
        r1 = false;
    L24:
        return false;
    }

    private static void i() {
        Context r1 = c;     // Catch: Throwable -> L55
        if (r1 == null) goto L18;
        String r2 = fp.o(r1);     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r) == true) goto L15;
        if (TextUtils.isEmpty(r2) == true) goto L15;
        if (r.equals(r2) == false) goto L15;
        if ((System.currentTimeMillis() - s) >= 60000) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r2) == true) goto L20;
        r = r2;     // Catch: Throwable -> L55
    L20:
        s = System.currentTimeMillis();     // Catch: Throwable -> L55
        q.clear();     // Catch: Throwable -> L55
        if (com.amap.a.a.a.a.a.b() == false) goto L53;
        Iterator r3 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L55
    L25:
        if (r3.hasNext() == false) goto L52;
        NetworkInterface r4 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r3.next(), NetworkInterface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        if (r4.getInterfaceAddresses().isEmpty() == true) goto L25;
        String r5 = r4.getDisplayName();     // Catch: Throwable -> L55
        int r6 = 0;
        Iterator<InterfaceAddress> r7 = r4.getInterfaceAddresses().iterator();     // Catch: Throwable -> L55
    L30:
        if (r7.hasNext() == false) goto L43;
        InetAddress r8 = ((InterfaceAddress) ZeusTransformUtils.preCheckCast(r7.next(), InterfaceAddress.class, "com.obric.memorydata.plugin")).getAddress();     // Catch: Throwable -> L55
        if (ZeusTransformUtils.instanceOf(r8, Inet6Address.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, Inet4Address.class) == false) goto L30;
        Inet4Address r9 = (Inet4Address) ZeusTransformUtils.preCheckCast(r8, Inet4Address.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        if (a(r9) == true) goto L30;
        if (r9.getHostAddress().startsWith(fx.c("FMTkyLjE2OC40My4")) == true) goto L30;
        r6 = r6 | 1;     // Catch: Throwable -> L55
        goto L30
    L34:
        if (a((Inet6Address) ZeusTransformUtils.preCheckCast(r8, Inet6Address.class, "com.obric.memorydata.plugin")) == true) goto L30;
        r6 = r6 | 2;     // Catch: Throwable -> L55
        goto L30
    L43:
        if (r6 == 0) goto L25;
        if (r5 == null) goto L48;
        if (r5.startsWith("wlan") == false) goto L48;
        q.put("WIFI", Integer.valueOf(r6));     // Catch: Throwable -> L55
    L48:
        if (r5 == null) goto L25;
        if (r5.startsWith("rmnet") == false) goto L25;
        q.put("MOBILE", Integer.valueOf(r6));     // Catch: Throwable -> L55
        goto L25
    L52:
        return;
    L53:
        q.put("WIFI", 3);     // Catch: Throwable -> L55
        q.put("MOBILE", 3);     // Catch: Throwable -> L55
        return;
    L18:
        if ((System.currentTimeMillis() - s) >= 10000) goto L20;
        return;
    L55:
        th = move-exception;
        n.a(th, "at", "ipstack");
    }
}
