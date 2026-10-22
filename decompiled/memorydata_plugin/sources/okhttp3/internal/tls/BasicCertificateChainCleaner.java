package okhttp3.internal.tls;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BasicCertificateChainCleaner(TrustRootIndex r3) {
        TrustRootIndex r4 = (TrustRootIndex) ZeusTransformUtils.wrapperContextForParams(r3, TrustRootIndex.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "trustRootIndex");
        this.trustRootIndex = r4;
    }

    private final boolean verifySignature(X509Certificate r3, X509Certificate r4) {
        if ((!Intrinsics.areEqual(r3.getIssuerDN(), r4.getSubjectDN())) == false) goto L9;
        return false;
    L9:
        r3.verify(r4.getPublicKey());     // Catch: GeneralSecurityException -> L7
        return true;
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<? extends Certificate> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r11, "chain");
        Intrinsics.checkParameterIsNotNull(r10, "hostname");
        Deque r12 = (Deque) ZeusTransformUtils.preCheckCast(new ArrayDeque((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")), Deque.class, "com.obric.memorydata.plugin");
        List<Certificate> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Object r0 = r12.removeFirst();
        Intrinsics.checkExpressionValueIsNotNull(r0, "queue.removeFirst()");
        r13.add(r0);
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= 9) goto L36;
        Object r3 = r13.get(r13.size() - 1);
        if (r3 == null) goto L34;
        X509Certificate r4 = (X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.memorydata.plugin");
        X509Certificate r6 = this.trustRootIndex.findByIssuerAndSignature(r4);
        if (r6 != null) goto L10;
        Iterator r5 = r12.iterator();
        Intrinsics.checkExpressionValueIsNotNull(r5, "queue.iterator()");
    L20:
        if (r5.hasNext() == false) goto L29;
        Object r7 = r5.next();
        if (r7 == null) goto L28;
        X509Certificate r8 = (X509Certificate) ZeusTransformUtils.preCheckCast(r7, X509Certificate.class, "com.obric.memorydata.plugin");
        if (verifySignature(r4, r8) == false) goto L20;
        r5.remove();
        r13.add(r8);
    L26:
        r1 = r1 + 1;
        goto L4
    L28:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L29:
        if (r2 == false) goto L32;
        return r13;
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r4), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        if (r13.size() <= 1) goto L12;
    L13:
        r13.add(r6);
    L15:
        if (verifySignature(r6, r6) == true) goto L16;
        r2 = true;
        goto L26
    L16:
        return r13;
    L12:
        if ((!Intrinsics.areEqual(r4, r6)) == false) goto L15;
    L34:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L36:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SSLPeerUnverifiedException("Certificate chain too long: " + r13), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (r5 != ((BasicCertificateChainCleaner) ZeusTransformUtils.preCheckCast(this, BasicCertificateChainCleaner.class, "com.obric.memorydata.plugin"))) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BasicCertificateChainCleaner.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(((BasicCertificateChainCleaner) ZeusTransformUtils.preCheckCast(r5, BasicCertificateChainCleaner.class, "com.obric.memorydata.plugin")).trustRootIndex, this.trustRootIndex) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
