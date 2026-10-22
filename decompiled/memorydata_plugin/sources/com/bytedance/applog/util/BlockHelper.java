package com.bytedance.applog.util;

import android.os.SystemClock;
import com.bytedance.applog.log.q;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1876a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1877b = false;
    private static volatile long c = -1;
    public static volatile boolean enableBlock = true;

    static {
    }

    public BlockHelper() {
    }

    private static void a() {
        if (f1877b == false) goto L16;
    L9:
        e = move-exception;
        q.a().a("BlockHelper: block interrupted!", e, new Object[0]);
        return;
    L5:
        if (Math.abs(SystemClock.elapsedRealtime() - c) >= 10000) goto L7;
        Thread.sleep(f1876a);     // Catch: InterruptedException -> L9
    L12:
        return;
    L7:
        endBlock();     // Catch: InterruptedException -> L9
        goto L12
    }

    public static void beginBlock() {
        f1877b = true;
        c = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        f1877b = false;
        c = -1;
    }

    public static long getBlockInterval() {
        return f1876a;
    }

    public static void setBlockInterval(long r2) {
        f1876a = Math.max(r2, 1);
    }

    public static void setEnableBlock(boolean r0) {
        enableBlock = r0;
    }

    public static void tryBlock() {
        if (enableBlock == true) goto L6;
        return;
    L6:
        if (f1877b == false) goto L8;
        a();
        goto L6
    }
}
