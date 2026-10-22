package okhttp3.internal.platform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "setProtocolMethod", "Ljava/lang/reflect/Method;", "getProtocolMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "socket", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Jdk9Platform extends Platform {
    public static final Companion Companion = null;
    public final Method getProtocolMethod;
    public final Method setProtocolMethod;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Jdk9Platform;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Jdk9Platform buildIfSupported() {
            Method r4 = SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class});     // Catch: NoSuchMethodException -> L4
            Method r0 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);     // Catch: NoSuchMethodException -> L4
            Intrinsics.checkExpressionValueIsNotNull(r4, "setProtocolMethod");     // Catch: NoSuchMethodException -> L4
            Intrinsics.checkExpressionValueIsNotNull(r0, "getProtocolMethod");     // Catch: NoSuchMethodException -> L4
            return new Jdk9Platform(r4, r0);
        L4:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Jdk9Platform(Method r2, Method r3) {
        Intrinsics.checkParameterIsNotNull(r2, "setProtocolMethod");
        Intrinsics.checkParameterIsNotNull(r3, "getProtocolMethod");
        this.setProtocolMethod = r2;
        this.getProtocolMethod = r3;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r6, String r7, List<? extends Protocol> r8) {
        List<? extends Protocol> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r9, "protocols");
        SSLParameters r0 = r6.getSSLParameters();     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        List<String> r10 = Platform.Companion.alpnProtocolNames(r9);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        Method r5 = this.setProtocolMethod;     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        Object[] r2 = new Object[1];     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        Object[] r11 = ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        if (r11 == null) goto L8;
        r2[0] = r11;     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        r5.invoke(r0, r2);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        r6.setSSLParameters(r0);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        return;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L12:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to set SSL parameters", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to set SSL parameters", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r4) {
        Intrinsics.checkParameterIsNotNull(r4, "socket");
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.getProtocolMethod.invoke(r4, new Object[0]), String.class, "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L13
        if (r3 == null) goto L8;
        if (Intrinsics.areEqual(r3, "") == true) goto L8;
        return r3;
    L8:
        return null;
    L13:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocketFactory");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
