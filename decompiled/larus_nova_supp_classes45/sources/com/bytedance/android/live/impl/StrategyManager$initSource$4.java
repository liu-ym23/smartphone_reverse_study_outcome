package com.bytedance.android.live.impl;

import com.bytedance.android.live.impl.strategy.Strategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class StrategyManager$initSource$4 extends FunctionReferenceImpl implements Function2<List<? extends String>, Boolean, Unit> {
    public StrategyManager$initSource$4(StrategyManager r8) {
        super(2, r8, StrategyManager.class, "updateCharacter", "updateCharacter(Ljava/util/List;Z)V", 0);
    }

    public final void invoke(List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        StrategyManager r0 = (StrategyManager) ((CallableReference) this).receiver;
        Strategy r1 = StrategyManager.a;
        r0.getClass();
        StrategyManager.i(r3, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((List) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
