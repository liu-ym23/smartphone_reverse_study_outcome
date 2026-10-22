package okhttp3.internal.cache;

import cn.nubia.neopush.commons.AppUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.h;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.n0;
import okhttp3.r0;
import okhttp3.s0;
import uj.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "Lokhttp3/Request;", "networkRequest", "Lokhttp3/s0;", "cacheResponse", "<init>", "(Lokhttp3/Request;Lokhttp3/s0;)V", "Lokhttp3/Request;", "getNetworkRequest", "()Lokhttp3/Request;", "Lokhttp3/s0;", "getCacheResponse", "()Lokhttp3/s0;", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheStrategy {
    public static final Companion Companion = null;
    private final s0 cacheResponse;
    private final Request networkRequest;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "<init>", "()V", "Lokhttp3/s0;", "response", "Lokhttp3/Request;", "request", "", "isCacheable", "(Lokhttp3/s0;Lokhttp3/Request;)Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isCacheable(s0 r5, Request r10) {
            Intrinsics.checkNotNullParameter(r5, "response");
            Intrinsics.checkNotNullParameter(r10, "request");
            int r11 = r5.e;
            if (r11 == 200) goto L34;
            if (r11 == 410) goto L34;
            if (r11 == 414) goto L34;
            if (r11 == 501) goto L34;
            if (r11 == 203) goto L34;
            if (r11 == 204) goto L34;
            if (r11 == 307) goto L25;
            if (r11 == 308) goto L34;
            if (r11 == 404) goto L34;
            if (r11 == 405) goto L34;
            switch(r11) {
                case 300: goto L34;
                case 301: goto L34;
                case 302: goto L25;
                default: goto L23;
            };
        L23:
            return false;
        L25:
            if (r5.d("Expires", null) != null) goto L34;
            if (r5.b().f20650c != (-1)) goto L34;
            if (r5.b().f == true) goto L34;
            if (r5.b().e == true) goto L34;
            return false;
        L34:
            if (r5.b().f20649b == false) goto L36;
            return false;
        L36:
            if (r10.cacheControl().f20649b == true) goto L40;
            return true;
        L40:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)¨\u0006*"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "nowMillis", "Lokhttp3/Request;", "request", "Lokhttp3/s0;", "cacheResponse", "<init>", "(JLokhttp3/Request;Lokhttp3/s0;)V", "", "isFreshnessLifetimeHeuristic", "()Z", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "()Lokhttp3/internal/cache/CacheStrategy;", "computeFreshnessLifetime", "()J", "cacheResponseAge", "hasConditions", "(Lokhttp3/Request;)Z", "compute", "Ljava/util/Date;", "servedDate", "Ljava/util/Date;", "", "servedDateString", "Ljava/lang/String;", "lastModified", "lastModifiedString", "expires", "sentRequestMillis", "J", "receivedResponseMillis", "etag", "", "ageSeconds", "I", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "Lokhttp3/s0;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Factory {
        private int ageSeconds;
        private final s0 cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long r5, Request r10, s0 r11) {
            Intrinsics.checkNotNullParameter(r10, "request");
            this.nowMillis = r5;
            this.request = r10;
            this.cacheResponse = r11;
            this.ageSeconds = -1;
            if (r11 == null) goto L22;
            this.sentRequestMillis = r11.f20752l;
            this.receivedResponseMillis = r11.f20753m;
            c0 r12 = r11.g;
            int r13 = r12.size();
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L30;
            String r15 = r12.c(r14);
            String r16 = r12.e(r14);
            if (StringsKt.l(r15, "Date") == false) goto L10;
            this.servedDate = DatesKt.toHttpDateOrNull(r16);
            this.servedDateString = r16;
        L21:
            r14 = r14 + 1;
            goto L5
        L10:
            if (StringsKt.l(r15, "Expires") == false) goto L13;
            this.expires = DatesKt.toHttpDateOrNull(r16);
            goto L21
        L13:
            if (StringsKt.l(r15, "Last-Modified") == false) goto L16;
            this.lastModified = DatesKt.toHttpDateOrNull(r16);
            this.lastModifiedString = r16;
            goto L21
        L16:
            if (StringsKt.l(r15, "ETag") == false) goto L19;
            this.etag = r16;
            goto L21
        L19:
            if (StringsKt.l(r15, "Age") == false) goto L21;
            this.ageSeconds = Util.toNonNegativeInt(r16, -1);
            goto L21
        L30:
            return;
        }

        private final long cacheResponseAge() {
            Date r5 = this.servedDate;
            long r10 = 0;
            if (r5 == null) goto L5;
            r10 = Math.max(0, this.receivedResponseMillis - r5.getTime());
        L5:
            int r11 = this.ageSeconds;
            if (r11 == (-1)) goto L8;
            r10 = Math.max(r10, TimeUnit.SECONDS.toMillis(r11));
        L8:
            long r12 = this.receivedResponseMillis;
            return (r10 + (r12 - this.sentRequestMillis)) + (this.nowMillis - r12);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, null);
        L7:
            if (this.request.isHttps() == false) goto L13;
            if (this.cacheResponse.f != null) goto L13;
            return new CacheStrategy(this.request, null);
        L13:
            if (CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request) == false) goto L15;
            h r5 = this.request.cacheControl();
            if (r5.f20648a == true) goto L62;
            if (hasConditions(this.request) == true) goto L62;
            h r10 = this.cacheResponse.b();
            long r11 = cacheResponseAge();
            long r12 = computeFreshnessLifetime();
            int r13 = r5.f20650c;
            if (r13 == (-1)) goto L24;
            r12 = Math.min(r12, TimeUnit.SECONDS.toMillis(r13));
        L24:
            long r14 = 0;
            int r15 = r5.f20652i;
            if (r15 == (-1)) goto L27;
            long r16 = TimeUnit.SECONDS.toMillis(r15);
        L29:
            if (r10.g == true) goto L34;
            int r17 = r5.f20651h;
            if (r17 == (-1)) goto L34;
            r14 = TimeUnit.SECONDS.toMillis(r17);
        L34:
            if (r10.f20648a == true) goto L47;
            long r18 = r16 + r11;
            if (r18 >= (r14 + r12)) goto L47;
            r0 r19 = this.cacheResponse.f();
            if (r18 < r12) goto L41;
            Intrinsics.checkNotNullParameter("Warning", "name");
            Intrinsics.checkNotNullParameter("110 HttpURLConnection \"Response is stale\"", "value");
            r19.f.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r11 <= AppUtil.MILLIS_IN_DAYS) goto L46;
            if (isFreshnessLifetimeHeuristic() == false) goto L46;
            Intrinsics.checkNotNullParameter("Warning", "name");
            Intrinsics.checkNotNullParameter("113 HttpURLConnection \"Heuristic expiration\"", "value");
            r19.f.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new CacheStrategy(null, r19.a());
        L47:
            String r20 = this.etag;
            if (r20 == null) goto L51;
            String r21 = "If-None-Match";
        L57:
            b0 r22 = this.request.headers().d();
            Intrinsics.checkNotNull(r20);
            r22.c(r21, r20);
            n0 r23 = this.request.newBuilder();
            c0 r24 = r22.d();
            r23.getClass();
            Intrinsics.checkNotNullParameter(r24, "headers");
            r23.f20715c = r24.d();
            return new CacheStrategy(r23.b(), this.cacheResponse);
        L51:
            if (this.lastModified == null) goto L55;
            r20 = this.lastModifiedString;
        L53:
            r21 = "If-Modified-Since";
            goto L57
        L55:
            if (this.servedDate == null) goto L60;
            r20 = this.servedDateString;
            goto L53
        L60:
            return new CacheStrategy(this.request, null);
        L27:
            r16 = 0;
        L62:
            return new CacheStrategy(this.request, null);
        L15:
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            s0 r5 = this.cacheResponse;
            Intrinsics.checkNotNull(r5);
            int r10 = r5.b().f20650c;
            if (r10 != (-1)) goto L5;
            Date r11 = this.expires;
            if (r11 == null) goto L17;
            Date r12 = this.servedDate;
            if (r12 == null) goto L11;
            long r13 = r12.getTime();
        L12:
            long r14 = r11.getTime() - r13;
            if (r14 > 0) goto L15;
            return 0;
        L15:
            return r14;
        L11:
            r13 = this.receivedResponseMillis;
            goto L12
        L17:
            if (this.lastModified == null) goto L32;
            ArrayList r15 = this.cacheResponse.f20746b.url().f20642h;
            if (r15 != null) goto L21;
            String r16 = null;
        L22:
            if (r16 != null) goto L33;
            Date r17 = this.servedDate;
            if (r17 == null) goto L26;
            long r18 = r17.getTime();
        L27:
            Date r19 = this.lastModified;
            Intrinsics.checkNotNull(r19);
            long r20 = r18 - r19.getTime();
            if (r20 > 0) goto L30;
            return 0;
        L30:
            return r20 / ((long) 10);
        L26:
            r18 = this.sentRequestMillis;
            goto L27
        L33:
            return 0;
        L21:
            StringBuilder r21 = new StringBuilder();
            a.m(r15, r21);
            r16 = r21.toString();
            goto L22
        L32:
            return 0;
        L5:
            return TimeUnit.SECONDS.toMillis(r10);
        }

        private final boolean hasConditions(Request r5) {
            if (r5.header("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r5.header("If-None-Match") != null) goto L8;
            return false;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            s0 r5 = this.cacheResponse;
            Intrinsics.checkNotNull(r5);
            if (r5.b().f20650c == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.expires != null) goto L7;
            return true;
        }

        public final CacheStrategy compute() {
            CacheStrategy r5 = computeCandidate();
            if (r5.getNetworkRequest() != null) goto L5;
        L8:
            return r5;
        L5:
            if (this.request.cacheControl().f20653j == false) goto L8;
            return new CacheStrategy(null, null);
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheStrategy(Request r5, s0 r10) {
        this.networkRequest = r5;
        this.cacheResponse = r10;
    }

    public final s0 getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
