package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f20616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TlsVersion f20617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f20618c;
    public final List d;

    public a0(TlsVersion r5, m r10, List r11, final Function0 r12) {
        Intrinsics.checkNotNullParameter(r5, "tlsVersion");
        Intrinsics.checkNotNullParameter(r10, "cipherSuite");
        Intrinsics.checkNotNullParameter(r11, "localCertificates");
        Intrinsics.checkNotNullParameter(r12, "peerCertificatesFn");
        this.f20617b = r5;
        this.f20618c = r10;
        this.d = r11;
        this.f20616a = LazyKt.lazy(new Handshake$peerCertificates$2(r12));
    }

    public final List a() {
        return (List) this.f20616a.getValue();
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a0) == false) goto L13;
        a0 r10 = (a0) r5;
        if (r10.f20617b != this.f20617b) goto L13;
        if (Intrinsics.areEqual(r10.f20618c, this.f20618c) == false) goto L13;
        if (Intrinsics.areEqual(r10.a(), a()) == false) goto L13;
        if (Intrinsics.areEqual(r10.d, this.d) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final int hashCode() {
        int r5 = (this.f20617b.hashCode() + 527) * 31;
        int r10 = (this.f20618c.hashCode() + r5) * 31;
        int r11 = (a().hashCode() + r10) * 31;
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        List r5 = a();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Certificate r12 = (Certificate) r11.next();
        if ((r12 instanceof X509Certificate) == false) goto L8;
        String r13 = ((X509Certificate) r12).getSubjectDN().toString();
    L9:
        r10.add(r13);
        goto L4
    L8:
        r13 = r12.getType();
        goto L9
    L10:
        String r14 = r10.toString();
        StringBuilder r15 = new StringBuilder("Handshake{tlsVersion=");
        r15.append(this.f20617b);
        r15.append(" cipherSuite=");
        r15.append(this.f20618c);
        r15.append(" peerCertificates=");
        r15.append(r14);
        r15.append(" localCertificates=");
        List r16 = this.d;
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator r18 = r16.iterator();
    L12:
        if (r18.hasNext() == false) goto L18;
        Certificate r19 = (Certificate) r18.next();
        if ((r19 instanceof X509Certificate) == false) goto L16;
        String r20 = ((X509Certificate) r19).getSubjectDN().toString();
    L17:
        r17.add(r20);
        goto L12
    L16:
        r20 = r19.getType();
        goto L17
    L18:
        r15.append(r17);
        r15.append('}');
        return r15.toString();
    }
}
