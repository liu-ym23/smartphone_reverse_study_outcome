package com.byted.cast.render.utils;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Dump {
    private File dumpFile;
    private boolean isReady;

    public Dump() {
        this.isReady = false;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void writeData(byte[] r10) {
        if (this.isReady == true) goto L12;
        return;
    L12:
        BufferedOutputStream r1 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.dumpFile, true));     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r1.write(r10);     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r1.flush();     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r1.close();     // Catch: OutOfMemoryError -> L7 IOException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean setFilePath(String r10, String r11) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == false) goto L5;
    L8:
        this.dumpFile = new PolarisFileWrapper(r10 + File.separator + r11);
        this.isReady = true;
        return true;
    L5:
        if (r0.mkdir() == true) goto L8;
        return false;
    }
}
