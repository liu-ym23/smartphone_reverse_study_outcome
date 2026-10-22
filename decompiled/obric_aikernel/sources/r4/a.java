package r4;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f12657a = null;

    static {
        f12657a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static char[] a(byte[] r10) {
        int r11 = r10.length;
        char[] r12 = new char[r11 << 1];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        int r15 = r14 + 1;
        char[] r16 = f12657a;
        r12[r14] = r16[(r10[r13] & 240) >>> 4];
        r14 = r15 + 1;
        r12[r15] = r16[r10[r13] & 15];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static String b(InputStream r10) {
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L8
        byte[] r12 = new byte[1024];     // Catch: Throwable -> L8
        int r13 = r10.read(r12, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r13 <= (-1)) goto L6;
        r11.update(r12, 0, r13);     // Catch: Throwable -> L8
        r13 = r10.read(r12, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(a(r11.digest()));
    L8:
        return null;
    }

    public static String c(byte[] r10) {
        return new String(a(MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r10)));
    L4:
        return null;
    }
}
