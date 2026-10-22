package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxNativeMemoryTracer {
    public static int a = 1;
    public static boolean b;
    public static boolean c;
    public static int d;

    public static class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r3, Intent r4) {
            if (r4.getAction().endsWith("LYNX_MEMORY_TRACING_START") == false) goto L9;
            int r5 = r4.getIntExtra("min_watched_size", -1);
            if (r5 <= 0) goto L7;
            LynxNativeMemoryTracer.b(r5);
            return;
        L7:
            LynxNativeMemoryTracer.b(LynxNativeMemoryTracer.a);
            return;
        L9:
            if (r4.getAction().endsWith("LYNX_MEMORY_TRACING_STOP") == false) goto L12;
            LynxNativeMemoryTracer.c();
            return;
        L12:
            if (r4.getAction().endsWith("LYNX_MEMORY_TRACING_REPORT") == false) goto L21;
            String r6 = r4.getStringExtra("report_dir");
            if (r6 != null) goto L16;
            r6 = r3.getExternalFilesDir(null).getPath() + "/memory-reports";
        L16:
            LynxNativeMemoryTracer.d(r6);
            return;
        }
    }

    public LynxNativeMemoryTracer() {
    }

    private static native void nativeStartTracing(int r0);

    private static native void nativeStopTracing();

    private static native void nativeWriteRecordsToFile(String r0);

    public static void c() {
        if (c == true) goto L5;
        return;
    L5:
        nativeStopTracing();
        c = false;
    }

    public static void a(Context r13) {
        IntentFilter r7 = new IntentFilter();
        r7.addAction(r13.getPackageName() + ".LYNX_MEMORY_TRACING_START");
        r7.addAction(r13.getPackageName() + ".LYNX_MEMORY_TRACING_STOP");
        r7.addAction(r13.getPackageName() + ".LYNX_MEMORY_TRACING_REPORT");
        a r8 = new a();
        if (Build.VERSION.SDK_INT < 34) goto L37;
        if (r13.getApplicationInfo().targetSdkVersion < 34) goto L37;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L71;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L71:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r7, 4);
    L64:
        b = true;
        return;
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r7, 4, null, null, 3, r13).result;     // Catch: Exception -> L31
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L70;
        r13.registerReceiver(r8, r7, 4);     // Catch: Exception -> L31
    L70:
        goto L64
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L70
    L20:
        r13.registerReceiver(r8, r7, 4);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r13.registerReceiver(r8, r7, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L70
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r13.registerReceiver(r8, r7, 4);     // Catch: Exception -> L31
        goto L70
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r7) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r13, r8, r7, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L31
    L37:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L60:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L66;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r7);
        goto L64
    L66:
        throw e;
    L40:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L51;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L51;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r7, 0, null, null, 2, r13).result;     // Catch: Exception -> L60
        if (r1 == 1) goto L49;
        if (r1 == 2) goto L48;
        if (r1 == 3) goto L67;
        r13.registerReceiver(r8, r7);     // Catch: Exception -> L60
    L67:
        goto L64
    L48:
        new Intent();     // Catch: Exception -> L60
        goto L67
    L49:
        r13.registerReceiver(r8, r7);     // Catch: Exception -> L60
    L51:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L54;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L60
        r13.registerReceiver(r8, r7, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L60
        goto L67
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L56;
    L58:
        r13.registerReceiver(r8, r7);     // Catch: Exception -> L60
        goto L67
    L56:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r7) == false) goto L58;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L60
        ContextCompat.registerReceiver(r13, r8, r7, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L60
        goto L67
    }

    public static void b(int r1) {
        if (b == true) goto L5;
        return;
    L5:
        d = 0;
        nativeStartTracing(r1);
        c = true;
    }

    public static void d(String r3) {
        if (c == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L23;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == false) goto L14;
        if (r0.isDirectory() == true) goto L14;
        throw new IllegalArgumentException(r3.concat(" is not a directory"));
    L14:
        if (r0.exists() == false) goto L16;
    L20:
        String r4 = r0.getPath() + "/lynx-native-memory-report-" + d;
        d++;
        nativeWriteRecordsToFile(r4);
        return;
    L16:
        if (r0.mkdirs() == true) goto L20;
        throw new IllegalArgumentException("can not create directory '" + r3 + "'");
    L23:
        throw new NullPointerException("filePath is null");
    }
}
