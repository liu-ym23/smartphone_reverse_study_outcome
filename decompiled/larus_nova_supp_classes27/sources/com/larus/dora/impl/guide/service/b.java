package com.larus.dora.impl.guide.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ GuideSession a;
    public final /* synthetic */ DoraGuideServiceImpl b;

    public /* synthetic */ b(GuideSession r1, DoraGuideServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        GuideSession r0 = this.a;
        DoraGuideServiceImpl r1 = this.b;
        Throwable r6 = (Throwable) r5;
        int r7 = DoraGuideServiceImpl.e;
        g49.d.d("DoraGuideServiceImpl", "lifeCycleScope completed, automatically ending guide session: " + r0.a);     // Catch: Exception -> L5
        r1.a(r0.a);     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "auto endGuideSession failed: " + e.getMessage(), e);
        goto L8
    }
}
