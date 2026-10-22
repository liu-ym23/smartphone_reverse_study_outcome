package okhttp3.internal.tls;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", "other", "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... r9) {
        Intrinsics.checkParameterIsNotNull(r9, "caCerts");
        Map<X500Principal, Set<X509Certificate>> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        X509Certificate r4 = r9[r3];
        X500Principal r5 = r4.getSubjectX500Principal();
        Intrinsics.checkExpressionValueIsNotNull(r5, "caCert.subjectX500Principal");
        Set<X509Certificate> r6 = r0.get(r5);
        if (r6 != null) goto L7;
        r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r0.put(r5, r6);
    L7:
        ((Set) ZeusTransformUtils.preCheckCast(r6, Set.class, "com.obric.memorydata.plugin")).add(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        this.subjectToCaCerts = r0;
    }

    public boolean equals(Object r4) {
        if (r4 != ((BasicTrustRootIndex) ZeusTransformUtils.preCheckCast(this, BasicTrustRootIndex.class, "com.obric.memorydata.plugin"))) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, BasicTrustRootIndex.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(((BasicTrustRootIndex) ZeusTransformUtils.preCheckCast(r4, BasicTrustRootIndex.class, "com.obric.memorydata.plugin")).subjectToCaCerts, this.subjectToCaCerts) == false) goto L9;
        goto L9
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate r5) {
        Intrinsics.checkParameterIsNotNull(r5, "cert");
        X500Principal r0 = r5.getIssuerX500Principal();
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(this.subjectToCaCerts.get(r0), Set.class, "com.obric.memorydata.plugin");
        Object r1 = null;
        if (r4 == null) goto L15;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r2 = r6.next();
        r5.verify(((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.memorydata.plugin")).getPublicKey());     // Catch: Exception -> L10
        boolean r3 = true;
    L11:
        if (r3 == false) goto L6;
        r1 = r2;
    L10:
        r3 = false;
    L14:
        return (X509Certificate) ZeusTransformUtils.preCheckCast(r1, X509Certificate.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
