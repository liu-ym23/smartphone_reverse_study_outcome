package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes7.dex */
public final class FileHelper {
    public static void copyFile(File r8, File r9) {
        FileInputStream r0 = new FileInputStream(r8);
        FileOutputStream r10 = new FileOutputStream(r9);     // Catch: Throwable -> L41
        FileChannel r11 = r0.getChannel();     // Catch: Throwable -> L33
        FileChannel r7 = r10.getChannel();     // Catch: Throwable -> L24
        r11.transferTo(0, r11.size(), r7);     // Catch: Throwable -> L15
        if (r7 == null) goto L10;
        r7.close();     // Catch: Throwable -> L24
    L10:
        if (r11 == null) goto L12;
        r11.close();     // Catch: Throwable -> L33
    L12:
        r10.close();     // Catch: Throwable -> L41
        r0.close();
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r7 != null) goto L56;
    L23:
        throw th;     // Catch: Throwable -> L24
    L56:
        r7.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        if (r11 != null) goto L53;
    L32:
        throw th;     // Catch: Throwable -> L33
    L53:
        r11.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L38
    L40:
        throw th;     // Catch: Throwable -> L41
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L46
    L48:
        throw th;
    L46:
        th = move-exception;
        th.addSuppressed(th);
        goto L48
    }

    public static File getDirectory(File r3) {
        if (r3 == null) goto L10;
        String r4 = r3.getPath();
        int r0 = r4.length();
    L4:
        r0 = r0 - 1;
        if (r0 < 0) goto L15;
        if (r4.charAt(r0) != File.separatorChar) goto L4;
        return new File(r4.substring(0, r0));
    L15:
        return null;
    L10:
        return null;
    }

    public static String getFilename(File r4) {
        if (r4 == null) goto L10;
        String r5 = r4.getPath();
        int r0 = r5.length();
        int r1 = r0;
    L4:
        r1 = r1 - 1;
        if (r1 < 0) goto L15;
        if (r5.charAt(r1) != File.separatorChar) goto L4;
        return r5.substring(r1 + 1, r0);
    L15:
        return "";
    L10:
        return "";
    }
}
