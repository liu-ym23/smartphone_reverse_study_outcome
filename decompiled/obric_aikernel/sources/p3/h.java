package p3;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static void a(File r10, ZipOutputStream r11, String r12) {
        byte[] r13 = new byte[2048];
        r11.putNextEntry(new ZipEntry(r12));
        FileInputStream r14 = new FileInputStream(r10);
    L3:
        int r15 = r14.read(r13);
        if (r15 == (-1)) goto L6;
        r11.write(r13, 0, r15);
        goto L3
    L6:
        r11.closeEntry();
        r14.close();
    }

    @NonNull
    public static File b(@NonNull File r10, boolean r11) {
        u3.a.b().f("compressFile");
        File r12 = new File(r10.getParentFile(), r10.getName().substring(0, r10.getName().lastIndexOf(".")) + ".zip");
        c(r10, r12);
        if (r12.exists() == false) goto L6;
        if (r11 == false) goto L6;
        r10.delete();
    L6:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0017 -> B:26:0x0040). Please report as a decompilation issue!!! */
    public static void c(File r10, File r11) {
        ?? r12 = 0;
        ZipOutputStream r13 = null;
        r12 = 0;
        ZipOutputStream r14 = new ZipOutputStream(new FileOutputStream(r11));     // Catch: Throwable -> L13 Exception -> L15
        String r15 = r10.getName();     // Catch: Throwable -> L9 Exception -> L11
        a(r10, r14, r15);     // Catch: Throwable -> L9 Exception -> L11
        r14.close();     // Catch: IOException -> L7
        r12 = r15;
    L26:
        return;
    L11:
        e = e;
        r13 = r14;
    L16:
        HashMap<String, Object> r16 = new HashMap();     // Catch: Throwable -> L13
        r16.put("http_error_message", e.getMessage());     // Catch: Throwable -> L13
        u3.a.b().c("compress_exception", r16);     // Catch: Throwable -> L13
        r12 = r13;
        if (r13 == null) goto L26;
        r13.close();     // Catch: IOException -> L7
        r12 = r13;
    L9:
        th = th;
        r12 = r14;
    L20:
        if (r12 != 0) goto L29;
    L25:
        throw th;
    L29:
        r12.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L13:
        th = th;
    L15:
        e = e;
    L7:
        e = move-exception;
        e.printStackTrace();
        r12 = r12;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0073 -> B:60:0x0076). Please report as a decompilation issue!!! */
    public static void d(File r10, File r11, boolean r12) {
        long r13 = System.currentTimeMillis();
        ?? r14 = 0;
        r14 = 0;
        r14 = 0;
        r14 = 0;
        r14 = 0;
        FileInputStream r15 = new FileInputStream(r10);     // Catch: Throwable -> L26 Exception -> L28
        DeflaterOutputStream r16 = new DeflaterOutputStream(new FileOutputStream(r11));     // Catch: Exception -> L24 Throwable -> L42
        byte[] r17 = new byte[8192];     // Catch: Throwable -> L20 Exception -> L22
    L7:
        int r18 = r15.read(r17);     // Catch: Throwable -> L20 Exception -> L22
        if (r18 == (-1)) goto L10;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L20 Exception -> L22
        goto L7
    L10:
        r14 = "Compress over cost： %d ms";
        c.c("Compress over cost： %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r13)});     // Catch: Throwable -> L20 Exception -> L22
        if (r11.exists() == false) goto L58;
        if (r12 == false) goto L58;
        r10.delete();     // Catch: Throwable -> L20 Exception -> L22
    L58:
        r16.close();     // Catch: IOException -> L16
    L18:
        r15.close();     // Catch: IOException -> L39
    L60:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r14 = r16;
    L30:
        c.b(e, "HeapFile compress failed", new Object[0]);     // Catch: Throwable -> L42
        if (r14 != 0) goto L54;
    L36:
        if (r15 == null) goto L60;
        r15.close();     // Catch: IOException -> L39
        goto L60
    L54:
        r14.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L20:
        th = th;
        r14 = r16;
    L43:
        if (r14 != 0) goto L68;
    L48:
        if (r15 == null) goto L74;
        r15.close();     // Catch: IOException -> L51
        throw th;
    L51:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L68:
        r14.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        goto L30
    L42:
        th = th;
    L28:
        e = e;
        r15 = null;
    L26:
        th = th;
        r15 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L60
    }
}
