package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0097\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", IslandSession.REOPEN_VALUE_CLOSE, "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", TypedValues.CycleType.S_WAVE_OFFSET, "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", Ext.KEY_REQUEST, "require", "select", "options", "Lokio/Options;", "skip", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "toString", "jvm"}, k = 1, mv = {1, 1, 11})
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source r3) {
        Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, AILabCheckPermissionTask.KEY_SOURCE);
        this.source = r4;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void buffer$annotations() {
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Source
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if ((!this.closed) == false) goto L12;
        if (this.bufferField.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) {
        boolean r1 = true;
        if ((!this.closed) == false) goto L27;
        if (0 <= r11) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L25;
    L13:
        if (r11 >= r13) goto L23;
        long r3 = this.bufferField.indexOf(r10, r11, r13);
        if (r3 != (-1)) goto L16;
        long r4 = this.bufferField.size();
        if (r4 >= r13) goto L23;
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L23;
        r11 = Math.max(r11, r4);
        goto L13
    L16:
        return r3;
    L23:
        return -1;
    L25:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("fromIndex=" + r11 + " toIndex=" + r13).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        if (r13 < r11) goto L10;
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) {
        Intrinsics.checkParameterIsNotNull(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r9, long r10) {
        Intrinsics.checkParameterIsNotNull(r9, "bytes");
        if ((!this.closed) == false) goto L12;
    L4:
        long r0 = this.bufferField.indexOf(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, (r1 - ((long) r9.size())) + 1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        Intrinsics.checkParameterIsNotNull(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r9, long r10) {
        Intrinsics.checkParameterIsNotNull(r9, "targetBytes");
        if ((!this.closed) == false) goto L12;
    L4:
        long r0 = this.bufferField.indexOfElement(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, r1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return (InputStream) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), InputStream.class, "com.obric.memorydata.plugin");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer((Source) ZeusTransformUtils.preCheckCast(new PeekSource((BufferedSource) ZeusTransformUtils.preCheckCast(this, BufferedSource.class, "com.obric.memorydata.plugin")), Source.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkParameterIsNotNull(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, "bytes");
        if ((!this.closed) == false) goto L23;
        if (r8 < 0) goto L21;
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L21;
        if ((r10.size() - r11) < r12) goto L21;
        int r0 = 0;
    L12:
        if (r0 >= r12) goto L20;
        long r3 = ((long) r0) + r8;
        if (request(1 + r3) == false) goto L15;
        if (this.bufferField.getByte(r3) != r10.getByte(r11 + r0)) goto L18;
        r0 = r0 + 1;
        goto L12
    L18:
        return false;
    L15:
        return false;
    L20:
        return true;
    L21:
        return false;
    L23:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r5) {
        Intrinsics.checkParameterIsNotNull(r5, "sink");
        if (this.bufferField.size() != 0) goto L9;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.bufferField.read(r5);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        Intrinsics.checkParameterIsNotNull(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, "sink");
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        if (this.bufferField.size() != 0) goto L9;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.bufferField.read(r10, r11, (int) Math.min(r7, this.bufferField.size()));
    }

    @Override // okio.Source
    public long read(Buffer r6, long r7) {
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L20;
        if ((!this.closed) == false) goto L18;
        if (this.bufferField.size() != 0) goto L16;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L16;
        return -1;
    L16:
        return this.bufferField.read(r6, Math.min(r7, this.bufferField.size()));
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r7).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r9) {
        Sink r10 = (Sink) ZeusTransformUtils.wrapperContextForParams(r9, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r10, "sink");
        long r2 = 0;
    L4:
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L9;
        long r4 = this.bufferField.completeSegmentByteCount();
        if (r4 <= 0) goto L4;
        r2 = r2 + r4;
        r10.write(this.bufferField, r4);
        goto L4
    L9:
        if (this.bufferField.size() <= 0) goto L17;
        long r3 = r2 + this.bufferField.size();
        Buffer r8 = this.bufferField;
        r10.write(r8, r8.size());
        return r3;
    L17:
        return r2;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r1) {
        require(r1);
        return this.bufferField.readByteArray(r1);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r1) {
        require(r1);
        return this.bufferField.readByteString(r1);
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (request(r6) == false) goto L20;
        byte r8 = this.bufferField.getByte(r4);
        if (r8 < ((byte) 48)) goto L10;
        if (r8 > ((byte) 57)) goto L10;
    L14:
        r4 = r6;
    L10:
        if (r4 != 0) goto L15;
        if (r8 == ((byte) 45)) goto L14;
    L15:
        if (r4 != 0) goto L20;
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r1 = String.format("Expected leading [0-9] or '-' character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(r8)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(r1, "java.lang.String.format(format, *args)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException(r1), Throwable.class, "com.obric.memorydata.plugin"));
    L20:
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r2, long r3) {
        Intrinsics.checkParameterIsNotNull(r2, "sink");
        require(r3);     // Catch: EOFException -> L6
        this.bufferField.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll((Source) ZeusTransformUtils.preCheckCast(this.bufferField, Source.class, "com.obric.memorydata.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r7) {
        Intrinsics.checkParameterIsNotNull(r7, "sink");
        require(r7.length);     // Catch: EOFException -> L6
        this.bufferField.readFully(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (this.bufferField.size() <= 0) goto L16;
        Buffer r2 = this.bufferField;
        int r3 = r2.read(r7, r1, (int) r2.size());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(), Throwable.class, "com.obric.memorydata.plugin"));
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        require(1);
        int r1 = 0;
    L3:
        int r2 = r1 + 1;
        if (request(r2) == false) goto L24;
        byte r3 = this.bufferField.getByte(r1);
        if (r3 < ((byte) 48)) goto L10;
        if (r3 > ((byte) 57)) goto L10;
    L18:
        r1 = r2;
    L10:
        if (r3 < ((byte) 97)) goto L14;
        if (r3 <= ((byte) 102)) goto L18;
    L14:
        if (r3 < ((byte) 65)) goto L19;
        if (r3 <= ((byte) 70)) goto L18;
    L19:
        if (r1 != 0) goto L24;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r0 = String.format("Expected leading [0-9a-fA-F] character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(r0, "java.lang.String.format(format, *args)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException(r0), Throwable.class, "com.obric.memorydata.plugin"));
    L24:
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(long r2, Charset r4) {
        Intrinsics.checkParameterIsNotNull(r4, "charset");
        require(r2);
        return this.bufferField.readString(r2, r4);
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        Intrinsics.checkParameterIsNotNull(r3, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(r3);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r1) {
        require(r1);
        return this.bufferField.readUtf8(r1);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1);
        byte r0 = this.bufferField.getByte(0);
        if ((r0 & MessagePack.Code.NEGFIXINT_PREFIX) != 192) goto L7;
        long r1 = 2;
    L5:
        require(r1);
    L13:
        return this.bufferField.readUtf8CodePoint();
    L7:
        if ((r0 & 240) != 224) goto L10;
        r1 = 3;
        goto L5
    L10:
        if ((r0 & 248) != 240) goto L13;
        r1 = 4;
        goto L5
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (this.bufferField.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.bufferField.size());
    L9:
        return this.bufferField.readUtf8Line$jvm(r0);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r18) {
        if (r18 < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L31;
        if (r18 != Long.MAX_VALUE) goto L11;
        long r14 = Long.MAX_VALUE;
    L12:
        byte r4 = (byte) 10;
        long r1 = indexOf(r4, 0, r14);
        if (r1 == (-1)) goto L17;
        return this.bufferField.readUtf8Line$jvm(r1);
    L17:
        if (r14 < Long.MAX_VALUE) goto L19;
    L28:
        Buffer r2 = new Buffer();
        Buffer r10 = this.bufferField;
        r10.copyTo(r2, 0, Math.min(32, r10.size()));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), r18) + " content=" + r2.readByteString().hex() + "…"), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        if (request(r14) == false) goto L28;
        if (this.bufferField.getByte(r14 - 1) != ((byte) 13)) goto L28;
        if (request(1 + r14) == false) goto L28;
        if (this.bufferField.getByte(r14) != r4) goto L28;
        return this.bufferField.readUtf8Line$jvm(r14);
    L11:
        r14 = r18 + 1;
        goto L12
    L31:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("limit < 0: " + r18).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public boolean request(long r8) {
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L19;
        if ((!this.closed) == false) goto L17;
    L11:
        if (this.bufferField.size() >= r8) goto L15;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L11;
        return false;
    L15:
        return true;
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r8).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public void require(long r1) {
        if (request(r1) == false) goto L6;
        return;
    L6:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public int select(Options r9) {
        Intrinsics.checkParameterIsNotNull(r9, "options");
        if ((!this.closed) == false) goto L14;
    L4:
        int r0 = this.bufferField.selectPrefix$jvm(r9, true);
        if (r0 != (-2)) goto L6;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L4;
        return -1;
    L6:
        if (r0 == (-1)) goto L9;
        this.bufferField.skip(r9.getByteStrings$jvm()[r0].size());
        return r0;
    L9:
        return -1;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public void skip(long r7) {
        if ((!this.closed) == false) goto L16;
    L5:
        if (r7 <= 0) goto L14;
        if (this.bufferField.size() != 0) goto L13;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        long r2 = Math.min(r7, this.bufferField.size());
        this.bufferField.skip(r2);
        r7 = r7 - r2;
        goto L5
    L14:
        return;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
