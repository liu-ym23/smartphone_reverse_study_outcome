package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import z64.f;

/* JADX INFO: renamed from: com.bytedance.badger.network.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0382c extends Lambda implements Function0 {
    final /* synthetic */ long a;
    final /* synthetic */ TriggerStage b;
    final /* synthetic */ f c;

    public C0382c(long r1, TriggerStage r3, f r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        super(0);
    }

    public Object invoke() {
        long r2 = this.a;
        if (r2 <= 0) goto L6;
        Thread.sleep(r2);
    L6:
        if (this.b != TriggerStage.recollect) goto L8;
        f r0 = this.c;
        r0.d = System.currentTimeMillis();
        f r1 = this.c;
        BadgerCore.Companion.getClass();
        r1.c = j.a().getDeviceId();
    L8:
        long r3 = SystemClock.elapsedRealtime();
        com.bytedance.badger.v.d.f0.getClass();
        long r4 = com.bytedance.badger.v.d.f().a();
        o0.a.i(this.c, (int) r4, this.b, false, com.bytedance.badger.C.a.b, null);     // Catch: Throwable -> L11
    L14:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.c, this.b, th, 0, null, (int) r4, SystemClock.elapsedRealtime() - r3, SystemClock.uptimeMillis() - r3, this.c, null, false, 0, null, null, 7948);
        goto L14
    }
}
