package okhttp3.internal.platform.android;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "(Ljava/lang/Class;)V", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setAlpnProtocols", "setHostname", "setUseSessionTickets", "configureTlsExtensions", "", "sslSocket", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SocketAdapter buildIfSupported(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Class r4 = ZeusTransformUtils.forName(r3 + ".OpenSSLSocketImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L8
            if (r4 == null) goto L7;
            AndroidSocketAdapter r0 = new AndroidSocketAdapter(r4);     // Catch: Exception -> L8
        L11:
            return (SocketAdapter) ZeusTransformUtils.preCheckCast(r0, SocketAdapter.class, "com.obric.memorydata.plugin");
        L7:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");     // Catch: Exception -> L8
        L8:
            e = move-exception;
            UtilKt.androidLog(5, "unable to load android socket classes", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            r0 = null;
            goto L11
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> r5) {
        Intrinsics.checkParameterIsNotNull(r5, "sslSocketClass");
        this.sslSocketClass = r5;
        Method r1 = r5.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.checkExpressionValueIsNotNull(r1, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = r1;
        this.setHostname = r5.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = r5.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = r5.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket r7, String r8, List<? extends Protocol> r9) {
        List<? extends Protocol> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r10, "protocols");
        if (matchesSocket(r7) == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L16;
    L7:
        this.setAlpnProtocols.invoke(r7, new Object[]{Platform.Companion.concatLengthPrefixed(r10)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
    L12:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(e), Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(e), Throwable.class, "com.obric.memorydata.plugin"));
    L18:
        return;
    L16:
        this.setUseSessionTickets.invoke(r7, new Object[]{true});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        this.setHostname.invoke(r7, new Object[]{r8});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        goto L7
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket r4) {
        Intrinsics.checkParameterIsNotNull(r4, "sslSocket");
        if (matchesSocket(r4) == true) goto L15;
        return null;
    L15:
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(this.getAlpnSelectedProtocol.invoke(r4, new Object[0]), byte[].class, "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        if (r3 == null) goto L17;
        Charset r5 = StandardCharsets.UTF_8;     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        Intrinsics.checkExpressionValueIsNotNull(r5, "StandardCharsets.UTF_8");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12
        return new String(r3, r5);
    L17:
        return null;
    L12:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(e), Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(e), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        return ZeusTransformUtils.instanceOf(this.sslSocketClass, r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory r1) {
        Intrinsics.checkParameterIsNotNull(r1, "sslSocketFactory");
        return false;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory r1) {
        Intrinsics.checkParameterIsNotNull(r1, "sslSocketFactory");
        return null;
    }
}
