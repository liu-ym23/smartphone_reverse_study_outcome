package okhttp3.internal.connection;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0003?@AB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ7\u0010\u0017\u001a\u0002H\u0018\"\n\b\u0000\u0010\u0018*\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u0002H\u0018¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u0004\u0018\u00010#J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u0012J\u000e\u00107\u001a\u00020!2\u0006\u00102\u001a\u000203J\u0006\u00108\u001a\u00020!J\u0006\u00109\u001a\u00020!J\u0010\u0010:\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020!J\u000e\u0010>\u001a\u00020!2\u0006\u0010&\u001a\u00020'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006B"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", "transmitter", "Lokhttp3/internal/connection/Transmitter;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "(Lokhttp3/internal/connection/Transmitter;Lokhttp3/Call;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/Call;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "<set-?>", "", "isDuplex", "()Z", "getTransmitter$okhttp", "()Lokhttp3/internal/connection/Transmitter;", "bodyComplete", ExifInterface.LONGITUDE_EAST, "Ljava/io/IOException;", "bytesRead", "", "responseDone", "requestDone", "e", "(JZZLjava/io/IOException;)Ljava/io/IOException;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "duplex", "detachWithViolence", "finishRequest", "flushRequest", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "noNewExchangesOnConnection", "noRequestBody", "openResponseBody", "Lokhttp3/ResponseBody;", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "responseHeadersStart", "timeoutEarlyExit", "trackFailure", "trailers", "Lokhttp3/Headers;", "webSocketUpgradeFailed", "writeRequestHeaders", "Companion", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Exchange {
    public static final Companion Companion = null;
    private final Call call;
    private final ExchangeCodec codec;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean isDuplex;
    private final Transmitter transmitter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/Exchange$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/Exchange;", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Exchange get(Response r1) {
            Intrinsics.checkParameterIsNotNull(r1, ChatMessage.TYPE_RESPONSE);
            return r1.exchange();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000eH\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "bytesReceived", "closed", "", "completed", IslandSession.REOPEN_VALUE_CLOSE, "", "complete", ExifInterface.LONGITUDE_EAST, "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        public RequestBodySink(Exchange r3, Sink r4, long r5) {
            Sink r6 = (Sink) ZeusTransformUtils.wrapperContextForParams(r4, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "delegate");
            this.this$0 = r3;
            super(r6);
            this.contentLength = r5;
        }

        private final <E extends IOException> E complete(E r8) {
            if (this.completed == false) goto L5;
            return r8;
        L5:
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, r8);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            long r0 = this.contentLength;
            if (r0 != (-1)) goto L8;
        L17:
            super.close();     // Catch: IOException -> L14
            complete(null);     // Catch: IOException -> L14
            return;
        L14:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(complete(e), Throwable.class, "com.obric.memorydata.plugin"));
        L8:
            if (this.bytesReceived == r0) goto L17;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("unexpected end of stream"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(complete(e), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer r7, long r8) {
            Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
            if ((!this.closed) == false) goto L17;
            long r2 = this.contentLength;
            if (r2 != (-1)) goto L7;
        L18:
            super.write(r7, r8);     // Catch: IOException -> L13
            this.bytesReceived += r8;     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(complete(e), Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            if ((this.bytesReceived + r8) <= r2) goto L18;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + r8)), Throwable.class, "com.obric.memorydata.plugin"));
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001f\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "bytesReceived", "closed", "", "completed", IslandSession.REOPEN_VALUE_CLOSE, "", "complete", ExifInterface.LONGITUDE_EAST, "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        public ResponseBodySource(Exchange r3, Source r4, long r5) {
            Source r6 = (Source) ZeusTransformUtils.wrapperContextForParams(r4, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "delegate");
            this.this$0 = r3;
            super(r6);
            this.contentLength = r5;
            if (r5 != 0) goto L6;
            complete(null);
            return;
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            super.close();     // Catch: IOException -> L8
            complete(null);     // Catch: IOException -> L8
            return;
        L8:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(complete(e), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final <E extends IOException> E complete(E r8) {
            if (this.completed == false) goto L5;
            return r8;
        L5:
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, r8);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer r9, long r10) {
            Intrinsics.checkParameterIsNotNull(r9, "sink");
            if ((!this.closed) == false) goto L23;
            long r11 = delegate().read(r9, r10);     // Catch: IOException -> L19
            if (r11 != (-1)) goto L8;
            complete(null);     // Catch: IOException -> L19
            return -1;
        L8:
            long r4 = this.bytesReceived + r11;     // Catch: IOException -> L19
            long r6 = this.contentLength;     // Catch: IOException -> L19
            if (r6 != (-1)) goto L11;
        L15:
            this.bytesReceived = r4;     // Catch: IOException -> L19
            if (r4 != r6) goto L18;
            complete(null);     // Catch: IOException -> L19
        L18:
            return r11;
        L11:
            if (r4 <= r6) goto L15;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("expected " + this.contentLength + " bytes but received " + r4), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L19
        L19:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(complete(e), Throwable.class, "com.obric.memorydata.plugin"));
        L23:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Exchange(Transmitter r3, Call r4, EventListener r5, ExchangeFinder r6, ExchangeCodec r7) {
        Call r8 = (Call) ZeusTransformUtils.wrapperContextForParams(r4, Call.class, "com.obric.memorydata.plugin");
        ExchangeCodec r9 = (ExchangeCodec) ZeusTransformUtils.wrapperContextForParams(r7, ExchangeCodec.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "transmitter");
        Intrinsics.checkParameterIsNotNull(r8, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(r5, "eventListener");
        Intrinsics.checkParameterIsNotNull(r6, "finder");
        Intrinsics.checkParameterIsNotNull(r9, "codec");
        this.transmitter = r3;
        this.call = r8;
        this.eventListener = r5;
        this.finder = r6;
        this.codec = r9;
    }

    private final void trackFailure(IOException r2) {
        this.finder.trackFailure();
        RealConnection r1 = this.codec.connection();
        if (r1 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r1.trackFailure$okhttp(r2);
    }

    public final <E extends IOException> E bodyComplete(long r3, boolean r5, boolean r6, E r7) {
        if (r7 == null) goto L4;
        trackFailure(r7);
    L4:
        if (r6 == false) goto L9;
        EventListener r0 = this.eventListener;
        Call r1 = this.call;
        if (r7 == null) goto L8;
        r0.requestFailed(r1, r7);
        goto L9
    L8:
        r0.requestBodyEnd(r1, r3);
    L9:
        if (r5 == false) goto L14;
        if (r7 == null) goto L12;
        this.eventListener.responseFailed(this.call, r7);
        goto L14
    L12:
        this.eventListener.responseBodyEnd(this.call, r3);
    L14:
        return (E) this.transmitter.exchangeMessageDone$okhttp(this, r6, r5, r7);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final RealConnection connection() {
        return this.codec.connection();
    }

    public final Sink createRequestBody(Request r4, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r4, Ext.KEY_REQUEST);
        this.isDuplex = r5;
        RequestBody r6 = r4.body();
        if (r6 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        long r0 = r6.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return (Sink) ZeusTransformUtils.preCheckCast(new RequestBodySink(this, this.codec.createRequestBody(r4, r0), r0), Sink.class, "com.obric.memorydata.plugin");
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() {
        this.codec.finishRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void flushRequest() {
        this.codec.flushRequest();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Call getCall$okhttp() {
        return this.call;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final Transmitter getTransmitter$okhttp() {
        return this.transmitter;
    }

    public final boolean isDuplex() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() {
        this.transmitter.timeoutEarlyExit();
        RealConnection r0 = this.codec.connection();
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0.newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        RealConnection r0 = this.codec.connection();
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.noNewExchanges();
    }

    public final void noRequestBody() {
        this.transmitter.exchangeMessageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response r7) {
        Intrinsics.checkParameterIsNotNull(r7, ChatMessage.TYPE_RESPONSE);
        this.eventListener.responseBodyStart(this.call);     // Catch: IOException -> L5
        String r1 = Response.header$default(r7, NetConst.KEY_CONTENT_TYPE, null, 2, null);     // Catch: IOException -> L5
        long r2 = this.codec.reportedContentLength(r7);     // Catch: IOException -> L5
        return (ResponseBody) ZeusTransformUtils.preCheckCast(new RealResponseBody(r1, r2, Okio.buffer((Source) ZeusTransformUtils.preCheckCast(new ResponseBodySource(this, this.codec.openResponseBodySource(r7), r2), Source.class, "com.obric.memorydata.plugin"))), ResponseBody.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Response.Builder readResponseHeaders(boolean r3) {
        Response.Builder r4 = this.codec.readResponseHeaders(r3);     // Catch: IOException -> L6
        if (r4 == null) goto L5;
        r4.initExchange$okhttp(this);     // Catch: IOException -> L6
    L5:
        return r4;
    L6:
        e = move-exception;
        this.eventListener.responseFailed(this.call, e);
        trackFailure(e);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void responseHeadersEnd(Response r2) {
        Intrinsics.checkParameterIsNotNull(r2, ChatMessage.TYPE_RESPONSE);
        this.eventListener.responseHeadersEnd(this.call, r2);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public final Headers trailers() {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, null);
    }

    public final void writeRequestHeaders(Request r3) {
        Intrinsics.checkParameterIsNotNull(r3, Ext.KEY_REQUEST);
        this.eventListener.requestHeadersStart(this.call);     // Catch: IOException -> L5
        this.codec.writeRequestHeaders(r3);     // Catch: IOException -> L5
        this.eventListener.requestHeadersEnd(this.call, r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.eventListener.requestFailed(this.call, e);
        trackFailure(e);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
