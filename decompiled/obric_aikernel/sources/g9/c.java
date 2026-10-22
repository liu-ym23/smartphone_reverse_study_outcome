package g9;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f9010a = null;

    static {
        f9010a = Logger.getLogger(c.class.getName());
    }

    public c() {
    }

    private static void a(File r10, String r11, ZipOutputStream r12) {
        File[] r13 = r10.listFiles();
        if (r13 == null) goto L26;
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L37;
        File r16 = r13[r15];
        if (r16.isDirectory() == false) goto L27;
        a(r16, r11 + "/" + r16.getName(), r12);
    L16:
        r15 = r15 + 1;
        goto L5
    L27:
        FileInputStream r17 = new FileInputStream(r16);     // Catch: IOException -> L23
        r12.putNextEntry(new ZipEntry(r11 + "/" + r16.getName()));     // Catch: Throwable -> L17
        byte[] r18 = new byte[8192];     // Catch: Throwable -> L17
    L11:
        int r19 = r17.read(r18);     // Catch: Throwable -> L17
        if (r19 < 0) goto L14;
        r12.write(r18, 0, r19);     // Catch: Throwable -> L17
        goto L11
    L14:
        r12.closeEntry();     // Catch: Throwable -> L17
        r17.close();     // Catch: IOException -> L23
        goto L16
    L17:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L23
    L23:
        e = move-exception;
        f9010a.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r16.getAbsolutePath(), e.getMessage()});
        throw e;
    L37:
        return;
    }

    public static void b(Context r10, String[] r11, String r12) {
        File r13 = new File(r10.getFilesDir(), r12);
        if (r13.exists() == false) goto L40;
        r13.delete();
    L40:
        FileOutputStream r14 = new FileOutputStream(r13);     // Catch: IOException -> L33
        ZipOutputStream r15 = new ZipOutputStream(r14);     // Catch: Throwable -> L27
        int r16 = r11.length;     // Catch: Throwable -> L21
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L18;
        String r18 = r11[r17];     // Catch: Throwable -> L21
        File r19 = new File(r18);     // Catch: Throwable -> L21
        if (r19.exists() == true) goto L13;
    L16:
        f9010a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r18);     // Catch: Throwable -> L21
    L17:
        r17 = r17 + 1;
        goto L9
    L13:
        if (r19.isDirectory() == false) goto L16;
        a(r19, r19.getName(), r15);     // Catch: Throwable -> L21
        goto L17
    L18:
        r15.close();     // Catch: Throwable -> L27
        r14.close();     // Catch: IOException -> L33
        return;
    L21:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: IOException -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L33
    L33:
        e = move-exception;
        f9010a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r13.getAbsolutePath(), e.getMessage()});
        throw e;
    }
}
