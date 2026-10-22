package org.apache.commons.compress.archivers.zip;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUnicodeExtraField implements ZipExtraField {
    private byte[] data;
    private long nameCRC32;
    private byte[] unicodeName;

    public AbstractUnicodeExtraField() {
    }

    public AbstractUnicodeExtraField(String r2, byte[] r3, int r4, int r5) {
        CRC32 r0 = new CRC32();
        r0.update(r3, r4, r5);
        this.nameCRC32 = r0.getValue();
        this.unicodeName = r2.getBytes(StandardCharsets.UTF_8);
    }

    private void assembleData() {
        byte[] r0 = this.unicodeName;
        if (r0 != null) goto L5;
        return;
    L5:
        byte[] r1 = new byte[r0.length + 5];
        this.data = r1;
        r1[0] = 1;
        System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
        byte[] r2 = this.unicodeName;
        System.arraycopy(r2, 0, this.data, 5, r2.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.data != null) goto L5;
        assembleData();
    L5:
        byte[] r3 = this.data;
        if (r3 == null) goto L9;
        int r0 = r3.length;
        byte[] r1 = new byte[r0];
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    L9:
        return null;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.data != null) goto L5;
        assembleData();
    L5:
        byte[] r1 = this.data;
        if (r1 == null) goto L8;
        int r2 = r1.length;
    L10:
        return new ZipShort(r2);
    L8:
        r2 = 0;
        goto L10
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public long getNameCRC32() {
        return this.nameCRC32;
    }

    public byte[] getUnicodeName() {
        byte[] r3 = this.unicodeName;
        if (r3 == null) goto L5;
        int r0 = r3.length;
        byte[] r1 = new byte[r0];
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    L5:
        return null;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        parseFromLocalFileData(r1, r2, r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r4, int r5, int r6) {
        if (r6 < 5) goto L11;
        byte r1 = r4[r5];
        if (r1 != 1) goto L9;
        this.nameCRC32 = ZipLong.getValue(r4, r5 + 1);
        int r7 = r6 - 5;
        byte[] r2 = new byte[r7];
        this.unicodeName = r2;
        System.arraycopy(r4, r5 + 5, r2, 0, r7);
        this.data = null;
        return;
    L9:
        throw new ZipException("Unsupported version [" + r1 + "] for UniCode path extra data.");
    L11:
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }
}
