package gla;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final Logger a = null;

    public b() {
    }

    static {
        a = Logger.getLogger(b.class.getName());
    }

    public static void b(Context r9, String[] r10) throws IOException {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r9.getFilesDir(), "ologs.zip");
        if (r0.exists() == false) goto L39;
        r0.delete();
    L39:
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r0);     // Catch: IOException -> L34
        ZipOutputStream r2 = new ZipOutputStream(r1);     // Catch: Throwable -> L28
        int r3 = r10.length;     // Catch: Throwable -> L16
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L20;
        String r5 = r10[r4];     // Catch: Throwable -> L16
        PolarisFileWrapper r6 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L16
        if (r6.exists() == true) goto L13;
    L18:
        a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r5);     // Catch: Throwable -> L16
    L19:
        r4 = r4 + 1;
        goto L9
    L13:
        if (r6.isDirectory() == false) goto L18;
        a(r6, r6.getName(), r2, r0);     // Catch: Throwable -> L16
        goto L19
    L20:
        r2.close();     // Catch: Throwable -> L28
        r1.close();     // Catch: IOException -> L34
        return;
    L16:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Throwable -> L28
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: IOException -> L34
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L34
    L34:
        e = move-exception;
        a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r0.getAbsolutePath(), e.getMessage()});
        throw e;
    }

    public static void a(File r8, String r9, ZipOutputStream r10, PolarisFileWrapper r11) throws IOException {
        File[] r12 = r8.listFiles();
        if (r12 == null) goto L29;
        int r0 = r12.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L41;
        File r3 = r12[r2];
        if (r3.equals(r11) == true) goto L19;
        if (r3.isDirectory() == false) goto L32;
        a(r3, r9 + "/" + r3.getName(), r10, r11);
        goto L19
    L32:
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r3);     // Catch: IOException -> L26
        r10.putNextEntry(new ZipEntry(r9 + "/" + r3.getName()));     // Catch: Throwable -> L20
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L20
    L14:
        int r6 = r4.read(r5);     // Catch: Throwable -> L20
        if (r6 < 0) goto L17;
        r10.write(r5, 0, r6);     // Catch: Throwable -> L20
        goto L14
    L17:
        r10.closeEntry();     // Catch: Throwable -> L20
        r4.close();     // Catch: IOException -> L26
        goto L19
    L20:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        a.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r3.getAbsolutePath(), e.getMessage()});
        throw e;
    L19:
        r2 = r2 + 1;
        goto L5
    L41:
        return;
    }
}
