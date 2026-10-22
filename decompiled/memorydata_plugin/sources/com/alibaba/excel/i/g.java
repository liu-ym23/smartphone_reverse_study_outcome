package com.alibaba.excel.i;

import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.exception.ExcelCommonException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f215b;
    private static String c;

    static {
        f214a = System.getProperty("java.io.tmpdir") + File.separator + UUID.randomUUID().toString() + File.separator;
        f215b = f214a + "poifiles" + File.separator;
        c = f214a + "excache" + File.separator;
        File r0 = new File(f214a);
        a(r0);
        r0.deleteOnExit();
        a(new File(c));
    }

    public static File a() {
        return a(new File(c + UUID.randomUUID().toString()));
    }

    public static File a(File r3) {
        if (r3.exists() == false) goto L5;
    L9:
        return r3;
    L5:
        if (r3.mkdirs() == true) goto L9;
        throw new ExcelCommonException("Cannot create directory:" + r3.getAbsolutePath());
    }

    public static void a(File r7, InputStream r8, boolean r9) {
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r7);     // Catch: Throwable -> L26 Exception -> L28
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L22 Exception -> L24
    L6:
        int r5 = r8.read(r4, 0, 8192);     // Catch: Throwable -> L22 Exception -> L24
        if (r5 == (-1)) goto L52;
        r3.write(r4, 0, r5);     // Catch: Throwable -> L22 Exception -> L24
    L52:
        r3.close();     // Catch: IOException -> L19
        if (r8 == null) goto L18;
        if (r9 == false) goto L59;
        r8.close();     // Catch: IOException -> L15
        return;
    L15:
        e = move-exception;
        throw new ExcelAnalysisException("Can not close 'inputStream'", e);
    L59:
        return;
    L18:
        return;
    L19:
        e = move-exception;
        throw new ExcelAnalysisException("Can not close 'outputStream'!", e);
    L24:
        e = e;
        r2 = r3;
    L30:
        throw new ExcelAnalysisException("Can not create temporary file!", e);     // Catch: Throwable -> L26
    L22:
        th = th;
        r2 = r3;
    L31:
        if (r2 != null) goto L54;
    L37:
        if (r8 == null) goto L44;
        if (r9 == false) goto L44;
        r8.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        throw new ExcelAnalysisException("Can not close 'inputStream'", e);
    L44:
        throw th;
    L54:
        r2.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        throw new ExcelAnalysisException("Can not close 'outputStream'!", e);
    L28:
        e = e;
    L26:
        th = th;
        goto L31
    }

    public static void delete(File r3) {
        if (r3.isFile() == false) goto L7;
        r3.delete();
        return;
    L7:
        if (r3.isDirectory() == false) goto L21;
        File[] r0 = r3.listFiles();
        if (r0 != null) goto L11;
    L18:
        r3.delete();
        return;
    L11:
        if (r0.length == 0) goto L18;
        int r1 = 0;
    L15:
        if (r1 >= r0.length) goto L17;
        delete(r0[r1]);
        r1 = r1 + 1;
        goto L15
    L17:
        r3.delete();
        return;
    }
}
