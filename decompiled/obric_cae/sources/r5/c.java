package r5;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11501a;
    }

    public final String a(String r8, byte[] r10, String r11) {
        HashMap r12 = new HashMap();
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L14
        GZIPOutputStream r14 = new GZIPOutputStream(r13);     // Catch: Throwable -> L14
        r14.write(r10);     // Catch: Throwable -> L12
        r14.close();     // Catch: Throwable -> L12
        byte[] r15 = r13.toByteArray();     // Catch: Throwable -> L14
        r12.put("Content-Encoding", "gzip");     // Catch: Exception -> L19
        if (f.b(r11) == true) goto L10;
        r12.put("Content-Type", r11);
    L10:
        a r16 = new a();
        r16.f11501a = true;
        return b(r8, r15, r12, r16);
    L12:
        th = th;
    L16:
        if (r14 == null) goto L18;
        r14.close();     // Catch: Exception -> L19
    L18:
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        throw new r5.a(e.getMessage());
    L14:
        th = th;
        r14 = null;
        goto L16
    }

    public abstract String b(String r8, byte[] r10, Map<String, String> r11, a r12);
}
