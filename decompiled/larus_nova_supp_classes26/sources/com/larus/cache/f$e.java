package com.larus.cache;

import com.larus.utils.g;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f$e implements Closeable {
    public final InputStream[] a;
    public final File[] b;

    public final String a() throws IOException {
        InputStream r0 = this.a[0];
        Pattern r2 = f.o;
        InputStreamReader r3 = new InputStreamReader(r0, StandardCharsets.UTF_8);
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L19
        char[] r4 = new char[1024];     // Catch: Throwable -> L13
    L6:
        int r5 = r3.read(r4);     // Catch: Throwable -> L13
        if (r5 == (-1)) goto L9;
        r1.write(r4, 0, r5);     // Catch: Throwable -> L13
        goto L6
    L9:
        String r6 = r1.toString();     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L19
        r3.close();
        return r6;
    L13:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r3.close();
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        g.a(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public f$e(InputStream[] r1, File[] r2) {
        this.a = r1;
        this.b = r2;
    }
}
