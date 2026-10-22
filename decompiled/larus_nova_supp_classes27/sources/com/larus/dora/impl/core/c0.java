package com.larus.dora.impl.core;

import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c0 {
    public static int a;
    public static long b;
    public static int c;
    public static final ReentrantLock d = null;

    static {
        a = -1;
        b = -1;
        c = -1;
        d = new ReentrantLock();
    }

    public static void c(int r5) {
        g49.d.d("DoraLifeCycleManager", "handleIdleStatus: status=" + r5);
        ReentrantLock r0 = d;
        r0.lock();
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (c == r5) goto L8;
        c = r5;     // Catch: Throwable -> L11
        if (a == (-1)) goto L8;
        DoraBuryPointManager r1 = DoraBuryPointManager.a;     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        g49.d.d(DoraBuryPointManager.b, "reportBusyStatus: status=" + r5);     // Catch: Throwable -> L11
        DoraBuryPointManager.J(r1, "d_device_bt_busy_status", MapsKt.mapOf(TuplesKt.to("status", Integer.valueOf(r5))), false, 12);     // Catch: Throwable -> L11
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r0.unlock();
    }

    public static void a(int r2, int[] r3) {
        StringBuilder r0 = new StringBuilder("handleBudsStatusChanged: stage=");
        r0.append(r2);
        r0.append(", statusArray=");
        if (r3 == null) goto L5;
        String r1 = Arrays.toString(r3);
    L6:
        r0.append(r1);
        g49.d.d("DoraLifeCycleManager", r0.toString());
        ReentrantLock r4 = d;
        r4.lock();
        b(r2, r3);     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r4.unlock();
        return;
    L10:
        th = move-exception;
        r4.unlock();
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    public static void b(int r6, int[] r7) {
        g49.d.d("DoraLifeCycleManager", "handleBudsStatusChangedLocked: stage=" + r6 + ", statusArray=" + Arrays.toString(r7));
        if (r7 != null) goto L5;
    L11:
        int r8 = -1;
    L12:
        if (r8 != (-1)) goto L16;
        g49.d.e("DoraLifeCycleManager", "handleBudsStatusChanged: statusArray maybe null");
        return;
    L16:
        if (r6 == 0) goto L27;
        if (r6 == 1) goto L21;
        if (r6 != 2) goto L32;
        DoraBuryPointManager.a.F(a, 2, System.currentTimeMillis() - b);
        a = -1;
        b = -1;
        return;
    L32:
        return;
    L21:
        int r9 = a;
        if (r9 != (-1)) goto L25;
        a = r8;
        b = System.currentTimeMillis();
        DoraBuryPointManager.a.F(r8, 0, 0);
        return;
    L25:
        if (r9 == r8) goto L30;
        DoraBuryPointManager.a.F(a, 1, System.currentTimeMillis() - b);
        a = r8;
        b = System.currentTimeMillis();
        return;
    L30:
        return;
    L27:
        a = r8;
        b = System.currentTimeMillis();
        DoraBuryPointManager.a.F(r8, 0, 0);
        return;
    L5:
        if (r7.length < 3) goto L11;
        if (r7[2] != 3) goto L10;
        r8 = 2;
        goto L12
    L10:
        r8 = 1;
        goto L12
    }
}
