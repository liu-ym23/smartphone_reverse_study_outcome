package com.ss.android.socialbase.downloader.md5;

import com.ss.android.socialbase.downloader.utils.DownloadFileRandomAccess;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import kotlin.UByte;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TTMd5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f15795a = null;

    public static class FileRandomAccess implements IRandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RandomAccessFile f15796a;

        public FileRandomAccess(File r5) {
            this.f15796a = new RandomAccessFile(r5, "r");
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public final int a(byte[] r5, int r10) {
            return this.f15796a.read(r5, 0, r10);
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public final void close() {
            this.f15796a.close();
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public final long length() {
            return this.f15796a.length();
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public final void a(long r5) {
            this.f15796a.seek(r5);
        }
    }

    public static class TTMd5Args {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15799c;
        public long d;
        public String e;

        public TTMd5Args() {
        }
    }

    static {
        f15795a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(File r5) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    L4:
        if (r5.exists() == true) goto L6;
        return "";
    L6:
        return a(new FileRandomAccess(r5), -1, -1);
    }

    public static int a(String r10, File r11, DownloadFileRandomAccess r12) {
        if (r10 != null) goto L5;
    L67:
        return 2;
    L5:
        if (r10.length() == 0) goto L67;
        if (r12 != null) goto L11;
        if (r11 != null) goto L16;
    L66:
        return 5;
    L16:
        if (r11.exists() == false) goto L66;
    L73:
        TTMd5Args r5 = a(r10);     // Catch: Throwable -> L62
        if (r5 != null) goto L21;
        int r13 = -1;
        long r14 = -1;
    L27:
        TTMd5Args r15 = null;
        if (r12 == null) goto L32;
        String r16 = a(r12, r13, r14);     // Catch: Throwable -> L30
    L70:
    L35:
        if (r16 != null) goto L37;
        return 6;
    L37:
        if (r16.length() == 0) goto L80;
        if (r5 == null) goto L57;
        if (r5.f15797a != 1) goto L46;
        if (r5.f15798b == 1) goto L57;
    L46:
        if (r5.e != null) goto L78;
    L59:
        return 1;
    L78:
        r15 = a(r16);     // Catch: Throwable -> L68
    L48:
        if (r15 == null) goto L59;
        if (r5.f15799c != r15.f15799c) goto L59;
        if (r5.d != r15.d) goto L59;
        if (r5.e.equals(r15.e) == false) goto L59;
        return 0;
    L57:
        if (r16.equals(r10) == false) goto L59;
        return 0;
    L80:
        return 6;
    L32:
        r16 = a(new FileRandomAccess(r11), r13, r14);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        r16 = null;
        goto L35
    L21:
        if (r5.f15797a <= 1) goto L24;
        return 3;
    L24:
        r13 = r5.f15799c;     // Catch: Throwable -> L64
        r14 = r5.d;     // Catch: Throwable -> L64
    L62:
        return 4;
    L11:
        if (r12.f16131b.size() > 0) goto L73;
        DownloadUtils.a(new Closeable[]{r12.f16131b, r12.f16130a});     // Catch: Throwable -> L69
    L13:
        return 5;
    L64:
        return 99;
    }

    public static String a(IRandomAccess r21, int r22, long r23) {
        int r5 = r22;
        MessageDigest r10 = MessageDigest.getInstance("MD5");
        if (r10 != null) goto L52;
        return "";
    L52:
        long r11 = r21.length();     // Catch: Throwable -> L14
        if (r5 > 0) goto L9;
    L16:
        long r12 = r11;
        r5 = 1;
    L17:
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L14
        long r15 = 0;
        a(r21, r10, r14, 0, r12);     // Catch: Throwable -> L14
        if (r5 <= 2) goto L22;
        int r13 = r5 - 1;     // Catch: Throwable -> L14
        long r17 = (r11 - (((long) r5) * r12)) / ((long) r13);     // Catch: Throwable -> L14
        int r16 = 1;
    L20:
        if (r16 >= r13) goto L22;
        r15 = r15 + (r12 + r17);     // Catch: Throwable -> L14
        a(r21, r10, r14, r15, r12);     // Catch: Throwable -> L14
        r16 = r16 + 1;     // Catch: Throwable -> L14
        r13 = r13;
    L22:
        if (r5 <= 1) goto L24;
        a(r21, r10, r14, r11 - r12, r12);     // Catch: Throwable -> L14
    L24:
        byte[] r18 = r10.digest();     // Catch: Throwable -> L14
        if (r18 == null) goto L40;
        int r19 = r18.length;     // Catch: Throwable -> L14
        int r20 = r19 * 2;     // Catch: Throwable -> L14
        char[] r24 = new char[r20];     // Catch: Throwable -> L14
        int r25 = 0;
        int r26 = 0;
    L28:
        if (r25 >= r19) goto L30;
        byte r110 = r18[r25];     // Catch: Throwable -> L14
        int r111 = r110 & UByte.MAX_VALUE;     // Catch: Throwable -> L14
        int r112 = r26 + 1;     // Catch: Throwable -> L14
        char[] r113 = f15795a;     // Catch: Throwable -> L14
        r24[r26] = r113[r111 >> 4];     // Catch: Throwable -> L14
        r26 = r26 + 2;     // Catch: Throwable -> L14
        r24[r112] = r113[r110 & 15];     // Catch: Throwable -> L14
        r25 = r25 + 1;     // Catch: Throwable -> L14
        goto L28
    L30:
        String r27 = new String(r24, 0, r20);     // Catch: Throwable -> L14
        if (r5 == 1) goto L33;
    L36:
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L14
        r28.append("ttmd5:1:1:" + Long.toHexString((((long) r5) << 4) + 31) + "g" + Long.toHexString((r12 << 4) + 31));     // Catch: Throwable -> L14
        r28.append(";");     // Catch: Throwable -> L14
        r28.append(r27);     // Catch: Throwable -> L14
        String r29 = r28.toString();     // Catch: Throwable -> L14
        r21.close();     // Catch: Throwable -> L44
    L38:
        return r29;
    L33:
        if (r12 != r11) goto L36;
        r21.close();     // Catch: Throwable -> L43
    L35:
        return r27;
    L40:
        throw new NullPointerException("bytes is null");     // Catch: Throwable -> L14
    L9:
        if (r23 <= 0) goto L16;
        if ((((long) r5) * r23) > ((8 * r11) / 10)) goto L16;
        r12 = r23;
    L14:
        th = move-exception;
        r21.close();     // Catch: Throwable -> L45
    L42:
        throw th;
    }

    public static void a(IRandomAccess r5, MessageDigest r10, byte[] r11, long r12, long r13) {
        r5.a(r12);
        long r14 = 0;
    L4:
        if (r14 >= r13) goto L10;
        int r15 = r5.a(r11, (int) Math.min(r13 - r14, r11.length));
        if (r15 <= 0) goto L9;
        r10.update(r11, 0, r15);
        r14 = r14 + ((long) r15);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r15 + ", readTotalCount = " + r14 + ", sampleSize = " + r13);
    }

    public static TTMd5Args a(String r10) {
        if (r10.startsWith("ttmd5:") == true) goto L6;
        return null;
    L6:
        String[] r11 = r10.split(";");
        String[] r5 = r11[0].split(":");
        TTMd5Args r12 = new TTMd5Args();
        int r13 = Integer.parseInt(r5[1]);
        r12.f15797a = r13;
        if (r13 <= 1) goto L9;
        return r12;
    L9:
        r12.f15798b = Integer.parseInt(r5[2]);
        String[] r14 = r5[3].split("g");
        String r15 = r14[0];
        r12.f15799c = (int) ((Long.parseLong(r15, 16) - 31) >> 4);
        String r16 = r14[1];
        r12.d = (Long.parseLong(r16, 16) - 31) >> 4;
        r12.e = r11[1];
        return r12;
    L16:
        throw new RuntimeException(d.b("ttmd5 decryptNum error, num = ", r16));
    L18:
        throw new RuntimeException(d.b("ttmd5 decryptNum error, num = ", r15));
    }
}
