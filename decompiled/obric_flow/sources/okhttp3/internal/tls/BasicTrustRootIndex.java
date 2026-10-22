package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", "other", "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... r10) {
        Intrinsics.checkNotNullParameter(r10, "caCerts");
        LinkedHashMap r5 = new LinkedHashMap();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        X509Certificate r13 = r10[r12];
        X500Principal r14 = r13.getSubjectX500Principal();
        Object r15 = r5.get(r14);
        if (r15 != null) goto L7;
        r15 = new LinkedHashSet();
        r5.put(r14, r15);
    L7:
        ((Set) r15).add(r13);
        r12 = r12 + 1;
        goto L3
    L8:
        this.subjectToCaCerts = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r5 instanceof BasicTrustRootIndex) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(((BasicTrustRootIndex) r5).subjectToCaCerts, this.subjectToCaCerts) == false) goto L8;
        goto L8
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate r5) {
        Intrinsics.checkNotNullParameter(r5, "cert");
        X500Principal r10 = r5.getIssuerX500Principal();
        Set<X509Certificate> r11 = this.subjectToCaCerts.get(r10);
        Object r12 = null;
        if (r11 == null) goto L17;
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        r5.verify(((X509Certificate) r14).getPublicKey());     // Catch: Exception -> L12
        r12 = r14;
    L11:
        return (X509Certificate) r12;
    L17:
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
