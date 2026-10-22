package com.ss.ugc.effectplatform.task.algorithm;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchModelTask$b implements Runnable {
    public final /* synthetic */ FetchModelTask a;
    public final /* synthetic */ ModelInfo b;
    public final /* synthetic */ Effect c;
    public final /* synthetic */ long d;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k(this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public FetchModelTask$b(FetchModelTask r1, ModelInfo r2, Effect r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
