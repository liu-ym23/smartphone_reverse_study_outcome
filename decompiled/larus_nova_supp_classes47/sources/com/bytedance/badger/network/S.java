package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class S extends Lambda implements Function6 {
    final /* synthetic */ T a;

    public S(T r1) {
        this.a = r1;
        super(6);
    }

    public Object invoke(Object r24, Object r25, Object r26, Object r27, Object r28, Object r29) {
        String r2 = (String) r25;
        a0 r3 = (a0) r26;
        b0 r4 = (b0) r27;
        l0 r5 = (l0) r28;
        com.bytedance.badger.C.a r6 = (com.bytedance.badger.C.a) r29;
        if (((Boolean) r24).booleanValue() == false) goto L6;
        z0 r1 = d0.a;
        T r7 = this.a;
        b r8 = r7.a;
        z64.b r9 = r7.b;
        r8.c.a(new i.b(r2, r8.a, r9.c, r8.d));
        com.bytedance.badger.monitor.c r10 = com.bytedance.badger.monitor.c.c;
        TriggerStage r12 = TriggerStage.custom;
        CollectStage r13 = CollectStage.report_finished;
        z64.c r14 = r8.b;
        boolean r15 = r8.e;
        long r16 = r8.f;
        com.bytedance.badger.monitor.c.a(r10, r12, r13, r14, r9, 0, SystemClock.elapsedRealtime() - r8.g, SystemClock.uptimeMillis() - r8.h, null, null, r15, r16, null, 0, null, 14736);
    L9:
        return Unit.INSTANCE;
    L6:
        if (r5.a() == false) goto L9;
        z0 r17 = d0.a;
        d0.e(this.a.a, new com.bytedance.badger.utils.c("uploadReport failed", -1201, CollectStage.report_finished, null, 8), "uploadReport - last attempt failed");
        goto L9
    }
}
