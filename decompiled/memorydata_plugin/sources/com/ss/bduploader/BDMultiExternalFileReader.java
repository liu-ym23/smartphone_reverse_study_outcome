package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDMultiExternalFileReader {
    void closeFileWithIndex(int r1);

    long multiGetValue(int r1, int r2);

    int openFileWithIndex(int r1);

    int readSliceByOffset(long r1, byte[] r3, int r4, int r5, int r6);
}
