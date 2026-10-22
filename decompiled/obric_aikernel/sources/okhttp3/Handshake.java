package okhttp3;

import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1549#2:201\n1620#2,3:202\n1549#2:205\n1620#2,3:206\n*S KotlinDebug\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n*L\n129#1:201\n129#1:202,3\n134#1:205\n134#1:206,3\n*E\n"})
public final class Handshake {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f11661e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TlsVersion f11662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f11663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f11664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f11665d;

    @SourceDebugExtension({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final List<Certificate> b(Certificate[] r10) {
            if (r10 == null) goto L5;
            return hc.e.w(Arrays.copyOf(r10, r10.length));
        L5:
            return CollectionsKt.emptyList();
        }

        @JvmStatic
        @JvmName(name = "get")
        public final Handshake a(SSLSession r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            String r11 = r10.getCipherSuite();
            if (r11 == null) goto L26;
            if (Intrinsics.areEqual(r11, "TLS_NULL_WITH_NULL_NULL") == false) goto L7;
            boolean r12 = true;
        L8:
            if (r12 == true) goto L24;
            h r13 = h.f11712b.b(r11);
            String r14 = r10.getProtocol();
            if (r14 == null) goto L22;
            if (Intrinsics.areEqual("NONE", r14) == true) goto L20;
            TlsVersion r15 = TlsVersion.Companion.a(r14);
            final List<Certificate> r16 = b(r10.getPeerCertificates());     // Catch: SSLPeerUnverifiedException -> L16
        L18:
            return new Handshake(r15, r13, b(r10.getLocalCertificates()), new Handshake$Companion$handshake$1(r16));
        L16:
            r16 = CollectionsKt.emptyList();
            goto L18
        L20:
            throw new IOException("tlsVersion == NONE");
        L22:
            throw new IllegalStateException("tlsVersion == null".toString());
        L24:
            throw new IOException("cipherSuite == " + r11);
        L7:
            r12 = Intrinsics.areEqual(r11, "SSL_NULL_WITH_NULL_NULL");
            goto L8
        L26:
            throw new IllegalStateException("cipherSuite == null".toString());
        }
    }

    static {
        f11661e = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion r10, h r11, List<? extends Certificate> r12, final Function0<? extends List<? extends Certificate>> r13) {
        Intrinsics.checkNotNullParameter(r10, "tlsVersion");
        Intrinsics.checkNotNullParameter(r11, "cipherSuite");
        Intrinsics.checkNotNullParameter(r12, "localCertificates");
        Intrinsics.checkNotNullParameter(r13, "peerCertificatesFn");
        this.f11662a = r10;
        this.f11663b = r11;
        this.f11664c = r12;
        this.f11665d = LazyKt.lazy(new Handshake$peerCertificates$2(r13));
    }

    private final String b(Certificate r10) {
        if ((r10 instanceof X509Certificate) == true) goto L7;
        String r11 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r11, WsConstants.KEY_CONNECTION_TYPE);
        return r11;
    L7:
        return ((X509Certificate) r10).getSubjectDN().toString();
    }

    @JvmName(name = "cipherSuite")
    public final h a() {
        return this.f11663b;
    }

    @JvmName(name = "localCertificates")
    public final List<Certificate> c() {
        return this.f11664c;
    }

    @JvmName(name = "peerCertificates")
    public final List<Certificate> d() {
        return (List) this.f11665d.getValue();
    }

    @JvmName(name = "tlsVersion")
    public final TlsVersion e() {
        return this.f11662a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Handshake) == false) goto L13;
        Handshake r11 = (Handshake) r10;
        if (r11.f11662a != this.f11662a) goto L13;
        if (Intrinsics.areEqual(r11.f11663b, this.f11663b) == false) goto L13;
        if (Intrinsics.areEqual(r11.d(), d()) == false) goto L13;
        if (Intrinsics.areEqual(r11.f11664c, this.f11664c) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f11662a.hashCode()) * 31) + this.f11663b.hashCode()) * 31) + d().hashCode()) * 31) + this.f11664c.hashCode();
    }

    public String toString() {
        List<Certificate> r10 = d();
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(b((Certificate) r12.next()));
        goto L4
    L6:
        String r13 = r11.toString();
        StringBuilder r14 = new StringBuilder();
        r14.append("Handshake{tlsVersion=");
        r14.append(this.f11662a);
        r14.append(" cipherSuite=");
        r14.append(this.f11663b);
        r14.append(" peerCertificates=");
        r14.append(r13);
        r14.append(" localCertificates=");
        List<Certificate> r15 = this.f11664c;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r16.add(b((Certificate) r17.next()));
        goto L8
    L10:
        r14.append(r16);
        r14.append('}');
        return r14.toString();
    }
}
