package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class UnparseableExtraFieldData implements ZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    static {
        HEADER_ID = new ZipShort(44225);
    }

    public UnparseableExtraFieldData() {
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r0 = this.centralDirectoryData;
        if (r0 != null) goto L6;
        return getLocalFileDataData();
    L6:
        return ZipUtil.copy(r0);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralDirectoryData != null) goto L6;
        return getLocalFileDataLength();
    L6:
        return new ZipShort(this.centralDirectoryData.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] r1 = this.localFileData;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return new ZipShort(r2);
    L5:
        r2 = r1.length;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r2, int r3, int r4) {
        this.centralDirectoryData = Arrays.copyOfRange(r2, r3, r3 + r4);
        if (this.localFileData != null) goto L6;
        parseFromLocalFileData(r2, r3, r4);
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r1, int r2, int r3) {
        this.localFileData = Arrays.copyOfRange(r1, r2, r3 + r2);
    }
}
