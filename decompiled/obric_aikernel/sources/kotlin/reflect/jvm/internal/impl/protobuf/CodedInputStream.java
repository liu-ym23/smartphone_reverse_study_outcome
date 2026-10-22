package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    private interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream r10) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = r10;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(LiteralByteString r10) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = r10.bytes;
        int r11 = r10.getOffsetIntoBytes();
        this.bufferPos = r11;
        this.bufferSize = r11 + r10.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int decodeZigZag32(int r10) {
        int r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    public static long decodeZigZag64(long r10) {
        long r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    private void ensureAvailable(int r10) {
        if ((this.bufferSize - this.bufferPos) >= r10) goto L6;
        refillBuffer(r10);
        return;
    }

    public static CodedInputStream newInstance(InputStream r10) {
        return new CodedInputStream(r10);
    }

    static CodedInputStream newInstance(LiteralByteString r10) {
        CodedInputStream r11 = new CodedInputStream(r10);
        r11.pushLimit(r10.size());     // Catch: InvalidProtocolBufferException -> L5
        return r11;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private byte[] readRawBytesSlowPath(int r13) {
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L7;
        return Internal.EMPTY_BYTE_ARRAY;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r10 = this.totalBytesRetired;
        int r11 = this.bufferPos;
        int r12 = (r10 + r11) + r13;
        int r14 = this.currentLimit;
        if (r12 <= r14) goto L11;
        skipRawBytes((r14 - r10) - r11);
        throw InvalidProtocolBufferException.truncatedMessage();
    L11:
        if (r13 >= 4096) goto L14;
        byte[] r15 = new byte[r13];
        int r16 = this.bufferSize - r11;
        System.arraycopy(this.buffer, r11, r15, 0, r16);
        this.bufferPos = this.bufferSize;
        int r17 = r13 - r16;
        ensureAvailable(r17);
        System.arraycopy(this.buffer, 0, r15, r16, r17);
        this.bufferPos = r17;
        return r15;
    L14:
        int r18 = this.bufferSize;
        this.totalBytesRetired = r10 + r18;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int r19 = r18 - r11;
        int r20 = r13 - r19;
        ArrayList r21 = new ArrayList();
    L15:
        if (r20 <= 0) goto L27;
        int r22 = Math.min(r20, 4096);
        byte[] r23 = new byte[r22];
        int r24 = 0;
    L17:
        if (r24 >= r22) goto L26;
        InputStream r25 = this.input;
        if (r25 != null) goto L21;
        int r26 = -1;
    L22:
        if (r26 == (-1)) goto L25;
        this.totalBytesRetired += r26;
        r24 = r24 + r26;
        goto L17
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L21:
        r26 = r25.read(r23, r24, r22 - r24);
        goto L22
    L26:
        r20 = r20 - r22;
        r21.add(r23);
        goto L15
    L27:
        byte[] r110 = new byte[r13];
        System.arraycopy(this.buffer, r11, r110, 0, r19);
        Iterator r111 = r21.iterator();
    L29:
        if (r111.hasNext() == false) goto L31;
        byte[] r27 = (byte[]) r111.next();
        System.arraycopy(r27, 0, r110, r19, r27.length);
        r19 = r19 + r27.length;
        goto L29
    L31:
        return r110;
    }

    public static int readRawVarint32(int r10, InputStream r11) {
        if ((r10 & 128) != 0) goto L5;
        return r10;
    L5:
        int r12 = r10 & 127;
        int r13 = 7;
    L7:
        if (r13 >= 32) goto L17;
        int r14 = r11.read();
        if (r14 == (-1)) goto L15;
        r12 = r12 | ((r14 & 127) << r13);
        if ((r14 & 128) == 0) goto L12;
        r13 = r13 + 7;
        goto L7
    L12:
        return r12;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r13 >= 64) goto L27;
        int r15 = r11.read();
        if (r15 == (-1)) goto L25;
        if ((r15 & 128) == 0) goto L22;
        r13 = r13 + 7;
        goto L17
    L22:
        return r12;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void recomputeBufferSizeAfterLimit() {
        int r10 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = r10;
        int r11 = this.totalBytesRetired + r10;
        int r12 = this.currentLimit;
        if (r11 <= r12) goto L5;
        int r13 = r11 - r12;
        this.bufferSizeAfterLimit = r13;
        this.bufferSize = r10 - r13;
        return;
    L5:
        this.bufferSizeAfterLimit = 0;
    }

    private void refillBuffer(int r10) {
        if (tryRefillBuffer(r10) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void skipRawBytesSlowPath(int r10) {
        if (r10 < 0) goto L14;
        int r11 = this.totalBytesRetired;
        int r12 = this.bufferPos;
        int r13 = (r11 + r12) + r10;
        int r14 = this.currentLimit;
        if (r13 > r14) goto L11;
        int r15 = this.bufferSize;
        int r16 = r15 - r12;
        this.bufferPos = r15;
    L6:
        refillBuffer(1);
        int r17 = r10 - r16;
        int r18 = this.bufferSize;
        if (r17 <= r18) goto L9;
        r16 = r16 + r18;
        this.bufferPos = r18;
        goto L6
    L9:
        this.bufferPos = r17;
        return;
    L11:
        skipRawBytes((r14 - r11) - r12);
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    private boolean tryRefillBuffer(int r10) {
        int r11 = this.bufferPos;
        if ((r11 + r10) > this.bufferSize) goto L5;
        StringBuilder r12 = new StringBuilder(77);
        r12.append("refillBuffer() called when ");
        r12.append(r10);
        r12.append(" bytes were already available in buffer");
        throw new IllegalStateException(r12.toString());
    L5:
        if (((this.totalBytesRetired + r11) + r10) <= this.currentLimit) goto L7;
        return false;
    L7:
        RefillCallback r13 = this.refillCallback;
        if (r13 == null) goto L11;
        r13.onRefill();
    L11:
        if (this.input == null) goto L36;
        int r14 = this.bufferPos;
        if (r14 <= 0) goto L18;
        int r15 = this.bufferSize;
        if (r15 <= r14) goto L17;
        byte[] r16 = this.buffer;
        System.arraycopy(r16, r14, r16, 0, r15 - r14);
    L17:
        this.totalBytesRetired += r14;
        this.bufferSize -= r14;
        this.bufferPos = 0;
    L18:
        InputStream r17 = this.input;
        byte[] r18 = this.buffer;
        int r19 = this.bufferSize;
        int r20 = r17.read(r18, r19, r18.length - r19);
        if (r20 != 0) goto L21;
    L34:
        StringBuilder r21 = new StringBuilder(102);
        r21.append("InputStream#read(byte[]) returned invalid result: ");
        r21.append(r20);
        r21.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r21.toString());
    L21:
        if (r20 < (-1)) goto L34;
        if (r20 > this.buffer.length) goto L34;
        if (r20 <= 0) goto L36;
        this.bufferSize += r20;
        if (((this.totalBytesRetired + r10) - this.sizeLimit) > 0) goto L33;
        recomputeBufferSizeAfterLimit();
        if (this.bufferSize < r10) goto L31;
        return true;
    L31:
        return tryRefillBuffer(r10);
    L33:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    L36:
        return false;
    }

    public void checkLastTagWas(int r10) {
        if (this.lastTag != r10) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public int getBytesUntilLimit() {
        int r10 = this.currentLimit;
        if (r10 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r10 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() {
        if (this.bufferPos == this.bufferSize) goto L5;
    L7:
        return false;
    L5:
        if (tryRefillBuffer(1) == true) goto L7;
        return true;
    }

    public void popLimit(int r10) {
        this.currentLimit = r10;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int r10) {
        if (r10 < 0) goto L10;
        int r11 = r10 + (this.totalBytesRetired + this.bufferPos);
        int r12 = this.currentLimit;
        if (r11 > r12) goto L8;
        this.currentLimit = r11;
        recomputeBufferSizeAfterLimit();
        return r12;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() {
        if (readRawVarint64() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ByteString readBytes() {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L13;
        if (r10 <= 0) goto L13;
        if (this.bufferIsImmutable == true) goto L8;
    L10:
        ByteString r13 = ByteString.copyFrom(this.buffer, r12, r10);
    L11:
        this.bufferPos += r10;
        return r13;
    L8:
        if (this.enableAliasing == false) goto L10;
        r13 = new BoundedByteString(this.buffer, this.bufferPos, r10);
    L13:
        if (r10 != 0) goto L17;
        return ByteString.EMPTY;
    L17:
        return new LiteralByteString(readRawBytesSlowPath(r10));
    }

    public double readDouble() {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() {
        return readRawVarint32();
    }

    public int readFixed32() {
        return readRawLittleEndian32();
    }

    public long readFixed64() {
        return readRawLittleEndian64();
    }

    public float readFloat() {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) {
        int r13 = this.recursionDepth;
        if (r13 >= this.recursionLimit) goto L7;
        this.recursionDepth = r13 + 1;
        r11.mergeFrom(this, r12);
        checkLastTagWas(WireFormat.makeTag(r10, 4));
        this.recursionDepth--;
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() {
        return readRawVarint32();
    }

    public long readInt64() {
        return readRawVarint64();
    }

    public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) {
        int r12 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r13 = pushLimit(r12);
        this.recursionDepth++;
        T r14 = r10.parsePartialFrom(this, r11);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r13);
        return r14;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) {
        int r12 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r13 = pushLimit(r12);
        this.recursionDepth++;
        r10.mergeFrom(this, r11);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r13);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() {
        if (this.bufferPos != this.bufferSize) goto L5;
        refillBuffer(1);
    L5:
        byte[] r10 = this.buffer;
        int r11 = this.bufferPos;
        this.bufferPos = r11 + 1;
        return r10[r11];
    }

    public int readRawLittleEndian32() {
        int r10 = this.bufferPos;
        if ((this.bufferSize - r10) >= 4) goto L5;
        refillBuffer(4);
        r10 = this.bufferPos;
    L5:
        byte[] r11 = this.buffer;
        this.bufferPos = r10 + 4;
        return (((r11[r10] & 255) | ((r11[r10 + 1] & 255) << 8)) | ((r11[r10 + 2] & 255) << 16)) | ((r11[r10 + 3] & 255) << 24);
    }

    public long readRawLittleEndian64() {
        int r10 = this.bufferPos;
        if ((this.bufferSize - r10) >= 8) goto L5;
        refillBuffer(8);
        r10 = this.bufferPos;
    L5:
        byte[] r11 = this.buffer;
        this.bufferPos = r10 + 8;
        long r12 = ((((((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16)) | ((((long) r11[r10 + 3]) & 255) << 24)) | ((((long) r11[r10 + 4]) & 255) << 32)) | ((((long) r11[r10 + 5]) & 255) << 40)) | ((((long) r11[r10 + 6]) & 255) << 48);
        return ((((long) r11[r10 + 7]) & 255) << 56) | r12;
    }

    public int readRawVarint32() {
        int r10 = this.bufferPos;
        int r11 = this.bufferSize;
        if (r11 == r10) goto L36;
        byte[] r12 = this.buffer;
        int r13 = r10 + 1;
        byte r14 = r12[r10];
        if (r14 < 0) goto L10;
        this.bufferPos = r13;
        return r14;
    L10:
        if ((r11 - r13) < 9) goto L36;
        int r15 = r13 + 1;
        int r16 = r14 ^ (r12[r13] << 7);
        long r17 = r16;
        if (r17 >= 0) goto L16;
        long r18 = -128;
    L15:
        int r19 = (int) (r17 ^ r18);
    L37:
        this.bufferPos = r15;
        return r19;
    L16:
        int r20 = r15 + 1;
        int r21 = r16 ^ (r12[r15] << 14);
        long r22 = r21;
        if (r22 < 0) goto L20;
        r19 = (int) (16256 ^ r22);
    L19:
        r15 = r20;
        goto L37
    L20:
        r15 = r20 + 1;
        int r23 = r21 ^ (r12[r20] << 21);
        r17 = r23;
        if (r17 >= 0) goto L23;
        r18 = -2080896;
        goto L15
    L23:
        r20 = r15 + 1;
        byte r24 = r12[r15];
        r19 = (int) (((long) (r23 ^ (r24 << 28))) ^ 266354560);
        if (r24 >= 0) goto L19;
        r15 = r20 + 1;
        if (r12[r20] >= 0) goto L37;
        r20 = r15 + 1;
        if (r12[r15] >= 0) goto L19;
        r15 = r20 + 1;
        if (r12[r20] >= 0) goto L37;
        r20 = r15 + 1;
        if (r12[r15] >= 0) goto L19;
        r15 = r20 + 1;
        if (r12[r20] >= 0) goto L37;
    L36:
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() {
        int r10 = this.bufferPos;
        int r11 = this.bufferSize;
        if (r11 == r10) goto L40;
        byte[] r12 = this.buffer;
        int r13 = r10 + 1;
        byte r14 = r12[r10];
        if (r14 < 0) goto L10;
        this.bufferPos = r13;
        return r14;
    L10:
        if ((r11 - r13) < 9) goto L40;
        int r15 = r13 + 1;
        long r16 = r14 ^ (r12[r13] << 7);
        if (r16 >= 0) goto L16;
        long r17 = -128;
    L15:
        long r18 = r16 ^ r17;
    L43:
        this.bufferPos = r15;
        return r18;
    L16:
        int r19 = r15 + 1;
        long r20 = r16 ^ ((long) (r12[r15] << 14));
        if (r20 < 0) goto L20;
        long r21 = 16256;
    L19:
        r18 = r20 ^ r21;
        r15 = r19;
        goto L43
    L20:
        r15 = r19 + 1;
        r16 = r20 ^ ((long) (r12[r19] << 21));
        if (r16 >= 0) goto L23;
        r17 = -2080896;
        goto L15
    L23:
        r19 = r15 + 1;
        r20 = r16 ^ (((long) r12[r15]) << 28);
        if (r20 < 0) goto L26;
        r21 = 266354560;
        goto L19
    L26:
        r15 = r19 + 1;
        r16 = r20 ^ (((long) r12[r19]) << 35);
        if (r16 >= 0) goto L29;
        r17 = -34093383808L;
        goto L15
    L29:
        r19 = r15 + 1;
        r20 = r16 ^ (((long) r12[r15]) << 42);
        if (r20 < 0) goto L32;
        r21 = 4363953127296L;
        goto L19
    L32:
        r15 = r19 + 1;
        r16 = r20 ^ (((long) r12[r19]) << 49);
        if (r16 >= 0) goto L35;
        r17 = -558586000294016L;
        goto L15
    L35:
        int r22 = r15 + 1;
        long r23 = (r16 ^ (((long) r12[r15]) << 56)) ^ 71499008037633920L;
        if (r23 >= 0) goto L41;
        r15 = r22 + 1;
        if (r12[r22] < 0) goto L40;
    L42:
        r18 = r23;
        goto L43
    L41:
        r15 = r22;
    L40:
        return readRawVarint64SlowPath();
    }

    long readRawVarint64SlowPath() {
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= 64) goto L10;
        byte r12 = readRawByte();
        r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
        if ((r12 & 128) == 0) goto L7;
        r11 = r11 + 7;
        goto L4
    L7:
        return r10;
    L10:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() {
        return readRawLittleEndian32();
    }

    public long readSFixed64() {
        return readRawLittleEndian64();
    }

    public int readSInt32() {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() {
        int r10 = readRawVarint32();
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L7;
        if (r10 <= 0) goto L7;
        String r13 = new String(this.buffer, r12, r10, "UTF-8");
        this.bufferPos += r10;
        return r13;
    L7:
        if (r10 != 0) goto L11;
        return "";
    L11:
        return new String(readRawBytesSlowPath(r10), "UTF-8");
    }

    public String readStringRequireUtf8() {
        int r10 = readRawVarint32();
        int r11 = this.bufferPos;
        if (r10 > (this.bufferSize - r11)) goto L6;
        if (r10 <= 0) goto L6;
        byte[] r12 = this.buffer;
        this.bufferPos = r11 + r10;
    L11:
        if (Utf8.isValidUtf8(r12, r11, r11 + r10) == false) goto L15;
        return new String(r12, r11, r10, "UTF-8");
    L15:
        throw InvalidProtocolBufferException.invalidUtf8();
    L6:
        if (r10 != 0) goto L9;
        return "";
    L9:
        r12 = readRawBytesSlowPath(r10);
        r11 = 0;
        goto L11
    }

    public int readTag() {
        if (isAtEnd() == false) goto L6;
        this.lastTag = 0;
        return 0;
    L6:
        int r10 = readRawVarint32();
        this.lastTag = r10;
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
        return this.lastTag;
    L11:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() {
        return readRawVarint32();
    }

    public long readUInt64() {
        return readRawVarint64();
    }

    public boolean skipField(int r10, CodedOutputStream r11) {
        int r12 = WireFormat.getTagWireType(r10);
        if (r12 == 0) goto L24;
        if (r12 != 1) goto L6;
        long r13 = readRawLittleEndian64();
        r11.writeRawVarint32(r10);
        r11.writeFixed64NoTag(r13);
        return true;
    L6:
        if (r12 != 2) goto L8;
        ByteString r14 = readBytes();
        r11.writeRawVarint32(r10);
        r11.writeBytesNoTag(r14);
        return true;
    L8:
        if (r12 == 3) goto L18;
        if (r12 != 4) goto L11;
        return false;
    L11:
        if (r12 != 5) goto L15;
        int r15 = readRawLittleEndian32();
        r11.writeRawVarint32(r10);
        r11.writeFixed32NoTag(r15);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        r11.writeRawVarint32(r10);
        skipMessage(r11);
        int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
        checkLastTagWas(r16);
        r11.writeRawVarint32(r16);
        return true;
    L24:
        long r17 = readInt64();
        r11.writeRawVarint32(r10);
        r11.writeUInt64NoTag(r17);
        return true;
    }

    public void skipMessage(CodedOutputStream r10) {
    L2:
        int r11 = readTag();
        if (r11 == 0) goto L6;
        if (skipField(r11, r10) == true) goto L2;
        return;
    }

    public void skipRawBytes(int r10) {
        int r11 = this.bufferSize;
        int r12 = this.bufferPos;
        if (r10 > (r11 - r12)) goto L6;
        if (r10 < 0) goto L6;
        this.bufferPos = r12 + r10;
        return;
    L6:
        skipRawBytesSlowPath(r10);
    }
}
