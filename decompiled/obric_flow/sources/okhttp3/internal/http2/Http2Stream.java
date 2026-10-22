package okhttp3.internal.http2;

import androidx.constraintlayout.motion.widget.a;
import com.bytedance.common.wschannel.WsConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.a0;
import nu.e;
import nu.f0;
import nu.j;
import nu.l;
import okhttp3.c0;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 u2\u00020\u0001:\u0004uvwxB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000eJ+\u0010\u0015\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u001f\u0010'\u001a\u00020\u00142\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00142\u0006\u0010)\u001a\u00020#¢\u0006\u0004\b*\u0010+J\u001d\u0010/\u001a\u00020\u00142\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u00142\u0006\u0010)\u001a\u00020#¢\u0006\u0004\b3\u0010+J\u000f\u00106\u001a\u00020\u0014H\u0000¢\u0006\u0004\b4\u00105J\u0015\u00109\u001a\u00020\u00142\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020\u0014H\u0000¢\u0006\u0004\b;\u00105J\u000f\u0010>\u001a\u00020\u0014H\u0000¢\u0006\u0004\b=\u00105J!\u0010?\u001a\u00020\u00062\u0006\u0010)\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b?\u0010@R*\u0010B\u001a\u0002072\u0006\u0010A\u001a\u0002078\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010:R*\u0010G\u001a\u0002072\u0006\u0010A\u001a\u0002078\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010:R*\u0010J\u001a\u0002072\u0006\u0010A\u001a\u0002078\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010C\u001a\u0004\bK\u0010E\"\u0004\bL\u0010:R*\u0010M\u001a\u0002072\u0006\u0010A\u001a\u0002078\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010E\"\u0004\bO\u0010:R\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\t0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010-\u001a\u00060UR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010V\u001a\u0004\bW\u0010XR\u001e\u0010Z\u001a\u00060YR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001e\u0010\u001a\u001a\u00060^R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010_\u001a\u0004\b`\u0010aR\u001e\u0010\u001c\u001a\u00060^R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010_\u001a\u0004\bb\u0010aR$\u0010)\u001a\u0004\u0018\u00010#8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010+R$\u0010&\u001a\u0004\u0018\u00010%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010o\u001a\u0004\bp\u0010qR\u0011\u0010r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0011\u0010t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bt\u0010s¨\u0006y"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "", "id", "Lokhttp3/internal/http2/Http2Connection;", WsConstants.KEY_CONNECTION, "", "outFinished", "inFinished", "Lokhttp3/c0;", "headers", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/c0;)V", "takeHeaders", "()Lokhttp3/c0;", "trailers", "", "Lokhttp3/internal/http2/Header;", "responseHeaders", "flushHeaders", "", "writeHeaders", "(Ljava/util/List;ZZ)V", "enqueueTrailers", "(Lokhttp3/c0;)V", "Lnu/f0;", "readTimeout", "()Lnu/f0;", "writeTimeout", "Lnu/c0;", "getSource", "()Lnu/c0;", "Lnu/a0;", "getSink", "()Lnu/a0;", "Lokhttp3/internal/http2/ErrorCode;", "rstStatusCode", "Ljava/io/IOException;", "errorException", "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "errorCode", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Lnu/l;", "source", "length", "receiveData", "(Lnu/l;I)V", "receiveHeaders", "(Lokhttp3/c0;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", "", "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "closeInternal", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", "<set-?>", "readBytesTotal", "J", "getReadBytesTotal", "()J", "setReadBytesTotal$okhttp", "readBytesAcknowledged", "getReadBytesAcknowledged", "setReadBytesAcknowledged$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "Ljava/util/ArrayDeque;", "headersQueue", "Ljava/util/ArrayDeque;", "hasResponseHeaders", "Z", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getWriteTimeout$okhttp", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "I", "getId", "()I", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "isOpen", "()Z", "isLocallyInitiated", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Stream {
    public static final Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<c0> headersQueue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f20663id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b$\u0010\"\"\u0004\b%\u0010\t¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lnu/a0;", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "outFinishedOnLastFrame", "", "emitFrame", "(Z)V", "Lnu/j;", "source", "", "byteCount", "write", "(Lnu/j;J)V", "flush", "()V", "Lnu/f0;", "timeout", "()Lnu/f0;", "close", "sendBuffer", "Lnu/j;", "Lokhttp3/c0;", "trailers", "Lokhttp3/c0;", "getTrailers", "()Lokhttp3/c0;", "setTrailers", "(Lokhttp3/c0;)V", "closed", "Z", "getClosed", "()Z", "setClosed", "getFinished", "setFinished", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class FramingSink implements a0 {
        private boolean closed;
        private boolean finished;
        private final j sendBuffer;
        final /* synthetic */ Http2Stream this$0;
        private c0 trailers;

        public FramingSink(Http2Stream r5, boolean r10) {
            this.this$0 = r5;
            this.finished = r10;
            this.sendBuffer = new j();
        }

        private final void emitFrame(boolean r12) throws IOException {
            Http2Stream r5 = this.this$0;
            monitor-enter(r5);
            this.this$0.getWriteTimeout$okhttp().enter();     // Catch: Throwable -> L23
        L39:
        L15:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L23
        L6:
            if (this.this$0.getWriteBytesTotal() < this.this$0.getWriteBytesMaximum()) goto L17;
            if (this.finished == true) goto L17;
            if (this.closed == true) goto L17;
            if (this.this$0.getErrorCode$okhttp() != null) goto L17;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L15
        L17:
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L23
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L23
            long r10 = Math.min(this.this$0.getWriteBytesMaximum() - this.this$0.getWriteBytesTotal(), this.sendBuffer.f20328b);     // Catch: Throwable -> L23
            Http2Stream r11 = this.this$0;     // Catch: Throwable -> L23
            r11.setWriteBytesTotal$okhttp(r11.getWriteBytesTotal() + r10);     // Catch: Throwable -> L23
            if (r12 == true) goto L20;
        L25:
            boolean r13 = false;
        L22:
            boolean r14 = r13;
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r5);
            this.this$0.getWriteTimeout$okhttp().enter();
            this.this$0.getConnection().writeData(this.this$0.getId(), r14, this.sendBuffer, r10);     // Catch: Throwable -> L32
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            return;
        L32:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            throw th;
        L20:
            if (r10 != this.sendBuffer.f20328b) goto L25;
            r13 = true;
        L23:
            th = move-exception;
            throw th;
        }

        @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r5 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
        L48:
            th = move-exception;
            throw th;
        L12:
            if (this.closed == false) goto L16;
            monitor-exit(r10);
            return;
        L16:
            if (this.this$0.getErrorCode$okhttp() != null) goto L18;
            boolean r11 = true;
        L19:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r10);
            if (this.this$0.getSink$okhttp().finished == false) goto L24;
        L39:
            Http2Stream r13 = this.this$0;
            monitor-enter(r13);
            this.closed = true;     // Catch: Throwable -> L45
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L45
            monitor-exit(r13);
            this.this$0.getConnection().flush();
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L45:
            th = move-exception;
            throw th;
        L24:
            if (this.sendBuffer.f20328b <= 0) goto L26;
            boolean r15 = true;
        L28:
            if (this.trailers != null) goto L30;
            if (r15 == true) goto L35;
            if (r11 == false) goto L39;
            this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0);
        L35:
            if (this.sendBuffer.f20328b <= 0) goto L39;
            emitFrame(true);
        L30:
            if (this.sendBuffer.f20328b <= 0) goto L32;
            emitFrame(false);
            goto L30
        L32:
            Http2Connection r16 = this.this$0.getConnection();
            int r17 = this.this$0.getId();
            c0 r18 = this.trailers;
            Intrinsics.checkNotNull(r18);
            r16.writeHeaders$okhttp(r17, r11, Util.toHeaderList(r18));
            goto L39
        L26:
            r15 = false;
            goto L28
        L18:
            r11 = false;
            goto L19
        L5:
            if (Thread.holdsLock(r5) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r5);
        }

        @Override // nu.a0, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream r5 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L17
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(r10);
        L14:
            if (this.sendBuffer.f20328b <= 0) goto L16;
            emitFrame(false);
            this.this$0.getConnection().flush();
            goto L14
        L16:
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Thread.holdsLock(r5) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r5);
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final c0 getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean r5) {
            this.closed = r5;
        }

        public final void setFinished(boolean r5) {
            this.finished = r5;
        }

        public final void setTrailers(c0 r5) {
            this.trailers = r5;
        }

        @Override // nu.a0
        public f0 timeout() {
            return this.this$0.getWriteTimeout$okhttp();
        }

        @Override // nu.a0
        public void write(j r5, long r10) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "source");
            Http2Stream r11 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            this.sendBuffer.write(r5, r10);
        L11:
            if (this.sendBuffer.f20328b < Http2Stream.EMIT_BUFFER_SIZE) goto L13;
            emitFrame(false);
            goto L11
        L13:
            return;
        L5:
            if (Thread.holdsLock(r11) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r11);
        }

        public /* synthetic */ FramingSink(Http2Stream r5, boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = false;
        L5:
            this(r5, r10);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lnu/c0;", "", "maxByteCount", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "read", "", "updateConnectionFlowControl", "(J)V", "Lnu/j;", "sink", "byteCount", "(Lnu/j;J)J", "Lnu/l;", "source", "receive$okhttp", "(Lnu/l;J)V", "receive", "Lnu/f0;", "timeout", "()Lnu/f0;", "close", "()V", "receiveBuffer", "Lnu/j;", "getReceiveBuffer", "()Lnu/j;", "readBuffer", "getReadBuffer", "Lokhttp3/c0;", "trailers", "Lokhttp3/c0;", "getTrailers", "()Lokhttp3/c0;", "setTrailers", "(Lokhttp3/c0;)V", "closed", "Z", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "J", "getFinished$okhttp", "setFinished$okhttp", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class FramingSource implements nu.c0 {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final j readBuffer;
        private final j receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private c0 trailers;

        public FramingSource(Http2Stream r5, long r10, boolean r11) {
            this.this$0 = r5;
            this.maxByteCount = r10;
            this.finished = r11;
            this.receiveBuffer = new j();
            this.readBuffer = new j();
        }

        private final void updateConnectionFlowControl(long r5) {
            Http2Stream r10 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(r5);
            return;
        L5:
            if (Thread.holdsLock(r10) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r10);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r5 = this.this$0;
            monitor-enter(r5);
            this.closed = true;     // Catch: Throwable -> L14
            j r10 = this.readBuffer;     // Catch: Throwable -> L14
            long r11 = r10.f20328b;     // Catch: Throwable -> L14
            r10.b();     // Catch: Throwable -> L14
            Http2Stream r12 = this.this$0;     // Catch: Throwable -> L14
            if (r12 == null) goto L17;
            r12.notifyAll();     // Catch: Throwable -> L14
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r5);
            if (r11 <= 0) goto L12;
            updateConnectionFlowControl(r11);
        L12:
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final j getReadBuffer() {
            return this.readBuffer;
        }

        public final j getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final c0 getTrailers() {
            return this.trailers;
        }

        @Override // nu.c0
        public long read(j r19, long r20) throws IOException {
            Intrinsics.checkNotNullParameter(r19, "sink");
            long r5 = 0;
            if (r20 < 0) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L57;
        L7:
            Http2Stream r11 = this.this$0;
            monitor-enter(r11);
            this.this$0.getReadTimeout$okhttp().enter();     // Catch: Throwable -> L48
        L16:
            th = move-exception;
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L11:
            if (this.this$0.getErrorCode$okhttp() == null) goto L18;
            IOException r12 = this.this$0.getErrorException$okhttp();     // Catch: Throwable -> L16
            if (r12 != null) goto L20;
            ErrorCode r13 = this.this$0.getErrorCode$okhttp();     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L16
            r12 = new StreamResetException(r13);     // Catch: Throwable -> L16
        L20:
            if (this.closed == true) goto L51;
            j r14 = this.readBuffer;     // Catch: Throwable -> L16
            long r15 = r14.f20328b;     // Catch: Throwable -> L16
            if (r15 <= r5) goto L30;
            long r16 = r14.read(r19, Math.min(r20, r15));     // Catch: Throwable -> L16
            Http2Stream r17 = this.this$0;     // Catch: Throwable -> L16
            r17.setReadBytesTotal$okhttp(r17.getReadBytesTotal() + r16);     // Catch: Throwable -> L16
            long r18 = this.this$0.getReadBytesTotal() - this.this$0.getReadBytesAcknowledged();     // Catch: Throwable -> L16
            if (r12 == null) goto L26;
        L28:
            boolean r21 = false;
        L36:
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L48
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r11);
            if (r21 == false) goto L41;
            r5 = 0;
            goto L7
        L41:
            if (r16 == (-1)) goto L44;
            updateConnectionFlowControl(r16);
            return r16;
        L44:
            if (r12 != null) goto L46;
            return -1;
        L46:
            Intrinsics.checkNotNull(r12);
            throw r12;
        L26:
            if (r18 < (this.this$0.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)) goto L28;
            this.this$0.getConnection().writeWindowUpdateLater$okhttp(this.this$0.getId(), r18);     // Catch: Throwable -> L16
            Http2Stream r23 = this.this$0;     // Catch: Throwable -> L16
            r23.setReadBytesAcknowledged$okhttp(r23.getReadBytesTotal());     // Catch: Throwable -> L16
            goto L28
        L30:
            if (this.finished == true) goto L35;
            if (r12 != null) goto L35;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L16
            r21 = true;
        L34:
            r16 = -1;
        L35:
            r21 = false;
            goto L34
        L51:
            throw new IOException("stream closed");     // Catch: Throwable -> L16
        L18:
            r12 = null;
        L48:
            th = move-exception;
            throw th;
        L57:
            throw new IllegalArgumentException(a.j(r20, "byteCount < 0: ").toString());
        L5:
            r10 = false;
            goto L6
        }

        public final void receive$okhttp(l r10, long r11) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "source");
            Http2Stream r5 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r5) == false) goto L10;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r5);
        L10:
            if (r11 <= 0) goto L56;
            Http2Stream r12 = this.this$0;
            monitor-enter(r12);
            boolean r13 = this.finished;     // Catch: Throwable -> L53
            boolean r14 = false;
            if ((this.readBuffer.f20328b + r11) <= this.maxByteCount) goto L16;
            boolean r15 = true;
        L17:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L53
            monitor-exit(r12);
            if (r15 == true) goto L20;
            if (r13 == true) goto L23;
            long r17 = r10.read(this.receiveBuffer, r11);
            if (r17 == (-1)) goto L52;
            r11 = r11 - r17;
            Http2Stream r18 = this.this$0;
            monitor-enter(r18);
        L32:
            th = move-exception;
            throw th;
        L30:
            if (this.closed == false) goto L34;
            j r19 = this.receiveBuffer;     // Catch: Throwable -> L32
            long r20 = r19.f20328b;     // Catch: Throwable -> L32
            r19.b();     // Catch: Throwable -> L32
        L45:
            monitor-exit(r18);
            if (r20 <= 0) goto L10;
            updateConnectionFlowControl(r20);
            goto L10
        L34:
            j r21 = this.readBuffer;     // Catch: Throwable -> L32
            if (r21.f20328b != 0) goto L37;
            r14 = true;
        L37:
            r21.G(this.receiveBuffer);     // Catch: Throwable -> L32
            if (r14 == false) goto L44;
            Http2Stream r22 = this.this$0;     // Catch: Throwable -> L32
            if (r22 == null) goto L43;
            r22.notifyAll();     // Catch: Throwable -> L32
            goto L44
        L43:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L32
        L44:
            r20 = 0;
            goto L45
        L52:
            throw new EOFException();
        L23:
            r10.skip(r11);
            return;
        L20:
            r10.skip(r11);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L16:
            r15 = false;
        L53:
            th = move-exception;
            throw th;
        }

        public final void setClosed$okhttp(boolean r5) {
            this.closed = r5;
        }

        public final void setFinished$okhttp(boolean r5) {
            this.finished = r5;
        }

        public final void setTrailers(c0 r5) {
            this.trailers = r5;
        }

        @Override // nu.c0
        public f0 timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lnu/e;", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "", "timedOut", "()V", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "exitAndThrowIfTimedOut", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class StreamTimeout extends e {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream r5) {
            this.this$0 = r5;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit() == true) goto L6;
            return;
        L6:
            throw newTimeoutException(null);
        }

        @Override // nu.e
        public IOException newTimeoutException(IOException r5) {
            SocketTimeoutException r10 = new SocketTimeoutException("timeout");
            if (r5 == null) goto L5;
            r10.initCause(r5);
        L5:
            return r10;
        }

        @Override // nu.e
        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http2Stream(int r5, Http2Connection r10, boolean r11, boolean r12, c0 r13) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        this.f20663id = r5;
        this.connection = r10;
        this.writeBytesMaximum = r10.getPeerSettings().getInitialWindowSize();
        ArrayDeque<c0> r14 = new ArrayDeque();
        this.headersQueue = r14;
        this.source = new FramingSource(this, r10.getOkHttpSettings().getInitialWindowSize(), r12);
        this.sink = new FramingSink(this, r11);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (r13 == null) goto L10;
        if (isLocallyInitiated() == true) goto L8;
        r14.add(r13);
        return;
    L8:
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    L10:
        if (isLocallyInitiated() == false) goto L13;
        return;
    L13:
        throw new IllegalStateException("remotely-initiated streams should have headers");
    }

    private final boolean closeInternal(ErrorCode r5, IOException r10) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L12:
        if (this.errorCode == null) goto L16;
        monitor-exit(this);
        return false;
    L16:
        if (this.source.getFinished$okhttp() == true) goto L18;
    L23:
        this.errorCode = r5;     // Catch: Throwable -> L21
        this.errorException = r10;     // Catch: Throwable -> L21
        notifyAll();     // Catch: Throwable -> L21
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        this.connection.removeStream$okhttp(this.f20663id);
        return true;
    L18:
        if (this.sink.getFinished() == false) goto L23;
        monitor-exit(this);
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void addBytesToWriteWindow(long r5) {
        this.writeBytesMaximum += r5;
        if (r5 <= 0) goto L6;
        notifyAll();
        return;
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (this.source.getFinished$okhttp() == false) goto L13;
    L22:
        boolean r5 = false;
    L23:
        boolean r10 = isOpen();     // Catch: Throwable -> L19
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        if (r5 == false) goto L27;
        close(ErrorCode.CANCEL, null);
        return;
    L27:
        if (r10 == true) goto L35;
        this.connection.removeStream$okhttp(this.f20663id);
        return;
    L35:
        return;
    L13:
        if (this.source.getClosed$okhttp() == false) goto L22;
        if (this.sink.getFinished() == false) goto L17;
    L21:
        r5 = true;
        goto L23
    L17:
        if (this.sink.getClosed() == false) goto L22;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed() == true) goto L17;
        if (this.sink.getFinished() == true) goto L15;
        if (this.errorCode == null) goto L13;
        IOException r5 = this.errorException;
        if (r5 != null) goto L18;
        ErrorCode r10 = this.errorCode;
        Intrinsics.checkNotNull(r10);
        throw new StreamResetException(r10);
    L18:
        throw r5;
    L13:
        return;
    L15:
        throw new IOException("stream finished");
    L17:
        throw new IOException("stream closed");
    }

    public final void close(ErrorCode r5, IOException r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "rstStatusCode");
        if (closeInternal(r5, r10) == true) goto L5;
        return;
    L5:
        this.connection.writeSynReset$okhttp(this.f20663id, r5);
    }

    public final void closeLater(ErrorCode r5) {
        Intrinsics.checkNotNullParameter(r5, "errorCode");
        if (closeInternal(r5, null) == true) goto L5;
        return;
    L5:
        this.connection.writeSynResetLater$okhttp(this.f20663id, r5);
    }

    public final void enqueueTrailers(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "trailers");
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.sink.getFinished() == true) goto L19;
        if (r5.size() == 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L17;
        this.sink.setTrailers(r5);     // Catch: Throwable -> L14
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new IllegalArgumentException("trailers.size() == 0");     // Catch: Throwable -> L14
    L9:
        r10 = false;
        goto L10
    L19:
        throw new IllegalStateException("already finished");     // Catch: Throwable -> L14
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        monitor-enter(this);
        ErrorCode r5 = this.errorCode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.f20663id;
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

    public final a0 getSink() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.hasResponseHeaders == false) goto L6;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L18;
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return this.sink;
    L18:
        throw new IllegalStateException("reply before requesting the sink");     // Catch: Throwable -> L9
    L6:
        if (isLocallyInitiated() == true) goto L11;
        r5 = false;
        goto L12
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final nu.c0 getSource() {
        return this.source;
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
        if ((this.f20663id & 1) != 1) goto L5;
        boolean r5 = true;
    L7:
        if (this.connection.getClient$okhttp() != r5) goto L10;
        return true;
    L10:
        return false;
    L5:
        r5 = false;
        goto L7
    }

    public final synchronized boolean isOpen() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.errorCode == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.source.getFinished$okhttp() == true) goto L16;
        if (this.source.getClosed$okhttp() == true) goto L16;
    L23:
        monitor-exit(this);
        return true;
    L16:
        if (this.sink.getFinished() == false) goto L18;
    L19:
        if (this.hasResponseHeaders == false) goto L23;
        monitor-exit(this);
        return false;
    L18:
        if (this.sink.getClosed() == false) goto L23;
        goto L19
    }

    public final f0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(l r5, int r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.source.receive$okhttp(r5, r10);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void receiveHeaders(c0 r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "headers");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.hasResponseHeaders == false) goto L17;
        if (r10 == false) goto L17;
        this.source.setTrailers(r5);     // Catch: Throwable -> L15
    L18:
        if (r10 == false) goto L20;
        this.source.setFinished$okhttp(true);     // Catch: Throwable -> L15
    L20:
        boolean r11 = isOpen();     // Catch: Throwable -> L15
        notifyAll();     // Catch: Throwable -> L15
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r11 == true) goto L29;
        this.connection.removeStream$okhttp(this.f20663id);
        return;
    L29:
        return;
    L17:
        this.hasResponseHeaders = true;     // Catch: Throwable -> L15
        this.headersQueue.add(r5);     // Catch: Throwable -> L15
        goto L18
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final synchronized void receiveRstStream(ErrorCode r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "errorCode");     // Catch: Throwable -> L7
        if (this.errorCode != null) goto L9;
        this.errorCode = r5;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setErrorCode$okhttp(ErrorCode r5) {
        this.errorCode = r5;
    }

    public final void setErrorException$okhttp(IOException r5) {
        this.errorException = r5;
    }

    public final void setReadBytesAcknowledged$okhttp(long r5) {
        this.readBytesAcknowledged = r5;
    }

    public final void setReadBytesTotal$okhttp(long r5) {
        this.readBytesTotal = r5;
    }

    public final void setWriteBytesMaximum$okhttp(long r5) {
        this.writeBytesMaximum = r5;
    }

    public final void setWriteBytesTotal$okhttp(long r5) {
        this.writeBytesTotal = r5;
    }

    public final synchronized c0 takeHeaders() throws IOException {
        monitor-enter(this);
        this.readTimeout.enter();     // Catch: Throwable -> L17
    L28:
    L10:
        th = move-exception;
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L5:
        if (this.headersQueue.isEmpty() == false) goto L12;
        if (this.errorCode != null) goto L12;
        waitForIo$okhttp();     // Catch: Throwable -> L10
    L12:
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L17
        if (this.headersQueue.isEmpty() == true) goto L19;
        c0 r5 = this.headersQueue.removeFirst();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r5;
    L19:
        IOException r10 = this.errorException;     // Catch: Throwable -> L17
        if (r10 != null) goto L34;
        ErrorCode r11 = this.errorCode;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L17
        throw new StreamResetException(r11);     // Catch: Throwable -> L17
    L34:
        throw r10;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized c0 trailers() throws IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.source.getFinished$okhttp() == false) goto L18;
        if (this.source.getReceiveBuffer().y() == false) goto L18;
        if (this.source.getReadBuffer().y() == false) goto L18;
        c0 r5 = this.source.getTrailers();     // Catch: Throwable -> L15
        if (r5 != null) goto L13;
        r5 = Util.EMPTY_HEADERS;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r5;
    L18:
        if (this.errorCode == null) goto L25;
        IOException r10 = this.errorException;     // Catch: Throwable -> L15
        if (r10 != null) goto L29;
        ErrorCode r11 = this.errorCode;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L15
        throw new StreamResetException(r11);     // Catch: Throwable -> L15
    L29:
        throw r10;     // Catch: Throwable -> L15
    L25:
        throw new IllegalStateException("too early; can't read the trailers yet");     // Catch: Throwable -> L15
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }

    public final void writeHeaders(List<Header> r10, boolean r11, boolean r12) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "responseHeaders");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
        boolean r5 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L14
        if (r11 == false) goto L16;
        this.sink.setFinished(true);     // Catch: Throwable -> L14
    L16:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r12 == true) goto L31;
        Http2Connection r14 = this.connection;
        monitor-enter(r14);
        if (this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum()) goto L26;
        r5 = false;
    L26:
        monitor-exit(r14);
        r12 = r5;
    L28:
        th = move-exception;
        throw th;
    L31:
        this.connection.writeHeaders$okhttp(this.f20663id, r11, r10);
        if (r12 == false) goto L41;
        this.connection.flush();
        return;
    L41:
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final f0 writeTimeout() {
        return this.writeTimeout;
    }
}
