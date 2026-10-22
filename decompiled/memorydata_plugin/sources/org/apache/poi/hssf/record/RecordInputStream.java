package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class RecordInputStream implements LittleEndianInput {
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private final BiffHeaderInput _bhi;
    private int _currentDataLength;
    private int _currentDataOffset;
    private int _currentSid;
    private final LittleEndianInput _dataInput;
    private int _markedDataOffset;
    private int _nextSid;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.RecordInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class LeftoverDataException extends RuntimeException {
        public LeftoverDataException(int r4, int r5) {
            super("Initialisation of record 0x" + Integer.toHexString(r4).toUpperCase(Locale.ROOT) + "(" + getRecordName(r4) + ") left " + r5 + " bytes remaining still to be read.");
        }

        private static String getRecordName(int r0) {
            Class<? extends Record> r1 = RecordFactory.getRecordClass(r0);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.getSimpleName();
        }
    }

    private static final class SimpleHeaderInput implements BiffHeaderInput {
        private final LittleEndianInput _lei;

        private SimpleHeaderInput(LittleEndianInput r3) {
            this._lei = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ SimpleHeaderInput(LittleEndianInput r2, AnonymousClass1 r3) {
            this((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int available() {
            return this._lei.available();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readDataSize() {
            return this._lei.readUShort();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readRecordSID() {
            return this._lei.readUShort();
        }
    }

    static {
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public RecordInputStream(InputStream r3) {
        this(r3, null, 0);
    }

    public RecordInputStream(InputStream r2, EncryptionInfo r3, int r4) {
        if (r3 == null) goto L5;
        Biff8DecryptingStream r0 = new Biff8DecryptingStream(r2, r4, r3);
        this._dataInput = r0;
        this._bhi = r0;
    L10:
        this._nextSid = readNextSid();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, LittleEndianInput.class) == false) goto L7;
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.preCheckCast(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
    L8:
        this._dataInput = r5;
        this._bhi = new SimpleHeaderInput(r5, null);
        goto L10
    L7:
        r5 = new LittleEndianInputStream(r2);
        goto L8
    }

    private void checkRecordPosition(int r4) {
        int r0 = remaining();
        if (r0 < r4) goto L5;
        return;
    L5:
        if (r0 != 0) goto L11;
        if (isContinueNext() == false) goto L11;
        nextRecord();
        return;
    L11:
        throw new RecordFormatException("Not enough data (" + r0 + ") to read requested (" + r4 + ") bytes");
    }

    private boolean isContinueNext() {
        int r0 = this._currentDataLength;
        if (r0 == (-1)) goto L10;
        if (this._currentDataOffset == r0) goto L10;
        throw new IllegalStateException("Should never be called before end of current record");
    L10:
        if (hasNextRecord() == true) goto L13;
        return false;
    L13:
        if (this._nextSid != 60) goto L16;
        return true;
    L16:
        return false;
    }

    private void readFully(byte[] r4, int r5, int r6, boolean r7) {
        Objects.requireNonNull(r4);
        if (r5 < 0) goto L27;
        if (r6 < 0) goto L27;
        if (r6 > (r4.length - r5)) goto L27;
        int r0 = r6;
    L8:
        if (r0 <= 0) goto L25;
        int r1 = Math.min(available(), r0);
        if (r1 == 0) goto L12;
    L20:
        checkRecordPosition(r1);
        LittleEndianInput r2 = this._dataInput;
        if (r7 == false) goto L23;
        r2.readPlain(r4, r5, r1);
    L24:
        this._currentDataOffset += r1;
        r5 = r5 + r1;
        r0 = r0 - r1;
        goto L8
    L23:
        r2.readFully(r4, r5, r1);
        goto L24
    L12:
        if (hasNextRecord() == false) goto L19;
        nextRecord();
        r1 = Math.min(available(), r0);
        if (r1 > 0) goto L20;
        throw new RecordFormatException("Need to have a valid next chunk, but had: " + r1 + " with len: " + r0 + " and available: " + available());
    L19:
        throw new RecordFormatException("Can't read the remaining " + r0 + " bytes of the requested " + r6 + " bytes. No further record exists.");
    L25:
        return;
    L27:
        throw new IndexOutOfBoundsException();
    }

    private int readNextSid() {
        if (this._bhi.available() >= 4) goto L5;
        return -1;
    L5:
        int r0 = this._bhi.readRecordSID();
        if (r0 == (-1)) goto L10;
        this._currentDataLength = -1;
        return r0;
    L10:
        throw new RecordFormatException("Found invalid sid (" + r0 + ")");
    }

    private String readStringCommon(int r6, boolean r7) {
        if (r6 < 0) goto L42;
        if (r6 > 1048576) goto L42;
        char[] r0 = new char[r6];
        int r2 = 0;
    L6:
        int r3 = remaining();
        if (r7 == true) goto L11;
        r3 = r3 / 2;
    L11:
        if ((r6 - r2) <= r3) goto L12;
    L19:
        if (r3 <= 0) goto L25;
        if (r7 == false) goto L22;
        int r4 = readUByte();
    L23:
        r0[r2] = (char) r4;
        r2 = r2 + 1;
        r3 = r3 - 1;
        goto L19
    L22:
        r4 = readShort();
        goto L23
    L25:
        if (isContinueNext() == false) goto L40;
        if (remaining() != 0) goto L38;
        nextRecord();
        byte r8 = readByte();
        if (r8 == 0) goto L34;
        if (r8 == 1) goto L34;
        throw new RecordFormatException("Invalid compressFlag: " + r8);
    L34:
        if (r8 == 0) goto L35;
        r7 = false;
        goto L6
    L35:
        r7 = true;
        goto L6
    L38:
        throw new RecordFormatException("Odd number of bytes(" + remaining() + ") left behind");
    L40:
        throw new RecordFormatException("Expected to find a ContinueRecord in order to read remaining " + (r6 - r2) + " of " + r6 + " chars");
    L12:
        if (r2 >= r6) goto L18;
        if (r7 == false) goto L15;
        int r1 = readUByte();
    L16:
        r0[r2] = (char) r1;
        r2 = r2 + 1;
        goto L12
    L15:
        r1 = readShort();
        goto L16
    L18:
        return new String(r0);
    L42:
        throw new IllegalArgumentException("Bad requested string length (" + r6 + ")");
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return remaining();
    }

    public int getNextSid() {
        return this._nextSid;
    }

    public short getSid() {
        return (short) this._currentSid;
    }

    public boolean hasNextRecord() {
        int r0 = this._currentDataLength;
        if (r0 != (-1)) goto L5;
    L9:
        if (r0 == (-1)) goto L12;
        this._nextSid = readNextSid();
    L12:
        if (this._nextSid == (-1)) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r0 == this._currentDataOffset) goto L9;
        throw new LeftoverDataException(this._currentSid, remaining());
    }

    public boolean isEncrypted() {
        if (ZeusTransformUtils.instanceOf(this._dataInput, Biff8DecryptingStream.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Biff8DecryptingStream) ZeusTransformUtils.preCheckCast(this._dataInput, Biff8DecryptingStream.class, "com.obric.memorydata.plugin")).isCurrentRecordEncrypted() == false) goto L7;
        return true;
    }

    public void mark(int r4) {
        ((InputStream) ZeusTransformUtils.preCheckCast(this._dataInput, InputStream.class, "com.obric.memorydata.plugin")).mark(r4);
        this._markedDataOffset = this._currentDataOffset;
    }

    public void nextRecord() {
        int r0 = this._nextSid;
        if (r0 == (-1)) goto L14;
        if (this._currentDataLength != (-1)) goto L12;
        this._currentSid = r0;
        this._currentDataOffset = 0;
        int r1 = this._bhi.readDataSize();
        this._currentDataLength = r1;
        if (r1 > 8224) goto L10;
        return;
    L10:
        throw new RecordFormatException("The content of an excel record cannot exceed 8224 bytes");
    L12:
        throw new IllegalStateException("Cannot call nextRecord() without checking hasNextRecord() first");
    L14:
        throw new IllegalStateException("EOF - next record not available");
    }

    @Deprecated
    public byte[] readAllContinuedRemainder() {
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream(16448);     // Catch: IOException -> L18
    L21:
        byte[] r1 = readRemainder();     // Catch: Throwable -> L10
        r0.write(r1, 0, r1.length);     // Catch: Throwable -> L10
        if (isContinueNext() == false) goto L5;
        nextRecord();     // Catch: Throwable -> L10
        goto L21
    L5:
        byte[] r4 = r0.toByteArray();     // Catch: Throwable -> L10
        r0.close();     // Catch: IOException -> L18
        return r4;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new RecordFormatException(e);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkRecordPosition(1);
        this._currentDataOffset++;
        return this._dataInput.readByte();
    }

    public String readCompressedUnicode(int r2) {
        return readStringCommon(r2, true);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r3) {
        readFully(r3, 0, r3.length, false);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r2, int r3, int r4) {
        readFully(r2, r3, r4, false);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkRecordPosition(4);
        this._currentDataOffset += 4;
        return this._dataInput.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkRecordPosition(8);
        this._currentDataOffset += 8;
        return this._dataInput.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r2, int r3, int r4) {
        readFully(r2, 0, r2.length, true);
    }

    public byte[] readRemainder() {
        int r0 = remaining();
        if (r0 == 0) goto L5;
        byte[] r1 = IOUtils.safelyAllocate(r0, HSSFWorkbook.getMaxRecordLength());
        readFully(r1);
        return r1;
    L5:
        return EMPTY_BYTE_ARRAY;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readShort();
    }

    public String readString() {
        int r0 = readUShort();
        if (readByte() != 0) goto L5;
        boolean r1 = true;
    L7:
        return readStringCommon(r0, r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readUShort();
    }

    public String readUnicodeLEString(int r2) {
        return readStringCommon(r2, false);
    }

    public int remaining() {
        int r0 = this._currentDataLength;
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r0 - this._currentDataOffset;
    }

    public void reset() {
        ((InputStream) ZeusTransformUtils.preCheckCast(this._dataInput, InputStream.class, "com.obric.memorydata.plugin")).reset();
        this._currentDataOffset = this._markedDataOffset;
    }
}
