package okhttp3.internal.http;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean r1) {
        this.forWebSocket = r1;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r13) {
        Interceptor.Chain r14 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r13, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r14, "chain");
        RealInterceptorChain r15 = (RealInterceptorChain) ZeusTransformUtils.preCheckCast(r14, RealInterceptorChain.class, "com.obric.memorydata.plugin");
        Exchange r0 = r15.exchange();
        Request r16 = r15.request();
        RequestBody r2 = r16.body();
        long r3 = System.currentTimeMillis();
        r0.writeRequestHeaders(r16);
        Long r6 = null;
        Response.Builder r5 = (Response.Builder) ZeusTransformUtils.preCheckCast(null, Response.Builder.class, "com.obric.memorydata.plugin");
        if (HttpMethod.permitsRequestBody(r16.method()) == false) goto L20;
        if (r2 == null) goto L20;
        if (StringsKt.equals("100-continue", r16.header("Expect"), true) == false) goto L8;
        r0.flushRequest();
        r0.responseHeadersStart();
        r5 = r0.readResponseHeaders(true);
        boolean r7 = true;
    L9:
        if (r5 == null) goto L11;
        r0.noRequestBody();
        RealConnection r10 = r0.connection();
        if (r10 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        if (r10.isMultiplexed() == true) goto L21;
        r0.noNewExchangesOnConnection();
    L21:
        if (r2 != null) goto L23;
    L24:
        r0.finishRequest();
    L25:
        if (r7 == true) goto L27;
        r0.responseHeadersStart();
    L27:
        if (r5 != null) goto L31;
        r5 = r0.readResponseHeaders(false);
        if (r5 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        Response.Builder r4 = r5.request(r16);
        RealConnection r8 = r0.connection();
        if (r8 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        Response r9 = r4.handshake(r8.handshake()).sentRequestAtMillis(r3).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int r11 = r9.code();
        if (r11 != 100) goto L43;
        Response.Builder r12 = r0.readResponseHeaders(false);
        if (r12 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        Response.Builder r17 = r12.request(r16);
        RealConnection r18 = r0.connection();
        if (r18 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        r9 = r17.handshake(r18.handshake()).sentRequestAtMillis(r3).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r11 = r9.code();
    L43:
        r0.responseHeadersEnd(r9);
        if (this.forWebSocket == true) goto L46;
    L48:
        Response.Builder r19 = r9.newBuilder();
        ResponseBody r110 = r0.openResponseBody(r9);
    L49:
        Response r111 = r19.body(r110).build();
        if (StringsKt.equals(IslandSession.REOPEN_VALUE_CLOSE, r111.request().header("Connection"), true) == false) goto L52;
    L53:
        r0.noNewExchangesOnConnection();
    L55:
        if (r11 != 204) goto L57;
    L58:
        ResponseBody r112 = r111.body();
        if (r112 == null) goto L61;
        long r20 = r112.contentLength();
    L63:
        if (r20 <= 0) goto L69;
        StringBuilder r1 = new StringBuilder().append("HTTP ").append(r11).append(" had non-zero Content-Length: ");
        ResponseBody r113 = r111.body();
        if (r113 == null) goto L68;
        r6 = Long.valueOf(r113.contentLength());
    L68:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException(r1.append(r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L69:
        return r111;
    L61:
        r20 = -1;
        goto L63
    L57:
        if (r11 != 205) goto L69;
    L52:
        if (StringsKt.equals(IslandSession.REOPEN_VALUE_CLOSE, Response.header$default(r111, "Connection", null, 2, null), true) == false) goto L55;
    L46:
        if (r11 != 101) goto L48;
        r19 = r9.newBuilder();
        r110 = Util.EMPTY_RESPONSE;
        goto L49
    L23:
        if (r2.isDuplex() == true) goto L25;
    L11:
        if (r2.isDuplex() == false) goto L13;
        r0.flushRequest();
        r2.writeTo(Okio.buffer(r0.createRequestBody(r16, true)));
        goto L21
    L13:
        BufferedSink r114 = Okio.buffer(r0.createRequestBody(r16, false));
        r2.writeTo(r114);
        r114.close();
        goto L21
    L8:
        r7 = false;
    L20:
        r0.noRequestBody();
        r7 = false;
        goto L21
    }
}
