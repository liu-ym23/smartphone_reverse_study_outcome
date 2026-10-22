package org.apache.poi.poifs.common;

/* JADX INFO: loaded from: classes7.dex */
public final class POIFSBigBlockSize {
    private int bigBlockSize;
    private short headerValue;

    public POIFSBigBlockSize(int r1, short r2) {
        this.bigBlockSize = r1;
        this.headerValue = r2;
    }

    public int getBATEntriesPerBlock() {
        return this.bigBlockSize / 4;
    }

    public int getBigBlockSize() {
        return this.bigBlockSize;
    }

    public short getHeaderValue() {
        return this.headerValue;
    }

    public int getXBATEntriesPerBlock() {
        return getBATEntriesPerBlock() - 1;
    }
}
