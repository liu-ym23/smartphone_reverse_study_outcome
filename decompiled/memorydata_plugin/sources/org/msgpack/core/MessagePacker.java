package org.msgpack.core;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Flushable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.time.Instant;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.value.Value;

/* JADX INFO: loaded from: classes7.dex */
public class MessagePacker implements Closeable, Flushable {
    private static final boolean CORRUPTED_CHARSET_ENCODER = false;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int UTF_8_MAX_CHAR_SIZE = 6;
    private MessageBuffer buffer;
    private final int bufferFlushThreshold;
    private CharsetEncoder encoder;
    protected MessageBufferOutput out;
    private int position;
    private final int smallStringOptimizationThreshold;
    private final boolean str8FormatSupport;
    private long totalFlushBytes;

    static {
        boolean r0 = false;
        Class r1 = ZeusTransformUtils.forName("android.os.Build$VERSION", "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        Object r2 = r1.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        int r3 = r1.getField("SDK_INT").getInt(r2);     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        goto L19
    L5:
        if (r3 < 14) goto L19;
        if (r3 >= 21) goto L19;
        r0 = true;
    L15:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L19:
        CORRUPTED_CHARSET_ENCODER = r0;
    }

    public MessagePacker(MessageBufferOutput r3, MessagePack.PackerConfig r4) {
        this.out = (MessageBufferOutput) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((MessageBufferOutput) ZeusTransformUtils.wrapperContextForParams(r3, MessageBufferOutput.class, "com.obric.memorydata.plugin"), "MessageBufferOutput is null"), MessageBufferOutput.class, "com.obric.memorydata.plugin");
        this.smallStringOptimizationThreshold = r4.getSmallStringOptimizationThreshold();
        this.bufferFlushThreshold = r4.getBufferFlushThreshold();
        this.str8FormatSupport = r4.isStr8FormatSupport();
        this.position = 0;
        this.totalFlushBytes = 0;
    }

    private int encodeStringToBufferAt(int r4, String r5) {
        prepareEncoder();
        MessageBuffer r0 = this.buffer;
        ByteBuffer r6 = r0.sliceAsByteBuffer(r4, r0.size() - r4);
        int r1 = r6.position();
        CharBuffer r7 = CharBuffer.wrap(r5);
        CoderResult r8 = this.encoder.encode(r7, r6, true);
        if (r8.isError() == false) goto L10;
        r8.throwException();     // Catch: CharacterCodingException -> L6
    L6:
        e = move-exception;
        throw new MessageStringCodingException(e);
    L10:
        if (r8.isUnderflow() == true) goto L12;
    L19:
        return -1;
    L12:
        if (r8.isOverflow() == true) goto L19;
        if (this.encoder.flush(r6).isUnderflow() == true) goto L18;
        return -1;
    L18:
        return r6.position() - r1;
    }

    private void ensureCapacity(int r3) {
        MessageBuffer r0 = this.buffer;
        if (r0 != null) goto L6;
    L4:
        this.buffer = this.out.next(r3);
        return;
    L6:
        if ((this.position + r3) < r0.size()) goto L9;
        flushBuffer();
        goto L4
    }

    private void flushBuffer() {
        this.out.writeBuffer(this.position);
        this.buffer = null;
        this.totalFlushBytes += (long) this.position;
        this.position = 0;
    }

    private void packStringWithGetBytes(String r2) {
        byte[] r3 = r2.getBytes(MessagePack.UTF8);
        packRawStringHeader(r3.length);
        addPayload(r3);
    }

    private void prepareEncoder() {
        if (this.encoder != null) goto L5;
        this.encoder = MessagePack.UTF8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    L5:
        this.encoder.reset();
    }

    private void writeByte(byte r4) {
        ensureCapacity(1);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
    }

    private void writeByteAndByte(byte r4, byte r5) {
        ensureCapacity(2);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        MessageBuffer r6 = this.buffer;
        int r2 = this.position;
        this.position = r2 + 1;
        r6.putByte(r2, r5);
    }

    private void writeByteAndDouble(byte r4, double r5) {
        ensureCapacity(9);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        this.buffer.putDouble(this.position, r5);
        this.position += 8;
    }

