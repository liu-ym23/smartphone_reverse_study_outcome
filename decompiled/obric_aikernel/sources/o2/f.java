package o2;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.bytedance.retrofit2.z;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static AtomicBoolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f11450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t f11451b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f11452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f11453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static s f11454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f11455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static h f11456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static d f11457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static l f11458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static m f11459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile AtomicBoolean f11460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f11461l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static CountDownLatch f11462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static e f11463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static j f11464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static InterfaceC0255f f11465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile u f11466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile r f11467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile n f11468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Map<String, o> f11469t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile q f11470u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static b f11471v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static a f11472w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static boolean f11473x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f11474y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f11475z;

    public interface a {
        Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, List<String>> r11);
    }

    public interface b {
        Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, List<String>> r11);
    }

    public interface c {
        boolean a();
    }

    public interface d<T extends o2.b> {
        String a(String r10, boolean r11, Object... r12);

        @Deprecated
        void b(String r10, Throwable r11, long r12, T r13);

        @Deprecated
        void c(String r10, long r11, T r12);

        String d(String r10, boolean r11);

        void e();
    }

    public interface e<T extends o2.c> {
        String a(String r10, T r11);

        void c(String r10, String r11, boolean r12);
    }

    /* JADX INFO: renamed from: o2.f$f, reason: collision with other inner class name */
    public interface InterfaceC0255f {
        Map<String, List<String>> a(URI r10, Map<String, List<String>> r11);

        void b(URI r10, Map<String, List<String>> r11);
    }

    public interface g {
    }

    public interface h {
        void a(List<String> r10);

        String b();
    }

    public interface i {
        boolean b(String r10);
    }

    public interface j {
        List<String> f(CookieManager r10, com.bytedance.frameworks.baselib.network.http.impl.b r11, URI r12);

        List<String> g(String r10);
    }

    public interface k {
        void a(Set<String> r10);

        void b(String r10, String r11);
    }

    public interface l<T extends o2.b> {
        void a(long r10, long r11, String r12, String r13, T r14, Throwable r15);

        void b(long r10, long r11, String r12, String r13, T r14);

        default boolean handleApiSample(String r10, String r11) {
            return false;
        }
    }

    public interface m {
        boolean a();
    }

    public interface n {
        o2.h a(String r10, List<n4.b> r11, Map<String, List<String>> r12, boolean r13);
    }

    public interface o {
        o2.h a(Map<String, List<String>> r10);
    }

    public interface p extends o {
        o2.h b(String r10, List<n4.b> r11, Map<String, List<String>> r12);
    }

    public interface q {
        o2.h a(String r10, String r11, o2.b r12, int r13, List<n4.b> r14, Map<String, List<String>> r15);
    }

    public interface r {
        o2.h a(Map<String, List<String>> r10);
    }

    public interface s {
        InputStream a(InputStream r10, Map<String, List<String>> r11, RetrofitMetrics r12);
    }

    public static final class t implements z.b {
        public t() {
        }

        private void d(Object r10) {
            o2.b r11 = (o2.b) r10;
            if (r11.f11394a == null) goto L6;
            Logger.e("TTNetCallMonitor", "monitor cast error" + r11.f11394a.getPath());
            return;
        }

        @Override // com.bytedance.retrofit2.z.b
        public boolean a() {
            if (f.b() != null) goto L7;
            return false;
        L7:
            return f.b().a();
        }

        @Override // com.bytedance.retrofit2.z.b
        public void b(long r11, long r13, String r15, String r16, Object r17) {
            if (f.a() != null) goto L5;
            return;
        L5:
            if (r17 == null) goto L17;
            o2.b r10 = (o2.b) r17;
            if (com.bytedance.common.utility.g.b(r10.A) == false) goto L9;
            return;
        L9:
            if (r10.Q == true) goto L19;
            f.a().b(r11, r13, r15, r16, (o2.b) r17);     // Catch: ClassCastException -> L13
            return;
        L13:
            d(r17);
            return;
        L19:
            return;
        }

        @Override // com.bytedance.retrofit2.z.b
        public void c(long r12, long r14, String r16, String r17, Object r18, Throwable r19) {
            if (f.a() != null) goto L5;
            return;
        L5:
            if (r18 == null) goto L17;
            o2.b r10 = (o2.b) r18;
            if (com.bytedance.common.utility.g.b(r10.A) == false) goto L9;
            return;
        L9:
            if (r10.Q == true) goto L19;
            f.a().a(r12, r14, r16, r17, (o2.b) r18, r19);     // Catch: ClassCastException -> L13
            return;
        L13:
            d(r18);
            return;
        L19:
            return;
        }
    }

    public interface u {
        boolean a(Map<String, List<String>> r10);
    }

    static {
        f11451b = new t();
        f11454e = null;
        f11455f = null;
        f11460k = new AtomicBoolean(false);
        f11461l = new Object();
        f11462m = new CountDownLatch(1);
        f11469t = new ConcurrentHashMap();
        f11473x = false;
        f11474y = true;
        f11475z = 100;
        A = new AtomicBoolean(false);
    }

    public f() {
    }

    public static void A(String r10, o2.b r11, Throwable r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        long r13 = r11.f11405l;
        long r14 = r11.f11401h;
        z(r13 - r14, r14, r10, r11.P, r11, r12);
    }

    public static void B(String r10, String r11, boolean r12) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.g.b(r11) == true) goto L13;
        e r13 = f11463n;
        if (r13 == null) goto L12;
        r13.c(r10, r11, r12);
        return;
    L12:
        return;
    }

    public static void C(String r10, o2.b r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.Q == true) goto L9;
        long r12 = r11.f11405l;
        long r13 = r11.f11401h;
        D(r12 - r13, r13, r10, r11.P, r11);
        return;
    }

    public static void D(long r10, long r11, String r13, String r14, o2.b r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (com.bytedance.common.utility.g.b(r15.A) == false) goto L6;
        return;
    L6:
        if (r15.Q == true) goto L28;
        l r12 = f11458i;
        if (com.bytedance.common.utility.g.b(r13) == false) goto L11;
        return;
    L11:
        if (r10 <= 0) goto L25;
        if (r12 != null) goto L14;
        return;
    L14:
        if (r15.C == false) goto L18;
        if (r15.M.get() == false) goto L18;
        return;
    L18:
        if (r15.C == false) goto L20;
        r15.M.set(true);
    L20:
        r12.b(r10, r11, r13, r14, r15);
        return;
    L25:
        return;
    }

    private static o2.h E(Map<String, List<String>> r10) {
        if (f11467r == null) goto L7;
        o2.h r11 = f11467r.a(r10);
        r10.remove("bdturing-verify");
        return r11;
    L7:
        if (f11466q == null) goto L11;
        boolean r12 = f11466q.a(r10);
        r10.remove("bdturing-verify");
        return new o2.h(r12);
    L11:
        return new o2.h(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void F(n4.c r10, o2.b r11, Throwable r12, Boolean r13) {
        if (r12 != 0) goto L5;
        C(r10.G(), r11);
        return;
    L5:
        if ((r12 instanceof TTNetExceptionStorage) == false) goto L15;
        TTNetExceptionStorage r14 = (TTNetExceptionStorage) r12;
        if (r14.needReport == false) goto L15;
        if (r14.reportMonitorOk == false) goto L12;
        C(r10.G(), r11);
    L12:
        if (r14.reportMonitorError == false) goto L24;
    L21:
        A(r10.G(), r11, r12);
        return;
    L24:
        return;
    L15:
        if ((r12 instanceof s4.a) == false) goto L20;
        if (((s4.a) r12).shouldReport() == true) goto L21;
        return;
    L20:
        if (r13.booleanValue() == true) goto L21;
    }

    public static void G(d r10) {
        f11457h = r10;
    }

    public static void H(e r10) {
        f11463n = r10;
    }

    public static void I(g r10) {
    }

    public static void J(h r10) {
        f11456g = r10;
    }

    public static void K(i r10) {
        f11453d = r10;
    }

    public static void L(boolean r10) {
        if (f11460k.get() != r10) goto L5;
        return;
    L5:
        f11460k.getAndSet(r10);
        e();
        if (r10 == true) goto L9;
        f11462m = new CountDownLatch(1);
        return;
    }

    public static void M(j r10) {
        f11464o = r10;
    }

    public static void N(String r10) {
        if (r10 != null) goto L19;
    L16:
        f11455f = r10;
        return;
    L19:
        if (r10.length() <= 0) goto L16;
        char[] r11 = r10.toCharArray();     // Catch: Exception -> L18
        int r12 = r11.length;     // Catch: Exception -> L18
        int r13 = 0;
        boolean r14 = false;
    L6:
        if (r13 >= r12) goto L13;
        if (r11[r13] >= ' ') goto L10;
    L11:
        r11[r13] = '?';     // Catch: Exception -> L18
        r14 = true;
    L12:
        r13 = r13 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r11[r13] <= '~') goto L12;
    L13:
        if (r14 == false) goto L16;
        r10 = new String(r11);     // Catch: Exception -> L18
        goto L16
    }

    public static void O(int r10) {
        f11475z = r10;
    }

    public static void P(boolean r10) {
        A.set(r10);
    }

    public static void Q(l r10) {
        f11458i = r10;
        z.t(f11451b);
    }

    public static void R(boolean r10) {
        f11474y = r10;
    }

    private static o2.h S(String r10, o2.b r11, boolean r12, List<n4.b> r13, Map<String, List<String>> r14) {
        o2.h r15 = new o2.h(false);
        if (f11468s != null) goto L6;
        return r15;
    L6:
        if (r13 == null) goto L17;
        Iterator<n4.b> r16 = r13.iterator();
    L9:
        if (r16.hasNext() == false) goto L17;
        n4.b r17 = r16.next();
        if (r17 == null) goto L9;
        if ("x-tt-bypass-retry-for-account".equalsIgnoreCase(r17.a()) == false) goto L9;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r17.b()) == false) goto L9;
        return r15;
    L17:
        long r18 = SystemClock.uptimeMillis();
        r15 = f11468s.a(r10, r13, r14, r12);     // Catch: Throwable -> L29
    L19:
        r11.I = SystemClock.uptimeMillis() - r18;
        if (r12 == true) goto L28;
        if (r15 == null) goto L28;
        if (r15.d() == false) goto L28;
        HashMap r19 = new HashMap();
        r19.put("x-tt-retry-for-account", NetConst.ENCRYPT_VERISON_CODE);
        if (r15.a() == null) goto L27;
        r19.putAll(r15.a());
    L27:
        r15.e(r19);
        r11.H = true;
    L28:
        return r15;
    }

    private static o2.h T(n4.c r10, o2.b r11, List<n4.b> r12, Map<String, List<String>> r13) {
        boolean r14 = false;
        o2.h r15 = new o2.h(false);
        if (r13 != null) goto L5;
    L50:
        return r15;
    L5:
        if (r13.isEmpty() == true) goto L50;
        if (f11469t.isEmpty() == true) goto L50;
        Iterator<String> r16 = r13.keySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L17;
        String r17 = r16.next();
        if (com.bytedance.common.utility.g.b(r17) == true) goto L11;
        if (r17.toLowerCase().contains("verify") == false) goto L11;
        r14 = true;
    L17:
        if (r14 == true) goto L19;
        return r15;
    L19:
        Map.Entry<String, o> r18 = q(r13.keySet());
        if (r18 != null) goto L23;
        return r15;
    L23:
        if (r12 == null) goto L34;
        String r19 = "x-tt-bypass-retry-by-" + r18.getKey();
        Iterator<n4.b> r20 = r12.iterator();
    L26:
        if (r20.hasNext() == false) goto L34;
        n4.b r21 = r20.next();
        if (r21 == null) goto L26;
        if (r19.equalsIgnoreCase(r21.a()) == false) goto L26;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r21.b()) == false) goto L26;
        return r15;
    L34:
        o r22 = r18.getValue();
        if (r22 != null) goto L37;
        return r15;
    L37:
        long r23 = SystemClock.uptimeMillis();
        if ((r22 instanceof p) == false) goto L40;
        o2.h r24 = ((p) r22).b(r10.G(), r12, r13);
    L41:
        r11.E = SystemClock.uptimeMillis() - r23;
        r11.G = r18.getKey();
        if (r24 != null) goto L44;
    L49:
        return r24;
    L44:
        if (r24.d() == false) goto L49;
        r11.F = true;
        Map<String, String> r25 = r24.a();
        if (r25 != null) goto L48;
        r25 = new HashMap();
    L48:
        r25.put("x-tt-retry-by-" + r18.getKey(), NetConst.ENCRYPT_VERISON_CODE);
        r24.e(r25);
        goto L49
    L40:
        r24 = r22.a(r13);
        goto L41
    }

    private static o2.h U(n4.c r16, o2.b r17, int r18, List<n4.b> r19, Map<String, List<String>> r20, boolean r21) {
        o2.h r10 = new o2.h(false);
        if (r21 == false) goto L5;
    L38:
        return r10;
    L5:
        if (r17.F == true) goto L38;
        if (r17.H == true) goto L38;
        if (A.get() == true) goto L38;
        if (f11470u == null) goto L38;
        o2.i r11 = r17.K;
        if (r11 != null) goto L17;
        return r10;
    L17:
        if (r11.c() == false) goto L20;
        r11.d(r16.w(), r16.A(), r18, -1, r10, r17);
        return r10;
    L20:
        String r12 = r16.G();
        o2.c.b r13 = r11.b();
        if (r13 != null) goto L23;
        return r10;
    L23:
        String r14 = r13.f11446a;
        String r15 = r13.f11447b;
        if (TextUtils.isEmpty(r14) == true) goto L38;
        if (TextUtils.isEmpty(r15) == true) goto L38;
        String r110 = r16.w();
        String r111 = r16.A();
        String r112 = r12.replaceFirst(r110, r14).replaceFirst(r111, r15);
        long r113 = SystemClock.elapsedRealtime();
        r10 = f11470u.a(r12, r112, r17, r18, r19, r20);     // Catch: Throwable -> L31
    L33:
        r11.d(r110, r111, r18, SystemClock.elapsedRealtime() - r113, r10, r17);
        if (r10 == null) goto L38;
        if (r10.d() == false) goto L38;
        r17.f11393J = true;
        r10.f(r112);
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L33
    }

    private static o2.h V(o2.b r10, List<n4.b> r11, Map<String, List<String>> r12) {
        o2.h r13 = new o2.h(false);
        if (r12 != null) goto L5;
    L30:
        return r13;
    L5:
        if (r12.containsKey("bdturing-verify") == false) goto L30;
        if (r11 == null) goto L19;
        Iterator<n4.b> r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L19;
        n4.b r15 = r14.next();
        if (r15 == null) goto L11;
        if ("x-tt-bypass-bdturing".equalsIgnoreCase(r15.a()) == false) goto L11;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r15.b()) == false) goto L11;
        return r13;
    L19:
        TreeMap r16 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r16.putAll(r12);
        long r17 = SystemClock.uptimeMillis();
        o2.h r18 = E(r16);
        r10.E = SystemClock.uptimeMillis() - r17;
        if (r16.containsKey("bdturing-verify") == true) goto L22;
        r10.D = true;
        r10.G = "bdturing-verify";
    L22:
        if (r18 != null) goto L24;
    L29:
        return r18;
    L24:
        if (r18.d() == false) goto L29;
        r10.F = true;
        HashMap r19 = new HashMap();
        r19.put("x-tt-bdturing-retry", NetConst.ENCRYPT_VERISON_CODE);
        if (r18.a() == null) goto L28;
        r19.putAll(r18.a());
    L28:
        r18.e(r19);
        goto L29
    }

    public static o2.h W(n4.c r10, int r11, o2.b r12, List<n4.b> r13, Map<String, List<String>> r14, boolean r15, boolean r16) {
        boolean r17 = false;
        o2.h r18 = new o2.h(false);
        r12.f11393J = false;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return r18;
    L6:
        if (r11 != 200) goto L8;
    L9:
        if (r15 == false) goto L11;
        o2.h r19 = V(r12, r13, r14);
        if (r12.D == true) goto L16;
        r19 = T(r10, r12, r13, r14);
    L16:
        if (r19 != null) goto L18;
    L20:
        boolean r20 = false;
    L21:
        o2.h r21 = S(r10.G(), r12, r20, r13, r14);
        if (r20 == true) goto L24;
        r19 = r21;
    L31:
        if (r19 != null) goto L33;
    L35:
        if (r17 == false) goto L11;
        return r19;
    L33:
        if (r19.d() == false) goto L35;
        r17 = true;
        goto L35
    L24:
        if (r21 == null) goto L31;
        if (r21.a() == null) goto L31;
        HashMap r22 = new HashMap();
        if (r19.a() == null) goto L30;
        r22.putAll(r19.a());
    L30:
        r22.putAll(r21.a());
        r19.e(r22);
        goto L31
    L18:
        if (r19.d() == false) goto L20;
        r20 = true;
    L11:
        return U(r10, r12, r11, r13, r14, r16);
    L8:
        if (w(r14) == false) goto L11;
        goto L9
    }

    public static Map<String, String> X(String r10, Map<String, List<String>> r11) {
        a r12 = f11472w;
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.onCallToAddSecurityFactor(r10, r11);
    }

    public static String Y(String r10, boolean r11, Object... r12) {
        d r13 = f11457h;
        if (r13 != null) goto L5;
        return r10;
    L5:
        return r13.a(r10, r11, r12);
    }

    public static Map<String, String> Z(String r10, Map<String, List<String>> r11) {
        b r12 = f11471v;
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.onCallToAddSecurityFactor(r10, r11);
    }

    static /* synthetic */ l a() {
        return f11458i;
    }

    public static void a0() {
        d r10 = f11457h;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    static /* synthetic */ c b() {
        return f11450a;
    }

    public static CookieManager b0() {
        Object r10 = f11461l;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (f11460k.get() == false) goto L24;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L19
        CookieManager r11 = null;
        r11 = CookieManager.getInstance();     // Catch: Throwable -> L22
        if (r11.acceptCookie() == true) goto L18;
        r11.setAcceptCookie(true);     // Catch: Throwable -> L22
    L18:
        return r11;
    L24:
        CountDownLatch r12 = f11462m;     // Catch: Exception -> L23 Throwable -> L19
        if (r12 == null) goto L12;
        r12.await(5000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L23 Throwable -> L19
        if (f11462m.getCount() != 1) goto L12;
        f11462m.countDown();     // Catch: Exception -> L23 Throwable -> L19
    L12:
        f11460k.getAndSet(true);     // Catch: Throwable -> L19
        goto L13
    }

    public static String c(String r10, boolean r11) {
        d r12 = f11457h;
        if (r12 != null) goto L5;
        return r10;
    L5:
        return r12.d(r10, r11);
    }

    public static CookieManager c0() {
        return d0("");
    }

    public static synchronized boolean d(String r10, o r11) {
        monitor-enter(f.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (com.bytedance.common.utility.g.b(r10) == false) goto L7;
    L21:
        monitor-exit(f.class);
        return false;
    L7:
        if (r10.toLowerCase().contains("verify") == false) goto L21;
        if (r11 == null) goto L21;
        Iterator<String> r12 = f11469t.keySet().iterator();     // Catch: Throwable -> L23
    L12:
        if (r12.hasNext() == false) goto L17;
        if (r12.next().equalsIgnoreCase(r10) == false) goto L12;
        monitor-exit(f.class);
        return false;
    L17:
        f11469t.put(r10, r11);     // Catch: Throwable -> L23
        monitor-exit(f.class);
        return true;
    }

    public static CookieManager d0(String r10) {
        a0();
        return b0();
    }

    private static void e() {
        CountDownLatch r10 = f11462m;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getCount() <= 0) goto L9;
        f11462m.countDown();
        return;
    }

    public static String f(String r10) {
        return g(r10, null);
    }

    public static String g(String r10, o2.c r11) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L5;
        return r10;
    L5:
        e r12 = f11463n;
        if (r12 != null) goto L8;
        return r10;
    L8:
        return r12.a(r10, r11);
    }

    public static InterfaceC0255f h() {
        return f11465p;
    }

    public static h i() {
        return f11456g;
    }

    public static int j() {
        return 15000;
    }

    public static i k() {
        return f11453d;
    }

    public static j l() {
        return f11464o;
    }

    public static k m() {
        return f11452c;
    }

    public static int n() {
        return f11475z;
    }

    public static boolean o() {
        return f11473x;
    }

    public static int p() {
        return 15000;
    }

    private static synchronized Map.Entry<String, o> q(Set<String> r10) {
        monitor-enter(f.class);
        Iterator<Map.Entry<String, o>> r11 = f11469t.entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r11.hasNext() == false) goto L17;
        Map.Entry<String, o> r12 = r11.next();     // Catch: Throwable -> L19
        Iterator<String> r13 = r10.iterator();     // Catch: Throwable -> L19
    L9:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.g.b(r14) == true) goto L9;
        if (r14.equalsIgnoreCase(r12.getKey()) == false) goto L9;
        monitor-exit(f.class);
        return r12;
    L17:
        monitor-exit(f.class);
        return null;
    L19:
        th = move-exception;
        throw th;
    }

    public static s r() {
        return f11454e;
    }

    public static String s() {
        return f11455f;
    }

    @Deprecated
    public static void t(String r10, Throwable r11, o2.b r12) {
        if (com.bytedance.common.utility.g.b(r10) == true) goto L17;
        if (r11 == null) goto L22;
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.Q == true) goto L23;
        d r13 = f11457h;
        m r14 = f11459j;
        if (r13 == null) goto L19;
        if (r14 != null) goto L14;
        return;
    L14:
        if (r14.a() == false) goto L21;
        r13.b(r10, r11, r12.f11405l - r12.f11401h, r12);
        return;
    L21:
        return;
    L19:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Deprecated
    public static void u(String r10, o2.b r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.Q == true) goto L22;
        d r12 = f11457h;
        m r13 = f11459j;
        long r14 = r11.f11405l - r11.f11401h;
        if (com.bytedance.common.utility.g.b(r10) == false) goto L9;
        return;
    L9:
        if (r14 <= 0) goto L18;
        if (r12 == null) goto L19;
        if (r13 != null) goto L13;
        return;
    L13:
        if (r13.a() == false) goto L21;
        r12.c(r10, r14, r11);
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static boolean v(String r10, String r11) {
        l r12 = f11458i;
        if (r12 != null) goto L5;
        return false;
    L5:
        if (com.bytedance.common.utility.g.b(r10) == false) goto L7;
        return false;
    L7:
        if (com.bytedance.common.utility.g.b(r11) == false) goto L9;
        return false;
    L9:
        return r12.handleApiSample(r10, r11);
    }

    private static boolean w(Map<String, List<String>> r10) {
        if (r10 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L16;
        Iterator<String> r11 = r10.keySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();
        if (com.bytedance.common.utility.g.b(r12) == true) goto L9;
        if (r12.toLowerCase().contains("ignore-status-code") == false) goto L9;
        return true;
    }

    public static boolean x(Object r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r10 instanceof o2.c) == false) goto L8;
        if (((o2.c) r10).f11443x == false) goto L8;
        return true;
    }

    public static boolean y() {
        return f11474y;
    }

    public static void z(long r10, long r11, String r13, String r14, o2.b r15, Throwable r16) {
        if (r15 != null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.g.b(r15.A) == false) goto L7;
        return;
    L7:
        if (r15.Q == false) goto L10;
        return;
    L10:
        if (com.bytedance.common.utility.g.b(r13) == true) goto L22;
        if (r16 == null) goto L25;
        l r12 = f11458i;
        if (r12 != null) goto L16;
        return;
    L16:
        if (r15.C == false) goto L18;
        r15.M.set(true);
    L18:
        r12.a(r10, r11, r13, r14, r15, r16);
        return;
    L25:
        return;
    }
}
