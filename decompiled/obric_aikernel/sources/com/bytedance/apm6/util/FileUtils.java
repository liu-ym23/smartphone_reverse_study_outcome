package com.bytedance.apm6.util;

import android.os.Build;
import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static void deleteFile(File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == false) goto L12;
        r10.delete();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static boolean deleteFileWithResult(File r10) {
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.exists() == false) goto L9;
        return r10.delete();
    }

    public static long getAvailableStorage(String r10) {
        StatFs r11 = new StatFs(r10);
        if (Build.VERSION.SDK_INT < 18) goto L6;
        return r11.getAvailableBytes();
    L6:
        return r11.getAvailableBlocks() * r11.getBlockSize();
    }

    public static long getTotalStorageSize(String r10) {
        StatFs r11 = new StatFs(r10);
        if (Build.VERSION.SDK_INT < 18) goto L6;
        return r11.getTotalBytes();
    L6:
        return r11.getBlockCount() * r11.getBlockSize();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x003c */
    public static byte[] readFileToByteArray(File r10) {
        Closeable r11 = null;
        if (r10 != null) goto L5;
    L31:
        return null;
    L5:
        if (r10.exists() == false) goto L31;
        int r12 = (int) r10.length();
        byte[] r13 = new byte[r12];
        BufferedInputStream r14 = new BufferedInputStream(new FileInputStream(r10));     // Catch: Throwable -> L17 IOException -> L19 FileNotFoundException -> L22
    L33:
        r14.read(r13, 0, r12);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L27
        r14.close();     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L27
        IOUtils.closeQuietly(r14);
        return r13;
    L15:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L27
    L25:
        IOUtils.closeQuietly(r14);
        return null;
    L13:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = th;
        r11 = r3;
    L29:
        IOUtils.closeQuietly(r11);
        throw th;
    L22:
        e = e;
        r14 = null;
    L19:
        e = e;
        r14 = null;
    L17:
        th = th;
        goto L29
    }
}
