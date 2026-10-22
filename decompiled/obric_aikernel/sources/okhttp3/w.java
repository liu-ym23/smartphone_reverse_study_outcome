package okhttp3;

import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.crash.dumper.Scraps;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1116:1\n2624#2,3:1117\n2624#2,3:1120\n1#3:1123\n*S KotlinDebug\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient\n*L\n237#1:1117,3\n267#1:1120,3\n*E\n"})
public class w implements Cloneable {
    public static final b L = null;
    private static final List<Protocol> M = null;
    private static final List<k> N = null;
    private final CertificatePinner A;
    private final qc.c B;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final long H;
    private final TTNetDns I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final boolean f12069J;
    private final okhttp3.internal.connection.g K;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f12070c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j f12071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<t> f12072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<t> f12073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final q.c f12074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f12075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final okhttp3.b f12076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f12077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f12078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final m f12079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final c f12080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final p f12081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Proxy f12082r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ProxySelector f12083s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final okhttp3.b f12084t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final SocketFactory f12085u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final SSLSocketFactory f12086v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final X509TrustManager f12087w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List<k> f12088x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List<Protocol> f12089y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final HostnameVerifier f12090z;

    @SourceDebugExtension({"SMAP\nOkHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClient.kt\nokhttp3/OkHttpClient$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1116:1\n1#2:1117\n*E\n"})
    public static final class a {
        private int A;
        private int B;
        private long C;
        private okhttp3.internal.connection.g D;
        private TTNetDns E;
        private boolean F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private o f12091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f12092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<t> f12093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<t> f12094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private q.c f12095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f12096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private okhttp3.b f12097g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12098h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f12099i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private m f12100j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private c f12101k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private p f12102l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Proxy f12103m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private ProxySelector f12104n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private okhttp3.b f12105o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private SocketFactory f12106p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private SSLSocketFactory f12107q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private X509TrustManager f12108r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private List<k> f12109s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private List<? extends Protocol> f12110t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private HostnameVerifier f12111u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private CertificatePinner f12112v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private qc.c f12113w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f12114x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f12115y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f12116z;

        public a() {
            this.f12091a = new o();
            this.f12092b = new j();
            this.f12093c = new ArrayList();
            this.f12094d = new ArrayList();
            this.f12095e = hc.e.g(q.f12021a);
            this.f12096f = true;
            okhttp3.b r10 = okhttp3.b.f11682a;
            this.f12097g = r10;
            this.f12098h = true;
            this.f12099i = true;
            this.f12100j = m.f12010a;
            this.f12102l = p.f12019a;
            this.f12105o = r10;
            SocketFactory r11 = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(r11, "getDefault()");
            this.f12106p = r11;
            b r12 = w.L;
            this.f12109s = r12.a();
            this.f12110t = r12.b();
            this.f12111u = qc.d.f12506a;
            this.f12112v = CertificatePinner.f11654d;
            this.f12115y = 10000;
            this.f12116z = 10000;
            this.A = 10000;
            this.C = 1024;
        }

        public a(w r10) {
            Intrinsics.checkNotNullParameter(r10, "okHttpClient");
            this();
            this.f12091a = r10.o();
            this.f12092b = r10.l();
            CollectionsKt.addAll(this.f12093c, r10.w());
            CollectionsKt.addAll(this.f12094d, r10.y());
            this.f12095e = r10.r();
            this.f12096f = r10.H();
            this.f12097g = r10.f();
            this.f12098h = r10.s();
            this.f12099i = r10.t();
            this.f12100j = r10.n();
            r10.g();
            this.f12102l = r10.p();
            this.f12103m = r10.D();
            this.f12104n = r10.F();
            this.f12105o = r10.E();
            this.f12106p = r10.I();
            this.f12107q = w.e(r10);
            this.f12108r = r10.N();
            this.f12109s = r10.m();
            this.f12110t = r10.C();
            this.f12111u = r10.v();
            this.f12112v = r10.j();
            this.f12113w = r10.i();
            this.f12114x = r10.h();
            this.f12115y = r10.k();
            this.f12116z = r10.G();
            this.A = r10.M();
            this.B = r10.B();
            this.C = r10.x();
            this.D = r10.u();
            this.E = r10.K();
            this.F = r10.q();
        }

