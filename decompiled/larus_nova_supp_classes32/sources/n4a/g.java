package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    static {
        a = f5.o("SYmFja3Vwcw");
        b = f5.o("SLmFkaXU");
        c = f5.o("JIw");
    }

    public static synchronized void a(Context r3, String r4, String r5) {
        monitor-enter(g.class);
        FileLock r1 = null;
        File r2 = r3.getExternalCacheDir();     // Catch: Throwable -> L11 Exception -> L56
        if (r2 != null) goto L8;
        r2 = r3.getCacheDir();     // Catch: Throwable -> L11 Exception -> L56
    L8:
        if (r2 == null) goto L13;
        String r6 = r2.getAbsolutePath();     // Catch: Throwable -> L11 Exception -> L56
    L15:
        if (TextUtils.isEmpty(r6) == false) goto L18;
        monitor-exit(g.class);
        return;
    L18:
        String r7 = r4 + c + r5;     // Catch: Throwable -> L11
        PolarisFileWrapper r8 = new PolarisFileWrapper(r6 + File.separator + a);     // Catch: Throwable -> L11
        PolarisFileWrapper r9 = new PolarisFileWrapper(r8, b);     // Catch: Throwable -> L11
    L38:
        FileChannel r10 = null;
        RandomAccessFile r11 = null;
    L39:
        if (r1 != null) goto L62;
    L43:
        if (r10 != null) goto L57;
    L45:
        if (r11 != null) goto L75;
    L47:
        monitor-exit(g.class);
        return;
    L75:
        r11.close();     // Catch: Throwable -> L55
        goto L47
    L57:
        r10.close();     // Catch: Throwable -> L11 IOException -> L54
        goto L45
    L62:
        r1.release();     // Catch: Throwable -> L11 IOException -> L42
        goto L43
    L20:
        if (r8.exists() == true) goto L22;
    L23:
        r8.mkdirs();     // Catch: Throwable -> L38
    L24:
        r9.createNewFile();     // Catch: Throwable -> L38
        r11 = new RandomAccessFile(r9, "rws");     // Catch: Throwable -> L38
        r10 = r11.getChannel();     // Catch: Throwable -> L37
        r1 = r10.tryLock();     // Catch: Throwable -> L30
        if (r1 == null) goto L31;
        r10.write(ByteBuffer.wrap(r7.getBytes("UTF-8")));     // Catch: Throwable -> L30
    L31:
        if (r1 != null) goto L71;
    L69:
        r10.close();     // Catch: Throwable -> L11 IOException -> L52
    L59:
        r11.close();     // Catch: Throwable -> L53
    L35:
        monitor-exit(g.class);
        return;
    L71:
        r1.release();     // Catch: Throwable -> L11 IOException -> L51
    L37:
        r10 = null;
        goto L39
    L22:
        if (r8.isDirectory() == false) goto L24;
    L11:
        th = move-exception;
        throw th;
    L13:
        r6 = null;
        goto L15
    }
}
