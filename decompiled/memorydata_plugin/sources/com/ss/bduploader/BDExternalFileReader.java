package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDExternalFileReader {
    public static final int KeyIsGetAvailableFileSize = 4;
    public static final int KeyIsGetFileSize = 0;
    public static final int KeyIsGetHeaderSize = 2;
    public static final int KeyIsGetOffset = 1;
    public static final int ReadSliceEnd = 0;
    public static final int ReadSliceError = -1;
    public static final int ReadSliceErrorIsCancel = -2;

    void cancel();

    long getCrc32ByOffset(long r1, int r3);

    long getValue(int r1);

    int readSlice(int r1, byte[] r2, int r3);

    int readSliceByOffset(long r1, byte[] r3, int r4, int r5);
}
