package h7;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import w6.e;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f7920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f7921b;

    public static void a(int r8, byte[] r10) {
        if (r8 <= 0) goto L7;
        byte[] r11 = {-99, -114, 127, 90};
        int r12 = 0;
    L5:
        if (r12 >= r8) goto L9;
        r10[r12] = (byte) (r10[r12] ^ r11[r12 % 4]);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public static byte[] b(boolean r11, int r12, InputStream r13, int[] r14, RetrofitMetrics r15) {
        if (r12 > 0) goto L6;
        r12 = 5242880;
    L6:
        if (r12 >= 1048576) goto L9;
        r12 = 1048576;
    L9:
        if (r13 != null) goto L80;
        return null;
    L80:
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L77
        if (r11 == false) goto L14;
        r13 = new GZIPInputStream(r13);     // Catch: Throwable -> L77
    L15:
        int r10 = f7920a;     // Catch: Throwable -> L77
        boolean r16 = true;
        if (r10 < 4096) goto L19;
        if (r10 > 5242880) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
        int r18 = f7920a;     // Catch: Throwable -> L77
    L23:
        int r19 = f7921b;     // Catch: Throwable -> L77
        if (r19 < 4096) goto L27;
        if (r19 > 5242880) goto L27;
    L28:
        if (r16 == false) goto L30;
        int r20 = f7921b;     // Catch: Throwable -> L77
    L31:
        byte[] r21 = new byte[r18];     // Catch: Throwable -> L77
        int r22 = 0;
    L81:
    L52:
        e = move-exception;
        String r23 = e.getMessage();     // Catch: Throwable -> L77
        if (r11 == false) goto L62;
        if (r22 <= 0) goto L62;
        if ("CRC mismatch".equals(r23) == false) goto L59;
    L60:
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L77
        r110.append("ungzip got exception ");     // Catch: Throwable -> L77
        r110.append(e);     // Catch: Throwable -> L77
    L67:
        Logger.w("c", r110.toString());     // Catch: Throwable -> L77
    L68:
        if (r22 <= 0) goto L74;
        if (r15 == null) goto L71;
        r15.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r8));     // Catch: Throwable -> L77
        r15.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r22));     // Catch: Throwable -> L77
    L71:
        r14[0] = r22;     // Catch: Throwable -> L77
        c(r13);
        return r21;
    L74:
        c(r13);
        return null;
    L59:
        if ("Size mismatch".equals(r23) == true) goto L60;
    L62:
        throw e;     // Catch: Throwable -> L77
    L63:
        e = move-exception;
        if (r11 == false) goto L76;
        if (r22 <= 0) goto L76;
        r110 = new StringBuilder();     // Catch: Throwable -> L77
        r110.append("ungzip got exception ");     // Catch: Throwable -> L77
        r110.append(e);     // Catch: Throwable -> L77
    L76:
        throw e;     // Catch: Throwable -> L77
    L48:
        e = move-exception;
        Logger.e("c", "new buff error" + e);     // Catch: Throwable -> L77
        c(r13);
        return null;
    L35:
        if ((r22 + 4096) > r21.length) goto L37;
    L41:
        int r24 = r13.read(r21, r22, r21.length - r22);     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        if (r24 <= 0) goto L68;
        r22 = r22 + r24;     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        if (r22 <= r12) goto L81;
        Logger.w("c", "entity length did exceed given maxLength");     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        throw new l7.b(r12, r22);     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
    L37:
        if (r21.length >= r20) goto L39;
        int r25 = r21.length + r20;     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
    L40:
        byte[] r26 = new byte[r25];     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        System.arraycopy(r21, 0, r26, 0, r22);     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        r21 = r26;
        goto L41
    L39:
        r25 = r21.length * 2;     // Catch: OutOfMemoryError -> L48 IOException -> L52 EOFException -> L63 Throwable -> L77
        goto L40
    L30:
        r20 = 102400;
    L27:
        r16 = false;
        goto L28
    L22:
        r18 = 32768;
    L19:
        r17 = false;
        goto L20
    L14:
        e.d r27 = e.f13020a;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        c(r13);
        throw th;
    }

    public static void c(Closeable r8) {
        if (r8 == null) goto L9;
        r8.close();     // Catch: Exception -> L5
        return;
    L5:
        Logger.debug();
        return;
    }

    public static boolean d(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        int r10 = r8.indexOf("application/octet-stream");
        if (r10 < 0) goto L8;
        r10 = r8.indexOf("ssmix=", r10 + 24);
    L8:
        if (r10 <= 0) goto L11;
        return true;
    L11:
        return false;
    }
}
