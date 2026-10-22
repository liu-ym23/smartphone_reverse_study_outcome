package qc;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f12503b;

    /* JADX INFO: renamed from: qc.a$a, reason: collision with other inner class name */
    public static final class C0285a {
        private C0285a() {
        }

        public /* synthetic */ C0285a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0285a(null);
    }

    public a(e r10) {
        Intrinsics.checkNotNullParameter(r10, "trustRootIndex");
        this.f12503b = r10;
    }

    private final boolean b(X509Certificate r10, X509Certificate r11) {
        if (Intrinsics.areEqual(r10.getIssuerDN(), r11.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r10.verify(r11.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L11:
        return false;
    }

    @Override // qc.c
    public List<Certificate> a(List<? extends Certificate> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        Intrinsics.checkNotNullParameter(r11, "hostname");
        ArrayDeque r12 = new ArrayDeque(r10);
        ArrayList r13 = new ArrayList();
        Object r14 = r12.removeFirst();
        Intrinsics.checkNotNullExpressionValue(r14, "queue.removeFirst()");
        r13.add(r14);
        int r15 = 0;
        boolean r16 = false;
    L4:
        if (r15 >= 9) goto L28;
        Object r17 = r13.get(r13.size() - 1);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate r18 = (X509Certificate) r17;
        X509Certificate r19 = this.f12503b.a(r18);
        if (r19 != null) goto L8;
        Iterator r20 = r12.iterator();
        Intrinsics.checkNotNullExpressionValue(r20, "queue.iterator()");
    L18:
        if (r20.hasNext() == false) goto L23;
        Object r21 = r20.next();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate r22 = (X509Certificate) r21;
        if (b(r18, r22) == false) goto L18;
        r20.remove();
        r13.add(r22);
    L22:
        r15 = r15 + 1;
        goto L4
    L23:
        if (r16 == false) goto L26;
        return r13;
    L26:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r18);
    L8:
        if (r13.size() <= 1) goto L10;
    L11:
        r13.add(r19);
    L13:
        if (b(r19, r19) == true) goto L14;
        r16 = true;
        goto L22
    L14:
        return r13;
    L10:
        if (Intrinsics.areEqual(r18, r19) == true) goto L13;
    L28:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r13);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(((a) r10).f12503b, this.f12503b) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.f12503b.hashCode();
    }
}
