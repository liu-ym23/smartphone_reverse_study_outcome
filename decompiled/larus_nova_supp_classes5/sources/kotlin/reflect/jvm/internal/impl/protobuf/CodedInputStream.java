package kotlin.reflect.jvm.internal.impl.protobuf;

import com.ss.android.ugc.effectmanager.common.EffectRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

    public static int decodeZigZag32(int r1) {
        int r0 = r1 >>> 1;
        return (-(r1 & 1)) ^ r0;
    }

    public static long decodeZigZag64(long r4) {
        long r0 = r4 >>> 1;
        return (-(r4 & 1)) ^ r0;
    }

    private void recomputeBufferSizeAfterLimit() {
        int r0 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = r0;
        int r1 = this.totalBytesRetired + r0;
        int r2 = this.currentLimit;
        if (r1 <= r2) goto L5;
        int r3 = r1 - r2;
        this.bufferSizeAfterLimit = r3;
        this.bufferSize = r0 - r3;
        return;
    L5:
        this.bufferSizeAfterLimit = 0;
    }

    public int getBytesUntilLimit() {
        int r0 = this.currentLimit;
        if (r0 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r0 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        if (this.bufferPos == this.bufferSize) goto L5;
    L7:
        return false;
    L5:
        if (tryRefillBuffer(1) == true) goto L7;
        return true;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos != this.bufferSize) goto L5;
        refillBuffer(1);
    L5:
        byte[] r0 = this.buffer;
        int r1 = this.bufferPos;
        this.bufferPos = r1 + 1;
        return r0[r1];
    }

    public int readRawLittleEndian32() throws IOException {
        int r0 = this.bufferPos;
        if ((this.bufferSize - r0) >= 4) goto L5;
        refillBuffer(4);
        r0 = this.bufferPos;
    L5:
        byte[] r1 = this.buffer;
        this.bufferPos = r0 + 4;
        int r2 = ((r1[r0] & UByte.MAX_VALUE) | ((r1[r0 + 1] & UByte.MAX_VALUE) << 8)) | ((r1[r0 + 2] & UByte.MAX_VALUE) << 16);
        return ((r1[r0 + 3] & UByte.MAX_VALUE) << 24) | r2;
    }

    public long readRawLittleEndian64() throws IOException {
        int r0 = this.bufferPos;
        if ((this.bufferSize - r0) >= 8) goto L5;
        refillBuffer(8);
        r0 = this.bufferPos;
    L5:
        byte[] r1 = this.buffer;
        this.bufferPos = r0 + 8;
        long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
        return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
    }

    public int readRawVarint32() throws IOException {
        int r0 = this.bufferPos;
        int r1 = this.bufferSize;
        if (r1 == r0) goto L36;
        byte[] r2 = this.buffer;
        int r3 = r0 + 1;
        byte r4 = r2[r0];
        if (r4 < 0) goto L10;
        this.bufferPos = r3;
        return r4;
    L10:
        if ((r1 - r3) < 9) goto L36;
        int r5 = r3 + 1;
        int r6 = r4 ^ (r2[r3] << 7);
        long r7 = r6;
        if (r7 >= 0) goto L16;
        long r8 = -128;
    L15:
        int r9 = (int) (r7 ^ r8);
    L37:
        this.bufferPos = r5;
        return r9;
    L16:
        int r10 = r5 + 1;
        int r11 = r6 ^ (r2[r5] << 14);
        long r12 = r11;
        if (r12 < 0) goto L20;
        r9 = (int) (16256 ^ r12);
    L19:
        r5 = r10;
        goto L37
    L20:
        r5 = r10 + 1;
        int r13 = r11 ^ (r2[r10] << 21);
        r7 = r13;
        if (r7 >= 0) goto L23;
        r8 = -2080896;
        goto L15
    L23:
        r10 = r5 + 1;
        byte r14 = r2[r5];
        r9 = (int) (((long) (r13 ^ (r14 << 28))) ^ 266354560);
        if (r14 >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
        r10 = r5 + 1;
        if (r2[r5] >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
        r10 = r5 + 1;
        if (r2[r5] >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
    L36:
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() throws IOException {
        int r0 = this.bufferPos;
        int r1 = this.bufferSize;
        if (r1 == r0) goto L40;
        byte[] r2 = this.buffer;
        int r3 = r0 + 1;
        byte r4 = r2[r0];
        if (r4 < 0) goto L10;
        this.bufferPos = r3;
        return r4;
    L10:
        if ((r1 - r3) < 9) goto L40;
        int r5 = r3 + 1;
        long r6 = r4 ^ (r2[r3] << 7);
        if (r6 >= 0) goto L16;
        long r7 = -128;
    L15:
        long r8 = r6 ^ r7;
    L43:
        this.bufferPos = r5;
        return r8;
    L16:
        int r9 = r5 + 1;
        long r10 = r6 ^ ((long) (r2[r5] << 14));
        if (r10 < 0) goto L20;
        long r11 = 16256;
    L19:
        r8 = r10 ^ r11;
        r5 = r9;
        goto L43
    L20:
        r5 = r9 + 1;
        r6 = r10 ^ ((long) (r2[r9] << 21));
        if (r6 >= 0) goto L23;
        r7 = -2080896;
        goto L15
    L23:
        r9 = r5 + 1;
        r10 = r6 ^ (((long) r2[r5]) << 28);
        if (r10 < 0) goto L26;
        r11 = 266354560;
        goto L19
    L26:
        r5 = r9 + 1;
        r6 = r10 ^ (((long) r2[r9]) << 35);
        if (r6 >= 0) goto L29;
        r7 = -34093383808L;
        goto L15
    L29:
        r9 = r5 + 1;
        r10 = r6 ^ (((long) r2[r5]) << 42);
        if (r10 < 0) goto L32;
        r11 = 4363953127296L;
        goto L19
    L32:
        r5 = r9 + 1;
        r6 = r10 ^ (((long) r2[r9]) << 49);
        if (r6 >= 0) goto L35;
        r7 = -558586000294016L;
        goto L15
    L35:
        int r12 = r5 + 1;
        long r13 = (r6 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
        if (r13 >= 0) goto L41;
        r5 = r12 + 1;
        if (r2[r12] < 0) goto L40;
    L42:
        r8 = r13;
        goto L43
    L41:
        r5 = r12;
    L40:
        return readRawVarint64SlowPath();
    }

    public long readRawVarint64SlowPath() throws IOException {
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 64) goto L10;
        byte r3 = readRawByte();
        r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
        if ((r3 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
        r2 = r2 + 7;
        goto L4
    L7:
        return r0;
    L10:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint64() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ByteString readBytes() throws IOException {
        int r0 = readRawVarint32();
        int r1 = this.bufferSize;
        int r2 = this.bufferPos;
        if (r0 > (r1 - r2)) goto L13;
        if (r0 <= 0) goto L13;
        if (this.bufferIsImmutable == true) goto L8;
    L10:
        BoundedByteString r3 = ByteString.copyFrom(this.buffer, r2, r0);
    L11:
        this.bufferPos += r0;
        return r3;
    L8:
        if (this.enableAliasing == false) goto L10;
        r3 = new BoundedByteString(this.buffer, this.bufferPos, r0);
    L13:
        if (r0 != 0) goto L17;
        return ByteString.EMPTY;
    L17:
        return new LiteralByteString(readRawBytesSlowPath(r0));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int r0 = readRawVarint32();
        int r1 = this.bufferSize;
        int r2 = this.bufferPos;
        if (r0 > (r1 - r2)) goto L7;
        if (r0 <= 0) goto L7;
        String r3 = new String(this.buffer, r2, r0, EffectRequest.DEFAULT_PARAMS_ENCODING);
        this.bufferPos += r0;
        return r3;
    L7:
        if (r0 != 0) goto L11;
        return "";
    L11:
        return new String(readRawBytesSlowPath(r0), EffectRequest.DEFAULT_PARAMS_ENCODING);
    }

    public String readStringRequireUtf8() throws IOException {
        int r0 = readRawVarint32();
        int r1 = this.bufferPos;
        if (r0 > (this.bufferSize - r1)) goto L6;
        if (r0 <= 0) goto L6;
        byte[] r2 = this.buffer;
        this.bufferPos = r1 + r0;
    L11:
        if (Utf8.isValidUtf8(r2, r1, r1 + r0) == false) goto L15;
        return new String(r2, r1, r0, EffectRequest.DEFAULT_PARAMS_ENCODING);
    L15:
        throw InvalidProtocolBufferException.invalidUtf8();
    L6:
        if (r0 != 0) goto L9;
        return "";
    L9:
        r2 = readRawBytesSlowPath(r0);
        r1 = 0;
        goto L11
    }

    public int readTag() throws IOException {
        if (isAtEnd() == false) goto L6;
        this.lastTag = 0;
        return 0;
    L6:
        int r0 = readRawVarint32();
        this.lastTag = r0;
        if (WireFormat.getTagFieldNumber(r0) == 0) goto L11;
        return this.lastTag;
    L11:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    private CodedInputStream(LiteralByteString r3) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = r3.bytes;
        int r1 = r3.getOffsetIntoBytes();
        this.bufferPos = r1;
        this.bufferSize = r1 + r3.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    private void ensureAvailable(int r3) throws IOException {
        if ((this.bufferSize - this.bufferPos) >= r3) goto L6;
        refillBuffer(r3);
        return;
    }

    public static CodedInputStream newInstance(LiteralByteString r1) {
        CodedInputStream r0 = new CodedInputStream(r1);
        r0.pushLimit(r1.size());     // Catch: InvalidProtocolBufferException -> L5
        return r0;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private byte[] readRawBytesSlowPath(int r13) throws IOException {
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L7;
        return Internal.EMPTY_BYTE_ARRAY;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r0 = this.totalBytesRetired;
        int r1 = this.bufferPos;
        int r2 = (r0 + r1) + r13;
        int r3 = this.currentLimit;
        if (r2 <= r3) goto L11;
        skipRawBytes((r3 - r0) - r1);
        throw InvalidProtocolBufferException.truncatedMessage();
    L11:
        if (r13 >= 4096) goto L14;
        byte[] r4 = new byte[r13];
        int r5 = this.bufferSize - r1;
        System.arraycopy(this.buffer, r1, r4, 0, r5);
        this.bufferPos = this.bufferSize;
        int r14 = r13 - r5;
        ensureAvailable(r14);
        System.arraycopy(this.buffer, 0, r4, r5, r14);
        this.bufferPos = r14;
        return r4;
    L14:
        int r6 = this.bufferSize;
        this.totalBytesRetired = r0 + r6;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int r7 = r6 - r1;
        int r8 = r13 - r7;
        ArrayList r9 = new ArrayList();
    L15:
        if (r8 <= 0) goto L27;
        int r10 = Math.min(r8, 4096);
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L26;
        InputStream r15 = this.input;
        if (r15 != null) goto L21;
        int r16 = -1;
    L22:
        if (r16 == (-1)) goto L25;
        this.totalBytesRetired += r16;
        r12 = r12 + r16;
        goto L17
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L21:
        r16 = r15.read(r11, r12, r10 - r12);
        goto L22
    L26:
        r8 = r8 - r10;
        r9.add(r11);
        goto L15
    L27:
        byte[] r17 = new byte[r13];
        System.arraycopy(this.buffer, r1, r17, 0, r7);
        Iterator r18 = r9.iterator();
    L29:
        if (r18.hasNext() == false) goto L31;
        byte[] r19 = (byte[]) r18.next();
        System.arraycopy(r19, 0, r17, r7, r19.length);
        r7 = r7 + r19.length;
        goto L29
    L31:
        return r17;
    }

    private void refillBuffer(int r1) throws IOException {
        if (tryRefillBuffer(r1) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void skipRawBytesSlowPath(int r5) throws IOException {
        if (r5 < 0) goto L14;
        int r0 = this.totalBytesRetired;
        int r1 = this.bufferPos;
        int r2 = (r0 + r1) + r5;
        int r3 = this.currentLimit;
        if (r2 > r3) goto L11;
        int r4 = this.bufferSize;
        int r6 = r4 - r1;
        this.bufferPos = r4;
        refillBuffer(1);
    L6:
        int r7 = r5 - r6;
        int r8 = this.bufferSize;
        if (r7 <= r8) goto L9;
        r6 = r6 + r8;
        this.bufferPos = r8;
        refillBuffer(1);
        goto L6
    L9:
        this.bufferPos = r7;
        return;
    L11:
        skipRawBytes((r3 - r0) - r1);
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    private boolean tryRefillBuffer(int r6) throws IOException {
        int r0 = this.bufferPos;
        if ((r0 + r6) > this.bufferSize) goto L5;
        StringBuilder r1 = new StringBuilder(77);
        r1.append("refillBuffer() called when ");
        r1.append(r6);
        r1.append(" bytes were already available in buffer");
        throw new IllegalStateException(r1.toString());
    L5:
        if (((this.totalBytesRetired + r0) + r6) <= this.currentLimit) goto L7;
        return false;
    L7:
        RefillCallback r2 = this.refillCallback;
        if (r2 == null) goto L11;
        r2.onRefill();
    L11:
        if (this.input == null) goto L36;
        int r3 = this.bufferPos;
        if (r3 <= 0) goto L18;
        int r4 = this.bufferSize;
        if (r4 <= r3) goto L17;
        byte[] r5 = this.buffer;
        System.arraycopy(r5, r3, r5, 0, r4 - r3);
    L17:
        this.totalBytesRetired += r3;
        this.bufferSize -= r3;
        this.bufferPos = 0;
    L18:
        InputStream r7 = this.input;
        byte[] r8 = this.buffer;
        int r9 = this.bufferSize;
        int r10 = r7.read(r8, r9, r8.length - r9);
        if (r10 != 0) goto L21;
    L34:
        StringBuilder r11 = new StringBuilder(102);
        r11.append("InputStream#read(byte[]) returned invalid result: ");
        r11.append(r10);
        r11.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r11.toString());
    L21:
        if (r10 < (-1)) goto L34;
        if (r10 > this.buffer.length) goto L34;
        if (r10 <= 0) goto L36;
        this.bufferSize += r10;
        if (((this.totalBytesRetired + r6) - this.sizeLimit) > 0) goto L33;
        recomputeBufferSizeAfterLimit();
        if (this.bufferSize < r6) goto L31;
        return true;
    L31:
        return tryRefillBuffer(r6);
    L33:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    L36:
        return false;
    }

    public void checkLastTagWas(int r2) throws InvalidProtocolBufferException {
        if (this.lastTag != r2) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void popLimit(int r1) {
        this.currentLimit = r1;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int r3) throws InvalidProtocolBufferException {
        if (r3 < 0) goto L10;
        int r4 = r3 + (this.totalBytesRetired + this.bufferPos);
        int r0 = this.currentLimit;
        if (r4 > r0) goto L8;
        this.currentLimit = r4;
        recomputeBufferSizeAfterLimit();
        return r0;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public void skipMessage(CodedOutputStream r2) throws IOException {
    L2:
        int r0 = readTag();
        if (r0 == 0) goto L6;
        if (skipField(r0, r2) == true) goto L2;
        return;
    }

    public void skipRawBytes(int r3) throws IOException {
        int r0 = this.bufferSize;
        int r1 = this.bufferPos;
        if (r3 > (r0 - r1)) goto L6;
        if (r3 < 0) goto L6;
        this.bufferPos = r1 + r3;
        return;
    L6:
        skipRawBytesSlowPath(r3);
    }

    private CodedInputStream(InputStream r3) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = r3;
        this.bufferIsImmutable = false;
    }

    public static CodedInputStream newInstance(InputStream r1) {
        return new CodedInputStream(r1);
    }

    public static int readRawVarint32(int r3, InputStream r4) throws IOException {
        if ((r3 & 128) != 0) goto L5;
        return r3;
    L5:
        int r5 = r3 & 127;
        int r0 = 7;
    L7:
        if (r0 >= 32) goto L17;
        int r1 = r4.read();
        if (r1 == (-1)) goto L15;
        r5 = r5 | ((r1 & 127) << r0);
        if ((r1 & 128) == 0) goto L12;
        r0 = r0 + 7;
        goto L7
    L12:
        return r5;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r0 >= 64) goto L27;
        int r2 = r4.read();
        if (r2 == (-1)) goto L25;
        if ((r2 & 128) == 0) goto L22;
        r0 = r0 + 7;
        goto L17
    L22:
        return r5;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public <T extends MessageLite> T readMessage(Parser<T> r4, ExtensionRegistryLite r5) throws IOException {
        int r0 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r1 = pushLimit(r0);
        this.recursionDepth++;
        T r6 = r4.parsePartialFrom(this, r5);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r1);
        return r6;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public boolean skipField(int r5, CodedOutputStream r6) throws IOException {
        int r0 = WireFormat.getTagWireType(r5);
        if (r0 == 0) goto L24;
        if (r0 != 1) goto L6;
        long r2 = readRawLittleEndian64();
        r6.writeRawVarint32(r5);
        r6.writeFixed64NoTag(r2);
        return true;
    L6:
        if (r0 != 2) goto L8;
        ByteString r1 = readBytes();
        r6.writeRawVarint32(r5);
        r6.writeBytesNoTag(r1);
        return true;
    L8:
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L11;
        return false;
    L11:
        if (r0 != 5) goto L15;
        int r3 = readRawLittleEndian32();
        r6.writeRawVarint32(r5);
        r6.writeFixed32NoTag(r3);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        r6.writeRawVarint32(r5);
        skipMessage(r6);
        int r7 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r5), 4);
        checkLastTagWas(r7);
        r6.writeRawVarint32(r7);
        return true;
    L24:
        long r4 = readInt64();
        r6.writeRawVarint32(r5);
        r6.writeUInt64NoTag(r4);
        return true;
    }

    public void readMessage(MessageLite.Builder r4, ExtensionRegistryLite r5) throws IOException {
        int r0 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r1 = pushLimit(r0);
        this.recursionDepth++;
        r4.mergeFrom(this, r5);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r1);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void readGroup(int r3, MessageLite.Builder r4, ExtensionRegistryLite r5) throws IOException {
        int r0 = this.recursionDepth;
        if (r0 >= this.recursionLimit) goto L7;
        this.recursionDepth = r0 + 1;
        r4.mergeFrom(this, r5);
        checkLastTagWas(WireFormat.makeTag(r3, 4));
        this.recursionDepth--;
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
}
