package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.n;
import java.nio.charset.Charset;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Charsets;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 {
    public static final z0 a = null;
    public static final z0 b = null;
    public static volatile long c;

    static {
        a = new z0("collection", 1, 1);
        b = new z0("upload", 2, 8);
    }

    public d0() {
    }

    public static z64.d a(int r8) {
        BadgerCore.Companion.getClass();
        String r4 = j.a().getDeviceId();
        int r0 = n.a;     // Catch: Throwable -> L10
        Charset r1 = Charsets.UTF_8;     // Catch: Throwable -> L10
        if (r4 == null) goto L9;
        return new z64.d(UInt.toString-impl(UInt.constructor-impl(n.a(r4.getBytes(r1)))), r8, r4, null, 24);
    L9:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        e.c("BadgerCustomReportHandler", "getBadgerRequest - failed to generate challenge key for scene " + r8 + ": " + th.getMessage(), th);
        return null;
    }

    public static void f(b r2, Function0 r3) {
        a.a(new r(r3, r2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e(r2, th, "collectionThread - scheduling failed");
    }

    public static final void c(b r25) {
        BadgerCore.Companion.getClass();
        z64.b r0 = j.a().getBadgerReport(r25.b, r25.i);
        if (r0 == null) goto L15;
        if (r0.b != 0) goto L13;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.c, TriggerStage.custom, CollectStage.collect_finished, r25.b, r0, 0, SystemClock.elapsedRealtime() - r25.g, SystemClock.uptimeMillis() - r25.h, null, null, r25.e, r25.f, null, 0, null, 14736);
        b.a(new c0(new T(r25, r0), r25));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        e(r25, th, "uploadThread - scheduling failed");
        return;
    L13:
        throw new com.bytedance.badger.utils.c("getBadgerReport failed,errorCode=" + r0.b, -1102, CollectStage.collect_finished, j.a().getLastCollectError());
    L15:
        throw new com.bytedance.badger.utils.c("Switch is off for scene " + r25.a, 0, null, null, 14);
    }

    public static void e(b r20, Throwable r22, String r23) {
        e.c("BadgerCustomReportHandler", r23 + " - " + r22.getMessage(), r22);
        r20.c.a(new i.a(r22, r22 instanceof com.bytedance.badger.utils.c, r20.d));
        com.bytedance.badger.monitor.c r1 = com.bytedance.badger.monitor.c.c;
        TriggerStage r6 = TriggerStage.custom;
        z64.c r10 = r20.b;
        boolean r12 = r20.e;
        com.bytedance.badger.monitor.c.b(r1, r6, r22, 0, null, 0, SystemClock.elapsedRealtime() - r20.g, SystemClock.uptimeMillis() - r20.h, r10, null, r12, r20.f, null, null, 6428);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static void b(int r42, z64.h r43, z64.g r44, boolean r45) {
        BadgerCore.Companion.getClass();
        if (j.a().isInitialized() == true) goto L5;
        i.a r0 = new i.a(new com.bytedance.badger.utils.c("Badger is not initialized", -1001, null, null, 12), false);
    L8:
        r44.a(r0);
        return;
    L5:
        com.bytedance.badger.v.d.f0.getClass();
        String r2 = com.bytedance.badger.v.d.g();
        if (r2 != 0) goto L40;
        r0 = new i.a(new com.bytedance.badger.utils.c("Badger is disabled", -1002, null, null, 12), false);
        goto L8
    L40:
        z64.d r19 = a(r42);     // Catch: Throwable -> L33
        if (r19 == null) goto L36;
        b r6 = new b(r42, r19, r44, null, false, 0, 0, 0, r45, 248);     // Catch: Throwable -> L31
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.c, TriggerStage.custom, CollectStage.collect_pre, r19, null, 0, 0, 0, null, null, false, 0, null, 0, r43, 6544);     // Catch: Throwable -> L31
        if ((r43 instanceof z64.h.c) == false) goto L20;
        e.f("BadgerCustomReportHandler", "handlePreload - scene: " + r6.a);     // Catch: Throwable -> L37
        f(r6, new J(r6));     // Catch: Throwable -> L37
        return;
    L20:
        if ((r43 instanceof z64.h.d) == false) goto L23;
        ((z64.h.d) r43).getClass();     // Catch: Throwable -> L37
        e.f("BadgerCustomReportHandler", "handleTimeout - timeoutMs: 0, scene: " + r6.a);     // Catch: Throwable -> L37
        f(r6, new L(r6, 0));     // Catch: Throwable -> L37
        return;
    L23:
        if ((r43 instanceof z64.h.e) == false) goto L26;
        int r1 = ((z64.h.e) r43).a;     // Catch: Throwable -> L37
        e.f("BadgerCustomReportHandler", "handleTimeoutWithRetry - timeoutMs: " + r1 + ", scene: " + r6.a);     // Catch: Throwable -> L37
        f(r6, new M(r6, r1));     // Catch: Throwable -> L37
        return;
    L26:
        if ((r43 instanceof z64.h.a) == false) goto L29;
        e.f("BadgerCustomReportHandler", "handleCompleteReport - scene: " + r6.a);     // Catch: Throwable -> L37
        f(r6, new F(r6));     // Catch: Throwable -> L37
        return;
    L29:
        if ((r43 instanceof z64.h.b) == false) goto L49;
        e.f("BadgerCustomReportHandler", "handleGetReportAndReport - scene: " + r6.a);     // Catch: Throwable -> L37
        f(r6, new G(r6));     // Catch: Throwable -> L37
        return;
    L49:
        return;
    L31:
        th = th;
        r2 = "BadgerCustomReportHandler";
    L38:
        e.c(r2, "doBadgerReport - failed for scene " + r42 + ": " + th.getMessage(), th);
        r44.a(new i.a(th, th instanceof com.bytedance.badger.utils.c));
        return;
    L36:
        throw new com.bytedance.badger.utils.c("Failed to generate badger request for scene " + r42, 0, null, null, 14);     // Catch: Throwable -> L37
    L37:
        th = th;
    L33:
        th = th;
        r2 = "BadgerCustomReportHandler";
        goto L38
    }

    public static void d(b r7, int r8, Function0 r9, Function0 r10, int r12) {
        if ((r12 & 4) == 0) goto L6;
        r9 = N.a;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r10 = O.a;
    L9:
        if ((r12 & 16) == 0) goto L11;
        P r13 = P.a;
    L13:
        if (r8 != 0) goto L15;
        e.f("BadgerCustomReportHandler", "handleUpdateResult - completed for scene: " + r7.a);
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
        r10.invoke();
        return;
    L15:
        if (r8 != 1) goto L17;
        e.f("BadgerCustomReportHandler", "handleUpdateResult - timeout for scene: " + r7.a);
        r9.invoke();
        return;
    L17:
        e.e("BadgerCustomReportHandler", "handleUpdateResult - error: " + r8 + " for scene: " + r7.a);
        r13.getClass();
        throw new com.bytedance.badger.utils.c("Badger update failed for scene " + r7.a + " with code: " + r8, 0, null, null, 14);
    L11:
        r13 = null;
        goto L13
    }
}
