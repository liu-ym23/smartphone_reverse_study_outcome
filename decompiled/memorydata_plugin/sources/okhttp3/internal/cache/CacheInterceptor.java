package okhttp3.internal.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.NetConst;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", ChatMessage.TYPE_RESPONSE, "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private final Cache cache;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", ChatMessage.TYPE_RESPONSE, "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ Headers access$combine(Companion r0, Headers r1, Headers r2) {
            return r0.combine(r1, r2);
        }

        public static final /* synthetic */ Response access$stripBody(Companion r0, Response r1) {
            return r0.stripBody(r1);
        }

        private final Headers combine(Headers r12, Headers r13) {
            Headers.Builder r1 = new Headers.Builder();
            int r2 = r12.size();
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r4 >= r2) goto L18;
            String r6 = r12.name(r4);
            String r7 = r12.value(r4);
            if (StringsKt.equals("Warning", r6, true) == false) goto L11;
            if (StringsKt.startsWith$default(r7, "1", false, 2, null) == false) goto L11;
        L17:
            r4 = r4 + 1;
        L11:
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isContentSpecificHeader(r6) == false) goto L13;
        L16:
            r1.addLenient$okhttp(r6, r7);
            goto L17
        L13:
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isEndToEnd(r6) == false) goto L16;
            if (r13.get(r6) != null) goto L17;
        L18:
            int r14 = r13.size();
        L19:
            if (r3 >= r14) goto L27;
            String r5 = r13.name(r3);
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isContentSpecificHeader(r5) == true) goto L25;
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isEndToEnd(r5) == false) goto L25;
            r1.addLenient$okhttp(r5, r13.value(r3));
        L25:
            r3 = r3 + 1;
            goto L19
        L27:
            return r1.build();
        }

        private final boolean isContentSpecificHeader(String r2) {
            if (StringsKt.equals("Content-Length", r2, true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(NetConst.KEY_CONTENT_ENCODING, r2, true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(NetConst.KEY_CONTENT_TYPE, r2, true) == true) goto L13;
            return false;
        L13:
            return true;
        }

        private final boolean isEndToEnd(String r2) {
            if (StringsKt.equals("Connection", r2, true) == false) goto L5;
        L19:
            return false;
        L5:
            if (StringsKt.equals("Keep-Alive", r2, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authenticate", r2, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authorization", r2, true) == true) goto L19;
            if (StringsKt.equals("TE", r2, true) == true) goto L19;
            if (StringsKt.equals("Trailers", r2, true) == true) goto L19;
            if (StringsKt.equals("Transfer-Encoding", r2, true) == true) goto L19;
            if (StringsKt.equals("Upgrade", r2, true) == true) goto L19;
            return true;
        }

        private final Response stripBody(Response r2) {
            if (r2 == null) goto L5;
            ResponseBody r0 = r2.body();
        L6:
            if (r0 != null) goto L8;
            return r2;
        L8:
            return r2.newBuilder().body(null).build();
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheInterceptor(Cache r1) {
        this.cache = r1;
    }

    private final Response cacheWritingResponse(CacheRequest r6, Response r7) {
        final CacheRequest r5 = (CacheRequest) ZeusTransformUtils.wrapperContextForParams(r6, CacheRequest.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return r7;
    L5:
        Sink r8 = r5.body();
        ResponseBody r1 = r7.body();
        if (r1 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        final BufferedSource r2 = r1.source();
        final BufferedSink r9 = Okio.buffer(r8);
        Source r3 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(r2, r5, r9);
        String r10 = Response.header$default(r7, NetConst.KEY_CONTENT_TYPE, null, 2, null);
        long r4 = r7.body().contentLength();
        return r7.newBuilder().body((ResponseBody) ZeusTransformUtils.preCheckCast(new RealResponseBody(r10, r4, Okio.buffer((Source) ZeusTransformUtils.preCheckCast(r3, Source.class, "com.obric.memorydata.plugin"))), ResponseBody.class, "com.obric.memorydata.plugin")).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r8) {
        Interceptor.Chain r9 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r8, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "chain");
        Cache r0 = this.cache;
        if (r0 == null) goto L5;
        Response r1 = r0.get$okhttp(r9.request());
    L6:
        CacheStrategy r3 = new CacheStrategy.Factory(System.currentTimeMillis(), r9.request(), r1).compute();
        Request r4 = r3.getNetworkRequest();
        Response r5 = r3.getCacheResponse();
        Cache r6 = this.cache;
        if (r6 == null) goto L9;
        r6.trackResponse$okhttp(r3);
    L9:
        if (r1 == null) goto L14;
        if (r5 != null) goto L14;
        ResponseBody r7 = r1.body();
        if (r7 == null) goto L14;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin"));
    L14:
        if (r4 != null) goto L18;
        if (r5 != null) goto L18;
        return new Response.Builder().request(r9.request()).protocol(Protocol.HTTP_1_1).code(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
    L18:
        if (r4 != null) goto L23;
        if (r5 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return r5.newBuilder().cacheResponse(Companion.access$stripBody(Companion, r5)).build();
    L23:
        Response r2 = (Response) ZeusTransformUtils.preCheckCast(null, Response.class, "com.obric.memorydata.plugin");
        Response r10 = r9.proceed(r4);     // Catch: Throwable -> L59
        if (r10 != null) goto L30;
        if (r1 == null) goto L30;
        ResponseBody r11 = r1.body();
        if (r11 == null) goto L30;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin"));
    L30:
        if (r5 == null) goto L45;
        if (r10 != null) goto L33;
    L42:
        ResponseBody r12 = r5.body();
        if (r12 == null) goto L45;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin"));
        goto L45
    L33:
        if (r10.code() != 304) goto L42;
        Response.Builder r13 = r5.newBuilder();
        Companion r14 = Companion;
        Response r15 = r13.headers(Companion.access$combine(r14, r5.headers(), r10.headers())).sentRequestAtMillis(r10.sentRequestAtMillis()).receivedResponseAtMillis(r10.receivedResponseAtMillis()).cacheResponse(Companion.access$stripBody(r14, r5)).networkResponse(Companion.access$stripBody(r14, r10)).build();
        ResponseBody r16 = r10.body();
        if (r16 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        r16.close();
        Cache r17 = this.cache;
        if (r17 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        r17.trackConditionalCacheHit$okhttp();
        this.cache.update$okhttp(r5, r15);
        return r15;
    L45:
        if (r10 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        Response.Builder r18 = r10.newBuilder();
        Companion r19 = Companion;
        Response r20 = r18.cacheResponse(Companion.access$stripBody(r19, r5)).networkResponse(Companion.access$stripBody(r19, r10)).build();
        if (this.cache != null) goto L50;
    L58:
        return r20;
    L50:
        if (HttpHeaders.promisesBody(r20) == false) goto L56;
        if (CacheStrategy.Companion.isCacheable(r20, r4) == false) goto L56;
        return cacheWritingResponse(this.cache.put$okhttp(r20), r20);
    L56:
        if (HttpMethod.INSTANCE.invalidatesCache(r4.method()) == false) goto L58;
        this.cache.remove$okhttp(r4);     // Catch: IOException -> L65
    L59:
        th = move-exception;
        if (r1 == null) goto L64;
        ResponseBody r21 = r1.body();
        if (r21 == null) goto L64;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r21, Closeable.class, "com.obric.memorydata.plugin"));
    L64:
        throw th;
    L5:
        r1 = null;
        goto L6
    }
}
