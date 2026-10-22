package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.a0;
import nu.f0;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.c0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.r0;
import okhttp3.s0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00016B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010\u0017R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00104R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00105¨\u00067"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http2/Http2Connection;", "http2Connection", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "Lokhttp3/Request;", "request", "", "contentLength", "Lnu/a0;", "createRequestBody", "(Lokhttp3/Request;J)Lnu/a0;", "", "writeRequestHeaders", "(Lokhttp3/Request;)V", "flushRequest", "()V", "finishRequest", "", "expectContinue", "Lokhttp3/r0;", "readResponseHeaders", "(Z)Lokhttp3/r0;", "Lokhttp3/s0;", "response", "reportedContentLength", "(Lokhttp3/s0;)J", "Lnu/c0;", "openResponseBodySource", "(Lokhttp3/s0;)Lnu/c0;", "Lokhttp3/c0;", "trailers", "()Lokhttp3/c0;", "cancel", "Lokhttp3/internal/http2/Http2Stream;", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "canceled", "Z", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/internal/http2/Http2Connection;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    public static final Companion Companion = null;
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = null;
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = null;
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "<init>", "()V", "Lokhttp3/Request;", "request", "", "Lokhttp3/internal/http2/Header;", "http2HeadersList", "(Lokhttp3/Request;)Ljava/util/List;", "Lokhttp3/c0;", "headerBlock", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/r0;", "readHttp2HeadersList", "(Lokhttp3/c0;Lokhttp3/Protocol;)Lokhttp3/r0;", "", "CONNECTION", "Ljava/lang/String;", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final List<Header> http2HeadersList(Request r10) {
            Intrinsics.checkNotNullParameter(r10, "request");
            c0 r5 = r10.headers();
            ArrayList r11 = new ArrayList(r5.size() + 4);
            r11.add(new Header(Header.TARGET_METHOD, r10.method()));
            r11.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(r10.url())));
            String r12 = r10.header("Host");
            if (r12 == null) goto L5;
            r11.add(new Header(Header.TARGET_AUTHORITY, r12));
        L5:
            r11.add(new Header(Header.TARGET_SCHEME, r10.url().f20640b));
            int r13 = r5.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L19;
            String r15 = r5.c(r14);
            Locale r16 = Locale.US;
            if (r15 == null) goto L18;
            String r17 = r15.toLowerCase(r16);
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(r17) == true) goto L12;
        L15:
            r11.add(new Header(r17, r5.e(r14)));
        L16:
            r14 = r14 + 1;
            goto L6
        L12:
            if (Intrinsics.areEqual(r17, Http2ExchangeCodec.TE) == false) goto L16;
            if (Intrinsics.areEqual(r5.e(r14), "trailers") == false) goto L16;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L19:
            return r11;
        }

        public final r0 readHttp2HeadersList(c0 r10, Protocol r11) {
            Intrinsics.checkNotNullParameter(r10, "headerBlock");
            Intrinsics.checkNotNullParameter(r11, "protocol");
            ArrayList r12 = new ArrayList(20);
            int r5 = r10.size();
            StatusLine r13 = null;
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L11;
            String r15 = r10.c(r14);
            String r16 = r10.e(r14);
            if (Intrinsics.areEqual(r15, Header.RESPONSE_STATUS_UTF8) == false) goto L8;
            r13 = StatusLine.Companion.parse("HTTP/1.1 " + r16);
        L10:
            r14 = r14 + 1;
            goto L3
        L8:
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(r15) == true) goto L10;
            Intrinsics.checkNotNullParameter(r15, "name");
            Intrinsics.checkNotNullParameter(r16, "value");
            r12.add(r15);
            r12.add(StringsKt.trim(r16).toString());
            goto L10
        L11:
            if (r13 == null) goto L19;
            r0 r17 = new r0();
            r17.d(r11);
            r17.f20737c = r13.code;
            String r18 = r13.message;
            Intrinsics.checkNotNullParameter(r18, "message");
            r17.d = r18;
            Object[] r19 = r12.toArray(new String[0]);
            if (r19 == null) goto L17;
            r17.c(new c0((String[]) r19));
            return r17;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L19:
            throw new ProtocolException("Expected ':status' header not present");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    }

    public Http2ExchangeCodec(OkHttpClient r5, RealConnection r10, RealInterceptorChain r11, Http2Connection r12) {
        Intrinsics.checkNotNullParameter(r5, "client");
        Intrinsics.checkNotNullParameter(r10, "connection");
        Intrinsics.checkNotNullParameter(r11, "chain");
        Intrinsics.checkNotNullParameter(r12, "http2Connection");
        this.connection = r10;
        this.chain = r11;
        this.http2Connection = r12;
        List r13 = r5.s;
        Protocol r14 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r13.contains(r14) == true) goto L6;
        r14 = Protocol.HTTP_2;
    L6:
        this.protocol = r14;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp() {
        return HTTP_2_SKIPPED_REQUEST_HEADERS;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp() {
        return HTTP_2_SKIPPED_RESPONSE_HEADERS;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream r5 = this.stream;
        if (r5 == null) goto L6;
        r5.closeLater(ErrorCode.CANCEL);
        return;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public a0 createRequestBody(Request r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Http2Stream r11 = this.stream;
        Intrinsics.checkNotNull(r11);
        return r11.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream r5 = this.stream;
        Intrinsics.checkNotNull(r5);
        r5.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public nu.c0 openResponseBodySource(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        Http2Stream r10 = this.stream;
        Intrinsics.checkNotNull(r10);
        return r10.getSource$okhttp();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public r0 readResponseHeaders(boolean r5) {
        Http2Stream r10 = this.stream;
        Intrinsics.checkNotNull(r10);
        c0 r11 = r10.takeHeaders();
        r0 r12 = Companion.readHttp2HeadersList(r11, this.protocol);
        if (r5 == true) goto L5;
        return r12;
    L5:
        if (r12.f20737c != 100) goto L9;
        return null;
    L9:
        return r12;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        if (HttpHeaders.promisesBody(r5) == true) goto L6;
        return 0;
    L6:
        return Util.headersContentLength(r5);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public c0 trailers() {
        Http2Stream r5 = this.stream;
        Intrinsics.checkNotNull(r5);
        return r5.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (this.stream == null) goto L6;
        return;
    L6:
        if (r5.body() == null) goto L8;
        boolean r10 = true;
    L9:
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(r5), r10);
        if (this.canceled == true) goto L13;
        Http2Stream r11 = this.stream;
        Intrinsics.checkNotNull(r11);
        f0 r12 = r11.readTimeout();
        long r13 = this.chain.getReadTimeoutMillis$okhttp();
        TimeUnit r14 = TimeUnit.MILLISECONDS;
        r12.timeout(r13, r14);
        Http2Stream r15 = this.stream;
        Intrinsics.checkNotNull(r15);
        r15.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), r14);
        return;
    L13:
        Http2Stream r16 = this.stream;
        Intrinsics.checkNotNull(r16);
        r16.closeLater(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    L8:
        r10 = false;
        goto L9
    }
}
