package s1;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(Closeable r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: IOException -> L6
        return;
    }

    public static void b(String r10) {
        File r11 = new File(r10);
        if (r11.exists() == true) goto L6;
        return;
    L6:
        if (r11.isFile() == false) goto L9;
        r11.delete();
        return;
    L9:
        String[] r12 = r11.list();
        if (r12 != null) goto L12;
        return;
    L12:
        int r13 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L28;
        String r15 = r12[r14];
        if (r15 == null) goto L27;
        String r16 = File.separator;
        if (r10.endsWith(r16) == false) goto L20;
        String r17 = r10 + r15;
    L21:
        File r18 = new File(r17);
        if (r18.isFile() == false) goto L25;
        r18.delete();
    L25:
        if (r18.isDirectory() == false) goto L27;
        b(r17);
        goto L27
    L20:
        r17 = r10 + r16 + r15;
    L27:
        r14 = r14 + 1;
        goto L13
    L28:
        r11.delete();
    }

    public static boolean c(String r10, String r11) {
        File r12 = new File(r10);
        File r13 = new File(r11);
        if (r12.exists() == true) goto L7;
        return false;
    L7:
        return r12.renameTo(r13);
    }
}
