package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConscryptPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConscryptPlatform.kt\nokhttp3/internal/platform/ConscryptPlatform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,141:1\n37#2,2:142\n*S KotlinDebug\n*F\n+ 1 ConscryptPlatform.kt\nokhttp3/internal/platform/ConscryptPlatform\n*L\n89#1:142,2\n*E\n"})
public final class d extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11961e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f11962f = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f11963d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(int r10, int r11, int r12) {
            Conscrypt.Version r13 = Conscrypt.version();
            if (r13.major() == r10) goto L10;
            if (r13.major() <= r10) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (r13.minor() == r11) goto L17;
            if (r13.minor() <= r11) goto L15;
            return true;
        L15:
            return false;
        L17:
            if (r13.patch() < r12) goto L20;
            return true;
        L20:
            return false;
        }

        public final d b() {
            DefaultConstructorMarker r10 = null;
            if (c() == true) goto L5;
            return null;
        L5:
            return new d(r10);
        }

        public final boolean c() {
            return d.q();
        }
    }

    public static final class b implements ConscryptHostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11964a = null;

        static {
            f11964a = new b();
        }

        private b() {
        }
    }

    static {
        a r10 = new a(null);
        f11961e = r10;
        boolean r11 = false;
        Class.forName("org.conscrypt.Conscrypt$Version", false, r10.getClass().getClassLoader());     // Catch: Throwable -> L10
        if (Conscrypt.isAvailable() == false) goto L8;
        if (r10.a(2, 1, 0) == false) goto L8;
        r11 = true;
    L8:
        f11962f = r11;
    }

    private d() {
        Provider r10 = Conscrypt.newProvider();
        Intrinsics.checkNotNullExpressionValue(r10, "newProvider()");
        this.f11963d = r10;
    }

    public /* synthetic */ d(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ boolean q() {
        return f11962f;
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket r10, String r11, List<Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        if (Conscrypt.isConscrypt(r10) == false) goto L5;
        Conscrypt.setUseSessionTickets(r10, true);
        Conscrypt.setApplicationProtocols(r10, (String[]) h.f11979a.b(r12).toArray(new String[0]));
        return;
    L5:
        super.e(r10, r11, r12);
    }

    @Override // okhttp3.internal.platform.h
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        if (Conscrypt.isConscrypt(r10) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r10);
    L6:
        return super.g(r10);
    }

    @Override // okhttp3.internal.platform.h
    public SSLContext m() {
        SSLContext r10 = SSLContext.getInstance("TLS", this.f11963d);
        Intrinsics.checkNotNullExpressionValue(r10, "getInstance(\"TLS\", provider)");
        return r10;
    }

    @Override // okhttp3.internal.platform.h
    public SSLSocketFactory n(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        SSLContext r11 = m();
        r11.init(null, new TrustManager[]{r10}, null);
        SSLSocketFactory r12 = r11.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(r12, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return r12;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager o() {
        TrustManagerFactory r10 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r10.init(null);
        TrustManager[] r11 = r10.getTrustManagers();
        Intrinsics.checkNotNull(r11);
        boolean r12 = true;
        if (r11.length == 1) goto L5;
    L7:
        r12 = false;
    L8:
        if (r12 == false) goto L11;
        TrustManager r13 = r11[0];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        X509TrustManager r14 = (X509TrustManager) r13;
        Conscrypt.setHostnameVerifier(r14, b.f11964a);
        return r14;
    L11:
        StringBuilder r15 = new StringBuilder();
        r15.append("Unexpected default trust managers: ");
        String r16 = Arrays.toString(r11);
        Intrinsics.checkNotNullExpressionValue(r16, "toString(this)");
        r15.append(r16);
        throw new IllegalStateException(r15.toString().toString());
    L5:
        if ((r11[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        return null;
    }
}
