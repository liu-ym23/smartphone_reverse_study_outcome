package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipFile;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FileSystemUtils {
    public FileSystemUtils() {
    }

    public static void close(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void close(ZipFile r0) {
        if (r0 != null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static File createDirectory(File r1) {
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r1;
    L3:
        if (r1.exists() == true) goto L6;
    L4:
        r1.mkdirs();     // Catch: Exception -> L9
        goto L11
    L6:
        if (r1.isDirectory() == true) goto L11;
        r1.delete();     // Catch: Exception -> L9
        goto L4
    }

    public static File createDirectory(File r1, String r2) {
        File r0 = new File(r1, r2);
        createDirectory(r0);
        return r0;
    }

    public static File createFile(File r1, String r2) {
        File r0 = new File(r1, r2);
        if (r0.isDirectory() == false) goto L12;
        deleteAll(r0);
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r0;
    L6:
        if (r0.exists() == true) goto L11;
        r0.createNewFile();     // Catch: Exception -> L9
        goto L11
    }

    public static void createNewFile(File r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.exists() == true) goto L11;
        r1.createNewFile();     // Catch: IOException -> L8
        return;
    L12:
        return;
    }

    public static void deleteAll(File r4) {
        if (r4.exists() == true) goto L5;
        return;
    L5:
        if (r4.isDirectory() == false) goto L14;
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L14;
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L14;
        deleteAll(r0[r2]);
        r2 = r2 + 1;
    L14:
        FileUtils.deleteFile(r4);     // Catch: Throwable -> L13
        return;
    }

    public static String readUtf8File(File r5) {
        if (r5.exists() == true) goto L5;
    L15:
        return null;
    L5:
        if (r5.isDirectory() == true) goto L15;
        int r0 = (int) r5.length();
        byte[] r2 = new byte[r0];
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L12
        String r4 = new String(r2, 0, r3.read(r2, 0, r0));     // Catch: Throwable -> L17
        r3.close();     // Catch: IOException -> L16
    L11:
        return r4;
    L13:
        if (r3 == null) goto L15;
        r3.close();     // Catch: IOException -> L18
    L12:
        r3 = null;
        goto L13
    }

    public static void setPermissions(String r9, int r10) {
        ReflexHelper.getMethod("android.os.FileUtils", "setPermissions", new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).invoke(null, new Object[]{r9, Integer.valueOf(r10), -1, -1});     // Catch: Throwable -> L4
        return;
    }

    public static void writeFile(File r1, String r2) {
        FileUtils.writeFile(r1, r2, false);     // Catch: Exception -> L5
        return;
    }

    public static void writeFile(File r0, String r1, String r2) {
        FileUtils.writeFile(createFile(r0, r1), r2, false);     // Catch: Exception -> L5
        return;
    }

    public static void writeFile(File r0, String r1, JSONObject r2) {
        FileUtils.writeFile(createFile(r0, r1), r2, false);     // Catch: Exception -> L5
        return;
    }
}
