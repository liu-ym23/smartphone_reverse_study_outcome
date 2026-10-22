package r6;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static File a(Context r10, JSONObject r11) {
        BufferedWriter r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        String r13 = com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath();
        String r14 = r13 + File.separator + "stats.txt";
        File r15 = new File(r13);     // Catch: Throwable -> L27 IOException -> L29
        if (r15.exists() == true) goto L9;
        r15.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r16 = new FileWriter(r14);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        BufferedWriter r17 = new BufferedWriter(r16);     // Catch: Throwable -> L22 IOException -> L24
        r17.write(r11.toString());     // Catch: Throwable -> L18 IOException -> L20
        r17.close();     // Catch: IOException -> L14
        r16.close();     // Catch: IOException -> L14
    L17:
        return new File(r14);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
    L26:
        IOException r18 = e;
        FileWriter r19 = r16;
        e = r18;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r17 != null) goto L56;
    L36:
        if (r19 == null) goto L40;
        r19.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L56:
        r17.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r12 = r17;
    L43:
        if (r12 != null) goto L54;
    L47:
        if (r19 == null) goto L51;
        r19.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r12.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r12 = r17;
    L23:
        Throwable r20 = th;
        r19 = r16;
        th = r20;
        goto L43
    L24:
        e = e;
        r17 = null;
    L22:
        th = th;
    L29:
        e = e;
        r19 = null;
        r17 = null;
    L27:
        th = th;
        r19 = null;
        goto L43
    }
}
