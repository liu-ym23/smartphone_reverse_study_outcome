package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f11666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TTNetDns f11667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SocketFactory f11668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SSLSocketFactory f11669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HostnameVerifier f11670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CertificatePinner f11671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f11672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Proxy f11673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ProxySelector f11674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final s f11675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<Protocol> f11676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<k> f11677l;

    public a(String r10, int r11, p r12, TTNetDns r13, SocketFactory r14, SSLSocketFactory r15, HostnameVerifier r16, CertificatePinner r17, b r18, Proxy r19, List<? extends Protocol> r110, List<k> r111, ProxySelector r112) {
        Intrinsics.checkNotNullParameter(r10, "uriHost");
        Intrinsics.checkNotNullParameter(r12, "dns");
        Intrinsics.checkNotNullParameter(r14, "socketFactory");
        Intrinsics.checkNotNullParameter(r18, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(r110, "protocols");
        Intrinsics.checkNotNullParameter(r111, "connectionSpecs");
        Intrinsics.checkNotNullParameter(r112, "proxySelector");
        this.f11666a = r12;
        this.f11667b = r13;
        this.f11668c = r14;
        this.f11669d = r15;
        this.f11670e = r16;
        this.f11671f = r17;
        this.f11672g = r18;
        this.f11673h = r19;
        this.f11674i = r112;
        s.a r20 = new s.a();
        if (r15 == null) goto L5;
        String r21 = "https";
    L6:
        this.f11675j = r20.p(r21).f(r10).l(r11).b();
        this.f11676k = hc.e.T(r110);
        this.f11677l = hc.e.T(r111);
        return;
    L5:
        r21 = "http";
        goto L6
    }

    @JvmName(name = "certificatePinner")
    public final CertificatePinner a() {
        return this.f11671f;
    }

    @JvmName(name = "connectionSpecs")
    public final List<k> b() {
        return this.f11677l;
    }

    @JvmName(name = "dns")
    public final p c() {
        return this.f11666a;
    }

    public final boolean d(a r10) {
        Intrinsics.checkNotNullParameter(r10, "that");
        if (Intrinsics.areEqual(this.f11666a, r10.f11666a) == true) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f11672g, r10.f11672g) == false) goto L23;
        if (Intrinsics.areEqual(this.f11676k, r10.f11676k) == false) goto L23;
        if (Intrinsics.areEqual(this.f11677l, r10.f11677l) == false) goto L23;
        if (Intrinsics.areEqual(this.f11674i, r10.f11674i) == false) goto L23;
        if (Intrinsics.areEqual(this.f11673h, r10.f11673h) == false) goto L23;
        if (Intrinsics.areEqual(this.f11669d, r10.f11669d) == false) goto L23;
        if (Intrinsics.areEqual(this.f11670e, r10.f11670e) == false) goto L23;
        if (Intrinsics.areEqual(this.f11671f, r10.f11671f) == false) goto L23;
        if (this.f11675j.n() != r10.f11675j.n()) goto L23;
        return true;
    }

    @JvmName(name = "hostnameVerifier")
    public final HostnameVerifier e() {
        return this.f11670e;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == false) goto L9;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f11675j, r11.f11675j) == false) goto L9;
        if (d(r11) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmName(name = "protocols")
    public final List<Protocol> f() {
        return this.f11676k;
    }

    @JvmName(name = "proxy")
    public final Proxy g() {
        return this.f11673h;
    }

    @JvmName(name = "proxyAuthenticator")
    public final b h() {
        return this.f11672g;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f11675j.hashCode()) * 31) + this.f11666a.hashCode()) * 31) + this.f11672g.hashCode()) * 31) + this.f11676k.hashCode()) * 31) + this.f11677l.hashCode()) * 31) + this.f11674i.hashCode()) * 31) + Objects.hashCode(this.f11673h)) * 31) + Objects.hashCode(this.f11669d)) * 31) + Objects.hashCode(this.f11670e)) * 31) + Objects.hashCode(this.f11671f);
    }

    @JvmName(name = "proxySelector")
    public final ProxySelector i() {
        return this.f11674i;
    }

    @JvmName(name = "socketFactory")
    public final SocketFactory j() {
        return this.f11668c;
    }

    @JvmName(name = "sslSocketFactory")
    public final SSLSocketFactory k() {
        return this.f11669d;
    }

    @JvmName(name = "ttnetDns")
    public final TTNetDns l() {
        return this.f11667b;
    }

    @JvmName(name = "url")
    public final s m() {
        return this.f11675j;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Address{");
        r10.append(this.f11675j.h());
        r10.append(':');
        r10.append(this.f11675j.n());
        r10.append(", ");
        if (this.f11673h == null) goto L5;
        StringBuilder r11 = new StringBuilder();
        r11.append("proxy=");
        Object r12 = this.f11673h;
    L6:
        r11.append(r12);
        r10.append(r11.toString());
        r10.append('}');
        return r10.toString();
    L5:
        r11 = new StringBuilder();
        r11.append("proxySelector=");
        r12 = this.f11674i;
        goto L6
    }
}
