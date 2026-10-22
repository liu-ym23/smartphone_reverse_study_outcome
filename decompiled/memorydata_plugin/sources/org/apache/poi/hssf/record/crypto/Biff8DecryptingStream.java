package org.apache.poi.hssf.record.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.PushbackInputStream;
import kotlin.UShort;
import org.apache.poi.hssf.record.BiffHeaderInput;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class Biff8DecryptingStream implements BiffHeaderInput, LittleEndianInput {
    private final byte[] buffer;
    private final ChunkedCipherInputStream ccis;
    private boolean shouldSkipEncryptionOnCurrentRecord;

    public Biff8DecryptingStream(InputStream r5, int r6, EncryptionInfo r7) {
        this.buffer = new byte[8];
        byte[] r0 = IOUtils.safelyAllocate(r6, HSSFWorkbook.getMaxRecordLength());     // Catch: Exception -> L12
        if (r6 == 0) goto L8;
        PushbackInputStream r2 = new PushbackInputStream(r5, r6);     // Catch: Exception -> L12
        ((PushbackInputStream) ZeusTransformUtils.preCheckCast(r2, PushbackInputStream.class, "com.obric.memorydata.plugin")).unread(r0);     // Catch: Exception -> L12
        r5 = r2;
    L8:
        Decryptor r8 = r7.getDecryptor();     // Catch: Exception -> L12
        r8.setChunkSize(1024);     // Catch: Exception -> L12
        ChunkedCipherInputStream r9 = (ChunkedCipherInputStream) ZeusTransformUtils.preCheckCast(r8.getDataStream(r5, Integer.MAX_VALUE, 0), ChunkedCipherInputStream.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.ccis = r9;     // Catch: Exception -> L12
        if (r6 <= 0) goto L17;
        r9.readFully(r0);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        throw new RecordFormatException(e);
    }

    public static boolean isNeverEncryptedRecord(int r1) {
        if (r1 != 47) goto L5;
        return true;
    L5:
        if (r1 != 225) goto L7;
        return true;
    L7:
        if (r1 == 2057) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int available() {
        return this.ccis.available();
    }

    public boolean isCurrentRecordEncrypted() {
        return !this.shouldSkipEncryptionOnCurrentRecord;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        if (this.shouldSkipEncryptionOnCurrentRecord == false) goto L7;
        readPlain(this.buffer, 0, 1);
        return this.buffer[0];
    L7:
        return this.ccis.readByte();
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readDataSize() {
        readPlain(this.buffer, 0, 2);
        int r0 = LittleEndian.getUShort(this.buffer, 0);
        this.ccis.setNextRecordSize(r0);
        return r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double r0 = Double.longBitsToDouble(readLong());
        if (Double.isNaN(r0) == true) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Did not expect to read NaN");
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r3) {
        readFully(r3, 0, r3.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r2, int r3, int r4) {
        if (this.shouldSkipEncryptionOnCurrentRecord == false) goto L5;
        readPlain(r2, r3, r2.length);
        return;
    L5:
        this.ccis.readFully(r2, r3, r4);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        if (this.shouldSkipEncryptionOnCurrentRecord == false) goto L7;
        readPlain(this.buffer, 0, 4);
        return LittleEndian.getInt(this.buffer);
    L7:
        return this.ccis.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        if (this.shouldSkipEncryptionOnCurrentRecord == false) goto L7;
        readPlain(this.buffer, 0, 8);
        return LittleEndian.getLong(this.buffer);
    L7:
        return this.ccis.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r1, int r2, int r3) {
        this.ccis.readPlain(r1, r2, r3);
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readRecordSID() {
        readPlain(this.buffer, 0, 2);
        int r0 = LittleEndian.getUShort(this.buffer, 0);
        this.shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(r0);
        return r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        if (this.shouldSkipEncryptionOnCurrentRecord == false) goto L7;
        readPlain(this.buffer, 0, 2);
        return LittleEndian.getShort(this.buffer);
    L7:
        return this.ccis.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & UShort.MAX_VALUE;
    }
}
