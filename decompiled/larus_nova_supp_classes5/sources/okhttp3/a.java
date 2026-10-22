package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final HttpUrl a;
    public final Dns b;
    public final SocketFactory c;
    public final b d;
    public final List<Protocol> e;
    public final List<f> f;
    public final ProxySelector g;

    @Nullable
    public final Proxy h;

    @Nullable
    public final SSLSocketFactory i;

    @Nullable
    public final HostnameVerifier j;

    @Nullable
    public final c k;
    public final TTNetDns l;

    public final int hashCode() {
        int r1 = (((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy r0 = this.h;
        int r2 = 0;
        if (r0 == null) goto L5;
        int r3 = r0.hashCode();
    L6:
        int r4 = (r1 + r3) * 31;
        SSLSocketFactory r5 = this.i;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        HostnameVerifier r8 = this.j;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        c r11 = this.k;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Address{");
        r0.append(this.a.host());
        r0.append(":");
        r0.append(this.a.port());
        if (this.h == null) goto L5;
        r0.append(", proxy=");
        r0.append(this.h);
    L6:
        r0.append("}");
        return r0.toString();
    L5:
        r0.append(", proxySelector=");
        r0.append(this.g);
        goto L6
    }

    public final boolean a(a r3) {
        if (this.b.equals(r3.b) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.d.equals(r3.d) == false) goto L23;
        if (this.e.equals(r3.e) == false) goto L23;
        if (this.f.equals(r3.f) == false) goto L23;
        if (this.g.equals(r3.g) == false) goto L23;
        if (cvc.c.k(this.h, r3.h) == false) goto L23;
        if (cvc.c.k(this.i, r3.i) == false) goto L23;
        if (cvc.c.k(this.j, r3.j) == false) goto L23;
        if (cvc.c.k(this.k, r3.k) == false) goto L23;
        if (this.a.port() != r3.a.port()) goto L23;
        return true;
    }

    public final boolean equals(@Nullable Object r3) {
        if ((r3 instanceof a) == false) goto L9;
        a r4 = (a) r3;
        if (this.a.equals(r4.a) == false) goto L9;
        if (a(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public a(String r3, int r4, Dns r5, SocketFactory r6, @Nullable SSLSocketFactory r7, @Nullable HostnameVerifier r8, @Nullable c r9, b r10, @Nullable Proxy r11, List<Protocol> r12, List<f> r13, ProxySelector r14) {
        HttpUrl.a r0 = new HttpUrl.a();
        if (r7 == null) goto L5;
        String r1 = "https";
    L6:
        r0.g(r1);
        r0.c(r3);
        if (r4 <= 0) goto L37;
        if (r4 > 65535) goto L37;
        r0.e = r4;
        this.a = r0.b();
        if (r5 == null) goto L35;
        this.b = r5;
        if (r6 == null) goto L33;
        this.c = r6;
        if (r10 == null) goto L31;
        this.d = r10;
        if (r12 == null) goto L29;
        this.e = cvc.c.n(r12);
        if (r13 == null) goto L27;
        this.f = cvc.c.n(r13);
        if (r14 == null) goto L25;
        this.g = r14;
        this.h = r11;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        return;
    L25:
        throw new NullPointerException("proxySelector == null");
    L27:
        throw new NullPointerException("connectionSpecs == null");
    L29:
        throw new NullPointerException("protocols == null");
    L31:
        throw new NullPointerException("proxyAuthenticator == null");
    L33:
        throw new NullPointerException("socketFactory == null");
    L35:
        throw new NullPointerException("dns == null");
    L37:
        throw new IllegalArgumentException("unexpected port: " + r4);
    L5:
        r1 = "http";
        goto L6
    }

    public a(String r1, int r2, Dns r3, SocketFactory r4, @Nullable SSLSocketFactory r5, @Nullable HostnameVerifier r6, @Nullable c r7, b r8, @Nullable Proxy r9, List<Protocol> r10, List<f> r11, ProxySelector r12, TTNetDns r13) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        this.l = r13;
    }
}
