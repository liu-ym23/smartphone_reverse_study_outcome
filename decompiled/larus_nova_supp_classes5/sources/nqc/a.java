package nqc;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static String a = "";

    public static ByteBuffer b(PolarisFileWrapper r9) throws Exception {
        RandomAccessFile r0 = null;
        Pair<ByteBuffer, Long> r1 = null;
        RandomAccessFile r2 = new RandomAccessFile(r9, DownloadFileUtils.MODE_READ);     // Catch: Throwable -> L28
        boolean r10 = false;
        if (r2.length() < 22) goto L11;
        r1 = b.b(r2, 0);     // Catch: Throwable -> L26
        if (r1 != null) goto L11;
        r1 = b.b(r2, 65535);     // Catch: Throwable -> L26
    L11:
        if (r1 == null) goto L25;
        ByteBuffer r3 = (ByteBuffer) r1.first;     // Catch: Throwable -> L26
        long r4 = ((Long) r1.second).longValue();     // Catch: Throwable -> L26
        long r5 = r4 - 20;     // Catch: Throwable -> L26
        if (r5 < 0) goto L18;
        r2.seek(r5);     // Catch: Throwable -> L26
        if (r2.readInt() != 1347094023) goto L18;
        r10 = true;
    L18:
        if (r10 == true) goto L23;
        ByteBuffer r11 = (ByteBuffer) a(r2, c(r3, r4)).first;     // Catch: Throwable -> L26
        r2.close();
        return r11;
    L23:
        throw new Exception("ZIP64 APK not supported");     // Catch: Throwable -> L26
    L25:
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");     // Catch: Throwable -> L26
    L26:
        th = th;
        r0 = r2;
    L29:
        if (r0 == null) goto L31;
        r0.close();
    L31:
        throw th;
    L28:
        th = th;
        goto L29
    }

    public static boolean d(ByteBuffer r11) throws Exception {
        if (r11.order() != ByteOrder.LITTLE_ENDIAN) goto L45;
        int r0 = r11.capacity() - 24;
        if (r0 < 8) goto L43;
        int r2 = r11.capacity();
        if (r0 > r11.capacity()) goto L41;
        int r3 = r11.limit();
        int r4 = r11.position();
        r11.position(0);     // Catch: Throwable -> L37
        r11.limit(r0);     // Catch: Throwable -> L37
        r11.position(8);     // Catch: Throwable -> L37
        ByteBuffer r1 = r11.slice();     // Catch: Throwable -> L37
        r1.order(r11.order());     // Catch: Throwable -> L37
        r11.position(0);
        r11.limit(r3);
        r11.position(r4);
        int r12 = 0;
    L12:
        if (r1.hasRemaining() == false) goto L36;
        r12 = r12 + 1;
        if (r1.remaining() < 8) goto L35;
        long r5 = r1.getLong();
        if (r5 < 4) goto L33;
        if (r5 > 2147483647L) goto L33;
        int r6 = (int) r5;
        int r7 = r1.position() + r6;
        if (r6 > r1.remaining()) goto L31;
        int r8 = r1.getInt();
        if (r8 == (-262969152)) goto L23;
        if (r8 == 1896449818) goto L27;
        r1.position(r7);
        goto L12
    L27:
        a = "V2";
        return true;
    L23:
        a = "V3";
        return true;
    L31:
        throw new Exception("APK Signing Block entry #" + r12 + " size out of range: " + r6 + ", available: " + r1.remaining());
    L33:
        throw new Exception("APK Signing Block entry #" + r12 + " size out of range: " + r5);
    L35:
        throw new Exception("Insufficient data to read size of APK Signing Block entry #" + r12);
    L36:
        return false;
    L37:
        th = move-exception;
        r11.position(0);
        r11.limit(r3);
        r11.position(r4);
        throw th;
    L41:
        throw new IllegalArgumentException("end > capacity: " + r0 + " > " + r2);
    L43:
        throw new IllegalArgumentException("end < start: " + r0 + " < 8");
    L45:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile r8, long r9) throws Exception {
        if (r9 < 32) goto L27;
        ByteBuffer r0 = ByteBuffer.allocate(24);
        ByteOrder r1 = ByteOrder.LITTLE_ENDIAN;
        r0.order(r1);
        r8.seek(r9 - ((long) r0.capacity()));
        r8.readFully(r0.array(), r0.arrayOffset(), r0.capacity());
        if (r0.getLong(8) != 2334950737559900225L) goto L25;
        if (r0.getLong(16) != 3617552046287187010L) goto L25;
        long r3 = r0.getLong(0);
        if (r3 < r0.capacity()) goto L23;
        if (r3 > 2147483639) goto L23;
        int r2 = (int) (8 + r3);
        long r10 = r9 - ((long) r2);
        if (r10 < 0) goto L21;
        ByteBuffer r4 = ByteBuffer.allocate(r2);
        r4.order(r1);
        r8.seek(r10);
        r8.readFully(r4.array(), r4.arrayOffset(), r4.capacity());
        long r5 = r4.getLong(0);
        if (r5 != r3) goto L19;
        return Pair.create(r4, Long.valueOf(r10));
    L19:
        throw new Exception("APK Signing Block sizes in header and footer do not match: " + r5 + " vs " + r3);
    L21:
        throw new Exception("APK Signing Block offset out of range: " + r10);
    L23:
        throw new Exception("APK Signing Block size out of range: " + r3);
    L25:
        throw new Exception("No APK Signing Block before ZIP Central Directory");
    L27:
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: " + r9);
    }

    public static long c(ByteBuffer r6, long r7) throws Exception {
        b.a(r6);
        long r0 = ((long) r6.getInt(r6.position() + 16)) & 4294967295L;
        if (r0 > r7) goto L10;
        b.a(r6);
        if (((4294967295L & ((long) r6.getInt(r6.position() + 12))) + r0) != r7) goto L8;
        return r0;
    L8:
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    L10:
        throw new Exception("ZIP Central Directory offset out of range: " + r0 + ". ZIP End of Central Directory offset: " + r7);
    }
}
