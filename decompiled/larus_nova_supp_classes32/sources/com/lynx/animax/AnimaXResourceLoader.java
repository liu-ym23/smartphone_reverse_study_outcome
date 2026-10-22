package com.lynx.animax;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXResourceLoader {
    public AnimaXResourceLoader() {
    }

    public static String getCacheDirectory() {
        Context r0 = AnimaX.e().c;
        if (r0 != null) goto L5;
        return null;
    L5:
        File r1 = r0.getCacheDir();
        if (r1 != null) goto L8;
        return null;
    L8:
        String r2 = r1.getAbsolutePath();
        if (r2 != null) goto L11;
        return null;
    L11:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2, "animax");
        if (r3.exists() == true) goto L17;
        if (r3.mkdirs() == true) goto L17;
        AnimaXLog.a("AnimaXResourceLoader", "Failed to make animax cache directory: " + r3.getAbsolutePath());
    L17:
        if (r3.exists() == false) goto L22;
        if (r3.isFile() == false) goto L22;
        AnimaXLog.a("AnimaXResourceLoader", "Failed to make animax cache directory, path is a file: " + r3.getAbsolutePath());
    L22:
        return r3.getAbsolutePath();
    }

    public static byte[] readFile(String r2) {
        if (r2 != null) goto L5;
    L11:
        PolarisFileInputStreamWrapper r0 = null;
    L17:
        int r3 = r0.available();     // Catch: IOException -> L14
    L16:
        return y4a.b.c(r0, r3);
    L14:
        r3 = 0;
        goto L16
    L5:
        if (new PolarisFileWrapper(r2).exists() == false) goto L11;
        r0 = new PolarisFileInputStreamWrapper(r2);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "createFileInputStream error: " + e);
        goto L11
    }

    public static boolean saveByteArrayIntoFile(String r3, byte[] r4) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r4);
        int r5 = r0.available();     // Catch: IOException -> L5
    L13:
        BufferedOutputStream r2 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r3));     // Catch: IOException -> L8
    L10:
        return y4a.b.b(r0, r2, r5);
    L8:
        AnimaXLog.a("AnimaXStreamUtil", "Failed to create FileOutputStream for file: " + r3);
        r2 = null;
    L5:
        r5 = 0;
        goto L13
    }
}
