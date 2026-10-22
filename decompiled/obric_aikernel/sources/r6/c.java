package r6;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static File a(Context r10, String r11, String r12) {
        BufferedWriter r13 = null;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        String r14 = com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath();
        String r15 = r14 + File.separator + r12 + ".txt";
        File r16 = new File(r14);     // Catch: Throwable -> L27 IOException -> L29
        if (r16.exists() == true) goto L9;
        r16.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r17 = new FileWriter(r15);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        BufferedWriter r18 = new BufferedWriter(r17);     // Catch: Throwable -> L22 IOException -> L24
        r18.write(r11);     // Catch: Throwable -> L18 IOException -> L20
        r18.close();     // Catch: IOException -> L14
        r17.close();     // Catch: IOException -> L14
    L17:
        return new File(r15);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
    L26:
        IOException r19 = e;
        FileWriter r20 = r17;
        e = r19;
    L52:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r18 != null) goto L56;
    L36:
        if (r20 == null) goto L40;
        r20.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L56:
        r18.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r13 = r18;
    L43:
        if (r13 != null) goto L54;
    L47:
        if (r20 == null) goto L51;
        r20.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r13.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r13 = r18;
    L23:
        Throwable r21 = th;
        r20 = r17;
        th = r21;
        goto L43
    L24:
        e = e;
        r18 = null;
    L22:
        th = th;
    L29:
        e = e;
        r20 = null;
        r18 = null;
    L27:
        th = th;
        r20 = null;
        goto L43
    }
}
