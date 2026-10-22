package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteGlobal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15849a = 0;

    static {
        if (WCDBInitializationProbe.libLoaded == true) goto L10;
        System.loadLibrary("wcdb");
    L10:
        int r0 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();     // Catch: RuntimeException -> L7
    L8:
        f15849a = r0;
        nativeSetDefaultCipherSettings(r0);
        return;
    L7:
        r0 = 4096;
        goto L8
    }

    private SQLiteGlobal() {
    }

    public static void a() {
    }

    private static native int nativeReleaseMemory();

    private static native void nativeSetDefaultCipherSettings(int r0);
}
