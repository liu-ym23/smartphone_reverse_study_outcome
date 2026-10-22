package okhttp3.internal.http;

import f4.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.b0;
import okhttp3.e0;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.h0;
import okhttp3.internal.Util;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.r;
import okhttp3.r0;
import okhttp3.s;
import okhttp3.s0;
import okhttp3.w0;
import sj.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/g0;", "Lokhttp3/s;", "cookieJar", "<init>", "(Lokhttp3/s;)V", "", "Lokhttp3/r;", "cookies", "", "cookieHeader", "(Ljava/util/List;)Ljava/lang/String;", "Lokhttp3/f0;", "chain", "Lokhttp3/s0;", "intercept", "(Lokhttp3/f0;)Lokhttp3/s0;", "Lokhttp3/s;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BridgeInterceptor implements g0 {
    private final s cookieJar;

    public BridgeInterceptor(s r5) {
        Intrinsics.checkNotNullParameter(r5, "cookieJar");
        this.cookieJar = r5;
    }

    private final String cookieHeader(List<r> r5) {
        StringBuilder r10 = new StringBuilder();
        Iterator<T> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r r15 = (r) r13;
        if (r12 <= 0) goto L11;
        r10.append("; ");
    L11:
        r10.append(r15.f20730a);
        r10.append('=');
        r10.append(r15.f20731b);
        r12 = r14;
        goto L4
    L13:
        return r10.toString();
    }

    @Override // okhttp3.g0
    public s0 intercept(f0 r13) throws IOException {
        Intrinsics.checkNotNullParameter(r13, "chain");
        Request r5 = r13.request();
        n0 r10 = r5.newBuilder();
        q0 r11 = r5.body();
        if (r11 == null) goto L11;
        h0 r12 = r11.contentType();
        if (r12 == null) goto L7;
        r10.c("Content-Type", r12.f20657a);
    L7:
        long r14 = r11.contentLength();
        if (r14 == (-1)) goto L10;
        r10.c("Content-Length", String.valueOf(r14));
        r10.e("Transfer-Encoding");
        goto L11
    L10:
        r10.c("Transfer-Encoding", "chunked");
        r10.e("Content-Length");
    L11:
        boolean r15 = false;
        if (r5.header("Host") != null) goto L15;
        r10.c("Host", Util.toHostHeader$default(r5.url(), false, 1, null));
    L15:
        if (r5.header("Connection") != null) goto L18;
        r10.c("Connection", "Keep-Alive");
    L18:
        if (r5.header("Accept-Encoding") == null) goto L20;
    L22:
        s r16 = this.cookieJar;
        e0 r17 = r5.url();
        ((e) r16).getClass();
        Intrinsics.checkNotNullParameter(r17, "url");
        List<r> r18 = CollectionsKt.emptyList();
        if (r18.isEmpty() == true) goto L26;
        r10.c("Cookie", cookieHeader(r18));
    L26:
        if (r5.header("User-Agent") != null) goto L28;
        r10.c("User-Agent", Util.userAgent);
    L28:
        s0 r19 = r13.proceed(r10.b());
        HttpHeaders.receiveHeaders(this.cookieJar, r5.url(), r19.g);
        r0 r110 = r19.f();
        Intrinsics.checkNotNullParameter(r5, "request");
        r110.f20735a = r5;
        if (r15 == false) goto L38;
        if (StringsKt.l("gzip", r19.d("Content-Encoding", null)) == false) goto L38;
        if (HttpHeaders.promisesBody(r19) == false) goto L38;
        w0 r20 = r19.f20748h;
        if (r20 == null) goto L38;
        nu.r r21 = new nu.r(r20.source());
        b0 r22 = r19.g.d();
        r22.f("Content-Encoding");
        r22.f("Content-Length");
        r110.c(r22.d());
        r110.g = new RealResponseBody(r19.d("Content-Type", null), -1, b.e(r21));
    L38:
        return r110.a();
    L20:
        if (r5.header("Range") != null) goto L22;
        r10.c("Accept-Encoding", "gzip");
        r15 = true;
        goto L22
    }
}
