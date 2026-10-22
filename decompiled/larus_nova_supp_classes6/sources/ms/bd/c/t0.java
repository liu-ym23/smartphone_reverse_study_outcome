package ms.bd.c;

import f06.b;
import f06.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class t0 {
    public static final String a = null;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "2ad15a", new byte[]{24, 63, 86, 27, 55});
        a = (String) p2.a(16777217, 0, 0, "05e7d2", new byte[]{44, 50, 24, 71});
    }

    public static String a(BufferedInputStream r9) {
        byte[] r1 = new byte[4096];
        StringBuilder r2 = new StringBuilder();
    L11:
        int r3 = r9.read(r1);     // Catch: Exception -> L8
        if (r3 <= 0) goto L6;
        r2.append(new String(r1, 0, r3));     // Catch: Exception -> L8
    L6:
        if (r3 >= 4096) goto L11;
    L10:
        return r2.toString();
    L8:
        String r10 = (String) p2.a(16777217, 0, 0, "b64299", new byte[]{118, 61, 68});
        goto L10
    }

    public static String b(String r14) {
        BufferedOutputStream r4 = null;
        BufferedInputStream r5 = null;
        r4 = null;
        String r6 = null;
        r6 = null;
        Process r7 = c(Runtime.getRuntime(), (String) p2.a(16777217, 0, 0, "dae412", new byte[]{102, 107}));     // Catch: Throwable -> L21 Exception -> L23
    L75:
        BufferedOutputStream r8 = new BufferedOutputStream(r7.getOutputStream());     // Catch: Throwable -> L19 Exception -> L54
        BufferedInputStream r9 = new BufferedInputStream(r7.getInputStream());     // Catch: Throwable -> L16 Exception -> L18
        r8.write(r14.getBytes());     // Catch: Throwable -> L14 Exception -> L53
        r8.write(10);     // Catch: Throwable -> L14 Exception -> L53
        r8.flush();     // Catch: Throwable -> L14 Exception -> L53
        r8.close();     // Catch: Throwable -> L14 Exception -> L53
        r7.waitFor();     // Catch: Throwable -> L14 Exception -> L53
        String r15 = a(r9);     // Catch: Throwable -> L14 Exception -> L53
        r8.close();     // Catch: IOException -> L9
    L61:
        r9.close();     // Catch: IOException -> L12
    L13:
        r6 = r15;
    L36:
        r7.destroy();
    L37:
        return r6;
    L12:
        String r0 = (String) p2.a(16777217, 0, 0, "f56691", new byte[]{114, 62, 70, 125, 3});
    L9:
        String r1 = (String) p2.a(16777217, 0, 0, "6260dd", new byte[]{34, 57, 70, 123, 94});
        goto L61
    L14:
        th = th;
    L41:
        r5 = r9;
    L42:
        if (r8 != null) goto L67;
    L46:
        if (r5 != null) goto L57;
    L50:
        if (r7 == null) goto L77;
        r7.destroy();
        throw th;
    L77:
        throw th;
    L57:
        r5.close();     // Catch: IOException -> L49
    L49:
        String r2 = (String) p2.a(16777217, 0, 0, "63ffd3", new byte[]{34, 56, 22, 45, 94});
        goto L50
    L67:
        r8.close();     // Catch: IOException -> L45
    L45:
        String r3 = (String) p2.a(16777217, 0, 0, "4af50d", new byte[]{32, 106, 22, 126, 10});
    L63:
        String r16 = (String) p2.a(16777217, 0, 0, "280914", new byte[]{38, 51, 64, 114, 11});     // Catch: Throwable -> L38
        if (r8 != null) goto L65;
    L31:
        if (r9 != null) goto L55;
    L35:
        if (r7 == null) goto L37;
    L55:
        r9.close();     // Catch: IOException -> L34
    L34:
        String r17 = (String) p2.a(16777217, 0, 0, "656fd2", new byte[]{34, 62, 70, 45, 94});
        goto L35
    L65:
        r8.close();     // Catch: IOException -> L30
    L30:
        String r18 = (String) p2.a(16777217, 0, 0, "703ced", new byte[]{35, 59, 67, 40, 95});
    L38:
        th = th;
        r4 = r8;
    L40:
        r8 = r4;
        goto L41
    L18:
        r9 = null;
    L16:
        th = th;
        goto L42
    L19:
        th = th;
        r9 = null;
    L24:
        r8 = null;
        r9 = null;
    L23:
        r7 = null;
    L21:
        th = th;
        r7 = null;
        r9 = null;
        goto L40
    }

    public static Process c(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        b r10 = new b();
        d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }
}
