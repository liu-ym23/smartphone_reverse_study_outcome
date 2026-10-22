package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.e0;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w0;
import okhttp3.x0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&¨\u0006("}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/g0;", "Lokhttp3/OkHttpClient;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Request;", "userRequest", "", "requestSendStarted", "recover", "(Ljava/io/IOException;Lokhttp3/internal/connection/RealCall;Lokhttp3/Request;Z)Z", "requestIsOneShot", "(Ljava/io/IOException;Lokhttp3/Request;)Z", "isRecoverable", "(Ljava/io/IOException;Z)Z", "Lokhttp3/s0;", "userResponse", "Lokhttp3/internal/connection/Exchange;", "exchange", "followUpRequest", "(Lokhttp3/s0;Lokhttp3/internal/connection/Exchange;)Lokhttp3/Request;", "", "method", "buildRedirectRequest", "(Lokhttp3/s0;Ljava/lang/String;)Lokhttp3/Request;", "", "defaultDelay", "retryAfter", "(Lokhttp3/s0;I)I", "Lokhttp3/f0;", "chain", "intercept", "(Lokhttp3/f0;)Lokhttp3/s0;", "Lokhttp3/OkHttpClient;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RetryAndFollowUpInterceptor implements g0 {
    public static final Companion Companion = null;
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RetryAndFollowUpInterceptor(OkHttpClient r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        this.client = r5;
    }

    private final Request buildRedirectRequest(s0 r10, String r11) {
        q0 r5 = null;
        if (this.client.f20590h == true) goto L5;
        return null;
    L5:
        String r12 = r10.d("Location", null);
        if (r12 == null) goto L38;
        Request r13 = r10.f20746b;
        e0 r14 = r13.url().j(r12);
        if (r14 == null) goto L38;
        String r15 = r13.url().f20640b;
        if (Intrinsics.areEqual(r14.f20640b, r15) == false) goto L12;
    L14:
        n0 r16 = r13.newBuilder();
        if (HttpMethod.permitsRequestBody(r11) == false) goto L34;
        HttpMethod r17 = HttpMethod.INSTANCE;
        boolean r18 = r17.redirectsWithBody(r11);
        int r19 = r10.e;
        if (r18 == true) goto L22;
        if (r19 == 308) goto L22;
        if (r19 == 307) goto L22;
        boolean r20 = false;
    L24:
        if (r17.redirectsToGet(r11) == false) goto L28;
        if (r19 == 308) goto L28;
        if (r19 == 307) goto L28;
        r16.d("GET", null);
    L31:
        if (r20 == true) goto L34;
        r16.e("Transfer-Encoding");
        r16.e("Content-Length");
        r16.e("Content-Type");
    L28:
        if (r20 == false) goto L30;
        r5 = r13.body();
    L30:
        r16.d(r11, r5);
    L22:
        r20 = true;
    L34:
        if (Util.canReuseConnectionFor(r13.url(), r14) == true) goto L36;
        r16.e("Authorization");
    L36:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r14, "url");
        r16.f20713a = r14;
        return r16.b();
    L12:
        if (this.client.f20591i == true) goto L14;
        return null;
    L38:
        return null;
    }

    private final Request followUpRequest(s0 r10, Exchange r11) throws IOException {
        if (r11 == null) goto L7;
        RealConnection r5 = r11.getConnection$okhttp();
        if (r5 == null) goto L7;
        x0 r12 = r5.route();
    L8:
        int r13 = r10.e;
        Request r14 = r10.f20746b;
        String r15 = r14.method();
        if (r13 == 307) goto L69;
        if (r13 == 308) goto L69;
        if (r13 != 401) goto L15;
        this.client.g.getClass();
        Intrinsics.checkNotNullParameter(r10, "response");
        return null;
    L15:
        if (r13 == 421) goto L54;
        s0 r16 = r10.f20751k;
        if (r13 != 503) goto L19;
        if (r16 == null) goto L51;
        if (r16.e != 503) goto L51;
        return null;
    L51:
        if (retryAfter(r10, Integer.MAX_VALUE) != 0) goto L53;
        return r14;
    L53:
        return null;
    L19:
        if (r13 != 407) goto L21;
        Intrinsics.checkNotNull(r12);
        if (r12.f20765b.type() != Proxy.Type.HTTP) goto L45;
        this.client.f20596n.getClass();
        Intrinsics.checkNotNullParameter(r10, "response");
        return null;
    L45:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L21:
        if (r13 == 408) goto L25;
        switch(r13) {
            case 300: goto L69;
            case 301: goto L69;
            case 302: goto L69;
            case 303: goto L69;
            default: goto L23;
        };
    L23:
        return null;
    L25:
        if (this.client.f == true) goto L27;
        return null;
    L27:
        q0 r17 = r14.body();
        if (r17 != null) goto L30;
    L32:
        if (r16 == null) goto L37;
        if (r16.e != 408) goto L37;
        return null;
    L37:
        if (retryAfter(r10, 0) <= 0) goto L39;
        return null;
    L39:
        return r14;
    L30:
        if (r17.isOneShot() == false) goto L32;
        return null;
    L54:
        q0 r18 = r14.body();
        if (r18 != null) goto L57;
    L59:
        if (r11 != null) goto L61;
    L65:
        return null;
    L61:
        if (r11.isCoalescedConnection$okhttp() == false) goto L65;
        r11.getConnection$okhttp().noCoalescedConnections$okhttp();
        return r14;
    L57:
        if (r18.isOneShot() == false) goto L59;
        return null;
    L69:
        return buildRedirectRequest(r10, r15);
    L7:
        r12 = null;
        goto L8
    }

    private final boolean isRecoverable(IOException r5, boolean r10) {
        if ((r5 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof InterruptedIOException) == false) goto L13;
        if ((r5 instanceof SocketTimeoutException) == false) goto L21;
        if (r10 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r5 instanceof SSLHandshakeException) == false) goto L18;
        if ((r5.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r5 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private final boolean recover(IOException r5, RealCall r10, Request r11, boolean r12) {
        if (this.client.f == true) goto L5;
        return false;
    L5:
        if (r12 == false) goto L10;
        if (requestIsOneShot(r5, r11) == false) goto L10;
        return false;
    L10:
        if (isRecoverable(r5, r12) == true) goto L13;
        return false;
    L13:
        if (r10.retryAfterFailure() == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean requestIsOneShot(IOException r5, Request r10) {
        q0 r11 = r10.body();
        if (r11 == null) goto L7;
        if (r11.isOneShot() == false) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof FileNotFoundException) == true) goto L8;
        return false;
    }

    private final int retryAfter(s0 r5, int r10) {
        String r11 = r5.d("Retry-After", null);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (new Regex("\\d+").matches(r11) == true) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return Integer.valueOf(r11).intValue();
    }

    @Override // okhttp3.g0
    public s0 intercept(f0 r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "chain");
        RealInterceptorChain r12 = (RealInterceptorChain) r11;
        Request r5 = r12.getRequest$okhttp();
        RealCall r10 = r12.getCall$okhttp();
        List r13 = CollectionsKt.emptyList();
        int r14 = 0;
        s0 r15 = null;
    L3:
        boolean r16 = true;
    L4:
        r10.enterNetworkInterceptorExchange(r5, r16);
    L13:
        th = move-exception;
        r10.exitNetworkInterceptorExchange$okhttp(true);
        throw th;
    L6:
        if (r10.isCanceled() == true) goto L53;
        s0 r17 = r12.proceed(r5);     // Catch: Throwable -> L13 IOException -> L39 RouteException -> L46
    L8:
        if (r15 == null) goto L12;
        r0 r18 = r17.f();     // Catch: Throwable -> L13
        r0 r19 = r15.f();     // Catch: Throwable -> L13
        r19.g = null;     // Catch: Throwable -> L13
        s0 r20 = r19.a();     // Catch: Throwable -> L13
        if (r20.f20748h != null) goto L16;
        r18.f20740j = r20;     // Catch: Throwable -> L13
        r17 = r18.a();     // Catch: Throwable -> L13
        goto L12
    L16:
        throw new IllegalArgumentException("priorResponse.body != null");     // Catch: Throwable -> L13
    L12:
        r15 = r17;
        Exchange r21 = r10.getInterceptorScopedExchange$okhttp();     // Catch: Throwable -> L13
        Request r22 = followUpRequest(r15, r21);     // Catch: Throwable -> L13
        if (r22 == null) goto L19;
        q0 r23 = r22.body();     // Catch: Throwable -> L13
        if (r23 != null) goto L28;
    L31:
        w0 r24 = r15.f20748h;     // Catch: Throwable -> L13
        if (r24 == null) goto L34;
        Util.closeQuietly(r24);     // Catch: Throwable -> L13
    L34:
        r14 = r14 + 1;
        if (r14 > 20) goto L38;
        r10.exitNetworkInterceptorExchange$okhttp(true);
        r5 = r22;
        goto L3
    L38:
        throw new ProtocolException("Too many follow-up requests: " + r14);     // Catch: Throwable -> L13
    L28:
        if (r23.isOneShot() == false) goto L31;
        r10.exitNetworkInterceptorExchange$okhttp(false);
        return r15;
    L19:
        if (r21 != null) goto L21;
    L23:
        r10.exitNetworkInterceptorExchange$okhttp(false);
        return r15;
    L21:
        if (r21.isDuplex$okhttp() == false) goto L23;
        r10.timeoutEarlyExit();     // Catch: Throwable -> L13
    L39:
        e = move-exception;
        if (recover(e, r10, r5, !(e instanceof ConnectionShutdownException)) == false) goto L45;
        r13 = CollectionsKt.plus(r13, e);     // Catch: Throwable -> L13
    L43:
        r10.exitNetworkInterceptorExchange$okhttp(true);
        r16 = false;
        goto L4
    L45:
        throw Util.withSuppressed(e, r13);     // Catch: Throwable -> L13
    L46:
        e = move-exception;
        if (recover(e.getLastConnectException(), r10, r5, false) == false) goto L51;
        r13 = CollectionsKt.plus(r13, e.getFirstConnectException());     // Catch: Throwable -> L13
        goto L43
    L51:
        throw Util.withSuppressed(e.getFirstConnectException(), r13);     // Catch: Throwable -> L13
    L53:
        throw new IOException("Canceled");     // Catch: Throwable -> L13
    }
}
