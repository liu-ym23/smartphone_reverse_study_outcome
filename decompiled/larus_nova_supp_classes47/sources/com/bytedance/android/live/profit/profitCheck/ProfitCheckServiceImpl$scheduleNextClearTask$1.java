package com.bytedance.android.live.profit.profitCheck;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ProfitCheckServiceImpl$scheduleNextClearTask$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ProfitCheckServiceImpl$scheduleNextClearTask$1(ProfitCheckServiceImpl r8) {
        super(0, r8, ProfitCheckServiceImpl.class, "startCycleClearTask", "startCycleClearTask()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m198invoke() {
        ProfitCheckServiceImpl r0 = (ProfitCheckServiceImpl) ((CallableReference) this).receiver;
        int r1 = ProfitCheckServiceImpl.h;
        r0.getClass();
        ProfitCheckServiceImpl$startCycleClearTask$1 r2 = new ProfitCheckServiceImpl$startCycleClearTask$1(r0);
        r0.c.onNext(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m198invoke();
        return Unit.INSTANCE;
    }
}
