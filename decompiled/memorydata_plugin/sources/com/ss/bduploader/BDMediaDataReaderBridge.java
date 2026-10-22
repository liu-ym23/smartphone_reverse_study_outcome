package com.ss.bduploader;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BDMediaDataReaderBridge {
    public BDMediaDataReaderBridge() {
    }

    int close(Object r2, int r3) {
        if (r2 == null) goto L7;
        if (r3 < 0) goto L7;
        return ((BDMediaDataReader) ZeusTransformUtils.preCheckCast(r2, BDMediaDataReader.class, "com.obric.memorydata.plugin")).close(r3);
    L7:
        Log.e("ttmn", "try to close fail");
        return 0;
    }

    long getValue(Object r2, int r3, int r4) {
        if (r2 != null) goto L6;
        Log.e("ttmn", "try to get value fail");
        return -1;
    L6:
        return ((BDMediaDataReader) ZeusTransformUtils.preCheckCast(r2, BDMediaDataReader.class, "com.obric.memorydata.plugin")).getValue(r3, r4);
    }

    int open(Object r2, int r3) {
        if (r2 != null) goto L6;
        Log.e("ttmn", "try to open failed");
        return 0;
    L6:
        return ((BDMediaDataReader) ZeusTransformUtils.preCheckCast(r2, BDMediaDataReader.class, "com.obric.memorydata.plugin")).open(r3);
    }

    int read(Object r7, int r8, long r9, byte[] r11, int r12) {
        if (r7 == null) goto L8;
        if (r11 == null) goto L8;
        if (r12 == 0) goto L8;
        return ((BDMediaDataReader) ZeusTransformUtils.preCheckCast(r7, BDMediaDataReader.class, "com.obric.memorydata.plugin")).read(r8, r9, r11, r12);
    L8:
        Log.e("ttmn", "try to read end fail");
        return 0;
    }
}
