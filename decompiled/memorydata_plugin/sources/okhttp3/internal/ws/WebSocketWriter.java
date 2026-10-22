package okhttp3.internal.ws;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(J\u0018\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020(H\u0002J&\u0010,\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003J\u000e\u00100\u001a\u00020%2\u0006\u0010+\u001a\u00020(J\u000e\u00101\u001a\u00020%2\u0006\u0010+\u001a\u00020(R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "", "isClient", "", "sink", "Lokio/BufferedSink;", "random", "Ljava/util/Random;", "(ZLokio/BufferedSink;Ljava/util/Random;)V", "activeWriter", "getActiveWriter", "()Z", "setActiveWriter", "(Z)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "frameSink", "Lokhttp3/internal/ws/WebSocketWriter$FrameSink;", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "getRandom", "()Ljava/util/Random;", "getSink", "()Lokio/BufferedSink;", "sinkBuffer", "writerClosed", "newMessageSink", "Lokio/Sink;", "formatOpcode", "", "contentLength", "", "writeClose", "", "code", InfoRequestQPSOptTraceLogger.REASON, "Lokio/ByteString;", "writeControlFrame", "opcode", "payload", "writeMessageFrame", "byteCount", "isFirstFrame", "isFinal", "writePing", "writePong", "FrameSink", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class WebSocketWriter {
    private boolean activeWriter;
    private final Buffer buffer;
    private final FrameSink frameSink;
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006 "}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter$FrameSink;", "Lokio/Sink;", "(Lokhttp3/internal/ws/WebSocketWriter;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "contentLength", "", "getContentLength", "()J", "setContentLength", "(J)V", "formatOpcode", "", "getFormatOpcode", "()I", "setFormatOpcode", "(I)V", "isFirstFrame", "setFirstFrame", IslandSession.REOPEN_VALUE_CLOSE, "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class FrameSink implements Sink {
        private boolean closed;
        private long contentLength;
        private int formatOpcode;
        private boolean isFirstFrame;
        final /* synthetic */ WebSocketWriter this$0;

        public FrameSink(WebSocketWriter r1) {
            this.this$0 = r1;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == true) goto L7;
            WebSocketWriter r1 = this.this$0;
            r1.writeMessageFrame(this.formatOpcode, r1.getBuffer().size(), this.isFirstFrame, true);
            this.closed = true;
            this.this$0.setActiveWriter(false);
            return;
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed == true) goto L7;
            WebSocketWriter r1 = this.this$0;
            r1.writeMessageFrame(this.formatOpcode, r1.getBuffer().size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final boolean isFirstFrame() {
            return this.isFirstFrame;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        public final void setContentLength(long r1) {
            this.contentLength = r1;
        }

        public final void setFirstFrame(boolean r1) {
            this.isFirstFrame = r1;
        }

        public final void setFormatOpcode(int r1) {
            this.formatOpcode = r1;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.this$0.getSink().timeout();
        }

        @Override // okio.Sink
        public void write(Buffer r7, long r8) {
            Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
            if (this.closed == true) goto L18;
            this.this$0.getBuffer().write(r7, r8);
            if (this.isFirstFrame == true) goto L7;
        L11:
            boolean r9 = false;
        L12:
            long r2 = this.this$0.getBuffer().completeSegmentByteCount();
            if (r2 <= 0) goto L19;
            if (r9 == true) goto L20;
            this.this$0.writeMessageFrame(this.formatOpcode, r2, this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.contentLength == (-1)) goto L11;
            if (this.this$0.getBuffer().size() <= (this.contentLength - ((long) 8192))) goto L11;
            r9 = true;
            goto L12
        L18:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    public WebSocketWriter(boolean r3, BufferedSink r4, Random r5) {
        BufferedSink r6 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        Intrinsics.checkParameterIsNotNull(r5, "random");
        this.isClient = r3;
        this.sink = r6;
        this.random = r5;
        this.sinkBuffer = r6.getBuffer();
        this.buffer = new Buffer();
        this.frameSink = new FrameSink(this);
        Buffer.UnsafeCursor r7 = null;
        if (r3 == false) goto L5;
        byte[] r8 = new byte[4];
    L6:
        this.maskKey = r8;
        if (r3 == false) goto L9;
        r7 = new Buffer.UnsafeCursor();
    L9:
        this.maskCursor = r7;
        return;
    L5:
        r8 = null;
        goto L6
    }

    private final void writeControlFrame(int r7, ByteString r8) {
        if (this.writerClosed == true) goto L26;
        int r0 = r8.size();
        if (r0 > 125) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L24;
        this.sinkBuffer.writeByte(r7 | 128);
        if (this.isClient == false) goto L20;
        this.sinkBuffer.writeByte(r0 | 128);
        Random r9 = this.random;
        byte[] r1 = this.maskKey;
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r9.nextBytes(r1);
        this.sinkBuffer.write(this.maskKey);
        if (r0 <= 0) goto L21;
        long r3 = this.sinkBuffer.size();
        this.sinkBuffer.write(r8);
        Buffer r10 = this.sinkBuffer;
        Buffer.UnsafeCursor r11 = this.maskCursor;
        if (r11 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r10.readAndWriteUnsafe(r11);
        this.maskCursor.seek(r3);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L21:
        this.sink.flush();
        return;
    L20:
        this.sinkBuffer.writeByte(r0);
        this.sinkBuffer.write(r8);
        goto L21
    L24:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Payload size must be less than or equal to 125".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        r2 = false;
        goto L8
    L26:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean getActiveWriter() {
        return this.activeWriter;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final Sink newMessageSink(int r4, long r5) {
        if ((!this.activeWriter) == false) goto L7;
        this.activeWriter = true;
        this.frameSink.setFormatOpcode(r4);
        this.frameSink.setContentLength(r5);
        this.frameSink.setFirstFrame(true);
        this.frameSink.setClosed(false);
        return (Sink) ZeusTransformUtils.preCheckCast(this.frameSink, Sink.class, "com.obric.memorydata.plugin");
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Another message writer is active. Did you call close()?".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void setActiveWriter(boolean r1) {
        this.activeWriter = r1;
    }

    public final void writeClose(int r2, ByteString r3) {
        ByteString r0 = ByteString.EMPTY;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        writeControlFrame(8, r0);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        WebSocketProtocol.INSTANCE.validateCloseCode(r2);
    L7:
        Buffer r1 = new Buffer();
        r1.writeShort(r2);
        if (r3 == null) goto L10;
        r1.write(r3);
    L10:
        r0 = r1.readByteString();
        goto L18
    }

    public final void writeMessageFrame(int r2, long r3, boolean r5, boolean r6) {
        if (this.writerClosed == true) goto L35;
        int r0 = 0;
        if (r5 == true) goto L8;
        r2 = 0;
    L8:
        if (r6 == false) goto L10;
        r2 = r2 | 128;
    L10:
        this.sinkBuffer.writeByte(r2);
        if (this.isClient == false) goto L14;
        r0 = 128;
    L14:
        if (r3 > 125) goto L17;
        this.sinkBuffer.writeByte(((int) r3) | r0);
    L21:
        if (this.isClient == false) goto L31;
        Random r4 = this.random;
        byte[] r7 = this.maskKey;
        if (r7 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r4.nextBytes(r7);
        this.sinkBuffer.write(this.maskKey);
        if (r3 <= 0) goto L32;
        long r8 = this.sinkBuffer.size();
        this.sinkBuffer.write(this.buffer, r3);
        Buffer r9 = this.sinkBuffer;
        Buffer.UnsafeCursor r10 = this.maskCursor;
        if (r10 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        r9.readAndWriteUnsafe(r10);
        this.maskCursor.seek(r8);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L32:
        this.sink.emit();
        return;
    L31:
        this.sinkBuffer.write(this.buffer, r3);
        goto L32
    L17:
        if (r3 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L19;
        this.sinkBuffer.writeByte(r0 | WebSocketProtocol.PAYLOAD_SHORT);
        this.sinkBuffer.writeShort((int) r3);
        goto L21
    L19:
        this.sinkBuffer.writeByte(r0 | 127);
        this.sinkBuffer.writeLong(r3);
        goto L21
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void writePing(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "payload");
        writeControlFrame(9, r2);
    }

    public final void writePong(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "payload");
        writeControlFrame(10, r2);
    }
}
