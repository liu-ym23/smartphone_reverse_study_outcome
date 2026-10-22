package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromCentralDirectoryData(byte[] r1, int r2, int r3);

    void parseFromLocalFileData(byte[] r1, int r2, int r3);
}
