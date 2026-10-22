package okhttp3.internal.platform.android;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = null;
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "com.android.org.conscrypt";
        L6:
            return r0.buildIfSupported(r1);
        }

        public final SocketAdapter buildIfSupported(String r5) {
            Intrinsics.checkParameterIsNotNull(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Class r0 = ZeusTransformUtils.forName(r5 + ".OpenSSLSocketImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            if (r0 == null) goto L11;
            Class r1 = ZeusTransformUtils.forName(r5 + ".OpenSSLSocketFactoryImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            if (r1 == null) goto L9;
            Class r6 = ZeusTransformUtils.forName(r5 + ".SSLParametersImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            Intrinsics.checkExpressionValueIsNotNull(r6, "paramsClass");     // Catch: Exception -> L12
            StandardAndroidSocketAdapter r2 = new StandardAndroidSocketAdapter(r0, r1, r6);     // Catch: Exception -> L12
        L15:
            return (SocketAdapter) ZeusTransformUtils.preCheckCast(r2, SocketAdapter.class, "com.obric.memorydata.plugin");
        L9:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");     // Catch: Exception -> L12
        L11:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");     // Catch: Exception -> L12
        L12:
            e = move-exception;
            UtilKt.androidLog(5, "unable to load android socket classes", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            r2 = null;
            goto L15
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StandardAndroidSocketAdapter(Class<? super SSLSocket> r2, Class<? super SSLSocketFactory> r3, Class<?> r4) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocketClass");
        Intrinsics.checkParameterIsNotNull(r3, "sslSocketFactoryClass");
        Intrinsics.checkParameterIsNotNull(r4, "paramClass");
        super(r2);
        this.sslSocketFactoryClass = r3;
        this.paramClass = r4;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocketFactory");
        return ZeusTransformUtils.instanceOf(this.sslSocketFactoryClass, r2);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory r3) {
        Intrinsics.checkParameterIsNotNull(r3, "sslSocketFactory");
        Object r2 = Util.readFieldOrNull(r3, this.paramClass, "sslParameters");
        if (r2 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.preCheckCast(Util.readFieldOrNull(r2, X509TrustManager.class, "x509TrustManager"), X509TrustManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        return r4;
    L9:
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(Util.readFieldOrNull(r2, X509TrustManager.class, "trustManager"), X509TrustManager.class, "com.obric.memorydata.plugin");
    }
}
