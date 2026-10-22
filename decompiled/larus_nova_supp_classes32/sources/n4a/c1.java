package n4a;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c1 extends b1 {
    public c1() {
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r9) {
        String[] r0 = f5.a;
        byte[] r3 = null;
        if (r9 != null) goto L5;
    L43:
        return r3;
    L5:
        if (r9.length == 0) goto L43;
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
        ZipOutputStream r5 = new ZipOutputStream(r4);     // Catch: Throwable -> L16
        r5.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L14
        r5.write(r9);     // Catch: Throwable -> L14
        r5.closeEntry();     // Catch: Throwable -> L14
        r5.finish();     // Catch: Throwable -> L14
        r3 = r4.toByteArray();     // Catch: Throwable -> L14
        r5.close();     // Catch: Throwable -> L12
    L56:
        r4.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        n.a(th, "ut", "zp2");
    L12:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L14:
        th = th;
    L44:
        n.a(th, "ut", "zp");     // Catch: Throwable -> L31
        if (r5 != null) goto L48;
    L26:
        if (r4 == null) goto L43;
    L48:
        r5.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L31:
        th = move-exception;
        if (r5 != null) goto L52;
    L37:
        if (r4 == null) goto L62;
        r4.close();     // Catch: Throwable -> L40
        throw th;
    L40:
        th = move-exception;
        n.a(th, "ut", "zp2");
        throw th;
    L62:
        throw th;
    L52:
        r5.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L16:
        th = th;
        r5 = null;
    L18:
        th = th;
        r4 = null;
        r5 = null;
        goto L44
    }
}
