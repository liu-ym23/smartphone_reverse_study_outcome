package nc;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAndroidCertificateChainCleaner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n37#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n*L\n43#1:75,2\n*E\n"})
public final class b extends qc.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11339d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X509TrustManager f11340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X509TrustManagerExtensions f11341c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final b a(X509TrustManager r10) {
            Intrinsics.checkNotNullParameter(r10, "trustManager");
            X509TrustManagerExtensions r11 = new X509TrustManagerExtensions(r10);     // Catch: IllegalArgumentException -> L5
        L6:
            if (r11 != null) goto L8;
            return null;
        L8:
            return new b(r10, r11);
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
        f11339d = new a(null);
    }

    public b(X509TrustManager r10, X509TrustManagerExtensions r11) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        Intrinsics.checkNotNullParameter(r11, "x509TrustManagerExtensions");
        this.f11340b = r10;
        this.f11341c = r11;
    }

    @Override // qc.c
    public List<Certificate> a(List<? extends Certificate> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        Intrinsics.checkNotNullParameter(r11, "hostname");
        X509Certificate[] r12 = (X509Certificate[]) r10.toArray(new X509Certificate[0]);
        List<X509Certificate> r13 = this.f11341c.checkServerTrusted(r12, "RSA", r11);     // Catch: CertificateException -> L5
        Intrinsics.checkNotNullExpressionValue(r13, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");     // Catch: CertificateException -> L5
        return r13;
    L5:
        e = move-exception;
        SSLPeerUnverifiedException r14 = new SSLPeerUnverifiedException(e.getMessage());
        r14.initCause(e);
        throw r14;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) r10).f11340b != this.f11340b) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f11340b);
    }
}
