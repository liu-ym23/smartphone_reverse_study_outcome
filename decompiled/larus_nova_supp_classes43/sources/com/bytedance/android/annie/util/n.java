package com.bytedance.android.annie.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import kotlin.text.Regex;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static long a;
    public static double b;
    public static final /* synthetic */ int c = 0;

    static {
        b = -1.0d;
    }

    public static long b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), IServerListener.WHAT_BYTELINK_SINK_ERROR);     // Catch: Throwable -> L12
        Object[] r0 = new Regex(" ").split(r10.readLine(), 0).toArray(new String[0]);     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        String[] r1 = (String[]) r0;     // Catch: Throwable -> L11
        long r11 = ((Long.parseLong(r1[13]) + Long.parseLong(r1[14])) + Long.parseLong(r1[15])) + Long.parseLong(r1[16]);
        r10.close();
        return r11;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L11
    L13:
        if (r10 == null) goto L20;
        r10.close();
        return -1;
    L20:
        return -1;
    L12:
        r10 = null;
        goto L13
    }

    public static long c() {
        int r0 = Runtime.getRuntime().availableProcessors();
        long r1 = -1;
        int r10 = 0;
    L3:
        if (r10 >= r0) goto L29;
        BufferedReader r11 = new BufferedReader(new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu" + r10 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L24
    L31:
        String r12 = r11.readLine();     // Catch: Throwable -> L22
        if (r12 != null) goto L8;
    L35:
        r11.close();     // Catch: Throwable -> L30
        r10 = r10 + 1;     // Catch: Throwable -> L30
        goto L3
    L8:
        if (r12.length() != 0) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == true) goto L35;
        Object[] r14 = new Regex("\\s+").split(r12, 0).toArray(new String[0]);     // Catch: Throwable -> L22
        if (r14 == null) goto L20;
        String[] r15 = (String[]) r14;     // Catch: Throwable -> L22
        if (r15.length != 2) goto L31;
        r1 = r1 + Long.parseLong(r15[1]);     // Catch: Throwable -> L22
        goto L31
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L22
    L10:
        r13 = false;
    L22:
        th = th;
    L26:
        if (r11 == null) goto L28;
        r11.close();     // Catch: Throwable -> L30
    L28:
        throw th;     // Catch: Throwable -> L30
    L24:
        th = th;
        r11 = null;
    L29:
        return r1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r11);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r11, 0, null, null, 2, r10);     // Catch: Exception -> L36
        int r12 = r1.result;     // Catch: Exception -> L36
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L21;
        if (r12 == 3) goto L19;
        return r10.registerReceiver(null, r11);
    L19:
        return r1.intent;
    L21:
        return new Intent();
    L23:
        return r10.registerReceiver(null, r11);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r10.registerReceiver(null, r11, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r10, null, r11, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r10.registerReceiver(null, r11);
    }
}
