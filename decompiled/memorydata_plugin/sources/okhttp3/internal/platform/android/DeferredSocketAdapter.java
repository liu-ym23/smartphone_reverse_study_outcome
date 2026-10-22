package okhttp3.internal.platform.android;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/android/DeferredSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketPackage", "", "(Ljava/lang/String;)V", "delegate", "initialized", "", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "protocols", "", "Lokhttp3/Protocol;", "getDelegate", "actualSSLSocketClass", "getSelectedProtocol", "isSupported", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class DeferredSocketAdapter implements SocketAdapter {
    private SocketAdapter delegate;
    private boolean initialized;
    private final String socketPackage;

    public DeferredSocketAdapter(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "socketPackage");
        this.socketPackage = r2;
    }

    private final synchronized SocketAdapter getDelegate(SSLSocket r7) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == false) goto L25;
    L19:
        SocketAdapter r8 = this.delegate;     // Catch: Throwable -> L22
        monitor-exit(this);
        return r8;
    L25:
        Class<?> r1 = r7.getClass();     // Catch: Exception -> L16 Throwable -> L22
    L8:
        if ((!Intrinsics.areEqual(r1.getName(), this.socketPackage + ".OpenSSLSocketImpl")) == false) goto L14;
        r1 = r1.getSuperclass();     // Catch: Exception -> L16 Throwable -> L22
        Intrinsics.checkExpressionValueIsNotNull(r1, "possibleClass.superclass");     // Catch: Exception -> L16 Throwable -> L22
        if (r1 != null) goto L8;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + r7), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16 Throwable -> L22
    L14:
        this.delegate = (SocketAdapter) ZeusTransformUtils.preCheckCast(new AndroidSocketAdapter(r1), SocketAdapter.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16 Throwable -> L22
    L18:
        this.initialized = true;     // Catch: Throwable -> L22
    L16:
        e = move-exception;
        Platform.Companion.get().log(5, "Failed to initialize DeferredSocketAdapter " + this.socketPackage, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        goto L18
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket r3, String r4, List<? extends Protocol> r5) {
        List<? extends Protocol> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r6, "protocols");
        SocketAdapter r2 = getDelegate(r3);
        if (r2 == null) goto L6;
        r2.configureTlsExtensions(r3, r4, r6);
        return;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        SocketAdapter r1 = getDelegate(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r4) {
        Intrinsics.checkParameterIsNotNull(r4, "sslSocket");
        String r5 = r4.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(r5, "sslSocket.javaClass.name");
        return StringsKt.startsWith$default(r5, this.socketPackage, false, 2, null);
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
