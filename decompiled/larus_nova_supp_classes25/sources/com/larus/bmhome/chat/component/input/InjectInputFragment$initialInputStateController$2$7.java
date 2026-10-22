package com.larus.bmhome.chat.component.input;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class InjectInputFragment$initialInputStateController$2$7 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public InjectInputFragment$initialInputStateController$2$7(Object r8) {
        super(1, r8, InjectInputFragment.class, "showInjectInputView", "showInjectInputView(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        InjectInputFragment r0 = (InjectInputFragment) ((CallableReference) this).receiver;
        int r1 = InjectInputFragment.p;
        r0.X90(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
