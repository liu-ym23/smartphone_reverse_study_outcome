package okhttp3.internal.platform;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import okhttp3.w;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f11980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f11981c = null;

    @SourceDebugExtension({"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,286:1\n766#2:287\n857#2,2:288\n1549#2:290\n1620#2,3:291\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n*L\n193#1:287\n193#1:288,2\n193#1:290\n193#1:291,3\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ h a(a r10) {
            return r10.f();
        }

        private final h d() {
            nc.c.f11342a.b();
            h r10 = okhttp3.internal.platform.a.f11949e.a();
            if (r10 != null) goto L6;
            h r11 = b.f11952f.a();
            Intrinsics.checkNotNull(r11);
            return r11;
        L6:
            return r10;
        }

        private final h e() {
            if (j() == false) goto L8;
            d r10 = d.f11961e.b();
            if (r10 == null) goto L8;
            return r10;
        L8:
            if (i() == false) goto L13;
            c r11 = c.f11958e.a();
            if (r11 == null) goto L13;
            return r11;
        L13:
            if (k() == false) goto L17;
            g r12 = g.f11976e.a();
            if (r12 == null) goto L17;
            return r12;
        L17:
            f r13 = f.f11974d.a();
            if (r13 == null) goto L20;
            return r13;
        L20:
            h r14 = e.f11965i.a();
            if (r14 == null) goto L24;
            return r14;
        L24:
            return new h();
        }

        private final h f() {
            if (h() == false) goto L6;
            return d();
        L6:
            return e();
        }

        private final boolean i() {
            return Intrinsics.areEqual("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return Intrinsics.areEqual("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return Intrinsics.areEqual("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List<String> b(List<? extends Protocol> r10) {
            Intrinsics.checkNotNullParameter(r10, "protocols");
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L11;
            Object r13 = r12.next();
            if (((Protocol) r13) == Protocol.HTTP_1_0) goto L8;
            boolean r14 = true;
        L9:
            if (r14 == false) goto L4;
            r11.add(r13);
            goto L4
        L8:
            r14 = false;
            goto L9
        L11:
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator r16 = r11.iterator();
        L13:
            if (r16.hasNext() == false) goto L15;
            r15.add(((Protocol) r16.next()).toString());
            goto L13
        L15:
            return r15;
        }

        public final byte[] c(List<? extends Protocol> r10) {
            Intrinsics.checkNotNullParameter(r10, "protocols");
            okio.d r11 = new okio.d();
            Iterator<String> r12 = b(r10).iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            String r13 = r12.next();
            r11.c0(r13.length());
            r11.l0(r13);
            goto L4
        L7:
            return r11.C();
        }

        @JvmStatic
        public final h g() {
            return h.a();
        }

        public final boolean h() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    static {
        a r10 = new a(null);
        f11979a = r10;
        f11980b = a.a(r10);
        f11981c = Logger.getLogger(w.class.getName());
    }

    public h() {
    }

    public static final /* synthetic */ h a() {
        return f11980b;
    }

    public static /* synthetic */ void k(h r10, String r11, int r12, Throwable r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 4;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        r10.j(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void b(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
    }

    public qc.c c(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        return new qc.a(d(r10));
    }

    public qc.e d(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        X509Certificate[] r11 = r10.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(r11, "trustManager.acceptedIssuers");
        return new qc.b((X509Certificate[]) Arrays.copyOf(r11, r11.length));
    }

    public void e(SSLSocket r10, String r11, List<Protocol> r12) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        Intrinsics.checkNotNullParameter(r12, "protocols");
    }

    public void f(Socket r10, InetSocketAddress r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "socket");
        Intrinsics.checkNotNullParameter(r11, "address");
        r10.connect(r11, r12);
    }

    public String g(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        return null;
    }

    public Object h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "closer");
        if (f11981c.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r10);
    }

    public boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "hostname");
        return true;
    }

    public void j(String r10, int r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (r11 != 5) goto L5;
        Level r13 = Level.WARNING;
    L6:
        f11981c.log(r13, r10, r12);
        return;
    L5:
        r13 = Level.INFO;
        goto L6
    }

    public void l(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (r11 != null) goto L5;
        r10 = r10 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L5:
        j(r10, 5, (Throwable) r11);
    }

    public SSLContext m() {
        SSLContext r10 = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(r10, "getInstance(\"TLS\")");
        return r10;
    }

    public SSLSocketFactory n(X509TrustManager r10) {
        Intrinsics.checkNotNullParameter(r10, "trustManager");
        SSLContext r11 = m();     // Catch: GeneralSecurityException -> L5
        r11.init(null, new TrustManager[]{r10}, null);     // Catch: GeneralSecurityException -> L5
        SSLSocketFactory r12 = r11.getSocketFactory();     // Catch: GeneralSecurityException -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "newSSLContext().apply {\n…ll)\n      }.socketFactory");     // Catch: GeneralSecurityException -> L5
        return r12;
    L5:
        e = move-exception;
        throw new AssertionError("No System TLS: " + e, e);
    }

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

    public X509TrustManager p(SSLSocketFactory r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocketFactory");
        Class<?> r11 = Class.forName("sun.security.ssl.SSLContextImpl");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        Intrinsics.checkNotNullExpressionValue(r11, "sslContextClass");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        Object r12 = hc.e.J(r10, r11, "context");     // Catch: RuntimeException -> L8 ClassNotFoundException -> L14
        if (r12 != null) goto L6;
        return null;
    L6:
        goto L18
    L13:
        return (X509TrustManager) hc.e.J(r12, X509TrustManager.class, "trustManager");
    L8:
        e = move-exception;
        if (Intrinsics.areEqual(e.getClass().getName(), "java.lang.reflect.InaccessibleObjectException") == true) goto L17;
        throw e;
    L17:
        return null;
    L18:
        return null;
    }

    public String toString() {
        String r10 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r10, "javaClass.simpleName");
        return r10;
    }
}