        public final boolean A() {
            return this.f12099i;
        }

        public final HostnameVerifier B() {
            return this.f12111u;
        }

        public final List<t> C() {
            return this.f12093c;
        }

        public final long D() {
            return this.C;
        }

        public final List<t> E() {
            return this.f12094d;
        }

        public final int F() {
            return this.B;
        }

        public final List<Protocol> G() {
            return this.f12110t;
        }

        public final Proxy H() {
            return this.f12103m;
        }

        public final okhttp3.b I() {
            return this.f12105o;
        }

        public final ProxySelector J() {
            return this.f12104n;
        }

        public final int K() {
            return this.f12116z;
        }

        public final boolean L() {
            return this.f12096f;
        }

        public final okhttp3.internal.connection.g M() {
            return this.D;
        }

        public final SocketFactory N() {
            return this.f12106p;
        }

        public final SSLSocketFactory O() {
            return this.f12107q;
        }

        public final TTNetDns P() {
            return this.E;
        }

        public final int Q() {
            return this.A;
        }

        public final X509TrustManager R() {
            return this.f12108r;
        }

        public final a S(List<? extends Protocol> r10) {
            Intrinsics.checkNotNullParameter(r10, "protocols");
            List r11 = CollectionsKt.toMutableList(r10);
            Protocol r12 = Protocol.H2_PRIOR_KNOWLEDGE;
            boolean r13 = false;
            if (r11.contains(r12) == false) goto L5;
        L8:
            boolean r14 = true;
        L9:
            if (r14 == false) goto L32;
            if (r11.contains(r12) == true) goto L13;
        L14:
            r13 = true;
        L15:
            if (r13 == false) goto L30;
            if ((!r11.contains(Protocol.HTTP_1_0)) == false) goto L28;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if ((!r11.contains(null)) == false) goto L26;
            r11.remove(Protocol.SPDY_3);
            if (Intrinsics.areEqual(r11, this.f12110t) == true) goto L23;
            this.D = null;
        L23:
            List<? extends Protocol> r15 = Collections.unmodifiableList(r11);
            Intrinsics.checkNotNullExpressionValue(r15, "unmodifiableList(protocolsCopy)");
            this.f12110t = r15;
            return this;
        L26:
            throw new IllegalArgumentException("protocols must not contain null".toString());
        L28:
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + r11).toString());
        L30:
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + r11).toString());
        L13:
            if (r11.size() > 1) goto L15;
        L32:
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + r11).toString());
        L5:
            if (r11.contains(Protocol.HTTP_1_1) == true) goto L8;
            r14 = false;
            goto L9
        }

        public final a T(Proxy r10) {
            if (Intrinsics.areEqual(r10, this.f12103m) == true) goto L5;
            this.D = null;
        L5:
            this.f12103m = r10;
            return this;
        }

        public final a U(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
            this.f12116z = hc.e.k("timeout", r10, r11);
            return this;
        }

        public final a V(boolean r10) {
            this.f12096f = r10;
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        public final a W(SSLSocketFactory r10) {
            Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
            if (Intrinsics.areEqual(r10, this.f12107q) == true) goto L5;
            this.D = null;
        L5:
            this.f12107q = r10;
            okhttp3.internal.platform.h.a r11 = okhttp3.internal.platform.h.f11979a;
            X509TrustManager r12 = r11.g().p(r10);
            if (r12 == null) goto L10;
            this.f12108r = r12;
            okhttp3.internal.platform.h r13 = r11.g();
            X509TrustManager r14 = this.f12108r;
            Intrinsics.checkNotNull(r14);
            this.f12113w = r13.c(r14);
            return this;
        L10:
            throw new IllegalStateException("Unable to extract the trust manager on " + r11.g() + ", sslSocketFactory is " + r10.getClass());
        }

        public final a X(SSLSocketFactory r10, X509TrustManager r11) {
            Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(r11, "trustManager");
            if (Intrinsics.areEqual(r10, this.f12107q) == true) goto L5;
        L6:
            this.D = null;
        L7:
            this.f12107q = r10;
            this.f12113w = qc.c.f12505a.a(r11);
            this.f12108r = r11;
            return this;
        L5:
            if (Intrinsics.areEqual(r11, this.f12108r) == true) goto L7;
            goto L6
        }

        public final a Y(TTNetDns r10) {
            Intrinsics.checkNotNullParameter(r10, "ttnetDns");
            this.E = r10;
            return this;
        }

        public final a Z(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
            this.A = hc.e.k("timeout", r10, r11);
            return this;
        }

        public final a a(t r10) {
            Intrinsics.checkNotNullParameter(r10, "interceptor");
            this.f12093c.add(r10);
            return this;
        }

        public final a b(t r10) {
            Intrinsics.checkNotNullParameter(r10, "interceptor");
            this.f12094d.add(r10);
            return this;
        }

        public final w c() {
            return new w(this);
        }

        public final a d(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
            this.f12115y = hc.e.k("timeout", r10, r11);
            return this;
        }

        public final a e(j r10) {
            Intrinsics.checkNotNullParameter(r10, "connectionPool");
            this.f12092b = r10;
            return this;
        }

        public final a f(List<k> r10) {
            Intrinsics.checkNotNullParameter(r10, "connectionSpecs");
            if (Intrinsics.areEqual(r10, this.f12109s) == true) goto L5;
            this.D = null;
        L5:
            this.f12109s = hc.e.T(r10);
            return this;
        }

        public final a g(m r10) {
            Intrinsics.checkNotNullParameter(r10, "cookieJar");
            this.f12100j = r10;
            return this;
        }

        public final a h(o r10) {
            Intrinsics.checkNotNullParameter(r10, "dispatcher");
            this.f12091a = r10;
            return this;
        }

        public final a i(p r10) {
            Intrinsics.checkNotNullParameter(r10, "dns");
            if (Intrinsics.areEqual(r10, this.f12102l) == true) goto L5;
            this.D = null;
        L5:
            this.f12102l = r10;
            return this;
        }

        public final a j(boolean r10) {
            this.F = r10;
            return this;
        }

        public final a k(q r10) {
            Intrinsics.checkNotNullParameter(r10, "eventListener");
            this.f12095e = hc.e.g(r10);
            return this;
        }

        public final a l(boolean r10) {
            this.f12098h = r10;
            return this;
        }

        public final okhttp3.b m() {
            return this.f12097g;
        }

        public final c n() {
            return this.f12101k;
        }

        public final int o() {
            return this.f12114x;
        }

        public final qc.c p() {
            return this.f12113w;
        }

        public final CertificatePinner q() {
            return this.f12112v;
        }

        public final int r() {
            return this.f12115y;
        }

        public final j s() {
            return this.f12092b;
        }

        public final List<k> t() {
            return this.f12109s;
        }

        public final m u() {
            return this.f12100j;
        }

        public final o v() {
            return this.f12091a;
        }

        public final p w() {
            return this.f12102l;
        }

        public final boolean x() {
            return this.F;
        }

        public final q.c y() {
            return this.f12095e;
        }

        public final boolean z() {
            return this.f12098h;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final List<k> a() {
            return w.b();
        }

        public final List<Protocol> b() {
            return w.d();
        }
    }

    static {
        L = new b(null);
        M = hc.e.w(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        N = hc.e.w(new k[]{k.f11985g, k.f11987i});
    }

    public w() {
        this(new a());
    }

    public w(a r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.f12070c = r10.v();
        this.f12071g = r10.s();
        this.f12072h = hc.e.T(r10.C());
        this.f12073i = hc.e.T(r10.E());
        this.f12074j = r10.y();
        this.f12075k = r10.L();
        this.f12076l = r10.m();
        this.f12077m = r10.z();
        this.f12078n = r10.A();
        this.f12079o = r10.u();
        r10.n();
        this.f12081q = r10.w();
        this.f12082r = r10.H();
        if (r10.H() == null) goto L5;
    L4:
        ProxySelector r11 = oc.a.f11652a;
    L10:
        this.f12083s = r11;
        this.f12084t = r10.I();
        this.f12085u = r10.N();
        List<k> r12 = r10.t();
        this.f12088x = r12;
        this.f12089y = r10.G();
        this.f12090z = r10.B();
        this.C = r10.o();
        this.D = r10.r();
        this.E = r10.K();
        this.F = r10.Q();
        this.G = r10.F();
        this.H = r10.D();
        this.I = r10.P();
        this.f12069J = r10.x();
        okhttp3.internal.connection.g r13 = r10.M();
        if (r13 != null) goto L13;
        r13 = new okhttp3.internal.connection.g();
    L13:
        this.K = r13;
        boolean r14 = true;
        if ((r12 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r15 = r12.iterator();
    L20:
        if (r15.hasNext() == false) goto L24;
        if (((k) r15.next()).f() == false) goto L20;
        r14 = false;
    L24:
        if (r14 == false) goto L28;
        this.f12086v = null;
        this.B = null;
        this.f12087w = null;
        CertificatePinner r16 = CertificatePinner.f11654d;
    L26:
        this.A = r16;
        L();
        return;
    L28:
        if (r10.O() == null) goto L30;
        this.f12086v = r10.O();
        qc.c r17 = r10.p();
        Intrinsics.checkNotNull(r17);
        this.B = r17;
        X509TrustManager r18 = r10.R();
        Intrinsics.checkNotNull(r18);
        this.f12087w = r18;
    L31:
        CertificatePinner r19 = r10.q();
        Intrinsics.checkNotNull(r17);
        r16 = r19.e(r17);
        goto L26
    L30:
        okhttp3.internal.platform.h.a r20 = okhttp3.internal.platform.h.f11979a;
        X509TrustManager r21 = r20.g().o();
        this.f12087w = r21;
        okhttp3.internal.platform.h r22 = r20.g();
        Intrinsics.checkNotNull(r21);
        this.f12086v = r22.n(r21);
        qc.c.a r23 = qc.c.f12505a;
        Intrinsics.checkNotNull(r21);
        r17 = r23.a(r21);
        this.B = r17;
        goto L31
    L16:
        if (r12.isEmpty() == false) goto L18;
    L5:
        r11 = r10.J();
        if (r11 != null) goto L8;
        r11 = ProxySelector.getDefault();
    L8:
        if (r11 != null) goto L10;
        goto L10
    }

    private final void L() {
        List<t> r10 = this.f12072h;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        boolean r11 = true;
        if ((!r10.contains(null)) == false) goto L61;
        List<t> r12 = this.f12073i;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if ((!r12.contains(null)) == false) goto L59;
        List<k> r13 = this.f12088x;
        if ((r13 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L10;
        if (((k) r14.next()).f() == false) goto L13;
        boolean r15 = false;
    L17:
        if (r15 == false) goto L46;
        if (this.f12086v != null) goto L21;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L44;
        if (this.B != null) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == false) goto L42;
        if (this.f12087w == null) goto L33;
        r11 = false;
    L33:
        if (r11 == false) goto L40;
        if (Intrinsics.areEqual(this.A, CertificatePinner.f11654d) == false) goto L38;
        return;
    L38:
        throw new IllegalStateException("Check failed.".toString());
    L40:
        throw new IllegalStateException("Check failed.".toString());
    L42:
        throw new IllegalStateException("Check failed.".toString());
    L27:
        r17 = false;
        goto L28
    L44:
        throw new IllegalStateException("Check failed.".toString());
    L21:
        r16 = false;
        goto L23
    L46:
        if (this.f12086v == null) goto L57;
        if (this.B == null) goto L55;
        if (this.f12087w == null) goto L53;
        return;
    L53:
        throw new IllegalStateException("x509TrustManager == null".toString());
    L55:
        throw new IllegalStateException("certificateChainCleaner == null".toString());
    L57:
        throw new IllegalStateException("sslSocketFactory == null".toString());
    L10:
        r15 = true;
        goto L17
    L9:
        if (r13.isEmpty() == false) goto L11;
    L59:
        throw new IllegalStateException(("Null network interceptor: " + this.f12073i).toString());
    L61:
        throw new IllegalStateException(("Null interceptor: " + this.f12072h).toString());
    }

    public static final /* synthetic */ List b() {
        return N;
    }

    public static final /* synthetic */ List d() {
        return M;
    }

    public static final /* synthetic */ SSLSocketFactory e(w r10) {
        return r10.f12086v;
    }

    public e A(x r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        return new okhttp3.internal.connection.e(this, r10, false);
    }

    @JvmName(name = "pingIntervalMillis")
    public final int B() {
        return this.G;
    }

    @JvmName(name = "protocols")
    public final List<Protocol> C() {
        return this.f12089y;
    }

    @JvmName(name = "proxy")
    public final Proxy D() {
        return this.f12082r;
    }

    @JvmName(name = "proxyAuthenticator")
    public final okhttp3.b E() {
        return this.f12084t;
    }

    @JvmName(name = "proxySelector")
    public final ProxySelector F() {
        return this.f12083s;
    }

    @JvmName(name = "readTimeoutMillis")
    public final int G() {
        return this.E;
    }

    @JvmName(name = "retryOnConnectionFailure")
    public final boolean H() {
        return this.f12075k;
    }

    @JvmName(name = "socketFactory")
    public final SocketFactory I() {
        return this.f12085u;
    }

    @JvmName(name = "sslSocketFactory")
    public final SSLSocketFactory J() {
        SSLSocketFactory r10 = this.f12086v;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName(name = "ttnetDns")
    public final TTNetDns K() {
        return this.I;
    }

    @JvmName(name = "writeTimeoutMillis")
    public final int M() {
        return this.F;
    }

    @JvmName(name = "x509TrustManager")
    public final X509TrustManager N() {
        return this.f12087w;
    }

    public Object clone() {
        return super.clone();
    }

    @JvmName(name = "authenticator")
    public final okhttp3.b f() {
        return this.f12076l;
    }

    @JvmName(name = CommonProcUtil.CACHE)
    public final c g() {
        return this.f12080p;
    }

    @JvmName(name = "callTimeoutMillis")
    public final int h() {
        return this.C;
    }

    @JvmName(name = "certificateChainCleaner")
    public final qc.c i() {
        return this.B;
    }

    @JvmName(name = "certificatePinner")
    public final CertificatePinner j() {
        return this.A;
    }

    @JvmName(name = "connectTimeoutMillis")
    public final int k() {
        return this.D;
    }

    @JvmName(name = "connectionPool")
    public final j l() {
        return this.f12071g;
    }

    @JvmName(name = "connectionSpecs")
    public final List<k> m() {
        return this.f12088x;
    }

    @JvmName(name = "cookieJar")
    public final m n() {
        return this.f12079o;
    }

    @JvmName(name = "dispatcher")
    public final o o() {
        return this.f12070c;
    }

    @JvmName(name = "dns")
    public final p p() {
        return this.f12081q;
    }

    @JvmName(name = "enableBoe")
    public final boolean q() {
        return this.f12069J;
    }

    @JvmName(name = "eventListenerFactory")
    public final q.c r() {
        return this.f12074j;
    }

    @JvmName(name = "followRedirects")
    public final boolean s() {
        return this.f12077m;
    }

    @JvmName(name = "followSslRedirects")
    public final boolean t() {
        return this.f12078n;
    }

    public final okhttp3.internal.connection.g u() {
        return this.K;
    }

    @JvmName(name = "hostnameVerifier")
    public final HostnameVerifier v() {
        return this.f12090z;
    }

    @JvmName(name = "interceptors")
    public final List<t> w() {
        return this.f12072h;
    }

    @JvmName(name = "minWebSocketMessageToCompress")
    public final long x() {
        return this.H;
    }

    @JvmName(name = "networkInterceptors")
    public final List<t> y() {
        return this.f12073i;
    }

    public a z() {
        return new a(this);
    }
}
