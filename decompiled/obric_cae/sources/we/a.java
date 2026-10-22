package we;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f13103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f13104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketFactory f13105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f13106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<w> f13107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j> f13108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f13109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final Proxy f13110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final SSLSocketFactory f13111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final HostnameVerifier f13112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final f f13113k;

    public a() {
        throw null;
    }

    public a(String r14, int r15, n r16, SocketFactory r17, @Nullable SSLSocketFactory r18, @Nullable HostnameVerifier r19, @Nullable f r20, b r21, @Nullable Proxy r22, List r23, List r24, ProxySelector r25) {
        r.a r8 = new r.a();
        String r10 = LocationInfoConst.HTTPS;
        if (r18 == null) goto L5;
        String r11 = LocationInfoConst.HTTPS;
    L7:
        if (r11.equalsIgnoreCase("http") == false) goto L10;
        r10 = "http";
    L11:
        r8.f13250a = r10;
        if (r14 == null) goto L50;
        String r12 = xe.c.c(r.i(r14, 0, r14.length(), false));
        if (r12 == null) goto L48;
        r8.f13253d = r12;
        if (r15 <= 0) goto L46;
        if (r15 > 65535) goto L46;
        r8.f13254e = r15;
        this.f13103a = r8.a();
        if (r16 == null) goto L44;
        this.f13104b = r16;
        if (r17 == null) goto L42;
        this.f13105c = r17;
        if (r21 == null) goto L40;
        this.f13106d = r21;
        if (r23 == null) goto L38;
        this.f13107e = xe.c.p(r23);
        if (r24 == null) goto L36;
        this.f13108f = xe.c.p(r24);
        if (r25 == null) goto L34;
        this.f13109g = r25;
        this.f13110h = r22;
        this.f13111i = r18;
        this.f13112j = r19;
        this.f13113k = r20;
        return;
    L34:
        throw new NullPointerException("proxySelector == null");
    L36:
        throw new NullPointerException("connectionSpecs == null");
    L38:
        throw new NullPointerException("protocols == null");
    L40:
        throw new NullPointerException("proxyAuthenticator == null");
    L42:
        throw new NullPointerException("socketFactory == null");
    L44:
        throw new NullPointerException("dns == null");
    L46:
        throw new IllegalArgumentException(defpackage.a.d("unexpected port: ", r15));
    L48:
        throw new IllegalArgumentException("unexpected host: ".concat(r14));
    L50:
        throw new NullPointerException("host == null");
    L10:
        if (r11.equalsIgnoreCase(LocationInfoConst.HTTPS) == true) goto L11;
        throw new IllegalArgumentException("unexpected scheme: ".concat(r11));
    L5:
        r11 = "http";
        goto L7
    }

    public final boolean a(a r8) {
        n r10 = r8.f13104b;
        if (this.f13104b.equals(r10) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.f13106d.equals(r8.f13106d) == false) goto L23;
        if (this.f13107e.equals(r8.f13107e) == false) goto L23;
        if (this.f13108f.equals(r8.f13108f) == false) goto L23;
        if (this.f13109g.equals(r8.f13109g) == false) goto L23;
        if (xe.c.m(this.f13110h, r8.f13110h) == false) goto L23;
        if (xe.c.m(this.f13111i, r8.f13111i) == false) goto L23;
        if (xe.c.m(this.f13112j, r8.f13112j) == false) goto L23;
        if (xe.c.m(this.f13113k, r8.f13113k) == false) goto L23;
        if (this.f13103a.f13245e != r8.f13103a.f13245e) goto L23;
        return true;
    }

    public final b b() {
        return this.f13106d;
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof a) == false) goto L9;
        a r10 = (a) r8;
        r r11 = r10.f13103a;
        if (this.f13103a.equals(r11) == false) goto L9;
        if (a(r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final int hashCode() {
        int r8 = (this.f13109g.hashCode() + ((this.f13108f.hashCode() + ((this.f13107e.hashCode() + ((this.f13106d.hashCode() + ((this.f13104b.hashCode() + ((this.f13103a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        int r10 = 0;
        Proxy r11 = this.f13110h;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        int r13 = (r8 + r12) * 31;
        SSLSocketFactory r14 = this.f13111i;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        HostnameVerifier r17 = this.f13112j;
        if (r17 == null) goto L13;
        int r18 = r17.hashCode();
    L14:
        int r19 = (r16 + r18) * 31;
        f r20 = this.f13113k;
        if (r20 == null) goto L18;
        r10 = r20.hashCode();
    L18:
        return r19 + r10;
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Address{");
        r r10 = this.f13103a;
        r8.append(r10.f13244d);
        r8.append(BdimCategoryConstants.SEPARATOR_COLON);
        r8.append(r10.f13245e);
        Proxy r11 = this.f13110h;
        if (r11 == null) goto L5;
        r8.append(", proxy=");
        r8.append(r11);
    L6:
        r8.append("}");
        return r8.toString();
    L5:
        r8.append(", proxySelector=");
        r8.append(this.f13109g);
        goto L6
    }
}
