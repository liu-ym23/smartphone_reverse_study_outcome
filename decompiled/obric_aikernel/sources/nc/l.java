package nc;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f11364j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f11365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<?> f11366i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ k b(a r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = "com.android.org.conscrypt";
        L6:
            return r10.a(r11);
        }

        public final k a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Class<?> r11 = Class.forName(r10 + ".OpenSSLSocketImpl");     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");     // Catch: Exception -> L5
            Class<?> r12 = Class.forName(r10 + ".OpenSSLSocketFactoryImpl");     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");     // Catch: Exception -> L5
            Class<?> r13 = Class.forName(r10 + ".SSLParametersImpl");     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r13, "paramsClass");     // Catch: Exception -> L5
            return new l(r11, r12, r13);
        L5:
            e = move-exception;
            okhttp3.internal.platform.h.f11979a.g().j("unable to load android socket classes", 5, e);
            return null;
        }
    }

    static {
        f11364j = new a(null);
    }

    public l(Class<? super SSLSocket> r10, Class<? super SSLSocketFactory> r11, Class<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketClass");
        Intrinsics.checkNotNullParameter(r11, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(r12, "paramClass");
        super(r10);
        this.f11365h = r11;
        this.f11366i = r12;
    }

    @Override // nc.f, nc.k
    public X509TrustManager c(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        Object r11 = hc.e.J(r10, this.f11366i, "sslParameters");
        Intrinsics.checkNotNull(r11);
        X509TrustManager r12 = (X509TrustManager) hc.e.J(r11, X509TrustManager.class, "x509TrustManager");
        if (r12 == null) goto L5;
        return r12;
    L5:
        return (X509TrustManager) hc.e.J(r11, X509TrustManager.class, "trustManager");
    }

    @Override // nc.f, nc.k
    public boolean d(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        return this.f11365h.isInstance(r10);
    }
}
