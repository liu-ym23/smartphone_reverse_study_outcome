package com.bumptech.glide.load.engine.b;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class b {
    static int a() {
        int r0 = Runtime.getRuntime().availableProcessors();
        if (Build.VERSION.SDK_INT < 17) goto L5;
        return r0;
    L5:
        return Math.max(b(), r0);
    }

    private static int b() {
        StrictMode.ThreadPolicy r1 = StrictMode.allowThreadDiskReads();
        File r2 = new File("/sys/devices/system/cpu/");     // Catch: Throwable -> L5
        final Pattern r3 = Pattern.compile("cpu[0-9]+");     // Catch: Throwable -> L5
        File[] r0 = r2.listFiles(new AnonymousClass1(r3));     // Catch: Throwable -> L5
        StrictMode.setThreadPolicy(r1);
    L12:
        if (r0 == null) goto L14;
        int r4 = r0.length;
    L16:
        return Math.max(1, r4);
    L14:
        r4 = 0;
    L5:
        th = move-exception;
    L17:
        th = move-exception;
        StrictMode.setThreadPolicy(r1);
        throw th;
    L8:
        if (Log.isLoggable("GlideRuntimeCompat", 6) == false) goto L10;
        Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);     // Catch: Throwable -> L17
    L10:
        StrictMode.setThreadPolicy(r1);
        r0 = null;
        goto L12
    }
}
