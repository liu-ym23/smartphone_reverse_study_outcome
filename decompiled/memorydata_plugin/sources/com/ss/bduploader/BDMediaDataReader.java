package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDMediaDataReader {
    public static final int KeyIsGetFileCrc32 = 1;
    public static final int KeyIsGetFileSize = 0;
    public static final int ReadFileEnd = 0;
    public static final int ReadFileError = -1;

    int close(int r1);

    long getValue(int r1, int r2);

    int open(int r1);

    int read(int r1, long r2, byte[] r4, int r5);
}
