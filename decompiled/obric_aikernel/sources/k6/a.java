package k6;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.util.a0;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.anr.AnrManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import m6.c;
import m6.d;
import m6.f;
import m6.g;
import m6.h;
import m6.i;
import m6.j;
import org.json.JSONArray;
import org.json.JSONObject;
import p6.e;
import p6.k;
import p6.l;
import p6.m;
import p6.n;
import p6.o;
import p6.p;
import p6.q;
import p6.r;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Context f10102g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f10103h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static h f10104i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static g f10105j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static m6.a f10106k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static c f10107l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static f f10108m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static i f10109n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static j f10110o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile boolean f10111p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile boolean f10112q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile String f10113r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile String f10114s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile String f10115t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile String f10116u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static volatile String[] f10117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f10118w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Vector f10119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<o6.b> f10120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f10121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile HashMap<String, String> f10122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile WeakReference<d> f10123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10124f;

    /* JADX INFO: renamed from: k6.a$a, reason: collision with other inner class name */
    class RunnableC0217a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10125c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f10126g;

        RunnableC0217a(a r10, String r11) {
            this.f10126g = r10;
            this.f10125c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f10126g, n6.a.a(this.f10125c));
        }
    }

    class b implements Runnable {
        b(a r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            r6.a.a(a.b());     // Catch: Throwable -> L4
            return;
        }
    }

    static {
    }

    private a() {
        this.f10122d = new HashMap();
        this.f10123e = null;
        this.f10119a = new Vector(10);
        this.f10121c = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        ArrayList r10 = new ArrayList(20);
        r10.add(new p6.f());
        r10.add(new p6.c());
        r10.add(new q());
        r10.add(new p6.j());
        r10.add(new o());
        r10.add(new r());
        r10.add(new p6.d());
        r10.add(new p());
        r10.add(new m());
        r10.add(new p6.h());
        r10.add(new p6.b());
        r10.add(new p6.a());
        r10.add(new l());
        r10.add(new n());
        r10.add(new p6.g());
        r10.add(new p6.i());
        r10.add(new e());
        r10.add(new k());
        this.f10120b = Collections.unmodifiableList(r10);
        o();
        c();
        f10116u = d(f10102g).getAbsolutePath() + "/dump.hprof";     // Catch: Exception -> L5
        return;
    }

    private void A(i r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof o) == false) goto L5;
        ((o) r12).m(r10);
        return;
    L14:
        return;
    }

    private void B(j r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof r) == false) goto L5;
        ((r) r12).m(r10);
        return;
    L14:
        return;
    }

    static /* synthetic */ void a(a r10, n6.a r11) {
        r10.q(r11);
    }

    static /* synthetic */ Context b() {
        return f10102g;
    }

    private void c() {
        this.f10121c.execute(new b(this));
    }

    public static File d(Context r10) {
        File r11 = new File(r10.getExternalFilesDir(null) + "/monitor");
        if (r11.exists() == true) goto L5;
        r11.mkdir();
    L5:
        return r11;
    }

    public static String f() {
        return f10114s;
    }

    public static String[] g() {
        return f10117v;
    }

    public static String j() {
        return f10116u;
    }

    public static a k() {
        if (f10103h != null) goto L19;
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f10103h == null) goto L9;
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (f10112q == false) goto L12;
        f10103h = new a();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return f10103h;
    }

    public static String m() {
        return f10113r;
    }

    public static String n() {
        return f10115t;
    }

    private void o() {
        h r10 = f10104i;
        if (r10 == null) goto L5;
        z(r10);
        f10104i = null;
    L5:
        g r11 = f10105j;
        if (r11 == null) goto L8;
        y(r11);
        f10105j = null;
    L8:
        m6.a r12 = f10106k;
        if (r12 == null) goto L11;
        t(r12);
        f10106k = null;
    L11:
        c r13 = f10107l;
        if (r13 == null) goto L14;
        u(r13);
        f10107l = null;
    L14:
        f r14 = f10108m;
        if (r14 == null) goto L17;
        w(r14);
        f10108m = null;
    L17:
        i r15 = f10109n;
        if (r15 == null) goto L20;
        A(r15);
        f10109n = null;
    L20:
        j r16 = f10110o;
        if (r16 == null) goto L24;
        B(r16);
        f10110o = null;
        return;
    }

    private void q(n6.a r10) {
        if (com.bytedance.apm.d.D() == false) goto L5;
        e0.e.b("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r10});
    L5:
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.f10123e != null) goto L10;
        d r11 = null;
    L11:
        if (r11 == null) goto L13;
        r11.a(r10);
    L13:
        Iterator<o6.b> r12 = this.f10120b.iterator();
    L15:
        if (r12.hasNext() == false) goto L22;
        if (r12.next().b(r10) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r11 = this.f10123e.get();
        goto L11
    }

    public static void r(Context r10) {
        f10112q = true;
        f10102g = r10.getApplicationContext();
        k();
        if (com.bytedance.apm.d.D() == false) goto L6;
        e0.e.b("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    public static boolean s() {
        return f10111p;
    }

    private void t(m6.a r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof p6.a) == false) goto L5;
        ((p6.a) r12).m(r10);
        return;
    L14:
        return;
    }

    private void u(c r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof p6.b) == false) goto L5;
        ((p6.b) r12).m(r10);
        return;
    L14:
        return;
    }

    public static void v(c r10) {
        if (f10112q == false) goto L5;
        k().u(r10);
        return;
    L5:
        f10107l = r10;
    }

    private void w(f r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof p6.h) == false) goto L5;
        ((p6.h) r12).o(r10);
        return;
    L14:
        return;
    }

    public static void x(f r10) {
        if (f10112q == false) goto L5;
        k().w(r10);
        return;
    L5:
        f10108m = r10;
    }

    private void y(g r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof l) == false) goto L5;
        ((l) r12).m(r10);
        return;
    L14:
        return;
    }

    private void z(h r10) {
        if (r10 == null) goto L13;
        Iterator<o6.b> r11 = this.f10120b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        o6.b r12 = r11.next();
        if ((r12 instanceof n) == false) goto L5;
        ((n) r12).m(r10);
        return;
    L14:
        return;
    }

    public void e() {
        f10118w = m0.a.f10956a;
        long r10 = System.currentTimeMillis();
        if ((r10 - this.f10124f) >= AnrManager.ANR_MIN_INTERVAL) goto L6;
        e0.e.b("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.f10124f = r10;
        String r11 = a0.a(ReportConsts.HTTPS + f10118w + "/monitor/collect/c/cloudcontrol/get", com.bytedance.apm.d.y());     // Catch: Exception -> L53
        HashMap r12 = new HashMap();     // Catch: Exception -> L53
        r12.put(NetConst.KEY_CONTENT_TYPE, "application/json");     // Catch: Exception -> L53
        r12.put(NetConst.KEY_REQUSET_VERISON_CODE, NetConst.ENCRYPT_VERISON_CODE);     // Catch: Exception -> L53
        r12.put("Accept", "application/json");     // Catch: Exception -> L53
        t4.c r13 = com.bytedance.apm.d.d(r11, Tools.safeGetBytes(new JSONObject().toString()), r12);     // Catch: Exception -> L53
        int r14 = 0;
        if (com.bytedance.apm.d.D() == false) goto L10;
        e0.e.b("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r11});     // Catch: Exception -> L53
    L10:
        if (r13 != null) goto L14;
        e0.e.b("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L53
        return;
    L14:
        if (r13.c() != 200) goto L64;
        JSONObject r15 = new JSONObject(new String(r13.b()));     // Catch: Exception -> L53
        if (com.bytedance.apm.d.D() == false) goto L18;
        e0.e.b("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r15.toString()});     // Catch: Exception -> L53
    L18:
        Map<String, String> r16 = r13.a();     // Catch: Exception -> L53
        String r17 = null;
        if (r16 != null) goto L21;
    L32:
        String r18 = r15.optString("data");     // Catch: Exception -> L53
        if (r18.isEmpty() == true) goto L39;
        if (TextUtils.isEmpty(r17) == true) goto L37;
        r15 = new JSONObject(com.bytedance.apm.util.c.a(r18.getBytes(), r17));     // Catch: Exception -> L53
        goto L39
    L37:
        r15 = new JSONObject(new String(r18.getBytes()));     // Catch: Exception -> L53
    L39:
        if (com.bytedance.apm.d.D() == false) goto L42;
        e0.e.b("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r15});     // Catch: Exception -> L53
    L42:
        if (com.bytedance.apm.util.i.d(r15) == false) goto L44;
        return;
    L44:
        JSONObject r19 = r15.optJSONObject("configs");     // Catch: Exception -> L53
        if (com.bytedance.apm.util.i.d(r19) == false) goto L47;
        return;
    L47:
        JSONArray r20 = r19.optJSONArray("cloud_commands");     // Catch: Exception -> L53
        if (r20 != null) goto L50;
        return;
    L50:
        if (r14 >= r20.length()) goto L66;
        p(r20.optString(r14));     // Catch: Exception -> L53
        r14 = r14 + 1;
        goto L50
    L66:
        return;
    L21:
        if (r16.isEmpty() == true) goto L32;
        r17 = r16.get(CommonConsts.KEY_DECODE);     // Catch: Exception -> L53
        if (TextUtils.isEmpty(r17) == false) goto L32;
        Iterator<Map.Entry<String, String>> r21 = r16.entrySet().iterator();     // Catch: Throwable -> L56
    L27:
        if (r21.hasNext() == false) goto L32;
        Map.Entry<String, String> r22 = r21.next();     // Catch: Throwable -> L56
        if (CommonConsts.KEY_DECODE.equalsIgnoreCase(r22.getKey()) == false) goto L27;
        r17 = r22.getValue();     // Catch: Throwable -> L56
        goto L32
    L64:
        return;
    L53:
        e = move-exception;
        e0.e.f("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }

    public HashMap<String, String> h() {
        return this.f10122d;
    }

    public Context i() {
        return f10102g;
    }

    public Enumeration l() {
        return this.f10119a.elements();
    }

    public void p(String r10) {
        this.f10121c.execute(new RunnableC0217a(this, r10));
    }
}
