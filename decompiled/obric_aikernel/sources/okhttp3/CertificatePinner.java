package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,370:1\n625#2,8:371\n*S KotlinDebug\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n*L\n216#1:371,8\n*E\n"})
public final class CertificatePinner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f11653c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final CertificatePinner f11654d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<c> f11655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qc.c f11656b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f11657a;

        public a() {
            this.f11657a = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner a() {
            return new CertificatePinner(CollectionsKt.toSet(this.f11657a), null, 2, 0 == true ? 1 : 0);
        }
    }

    @SourceDebugExtension({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final String a(Certificate r10) {
            Intrinsics.checkNotNullParameter(r10, "certificate");
            if ((r10 instanceof X509Certificate) == false) goto L7;
            return "sha256/" + c((X509Certificate) r10).base64();
        L7:
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @JvmStatic
        public final ByteString b(X509Certificate r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            ByteString.a r11 = ByteString.Companion;
            byte[] r12 = r10.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(r12, "publicKey.encoded");
            return ByteString.a.h(r11, r12, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        public final ByteString c(X509Certificate r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            ByteString.a r11 = ByteString.Companion;
            byte[] r12 = r10.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(r12, "publicKey.encoded");
            return ByteString.a.h(r11, r12, 0, 0, 3, null).sha256();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ByteString f11660c;

        public final ByteString a() {
            return this.f11660c;
        }

        public final String b() {
            return this.f11659b;
        }

        public final boolean c(String r12) {
            Intrinsics.checkNotNullParameter(r12, "hostname");
            if (StringsKt.startsWith$default(this.f11658a, "**.", false, 2, null) == false) goto L11;
            int r10 = this.f11658a.length() - 3;
            int r11 = r12.length() - r10;
            if (StringsKt.regionMatches$default(r12, r12.length() - r10, this.f11658a, 3, r10, false, 16, null) == false) goto L19;
            if (r11 == 0) goto L21;
            if (r12.charAt(r11 - 1) == '.') goto L21;
            return false;
        L21:
            return true;
        L19:
            return false;
        L11:
            if (StringsKt.startsWith$default(this.f11658a, "*.", false, 2, null) == false) goto L18;
            int r13 = this.f11658a.length() - 1;
            int r14 = r12.length() - r13;
            if (StringsKt.regionMatches$default(r12, r12.length() - r13, this.f11658a, 1, r13, false, 16, null) == true) goto L15;
            return false;
        L15:
            if (StringsKt.lastIndexOf$default(r12, '.', r14 - 1, false, 4, null) == (-1)) goto L21;
            return false;
        L18:
            return Intrinsics.areEqual(r12, this.f11658a);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f11658a, r11.f11658a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11659b, r11.f11659b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f11660c, r11.f11660c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11658a.hashCode() * 31) + this.f11659b.hashCode()) * 31) + this.f11660c.hashCode();
        }

        public String toString() {
            return this.f11659b + '/' + this.f11660c.base64();
        }
    }

    static {
        f11653c = new b(null);
        f11654d = new a().a();
    }

    public CertificatePinner(Set<c> r10, qc.c r11) {
        Intrinsics.checkNotNullParameter(r10, "pins");
        this.f11655a = r10;
        this.f11656b = r11;
    }

    public /* synthetic */ CertificatePinner(Set r10, qc.c r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void a(final String r10, final List<? extends Certificate> r11) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        Intrinsics.checkNotNullParameter(r11, "peerCertificates");
        b(r10, new CertificatePinner$check$1(this, r11, r10));
    }

    public final void b(String r10, Function0<? extends List<? extends X509Certificate>> r11) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        Intrinsics.checkNotNullParameter(r11, "cleanedPeerCertificatesFn");
        List<c> r12 = c(r10);
        if (r12.isEmpty() == false) goto L5;
        return;
    L5:
        List<? extends X509Certificate> r13 = r11.invoke();
        Iterator<? extends X509Certificate> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L27;
        X509Certificate r15 = r14.next();
        Iterator<c> r16 = r12.iterator();
        ByteString r17 = null;
        ByteString r18 = null;
    L10:
        if (r16.hasNext() == false) goto L7;
        c r19 = r16.next();
        String r20 = r19.b();
        if (Intrinsics.areEqual(r20, "sha256") == true) goto L13;
        if (Intrinsics.areEqual(r20, "sha1") == false) goto L26;
        if (r18 != null) goto L23;
        r18 = f11653c.b(r15);
    L23:
        if (Intrinsics.areEqual(r19.a(), r18) == false) goto L10;
        return;
    L26:
        throw new AssertionError("unsupported hashAlgorithm: " + r19.b());
    L13:
        if (r17 != null) goto L16;
        r17 = f11653c.c(r15);
    L16:
        if (Intrinsics.areEqual(r19.a(), r17) == false) goto L10;
        return;
    L27:
        StringBuilder r21 = new StringBuilder();
        r21.append("Certificate pinning failure!");
        r21.append("\n  Peer certificate chain:");
        Iterator<? extends X509Certificate> r110 = r13.iterator();
    L29:
        if (r110.hasNext() == false) goto L31;
        X509Certificate r22 = r110.next();
        r21.append("\n    ");
        r21.append(f11653c.a(r22));
        r21.append(": ");
        r21.append(r22.getSubjectDN().getName());
        goto L29
    L31:
        r21.append("\n  Pinned certificates for ");
        r21.append(r10);
        r21.append(":");
        Iterator<c> r23 = r12.iterator();
    L33:
        if (r23.hasNext() == false) goto L35;
        c r24 = r23.next();
        r21.append("\n    ");
        r21.append(r24);
        goto L33
    L35:
        String r25 = r21.toString();
        Intrinsics.checkNotNullExpressionValue(r25, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(r25);
    }

    public final List<c> c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        Set<c> r11 = this.f11655a;
        List<c> r12 = CollectionsKt.emptyList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (((c) r14).c(r10) == false) goto L4;
        if (r12.isEmpty() == false) goto L10;
        r12 = new ArrayList();
    L10:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
        TypeIntrinsics.asMutableList(r12).add(r14);
        goto L4
    L11:
        return r12;
    }

    public final qc.c d() {
        return this.f11656b;
    }

    public final CertificatePinner e(qc.c r10) {
        Intrinsics.checkNotNullParameter(r10, "certificateChainCleaner");
        if (Intrinsics.areEqual(this.f11656b, r10) == false) goto L6;
        return this;
    L6:
        return new CertificatePinner(this.f11655a, r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof CertificatePinner) == false) goto L9;
        CertificatePinner r11 = (CertificatePinner) r10;
        if (Intrinsics.areEqual(r11.f11655a, this.f11655a) == false) goto L9;
        if (Intrinsics.areEqual(r11.f11656b, this.f11656b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r10 = (1517 + this.f11655a.hashCode()) * 41;
        qc.c r11 = this.f11656b;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }
}
