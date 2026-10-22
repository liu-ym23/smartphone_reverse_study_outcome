package okhttp3;

import com.bytedance.keva.KevaImpl;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {
    public long A;
    public RouteDatabase B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.web.jsbridge2.p f20676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f20677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f20678c;
    public final ArrayList d;
    public v e;
    public boolean f;
    public r9.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public sj.e f20681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f20682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t f20683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ProxySelector f20684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r9.c f20685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SocketFactory f20686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SSLSocketFactory f20687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public X509TrustManager f20688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f20689r;
    public List s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OkHostnameVerifier f20690t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k f20691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CertificateChainCleaner f20692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20694x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20695y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20696z;

    public l0() {
        this.f20676a = new com.bytedance.ies.web.jsbridge2.p(6);
        this.f20677b = new o(5, 5, TimeUnit.MINUTES);
        this.f20678c = new ArrayList();
        this.d = new ArrayList();
        this.e = Util.asFactory(w.f20761a);
        this.f = true;
        r9.c r5 = b.f20619i1;
        this.g = r5;
        this.f20679h = true;
        this.f20680i = true;
        this.f20681j = s.f20744j1;
        this.f20683l = t.l1;
        this.f20685n = r5;
        this.f20686o = SocketFactory.getDefault();
        this.f20689r = OkHttpClient.D;
        this.s = OkHttpClient.C;
        this.f20690t = OkHostnameVerifier.INSTANCE;
        this.f20691u = k.f20666c;
        this.f20694x = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f20695y = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f20696z = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.A = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public final void a(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        this.f20694x = Util.checkDuration("timeout", r5, r10);
    }

    public final void b(List r5) {
        Intrinsics.checkNotNullParameter(r5, "protocols");
        List r10 = CollectionsKt.toMutableList(r5);
        Protocol r11 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r10.contains(r11) == true) goto L10;
        if (r10.contains(Protocol.HTTP_1_1) == true) goto L10;
        throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + r10).toString());
    L10:
        if (r10.contains(r11) == false) goto L17;
        if (r10.size() <= 1) goto L17;
        throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + r10).toString());
    L17:
        if (r10.contains(Protocol.HTTP_1_0) == true) goto L28;
        if (r10.contains(null) == true) goto L26;
        r10.remove(Protocol.SPDY_3);
        if (Intrinsics.areEqual(r10, this.s) == true) goto L23;
        this.B = null;
    L23:
        this.s = Collections.unmodifiableList(r10);
        return;
    L26:
        throw new IllegalArgumentException("protocols must not contain null");
    L28:
        throw new IllegalArgumentException(("protocols must not contain http/1.0: " + r10).toString());
    }

    public final void c(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        this.f20695y = Util.checkDuration("timeout", r5, r10);
    }

    public final void d(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        this.f20696z = Util.checkDuration("timeout", r5, r10);
    }
}
