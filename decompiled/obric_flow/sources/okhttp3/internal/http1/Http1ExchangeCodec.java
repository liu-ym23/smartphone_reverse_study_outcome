package okhttp3.internal.http1;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import com.bytedance.common.wschannel.WsConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import nu.a0;
import nu.f0;
import nu.j;
import nu.k;
import nu.l;
import nu.q;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.r0;
import okhttp3.s0;
import sj.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 R2\u00020\u0001:\u0007STURVWXB)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010'\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0019\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0010H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u00101J\u0017\u00104\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u001c2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001cH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00132\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010FR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010GR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010KR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010LR\u0011\u0010M\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020)*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0018\u0010O\u001a\u00020)*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010Q¨\u0006Y"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/connection/RealConnection;", WsConstants.KEY_CONNECTION, "Lnu/l;", "source", "Lnu/k;", "sink", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lnu/l;Lnu/k;)V", "Lokhttp3/Request;", "request", "", "contentLength", "Lnu/a0;", "createRequestBody", "(Lokhttp3/Request;J)Lnu/a0;", "", "cancel", "()V", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/s0;", "response", "reportedContentLength", "(Lokhttp3/s0;)J", "Lnu/c0;", "openResponseBodySource", "(Lokhttp3/s0;)Lnu/c0;", "Lokhttp3/c0;", "trailers", "()Lokhttp3/c0;", "flushRequest", "finishRequest", "headers", "", "requestLine", "writeRequest", "(Lokhttp3/c0;Ljava/lang/String;)V", "", "expectContinue", "Lokhttp3/r0;", "readResponseHeaders", "(Z)Lokhttp3/r0;", "skipConnectBody", "(Lokhttp3/s0;)V", "newChunkedSink", "()Lnu/a0;", "newKnownLengthSink", "length", "newFixedLengthSource", "(J)Lnu/c0;", "Lokhttp3/e0;", "url", "newChunkedSource", "(Lokhttp3/e0;)Lnu/c0;", "newUnknownLengthSource", "()Lnu/c0;", "Lnu/q;", "timeout", "detachTimeout", "(Lnu/q;)V", "", "state", "I", "Lokhttp3/internal/http1/HeadersReader;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "Lokhttp3/c0;", "Lokhttp3/OkHttpClient;", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Lnu/l;", "Lnu/k;", "isClosed", "()Z", "isChunked", "(Lokhttp3/s0;)Z", "(Lokhttp3/Request;)Z", "Companion", "AbstractSource", "ChunkedSink", "ChunkedSource", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = null;
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final k sink;
    private final l source;
    private int state;
    private c0 trailers;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lnu/c0;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lnu/f0;", "timeout", "()Lnu/f0;", "Lnu/j;", "sink", "", "byteCount", "read", "(Lnu/j;J)J", "", "responseBodyComplete", "()V", "Lnu/q;", "Lnu/q;", "getTimeout", "()Lnu/q;", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public abstract class AbstractSource implements nu.c0 {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final q timeout;

        public AbstractSource(Http1ExchangeCodec r5) {
            this.this$0 = r5;
            this.timeout = new q(Http1ExchangeCodec.access$getSource$p(r5).timeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        public final boolean getClosed() {
            return this.closed;
        }

        public final q getTimeout() {
            return this.timeout;
        }

        @Override // nu.c0
        public long read(j r5, long r10) {
            Intrinsics.checkNotNullParameter(r5, "sink");
            return Http1ExchangeCodec.access$getSource$p(this.this$0).read(r5, r10);
        L5:
            e = move-exception;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            throw e;
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 6) goto L6;
            return;
        L6:
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 5) goto L10;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 6);
            return;
        L10:
            throw new IllegalStateException("state: " + Http1ExchangeCodec.access$getState$p(this.this$0));
        }

        public final void setClosed(boolean r5) {
            this.closed = r5;
        }

        @Override // nu.c0
        public f0 timeout() {
            return this.timeout;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lnu/a0;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lnu/f0;", "timeout", "()Lnu/f0;", "Lnu/j;", "source", "", "byteCount", "", "write", "(Lnu/j;J)V", "flush", "()V", "close", "Lnu/q;", "Lnu/q;", "", "closed", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ChunkedSink implements a0 {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final q timeout;

        public ChunkedSink(Http1ExchangeCodec r5) {
            this.this$0 = r5;
            this.timeout = new q(Http1ExchangeCodec.access$getSink$p(r5).timeout());
        }

        @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
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
            Http1ExchangeCodec.access$getSink$p(this.this$0).l("0\r\n\r\n");     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // nu.a0, java.io.Flushable
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

        @Override // nu.a0
        public f0 timeout() {
            return this.timeout;
        }

        @Override // nu.a0
        public void write(j r5, long r10) {
            Intrinsics.checkNotNullParameter(r5, "source");
            if (this.closed == true) goto L10;
            if (r10 != 0) goto L7;
            return;
        L7:
            Http1ExchangeCodec.access$getSink$p(this.this$0).B(r10);
            Http1ExchangeCodec.access$getSink$p(this.this$0).l("\r\n");
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r5, r10);
            Http1ExchangeCodec.access$getSink$p(this.this$0).l("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/e0;", "url", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/e0;)V", "", "readChunkSize", "()V", "Lnu/j;", "sink", "", "byteCount", "read", "(Lnu/j;J)J", "close", "bytesRemainingInChunk", "J", "", "hasMoreChunks", "Z", "Lokhttp3/e0;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final e0 url;

        public ChunkedSource(Http1ExchangeCodec r5, e0 r10) {
            Intrinsics.checkNotNullParameter(r10, "url");
            this.this$0 = r5;
            super(r5);
            this.url = r10;
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk == (-1)) goto L22;
            Http1ExchangeCodec.access$getSource$p(this.this$0).o();
        L22:
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).H();     // Catch: NumberFormatException -> L12
            String r5 = StringsKt.trim(Http1ExchangeCodec.access$getSource$p(this.this$0).o()).toString();     // Catch: NumberFormatException -> L12
            if (this.bytesRemainingInChunk < 0) goto L19;
            if (r5.length() <= 0) goto L15;
            if (StringsKt.P(r5, ";") == false) goto L19;
        L15:
            if (this.bytesRemainingInChunk != 0) goto L24;
            this.hasMoreChunks = false;
            Http1ExchangeCodec r10 = this.this$0;
            Http1ExchangeCodec.access$setTrailers$p(r10, Http1ExchangeCodec.access$getHeadersReader$p(r10).readHeaders());
            OkHttpClient r11 = Http1ExchangeCodec.access$getClient$p(this.this$0);
            Intrinsics.checkNotNull(r11);
            e r12 = r11.f20592j;
            e0 r13 = this.url;
            c0 r14 = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
            Intrinsics.checkNotNull(r14);
            HttpHeaders.receiveHeaders(r12, r13, r14);
            responseBodyComplete();
            return;
        L24:
            return;
        L19:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r5 + Typography.quote);     // Catch: NumberFormatException -> L12
        L12:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.hasMoreChunks == true) goto L8;
        L10:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, nu.c0
        public long read(j r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (r11 < 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L28;
            if (getClosed() == true) goto L26;
            if (this.hasMoreChunks == true) goto L12;
            return -1;
        L12:
            long r12 = this.bytesRemainingInChunk;
            if (r12 != 0) goto L15;
        L16:
            readChunkSize();
            if (this.hasMoreChunks == true) goto L19;
            return -1;
        L19:
            long r13 = super.read(r10, Math.min(r11, this.bytesRemainingInChunk));
            if (r13 == (-1)) goto L23;
            this.bytesRemainingInChunk -= r13;
            return r13;
        L23:
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException r14 = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw r14;
        L15:
            if (r12 != (-1)) goto L19;
        L26:
            throw new IllegalStateException("closed");
        L28:
            throw new IllegalArgumentException(a.j(r11, "byteCount < 0: ").toString());
        L5:
            r5 = false;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "NO_CHUNK_YET", "", "STATE_CLOSED", "", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "", "bytesRemaining", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "Lnu/j;", "sink", "byteCount", "read", "(Lnu/j;J)J", "", "close", "()V", "J", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public FixedLengthSource(Http1ExchangeCodec r5, long r10) {
            this.this$0 = r5;
            super(r5);
            this.bytesRemaining = r10;
            if (r10 != 0) goto L6;
            responseBodyComplete();
            return;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.bytesRemaining != 0) goto L8;
        L10:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, nu.c0
        public long read(j r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (r11 < 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L23;
            if (getClosed() == true) goto L21;
            long r12 = this.bytesRemaining;
            if (r12 != 0) goto L12;
            return -1;
        L12:
            long r13 = super.read(r10, Math.min(r12, r11));
            if (r13 == (-1)) goto L18;
            long r14 = this.bytesRemaining - r13;
            this.bytesRemaining = r14;
            if (r14 != 0) goto L17;
            responseBodyComplete();
        L17:
            return r13;
        L18:
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException r15 = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw r15;
        L21:
            throw new IllegalStateException("closed");
        L23:
            throw new IllegalArgumentException(a.j(r11, "byteCount < 0: ").toString());
        L5:
            r5 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lnu/a0;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lnu/f0;", "timeout", "()Lnu/f0;", "Lnu/j;", "source", "", "byteCount", "", "write", "(Lnu/j;J)V", "flush", "()V", "close", "Lnu/q;", "Lnu/q;", "", "closed", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class KnownLengthSink implements a0 {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final q timeout;

        public KnownLengthSink(Http1ExchangeCodec r5) {
            this.this$0 = r5;
            this.timeout = new q(Http1ExchangeCodec.access$getSink$p(r5).timeout());
        }

        @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);
        }

        @Override // nu.a0, java.io.Flushable
        public void flush() {
            if (this.closed == false) goto L5;
            return;
        L5:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
        }

        @Override // nu.a0
        public f0 timeout() {
            return this.timeout;
        }

        @Override // nu.a0
        public void write(j r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            if (this.closed == true) goto L7;
            Util.checkOffsetAndCount(r10.f20328b, 0, r11);
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r10, r11);
            return;
        L7:
            throw new IllegalStateException("closed");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lnu/j;", "sink", "", "byteCount", "read", "(Lnu/j;J)J", "", "close", "()V", "", "inputExhausted", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public UnknownLengthSource(Http1ExchangeCodec r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.inputExhausted == true) goto L8;
            responseBodyComplete();
        L8:
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, nu.c0
        public long read(j r5, long r10) {
            Intrinsics.checkNotNullParameter(r5, "sink");
            if (r10 < 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            if (getClosed() == true) goto L18;
            if (this.inputExhausted == false) goto L12;
            return -1;
        L12:
            long r12 = super.read(r5, r10);
            if (r12 != (-1)) goto L16;
            this.inputExhausted = true;
            responseBodyComplete();
            return -1;
        L16:
            return r12;
        L18:
            throw new IllegalStateException("closed");
        L20:
            throw new IllegalArgumentException(a.j(r10, "byteCount < 0: ").toString());
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http1ExchangeCodec(OkHttpClient r5, RealConnection r10, l r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "sink");
        this.client = r5;
        this.connection = r10;
        this.source = r11;
        this.sink = r12;
        this.headersReader = new HeadersReader(r11);
    }

    public static final /* synthetic */ void access$detachTimeout(Http1ExchangeCodec r5, q r10) {
        r5.detachTimeout(r10);
    }

    public static final /* synthetic */ OkHttpClient access$getClient$p(Http1ExchangeCodec r5) {
        return r5.client;
    }

    public static final /* synthetic */ HeadersReader access$getHeadersReader$p(Http1ExchangeCodec r5) {
        return r5.headersReader;
    }

    public static final /* synthetic */ k access$getSink$p(Http1ExchangeCodec r5) {
        return r5.sink;
    }

    public static final /* synthetic */ l access$getSource$p(Http1ExchangeCodec r5) {
        return r5.source;
    }

    public static final /* synthetic */ int access$getState$p(Http1ExchangeCodec r5) {
        return r5.state;
    }

    public static final /* synthetic */ c0 access$getTrailers$p(Http1ExchangeCodec r5) {
        return r5.trailers;
    }

    public static final /* synthetic */ void access$setState$p(Http1ExchangeCodec r5, int r10) {
        r5.state = r10;
    }

    public static final /* synthetic */ void access$setTrailers$p(Http1ExchangeCodec r5, c0 r10) {
        r5.trailers = r10;
    }

    private final void detachTimeout(q r5) {
        f0 r10 = r5.f20332a;
        f0 r11 = f0.NONE;
        Intrinsics.checkNotNullParameter(r11, "delegate");
        r5.f20332a = r11;
        r10.clearDeadline();
        r10.clearTimeout();
    }

    private final boolean isChunked(Request r5) {
        return StringsKt.l("chunked", r5.header("Transfer-Encoding"));
    }

    private final a0 newChunkedSink() {
        boolean r5 = true;
        if (this.state == 1) goto L6;
        r5 = false;
    L6:
        if (r5 == false) goto L10;
        this.state = 2;
        return new ChunkedSink(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final nu.c0 newChunkedSource(e0 r5) {
        if (this.state != 4) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.state = 5;
        return new ChunkedSource(this, r5);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r10 = false;
        goto L6
    }

    private final nu.c0 newFixedLengthSource(long r5) {
        if (this.state != 4) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.state = 5;
        return new FixedLengthSource(this, r5);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r10 = false;
        goto L6
    }

    private final a0 newKnownLengthSink() {
        boolean r5 = true;
        if (this.state == 1) goto L6;
        r5 = false;
    L6:
        if (r5 == false) goto L10;
        this.state = 2;
        return new KnownLengthSink(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final nu.c0 newUnknownLengthSource() {
        if (this.state != 4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r5 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public a0 createRequestBody(Request r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (r5.body() == null) goto L10;
        if (r5.body().isDuplex() == false) goto L10;
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    L10:
        if (isChunked(r5) == false) goto L13;
        return newChunkedSink();
    L13:
        if (r10 == (-1)) goto L17;
        return newKnownLengthSink();
    L17:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public nu.c0 openResponseBodySource(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        if (HttpHeaders.promisesBody(r5) == true) goto L6;
        return newFixedLengthSource(0);
    L6:
        if (isChunked(r5) == true) goto L14;
        long r10 = Util.headersContentLength(r5);
        if (r10 == (-1)) goto L12;
        return newFixedLengthSource(r10);
    L12:
        return newUnknownLengthSource();
    L14:
        return newChunkedSource(r5.f20746b.url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public r0 readResponseHeaders(boolean r10) {
        int r5 = this.state;
        if (r5 == 1) goto L22;
        if (r5 == 3) goto L22;
        throw new IllegalStateException(("state: " + this.state).toString());
    L22:
        StatusLine r11 = StatusLine.Companion.parse(this.headersReader.readLine());     // Catch: EOFException -> L13
        r0 r12 = new r0();     // Catch: EOFException -> L13
        r12.d(r11.protocol);     // Catch: EOFException -> L13
        r12.f20737c = r11.code;     // Catch: EOFException -> L13
        String r13 = r11.message;     // Catch: EOFException -> L13
        Intrinsics.checkNotNullParameter(r13, "message");     // Catch: EOFException -> L13
        r12.d = r13;     // Catch: EOFException -> L13
        r12.c(this.headersReader.readHeaders());     // Catch: EOFException -> L13
        if (r10 == false) goto L16;
        if (r11.code != 100) goto L16;
        return null;
    L16:
        if (r11.code != 100) goto L18;
        this.state = 3;     // Catch: EOFException -> L13
        return r12;
    L18:
        this.state = 4;     // Catch: EOFException -> L13
        return r12;
    L13:
        e = move-exception;
        throw new IOException(j0.C("unexpected end of stream on ", getConnection().route().f20764a.f20610a.i()), e);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        if (HttpHeaders.promisesBody(r5) == true) goto L6;
        return 0;
    L6:
        if (isChunked(r5) == false) goto L9;
        return -1;
    L9:
        return Util.headersContentLength(r5);
    }

    public final void skipConnectBody(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        long r10 = Util.headersContentLength(r5);
        if (r10 != (-1)) goto L5;
        return;
    L5:
        nu.c0 r11 = newFixedLengthSource(r10);
        Util.skipAll(r11, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r11.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public c0 trailers() {
        if (this.state != 6) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L13;
        c0 r10 = this.trailers;
        if (r10 == null) goto L11;
        return r10;
    L11:
        return Util.EMPTY_HEADERS;
    L13:
        throw new IllegalStateException("too early; can't read the trailers yet");
    L5:
        r5 = false;
        goto L6
    }

    public final void writeRequest(c0 r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "headers");
        Intrinsics.checkNotNullParameter(r10, "requestLine");
        if (this.state != 0) goto L10;
        this.sink.l(r10).l("\r\n");
        int r11 = r5.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        this.sink.l(r5.c(r12)).l(": ").l(r5.e(r12)).l("\r\n");
        r12 = r12 + 1;
        goto L5
    L7:
        this.sink.l("\r\n");
        this.state = 1;
        return;
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        String r10 = RequestLine.INSTANCE.get(r5, getConnection().route().f20765b.type());
        writeRequest(r5.headers(), r10);
    }

    private final boolean isChunked(s0 r5) {
        return StringsKt.l("chunked", r5.d("Transfer-Encoding", null));
    }
}
