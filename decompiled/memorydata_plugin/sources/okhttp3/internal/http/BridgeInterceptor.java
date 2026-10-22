package okhttp3.internal.http;

import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar r3) {
        CookieJar r4 = (CookieJar) ZeusTransformUtils.wrapperContextForParams(r3, CookieJar.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "cookieJar");
        this.cookieJar = r4;
    }

    private final String cookieHeader(List<Cookie> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L12;
        Object r2 = r8.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Cookie r4 = (Cookie) ZeusTransformUtils.preCheckCast(r2, Cookie.class, "com.obric.memorydata.plugin");
        if (r1 <= 0) goto L11;
        r7.append("; ");
    L11:
        r7.append(r4.name()).append('=').append(r4.value());
        r1 = r3;
        goto L4
    L12:
        String r9 = r7.toString();
        Intrinsics.checkExpressionValueIsNotNull(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r14) {
        Interceptor.Chain r15 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r14, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r15, "chain");
        Request r0 = r15.request();
        Request.Builder r2 = r0.newBuilder();
        RequestBody r3 = r0.body();
        if (r3 == null) goto L11;
        MediaType r8 = r3.contentType();
        if (r8 == null) goto L7;
        r2.header(NetConst.KEY_CONTENT_TYPE, r8.toString());
    L7:
        long r9 = r3.contentLength();
        if (r9 == (-1)) goto L10;
        r2.header("Content-Length", String.valueOf(r9));
        r2.removeHeader("Transfer-Encoding");
        goto L11
    L10:
        r2.header("Transfer-Encoding", "chunked");
        r2.removeHeader("Content-Length");
    L11:
        boolean r10 = false;
        if (r0.header("Host") != null) goto L15;
        r2.header("Host", Util.toHostHeader$default(r0.url(), false, 1, null));
    L15:
        if (r0.header("Connection") != null) goto L18;
        r2.header("Connection", "Keep-Alive");
    L18:
        if (r0.header(NetConst.KEY_ACCEPT_ENCODING) == null) goto L20;
    L22:
        List<Cookie> r4 = this.cookieJar.loadForRequest(r0.url());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L26;
        r2.header("Cookie", cookieHeader(r4));
    L26:
        if (r0.header("User-Agent") != null) goto L28;
        r2.header("User-Agent", Version.userAgent);
    L28:
        Response r16 = r15.proceed(r2.build());
        HttpHeaders.receiveHeaders(this.cookieJar, r0.url(), r16.headers());
        Response.Builder r13 = r16.newBuilder().request(r0);
        if (r10 == false) goto L38;
        if (StringsKt.equals(NetConst.GZIP, Response.header$default(r16, NetConst.KEY_CONTENT_ENCODING, null, 2, null), true) == false) goto L38;
        if (HttpHeaders.promisesBody(r16) == false) goto L38;
        ResponseBody r5 = r16.body();
        if (r5 == null) goto L38;
        GzipSource r11 = new GzipSource((Source) ZeusTransformUtils.preCheckCast(r5.source(), Source.class, "com.obric.memorydata.plugin"));
        r13.headers(r16.headers().newBuilder().removeAll(NetConst.KEY_CONTENT_ENCODING).removeAll("Content-Length").build());
        r13.body((ResponseBody) ZeusTransformUtils.preCheckCast(new RealResponseBody(Response.header$default(r16, NetConst.KEY_CONTENT_TYPE, null, 2, null), -1, Okio.buffer((Source) ZeusTransformUtils.preCheckCast(r11, Source.class, "com.obric.memorydata.plugin"))), ResponseBody.class, "com.obric.memorydata.plugin"));
    L38:
        return r13.build();
    L20:
        if (r0.header("Range") != null) goto L22;
        r2.header(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        r10 = true;
        goto L22
    }
}
