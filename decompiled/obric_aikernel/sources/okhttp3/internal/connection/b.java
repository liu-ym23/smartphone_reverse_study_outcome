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
import kotlin.jvm.internal.Intrinsics;
import okhttp3.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k> f11767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11770d;

    public b(List<k> r10) {
        Intrinsics.checkNotNullParameter(r10, "connectionSpecs");
        this.f11767a = r10;
    }

    private final boolean c(SSLSocket r10) {
        int r11 = this.f11768b;
        int r12 = this.f11767a.size();
    L3:
        if (r11 >= r12) goto L9;
        if (this.f11767a.get(r11).e(r10) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final k a(SSLSocket r10) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        int r11 = this.f11768b;
        int r12 = this.f11767a.size();
    L3:
        if (r11 >= r12) goto L7;
        k r13 = this.f11767a.get(r11);
        r11 = r11 + 1;
        if (r13.e(r10) == false) goto L3;
        this.f11768b = r11;
    L8:
        if (r13 == null) goto L11;
        this.f11769c = c(r10);
        r13.c(r10, this.f11770d);
        return r13;
    L11:
        StringBuilder r14 = new StringBuilder();
        r14.append("Unable to find acceptable protocols. isFallback=");
        r14.append(this.f11770d);
        r14.append(", modes=");
        r14.append(this.f11767a);
        r14.append(", supported protocols=");
        String[] r15 = r10.getEnabledProtocols();
        Intrinsics.checkNotNull(r15);
        String r16 = Arrays.toString(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "toString(this)");
        r14.append(r16);
        throw new UnknownServiceException(r14.toString());
    L7:
        r13 = null;
        goto L8
    }

    public final boolean b(IOException r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        this.f11770d = true;
        if (this.f11769c == true) goto L6;
    L21:
        return false;
    L6:
        if ((r10 instanceof ProtocolException) == true) goto L21;
        if ((r10 instanceof InterruptedIOException) == true) goto L21;
        if ((r10 instanceof SSLHandshakeException) == false) goto L17;
        if ((r10.getCause() instanceof CertificateException) == true) goto L21;
    L17:
        if ((r10 instanceof SSLPeerUnverifiedException) == true) goto L21;
        if ((r10 instanceof SSLException) == false) goto L21;
        return true;
    }
}
