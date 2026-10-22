package okhttp3.internal.platform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/platform/OpenJSSEPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class OpenJSSEPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/OpenJSSEPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/OpenJSSEPlatform;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final OpenJSSEPlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isSupported() == true) goto L5;
            return null;
        L5:
            return new OpenJSSEPlatform(r0);
        }

        public final boolean isSupported() {
            return OpenJSSEPlatform.access$isSupported$cp();
        }
    }

    static {
        Companion = new Companion(null);
        ZeusTransformUtils.forName("org.openjsse.net.ssl.OpenJSSE", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
        boolean r0 = true;
    L6:
        isSupported = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private OpenJSSEPlatform() {
        this.provider = (Provider) ZeusTransformUtils.preCheckCast(new OpenJSSE(), Provider.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OpenJSSEPlatform(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r3, String r4, List<? extends Protocol> r5) {
        List<Protocol> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r6, "protocols");
        if (ZeusTransformUtils.instanceOf(r3, org.openjsse.javax.net.ssl.SSLSocket.class) == false) goto L11;
        SSLParameters r2 = ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r3, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.memorydata.plugin")).getSSLParameters();
        if (ZeusTransformUtils.instanceOf(r2, org.openjsse.javax.net.ssl.SSLParameters.class) == false) goto L13;
        List<String> r7 = Platform.Companion.alpnProtocolNames(r6);
        org.openjsse.javax.net.ssl.SSLParameters r8 = (org.openjsse.javax.net.ssl.SSLParameters) ZeusTransformUtils.preCheckCast(r2, org.openjsse.javax.net.ssl.SSLParameters.class, "com.obric.memorydata.plugin");
        Object[] r9 = ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        if (r9 == null) goto L10;
        r8.setApplicationProtocols((String[]) ZeusTransformUtils.preCheckCast(r9, String[].class, "com.obric.memorydata.plugin"));
        ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r3, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.memorydata.plugin")).setSSLParameters(r2);
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        return;
    L11:
        super.configureTlsExtensions(r3, r4, r6);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        if (ZeusTransformUtils.instanceOf(r2, org.openjsse.javax.net.ssl.SSLSocket.class) == false) goto L11;
        String r1 = ((org.openjsse.javax.net.ssl.SSLSocket) ZeusTransformUtils.preCheckCast(r2, org.openjsse.javax.net.ssl.SSLSocket.class, "com.obric.memorydata.plugin")).getApplicationProtocol();
        if (r1 != null) goto L8;
    L9:
        return null;
    L8:
        if (Intrinsics.areEqual(r1, "") == true) goto L9;
        return r1;
    L11:
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLSv1.3", this.provider);
        Intrinsics.checkExpressionValueIsNotNull(r1, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r5 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        r5.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r5, "factory");
        TrustManager[] r6 = r5.getTrustManagers();
        if (r6 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        boolean r1 = true;
        if (r6.length == 1) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L18;
        TrustManager r7 = r6[0];
        if (r7 == null) goto L17;
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(r7, X509TrustManager.class, "com.obric.memorydata.plugin");
    L17:
        throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L18:
        StringBuilder r0 = new StringBuilder().append("Unexpected default trust managers: ");
        String r8 = Arrays.toString(r6);
        Intrinsics.checkExpressionValueIsNotNull(r8, "java.util.Arrays.toString(this)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(r0.append(r8).toString().toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r6[0], X509TrustManager.class) == false) goto L10;
        goto L10
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocketFactory");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
