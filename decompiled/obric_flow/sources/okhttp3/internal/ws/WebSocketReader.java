package okhttp3.internal.ws;

import com.bytedance.ai.event.MessageIndication;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.g;
import nu.j;
import nu.l;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00011B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00100R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016¨\u00062"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "", "isClient", "Lnu/l;", "source", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLnu/l;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "", "readHeader", "()V", "readControlFrame", "readMessageFrame", "readUntilNonControlFrame", "readMessage", "processNextFrame", "close", "closed", "Z", "", "opcode", "I", "", "frameLength", "J", "isFinalFrame", "isControlFrame", "readingCompressedMessage", "Lnu/j;", "controlFrameBuffer", "Lnu/j;", "messageFrameBuffer", "Lokhttp3/internal/ws/MessageInflater;", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "", "maskKey", "[B", "Lnu/g;", "maskCursor", "Lnu/g;", "Lnu/l;", "getSource", "()Lnu/l;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "FrameCallback", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final j controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final g maskCursor;
    private final byte[] maskKey;
    private final j messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final l source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "onReadClose", "", "code", "", "reason", "", "onReadMessage", MessageIndication.CONTENT_TYPE_TEXT, "bytes", "Lokio/ByteString;", "onReadPing", "payload", "onReadPong", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface FrameCallback {
        void onReadClose(int r5, String r10);

        void onReadMessage(String r5) throws IOException;

        void onReadMessage(ByteString r5) throws IOException;

        void onReadPing(ByteString r5);

        void onReadPong(ByteString r5);
    }

    public WebSocketReader(boolean r5, l r10, FrameCallback r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "frameCallback");
        this.isClient = r5;
        this.source = r10;
        this.frameCallback = r11;
        this.perMessageDeflate = r12;
        this.noContextTakeover = r13;
        this.controlFrameBuffer = new j();
        this.messageFrameBuffer = new j();
        g r14 = null;
        if (r5 == false) goto L5;
        byte[] r15 = null;
    L6:
        this.maskKey = r15;
        if (r5 == true) goto L10;
        r14 = new g();
    L10:
        this.maskCursor = r14;
        return;
    L5:
        r15 = new byte[4];
        goto L6
    }

    private final void readControlFrame() throws IOException {
        long r5 = this.frameLength;
        if (r5 <= 0) goto L8;
        this.source.a(this.controlFrameBuffer, r5);
        if (this.isClient == true) goto L8;
        j r10 = this.controlFrameBuffer;
        g r11 = this.maskCursor;
        Intrinsics.checkNotNull(r11);
        r10.J(r11);
        this.maskCursor.d(0);
        WebSocketProtocol r12 = WebSocketProtocol.INSTANCE;
        g r13 = this.maskCursor;
        byte[] r14 = this.maskKey;
        Intrinsics.checkNotNull(r14);
        r12.toggleMask(r13, r14);
        this.maskCursor.close();
    L8:
        switch(this.opcode) {
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        FrameCallback r15 = this.frameCallback;
        j r16 = this.controlFrameBuffer;
        r15.onReadPong(r16.v(r16.f20328b));
        return;
    L12:
        FrameCallback r17 = this.frameCallback;
        j r18 = this.controlFrameBuffer;
        r17.onReadPing(r18.v(r18.f20328b));
        return;
    L13:
        j r19 = this.controlFrameBuffer;
        long r20 = r19.f20328b;
        if (r20 == 1) goto L26;
        if (r20 == 0) goto L22;
        short r21 = r19.readShort();
        String r22 = this.controlFrameBuffer.M();
        String r23 = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(r21);
        if (r23 != null) goto L21;
    L23:
        this.frameCallback.onReadClose(r21, r22);
        this.closed = true;
        return;
    L21:
        throw new ProtocolException(r23);
    L22:
        r21 = 1005;
        r22 = "";
        goto L23
    L26:
        throw new ProtocolException("Malformed close payload length of 1.");
    L10:
        throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
    }

    private final void readHeader() throws IOException, ProtocolException {
        if (this.closed == true) goto L83;
        long r5 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int r10 = Util.and(this.source.readByte(), 255);     // Catch: Throwable -> L79
        this.source.timeout().timeout(r5, TimeUnit.NANOSECONDS);
        int r11 = r10 & 15;
        this.opcode = r11;
        boolean r12 = false;
        if ((r10 & 128) == 0) goto L9;
        boolean r13 = true;
    L10:
        this.isFinalFrame = r13;
        if ((r10 & 8) == 0) goto L13;
        boolean r14 = true;
    L14:
        this.isControlFrame = r14;
        if (r14 == false) goto L21;
        if (r13 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r10 & 64) == 0) goto L23;
        boolean r15 = true;
    L25:
        if (r11 != 1) goto L27;
    L32:
        if (r15 == true) goto L34;
        boolean r16 = false;
    L39:
        this.readingCompressedMessage = r16;
    L41:
        if ((r10 & 32) != 0) goto L78;
        if ((r10 & 16) != 0) goto L76;
        int r17 = Util.and(this.source.readByte(), 255);
        if ((r17 & 128) == 0) goto L48;
        r12 = true;
    L48:
        if (r12 == this.isClient) goto L50;
        long r18 = r17 & 127;
        this.frameLength = r18;
        if (r18 != 126) goto L59;
        this.frameLength = Util.and(this.source.readShort(), 65535);
    L66:
        if (this.isControlFrame == true) goto L68;
    L72:
        if (r12 == false) goto L86;
        l r19 = this.source;
        byte[] r20 = this.maskKey;
        Intrinsics.checkNotNull(r20);
        r19.readFully(r20);
        return;
    L86:
        return;
    L68:
        if (this.frameLength <= 125) goto L72;
        throw new ProtocolException("Control frame must be less than 125B.");
    L59:
        if (r18 != 127) goto L66;
        long r21 = this.source.readLong();
        this.frameLength = r21;
        if (r21 >= 0) goto L66;
        throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L50:
        if (this.isClient == false) goto L52;
        String r22 = "Server-sent frames must not be masked.";
    L54:
        throw new ProtocolException(r22);
    L52:
        r22 = "Client-sent frames must be masked.";
        goto L54
    L76:
        throw new ProtocolException("Unexpected rsv3 flag");
    L78:
        throw new ProtocolException("Unexpected rsv2 flag");
    L34:
        if (this.perMessageDeflate == false) goto L37;
        r16 = true;
        goto L39
    L37:
        throw new ProtocolException("Unexpected rsv1 flag");
    L27:
        if (r11 == 2) goto L32;
        if (r15 == false) goto L41;
        throw new ProtocolException("Unexpected rsv1 flag");
    L23:
        r15 = false;
        goto L25
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L79:
        th = move-exception;
        this.source.timeout().timeout(r5, TimeUnit.NANOSECONDS);
        throw th;
    L83:
        throw new IOException("closed");
    }

    private final void readMessage() throws IOException {
    L3:
        if (this.closed == true) goto L18;
        long r5 = this.frameLength;
        if (r5 <= 0) goto L10;
        this.source.a(this.messageFrameBuffer, r5);
        if (this.isClient == true) goto L10;
        j r10 = this.messageFrameBuffer;
        g r11 = this.maskCursor;
        Intrinsics.checkNotNull(r11);
        r10.J(r11);
        this.maskCursor.d(this.messageFrameBuffer.f20328b - this.frameLength);
        WebSocketProtocol r12 = WebSocketProtocol.INSTANCE;
        g r13 = this.maskCursor;
        byte[] r14 = this.maskKey;
        Intrinsics.checkNotNull(r14);
        r12.toggleMask(r13, r14);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int r5 = this.opcode;
        if (r5 != 1) goto L5;
    L9:
        readMessage();
        if (this.readingCompressedMessage == false) goto L16;
        MessageInflater r10 = this.messageInflater;
        if (r10 != null) goto L15;
        r10 = new MessageInflater(this.noContextTakeover);
        this.messageInflater = r10;
    L15:
        r10.inflate(this.messageFrameBuffer);
    L16:
        if (r5 != 1) goto L18;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.M());
        return;
    L18:
        FrameCallback r11 = this.frameCallback;
        j r12 = this.messageFrameBuffer;
        r11.onReadMessage(r12.v(r12.f20328b));
        return;
    L5:
        if (r5 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Util.toHexString(r5));
    }

    private final void readUntilNonControlFrame() throws IOException {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater r5 = this.messageInflater;
        if (r5 == null) goto L6;
        r5.close();
        return;
    }

    public final l getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }
}
