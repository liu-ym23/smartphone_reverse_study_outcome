package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BasicCertificateChainCleaner(TrustRootIndex r5) {
        Intrinsics.checkNotNullParameter(r5, "trustRootIndex");
        this.trustRootIndex = r5;
    }

    private final boolean verifySignature(X509Certificate r5, X509Certificate r10) {
        if (Intrinsics.areEqual(r5.getIssuerDN(), r10.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r5.verify(r10.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L11:
        return false;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<? extends Certificate> r10, String r11) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(r10, "chain");
        Intrinsics.checkNotNullParameter(r11, "hostname");
        ArrayDeque r12 = new ArrayDeque(r10);
        ArrayList r13 = new ArrayList();
        r13.add(r12.removeFirst());
        int r5 = 0;
        boolean r14 = false;
    L4:
        if (r5 >= 9) goto L36;
        Object r15 = r13.get(r13.size() - 1);
        if (r15 == null) goto L34;
        X509Certificate r16 = (X509Certificate) r15;
        X509Certificate r17 = this.trustRootIndex.findByIssuerAndSignature(r16);
        if (r17 != null) goto L10;
        Iterator r18 = r12.iterator();
    L20:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        if (r19 == null) goto L28;
        X509Certificate r20 = (X509Certificate) r19;
        if (verifySignature(r16, r20) == false) goto L20;
        r18.remove();
        r13.add(r20);
    L26:
        r5 = r5 + 1;
        goto L4
    L28:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L29:
        if (r14 == false) goto L32;
        return r13;
    L32:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r16);
    L10:
        if (r13.size() <= 1) goto L12;
    L13:
        r13.add(r17);
    L15:
        if (verifySignature(r17, r17) == true) goto L16;
        r14 = true;
        goto L26
    L16:
        return r13;
    L12:
        if (Intrinsics.areEqual(r16, r17) == true) goto L15;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L36:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r13);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof BasicCertificateChainCleaner) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(((BasicCertificateChainCleaner) r5).trustRootIndex, this.trustRootIndex) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
