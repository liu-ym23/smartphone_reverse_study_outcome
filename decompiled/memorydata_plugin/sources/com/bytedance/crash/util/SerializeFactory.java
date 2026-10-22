package com.bytedance.crash.util;

import com.bytedance.crash.diagnose.NpthMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class SerializeFactory {
    private static final String BACKUP_SUFFIX = ".bk";

    public SerializeFactory() {
    }

    public static Object load(File r4) {
    L25:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return null;
    L4:
        if (r4.exists() == true) goto L32;
        File r1 = new File(r4.getAbsolutePath() + BACKUP_SUFFIX);     // Catch: Throwable -> L25
        if (r1.exists() == true) goto L8;
        return null;
    L8:
        r1.renameTo(r4);     // Catch: Throwable -> L25
    L32:
        FileInputStream r2 = new FileInputStream(r4);     // Catch: Throwable -> L15 Exception -> L17
        Object r5 = new ObjectInputStream(r2).readObject();     // Catch: Exception -> L13 Throwable -> L22
        FileSystemUtils.close(r2);     // Catch: Throwable -> L25
        return r5;
    L13:
        e = e;
    L19:
        FileUtils.deleteFile(r4);     // Catch: Throwable -> L22
        NpthMonitor.reportInnerException(e);     // Catch: Throwable -> L22
        FileSystemUtils.close(r2);     // Catch: Throwable -> L25
        return null;
    L22:
        th = th;
    L23:
        FileSystemUtils.close(r2);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L17:
        e = e;
        r2 = null;
    L15:
        th = th;
        r2 = null;
        goto L23
    }

    public static void store(File r4, Object r5) {
        File r0 = new File(r4.getAbsolutePath() + BACKUP_SUFFIX);     // Catch: Throwable -> L36
        if (r4.isDirectory() == false) goto L6;
        FileUtils.deleteFile(r4);     // Catch: Throwable -> L36
    L11:
        boolean r1 = false;
        Closeable r2 = null;
        FileOutputStream r3 = null;
        FileOutputStream r6 = new FileOutputStream(r4);     // Catch: Throwable -> L21 Exception -> L23
        ObjectOutputStream r7 = new ObjectOutputStream(r6);     // Catch: Throwable -> L17 Exception -> L19
        r7.writeObject(r5);     // Catch: Throwable -> L17 Exception -> L19
        r1 = true;
        FileSystemUtils.close(r6);     // Catch: Throwable -> L36
        r2 = r7;
    L27:
        if (r0.exists() == false) goto L39;
        if (r1 == false) goto L31;
        FileUtils.deleteFile(r0);     // Catch: Throwable -> L36
        goto L39
    L31:
        if (r4.exists() == false) goto L33;
        FileUtils.deleteFile(r4);     // Catch: Throwable -> L36
    L33:
        r0.renameTo(r4);     // Catch: Throwable -> L36
    L39:
        return;
    L19:
        e = e;
        r3 = r6;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        NpthMonitor.reportInnerException(e);     // Catch: Throwable -> L21
        FileSystemUtils.close(r3);     // Catch: Throwable -> L36
        r2 = r3;
    L17:
        th = th;
        r2 = r6;
    L34:
        FileSystemUtils.close(r2);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L21:
        th = th;
    L23:
        e = e;
        goto L24
    L6:
        if (r4.exists() == false) goto L11;
        if (r0.exists() == false) goto L10;
        r0.delete();     // Catch: Throwable -> L36
    L10:
        r4.renameTo(r0);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }
}
