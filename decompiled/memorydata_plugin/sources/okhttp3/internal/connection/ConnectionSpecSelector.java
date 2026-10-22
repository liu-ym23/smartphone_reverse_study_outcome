package okhttp3.internal.connection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.ConnectionSpec;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> r3) {
        List<ConnectionSpec> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "connectionSpecs");
        this.connectionSpecs = r4;
    }

    private final boolean isFallbackPossible(SSLSocket r6) {
        int r0 = this.nextModeIndex;
        int r1 = this.connectionSpecs.size();
    L3:
        if (r0 >= r1) goto L9;
        if (((ConnectionSpec) ZeusTransformUtils.preCheckCast(this.connectionSpecs.get(r0), ConnectionSpec.class, "com.obric.memorydata.plugin")).isCompatible(r6) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket r7) {
        Intrinsics.checkParameterIsNotNull(r7, "sslSocket");
        ConnectionSpec r0 = (ConnectionSpec) ZeusTransformUtils.preCheckCast(null, ConnectionSpec.class, "com.obric.memorydata.plugin");
        int r1 = this.nextModeIndex;
        int r3 = this.connectionSpecs.size();
    L3:
        if (r1 >= r3) goto L7;
        ConnectionSpec r4 = (ConnectionSpec) ZeusTransformUtils.preCheckCast(this.connectionSpecs.get(r1), ConnectionSpec.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        if (r4.isCompatible(r7) == false) goto L3;
        this.nextModeIndex = r1;
        r0 = r4;
    L7:
        if (r0 != null) goto L13;
        StringBuilder r6 = new StringBuilder().append("Unable to find acceptable protocols. isFallback=").append(this.isFallback).append(',').append(" modes=").append(this.connectionSpecs).append(',').append(" supported protocols=");
        String[] r8 = r7.getEnabledProtocols();
        if (r8 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        String r9 = Arrays.toString(r8);
        Intrinsics.checkExpressionValueIsNotNull(r9, "java.util.Arrays.toString(this)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new UnknownServiceException(r6.append(r9).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        this.isFallbackPossible = isFallbackPossible(r7);
        r0.apply$okhttp(r7, this.isFallback);
        return r0;
    }

    public final boolean connectionFailed(IOException r4) {
        Intrinsics.checkParameterIsNotNull(r4, "e");
        this.isFallback = true;
        if (this.isFallbackPossible == true) goto L6;
    L21:
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ProtocolException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, InterruptedIOException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, SSLHandshakeException.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r4.getCause(), CertificateException.class) == true) goto L21;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, SSLPeerUnverifiedException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, SSLException.class) == false) goto L21;
        return true;
    }
}
