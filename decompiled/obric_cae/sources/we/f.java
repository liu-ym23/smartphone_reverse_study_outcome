package we;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f13169c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f13170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final android.support.v4.media.a f13171b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f13172a;

        public a() {
            this.f13172a = new ArrayList();
        }
    }

    public static final class b {
        public final boolean equals(Object r8) {
            if ((r8 instanceof b) == true) goto L6;
            return false;
        L6:
            ((b) r8).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    static {
        f13169c = new f(new LinkedHashSet(new a().f13172a), null);
    }

    public f(Set<b> r8, @Nullable android.support.v4.media.a r10) {
        this.f13170a = r8;
        this.f13171b = r10;
    }

    public static String b(X509Certificate r8) {
        if ((r8 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + jf.g.g(r8.getPublicKey().getEncoded()).k().a();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r8, List<Certificate> r10) {
        List r11 = Collections.emptyList();
        Iterator<b> r12 = this.f13170a.iterator();
        if (r12.hasNext() == false) goto L5;
        r12.next().getClass();
        throw null;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return;
    L7:
        android.support.v4.media.a r13 = this.f13171b;
        if (r13 == 0) goto L10;
        r10 = r13.g(r8, r10);
    L10:
        int r14 = r10.size();
        int r15 = 0;
        int r16 = 0;
    L11:
        if (r16 >= r14) goto L17;
        X509Certificate r17 = (X509Certificate) r10.get(r16);
        if (r11.size() > 0) goto L15;
        r16 = r16 + 1;
        goto L11
    L15:
        ((b) r11.get(0)).getClass();
        throw null;
    L17:
        StringBuilder r18 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int r19 = r10.size();
        int r20 = 0;
    L19:
        if (r20 >= r19) goto L21;
        X509Certificate r21 = (X509Certificate) r10.get(r20);
        r18.append("\n    ");
        r18.append(b(r21));
        r18.append(": ");
        r18.append(r21.getSubjectDN().getName());
        r20 = r20 + 1;
        goto L19
    L21:
        r18.append("\n  Pinned certificates for ");
        r18.append(r8);
        r18.append(BdimCategoryConstants.SEPARATOR_COLON);
        int r22 = r11.size();
    L22:
        if (r15 >= r22) goto L25;
        b r23 = (b) r11.get(r15);
        r18.append("\n    ");
        r18.append(r23);
        r15 = r15 + 1;
        goto L22
    L25:
        throw new SSLPeerUnverifiedException(r18.toString());
    }

    public final boolean equals(@Nullable Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == false) goto L12;
        f r10 = (f) r8;
        android.support.v4.media.a r11 = r10.f13171b;
        if (xe.c.m(this.f13171b, r11) == false) goto L12;
        if (this.f13170a.equals(r10.f13170a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        android.support.v4.media.a r8 = this.f13171b;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L6:
        int r11 = this.f13170a.hashCode();
        return r11 + (r10 * 31);
    L5:
        r10 = 0;
        goto L6
    }
}
