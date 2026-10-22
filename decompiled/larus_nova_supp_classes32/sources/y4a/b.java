package y4a;

import com.lynx.animax.util.AnimaXLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static void a(Closeable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "Failed to close resource: " + e);
    }

    public static byte[] c(InputStream r1, int r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (b(r1, r0, r2) == true) goto L5;
        return null;
    L5:
        return r0.toByteArray();
    }

    public static boolean b(InputStream r5, OutputStream r6, int r7) {
        if (r5 == null) goto L21;
        if (r6 == null) goto L21;
        if (r7 >= 1024) goto L10;
        r7 = 1024;
    L12:
        byte[] r2 = new byte[r7];     // Catch: IOException -> L17 Throwable -> L24
    L13:
        int r3 = r5.read(r2, 0, r7);     // Catch: IOException -> L17 Throwable -> L24
        if (r3 == (-1)) goto L19;
        r6.write(r2, 0, r3);     // Catch: IOException -> L17 Throwable -> L24
        goto L13
    L19:
        a(r5);
        a(r6);
        return true;
    L10:
        if (r7 <= 8192) goto L12;
        r7 = 8192;
    L21:
        AnimaXLog.a("AnimaXStreamUtil", "Invalid input stream or output stream");     // Catch: IOException -> L17 Throwable -> L24
    L22:
        a(r5);
        a(r6);
        return false;
    L24:
        th = move-exception;
        a(r5);
        a(r6);
        throw th;
    L17:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "Failed to copy input stream to output stream, reason: " + e);     // Catch: Throwable -> L24
        goto L22
    }
}
