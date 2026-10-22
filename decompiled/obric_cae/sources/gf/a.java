package gf;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f7829c;

    public a(d r8) {
        this.f7829c = r8;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
    L10:
        return false;
    L8:
        if (((a) r8).f7829c.equals(this.f7829c) == false) goto L10;
        return true;
    }

    @Override // android.support.v4.media.a
    public final List g(String r10, List r11) {
        ArrayDeque r12 = new ArrayDeque(r11);
        ArrayList r13 = new ArrayList();
        r13.add(r12.removeFirst());
        int r8 = 0;
        boolean r14 = false;
    L4:
        if (r8 >= 9) goto L36;
        X509Certificate r15 = (X509Certificate) r13.get(r13.size() - 1);
        X509Certificate r16 = this.f7829c.a(r15);
        if (r16 != null) goto L8;
        Iterator r17 = r12.iterator();
    L22:
        if (r17.hasNext() == false) goto L31;
        X509Certificate r18 = (X509Certificate) r17.next();
        if (r15.getIssuerDN().equals(r18.getSubjectDN()) == true) goto L39;
    L25:
        boolean r19 = false;
    L28:
        if (r19 == false) goto L22;
        r17.remove();
        r13.add(r18);
    L30:
        r8 = r8 + 1;
        goto L4
    L39:
        r15.verify(r18.getPublicKey());     // Catch: GeneralSecurityException -> L38
        r19 = true;
        goto L28
    L31:
        if (r14 == false) goto L34;
        return r13;
    L34:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r15);
    L8:
        if (r13.size() <= 1) goto L10;
    L11:
        r13.add(r16);
    L13:
        if (r16.getIssuerDN().equals(r16.getSubjectDN()) == true) goto L41;
    L14:
        boolean r20 = false;
    L17:
        if (r20 == true) goto L18;
        r14 = true;
        goto L30
    L18:
        return r13;
    L41:
        r16.verify(r16.getPublicKey());     // Catch: GeneralSecurityException -> L37
        r20 = true;
        goto L17
    L10:
        if (r15.equals(r16) == true) goto L13;
    L36:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r13);
    }

    public final int hashCode() {
        return this.f7829c.hashCode();
    }
}
