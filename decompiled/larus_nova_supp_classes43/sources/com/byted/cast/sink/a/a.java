package com.byted.cast.sink.a;

import android.content.Context;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.PreferenceUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {
    private static final Random a = null;
    private static int b;

    static {
        a = new Random(System.currentTimeMillis());
        b = -1;
    }

    private static int a(int r1, int r10) {
        Random r0 = a;
        return r0.nextInt(r10 - r1) + r1;
    }

    private static int a(Context r10, CastLogger r11) {
        int r12 = b;     // Catch: Exception -> L11
        if (r12 != (-1)) goto L7;
        r12 = CastIntegerProtector.parseInt(PreferenceUtils.getValue(r10, "bytelink_avail_port", "-1"));     // Catch: Exception -> L11
    L7:
        if (a(r12) == false) goto L9;
        b = r12;     // Catch: Exception -> L11
    L13:
        r11.i("SocketUtils", "getDiskAvailablePort:" + b);
        return b;
    L9:
        b = -1;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r11.w("SocketUtils", "getDiskAvailablePort:" + e);
        b = -1;
        goto L13
    }

    public static int a(ContextManager.CastContext r10, Context r11) {
        return a(r10, r11, 49152, 65535);
    }

    public static int a(ContextManager.CastContext r10, Context r11, int r12, int r13) {
        CastLogger r14 = ContextManager.getLogger(r10);
        if (r12 < 49152) goto L16;
        if (r13 < r12) goto L16;
        if (r13 > 65535) goto L16;
        int r0 = a(r11, r14);
        if (r0 <= 0) goto L11;
        return r0;
    L11:
        int r1 = a(r12, r13);
        if (a(r1) == false) goto L11;
        r14.i("SocketUtils", "findAvailablePort:" + r1);
        a(r11, r1);
        return r1;
    L16:
        r14.w("SocketUtils", "findAvailablePort, wrong socket range, min:" + r12 + ", max:" + r13);
        return -1;
    }

    private static void a(Context r1, int r10) {
        b = r10;
        PreferenceUtils.setValue(r1, "bytelink_avail_port", Integer.toString(r10));
    }

    public static boolean a(int r1) {
        return a(r1, null);
    }

    public static boolean a(int r10, InetAddress r11) {
        if (r10 < 49152) goto L37;
        if (r10 > 65535) goto L37;
        DatagramSocket r0 = null;
        if (r11 == null) goto L9;
        ServerSocket r1 = new ServerSocket(r10, 50, r11);     // Catch: Throwable -> L22 IOException -> L29
    L10:
        r1.setReuseAddress(true);     // Catch: Throwable -> L19 IOException -> L21
        if (r11 == null) goto L14;
        r0 = new DatagramSocket(r10, r11);     // Catch: Throwable -> L19 IOException -> L21
    L15:
        r0.setReuseAddress(true);     // Catch: Throwable -> L19 IOException -> L21
        r0.close();
        r1.close();     // Catch: IOException -> L38
    L18:
        return true;
        goto L30
    L14:
        r0 = new DatagramSocket(r10);     // Catch: Throwable -> L19 IOException -> L21
    L19:
        th = th;
    L24:
        if (r0 == null) goto L26;
        r0.close();
    L26:
        if (r1 != null) goto L41;
    L28:
        throw th;
    L41:
        r1.close();     // Catch: IOException -> L39
    L30:
        if (r0 == null) goto L32;
        r0.close();
    L32:
        if (r1 == null) goto L51;
        r1.close();     // Catch: IOException -> L40
        return false;
    L52:
        return false;
    L51:
        return false;
    L9:
        r1 = new ServerSocket(r10);     // Catch: Throwable -> L22 IOException -> L29
    L29:
        r1 = null;
    L22:
        th = th;
        r1 = null;
    L37:
        throw new IllegalArgumentException("Invalid start minPort: " + r10);
    }
}
