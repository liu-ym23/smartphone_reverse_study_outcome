package okhttp3.internal.http2;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0004_`abB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH\u0000¢\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/¨\u0006c"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", OaidModel.KEY_ID, "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", AILabCheckPermissionTask.KEY_SOURCE, "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", IslandSession.REOPEN_VALUE_CLOSE, "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", XSDatatype.FACET_LENGTH, "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Http2Stream {
    public static final Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", IslandSession.REOPEN_VALUE_CLOSE, "", "emitFrame", "outFinishedOnLastFrame", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "write", AILabCheckPermissionTask.KEY_SOURCE, "byteCount", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSink(Http2Stream r1, boolean r2) {
            this.this$0 = r1;
            this.finished = r2;
            this.sendBuffer = new Buffer();
        }

        public /* synthetic */ FramingSink(Http2Stream r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }

        private final void emitFrame(boolean r12) {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.getWriteTimeout$okhttp().enter();     // Catch: Throwable -> L35
        L41:
        L32:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L6:
            if (this.this$0.getWriteBytesTotal() < this.this$0.getWriteBytesMaximum()) goto L15;
            if (this.finished == true) goto L15;
            if (this.closed == true) goto L15;
            if (this.this$0.getErrorCode$okhttp() != null) goto L15;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L32
        L15:
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L35
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L35
            long r9 = Math.min(this.this$0.getWriteBytesMaximum() - this.this$0.getWriteBytesTotal(), this.sendBuffer.size());     // Catch: Throwable -> L35
            Http2Stream r1 = this.this$0;     // Catch: Throwable -> L35
            r1.setWriteBytesTotal$okhttp(r1.getWriteBytesTotal() + r9);     // Catch: Throwable -> L35
            if (r12 == true) goto L18;
        L22:
            boolean r13 = false;
        L23:
            boolean r7 = r13;
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L35
            monitor-exit(r0);
            this.this$0.getWriteTimeout$okhttp().enter();
            this.this$0.getConnection().writeData(this.this$0.getId(), r7, this.sendBuffer, r9);     // Catch: Throwable -> L29
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            return;
        L29:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            throw th;
        L18:
            if (r9 != this.sendBuffer.size()) goto L22;
            if (this.this$0.getErrorCode$okhttp() != null) goto L22;
            r13 = true;
        L35:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Thread.holdsLock(this.this$0);
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
        L47:
            th = move-exception;
            throw th;
        L5:
            if (this.closed == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            if (this.this$0.getErrorCode$okhttp() != null) goto L11;
            boolean r1 = true;
        L12:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L47
            monitor-exit(r0);
            if (this.this$0.getSink$okhttp().finished == false) goto L17;
        L38:
            Http2Stream r2 = this.this$0;
            monitor-enter(r2);
            this.closed = true;     // Catch: Throwable -> L44
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L44
            monitor-exit(r2);
            this.this$0.getConnection().flush();
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L44:
            th = move-exception;
            throw th;
        L17:
            if (this.sendBuffer.size() <= 0) goto L19;
            boolean r5 = true;
        L21:
            if (this.trailers == null) goto L23;
            boolean r6 = true;
        L24:
            if (r6 == true) goto L26;
            if (r5 == true) goto L34;
            if (r1 == false) goto L38;
            this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0);
        L34:
            if (this.sendBuffer.size() <= 0) goto L38;
            emitFrame(true);
        L26:
            if (this.sendBuffer.size() <= 0) goto L28;
            emitFrame(false);
            goto L26
        L28:
            Http2Connection r7 = this.this$0.getConnection();
            int r8 = this.this$0.getId();
            Headers r9 = this.trailers;
            if (r9 != null) goto L31;
            Intrinsics.throwNpe();
        L31:
            r7.writeHeaders$okhttp(r8, r1, Util.toHeaderList(r9));
            goto L38
        L23:
            r6 = false;
            goto L24
        L19:
            r5 = false;
            goto L21
        L11:
            r1 = false;
            goto L12
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            Thread.holdsLock(this.this$0);
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L10
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
        L7:
            if (this.sendBuffer.size() <= 0) goto L9;
            emitFrame(false);
            this.this$0.getConnection().flush();
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        public final void setFinished(boolean r1) {
            this.finished = r1;
        }

        public final void setTrailers(Headers r1) {
            this.trailers = r1;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return (Timeout) ZeusTransformUtils.preCheckCast(this.this$0.getWriteTimeout$okhttp(), Timeout.class, "com.obric.memorydata.plugin");
        }

        @Override // okio.Sink
        public void write(Buffer r3, long r4) {
            Intrinsics.checkParameterIsNotNull(r3, AILabCheckPermissionTask.KEY_SOURCE);
            Thread.holdsLock(this.this$0);
            this.sendBuffer.write(r3, r4);
        L4:
            if (this.sendBuffer.size() < 16384) goto L6;
            emitFrame(false);
            goto L4
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u001a\u0010\u0007\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "sink", "byteCount", "receive", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "receive$okhttp", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSource(Http2Stream r1, long r2, boolean r4) {
            this.this$0 = r1;
            this.maxByteCount = r2;
            this.finished = r4;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        private final void updateConnectionFlowControl(long r2) {
            Thread.holdsLock(this.this$0);
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(r2);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            this.closed = true;     // Catch: Throwable -> L16
            long r1 = this.readBuffer.size();     // Catch: Throwable -> L16
            this.readBuffer.clear();     // Catch: Throwable -> L16
            Http2Stream r3 = this.this$0;     // Catch: Throwable -> L16
            if (r3 == null) goto L15;
            ZeusTransformUtils.preCheckCast(r3, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L16
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r0);
            if (r1 <= 0) goto L12;
            updateConnectionFlowControl(r1);
        L12:
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L15:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // okio.Source
        public long read(Buffer r18, long r19) {
            Intrinsics.checkParameterIsNotNull(r18, "sink");
            long r4 = 0;
            if (r19 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L58;
        L7:
            IOException r7 = (IOException) ZeusTransformUtils.preCheckCast(null, IOException.class, "com.obric.memorydata.plugin");
            Http2Stream r9 = this.this$0;
            monitor-enter(r9);
            this.this$0.getReadTimeout$okhttp().enter();     // Catch: Throwable -> L54
        L51:
            th = move-exception;
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L54
            throw th;     // Catch: Throwable -> L54
        L11:
            if (this.this$0.getErrorCode$okhttp() == null) goto L20;
            r7 = this.this$0.getErrorException$okhttp();     // Catch: Throwable -> L51
            if (r7 != null) goto L20;
            ErrorCode r10 = this.this$0.getErrorCode$okhttp();     // Catch: Throwable -> L51
            if (r10 != null) goto L18;
            Intrinsics.throwNpe();     // Catch: Throwable -> L51
        L18:
            r7 = (IOException) ZeusTransformUtils.preCheckCast(new StreamResetException(r10), IOException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        L20:
            if (this.closed == true) goto L50;
            if (this.readBuffer.size() <= r4) goto L29;
            Buffer r11 = this.readBuffer;     // Catch: Throwable -> L51
            long r13 = r11.read(r18, Math.min(r19, r11.size()));     // Catch: Throwable -> L51
            Http2Stream r12 = this.this$0;     // Catch: Throwable -> L51
            r12.setReadBytesTotal$okhttp(r12.getReadBytesTotal() + r13);     // Catch: Throwable -> L51
            long r5 = this.this$0.getReadBytesTotal() - this.this$0.getReadBytesAcknowledged();     // Catch: Throwable -> L51
            if (r7 == null) goto L26;
        L34:
            boolean r8 = false;
        L35:
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L54
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L54
            monitor-exit(r9);
            if (r8 == false) goto L40;
            r4 = 0;
            goto L7
        L40:
            if (r13 == (-1)) goto L43;
            updateConnectionFlowControl(r13);
            return r13;
        L43:
            if (r7 == null) goto L48;
            if (r7 != null) goto L47;
            Intrinsics.throwNpe();
        L47:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.memorydata.plugin"));
        L48:
            return -1;
        L26:
            if (r5 < (this.this$0.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)) goto L34;
            this.this$0.getConnection().writeWindowUpdateLater$okhttp(this.this$0.getId(), r5);     // Catch: Throwable -> L51
            Http2Stream r15 = this.this$0;     // Catch: Throwable -> L51
            r15.setReadBytesAcknowledged$okhttp(r15.getReadBytesTotal());     // Catch: Throwable -> L51
            goto L34
        L29:
            if (this.finished == true) goto L33;
            if (r7 != null) goto L33;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L51
            r13 = -1;
            r8 = true;
        L33:
            r13 = -1;
            goto L34
        L50:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("stream closed"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L51
        L54:
            th = move-exception;
            throw th;
        L58:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r19).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r6 = false;
            goto L6
        }

        public final void receive$okhttp(BufferedSource r10, long r11) {
            BufferedSource r12 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r10, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r12, AILabCheckPermissionTask.KEY_SOURCE);
            Thread.holdsLock(this.this$0);
        L4:
            if (r11 <= 0) goto L51;
            Http2Stream r2 = this.this$0;
            monitor-enter(r2);
            boolean r3 = this.finished;     // Catch: Throwable -> L48
            boolean r5 = true;
            if ((this.readBuffer.size() + r11) <= this.maxByteCount) goto L10;
            boolean r4 = true;
        L11:
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r2);
            if (r4 == true) goto L14;
            if (r3 == true) goto L17;
            long r6 = r12.read(this.receiveBuffer, r11);
            if (r6 == (-1)) goto L47;
            r11 = r11 - r6;
            Http2Stream r8 = this.this$0;
            monitor-enter(r8);
        L43:
            th = move-exception;
            throw th;
        L24:
            if (this.closed == false) goto L27;
            long r9 = this.receiveBuffer.size();     // Catch: Throwable -> L43
            this.receiveBuffer.clear();     // Catch: Throwable -> L43
        L38:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L43
            monitor-exit(r8);
            if (r9 <= 0) goto L4;
            updateConnectionFlowControl(r9);
            goto L4
        L27:
            if (this.readBuffer.size() == 0) goto L30;
            r5 = false;
        L30:
            this.readBuffer.writeAll((Source) ZeusTransformUtils.preCheckCast(this.receiveBuffer, Source.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
            if (r5 == false) goto L37;
            Http2Stream r14 = this.this$0;     // Catch: Throwable -> L43
            if (r14 == null) goto L36;
            ZeusTransformUtils.preCheckCast(r14, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L43
            goto L37
        L36:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L43
        L37:
            r9 = 0;
            goto L38
        L47:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
        L17:
            r12.skip(r11);
            return;
        L14:
            r12.skip(r11);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L10:
            r4 = false;
        L48:
            th = move-exception;
            throw th;
        }

        public final void setClosed$okhttp(boolean r1) {
            this.closed = r1;
        }

        public final void setFinished$okhttp(boolean r1) {
            this.finished = r1;
        }

        public final void setTrailers(Headers r1) {
            this.trailers = r1;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return (Timeout) ZeusTransformUtils.preCheckCast(this.this$0.getReadTimeout$okhttp(), Timeout.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream r1) {
            this.this$0 = r1;
        }

        public final void exitAndThrowIfTimedOut() {
            if (exit() == true) goto L6;
            return;
        L6:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(newTimeoutException(null), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException r3) {
            SocketTimeoutException r2 = new SocketTimeoutException(LocationMonitorConst.TIMEOUT);
            if (r3 == null) goto L6;
            r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        L6:
            return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.memorydata.plugin");
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http2Stream(int r4, Http2Connection r5, boolean r6, boolean r7, Headers r8) {
        Intrinsics.checkParameterIsNotNull(r5, WsConstants.KEY_CONNECTION);
        this.id = r4;
        this.connection = r5;
        this.writeBytesMaximum = r5.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> r9 = new ArrayDeque();
        this.headersQueue = r9;
        this.source = new FramingSource(this, r5.getOkHttpSettings().getInitialWindowSize(), r7);
        this.sink = new FramingSink(this, r6);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        boolean r3 = isLocallyInitiated();
        if (r8 != null) goto L5;
        if (r3 == false) goto L12;
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("remotely-initiated streams should have headers".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if ((!r3) == false) goto L8;
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).add(r8);
        return;
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean closeInternal(ErrorCode r3, IOException r4) {
        Thread.holdsLock(this);
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.errorCode == null) goto L10;
        monitor-exit(this);
        return false;
    L10:
        if (this.source.getFinished$okhttp() == true) goto L12;
    L15:
        this.errorCode = r3;     // Catch: Throwable -> L19
        this.errorException = r4;     // Catch: Throwable -> L19
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L19
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        this.connection.removeStream$okhttp(this.id);
        return true;
    L12:
        if (this.sink.getFinished() == false) goto L15;
        monitor-exit(this);
        return false;
    }

    public final void addBytesToWriteWindow(long r3) {
        this.writeBytesMaximum += r3;
        if (r3 <= 0) goto L6;
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();
        return;
    }

    public final void cancelStreamIfNecessary$okhttp() {
        Thread.holdsLock(this);
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.source.getFinished$okhttp() == false) goto L7;
    L13:
        boolean r0 = false;
    L14:
        boolean r1 = isOpen();     // Catch: Throwable -> L21
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r0 == false) goto L18;
        close(ErrorCode.CANCEL, null);
        return;
    L18:
        if (r1 == true) goto L27;
        this.connection.removeStream$okhttp(this.id);
        return;
    L27:
        return;
    L7:
        if (this.source.getClosed$okhttp() == false) goto L13;
        if (this.sink.getFinished() == false) goto L11;
    L12:
        r0 = true;
        goto L14
    L11:
        if (this.sink.getClosed() == false) goto L13;
        goto L12
    }

    public final void checkOutNotClosed$okhttp() {
        if (this.sink.getClosed() == true) goto L20;
        if (this.sink.getFinished() == true) goto L18;
        if (this.errorCode == null) goto L16;
        Object r0 = this.errorException;
        if (r0 != null) goto L15;
        ErrorCode r2 = this.errorCode;
        if (r2 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r0 = new StreamResetException(r2);
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"));
    L16:
        return;
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("stream finished"), Throwable.class, "com.obric.memorydata.plugin"));
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("stream closed"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void close(ErrorCode r2, IOException r3) {
        Intrinsics.checkParameterIsNotNull(r2, "rstStatusCode");
        if (closeInternal(r2, r3) == true) goto L5;
        return;
    L5:
        this.connection.writeSynReset$okhttp(this.id, r2);
    }

    public final void closeLater(ErrorCode r2) {
        Intrinsics.checkParameterIsNotNull(r2, "errorCode");
        if (closeInternal(r2, null) == true) goto L5;
        return;
    L5:
        this.connection.writeSynResetLater$okhttp(this.id, r2);
    }

    public final void enqueueTrailers(Headers r3) {
        Intrinsics.checkParameterIsNotNull(r3, "trailers");
        monitor-enter(this);
        boolean r1 = true;
        if ((!this.sink.getFinished()) == false) goto L17;
        if (r3.size() != 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L15;
        this.sink.setTrailers(r3);     // Catch: Throwable -> L18
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("trailers.size() == 0".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("already finished".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        monitor-enter(this);
        ErrorCode r0 = this.errorCode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final Sink getSink() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.hasResponseHeaders == false) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L16;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return (Sink) ZeusTransformUtils.preCheckCast(this.sink, Sink.class, "com.obric.memorydata.plugin");
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("reply before requesting the sink".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L6:
        if (isLocallyInitiated() == true) goto L9;
        r0 = false;
        goto L10
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final Source getSource() {
        return (Source) ZeusTransformUtils.preCheckCast(this.source, Source.class, "com.obric.memorydata.plugin");
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        if ((this.id & 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (this.connection.getClient$okhttp() != r0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public final synchronized boolean isOpen() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.errorCode == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.source.getFinished$okhttp() == true) goto L13;
        if (this.source.getClosed$okhttp() == true) goto L13;
    L21:
        monitor-exit(this);
        return true;
    L13:
        if (this.sink.getFinished() == false) goto L15;
    L16:
        if (this.hasResponseHeaders == false) goto L21;
        monitor-exit(this);
        return false;
    L15:
        if (this.sink.getClosed() == false) goto L21;
        goto L16
    }

    public final Timeout readTimeout() {
        return (Timeout) ZeusTransformUtils.preCheckCast(this.readTimeout, Timeout.class, "com.obric.memorydata.plugin");
    }

    public final void receiveData(BufferedSource r3, int r4) {
        BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Thread.holdsLock(this);
        this.source.receive$okhttp(r5, r4);
    }

    public final void receiveHeaders(Headers r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "headers");
        Thread.holdsLock(this);
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.hasResponseHeaders == false) goto L9;
        if (r6 == false) goto L9;
        this.source.setTrailers(r5);     // Catch: Throwable -> L17
    L10:
        if (r6 == false) goto L12;
        this.source.setFinished$okhttp(true);     // Catch: Throwable -> L17
    L12:
        boolean r7 = isOpen();     // Catch: Throwable -> L17
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L17
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        if (r7 == true) goto L22;
        this.connection.removeStream$okhttp(this.id);
        return;
    L22:
        return;
    L9:
        this.hasResponseHeaders = true;     // Catch: Throwable -> L17
        ((Collection) ZeusTransformUtils.preCheckCast(this.headersQueue, Collection.class, "com.obric.memorydata.plugin")).add(r5);     // Catch: Throwable -> L17
        goto L10
    }

    public final synchronized void receiveRstStream(ErrorCode r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, "errorCode");     // Catch: Throwable -> L8
        if (this.errorCode != null) goto L6;
        this.errorCode = r2;     // Catch: Throwable -> L8
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setErrorCode$okhttp(ErrorCode r1) {
        this.errorCode = r1;
    }

    public final void setErrorException$okhttp(IOException r1) {
        this.errorException = r1;
    }

    public final void setReadBytesAcknowledged$okhttp(long r1) {
        this.readBytesAcknowledged = r1;
    }

    public final void setReadBytesTotal$okhttp(long r1) {
        this.readBytesTotal = r1;
    }

    public final void setWriteBytesMaximum$okhttp(long r1) {
        this.writeBytesMaximum = r1;
    }

    public final void setWriteBytesTotal$okhttp(long r1) {
        this.writeBytesTotal = r1;
    }

    public final synchronized Headers takeHeaders() {
        monitor-enter(this);
        this.readTimeout.enter();     // Catch: Throwable -> L27
    L31:
    L24:
        th = move-exception;
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L5:
        if (this.headersQueue.isEmpty() == false) goto L10;
        if (this.errorCode != null) goto L10;
        waitForIo$okhttp();     // Catch: Throwable -> L24
    L10:
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L27
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.headersQueue, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        Headers r0 = this.headersQueue.removeFirst();     // Catch: Throwable -> L27
        Intrinsics.checkExpressionValueIsNotNull(r0, "headersQueue.removeFirst()");     // Catch: Throwable -> L27
        Headers r1 = (Headers) ZeusTransformUtils.preCheckCast(r0, Headers.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        monitor-exit(this);
        return r1;
    L15:
        IOException r2 = this.errorException;     // Catch: Throwable -> L27
        if (r2 != null) goto L22;
        ErrorCode r3 = this.errorCode;     // Catch: Throwable -> L27
        if (r3 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Throwable -> L27
    L20:
        Object r4 = ZeusTransformUtils.preCheckCast(new StreamResetException(r3), Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L23:
        throw ((Throwable) r4);     // Catch: Throwable -> L27
    L22:
        r4 = ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final synchronized Headers trailers() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (this.errorCode == null) goto L15;
        IOException r0 = this.errorException;     // Catch: Throwable -> L31
        if (r0 != null) goto L12;
        ErrorCode r1 = this.errorCode;     // Catch: Throwable -> L31
        if (r1 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L31
    L10:
        Object r2 = ZeusTransformUtils.preCheckCast(new StreamResetException(r1), Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
    L13:
        throw ((Throwable) r2);     // Catch: Throwable -> L31
    L12:
        r2 = ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        goto L13
    L15:
        if (this.source.getFinished$okhttp() == true) goto L17;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L30;
        Headers r4 = this.source.getTrailers();     // Catch: Throwable -> L31
        if (r4 != null) goto L27;
        r4 = Util.EMPTY_HEADERS;     // Catch: Throwable -> L31
    L27:
        monitor-exit(this);
        return r4;
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("too early; can't read the trailers yet".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L17:
        if (this.source.getReceiveBuffer().exhausted() == false) goto L21;
        if (this.source.getReadBuffer().exhausted() == false) goto L21;
        r3 = true;
        goto L22
    }

    public final void waitForIo$okhttp() {
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").wait();     // Catch: InterruptedException -> L5
        return;
    L5:
        Thread.currentThread().interrupt();
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void writeHeaders(List<Header> r6, boolean r7, boolean r8) {
        List<Header> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "responseHeaders");
        Thread.holdsLock(this);
        monitor-enter(this);
        boolean r0 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L27
        if (r7 == false) goto L8;
        this.sink.setFinished(true);     // Catch: Throwable -> L27
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        if (r8 == true) goto L23;
        Http2Connection r10 = this.connection;
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum()) goto L17;
        r0 = false;
    L17:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r10);
        r8 = r0;
    L23:
        this.connection.writeHeaders$okhttp(this.id, r7, r9);
        if (r8 == false) goto L34;
        this.connection.flush();
        return;
    L34:
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public final Timeout writeTimeout() {
        return (Timeout) ZeusTransformUtils.preCheckCast(this.writeTimeout, Timeout.class, "com.obric.memorydata.plugin");
    }
}
