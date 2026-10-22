package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ long b;

    public g(i r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = this.a.b;
        StringBuilder r1 = new StringBuilder("loadedbatch = ");
        i r2 = this.a;
        if (r2.c.isEmpty() == false) goto L5;
        Integer r3 = null;
    L6:
        r1.append(r3);
        r1.append(" ____  loadingbatch = ");
        r1.append(this.a.d);
        r1.append(" __  batchLoadDelayTime = ");
        r1.append(this.b);
        ALogger.i(r0, r1.toString());
        b r4 = this.a.b();
        if (r4 == null) goto L10;
        r4.b(this.a.d, BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME);
        return;
    L10:
        return;
    L5:
        r3 = (Integer) CollectionsKt.last(r2.c.keySet());
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
