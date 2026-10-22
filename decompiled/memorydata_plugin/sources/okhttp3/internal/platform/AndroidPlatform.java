package okhttp3.internal.platform;

import android.os.Build;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.platform.android.UtilKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u0003123B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0016J \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u000200H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "api23IsCleartextTrafficPermitted", "", "hostname", "", "networkPolicyClass", "Ljava/lang/Class;", "networkSecurityPolicy", "", "api24IsCleartextTrafficPermitted", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "protocols", "Lokhttp3/Protocol;", "connectSocket", "socket", "Ljava/net/Socket;", MemoryKeyInfoEntity.KEY_ADDRESS, "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "log", "level", "message", "t", "", "logCloseableLeak", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "AndroidCertificateChainCleaner", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "x509TrustManagerExtensions", "", "checkServerTrusted", "Ljava/lang/reflect/Method;", "(Ljava/lang/Object;Ljava/lang/reflect/Method;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "hashCode", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public AndroidCertificateChainCleaner(Object r2, Method r3) {
            Intrinsics.checkParameterIsNotNull(r2, "x509TrustManagerExtensions");
            Intrinsics.checkParameterIsNotNull(r3, "checkServerTrusted");
            this.x509TrustManagerExtensions = r2;
            this.checkServerTrusted = r3;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<? extends Certificate> r5, String r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, "chain");
            Intrinsics.checkParameterIsNotNull(r6, "hostname");
            Object[] r8 = ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new X509Certificate[0]);     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            if (r8 == null) goto L12;
            X509Certificate[] r9 = (X509Certificate[]) ZeusTransformUtils.preCheckCast(r8, X509Certificate[].class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            Object r4 = this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{r9, "RSA", r6});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            if (r4 == null) goto L10;
            return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        L10:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.Certificate>");     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
        L12:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
        L13:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(e), Throwable.class, "com.obric.memorydata.plugin"));
        L16:
            e = move-exception;
            SSLPeerUnverifiedException r10 = new SSLPeerUnverifiedException(e.getMessage());
            r10.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public boolean equals(Object r1) {
            return ZeusTransformUtils.instanceOf(r1, AndroidCertificateChainCleaner.class);
        }

        public int hashCode() {
            return 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Platform buildIfSupported() {
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isSupported() == true) goto L7;
            return null;
        L7:
            return (Platform) ZeusTransformUtils.preCheckCast(new AndroidPlatform(), Platform.class, "com.obric.memorydata.plugin");
        }

        public final boolean isSupported() {
            return AndroidPlatform.access$isSupported$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager r3, Method r4) {
            X509TrustManager r5 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "trustManager");
            Intrinsics.checkParameterIsNotNull(r4, "findByIssuerAndSignatureMethod");
            this.trustManager = r5;
            this.findByIssuerAndSignatureMethod = r4;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex r1, X509TrustManager r2, Method r3, int r4, Object r5) {
            X509TrustManager r6 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r2, X509TrustManager.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = r1.trustManager;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.findByIssuerAndSignatureMethod;
        L9:
            return r1.copy(r6, r3);
        }

        public final CustomTrustRootIndex copy(X509TrustManager r2, Method r3) {
            X509TrustManager r1 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r2, X509TrustManager.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "trustManager");
            Intrinsics.checkParameterIsNotNull(r3, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(r1, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, CustomTrustRootIndex.class) == false) goto L11;
            CustomTrustRootIndex r4 = (CustomTrustRootIndex) ZeusTransformUtils.preCheckCast(r3, CustomTrustRootIndex.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.trustManager, r4.trustManager) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, r4.findByIssuerAndSignatureMethod) == true) goto L17;
            return false;
        L17:
            return true;
        L11:
            return false;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate r5) {
            Intrinsics.checkParameterIsNotNull(r5, "cert");
            Object r4 = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{r5});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
            if (r4 == null) goto L7;
            return ((TrustAnchor) ZeusTransformUtils.preCheckCast(r4, TrustAnchor.class, "com.obric.memorydata.plugin")).getTrustedCert();
        L7:
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
        L10:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("unable to get issues and signature", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
        L8:
            return null;
        }

        public int hashCode() {
            X509TrustManager r0 = this.trustManager;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Method r4 = this.findByIssuerAndSignatureMethod;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ")";
        }
    }

    static {
        Companion = new Companion(null);
        boolean r1 = true;
        ZeusTransformUtils.forName("com.android.org.conscrypt.OpenSSLSocketImpl", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L11
        if (Build.VERSION.SDK_INT < 21) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
    L12:
        isSupported = r1;
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT).toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: ClassNotFoundException -> L11
    L6:
        r3 = false;
    L11:
        r1 = false;
        goto L12
    }

    public AndroidPlatform() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new SocketAdapter[]{StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), ConscryptSocketAdapter.INSTANCE.buildIfSupported(), (SocketAdapter) ZeusTransformUtils.preCheckCast(new DeferredSocketAdapter("com.google.android.gms.org.conscrypt"), SocketAdapter.class, "com.obric.memorydata.plugin")}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((SocketAdapter) ZeusTransformUtils.preCheckCast(r3, SocketAdapter.class, "com.obric.memorydata.plugin")).isSupported() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.socketAdapters = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        this.closeGuard = CloseGuard.Companion.get();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    private final boolean api23IsCleartextTrafficPermitted(String r4, Class<?> r5, Object r6) {
        Object r7 = r5.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(r6, new Object[0]);     // Catch: NoSuchMethodException -> L7
        if (r7 == null) goto L6;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: NoSuchMethodException -> L7
    L8:
        return super.isCleartextTrafficPermitted(r4);
    }

    private final boolean api24IsCleartextTrafficPermitted(String r6, Class<?> r7, Object r8) {
        Object r0 = r7.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(r8, new Object[]{r6});     // Catch: NoSuchMethodException -> L7
        if (r0 == null) goto L6;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: NoSuchMethodException -> L7
    L8:
        return api23IsCleartextTrafficPermitted(r6, r7, r8);
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r9) {
        X509TrustManager r10 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r9, X509TrustManager.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r10, "trustManager");
        Class r1 = ZeusTransformUtils.forName("android.net.http.X509TrustManagerExtensions", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Object r4 = r1.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{r10});     // Catch: Exception -> L5
        Method r2 = r1.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class});     // Catch: Exception -> L5
        Intrinsics.checkExpressionValueIsNotNull(r4, "extensions");     // Catch: Exception -> L5
        Intrinsics.checkExpressionValueIsNotNull(r2, "checkServerTrusted");     // Catch: Exception -> L5
        return (CertificateChainCleaner) ZeusTransformUtils.preCheckCast(new AndroidCertificateChainCleaner(r4, r2), CertificateChainCleaner.class, "com.obric.memorydata.plugin");
    L6:
        return super.buildCertificateChainCleaner(r10);
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager r8) {
        X509TrustManager r9 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r8, X509TrustManager.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "trustManager");
        Method r0 = r9.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkExpressionValueIsNotNull(r0, "method");     // Catch: NoSuchMethodException -> L5
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        return (TrustRootIndex) ZeusTransformUtils.preCheckCast(new CustomTrustRootIndex(r9, r0), TrustRootIndex.class, "com.obric.memorydata.plugin");
    L6:
        return super.buildTrustRootIndex(r9);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r4, String r5, List<? extends Protocol> r6) {
        List<? extends Protocol> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r7, "protocols");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.socketAdapters, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = r3.next();
        if (((SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin")).matchesSocket(r4) == false) goto L4;
    L9:
        SocketAdapter r8 = (SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L16;
        r8.configureTlsExtensions(r4, r5, r7);
        return;
    L16:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket r2, InetSocketAddress r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, "socket");
        Intrinsics.checkParameterIsNotNull(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
        r2.connect((SocketAddress) ZeusTransformUtils.preCheckCast(r3, SocketAddress.class, "com.obric.memorydata.plugin"), r4);     // Catch: ClassCastException -> L5
        return;
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT != 26) goto L11;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Exception in connect", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkParameterIsNotNull(r5, "sslSocket");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.socketAdapters, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (((SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin")).matchesSocket(r5) == false) goto L4;
    L9:
        SocketAdapter r6 = (SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.getSelectedProtocol(r5);
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "closer");
        return this.closeGuard.createAndOpen(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String r7) {
        Intrinsics.checkParameterIsNotNull(r7, "hostname");
        Class<?> r2 = ZeusTransformUtils.forName("android.security.NetworkSecurityPolicy", "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L5 IllegalArgumentException -> L8 IllegalAccessException -> L11 Throwable -> L14
        Object r3 = r2.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L5 IllegalArgumentException -> L8 IllegalAccessException -> L11 Throwable -> L14
        Intrinsics.checkExpressionValueIsNotNull(r2, "networkPolicyClass");     // Catch: InvocationTargetException -> L5 IllegalArgumentException -> L8 IllegalAccessException -> L11 Throwable -> L14
        Intrinsics.checkExpressionValueIsNotNull(r3, "networkSecurityPolicy");     // Catch: InvocationTargetException -> L5 IllegalArgumentException -> L8 IllegalAccessException -> L11 Throwable -> L14
        goto L15
    L18:
        return api24IsCleartextTrafficPermitted(r7, r2, r3);
    L11:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("unable to determine cleartext support", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("unable to determine cleartext support", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("unable to determine cleartext support", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        return super.isCleartextTrafficPermitted(r7);
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int r1, String r2, Throwable r3) {
        Intrinsics.checkParameterIsNotNull(r2, "message");
        UtilKt.androidLog(r1, r2, r3);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String r2, Object r3) {
        Intrinsics.checkParameterIsNotNull(r2, "message");
        if (this.closeGuard.warnIfOpen(r3) == true) goto L6;
        log(5, r2, null);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r5) {
        Intrinsics.checkParameterIsNotNull(r5, "sslSocketFactory");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.socketAdapters, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (((SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin")).matchesSocketFactory(r5) == false) goto L4;
    L9:
        SocketAdapter r6 = (SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.trustManager(r5);
    L8:
        r0 = null;
        goto L9
    }
}
