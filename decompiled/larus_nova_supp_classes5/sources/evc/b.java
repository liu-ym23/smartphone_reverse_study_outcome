package evc;

import cvc.c;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.d;
import okhttp3.internal.http.RealInterceptorChain;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements Interceptor {
    public final boolean a;

    public b(boolean r1) {
        this.a = r1;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r13) throws IOException {
        RealInterceptorChain r14 = (RealInterceptorChain) r13;
        c r0 = r14.httpStream();
        StreamAllocation r1 = r14.streamAllocation();
        d r2 = r14.connection();
        Request r3 = r14.request();
        long r4 = System.currentTimeMillis();
        r14.eventListener().requestHeadersStart(r14.call());
        r0.b(r3);
        r14.eventListener().requestHeadersEnd(r14.call(), r3);
        Response.Builder r8 = null;
        if (f.b(r3.method()) == true) goto L5;
    L17:
        r0.d();
        if (r8 != null) goto L20;
        r14.eventListener().responseHeadersStart(r14.call());
        r8 = r0.f(false);
    L20:
        Response r5 = r8.request(r3).handshake(r1.connection().f).sentRequestAtMillis(r4).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int r6 = r5.code();
        if (r6 != 100) goto L23;
        r5 = r0.f(false).request(r3).handshake(r1.connection().f).sentRequestAtMillis(r4).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r6 = r5.code();
    L23:
        r14.eventListener().responseHeadersEnd(r14.call(), r5);
        if (this.a == true) goto L26;
    L28:
        Response r15 = r5.newBuilder().body(r0.e(r5)).build();
    L30:
        if ("close".equalsIgnoreCase(r15.request().header("Connection")) == false) goto L32;
    L33:
        r1.noNewStreams();
    L35:
        if (r6 == 204) goto L39;
        if (r6 == 205) goto L39;
    L40:
        return r15;
    L39:
        if (r15.body().contentLength() <= 0) goto L40;
        throw new ProtocolException("HTTP " + r6 + " had non-zero Content-Length: " + r15.body().contentLength());
    L32:
        if ("close".equalsIgnoreCase(r15.header("Connection")) == false) goto L35;
    L26:
        if (r6 != 101) goto L28;
        r15 = r5.newBuilder().body(c.c).build();
        goto L30
    L5:
        if (r3.body() == null) goto L17;
        boolean r9 = true;
        if ("100-continue".equalsIgnoreCase(r3.header("Expect")) == false) goto L9;
        r0.a();
        r14.eventListener().responseHeadersStart(r14.call());
        r8 = r0.f(true);
    L9:
        if (r8 != null) goto L12;
        r14.eventListener().requestBodyStart(r14.call());
        a r7 = new a(r0.c(r3, r3.body().contentLength()));
        BufferedSink r10 = Okio.buffer(r7);
        r3.body().writeTo(r10);
        r10.close();
        r14.eventListener().requestBodyEnd(r14.call(), r7.b);
        goto L17
    L12:
        if (r2.h != null) goto L15;
        r9 = false;
    L15:
        if (r9 == true) goto L17;
        r1.noNewStreams();
        goto L17
    }
}
