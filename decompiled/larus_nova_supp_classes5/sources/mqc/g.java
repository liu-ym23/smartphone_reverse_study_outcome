package mqc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r8) {
        if (r8 != null) goto L5;
    L11:
        byte[] r9 = null;
    L12:
        if (r9 == null) goto L25;
        int r0 = r9.length;
        if (r0 <= 0) goto L26;
        char[] r1 = new char[r0 << 1];
        int r2 = 0;
        int r3 = 0;
    L18:
        if (r2 >= r0) goto L21;
        int r4 = r3 + 1;
        char[] r5 = a;
        byte r6 = r9[r2];
        r1[r3] = r5[(r6 >>> 4) & 15];
        r3 = r4 + 1;
        r1[r4] = r5[r6 & 15];
        r2 = r2 + 1;
        goto L18
    L21:
        return new String(r1);
    L26:
        return null;
    L25:
        return null;
    L5:
        if (r8.length <= 0) goto L11;
        MessageDigest r7 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
        r7.update(r8);     // Catch: NoSuchAlgorithmException -> L9
        r9 = r7.digest();     // Catch: NoSuchAlgorithmException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
