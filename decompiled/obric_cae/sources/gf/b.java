package gf;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f7830a;

    public b(X509Certificate... r8) {
        this.f7830a = new LinkedHashMap();
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        X509Certificate r12 = r8[r11];
        X500Principal r13 = r12.getSubjectX500Principal();
        Set r14 = (Set) this.f7830a.get(r13);
        if (r14 != null) goto L7;
        r14 = new LinkedHashSet(1);
        this.f7830a.put(r13, r14);
    L7:
        r14.add(r12);
        r11 = r11 + 1;
        goto L3
    }

    @Override // gf.d
    public final X509Certificate a(X509Certificate r8) {
        X500Principal r10 = r8.getIssuerX500Principal();
        Set r11 = (Set) this.f7830a.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        X509Certificate r13 = (X509Certificate) r12.next();
        r8.verify(r13.getPublicKey());     // Catch: Exception -> L12
        return r13;
    L11:
        return null;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
    L10:
        return false;
    L8:
        if (((b) r8).f7830a.equals(this.f7830a) == false) goto L10;
        return true;
    }

    public final int hashCode() {
        return this.f7830a.hashCode();
    }
}
