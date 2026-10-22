package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class FileLocker implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f8476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileLock f8477b;

    public FileLocker(File r5, boolean r10) {
        FileOutputStream r11 = new FileOutputStream(r5);
        this.f8476a = r11;
        if (r10 == true) goto L16;
        FileLock r12 = r11.getChannel().lock();     // Catch: Throwable -> L6
    L18:
    L10:
        if (r12 != null) goto L12;
        this.f8476a.close();
    L12:
        this.f8477b = r12;
        return;
    L16:
        r12 = r11.getChannel().tryLock();     // Catch: Throwable -> L6 IOException -> L8
    L8:
        r12 = null;
    L6:
        th = move-exception;
        this.f8476a.close();
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileLock r5 = this.f8477b;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.release();     // Catch: Throwable -> L6
    L8:
        this.f8476a.close();
        return;
    L6:
        th = move-exception;
        this.f8476a.close();
        throw th;
    }
}
