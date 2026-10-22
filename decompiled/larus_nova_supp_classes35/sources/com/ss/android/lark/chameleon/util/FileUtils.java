package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public FileUtils() {
    }

    public static void cleanDirectory(File r4) throws IOException {
        File[] r5 = verifiedListFiles(r4);
        int r0 = r5.length;
        IOException e = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        forceDelete(r5[r2]);     // Catch: IOException -> L7
    L8:
        r2 = r2 + 1;
    L7:
        e = e;
        goto L8
    L9:
        if (e != null) goto L11;
        return;
    L11:
        throw e;
    }

    public static void closeSilently(Closeable... r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length <= 0) goto L23;
        int r0 = r4.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L24;
        Closeable r2 = r4[r1];
        if (r2 == null) goto L15;
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Log.e(TAG, th.toString());
    L15:
        r1 = r1 + 1;
        goto L7
    L24:
        return;
    }

    public static void deleteDirectory(File r2) throws IOException {
        if (r2.exists() == true) goto L5;
        return;
    L5:
        cleanDirectory(r2);
        if (r2.delete() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to delete directory " + r2 + ".");
    }

    public static void deleteFile(File r1) throws IOException {
        if (r1.exists() == true) goto L6;
        return;
    L6:
        if (r1.isDirectory() == false) goto L9;
        deleteDirectory(r1);
        return;
    L9:
        if (r1.isFile() == false) goto L13;
        forceDelete(r1);
        return;
    }

    public static void forceDelete(File r3) throws IOException {
        if (r3.exists() == true) goto L6;
        return;
    L6:
        if (r3.isDirectory() == false) goto L8;
        deleteDirectory(r3);
        return;
    L8:
        boolean r0 = r3.exists();
        if (r3.delete() == true) goto L16;
        if (r0 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r3);
    L14:
        throw new IOException("Unable to delete file: " + r3);
    }

    private static File[] verifiedListFiles(File r3) throws IOException {
        if (r3.exists() == false) goto L14;
        if (r3.isDirectory() == false) goto L12;
        File[] r0 = r3.listFiles();
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw new IOException("Failed to list contents of " + r3);
    L12:
        throw new IllegalArgumentException(r3 + " is not a directory");
    L14:
        throw new IllegalArgumentException(r3 + " does not exist");
    }

    public static void safeDeleteFile(Context r1, File r2) throws IOException {
        String r3 = AppInfoUtils.getPackageName(r1);
        if (r2.getPath().contains(r3) == false) goto L5;
        deleteFile(r2);
        return;
    L5:
        Log.w(TAG, "safeDeleteFile, not allow to delete user files");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean copyAssets(Context r12, String r13, String r14) {
        InputStream r4 = null;
        String[] r5 = r12.getAssets().list(r13);     // Catch: Throwable -> L30 Exception -> L32
        if (r5 != null) goto L6;
    L11:
        InputStream r15 = r12.getAssets().open(r13);     // Catch: Throwable -> L30 Exception -> L32
        PolarisFileOutputStreamWrapper r16 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r14));     // Catch: Throwable -> L26 Exception -> L28
    L44:
        byte[] r17 = new byte[ChameleonContainerUtils.MAX_URL_LENGTH];     // Catch: Throwable -> L22 Exception -> L24
    L15:
        int r0 = r15.read(r17);     // Catch: Throwable -> L22 Exception -> L24
        if (r0 == (-1)) goto L18;
        r16.write(r17, 0, r0);     // Catch: Throwable -> L22 Exception -> L24
        goto L15
    L18:
        r16.flush();     // Catch: Throwable -> L22 Exception -> L24
        r15.close();     // Catch: Throwable -> L22 Exception -> L24
        r16.close();     // Catch: Throwable -> L22 Exception -> L24
        r4 = r15;
    L20:
        closeSilently(new Closeable[]{r4, r16});
        return true;
    L24:
        e = move-exception;
        r4 = r15;
        e = e;
    L40:
        Log.e(TAG, e.toString());     // Catch: Throwable -> L37
        closeSilently(new Closeable[]{r4, r16});
        return false;
    L37:
        th = th;
    L38:
        closeSilently(new Closeable[]{r4, r16});
        throw th;
    L22:
        th = move-exception;
        r4 = r15;
        th = th;
    L28:
        e = move-exception;
        r4 = r15;
        e = e;
        r16 = null;
    L26:
        th = move-exception;
        r4 = r15;
        th = th;
        r16 = null;
        goto L38
    L6:
        if (r5.length <= 0) goto L11;
        new PolarisFileWrapper(r14).mkdirs();     // Catch: Throwable -> L30 Exception -> L32
        int r6 = r5.length;     // Catch: Throwable -> L30 Exception -> L32
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        String r8 = r5[r7];     // Catch: Throwable -> L30 Exception -> L32
        copyAssets(r12, r13 + "/" + r8, r14 + "/" + r8);     // Catch: Throwable -> L30 Exception -> L32
        r7 = r7 + 1;     // Catch: Throwable -> L30 Exception -> L32
        goto L8
    L10:
        r16 = null;
    L32:
        e = e;
        r16 = null;
    L30:
        th = th;
        r16 = null;
        goto L38
    }
}
