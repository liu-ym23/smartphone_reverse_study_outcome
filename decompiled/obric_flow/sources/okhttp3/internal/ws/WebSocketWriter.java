package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.g;
import nu.j;
import nu.k;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u0014J\u001d\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u00104R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010%R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00105¨\u00066"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "isClient", "Lnu/k;", "sink", "Ljava/util/Random;", "random", "perMessageDeflate", "noContextTakeover", "", "minimumDeflateSize", "<init>", "(ZLnu/k;Ljava/util/Random;ZZJ)V", "", "opcode", "Lokio/ByteString;", "payload", "", "writeControlFrame", "(ILokio/ByteString;)V", "writePing", "(Lokio/ByteString;)V", "writePong", "code", "reason", "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "Lnu/j;", "messageBuffer", "Lnu/j;", "sinkBuffer", "writerClosed", "Z", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "", "maskKey", "[B", "Lnu/g;", "maskCursor", "Lnu/g;", "Lnu/k;", "getSink", "()Lnu/k;", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "J", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final g maskCursor;
    private final byte[] maskKey;
    private final j messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final k sink;
    private final j sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean r5, k r10, Random r11, boolean r12, boolean r13, long r14) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        Intrinsics.checkNotNullParameter(r11, "random");
        this.isClient = r5;
        this.sink = r10;
        this.random = r11;
        this.perMessageDeflate = r12;
        this.noContextTakeover = r13;
        this.minimumDeflateSize = r14;
        this.messageBuffer = new j();
        this.sinkBuffer = r10.h();
        g r15 = null;
        if (r5 == false) goto L5;
        byte[] r16 = new byte[4];
    L6:
        this.maskKey = r16;
        if (r5 == false) goto L9;
        r15 = new g();
    L9:
        this.maskCursor = r15;
        return;
    L5:
        r16 = null;
        goto L6
    }

    private final void writeControlFrame(int r10, ByteString r11) throws IOException {
        if (this.writerClosed == true) goto L17;
        int r5 = r11.size();
        if (r5 > 125) goto L15;
        this.sinkBuffer.T(r10 | 128);
        if (this.isClient == false) goto L11;
        this.sinkBuffer.T(r5 | 128);
        Random r12 = this.random;
        byte[] r13 = this.maskKey;
        Intrinsics.checkNotNull(r13);
        r12.nextBytes(r13);
        this.sinkBuffer.R(this.maskKey);
        if (r5 <= 0) goto L12;
        j r14 = this.sinkBuffer;
        long r15 = r14.f20328b;
        r14.Q(r11);
        j r16 = this.sinkBuffer;
        g r17 = this.maskCursor;
        Intrinsics.checkNotNull(r17);
        r16.J(r17);
        this.maskCursor.d(r15);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L12:
        this.sink.flush();
        return;
    L11:
        this.sinkBuffer.T(r5);
        this.sinkBuffer.Q(r11);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater r5 = this.messageDeflater;
        if (r5 == null) goto L6;
        r5.close();
        return;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final k getSink() {
        return this.sink;
    }

    public final void writeClose(int r5, ByteString r10) throws IOException {
        ByteString r11 = ByteString.EMPTY;
        if (r5 != 0) goto L5;
        if (r10 != null) goto L5;
    L18:
        writeControlFrame(8, r11);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r5 == 0) goto L7;
        WebSocketProtocol.INSTANCE.validateCloseCode(r5);
    L7:
        j r12 = new j();
        r12.Y(r5);
        if (r10 == null) goto L10;
        r12.Q(r10);
    L10:
        r11 = r12.v(r12.f20328b);
        goto L18
    }

    public final void writeMessageFrame(int r10, ByteString r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (this.writerClosed == true) goto L32;
        this.messageBuffer.Q(r11);
        int r5 = r10 | 128;
        if (this.perMessageDeflate == true) goto L7;
    L13:
        long r12 = this.messageBuffer.f20328b;
        this.sinkBuffer.T(r5);
        if (this.isClient == false) goto L16;
        int r13 = 128;
    L18:
        if (r12 > 125) goto L21;
        this.sinkBuffer.T(r13 | ((int) r12));
    L25:
        if (this.isClient == false) goto L29;
        Random r14 = this.random;
        byte[] r15 = this.maskKey;
        Intrinsics.checkNotNull(r15);
        r14.nextBytes(r15);
        this.sinkBuffer.R(this.maskKey);
        if (r12 <= 0) goto L29;
        j r16 = this.messageBuffer;
        g r17 = this.maskCursor;
        Intrinsics.checkNotNull(r17);
        r16.J(r17);
        this.maskCursor.d(0);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L29:
        this.sinkBuffer.write(this.messageBuffer, r12);
        this.sink.i();
        return;
    L21:
        if (r12 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L23;
        this.sinkBuffer.T(r13 | 126);
        this.sinkBuffer.Y((int) r12);
        goto L25
    L23:
        this.sinkBuffer.T(r13 | 127);
        this.sinkBuffer.X(r12);
        goto L25
    L16:
        r13 = 0;
        goto L18
    L7:
        if (r11.size() < this.minimumDeflateSize) goto L13;
        MessageDeflater r18 = this.messageDeflater;
        if (r18 != null) goto L12;
        r18 = new MessageDeflater(this.noContextTakeover);
        this.messageDeflater = r18;
    L12:
        r18.deflate(this.messageBuffer);
        r5 = r10 | 192;
        goto L13
    L32:
        throw new IOException("closed");
    }

    public final void writePing(ByteString r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "payload");
        writeControlFrame(9, r5);
    }

    public final void writePong(ByteString r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "payload");
        writeControlFrame(10, r5);
    }
}
