package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class UnrecognizedExtraField implements ZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    public UnrecognizedExtraField() {
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r0 = this.centralData;
        if (r0 == null) goto L7;
        return ZipUtil.copy(r0);
    L7:
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralData == null) goto L7;
        return new ZipShort(this.centralData.length);
    L7:
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] r1 = this.localData;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L7:
        return new ZipShort(r2);
    L5:
        r2 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        byte[] r4 = Arrays.copyOfRange(r1, r2, r3 + r2);
        setCentralDirectoryData(r4);
        if (this.localData != null) goto L6;
        setLocalFileDataData(r4);
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r1, int r2, int r3) {
        setLocalFileDataData(Arrays.copyOfRange(r1, r2, r3 + r2));
    }

    public void setCentralDirectoryData(byte[] r1) {
        this.centralData = ZipUtil.copy(r1);
    }

    public void setHeaderId(ZipShort r1) {
        this.headerId = r1;
    }

    public void setLocalFileDataData(byte[] r1) {
        this.localData = ZipUtil.copy(r1);
    }
}
