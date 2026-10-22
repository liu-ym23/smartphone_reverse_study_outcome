package org.apache.poi.poifs.common;

/* JADX INFO: loaded from: classes7.dex */
public interface POIFSConstants {
    public static final POIFSBigBlockSize LARGER_BIG_BLOCK_SIZE_DETAILS = null;
    public static final POIFSBigBlockSize SMALLER_BIG_BLOCK_SIZE_DETAILS = null;

    static {
        SMALLER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(512, 9);
        LARGER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(4096, 12);
    }
}
