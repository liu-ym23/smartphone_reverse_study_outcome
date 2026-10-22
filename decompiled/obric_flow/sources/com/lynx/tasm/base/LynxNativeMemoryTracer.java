package com.lynx.tasm.base;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class LynxNativeMemoryTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10105a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10106b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10107c = false;
    public static int d;

    public static void a() {
        if (f10107c == true) goto L5;
        return;
    L5:
        nativeStopTracing();
        f10107c = false;
    }

    public static void b(int r5) {
        if (f10106b == true) goto L5;
        return;
    L5:
        d = 0;
        nativeStartTracing(r5);
        f10107c = true;
    }

    public static void c(Context r5) {
        IntentFilter r10 = new IntentFilter();
        r10.addAction(r5.getPackageName() + ".LYNX_MEMORY_TRACING_START");
        r10.addAction(r5.getPackageName() + ".LYNX_MEMORY_TRACING_STOP");
        r10.addAction(r5.getPackageName() + ".LYNX_MEMORY_TRACING_REPORT");
        e r11 = new e(0);
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        r5.registerReceiver(r11, r10);
    L8:
        f10106b = true;
        return;
    L5:
        if (r5.getApplicationInfo().targetSdkVersion < 34) goto L7;
        r5.registerReceiver(r11, r10, 4);
        goto L8
    }

    public static void d(String r5) {
        if (f10107c == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L23;
        File r10 = new File(r5);
        if (r10.exists() == false) goto L14;
        if (r10.isDirectory() == true) goto L14;
        throw new IllegalArgumentException(r5.concat(" is not a directory"));
    L14:
        if (r10.exists() == false) goto L16;
    L20:
        String r11 = r10.getPath() + "/lynx-native-memory-report-" + d;
        d++;
        nativeWriteRecordsToFile(r11);
        return;
    L16:
        if (r10.mkdirs() == true) goto L20;
        throw new IllegalArgumentException(com.lynx.tasm.utils.g.d("can not create directory '", r5, "'"));
    L23:
        throw new NullPointerException("filePath is null");
    }

    private static native void nativeStartTracing(int r5);

    private static native void nativeStopTracing();

    private static native void nativeWriteRecordsToFile(String r5);
}
