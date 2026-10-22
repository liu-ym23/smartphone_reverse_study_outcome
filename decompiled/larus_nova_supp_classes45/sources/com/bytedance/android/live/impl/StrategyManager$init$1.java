package com.bytedance.android.live.impl;

import com.bytedance.android.live.impl.strategy.Strategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/impl/strategy/Strategy;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class StrategyManager$init$1 extends FunctionReferenceImpl implements Function1<Strategy, Unit> {
    public StrategyManager$init$1(StrategyManager r8) {
        super(1, r8, StrategyManager.class, "initSource", "initSource(Lcom/bytedance/android/live/impl/strategy/Strategy;)V", 0);
    }

    public final void invoke(Strategy r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        StrategyManager r0 = (StrategyManager) ((CallableReference) this).receiver;
        Strategy r1 = StrategyManager.a;
        r0.h(r3, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Strategy) r1);
        return Unit.INSTANCE;
    }
}
