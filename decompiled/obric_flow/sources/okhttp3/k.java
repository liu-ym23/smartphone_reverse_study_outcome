package okhttp3;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f20666c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f20667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f20668b;

    static {
        f20666c = new k(CollectionsKt.toSet(new ArrayList()), null);
    }

    public k(Set r5, CertificateChainCleaner r10) {
        Intrinsics.checkNotNullParameter(r5, "pins");
        this.f20667a = r5;
        this.f20668b = r10;
    }

    public final void a(final String r5, final List r10) {
        Intrinsics.checkNotNullParameter(r5, "hostname");
        Intrinsics.checkNotNullParameter(r10, "peerCertificates");
        b(r5, new CertificatePinner$check$1(this, r10, r5));
    }

    public final void b(String r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, "hostname");
        Intrinsics.checkNotNullParameter(r10, "cleanedPeerCertificatesFn");
        Intrinsics.checkNotNullParameter(r5, "hostname");
        Set r11 = this.f20667a;
        List r12 = CollectionsKt.emptyList();
        Iterator r13 = r11.iterator();
        if (r13.hasNext() == true) goto L30;
        if (r12.isEmpty() == false) goto L7;
        return;
    L7:
        List r14 = (List) r10.invoke();
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        X509Certificate r16 = (X509Certificate) r15.next();
        Iterator r17 = r12.iterator();
        if (r17.hasNext() == false) goto L9;
        throw androidx.constraintlayout.motion.widget.a.g(r17);
    L15:
        StringBuilder r18 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        Iterator r19 = r14.iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        X509Certificate r20 = (X509Certificate) r19.next();
        r18.append("\n    ");
        r18.append(z.m(r20));
        r18.append(": ");
        r18.append(r20.getSubjectDN().getName());
        goto L17
    L19:
        r18.append("\n  Pinned certificates for ");
        r18.append(r5);
        r18.append(":");
        Iterator r21 = r12.iterator();
    L21:
        if (r21.hasNext() == false) goto L28;
        if (r21.next() != null) goto L26;
        r18.append("\n    null");
        goto L21
    L26:
        throw new ClassCastException();
    L28:
        throw new SSLPeerUnverifiedException(r18.toString());
    L30:
        throw androidx.constraintlayout.motion.widget.a.g(r13);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof k) == false) goto L9;
        k r10 = (k) r5;
        if (Intrinsics.areEqual(r10.f20667a, this.f20667a) == false) goto L9;
        if (Intrinsics.areEqual(r10.f20668b, this.f20668b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final int hashCode() {
        int r5 = (this.f20667a.hashCode() + 1517) * 41;
        CertificateChainCleaner r10 = this.f20668b;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }
}
