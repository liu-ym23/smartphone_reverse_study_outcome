package com.ss.bduploader;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BDExternalFileReaderBridge {
    private static final String TAG = "ttmn";

    public BDExternalFileReaderBridge() {
    }

    void cancel(Object r3) {
        Log.e(TAG, "try to cancel");
        if (r3 != null) goto L7;
        String r4 = "try to cancel end fail";
    L5:
        Log.e(TAG, r4);
        return;
    L7:
        ((BDExternalFileReader) ZeusTransformUtils.preCheckCast(r3, BDExternalFileReader.class, "com.obric.memorydata.plugin")).cancel();
        r4 = "try to cancel end";
        goto L5
    }

    void closeFileWithIndex(Object r3, int r4) {
        Log.e(TAG, "try to closeFile");
        if (r3 != null) goto L6;
        Log.e(TAG, "try to closeFile end fail");
        return;
    L6:
        BDMultiExternalFileReader r5 = (BDMultiExternalFileReader) ZeusTransformUtils.preCheckCast(r3, BDMultiExternalFileReader.class, "com.obric.memorydata.plugin");
        Log.e(TAG, "try to closeFile end");
        r5.closeFileWithIndex(r4);
    }

    long getCrc32ByOffset(Object r4, long r5, int r7) {
        Log.e(TAG, "try to read end");
        if (r4 != null) goto L6;
        Log.e(TAG, "try to read end fail");
        return 0;
    L6:
        long r6 = ((BDExternalFileReader) ZeusTransformUtils.preCheckCast(r4, BDExternalFileReader.class, "com.obric.memorydata.plugin")).getCrc32ByOffset(r5, r7);
        Log.e(TAG, "try to read end");
        return r6;
    }

    long getValue(Object r3, int r4) {
        Log.e(TAG, "try to get value");
        if (r3 != null) goto L6;
        Log.e(TAG, "try to get value fail");
        return -1;
    L6:
        long r5 = ((BDExternalFileReader) ZeusTransformUtils.preCheckCast(r3, BDExternalFileReader.class, "com.obric.memorydata.plugin")).getValue(r4);
        Log.e(TAG, "try to get value end");
        return r5;
    }

    long multiGetValue(Object r3, int r4, int r5) {
        Log.e(TAG, "try to get value");
        if (r3 != null) goto L6;
        Log.e(TAG, "try to get value fail");
        return -1;
    L6:
        long r6 = ((BDMultiExternalFileReader) ZeusTransformUtils.preCheckCast(r3, BDMultiExternalFileReader.class, "com.obric.memorydata.plugin")).multiGetValue(r4, r5);
        Log.e(TAG, "try to get value end");
        return r6;
    }

    int multiReadSliceByOffset(Object r9, long r10, byte[] r12, int r13, int r14, int r15) {
        Log.e(TAG, "try to read end");
        if (r9 == null) goto L10;
        if (r12 == null) goto L10;
        if (r14 == 0) goto L10;
        if (r13 < 0) goto L10;
        int r11 = ((BDMultiExternalFileReader) ZeusTransformUtils.preCheckCast(r9, BDMultiExternalFileReader.class, "com.obric.memorydata.plugin")).readSliceByOffset(r10, r12, r13, r14, r15);
        Log.e(TAG, "try to read end");
        return r11;
    L10:
        Log.e(TAG, "try to read end fail");
        return 0;
    }

    int openFileWithIndex(Object r3, int r4) {
        Log.e(TAG, "try to openFile");
        if (r3 != null) goto L6;
        Log.e(TAG, "try to openFile end fail");
        return -1;
    L6:
        BDMultiExternalFileReader r5 = (BDMultiExternalFileReader) ZeusTransformUtils.preCheckCast(r3, BDMultiExternalFileReader.class, "com.obric.memorydata.plugin");
        Log.e(TAG, "try to openFile end");
        return r5.openFileWithIndex(r4);
    }

    int readSlice(Object r4, int r5, byte[] r6, int r7) {
        Log.e(TAG, "try to read end");
        if (r4 == null) goto L9;
        if (r6 == null) goto L9;
        if (r7 == 0) goto L9;
        int r8 = ((BDExternalFileReader) ZeusTransformUtils.preCheckCast(r4, BDExternalFileReader.class, "com.obric.memorydata.plugin")).readSlice(r5, r6, r7);
        Log.e(TAG, "try to read end");
        return r8;
    L9:
        Log.e(TAG, "try to read end fail");
        return 0;
    }

    int readSliceByOffset(Object r8, long r9, byte[] r11, int r12, int r13) {
        Log.e(TAG, "try to read end");
        if (r8 == null) goto L9;
        if (r11 == null) goto L9;
        if (r12 == 0) goto L9;
        int r10 = ((BDExternalFileReader) ZeusTransformUtils.preCheckCast(r8, BDExternalFileReader.class, "com.obric.memorydata.plugin")).readSliceByOffset(r9, r11, r12, r13);
        Log.e(TAG, "try to read end");
        return r10;
    L9:
        Log.e(TAG, "try to read end fail");
        return 0;
    }
}
