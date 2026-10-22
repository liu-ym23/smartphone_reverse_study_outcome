package okhttp3;

import java.net.ProxySelector;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpClient implements Cloneable, i {
    public static final List C = null;
    public static final List D = null;
    public final long A;
    public final RouteDatabase B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.web.jsbridge2.p f20587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f20588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f20589c;
    public final List d;
    public final v e;
    public final boolean f;
    public final r9.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f20591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final sj.e f20592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f20593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t f20594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ProxySelector f20595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r9.c f20596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SocketFactory f20597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SSLSocketFactory f20598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final X509TrustManager f20599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f20600r;
    public final List s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OkHostnameVerifier f20601t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f20602u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CertificateChainCleaner f20603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f20604w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f20605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f20606y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f20607z;

    static {
        C = Util.immutableListOf(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        D = Util.immutableListOf(new q[]{q.e, q.f});
    }

    public OkHttpClient(l0 r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.f20587a = r5.f20676a;
        this.f20588b = r5.f20677b;
        this.f20589c = Util.toImmutableList(r5.f20678c);
        this.d = Util.toImmutableList(r5.d);
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.f20590h = r5.f20679h;
        this.f20591i = r5.f20680i;
        this.f20592j = r5.f20681j;
        this.f20593k = r5.f20682k;
        this.f20594l = r5.f20683l;
        ProxySelector r10 = r5.f20684m;
        if (r10 != null) goto L6;
        r10 = ProxySelector.getDefault();
    L6:
        if (r10 != null) goto L9;
        r10 = NullProxySelector.INSTANCE;
    L9:
        this.f20595m = r10;
        this.f20596n = r5.f20685n;
        this.f20597o = r5.f20686o;
        List r11 = r5.f20689r;
        this.f20600r = r11;
        this.s = r5.s;
        this.f20601t = r5.f20690t;
        this.f20604w = r5.f20693w;
        this.f20605x = r5.f20694x;
        this.f20606y = r5.f20695y;
        this.f20607z = r5.f20696z;
        this.A = r5.A;
        RouteDatabase r12 = r5.B;
        if (r12 != null) goto L13;
        r12 = new RouteDatabase();
    L13:
        this.B = r12;
        if (r11 != null) goto L16;
    L18:
        Iterator r13 = r11.iterator();
    L20:
        if (r13.hasNext() == false) goto L35;
        if (((q) r13.next()).f20723a == false) goto L20;
        SSLSocketFactory r14 = r5.f20687p;
        k r15 = r5.f20691u;
        if (r14 == null) goto L30;
        this.f20598p = r14;
        CertificateChainCleaner r16 = r5.f20692v;
        Intrinsics.checkNotNull(r16);
        this.f20603v = r16;
        X509TrustManager r17 = r5.f20688q;
        Intrinsics.checkNotNull(r17);
        this.f20599q = r17;
        Intrinsics.checkNotNull(r16);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "certificateChainCleaner");
        if (Intrinsics.areEqual(r15.f20668b, r16) == true) goto L29;
        r15 = new k(r15.f20667a, r16);
    L29:
        this.f20602u = r15;
    L36:
        List r18 = this.f20589c;
        if (r18 == null) goto L89;
        if (r18.contains(null) == true) goto L87;
        List r19 = this.d;
        if (r19 == null) goto L85;
        if (r19.contains(null) == true) goto L83;
        X509TrustManager r20 = this.f20599q;
        CertificateChainCleaner r21 = this.f20603v;
        SSLSocketFactory r22 = this.f20598p;
        List r23 = this.f20600r;
        if (r23 != null) goto L47;
    L49:
        Iterator r24 = r23.iterator();
    L51:
        if (r24.hasNext() == false) goto L64;
        if (((q) r24.next()).f20723a == false) goto L51;
        if (r22 == null) goto L63;
        if (r21 == null) goto L61;
        if (r20 == null) goto L59;
        return;
    L59:
        throw new IllegalStateException("x509TrustManager == null");
    L61:
        throw new IllegalStateException("certificateChainCleaner == null");
    L63:
        throw new IllegalStateException("sslSocketFactory == null");
    L64:
        if (r22 != null) goto L66;
        boolean r25 = true;
    L68:
        if (r25 == false) goto L81;
        if (r21 != null) goto L79;
        if (r20 != null) goto L77;
        if (Intrinsics.areEqual(this.f20602u, k.f20666c) == false) goto L75;
        return;
    L75:
        throw new IllegalStateException("Check failed.");
    L77:
        throw new IllegalStateException("Check failed.");
    L79:
        throw new IllegalStateException("Check failed.");
    L81:
        throw new IllegalStateException("Check failed.");
    L66:
        r25 = false;
        goto L68
    L47:
        if (r23.isEmpty() == false) goto L49;
    L83:
        throw new IllegalStateException(("Null network interceptor: " + r19).toString());
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    L87:
        throw new IllegalStateException(("Null interceptor: " + r18).toString());
    L89:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    L30:
        Platform.Companion r26 = Platform.Companion;
        X509TrustManager r27 = r26.get().platformTrustManager();
        this.f20599q = r27;
        Platform r28 = r26.get();
        Intrinsics.checkNotNull(r27);
        this.f20598p = r28.newSslSocketFactory(r27);
        CertificateChainCleaner.Companion r29 = CertificateChainCleaner.Companion;
        Intrinsics.checkNotNull(r27);
        CertificateChainCleaner r30 = r29.get(r27);
        this.f20603v = r30;
        Intrinsics.checkNotNull(r30);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r30, "certificateChainCleaner");
        if (Intrinsics.areEqual(r15.f20668b, r30) == true) goto L34;
        r15 = new k(r15.f20667a, r30);
    L34:
        this.f20602u = r15;
    L35:
        this.f20598p = null;
        this.f20603v = null;
        this.f20599q = null;
        this.f20602u = k.f20666c;
        goto L36
    L16:
        if (r11.isEmpty() == false) goto L18;
        goto L18
    }

    public final RealCall a(Request r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        return new RealCall(this, r5, false);
    }

    public final Object clone() {
        return super.clone();
    }

    public OkHttpClient() {
        this(new l0());
    }
}
