package m02;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static String a(String r3) {
        String r0 = File.separator;
        if (r3.endsWith(r0) == false) goto L6;
        return r3.concat("config.json");
    L6:
        return r3 + r0 + "config.json";
    }

    public static String b(String r5) {
        if (new PolarisFileWrapper(r5).exists() == true) goto L51;
    L42:
        return null;
    L51:
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L20 IOException -> L22
    L53:
        InputStreamReader r6 = new InputStreamReader(r0, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r2 = new char[r0.available()];     // Catch: IOException -> L14 Throwable -> L32
        r6.read(r2);     // Catch: IOException -> L12 Throwable -> L32
        r6.close();     // Catch: IOException -> L12 Throwable -> L32
        r0.close();     // Catch: IOException -> L12 Throwable -> L32
        r6.close();     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
    L29:
        if (r2 == null) goto L42;
        return new String(r2);
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r6 == null) goto L27;
        r6.close();     // Catch: IOException -> L10
    L27:
        if (r0 == null) goto L29;
        r0.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r2 = null;
    L32:
        Throwable th = th;
    L33:
        if (r6 != null) goto L45;
    L37:
        if (r0 == null) goto L41;
        r0.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L41:
        throw th;
    L45:
        r6.close();     // Catch: IOException -> L35
        goto L37
    L18:
        e = e;
        r6 = null;
        r2 = null;
    L16:
        th = move-exception;
        th = th;
        r6 = null;
    L22:
        e = e;
        r6 = null;
        r0 = null;
        r2 = null;
    L20:
        th = move-exception;
        r0 = null;
        th = th;
        r6 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }
}
