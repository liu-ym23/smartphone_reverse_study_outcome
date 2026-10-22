package com.larus.basic.experience.downgrade.impl.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.strategy.DelayDowngradeStrategy", f = "DelayDowngradeStrategy.kt", i = {0}, l = {MessageCellStateTransformerType.BLOCK}, m = "preProcess", n = {"downgradeContext"}, s = {"L$0"})
public final class DelayDowngradeStrategy$preProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DelayDowngradeStrategy<T> this$0;

    public DelayDowngradeStrategy$preProcess$1(DelayDowngradeStrategy<T> r1, Continuation<? super DelayDowngradeStrategy$preProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, (Continuation<? super b<T>>) this);
    }
}
