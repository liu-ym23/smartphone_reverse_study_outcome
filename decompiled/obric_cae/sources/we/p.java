package we;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f13234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f13235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Certificate> f13236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Certificate> f13237d;

    public p(e0 r8, g r10, List<Certificate> r11, List<Certificate> r12) {
        this.f13234a = r8;
        this.f13235b = r10;
        this.f13236c = r11;
        this.f13237d = r12;
    }

    public static p a(SSLSession r8) {
        String r10 = r8.getCipherSuite();
        if (r10 == null) goto L30;
        if ("SSL_NULL_WITH_NULL_NULL".equals(r10) == true) goto L28;
        g r11 = g.a(r10);
        String r12 = r8.getProtocol();
        if (r12 == null) goto L26;
        if (BdimCategoryConstants.VALUE_NONE.equals(r12) == true) goto L24;
        e0 r13 = e0.a(r12);
        Certificate[] r14 = r8.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L13
    L14:
        if (r14 == null) goto L16;
        List r15 = xe.c.q(r14);
    L17:
        Certificate[] r16 = r8.getLocalCertificates();
        if (r16 == null) goto L20;
        List r17 = xe.c.q(r16);
    L22:
        return new p(r13, r11, r15, r17);
    L20:
        r17 = Collections.emptyList();
        goto L22
    L16:
        r15 = Collections.emptyList();
    L13:
        r14 = null;
        goto L14
    L24:
        throw new IOException("tlsVersion == NONE");
    L26:
        throw new IllegalStateException("tlsVersion == null");
    L28:
        throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    L30:
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof p) == true) goto L5;
        return false;
    L5:
        p r10 = (p) r8;
        e0 r11 = r10.f13234a;
        if (this.f13234a.equals(r11) == true) goto L8;
        return false;
    L8:
        if (this.f13235b.equals(r10.f13235b) == true) goto L10;
        return false;
    L10:
        if (this.f13236c.equals(r10.f13236c) == true) goto L12;
        return false;
    L12:
        if (this.f13237d.equals(r10.f13237d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r8 = (this.f13234a.hashCode() + 527) * 31;
        int r10 = (this.f13235b.hashCode() + r8) * 31;
        int r11 = (this.f13236c.hashCode() + r10) * 31;
        return this.f13237d.hashCode() + r11;
    }
}
