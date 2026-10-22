package qc;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBasicTrustRootIndex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicTrustRootIndex.kt\nokhttp3/internal/tls/BasicTrustRootIndex\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n372#2,7:57\n288#3,2:64\n*S KotlinDebug\n*F\n+ 1 BasicTrustRootIndex.kt\nokhttp3/internal/tls/BasicTrustRootIndex\n*L\n28#1:57,7\n37#1:64,2\n*E\n"})
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f12504a;

    public b(X509Certificate... r10) {
        Intrinsics.checkNotNullParameter(r10, "caCerts");
        LinkedHashMap r11 = new LinkedHashMap();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        X509Certificate r14 = r10[r13];
        X500Principal r15 = r14.getSubjectX500Principal();
        Intrinsics.checkNotNullExpressionValue(r15, "caCert.subjectX500Principal");
        Object r16 = r11.get(r15);
        if (r16 != null) goto L7;
        r16 = new LinkedHashSet();
        r11.put(r15, r16);
    L7:
        ((Set) r16).add(r14);
        r13 = r13 + 1;
        goto L3
    L8:
        this.f12504a = r11;
    }

    @Override // qc.e
    public X509Certificate a(X509Certificate r10) {
        Intrinsics.checkNotNullParameter(r10, "cert");
        X500Principal r11 = r10.getIssuerX500Principal();
        Set<X509Certificate> r12 = this.f12504a.get(r11);
        Object r13 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Iterator<T> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L15;
        Object r15 = r14.next();
        r10.verify(((X509Certificate) r15).getPublicKey());     // Catch: Exception -> L11
        boolean r16 = true;
    L12:
        if (r16 == false) goto L7;
        r13 = r15;
    L11:
        r16 = false;
    L15:
        return (X509Certificate) r13;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof b) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(((b) r10).f12504a, this.f12504a) == false) goto L8;
        goto L8
    }

    public int hashCode() {
        return this.f12504a.hashCode();
    }
}
