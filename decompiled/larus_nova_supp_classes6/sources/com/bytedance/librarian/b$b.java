package com.bytedance.librarian;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class b$b {
    public RandomAccessFile a;
    public FileLock b;
    public FileChannel c;
    public final File d;
    public final /* synthetic */ b e;

    public final void a() {
        FileLock r0 = this.b;
        if (r0 != null) goto L8;
    L5:
        this.e.b.a("released lock " + this.d.getPath());
        this.e.b(this.c);
        this.e.b(this.a);
        return;
    L8:
        r0.release();     // Catch: IOException -> L7
        goto L5
    }

    public final void b() throws IOException {
        RandomAccessFile r2 = new RandomAccessFile(this.d, "rw");
        this.a = r2;
        this.c = r2.getChannel();     // Catch: IOException -> L10
        this.e.b.a("blocking on lock " + this.d.getPath());     // Catch: IOException -> L7
        this.b = this.c.lock();     // Catch: IOException -> L7
        this.e.b.a("acquired on lock " + this.d.getPath());     // Catch: IOException -> L10
        return;
    L7:
        e = move-exception;
        this.e.b(this.c);     // Catch: IOException -> L10
        throw e;     // Catch: IOException -> L10
    L10:
        e = move-exception;
        this.e.b(this.a);
        throw e;
    }

    public b$b(b r1, PolarisFileWrapper r2) {
        this.e = r1;
        this.d = r2;
    }
}
