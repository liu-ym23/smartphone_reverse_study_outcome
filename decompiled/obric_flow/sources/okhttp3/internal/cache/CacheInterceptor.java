package okhttp3.internal.cache;

import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import cn.nubia.neopush.commons.Constant;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.t;
import f4.b;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.a0;
import nu.l;
import nu.w;
import okhttp3.Call;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d;
import okhttp3.e;
import okhttp3.f0;
import okhttp3.g;
import okhttp3.g0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/g0;", "Lokhttp3/g;", "cache", "<init>", "(Lokhttp3/g;)V", "Lokhttp3/internal/cache/CacheRequest;", "cacheRequest", "Lokhttp3/s0;", "response", "cacheWritingResponse", "(Lokhttp3/internal/cache/CacheRequest;Lokhttp3/s0;)Lokhttp3/s0;", "Lokhttp3/f0;", "chain", "intercept", "(Lokhttp3/f0;)Lokhttp3/s0;", "Lokhttp3/g;", "getCache$okhttp", "()Lokhttp3/g;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheInterceptor implements g0 {
    public static final Companion Companion = null;
    private final g cache;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "<init>", "()V", "Lokhttp3/s0;", "response", "stripBody", "(Lokhttp3/s0;)Lokhttp3/s0;", "Lokhttp3/c0;", "cachedHeaders", "networkHeaders", "combine", "(Lokhttp3/c0;Lokhttp3/c0;)Lokhttp3/c0;", "", "fieldName", "", "isEndToEnd", "(Ljava/lang/String;)Z", "isContentSpecificHeader", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ c0 access$combine(Companion r5, c0 r10, c0 r11) {
            return r5.combine(r10, r11);
        }

        public static final /* synthetic */ s0 access$stripBody(Companion r5, s0 r10) {
            return r5.stripBody(r10);
        }

        private final c0 combine(c0 r10, c0 r11) {
            b0 r5 = new b0();
            int r12 = r10.size();
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L17;
            String r15 = r10.c(r14);
            String r16 = r10.e(r14);
            if (StringsKt.l("Warning", r15) == false) goto L10;
            if (StringsKt.P(r16, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L10;
        L16:
            r14 = r14 + 1;
        L10:
            if (isContentSpecificHeader(r15) == false) goto L12;
        L15:
            r5.c(r15, r16);
            goto L16
        L12:
            if (isEndToEnd(r15) == false) goto L15;
            if (r11.b(r15) != null) goto L16;
        L17:
            int r17 = r11.size();
        L18:
            if (r13 >= r17) goto L26;
            String r18 = r11.c(r13);
            if (isContentSpecificHeader(r18) == true) goto L24;
            if (isEndToEnd(r18) == false) goto L24;
            r5.c(r18, r11.e(r13));
        L24:
            r13 = r13 + 1;
            goto L18
        L26:
            return r5.d();
        }

        private final boolean isContentSpecificHeader(String r5) {
            if (StringsKt.l("Content-Length", r5) == false) goto L5;
        L10:
            return true;
        L5:
            if (StringsKt.l("Content-Encoding", r5) == true) goto L10;
            if (StringsKt.l("Content-Type", r5) == true) goto L10;
            return false;
        }

        private final boolean isEndToEnd(String r5) {
            if (StringsKt.l("Connection", r5) == false) goto L5;
        L19:
            return false;
        L5:
            if (StringsKt.l("Keep-Alive", r5) == true) goto L19;
            if (StringsKt.l("Proxy-Authenticate", r5) == true) goto L19;
            if (StringsKt.l("Proxy-Authorization", r5) == true) goto L19;
            if (StringsKt.l("TE", r5) == true) goto L19;
            if (StringsKt.l("Trailers", r5) == true) goto L19;
            if (StringsKt.l("Transfer-Encoding", r5) == true) goto L19;
            if (StringsKt.l(Constant.UPDATE_PATH, r5) == true) goto L19;
            return true;
        }

        private final s0 stripBody(s0 r5) {
            if (r5 == null) goto L5;
            w0 r10 = r5.f20748h;
        L6:
            if (r10 == null) goto L9;
            r0 r11 = r5.f();
            r11.g = null;
            return r11.a();
        L9:
            return r5;
        L5:
            r10 = null;
            goto L6
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheInterceptor(g r5) {
        this.cache = r5;
    }

    private final s0 cacheWritingResponse(final CacheRequest r5, s0 r10) throws IOException {
        if (r5 != null) goto L4;
        return r10;
    L4:
        a0 r11 = r5.body();
        w0 r12 = r10.f20748h;
        Intrinsics.checkNotNull(r12);
        final l r13 = r12.source();
        final w r14 = b.d(r11);
        nu.c0 r15 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(r13, r5, r14);
        String r16 = r10.d("Content-Type", null);
        long r17 = r10.f20748h.contentLength();
        r0 r18 = r10.f();
        r18.g = new RealResponseBody(r16, r17, b.e(r15));
        return r18.a();
    }

    public final g getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.g0
    public s0 intercept(f0 r14) throws IOException {
        Intrinsics.checkNotNullParameter(r14, "chain");
        Call r5 = r14.call();
        g r10 = this.cache;
        t r11 = null;
        DiskLruCache.Editor r12 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        if (r10 == null) goto L5;
        s0 r13 = r10.b(r14.request());
    L6:
        CacheStrategy r15 = new CacheStrategy.Factory(System.currentTimeMillis(), r14.request(), r13).compute();
        Request r16 = r15.getNetworkRequest();
        s0 r17 = r15.getCacheResponse();
        g r18 = this.cache;
        if (r18 == null) goto L19;
        monitor-enter(r18);
        Intrinsics.checkNotNullParameter(r15, "cacheStrategy");     // Catch: Throwable -> L15
        if (r15.getNetworkRequest() != null) goto L13;
        r15.getCacheResponse();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r18);
    L15:
        th = move-exception;
        throw th;
    L19:
        if ((r5 instanceof RealCall) == true) goto L21;
        Call r19 = null;
    L22:
        RealCall r20 = (RealCall) r19;
        if (r20 == null) goto L25;
        r20.getEventListener$okhttp();
    L25:
        if (r13 == null) goto L30;
        if (r17 != null) goto L30;
        w0 r21 = r13.f20748h;
        if (r21 == null) goto L30;
        Util.closeQuietly(r21);
    L30:
        if (r16 != null) goto L34;
        if (r17 != null) goto L34;
        r0 r110 = new r0();
        Request r111 = r14.request();
        Intrinsics.checkNotNullParameter(r111, "request");
        r110.f20735a = r111;
        r110.d(Protocol.HTTP_1_1);
        r110.f20737c = 504;
        Intrinsics.checkNotNullParameter("Unsatisfiable Request (only-if-cached)", "message");
        r110.d = "Unsatisfiable Request (only-if-cached)";
        r110.g = Util.EMPTY_RESPONSE;
        r110.f20741k = -1;
        r110.f20742l = System.currentTimeMillis();
        s0 r112 = r110.a();
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r112, "response");
        return r112;
    L34:
        if (r16 != null) goto L37;
        Intrinsics.checkNotNull(r17);
        r0 r113 = r17.f();
        s0 r114 = Companion.access$stripBody(Companion, r17);
        r0.b(r114, "cacheResponse");
        r113.f20739i = r114;
        s0 r115 = r113.a();
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r115, "response");
        return r115;
    L37:
        if (r17 == null) goto L40;
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r17, "cachedResponse");
    L113:
        s0 r116 = r14.proceed(r16);     // Catch: Throwable -> L103
        if (r116 != null) goto L48;
        if (r13 == null) goto L48;
        w0 r22 = r13.f20748h;
        if (r22 == null) goto L48;
        Util.closeQuietly(r22);
    L48:
        if (r17 == null) goto L71;
        if (r116 != null) goto L51;
    L68:
        w0 r23 = r17.f20748h;
        if (r23 == null) goto L71;
        Util.closeQuietly(r23);
        goto L71
    L51:
        if (r116.e != 304) goto L68;
        r0 r24 = r17.f();
        Companion r25 = Companion;
        r24.c(Companion.access$combine(r25, r17.g, r116.g));
        r24.f20741k = r116.f20752l;
        r24.f20742l = r116.f20753m;
        s0 r26 = Companion.access$stripBody(r25, r17);
        r0.b(r26, "cacheResponse");
        r24.f20739i = r26;
        s0 r27 = Companion.access$stripBody(r25, r116);
        r0.b(r27, "networkResponse");
        r24.f20738h = r27;
        s0 r28 = r24.a();
        w0 r117 = r116.f20748h;
        Intrinsics.checkNotNull(r117);
        r117.close();
        g r118 = this.cache;
        Intrinsics.checkNotNull(r118);
        monitor-enter(r118);
        monitor-exit(r118);
        this.cache.getClass();
        Intrinsics.checkNotNullParameter(r17, "cached");
        Intrinsics.checkNotNullParameter(r28, "network");
        e r119 = new e(r28);
        w0 r120 = r17.f20748h;
        if (r120 == null) goto L67;
        r12 = ((d) r120).f20624b.edit();     // Catch: IOException -> L62
        if (r12 == null) goto L64;
        r119.c(r12);     // Catch: IOException -> L62
        r12.commit();     // Catch: IOException -> L62
    L64:
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r28, "response");
        return r28;
    L62:
        if (r12 == null) goto L64;
        r12.abort();     // Catch: IOException -> L109
        goto L64
    L67:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    L71:
        Intrinsics.checkNotNull(r116);
        r0 r29 = r116.f();
        Companion r30 = Companion;
        s0 r31 = Companion.access$stripBody(r30, r17);
        r0.b(r31, "cacheResponse");
        r29.f20739i = r31;
        s0 r121 = Companion.access$stripBody(r30, r116);
        r0.b(r121, "networkResponse");
        r29.f20738h = r121;
        s0 r122 = r29.a();
        if (this.cache != null) goto L74;
    L102:
        return r122;
    L74:
        if (HttpHeaders.promisesBody(r122) == false) goto L100;
        if (CacheStrategy.Companion.isCacheable(r122, r16) == false) goto L100;
        g r32 = this.cache;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r122, "response");
        String r33 = r122.f20746b.method();
        HttpMethod r34 = HttpMethod.INSTANCE;
        Request r35 = r122.f20746b;
        if (r34.invalidatesCache(r35.method()) == false) goto L82;
        Intrinsics.checkNotNullParameter(r35, "request");     // Catch: IOException -> L111
        r32.f20646a.remove(z.g(r35.url()));     // Catch: IOException -> L111
    L119:
        goto L95
    L82:
        if (Intrinsics.areEqual(r33, "GET") == false) goto L95;
        Intrinsics.checkNotNullParameter(r122, "$this$hasVaryAll");
        if (z.o(r122.g).contains(XPath.WILDCARD) == true) goto L95;
        e r36 = new e(r122);
        DiskLruCache.Editor r37 = DiskLruCache.edit$default(r32.f20646a, z.g(r35.url()), 0, 2, null);     // Catch: IOException -> L92
        if (r37 == null) goto L95;
        r36.c(r37);     // Catch: IOException -> L110
        r11 = new t(r32, r37);     // Catch: IOException -> L110
    L93:
        if (r37 == null) goto L95;
        r37.abort();     // Catch: IOException -> L111
    L92:
        r37 = null;
    L95:
        s0 r123 = cacheWritingResponse(r11, r122);
        if (r17 == null) goto L98;
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
    L98:
        return r123;
    L100:
        if (HttpMethod.INSTANCE.invalidatesCache(r16.method()) == false) goto L102;
        g r124 = this.cache;     // Catch: IOException -> L112
        r124.getClass();     // Catch: IOException -> L112
        Intrinsics.checkNotNullParameter(r16, "request");     // Catch: IOException -> L112
        r124.f20646a.remove(z.g(r16.url()));     // Catch: IOException -> L112
    L103:
        th = move-exception;
        if (r13 == null) goto L108;
        w0 r125 = r13.f20748h;
        if (r125 == null) goto L108;
        Util.closeQuietly(r125);
    L108:
        throw th;
    L40:
        if (this.cache == null) goto L113;
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        goto L113
    L21:
        r19 = r5;
        goto L22
    L5:
        r13 = null;
        goto L6
    }
}
