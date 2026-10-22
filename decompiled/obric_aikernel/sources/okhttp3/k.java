package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConnectionSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,350:1\n11065#2:351\n11400#2,3:352\n11065#2:355\n11400#2,3:356\n*S KotlinDebug\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec\n*L\n59#1:351\n59#1:352,3\n75#1:355\n75#1:356,3\n*E\n"})
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h[] f11983e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final h[] f11984f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final k f11985g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final k f11986h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final k f11987i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f11990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f11991d;

    @SourceDebugExtension({"SMAP\nConnectionSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,350:1\n1#2:351\n11065#3:352\n11400#3,3:353\n11065#3:358\n11400#3,3:359\n37#4,2:356\n37#4,2:362\n*S KotlinDebug\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec$Builder\n*L\n225#1:352\n225#1:353,3\n244#1:358\n244#1:359,3\n225#1:356,2\n244#1:362,2\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f11993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f11994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11995d;

        public a(k r10) {
            Intrinsics.checkNotNullParameter(r10, "connectionSpec");
            this.f11992a = r10.f();
            this.f11993b = k.a(r10);
            this.f11994c = k.b(r10);
            this.f11995d = r10.h();
        }

        public a(boolean r10) {
            this.f11992a = r10;
        }

        public final k a() {
            return new k(this.f11992a, this.f11995d, this.f11993b, this.f11994c);
        }

        public final a b(String... r10) {
            Intrinsics.checkNotNullParameter(r10, "cipherSuites");
            if (this.f11992a == false) goto L15;
            if (r10.length != 0) goto L7;
            boolean r11 = true;
        L9:
            if ((!r11) == false) goto L13;
            this.f11993b = (String[]) r10.clone();
            return this;
        L13:
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        L7:
            r11 = false;
            goto L9
        L15:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a c(h... r10) {
            Intrinsics.checkNotNullParameter(r10, "cipherSuites");
            if (this.f11992a == false) goto L10;
            ArrayList r11 = new ArrayList(r10.length);
            int r12 = r10.length;
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            r11.add(r10[r13].c());
            r13 = r13 + 1;
            goto L5
        L7:
            String[] r14 = (String[]) r11.toArray(new String[0]);
            return b((String[]) Arrays.copyOf(r14, r14.length));
        L10:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        public final a d(boolean r10) {
            if (this.f11992a == false) goto L7;
            this.f11995d = r10;
            return this;
        L7:
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final a e(String... r10) {
            Intrinsics.checkNotNullParameter(r10, "tlsVersions");
            if (this.f11992a == false) goto L15;
            if (r10.length != 0) goto L7;
            boolean r11 = true;
        L9:
            if ((!r11) == false) goto L13;
            this.f11994c = (String[]) r10.clone();
            return this;
        L13:
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        L7:
            r11 = false;
            goto L9
        L15:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a f(TlsVersion... r10) {
            Intrinsics.checkNotNullParameter(r10, "tlsVersions");
            if (this.f11992a == false) goto L10;
            ArrayList r11 = new ArrayList(r10.length);
            int r12 = r10.length;
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            r11.add(r10[r13].javaName());
            r13 = r13 + 1;
            goto L5
        L7:
            String[] r14 = (String[]) r11.toArray(new String[0]);
            return e((String[]) Arrays.copyOf(r14, r14.length));
        L10:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new b(null);
        h r10 = h.f11728r;
        h r11 = h.f11729s;
        h r12 = h.f11730t;
        h r13 = h.f11722l;
        h r14 = h.f11724n;
        h r15 = h.f11723m;
        h r16 = h.f11725o;
        h r17 = h.f11727q;
        h r18 = h.f11726p;
        h[] r19 = {r10, r11, r12, r13, r14, r15, r16, r17, r18};
        f11983e = r19;
        h[] r20 = {r10, r11, r12, r13, r14, r15, r16, r17, r18, h.f11720j, h.f11721k, h.f11718h, h.f11719i, h.f11716f, h.f11717g, h.f11715e};
        f11984f = r20;
        a r21 = new a(true).c((h[]) Arrays.copyOf(r19, r19.length));
        TlsVersion r22 = TlsVersion.TLS_1_3;
        TlsVersion r23 = TlsVersion.TLS_1_2;
        r21.f(new TlsVersion[]{r22, r23}).d(true).a();
        f11985g = new a(true).c((h[]) Arrays.copyOf(r20, r20.length)).f(new TlsVersion[]{r22, r23}).d(true).a();
        f11986h = new a(true).c((h[]) Arrays.copyOf(r20, r20.length)).f(new TlsVersion[]{r22, r23, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).d(true).a();
        f11987i = new a(false).a();
    }

    public k(boolean r10, boolean r11, String[] r12, String[] r13) {
        this.f11988a = r10;
        this.f11989b = r11;
        this.f11990c = r12;
        this.f11991d = r13;
    }

    public static final /* synthetic */ String[] a(k r10) {
        return r10.f11990c;
    }

    public static final /* synthetic */ String[] b(k r10) {
        return r10.f11991d;
    }

    private final k g(SSLSocket r10, boolean r11) {
        if (this.f11990c == null) goto L5;
        String[] r12 = r10.getEnabledCipherSuites();
        Intrinsics.checkNotNullExpressionValue(r12, "sslSocket.enabledCipherSuites");
        String[] r13 = hc.e.E(r12, this.f11990c, h.f11712b.c());
    L7:
        if (this.f11991d == null) goto L9;
        String[] r14 = r10.getEnabledProtocols();
        Intrinsics.checkNotNullExpressionValue(r14, "sslSocket.enabledProtocols");
        String[] r15 = hc.e.E(r14, this.f11991d, ComparisonsKt.naturalOrder());
    L10:
        String[] r16 = r10.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(r16, "supportedCipherSuites");
        int r17 = hc.e.x(r16, "TLS_FALLBACK_SCSV", h.f11712b.c());
        if (r11 == true) goto L13;
    L15:
        a r18 = new a(this);
        Intrinsics.checkNotNullExpressionValue(r13, "cipherSuitesIntersection");
        a r19 = r18.b((String[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r15, "tlsVersionsIntersection");
        return r19.e((String[]) Arrays.copyOf(r15, r15.length)).a();
    L13:
        if (r17 == (-1)) goto L15;
        Intrinsics.checkNotNullExpressionValue(r13, "cipherSuitesIntersection");
        String r20 = r16[r17];
        Intrinsics.checkNotNullExpressionValue(r20, "supportedCipherSuites[indexOfFallbackScsv]");
        r13 = hc.e.o(r13, r20);
        goto L15
    L9:
        r15 = r10.getEnabledProtocols();
        goto L10
    L5:
        r13 = r10.getEnabledCipherSuites();
        goto L7
    }

    public final void c(SSLSocket r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        k r12 = g(r10, r11);
        if (r12.i() == null) goto L6;
        r10.setEnabledProtocols(r12.f11991d);
    L6:
        if (r12.d() == null) goto L9;
        r10.setEnabledCipherSuites(r12.f11990c);
        return;
    }

    @JvmName(name = "cipherSuites")
    public final List<h> d() {
        String[] r10 = this.f11990c;
        if (r10 == null) goto L8;
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = 0;
        int r13 = r10.length;
    L5:
        if (r12 >= r13) goto L11;
        String r14 = r10[r12];
        r11.add(h.f11712b.b(r14));
        r12 = r12 + 1;
        goto L5
    L11:
        return CollectionsKt.toList(r11);
    L8:
        return null;
    }

    public final boolean e(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "socket");
        if (this.f11988a == true) goto L5;
        return false;
    L5:
        String[] r11 = this.f11991d;
        if (r11 != null) goto L8;
    L10:
        String[] r12 = this.f11990c;
        if (r12 != null) goto L13;
        return true;
    L13:
        if (hc.e.u(r12, r10.getEnabledCipherSuites(), h.f11712b.c()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (hc.e.u(r11, r10.getEnabledProtocols(), ComparisonsKt.naturalOrder()) == true) goto L10;
        return false;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof k) == true) goto L6;
        return false;
    L6:
        if (r10 != this) goto L8;
        return true;
    L8:
        boolean r11 = this.f11988a;
        k r12 = (k) r10;
        if (r11 == r12.f11988a) goto L11;
        return false;
    L11:
        if (r11 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f11990c, r12.f11990c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f11991d, r12.f11991d) == true) goto L19;
        return false;
    L19:
        if (this.f11989b == r12.f11989b) goto L21;
        return false;
    }

    @JvmName(name = "isTls")
    public final boolean f() {
        return this.f11988a;
    }

    @JvmName(name = "supportsTlsExtensions")
    public final boolean h() {
        return this.f11989b;
    }

    public int hashCode() {
        if (this.f11988a == false) goto L12;
        String[] r10 = this.f11990c;
        int r11 = 0;
        if (r10 == null) goto L7;
        int r12 = Arrays.hashCode(r10);
    L8:
        int r13 = (527 + r12) * 31;
        String[] r14 = this.f11991d;
        if (r14 == null) goto L14;
        r11 = Arrays.hashCode(r14);
    L14:
        return ((r13 + r11) * 31) + (!this.f11989b ? 1 : 0);
    L7:
        r12 = 0;
        goto L8
    L12:
        return 17;
    }

    @JvmName(name = "tlsVersions")
    public final List<TlsVersion> i() {
        String[] r10 = this.f11991d;
        if (r10 == null) goto L8;
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = 0;
        int r13 = r10.length;
    L5:
        if (r12 >= r13) goto L11;
        String r14 = r10[r12];
        r11.add(TlsVersion.Companion.a(r14));
        r12 = r12 + 1;
        goto L5
    L11:
        return CollectionsKt.toList(r11);
    L8:
        return null;
    }

    public String toString() {
        if (this.f11988a == true) goto L7;
        return "ConnectionSpec()";
    L7:
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f11989b + ')';
    }
}
