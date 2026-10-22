package com.bytedance.crash.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class SafelyLibraryLoader {
    public SafelyLibraryLoader() {
    }

    @Nullable
    public static String unpackLibrary(@NonNull Context r10, String r11, File r12) {
        ApplicationInfo r13 = r10.getApplicationInfo();
        String r14 = unpackLibrary(r13.sourceDir, r11, r12);
        if (r14 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        return r14;
    L8:
        String[] r15 = r13.splitSourceDirs;
        if (r15 == null) goto L16;
        int r16 = r15.length;
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L16;
        r14 = unpackLibrary(r15[r17], r11, r12);
        if (r14 == null) goto L14;
        r17 = r17 + 1;
        goto L11
    L14:
        return null;
    L16:
        return r14;
    }

    @Nullable
    private static String unpackLibrary(String r10, String r11, File r12) {
        FileOutputStream r13 = null;
        ZipFile r14 = new ZipFile(new File(r10), 1);     // Catch: Throwable -> L33
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L31
        r15.append("lib/");     // Catch: Throwable -> L31
        String r16 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r15.append(r16);     // Catch: Throwable -> L31
        r15.append("/");     // Catch: Throwable -> L31
        r15.append(System.mapLibraryName(r11));     // Catch: Throwable -> L31
        ZipEntry r17 = r14.getEntry(r15.toString());     // Catch: Throwable -> L31
        if (r17 != null) goto L17;
        int r18 = r16.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L31
        r19.append("lib/");     // Catch: Throwable -> L31
        if (r18 > 0) goto L10;
        r18 = r16.length();     // Catch: Throwable -> L31
    L10:
        r19.append(r16.substring(0, r18));     // Catch: Throwable -> L31
        r19.append("/");     // Catch: Throwable -> L31
        r19.append(System.mapLibraryName(r11));     // Catch: Throwable -> L31
        String r20 = r19.toString();     // Catch: Throwable -> L31
        ZipEntry r21 = r14.getEntry(r20);     // Catch: Throwable -> L31
        if (r21 != null) goto L16;
        String r22 = "Library entry not found:" + r20;     // Catch: Throwable -> L31
        FileSystemUtils.close(null);
        FileSystemUtils.close(null);
    L14:
        FileSystemUtils.close(r14);
        return r22;
    L16:
        r17 = r21;
    L17:
        r12.createNewFile();     // Catch: Throwable -> L31
        InputStream r23 = r14.getInputStream(r17);     // Catch: Throwable -> L31
        FileOutputStream r24 = new FileOutputStream(r12);     // Catch: Throwable -> L29
        byte[] r25 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r26 = r23.read(r25);     // Catch: Throwable -> L27
        if (r26 <= 0) goto L24;
        r24.write(r25, 0, r26);     // Catch: Throwable -> L27
        goto L21
    L24:
        FileSystemUtils.setPermissions(r12.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        FileSystemUtils.close(r24);
        FileSystemUtils.close(r23);
        FileSystemUtils.close(r14);
        return null;
    L27:
        th = move-exception;
        r13 = r24;
        InputStream r27 = r23;
        th = th;
    L43:
        r22 = th.getMessage();     // Catch: Throwable -> L37
        FileSystemUtils.close(r13);
        FileSystemUtils.close(r27);
    L37:
        th = move-exception;
        FileSystemUtils.close(r13);
        FileSystemUtils.close(r27);
        FileSystemUtils.close(r14);
        throw th;
    L29:
        th = move-exception;
        r27 = r23;
        th = th;
    L31:
        th = th;
        r27 = null;
    L33:
        th = th;
        r27 = null;
        r14 = null;
        goto L43
    }
}
