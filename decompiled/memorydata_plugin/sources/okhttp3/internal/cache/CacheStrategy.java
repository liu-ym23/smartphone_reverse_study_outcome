package okhttp3.internal.cache;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class CacheStrategy {
    public static final Companion Companion = null;
    private final Response cacheResponse;
    private final Request networkRequest;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean isCacheable(Response r4, Request r5) {
            Intrinsics.checkParameterIsNotNull(r4, ChatMessage.TYPE_RESPONSE);
            Intrinsics.checkParameterIsNotNull(r5, Ext.KEY_REQUEST);
            int r3 = r4.code();
            if (r3 == 200) goto L34;
            if (r3 == 410) goto L34;
            if (r3 == 414) goto L34;
            if (r3 == 501) goto L34;
            if (r3 == 203) goto L34;
            if (r3 == 204) goto L34;
            if (r3 == 307) goto L25;
            if (r3 == 308) goto L34;
            if (r3 == 404) goto L34;
            if (r3 == 405) goto L34;
            switch(r3) {
                case 300: goto L34;
                case 301: goto L34;
                case 302: goto L25;
                default: goto L23;
            };
        L23:
            return false;
        L25:
            if (Response.header$default(r4, "Expires", null, 2, null) != null) goto L34;
            if (r4.cacheControl().maxAgeSeconds() != (-1)) goto L34;
            if (r4.cacheControl().isPublic() == true) goto L34;
            if (r4.cacheControl().isPrivate() == true) goto L34;
            return false;
        L34:
            if (r4.cacheControl().noStore() == false) goto L36;
            return false;
        L36:
            if (r5.cacheControl().noStore() == true) goto L40;
            return true;
        L40:
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", URLDispatch.KEY_ETAG, "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
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

        public Factory(long r5, Request r7, Response r8) {
            Intrinsics.checkParameterIsNotNull(r7, Ext.KEY_REQUEST);
            this.nowMillis = r5;
            this.request = r7;
            this.cacheResponse = r8;
            this.ageSeconds = -1;
            if (r8 == null) goto L22;
            this.sentRequestMillis = r8.sentRequestAtMillis();
            this.receivedResponseMillis = r8.receivedResponseAtMillis();
            Headers r6 = r8.headers();
            int r9 = 0;
            int r10 = r6.size();
        L5:
            if (r9 >= r10) goto L30;
            String r0 = r6.name(r9);
            String r1 = r6.value(r9);
            if (StringsKt.equals(r0, "Date", true) == false) goto L10;
            this.servedDate = DatesKt.toHttpDateOrNull(r1);
            this.servedDateString = r1;
        L21:
            r9 = r9 + 1;
            goto L5
        L10:
            if (StringsKt.equals(r0, "Expires", true) == false) goto L13;
            this.expires = DatesKt.toHttpDateOrNull(r1);
            goto L21
        L13:
            if (StringsKt.equals(r0, "Last-Modified", true) == false) goto L16;
            this.lastModified = DatesKt.toHttpDateOrNull(r1);
            this.lastModifiedString = r1;
            goto L21
        L16:
            if (StringsKt.equals(r0, "ETag", true) == false) goto L19;
            this.etag = r1;
            goto L21
        L19:
            if (StringsKt.equals(r0, "Age", true) == false) goto L21;
            this.ageSeconds = Util.toNonNegativeInt(r1, -1);
            goto L21
        L30:
            return;
        }

        private final long cacheResponseAge() {
            Date r0 = this.servedDate;
            long r1 = 0;
            if (r0 == null) goto L6;
            r1 = Math.max(0, this.receivedResponseMillis - r0.getTime());
        L6:
            if (this.ageSeconds == (-1)) goto L8;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        L8:
            long r3 = this.receivedResponseMillis;
            return (r1 + (r3 - this.sentRequestMillis)) + (this.nowMillis - r3);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, null);
        L7:
            if (this.request.isHttps() == false) goto L13;
            if (this.cacheResponse.handshake() != null) goto L13;
            return new CacheStrategy(this.request, null);
        L13:
            if (CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request) == false) goto L15;
            CacheControl r0 = this.request.cacheControl();
            if (r0.noCache() == true) goto L64;
            if (hasConditions(this.request) == true) goto L64;
            CacheControl r2 = this.cacheResponse.cacheControl();
            long r3 = cacheResponseAge();
            long r5 = computeFreshnessLifetime();
            if (r0.maxAgeSeconds() == (-1)) goto L24;
            r5 = Math.min(r5, TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds()));
        L24:
            long r9 = 0;
            if (r0.minFreshSeconds() == (-1)) goto L27;
            long r11 = TimeUnit.SECONDS.toMillis(r0.minFreshSeconds());
        L29:
            if (r2.mustRevalidate() == true) goto L34;
            if (r0.maxStaleSeconds() == (-1)) goto L34;
            r9 = TimeUnit.SECONDS.toMillis(r0.maxStaleSeconds());
        L34:
            if (r2.noCache() == true) goto L47;
            long r12 = r11 + r3;
            if (r12 >= (r9 + r5)) goto L47;
            Response.Builder r1 = this.cacheResponse.newBuilder();
            if (r12 < r5) goto L41;
            r1.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r3 <= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L46;
            if (isFreshnessLifetimeHeuristic() == false) goto L46;
            r1.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new CacheStrategy(null, r1.build());
        L47:
            String r4 = this.etag;
            String r6 = "If-Modified-Since";
            if (r4 == null) goto L51;
            r6 = "If-None-Match";
        L56:
            Headers.Builder r7 = this.request.headers().newBuilder();
            if (r4 != null) goto L59;
            Intrinsics.throwNpe();
        L59:
            r7.addLenient$okhttp(r6, r4);
            return new CacheStrategy(this.request.newBuilder().headers(r7.build()).build(), this.cacheResponse);
        L51:
            if (this.lastModified == null) goto L54;
            r4 = this.lastModifiedString;
            goto L56
        L54:
            if (this.servedDate == null) goto L62;
            r4 = this.servedDateString;
            goto L56
        L62:
            return new CacheStrategy(this.request, null);
        L27:
            r11 = 0;
        L64:
            return new CacheStrategy(this.request, null);
        L15:
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            Response r0 = this.cacheResponse;
            if (r0 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            CacheControl r1 = r0.cacheControl();
            if (r1.maxAgeSeconds() != (-1)) goto L8;
            Date r2 = this.expires;
            if (r2 == null) goto L20;
            Date r3 = this.servedDate;
            if (r3 == null) goto L14;
            long r4 = r3.getTime();
        L15:
            long r5 = r2.getTime() - r4;
            if (r5 > 0) goto L18;
            return 0;
        L18:
            return r5;
        L14:
            r4 = this.receivedResponseMillis;
            goto L15
        L20:
            if (this.lastModified != null) goto L22;
            return 0;
        L22:
            if (this.cacheResponse.request().url().query() != null) goto L36;
            Date r6 = this.servedDate;
            if (r6 == null) goto L26;
            long r7 = r6.getTime();
        L27:
            Date r8 = this.lastModified;
            if (r8 != null) goto L30;
            Intrinsics.throwNpe();
        L30:
            long r9 = r7 - r8.getTime();
            if (r9 > 0) goto L33;
            return 0;
        L33:
            return r9 / ((long) 10);
        L26:
            r7 = this.sentRequestMillis;
            goto L27
        L36:
            return 0;
        L8:
            return TimeUnit.SECONDS.toMillis(r1.maxAgeSeconds());
        }

        private final boolean hasConditions(Request r1) {
            if (r1.header("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.header("If-None-Match") != null) goto L8;
            return false;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response r0 = this.cacheResponse;
            if (r0 != null) goto L6;
            Intrinsics.throwNpe();
        L6:
            if (r0.cacheControl().maxAgeSeconds() == (-1)) goto L8;
        L10:
            return false;
        L8:
            if (this.expires != null) goto L10;
            return true;
        }

        public final CacheStrategy compute() {
            CacheStrategy r0 = computeCandidate();
            if (r0.getNetworkRequest() != null) goto L5;
        L8:
            return r0;
        L5:
            if (this.request.cacheControl().onlyIfCached() == false) goto L8;
            return new CacheStrategy(null, null);
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheStrategy(Request r1, Response r2) {
        this.networkRequest = r1;
        this.cacheResponse = r2;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
