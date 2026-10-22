package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5520b = null;
    public static final String c = null;

    static {
        f5519a = fx.c("SYmFja3Vwcw");
        f5520b = fx.c("SLmFkaXU");
        c = fx.c("JIw");
    }

    private static String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 8) goto L6;
        File r1 = r4.getExternalCacheDir();     // Catch: Exception -> L13
    L7:
        if (r1 != null) goto L9;
        r1 = r4.getCacheDir();     // Catch: Exception -> L13
    L9:
        if (r1 == null) goto L12;
        return r1.getAbsolutePath();
    L6:
        r1 = null;
    L12:
        return null;
    }

    public static synchronized void a(Context r3, String r4, String r5) {
        monitor-enter(f.class);
        String r6 = a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r6) == false) goto L8;
        monitor-exit(f.class);
        return;
    L8:
        String r7 = r4 + c + r5;     // Catch: Throwable -> L36
        File r8 = new File(r6 + File.separator + f5519a);     // Catch: Throwable -> L36
        File r9 = new File(r8, f5520b);     // Catch: Throwable -> L36
        FileLock r1 = null;
    L28:
        FileChannel r10 = null;
        RandomAccessFile r11 = null;
    L29:
        if (r1 != null) goto L55;
    L31:
        if (r10 != null) goto L46;
    L33:
        a(r11);     // Catch: Throwable -> L36
        monitor-exit(f.class);
        return;
    L46:
        r10.close();     // Catch: IOException -> L43 Throwable -> L36
        goto L33
    L55:
        r1.release();     // Catch: IOException -> L42 Throwable -> L36
        goto L31
    L11:
        if (r8.exists() == true) goto L13;
    L14:
        r8.mkdirs();     // Catch: Throwable -> L28
    L15:
        r9.createNewFile();     // Catch: Throwable -> L28
        r11 = new RandomAccessFile(r9, "rws");     // Catch: Throwable -> L28
        r10 = r11.getChannel();     // Catch: Throwable -> L27
        r1 = r10.tryLock();     // Catch: Throwable -> L41
        if (r1 == null) goto L20;
        r10.write(ByteBuffer.wrap(r7.getBytes(RpcUtils.CHARSET_UTF8)));     // Catch: Throwable -> L41
    L20:
        if (r1 != null) goto L57;
    L22:
        if (r10 != null) goto L53;
    L24:
        a(r11);     // Catch: Throwable -> L36
        monitor-exit(f.class);
        return;
    L53:
        r10.close();     // Catch: IOException -> L40 Throwable -> L36
        goto L24
    L57:
        r1.release();     // Catch: IOException -> L39 Throwable -> L36
    L27:
        r10 = null;
        goto L29
    L13:
        if (r8.isDirectory() == false) goto L15;
    L36:
        th = move-exception;
        throw th;
    }

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
