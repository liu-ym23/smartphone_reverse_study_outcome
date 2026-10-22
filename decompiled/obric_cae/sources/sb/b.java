package sb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f12075a = null;

    static {
        f12075a = Logger.getLogger(b.class.getName());
    }

    public b() {
    }

    public static void a(File r8, String r10, ZipOutputStream r11, File r12, String r13) {
        File[] r14 = r8.listFiles();
        if (r14 == null) goto L30;
        int r15 = r14.length;
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L42;
        File r17 = r14[r16];
        if (r17.equals(r12) == true) goto L20;
        if (r17.isDirectory() == false) goto L12;
        StringBuilder r18 = android.aimedia.a.k(r10, "/");
        r18.append(r17.getName());
        a(r17, r18.toString(), r11, r12, r13);
        goto L20
    L12:
        String r19 = r13 + "/" + r10 + "/" + r17.getName();
        Log.i("zhoupeng.725", "entryName:" + r19);
        FileInputStream r20 = new FileInputStream(r17);     // Catch: Exception -> L27
        r11.putNextEntry(new ZipEntry(r19));     // Catch: Throwable -> L21
        byte[] r21 = new byte[8192];     // Catch: Throwable -> L21
    L15:
        int r22 = r20.read(r21);     // Catch: Throwable -> L21
        if (r22 < 0) goto L18;
        r11.write(r21, 0, r22);     // Catch: Throwable -> L21
        goto L15
    L18:
        r11.closeEntry();     // Catch: Throwable -> L21
        r20.close();     // Catch: Exception -> L27
        goto L20
    L21:
        th = move-exception;
        r20.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Exception -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        f12075a.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r17.getAbsolutePath(), e.getMessage()});
        throw e;
    L20:
        r16 = r16 + 1;
        goto L5
    L42:
        return;
    }

    public static void b(Context r10, String[] r11) {
        Logger r8 = f12075a;
        File r12 = new File(r10.getFilesDir(), "ologs.zip");
        if (r12.exists() == false) goto L42;
        r12.delete();
    L42:
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: Exception -> L32
        ZipOutputStream r14 = new ZipOutputStream(r13);     // Catch: Throwable -> L26
        int r15 = r11.length;     // Catch: Throwable -> L20
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L17;
        String r17 = r11[r16];     // Catch: Throwable -> L20
        File r18 = new File(r17);     // Catch: Throwable -> L20
        if (r18.exists() == true) goto L12;
    L15:
        r8.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r17);     // Catch: Throwable -> L20
    L16:
        r16 = r16 + 1;
        goto L8
    L12:
        if (r18.isDirectory() == false) goto L15;
        a(r18, r18.getName(), r14, r12, r18.getAbsolutePath().replaceAll("/", "_"));     // Catch: Throwable -> L20
        goto L16
    L17:
        r14.close();     // Catch: Throwable -> L26
        r13.close();     // Catch: Exception -> L32
        return;
    L20:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Exception -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        r8.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r12.getAbsolutePath(), e.getMessage()});
        throw e;
    }
}
