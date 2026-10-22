package okhttp3.internal.http2;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "realConnection", "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/Interceptor$Chain;", "connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/Interceptor$Chain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "protocol", "Lokhttp3/Protocol;", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
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
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private final RealConnection realConnection;
    private volatile Http2Stream stream;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<Header> http2HeadersList(Request r6) {
            Intrinsics.checkParameterIsNotNull(r6, Ext.KEY_REQUEST);
            Headers r5 = r6.headers();
            ArrayList r0 = new ArrayList(r5.size() + 4);
            r0.add(new Header(Header.TARGET_METHOD, r6.method()));
            r0.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(r6.url())));
            String r1 = r6.header("Host");
            if (r1 == null) goto L5;
            r0.add(new Header(Header.TARGET_AUTHORITY, r1));
        L5:
            r0.add(new Header(Header.TARGET_SCHEME, r6.url().scheme()));
            int r7 = 0;
            int r2 = r5.size();
        L6:
            if (r7 >= r2) goto L20;
            String r3 = r5.name(r7);
            Locale r4 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(r4, "Locale.US");
            if (r3 == null) goto L18;
            String r8 = r3.toLowerCase(r4);
            Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.String).toLowerCase(locale)");
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(r8) == true) goto L12;
        L15:
            r0.add(new Header(r8, r5.value(r7)));
        L16:
            r7 = r7 + 1;
            goto L6
        L12:
            if (Intrinsics.areEqual(r8, Http2ExchangeCodec.TE) == false) goto L16;
            if (Intrinsics.areEqual(r5.value(r7), "trailers") == false) goto L16;
        L18:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L20:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        }

        public final Response.Builder readHttp2HeadersList(Headers r8, Protocol r9) {
            Intrinsics.checkParameterIsNotNull(r8, "headerBlock");
            Intrinsics.checkParameterIsNotNull(r9, "protocol");
            StatusLine r7 = (StatusLine) ZeusTransformUtils.preCheckCast(null, StatusLine.class, "com.obric.memorydata.plugin");
            Headers.Builder r0 = new Headers.Builder();
            int r2 = r8.size();
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L11;
            String r4 = r8.name(r3);
            String r5 = r8.value(r3);
            if (Intrinsics.areEqual(r4, Header.RESPONSE_STATUS_UTF8) == false) goto L8;
            r7 = StatusLine.Companion.parse("HTTP/1.1 " + r5);
        L10:
            r3 = r3 + 1;
            goto L3
        L8:
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(r4) == true) goto L10;
            r0.addLenient$okhttp(r4, r5);
            goto L10
        L11:
            if (r7 == null) goto L15;
            return new Response.Builder().protocol(r9).code(r7.code).message(r7.message).headers(r0.build());
        L15:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected ':status' header not present"), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    }

    public Http2ExchangeCodec(OkHttpClient r3, RealConnection r4, Interceptor.Chain r5, Http2Connection r6) {
        Interceptor.Chain r7 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "client");
        Intrinsics.checkParameterIsNotNull(r4, "realConnection");
        Intrinsics.checkParameterIsNotNull(r7, "chain");
        Intrinsics.checkParameterIsNotNull(r6, "connection");
        this.realConnection = r4;
        this.chain = r7;
        this.connection = r6;
        if (r3.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L5;
        Protocol r8 = Protocol.H2_PRIOR_KNOWLEDGE;
    L6:
        this.protocol = r8;
        return;
    L5:
        r8 = Protocol.HTTP_2;
        goto L6
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
        Http2Stream r1 = this.stream;
        if (r1 == null) goto L6;
        r1.closeLater(ErrorCode.CANCEL);
        return;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request r1, long r2) {
        Intrinsics.checkParameterIsNotNull(r1, Ext.KEY_REQUEST);
        Http2Stream r0 = this.stream;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream r0 = this.stream;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response r2) {
        Intrinsics.checkParameterIsNotNull(r2, ChatMessage.TYPE_RESPONSE);
        Http2Stream r1 = this.stream;
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return (Source) ZeusTransformUtils.preCheckCast(r1.getSource$okhttp(), Source.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean r3) {
        Http2Stream r0 = this.stream;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Headers r1 = r0.takeHeaders();
        Response.Builder r2 = Companion.readHttp2HeadersList(r1, this.protocol);
        if (r3 == true) goto L8;
        return r2;
    L8:
        if (r2.getCode$okhttp() != 100) goto L12;
        return null;
    L12:
        return r2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response r1) {
        Intrinsics.checkParameterIsNotNull(r1, ChatMessage.TYPE_RESPONSE);
        return Util.headersContentLength(r1);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        Http2Stream r0 = this.stream;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r4) {
        Intrinsics.checkParameterIsNotNull(r4, Ext.KEY_REQUEST);
        if (this.stream == null) goto L6;
        return;
    L6:
        if (r4.body() == null) goto L8;
        boolean r0 = true;
    L9:
        this.stream = this.connection.newStream(Companion.http2HeadersList(r4), r0);
        if (this.canceled == false) goto L16;
        Http2Stream r3 = this.stream;
        if (r3 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r3.closeLater(ErrorCode.CANCEL);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Canceled"), Throwable.class, "com.obric.memorydata.plugin"));
    L16:
        Http2Stream r5 = this.stream;
        if (r5 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r5.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        Http2Stream r6 = this.stream;
        if (r6 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        r6.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return;
    L8:
        r0 = false;
        goto L9
    }
}
