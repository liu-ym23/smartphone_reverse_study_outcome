package okhttp3.internal.http2;

import ai.j0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.j;
import nu.k;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0010J\u001d\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010!J/\u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0011¢\u0006\u0004\b+\u0010\u0014J%\u0010/\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b¢\u0006\u0004\b/\u00100J%\u00104\u001a\u00020\f2\u0006\u00101\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u00106\u001a\u00020\n¢\u0006\u0004\b7\u0010\u000eJ-\u0010:\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\fH\u0016¢\u0006\u0004\b<\u0010\u0010J+\u0010>\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0017\u0010G\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010E¨\u0006M"}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "Lnu/k;", "sink", "", "client", "<init>", "(Lnu/k;Z)V", "", "streamId", "", "byteCount", "", "writeContinuationFrames", "(IJ)V", "connectionPreface", "()V", "Lokhttp3/internal/http2/Settings;", "peerSettings", "applyAndAckSettings", "(Lokhttp3/internal/http2/Settings;)V", "promisedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "maxDataLength", "()I", "outFinished", "Lnu/j;", "source", "data", "(ZILnu/j;I)V", "flags", "buffer", "dataFrame", "(IILnu/j;I)V", "settings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "windowSizeIncrement", "windowUpdate", "length", "type", "frameHeader", "(IIII)V", "close", "headerBlock", "headers", "(ZILjava/util/List;)V", "hpackBuffer", "Lnu/j;", "maxFrameSize", "I", "closed", "Z", "Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "Lnu/k;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Writer implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private boolean closed;
    private final j hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final k sink;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Writer(k r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        this.sink = r10;
        this.client = r11;
        j r5 = new j();
        this.hpackBuffer = r5;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, r5, 3, null);
    }

    private final void writeContinuationFrames(int r10, long r11) throws IOException {
    L3:
        if (r11 <= 0) goto L9;
        long r5 = Math.min(this.maxFrameSize, r11);
        r11 = r11 - r5;
        int r12 = (int) r5;
        if (r11 != 0) goto L7;
        int r13 = 4;
    L8:
        frameHeader(r10, r12, 9, r13);
        this.sink.write(this.hpackBuffer, r5);
        goto L3
    L7:
        r13 = 0;
        goto L8
    }

    public final synchronized void applyAndAckSettings(Settings r5) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "peerSettings");     // Catch: Throwable -> L8
        if (this.closed == true) goto L14;
        this.maxFrameSize = r5.getMaxFrameSize(this.maxFrameSize);     // Catch: Throwable -> L8
        if (r5.getHeaderTableSize() == (-1)) goto L10;
        this.hpackWriter.resizeHeaderTable(r5.getHeaderTableSize());     // Catch: Throwable -> L8
    L10:
        frameHeader(0, 0, 4, 1);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new IOException("closed");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L7
        this.sink.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void connectionPreface() throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L19;
        if (this.client == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        Logger r5 = logger;     // Catch: Throwable -> L13
        if (r5.isLoggable(Level.FINE) == false) goto L15;
        r5.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));     // Catch: Throwable -> L13
    L15:
        this.sink.F(Http2.CONNECTION_PREFACE);     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L19:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public final synchronized void data(boolean r5, int r10, j r11, int r12) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        dataFrame(r10, r5 ? 1 : 0, r11, r12);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final void dataFrame(int r5, int r10, j r11, int r12) throws IOException {
        frameHeader(r5, r12, 0, r10);
        if (r12 <= 0) goto L6;
        k r13 = this.sink;
        Intrinsics.checkNotNull(r11);
        r13.write(r11, r12);
        return;
    }

    public final synchronized void flush() throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final void frameHeader(int r10, int r11, int r12, int r13) throws IOException {
        Logger r5 = logger;
        if (r5.isLoggable(Level.FINE) == false) goto L6;
        r5.fine(Http2.INSTANCE.frameLog(false, r10, r11, r12, r13));
    L6:
        if (r11 > this.maxFrameSize) goto L14;
        if ((((int) 2147483648L) & r10) != 0) goto L12;
        Util.writeMedium(this.sink, r11);
        this.sink.writeByte(r12 & 255);
        this.sink.writeByte(r13 & 255);
        this.sink.writeInt(r10 & Integer.MAX_VALUE);
        return;
    L12:
        throw new IllegalArgumentException(j0.g(r10, "reserved bit set: ").toString());
    L14:
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + r11).toString());
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int r5, ErrorCode r10, byte[] r11) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "errorCode");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r11, "debugData");     // Catch: Throwable -> L14
        if (this.closed == true) goto L19;
        if (r10.getHttpCode() == (-1)) goto L17;
        frameHeader(0, r11.length + 8, 7, 0);     // Catch: Throwable -> L14
        this.sink.writeInt(r5);     // Catch: Throwable -> L14
        this.sink.writeInt(r10.getHttpCode());     // Catch: Throwable -> L14
        if (r11.length == 0) goto L11;
        this.sink.write(r11);     // Catch: Throwable -> L14
    L11:
        this.sink.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new IllegalArgumentException("errorCode.httpCode == -1");     // Catch: Throwable -> L14
    L19:
        throw new IOException("closed");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void headers(boolean r10, int r11, List<Header> r12) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "headerBlock");     // Catch: Throwable -> L15
        if (this.closed == true) goto L20;
        this.hpackWriter.writeHeaders(r12);     // Catch: Throwable -> L15
        long r5 = this.hpackBuffer.f20328b;     // Catch: Throwable -> L15
        long r13 = Math.min(this.maxFrameSize, r5);     // Catch: Throwable -> L15
        if (r5 != r13) goto L8;
        int r14 = 4;
    L9:
        if (r10 == false) goto L11;
        r14 = r14 | 1;     // Catch: Throwable -> L15
    L11:
        frameHeader(r11, (int) r13, 1, r14);     // Catch: Throwable -> L15
        this.sink.write(this.hpackBuffer, r13);     // Catch: Throwable -> L15
        if (r5 <= r13) goto L17;
        writeContinuationFrames(r11, r5 - r13);     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        return;
    L8:
        r14 = 0;
        goto L9
    L20:
        throw new IOException("closed");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean r5, int r10, int r11) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        frameHeader(0, 8, 6, r5 ? 1 : 0);     // Catch: Throwable -> L8
        this.sink.writeInt(r10);     // Catch: Throwable -> L8
        this.sink.writeInt(r11);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final synchronized void pushPromise(int r10, int r11, List<Header> r12) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "requestHeaders");     // Catch: Throwable -> L13
        if (this.closed == true) goto L18;
        this.hpackWriter.writeHeaders(r12);     // Catch: Throwable -> L13
        long r5 = this.hpackBuffer.f20328b;     // Catch: Throwable -> L13
        int r13 = (int) Math.min(((long) this.maxFrameSize) - 4, r5);     // Catch: Throwable -> L13
        int r14 = r13 + 4;     // Catch: Throwable -> L13
        long r15 = r13;
        if (r5 != r15) goto L8;
        int r16 = 4;
    L9:
        frameHeader(r10, r14, 5, r16);     // Catch: Throwable -> L13
        this.sink.writeInt(r11 & Integer.MAX_VALUE);     // Catch: Throwable -> L13
        this.sink.write(this.hpackBuffer, r15);     // Catch: Throwable -> L13
        if (r5 <= r15) goto L15;
        writeContinuationFrames(r10, r5 - r15);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L8:
        r16 = 0;
        goto L9
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void rstStream(int r5, ErrorCode r10) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "errorCode");     // Catch: Throwable -> L10
        if (this.closed == true) goto L15;
        if (r10.getHttpCode() == (-1)) goto L13;
        frameHeader(r5, 4, 3, 0);     // Catch: Throwable -> L10
        this.sink.writeInt(r10.getHttpCode());     // Catch: Throwable -> L10
        this.sink.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L10
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void settings(Settings r5) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "settings");     // Catch: Throwable -> L19
        if (this.closed == true) goto L25;
        int r10 = 0;
        frameHeader(0, r5.size() * 6, 4, 0);     // Catch: Throwable -> L19
    L7:
        if (r10 >= 10) goto L21;
        if (r5.isSet(r10) == false) goto L18;
        if (r10 != 4) goto L13;
        int r11 = 3;
    L17:
        this.sink.writeShort(r11);     // Catch: Throwable -> L19
        this.sink.writeInt(r5.get(r10));     // Catch: Throwable -> L19
        goto L18
    L13:
        if (r10 == 7) goto L15;
        r11 = r10;
        goto L17
    L15:
        r11 = 4;
    L18:
        r10 = r10 + 1;     // Catch: Throwable -> L19
        goto L7
    L21:
        this.sink.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L25:
        throw new IOException("closed");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void windowUpdate(int r5, long r10) throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L18;
        if (r10 == 0) goto L16;
        if (r10 > 2147483647L) goto L16;
        frameHeader(r5, 4, 8, 0);     // Catch: Throwable -> L13
        this.sink.writeInt((int) r10);     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + r10).toString());     // Catch: Throwable -> L13
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }
}
