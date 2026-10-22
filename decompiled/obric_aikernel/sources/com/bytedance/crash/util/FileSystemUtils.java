package com.bytedance.crash.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipFile;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FileSystemUtils {
    public FileSystemUtils() {
    }

    public static void close(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void close(ZipFile r10) {
        if (r10 != null) goto L8;
        r10.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @NonNull
    public static File createDirectory(@NonNull File r10) {
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r10;
    L3:
        if (r10.exists() == true) goto L6;
    L4:
        r10.mkdirs();     // Catch: Exception -> L9
        goto L11
    L6:
        if (r10.isDirectory() == true) goto L11;
        r10.delete();     // Catch: Exception -> L9
        goto L4
    }

    @NonNull
    public static File createDirectory(@NonNull File r10, @NonNull String r11) {
        File r12 = new File(r10, r11);
        createDirectory(r12);
        return r12;
    }

    @NonNull
    public static File createFile(@NonNull File r10, @NonNull String r11) {
        File r12 = new File(r10, r11);
        if (r12.isDirectory() == false) goto L12;
        deleteAll(r12);
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r12;
    L6:
        if (r12.exists() == true) goto L11;
        r12.createNewFile();     // Catch: Exception -> L9
        goto L11
    }

    public static void createNewFile(File r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.exists() == true) goto L11;
        r10.createNewFile();     // Catch: IOException -> L8
        return;
    L12:
        return;
    }

    public static void deleteAll(@NonNull File r10) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        if (r10.isDirectory() == false) goto L14;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L14;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L14;
        deleteAll(r11[r13]);
        r13 = r13 + 1;
    L14:
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L13
        return;
    }

    @Nullable
    public static String readUtf8File(@NonNull File r10) {
        if (r10.exists() == true) goto L5;
    L15:
        return null;
    L5:
        if (r10.isDirectory() == true) goto L15;
        int r11 = (int) r10.length();
        byte[] r12 = new byte[r11];
        FileInputStream r13 = new FileInputStream(r10);     // Catch: Throwable -> L12
        String r14 = new String(r12, 0, r13.read(r12, 0, r11));     // Catch: Throwable -> L17
        r13.close();     // Catch: IOException -> L16
    L11:
        return r14;
    L13:
        if (r13 == null) goto L15;
        r13.close();     // Catch: IOException -> L18
    L12:
        r13 = null;
        goto L13
    }

    public static void setPermissions(String r10, int r11) {
        Class r12 = Integer.TYPE;     // Catch: Throwable -> L4
        ReflexHelper.getMethod("android.os.FileUtils", "setPermissions", new Class[]{String.class, r12, r12, r12}).invoke(null, new Object[]{r10, Integer.valueOf(r11), -1, -1});     // Catch: Throwable -> L4
        return;
    }

    public static void writeFile(@NonNull File r10, String r11) {
        FileUtils.writeFile(r10, r11, false);     // Catch: Exception -> L5
        return;
    }

    public static void writeFile(@NonNull File r10, String r11, String r12) {
        FileUtils.writeFile(createFile(r10, r11), r12, false);     // Catch: Exception -> L5
        return;
    }

    public static void writeFile(@NonNull File r10, String r11, JSONObject r12) {
        FileUtils.writeFile(createFile(r10, r11), r12, false);     // Catch: Exception -> L5
        return;
    }
}
