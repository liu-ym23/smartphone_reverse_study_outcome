package qa;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10388c = null;

    static {
        f10386a = t4.n("SYmFja3Vwcw");
        f10387b = t4.n("SLmFkaXU");
        f10388c = t4.n("JIw");
    }

    public static synchronized void a(Context r8, String r10, String r11) {
        monitor-enter(f.class);
        FileLock r12 = null;
        File r13 = r8.getExternalCacheDir();     // Catch: Throwable -> L11 Exception -> L54
        if (r13 != null) goto L8;
        r13 = r8.getCacheDir();     // Catch: Throwable -> L11 Exception -> L54
    L8:
        if (r13 == null) goto L13;
        String r14 = r13.getAbsolutePath();     // Catch: Throwable -> L11 Exception -> L54
    L15:
        if (TextUtils.isEmpty(r14) == false) goto L18;
        monitor-exit(f.class);
        return;
    L18:
        String r15 = r10 + f10388c + r11;     // Catch: Throwable -> L11
        File r16 = new File(r14 + File.separator + f10386a);     // Catch: Throwable -> L11
        File r17 = new File(r16, f10387b);     // Catch: Throwable -> L11
    L36:
        FileChannel r18 = null;
        RandomAccessFile r19 = null;
    L37:
        if (r12 != null) goto L71;
    L39:
        if (r18 != null) goto L67;
    L41:
        if (r19 != null) goto L62;
    L43:
        monitor-exit(f.class);
        return;
    L62:
        r19.close();     // Catch: Throwable -> L53
        goto L43
    L67:
        r18.close();     // Catch: Throwable -> L11 IOException -> L52
        goto L41
    L71:
        r12.release();     // Catch: Throwable -> L11 IOException -> L51
        goto L39
    L20:
        if (r16.exists() == true) goto L22;
    L23:
        r16.mkdirs();     // Catch: Throwable -> L36
    L24:
        r17.createNewFile();     // Catch: Throwable -> L36
        r19 = new RandomAccessFile(r17, "rws");     // Catch: Throwable -> L36
        r18 = r19.getChannel();     // Catch: Throwable -> L35
        r12 = r18.tryLock();     // Catch: Throwable -> L50
        if (r12 == null) goto L29;
        r18.write(ByteBuffer.wrap(r15.getBytes("UTF-8")));     // Catch: Throwable -> L50
    L29:
        if (r12 != null) goto L73;
    L69:
        r18.close();     // Catch: Throwable -> L11 IOException -> L48
    L55:
        r19.close();     // Catch: Throwable -> L49
    L33:
        monitor-exit(f.class);
        return;
    L73:
        r12.release();     // Catch: Throwable -> L11 IOException -> L47
    L35:
        r18 = null;
        goto L37
    L22:
        if (r16.isDirectory() == false) goto L24;
    L11:
        th = move-exception;
        throw th;
    L13:
        r14 = null;
        goto L15
    }
}
