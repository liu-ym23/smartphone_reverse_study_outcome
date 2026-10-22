package com.bytedance.ai.core.base;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2090a;

    public /* synthetic */ c(d r5) {
        this.f2090a = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        int r11 = ((Integer) r10).intValue();
        d r12 = this.f2090a;
        if (r11 == 0) goto L5;
    L7:
        Job r13 = r12.e;
        if (r13 == null) goto L10;
        r13.cancel(null);
    L10:
        r12.e = null;
        r12.d.set(false);
    L12:
        return Unit.INSTANCE;
    L5:
        if (r12.d.compareAndSet(false, true) == false) goto L7;
        DelayCleanupRuntime$scheduleCleanup$1 r5 = new DelayCleanupRuntime$scheduleCleanup$1(r12, null);
        r12.e = BuildersKt.launch$default(r12.f2093c, null, null, r5, 3, null);
        goto L12
    }
}
