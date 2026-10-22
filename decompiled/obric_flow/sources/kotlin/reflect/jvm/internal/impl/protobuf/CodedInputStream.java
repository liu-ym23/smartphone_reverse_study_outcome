package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;
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

    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream r5) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = r5;
        this.bufferIsImmutable = false;
    }

    public static int decodeZigZag32(int r5) {
        int r10 = r5 >>> 1;
        return (-(r5 & 1)) ^ r10;
    }

    public static long decodeZigZag64(long r5) {
        long r10 = r5 >>> 1;
        return (-(r5 & 1)) ^ r10;
    }

    private void ensureAvailable(int r5) throws IOException {
        if ((this.bufferSize - this.bufferPos) >= r5) goto L6;
        refillBuffer(r5);
        return;
    }

    public static CodedInputStream newInstance(InputStream r5) {
        return new CodedInputStream(r5);
    }

    private byte[] readRawBytesSlowPath(int r13) throws IOException {
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L7;
        return Internal.EMPTY_BYTE_ARRAY;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r5 = this.totalBytesRetired;
        int r10 = this.bufferPos;
        int r11 = (r5 + r10) + r13;
        int r12 = this.currentLimit;
        if (r11 <= r12) goto L11;
        skipRawBytes((r12 - r5) - r10);
        throw InvalidProtocolBufferException.truncatedMessage();
    L11:
        if (r13 >= 4096) goto L14;
        byte[] r14 = new byte[r13];
        int r15 = this.bufferSize - r10;
        System.arraycopy(this.buffer, r10, r14, 0, r15);
        this.bufferPos = this.bufferSize;
        int r16 = r13 - r15;
        ensureAvailable(r16);
        System.arraycopy(this.buffer, 0, r14, r15, r16);
        this.bufferPos = r16;
        return r14;
    L14:
        int r17 = this.bufferSize;
        this.totalBytesRetired = r5 + r17;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int r18 = r17 - r10;
        int r19 = r13 - r18;
        ArrayList r20 = new ArrayList();
    L15:
        if (r19 <= 0) goto L27;
        int r21 = Math.min(r19, 4096);
        byte[] r22 = new byte[r21];
        int r23 = 0;
    L17:
        if (r23 >= r21) goto L26;
        InputStream r24 = this.input;
        if (r24 != null) goto L21;
        int r25 = -1;
    L22:
        if (r25 == (-1)) goto L25;
        this.totalBytesRetired += r25;
        r23 = r23 + r25;
        goto L17
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L21:
        r25 = r24.read(r22, r23, r21 - r23);
        goto L22
    L26:
        r19 = r19 - r21;
        r20.add(r22);
        goto L15
    L27:
        byte[] r110 = new byte[r13];
        System.arraycopy(this.buffer, r10, r110, 0, r18);
        Iterator r111 = r20.iterator();
    L29:
        if (r111.hasNext() == false) goto L31;
        byte[] r26 = (byte[]) r111.next();
        System.arraycopy(r26, 0, r110, r18, r26.length);
        r18 = r18 + r26.length;
        goto L29
    L31:
        return r110;
    }

    private void recomputeBufferSizeAfterLimit() {
        int r5 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = r5;
        int r10 = this.totalBytesRetired + r5;
        int r11 = this.currentLimit;
        if (r10 <= r11) goto L5;
        int r12 = r10 - r11;
        this.bufferSizeAfterLimit = r12;
        this.bufferSize = r5 - r12;
        return;
    L5:
        this.bufferSizeAfterLimit = 0;
    }

    private void refillBuffer(int r5) throws IOException {
        if (tryRefillBuffer(r5) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void skipRawBytesSlowPath(int r5) throws IOException {
        if (r5 < 0) goto L14;
        int r10 = this.totalBytesRetired;
        int r11 = this.bufferPos;
        int r12 = (r10 + r11) + r5;
        int r13 = this.currentLimit;
        if (r12 > r13) goto L11;
        int r14 = this.bufferSize;
        int r15 = r14 - r11;
        this.bufferPos = r14;
        refillBuffer(1);
    L6:
        int r16 = r5 - r15;
        int r17 = this.bufferSize;
        if (r16 <= r17) goto L9;
        r15 = r15 + r17;
        this.bufferPos = r17;
        refillBuffer(1);
        goto L6
    L9:
        this.bufferPos = r16;
        return;
    L11:
        skipRawBytes((r13 - r10) - r11);
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    private boolean tryRefillBuffer(int r10) throws IOException {
        int r5 = this.bufferPos;
        if ((r5 + r10) > this.bufferSize) goto L5;
        StringBuilder r11 = new StringBuilder(77);
        r11.append("refillBuffer() called when ");
        r11.append(r10);
        r11.append(" bytes were already available in buffer");
        throw new IllegalStateException(r11.toString());
    L5:
        if (((this.totalBytesRetired + r5) + r10) <= this.currentLimit) goto L7;
        return false;
    L7:
        RefillCallback r12 = this.refillCallback;
        if (r12 == null) goto L11;
        r12.onRefill();
    L11:
        if (this.input == null) goto L36;
        int r13 = this.bufferPos;
        if (r13 <= 0) goto L18;
        int r14 = this.bufferSize;
        if (r14 <= r13) goto L17;
        byte[] r15 = this.buffer;
        System.arraycopy(r15, r13, r15, 0, r14 - r13);
    L17:
        this.totalBytesRetired += r13;
        this.bufferSize -= r13;
        this.bufferPos = 0;
    L18:
        InputStream r16 = this.input;
        byte[] r17 = this.buffer;
        int r18 = this.bufferSize;
        int r19 = r16.read(r17, r18, r17.length - r18);
        if (r19 != 0) goto L21;
    L34:
        StringBuilder r20 = new StringBuilder(102);
        r20.append("InputStream#read(byte[]) returned invalid result: ");
        r20.append(r19);
        r20.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r20.toString());
    L21:
        if (r19 < (-1)) goto L34;
        if (r19 > this.buffer.length) goto L34;
        if (r19 <= 0) goto L36;
        this.bufferSize += r19;
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

    public void checkLastTagWas(int r5) throws InvalidProtocolBufferException {
        if (this.lastTag != r5) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public int getBytesUntilLimit() {
        int r5 = this.currentLimit;
        if (r5 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r5 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        if (this.bufferPos == this.bufferSize) goto L5;
    L7:
        return false;
    L5:
        if (tryRefillBuffer(1) == true) goto L7;
        return true;
    }

    public void popLimit(int r5) {
        this.currentLimit = r5;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int r5) throws InvalidProtocolBufferException {
        if (r5 < 0) goto L10;
        int r10 = (this.totalBytesRetired + this.bufferPos) + r5;
        int r11 = this.currentLimit;
        if (r10 > r11) goto L8;
        this.currentLimit = r10;
        recomputeBufferSizeAfterLimit();
        return r11;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint64() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ByteString readBytes() throws IOException {
        int r5 = readRawVarint32();
        int r10 = this.bufferSize;
        int r11 = this.bufferPos;
        if (r5 > (r10 - r11)) goto L13;
        if (r5 <= 0) goto L13;
        if (this.bufferIsImmutable == true) goto L8;
    L10:
        ByteString r12 = ByteString.copyFrom(this.buffer, r11, r5);
    L11:
        this.bufferPos += r5;
        return r12;
    L8:
        if (this.enableAliasing == false) goto L10;
        r12 = new BoundedByteString(this.buffer, this.bufferPos, r5);
    L13:
        if (r5 != 0) goto L17;
        return ByteString.EMPTY;
    L17:
        return new LiteralByteString(readRawBytesSlowPath(r5));
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

    public void readGroup(int r5, MessageLite.Builder r10, ExtensionRegistryLite r11) throws IOException {
        int r12 = this.recursionDepth;
        if (r12 >= this.recursionLimit) goto L7;
        this.recursionDepth = r12 + 1;
        r10.mergeFrom(this, r11);
        checkLastTagWas(WireFormat.makeTag(r5, 4));
        this.recursionDepth--;
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder r5, ExtensionRegistryLite r10) throws IOException {
        int r11 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r12 = pushLimit(r11);
        this.recursionDepth++;
        r5.mergeFrom(this, r10);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r12);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos != this.bufferSize) goto L5;
        refillBuffer(1);
    L5:
        byte[] r5 = this.buffer;
        int r10 = this.bufferPos;
        this.bufferPos = r10 + 1;
        return r5[r10];
    }

    public int readRawLittleEndian32() throws IOException {
        int r5 = this.bufferPos;
        if ((this.bufferSize - r5) >= 4) goto L5;
        refillBuffer(4);
        r5 = this.bufferPos;
    L5:
        byte[] r10 = this.buffer;
        this.bufferPos = r5 + 4;
        return (((r10[r5] & UByte.MAX_VALUE) | ((r10[r5 + 1] & UByte.MAX_VALUE) << 8)) | ((r10[r5 + 2] & UByte.MAX_VALUE) << 16)) | ((r10[r5 + 3] & UByte.MAX_VALUE) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        int r5 = this.bufferPos;
        if ((this.bufferSize - r5) >= 8) goto L5;
        refillBuffer(8);
        r5 = this.bufferPos;
    L5:
        byte[] r10 = this.buffer;
        this.bufferPos = r5 + 8;
        long r11 = ((((((((long) r10[r5]) & 255) | ((((long) r10[r5 + 1]) & 255) << 8)) | ((((long) r10[r5 + 2]) & 255) << 16)) | ((((long) r10[r5 + 3]) & 255) << 24)) | ((((long) r10[r5 + 4]) & 255) << 32)) | ((((long) r10[r5 + 5]) & 255) << 40)) | ((((long) r10[r5 + 6]) & 255) << 48);
        return ((((long) r10[r5 + 7]) & 255) << 56) | r11;
    }

    public int readRawVarint32() throws IOException {
        int r5 = this.bufferPos;
        int r10 = this.bufferSize;
        if (r10 == r5) goto L36;
        byte[] r11 = this.buffer;
        int r12 = r5 + 1;
        byte r13 = r11[r5];
        if (r13 < 0) goto L10;
        this.bufferPos = r12;
        return r13;
    L10:
        if ((r10 - r12) < 9) goto L36;
        int r14 = r5 + 2;
        int r15 = (r11[r12] << 7) ^ r13;
        long r16 = r15;
        if (r16 >= 0) goto L15;
        int r17 = (int) ((-128) ^ r16);
    L40:
        this.bufferPos = r14;
        return r17;
    L15:
        int r18 = r5 + 3;
        int r19 = (r11[r14] << 14) ^ r15;
        long r20 = r19;
        if (r20 < 0) goto L19;
        r17 = (int) (16256 ^ r20);
    L18:
        r14 = r18;
        goto L40
    L19:
        int r21 = r5 + 4;
        int r22 = r19 ^ (r11[r18] << 21);
        long r23 = r22;
        if (r23 >= 0) goto L23;
        r17 = (int) ((-2080896) ^ r23);
    L22:
        r14 = r21;
        goto L40
    L23:
        r18 = r5 + 5;
        byte r24 = r11[r21];
        int r25 = (int) (((long) (r22 ^ (r24 << 28))) ^ 266354560);
        if (r24 >= 0) goto L38;
        r21 = r5 + 6;
        if (r11[r18] >= 0) goto L39;
        r18 = r5 + 7;
        if (r11[r21] >= 0) goto L38;
        r21 = r5 + 8;
        if (r11[r18] >= 0) goto L39;
        r18 = r5 + 9;
        if (r11[r21] >= 0) goto L38;
        int r26 = r5 + 10;
        if (r11[r18] < 0) goto L36;
        r14 = r26;
        r17 = r25;
    L39:
        r17 = r25;
    L38:
        r17 = r25;
    L36:
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() throws IOException {
        int r5 = this.bufferPos;
        int r10 = this.bufferSize;
        if (r10 == r5) goto L41;
        byte[] r11 = this.buffer;
        int r12 = r5 + 1;
        byte r13 = r11[r5];
        if (r13 < 0) goto L10;
        this.bufferPos = r12;
        return r13;
    L10:
        if ((r10 - r12) < 9) goto L41;
        int r14 = r5 + 2;
        long r15 = (r11[r12] << 7) ^ r13;
        if (r15 >= 0) goto L16;
        long r16 = -128;
    L15:
        long r17 = r15 ^ r16;
    L44:
        this.bufferPos = r14;
        return r17;
    L16:
        int r18 = r5 + 3;
        long r19 = r15 ^ ((long) (r11[r14] << 14));
        if (r19 < 0) goto L21;
        long r20 = 16256;
    L19:
        r17 = r19 ^ r20;
    L20:
        r14 = r18;
        goto L44
    L21:
        r14 = r5 + 4;
        r15 = r19 ^ ((long) (r11[r18] << 21));
        if (r15 >= 0) goto L24;
        r16 = -2080896;
        goto L15
    L24:
        r18 = r5 + 5;
        r19 = r15 ^ (((long) r11[r14]) << 28);
        if (r19 < 0) goto L27;
        r20 = 266354560;
        goto L19
    L27:
        r14 = r5 + 6;
        r15 = r19 ^ (((long) r11[r18]) << 35);
        if (r15 >= 0) goto L30;
        r16 = -34093383808L;
        goto L15
    L30:
        r18 = r5 + 7;
        r19 = r15 ^ (((long) r11[r14]) << 42);
        if (r19 < 0) goto L33;
        r20 = 4363953127296L;
        goto L19
    L33:
        r14 = r5 + 8;
        r15 = r19 ^ (((long) r11[r18]) << 49);
        if (r15 >= 0) goto L36;
        r16 = -558586000294016L;
        goto L15
    L36:
        r18 = r5 + 9;
        long r21 = (r15 ^ (((long) r11[r14]) << 56)) ^ 71499008037633920L;
        if (r21 >= 0) goto L43;
        r14 = r5 + 10;
        if (r11[r18] < 0) goto L41;
        r17 = r21;
        goto L44
    L43:
        r17 = r21;
    L41:
        return readRawVarint64SlowPath();
    }

    public long readRawVarint64SlowPath() throws IOException {
        long r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 64) goto L10;
        byte r11 = readRawByte();
        r5 = r5 | (((long) (r11 & ByteCompanionObject.MAX_VALUE)) << r10);
        if ((r11 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
        r10 = r10 + 7;
        goto L4
    L7:
        return r5;
    L10:
        throw InvalidProtocolBufferException.malformedVarint();
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
        int r5 = readRawVarint32();
        int r10 = this.bufferSize;
        int r11 = this.bufferPos;
        if (r5 > (r10 - r11)) goto L7;
        if (r5 <= 0) goto L7;
        String r12 = new String(this.buffer, r11, r5, "UTF-8");
        this.bufferPos += r5;
        return r12;
    L7:
        if (r5 != 0) goto L11;
        return "";
    L11:
        return new String(readRawBytesSlowPath(r5), "UTF-8");
    }

    public String readStringRequireUtf8() throws IOException {
        int r5 = readRawVarint32();
        int r10 = this.bufferPos;
        if (r5 > (this.bufferSize - r10)) goto L6;
        if (r5 <= 0) goto L6;
        byte[] r11 = this.buffer;
        this.bufferPos = r10 + r5;
    L11:
        if (Utf8.isValidUtf8(r11, r10, r10 + r5) == false) goto L15;
        return new String(r11, r10, r5, "UTF-8");
    L15:
        throw InvalidProtocolBufferException.invalidUtf8();
    L6:
        if (r5 != 0) goto L9;
        return "";
    L9:
        r11 = readRawBytesSlowPath(r5);
        r10 = 0;
        goto L11
    }

    public int readTag() throws IOException {
        if (isAtEnd() == false) goto L6;
        this.lastTag = 0;
        return 0;
    L6:
        int r5 = readRawVarint32();
        this.lastTag = r5;
        if (WireFormat.getTagFieldNumber(r5) == 0) goto L11;
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

    public boolean skipField(int r5, CodedOutputStream r10) throws IOException {
        int r11 = WireFormat.getTagWireType(r5);
        if (r11 == 0) goto L24;
        if (r11 != 1) goto L6;
        long r12 = readRawLittleEndian64();
        r10.writeRawVarint32(r5);
        r10.writeFixed64NoTag(r12);
        return true;
    L6:
        if (r11 != 2) goto L8;
        ByteString r13 = readBytes();
        r10.writeRawVarint32(r5);
        r10.writeBytesNoTag(r13);
        return true;
    L8:
        if (r11 == 3) goto L18;
        if (r11 != 4) goto L11;
        return false;
    L11:
        if (r11 != 5) goto L15;
        int r14 = readRawLittleEndian32();
        r10.writeRawVarint32(r5);
        r10.writeFixed32NoTag(r14);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        r10.writeRawVarint32(r5);
        skipMessage(r10);
        int r15 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r5), 4);
        checkLastTagWas(r15);
        r10.writeRawVarint32(r15);
        return true;
    L24:
        long r16 = readInt64();
        r10.writeRawVarint32(r5);
        r10.writeUInt64NoTag(r16);
        return true;
    }

    public void skipMessage(CodedOutputStream r5) throws IOException {
    L2:
        int r10 = readTag();
        if (r10 == 0) goto L6;
        if (skipField(r10, r5) == true) goto L2;
        return;
    }

    public void skipRawBytes(int r5) throws IOException {
        int r10 = this.bufferSize;
        int r11 = this.bufferPos;
        if (r5 > (r10 - r11)) goto L6;
        if (r5 < 0) goto L6;
        this.bufferPos = r11 + r5;
        return;
    L6:
        skipRawBytesSlowPath(r5);
    }

    public static CodedInputStream newInstance(LiteralByteString r5) {
        CodedInputStream r10 = new CodedInputStream(r5);
        r10.pushLimit(r5.size());     // Catch: InvalidProtocolBufferException -> L5
        return r10;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public <T extends MessageLite> T readMessage(Parser<T> r5, ExtensionRegistryLite r10) throws IOException {
        int r11 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) goto L7;
        int r12 = pushLimit(r11);
        this.recursionDepth++;
        T r13 = r5.parsePartialFrom(this, r10);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(r12);
        return r13;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private CodedInputStream(LiteralByteString r5) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.refillCallback = null;
        this.buffer = r5.bytes;
        int r10 = r5.getOffsetIntoBytes();
        this.bufferPos = r10;
        this.bufferSize = r10 + r5.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int readRawVarint32(int r5, InputStream r10) throws IOException {
        if ((r5 & 128) != 0) goto L5;
        return r5;
    L5:
        int r11 = r5 & 127;
        int r12 = 7;
    L7:
        if (r12 >= 32) goto L17;
        int r13 = r10.read();
        if (r13 == (-1)) goto L15;
        r11 = r11 | ((r13 & 127) << r12);
        if ((r13 & 128) == 0) goto L12;
        r12 = r12 + 7;
        goto L7
    L12:
        return r11;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r12 >= 64) goto L27;
        int r14 = r10.read();
        if (r14 == (-1)) goto L25;
        if ((r14 & 128) == 0) goto L22;
        r12 = r12 + 7;
        goto L17
    L22:
        return r11;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
