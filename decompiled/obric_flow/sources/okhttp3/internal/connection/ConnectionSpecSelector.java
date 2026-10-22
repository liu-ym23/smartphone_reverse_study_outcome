package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "", "Lokhttp3/q;", "connectionSpecs", "<init>", "(Ljava/util/List;)V", "Ljavax/net/ssl/SSLSocket;", "socket", "", "isFallbackPossible", "(Ljavax/net/ssl/SSLSocket;)Z", "sslSocket", "configureSecureSocket", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/q;", "Ljava/io/IOException;", "e", "connectionFailed", "(Ljava/io/IOException;)Z", "", "nextModeIndex", "I", "Z", "isFallback", "Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionSpecSelector {
    private final List<q> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<q> r5) {
        Intrinsics.checkNotNullParameter(r5, "connectionSpecs");
        this.connectionSpecs = r5;
    }

    private final boolean isFallbackPossible(SSLSocket r5) {
        int r10 = this.nextModeIndex;
        int r11 = this.connectionSpecs.size();
    L3:
        if (r10 >= r11) goto L9;
        if (this.connectionSpecs.get(r10).c(r5) == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final q configureSecureSocket(SSLSocket r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        int r10 = this.nextModeIndex;
        int r11 = this.connectionSpecs.size();
    L3:
        if (r10 >= r11) goto L8;
        q r12 = this.connectionSpecs.get(r10);
        if (r12.c(r5) == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        this.nextModeIndex = r10 + 1;
    L9:
        if (r12 == null) goto L12;
        this.isFallbackPossible = isFallbackPossible(r5);
        r12.a(r5, this.isFallback);
        return r12;
    L12:
        StringBuilder r13 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        r13.append(this.isFallback);
        r13.append(", modes=");
        r13.append(this.connectionSpecs);
        r13.append(", supported protocols=");
        String[] r14 = r5.getEnabledProtocols();
        Intrinsics.checkNotNull(r14);
        r13.append(Arrays.toString(r14));
        throw new UnknownServiceException(r13.toString());
    L8:
        r12 = null;
        goto L9
    }

    public final boolean connectionFailed(IOException r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        this.isFallback = true;
        if (this.isFallbackPossible == true) goto L6;
    L21:
        return false;
    L6:
        if ((r5 instanceof ProtocolException) == true) goto L21;
        if ((r5 instanceof InterruptedIOException) == true) goto L21;
        if ((r5 instanceof SSLHandshakeException) == false) goto L17;
        if ((r5.getCause() instanceof CertificateException) == true) goto L21;
    L17:
        if ((r5 instanceof SSLPeerUnverifiedException) == true) goto L21;
        if ((r5 instanceof SSLException) == false) goto L21;
        return true;
    }
}
