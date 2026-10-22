package com.bytedance.android.live.profit.profitCheck;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProfitCheckServiceImpl$startCycleClearTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ProfitCheckServiceImpl this$0;

    public ProfitCheckServiceImpl$startCycleClearTask$1(ProfitCheckServiceImpl r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m199invoke() {
        CollectionsKt.removeAll(this.this$0.a, AnonymousClass1.INSTANCE);
        ProfitCheckServiceImpl r0 = this.this$0;
        r0.b.removeCallbacksAndMessages(null);
        r0.b.postDelayed(new b(new ProfitCheckServiceImpl$scheduleNextClearTask$1(r0)), 360000);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m199invoke();
        return Unit.INSTANCE;
    }
}
