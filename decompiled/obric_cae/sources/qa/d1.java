package qa;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d1 extends c1 {
    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        String[] r10 = t4.f11124a;
        byte[] r11 = null;
        if (r8 != null) goto L5;
    L43:
        return r11;
    L5:
        if (r8.length == 0) goto L43;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
        ZipOutputStream r13 = new ZipOutputStream(r12);     // Catch: Throwable -> L16
        r13.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L14
        r13.write(r8);     // Catch: Throwable -> L14
        r13.closeEntry();     // Catch: Throwable -> L14
        r13.finish();     // Catch: Throwable -> L14
        r11 = r12.toByteArray();     // Catch: Throwable -> L14
        r13.close();     // Catch: Throwable -> L12
    L48:
        r12.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        l.a("ut", "zp2", th);
    L12:
        th = move-exception;
        l.a("ut", "zp1", th);
    L14:
        th = th;
    L52:
        l.a("ut", "zp", th);     // Catch: Throwable -> L31
        if (r13 != null) goto L58;
    L26:
        if (r12 == null) goto L43;
    L58:
        r13.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        l.a("ut", "zp1", th);
    L31:
        th = move-exception;
        if (r13 != null) goto L44;
    L37:
        if (r12 == null) goto L62;
        r12.close();     // Catch: Throwable -> L40
        throw th;
    L40:
        th = move-exception;
        l.a("ut", "zp2", th);
        throw th;
    L62:
        throw th;
    L44:
        r13.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        l.a("ut", "zp1", th);
    L16:
        th = th;
        r13 = null;
    L18:
        th = th;
        r12 = null;
        r13 = null;
        goto L52
    }
}
