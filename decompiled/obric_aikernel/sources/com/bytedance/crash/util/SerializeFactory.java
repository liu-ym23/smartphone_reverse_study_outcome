package com.bytedance.crash.util;

import androidx.annotation.Nullable;
import com.bytedance.crash.diagnose.NpthMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class SerializeFactory {
    private static final String BACKUP_SUFFIX = ".bk";

    public SerializeFactory() {
    }

    @Nullable
    public static Object load(File r10) {
    L25:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return null;
    L4:
        if (r10.exists() == true) goto L32;
        File r11 = new File(r10.getAbsolutePath() + BACKUP_SUFFIX);     // Catch: Throwable -> L25
        if (r11.exists() == true) goto L8;
        return null;
    L8:
        r11.renameTo(r10);     // Catch: Throwable -> L25
    L32:
        FileInputStream r12 = new FileInputStream(r10);     // Catch: Throwable -> L15 Exception -> L17
        Object r13 = new ObjectInputStream(r12).readObject();     // Catch: Exception -> L13 Throwable -> L22
        FileSystemUtils.close(r12);     // Catch: Throwable -> L25
        return r13;
    L13:
        e = e;
    L19:
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L22
        NpthMonitor.reportInnerException(e);     // Catch: Throwable -> L22
        FileSystemUtils.close(r12);     // Catch: Throwable -> L25
        return null;
    L22:
        th = th;
    L23:
        FileSystemUtils.close(r12);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L17:
        e = e;
        r12 = null;
    L15:
        th = th;
        r12 = null;
        goto L23
    }

    public static void store(File r10, Object r11) {
        File r12 = new File(r10.getAbsolutePath() + BACKUP_SUFFIX);     // Catch: Throwable -> L36
        if (r10.isDirectory() == false) goto L6;
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L36
    L11:
        boolean r13 = false;
        Closeable r14 = null;
        FileOutputStream r15 = null;
        FileOutputStream r16 = new FileOutputStream(r10);     // Catch: Throwable -> L21 Exception -> L23
        ObjectOutputStream r17 = new ObjectOutputStream(r16);     // Catch: Throwable -> L17 Exception -> L19
        r17.writeObject(r11);     // Catch: Throwable -> L17 Exception -> L19
        r13 = true;
        FileSystemUtils.close(r16);     // Catch: Throwable -> L36
        r14 = r17;
    L27:
        if (r12.exists() == false) goto L39;
        if (r13 == false) goto L31;
        FileUtils.deleteFile(r12);     // Catch: Throwable -> L36
        goto L39
    L31:
        if (r10.exists() == false) goto L33;
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L36
    L33:
        r12.renameTo(r10);     // Catch: Throwable -> L36
    L39:
        return;
    L19:
        e = e;
        r15 = r16;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        NpthMonitor.reportInnerException(e);     // Catch: Throwable -> L21
        FileSystemUtils.close(r15);     // Catch: Throwable -> L36
        r14 = r15;
    L17:
        th = th;
        r14 = r16;
    L34:
        FileSystemUtils.close(r14);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L21:
        th = th;
    L23:
        e = e;
        goto L24
    L6:
        if (r10.exists() == false) goto L11;
        if (r12.exists() == false) goto L10;
        r12.delete();     // Catch: Throwable -> L36
    L10:
        r10.renameTo(r12);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }
}
