package okhttp3.internal.platform.android;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/platform/android/ConscryptSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "buildIfSupported", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final ConscryptSocketAdapter INSTANCE = null;

    static {
        INSTANCE = new ConscryptSocketAdapter();
    }

    private ConscryptSocketAdapter() {
    }

    public final SocketAdapter buildIfSupported() {
        if (ConscryptPlatform.Companion.isSupported() == true) goto L7;
        return null;
    L7:
        return (SocketAdapter) ZeusTransformUtils.preCheckCast(INSTANCE, SocketAdapter.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket r3, String r4, List<? extends Protocol> r5) {
        List<? extends Protocol> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r6, "protocols");
        if (matchesSocket(r3) == false) goto L11;
        if (r4 == null) goto L6;
        Conscrypt.setUseSessionTickets(r3, true);
        Conscrypt.setHostname(r3, r4);
    L6:
        Object[] r2 = ((Collection) ZeusTransformUtils.preCheckCast(Platform.Companion.alpnProtocolNames(r6), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        if (r2 == null) goto L10;
        Conscrypt.setApplicationProtocols(r3, (String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin"));
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        if (matchesSocket(r2) == true) goto L7;
        return null;
    L7:
        return Conscrypt.getApplicationProtocol(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return ConscryptPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket r1) {
        Intrinsics.checkParameterIsNotNull(r1, "sslSocket");
        return Conscrypt.isConscrypt(r1);
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
