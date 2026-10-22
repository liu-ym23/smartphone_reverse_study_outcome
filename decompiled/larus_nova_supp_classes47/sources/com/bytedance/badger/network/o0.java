package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.v.f;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function6;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 {
    public static final o0 a = null;

    static {
        a = new o0();
    }

    public o0() {
    }

    public static void a(n0 r20) {
        com.bytedance.badger.monitor.c r1 = com.bytedance.badger.monitor.c.c;
        TriggerStage r2 = r20.d;
        CollectStage r3 = CollectStage.collect_pre;
        int r6 = r20.c;
        com.bytedance.badger.monitor.c.a(r1, r2, r3, r20.a, null, r6, 0, 0, null, null, false, 0, r20.i, 0, null, 14304);
    }

    public static void d(n0 r20, z64.b r22) {
        com.bytedance.badger.monitor.c r1 = com.bytedance.badger.monitor.c.c;
        TriggerStage r2 = r20.d;
        CollectStage r3 = CollectStage.collect_finished;
        int r6 = r20.c;
        long r7 = SystemClock.elapsedRealtime() - r20.f;
        long r9 = SystemClock.uptimeMillis() - r20.g;
        com.bytedance.badger.monitor.c.a(r1, r2, r3, r20.a, r22, r6, r7, r9, null, null, r20.e, r20.h.get(), r20.i, 0, null, 12672);
    }

    public static void e(n0 r6, boolean r7) {
        BadgerCore.Companion.getClass();
        j.a().checkReadyForReportAndThrow(r7);
        if (StringsKt.isBlank(r6.a.getDeviceId()) == true) goto L6;
        return;
    L6:
        throw new com.bytedance.badger.utils.c("deviceId is blank", -1101, CollectStage.collect_pre, null, 8);
    }

    public final void c(n0 r7, Function6 r8) {
        Integer r1 = null;
        BadgerCore.Companion.getClass();     // Catch: Exception -> L5
        z64.b r2 = BadgerCore.getBadgerReport$default(j.a(), r7.a, false, 2, null);     // Catch: Exception -> L5
        Throwable r3 = null;
    L7:
        d(r7, r2);
        if (r2 != null) goto L10;
    L22:
        if (r2 == null) goto L24;
        BadgerCore.Companion.getClass();
        String r9 = j.a().getLastCollectError();
    L25:
        if (r3 != null) goto L31;
        StringBuilder r0 = new StringBuilder("getBadgerReport: fullReport empty or errorCode != 0, errorCode: ");
        if (r2 == null) goto L30;
        r1 = Integer.valueOf(r2.b);
    L30:
        r0.append(r1);
        r3 = new com.bytedance.badger.utils.c(r0.toString(), -1102, CollectStage.collect_finished, r9);
    L31:
        b(r7, r3, r2);
        return;
    L24:
        r9 = "";
        goto L25
    L10:
        if (r2.b != 0) goto L22;
        f(this, r2, r7, r8);     // Catch: Exception -> L19
        if (r7.e == false) goto L16;
        String r10 = "collectFullReport - timeout upload end";
    L17:
        e.f("BadgerNetworkHandler", r10);
        return;
    L16:
        r10 = "collectFullReport - full report upload end";
    L19:
        e = move-exception;
        e.e("BadgerNetworkHandler", "Failed to upload report: " + e.getMessage());
        b(r7, e, r2);
        return;
    L5:
        e = move-exception;
        r3 = e;
        r2 = null;
        goto L7
    }

    public static void b(n0 r19, Throwable r20, z64.b r22) {
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.c, r19.d, r20, 0, null, r19.c, SystemClock.elapsedRealtime() - r19.f, SystemClock.uptimeMillis() - r19.g, r19.a, null, r19.e, r19.h.get(), r19.i, null, 4364);
    }

    public static void f(o0 r3, z64.b r4, n0 r5, Function6 r6) {
        com.bytedance.badger.v.d.f0.getClass();
        f r0 = com.bytedance.badger.v.d.x;
        KProperty r1 = com.bytedance.badger.v.d.a[24];
        boolean r2 = ((Boolean) r0.a()).booleanValue();
        r3.getClass();
        g(r4, r5, r2, r6);
    }

    public static void g(z64.b r9, n0 r10, boolean r12, Function6 r13) {
        e.f("BadgerNetworkHandler", "sendFollowUpRequest doRequest start");
        z64.c r0 = r10.a;
        String r1 = r10.b;
        ArrayList r2 = new ArrayList();
        BadgerCore.Companion.getClass();     // Catch: Exception -> L7
        Pair r3 = j.a().getRequestHeaderTag();     // Catch: Exception -> L7
        if (r3 == null) goto L8;
        r2.add(TuplesKt.to(r3.getFirst(), r3.getSecond()));     // Catch: Exception -> L7
    L8:
        BadgerCore.Companion.getClass();
        String r4 = j.a().getNetRequestInterface().getHost();
        int r6 = 0;
        if (r4.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r4 = "aweme.snssdk.com";
    L14:
        String r7 = "https://" + r4 + r1;
        Pair[] r8 = new Pair[3];
        String r14 = r9.a;
        if (r14 != null) goto L18;
        r14 = "";
    L18:
        r8[0] = TuplesKt.to("badger_payload_data", r14);
        r8[1] = TuplesKt.to("badger_signal", String.valueOf(r0.getTimestamp()));
        r8[2] = TuplesKt.to("badger_scene", String.valueOf(r0.getSceneId()));
        a0 r15 = new a0(r7, r2, MapsKt.mapOf(r8));
        u0 r16 = u0.h;
        if (r12 == false) goto L21;
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.h r17 = com.bytedance.badger.v.d.y;
        KProperty r18 = com.bytedance.badger.v.d.a[25];
        int r19 = ((Number) r17.a()).intValue();
    L22:
        if (r12 == false) goto L24;
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.h r110 = com.bytedance.badger.v.d.z;
        KProperty r20 = com.bytedance.badger.v.d.a[26];
        r6 = ((Number) r110.a()).intValue();
    L24:
        BadgerRetryReportCallback r111 = new BadgerRetryReportCallback(r9, r10, r13);
        com.bytedance.badger.C.a r22 = r10.i;
        r16.getClass();
        u0.b(r15, r19, r6, r111, r22);
        return;
    L21:
        r19 = 0;
        goto L22
    L11:
        r5 = false;
        goto L12
    }

    public final void h(z64.c r18, int r19, TriggerStage r20, boolean r22, com.bytedance.badger.C.a r23, b74.b r24) {
        n0 r14 = new n0(r18, r19, r20, r23, 240);
        long r8 = r14.f;
        long r10 = r14.g;
        AtomicLong r15 = r14.h;
        n0 r12 = new n0(r18, "/passport/dtrait/sinr/", r19, r20, true, r8, r10, r15, r14.i);
        e(r14, true);
        a(r14);
        e.f("BadgerNetworkHandler", "start collect1...");
        BadgerCore.Companion.getClass();
        int r4 = j.a().updateFeatures(r18, r19, true);
        if (r4 == 0) goto L9;
        if (r4 == 1) goto L6;
        e.f("BadgerNetworkHandler", "collectFullReport - updateFeatures failed, status: " + r4);
        b(r14, new com.bytedance.badger.utils.c("badger update failed: " + r4, 0, null, null, 14), null);
        return;
    L6:
        e.f("BadgerNetworkHandler", "collectFullReport - updateFeatures timeout, status: " + r4);
        j.a().addSceneCompletionCallback(r18.getSceneId(), new C0384g(r4, r12, r24));
        r15.set(SystemClock.elapsedRealtime());
        e.f("BadgerNetworkHandler", "collectFullReport - timeout, first upload");
        if (r22 == false) goto L12;
        c(r14, r24);
        return;
    L12:
        return;
    L9:
        c(r14, r24);
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
    }

    public final void i(z64.c r9, int r10, TriggerStage r12, boolean r13, com.bytedance.badger.C.a r14, b74.b r15) {
        n0 r6 = new n0(r9, r10, r12, r14, 240);
        e(r6, r13);
        a(r6);
        e.f("BadgerNetworkHandler", "start collect2...");
        BadgerCore.Companion.getClass();
        int r16 = BadgerCore.updateFeatures$default(j.a(), r9, r10, false, 4, null);
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.h r17 = com.bytedance.badger.v.d.u;
        KProperty r0 = com.bytedance.badger.v.d.a[21];
        if (((Number) r17.a()).intValue() <= 0) goto L9;
        if (r16 != 0) goto L7;
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
        goto L9
    L7:
        if (r16 != 1) goto L9;
        j.a().addSceneCompletionCallback(r9.getSceneId(), C0385h.a);
    L9:
        z64.b r18 = j.a().getBadgerReport(r9, r13);
        if (r18 == null) goto L18;
        if (r18.b != 0) goto L16;
        d(r6, r18);
        f(this, r18, r6, r15);
        e.f("BadgerNetworkHandler", "sendFollowUpRequest end");
        return;
    L16:
        throw new com.bytedance.badger.utils.c("getBadgerReport failed,errorCode=" + r18.b, -1102, CollectStage.collect_finished, j.a().getLastCollectError());
    L18:
        throw new com.bytedance.badger.utils.c("getBadgerReport failed, switch is off", -1, CollectStage.collect_finished, null, 8);
    }
}
