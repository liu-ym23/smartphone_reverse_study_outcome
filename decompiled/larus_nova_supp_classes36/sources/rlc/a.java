package rlc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(PolarisFileWrapper r5) throws Exception {
        MessageDigest r0 = MessageDigest.getInstance("MD5");
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L14
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L12
    L6:
        int r4 = r1.read(r2, 0, 8192);     // Catch: Throwable -> L12
        if (r4 <= 0) goto L9;
        r0.update(r2, 0, r4);     // Catch: Throwable -> L12
        goto L6
    L9:
        String r6 = c(r0.digest());     // Catch: Throwable -> L12
        r1.close();
        return r6;
    L12:
        th = th;
    L16:
        if (r1 == null) goto L18;
        r1.close();
    L18:
        throw th;
    L14:
        th = th;
        r1 = null;
        goto L16
    }

    public static String b(String r2) throws Exception {
        if (r2 == null) goto L8;
        if (r2.length() == 0) goto L8;
        MessageDigest r0 = MessageDigest.getInstance("MD5");
        r0.update(r2.getBytes("UTF-8"));
        return c(r0.digest());
    L8:
        throw new IllegalArgumentException("str is null");
    }

    public static String c(byte[] r10) {
        if (r10 == null) goto L13;
        int r0 = r10.length;
        if ((0 + r0) > r10.length) goto L11;
        int r2 = r0 * 2;
        char[] r3 = new char[r2];
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r0) goto L9;
        int r6 = r10[r4 + 0] & 255;
        int r7 = r5 + 1;
        char[] r8 = a;
        r3[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r3[r7] = r8[r6 & 15];
        r4 = r4 + 1;
        goto L6
    L9:
        return new String(r3, 0, r2);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }
}
