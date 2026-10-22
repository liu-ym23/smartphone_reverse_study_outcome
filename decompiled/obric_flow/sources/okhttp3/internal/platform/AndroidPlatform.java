package okhttp3.internal.platform;

import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0006H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "", "closer", "isCleartextTrafficPermitted", "", "logCloseableLeak", "message", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Platform buildIfSupported() {
            if (isSupported() == true) goto L7;
            return null;
        L7:
            return new AndroidPlatform();
        }

        public final boolean isSupported() {
            return AndroidPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager r5, Method r10) {
            Intrinsics.checkNotNullParameter(r5, "trustManager");
            Intrinsics.checkNotNullParameter(r10, "findByIssuerAndSignatureMethod");
            this.trustManager = r5;
            this.findByIssuerAndSignatureMethod = r10;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex r5, X509TrustManager r10, Method r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.trustManager;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.findByIssuerAndSignatureMethod;
        L9:
            return r5.copy(r10, r11);
        }

        public final CustomTrustRootIndex copy(X509TrustManager r5, Method r10) {
            Intrinsics.checkNotNullParameter(r5, "trustManager");
            Intrinsics.checkNotNullParameter(r10, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof CustomTrustRootIndex) == false) goto L10;
            CustomTrustRootIndex r10 = (CustomTrustRootIndex) r5;
            if (Intrinsics.areEqual(this.trustManager, r10.trustManager) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, r10.findByIssuerAndSignatureMethod) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate r5) {
            Intrinsics.checkNotNullParameter(r5, "cert");
            Object r10 = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{r5});     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L10
            if (r10 == null) goto L9;
            return ((TrustAnchor) r10).getTrustedCert();
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L10
        L6:
            e = move-exception;
            throw new AssertionError("unable to get issues and signature", e);
        L10:
            return null;
        }

        public int hashCode() {
            X509TrustManager r5 = this.trustManager;
            int r10 = 0;
            if (r5 == null) goto L5;
            int r11 = r5.hashCode();
        L6:
            int r12 = r11 * 31;
            Method r13 = this.findByIssuerAndSignatureMethod;
            if (r13 == null) goto L10;
            r10 = r13.hashCode();
        L10:
            return r12 + r10;
        L5:
            r11 = 0;
            goto L6
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ")";
        }
    }

    static {
        Companion = new Companion(null);
        Platform.Companion.isAndroid();
        isSupported = false;
    }

    public AndroidPlatform() {
        List r5 = CollectionsKt.listOfNotNull(new SocketAdapter[]{StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (((SocketAdapter) r12).isSupported() == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        this.socketAdapters = r10;
        this.closeGuard = CloseGuard.Companion.get();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        AndroidCertificateChainCleaner r10 = AndroidCertificateChainCleaner.Companion.buildIfSupported(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return super.buildCertificateChainCleaner(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        Method r10 = r5.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L5
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        return new CustomTrustRootIndex(r5, r10);
    L6:
        return super.buildTrustRootIndex(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r5, String r10, List<Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
        Iterator<T> r12 = this.socketAdapters.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((SocketAdapter) r13).matchesSocket(r5) == false) goto L4;
    L9:
        SocketAdapter r14 = (SocketAdapter) r13;
        if (r14 == null) goto L16;
        r14.configureTlsExtensions(r5, r10, r11);
        return;
    L16:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket r5, InetSocketAddress r10, int r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "socket");
        Intrinsics.checkNotNullParameter(r10, "address");
        r5.connect(r10, r11);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Iterator<T> r10 = this.socketAdapters.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (((SocketAdapter) r11).matchesSocket(r5) == false) goto L4;
    L9:
        SocketAdapter r12 = (SocketAdapter) r11;
        if (r12 != null) goto L12;
        return null;
    L12:
        return r12.getSelectedProtocol(r5);
    L8:
        r11 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String r5) {
        Intrinsics.checkNotNullParameter(r5, "closer");
        return this.closeGuard.createAndOpen(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (this.closeGuard.warnIfOpen(r11) == true) goto L6;
        Platform.log$default(this, r10, 5, null, 4, null);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketFactory");
        Iterator<T> r10 = this.socketAdapters.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (((SocketAdapter) r11).matchesSocketFactory(r5) == false) goto L4;
    L9:
        SocketAdapter r12 = (SocketAdapter) r11;
        if (r12 != null) goto L12;
        return null;
    L12:
        return r12.trustManager(r5);
    L8:
        r11 = null;
        goto L9
    }
}
