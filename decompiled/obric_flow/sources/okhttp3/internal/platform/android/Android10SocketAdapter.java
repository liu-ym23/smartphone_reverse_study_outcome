package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"NewApi"})
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = null;

    @SuppressSignatureCheck
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "isSupported", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final SocketAdapter buildIfSupported() {
            if (isSupported() == true) goto L7;
            return null;
        L7:
            return new Android10SocketAdapter();
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Android10SocketAdapter() {
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket r5, String r10, List<? extends Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
        SSLSockets.setUseSessionTickets(r5, true);     // Catch: IllegalArgumentException -> L7
        SSLParameters r12 = r5.getSSLParameters();     // Catch: IllegalArgumentException -> L7
        Object[] r13 = Platform.Companion.alpnProtocolNames(r11).toArray(new String[0]);     // Catch: IllegalArgumentException -> L7
        if (r13 == null) goto L10;
        r12.setApplicationProtocols((String[]) r13);     // Catch: IllegalArgumentException -> L7
        r5.setSSLParameters(r12);     // Catch: IllegalArgumentException -> L7
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: IllegalArgumentException -> L7
    L7:
        e = move-exception;
        throw new IOException("Android internal error", e);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        String r10 = r5.getApplicationProtocol();
        if (r10 != null) goto L6;
    L10:
        return null;
    L6:
        if (r10.hashCode() == 0) goto L9;
        return r10;
    L9:
        if (r10.equals("") == true) goto L10;
        return r10;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        return SSLSockets.isSupportedSocket(r5);
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
