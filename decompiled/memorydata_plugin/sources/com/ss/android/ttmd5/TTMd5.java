package com.ss.android.ttmd5;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.crypto.utils.CryptoConst;
import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = null;
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    /* JADX INFO: renamed from: com.ss.android.ttmd5.TTMd5$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15731b;
        private int c;
        private long d;
        private String e;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(a r0) {
            return r0.f15730a;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.f15730a = r1;
            return r1;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ String a(a r0, String r1) {
            r0.e = r1;
            return r1;
        }

        static /* synthetic */ int b(a r0) {
            return r0.c;
        }

        static /* synthetic */ int b(a r0, int r1) {
            r0.f15731b = r1;
            return r1;
        }

        static /* synthetic */ int c(a r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ long c(a r2) {
            return r2.d;
        }

        static /* synthetic */ int d(a r0) {
            return r0.f15731b;
        }

        static /* synthetic */ String e(a r0) {
            return r0.e;
        }
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public TTMd5() {
    }

    private static String _ttmd5(b r22, int r23, long r24) {
        int r0 = r23;
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r22, b.class, "com.obric.memorydata.plugin");
        MessageDigest r9 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        if (r9 != null) goto L41;
        return "";
    L41:
        long r10 = r1.a();     // Catch: Throwable -> L31
        if (r0 > 0) goto L9;
    L14:
        long r13 = r10;
        r0 = 1;
    L15:
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L31
        long r16 = 0;
        updateSample(r1, r9, r15, 0, r13);     // Catch: Throwable -> L31
        if (r0 <= 2) goto L20;
        int r7 = r0 - 1;     // Catch: Throwable -> L31
        long r18 = (r10 - (((long) r0) * r13)) / ((long) r7);     // Catch: Throwable -> L31
        int r8 = 1;
    L18:
        if (r8 >= r7) goto L20;
        r16 = r16 + (r13 + r18);     // Catch: Throwable -> L31
        updateSample(r1, r9, r15, r16, r13);     // Catch: Throwable -> L31
        r8 = r8 + 1;     // Catch: Throwable -> L31
        r7 = r7;
    L20:
        if (r0 <= 1) goto L22;
        updateSample(r1, r9, r15, r10 - r13, r13);     // Catch: Throwable -> L31
    L22:
        String r2 = toHexString(r9.digest());     // Catch: Throwable -> L31
        if (r0 == 1) goto L25;
    L28:
        String r3 = generateTTMd5Tag(r0, r13) + ";" + r2;     // Catch: Throwable -> L31
        r1.b();     // Catch: Throwable -> L35
    L30:
        return r3;
    L25:
        if (r13 != r10) goto L28;
        r1.b();     // Catch: Throwable -> L34
    L27:
        return r2;
    L9:
        if (r24 <= 0) goto L14;
        if ((((long) r0) * r24) > ((8 * r10) / 10)) goto L14;
        r13 = r24;
    L31:
        th = move-exception;
        r1.b();     // Catch: Throwable -> L36
    L33:
        throw th;
    }

    private static String _ttmd5(File r1, int r2, long r3) {
        return _ttmd5(new com.ss.android.ttmd5.a(r1), r2, r3);
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
        if (_ttmd5(r4, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI).equals(_ttmd5(r5, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) == false) goto L15;
        return 0;
    L15:
        return 1;
    L24:
        return 5;
    L20:
        return 5;
    }

    public static int checkMd5(String r1, File r2) {
        return checkMd5(r1, r2, null);
    }

    public static int checkMd5(String r6, File r7, b r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return 2;
    L5:
        if (r6.length() != 0) goto L71;
        return 2;
    L71:
        if (r9 != null) goto L11;
        if (r7 != null) goto L16;
    L66:
        return 5;
    L16:
        if (r7.exists() == false) goto L66;
    L18:
        int r0 = -1;
        long r1 = -1;
        a r3 = parserTTMd5Args(r6);     // Catch: Throwable -> L62
        if (r3 != null) goto L23;
    L27:
        a r5 = null;
        if (r9 == null) goto L30;
        String r10 = _ttmd5(r9, r0, r1);     // Catch: Throwable -> L32
    L74:
    L34:
        if (r10 != null) goto L36;
        return 6;
    L36:
        if (r10.length() != 0) goto L39;
        return 6;
    L39:
        if (r3 == null) goto L57;
        if (a.a(r3) != 1) goto L46;
        if (a.d(r3) == 1) goto L57;
    L46:
        if (a.e(r3) != null) goto L77;
    L59:
        return 1;
    L77:
        r5 = parserTTMd5Args(r10);     // Catch: Throwable -> L69
    L48:
        if (r5 == null) goto L59;
        if (a.b(r3) != a.b(r5)) goto L59;
        if (a.c(r3) != a.c(r5)) goto L59;
        if (a.e(r3).equals(a.e(r5)) == false) goto L59;
        return 0;
    L57:
        if (r10.equals(r6) == false) goto L59;
        return 0;
    L30:
        r10 = _ttmd5(r7, r0, r1);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        r10 = null;
        goto L34
    L23:
        if (a.a(r3) <= 1) goto L26;
        return 3;
    L26:
        r0 = a.b(r3);     // Catch: Throwable -> L64
        r1 = a.c(r3);     // Catch: Throwable -> L64
    L62:
        return 4;
    L11:
        if (r9.a() > 0) goto L18;
        r9.b();     // Catch: Throwable -> L70
    L13:
        return 5;
    L64:
        return 99;
    }

    private static long decryptNum(String r4) {
        return (Long.parseLong(r4, 16) - 31) >> 4;
    L7:
        throw new RuntimeException("ttmd5 decryptNum error, num = " + r4);
    }

    private static String encryptionNum(long r2) {
        return Long.toHexString((r2 << 4) + 31);
    }

    private static String generateTTMd5Tag(int r3, long r4) {
        return "ttmd5:1:1:" + encryptionNum(r3) + o.f + encryptionNum(r4);
    }

    public static String md5(File r3) {
        return ttmd5(r3, -1, -1);
    }

    private static a parserTTMd5Args(String r6) {
        AnonymousClass1 r1 = null;
        if (r6.startsWith("ttmd5:") == true) goto L5;
        return null;
    L5:
        String[] r7 = r6.split(";");
        String[] r2 = r7[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        a r3 = new a(r1);
        a.a(r3, Integer.parseInt(r2[1]));
        if (a.a(r3) <= 1) goto L8;
        return r3;
    L8:
        a.b(r3, Integer.parseInt(r2[2]));
        String[] r4 = r2[3].split(o.f);
        a.c(r3, (int) decryptNum(r4[0]));
        a.a(r3, decryptNum(r4[1]));
        a.a(r3, r7[1]);
        return r3;
    }

    private static String toHexString(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        int r0 = r10.length;
        int r1 = r0 * 2;
        char[] r2 = new char[r1];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L6;
        int r6 = r10[r4 + 0] & 255;
        int r7 = r5 + 1;
        char[] r8 = HEX_CHARS;
        r2[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r2[r7] = r8[r6 & 15];
        r4 = r4 + 1;
        goto L3
    L6:
        return new String(r2, 0, r1);
    }

    public static String ttmd5(b r3) {
        return ttmd5((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"), 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(b r2, int r3) {
        return ttmd5((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin"), r3, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(b r2, int r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        return "";
    L10:
        return _ttmd5(r5, r3, r4);
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String ttmd5(File r3) {
        return ttmd5(r3, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(File r2, int r3) {
        return ttmd5(r2, r3, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
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

    private static void updateSample(b r4, MessageDigest r5, byte[] r6, long r7, long r9) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        r8.a(r7, r9);
        long r10 = 0;
    L4:
        if (r10 >= r9) goto L10;
        int r0 = r8.a(r6, 0, (int) Math.min(r9 - r10, r6.length));
        if (r0 <= 0) goto L9;
        r5.update(r6, 0, r0);
        r10 = r10 + ((long) r0);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r0 + ", readTotalCount = " + r10 + ", sampleSize = " + r9);
    }
}
