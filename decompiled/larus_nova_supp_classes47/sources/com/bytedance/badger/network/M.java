package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.ReportStage;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class M extends Lambda implements Function0 {
    final /* synthetic */ b a;
    final /* synthetic */ int b;

    public M(b r1, int r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        BadgerCore.Companion.getClass();
        int r1 = BadgerCore.updateFeatures$default(j.a(), this.a.b, this.b, false, 4, null);
        if (r1 != 0) goto L5;
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
        ReportStage r2 = ReportStage.FINAL;
    L10:
        ReportStage r6 = r2;
        z0 r3 = d0.a;
        b r4 = this.a;
        d0.c(new b(r4.a, r4.b, r4.c, r6, r4.e, r4.f, r4.g, r4.h, false, DefaultConfig.MAX_CACHE_ENTRIES));
        return Unit.INSTANCE;
    L5:
        if (r1 != 1) goto L8;
        z0 r5 = d0.a;
        d0.c = SystemClock.elapsedRealtime();
        b r7 = this.a;
        j.a().addSceneCompletionCallback(r7.a, new Q(true, r7, ReportStage.FINAL));
        r2 = ReportStage.PARTIAL;
        goto L10
    L8:
        throw new com.bytedance.badger.utils.c("Badger update failed for scene " + this.a.a + " with code: " + r1, 0, null, null, 14);
    }
}
