package okhttp3.internal.http1;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.Address;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 =2\u00020\u0001:\u0007:;<=>?@B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0013H\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u000eH\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u00104\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020.J\u0010\u00108\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\f\u00109\u001a\u00020\u000e*\u00020\u001aH\u0002J\f\u00109\u001a\u00020\u000e*\u00020,H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "realConnection", "Lokhttp3/internal/connection/RealConnection;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "headerLimit", "", "isClosed", "", "()Z", "state", "", "trailers", "Lokhttp3/Headers;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", WsConstants.KEY_CONNECTION, "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "contentLength", "detachTimeout", LocationMonitorConst.TIMEOUT, "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", XSDatatype.FACET_LENGTH, "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "readHeaderLine", "", "readHeaders", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "writeRequestHeaders", "isChunked", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = null;
    private static final int HEADER_LIMIT = 262144;
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private long headerLimit;
    private final RealConnection realConnection;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¢\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\b\u0010\t\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", LocationMonitorConst.TIMEOUT, "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "responseBodyComplete", "", "responseBodyComplete$okhttp", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 1, 15})
    private abstract class AbstractSource implements Source {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public AbstractSource(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p(r2).timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(Buffer r2, long r3) {
            Intrinsics.checkParameterIsNotNull(r2, "sink");
            return Http1ExchangeCodec.access$getSource$p(this.this$0).read(r2, r3);
        L5:
            e = move-exception;
            RealConnection r4 = Http1ExchangeCodec.access$getRealConnection$p(this.this$0);
            if (r4 != null) goto L9;
            Intrinsics.throwNpe();
        L9:
            r4.noNewExchanges();
            responseBodyComplete$okhttp();
            throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void responseBodyComplete$okhttp() {
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 6) goto L6;
            return;
        L6:
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 5) goto L10;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 6);
            return;
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("state: " + Http1ExchangeCodec.access$getState$p(this.this$0)), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return (Timeout) ZeusTransformUtils.preCheckCast(this.timeout, Timeout.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", LocationMonitorConst.TIMEOUT, "Lokio/ForwardingTimeout;", IslandSession.REOPEN_VALUE_CLOSE, "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "Lokio/Timeout;", "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public ChunkedSink(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.closed = true;     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("0\r\n\r\n");     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return (Timeout) ZeusTransformUtils.preCheckCast(this.timeout, Timeout.class, "com.obric.memorydata.plugin");
        }

        @Override // okio.Sink
        public void write(Buffer r3, long r4) {
            Intrinsics.checkParameterIsNotNull(r3, AILabCheckPermissionTask.KEY_SOURCE);
            if ((!this.closed) == false) goto L10;
            if (r4 != 0) goto L7;
            return;
        L7:
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeHexadecimalUnsignedLong(r4);
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r3, r4);
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
            return;
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lokhttp3/HttpUrl;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", "", "hasMoreChunks", "", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "sink", "Lokio/Buffer;", "byteCount", "readChunkSize", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        public ChunkedSource(Http1ExchangeCodec r2, HttpUrl r3) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            this.this$0 = r2;
            super(r2);
            this.url = r3;
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk == (-1)) goto L33;
            Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();
        L33:
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).readHexadecimalUnsignedLong();     // Catch: NumberFormatException -> L30
            String r1 = Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();     // Catch: NumberFormatException -> L30
            if (r1 == null) goto L29;
            String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: NumberFormatException -> L30
            if (this.bytesRemainingInChunk < 0) goto L27;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L17;
            if (StringsKt.startsWith$default(r2, ";", false, 2, null) == false) goto L27;
        L17:
            if (this.bytesRemainingInChunk != 0) goto L34;
            this.hasMoreChunks = false;
            Http1ExchangeCodec r0 = this.this$0;
            Http1ExchangeCodec.access$setTrailers$p(r0, Http1ExchangeCodec.access$readHeaders(r0));
            OkHttpClient r4 = Http1ExchangeCodec.access$getClient$p(this.this$0);
            if (r4 != null) goto L21;
            Intrinsics.throwNpe();
        L21:
            CookieJar r5 = r4.cookieJar();
            HttpUrl r6 = this.url;
            Headers r7 = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
            if (r7 != null) goto L24;
            Intrinsics.throwNpe();
        L24:
            HttpHeaders.receiveHeaders(r5, r6, r7);
            responseBodyComplete$okhttp();
            return;
        L34:
            return;
        L12:
            r3 = false;
        L27:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r2 + Typography.quote), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L30
        L29:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: NumberFormatException -> L30
        L30:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException(e.getMessage()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.hasMoreChunks == true) goto L8;
        L13:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L13;
            RealConnection r0 = Http1ExchangeCodec.access$getRealConnection$p(this.this$0);
            if (r0 != null) goto L12;
            Intrinsics.throwNpe();
        L12:
            r0.noNewExchanges();
            responseBodyComplete$okhttp();
            goto L13
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r8, long r9) {
            Intrinsics.checkParameterIsNotNull(r8, "sink");
            if (r9 < 0) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L32;
            if ((!getClosed()) == false) goto L30;
            if (this.hasMoreChunks == true) goto L13;
            return -1;
        L13:
            long r3 = this.bytesRemainingInChunk;
            if (r3 != 0) goto L16;
        L17:
            readChunkSize();
            if (this.hasMoreChunks == true) goto L20;
            return -1;
        L20:
            long r10 = super.read(r8, Math.min(r9, this.bytesRemainingInChunk));
            if (r10 != (-1)) goto L27;
            RealConnection r11 = Http1ExchangeCodec.access$getRealConnection$p(this.this$0);
            if (r11 != null) goto L25;
            Intrinsics.throwNpe();
        L25:
            r11.noNewExchanges();
            ProtocolException r12 = new ProtocolException("unexpected end of stream");
            responseBodyComplete$okhttp();
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r12, Throwable.class, "com.obric.memorydata.plugin"));
        L27:
            this.bytesRemainingInChunk -= r10;
            return r10;
        L16:
            if (r3 != (-1)) goto L20;
        L30:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L32:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r9).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r2 = false;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "HEADER_LIMIT", "", "NO_CHUNK_YET", "", "STATE_CLOSED", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "bytesRemaining", "", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public FixedLengthSource(Http1ExchangeCodec r3, long r4) {
            this.this$0 = r3;
            super(r3);
            this.bytesRemaining = r4;
            if (r4 != 0) goto L6;
            responseBodyComplete$okhttp();
            return;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.bytesRemaining != 0) goto L8;
        L13:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L13;
            RealConnection r0 = Http1ExchangeCodec.access$getRealConnection$p(this.this$0);
            if (r0 != null) goto L12;
            Intrinsics.throwNpe();
        L12:
            r0.noNewExchanges();
            responseBodyComplete$okhttp();
            goto L13
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r9, long r10) {
            Intrinsics.checkParameterIsNotNull(r9, "sink");
            if (r10 < 0) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L27;
            if ((!getClosed()) == false) goto L25;
            long r3 = this.bytesRemaining;
            if (r3 != 0) goto L13;
            return -1;
        L13:
            long r11 = super.read(r9, Math.min(r3, r10));
            if (r11 != (-1)) goto L20;
            RealConnection r12 = Http1ExchangeCodec.access$getRealConnection$p(this.this$0);
            if (r12 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            r12.noNewExchanges();
            ProtocolException r13 = new ProtocolException("unexpected end of stream");
            responseBodyComplete$okhttp();
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r13, Throwable.class, "com.obric.memorydata.plugin"));
        L20:
            long r4 = this.bytesRemaining - r11;
            this.bytesRemaining = r4;
            if (r4 != 0) goto L23;
            responseBodyComplete$okhttp();
        L23:
            return r11;
        L25:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L27:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r10).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r2 = false;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", LocationMonitorConst.TIMEOUT, "Lokio/ForwardingTimeout;", IslandSession.REOPEN_VALUE_CLOSE, "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "Lokio/Timeout;", "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class KnownLengthSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public KnownLengthSink(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed == false) goto L5;
            return;
        L5:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return (Timeout) ZeusTransformUtils.preCheckCast(this.timeout, Timeout.class, "com.obric.memorydata.plugin");
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) {
            Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
            if ((!this.closed) == false) goto L7;
            Util.checkOffsetAndCount(r8.size(), 0, r9);
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r8, r9);
            return;
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "inputExhausted", "", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public UnknownLengthSource(Http1ExchangeCodec r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.inputExhausted == true) goto L8;
            responseBodyComplete$okhttp();
        L8:
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r5, long r6) {
            Intrinsics.checkParameterIsNotNull(r5, "sink");
            if (r6 < 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L21;
            if ((!getClosed()) == false) goto L19;
            if (this.inputExhausted == false) goto L13;
            return -1;
        L13:
            long r7 = super.read(r5, r6);
            if (r7 != (-1)) goto L17;
            this.inputExhausted = true;
            responseBodyComplete$okhttp();
            return -1;
        L17:
            return r7;
        L19:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L21:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http1ExchangeCodec(OkHttpClient r3, RealConnection r4, BufferedSource r5, BufferedSink r6) {
        BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r5, BufferedSource.class, "com.obric.memorydata.plugin");
        BufferedSink r8 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r8, "sink");
        this.client = r3;
        this.realConnection = r4;
        this.source = r7;
        this.sink = r8;
        this.headerLimit = 262144;
    }

    public static final /* synthetic */ void access$detachTimeout(Http1ExchangeCodec r0, ForwardingTimeout r1) {
        r0.detachTimeout(r1);
    }

    public static final /* synthetic */ OkHttpClient access$getClient$p(Http1ExchangeCodec r0) {
        return r0.client;
    }

    public static final /* synthetic */ RealConnection access$getRealConnection$p(Http1ExchangeCodec r0) {
        return r0.realConnection;
    }

    public static final /* synthetic */ BufferedSink access$getSink$p(Http1ExchangeCodec r0) {
        return r0.sink;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(Http1ExchangeCodec r0) {
        return r0.source;
    }

    public static final /* synthetic */ int access$getState$p(Http1ExchangeCodec r0) {
        return r0.state;
    }

    public static final /* synthetic */ Headers access$getTrailers$p(Http1ExchangeCodec r0) {
        return r0.trailers;
    }

    public static final /* synthetic */ Headers access$readHeaders(Http1ExchangeCodec r0) {
        return r0.readHeaders();
    }

    public static final /* synthetic */ void access$setState$p(Http1ExchangeCodec r0, int r1) {
        r0.state = r1;
    }

    public static final /* synthetic */ void access$setTrailers$p(Http1ExchangeCodec r0, Headers r1) {
        r0.trailers = r1;
    }

    private final void detachTimeout(ForwardingTimeout r2) {
        Timeout r1 = r2.delegate();
        r2.setDelegate(Timeout.NONE);
        r1.clearDeadline();
        r1.clearTimeout();
    }

    private final boolean isChunked(Request r2) {
        return StringsKt.equals("chunked", r2.header("Transfer-Encoding"), true);
    }

    private final boolean isChunked(Response r3) {
        return StringsKt.equals("chunked", Response.header$default(r3, "Transfer-Encoding", null, 2, null), true);
    }

    private final Sink newChunkedSink() {
        boolean r1 = true;
        if (this.state == 1) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L11;
        this.state = 2;
        return (Sink) ZeusTransformUtils.preCheckCast(new ChunkedSink(this), Sink.class, "com.obric.memorydata.plugin");
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final Source newChunkedSource(HttpUrl r3) {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        this.state = 5;
        return (Source) ZeusTransformUtils.preCheckCast(new ChunkedSource(this, r3), Source.class, "com.obric.memorydata.plugin");
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    private final Source newFixedLengthSource(long r3) {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        this.state = 5;
        return (Source) ZeusTransformUtils.preCheckCast(new FixedLengthSource(this, r3), Source.class, "com.obric.memorydata.plugin");
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    private final Sink newKnownLengthSink() {
        boolean r1 = true;
        if (this.state == 1) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L11;
        this.state = 2;
        return (Sink) ZeusTransformUtils.preCheckCast(new KnownLengthSink(this), Sink.class, "com.obric.memorydata.plugin");
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final Source newUnknownLengthSource() {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L14;
        this.state = 5;
        RealConnection r1 = this.realConnection;
        if (r1 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r1.noNewExchanges();
        return (Source) ZeusTransformUtils.preCheckCast(new UnknownLengthSource(this), Source.class, "com.obric.memorydata.plugin");
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    private final String readHeaderLine() {
        String r0 = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) r0.length();
        return r0;
    }

    private final Headers readHeaders() {
        Headers.Builder r0 = new Headers.Builder();
    L3:
        String r1 = readHeaderLine();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L10;
        r0.addLenient$okhttp(r1);
        goto L3
    L10:
        return r0.build();
    L6:
        r2 = false;
        goto L7
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        RealConnection r0 = this.realConnection;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request r5, long r6) {
        Intrinsics.checkParameterIsNotNull(r5, Ext.KEY_REQUEST);
        if (r5.body() == null) goto L10;
        if (r5.body().isDuplex() == false) goto L10;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Duplex connections are not supported for HTTP/1"), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        if (isChunked(r5) == false) goto L13;
        return newChunkedSink();
    L13:
        if (r6 == (-1)) goto L17;
        return newKnownLengthSink();
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    public final boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response r5) {
        Intrinsics.checkParameterIsNotNull(r5, ChatMessage.TYPE_RESPONSE);
        if (HttpHeaders.promisesBody(r5) == true) goto L7;
        long r0 = 0;
    L14:
        return newFixedLengthSource(r0);
    L7:
        if (isChunked(r5) == true) goto L15;
        r0 = Util.headersContentLength(r5);
        if (r0 != (-1)) goto L14;
        return newUnknownLengthSource();
    L15:
        return newChunkedSource(r5.request().url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean r6) {
        int r0 = this.state;
        boolean r2 = true;
        if (r0 == 1) goto L8;
        if (r0 == 3) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L35;
        StatusLine r3 = StatusLine.Companion.parse(readHeaderLine());     // Catch: EOFException -> L19
        Response.Builder r4 = new Response.Builder().protocol(r3.protocol).code(r3.code).message(r3.message).headers(readHeaders());     // Catch: EOFException -> L19
        if (r6 == false) goto L15;
        if (r3.code != 100) goto L15;
        return null;
    L15:
        if (r3.code != 100) goto L17;
        this.state = 3;     // Catch: EOFException -> L19
        return r4;
    L17:
        this.state = 4;     // Catch: EOFException -> L19
        return r4;
    L19:
        e = move-exception;
        RealConnection r5 = this.realConnection;
        if (r5 == null) goto L31;
        Route r7 = r5.route();
        if (r7 == null) goto L31;
        Address r8 = r7.address();
        if (r8 == null) goto L31;
        HttpUrl r9 = r8.url();
        if (r9 == null) goto L31;
        String r10 = r9.redact();
        if (r10 == null) goto L31;
    L33:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unexpected end of stream on " + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L31:
        r10 = "unknown";
        goto L33
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response r2) {
        Intrinsics.checkParameterIsNotNull(r2, ChatMessage.TYPE_RESPONSE);
        if (HttpHeaders.promisesBody(r2) == true) goto L6;
        return 0;
    L6:
        if (isChunked(r2) == false) goto L9;
        return -1;
    L9:
        return Util.headersContentLength(r2);
    }

    public final void skipConnectBody(Response r5) {
        Intrinsics.checkParameterIsNotNull(r5, ChatMessage.TYPE_RESPONSE);
        long r0 = Util.headersContentLength(r5);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        Source r4 = newFixedLengthSource(r0);
        Util.skipAll(r4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r4.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        if (this.state != 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        Headers r2 = this.trailers;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return Util.EMPTY_HEADERS;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("too early; can't read the trailers yet".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public final void writeRequest(Headers r6, String r7) {
        Intrinsics.checkParameterIsNotNull(r6, "headers");
        Intrinsics.checkParameterIsNotNull(r7, "requestLine");
        int r1 = 0;
        if (this.state != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        this.sink.writeUtf8(r7).writeUtf8("\r\n");
        int r8 = r6.size();
    L8:
        if (r1 >= r8) goto L10;
        this.sink.writeUtf8(r6.name(r1)).writeUtf8(": ").writeUtf8(r6.value(r1)).writeUtf8("\r\n");
        r1 = r1 + 1;
        goto L8
    L10:
        this.sink.writeUtf8("\r\n");
        this.state = 1;
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("state: " + this.state).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r4) {
        Intrinsics.checkParameterIsNotNull(r4, Ext.KEY_REQUEST);
        RequestLine r0 = RequestLine.INSTANCE;
        RealConnection r1 = this.realConnection;
        if (r1 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Proxy.Type r2 = r1.route().proxy().type();
        Intrinsics.checkExpressionValueIsNotNull(r2, "realConnection!!.route().proxy.type()");
        String r3 = r0.get(r4, r2);
        writeRequest(r4.headers(), r3);
    }
}