    private void writeByteAndFloat(byte r4, float r5) {
        ensureCapacity(5);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        this.buffer.putFloat(this.position, r5);
        this.position += 4;
    }

    private void writeByteAndInt(byte r4, int r5) {
        ensureCapacity(5);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        this.buffer.putInt(this.position, r5);
        this.position += 4;
    }

    private void writeByteAndLong(byte r4, long r5) {
        ensureCapacity(9);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        this.buffer.putLong(this.position, r5);
        this.position += 8;
    }

    private void writeByteAndShort(byte r4, short r5) {
        ensureCapacity(3);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, r4);
        this.buffer.putShort(this.position, r5);
        this.position += 2;
    }

    private void writeInt(int r4) {
        ensureCapacity(4);
        this.buffer.putInt(this.position, r4);
        this.position += 4;
    }

    private void writeLong(long r4) {
        ensureCapacity(8);
        this.buffer.putLong(this.position, r4);
        this.position += 8;
    }

    private void writeShort(short r4) {
        ensureCapacity(2);
        this.buffer.putShort(this.position, r4);
        this.position += 2;
    }

    private void writeTimestamp32(int r4) {
        ensureCapacity(6);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, MessagePack.Code.FIXEXT4);
        MessageBuffer r2 = this.buffer;
        int r3 = this.position;
        this.position = r3 + 1;
        r2.putByte(r3, (byte) -1);
        this.buffer.putInt(this.position, r4);
        this.position += 4;
    }

    private void writeTimestamp64(long r4) {
        ensureCapacity(10);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, MessagePack.Code.FIXEXT8);
        MessageBuffer r2 = this.buffer;
        int r3 = this.position;
        this.position = r3 + 1;
        r2.putByte(r3, (byte) -1);
        this.buffer.putLong(this.position, r4);
        this.position += 8;
    }

    private void writeTimestamp96(long r4, int r6) {
        ensureCapacity(15);
        MessageBuffer r0 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r0.putByte(r1, MessagePack.Code.EXT8);
        MessageBuffer r2 = this.buffer;
        int r3 = this.position;
        this.position = r3 + 1;
        r2.putByte(r3, (byte) 12);
        MessageBuffer r5 = this.buffer;
        int r7 = this.position;
        this.position = r7 + 1;
        r5.putByte(r7, (byte) -1);
        this.buffer.putInt(this.position, r6);
        int r8 = this.position + 4;
        this.position = r8;
        this.buffer.putLong(r8, r4);
        this.position += 8;
    }

    public MessagePacker addPayload(byte[] r3) {
        return addPayload(r3, 0, r3.length);
    }

    public MessagePacker addPayload(byte[] r3, int r4, int r5) {
        MessageBuffer r0 = this.buffer;
        if (r0 == null) goto L10;
        int r1 = r0.size();
        int r2 = this.position;
        if ((r1 - r2) < r5) goto L10;
        if (r5 > this.bufferFlushThreshold) goto L10;
        this.buffer.putBytes(r2, r3, r4, r5);
        this.position += r5;
    L11:
        return this;
    L10:
        flush();
        this.out.add(r3, r4, r5);
        this.totalFlushBytes += (long) r5;
        goto L11
    }

    public void clear() {
        this.position = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();     // Catch: Throwable -> L5
        this.out.close();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.position <= 0) goto L5;
        flushBuffer();
    L5:
        this.out.flush();
    }

    public long getTotalWrittenBytes() {
        return this.totalFlushBytes + ((long) this.position);
    }

    public MessagePacker packArrayHeader(int r2) {
        if (r2 < 0) goto L12;
        if (r2 >= 16) goto L7;
        writeByte((byte) (r2 | NetError.ERR_NO_SSL_VERSIONS_ENABLED));
    L10:
        return this;
    L7:
        if (r2 >= 65536) goto L9;
        writeByteAndShort(MessagePack.Code.ARRAY16, (short) r2);
        goto L10
    L9:
        writeByteAndInt(MessagePack.Code.ARRAY32, r2);
        goto L10
    L12:
        throw new IllegalArgumentException("array size must be >= 0");
    }

    public MessagePacker packBigInteger(BigInteger r4) {
        if (r4.bitLength() > 63) goto L6;
        packLong(r4.longValue());
    L10:
        return this;
    L6:
        if (r4.bitLength() != 64) goto L12;
        if (r4.signum() != 1) goto L12;
        writeByteAndLong(MessagePack.Code.UINT64, r4.longValue());
    L12:
        throw new IllegalArgumentException("MessagePack cannot serialize BigInteger larger than 2^64-1");
    }

    public MessagePacker packBinaryHeader(int r2) {
        if (r2 >= 256) goto L6;
        writeByteAndByte(MessagePack.Code.BIN8, (byte) r2);
    L9:
        return this;
    L6:
        if (r2 >= 65536) goto L8;
        writeByteAndShort(MessagePack.Code.BIN16, (short) r2);
        goto L9
    L8:
        writeByteAndInt(MessagePack.Code.BIN32, r2);
        goto L9
    }

    public MessagePacker packBoolean(boolean r1) {
        if (r1 == false) goto L4;
        byte r2 = MessagePack.Code.TRUE;
    L5:
        writeByte(r2);
        return this;
    L4:
        r2 = MessagePack.Code.FALSE;
        goto L5
    }

    public MessagePacker packByte(byte r2) {
        if (r2 >= (-32)) goto L5;
        writeByteAndByte(MessagePack.Code.INT8, r2);
    L6:
        return this;
    L5:
        writeByte(r2);
        goto L6
    }

    public MessagePacker packDouble(double r2) {
        writeByteAndDouble(MessagePack.Code.FLOAT64, r2);
        return this;
    }

    public MessagePacker packExtensionTypeHeader(byte r3, int r4) {
        if (r4 >= 256) goto L26;
        if (r4 > 0) goto L7;
    L24:
        writeByteAndByte(MessagePack.Code.EXT8, (byte) r4);
    L29:
        writeByte(r3);
    L30:
        return this;
    L7:
        if (((r4 - 1) & r4) != 0) goto L24;
        if (r4 != 1) goto L13;
        byte r5 = MessagePack.Code.FIXEXT1;
    L11:
        writeByteAndByte(r5, r3);
        goto L30
    L13:
        if (r4 != 2) goto L16;
        r5 = MessagePack.Code.FIXEXT2;
        goto L11
    L16:
        if (r4 != 4) goto L19;
        r5 = MessagePack.Code.FIXEXT4;
        goto L11
    L19:
        if (r4 != 8) goto L22;
        r5 = MessagePack.Code.FIXEXT8;
        goto L11
    L22:
        if (r4 != 16) goto L24;
        r5 = MessagePack.Code.FIXEXT16;
        goto L11
    L26:
        if (r4 >= 65536) goto L28;
        writeByteAndShort(MessagePack.Code.EXT16, (short) r4);
        goto L29
    L28:
        writeByteAndInt(MessagePack.Code.EXT32, r4);
        goto L29
    }

    public MessagePacker packFloat(float r2) {
        writeByteAndFloat(MessagePack.Code.FLOAT32, r2);
        return this;
    }

    public MessagePacker packInt(int r2) {
        if (r2 >= (-32)) goto L14;
        if (r2 >= (-32768)) goto L9;
        byte r0 = MessagePack.Code.INT32;
    L7:
        writeByteAndInt(r0, r2);
    L24:
        return this;
    L9:
        if (r2 >= (-128)) goto L12;
        byte r1 = MessagePack.Code.INT16;
    L11:
        writeByteAndShort(r1, (short) r2);
        goto L24
    L12:
        byte r3 = MessagePack.Code.INT8;
    L19:
        writeByteAndByte(r3, (byte) r2);
        goto L24
    L14:
        if (r2 >= 128) goto L17;
        writeByte((byte) r2);
        goto L24
    L17:
        if (r2 >= 256) goto L21;
        r3 = MessagePack.Code.UINT8;
        goto L19
    L21:
        if (r2 >= 65536) goto L23;
        r1 = MessagePack.Code.UINT16;
        goto L11
    L23:
        r0 = MessagePack.Code.UINT32;
        goto L7
    }

    public MessagePacker packLong(long r3) {
        if (r3 >= (-32)) goto L19;
        if (r3 >= (-32768)) goto L13;
        if (r3 >= (-2147483648L)) goto L10;
        byte r0 = MessagePack.Code.INT64;
    L9:
        writeByteAndLong(r0, r3);
    L31:
        return this;
    L10:
        byte r1 = MessagePack.Code.INT32;
    L11:
        writeByteAndInt(r1, (int) r3);
        goto L31
    L13:
        if (r3 >= (-128)) goto L16;
        byte r2 = MessagePack.Code.INT16;
    L15:
        writeByteAndShort(r2, (short) r3);
        goto L31
    L16:
        byte r4 = MessagePack.Code.INT8;
    L17:
        writeByteAndByte(r4, (byte) r3);
        goto L31
    L19:
        if (r3 >= 128) goto L22;
        writeByte((byte) r3);
        goto L31
    L22:
        if (r3 >= 65536) goto L28;
        if (r3 >= 256) goto L26;
        r4 = MessagePack.Code.UINT8;
        goto L17
    L26:
        r2 = MessagePack.Code.UINT16;
        goto L15
    L28:
        if (r3 >= 4294967296L) goto L30;
        r1 = MessagePack.Code.UINT32;
        goto L11
    L30:
        r0 = MessagePack.Code.UINT64;
        goto L9
    }

    public MessagePacker packMapHeader(int r2) {
        if (r2 < 0) goto L12;
        if (r2 >= 16) goto L7;
        writeByte((byte) (r2 | (-128)));
    L10:
        return this;
    L7:
        if (r2 >= 65536) goto L9;
        writeByteAndShort(MessagePack.Code.MAP16, (short) r2);
        goto L10
    L9:
        writeByteAndInt(MessagePack.Code.MAP32, r2);
        goto L10
    L12:
        throw new IllegalArgumentException("map size must be >= 0");
    }

    public MessagePacker packNil() {
        writeByte(MessagePack.Code.NIL);
        return this;
    }

    public MessagePacker packRawStringHeader(int r2) {
        if (r2 >= 32) goto L6;
        writeByte((byte) (r2 | (-96)));
    L14:
        return this;
    L6:
        if (this.str8FormatSupport == false) goto L11;
        if (r2 >= 256) goto L11;
        writeByteAndByte(MessagePack.Code.STR8, (byte) r2);
    L11:
        if (r2 >= 65536) goto L13;
        writeByteAndShort(MessagePack.Code.STR16, (short) r2);
        goto L14
    L13:
        writeByteAndInt(MessagePack.Code.STR32, r2);
        goto L14
    }

    public MessagePacker packShort(short r2) {
        if (r2 >= (-32)) goto L11;
        if (r2 >= (-128)) goto L8;
        byte r0 = MessagePack.Code.INT16;
    L7:
        writeByteAndShort(r0, r2);
    L17:
        return this;
    L8:
        byte r1 = MessagePack.Code.INT8;
    L9:
        writeByteAndByte(r1, (byte) r2);
        goto L17
    L11:
        if (r2 >= 128) goto L14;
        writeByte((byte) r2);
        goto L17
    L14:
        if (r2 >= 256) goto L16;
        r1 = MessagePack.Code.UINT8;
        goto L9
    L16:
        r0 = MessagePack.Code.UINT16;
        goto L7
    }

    public MessagePacker packString(String r5) {
        if (r5.length() > 0) goto L7;
        packRawStringHeader(0);
        return this;
    L7:
        if (CORRUPTED_CHARSET_ENCODER == false) goto L9;
    L37:
        packStringWithGetBytes(r5);
        return this;
    L9:
        if (r5.length() < this.smallStringOptimizationThreshold) goto L37;
        if (r5.length() >= 256) goto L26;
        ensureCapacity(((r5.length() * 6) + 2) + 1);
        int r0 = encodeStringToBufferAt(this.position + 2, r5);
        if (r0 >= 0) goto L16;
    L35:
        packStringWithGetBytes(r5);
        return this;
    L16:
        if (this.str8FormatSupport == false) goto L19;
        if (r0 >= 256) goto L19;
        MessageBuffer r6 = this.buffer;
        int r1 = this.position;
        this.position = r1 + 1;
        r6.putByte(r1, MessagePack.Code.STR8);
        MessageBuffer r7 = this.buffer;
        int r2 = this.position;
        this.position = r2 + 1;
        r7.putByte(r2, (byte) r0);
        int r8 = this.position;
    L21:
        this.position = r8 + r0;
        return this;
    L19:
        if (r0 >= 65536) goto L24;
        MessageBuffer r9 = this.buffer;
        int r3 = this.position;
        r9.putMessageBuffer(r3 + 3, r9, r3 + 2, r0);
        MessageBuffer r10 = this.buffer;
        int r4 = this.position;
        this.position = r4 + 1;
        r10.putByte(r4, MessagePack.Code.STR16);
        this.buffer.putShort(this.position, (short) r0);
        r8 = this.position + 2;
        this.position = r8;
        goto L21
    L24:
        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
    L26:
        if (r5.length() >= 65536) goto L35;
        ensureCapacity(((r5.length() * 6) + 3) + 2);
        int r11 = encodeStringToBufferAt(this.position + 3, r5);
        if (r11 < 0) goto L35;
        MessageBuffer r12 = this.buffer;
        if (r11 >= 65536) goto L32;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, MessagePack.Code.STR16);
        this.buffer.putShort(this.position, (short) r11);
        int r14 = this.position + 2;
    L33:
        this.position = r14;
        this.position = r14 + r11;
        return this;
    L32:
        int r15 = this.position;
        r12.putMessageBuffer(r15 + 5, r12, r15 + 3, r11);
        MessageBuffer r16 = this.buffer;
        int r17 = this.position;
        this.position = r17 + 1;
        r16.putByte(r17, MessagePack.Code.STR32);
        this.buffer.putInt(this.position, r11);
        r14 = this.position + 4;
        goto L33
    }

    public MessagePacker packTimestamp(long r1) {
        return packTimestamp(Instant.ofEpochMilli(r1));
    }

    public MessagePacker packTimestamp(long r7, int r9) {
        long r0 = r9;
        long r8 = Math.addExact(r7, Math.floorDiv(r0, NANOS_PER_SECOND));
        long r1 = Math.floorMod(r0, NANOS_PER_SECOND);
        if ((r8 >>> 34) != 0) goto L8;
        long r2 = (r1 << 34) | r8;
        if (((-4294967296L) & r2) != 0) goto L7;
        writeTimestamp32((int) r8);
    L9:
        return this;
    L7:
        writeTimestamp64(r2);
        goto L9
    L8:
        writeTimestamp96(r8, (int) r1);
        goto L9
    }

    public MessagePacker packTimestamp(Instant r3) {
        return packTimestamp(r3.getEpochSecond(), r3.getNano());
    }

    public MessagePacker packValue(Value r3) {
        ((Value) ZeusTransformUtils.wrapperContextForParams(r3, Value.class, "com.obric.memorydata.plugin")).writeTo(this);
        return this;
    }

    public MessageBufferOutput reset(MessageBufferOutput r4) {
        MessageBufferOutput r5 = (MessageBufferOutput) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((MessageBufferOutput) ZeusTransformUtils.wrapperContextForParams(r4, MessageBufferOutput.class, "com.obric.memorydata.plugin"), "MessageBufferOutput is null"), MessageBufferOutput.class, "com.obric.memorydata.plugin");
        flush();
        MessageBufferOutput r0 = this.out;
        this.out = r5;
        this.totalFlushBytes = 0;
        return r0;
    }

    public MessagePacker writePayload(byte[] r3) {
        return writePayload(r3, 0, r3.length);
    }

    public MessagePacker writePayload(byte[] r3, int r4, int r5) {
        MessageBuffer r0 = this.buffer;
        if (r0 == null) goto L10;
        int r1 = r0.size();
        int r2 = this.position;
        if ((r1 - r2) < r5) goto L10;
        if (r5 > this.bufferFlushThreshold) goto L10;
        this.buffer.putBytes(r2, r3, r4, r5);
        this.position += r5;
    L11:
        return this;
    L10:
        flush();
        this.out.write(r3, r4, r5);
        this.totalFlushBytes += (long) r5;
        goto L11
    }
}
