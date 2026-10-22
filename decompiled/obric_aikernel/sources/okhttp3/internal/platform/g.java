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
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nOpenJSSEPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenJSSEPlatform.kt\nokhttp3/internal/platform/OpenJSSEPlatform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,101:1\n37#2,2:102\n*S KotlinDebug\n*F\n+ 1 OpenJSSEPlatform.kt\nokhttp3/internal/platform/OpenJSSEPlatform\n*L\n68#1:102,2\n*E\n"})
public final class g extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11976e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f11977f = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f11978d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final g a() {
            DefaultConstructorMarker r10 = null;
            if (b() == true) goto L5;
            return null;
        L5:
            return new g(r10);
        }

        public final boolean b() {
            return g.q();
        }
    }

    static {
        a r10 = new a(null);
        f11976e = r10;
        boolean r11 = false;
        Class.forName("org.openjsse.net.ssl.OpenJSSE", false, r10.getClass().getClassLoader());     // Catch: ClassNotFoundException -> L7
        r11 = true;
    L5:
        f11977f = r11;
    }

    private g() {
        this.f11978d = new OpenJSSE();
    }

    public /* synthetic */ g(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ boolean q() {
        return f11977f;
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket r10, String r11, List<Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
        if ((r10 instanceof org.openjsse.javax.net.ssl.SSLSocket) == false) goto L7;
        org.openjsse.javax.net.ssl.SSLSocket r13 = (org.openjsse.javax.net.ssl.SSLSocket) r10;
        SSLParameters r14 = r13.getSSLParameters();
        if ((r14 instanceof SSLParameters) == false) goto L9;
        List<String> r15 = h.f11979a.b(r12);
        r14.setApplicationProtocols((String[]) r15.toArray(new String[0]));
        r13.setSSLParameters(r14);
        return;
    L9:
        return;
    L7:
        super.e(r10, r11, r12);
    }

    @Override // okhttp3.internal.platform.h
    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        if ((r10 instanceof org.openjsse.javax.net.ssl.SSLSocket) == false) goto L11;
        String r11 = ((org.openjsse.javax.net.ssl.SSLSocket) r10).getApplicationProtocol();
        if (r11 != null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L12;
        return null;
    L12:
        return r11;
    L7:
        r12 = Intrinsics.areEqual(r11, "");
        goto L8
    L11:
        return super.g(r10);
    }

    @Override // okhttp3.internal.platform.h
    public SSLContext m() {
        SSLContext r10 = SSLContext.getInstance("TLSv1.3", this.f11978d);
        Intrinsics.checkNotNullExpressionValue(r10, "getInstance(\"TLSv1.3\", provider)");
        return r10;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager o() {
        TrustManagerFactory r10 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f11978d);
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
        return (X509TrustManager) r13;
    L11:
        StringBuilder r14 = new StringBuilder();
        r14.append("Unexpected default trust managers: ");
        String r15 = Arrays.toString(r11);
        Intrinsics.checkNotNullExpressionValue(r15, "toString(this)");
        r14.append(r15);
        throw new IllegalStateException(r14.toString().toString());
    L5:
        if ((r11[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }
}
