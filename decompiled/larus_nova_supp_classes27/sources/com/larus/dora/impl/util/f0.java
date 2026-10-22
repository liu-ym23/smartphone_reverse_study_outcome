package com.larus.dora.impl.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {
    public static volatile a a;
    public static volatile long b;

    public static final class a {
        public final long a;
        public final float b;
        public final long c;
        public final float d;
        public final long e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r9.b) == 0) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r9.d) == 0) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + Float.floatToIntBits(this.b)) * 31;
            long r3 = this.c;
            int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + Float.floatToIntBits(this.d)) * 31;
            long r4 = this.e;
            return r2 + ((int) (r4 ^ (r4 >>> 32)));
        }

        public final String toString() {
            return "MemoryStats(appUsedMemory=" + this.a + ", appMemoryRate=" + this.b + ", systemUsedMemory=" + this.c + ", systemMemoryRate=" + this.d + ", totalSystemMemory=" + this.e + ')';
        }

        public a(long r1, float r3, long r4, float r6, long r7) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    static {
    }

    public static a b() {
        long r0 = SystemClock.elapsedRealtime();
        if (a == null) goto L33;
        if ((r0 - b) >= 60000) goto L33;
        g49.d.a("DoraSystemResourceUtils", "Returning cached memory stats");
        a r1 = a;
        Intrinsics.checkNotNull(r1);
        return r1;
    L33:
        Debug.MemoryInfo r2 = new Debug.MemoryInfo();     // Catch: Exception -> L11
        Debug.getMemoryInfo(r2);     // Catch: Exception -> L11
        long r8 = ((long) r2.getTotalPss()) / 1024;     // Catch: Exception -> L11
    L35:
        Object r3 = AppHost.a.getApplication().getSystemService("activity");     // Catch: Exception -> L22
        if ((r3 instanceof ActivityManager) == false) goto L16;
        ActivityManager r4 = (ActivityManager) r3;     // Catch: Exception -> L22
    L17:
        ActivityManager.MemoryInfo r6 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L22
        if (r4 == null) goto L20;
        r4.getMemoryInfo(r6);     // Catch: Exception -> L22
    L20:
        long r10 = r6.totalMem;     // Catch: Exception -> L22
        Pair r5 = new Pair(Long.valueOf(r10 / 1048576), Long.valueOf((r10 - r6.availMem) / 1048576));     // Catch: Exception -> L22
    L24:
        long r14 = ((Number) r5.getFirst()).longValue();
        long r11 = ((Number) r5.getSecond()).longValue();
        if (r14 <= 0) goto L27;
        float r12 = (r8 * 100.0f) / r14;
    L28:
        if (r14 <= 0) goto L30;
        float r13 = (r11 * 100.0f) / r14;
    L31:
        g49.d.a("DoraSystemResourceUtils", "Memory stats - App used: " + r8 + "MB, App rate: " + r12 + "%, System used: " + r11 + "MB, System rate: " + r13 + "%, Total system: " + r14 + "MB");
        a r7 = new a(r8, r12, r11, r13, r14);
        a = r7;
        b = r0;
        return r7;
    L30:
        r13 = 0.0f;
        goto L31
    L27:
        r12 = 0.0f;
        goto L28
    L16:
        r4 = null;
    L22:
        e = move-exception;
        g49.d.c("DoraSystemResourceUtils", "Failed to get system memory info", e);
        r5 = new Pair(0L, 0L);
    L11:
        e = move-exception;
        g49.d.c("DoraSystemResourceUtils", "Failed to get app used memory", e);
        r8 = 0;
        goto L35
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r9, IntentFilter r10) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r10);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r10, 0, null, null, 2, r9);     // Catch: Exception -> L36
        int r2 = r1.result;     // Catch: Exception -> L36
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        return r9.registerReceiver(null, r10);
    L19:
        return r1.intent;
    L21:
        return new Intent();
    L23:
        return r9.registerReceiver(null, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r9.registerReceiver(null, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r9, null, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r9.registerReceiver(null, r10);
    }
}
