package okhttp3.internal.ws;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "", "isClient", "", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "controlFrameBuffer", "Lokio/Buffer;", "frameLength", "", "isControlFrame", "isFinalFrame", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageFrameBuffer", "opcode", "", "getSource", "()Lokio/BufferedSource;", "processNextFrame", "", "readControlFrame", "readHeader", "readMessage", "readMessageFrame", "readUntilNonControlFrame", "FrameCallback", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class WebSocketReader {
    private boolean closed;
    private final Buffer controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    private int opcode;
    private final BufferedSource source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "onReadClose", "", "code", "", InfoRequestQPSOptTraceLogger.REASON, "", "onReadMessage", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "bytes", "Lokio/ByteString;", "onReadPing", "payload", "onReadPong", "okhttp"}, k = 1, mv = {1, 1, 15})
    public interface FrameCallback {
        void onReadClose(int r1, String r2);

        void onReadMessage(String r1);

        void onReadMessage(ByteString r1);

        void onReadPing(ByteString r1);

        void onReadPong(ByteString r1);
    }

    public WebSocketReader(boolean r3, BufferedSource r4, FrameCallback r5) {
        BufferedSource r6 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSource.class, "com.obric.memorydata.plugin");
        FrameCallback r7 = (FrameCallback) ZeusTransformUtils.wrapperContextForParams(r5, FrameCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r7, "frameCallback");
        this.isClient = r3;
        this.source = r6;
        this.frameCallback = r7;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        Buffer.UnsafeCursor r8 = null;
        if (r3 == false) goto L5;
        byte[] r9 = null;
    L6:
        this.maskKey = r9;
        if (r3 == true) goto L10;
        r8 = new Buffer.UnsafeCursor();
    L10:
        this.maskCursor = r8;
        return;
    L5:
        r9 = new byte[4];
        goto L6
    }

    private final void readControlFrame() {
        long r0 = this.frameLength;
        if (r0 <= 0) goto L14;
        this.source.readFully(this.controlFrameBuffer, r0);
        if (this.isClient == true) goto L14;
        Buffer r1 = this.controlFrameBuffer;
        Buffer.UnsafeCursor r2 = this.maskCursor;
        if (r2 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r1.readAndWriteUnsafe(r2);
        this.maskCursor.seek(0);
        WebSocketProtocol r3 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        if (r5 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r3.toggleMask(r4, r5);
        this.maskCursor.close();
    L14:
        switch(this.opcode) {
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L16;
        };
    L17:
        this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
        return;
    L18:
        this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
        return;
    L19:
        short r6 = 1005;
        long r7 = this.controlFrameBuffer.size();
        if (r7 == 1) goto L32;
        if (r7 == 0) goto L28;
        r6 = this.controlFrameBuffer.readShort();
        String r8 = this.controlFrameBuffer.readUtf8();
        String r9 = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(r6);
        if (r9 != null) goto L27;
    L29:
        this.frameCallback.onReadClose(r6, r8);
        this.closed = true;
        return;
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException(r9), Throwable.class, "com.obric.memorydata.plugin"));
    L28:
        r8 = "";
        goto L29
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Malformed close payload length of 1."), Throwable.class, "com.obric.memorydata.plugin"));
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode)), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readHeader() {
        if (this.closed == true) goto L76;
        long r2 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int r0 = Util.and(this.source.readByte(), 255);     // Catch: Throwable -> L72
        this.source.timeout().timeout(r2, TimeUnit.NANOSECONDS);
        this.opcode = r0 & 15;
        boolean r3 = true;
        if ((r0 & 128) == 0) goto L9;
        boolean r4 = true;
    L10:
        this.isFinalFrame = r4;
        if ((r0 & 8) == 0) goto L13;
        boolean r6 = true;
    L14:
        this.isControlFrame = r6;
        if (r6 == false) goto L21;
        if (r4 == true) goto L21;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Control frames must be final."), Throwable.class, "com.obric.memorydata.plugin"));
    L21:
        if ((r0 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if ((r0 & 32) == 0) goto L27;
        boolean r7 = true;
    L29:
        if ((r0 & 16) == 0) goto L31;
        boolean r1 = true;
    L32:
        if (r5 == true) goto L71;
        if (r7 == true) goto L71;
        if (r1 == true) goto L71;
        int r8 = Util.and(this.source.readByte(), 255);
        if ((r8 & 128) != 0) goto L40;
        r3 = false;
    L40:
        if (r3 == this.isClient) goto L42;
        long r9 = r8 & 127;
        this.frameLength = r9;
        if (r9 != WebSocketProtocol.PAYLOAD_SHORT) goto L51;
        this.frameLength = Util.and(this.source.readShort(), 65535);
    L58:
        if (this.isControlFrame == true) goto L60;
    L64:
        if (r3 == false) goto L79;
        BufferedSource r10 = this.source;
        byte[] r11 = this.maskKey;
        if (r11 != null) goto L68;
        Intrinsics.throwNpe();
    L68:
        r10.readFully(r11);
        return;
    L79:
        return;
    L60:
        if (this.frameLength <= 125) goto L64;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Control frame must be less than 125B."), Throwable.class, "com.obric.memorydata.plugin"));
    L51:
        if (r9 != 127) goto L58;
        long r12 = this.source.readLong();
        this.frameLength = r12;
        if (r12 >= 0) goto L58;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF"), Throwable.class, "com.obric.memorydata.plugin"));
    L42:
        if (this.isClient == false) goto L44;
        String r13 = "Server-sent frames must not be masked.";
    L46:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException(r13), Throwable.class, "com.obric.memorydata.plugin"));
    L44:
        r13 = "Client-sent frames must be masked.";
    L71:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Reserved flags are unsupported."), Throwable.class, "com.obric.memorydata.plugin"));
    L31:
        r1 = false;
        goto L32
    L27:
        r7 = false;
        goto L29
    L23:
        r5 = false;
        goto L25
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
    L72:
        th = move-exception;
        this.source.timeout().timeout(r2, TimeUnit.NANOSECONDS);
        throw th;
    L76:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readMessage() {
    L3:
        if (this.closed == true) goto L24;
        long r2 = this.frameLength;
        if (r2 <= 0) goto L16;
        this.source.readFully(this.messageFrameBuffer, r2);
        if (this.isClient == true) goto L16;
        Buffer r0 = this.messageFrameBuffer;
        Buffer.UnsafeCursor r3 = this.maskCursor;
        if (r3 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r0.readAndWriteUnsafe(r3);
        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol r1 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r1.toggleMask(r4, r5);
        this.maskCursor.close();
    L16:
        if (this.isFinalFrame == true) goto L17;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode)), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        return;
    L24:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("closed"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readMessageFrame() {
        int r0 = this.opcode;
        if (r0 != 1) goto L5;
    L9:
        readMessage();
        if (r0 != 1) goto L12;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L12:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unknown opcode: " + Util.toHexString(r0)), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readUntilNonControlFrame() {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }

    public final void setClosed(boolean r1) {
        this.closed = r1;
    }
}
