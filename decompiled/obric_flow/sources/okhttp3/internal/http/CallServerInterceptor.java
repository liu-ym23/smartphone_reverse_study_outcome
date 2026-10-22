package okhttp3.internal.http;

import ai.j0;
import f4.b;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.w;
import okhttp3.Request;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.q0;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/g0;", "", "forWebSocket", "<init>", "(Z)V", "Lokhttp3/f0;", "chain", "Lokhttp3/s0;", "intercept", "(Lokhttp3/f0;)Lokhttp3/s0;", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CallServerInterceptor implements g0 {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean r5) {
        this.forWebSocket = r5;
    }

    @Override // okhttp3.g0
    public s0 intercept(f0 r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "chain");
        RealInterceptorChain r12 = (RealInterceptorChain) r11;
        Exchange r5 = r12.getExchange$okhttp();
        Intrinsics.checkNotNull(r5);
        Request r13 = r12.getRequest$okhttp();
        q0 r10 = r13.body();
        long r14 = System.currentTimeMillis();
        r5.writeRequestHeaders(r13);
        Long r15 = null;
        boolean r16 = true;
        if (HttpMethod.permitsRequestBody(r13.method()) == false) goto L18;
        if (r10 == null) goto L18;
        if (StringsKt.l("100-continue", r13.header("Expect")) == false) goto L8;
        r5.flushRequest();
        r0 r17 = r5.readResponseHeaders(true);
        r5.responseHeadersStart();
        boolean r18 = false;
    L9:
        if (r17 == null) goto L11;
        r5.noRequestBody();
        if (r5.getConnection$okhttp().isMultiplexed$okhttp() == true) goto L17;
        r5.noNewExchangesOnConnection();
    L17:
        r16 = r18;
    L19:
        if (r10 != null) goto L21;
    L22:
        r5.finishRequest();
    L23:
        if (r17 != null) goto L27;
        r17 = r5.readResponseHeaders(false);
        Intrinsics.checkNotNull(r17);
        if (r16 == false) goto L27;
        r5.responseHeadersStart();
        r16 = false;
    L27:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r13, "request");
        r17.f20735a = r13;
        r17.e = r5.getConnection$okhttp().handshake();
        r17.f20741k = r14;
        r17.f20742l = System.currentTimeMillis();
        s0 r19 = r17.a();
        int r20 = r19.e;
        if (r20 != 100) goto L33;
        r0 r21 = r5.readResponseHeaders(false);
        Intrinsics.checkNotNull(r21);
        if (r16 == false) goto L32;
        r5.responseHeadersStart();
    L32:
        r21.getClass();
        Intrinsics.checkNotNullParameter(r13, "request");
        r21.f20735a = r13;
        r21.e = r5.getConnection$okhttp().handshake();
        r21.f20741k = r14;
        r21.f20742l = System.currentTimeMillis();
        r19 = r21.a();
        r20 = r19.e;
    L33:
        r5.responseHeadersEnd(r19);
        if (this.forWebSocket == true) goto L36;
    L38:
        r0 r110 = r19.f();
        r110.g = r5.openResponseBody(r19);
        s0 r111 = r110.a();
    L40:
        if (StringsKt.l("close", r111.f20746b.header("Connection")) == false) goto L42;
    L43:
        r5.noNewExchangesOnConnection();
    L45:
        if (r20 != 204) goto L47;
    L48:
        w0 r112 = r111.f20748h;
        if (r112 == null) goto L51;
        long r22 = r112.contentLength();
    L53:
        if (r22 <= 0) goto L59;
        StringBuilder r23 = j0.s(r20, "HTTP ", " had non-zero Content-Length: ");
        if (r112 == null) goto L57;
        r15 = Long.valueOf(r112.contentLength());
    L57:
        r23.append(r15);
        throw new ProtocolException(r23.toString());
    L59:
        return r111;
    L51:
        r22 = -1;
        goto L53
    L47:
        if (r20 != 205) goto L59;
    L42:
        if (StringsKt.l("close", r111.d("Connection", null)) == false) goto L45;
    L36:
        if (r20 != 101) goto L38;
        r0 r113 = r19.f();
        r113.g = Util.EMPTY_RESPONSE;
        r111 = r113.a();
        goto L40
    L21:
        if (r10.isDuplex() == true) goto L23;
    L11:
        if (r10.isDuplex() == false) goto L13;
        r5.flushRequest();
        r10.writeTo(b.d(r5.createRequestBody(r13, true)));
        goto L17
    L13:
        w r24 = b.d(r5.createRequestBody(r13, false));
        r10.writeTo(r24);
        r24.close();
        goto L17
    L8:
        r17 = null;
        r18 = true;
    L18:
        r5.noRequestBody();
        r17 = null;
        goto L19
    }
}
