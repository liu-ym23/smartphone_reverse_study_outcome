package com.larus.avlink.simulInterpret.page.view;

import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/simulInterpret/page/model/Language;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.page.view.SimultaneousInterpretFragment$initSubscribers$6", f = "SimultaneousInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretFragment$initSubscribers$6 extends SuspendLambda implements Function2<com.larus.avlink.simulInterpret.page.model.a, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SimultaneousInterpretFragment this$0;

    public SimultaneousInterpretFragment$initSubscribers$6(SimultaneousInterpretFragment r1, Continuation<? super SimultaneousInterpretFragment$initSubscribers$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SimultaneousInterpretFragment$initSubscribers$6 r0 = new SimultaneousInterpretFragment$initSubscribers$6(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.avlink.simulInterpret.page.model.a r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.avlink.simulInterpret.page.model.a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        com.larus.avlink.simulInterpret.page.model.a r5 = (com.larus.avlink.simulInterpret.page.model.a) this.L$0;
        LayoutFragmentBinding r0 = this.this$0.l;
        if (r0 == null) goto L10;
        BottomTranslatePanelView r1 = r0.d;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "language");
        r1.a.g.setText(r5.a);
        r1.a.i.setText(r5.a);
        r1.a.h.setText(r5.c);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
