package com.bytedance.applog.util;

import android.os.SystemClock;
import c4.m;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3782a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f3783b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f3784c = -1;
    public static volatile boolean enableBlock = true;

    public BlockHelper() {
    }

    public static void beginBlock() {
        f3783b = true;
        f3784c = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        f3783b = false;
        f3784c = -1;
    }

    public static long getBlockInterval() {
        return f3782a;
    }

    public static void setBlockInterval(long r8) {
        f3782a = Math.max(r8, 1);
    }

    public static void setEnableBlock(boolean r8) {
        enableBlock = r8;
    }

    public static void tryBlock() {
        if (enableBlock == true) goto L6;
        return;
    L6:
        if (f3783b == false) goto L16;
        if (f3783b == false) goto L6;
        if (Math.abs(SystemClock.elapsedRealtime() - f3784c) < 10000) goto L11;
        endBlock();     // Catch: InterruptedException -> L14
        goto L6
    L11:
        Thread.sleep(f3782a);     // Catch: InterruptedException -> L14
    L14:
        e = move-exception;
        m.u().o(e, "BlockHelper: block interrupted!", new Object[0]);
        goto L6
    }
}
