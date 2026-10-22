package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import f4.b;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.a0;
import nu.c0;
import nu.j;
import nu.o;
import nu.p;
import okhttp3.Request;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.q0;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0002QRB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u000e¢\u0006\u0004\b/\u0010\u001bJ\r\u00100\u001a\u00020\u000e¢\u0006\u0004\b0\u0010\u001bJ\r\u00101\u001a\u00020\u000e¢\u0006\u0004\b1\u0010\u001bJ\r\u00102\u001a\u00020\u000e¢\u0006\u0004\b2\u0010\u001bJ9\u00108\u001a\u00028\u0000\"\n\b\u0000\u00103*\u0004\u0018\u00010\f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00152\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u000e¢\u0006\u0004\b:\u0010\u001bR$\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010NR\u0014\u0010P\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010?¨\u0006S"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/w;", "eventListener", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/w;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "Ljava/io/IOException;", "e", "", "trackFailure", "(Ljava/io/IOException;)V", "Lokhttp3/Request;", "request", "writeRequestHeaders", "(Lokhttp3/Request;)V", "", "duplex", "Lnu/a0;", "createRequestBody", "(Lokhttp3/Request;Z)Lnu/a0;", "flushRequest", "()V", "finishRequest", "responseHeadersStart", "expectContinue", "Lokhttp3/r0;", "readResponseHeaders", "(Z)Lokhttp3/r0;", "Lokhttp3/s0;", "response", "responseHeadersEnd", "(Lokhttp3/s0;)V", "Lokhttp3/w0;", "openResponseBody", "(Lokhttp3/s0;)Lokhttp3/w0;", "Lokhttp3/c0;", "trailers", "()Lokhttp3/c0;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "webSocketUpgradeFailed", "noNewExchangesOnConnection", "cancel", "detachWithViolence", ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "noRequestBody", "<set-?>", "isDuplex", "Z", "isDuplex$okhttp", "()Z", "Lokhttp3/internal/connection/RealConnection;", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/w;", "getEventListener$okhttp", "()Lokhttp3/w;", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/internal/http/ExchangeCodec;", "isCoalescedConnection$okhttp", "isCoalescedConnection", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final w eventListener;
    private final ExchangeFinder finder;
    private boolean isDuplex;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u0000\"\n\b\u0000\u0010\t*\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001a¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lnu/o;", "Lnu/a0;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lnu/a0;J)V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lnu/j;", "source", "byteCount", "", "write", "(Lnu/j;J)V", "flush", "()V", "close", "", "completed", "Z", "bytesReceived", "J", "closed", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RequestBodySink extends o {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        public RequestBodySink(Exchange r5, a0 r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "delegate");
            this.this$0 = r5;
            super(r10);
            this.contentLength = r11;
        }

        private final <E extends IOException> E complete(E r10) {
            if (this.completed == false) goto L5;
            return r10;
        L5:
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, r10);
        }

        @Override // nu.o, nu.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            long r5 = this.contentLength;
            if (r5 != (-1)) goto L8;
        L17:
            super.close();     // Catch: IOException -> L14
            complete(null);     // Catch: IOException -> L14
            return;
        L14:
            e = move-exception;
            throw complete(e);
        L8:
            if (this.bytesReceived == r5) goto L17;
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // nu.o, nu.a0, java.io.Flushable
        public void flush() throws IOException {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw complete(e);
        }

        @Override // nu.o, nu.a0
        public void write(j r5, long r10) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "source");
            if (this.closed == true) goto L17;
            long r11 = this.contentLength;
            if (r11 != (-1)) goto L7;
        L18:
            super.write(r5, r10);     // Catch: IOException -> L13
            this.bytesReceived += r10;     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw complete(e);
        L7:
            if ((this.bytesReceived + r10) <= r11) goto L18;
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + r10));
        L17:
            throw new IllegalStateException("closed");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00028\u0000\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lnu/p;", "Lnu/c0;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lnu/c0;J)V", "Lnu/j;", "sink", "byteCount", "read", "(Lnu/j;J)J", "", "close", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "bytesReceived", "J", "", "invokeStartEvent", "Z", "completed", "closed", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ResponseBodySource extends p {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        public ResponseBodySource(Exchange r5, c0 r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "delegate");
            this.this$0 = r5;
            super(r10);
            this.contentLength = r11;
            this.invokeStartEvent = true;
            if (r11 != 0) goto L6;
            complete(null);
            return;
        }

        @Override // nu.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            super.close();     // Catch: IOException -> L8
            complete(null);     // Catch: IOException -> L8
            return;
        L8:
            e = move-exception;
            throw complete(e);
        }

        public final <E extends IOException> E complete(E r10) {
            if (this.completed == false) goto L5;
            return r10;
        L5:
            this.completed = true;
            if (r10 != null) goto L11;
            if (this.invokeStartEvent == false) goto L11;
            this.invokeStartEvent = false;
            this.this$0.getEventListener$okhttp().d(this.this$0.getCall$okhttp());
        L11:
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, r10);
        }

        @Override // nu.p, nu.c0
        public long read(j r10, long r11) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (this.closed == true) goto L27;
            long r12 = delegate().read(r10, r11);     // Catch: IOException -> L7
            if (this.invokeStartEvent == false) goto L10;
            this.invokeStartEvent = false;     // Catch: IOException -> L7
            this.this$0.getEventListener$okhttp().d(this.this$0.getCall$okhttp());     // Catch: IOException -> L7
        L10:
            if (r12 != (-1)) goto L13;
            complete(null);     // Catch: IOException -> L7
            return -1;
        L13:
            long r5 = this.bytesReceived + r12;     // Catch: IOException -> L7
            long r13 = this.contentLength;     // Catch: IOException -> L7
            if (r13 != (-1)) goto L16;
        L20:
            this.bytesReceived = r5;     // Catch: IOException -> L7
            if (r5 != r13) goto L23;
            complete(null);     // Catch: IOException -> L7
        L23:
            return r12;
        L16:
            if (r5 <= r13) goto L20;
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + r5);     // Catch: IOException -> L7
        L7:
            e = move-exception;
            throw complete(e);
        L27:
            throw new IllegalStateException("closed");
        }
    }

    public Exchange(RealCall r5, w r10, ExchangeFinder r11, ExchangeCodec r12) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "eventListener");
        Intrinsics.checkNotNullParameter(r11, "finder");
        Intrinsics.checkNotNullParameter(r12, "codec");
        this.call = r5;
        this.eventListener = r10;
        this.finder = r11;
        this.codec = r12;
        this.connection = r12.getConnection();
    }

    private final void trackFailure(IOException r5) {
        this.finder.trackFailure(r5);
        this.codec.getConnection().trackFailure$okhttp(this.call, r5);
    }

    public final <E extends IOException> E bodyComplete(long r5, boolean r10, boolean r11, E r12) {
        if (r12 == null) goto L5;
        trackFailure(r12);
    L5:
        if (r11 == false) goto L9;
        if (r12 == null) goto L8;
        w r13 = this.eventListener;
        RealCall r14 = this.call;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "ioe");
        goto L9
    L8:
        w r15 = this.eventListener;
        RealCall r16 = this.call;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, NotificationCompat.CATEGORY_CALL);
    L9:
        if (r10 == false) goto L14;
        if (r12 == null) goto L12;
        w r17 = this.eventListener;
        RealCall r18 = this.call;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "ioe");
        goto L14
    L12:
        w r19 = this.eventListener;
        RealCall r20 = this.call;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, NotificationCompat.CATEGORY_CALL);
    L14:
        return (E) this.call.messageDone$okhttp(this, r11, r10, r12);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final a0 createRequestBody(Request r5, boolean r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.isDuplex = r10;
        q0 r11 = r5.body();
        Intrinsics.checkNotNull(r11);
        long r12 = r11.contentLength();
        w r13 = this.eventListener;
        RealCall r14 = this.call;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, NotificationCompat.CATEGORY_CALL);
        return new RequestBodySink(this, this.codec.createRequestBody(r5, r12), r12);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        this.codec.finishRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        w r5 = this.eventListener;
        RealCall r10 = this.call;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "ioe");
        trackFailure(e);
        throw e;
    }

    public final void flushRequest() throws IOException {
        this.codec.flushRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        w r5 = this.eventListener;
        RealCall r10 = this.call;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "ioe");
        trackFailure(e);
        throw e;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final w getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getAddress$okhttp().f20610a.e, this.connection.route().f20764a.f20610a.e);
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final w0 openResponseBody(s0 r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "response");
        String r10 = r5.d("Content-Type", null);     // Catch: IOException -> L5
        long r11 = this.codec.reportedContentLength(r5);     // Catch: IOException -> L5
        return new RealResponseBody(r10, r11, b.e(new ResponseBodySource(this, this.codec.openResponseBodySource(r5), r11)));
    L5:
        e = move-exception;
        w r12 = this.eventListener;
        RealCall r13 = this.call;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "ioe");
        trackFailure(e);
        throw e;
    }

    public final r0 readResponseHeaders(boolean r5) throws IOException {
        r0 r10 = this.codec.readResponseHeaders(r5);     // Catch: IOException -> L6
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "deferredTrailers");     // Catch: IOException -> L6
        r10.f20743m = this;     // Catch: IOException -> L6
    L5:
        return r10;
    L6:
        e = move-exception;
        w r11 = this.eventListener;
        RealCall r12 = this.call;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "ioe");
        trackFailure(e);
        throw e;
    }

    public final void responseHeadersEnd(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        w r10 = this.eventListener;
        RealCall r11 = this.call;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r5, "response");
    }

    public final void responseHeadersStart() {
        w r5 = this.eventListener;
        RealCall r10 = this.call;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public final okhttp3.c0 trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, null);
    }

    public final void writeRequestHeaders(Request r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "request");
        w r10 = this.eventListener;     // Catch: IOException -> L5
        RealCall r11 = this.call;     // Catch: IOException -> L5
        r10.getClass();     // Catch: IOException -> L5
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);     // Catch: IOException -> L5
        this.codec.writeRequestHeaders(r5);     // Catch: IOException -> L5
        w r12 = this.eventListener;     // Catch: IOException -> L5
        RealCall r13 = this.call;     // Catch: IOException -> L5
        r12.getClass();     // Catch: IOException -> L5
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);     // Catch: IOException -> L5
        Intrinsics.checkNotNullParameter(r5, "request");     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        w r14 = this.eventListener;
        RealCall r15 = this.call;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "ioe");
        trackFailure(e);
        throw e;
    }
}
