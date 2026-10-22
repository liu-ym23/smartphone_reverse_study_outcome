package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0097\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", IslandSession.REOPEN_VALUE_CLOSE, "", "emit", "emitCompleteSegments", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "isOpen", "outputStream", "Ljava/io/OutputStream;", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "toString", "", "write", "", AILabCheckPermissionTask.KEY_SOURCE, "Ljava/nio/ByteBuffer;", "", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", BaseSwitches.V, "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", TypedValues.Custom.S_STRING, "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "jvm"}, k = 1, mv = {1, 1, 11})
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink r3) {
        Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        this.sink = r4;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void buffer$annotations() {
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        Throwable th = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
    L10:
        th = th;
    L22:
        this.sink.close();     // Catch: Throwable -> L13
    L16:
        this.closed = true;
        if (th != null) goto L19;
        return;
    L19:
        throw th;
    L13:
        th = move-exception;
        if (th != null) goto L16;
        th = th;
        goto L16
    L7:
        if (this.bufferField.size() <= 0) goto L22;
        Sink r1 = this.sink;     // Catch: Throwable -> L10
        Buffer r2 = this.bufferField;     // Catch: Throwable -> L10
        r1.write(r2, r2.size());     // Catch: Throwable -> L10
        goto L22
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        if ((!this.closed) == false) goto L10;
        long r2 = this.bufferField.size();
        if (r2 <= 0) goto L8;
        this.sink.write(this.bufferField, r2);
    L8:
        return (BufferedSink) ZeusTransformUtils.preCheckCast(this, BufferedSink.class, "com.obric.memorydata.plugin");
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if ((!this.closed) == false) goto L10;
        long r2 = this.bufferField.completeSegmentByteCount();
        if (r2 <= 0) goto L8;
        this.sink.write(this.bufferField, r2);
    L8:
        return (BufferedSink) ZeusTransformUtils.preCheckCast(this, BufferedSink.class, "com.obric.memorydata.plugin");
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if ((!this.closed) == false) goto L10;
        if (this.bufferField.size() <= 0) goto L7;
        Sink r0 = this.sink;
        Buffer r1 = this.bufferField;
        r0.write(r1, r1.size());
    L7:
        this.sink.flush();
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return (OutputStream) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), OutputStream.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r2) {
        Intrinsics.checkParameterIsNotNull(r2, AILabCheckPermissionTask.KEY_SOURCE);
        if ((!this.closed) == false) goto L7;
        int r3 = this.bufferField.write(r2);
        emitCompleteSegments();
        return r3;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "byteString");
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r7, long r8) {
        Source r9 = (Source) ZeusTransformUtils.wrapperContextForParams(r7, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, AILabCheckPermissionTask.KEY_SOURCE);
    L4:
        if (r8 <= 0) goto L11;
        long r2 = r9.read(this.bufferField, r8);
        if (r2 == (-1)) goto L9;
        r8 = r8 - r2;
        emitCompleteSegments();
        goto L4
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        return (BufferedSink) ZeusTransformUtils.preCheckCast(this, BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, AILabCheckPermissionTask.KEY_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r2, int r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, AILabCheckPermissionTask.KEY_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.Sink
    public void write(Buffer r2, long r3) {
        Intrinsics.checkParameterIsNotNull(r2, AILabCheckPermissionTask.KEY_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2, r3);
        emitCompleteSegments();
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r7) {
        Source r8 = (Source) ZeusTransformUtils.wrapperContextForParams(r7, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r8.read(this.bufferField, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        emitCompleteSegments();
        goto L3
    L5:
        return r0;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeByte(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeDecimalLong(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeHexadecimalUnsignedLong(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeInt(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeIntLe(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeLong(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeLongLe(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeShort(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeShortLe(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r2, int r3, int r4, Charset r5) {
        Intrinsics.checkParameterIsNotNull(r2, TypedValues.Custom.S_STRING);
        Intrinsics.checkParameterIsNotNull(r5, "charset");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeString(r2, r3, r4, r5);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r2, Charset r3) {
        Intrinsics.checkParameterIsNotNull(r2, TypedValues.Custom.S_STRING);
        Intrinsics.checkParameterIsNotNull(r3, "charset");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeString(r2, r3);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, TypedValues.Custom.S_STRING);
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r2, int r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, TypedValues.Custom.S_STRING);
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8CodePoint(r2);
        return emitCompleteSegments();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
