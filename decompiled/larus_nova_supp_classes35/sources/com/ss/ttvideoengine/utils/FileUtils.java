package com.ss.ttvideoengine.utils;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static void checkAndMkdir(File r1) {
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
        return;
    }

    public static String readString(File r3) {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = new BufferedReader(new PolarisFileReaderWrapper(r3));     // Catch: IOException -> L18
    L25:
        String r4 = r1.readLine();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r0.append(r4);     // Catch: Throwable -> L10
    L8:
        r1.close();     // Catch: IOException -> L18
    L21:
        return r0.toString();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }
}
