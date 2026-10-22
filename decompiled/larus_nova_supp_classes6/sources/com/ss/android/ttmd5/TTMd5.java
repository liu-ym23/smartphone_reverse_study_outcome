package com.ss.android.ttmd5;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import lgc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = null;
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    public static class a {
        public int a;
        public int b;
        public int c;
        public long d;
        public String e;

        public a() {
        }
    }

    public TTMd5() {
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static long decryptNum(String r4) throws RuntimeException {
        return (CastLongProtector.parseLong(r4, 16) - 31) >> 4;
    L7:
        throw new RuntimeException("ttmd5 decryptNum error, num = " + r4);
    }

    private static String encryptionNum(long r2) {
        return Long.toHexString((r2 << 4) + 31);
    }

    public static String md5(File r3) {
        return ttmd5(r3, -1, -1);
    }

    private static a parserTTMd5Args(String r6) throws Exception {
        if (r6.startsWith("ttmd5:") == true) goto L6;
        return null;
    L6:
        String[] r7 = r6.split(";");
        String[] r1 = r7[0].split(":");
        a r2 = new a();
        int r4 = CastIntegerProtector.parseInt(r1[1]);
        r2.a = r4;
        if (r4 <= 1) goto L9;
        return r2;
    L9:
        r2.b = CastIntegerProtector.parseInt(r1[2]);
        String[] r3 = r1[3].split("g");
        r2.c = (int) decryptNum(r3[0]);
        r2.d = decryptNum(r3[1]);
        r2.e = r7[1];
        return r2;
    }

    private static String toHexString(byte[] r10) {
        if (r10 == null) goto L9;
        int r0 = r10.length;
        int r1 = r0 * 2;
        char[] r2 = new char[r1];
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= r0) goto L7;
        int r6 = r10[r4 + 0] & 255;
        int r7 = r5 + 1;
        char[] r8 = HEX_CHARS;
        r2[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r2[r7] = r8[r6 & 15];
        r4 = r4 + 1;
        goto L4
    L7:
        return new String(r2, 0, r1);
    L9:
        throw new NullPointerException("bytes is null");
    }

    public static String ttmd5(File r3) {
        return ttmd5(r3, 9, 8192);
    }

    public static String ttmd5(b r3) {
        return ttmd5(r3, 9, 8192);
    }

    public static int checkMd5(File r4, File r5) {
        if (r4 == null) goto L20;
        if (r5 == null) goto L24;
    L17:
        th = move-exception;
        th.printStackTrace();
        return 99;
    L5:
        if (r4.exists() == true) goto L7;
        return 5;
    L7:
        if (r5.exists() == true) goto L10;
        return 5;
    L10:
        if (r4 != r5) goto L12;
        return 0;
    L12:
        if (_ttmd5(r4, 9, 8192).equals(_ttmd5(r5, 9, 8192)) == false) goto L15;
        return 0;
    L15:
        return 1;
    L24:
        return 5;
    L20:
        return 5;
    }

    private static String generateTTMd5Tag(int r3, long r4) {
        return "ttmd5:1:1:" + encryptionNum(r3) + "g" + encryptionNum(r4);
    }

    public static String ttmd5(File r2, int r3) {
        return ttmd5(r2, r3, 8192);
    }

    public static int checkMd5(String r1, File r2) {
        return checkMd5(r1, r2, null);
    }

    public static String ttmd5(b r2, int r3) {
        return ttmd5(r2, r3, 8192);
    }

    private static String _ttmd5(b r22, int r23, long r24) throws Exception {
        int r0 = r23;
        MessageDigest r1 = MessageDigest.getInstance("MD5");
        if (r1 != null) goto L41;
        return "";
    L41:
        lgc.a r9 = (lgc.a) r22;     // Catch: Throwable -> L31
        long r10 = r9.a.length();     // Catch: Throwable -> L31
        if (r0 > 0) goto L9;
    L14:
        long r13 = r10;
        r0 = 1;
    L15:
        byte[] r15 = new byte[DEFAULT_SAMPLE_SIZE];     // Catch: Throwable -> L31
        long r16 = 0;
        updateSample(r9, r1, r15, 0, r13);     // Catch: Throwable -> L31
        if (r0 <= 2) goto L20;
        int r7 = r0 - 1;     // Catch: Throwable -> L31
        long r18 = (r10 - (((long) r0) * r13)) / ((long) r7);     // Catch: Throwable -> L31
        int r8 = 1;
    L18:
        if (r8 >= r7) goto L20;
        r16 = r16 + (r13 + r18);     // Catch: Throwable -> L31
        updateSample(r9, r1, r15, r16, r13);     // Catch: Throwable -> L31
        r8 = r8 + 1;     // Catch: Throwable -> L31
        r7 = r7;
    L20:
        if (r0 <= 1) goto L22;
        updateSample(r9, r1, r15, r10 - r13, r13);     // Catch: Throwable -> L31
    L22:
        String r2 = toHexString(r1.digest());     // Catch: Throwable -> L31
        if (r0 == 1) goto L25;
    L28:
        String r3 = generateTTMd5Tag(r0, r13) + ";" + r2;     // Catch: Throwable -> L31
        r9.a.close();     // Catch: Throwable -> L35
    L30:
        return r3;
    L25:
        if (r13 != r10) goto L28;
        r9.a.close();     // Catch: Throwable -> L34
    L27:
        return r2;
    L9:
        if (r24 <= 0) goto L14;
        if ((((long) r0) * r24) > ((8 * r10) / 10)) goto L14;
        r13 = r24;
    L31:
        th = move-exception;
        ((lgc.a) r22).a.close();     // Catch: Throwable -> L36
    L33:
        throw th;
    }

    public static int checkMd5(String r7, File r8, b r9) {
        if (r7 != null) goto L4;
        return 2;
    L4:
        if (r7.length() != 0) goto L78;
        return 2;
    L78:
        if (r9 == null) goto L13;
        lgc.a r1 = (lgc.a) r9;     // Catch: Throwable -> L66
        if (r1.a.length() > 0) goto L76;
        r1.a.close();     // Catch: Throwable -> L71
    L12:
        return 5;
    L76:
        a r0 = parserTTMd5Args(r7);     // Catch: Throwable -> L64
        if (r0 != null) goto L21;
        int r2 = -1;
        long r3 = -1;
    L27:
        a r5 = null;
        if (r9 == null) goto L30;
        String r10 = _ttmd5(r9, r2, r3);     // Catch: Throwable -> L32
    L79:
    L34:
        if (r10 != null) goto L36;
        return 6;
    L36:
        if (r10.length() != 0) goto L39;
        return 6;
    L39:
        if (r0 == null) goto L59;
        if (r0.a != 1) goto L46;
        if (r0.b == 1) goto L59;
    L46:
        if (r0.e != null) goto L72;
    L61:
        return 1;
    L72:
        r5 = parserTTMd5Args(r10);     // Catch: Throwable -> L49
    L50:
        if (r5 == null) goto L61;
        if (r0.c != r5.c) goto L61;
        if (r0.d != r5.d) goto L61;
        if (r0.e.equals(r5.e) == false) goto L61;
        return 0;
    L59:
        if (r10.equals(r7) == false) goto L61;
        return 0;
    L30:
        r10 = _ttmd5(r8, r2, r3);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
        r10 = null;
        goto L34
    L21:
        if (r0.a <= 1) goto L24;
        return 3;
    L24:
        r2 = r0.c;     // Catch: Throwable -> L66
        r3 = r0.d;     // Catch: Throwable -> L66
    L64:
        return 4;
    L13:
        if (r8 != null) goto L15;
    L68:
        return 5;
    L15:
        if (r8.exists() == true) goto L76;
    L66:
        return 99;
    }

    public static String ttmd5(File r2, int r3, long r4) {
        if (r2 != null) goto L12;
    L11:
        return "";
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    L5:
        if (r2.exists() == false) goto L11;
        return _ttmd5(r2, r3, r4);
    }

    private static String _ttmd5(File r1, int r2, long r3) throws Exception {
        return _ttmd5(new lgc.a(r1), r2, r3);
    }

    public static String ttmd5(b r1, int r2, long r3) {
        if (r1 != null) goto L10;
        return "";
    L10:
        return _ttmd5(r1, r2, r3);
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static void updateSample(b r4, MessageDigest r5, byte[] r6, long r7, long r9) throws IOException {
        ((lgc.a) r4).a.seek(r7);
        long r8 = 0;
    L4:
        if (r8 >= r9) goto L10;
        int r0 = ((lgc.a) r4).a.read(r6, 0, (int) Math.min(r9 - r8, r6.length));
        if (r0 <= 0) goto L9;
        r5.update(r6, 0, r0);
        r8 = r8 + ((long) r0);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r0 + ", readTotalCount = " + r8 + ", sampleSize = " + r9);
    }
}
