package m5;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Character f11048d = null;

    static {
        f11048d = ')';
    }

    public c() {
        this("proc/self/stat");
    }

    public c(String r10) {
        super(r10);
    }

    @Override // m5.a
    protected b a(File r10) {
        return c(r10, null);
    }

    protected b c(File r10, k5.d r11) {
        BufferedReader r12 = n5.c.b(r10);
        if (r12 != null) goto L32;
        return null;
    L32:
        String r13 = r12.readLine();     // Catch: Exception -> L25 Throwable -> L29
        if (r13 != null) goto L9;
    L23:
        n5.c.a(r12);
        return r11;
    L9:
        if (r13.isEmpty() == true) goto L23;
        String r14 = r13.trim();     // Catch: Exception -> L25 Throwable -> L29
        Character r15 = f11048d;     // Catch: Exception -> L25 Throwable -> L29
        String r16 = r14.substring(0, r14.indexOf(r15.charValue())).trim();     // Catch: Exception -> L25 Throwable -> L29
        String r17 = r14.substring(r14.indexOf(r15.charValue()) + 1, r14.length()).trim();     // Catch: Exception -> L25 Throwable -> L29
        String[] r18 = r16.split("\\(");     // Catch: Exception -> L25 Throwable -> L29
        String[] r19 = r17.split(" ");     // Catch: Exception -> L25 Throwable -> L29
        if (r18.length > 1) goto L14;
    L21:
        n5.c.a(r12);
        return r11;
    L14:
        if (r19.length <= 14) goto L21;
        if (r11 != null) goto L18;
        r11 = new k5.d();     // Catch: Exception -> L25 Throwable -> L29
    L18:
        r11.h(Integer.parseInt(r18[0].trim()));     // Catch: Exception -> L25 Throwable -> L29
        r11.i(r18[1].trim());     // Catch: Exception -> L25 Throwable -> L29
        r11.f((((Integer.parseInt(r19[11]) + Integer.parseInt(r19[12])) + Integer.parseInt(r19[13])) + Integer.parseInt(r19[14])) * 10);     // Catch: Exception -> L25 Throwable -> L29
        n5.c.a(r12);
        return r11;
    L25:
        e = move-exception;
        n5.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L29
        n5.c.a(r12);
        return r11;
    L29:
        n5.c.a(r12);
        return r11;
    }
}
