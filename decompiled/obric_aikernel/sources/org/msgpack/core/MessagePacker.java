package org.msgpack.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ttnet.org.chromium.net.NetError;
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

/* JADX INFO: loaded from: classes3.dex */
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
        boolean r10 = false;
        Class<?> r11 = Class.forName("android.os.Build$VERSION");     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        Object r12 = r11.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        int r13 = r11.getField("SDK_INT").getInt(r12);     // Catch: NoSuchFieldException -> L9 InvocationTargetException -> L11 InstantiationException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17 ClassNotFoundException -> L21
        goto L19
    L5:
        if (r13 < 14) goto L19;
        if (r13 >= 21) goto L19;
        r10 = true;
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
        CORRUPTED_CHARSET_ENCODER = r10;
    }

    protected MessagePacker(MessageBufferOutput r10, MessagePack.PackerConfig r11) {
        this.out = (MessageBufferOutput) Preconditions.checkNotNull(r10, "MessageBufferOutput is null");
        this.smallStringOptimizationThreshold = r11.getSmallStringOptimizationThreshold();
        this.bufferFlushThreshold = r11.getBufferFlushThreshold();
        this.str8FormatSupport = r11.isStr8FormatSupport();
        this.position = 0;
        this.totalFlushBytes = 0;
    }

    private int encodeStringToBufferAt(int r10, String r11) {
        prepareEncoder();
        MessageBuffer r12 = this.buffer;
        ByteBuffer r13 = r12.sliceAsByteBuffer(r10, r12.size() - r10);
        int r14 = r13.position();
        CharBuffer r15 = CharBuffer.wrap(r11);
        CoderResult r16 = this.encoder.encode(r15, r13, true);
        if (r16.isError() == false) goto L10;
        r16.throwException();     // Catch: CharacterCodingException -> L6
    L6:
        e = move-exception;
        throw new MessageStringCodingException(e);
    L10:
        if (r16.isUnderflow() == true) goto L12;
    L19:
        return -1;
    L12:
        if (r16.isOverflow() == true) goto L19;
        if (this.encoder.flush(r13).isUnderflow() == true) goto L18;
        return -1;
    L18:
        return r13.position() - r14;
    }

    private void ensureCapacity(int r10) {
        MessageBuffer r11 = this.buffer;
        if (r11 != null) goto L6;
    L4:
        this.buffer = this.out.next(r10);
        return;
    L6:
        if ((this.position + r10) < r11.size()) goto L9;
        flushBuffer();
        goto L4
    }

    private void flushBuffer() {
        this.out.writeBuffer(this.position);
        this.buffer = null;
        this.totalFlushBytes += (long) this.position;
        this.position = 0;
    }

    private void packStringWithGetBytes(String r10) {
        byte[] r11 = r10.getBytes(MessagePack.UTF8);
        packRawStringHeader(r11.length);
        addPayload(r11);
    }

    private void prepareEncoder() {
        if (this.encoder != null) goto L5;
        this.encoder = MessagePack.UTF8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    L5:
        this.encoder.reset();
    }

    private void writeByte(byte r10) {
        ensureCapacity(1);
        MessageBuffer r11 = this.buffer;
        int r12 = this.position;
        this.position = r12 + 1;
        r11.putByte(r12, r10);
    }

    private void writeByteAndByte(byte r10, byte r11) {
        ensureCapacity(2);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        MessageBuffer r14 = this.buffer;
        int r15 = this.position;
        this.position = r15 + 1;
        r14.putByte(r15, r11);
    }

    private void writeByteAndDouble(byte r10, double r11) {
        ensureCapacity(9);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        this.buffer.putDouble(this.position, r11);
        this.position += 8;
    }

    private void writeByteAndFloat(byte r10, float r11) {
        ensureCapacity(5);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        this.buffer.putFloat(this.position, r11);
        this.position += 4;
    }

    private void writeByteAndInt(byte r10, int r11) {
        ensureCapacity(5);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        this.buffer.putInt(this.position, r11);
        this.position += 4;
    }

    private void writeByteAndLong(byte r10, long r11) {
        ensureCapacity(9);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        this.buffer.putLong(this.position, r11);
        this.position += 8;
    }

    private void writeByteAndShort(byte r10, short r11) {
        ensureCapacity(3);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, r10);
        this.buffer.putShort(this.position, r11);
        this.position += 2;
    }

    private void writeInt(int r10) {
        ensureCapacity(4);
        this.buffer.putInt(this.position, r10);
        this.position += 4;
    }

    private void writeLong(long r10) {
        ensureCapacity(8);
        this.buffer.putLong(this.position, r10);
        this.position += 8;
    }

    private void writeShort(short r10) {
        ensureCapacity(2);
        this.buffer.putShort(this.position, r10);
        this.position += 2;
    }

    private void writeTimestamp32(int r10) {
        ensureCapacity(6);
        MessageBuffer r11 = this.buffer;
        int r12 = this.position;
        this.position = r12 + 1;
        r11.putByte(r12, MessagePack.Code.FIXEXT4);
        MessageBuffer r13 = this.buffer;
        int r14 = this.position;
        this.position = r14 + 1;
        r13.putByte(r14, (byte) -1);
        this.buffer.putInt(this.position, r10);
        this.position += 4;
    }

    private void writeTimestamp64(long r10) {
        ensureCapacity(10);
        MessageBuffer r11 = this.buffer;
        int r12 = this.position;
        this.position = r12 + 1;
        r11.putByte(r12, MessagePack.Code.FIXEXT8);
        MessageBuffer r13 = this.buffer;
        int r14 = this.position;
        this.position = r14 + 1;
        r13.putByte(r14, (byte) -1);
        this.buffer.putLong(this.position, r10);
        this.position += 8;
    }

    private void writeTimestamp96(long r10, int r11) {
        ensureCapacity(15);
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, MessagePack.Code.EXT8);
        MessageBuffer r14 = this.buffer;
        int r15 = this.position;
        this.position = r15 + 1;
        r14.putByte(r15, (byte) 12);
        MessageBuffer r16 = this.buffer;
        int r17 = this.position;
        this.position = r17 + 1;
        r16.putByte(r17, (byte) -1);
        this.buffer.putInt(this.position, r11);
        int r18 = this.position + 4;
        this.position = r18;
        this.buffer.putLong(r18, r10);
        this.position += 8;
    }

    public MessagePacker addPayload(byte[] r10) {
        return addPayload(r10, 0, r10.length);
    }

    public MessagePacker addPayload(byte[] r10, int r11, int r12) {
        MessageBuffer r13 = this.buffer;
        if (r13 == null) goto L10;
        int r14 = r13.size();
        int r15 = this.position;
        if ((r14 - r15) < r12) goto L10;
        if (r12 > this.bufferFlushThreshold) goto L10;
        this.buffer.putBytes(r15, r10, r11, r12);
        this.position += r12;
    L11:
        return this;
    L10:
        flush();
        this.out.add(r10, r11, r12);
        this.totalFlushBytes += (long) r12;
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

    public MessagePacker packArrayHeader(int r10) {
        if (r10 < 0) goto L12;
        if (r10 >= 16) goto L7;
        writeByte((byte) (r10 | NetError.ERR_NO_SSL_VERSIONS_ENABLED));
    L10:
        return this;
    L7:
        if (r10 >= 65536) goto L9;
        writeByteAndShort(MessagePack.Code.ARRAY16, (short) r10);
        goto L10
    L9:
        writeByteAndInt(MessagePack.Code.ARRAY32, r10);
        goto L10
    L12:
        throw new IllegalArgumentException("array size must be >= 0");
    }

    public MessagePacker packBigInteger(BigInteger r10) {
        if (r10.bitLength() > 63) goto L6;
        packLong(r10.longValue());
    L10:
        return this;
    L6:
        if (r10.bitLength() != 64) goto L12;
        if (r10.signum() != 1) goto L12;
        writeByteAndLong(MessagePack.Code.UINT64, r10.longValue());
    L12:
        throw new IllegalArgumentException("MessagePack cannot serialize BigInteger larger than 2^64-1");
    }

    public MessagePacker packBinaryHeader(int r10) {
        if (r10 >= 256) goto L6;
        writeByteAndByte(MessagePack.Code.BIN8, (byte) r10);
    L9:
        return this;
    L6:
        if (r10 >= 65536) goto L8;
        writeByteAndShort(MessagePack.Code.BIN16, (short) r10);
        goto L9
    L8:
        writeByteAndInt(MessagePack.Code.BIN32, r10);
        goto L9
    }

    public MessagePacker packBoolean(boolean r10) {
        if (r10 == false) goto L4;
        byte r11 = MessagePack.Code.TRUE;
    L5:
        writeByte(r11);
        return this;
    L4:
        r11 = MessagePack.Code.FALSE;
        goto L5
    }

    public MessagePacker packByte(byte r10) {
        if (r10 >= (-32)) goto L5;
        writeByteAndByte(MessagePack.Code.INT8, r10);
    L6:
        return this;
    L5:
        writeByte(r10);
        goto L6
    }

    public MessagePacker packDouble(double r10) {
        writeByteAndDouble(MessagePack.Code.FLOAT64, r10);
        return this;
    }

    public MessagePacker packExtensionTypeHeader(byte r10, int r11) {
        if (r11 >= 256) goto L26;
        if (r11 > 0) goto L7;
    L24:
        writeByteAndByte(MessagePack.Code.EXT8, (byte) r11);
    L29:
        writeByte(r10);
    L30:
        return this;
    L7:
        if (((r11 - 1) & r11) != 0) goto L24;
        if (r11 != 1) goto L13;
        byte r12 = MessagePack.Code.FIXEXT1;
    L11:
        writeByteAndByte(r12, r10);
        goto L30
    L13:
        if (r11 != 2) goto L16;
        r12 = MessagePack.Code.FIXEXT2;
        goto L11
    L16:
        if (r11 != 4) goto L19;
        r12 = MessagePack.Code.FIXEXT4;
        goto L11
    L19:
        if (r11 != 8) goto L22;
        r12 = MessagePack.Code.FIXEXT8;
        goto L11
    L22:
        if (r11 != 16) goto L24;
        r12 = MessagePack.Code.FIXEXT16;
        goto L11
    L26:
        if (r11 >= 65536) goto L28;
        writeByteAndShort(MessagePack.Code.EXT16, (short) r11);
        goto L29
    L28:
        writeByteAndInt(MessagePack.Code.EXT32, r11);
        goto L29
    }

    public MessagePacker packFloat(float r10) {
        writeByteAndFloat(MessagePack.Code.FLOAT32, r10);
        return this;
    }

    public MessagePacker packInt(int r10) {
        if (r10 >= (-32)) goto L14;
        if (r10 >= (-32768)) goto L9;
        byte r11 = MessagePack.Code.INT32;
    L7:
        writeByteAndInt(r11, r10);
    L24:
        return this;
    L9:
        if (r10 >= (-128)) goto L12;
        byte r12 = MessagePack.Code.INT16;
    L11:
        writeByteAndShort(r12, (short) r10);
        goto L24
    L12:
        byte r13 = MessagePack.Code.INT8;
    L19:
        writeByteAndByte(r13, (byte) r10);
        goto L24
    L14:
        if (r10 >= 128) goto L17;
        writeByte((byte) r10);
        goto L24
    L17:
        if (r10 >= 256) goto L21;
        r13 = MessagePack.Code.UINT8;
        goto L19
    L21:
        if (r10 >= 65536) goto L23;
        r12 = MessagePack.Code.UINT16;
        goto L11
    L23:
        r11 = MessagePack.Code.UINT32;
        goto L7
    }

    public MessagePacker packLong(long r10) {
        if (r10 >= (-32)) goto L19;
        if (r10 >= (-32768)) goto L13;
        if (r10 >= (-2147483648L)) goto L10;
        byte r11 = MessagePack.Code.INT64;
    L9:
        writeByteAndLong(r11, r10);
    L31:
        return this;
    L10:
        byte r12 = MessagePack.Code.INT32;
    L11:
        writeByteAndInt(r12, (int) r10);
        goto L31
    L13:
        if (r10 >= (-128)) goto L16;
        byte r13 = MessagePack.Code.INT16;
    L15:
        writeByteAndShort(r13, (short) r10);
        goto L31
    L16:
        byte r14 = MessagePack.Code.INT8;
    L17:
        writeByteAndByte(r14, (byte) r10);
        goto L31
    L19:
        if (r10 >= 128) goto L22;
        writeByte((byte) r10);
        goto L31
    L22:
        if (r10 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L28;
        if (r10 >= 256) goto L26;
        r14 = MessagePack.Code.UINT8;
        goto L17
    L26:
        r13 = MessagePack.Code.UINT16;
        goto L15
    L28:
        if (r10 >= 4294967296L) goto L30;
        r12 = MessagePack.Code.UINT32;
        goto L11
    L30:
        r11 = MessagePack.Code.UINT64;
        goto L9
    }

    public MessagePacker packMapHeader(int r10) {
        if (r10 < 0) goto L12;
        if (r10 >= 16) goto L7;
        writeByte((byte) (r10 | (-128)));
    L10:
        return this;
    L7:
        if (r10 >= 65536) goto L9;
        writeByteAndShort(MessagePack.Code.MAP16, (short) r10);
        goto L10
    L9:
        writeByteAndInt(MessagePack.Code.MAP32, r10);
        goto L10
    L12:
        throw new IllegalArgumentException("map size must be >= 0");
    }

    public MessagePacker packNil() {
        writeByte(MessagePack.Code.NIL);
        return this;
    }

    public MessagePacker packRawStringHeader(int r10) {
        if (r10 >= 32) goto L6;
        writeByte((byte) (r10 | (-96)));
    L14:
        return this;
    L6:
        if (this.str8FormatSupport == false) goto L11;
        if (r10 >= 256) goto L11;
        writeByteAndByte(MessagePack.Code.STR8, (byte) r10);
    L11:
        if (r10 >= 65536) goto L13;
        writeByteAndShort(MessagePack.Code.STR16, (short) r10);
        goto L14
    L13:
        writeByteAndInt(MessagePack.Code.STR32, r10);
        goto L14
    }

    public MessagePacker packShort(short r10) {
        if (r10 >= (-32)) goto L11;
        if (r10 >= (-128)) goto L8;
        byte r11 = MessagePack.Code.INT16;
    L7:
        writeByteAndShort(r11, r10);
    L17:
        return this;
    L8:
        byte r12 = MessagePack.Code.INT8;
    L9:
        writeByteAndByte(r12, (byte) r10);
        goto L17
    L11:
        if (r10 >= 128) goto L14;
        writeByte((byte) r10);
        goto L17
    L14:
        if (r10 >= 256) goto L16;
        r12 = MessagePack.Code.UINT8;
        goto L9
    L16:
        r11 = MessagePack.Code.UINT16;
        goto L7
    }

    public MessagePacker packString(String r10) {
        if (r10.length() > 0) goto L7;
        packRawStringHeader(0);
        return this;
    L7:
        if (CORRUPTED_CHARSET_ENCODER == false) goto L9;
    L37:
        packStringWithGetBytes(r10);
        return this;
    L9:
        if (r10.length() < this.smallStringOptimizationThreshold) goto L37;
        if (r10.length() >= 256) goto L26;
        ensureCapacity(((r10.length() * 6) + 2) + 1);
        int r11 = encodeStringToBufferAt(this.position + 2, r10);
        if (r11 >= 0) goto L16;
    L35:
        packStringWithGetBytes(r10);
        return this;
    L16:
        if (this.str8FormatSupport == false) goto L19;
        if (r11 >= 256) goto L19;
        MessageBuffer r12 = this.buffer;
        int r13 = this.position;
        this.position = r13 + 1;
        r12.putByte(r13, MessagePack.Code.STR8);
        MessageBuffer r14 = this.buffer;
        int r15 = this.position;
        this.position = r15 + 1;
        r14.putByte(r15, (byte) r11);
        int r16 = this.position;
    L21:
        this.position = r16 + r11;
        return this;
    L19:
        if (r11 >= 65536) goto L24;
        MessageBuffer r17 = this.buffer;
        int r18 = this.position;
        r17.putMessageBuffer(r18 + 3, r17, r18 + 2, r11);
        MessageBuffer r19 = this.buffer;
        int r20 = this.position;
        this.position = r20 + 1;
        r19.putByte(r20, MessagePack.Code.STR16);
        this.buffer.putShort(this.position, (short) r11);
        r16 = this.position + 2;
        this.position = r16;
        goto L21
    L24:
        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
    L26:
        if (r10.length() >= 65536) goto L35;
        ensureCapacity(((r10.length() * 6) + 3) + 2);
        int r21 = encodeStringToBufferAt(this.position + 3, r10);
        if (r21 < 0) goto L35;
        MessageBuffer r22 = this.buffer;
        if (r21 >= 65536) goto L32;
        int r23 = this.position;
        this.position = r23 + 1;
        r22.putByte(r23, MessagePack.Code.STR16);
        this.buffer.putShort(this.position, (short) r21);
        int r24 = this.position + 2;
    L33:
        this.position = r24;
        this.position = r24 + r21;
        return this;
    L32:
        int r25 = this.position;
        r22.putMessageBuffer(r25 + 5, r22, r25 + 3, r21);
        MessageBuffer r26 = this.buffer;
        int r27 = this.position;
        this.position = r27 + 1;
        r26.putByte(r27, MessagePack.Code.STR32);
        this.buffer.putInt(this.position, r21);
        r24 = this.position + 4;
        goto L33
    }

    public MessagePacker packTimestamp(long r10) {
        return packTimestamp(Instant.ofEpochMilli(r10));
    }

    public MessagePacker packTimestamp(long r10, int r11) {
        long r12 = r11;
        long r13 = Math.addExact(r10, Math.floorDiv(r12, NANOS_PER_SECOND));
        long r14 = Math.floorMod(r12, NANOS_PER_SECOND);
        if ((r13 >>> 34) != 0) goto L8;
        long r15 = (r14 << 34) | r13;
        if (((-4294967296L) & r15) != 0) goto L7;
        writeTimestamp32((int) r13);
    L9:
        return this;
    L7:
        writeTimestamp64(r15);
        goto L9
    L8:
        writeTimestamp96(r13, (int) r14);
        goto L9
    }

    public MessagePacker packTimestamp(Instant r10) {
        return packTimestamp(r10.getEpochSecond(), r10.getNano());
    }

    public MessagePacker packValue(Value r10) {
        r10.writeTo(this);
        return this;
    }

    public MessageBufferOutput reset(MessageBufferOutput r10) {
        MessageBufferOutput r11 = (MessageBufferOutput) Preconditions.checkNotNull(r10, "MessageBufferOutput is null");
        flush();
        MessageBufferOutput r12 = this.out;
        this.out = r11;
        this.totalFlushBytes = 0;
        return r12;
    }

    public MessagePacker writePayload(byte[] r10) {
        return writePayload(r10, 0, r10.length);
    }

    public MessagePacker writePayload(byte[] r10, int r11, int r12) {
        MessageBuffer r13 = this.buffer;
        if (r13 == null) goto L10;
        int r14 = r13.size();
        int r15 = this.position;
        if ((r14 - r15) < r12) goto L10;
        if (r12 > this.bufferFlushThreshold) goto L10;
        this.buffer.putBytes(r15, r10, r11, r12);
        this.position += r12;
    L11:
        return this;
    L10:
        flush();
        this.out.write(r10, r11, r12);
        this.totalFlushBytes += (long) r12;
        goto L11
    }
}
