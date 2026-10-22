package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final c c = null;
    public final Set<a> a;

    @Nullable
    public final jvc.c b;

    static {
        c = new c(new LinkedHashSet(new ArrayList()), null);
    }

    public final int hashCode() {
        jvc.c r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.a.hashCode();
    L5:
        r1 = 0;
        goto L7
    }

    public static String b(Certificate r2) {
        if ((r2 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + ByteString.of(((X509Certificate) r2).getPublicKey().getEncoded()).sha256().base64();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public final boolean equals(@Nullable Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == false) goto L12;
        c r5 = (c) r4;
        if (cvc.c.k(this.b, r5.b) == false) goto L12;
        if (this.a.equals(r5.a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public c(Set<a> r1, @Nullable jvc.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r8, List<Certificate> r9) throws SSLPeerUnverifiedException {
        List r0 = Collections.emptyList();
        Iterator<a> r1 = this.a.iterator();
        if (r1.hasNext() == false) goto L5;
        r1.next().getClass();
        throw null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return;
    L7:
        jvc.c r2 = this.b;
        if (r2 == null) goto L10;
        r9 = r2.a(r9, r8);
    L10:
        int r3 = r9.size();
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L17;
        X509Certificate r6 = (X509Certificate) ListProtector.get(r9, r5);
        if (r0.size() > 0) goto L15;
        r5 = r5 + 1;
        goto L11
    L15:
        ((a) ListProtector.get(r0, 0)).getClass();
        throw null;
    L17:
        StringBuilder r7 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int r10 = r9.size();
        int r11 = 0;
    L19:
        if (r11 >= r10) goto L21;
        X509Certificate r12 = (X509Certificate) ListProtector.get(r9, r11);
        r7.append("\n    ");
        r7.append(b(r12));
        r7.append(": ");
        r7.append(r12.getSubjectDN().getName());
        r11 = r11 + 1;
        goto L19
    L21:
        r7.append("\n  Pinned certificates for ");
        r7.append(r8);
        r7.append(":");
        int r13 = r0.size();
    L22:
        if (r4 >= r13) goto L25;
        a r14 = (a) ListProtector.get(r0, r4);
        r7.append("\n    ");
        r7.append(r14);
        r4 = r4 + 1;
        goto L22
    L25:
        throw new SSLPeerUnverifiedException(r7.toString());
    }
}
