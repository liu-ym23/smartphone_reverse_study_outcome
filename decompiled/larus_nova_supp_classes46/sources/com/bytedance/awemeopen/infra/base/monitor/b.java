package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Function0<Unit> {
    public b() {
    }

    public final Object invoke() {
        monitor-enter(AoMonitor.class);
        Iterator<AoMonitor.b> r1 = AoMonitor.b.iterator();     // Catch: Throwable -> L37
    L6:
        if (r1.hasNext() == false) goto L33;
        AoMonitor.b r2 = r1.next();     // Catch: Throwable -> L37
        int r3 = AoMonitor.a.a[r2.a.ordinal()];     // Catch: Throwable -> L37
        if (r3 != 1) goto L10;
        o64.a r4 = AoMonitor.a;     // Catch: Throwable -> L37
        String r5 = r2.b;     // Catch: Throwable -> L37
        int r6 = r2.c;     // Catch: Throwable -> L37
        JSONObject r7 = r2.d;     // Catch: Throwable -> L37
        JSONObject r8 = r2.e;     // Catch: Throwable -> L37
        SDKMonitor r9 = ((g64.a) r4).a;     // Catch: Throwable -> L37
        if (r9 == null) goto L6;
        r9.monitorStatusAndDuration(r5, r6, r7, r8);     // Catch: Throwable -> L37
        goto L6
    L10:
        if (r3 != 2) goto L12;
        o64.a r10 = AoMonitor.a;     // Catch: Throwable -> L37
        String r11 = r2.b;     // Catch: Throwable -> L37
        int r12 = r2.c;     // Catch: Throwable -> L37
        JSONObject r13 = r2.e;     // Catch: Throwable -> L37
        SDKMonitor r14 = ((g64.a) r10).a;     // Catch: Throwable -> L37
        if (r14 == null) goto L6;
        r14.monitorStatusRate(r11, r12, r13);     // Catch: Throwable -> L37
        goto L6
    L12:
        if (r3 != 3) goto L14;
        o64.a r15 = AoMonitor.a;     // Catch: Throwable -> L37
        String r16 = r2.b;     // Catch: Throwable -> L37
        JSONObject r17 = r2.d;     // Catch: Throwable -> L37
        JSONObject r18 = r2.e;     // Catch: Throwable -> L37
        SDKMonitor r19 = ((g64.a) r15).a;     // Catch: Throwable -> L37
        if (r19 == null) goto L6;
        r19.monitorDuration(r16, r17, r18);     // Catch: Throwable -> L37
        goto L6
    L14:
        if (r3 != 4) goto L16;
        o64.a r20 = AoMonitor.a;     // Catch: Throwable -> L37
        String r21 = r2.f;     // Catch: Throwable -> L37
        JSONObject r22 = r2.e;     // Catch: Throwable -> L37
        SDKMonitor r23 = ((g64.a) r20).a;     // Catch: Throwable -> L37
        if (r23 == null) goto L6;
        r23.monitorCommonLog(r21, r22);     // Catch: Throwable -> L37
        goto L6
    L16:
        if (r3 != 5) goto L17;
        o64.a r24 = AoMonitor.a;     // Catch: Throwable -> L37
        String r25 = r2.b;     // Catch: Throwable -> L37
        JSONObject r26 = r2.g;     // Catch: Throwable -> L37
        JSONObject r27 = r2.h;     // Catch: Throwable -> L37
        JSONObject r28 = r2.e;     // Catch: Throwable -> L37
        SDKMonitor r29 = ((g64.a) r24).a;     // Catch: Throwable -> L37
        if (r29 == null) goto L6;
        r29.monitorEvent(r25, r26, r27, r28);     // Catch: Throwable -> L37
        goto L6
    L17:
        AoLogger.c("AoAppMonitor", new Object[]{"unknown report type"});     // Catch: Throwable -> L37
        goto L6
    L33:
        AoMonitor.b.clear();     // Catch: Throwable -> L37
        AoMonitor.b = null;     // Catch: Throwable -> L37
        monitor-exit(AoMonitor.class);
        return Unit.INSTANCE;
    L37:
        th = move-exception;
        throw th;
    }
}
