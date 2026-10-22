package com.bytedance.android.live.impl;

import com.bytedance.android.live.impl.strategy.Strategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "p1", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class StrategyManager$getFactor$4 extends FunctionReferenceImpl implements Function1<List<? extends String>, Unit> {
    public StrategyManager$getFactor$4(StrategyManager r8) {
        super(1, r8, StrategyManager.class, "updateCharacter", "updateCharacter(Ljava/util/List;)V", 0);
    }

    public final void invoke(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        StrategyManager r0 = (StrategyManager) ((CallableReference) this).receiver;
        Strategy r1 = StrategyManager.a;
        r0.getClass();
        StrategyManager.i(r3, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((List) r1);
        return Unit.INSTANCE;
    }
}
