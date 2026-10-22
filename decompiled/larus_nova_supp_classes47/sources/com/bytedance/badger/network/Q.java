package com.bytedance.badger.network;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.badger.data.ReportStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class Q extends Lambda implements Function1 {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;
    final /* synthetic */ ReportStage c;

    public Q(boolean r1, b r2, ReportStage r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(1);
    }

    public Object invoke(Object r18) {
        BadgerUpdateInfo r0 = (BadgerUpdateInfo) r18;
        com.bytedance.badger.monitor.c.c.getClass();     // Catch: Throwable -> L8
        com.bytedance.badger.monitor.c.e();     // Catch: Throwable -> L8
        if (this.a == false) goto L6;
        b r1 = this.b;     // Catch: Throwable -> L8
        ReportStage r6 = this.c;     // Catch: Throwable -> L8
        z0 r2 = d0.a;     // Catch: Throwable -> L8
        long r8 = d0.c;     // Catch: Throwable -> L8
        r1.getClass();     // Catch: Throwable -> L8
        d0.c(new b(r1.a, r1.b, r1.c, r6, true, r8, r1.g, r1.h, false, DefaultConfig.MAX_CACHE_ENTRIES));     // Catch: Throwable -> L8
    L12:
    L11:
        return Unit.INSTANCE;
    L6:
        b r3 = this.b;     // Catch: Throwable -> L8
        r3.c.a(new i.b(r3.a));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        z0 r4 = d0.a;
        d0.e(this.b, th, "registerCompletionCallback - callback failed");
        goto L11
    }
}
