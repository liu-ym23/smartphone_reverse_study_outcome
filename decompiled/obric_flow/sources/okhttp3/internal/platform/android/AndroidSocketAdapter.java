package okhttp3.internal.platform.android;

import androidx.constraintlayout.motion.widget.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "(Ljava/lang/Class;)V", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setAlpnProtocols", "setHostname", "setUseSessionTickets", "configureTlsExtensions", "", "sslSocket", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;
    private static final DeferredSocketAdapter.Factory playProviderFactory = null;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "build", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", "packageName", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ AndroidSocketAdapter access$build(Companion r5, Class r10) {
            return r5.build(r10);
        }

        private final AndroidSocketAdapter build(Class<? super SSLSocket> r5) {
            Class<? super SSLSocket> r10 = r5;
        L3:
            if (r10 == null) goto L11;
            if (Intrinsics.areEqual(r10.getSimpleName(), "OpenSSLSocketImpl") == true) goto L11;
            r10 = r10.getSuperclass();
            if (r10 != null) goto L3;
            throw new AssertionError(a.l(r5, "No OpenSSLSocketImpl superclass of socket of type "));
        L11:
            Intrinsics.checkNotNull(r10);
            return new AndroidSocketAdapter(r10);
        }

        public final DeferredSocketAdapter.Factory factory(final String r5) {
            Intrinsics.checkNotNullParameter(r5, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(r5);
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        playProviderFactory = r5.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketClass");
        this.sslSocketClass = r5;
        this.setUseSessionTickets = r5.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        this.setHostname = r5.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = r5.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = r5.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return playProviderFactory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket r5, String r10, List<? extends Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
        if (matchesSocket(r5) == true) goto L18;
        return;
    L18:
        this.setUseSessionTickets.invoke(r5, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r10 == null) goto L11;
        this.setHostname.invoke(r5, new Object[]{r10});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L11:
        this.setAlpnProtocols.invoke(r5, new Object[]{Platform.Companion.concatLengthPrefixed(r11)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L20:
        return;
    L9:
        e = move-exception;
        throw new AssertionError(e);
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        if (matchesSocket(r5) == true) goto L23;
        return null;
    L23:
        byte[] r10 = (byte[]) this.getAlpnSelectedProtocol.invoke(r5, null);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NullPointerException -> L13
        if (r10 == null) goto L21;
    L25:
        return new String(r10, StandardCharsets.UTF_8);
    L21:
        return null;
    L11:
        e = move-exception;
        throw new AssertionError(e);
    L13:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), "ssl == null") == true) goto L26;
        throw e;
    L26:
        return null;
    L9:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        return this.sslSocketClass.isInstance(r5);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, r5);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, r5);
    }
}
