package okhttp3;

import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f20610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f20611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f20612c;
    public final t d;
    public final SocketFactory e;
    public final SSLSocketFactory f;
    public final HostnameVerifier g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f20613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r9.c f20614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ProxySelector f20615j;

    public a(String r5, int r10, t r11, SocketFactory r12, SSLSocketFactory r13, HostnameVerifier r14, k r15, r9.c r16, List r17, List r18, ProxySelector r19) {
        Intrinsics.checkNotNullParameter(r5, "uriHost");
        Intrinsics.checkNotNullParameter(r11, "dns");
        Intrinsics.checkNotNullParameter(r12, "socketFactory");
        Intrinsics.checkNotNullParameter(r16, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(r17, "protocols");
        Intrinsics.checkNotNullParameter(r18, "connectionSpecs");
        Intrinsics.checkNotNullParameter(r19, "proxySelector");
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f20613h = r15;
        this.f20614i = r16;
        this.f20615j = r19;
        d0 r20 = new d0();
        if (r13 == null) goto L5;
        String r21 = IIvyAIPackageResourceService.SCHEMA;
    L6:
        Intrinsics.checkNotNullParameter(r21, "scheme");
        if (StringsKt.l(r21, "http") == false) goto L10;
        r20.f20626a = "http";
    L12:
        Intrinsics.checkNotNullParameter(r5, "host");
        String r22 = HostnamesKt.toCanonicalHost(uj.a.k(r5, 0, 0, 7, false));
        if (r22 == null) goto L23;
        r20.d = r22;
        if (1 > r10) goto L21;
        if (65535 < r10) goto L21;
        r20.e = r10;
        this.f20610a = r20.a();
        this.f20611b = Util.toImmutableList(r17);
        this.f20612c = Util.toImmutableList(r18);
        return;
    L21:
        throw new IllegalArgumentException(ai.j0.g(r10, "unexpected port: ").toString());
    L23:
        throw new IllegalArgumentException("unexpected host: ".concat(r5));
    L10:
        if (StringsKt.l(r21, IIvyAIPackageResourceService.SCHEMA) == false) goto L25;
        r20.f20626a = IIvyAIPackageResourceService.SCHEMA;
        goto L12
    L25:
        throw new IllegalArgumentException("unexpected scheme: ".concat(r21));
    L5:
        r21 = "http";
        goto L6
    }

    public final boolean a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "that");
        t r10 = r5.d;
        if (Intrinsics.areEqual(this.d, r10) == true) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f20614i, r5.f20614i) == false) goto L23;
        if (Intrinsics.areEqual(this.f20611b, r5.f20611b) == false) goto L23;
        if (Intrinsics.areEqual(this.f20612c, r5.f20612c) == false) goto L23;
        if (Intrinsics.areEqual(this.f20615j, r5.f20615j) == false) goto L23;
        if (Intrinsics.areEqual(null, null) == false) goto L23;
        if (Intrinsics.areEqual(this.f, r5.f) == false) goto L23;
        if (Intrinsics.areEqual(this.g, r5.g) == false) goto L23;
        if (Intrinsics.areEqual(this.f20613h, r5.f20613h) == false) goto L23;
        if (this.f20610a.f != r5.f20610a.f) goto L23;
        return true;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a) == false) goto L9;
        a r10 = (a) r5;
        e0 r11 = r10.f20610a;
        if (Intrinsics.areEqual(this.f20610a, r11) == false) goto L9;
        if (a(r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(527, 31, this.f20610a.f20644j);
        int r10 = (this.d.hashCode() + r5) * 31;
        int r11 = (this.f20614i.hashCode() + r10) * 31;
        int r12 = androidx.constraintlayout.motion.widget.a.f(this.f20611b, r11, 31);
        int r13 = androidx.constraintlayout.motion.widget.a.f(this.f20612c, r12, 31);
        int r14 = (this.f20615j.hashCode() + r13) * 961;
        int r15 = (Objects.hashCode(this.f) + r14) * 31;
        int r16 = (Objects.hashCode(this.g) + r15) * 31;
        return Objects.hashCode(this.f20613h) + r16;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Address{");
        e0 r10 = this.f20610a;
        r5.append(r10.e);
        r5.append(':');
        r5.append(r10.f);
        r5.append(", ");
        r5.append("proxySelector=" + this.f20615j);
        r5.append("}");
        return r5.toString();
    }
}
