package n5;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public interface a {
        boolean a(String r10);
    }

    public static void a(BufferedReader r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
        return;
    }

    public static BufferedReader b(File r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.exists() == true) goto L11;
        StringBuilder r11 = new StringBuilder();
        r11.append("file:");
        r11.append(r10.getName());
        String r12 = " not exist";
    L8:
        r11.append(r12);
        b.g(r11.toString());
        return null;
    L11:
        if (r10.canRead() == true) goto L18;
        r11 = new StringBuilder();
        r11.append("file:");
        r11.append(r10.getName());
        r12 = " can not read";
        goto L8
    L18:
        return new BufferedReader(new FileReader(r10), 10000);
    L15:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
        return null;
    }

    public static void c(File r10, a r11) {
        if (r10 == null) goto L23;
        if (r11 == null) goto L24;
        BufferedReader r12 = b(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L16;
        String r14 = r12.readLine();     // Catch: IOException -> L14
        if (r14 == null) goto L16;
        r13 = r11.a(r14);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
    L16:
        a(r12);
        return;
    L24:
        return;
    }

    public static void d(String r10, a r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        c(new File(r10), r11);
        return;
    L8:
        return;
    }
}
