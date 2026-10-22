package okhttp3.internal.http;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "route", "Lokhttp3/Route;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "transmitter", "Lokhttp3/internal/connection/Transmitter;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RetryAndFollowUpInterceptor(OkHttpClient r2) {
        Intrinsics.checkParameterIsNotNull(r2, "client");
        this.client = r2;
    }

    private final Request buildRedirectRequest(Response r5, String r6) {
        RequestBody r1 = null;
        if (this.client.followRedirects() == true) goto L5;
        return null;
    L5:
        String r0 = Response.header$default(r5, "Location", null, 2, null);
        if (r0 == null) goto L29;
        HttpUrl r2 = r5.request().url().resolve(r0);
        if (r2 == null) goto L29;
        if (Intrinsics.areEqual(r2.scheme(), r5.request().url().scheme()) == false) goto L12;
    L14:
        Request.Builder r4 = r5.request().newBuilder();
        if (HttpMethod.permitsRequestBody(r6) == false) goto L25;
        boolean r3 = HttpMethod.INSTANCE.redirectsWithBody(r6);
        if (HttpMethod.INSTANCE.redirectsToGet(r6) == false) goto L20;
        r6 = HttpMethodContrants.GET;
    L19:
        r4.method(r6, r1);
        if (r3 == true) goto L25;
        r4.removeHeader("Transfer-Encoding");
        r4.removeHeader("Content-Length");
        r4.removeHeader(NetConst.KEY_CONTENT_TYPE);
        goto L25
    L20:
        if (r3 == false) goto L19;
        r1 = r5.request().body();
    L25:
        if (Util.canReuseConnectionFor(r5.request().url(), r2) == true) goto L28;
        r4.removeHeader("Authorization");
    L28:
        return r4.url(r2).build();
    L12:
        if (this.client.followSslRedirects() == true) goto L14;
        return null;
    L29:
        return null;
    }

    private final Request followUpRequest(Response r5, Route r6) {
        int r0 = r5.code();
        String r1 = r5.request().method();
        if (r0 == 307) goto L57;
        if (r0 == 308) goto L57;
        if (r0 != 401) goto L9;
        Authenticator r4 = this.client.authenticator();
    L42:
        return r4.authenticate(r6, r5);
    L9:
        if (r0 != 503) goto L11;
        Response r7 = r5.priorResponse();
        if (r7 == null) goto L51;
        if (r7.code() != 503) goto L51;
        return null;
    L51:
        if (retryAfter(r5, Integer.MAX_VALUE) == 0) goto L53;
        return null;
    L53:
        return r5.request();
    L11:
        if (r0 != 407) goto L13;
        if (r6 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        if (r6.proxy().type() != Proxy.Type.HTTP) goto L44;
        r4 = this.client.proxyAuthenticator();
        goto L42
    L44:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy"), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        if (r0 == 408) goto L19;
        switch(r0) {
            case 300: goto L17;
            case 301: goto L17;
            case 302: goto L17;
            case 303: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L17:
        return buildRedirectRequest(r5, r1);
    L19:
        if (this.client.retryOnConnectionFailure() == true) goto L21;
        return null;
    L21:
        RequestBody r2 = r5.request().body();
        if (r2 != null) goto L24;
    L26:
        Response r3 = r5.priorResponse();
        if (r3 == null) goto L32;
        if (r3.code() != 408) goto L32;
        return null;
    L32:
        if (retryAfter(r5, 0) <= 0) goto L35;
        return null;
    L35:
        return r5.request();
    L24:
        if (r2.isOneShot() == false) goto L26;
        return null;
    L57:
        if ((!Intrinsics.areEqual(r1, HttpMethodContrants.GET)) == false) goto L62;
        if ((!Intrinsics.areEqual(r1, HttpMethodContrants.HEAD)) == false) goto L62;
        return null;
    L62:
        return buildRedirectRequest(r5, r1);
    }

    private final boolean isRecoverable(IOException r3, boolean r4) {
        if (ZeusTransformUtils.instanceOf(r3, ProtocolException.class) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, InterruptedIOException.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, SocketTimeoutException.class) == false) goto L21;
        if (r4 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, SSLHandshakeException.class) == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r3.getCause(), CertificateException.class) == false) goto L18;
        return false;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, SSLPeerUnverifiedException.class) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private final boolean recover(IOException r3, Transmitter r4, boolean r5, Request r6) {
        if (this.client.retryOnConnectionFailure() == true) goto L5;
        return false;
    L5:
        if (r5 == false) goto L10;
        if (requestIsOneShot(r3, r6) == false) goto L10;
        return false;
    L10:
        if (isRecoverable(r3, r5) == true) goto L13;
        return false;
    L13:
        if (r4.canRetry() == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean requestIsOneShot(IOException r1, Request r2) {
        RequestBody r0 = r2.body();
        if (r0 == null) goto L7;
        if (r0.isOneShot() == false) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, FileNotFoundException.class) == true) goto L8;
        return false;
    }

    private final int retryAfter(Response r3, int r4) {
        String r2 = Response.header$default(r3, "Retry-After", null, 2, null);
        if (r2 == null) goto L10;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (new Regex("\\d+").matches(r5) == false) goto L8;
        Integer r6 = Integer.valueOf(r2);
        Intrinsics.checkExpressionValueIsNotNull(r6, "Integer.valueOf(header)");
        return r6.intValue();
    L8:
        return Integer.MAX_VALUE;
    L10:
        return r4;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r11) {
        Interceptor.Chain r12 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r11, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r12, "chain");
        Request r0 = r12.request();
        RealInterceptorChain r13 = (RealInterceptorChain) ZeusTransformUtils.preCheckCast(r12, RealInterceptorChain.class, "com.obric.memorydata.plugin");
        Transmitter r2 = r13.transmitter();
        Response r3 = (Response) ZeusTransformUtils.preCheckCast(null, Response.class, "com.obric.memorydata.plugin");
        int r6 = 0;
    L3:
        r2.prepareToConnect(r0);
        if (r2.isCanceled() == true) goto L59;
        Response r1 = r13.proceed(r0, r2, null);     // Catch: Throwable -> L38 IOException -> L40 RouteException -> L50
    L6:
        if (r3 == null) goto L8;
        r1 = r1.newBuilder().priorResponse(r3.newBuilder().body(null).build()).build();
    L8:
        r3 = r1;
        Exchange r4 = r3.exchange();
        if (r4 == null) goto L13;
        RealConnection r7 = r4.connection();
        if (r7 == null) goto L13;
        Route r8 = r7.route();
    L14:
        Request r9 = followUpRequest(r3, r8);
        if (r9 == null) goto L16;
        RequestBody r10 = r9.body();
        if (r10 != null) goto L24;
    L26:
        ResponseBody r14 = r3.body();
        if (r14 == null) goto L30;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r14, Closeable.class, "com.obric.memorydata.plugin"));
    L30:
        if (r2.hasExchange() == false) goto L33;
        if (r4 == null) goto L33;
        r4.detachWithViolence();
    L33:
        r6 = r6 + 1;
        if (r6 > 20) goto L37;
        r0 = r9;
        goto L3
    L37:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Too many follow-up requests: " + r6), Throwable.class, "com.obric.memorydata.plugin"));
    L24:
        if (r10.isOneShot() == false) goto L26;
        return r3;
    L16:
        if (r4 != null) goto L18;
    L20:
        return r3;
    L18:
        if (r4.isDuplex() == false) goto L20;
        r2.timeoutEarlyExit();
    L13:
        r8 = null;
    L38:
        th = move-exception;
        r2.exchangeDoneDueToException();
        throw th;
    L40:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, ConnectionShutdownException.class) == true) goto L44;
        boolean r15 = true;
    L46:
        if (recover(e, r2, r15, r0) == false) goto L49;
    L53:
        r2.exchangeDoneDueToException();
        goto L3
    L49:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
    L44:
        r15 = false;
    L50:
        e = move-exception;
        if (recover(e.getLastConnectException(), r2, false, r0) == true) goto L53;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e.getFirstConnectException(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
    L59:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Canceled"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
