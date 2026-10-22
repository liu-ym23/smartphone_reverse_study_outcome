package com.bytedance.crash.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class SafelyLibraryLoader {
    public SafelyLibraryLoader() {
    }

    public static String unpackLibrary(Context r4, String r5, File r6) {
        ApplicationInfo r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo();
        String r0 = unpackLibrary(r7.sourceDir, r5, r6);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        return r0;
    L8:
        String[] r8 = r7.splitSourceDirs;
        if (r8 == null) goto L16;
        int r2 = r8.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L16;
        r0 = unpackLibrary(r8[r3], r5, r6);
        if (r0 == null) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return null;
    L16:
        return r0;
    }

    private static String unpackLibrary(String r7, String r8, File r9) {
        FileOutputStream r2 = null;
        ZipFile r3 = new ZipFile(new File(r7), 1);     // Catch: Throwable -> L33
        ZipEntry r10 = r3.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(r8));     // Catch: Throwable -> L31
        if (r10 != null) goto L17;
        int r11 = Build.CPU_ABI.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r1 = new StringBuilder().append("lib/");     // Catch: Throwable -> L31
        String r5 = Build.CPU_ABI;     // Catch: Throwable -> L31
        if (r11 > 0) goto L10;
        r11 = Build.CPU_ABI.length();     // Catch: Throwable -> L31
    L10:
        String r12 = r1.append(r5.substring(0, r11)).append("/").append(System.mapLibraryName(r8)).toString();     // Catch: Throwable -> L31
        ZipEntry r13 = r3.getEntry(r12);     // Catch: Throwable -> L31
        if (r13 != null) goto L16;
        String r14 = "Library entry not found:" + r12;     // Catch: Throwable -> L31
        FileSystemUtils.close(null);
        FileSystemUtils.close(null);
    L14:
        FileSystemUtils.close(r3);
        return r14;
    L16:
        r10 = r13;
    L17:
        r9.createNewFile();     // Catch: Throwable -> L31
        InputStream r15 = r3.getInputStream(r10);     // Catch: Throwable -> L31
        FileOutputStream r16 = new FileOutputStream(r9);     // Catch: Throwable -> L29
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r4 = r15.read(r0);     // Catch: Throwable -> L27
        if (r4 <= 0) goto L24;
        r16.write(r0, 0, r4);     // Catch: Throwable -> L27
        goto L21
    L24:
        FileSystemUtils.setPermissions(r9.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        FileSystemUtils.close(r16);
        FileSystemUtils.close(r15);
        FileSystemUtils.close(r3);
        return null;
    L27:
        th = move-exception;
        r2 = r16;
        InputStream r17 = r15;
        th = th;
    L43:
        r14 = th.getMessage();     // Catch: Throwable -> L37
        FileSystemUtils.close(r2);
        FileSystemUtils.close(r17);
    L37:
        th = move-exception;
        FileSystemUtils.close(r2);
        FileSystemUtils.close(r17);
        FileSystemUtils.close(r3);
        throw th;
    L29:
        th = move-exception;
        r17 = r15;
        th = th;
    L31:
        th = th;
        r17 = null;
    L33:
        th = th;
        r17 = null;
        r3 = null;
        goto L43
    }
}
