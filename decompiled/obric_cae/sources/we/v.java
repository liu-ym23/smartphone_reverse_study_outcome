package we;

import com.bytedance.keva.KevaImpl;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Cloneable {
    public static final List<w> L = null;
    public static final List<j> M = null;
    public final i A;
    public final n B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f13277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Proxy f13278b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<w> f13279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<j> f13280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<s> f13281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<s> f13282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o.c f13283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ProxySelector f13284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final l f13285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SocketFactory f13286t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SSLSocketFactory f13287u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final android.support.v4.media.a f13288v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HostnameVerifier f13289w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f13290x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final we.b f13291y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final we.b f13292z;

    public static class a extends xe.a {
        public final Socket a(i r8, we.a r10, ze.g r11) {
            Iterator r12 = r8.f13198d.iterator();
        L4:
            if (r12.hasNext() == false) goto L27;
            ze.d r13 = (ze.d) r12.next();
            if (r13.h(r10, null) == false) goto L4;
            if (r13.i() == false) goto L4;
            if (r13 == r11.b()) goto L4;
            if (r11.f14414o != null) goto L17;
            if (r11.f14409j.f14385n.size() != 1) goto L17;
            Reference r14 = (Reference) r11.f14409j.f14385n.get(0);
            Socket r15 = r11.c(true, false, false);
            r11.f14409j = r13;
            r13.f14385n.add(r14);
            return r15;
        L17:
            throw new IllegalStateException();
        L27:
            return null;
        }

        public final ze.d b(i r8, we.a r10, ze.g r11, d0 r12) {
            Iterator r13 = r8.f13198d.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            ze.d r14 = (ze.d) r13.next();
            if (r14.h(r10, r12) == false) goto L4;
            r11.a(r14, true);
            return r14;
        L8:
            return null;
        }
    }

    public static final class b {
        public final boolean A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f13293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Proxy f13294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<w> f13295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<j> f13296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList f13297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList f13298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o.c f13299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ProxySelector f13300h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public l f13301i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public SocketFactory f13302j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public SSLSocketFactory f13303k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public android.support.v4.media.a f13304l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final HostnameVerifier f13305m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final f f13306n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final we.b f13307o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final we.b f13308p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public i f13309q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public n f13310r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f13311s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f13312t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f13313u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f13314v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f13315w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f13316x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f13317y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final int f13318z;

        public b() {
            this.f13297e = new ArrayList();
            this.f13298f = new ArrayList();
            this.f13293a = new m();
            this.f13295c = v.L;
            this.f13296d = v.M;
            this.f13299g = o.factory(o.NONE);
            ProxySelector r8 = ProxySelector.getDefault();
            this.f13300h = r8;
            if (r8 != null) goto L5;
            this.f13300h = new ef.a();
        L5:
            this.f13301i = l.f13225a;
            this.f13302j = SocketFactory.getDefault();
            this.f13305m = gf.c.f7831a;
            this.f13306n = f.f13169c;
            we.b.a r10 = we.b.f13138a;
            this.f13307o = r10;
            this.f13308p = r10;
            this.f13309q = new i();
            this.f13310r = n.f13232a;
            this.f13311s = true;
            this.f13312t = true;
            this.f13313u = true;
            this.f13314v = 0;
            this.f13315w = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f13316x = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f13317y = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f13318z = 0;
            this.A = false;
        }

        public final void a(List r8) {
            ArrayList r10 = new ArrayList(r8);
            w r11 = w.f13323p;
            if (r10.contains(r11) == true) goto L10;
            if (r10.contains(w.f13320m) == true) goto L10;
            throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + r10);
        L10:
            if (r10.contains(r11) == false) goto L17;
            if (r10.size() <= 1) goto L17;
            throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + r10);
        L17:
            if (r10.contains(w.f13319b) == true) goto L25;
            if (r10.contains(null) == true) goto L23;
            r10.remove(w.f13321n);
            this.f13295c = Collections.unmodifiableList(r10);
            return;
        L23:
            throw new IllegalArgumentException("protocols must not contain null");
        L25:
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + r10);
        }

        public b(v r8) {
            ArrayList r10 = new ArrayList();
            this.f13297e = r10;
            ArrayList r11 = new ArrayList();
            this.f13298f = r11;
            this.f13293a = r8.f13277a;
            this.f13294b = r8.f13278b;
            this.f13295c = r8.f13279m;
            this.f13296d = r8.f13280n;
            r10.addAll(r8.f13281o);
            r11.addAll(r8.f13282p);
            this.f13299g = r8.f13283q;
            this.f13300h = r8.f13284r;
            this.f13301i = r8.f13285s;
            this.f13302j = r8.f13286t;
            this.f13303k = r8.f13287u;
            this.f13304l = r8.f13288v;
            this.f13305m = r8.f13289w;
            this.f13306n = r8.f13290x;
            this.f13307o = r8.f13291y;
            this.f13308p = r8.f13292z;
            this.f13309q = r8.A;
            this.f13310r = r8.B;
            this.f13311s = r8.C;
            this.f13312t = r8.D;
            this.f13313u = r8.E;
            this.f13314v = r8.F;
            this.f13315w = r8.G;
            this.f13316x = r8.H;
            this.f13317y = r8.I;
            this.f13318z = r8.J;
            this.A = r8.K;
        }
    }

    static {
        L = xe.c.q(new w[]{w.f13322o, w.f13320m});
        M = xe.c.q(new j[]{j.f13202e, j.f13203f});
        xe.a.f13878a = new a();
    }

    public v() {
        this(new b());
    }

    public final m a() {
        return this.f13277a;
    }

    public v(b r8) {
        this.f13277a = r8.f13293a;
        this.f13278b = r8.f13294b;
        this.f13279m = r8.f13295c;
        List<j> r10 = r8.f13296d;
        this.f13280n = r10;
        this.f13281o = xe.c.p(r8.f13297e);
        this.f13282p = xe.c.p(r8.f13298f);
        this.f13283q = r8.f13299g;
        this.f13284r = r8.f13300h;
        this.f13285s = r8.f13301i;
        this.f13286t = r8.f13302j;
        Iterator<j> r11 = r10.iterator();
    L3:
        boolean r12 = false;
    L5:
        if (r11.hasNext() == false) goto L11;
        j r13 = r11.next();
        if (r12 == true) goto L10;
        if (r13.f13204a == false) goto L3;
    L10:
        r12 = true;
        goto L5
    L11:
        SSLSocketFactory r14 = r8.f13303k;
        if (r14 != null) goto L31;
        if (r12 == false) goto L31;
        TrustManagerFactory r15 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L28
        r15.init(null);     // Catch: GeneralSecurityException -> L28
        TrustManager[] r16 = r15.getTrustManagers();     // Catch: GeneralSecurityException -> L28
        if (r16.length != 1) goto L27;
        TrustManager r17 = r16[0];     // Catch: GeneralSecurityException -> L28
        if ((r17 instanceof X509TrustManager) == false) goto L27;
        X509TrustManager r18 = (X509TrustManager) r17;     // Catch: GeneralSecurityException -> L28
        df.f r19 = df.f.f7097a;     // Catch: GeneralSecurityException -> L23
        SSLContext r20 = r19.h();     // Catch: GeneralSecurityException -> L23
        r20.init(null, new TrustManager[]{r18}, null);     // Catch: GeneralSecurityException -> L23
        this.f13287u = r20.getSocketFactory();
        android.support.v4.media.a r21 = r19.c(r18);
    L32:
        this.f13288v = r21;
        SSLSocketFactory r22 = this.f13287u;
        if (r22 == null) goto L35;
        df.f.f7097a.e(r22);
    L35:
        this.f13289w = r8.f13305m;
        f r23 = r8.f13306n;
        if (xe.c.m(r23.f13171b, r21) == true) goto L39;
        r23 = new f(r23.f13170a, r21);
    L39:
        this.f13290x = r23;
        this.f13291y = r8.f13307o;
        this.f13292z = r8.f13308p;
        this.A = r8.f13309q;
        this.B = r8.f13310r;
        this.C = r8.f13311s;
        this.D = r8.f13312t;
        this.E = r8.f13313u;
        this.F = r8.f13314v;
        this.G = r8.f13315w;
        this.H = r8.f13316x;
        this.I = r8.f13317y;
        this.J = r8.f13318z;
        this.K = r8.A;
        if (this.f13281o.contains(null) == true) goto L47;
        if (this.f13282p.contains(null) == true) goto L45;
        return;
    L45:
        throw new IllegalStateException("Null network interceptor: " + this.f13282p);
    L47:
        throw new IllegalStateException("Null interceptor: " + this.f13281o);
    L23:
        e = move-exception;
        throw xe.c.a("No System TLS", e);
    L27:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r16));     // Catch: GeneralSecurityException -> L28
    L28:
        e = move-exception;
        throw xe.c.a("No System TLS", e);
    L31:
        this.f13287u = r14;
        r21 = r8.f13304l;
        goto L32
    }
}
