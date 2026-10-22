package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class CoreInputAbility$observeOnInputStatusChanged$1 extends FunctionReferenceImpl implements Function2<Integer, Boolean, Unit> {
    public CoreInputAbility$observeOnInputStatusChanged$1(Object r8) {
        super(2, r8, CoreInputAbility.class, "switchCoreInputStatus", "switchCoreInputStatus(IZ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r3, boolean r4) {
        CoreInputAbility r0 = (CoreInputAbility) ((CallableReference) this).receiver;
        String r1 = CoreInputAbility.U;
        r0.N0(r3, r4);
    }
}
