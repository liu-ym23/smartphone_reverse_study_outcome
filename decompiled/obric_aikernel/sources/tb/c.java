package tb;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f12976a = null;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f12980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f12981e;

        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }

        static /* synthetic */ int a(b r10) {
            return r10.f12977a;
        }

        static /* synthetic */ int b(b r10, int r11) {
            r10.f12977a = r11;
            return r11;
        }

        static /* synthetic */ int c(b r10) {
            return r10.f12979c;
        }

        static /* synthetic */ int d(b r10, int r11) {
            r10.f12979c = r11;
            return r11;
        }

        static /* synthetic */ long e(b r10) {
            return r10.f12980d;
        }

        static /* synthetic */ long f(b r10, long r11) {
            r10.f12980d = r11;
            return r11;
        }

        static /* synthetic */ int g(b r10) {
            return r10.f12978b;
        }

        static /* synthetic */ int h(b r10, int r11) {
            r10.f12978b = r11;
            return r11;
        }

        static /* synthetic */ String i(b r10) {
            return r10.f12981e;
        }

        static /* synthetic */ String j(b r10, String r11) {
            r10.f12981e = r11;
            return r11;
        }
    }

    static {
        f12976a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static String a(File r10, int r11, long r12) {
        return b(new tb.a(r10), r11, r12);
    }

    private static String b(tb.b r21, int r22, long r23) {
        int r10 = r22;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        if (r11 != null) goto L39;
        return "";
    L39:
        long r12 = r21.length();     // Catch: Throwable -> L31
        if (r10 > 0) goto L9;
    L14:
        long r13 = r12;
        r10 = 1;
    L15:
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L31
        long r15 = 0;
        j(r21, r11, r14, 0, r13);     // Catch: Throwable -> L31
        if (r10 <= 2) goto L20;
        int r16 = r10 - 1;     // Catch: Throwable -> L31
        long r17 = (r12 - (((long) r10) * r13)) / ((long) r16);     // Catch: Throwable -> L31
        int r18 = 1;
    L18:
        if (r18 >= r16) goto L20;
        r15 = r15 + (r13 + r17);     // Catch: Throwable -> L31
        j(r21, r11, r14, r15, r13);     // Catch: Throwable -> L31
        r18 = r18 + 1;     // Catch: Throwable -> L31
        r16 = r16;
    L20:
        if (r10 <= 1) goto L22;
        j(r21, r11, r14, r12 - r13, r13);     // Catch: Throwable -> L31
    L22:
        String r19 = i(r11.digest());     // Catch: Throwable -> L31
        if (r10 == 1) goto L25;
    L28:
        String r20 = g(r10, r13) + ";" + r19;     // Catch: Throwable -> L31
        r21.close();     // Catch: Throwable -> L35
    L30:
        return r20;
    L25:
        if (r13 != r12) goto L28;
        r21.close();     // Catch: Throwable -> L34
    L27:
        return r19;
    L9:
        if (r23 <= 0) goto L14;
        if ((((long) r10) * r23) > ((8 * r12) / 10)) goto L14;
        r13 = r23;
    L31:
        th = move-exception;
        r21.close();     // Catch: Throwable -> L36
    L33:
        throw th;
    }

    public static int c(String r10, File r11) {
        return d(r10, r11, null);
    }

    public static int d(String r10, File r11, tb.b r12) {
        if (r10 != null) goto L4;
        return 2;
    L4:
        if (r10.length() != 0) goto L74;
        return 2;
    L74:
        if (r12 != null) goto L10;
        if (r11 != null) goto L15;
    L65:
        return 5;
    L15:
        if (r11.exists() == false) goto L65;
    L17:
        int r13 = -1;
        long r14 = -1;
        b r15 = h(r10);     // Catch: Throwable -> L61
        if (r15 != null) goto L22;
    L26:
        b r16 = null;
        if (r12 == null) goto L29;
        String r17 = b(r12, r13, r14);     // Catch: Throwable -> L31
    L77:
    L33:
        if (r17 != null) goto L35;
        return 6;
    L35:
        if (r17.length() != 0) goto L38;
        return 6;
    L38:
        if (r15 == null) goto L56;
        if (b.a(r15) != 1) goto L45;
        if (b.g(r15) == 1) goto L56;
    L45:
        if (b.i(r15) != null) goto L70;
    L58:
        return 1;
    L70:
        r16 = h(r17);     // Catch: Throwable -> L68
    L47:
        if (r16 == null) goto L58;
        if (b.c(r15) != b.c(r16)) goto L58;
        if (b.e(r15) != b.e(r16)) goto L58;
        if (b.i(r15).equals(b.i(r16)) == false) goto L58;
        return 0;
    L56:
        if (r17.equals(r10) == false) goto L58;
        return 0;
    L29:
        r17 = a(r11, r13, r14);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        r17 = null;
        goto L33
    L22:
        if (b.a(r15) <= 1) goto L25;
        return 3;
    L25:
        r13 = b.c(r15);     // Catch: Throwable -> L63
        r14 = b.e(r15);     // Catch: Throwable -> L63
    L61:
        return 4;
    L10:
        if (r12.length() > 0) goto L17;
        r12.close();     // Catch: Throwable -> L69
    L12:
        return 5;
    L63:
        return 99;
    }

    private static long e(String r10) {
        return (Long.parseLong(r10, 16) - 31) >> 4;
    L7:
        throw new RuntimeException("ttmd5 decryptNum error, num = " + r10);
    }

    private static String f(long r10) {
        return Long.toHexString((r10 << 4) + 31);
    }

    private static String g(int r10, long r11) {
        return "ttmd5:1:1:" + f(r10) + "g" + f(r11);
    }

    private static b h(String r10) {
        a r11 = null;
        if (r10.startsWith("ttmd5:") == true) goto L5;
        return null;
    L5:
        String[] r12 = r10.split(";");
        String[] r13 = r12[0].split(":");
        b r14 = new b(r11);
        b.b(r14, Integer.parseInt(r13[1]));
        if (b.a(r14) <= 1) goto L8;
        return r14;
    L8:
        b.h(r14, Integer.parseInt(r13[2]));
        String[] r15 = r13[3].split("g");
        b.d(r14, (int) e(r15[0]));
        b.f(r14, e(r15[1]));
        b.j(r14, r12[1]);
        return r14;
    }

    private static String i(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        int r11 = r10.length;
        int r12 = r11 * 2;
        char[] r13 = new char[r12];
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r11) goto L6;
        int r16 = r10[r14 + 0] & 255;
        int r17 = r15 + 1;
        char[] r18 = f12976a;
        r13[r15] = r18[r16 >> 4];
        r15 = r17 + 1;
        r13[r17] = r18[r16 & 15];
        r14 = r14 + 1;
        goto L3
    L6:
        return new String(r13, 0, r12);
    }

    private static void j(tb.b r10, MessageDigest r11, byte[] r12, long r13, long r14) {
        r10.a(r13, r14);
        long r15 = 0;
    L4:
        if (r15 >= r14) goto L10;
        int r16 = r10.read(r12, 0, (int) Math.min(r14 - r15, r12.length));
        if (r16 <= 0) goto L9;
        r11.update(r12, 0, r16);
        r15 = r15 + ((long) r16);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r16 + ", readTotalCount = " + r15 + ", sampleSize = " + r14);
    }
}
