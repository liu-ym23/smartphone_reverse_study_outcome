package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Zip64ExtendedInformationExtraField implements ZipExtraField {
    static final ZipShort HEADER_ID = null;
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;

    static {
        HEADER_ID = new ZipShort(1);
    }

    public Zip64ExtendedInformationExtraField() {
    }

    private int addSizes(byte[] r4) {
        ZipEightByteInteger r0 = this.size;
        if (r0 == null) goto L5;
        System.arraycopy(r0.getBytes(), 0, r4, 0, 8);
        int r1 = 8;
    L6:
        ZipEightByteInteger r3 = this.compressedSize;
        if (r3 == null) goto L10;
        System.arraycopy(r3.getBytes(), 0, r4, r1, 8);
        return r1 + 8;
    L10:
        return r1;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r0 = new byte[getCentralDirectoryLength().getValue()];
        int r1 = addSizes(r0);
        ZipEightByteInteger r2 = this.relativeHeaderOffset;
        if (r2 == null) goto L5;
        System.arraycopy(r2.getBytes(), 0, r0, r1, 8);
        r1 = r1 + 8;
    L5:
        ZipLong r5 = this.diskStart;
        if (r5 == null) goto L8;
        System.arraycopy(r5.getBytes(), 0, r0, r1, 4);
    L8:
        return r0;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        int r2 = 8;
        int r3 = 0;
        if (this.size == null) goto L5;
        int r1 = 8;
    L7:
        if (this.compressedSize == null) goto L9;
        int r4 = 8;
    L10:
        int r5 = r1 + r4;
        if (this.relativeHeaderOffset != null) goto L14;
        r2 = 0;
    L14:
        int r6 = r5 + r2;
        if (this.diskStart == null) goto L18;
        r3 = 4;
    L18:
        return new ZipShort(r6 + r3);
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L7
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        ZipEightByteInteger r0 = this.size;
        if (r0 == null) goto L5;
    L9:
        if (r0 == null) goto L15;
        if (this.compressedSize == null) goto L15;
        byte[] r1 = new byte[16];
        addSizes(r1);
        return r1;
    L15:
        throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
    L5:
        if (this.compressedSize != null) goto L9;
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        if (this.size == null) goto L5;
        int r1 = 16;
    L7:
        return new ZipShort(r1);
    L5:
        r1 = 0;
        goto L7
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r3, int r4, int r5) {
        byte[] r0 = new byte[r5];
        this.rawCentralDirectoryData = r0;
        System.arraycopy(r3, r4, r0, 0, r5);
        if (r5 < 28) goto L6;
        parseFromLocalFileData(r3, r4, r5);
        return;
    L6:
        if (r5 != 24) goto L9;
        this.size = new ZipEightByteInteger(r3, r4);
        int r6 = r4 + 8;
        this.compressedSize = new ZipEightByteInteger(r3, r6);
        this.relativeHeaderOffset = new ZipEightByteInteger(r3, r6 + 8);
        return;
    L9:
        if ((r5 % 8) != 4) goto L14;
        this.diskStart = new ZipLong(r3, (r4 + r5) - 4);
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r4, int r5, int r6) {
        if (r6 != 0) goto L5;
        return;
    L5:
        if (r6 < 16) goto L14;
        this.size = new ZipEightByteInteger(r4, r5);
        int r7 = r5 + 8;
        this.compressedSize = new ZipEightByteInteger(r4, r7);
        int r8 = r7 + 8;
        int r9 = r6 - 16;
        if (r9 < 8) goto L10;
        this.relativeHeaderOffset = new ZipEightByteInteger(r4, r8);
        r8 = r8 + 8;
        r9 = r9 - 8;
    L10:
        if (r9 < 4) goto L15;
        this.diskStart = new ZipLong(r4, r8);
        return;
    L15:
        return;
    L14:
        throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
    }

    public void reparseCentralDirectoryData(boolean r6, boolean r7, boolean r8, boolean r9) {
        byte[] r0 = this.rawCentralDirectoryData;
        if (r0 == null) goto L31;
        int r1 = 0;
        if (r6 == false) goto L7;
        int r3 = 8;
    L8:
        if (r7 == false) goto L10;
        int r4 = 8;
    L11:
        int r5 = r3 + r4;
        if (r8 == false) goto L14;
        int r10 = 8;
    L15:
        int r11 = r5 + r10;
        if (r9 == false) goto L18;
        int r12 = 4;
    L19:
        int r13 = r11 + r12;
        if (r0.length < r13) goto L30;
        if (r6 == false) goto L23;
        this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
        r1 = 8;
    L23:
        if (r7 == false) goto L25;
        this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, r1);
        r1 = r1 + 8;
    L25:
        if (r8 == false) goto L27;
        this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, r1);
        r1 = r1 + 8;
    L27:
        if (r9 == false) goto L32;
        this.diskStart = new ZipLong(this.rawCentralDirectoryData, r1);
        return;
    L32:
        return;
    L30:
        throw new ZipException("Central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + r13 + " but is " + this.rawCentralDirectoryData.length);
    L18:
        r12 = 0;
        goto L19
    L14:
        r10 = 0;
        goto L15
    L10:
        r4 = 0;
        goto L11
    L7:
        r3 = 0;
        goto L8
    }

    public void setCompressedSize(ZipEightByteInteger r1) {
        this.compressedSize = r1;
    }

    public void setDiskStartNumber(ZipLong r1) {
        this.diskStart = r1;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger r1) {
        this.relativeHeaderOffset = r1;
    }

    public void setSize(ZipEightByteInteger r1) {
        this.size = r1;
    }
}
