package ie;

import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r10) {
        byte[] r11 = MessageDigest.getInstance("MD5").digest(r10);     // Catch: Throwable -> L7
        char[] r0 = a;     // Catch: Throwable -> L7
        int r12 = r11.length;     // Catch: Throwable -> L7
        char[] r13 = new char[r12 << 1];     // Catch: Throwable -> L7
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L5;
        int r16 = r15 + 1;     // Catch: Throwable -> L7
        byte r17 = r11[r14];     // Catch: Throwable -> L7
        r13[r15] = r0[(r17 & 240) >>> 4];     // Catch: Throwable -> L7
        r15 = r16 + 1;     // Catch: Throwable -> L7
        r13[r16] = r0[r17 & 15];     // Catch: Throwable -> L7
        r14 = r14 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        return new String(r13);
    L7:
        return null;
    }
}
