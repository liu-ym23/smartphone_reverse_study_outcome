package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f15091a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static LinkedList<File> f15092b = null;
    private static boolean c = false;

    static {
    }

    public n() {
    }

    private static synchronized void a(Context r4) {
        monitor-enter(n.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
    L34:
        monitor-exit(n.class);
        return;
    L6:
        if (f15091a >= 0) goto L10;
        b(r5);     // Catch: Throwable -> L32
    L10:
        if (f15091a >= 500) goto L14;
        monitor-exit(n.class);
        return;
    L14:
        if (f15092b != null) goto L17;
        b(r5);     // Catch: Throwable -> L32
    L17:
        if (f15092b != null) goto L21;
        monitor-exit(n.class);
        return;
    L21:
        if (f15091a <= 500) goto L26;
        if (f15092b.size() <= 0) goto L26;
        ((File) ZeusTransformUtils.preCheckCast(f15092b.removeFirst(), File.class, "com.obric.memorydata.plugin")).delete();     // Catch: Throwable -> L32
        f15091a--;     // Catch: Throwable -> L32
    L26:
        if (f15091a >= 0) goto L29;
        f15091a = -1;     // Catch: Throwable -> L32
    L29:
        if (f15092b.isEmpty() == false) goto L34;
        f15092b = null;     // Catch: Throwable -> L32
    L36:
        th = move-exception;
        throw th;
    }

    public static void a(Context r3, long r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (c == true) goto L6;
        return;
    L6:
        if (Logger.debug() == true) goto L8;
        return;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        if (r4 <= 0) goto L26;
        FileOutputStream r0 = null;
        FileOutputStream r6 = new FileOutputStream(new File(r5.getExternalCacheDir(), "discard_logs.log"), true);     // Catch: Throwable -> L19
        r6.write((r4 + new Date().toString() + "\n").getBytes());     // Catch: Throwable -> L16
        a(r6);
        return;
    L16:
        r0 = r6;
    L17:
        a(r0);
        return;
    }

    public static void a(Context r5, long r6, String r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (c == true) goto L6;
        return;
    L6:
        if (Logger.debug() == true) goto L8;
        return;
    L8:
        if (r7 != null) goto L10;
        return;
    L10:
        if (r6 <= 0) goto L46;
        if (r8 != null) goto L13;
        return;
    L13:
        if (r8.length() > 0) goto L16;
        return;
    L16:
        if (r8.indexOf("item_impression") > 0) goto L18;
        return;
    L18:
        FileOutputStream r0 = null;
        FileOutputStream r9 = new FileOutputStream(new File(r7.getExternalCacheDir(), "log_" + r6 + "_.log"));     // Catch: Throwable -> L38
        r9.write(r8.getBytes());     // Catch: Throwable -> L31
        r9.close();     // Catch: Throwable -> L31
        monitor-enter(n.class);     // Catch: Throwable -> L38
        int r10 = f15091a;     // Catch: Throwable -> L28
        if (r10 < 0) goto L26;
        f15091a = r10 + 1;     // Catch: Throwable -> L28
    L26:
        monitor-exit(n.class);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L31:
        r0 = r9;
    L32:
        a(r0);
        a(r7);
        LinkedList<File> r11 = f15092b;
        if (r11 == null) goto L35;
        int r12 = r11.size();
    L36:
        Logger.d("LogDebugUtil", "logCount: " + f15091a + ", purgeQueueSize: " + r12);
        return;
    L35:
        r12 = -1;
        goto L36
    }

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    private static File[] a(File r2) {
        final Pattern r0 = Pattern.compile("^log_[0-9]+_\\.log$");
        File[] r3 = r2.listFiles(new AnonymousClass1(r0));
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.length <= 0) goto L11;
        Arrays.sort(r3, new AnonymousClass2());
        return r3;
    L11:
        return null;
    }

    private static void b(Context r3) {
        File[] r4 = a(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getExternalCacheDir());
        f15091a = r4.length;
        if (r4.length < 500) goto L9;
        LinkedList<File> r0 = new LinkedList();
        f15092b = r0;
        int r2 = 100;
        if (r4.length > 100) goto L7;
        r2 = r4.length;
    L7:
        r0.addAll(Arrays.asList(r4).subList(0, r2));
        return;
    }
}
